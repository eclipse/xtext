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

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.ExpectationTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeArgumentFromComputedTypeCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByUnboundSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractLinkingCandidate<Expression extends XExpression> implements ILinkingCandidate {

	protected class ArgumentTypeComputationState extends AbstractStackedTypeComputationState {

		private final LightweightTypeReference expectedType;
		private final ConformanceHint defaultHint;

		public ArgumentTypeComputationState(AbstractTypeComputationState parent,
				LightweightTypeReference expectedType, @Nullable ConformanceHint defaultHint) {
			super(parent.getResolvedTypes(), parent.getFeatureScopeSession(), parent.getResolver(), parent);
			this.expectedType = expectedType;
			this.defaultHint = defaultHint;
		}
		
		@Override
		protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState) {
			AbstractTypeExpectation result = createTypeExpectation(expectedType, actualState, false, defaultHint);
			return Collections.singletonList(result);
		}
		
		protected AbstractTypeExpectation createTypeExpectation(@Nullable LightweightTypeReference expectedType,
				AbstractTypeComputationState actualState, boolean returnType, @Nullable ConformanceHint hint) {
			AbstractTypeExpectation result = null;
			if (expectedType != null) {
				LightweightTypeReference copied = expectedType.copyInto(actualState.getReferenceOwner());
				result = new ObservableTypeExpectation(copied, actualState, returnType, hint);
			} else {
				result = new NoExpectation(actualState, returnType);
			}
			return result;
		}
		
		protected LightweightTypeReference getExpectedType() {
			return expectedType;
		}
		
	}
	
	protected class ObservableTypeExpectation extends TypeExpectation {

		private ConformanceHint conformanceHint;

		public ObservableTypeExpectation(LightweightTypeReference expectedType, AbstractTypeComputationState state, boolean returnType, @Nullable ConformanceHint conformanceHint) {
			super(expectedType, state, returnType);
			this.conformanceHint = conformanceHint;
		}
		
		@Override
		public void acceptActualType(LightweightTypeReference type, ConformanceHint... hints) {
			ConformanceHint[] actualHints = hints;
			if (this.conformanceHint != null) {
				actualHints = new ConformanceHint[hints.length + 1];
				System.arraycopy(hints, 0, actualHints, 0, hints.length);
				actualHints[hints.length] = conformanceHint;
			}				
			accept(this, type);
			super.acceptActualType(type, actualHints);
		}

		@Override
		public ObservableTypeExpectation copyInto(ITypeReferenceOwner referenceOwner) {
			LightweightTypeReference expectedType = getExpectedType();
			if (expectedType == null || expectedType.isOwnedBy(referenceOwner))
				return this;
			return new ObservableTypeExpectation(expectedType.copyInto(referenceOwner), getState(), isReturnType(), conformanceHint);
		}
		
	}
	
	private final ExpressionTypeComputationState state;
	private final Expression expression;
	private List<LightweightTypeReference> typeArguments;
	protected IFeatureCallArguments arguments;
	
	protected AbstractLinkingCandidate(Expression expression, ExpressionTypeComputationState state) {
		this.expression = expression;
		this.state = state;
	}

	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> initializeTypeParameterMapping() {
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;
		state.getResolvedTypes().acceptLinkingInformation(expression, this);
		List<JvmTypeParameter> declaredTypeParameters = getDeclaredTypeParameters();
		if (declaredTypeParameters.isEmpty()) {
			typeParameterMapping = Collections.emptyMap();
		} else {
			typeParameterMapping = Maps.newLinkedHashMap();
			List<LightweightTypeReference> explicitTypeArguments = getSyntacticTypeArguments();
			int size = Math.min(declaredTypeParameters.size(), explicitTypeArguments.size());
			for(int i = 0; i < size; i++) {
				JvmTypeParameter declaredTypeParameter = declaredTypeParameters.get(i);
				LightweightTypeReference explicitTypeArgument = explicitTypeArguments.get(i);
				UnboundTypeReference typeReference = state.getResolvedTypes().createUnboundTypeReference(expression, declaredTypeParameter);
				// TODO create error if explicit type argument is wildcard
				typeReference.acceptHint(explicitTypeArgument.getInvariantBoundSubstitute(), BoundTypeArgumentSource.EXPLICIT, expression, VarianceInfo.INVARIANT, VarianceInfo.INVARIANT);
				typeParameterMapping.put(declaredTypeParameter, new LightweightMergedBoundTypeArgument(typeReference, VarianceInfo.INVARIANT));
			}
			for(int i = size; i < declaredTypeParameters.size(); i++) {
				JvmTypeParameter declaredTypeParameter = declaredTypeParameters.get(i);
				// TODO add declaration hint
				UnboundTypeReference typeReference = state.getResolvedTypes().createUnboundTypeReference(expression, declaredTypeParameter);
				typeParameterMapping.put(declaredTypeParameter, new LightweightMergedBoundTypeArgument(typeReference, VarianceInfo.INVARIANT));
			}
		}
		return typeParameterMapping;
	}
	
	protected void accept(ObservableTypeExpectation expectation, LightweightTypeReference actual) {
		LightweightTypeReference expectedType = expectation.getExpectedType();
		if (expectedType == null || actual instanceof AnyTypeReference) {
			return;
		}
		resolveAgainstActualType(expectedType, actual, expectation.getState());
	}
	
	public List<LightweightTypeReference> getTypeArguments() {
		if (typeArguments == null) {
			List<JvmTypeParameter> typeParameters = getDeclaredTypeParameters();
			if (typeParameters.isEmpty()) {
				typeArguments = Collections.emptyList();
			} else {
				List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(typeParameters.size());
				for(JvmTypeParameter parameter: typeParameters) {
					LightweightMergedBoundTypeArgument typeArgument = getTypeParameterMapping().get(parameter);
					result.add(typeArgument.getTypeReference());
				}
				typeArguments = result;
			}
		}
		return typeArguments;
	}
	
	protected abstract Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping();
	
	protected List<JvmTypeParameter> getDeclaredTypeParameters() {
		JvmIdentifiableElement feature = getFeature();
		if (feature instanceof JvmTypeParameterDeclarator) {
			return ((JvmTypeParameterDeclarator) feature).getTypeParameters();
		}
		return Collections.emptyList();
	}
	
	public void apply() {
		preApply();
		JvmIdentifiableElement feature = getFeature();
		LightweightTypeReference featureType = getDeclaredType(feature);
		for(ITypeExpectation expectation: state.getExpectations()) {
			// TODO implement bounds / type parameter resolution
			// TODO consider expectation if any
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> declaratorParameterMapping = getDeclaratorParameterMapping();
			TypeParameterSubstitutor<?> substitutor = new TypeParameterByUnboundSubstitutor(declaratorParameterMapping, expectation.getReferenceOwner()) {

				@Override
				protected UnboundTypeReference createUnboundTypeReference(JvmTypeParameter type) {
					UnboundTypeReference result = state.getResolvedTypes().createUnboundTypeReference(expression, type);
					return result;
				}
				
			};
			substitutor.enhanceMapping(getTypeParameterMapping());
			// TODO enhance with expectation
			LightweightTypeReference substitutedFeatureType = substitutor.substitute(featureType).getUpperBoundSubstitute();
			deferredBindTypeArgument(expectation, substitutedFeatureType);
			expectation.acceptActualType(substitutedFeatureType, ConformanceHint.UNCHECKED); // TODO NATIVE, EXPECTATION_INDEPENDENT ?
		}
		state.getStackedResolvedTypes().mergeIntoParent();
	}
	
	protected void preApply() {
		computeArgumentTypes();
	}
	
	protected void deferredBindTypeArgument(ITypeExpectation expectation, LightweightTypeReference type) {
		LightweightTypeReference expectedType = expectation.getExpectedType();
		if (expectedType != null) { 
			ExpectationTypeParameterHintCollector collector = new ExpectationTypeParameterHintCollector(state.getReferenceOwner());
			collector.processPairedReferences(expectedType, type);
		}
	}
	
	/*
	 * public for testing purpose
	 */
	public void computeArgumentTypes() {
		initializeArgumentTypeComputation();
		while(arguments.hasUnprocessedArguments())
			computeArgumentType(arguments.getNextUnprocessedNextArgument());
	}
	
	protected void initializeArgumentTypeComputation() {
		if (arguments != null)
			return;
		arguments = state.getResolver().getExpressionArgumentFactory().createExpressionArguments(expression, this);
	}
	
	protected void computeArgumentType(int argumentIndex) {
		initializeArgumentTypeComputation();
		if (arguments.isProcessed(argumentIndex))
			return;
		UnboundTypeParameterPreservingSubstitutor substitutor = new UnboundTypeParameterPreservingSubstitutor(getDeclaratorParameterMapping(), state.getReferenceOwner());
		substitutor.enhanceMapping(getTypeParameterMapping());
		if (argumentIndex < arguments.getFixedArityArgumentCount()) {
			computeFixedArityArgumentType(argumentIndex, substitutor);
			return;
		}
		if (arguments.isVarArgs()) {
			ArrayTypeReference lastParameterType = arguments.getVarArgType();
			LightweightTypeReference componentType = lastParameterType.getComponentType();
			ITypeComputationState argumentState = null;
			LightweightTypeReference substitutedComponentType = substitutor.substitute(componentType);
			if (arguments.isExactArity()) {
				ArgumentTypeComputationState first = createVarArgTypeComputationState(substitutedComponentType);
				ArrayTypeReference arrayTypeReference = new ArrayTypeReference(substitutedComponentType.getOwner(), substitutedComponentType);
				ArgumentTypeComputationState second = createLinkingTypeComputationState(arrayTypeReference);
				argumentState = new CompoundTypeComputationState(substitutedComponentType.getOwner(), first, second);
			} else {
				argumentState = createVarArgTypeComputationState(substitutedComponentType);
			}
			while(arguments.hasUnprocessedArguments()) {
				int localNextArgumentIndex = arguments.getNextUnprocessedNextArgument();
				XExpression argument = arguments.getArgument(localNextArgumentIndex);
				resolveArgumentType(argument, substitutedComponentType, argumentState);
				arguments.markProcessed(localNextArgumentIndex);
			}
		} else {
			XExpression argument = arguments.getArgument(argumentIndex);
			resolveArgumentType(argument, null, state.withNonVoidExpectation());
			arguments.markProcessed(argumentIndex);
		}
	}

	protected void computeFixedArityArgumentType(int argumentIndex, UnboundTypeParameterPreservingSubstitutor substitutor) {
		LightweightTypeReference parameterType = arguments.getDeclaredType(argumentIndex);
		LightweightTypeReference substitutedParameterType = substitutor.substitute(parameterType);
		XExpression argument = arguments.getArgument(argumentIndex);
		AbstractTypeComputationState argumentState = createLinkingTypeComputationState(substitutedParameterType);
		resolveArgumentType(argument, substitutedParameterType, argumentState);
		arguments.markProcessed(argumentIndex);
	}

	protected ArgumentTypeComputationState createLinkingTypeComputationState(LightweightTypeReference expectedType) {
		return new ArgumentTypeComputationState(state, expectedType.getLowerBoundSubstitute(), null);
	}
	
	protected ArgumentTypeComputationState createVarArgTypeComputationState(LightweightTypeReference expectedType) {
		return new ArgumentTypeComputationState(state, expectedType.getLowerBoundSubstitute(), ConformanceHint.VAR_ARG);
	}
	
	protected void resolveAgainstActualType(LightweightTypeReference declaredType, LightweightTypeReference actualType, final AbstractTypeComputationState state) {
		// TODO this(..) and super(..) for generic types
		List<JvmTypeParameter> typeParameters = getDeclaredTypeParameters();
		if (!typeParameters.isEmpty()) {
			// TODO actualType -(hint for)-> declared type == inferred
			// declared type -(hint for)-> actual type == expected
			TypeArgumentFromComputedTypeCollector.resolveAgainstActualType(declaredType, actualType, typeParameters, getTypeParameterMapping(), BoundTypeArgumentSource.EXPECTATION, state.getReferenceOwner());
		}
	}
	
	protected LightweightTypeReference getDeclaredType(JvmIdentifiableElement feature) {
		LightweightTypeReference result = state.getResolvedTypes().getActualType(feature);
		if (result == null)
			throw new IllegalStateException("Cannot determine type for " + feature.getIdentifier());
		return result;
	}

	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getDeclaratorParameterMapping() {
		return Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap();
	}

	/**
	 * @param argument the expression that should be processed.
	 * @param declaredType the declared (expected) type for the given expression.
	 * @param argumentState the to-be-used state to compute the actual type of the argument. It is already configured with the expectation. 
	 */
	protected void resolveArgumentType(XExpression argument, @Nullable LightweightTypeReference declaredType, ITypeComputationState argumentState) {
		argumentState.computeTypes(argument);
	}
	
	protected abstract List<XExpression> getArguments();
	
	public abstract boolean isPreferredOver(ILinkingCandidate other);
	
	@Nullable
	protected LightweightTypeReference getExpectedType(XExpression expression) {
		return state.getResolvedTypes().getExpectedType(expression);
	}
	
	@Nullable
	protected LightweightTypeReference getActualType(JvmIdentifiableElement identifiableElement) {
		return state.getResolvedTypes().getActualType(identifiableElement);
	}
	
	@Nullable
	protected LightweightTypeReference getActualType(@Nullable XExpression expression) {
		if (expression == null)
			return null;
		return state.getResolvedTypes().getActualType(expression);
	}
	
	@Nullable
	protected LightweightTypeReference getSubstitutedExpectedType(int argumentIndex) {
		XExpression expression = arguments.getArgument(argumentIndex);
		LightweightTypeReference expectedType = getExpectedType(expression);
		if (expectedType != null) {
			TypeParameterByConstraintSubstitutor substitutor = new TypeParameterByConstraintSubstitutor(
					getDeclaratorParameterMapping(), state.getReferenceOwner());
			LightweightTypeReference result = substitutor.substitute(expectedType);
			return result;
		}
		return null;
	}

	protected abstract List<LightweightTypeReference> getSyntacticTypeArguments();
	
	public abstract JvmIdentifiableElement getFeature();
	
	protected Expression getExpression() {
		return expression;
	}
	
	protected boolean hasReceiver() {
		return false;
	}
	
	protected ExpressionTypeComputationState getState() {
		return state;
	}
	
}
