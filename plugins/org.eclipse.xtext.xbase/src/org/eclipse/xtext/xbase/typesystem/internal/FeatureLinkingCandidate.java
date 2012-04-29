/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.scoping.batch.BucketedEObjectDescription;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.util.ActualTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class FeatureLinkingCandidate implements IFeatureLinkingCandidate, ObservableTypeExpectation.Observer {

	private final XAbstractFeatureCall featureCall;
	private final IEObjectDescription description;
	private final AbstractTypeComputationState state;
	private final ListMultimap<JvmTypeParameter, BoundTypeArgument> typeParameterMapping;

	public FeatureLinkingCandidate(XAbstractFeatureCall featureCall, IEObjectDescription description,
			AbstractTypeComputationState state) {
		this.featureCall = featureCall;
		this.description = description;
		this.state = state;
		this.typeParameterMapping = ArrayListMultimap.create(2, 2);
	}

	public void accept(ObservableTypeExpectation expectation, JvmTypeReference actual, ConformanceHint conformanceHint) {
		// TODO traverse the expectation and read the actual parameter data from the actual mapping by means of a type parameter substitutor
		JvmTypeReference expectedType = expectation.getExpectedType();
		if (expectedType == null) {
			return;
		}
		if (expectedType.getType() instanceof JvmTypeParameter) {
			if (!(actual instanceof JvmAnyTypeReference)) {
				typeParameterMapping.put((JvmTypeParameter) expectedType.getType(), new BoundTypeArgument(actual, BoundTypeArgumentSource.INFERRED, new Object(), VarianceInfo.OUT, VarianceInfo.OUT));
			}
		} else {
			resolveAgainstActualType(expectedType, actual);
//			JvmIdentifiableElement feature = getFeature();
//			if (feature instanceof JvmTypeParameterDeclarator) {
//				for(JvmTypeParameter parameter: )
//			}
		}
	}
	
	protected void resolveAgainstActualType(JvmTypeReference declaredType, JvmTypeReference actualType) {
		JvmIdentifiableElement feature = getFeature();
		// TODO this(..) and super(..) for generic types
		if (feature instanceof JvmTypeParameterDeclarator) {
			ActualTypeArgumentCollector implementation = new ActualTypeArgumentCollector(
					((JvmTypeParameterDeclarator) feature).getTypeParameters(), state.getServices());
			implementation.populateTypeParameterMapping(declaredType, actualType);
			typeParameterMapping.putAll(implementation.getTypeParameterMapping());
		}
	}

	
	protected void computeArgumentTypes(JvmIdentifiableElement feature, JvmTypeReference featureType) {
		int declaredParameterCount = 0;
		int fixedArityParameterCount = 0;
		List<JvmFormalParameter> parameters = null;
		boolean varArgs = false;
		if (feature instanceof JvmExecutable) {
			JvmExecutable executable = (JvmExecutable) feature;
			declaredParameterCount = executable.getParameters().size();
			varArgs = executable.isVarArgs();
			fixedArityParameterCount = varArgs ? declaredParameterCount - 1 : declaredParameterCount;
			parameters = executable.getParameters();
		}
		List<XExpression> arguments = getArguments();
		int fixedArityArgumentCount = Math.min(fixedArityParameterCount, arguments.size());
		List<StackedResolvedTypes> stackedResolvedTypes = Lists.newArrayListWithCapacity(arguments.size());
		JvmTypeReference receiverType = getReceiverType();
		if (parameters != null) {
			for(int i = 0; i < fixedArityArgumentCount; i++) {
				JvmFormalParameter parameter = parameters.get(i);
				XExpression argument = arguments.get(i);
				if (argument == getReceiver()) {
					StackedResolvedTypes resolvedTypes = new StackedResolvedTypes(state.getResolvedTypes());
					resolvedTypes.acceptType(argument, null, receiverType, ConformanceHint.UNCHECKED, false);
					resolveAgainstActualType(parameter.getParameterType(), receiverType);
					stackedResolvedTypes.add(resolvedTypes);
				} else {
					// TODO explicit type arguments given - don't use the parameter type but the bound value
					// TODO retry those that depend on the expectation if the expectation changes due to other computation results 
					AbstractTypeComputationState argumentState = new ObservableTypeComputationStateWithExpectation(
							state.getResolvedTypes(), state.getFeatureScopeSession(), state.getResolver(), state, parameter.getParameterType(), this);
					stackedResolvedTypes.add(argumentState.computeTypesWithoutMerge(argument));
				}
			}
			if (varArgs) {
				int lastParamIndex = declaredParameterCount - 1;
				JvmTypeReference lastParameterType = parameters.get(lastParamIndex).getParameterType();
				if (!(lastParameterType instanceof JvmGenericArrayTypeReference))
					throw new IllegalStateException("Unexpected var arg type: " + lastParameterType);
				JvmTypeReference componentType = ((JvmGenericArrayTypeReference) lastParameterType).getComponentType();
				AbstractTypeComputationState argumentState = null;
				if (arguments.size() == declaredParameterCount) {
	//				XExpression lastArgument = arguments.get(lastParamIndex);
					// TODO expect Array and componentType
					argumentState = new ObservableTypeComputationStateWithExpectation(
							state.getResolvedTypes(), state.getFeatureScopeSession(), state.getResolver(), state, componentType, this);
				} else {
					argumentState = new ObservableTypeComputationStateWithExpectation(
							state.getResolvedTypes(), state.getFeatureScopeSession(), state.getResolver(), state, componentType, this);
				}
				for(int i = fixedArityArgumentCount; i < arguments.size(); i++) {
					XExpression argument = arguments.get(i);
					if (argument == getReceiver()) {
						StackedResolvedTypes resolvedTypes = new StackedResolvedTypes(state.getResolvedTypes());
						resolvedTypes.acceptType(argument, null, receiverType, ConformanceHint.UNCHECKED, false);
						stackedResolvedTypes.add(resolvedTypes);
					} else {
						stackedResolvedTypes.add(argumentState.computeTypesWithoutMerge(argument));
					}
				}
			}
		}
		if (!varArgs) {
			for(int i = fixedArityArgumentCount; i < arguments.size(); i++) {
				XExpression argument = arguments.get(i);
				if (argument == getReceiver()) {
					StackedResolvedTypes resolvedTypes = new StackedResolvedTypes(state.getResolvedTypes());
					resolvedTypes.acceptType(argument, null, receiverType, ConformanceHint.UNCHECKED, false);
					stackedResolvedTypes.add(resolvedTypes);
				} else {
					AbstractTypeComputationState argumentState = state.fork().withNonVoidExpectation();
					stackedResolvedTypes.add(argumentState.computeTypesWithoutMerge(argument));
				}
			}
		}
		for(StackedResolvedTypes pending: stackedResolvedTypes) {
			pending.mergeIntoParent();
		}
	}
	
	public void apply() {
		JvmIdentifiableElement feature = getFeature();
		JvmTypeReference featureType = state.getType(feature);
		state.getResolvedTypes().setLinkingInformation(featureCall, this);
		computeArgumentTypes(feature, featureType);
		List<ITypeExpectation> expectations = state.getImmediateExpectations();
		for(ITypeExpectation expectation: expectations) {
			// TODO implement bounds / type parameter resolution
			// TODO consider expectation if any
			boolean staticFeature = false;
			if (featureType == null) {
				if (feature instanceof JvmOperation) {
					staticFeature = ((JvmOperation) feature).isStatic();  
					featureType = ((JvmOperation) feature).getReturnType();
				} else if (feature instanceof JvmConstructor) {
					featureType = state.getServices().getTypeReferences().getTypeForName(Void.TYPE, featureCall);
				} else if (feature instanceof JvmField) {
					staticFeature = ((JvmField) feature).isStatic();
					featureType = ((JvmField) feature).getType();
				}
			}
			JvmTypeReference receiverType = getReceiverType();
			// TODO cache the type parameters per receiver
			Map<JvmTypeParameter, JvmTypeReference> declaratorParameterMapping = 
					staticFeature ? Collections.<JvmTypeParameter, JvmTypeReference>emptyMap() : new DeclaratorTypeArgumentCollector().getTypeParameterMapping(receiverType);
			TypeParameterSubstitutor substitutor = new TypeParameterSubstitutor(declaratorParameterMapping, state.getServices());
			substitutor.enhanceMapping(getFeatureTypeParameterMapping());
			JvmTypeReference resolvedType = substitutor.substitute(featureType);
			expectation.acceptActualType(resolvedType, ConformanceHint.UNCHECKED);
		}
	}

	protected JvmTypeReference getReceiverType() {
		JvmTypeReference receiverType = null;
		if (description instanceof BucketedEObjectDescription) {
			receiverType = ((BucketedEObjectDescription) description).getReceiverType();
		}
		return receiverType;
	}

	public JvmIdentifiableElement getFeature() {
		return (JvmIdentifiableElement) description.getEObjectOrProxy();
	}
	
	protected XExpression getReceiver() {
		if (description instanceof BucketedEObjectDescription) {
			return ((BucketedEObjectDescription) description).getReceiver();
		}
		return null;
	}
	
	protected Map<JvmTypeParameter, JvmTypeReference> getFeatureTypeParameterMapping() {
		JvmIdentifiableElement feature = getFeature();
		if (feature instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeReference> typeArguments = featureCall.getTypeArguments();
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) feature).getTypeParameters();
			if (!typeArguments.isEmpty()) {
				int max = Math.min(typeArguments.size(), typeParameters.size());
				Map<JvmTypeParameter, JvmTypeReference> result = Maps.newHashMapWithExpectedSize(max);
				for(int i = 0; i < max; i++) {
					result.put(typeParameters.get(i), typeArguments.get(i));
				}
				// TODO computed type references for the remaining type parameters
				return result;
			}
		}
		Map<JvmTypeParameter, JvmTypeReference> consolidatedMap = Maps.newHashMap();
		TypeConformanceComputer conformanceComputer = state.getResolver().getServices().getTypeConformanceComputer();
		for(JvmTypeParameter typeParameter: typeParameterMapping.keySet()) {
			List<BoundTypeArgument> boundTypeArguments = typeParameterMapping.get(typeParameter);
			List<JvmTypeReference> boundTypes = Lists.newArrayList();
			for(BoundTypeArgument boundTypeArgument: boundTypeArguments) {
				boundTypes.add(boundTypeArgument.getTypeReference());
			}
			consolidatedMap.put(typeParameter, conformanceComputer.getCommonSuperType(boundTypes));
		}
		return consolidatedMap;
	}

	public List<XExpression> getArguments() {
		List<XExpression> arguments = getSyntacticArguments();
		// TODO handle static feature etc
		JvmIdentifiableElement feature = getFeature();
		if (feature instanceof JvmOperation && ((JvmOperation) feature).isStatic()) {
			XExpression receiver = getReceiver();
			if (receiver != null) {
				List<XExpression> result = Lists.newArrayListWithCapacity(1 + arguments.size());
				result.add(receiver);
				result.addAll(arguments);
				return result;
			}
		}
		return arguments;
	}

	protected List<XExpression> getSyntacticArguments() {
		// TODO binary operation
		if (featureCall instanceof XMemberFeatureCall) {
			return ((XMemberFeatureCall) featureCall).getMemberCallArguments();
		} else if (featureCall instanceof XFeatureCall) {
			return ((XFeatureCall) featureCall).getFeatureCallArguments();
		}
		return featureCall.getExplicitArguments();
	}

	public XAbstractFeatureCall getFeatureCall() {
		return featureCall;
	}

}
