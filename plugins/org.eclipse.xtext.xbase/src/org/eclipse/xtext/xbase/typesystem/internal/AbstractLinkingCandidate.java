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
import java.util.Set;

import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.BucketedEObjectDescription;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.util.AbstractTypeReferencePairWalker;
import org.eclipse.xtext.xbase.typesystem.util.ActualTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractLinkingCandidate implements ILinkingCandidate, ObservableTypeExpectation.Observer {
	
	private final IEObjectDescription description;
	private final AbstractTypeComputationState state;
	private final ListMultimap<JvmTypeParameter, BoundTypeArgument> typeParameterMapping;
	private final XExpression expression;
	
	protected AbstractLinkingCandidate(XExpression expression, IEObjectDescription description,
			AbstractTypeComputationState state) {
		this.expression = expression;
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
		if (expectedType instanceof XComputedTypeReference) {
			XComputedTypeReference computedTypeReference = (XComputedTypeReference) expectedType;
			if (computedTypeReference.getTypeProvider() instanceof UnboundTypeParameter) {
				UnboundTypeParameter unboundTypeParameter = (UnboundTypeParameter) computedTypeReference.getTypeProvider();
				Primitives primitives = state.getServices().getPrimitives();
				JvmTypeReference wrappedActual = primitives.asWrapperTypeIfPrimitive(actual);
				unboundTypeParameter.acceptHint(wrappedActual);
			}
		} else if (expectedType.getType() instanceof JvmTypeParameter) {
			if (!(actual instanceof JvmAnyTypeReference)) {
				Primitives primitives = state.getServices().getPrimitives();
				JvmTypeReference wrappedActual = primitives.asWrapperTypeIfPrimitive(actual);
				typeParameterMapping.put((JvmTypeParameter) expectedType.getType(), new BoundTypeArgument(wrappedActual, BoundTypeArgumentSource.INFERRED, new Object(), VarianceInfo.OUT, VarianceInfo.OUT));
			}
		} else {
			resolveAgainstActualType(expectedType, actual);
		}
	}
	
	public void apply() {
		JvmIdentifiableElement feature = getFeature();
		JvmTypeReference featureType = getDeclaredType(feature);
		state.getResolvedTypes().acceptLinkingInformation(getExpression(), this);
		computeArgumentTypes(feature, featureType);
		List<ITypeExpectation> expectations = state.getImmediateExpectations();
		for(ITypeExpectation expectation: expectations) {
			// TODO implement bounds / type parameter resolution
			// TODO consider expectation if any
			TypeParameterSubstitutor substitutor = new TypeParameterSubstitutor(
					getDeclaratorParameterMapping(), state.getServices()) {
				@Override
				public JvmTypeReference doVisitComputedTypeReference(XComputedTypeReference reference,
						Set<JvmTypeParameter> param) {
					if (reference.getTypeProvider() instanceof UnboundTypeParameter) {
						XComputedTypeReference result = getServices().getXtypeFactory().createXComputedTypeReference();
						result.setTypeProvider(reference.getTypeProvider());
						return result;
					}
					return super.doVisitComputedTypeReference(reference, param);
				}
			};
			substitutor.enhanceMapping(getFeatureTypeParameterMapping());
			// TODO enhance with expectation
			JvmTypeReference substitute = substitutor.substitute(featureType);
			deferredBindTypeArguments(expectation, substitute);
			expectation.acceptActualType(substitute, ConformanceHint.UNCHECKED);
		}
	}
	
	protected void deferredBindTypeArguments(ITypeExpectation expectation, JvmTypeReference type) {
		JvmTypeReference expectedType = expectation.getExpectedType();
		if (expectedType != null) {
			if (type instanceof XComputedTypeReference) {
				IJvmTypeReferenceProvider typeReferenceProvider = ((XComputedTypeReference) type).getTypeProvider();
				if (typeReferenceProvider instanceof UnboundTypeParameter) {
					UnboundTypeParameter unbound = (UnboundTypeParameter) typeReferenceProvider;
					unbound.acceptHint(expectedType);
				}
			}
//			new AbstractTypeReferencePairWalker() {
//				
//				@Override
//				protected void processTypeParameter(JvmTypeParameter typeParameter, JvmTypeReference reference) {
//					// TODO Auto-generated method stub
//					
//				}
//			};
		}
	}

	protected JvmTypeReference getDeclaredType(JvmIdentifiableElement feature) {
		return state.getType(feature);
	}

	protected Map<JvmTypeParameter, JvmTypeReference> getDeclaratorParameterMapping() {
		return Collections.<JvmTypeParameter, JvmTypeReference>emptyMap();
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
		if (parameters != null) {
			for(int i = 0; i < fixedArityArgumentCount; i++) {
				JvmFormalParameter parameter = parameters.get(i);
				XExpression argument = arguments.get(i);
				JvmTypeReference parameterType = parameter.getParameterType();
				TypeParameterSubstitutor substitutor = new TypeParameterSubstitutor(
						getDeclaratorParameterMapping(), state.getServices()) {
					@Override
					public JvmTypeReference doVisitComputedTypeReference(XComputedTypeReference reference,
							Set<JvmTypeParameter> param) {
						if (reference.getTypeProvider() instanceof UnboundTypeParameter) {
							XComputedTypeReference result = getServices().getXtypeFactory().createXComputedTypeReference();
							result.setTypeProvider(reference.getTypeProvider());
							return result;
						}
						return super.doVisitComputedTypeReference(reference, param);
					}
				};
				substitutor.enhanceMapping(getFeatureTypeParameterMapping());
				// TODO enhance with expectation
				JvmTypeReference substitute = substitutor.substitute(parameterType);
				AbstractTypeComputationState argumentState = new ObservableTypeComputationStateWithExpectation(
						state.getResolvedTypes(), state.getFeatureScopeSession(), state.getResolver(), state, substitute, this);
				stackedResolvedTypes.add(resolveArgumentType(argument, parameterType, argumentState));
			}
			if (varArgs) {
				int lastParamIndex = declaredParameterCount - 1;
				JvmTypeReference lastParameterType = parameters.get(lastParamIndex).getParameterType();
				if (!(lastParameterType instanceof JvmGenericArrayTypeReference))
					throw new IllegalStateException("Unexpected var arg type: " + lastParameterType);
				JvmTypeReference componentType = ((JvmGenericArrayTypeReference) lastParameterType).getComponentType();
				
				TypeParameterSubstitutor substitutor = new TypeParameterSubstitutor(
						getDeclaratorParameterMapping(), state.getServices());
				substitutor.enhanceMapping(getFeatureTypeParameterMapping());
				// TODO enhance with expectation
				JvmTypeReference substitute = substitutor.substitute(componentType);
				
				AbstractTypeComputationState argumentState = null;
				if (arguments.size() == declaredParameterCount) {
	//				XExpression lastArgument = arguments.get(lastParamIndex);
					// TODO expect Array and componentType
					argumentState = new ObservableTypeComputationStateWithExpectation(
							state.getResolvedTypes(), state.getFeatureScopeSession(), state.getResolver(), state, substitute, this);
				} else {
					argumentState = new ObservableTypeComputationStateWithExpectation(
							state.getResolvedTypes(), state.getFeatureScopeSession(), state.getResolver(), state, substitute, this);
				}
				for(int i = fixedArityArgumentCount; i < arguments.size(); i++) {
					XExpression argument = arguments.get(i);
					stackedResolvedTypes.add(resolveArgumentType(argument, null, argumentState));
				}
			}
		}
		if (!varArgs) {
			for(int i = fixedArityArgumentCount; i < arguments.size(); i++) {
				XExpression argument = arguments.get(i);
				stackedResolvedTypes.add(resolveArgumentType(argument, null, state.fork().withNonVoidExpectation()));
			}
		}
		for(StackedResolvedTypes pending: stackedResolvedTypes) {
			pending.mergeIntoParent();
		}
	}
	
	protected StackedResolvedTypes resolveArgumentType(XExpression argument, JvmTypeReference declaredType, AbstractTypeComputationState argumentState) {
		return argumentState.computeTypesWithoutMerge(argument);
	}

	protected void resolveAgainstActualType(JvmTypeReference declaredType, JvmTypeReference actualType) {
		JvmIdentifiableElement feature = getFeature();
		// TODO this(..) and super(..) for generic types
		if (feature instanceof JvmTypeParameterDeclarator) {
			ActualTypeArgumentCollector implementation = new ActualTypeArgumentCollector(
					((JvmTypeParameterDeclarator) feature).getTypeParameters(), state.getServices());
			implementation.populateTypeParameterMapping(declaredType, actualType);
			typeParameterMapping.putAll(implementation.rawGetTypeParameterMapping());
		}
	}

	protected Map<JvmTypeParameter, JvmTypeReference> getFeatureTypeParameterMapping() {
		Map<JvmTypeParameter, JvmTypeReference> consolidatedMap = Maps.newHashMap();
		for(JvmTypeParameter typeParameter: typeParameterMapping.keySet()) {
			List<BoundTypeArgument> boundTypeArguments = typeParameterMapping.get(typeParameter);
			MergedBoundTypeArgument mergedTypeArguments = state.getTypeArgumentMerger().merge(boundTypeArguments);
			if (mergedTypeArguments != null)
				consolidatedMap.put(typeParameter, mergedTypeArguments.getTypeReference());
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
	
	protected abstract List<XExpression> getSyntacticArguments();
	
	protected IEObjectDescription getDescription() {
		return description;
	}
	
	public JvmIdentifiableElement getFeature() {
		return (JvmIdentifiableElement) getDescription().getEObjectOrProxy();
	}
	
	protected XExpression getReceiver() {
		if (getDescription() instanceof BucketedEObjectDescription) {
			return ((BucketedEObjectDescription) getDescription()).getReceiver();
		}
		return null;
	}
	
	protected XExpression getExpression() {
		return expression;
	}
	
	protected AbstractTypeComputationState getState() {
		return state;
	}

}
