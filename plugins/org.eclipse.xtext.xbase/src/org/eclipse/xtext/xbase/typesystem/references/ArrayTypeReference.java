/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.io.Serializable;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ArrayTypeReference extends LightweightTypeReference {

	private LightweightTypeReference component;

	public ArrayTypeReference(ITypeReferenceOwner owner, LightweightTypeReference component) {
		super(owner);
		this.component = Preconditions.checkNotNull(component, "component");
		// TODO decide about the following constraint which prevents (Number & Serializable)[]
//		if (!(component.getType() instanceof JvmComponentType)) {
//			throw new IllegalArgumentException("Cannot create array reference from non-component type " + component.getIdentifier());
//		}
		if (!component.isOwnedBy(owner)) {
			throw new IllegalArgumentException("component is not valid in current context");
		}
	}
	
	@Override
	public JvmTypeReference toTypeReference() {
		JvmGenericArrayTypeReference result = getTypesFactory().createJvmGenericArrayTypeReference();
		result.setComponentType(component.toTypeReference());
		return result;
	}
	
	@Override
	public JvmArrayType getType() {
		JvmType componentType = component.getType();
		if (componentType instanceof JvmComponentType) {
			return Preconditions.checkNotNull(((JvmComponentType) componentType).getArrayType());
		}
		throw new IllegalStateException("component type seems to be invalid");
	}
	
	@Override
	protected List<LightweightTypeReference> getSuperTypes(TypeParameterSubstitutor<?> substitutor) {
		List<LightweightTypeReference> componentSuperTypes = component.getSuperTypes(substitutor);
		if (!componentSuperTypes.isEmpty()) {
			List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(componentSuperTypes.size());
			for(LightweightTypeReference componentSuperType: componentSuperTypes) {
				result.add(new ArrayTypeReference(getOwner(), componentSuperType));
			}
			return result;
		}
		List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(3);
		result.add(new ParameterizedTypeReference(getOwner(), findNonNullType(Cloneable.class)));
		result.add(new ParameterizedTypeReference(getOwner(), findNonNullType(Serializable.class)));
		return result;
	}
	
	@Override
	public boolean isResolved() {
		return component.isResolved();
	}
	
	@Override
	public boolean isRawType() {
		return component.isRawType();
	}
	
	@Override
	public boolean isOwnedBy(ITypeReferenceOwner owner) {
		return super.isOwnedBy(owner) && component.isOwnedBy(owner);
	}
	
	@Override
	public boolean isArray() {
		return true;
	}
	
	@Override
	public ParameterizedTypeReference tryConvertToListType() {
		ArrayTypes arrayTypes = getServices().getArrayTypes();
		return arrayTypes.convertToList(this);
	}
	
	@Override
	protected LightweightTypeReference doCopyInto(ITypeReferenceOwner owner) {
		LightweightTypeReference copiedComponent = component.copyInto(owner);
		return new ArrayTypeReference(owner, copiedComponent);
	}
	
	@Override
	public String getSimpleName() {
		return component.getSimpleName() + "[]";
	}
	
	@Override
	public String getIdentifier() {
		return component.getIdentifier() + "[]";
	}
	
	@Override
	public boolean isType(Class<?> clazz) {
		if (clazz.isArray()) {
			return component.isType(clazz.getComponentType());
		}
		return false;
	}
	
	@Override
	public LightweightTypeReference getComponentType() {
		return component;
	}
	
	@Override
	public void accept(TypeReferenceVisitor visitor) {
		visitor.doVisitArrayTypeReference(this);
	}
	
	@Override
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		visitor.doVisitArrayTypeReference(this, param);
	}
	
	@Override
	@Nullable
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		return visitor.doVisitArrayTypeReference(this);
	}
	
	@Override
	@Nullable
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		return visitor.doVisitArrayTypeReference(this, param);
	}

}
