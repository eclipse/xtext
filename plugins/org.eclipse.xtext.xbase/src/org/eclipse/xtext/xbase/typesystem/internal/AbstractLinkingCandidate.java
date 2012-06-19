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
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.BucketedEObjectDescription;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.util.ActualTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameter;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameters;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO Javadoc
 */
public abstract class AbstractLinkingCandidate<LinkingCandidate extends ILinkingCandidate<LinkingCandidate>> 
		implements ILinkingCandidate<LinkingCandidate>, ObservableTypeExpectation.Observer { 
	
	private final IEObjectDescription description;
	private final ExpressionTypeComputationState state;
	private final XExpression expression;
	private final Map<JvmTypeParameter, MergedBoundTypeArgument> typeParameterMapping;
	
	private List<StackedResolvedTypes> stackedResolvedTypes;
	
	protected AbstractLinkingCandidate(XExpression expression, IEObjectDescription description,
			ExpressionTypeComputationState state) {
		this.expression = expression;
		this.description = description;
		this.state = state;
		state.getResolvedTypes().acceptLinkingInformation(expression, this);
		List<JvmTypeParameter> declaredTypeParameters = getDeclaredTypeParameters();
		if (declaredTypeParameters.isEmpty()) {
			this.typeParameterMapping = Collections.emptyMap();
		} else {
			this.typeParameterMapping = Maps.newLinkedHashMap();
			List<JvmTypeReference> explicitTypeArguments = getExplicitTypeArguments();
			int size = Math.min(declaredTypeParameters.size(), explicitTypeArguments.size());
			for(int i = 0; i < size; i++) {
				JvmTypeParameter declaredTypeParameter = declaredTypeParameters.get(i);
				JvmTypeReference explicitTypeArgument = explicitTypeArguments.get(i);
				UnboundTypeParameter typeParameter = getState().createUnboundTypeParameter(expression, declaredTypeParameter);
				XComputedTypeReference typeReference = getState().getServices().getXtypeFactory().createXComputedTypeReference();
				typeReference.setTypeProvider(typeParameter);
				typeParameter.acceptHint(explicitTypeArgument, BoundTypeArgumentSource.EXPLICIT, expression, VarianceInfo.INVARIANT, VarianceInfo.INVARIANT);
				typeParameterMapping.put(declaredTypeParameter, new MergedBoundTypeArgument(typeReference, VarianceInfo.INVARIANT));
			}
			for(int i = size; i < declaredTypeParameters.size(); i++) {
				JvmTypeParameter declaredTypeParameter = declaredTypeParameters.get(i);
				UnboundTypeParameter typeParameter = getState().createUnboundTypeParameter(expression, declaredTypeParameter);
				XComputedTypeReference typeReference = getState().getServices().getXtypeFactory().createXComputedTypeReference();
				typeReference.setTypeProvider(typeParameter);
				typeParameterMapping.put(declaredTypeParameter, new MergedBoundTypeArgument(typeReference, VarianceInfo.INVARIANT));
			}
		}
	}

	public void accept(ObservableTypeExpectation expectation, JvmTypeReference actual, ConformanceHint conformanceHint) {
		JvmTypeReference expectedType = expectation.getExpectedType();
		if (expectedType == null || actual instanceof JvmAnyTypeReference) {
			return;
		}
		resolveAgainstActualType(expectedType, actual, expectation.getState());
	}
	
	public List<JvmFormalParameter> getDeclaredParameters() {
		JvmIdentifiableElement feature = getFeature();
		if (feature instanceof JvmExecutable) {
			return ((JvmExecutable) feature).getParameters();
		}
		return Collections.emptyList();
	}
	
	public List<JvmTypeParameter> getDeclaredTypeParameters() {
		JvmIdentifiableElement feature = getFeature();
		if (feature instanceof JvmTypeParameterDeclarator) {
			return ((JvmTypeParameterDeclarator) feature).getTypeParameters();
		}
		return Collections.emptyList();
	}
	
	public void apply() {
		JvmIdentifiableElement feature = getFeature();
		JvmTypeReference featureType = getDeclaredType(feature);
		computeArgumentTypes(feature /*, featureType */);
		for(StackedResolvedTypes pending: stackedResolvedTypes) {
			pending.mergeIntoParent();
		}
		List<ITypeExpectation> expectations = getState().getImmediateExpectations();
		for(ITypeExpectation expectation: expectations) {
			// TODO implement bounds / type parameter resolution
			// TODO consider expectation if any
			Map<JvmTypeParameter, MergedBoundTypeArgument> declaratorParameterMapping = getDeclaratorParameterMapping();
			TypeParameterSubstitutor substitutor = new TypeParameterByConstraintSubstitutor(declaratorParameterMapping, getState().getServices()) {
				
				@Override
				public JvmTypeReference doVisitComputedTypeReference(XComputedTypeReference reference,
						Set<JvmTypeParameter> param) {
					if (UnboundTypeParameters.isUnboundTypeParameter(reference)) {
						XComputedTypeReference result = getServices().getXtypeFactory().createXComputedTypeReference();
						UnboundTypeParameter unboundTypeParameter = (UnboundTypeParameter) reference.getTypeProvider();
						BaseUnboundTypeParameter stacked = getState().getResolvedTypes().getUnboundTypeParameter(unboundTypeParameter.getHandle());
						result.setTypeProvider(stacked);
						return result;
					}
					return super.doVisitComputedTypeReference(reference, param);
				}
				
				@Override
				protected JvmTypeReference getUnmappedSubstitute(JvmParameterizedTypeReference reference, JvmTypeParameter type, Set<JvmTypeParameter> visiting) {
					XComputedTypeReference result = getServices().getXtypeFactory().createXComputedTypeReference();
					UnboundTypeParameter unboundTypeParameter = getState().getResolvedTypes().createUnboundTypeParameter(getExpression(), type);
					result.setTypeProvider(unboundTypeParameter);
					return result;
				}
				
			};
			substitutor.enhanceMapping(typeParameterMapping);
			// TODO enhance with expectation
			JvmTypeReference substitutedFeatureType = substitutor.substitute(featureType);
			deferredBindTypeArguments(expectation, substitutedFeatureType);
			expectation.acceptActualType(substitutedFeatureType, ConformanceHint.UNCHECKED);
		}
		getState().getResolvedTypes().mergeIntoParent();
	}
	
	protected void acceptActualType(ITypeExpectation expectation, JvmTypeReference featureType) {
		deferredBindTypeArguments(expectation, featureType);
		expectation.acceptActualType(featureType, ConformanceHint.UNCHECKED); // TODO NATIVE, EXPECTATION_INDEPENDENT ?
	}
	
	protected JvmTypeReference asWrapperType(JvmTypeReference potentialPrimitive) {
		return UnboundTypeParameters.asWrapperType(potentialPrimitive, getState().getServices().getPrimitives());
	}

	public void computeArgumentTypes(JvmIdentifiableElement feature /* JvmTypeReference featureType */) {
		if (stackedResolvedTypes != null)
			return;
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
		stackedResolvedTypes = Lists.newArrayListWithCapacity(arguments.size());
		if (parameters != null) {
			UnboundTypeParameterPreservingSubstitutor substitutor = getState().createSubstitutor(getDeclaratorParameterMapping());
			substitutor.enhanceMapping(typeParameterMapping);
			for(int i = 0; i < fixedArityArgumentCount; i++) {
				final JvmFormalParameter parameter = parameters.get(i);
				final JvmTypeReference parameterType = parameter.getParameterType();
				XExpression argument = arguments.get(i);
				AbstractTypeComputationState argumentState = new ObservableTypeComputationStateWithExpectation(
						getState(), 
						substitutor.substitute(parameterType), this);
				stackedResolvedTypes.add(resolveArgumentType(argument, parameterType, argumentState));
			}
			if (varArgs) {
				int lastParamIndex = declaredParameterCount - 1;
				JvmTypeReference lastParameterType = parameters.get(lastParamIndex).getParameterType();
				if (!(lastParameterType instanceof JvmGenericArrayTypeReference))
					throw new IllegalStateException("Unexpected var arg type: " + lastParameterType);
				final JvmTypeReference componentType = ((JvmGenericArrayTypeReference) lastParameterType).getComponentType();
				
				AbstractTypeComputationState argumentState = null;
				if (arguments.size() == declaredParameterCount) {
//					XExpression lastArgument = arguments.get(lastParamIndex);
					// TODO expect Array and componentType
					argumentState = new ObservableTypeComputationStateWithExpectation(
							getState(), substitutor.substitute(componentType), this);
				} else {
					argumentState = new ObservableTypeComputationStateWithExpectation(
							getState(), substitutor.substitute(componentType), this);
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
				stackedResolvedTypes.add(resolveArgumentType(argument, null, getState().fork().withNonVoidExpectation()));
			}
		}
	}
	
	protected JvmTypeParameter getTypeParameter(JvmTypeReference referenceToTypeParameter) {
		if (referenceToTypeParameter instanceof XComputedTypeReference) {
			XComputedTypeReference casted = ((XComputedTypeReference) referenceToTypeParameter);
			IJvmTypeReferenceProvider typeProvider = casted.getTypeProvider();
			if (typeProvider instanceof UnboundTypeParameter){
				return ((UnboundTypeParameter) typeProvider).getTypeParameter();
			}
			return getTypeParameter(casted.getEquivalent());
		}
		// TODO wildcards? <? extends T>, delegates
		JvmType result = referenceToTypeParameter.getType();
		if (result instanceof JvmTypeParameter) {
			return (JvmTypeParameter) result;
		}
		return null;
	}
	
	protected void deferredBindTypeArguments(ITypeExpectation expectation, JvmTypeReference type) {
		JvmTypeReference expectedType = expectation.getExpectedType();
		if (expectedType != null) { 
			// TODO expectation#hasTypeParameters / isUnresolved to improve the runtime performance
			DeferredTypeParameterHintCollector collector = new DeferredTypeParameterHintCollector(getState().getServices()) {
				@Override
				protected void addHint(UnboundTypeParameter typeParameter, JvmTypeReference reference) {
//					if (!getDeclaredTypeParameters().contains(typeParameter.getTypeParameter()) && typeParameter.getExpression() != getExpression()) {
						BaseUnboundTypeParameter replaced = getState().getResolvedTypes().getUnboundTypeParameter(typeParameter.getHandle());
						super.addHint(replaced, reference);
//					}
				}
				@Override
				protected TypeParameterSubstitutor createTypeParameterSubstitutor(
						Map<JvmTypeParameter, MergedBoundTypeArgument> mapping) {
					return getState().createSubstitutor(mapping);
				}
			};
			collector.processPairedReferences(expectedType, type);
		}
	}

	protected void resolveAgainstActualType(JvmTypeReference declaredType, JvmTypeReference actualType, AbstractTypeComputationState state) {
		// TODO this(..) and super(..) for generic types
		List<JvmTypeParameter> typeParameters = getDeclaredTypeParameters();
		if (!typeParameters.isEmpty()) {
			ActualTypeArgumentCollector implementation = state.createTypeArgumentCollector(typeParameters, BoundTypeArgumentSource.INFERRED);
//			ActualTypeArgumentCollector implementation = new UnboundTypeParameterAwareTypeArgumentCollector(typeParameters, BoundTypeArgumentSource.EXPECTATION, getState().getServices()) {
//				@Override
//				protected void acceptHint(UnboundTypeParameter typeParameter, JvmTypeReference param) {
//					BaseUnboundTypeParameter stacked = getState().getResolvedTypes().getUnboundTypeParameter(typeParameter.getHandle());
//					super.acceptHint(stacked, param);
//				}
//			};
			implementation.populateTypeParameterMapping(declaredType, actualType);
			ListMultimap<JvmTypeParameter,BoundTypeArgument> parameterMapping = implementation.rawGetTypeParameterMapping();
			for(Map.Entry<JvmTypeParameter, BoundTypeArgument> entry: parameterMapping.entries()) {
				MergedBoundTypeArgument boundTypeArgument = typeParameterMapping.get(entry.getKey());
				if (boundTypeArgument != null) {
					XComputedTypeReference typeReference = (XComputedTypeReference) boundTypeArgument.getTypeReference();
					if (UnboundTypeParameters.isUnboundTypeParameter(typeReference)) {
						UnboundTypeParameter unboundParameter = (UnboundTypeParameter) typeReference.getTypeProvider();
						unboundParameter.acceptHint(entry.getValue());
					}
				}
			}
		}
	}
	
	protected JvmTypeReference getDeclaredType(JvmIdentifiableElement feature) {
		return state.getType(feature);
	}

	protected Map<JvmTypeParameter, MergedBoundTypeArgument> getDeclaratorParameterMapping() {
		return Collections.<JvmTypeParameter, MergedBoundTypeArgument>emptyMap();
	}

	protected StackedResolvedTypes resolveArgumentType(XExpression argument, JvmTypeReference declaredType, AbstractTypeComputationState argumentState) {
		StackedResolvedTypes result = argumentState.computeTypesWithoutMerge(argument);
		return result;
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
	
	public int compareTo(LinkingCandidate right) {
		int arityCompareResult = compareByArityWith(right);
		if (arityCompareResult != 0)
			return arityCompareResult;
		int typeArityCompareResult = compareByArity(getTypeArityMismatch(), right.getTypeArityMismatch());
		if (typeArityCompareResult != 0)
			return typeArityCompareResult;
		if (getDeclaredTypeParameters().size() > right.getDeclaredTypeParameters().size()) {
			return 1;
		}
//		computeArgumentTypes(getFeature());
//		((AbstractLinkingCandidate<LinkingCandidate>)right).computeArgumentTypes(right.getFeature());
		return 0;
	}
	
	protected int compareByArityWith(LinkingCandidate right) {
		int arityCompareResult = compareByArity(getArityMismatch(), right.getArityMismatch());
		return arityCompareResult;
	}

	protected int compareByArity(int leftArityMismatch, int rightArityMismatch) {
		if (leftArityMismatch != rightArityMismatch) {
			if (leftArityMismatch == 0)
				return -1;
			if (rightArityMismatch == 0)
				return 1;
			if (Math.abs(leftArityMismatch) < Math.abs(rightArityMismatch))
				return -1;
			if (Math.abs(leftArityMismatch) > Math.abs(rightArityMismatch))
				return 1;
			if (leftArityMismatch > 0)
				return -1;
			if (rightArityMismatch > 0)
				return 1;
		}
		if (Math.abs(leftArityMismatch) < Math.abs(rightArityMismatch))
			return -1;
		if (Math.abs(leftArityMismatch) > Math.abs(rightArityMismatch))
			return 1;
		if (leftArityMismatch > 0)
			return -1;
		if (rightArityMismatch > 0)
			return 1;
		return 0;
	}
	
	public int getArityMismatch() {
		JvmIdentifiableElement identifiable = getFeature();
		if (identifiable instanceof JvmExecutable) {
			return getArityMismatch((JvmExecutable) identifiable, getArguments());
		} else {
			return getArguments().size();
		}
	}
	
	public int getTypeArityMismatch() {
		List<JvmTypeReference> explicitTypeArguments = getExplicitTypeArguments();
		if (explicitTypeArguments.size() == 0)
			return 0;
		return getDeclaredTypeParameters().size() - explicitTypeArguments.size();
	}
	
	protected abstract List<JvmTypeReference> getExplicitTypeArguments();

	protected int getArityMismatch(JvmExecutable executable, List<XExpression> arguments) {
		int fixedArityParamCount = executable.getParameters().size();
		if (executable.isVarArgs()) {
			fixedArityParamCount--;
			if (arguments.size() >= fixedArityParamCount) {
				return 0;
			}
		}
		return fixedArityParamCount - arguments.size();
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
	
	protected ExpressionTypeComputationState getState() {
		return state;
	}
}
