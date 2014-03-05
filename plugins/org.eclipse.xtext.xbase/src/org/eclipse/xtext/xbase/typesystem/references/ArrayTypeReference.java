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
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;
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
		if (component.isAny()) {
			throw new IllegalArgumentException("component is invalid: type <any> is not allowed");
		}
		if (component.isWildcard()) {
			throw new IllegalArgumentException("component is invalid: " + component);
		}
		if (!component.isOwnedBy(owner)) {
			throw new IllegalArgumentException("component is not valid in current context");
		}
	}
	
	/**
	 * Subclasses <em>must</em> override this method.
	 */
	@Override
	public int getKind() {
		return KIND_ARRAY_TYPE_REFERENCE;
	}
	
	@Override
	public JvmTypeReference toTypeReference() {
		JvmGenericArrayTypeReference result = getTypesFactory().createJvmGenericArrayTypeReference();
		result.setComponentType(component.toTypeReference());
		return result;
	}
	
	@Override
	public boolean isVisible(IVisibilityHelper visibilityHelper) {
		return component.isVisible(visibilityHelper);
	}
	
	@Override
	public JvmTypeReference toJavaCompliantTypeReference(IVisibilityHelper visibilityHelper) {
		JvmGenericArrayTypeReference result = getTypesFactory().createJvmGenericArrayTypeReference();
		result.setComponentType(component.toJavaCompliantTypeReference(visibilityHelper));
		return result;
	}
	
	@Override
	public JvmArrayType getType() {
		JvmType componentType = component.getType();
		if (componentType instanceof JvmComponentType) {
			return Preconditions.checkNotNull(((JvmComponentType) componentType).getArrayType());
		}
		if (component.isUnknown()) {
			return null;
		}
		throw new IllegalStateException("component type seems to be invalid: " + componentType + " / " + component);
	}
	
	@Override
	public boolean isUnknown() {
		return component.isUnknown();
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
		List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(2);
		result.add(new ParameterizedTypeReference(getOwner(), findNonNullType(Cloneable.class)));
		result.add(new ParameterizedTypeReference(getOwner(), findNonNullType(Serializable.class)));
		return result;
	}
	
	@Override
	@Nullable
	public LightweightTypeReference getSuperType(JvmType rawType) {
		if (rawType.eClass() == TypesPackage.Literals.JVM_ARRAY_TYPE) {
			JvmComponentType rawComponentType = ((JvmArrayType) rawType).getComponentType();
			LightweightTypeReference result = component.getSuperType(rawComponentType);
			if (result == null) {
				return null;
			}
			if (result == component)
				return this;
			return new ArrayTypeReference(getOwner(), result);
		} else if (rawType.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
			String identifier = rawType.getIdentifier();
			if (Object.class.getName().equals(identifier)
					|| Cloneable.class.getName().equals(identifier)
					|| Serializable.class.getName().equals(identifier)) {
				return new ParameterizedTypeReference(getOwner(), rawType);
			}
		}
		return null;
	}
	
	@Override
	@Nullable
	public LightweightTypeReference getSuperType(Class<?> rawType) {
		if (isType(rawType)) {
			return this;
		}
		Class<?> rawComponentType = rawType.getComponentType();
		if (rawComponentType == null) {
			if (Object.class.equals(rawType) || Cloneable.class.equals(rawType) || Serializable.class.equals(rawType)) {
				return internalFindTopLevelType(rawType);
			}
			return null;
		}
		LightweightTypeReference resultComponent = component.getSuperType(rawComponentType);
		if (resultComponent == null) {
			return null;
		}
		return new ArrayTypeReference(getOwner(), resultComponent);
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
	public LightweightTypeReference getRawTypeReference() {
		LightweightTypeReference rawComponent = component.getRawTypeReference();
		if (rawComponent == component) {
			return this;
		}
		return new ArrayTypeReference(getOwner(), rawComponent);
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
	public LightweightTypeReference tryConvertToListType() {
		ArrayTypes arrayTypes = getServices().getArrayTypes();
		return arrayTypes.convertToList(this);
	}
	
	@Override
	@Nullable
	public ArrayTypeReference tryConvertToArray() {
		return this;
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
	public String getUniqueIdentifier() {
		return component.getUniqueIdentifier() + "[]";
	}
	
	@Override
	public String getJavaIdentifier() {
		return component.getJavaIdentifier() + "[]";
	}
	
	@Override
	public boolean isType(Class<?> clazz) {
		Class<?> clazzComponentType = clazz.getComponentType();
		if (clazzComponentType != null) {
			return component.isType(clazzComponentType);
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
