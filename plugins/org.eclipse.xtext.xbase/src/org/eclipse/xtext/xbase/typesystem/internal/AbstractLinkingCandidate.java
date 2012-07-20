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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.BucketedEObjectDescription;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeExpectation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.ConstraintVisitingInfo;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.StateAwareDeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeArgumentFromComputedTypeCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO Javadoc
 */
public abstract class AbstractLinkingCandidate<LinkingCandidate extends ILinkingCandidate<LinkingCandidate>> 
		implements ILinkingCandidate<LinkingCandidate> { 
	
	public class LinkingTypeComputationState extends TypeComputationStateWithExpectation {
		public LinkingTypeComputationState(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession,
				DefaultReentrantTypeResolver reentrantTypeResolver, AbstractTypeComputationState parent,
				LightweightTypeReference typeReference) {
			super(resolvedTypes, featureScopeSession, reentrantTypeResolver, parent, typeReference);
		}
		
		@Override
		@NonNullByDefault
		protected AbstractTypeExpectation createTypeExpectation(@Nullable LightweightTypeReference expectedType,
				AbstractTypeComputationState actualState, boolean returnType) {
			AbstractTypeExpectation result = null;
			if (expectedType != null) {
				LightweightTypeReference copied = expectedType.copyInto(actualState.getReferenceOwner());
				result = new ObservableTypeExpectation(copied, actualState, returnType);
			} else {
				result = new NoExpectation(actualState, returnType);
			}
			return result;
		}
	}

	@NonNullByDefault
	public class ObservableTypeExpectation extends TypeExpectation {

		public ObservableTypeExpectation(LightweightTypeReference expectedType, AbstractTypeComputationState state, boolean returnType) {
			super(expectedType, state, returnType);
		}
		
		@Override
		public void acceptActualType(LightweightTypeReference type, ConformanceHint conformanceHint) {
			accept(this, type, conformanceHint);
			super.acceptActualType(type, conformanceHint);
		}

		@Override
		public ObservableTypeExpectation copyInto(TypeReferenceOwner referenceOwner) {
			LightweightTypeReference expectedType = internalGetExpectedType();
			if (expectedType == null || expectedType.isOwnedBy(referenceOwner))
				return this;
			return new ObservableTypeExpectation(expectedType.copyInto(referenceOwner), getState(), isReturnType());
		}
		
	}

	
	private final IEObjectDescription description;
	private final ExpressionTypeComputationState state;
	private final XExpression expression;
	private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;
	
	private boolean argumentsComputed;
	
	protected AbstractLinkingCandidate(XExpression expression, IEObjectDescription description,
			ExpressionTypeComputationState state) {
		this.expression = expression;
		this.description = description;
		this.state = state;
		this.typeParameterMapping = initializeTypeParameterMapping();
	}

	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> initializeTypeParameterMapping() {
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;
		state.getResolvedTypes().acceptLinkingInformation(expression, this);
		List<JvmTypeParameter> declaredTypeParameters = getDeclaredTypeParameters();
		if (declaredTypeParameters.isEmpty()) {
			typeParameterMapping = Collections.emptyMap();
		} else {
			typeParameterMapping = Maps.newLinkedHashMap();
			List<LightweightTypeReference> explicitTypeArguments = getExplicitTypeArguments();
			int size = Math.min(declaredTypeParameters.size(), explicitTypeArguments.size());
			for(int i = 0; i < size; i++) {
				JvmTypeParameter declaredTypeParameter = declaredTypeParameters.get(i);
				LightweightTypeReference explicitTypeArgument = explicitTypeArguments.get(i);
				UnboundTypeReference typeReference = getState().createUnboundTypeReference(expression, declaredTypeParameter);
				// TODO add declaration hint
				typeReference.acceptHint(explicitTypeArgument, BoundTypeArgumentSource.EXPLICIT, expression, VarianceInfo.INVARIANT, VarianceInfo.INVARIANT);
				typeParameterMapping.put(declaredTypeParameter, new LightweightMergedBoundTypeArgument(typeReference, VarianceInfo.INVARIANT));
			}
			for(int i = size; i < declaredTypeParameters.size(); i++) {
				JvmTypeParameter declaredTypeParameter = declaredTypeParameters.get(i);
				// TODO add declaration hint
				UnboundTypeReference typeReference = getState().createUnboundTypeReference(expression, declaredTypeParameter);
				typeParameterMapping.put(declaredTypeParameter, new LightweightMergedBoundTypeArgument(typeReference, VarianceInfo.INVARIANT));
			}
		}
		return typeParameterMapping;
	}

	@NonNullByDefault
	public void accept(ObservableTypeExpectation expectation, LightweightTypeReference actual, ConformanceHint conformanceHint) {
		LightweightTypeReference expectedType = expectation.internalGetExpectedType();
		if (expectedType == null || actual instanceof AnyTypeReference) {
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
		LightweightTypeReference featureType = getDeclaredType(feature);
		computeArgumentTypes(feature /*, featureType */);
		List<LightweightTypeExpectation> expectations = getState().getImmediateExpectations();
		for(LightweightTypeExpectation expectation: expectations) {
			// TODO implement bounds / type parameter resolution
			// TODO consider expectation if any
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> declaratorParameterMapping = getDeclaratorParameterMapping();
			TypeParameterSubstitutor<?> substitutor = new TypeParameterByConstraintSubstitutor(declaratorParameterMapping, getState().getReferenceOwner()) {
				
				@Override
				@NonNull 
				public LightweightTypeReference doVisitUnboundTypeReference(@NonNull UnboundTypeReference reference,
						@NonNull ConstraintVisitingInfo param) {
					return copy(reference);
				}
				
				@Override
				@NonNull
				protected LightweightTypeReference getUnmappedSubstitute(@NonNull ParameterizedTypeReference reference, @NonNull JvmTypeParameter type, @NonNull ConstraintVisitingInfo visiting) {
					UnboundTypeReference result = getState().getResolvedTypes().createUnboundTypeReference(getExpression(), type);
					return result;
				}
				
			};
			substitutor.enhanceMapping(typeParameterMapping);
			// TODO enhance with expectation
			LightweightTypeReference substitutedFeatureType = substitutor.substitute(featureType);
			deferredBindTypeArgument(expectation, substitutedFeatureType);
			expectation.acceptActualType(substitutedFeatureType, ConformanceHint.UNCHECKED); // TODO NATIVE, EXPECTATION_INDEPENDENT ?
		}
		getState().getResolvedTypes().mergeIntoParent();
	}
	
	@NonNullByDefault
	protected void deferredBindTypeArgument(LightweightTypeExpectation expectation, LightweightTypeReference type) {
		LightweightTypeReference expectedType = expectation.internalGetExpectedType();
		if (expectedType != null) { 
			DeferredTypeParameterHintCollector collector = new StateAwareDeferredTypeParameterHintCollector(getState().getReferenceOwner());
			collector.processPairedReferences(expectedType, type);
		}
	}
	
	public void computeArgumentTypes(JvmIdentifiableElement feature /* LightweightTypeReference featureType */) {
		if (argumentsComputed)
			return;
		argumentsComputed = true;
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
		if (parameters != null) {
			UnboundTypeParameterPreservingSubstitutor substitutor = new UnboundTypeParameterPreservingSubstitutor(getDeclaratorParameterMapping(), state.getReferenceOwner());
			substitutor.enhanceMapping(typeParameterMapping);
			for(int i = 0; i < fixedArityArgumentCount; i++) {
				JvmFormalParameter parameter = parameters.get(i);
				LightweightTypeReference parameterType = getState().toLightweightTypeReference(parameter.getParameterType());
				LightweightTypeReference substitutedParameterType = substitutor.substitute(parameterType);
				XExpression argument = arguments.get(i);
				TypeComputationStateWithExpectation argumentState = new LinkingTypeComputationState(state.getResolvedTypes(), state.getFeatureScopeSession(), state.getResolver(), state, substitutedParameterType);
						
				resolveArgumentType(argument, substitutedParameterType, argumentState);
			}
			if (varArgs) {
				int lastParamIndex = declaredParameterCount - 1;
				LightweightTypeReference lastParameterType = getState().toLightweightTypeReference(parameters.get(lastParamIndex).getParameterType());
				if (!(lastParameterType instanceof ArrayTypeReference))
					throw new IllegalStateException("Unexpected var arg type: " + lastParameterType);
				final LightweightTypeReference componentType = ((ArrayTypeReference) lastParameterType).getComponentType();
				
				TypeComputationStateWithExpectation argumentState = null;
				LightweightTypeReference substitutedComponentType = substitutor.substitute(componentType);
				if (arguments.size() == declaredParameterCount) {
//					XExpression lastArgument = arguments.get(lastParamIndex);
					// TODO expect Array and componentType
					argumentState = new LinkingTypeComputationState(state.getResolvedTypes(), state.getFeatureScopeSession(), state.getResolver(), state, substitutedComponentType);
				} else {
					argumentState = new LinkingTypeComputationState(state.getResolvedTypes(), state.getFeatureScopeSession(), state.getResolver(), state, substitutedComponentType);
				}
				for(int i = fixedArityArgumentCount; i < arguments.size(); i++) {
					XExpression argument = arguments.get(i);
					resolveArgumentType(argument, substitutedComponentType, argumentState);
				}
			}
		}
		if (!varArgs) {
			for(int i = fixedArityArgumentCount; i < arguments.size(); i++) {
				XExpression argument = arguments.get(i);
				resolveArgumentType(argument, null, getState().fork().withNonVoidExpectation());
			}
		}
	}
	
	protected JvmTypeParameter getTypeParameter(@Nullable LightweightTypeReference referenceToTypeParameter) {
		if (referenceToTypeParameter == null)
			return null;
		if (referenceToTypeParameter instanceof UnboundTypeReference) {
			UnboundTypeReference unbound = (UnboundTypeReference) referenceToTypeParameter;
			if (unbound.getResolvedTo() != null) {
				return getTypeParameter(unbound.getResolvedTo());
			}
			return unbound.getTypeParameter();
		}
		JvmType result = referenceToTypeParameter.getType();
		if (result instanceof JvmTypeParameter) {
			return (JvmTypeParameter) result;
		} else if (result == null) { 
			if (referenceToTypeParameter instanceof WildcardTypeReference) {
				// TODO multiple type parameters? Invalid in Java but possible during type inference?
				WildcardTypeReference wildcard = (WildcardTypeReference) referenceToTypeParameter;
				for(LightweightTypeReference upperBound: wildcard.getUpperBounds()) {
					JvmTypeParameter wildcardTypeParam = getTypeParameter(upperBound);
					if (wildcardTypeParam != null) {
						return wildcardTypeParam;
					}
				}
				// either null or ok
				return getTypeParameter(wildcard.getLowerBound());
			} else if (referenceToTypeParameter instanceof CompoundTypeReference) {
				// TODO multiple type parameters?
				CompoundTypeReference compound = (CompoundTypeReference) referenceToTypeParameter;
				for(LightweightTypeReference component: compound.getComponents()) {
					JvmTypeParameter componentTypeParam = getTypeParameter(component);
					if (componentTypeParam != null) {
						return componentTypeParam;
					}
				}
			}
		}
		return null;
	}
	
	protected void resolveAgainstActualType(LightweightTypeReference declaredType, LightweightTypeReference actualType, final AbstractTypeComputationState state) {
		// TODO this(..) and super(..) for generic types
		List<JvmTypeParameter> typeParameters = getDeclaredTypeParameters();
		if (!typeParameters.isEmpty()) {
			// TODO actualType -(hint for)-> declared type == inferred
			// declared type -(hint for)-> actual type == expected
			TypeArgumentFromComputedTypeCollector.resolveAgainstActualType(declaredType, actualType, typeParameters, typeParameterMapping, state.getReferenceOwner());
		}
	}
	
	protected LightweightTypeReference getDeclaredType(JvmIdentifiableElement feature) {
		return state.internalGetType(feature);
	}

	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getDeclaratorParameterMapping() {
		return Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap();
	}

	protected void resolveArgumentType(XExpression argument, LightweightTypeReference declaredType, AbstractTypeComputationState argumentState) {
		argumentState.computeTypes(argument);
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
		List<LightweightTypeReference> explicitTypeArguments = getExplicitTypeArguments();
		if (explicitTypeArguments.size() == 0)
			return 0;
		return getDeclaredTypeParameters().size() - explicitTypeArguments.size();
	}
	
	protected abstract List<LightweightTypeReference> getExplicitTypeArguments();

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
