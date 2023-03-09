/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArgumentSlot;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.ConstraintVisitingInfo;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.ExpectationTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.Maps2;
import org.eclipse.xtext.xbase.typesystem.util.RawTypeSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeArgumentFromComputedTypeCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByUnboundSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractLinkingCandidate<Expression extends XExpression> implements ILinkingCandidate {

	protected class ArgumentTypeComputationState extends AbstractStackedTypeComputationState {

		private final LightweightTypeReference expectedType;
		private final int defaultFlags;

		public ArgumentTypeComputationState(AbstractTypeComputationState parent,
				LightweightTypeReference expectedType, int defaultFlags) {
			super(parent.getResolvedTypes(), parent.getFeatureScopeSession(), parent);
			this.expectedType = expectedType;
			this.defaultFlags = defaultFlags;
		}
		
		@Override
		protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState) {
			AbstractTypeExpectation result = createTypeExpectation(expectedType, actualState, false, defaultFlags);
			return Collections.singletonList(result);
		}
		
		protected AbstractTypeExpectation createTypeExpectation(/* @Nullable */ LightweightTypeReference expectedType,
				AbstractTypeComputationState actualState, boolean returnType, int flags) {
			AbstractTypeExpectation result = null;
			if (expectedType != null) {
				LightweightTypeReference copied = expectedType.copyInto(actualState.getReferenceOwner());
				result = new ObservableTypeExpectation(copied, actualState, returnType, flags);
			} else {
				result = new NoExpectation(actualState, returnType);
			}
			return result;
		}
		
		/* @Nullable */
		protected int getDefaultFlags() {
			return defaultFlags;
		}
		
		protected LightweightTypeReference getExpectedType() {
			return expectedType;
		}
		
	}
	
	protected class ObservableTypeExpectation extends TypeExpectation {

		private int flags;

		public ObservableTypeExpectation(LightweightTypeReference expectedType, AbstractTypeComputationState state, boolean returnType, int flags) {
			super(expectedType, state, returnType);
			this.flags = flags;
		}
		
		@Override
		public void acceptActualType(LightweightTypeReference type, int flags) {
			accept(this, type);
			super.acceptActualType(type, flags | this.flags);
		}

		@Override
		public ObservableTypeExpectation copyInto(ITypeReferenceOwner referenceOwner) {
			LightweightTypeReference expectedType = getExpectedType();
			if (expectedType == null || expectedType.isOwnedBy(referenceOwner))
				return this;
			return new ObservableTypeExpectation(expectedType.copyInto(referenceOwner), getState(), isReturnType(), flags);
		}
		
	}
	
	private final ExpressionTypeComputationState state;
	private final ITypeExpectation expectation;
	private final Expression expression;
	protected List<LightweightTypeReference> typeArguments;
	protected IFeatureCallArguments arguments;
	
	protected AbstractLinkingCandidate(Expression expression, ITypeExpectation expectation, ExpressionTypeComputationState state) {
		this.expression = expression;
		this.expectation = expectation;
		this.state = state;
	}

	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> initializeTypeParameterMapping() {
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;
		state.acceptCandidate(expression, this);
		List<JvmTypeParameter> declaredTypeParameters = getDeclaredTypeParameters();
		if (declaredTypeParameters.isEmpty()) {
			typeParameterMapping = Collections.emptyMap();
		} else {
			typeParameterMapping = initializeTypeParameterMapping(declaredTypeParameters);
		}
		return typeParameterMapping;
	}

	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> initializeTypeParameterMapping(List<JvmTypeParameter> declaredTypeParameters) {
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;
		List<LightweightTypeReference> explicitTypeArguments = getSyntacticTypeArguments();
		int size = Math.min(declaredTypeParameters.size(), explicitTypeArguments.size());
		typeParameterMapping = Maps2.newLinkedHashMapWithExpectedSize(size);
		for(int i = 0; i < size; i++) {
			JvmTypeParameter declaredTypeParameter = declaredTypeParameters.get(i);
			LightweightTypeReference explicitTypeArgument = explicitTypeArguments.get(i);
			UnboundTypeReference typeReference = state.getResolvedTypes().createUnboundTypeReference(expression, declaredTypeParameter);
			if (explicitTypeArgument != null && explicitTypeArgument.isValidHint()) {
				LightweightTypeReference substitute = explicitTypeArgument.getInvariantBoundSubstitute();
				typeReference.acceptHint(substitute, BoundTypeArgumentSource.EXPLICIT, expression, VarianceInfo.INVARIANT, VarianceInfo.INVARIANT);
			}
			typeParameterMapping.put(declaredTypeParameter, new LightweightMergedBoundTypeArgument(typeReference, VarianceInfo.INVARIANT));
		}
		for(int i = size; i < declaredTypeParameters.size(); i++) {
			JvmTypeParameter declaredTypeParameter = declaredTypeParameters.get(i);
			initializeMapping(declaredTypeParameter, typeParameterMapping);
		}
		UnboundTypeParameterPreservingSubstitutor substitutor = new UnboundTypeParameterPreservingSubstitutor(typeParameterMapping, getState().getReferenceOwner());
		substitutor.enhanceMapping(getDeclaratorParameterMapping());
		LightweightTypeReference expectedType = expectation.getExpectedType();
		if (expectedType != null) {
			LightweightTypeReference declaredFeatureType = getDeclaredType(getFeature());
			LightweightTypeReference substitutedFeatureType = substitutor.substitute(declaredFeatureType);
			DeferredTypeParameterHintCollector collector = new DeferredTypeParameterHintCollector(state.getReferenceOwner()) {
				@Override
				protected void addHint(UnboundTypeReference typeParameter, LightweightTypeReference reference) {
					if (!typeParameter.internalIsResolved() && getExpectedVariance() == VarianceInfo.INVARIANT) {
						if (getExpectedVariance() == getActualVariance() && reference.getKind() != LightweightTypeReference.KIND_UNBOUND_TYPE_REFERENCE) {
							doAddHint(typeParameter, reference, BoundTypeArgumentSource.INFERRED_EXPECTATION);
						} else if (getActualVariance() == VarianceInfo.IN && !typeParameter.hasSignificantHints()) {
							if (reference.getKind() != LightweightTypeReference.KIND_UNBOUND_TYPE_REFERENCE) {
								doAddHint(typeParameter, reference, BoundTypeArgumentSource.INFERRED_EXPECTATION);
							} else {
								UnboundTypeReference casted = (UnboundTypeReference)reference;
								List<LightweightBoundTypeArgument> hints = casted.getAllHints();
								for(LightweightBoundTypeArgument hint: hints) {
									// avoid bogus transitive hints, e.g. if a reference was used with another variance
									// INFERRED_LATER serves as an indicator for these hints
									if (hint.getSource() == BoundTypeArgumentSource.INFERRED_LATER) {
										return;
									}
								}
								doAddHint(typeParameter, reference, BoundTypeArgumentSource.INFERRED_EXPECTATION);
							}
						}
					}
				}

				protected void doAddHint(UnboundTypeReference typeParameter, LightweightTypeReference reference, BoundTypeArgumentSource source) {
					typeParameter.acceptHint(
							reference.getWrapperTypeIfPrimitive(),
							source,
							getOrigin(),
							getExpectedVariance(),
							getActualVariance());
				}
			};
			collector.processPairedReferences(substitutedFeatureType, expectedType);
		}
		for(int i = size; i < declaredTypeParameters.size(); i++) {
			JvmTypeParameter declaredTypeParameter = declaredTypeParameters.get(i);
			LightweightMergedBoundTypeArgument boundTypeArgument = typeParameterMapping.get(declaredTypeParameter);
			LightweightTypeReference boundReference = boundTypeArgument.getTypeReference();
			if (boundReference instanceof UnboundTypeReference) {
				initializeConstraintMapping(declaredTypeParameter, substitutor, (UnboundTypeReference) boundReference);
			}
		}
		return typeParameterMapping;
	}

	protected void initializeMapping(JvmTypeParameter typeParameter, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> result) {
		UnboundTypeReference typeReference = state.getResolvedTypes().createUnboundTypeReference(expression, typeParameter);
		result.put(typeParameter, new LightweightMergedBoundTypeArgument(typeReference, VarianceInfo.INVARIANT));
	}
	
	protected void initializeConstraintMapping(JvmTypeParameter typeParameter, UnboundTypeParameterPreservingSubstitutor substitutor, UnboundTypeReference typeReference) {
		if (!typeReference.internalIsResolved()) {
			List<JvmTypeConstraint> constraints = typeParameter.getConstraints();
			for(JvmTypeConstraint constraint: constraints) {
				JvmTypeReference constraintReference = constraint.getTypeReference();
				if (constraintReference != null) {
					LightweightTypeReference substitute = substitutor.substitute(constraintReference);
					if (!substitute.isType(Object.class) && !substitute.isPrimitiveVoid()) {
						typeReference.acceptHint(substitute, BoundTypeArgumentSource.CONSTRAINT, constraint, VarianceInfo.OUT, VarianceInfo.OUT);
					}
				}
			}
		}
	}
	
	protected void accept(ObservableTypeExpectation expectation, LightweightTypeReference actual) {
		LightweightTypeReference expectedType = expectation.getExpectedType();
		if (expectedType == null || actual instanceof AnyTypeReference || actual.isPrimitiveVoid()) {
			return;
		}
		resolveAgainstActualType(expectedType, actual, expectation.getState());
	}
	
	@Override
	public List<LightweightTypeReference> getTypeArguments() {
		if (typeArguments == null) {
			List<JvmTypeParameter> typeParameters = getDeclaredTypeParameters();
			if (typeParameters.isEmpty() || getTypeParameterMapping().isEmpty()) {
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
		if (feature instanceof JvmExecutable) {
			// we are only interested in exectubles
			// types e.g. this, super or self may have
			// type parameters but these don't have an impact
			// on the linking
			return ((JvmTypeParameterDeclarator) feature).getTypeParameters();
		}
		return Collections.emptyList();
	}
	
	@Override
	public void applyToComputationState() {
		preApply();
		JvmIdentifiableElement feature = getFeature();
		LightweightTypeReference featureType = getDeclaredType(feature);
		
		// TODO implement bounds / type parameter resolution
		// TODO consider expectation if any
		TypeParameterSubstitutor<?> substitutor = null;
		if (!isRawTypeContext()) {
			final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> declaratorParameterMapping = getDeclaratorParameterMapping();
			substitutor = new TypeParameterByUnboundSubstitutor(declaratorParameterMapping, expectation.getReferenceOwner()) {

				private boolean wasCapturedWildcard = false;
				
				@Override
				protected UnboundTypeReference createUnboundTypeReference(JvmTypeParameter type) {
					UnboundTypeReference result = state.getResolvedTypes().createUnboundTypeReference(expression, type);
					return result;
				}
				
				@Override
				/* @Nullable */
				protected LightweightTypeReference getBoundTypeArgument(ParameterizedTypeReference reference, JvmTypeParameter type,
						ConstraintVisitingInfo visiting) {
					if (getOwner().getDeclaredTypeParameters().contains(type)) {
						return null;
					}
					return super.getBoundTypeArgument(reference, type, visiting);
				}
				
				@Override
				/* @Nullable */
				protected LightweightMergedBoundTypeArgument getBoundTypeArgument(JvmTypeParameter typeParameter,
						ConstraintVisitingInfo info) {
					LightweightMergedBoundTypeArgument result = super.getBoundTypeArgument(typeParameter, info);
					if (result != null) {
						LightweightTypeReference typeReference = result.getTypeReference();
						if (result.getVariance() == VarianceInfo.INVARIANT) {
							if (typeReference.isWildcard() && typeReference.getLowerBoundSubstitute().isAny() && typeReference.getUpperBoundSubstitute().isType(Object.class)) {
								// assume unbound wildcard - use the constraints of the respective type parameter
								if (!typeParameter.getConstraints().isEmpty()) {
									JvmTypeConstraint constraint = typeParameter.getConstraints().get(0);
									if (constraint instanceof JvmUpperBound) {
										LightweightTypeReference reference = getOwner().toLightweightTypeReference(constraint.getTypeReference());
										return new LightweightMergedBoundTypeArgument(reference, VarianceInfo.OUT);
									}
								}
							}
						}
						if (declaratorParameterMapping.containsKey(typeParameter) && typeReference.isWildcard()) {
							wasCapturedWildcard = true;
						}
					}
					return result;
				}
				
				@Override
				protected LightweightTypeReference enhanceParameterizedTypeReference(ParameterizedTypeReference reference, JvmType type,
						ParameterizedTypeReference result, ConstraintVisitingInfo visiting) {
					boolean convertToWildcard = false;
					for(int i = 0; i < reference.getTypeArguments().size(); i++) {
						wasCapturedWildcard = false;
						LightweightTypeReference argument = reference.getTypeArguments().get(i);
						visiting.pushInfo(type instanceof JvmTypeParameterDeclarator ? (JvmTypeParameterDeclarator) type : null, i);
						LightweightTypeReference visitedArgument = argument.accept(this, visiting);
						if (wasCapturedWildcard)
							convertToWildcard = true;
						wasCapturedWildcard = false;
						result.addTypeArgument(visitedArgument);
					}
					if (convertToWildcard) {
						WildcardTypeReference wildcard = result.getOwner().newWildcardTypeReference();
						wildcard.addUpperBound(result);
						return wildcard;
					}
					return result;
				}
				
			};
			substitutor.enhanceMapping(getTypeParameterMapping());
		} else {
			substitutor = new RawTypeSubstitutor(expectation.getReferenceOwner());
		}
		// TODO enhance with expectation
		LightweightTypeReference substitutedFeatureType = substitutor.substitute(featureType).getUpperBoundSubstitute();
		if (!expectation.isNoTypeExpectation()) {
			substitutedFeatureType = deferredBindTypeArgument(expectation, substitutedFeatureType);
		}
		expectation.acceptActualType(substitutedFeatureType, ConformanceFlags.UNCHECKED);
		state.getStackedResolvedTypes().mergeIntoParent();
	}
	
	protected void preApply() {
		computeArgumentTypes();
	}
	
	protected LightweightTypeReference deferredBindTypeArgument(ITypeExpectation expectation, LightweightTypeReference type) {
		LightweightTypeReference expectedType = expectation.getExpectedType();
		if (expectedType != null) { 
			ExpectationTypeParameterHintCollector collector = new ExpectationTypeParameterHintCollector(state.getReferenceOwner()) {
				@Override
				protected UnboundTypeReferenceTraverser createUnboundTypeReferenceTraverser() {
					return new UnboundTypeParameterHintCollector() {
						Set<Object> seenParameters = Sets.newHashSetWithExpectedSize(3);
						@Override
						protected void doVisitTypeReference(LightweightTypeReference reference, UnboundTypeReference declaration) {
							if (declaration.internalIsResolved() || getOwner().isResolved(declaration.getHandle())) {
								declaration.tryResolve();
								outerVisit(declaration, reference, declaration, getExpectedVariance(), getActualVariance());
							} else if (reference.isValidHint()) {
								addHint(declaration, reference);
								if (seenParameters.add(declaration.getHandle())) {
									/*
									 * If we add hints like CharIterable extends Iterable<Character> 
									 * for a type parameter V in <T, V extends Iterable<T>>, we want to
									 * add a hint for the type parameter T, too.
									 */
									List<LightweightBoundTypeArgument> hints = getState().getResolvedTypes().getHints(declaration.getHandle());
									for(int i = 0; i < hints.size(); i++) {
										LightweightBoundTypeArgument hint = hints.get(i);
										if (hint.getSource() == BoundTypeArgumentSource.CONSTRAINT) {
											outerVisit(hint.getTypeReference(), reference);
										}
									}
								}
							}
						}
						@Override
						protected void doVisitUnboundTypeReference(UnboundTypeReference reference, UnboundTypeReference declaration) {
							super.doVisitTypeReference(reference, declaration);
						}
					};
				}
			};
			collector.processPairedReferences(expectedType, type);
		}
		return type;
	}
	
	/*
	 * public for testing purpose
	 */
	public void computeArgumentTypes() {
		initializeArgumentTypeComputation();
		while(arguments.hasUnprocessedArguments())
			computeArgumentType(arguments.getNextUnprocessedArgumentSlot());
	}
	
	protected void initializeArgumentTypeComputation() {
		if (arguments != null)
			return;
		getTypeParameterMapping(); // trigger lazy init
		arguments = state.getResolver().getExpressionArgumentFactory().createExpressionArguments(expression, this);
	}
	
	protected void computeArgumentType(IFeatureCallArgumentSlot slot) {
		TypeParameterSubstitutor<?> substitutor = createArgumentTypeSubstitutor();
		if (!slot.isVarArg() && !slot.isSuperfluous()) {
			computeFixedArityArgumentType(slot, substitutor);
		} else if (slot.isVarArg()) {
			computeVarArgumentType(slot, substitutor);
		} else {
			XExpression argument = slot.getArgumentExpression();
			if (argument != null) {
				resolveArgumentType(argument, null, state.withNonVoidExpectation());
			}
		}
		slot.markProcessed();
	}

	protected void computeVarArgumentType(IFeatureCallArgumentSlot slot, TypeParameterSubstitutor<?> substitutor) {
		LightweightTypeReference lastParameterType = slot.getDeclaredType();
		if (lastParameterType == null) {
			throw new IllegalStateException();
		}
		LightweightTypeReference componentType = lastParameterType.isArray() ? lastParameterType.getComponentType() : lastParameterType;
		if (componentType == null) {
			throw new IllegalStateException();
		}
		ITypeComputationState argumentState = null;
		LightweightTypeReference substitutedComponentType = substitutor.substitute(componentType);
		List<XExpression> arguments = slot.getArgumentExpressions();
		if (!substitutedComponentType.isAny()) {
			if (arguments.size() == 1) {
				ArgumentTypeComputationState first = createVarArgTypeComputationState(substitutedComponentType);
				// If we have a single arg, infer the expected type to avoid bogus inference
				// when the arg is List<String> but the expectation would be an array conversion rather
				// than a List<String>[]
				if (substitutedComponentType.getKind() == LightweightTypeReference.KIND_UNBOUND_TYPE_REFERENCE) {
					UnboundTypeReference casted = (UnboundTypeReference) substitutedComponentType.copyInto(first.getReferenceOwner());
					List<LightweightBoundTypeArgument> hints = first.getResolvedTypes().getHints(casted.getHandle());
					for(int i = 0; i < hints.size(); i++) {
						LightweightBoundTypeArgument hint = hints.get(i);
						if (hint.getSource() == BoundTypeArgumentSource.INFERRED_EXPECTATION) {
							casted.acceptHint(
									hint.getTypeReference(),
									BoundTypeArgumentSource.INFERRED,
									hint.getOrigin(),
									hint.getDeclaredVariance(),
									hint.getActualVariance());
						}
					}
				}
				ArrayTypeReference arrayTypeReference = substitutedComponentType.getOwner().newArrayTypeReference(substitutedComponentType);
				ArgumentTypeComputationState second = createLinkingTypeComputationState(arrayTypeReference);
				argumentState = new CompoundTypeComputationState(substitutedComponentType.getOwner(), first, second);
			} else {
				argumentState = createVarArgTypeComputationState(substitutedComponentType);
			}
			for(XExpression argument: arguments) {
				if (argument != null) {
					resolveArgumentType(argument, substitutedComponentType, argumentState);
				}
			}
		} else {
			for(XExpression argument: arguments) {
				if (argument != null) {
					resolveArgumentType(argument, null, state.withNonVoidExpectation());
				}
			}
		}
	}

	protected TypeParameterSubstitutor<?> createArgumentTypeSubstitutor() {
		if (isRawTypeContext()) {
			return new RawTypeSubstitutor(state.getReferenceOwner());
		} else {
			UnboundTypeParameterPreservingSubstitutor substitutor = new UnboundTypeParameterPreservingSubstitutor(getDeclaratorParameterMapping(), state.getReferenceOwner()) {
				@Override
				/* @Nullable */
				protected LightweightTypeReference getBoundTypeArgument(ParameterizedTypeReference reference, JvmTypeParameter type, Set<JvmTypeParameter> visiting) {
					if (isBoundTypeArgumentSkipped(type, super.getTypeParameterMapping(), getOwner())) {
						return null;
					}
					return super.getBoundTypeArgument(reference, type, visiting);
				}
				
				@Override
				protected LightweightTypeReference visitTypeArgument(LightweightTypeReference reference, Set<JvmTypeParameter> visiting, boolean lowerBound) {
					LightweightTypeReference result = super.visitTypeArgument(reference, visiting, lowerBound);
					if (lowerBound && result.getKind() == LightweightTypeReference.KIND_WILDCARD_TYPE_REFERENCE) {
						result = result.getUpperBoundSubstitute();
					}
					return result;
				}
				
				@Override
				protected LightweightTypeReference doVisitWildcardTypeReference(WildcardTypeReference reference, Set<JvmTypeParameter> visiting) {
					if (reference.isResolved() && reference.isOwnedBy(getOwner()))
						return reference;
					WildcardTypeReference result = getOwner().newWildcardTypeReference();
					LightweightTypeReference lowerBound = reference.getLowerBound();
					if (lowerBound != null) {
						LightweightTypeReference visited = visitTypeArgument(lowerBound, visiting, true);
						if (visited.isWildcard()) {
							LightweightTypeReference substitute = visited.getInvariantBoundSubstitute();
							result.setLowerBound(substitute);
						} else {
							result.setLowerBound(visited);
						}
					} 
					for(LightweightTypeReference upperBound: reference.getUpperBounds()) {
						LightweightTypeReference visitedArgument = visitTypeArgument(upperBound, visiting);
						LightweightTypeReference upperBoundSubstitute = visitedArgument.getUpperBoundSubstitute();
						result.addUpperBound(upperBoundSubstitute);
					}
					if (result.getUpperBounds().isEmpty()) {
						throw new IllegalStateException("UpperBounds may not be empty");
					}
					return result;
				}
			};
			substitutor.enhanceMapping(getTypeParameterMapping());
			return substitutor;
		}
	}
	
	protected boolean isBoundTypeArgumentSkipped(JvmTypeParameter type, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, ITypeReferenceOwner owner) {
		return (type.getDeclarator() instanceof JvmType) && owner.getDeclaredTypeParameters().contains(type) && !mapping.containsKey(type);
	}
	
	protected boolean isRawTypeContext() {
		return false;
	}

	protected void computeFixedArityArgumentType(IFeatureCallArgumentSlot slot, TypeParameterSubstitutor<?> substitutor) {
		XExpression argument = slot.getArgumentExpression();
		if (argument != null) {
			LightweightTypeReference parameterType = slot.getDeclaredType();
			if (parameterType == null) {
				parameterType = state.getReferenceOwner().newUnknownTypeReference();
			}
			LightweightTypeReference substitutedParameterType = substitutor.substitute(parameterType);
			AbstractTypeComputationState argumentState = createLinkingTypeComputationState(substitutedParameterType);
			resolveArgumentType(argument, substitutedParameterType, argumentState);
		}
	}

	protected ArgumentTypeComputationState createLinkingTypeComputationState(LightweightTypeReference expectedType) {
		return new ArgumentTypeComputationState(state, expectedType.getLowerBoundSubstitute(), ConformanceFlags.NONE);
	}
	
	protected ArgumentTypeComputationState createVarArgTypeComputationState(LightweightTypeReference componentType) {
		return new ArgumentTypeComputationState(state, componentType.getLowerBoundSubstitute(), ConformanceFlags.VAR_ARG);
	}
	
	protected void resolveAgainstActualType(LightweightTypeReference declaredType, LightweightTypeReference actualType, final AbstractTypeComputationState state) {
		if (!actualType.isAny()) {
			// TODO this(..) and super(..) for generic types
			List<JvmTypeParameter> typeParameters = getDeclaredTypeParameters();
			if (!typeParameters.isEmpty()) {
				// TODO actualType -(hint for)-> declared type == inferred
				// declared type -(hint for)-> actual type == expected
				TypeArgumentFromComputedTypeCollector.resolveAgainstActualType(
						declaredType,
						actualType,
						typeParameters,
						getTypeParameterMapping(),
						BoundTypeArgumentSource.EXPECTATION,
						state.getReferenceOwner());
			}
		}
	}
	
	protected LightweightTypeReference getDeclaredType(JvmIdentifiableElement feature) {
		LightweightTypeReference result = state.getResolvedTypes().getActualType(feature);
		if (result == null) {
			return getState().getReferenceOwner().newAnyTypeReference();
		}
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
	protected void resolveArgumentType(XExpression argument, /* @Nullable */ LightweightTypeReference declaredType, ITypeComputationState argumentState) {
		argumentState.computeTypes(argument);
	}
	
	protected abstract List<XExpression> getArguments();
	
	/* @Nullable */
	protected LightweightTypeReference getExpectedType(XExpression expression) {
		return state.getResolvedTypes().getExpectedType(expression);
	}
	
	/**
	 * Returns the actual type of the given element. Does not consider reassigned types.
	 */
	/* @Nullable */
	protected LightweightTypeReference getActualType(JvmIdentifiableElement element, boolean ignoreReassignedTypes) {
		return state.getResolvedTypes().doGetActualType(element, ignoreReassignedTypes);
	}
	
	/* @Nullable */
	protected LightweightTypeReference getActualType(/* @Nullable */ XExpression expression) {
		if (expression == null)
			return null;
		return state.getResolvedTypes().getActualType(expression);
	}
	
	/**
	 * Returns the substituted expected type for the argument at {@code argumentIndex}.
	 * If the expected type is an unbound type parameter, a reference to the type parameter
	 * itself is returned. 
	 */
	/* @Nullable */
	protected LightweightTypeReference getSubstitutedExpectedType(int argumentIndex) {
		XExpression expression = arguments.getArgument(argumentIndex);
		if (expression == null)
			return null;
		LightweightTypeReference expectedType = getExpectedType(expression);
		if (expectedType != null) {
			// don't use UnboundTypeReference.getRawTypeReference since that would potentially resolve the unbound candidate
			if (expectedType instanceof UnboundTypeReference) {
				JvmTypeParameter typeParameter = ((UnboundTypeReference) expectedType).getTypeParameter();
				expectedType = expectedType.getOwner().newParameterizedTypeReference(typeParameter);
			}
		}
		return expectedType;
	}

	protected List<LightweightTypeReference> getSyntacticTypeArguments() {
		List<LightweightTypeReference> result = Lists.newArrayList();
		List<JvmTypeReference> typeArguments = getPlainSyntacticTypeArguments();
		ITypeReferenceOwner referenceOwner = getState().getReferenceOwner();
		for(int i = 0, size = typeArguments.size(); i < size; i++) {
			LightweightTypeReference typeArgument = referenceOwner.toLightweightTypeReference(typeArguments.get(i));
			result.add(typeArgument);
		}
		return result;
	}
	
	protected abstract List<JvmTypeReference> getPlainSyntacticTypeArguments();
	
	@Override
	public abstract JvmIdentifiableElement getFeature();
	
	@Override
	public Expression getExpression() {
		return expression;
	}
	
	/**
	 * Returns <code>true</code> if the argument at index 0 will be considered as the receiver.
	 */
	protected boolean hasReceiver() {
		return false;
	}
	
	public boolean isTypeLiteral() {
		return false;
	}
	
	protected ExpressionTypeComputationState getState() {
		return state;
	}

	protected boolean mustDiscardRefinement() {
		Expression expression = getExpression();
		if (expression instanceof XAssignment) {
			JvmIdentifiableElement feature = getFeature();
			if (feature instanceof XVariableDeclaration) {
				return ((XVariableDeclaration) feature).isWriteable();
			}
			if (feature instanceof JvmField) {
				return !((JvmField) feature).isFinal();
			}
		}
		return false;
	}
	
	protected void discardRefinementTypeIfReassigned() {
		if (mustDiscardRefinement()) {
			getState().discardReassignedTypes(getFeature());
		}
	}
	
}
