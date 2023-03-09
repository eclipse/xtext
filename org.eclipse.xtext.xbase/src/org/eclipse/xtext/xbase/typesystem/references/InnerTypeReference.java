/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;

import com.google.common.base.Function;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InnerTypeReference extends ParameterizedTypeReference {

	private final LightweightTypeReference outer;

	public InnerTypeReference(ITypeReferenceOwner owner, LightweightTypeReference outer, JvmType type) {
		super(owner, type);
		if (outer == null) {
			throw new NullPointerException("outer type may not be null");
		}
		if (outer.getKind() != KIND_PARAMETERIZED_TYPE_REFERENCE && outer.getKind() != KIND_INNER_TYPE_REFERENCE) {
			throw new NullPointerException("outer type must be a parameterized type reference");
		}
		this.outer = outer;
	}
	
	@Override
	protected void checkStaticFlag(JvmDeclaredType type) {
		if (type.isStatic()) {
			throw new IllegalArgumentException("type must be an inner class");
		}
	}
	
	@Override
	public int getKind() {
		return KIND_INNER_TYPE_REFERENCE;
	}
	
	@Override
	public LightweightTypeReference getOuter() {
		return outer;
	}
	
	@Override
	public boolean hasTypeArguments() {
		return outer.hasTypeArguments() || super.hasTypeArguments();
	}
	
	@Override
	public boolean isResolved() {
		return super.isResolved() && outer.isResolved();
	}
	
	@Override
	public LightweightTypeReference getRawTypeReference() {
		if (isRawType()) {
			return this;
		}
		LightweightTypeReference rawOuter = outer.getRawTypeReference();
		JvmType type = getType();
		if (type.eClass() != TypesPackage.Literals.JVM_TYPE_PARAMETER) {
			return getOwner().newParameterizedTypeReference(rawOuter, type);
		}
		return getServices().getRawTypeHelper().getRawTypeReference(this, getOwner().getContextResourceSet());
	}
	
	@Override
	public JvmTypeReference toTypeReference() {
		JvmInnerTypeReference result = getTypesFactory().createJvmInnerTypeReference();
		result.setType(getType());
		result.setOuter((JvmParameterizedTypeReference) outer.toTypeReference());
		for(LightweightTypeReference typeArgument: getTypeArguments()) {
			result.getArguments().add(typeArgument.toTypeReference());
		}
		return result;
	}
	
	@Override
	public JvmTypeReference toJavaCompliantTypeReference(IVisibilityHelper visibilityHelper) {
		if (isTypeVisible(visibilityHelper)) {
			JvmInnerTypeReference result = getTypesFactory().createJvmInnerTypeReference();
			result.setType(getType());
			result.setOuter((JvmParameterizedTypeReference) outer.toJavaCompliantTypeReference());
			for(LightweightTypeReference typeArgument: getTypeArguments()) {
				result.getArguments().add(typeArgument.toJavaCompliantTypeReference());
			}
			return result;
		} else {
			return toJavaCompliantTypeReference(getSuperTypes(), visibilityHelper);
		}
	}
	
	@Override
	public boolean isRawType() {
		return super.isRawType() || outer.isRawType();
	}
	
	@Override
	public boolean isOwnedBy(ITypeReferenceOwner owner) {
		if (super.isOwnedBy(owner)) {
			boolean result = outer.isOwnedBy(owner);
			return result;
		}
		return false;
	}
	
	@Override
	public boolean isVisible(IVisibilityHelper visibilityHelper) {
		if (super.isVisible(visibilityHelper)) {
			boolean result = outer.isVisible(visibilityHelper);
			return result;
		}
		return false;
	}
	
	@Override
	protected ParameterizedTypeReference doCopyInto(ITypeReferenceOwner owner) {
		LightweightTypeReference copiedOuter = outer.copyInto(owner);
		InnerTypeReference result = new InnerTypeReference(owner, copiedOuter, getType());
		copyTypeArguments(result, owner);
		return result;
	}
	
	@Override
	protected String getAsString(String type, Function<LightweightTypeReference, String> format) {
		type = format.apply(outer) + "$" + getType().getSimpleName();
 		return super.getAsString(type, format);
	}
	
	@Override
	public void accept(TypeReferenceVisitor visitor) {
		visitor.doVisitInnerTypeReference(this);
	}
	
	@Override
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		visitor.doVisitInnerTypeReference(this, param);
	}
	
	@Override
	/* @Nullable */
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		return visitor.doVisitInnerTypeReference(this);
	}
	
	@Override
	/* @Nullable */
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		return visitor.doVisitInnerTypeReference(this, param);
	}
	
	@Override
	public ParameterizedTypeReference toInstanceTypeReference() {
		ParameterizedTypeReference outerInstanceTypeReference = ((ParameterizedTypeReference) outer).toInstanceTypeReference();
		InnerTypeReference result = getOwner().newParameterizedTypeReference(outerInstanceTypeReference, getType());
		for(LightweightTypeReference typeArgument: getTypeArguments()) {
			result.addTypeArgument(typeArgument.getInvariantBoundSubstitute());
		}
		return result;
	}
}
