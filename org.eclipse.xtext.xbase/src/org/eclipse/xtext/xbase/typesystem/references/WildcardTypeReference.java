/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.lang.reflect.WildcardType;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class WildcardTypeReference extends LightweightTypeReference {

	private List<LightweightTypeReference> upperBounds;
	private LightweightTypeReference lowerBound;
	private boolean resolved;
	
	public WildcardTypeReference(ITypeReferenceOwner owner) {
		super(owner);
		resolved = true;
	}
	
	/**
	 * Subclasses <em>must</em> override this method.
	 */
	@Override
	public int getKind() {
		return KIND_WILDCARD_TYPE_REFERENCE;
	}
	
	@Override
	public boolean isResolved() {
		return resolved;
	}
	
	@Override
	public List<LightweightTypeReference> getTypeArguments() {
		if (lowerBound != null)
			return lowerBound.getTypeArguments();
		if (upperBounds != null && upperBounds.size() == 1) {
			return upperBounds.get(0).getTypeArguments();
		}
		return super.getTypeArguments();
	}

	@Override
	public boolean hasTypeArguments() {
		if (lowerBound != null)
			return lowerBound.hasTypeArguments();
		if (upperBounds != null && upperBounds.size() == 1) {
			return upperBounds.get(0).hasTypeArguments();
		}
		return super.hasTypeArguments();
	}
	
	public List<LightweightTypeReference> getUpperBounds() {
		return expose(upperBounds);
	}
	
	/**
	 * Returns <code>true</code> if this wilcard is unbounded according to
	 * http://docs.oracle.com/javase/specs/jls/se7/html/jls-4.html#jls-4.5.1.
	 * 
	 * Unbounded wildcards do not have any upper or lower bound defined.
	 * Unbounded references are only useful on the source level since at runtime
	 * an unbound wildcard type gets Object as upper bound (see {@link WildcardType#getUpperBounds()}.
	 */
	public boolean isUnbounded() {
		return lowerBound == null && upperBounds == null || upperBounds.isEmpty();
	}
	
	/* @Nullable */
	public LightweightTypeReference getLowerBound() {
		return lowerBound;
	}
	
	@Override
	public boolean isOwnedBy(ITypeReferenceOwner owner) {
		if (super.isOwnedBy(owner)) {
			if (lowerBound != null && !lowerBound.isOwnedBy(owner))
				return false;
			for(LightweightTypeReference parameterType: expose(upperBounds)) {
				if (!parameterType.isOwnedBy(owner)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	protected WildcardTypeReference doCopyInto(ITypeReferenceOwner owner) {
		WildcardTypeReference result = owner.newWildcardTypeReference();
		if (upperBounds != null && !upperBounds.isEmpty()) {
			for(LightweightTypeReference upperBound: upperBounds) {
				LightweightTypeReference copiedUpperBound = upperBound.copyInto(owner).getInvariantBoundSubstitute();
				if (!(copiedUpperBound.isPrimitive() || copiedUpperBound.isPrimitiveVoid())) {
					result.addUpperBound(copiedUpperBound);
				}
			}
		}
		if (lowerBound != null) {
			LightweightTypeReference copiedLowerBound = lowerBound.copyInto(owner).getInvariantBoundSubstitute();
			if (!(copiedLowerBound.isPrimitive() || copiedLowerBound.isPrimitiveVoid())) {
				result.setLowerBound(copiedLowerBound);
			}
		}
		return result;
	}
	
	@Override
	public boolean isType(Class<?> clazz) {
		return false;
	}
	
	@Override
	public LightweightTypeReference getUpperBoundSubstitute() {
		if (isUnbounded()) {
			return getOwner().newReferenceToObject();
		}
		List<LightweightTypeReference> upperBounds = getUpperBounds();
		if (upperBounds.size() == 1) {
			LightweightTypeReference result = upperBounds.get(0);
			return result;
		}
		CompoundTypeReference result = getOwner().newCompoundTypeReference(false);
		for(LightweightTypeReference upperBound: upperBounds) {
			result.addComponent(upperBound);
		}
		return result;
	}
	
	@Override
	public LightweightTypeReference getLowerBoundSubstitute() {
		if (lowerBound != null)
			return lowerBound;
		return getOwner().newAnyTypeReference();
	}
	
	@Override
	public LightweightTypeReference getInvariantBoundSubstitute() {
		if (lowerBound != null)
			return lowerBound;
		return getUpperBoundSubstitute();
	}
	
	@Override
	protected List<LightweightTypeReference> getSuperTypes(TypeParameterSubstitutor<?> substitutor) {
		if (isUnbounded()) {
			return Collections.singletonList(getUpperBoundSubstitute());
		}
		List<LightweightTypeReference> nonNullUpperBounds = expose(getUpperBounds());
		List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(nonNullUpperBounds.size());
		for(LightweightTypeReference upperBound: nonNullUpperBounds) {
			result.add(substitutor.substitute(upperBound));
		}
		return result;
	}
	
	@Override
	/* @Nullable */
	public LightweightTypeReference getSuperType(JvmType rawType) {
		if (isUnbounded()) {
			if (Object.class.getName().equals(rawType.getIdentifier())) {
				return getOwner().newParameterizedTypeReference(rawType);
			}
			return null;
		}
		List<LightweightTypeReference> nonNullUpperBounds = expose(getUpperBounds());
		for(LightweightTypeReference upperBound: nonNullUpperBounds) {
			LightweightTypeReference result = upperBound.getSuperType(rawType);
			if (result != null)
				return result;
		}
		return null;
	}
	
	@Override
	/* @Nullable */
	public LightweightTypeReference getSuperType(Class<?> rawType) {
		if (isUnbounded()) {
			if (Object.class.equals(rawType)) {
				return internalFindTopLevelType(rawType);
			}
			return null;
		}
		List<LightweightTypeReference> nonNullUpperBounds = expose(getUpperBounds());
		for(LightweightTypeReference upperBound: nonNullUpperBounds) {
			LightweightTypeReference result = upperBound.getSuperType(rawType);
			if (result != null)
				return result;
		}
		return null;
	}
	
	@Override
	public JvmTypeReference toTypeReference() {
		TypesFactory typesFactory = getTypesFactory();
		JvmWildcardTypeReference result = typesFactory.createJvmWildcardTypeReference();
		if (upperBounds != null && !upperBounds.isEmpty()) {
			for(LightweightTypeReference typeArgument: upperBounds) {
				JvmUpperBound constraint = typesFactory.createJvmUpperBound();
				constraint.setTypeReference(typeArgument.getWrapperTypeIfPrimitive().toTypeReference());
				result.getConstraints().add(constraint);
			}
		}
		if (lowerBound != null) {
			JvmLowerBound constraint = typesFactory.createJvmLowerBound();
			constraint.setTypeReference(lowerBound.getWrapperTypeIfPrimitive().toTypeReference());
			result.getConstraints().add(constraint);
		}
		return result;
	}
	
	@Override
	public JvmTypeReference toJavaCompliantTypeReference(IVisibilityHelper helper) {
		TypesFactory typesFactory = getTypesFactory();
		JvmWildcardTypeReference result = typesFactory.createJvmWildcardTypeReference();
		if (upperBounds != null && !upperBounds.isEmpty()) {
			List<LightweightTypeReference> nonInterfaceTypes = getNonInterfaceTypes(upperBounds);
			JvmTypeReference upperBound = toJavaCompliantTypeReference(nonInterfaceTypes != null ? nonInterfaceTypes: upperBounds, helper);
			JvmUpperBound constraint = typesFactory.createJvmUpperBound();
			constraint.setTypeReference(upperBound);
			result.getConstraints().add(constraint);
		}
		if (lowerBound != null) {
			JvmLowerBound constraint = typesFactory.createJvmLowerBound();
			constraint.setTypeReference(lowerBound.toJavaCompliantTypeReference());
			result.getConstraints().add(constraint);
		}
		return result;
	}
	
	@Override
	public boolean isVisible(IVisibilityHelper visibilityHelper) {
		if (upperBounds != null && !upperBounds.isEmpty()) {
			for(LightweightTypeReference upperBound: upperBounds) {
				if (!upperBound.isVisible(visibilityHelper)) {
					return false;
				}
			}
		}
		if (lowerBound != null && !lowerBound.isVisible(visibilityHelper)) {
			return false;
		}
		return true;
	}
	
	public void addUpperBound(LightweightTypeReference upperBound) {
		if (upperBound == null) {
			throw new NullPointerException("upperBound may not be null");
		}
		if (!upperBound.isOwnedBy(getOwner())) {
			throw new IllegalArgumentException("upperBound is not valid in current context");
		}
		if (upperBound instanceof WildcardTypeReference) {
			throw new IllegalArgumentException("Wildcards are not supported as upper bounds");
		}
		if (upperBound.isPrimitive() || upperBound.isPrimitiveVoid()) {
			throw new IllegalArgumentException("Constraints may not be primitives");
		}
		if (upperBounds == null)
			upperBounds = Lists.newArrayListWithCapacity(2);
		upperBounds.add(upperBound);
		resolved = resolved && upperBound.isResolved();
	}
	
	public void setLowerBound(LightweightTypeReference lowerBound) {
		if (lowerBound == null) {
			throw new NullPointerException("lowerBound may not be null");
		}
		if (!lowerBound.isOwnedBy(getOwner())) {
			throw new IllegalArgumentException("lowerBound is not valid in current context");
		}
		if (lowerBound instanceof WildcardTypeReference) {
			throw new IllegalArgumentException("Wildcards are not supported as lower bounds");
		}
		if (lowerBound.isPrimitive() || lowerBound.isPrimitiveVoid()) {
			throw new IllegalArgumentException("Constraints may not be primitives");
		}
		if (this.lowerBound != null && this.lowerBound != lowerBound) {
			throw new IllegalStateException("only one lower bound is supported");
		}
		
		this.lowerBound = lowerBound;
		resolved = resolved && lowerBound.isResolved();
	}

	@Override
	public String getSimpleName() {
		return getAsString(SimpleNameFunction.INSTANCE, true);
	}
	
	@Override
	public String getIdentifier() {
		return getAsString(IdentifierFunction.INSTANCE, false);
	}
	
	@Override
	public String getUniqueIdentifier() {
		return getAsString(UniqueIdentifierFunction.INSTANCE, false);
	}
	
	@Override
	public String getJavaIdentifier() {
		return getAsString(JavaIdentifierFunction.INSTANCE, false);
	}
	
	@Override
	/* @Nullable */
	public JvmType getType() {
		return null;
	}
	
	private String getAsString(Function<LightweightTypeReference, String> format, boolean simpleName) {
		if (lowerBound != null) {
			return "? super " + format.apply(lowerBound);
		}
		if (simpleName) {
			if (upperBounds != null && upperBounds.size() == 1 && upperBounds.get(0).isType(Object.class)) {
				return "?";
			}
		}
		return "?" + ( upperBounds != null ? " extends " + Joiner.on(" & ").join(Iterables.transform(upperBounds, format)) : "");
	}
	
	@Override
	public void accept(TypeReferenceVisitor visitor) {
		visitor.doVisitWildcardTypeReference(this);
	}
	
	@Override
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		visitor.doVisitWildcardTypeReference(this, param);
	}
	
	@Override
	/* @Nullable */
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		return visitor.doVisitWildcardTypeReference(this);
	}
	
	@Override
	/* @Nullable */
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		return visitor.doVisitWildcardTypeReference(this, param);
	}
	
	@Override
	public boolean isWildcard() {
		return true;
	}
}
