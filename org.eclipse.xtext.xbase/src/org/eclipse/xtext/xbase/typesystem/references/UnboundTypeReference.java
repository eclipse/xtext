/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xtype.XComputedTypeReference;

import com.google.common.collect.Lists;

/**
 * A type reference that points to a type parameter that is not yet resolved.
 * 
 * {@link UnboundTypeReference} should be created with a concrete {@link ITypeExpectation}
 * via the factory method {@link ITypeExpectation#createUnboundTypeReference(XExpression, JvmTypeParameter)}
 * or {@link #create(ITypeExpectation, XExpression, JvmTypeParameter)} respectively.
 * 
 * Such type references may be produced in cases like
 * <code>
 *   val x = newArrayList
 * </code>
 * where {@code x} has the inferred type {@code ArrayList<Unbound[E]>}.
 * 
 * Unbound types may be enhanced with {@link #acceptHint(LightweightBoundTypeArgument) hints} to
 * allow the type inferrer to find the most suitable type.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnboundTypeReference extends LightweightTypeReference {

	/**
	 * The resolved representation of this type reference.
	 */
	private LightweightTypeReference resolvedTo;
	
	private final JvmTypeParameter typeParameter;
	
	/**
	 * A handle uniquely identifies a unbound type reference. Since
	 * unbound references are cloned eagerly into new owners as soon as
	 * the potential owner is forked, we need a means to identify such references
	 * across owner boundaries. 
	 */
	private final Object handle;
	
	/**
	 * The expression that is the origin for the unbound type reference.
	 * Given the example
	 * <code>
	 *   val x = newArrayList
	 * </code>
	 * its the feature call {@code newArrayList} for the unbound type reference
	 * to {@code E}
	 */
	private final XExpression expression;
	
	/**
	 * Create a new, managed unbound type reference for the given type parameter which was
	 * first encountered for the given expression.
	 * @param expression the expression that used / referenced the type parameter
	 * @param typeParameter the type parameter
	 * @param expectation the decision path that uses the type parameter
	 */
	public static UnboundTypeReference create(ITypeExpectation expectation, XExpression expression, JvmTypeParameter typeParameter) {
		return expectation.createUnboundTypeReference(expression, typeParameter);
	}
	
	/**
	 * Subclasses <em>must</em> override this method.
	 */
	@Override
	public int getKind() {
		return KIND_UNBOUND_TYPE_REFERENCE;
	}
	
	protected UnboundTypeReference(ITypeReferenceOwner owner, XExpression expression, JvmTypeParameter typeParameter) {
		this(owner, expression, typeParameter, new Object());
	}
	
	protected UnboundTypeReference(ITypeReferenceOwner owner, XExpression expression, JvmTypeParameter typeParameter, Object handle) {
		super(owner);
		this.typeParameter = typeParameter;
		this.handle = handle;
		this.expression = expression;
	}
	
	public XExpression getExpression() {
		return expression;
	}
	
	protected UnboundTypeReference createCopy(ITypeReferenceOwner owner) {
		UnboundTypeReference result = new UnboundTypeReference(owner, expression, getTypeParameter(), getHandle());
		return result;
	}
	
	/**
	 * Try to resolve this reference iff there are hints available.
	 * May be invoked multiple times since it will simply returns if
	 * the reference is already resolved.
	 * 
	 * This is fully equivalent to {@code tryResolve(true)}.
	 * 
	 * @see #tryResolve(boolean)
	 */
	public void tryResolve() {
		tryResolve(true);
	}
	
	/**
	 * Try to resolve this reference iff there are hints available.
	 * May be invoked multiple times since it will simply returns if
	 * the reference is already resolved. The caller can decide whether
	 * type constraints are considered to be significant hints or not. 
	 */
	public void tryResolve(boolean constraintsAreSignificant) {
		if (internalIsResolved())
			return;
		List<LightweightBoundTypeArgument> hints = getAllHints();
		if (!hints.isEmpty() && hasSignificantHints(hints, constraintsAreSignificant)) {
			resolveWithHints(hints);
		}
	}

	/**
	 * Returns true if the existing hints would allow to resolve to the given reference.
	 */
	public boolean canResolveTo(LightweightTypeReference reference) {
		if (internalIsResolved())
			return reference.isAssignableFrom(resolvedTo, new TypeConformanceComputationArgument(false, true, true, true, false, false /* TODO do we need to support synonmys here? */));
		List<LightweightBoundTypeArgument> hints = getAllHints();
		if (!hints.isEmpty() && hasSignificantHints(hints)) {
			return canResolveTo(reference, hints);
		}
		return false;
	}
	
	public boolean hasSignificantHints() {
		if (internalIsResolved())
			return true;
		List<LightweightBoundTypeArgument> hints = getAllHints();
		if (!hints.isEmpty() && hasSignificantHints(hints))
			return true;
		return false;
	}
	
	public boolean hasSignificantHints(List<LightweightBoundTypeArgument> hints) {
		return hasSignificantHints(hints, true);
	}
	
	protected boolean hasSignificantHints(List<LightweightBoundTypeArgument> hints, boolean constraintsAreSignificant) {
		for (LightweightBoundTypeArgument hint: hints) {
			if (!(hint.getOrigin() instanceof VarianceInfo)) {
				if (constraintsAreSignificant || hint.getSource() != BoundTypeArgumentSource.CONSTRAINT)
					return true;
			}
		}
		return false;
	}

	@Override
	public JvmTypeReference toTypeReference() {
		if (internalGetResolvedTo() != null) {
			return resolvedTo.toTypeReference();
		}
		XComputedTypeReference result = getServices().getXtypeFactory().createXComputedTypeReference();
		result.setTypeProvider(new UnboundTypeReferenceResolver(this));
		return result;
	}
	
	@Override
	public JvmTypeReference toJavaCompliantTypeReference(IVisibilityHelper visibilityHelper) {
		return resolve().toJavaCompliantTypeReference(visibilityHelper);
	}
	
	@Override
	public boolean isRawType() {
		if (internalGetResolvedTo() != null)
			return resolvedTo.isRawType();
		return false;
	}
	
	@Override
	public boolean isAnonymous() {
		if (internalGetResolvedTo() != null)
			return resolvedTo.isAnonymous();
		return false;
	}
	
	public JvmTypeParameter getTypeParameter() {
		return typeParameter;
	}
	
	/**
	 * Returns the identifying handle for this reference.
	 * @see UnboundTypeReference#handle
	 */
	public Object getHandle() {
		return handle;
	}
	
	/**
	 * Returns the resolved reference for this unbound reference.
	 * It does not try to resolve this reference but only returns
	 * the resolved representation if this one was resolved by other clients 
	 * explicitly.
	 * @return the resolved reference or <code>null</code>.
	 */
	/* @Nullable */
	public LightweightTypeReference getResolvedTo() {
		return internalGetResolvedTo();
	}
	
	@Override
	public LightweightTypeReference getUpperBoundSubstitute() {
		if (internalGetResolvedTo() != null)
			return resolvedTo.getUpperBoundSubstitute();
		return super.getUpperBoundSubstitute();
	}
	
	@Override
	public LightweightTypeReference getLowerBoundSubstitute() {
		if (internalGetResolvedTo() != null)
			return resolvedTo.getLowerBoundSubstitute();
		return super.getLowerBoundSubstitute();
	}
	
	@Override
	public LightweightTypeReference getInvariantBoundSubstitute() {
		if (internalGetResolvedTo() != null)
			return resolvedTo.getInvariantBoundSubstitute();
		return super.getInvariantBoundSubstitute();
	}
	
	@Override
	public LightweightTypeReference getConstraintSubstitute() {
		if (internalGetResolvedTo() != null)
			return resolvedTo.getConstraintSubstitute();
		return super.getConstraintSubstitute();
	}
	
	/**
	 * Force this reference to be resolved. If not hints are available,
	 * the reference is resolved to the constraints of the type parameters.
	 * @return the resolved representation. Never <code>null</code>.
	 */
	public LightweightTypeReference resolve() {
		if (internalIsResolved())
			return resolvedTo;
		List<LightweightBoundTypeArgument> allHints = getAllHints();
		if (!allHints.isEmpty() && resolveWithHints(allHints)) {
			LightweightTypeReference result = internalGetResolvedTo();
			if (result != null) {
				return result;
			}
		}
		resolveAgainstConstraints();
		return resolvedTo;
	}

	protected void resolveAgainstConstraints() {
		TypeParameterByConstraintSubstitutor unboundSubstitutor = new TypeParameterByConstraintSubstitutor(
				Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), getOwner(), true);
		LightweightTypeReference substitute = unboundSubstitutor.substitute(getOwner().newParameterizedTypeReference(typeParameter));
		getOwner().acceptHint(getHandle(), new LightweightBoundTypeArgument(substitute, BoundTypeArgumentSource.RESOLVED, this, VarianceInfo.INVARIANT, VarianceInfo.INVARIANT));
		resolvedTo = substitute;
	}
	
	protected boolean canResolveTo(LightweightTypeReference reference, List<LightweightBoundTypeArgument> allHints) {
		List<LightweightBoundTypeArgument> inferredHints = Lists.newArrayListWithCapacity(allHints.size());
		List<LightweightBoundTypeArgument> effectiveHints = Lists.newArrayListWithCapacity(allHints.size());
		EnumSet<VarianceInfo> varianceHints = EnumSet.noneOf(VarianceInfo.class);
		for(LightweightBoundTypeArgument hint: allHints) {
			if (hint.getOrigin() instanceof VarianceInfo) {
				varianceHints.add((VarianceInfo) hint.getOrigin());
			} else {
				effectiveHints.add(hint);
				if (hint.getSource() == BoundTypeArgumentSource.INFERRED) {
					inferredHints.add(hint);
				}
			}
		}
		if (effectiveHints.isEmpty())
			return false;
		boolean result = getServices().getBoundTypeArgumentMerger().isPossibleMergeResult(!inferredHints.isEmpty() ? inferredHints : effectiveHints, reference);
		return result;
	}

	protected boolean resolveWithHints(List<LightweightBoundTypeArgument> allHints) {
		List<LightweightBoundTypeArgument> inferredHints = Lists.newArrayListWithCapacity(allHints.size());
		List<LightweightBoundTypeArgument> effectiveHints = Lists.newArrayListWithCapacity(allHints.size());
		List<LightweightBoundTypeArgument> inferredConstraintHints = Lists.newArrayListWithCapacity(allHints.size());
		EnumSet<VarianceInfo> varianceHints = EnumSet.noneOf(VarianceInfo.class);
		boolean hasContraintHints = populateListsFromHints(allHints, inferredHints, effectiveHints, inferredConstraintHints, varianceHints);
		if (inferredHints.size() == 1 && !varianceHints.isEmpty()) {
			LightweightBoundTypeArgument hint = inferredHints.get(0);
			if ((hint.getDeclaredVariance() == VarianceInfo.IN && hint.getActualVariance() == VarianceInfo.INVARIANT) && !hint.getTypeReference().isWildcard()) {
				// we recorded a single bogus hint, eliminate that one
				inferredHints.clear();
			}
		}
		if (effectiveHints.isEmpty())
			return false;
		LightweightMergedBoundTypeArgument typeArgument = getServices().getBoundTypeArgumentMerger().merge(!inferredHints.isEmpty() ? inferredHints : effectiveHints, getOwner());
		if (typeArgument != null) {
			resolvedTo = typeArgument.getTypeReference();
			if (resolvedTo != null) {
				boolean outResolvedToInvariant = varianceHints.contains(VarianceInfo.OUT) && varianceHints.size() == 1 && typeArgument.getVariance() == VarianceInfo.INVARIANT;
				if (outResolvedToInvariant && (resolvedTo.getKind() == LightweightTypeReference.KIND_WILDCARD_TYPE_REFERENCE)) {
					resolvedTo = resolvedTo.getUpperBoundSubstitute();
				} else if (outResolvedToInvariant && (resolvedTo.getKind() != LightweightTypeReference.KIND_WILDCARD_TYPE_REFERENCE) && inferredConstraintHints.size() == 1) {
					LightweightTypeReference constraintTypeRef = inferredConstraintHints.get(0).getTypeReference();
					if (constraintTypeRef.isAssignableFrom(resolvedTo)) {
						resolvedTo = constraintTypeRef;
					}
				} else if (varianceHints.contains(VarianceInfo.IN) && varianceHints.size() == 1 && typeArgument.getVariance() == VarianceInfo.INVARIANT && (resolvedTo instanceof WildcardTypeReference)) { 
					resolvedTo = resolvedTo.getInvariantBoundSubstitute();
				} else if (varianceHints.isEmpty() && typeArgument.getVariance() == VarianceInfo.OUT && allHints.size() == 1) {
					LightweightBoundTypeArgument singleHint = allHints.get(0);
					if (singleHint.getDeclaredVariance() == VarianceInfo.INVARIANT && singleHint.getSource() == BoundTypeArgumentSource.INFERRED_LATER) {
						WildcardTypeReference wildcard = resolvedTo.getOwner().newWildcardTypeReference();
						wildcard.addUpperBound(resolvedTo);
						resolvedTo = wildcard;
					}
				} else if (varianceHints.isEmpty() && inferredConstraintHints.size() == 1 && typeArgument.getVariance() == VarianceInfo.INVARIANT) {
					LightweightBoundTypeArgument constraintTypeRef = inferredConstraintHints.get(0);
					if (constraintTypeRef.getTypeReference().getKind() != LightweightTypeReference.KIND_WILDCARD_TYPE_REFERENCE && 
							constraintTypeRef.getDeclaredVariance() == VarianceInfo.OUT && constraintTypeRef.getActualVariance() == VarianceInfo.INVARIANT) {
						if (resolvedTo.getKind() == LightweightTypeReference.KIND_WILDCARD_TYPE_REFERENCE && ((WildcardTypeReference) resolvedTo).getLowerBound() != null) {
							if(resolvedTo.getInvariantBoundSubstitute().isAssignableFrom(constraintTypeRef.getTypeReference())) {
								WildcardTypeReference wildcard = resolvedTo.getOwner().newWildcardTypeReference();
								wildcard.addUpperBound(resolvedTo.getInvariantBoundSubstitute());
								resolvedTo = wildcard;
							}
						} else if (resolvedTo.isAssignableFrom(constraintTypeRef.getTypeReference())) {
							resolvedTo = constraintTypeRef.getTypeReference();
						}
					}
				}
			}
			getOwner().acceptHint(getHandle(), new LightweightBoundTypeArgument(
					resolvedTo,
					BoundTypeArgumentSource.RESOLVED,
					this,
					VarianceInfo.INVARIANT,
					typeArgument.getVariance()));
			if (hasContraintHints) {
				propageResolvedTypeToConstraints(allHints);
			}
			return true;
		}
		return false;
	}

	private boolean populateListsFromHints(List<LightweightBoundTypeArgument> allHints, List<LightweightBoundTypeArgument> inferredHints,
			List<LightweightBoundTypeArgument> effectiveHints, List<LightweightBoundTypeArgument> inferredConstraintHints, EnumSet<VarianceInfo> varianceHints) {
		boolean hasContraintHints = false;
		boolean hasInferred = false;
		List<LightweightBoundTypeArgument> expectationHints = null;
		for(LightweightBoundTypeArgument hint: allHints) {
			if (hint.getOrigin() instanceof VarianceInfo) {
				varianceHints.add((VarianceInfo) hint.getOrigin());
			} else {
				if (hint.getSource() == BoundTypeArgumentSource.CONSTRAINT) {
					hasContraintHints = true;
				}
				effectiveHints.add(hint);
				if (hint.getSource() == BoundTypeArgumentSource.INFERRED) {
					if (inferredHints.isEmpty()) {
						hasInferred = true;
					}
					inferredHints.add(hint);
				}
				if (hint.getSource() == BoundTypeArgumentSource.INFERRED_EXPECTATION) {
					if (expectationHints == null) {
						expectationHints = Lists.newArrayListWithCapacity(2);
					}
					expectationHints.add(hint);
				}
				if (!hasInferred && hint.getSource() == BoundTypeArgumentSource.INFERRED_CONSTRAINT) {
					inferredConstraintHints.add(hint);
				}
			}
		}
		if (expectationHints != null) {
			inferredHints.addAll(expectationHints);
		}
		return hasContraintHints;
	}

	protected void propageResolvedTypeToConstraints(List<LightweightBoundTypeArgument> hints) {
		if (!resolvedTo.isRawType()) {
			for(LightweightBoundTypeArgument hint: hints) {
				LightweightTypeReference hintReference = hint.getTypeReference();
				if (hintReference != null && !hintReference.isRawType() && hint.getSource() == BoundTypeArgumentSource.CONSTRAINT) {
					DeferredTypeParameterHintCollector collector = new DeferredTypeParameterHintCollector(getOwner()) {
						@Override
						protected BoundTypeArgumentSource getTypeArgumentSource() {
							return BoundTypeArgumentSource.INFERRED_CONSTRAINT;
						}
						@Override
						protected void addHint(UnboundTypeReference typeParameter, LightweightTypeReference reference) {
							if (typeParameter.getHandle() != getHandle())
								super.addHint(typeParameter, reference);
						}
					};
					collector.processPairedReferences(hintReference, resolvedTo);
				}
			}
		}
	}

	/**
	 * Always copies the reference since we want to reduce the nesting level
	 * of references if this one was resolved but points to something unresolved.
	 * In that case, we only want to copy the remaining unresolved parts.
	 * Otherwise we copy this reference.
	 */
	@Override
	public LightweightTypeReference copyInto(ITypeReferenceOwner owner) {
		return doCopyInto(owner);
	}
	
	@Override
	public boolean isResolved() {
		if (internalGetResolvedTo() != null) {
			return resolvedTo.isResolved();
		}
		return false;
	}
	
	public boolean internalIsResolved() {
		return internalGetResolvedTo() != null;
	}
	
	/* @Nullable */
	public LightweightTypeReference internalGetResolvedTo() {
		if (resolvedTo != null) {
			if (!getOwner().isResolved(handle)) {
				throw new IllegalStateException("owner should know that this one is resolved");
			}
			return resolvedTo;
		}
		if (getOwner().isResolved(getHandle())) {
			List<LightweightBoundTypeArgument> hints = getOwner().getAllHints(getHandle());
			if (hints.isEmpty()) {
				throw new IllegalStateException("cannot have empty hints if marked as resolved");
			}
			if (hints.size() != 1)
				return null;
			LightweightBoundTypeArgument singleHint = hints.get(0);
			if (singleHint.getSource() == BoundTypeArgumentSource.RESOLVED) {
				resolvedTo = singleHint.getTypeReference();
				if (!getOwner().isResolved(handle)) {
					throw new IllegalStateException("owner should know that this one is resolved");
				}
				return resolvedTo;
			}
		}
		return null;
	}
	
	@Override
	public List<LightweightTypeReference> getTypeArguments() {
		if (internalIsResolved()) {
			return resolvedTo.getTypeArguments();
		}
		return super.getTypeArguments();
	}
	
	@Override
	public boolean hasTypeArguments() {
		if (internalIsResolved()) {
			return resolvedTo.hasTypeArguments();
		}
		return super.hasTypeArguments();
	}
	
	@Override
	public boolean isArray() {
		if (internalIsResolved()) {
			return resolvedTo.isArray();
		}
		return false;
	}
	
	@Override
	public boolean isVisible(IVisibilityHelper visibilityHelper) {
		if (internalIsResolved()) {
			return resolvedTo.isVisible(visibilityHelper);
		}
		return true;
	}
	
	@Override
	public boolean isAny() {
		if (internalIsResolved()) {
			return resolvedTo.isAny();
		}
		return false;
	}
	
	@Override
	public boolean isUnknown() {
		if (internalIsResolved()) {
			return resolvedTo.isUnknown();
		}
		return false;
	}
	
	@Override
	public FunctionTypeKind getFunctionTypeKind() {
		if (internalIsResolved()) {
			return resolvedTo.getFunctionTypeKind();
		}
		return super.getFunctionTypeKind();
	}
	
	@Override
	/* @Nullable */
	public ArrayTypeReference tryConvertToArray() {
		if (internalIsResolved()) {
			return resolvedTo.tryConvertToArray();
		}
		return super.tryConvertToArray();
	}
	
	@Override
	/* @Nullable */
	public FunctionTypeReference tryConvertToFunctionTypeReference(boolean rawType) {
		if (internalIsResolved()) {
			return resolvedTo.tryConvertToFunctionTypeReference(rawType);
		}
		return super.tryConvertToFunctionTypeReference(rawType);
	}
	
	@Override
	/* @Nullable */
	public LightweightTypeReference tryConvertToListType() {
		if (internalIsResolved()) {
			return resolvedTo.tryConvertToListType();
		}
		return null;
	}
	
	@Override
	/* @Nullable */
	public LightweightTypeReference getComponentType() {
		if (internalIsResolved()) {
			return resolvedTo.getComponentType();
		}
		return super.getComponentType();
	}
	
	@Override
	public boolean isWrapper() {
		if (internalIsResolved()) {
			return resolvedTo.isWrapper();
		}
		return false;
	}
	
	@Override
	public boolean isPrimitive() {
		if (internalIsResolved()) {
			return resolvedTo.isPrimitive();
		}
		return false;
	}
	
	@Override
	/* @Nullable */
	public Primitive getPrimitiveKind() {
		if (internalIsResolved()) {
			return resolvedTo.getPrimitiveKind();
		}
		return null;
	}
	
	@Override
	/* @Nullable */
	public Primitive getPrimitiveKindIfWrapperType() {
		if (internalIsResolved()) {
			return resolvedTo.getPrimitiveKindIfWrapperType();
		}
		return null;
	}
	
	@Override
	public boolean isPrimitiveVoid() {
		if (internalIsResolved()) {
			return resolvedTo.isPrimitiveVoid();
		}
		return false;
	}
	
	@Override
	public boolean isInterfaceType() {
		if (internalIsResolved()) {
			return resolvedTo.isInterfaceType();
		}
		return false;
	}
	
	@Override
	public LightweightTypeReference getPrimitiveIfWrapperType() {
		if (internalIsResolved()) {
			return resolvedTo.getPrimitiveIfWrapperType();
		}
		return this;
	}
	
	@Override
	/* @Nullable */
	public JvmType getType() {
		if (internalIsResolved())
			return resolvedTo.getType();
		return getTypeParameter();
	}
	
	@Override
	public boolean isType(Class<?> clazz) {
		if (internalIsResolved()) {
			return resolvedTo.isType(clazz);
		}
		return false;
	}
	
	@Override
	protected List<LightweightTypeReference> getSuperTypes(TypeParameterSubstitutor<?> substitutor) {
		if (internalIsResolved())
			return resolvedTo.getSuperTypes(substitutor);
		return Collections.emptyList();
	}
	
	@Override
	/* @Nullable */
	public LightweightTypeReference getSuperType(JvmType rawType) {
		if (internalIsResolved())
			return resolvedTo.getSuperType(rawType);
		return null;
	}
	
	@Override
	/* @Nullable */
	public LightweightTypeReference getSuperType(Class<?> rawType) {
		if (internalIsResolved())
			return resolvedTo.getSuperType(rawType);
		return null;
	}
	
	@Override
	public LightweightTypeReference getWrapperTypeIfPrimitive() {
		if (internalIsResolved())
			return resolvedTo.getWrapperTypeIfPrimitive();
		return super.getWrapperTypeIfPrimitive();
	}

	boolean copying = false;
	
	@Override
	protected LightweightTypeReference doCopyInto(ITypeReferenceOwner owner) {
		if (internalIsResolved()) {
			if (copying) {
				throw new IllegalStateException();
			}
			copying = true;
			try {
				return resolvedTo.copyInto(owner);
			} finally {
				copying = false;
			}
		}
		UnboundTypeReference result = createCopy(owner);
		return result;
	}

	@Override
	public String getSimpleName() {
		if (internalIsResolved()) {
			return resolvedTo.getSimpleName();
		}
		return "Unbound[" + typeParameter.getSimpleName() + "]";
	}
	
	@Override
	public String getIdentifier() {
		if (internalIsResolved()) {
			return resolvedTo.getIdentifier();
		}
		return "Unbound[" + typeParameter.getIdentifier() + "]";
	}
	
	@Override
	public String getUniqueIdentifier() {
		if (internalIsResolved()) {
			return resolvedTo.getUniqueIdentifier();
		}
		return "Unbound[" + getUniqueIdentifier(typeParameter) + ":" + handle + "]";
	}
	
	@Override
	public String getJavaIdentifier() {
		if (internalIsResolved()) {
			return resolvedTo.getJavaIdentifier();
		}
		return getIdentifier();
	}
	
	@Override
	public void accept(TypeReferenceVisitor visitor) {
		if (internalIsResolved()) {
			resolvedTo.accept(visitor);
		} else {
			visitor.doVisitUnboundTypeReference(this);
		}
	}
	
	@Override
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		if (internalIsResolved()) {
			resolvedTo.accept(visitor, param);
		} else {
			visitor.doVisitUnboundTypeReference(this, param);
		}
	}
	
	@Override
	/* @Nullable */
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		if (internalIsResolved()) {
			return resolvedTo.accept(visitor);
		} else {
			return visitor.doVisitUnboundTypeReference(this);
		}
	}
	
	@Override
	/* @Nullable */
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		if (internalIsResolved()) {
			return resolvedTo.accept(visitor, param);
		} else {
			return visitor.doVisitUnboundTypeReference(this, param);
		}
	}
	
	public void acceptHint(VarianceInfo variance) {
		acceptHint(new LightweightBoundTypeArgument(null, null, variance, null, null));		
	}

	/**
	 * <p>Attach a resolution hint to this unbound type reference.</p>
	 * <p>
	 * Only {@link #isValidHint() valid} hints can be accepted. The given source indicates the
	 * quality of this hint. The {@link VarianceInfo variances} indicate how the hint was used and
	 * how it was expected to be used. A hint from a co-variant location may not have the same impact
	 * for a contra-variant usage as a contra-variant hint. Consider a return type of a method</p>
	 * <p>
	 * <code>
	 *   &lt;T&gt; Collection&lt;? extends T&gt; m(..) { }
	 * </code>
	 * </p>
	 * and its usage
	 * <p>
	 * <code>
	 *   Collection&lt;? super CharSequence&gt; variable = m(..)
	 * </code>
	 * </p>
	 * <p>
	 * The hint that stems from the variable declaration may not be very useful since the variances
	 * are not compatible. Nevertheless, it can be accepted to produce better error messages.</p>
	 * 
	 * @param hint the reference that provides the hint.
	 * @param source the source of this hint, e.g. an inferred hint, or an expectation.
	 * @param origin the object that produced the hint. Only for debugging purpose to trace the origin of a hint.
	 * @param expectedVariance the expected variance, e.g. where this unbound type reference is used.
	 * @param actualVariance how the hint is used.
	 * 
	 * @see LightweightTypeReference#isValidHint()
	 */
	public void acceptHint(
			LightweightTypeReference hint, BoundTypeArgumentSource source, Object origin,
			VarianceInfo expectedVariance, VarianceInfo actualVariance) {
		if (!hint.isValidHint())
			throw new IllegalArgumentException("Hint may not be primitive void, <any> or <unknown>");
		if (hint instanceof UnboundTypeReference) {
			if (((UnboundTypeReference) hint).getHandle() == getHandle()) {
				return; // invalid input, e.g. List<T extends T>
			}
		}
		acceptHint(new LightweightBoundTypeArgument(hint.getWrapperTypeIfPrimitive(), source, origin, expectedVariance, actualVariance));
	}
	
	public void acceptHint(LightweightBoundTypeArgument hint) {
		if (internalIsResolved()) {
			throw new IllegalStateException("Cannot add hints to a resolved reference");
		}
		if (hint.getSource() == BoundTypeArgumentSource.EXPLICIT) {
			LightweightTypeReference reference = hint.getTypeReference();
			if (!(reference instanceof ParameterizedTypeReference) && !reference.isArray() && !reference.isUnknown()) {
				throw new IllegalArgumentException("cannot set " + hint + " as explicit hint");
			}
			if (!getAllHints().isEmpty()) {
				throw new IllegalStateException("Cannot set explicit hint if other hints are present: " + getAllHints());
			}
			this.resolvedTo = reference;
			getOwner().acceptHint(getHandle(), new LightweightBoundTypeArgument(resolvedTo, BoundTypeArgumentSource.RESOLVED, this, hint.getDeclaredVariance(), hint.getActualVariance()));
			return;
		}
		getOwner().acceptHint(this.getHandle(), hint);
	}
	
	public List<LightweightBoundTypeArgument> getAllHints() {
		if (internalGetResolvedTo() != null) {
			throw new IllegalStateException("Cannot query hints for a resolved reference");
		}
		return getOwner().getAllHints(getHandle());
	}

	public boolean equalHandles(UnboundTypeReference reference) {
		return getHandle().equals(reference.getHandle());
	}

	@Override
	public boolean isWildcard() {
		if (resolvedTo != null)
			return resolvedTo.isWildcard();
		return false;
	}
	
	@Override
	public boolean isMultiType() {
		if (resolvedTo != null)
			return resolvedTo.isMultiType();
		return super.isMultiType();
	}
	
	@Override
	public boolean isSynonym() {
		if (resolvedTo != null)
			return resolvedTo.isSynonym();
		return super.isSynonym();
	}
	
	@Override
	public LightweightTypeReference toJavaType() {
		if (resolvedTo != null)
			return resolvedTo.toJavaType();
		return super.toJavaType();
	}
	
	@Override
	public List<LightweightTypeReference> getMultiTypeComponents() {
		if (resolvedTo != null)
			return resolvedTo.getMultiTypeComponents();
		return super.getMultiTypeComponents();
	}
}
