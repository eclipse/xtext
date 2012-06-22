/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ArrayTypeReference extends LightweightTypeReference {

	private LightweightTypeReference component;

	protected ArrayTypeReference(TypeReferenceOwner owner, LightweightTypeReference component) {
		super(owner);
		this.component = component;
	}
	
	@Override
	public JvmTypeReference toTypeReference() {
		JvmGenericArrayTypeReference result = getTypesFactory().createJvmGenericArrayTypeReference();
		result.setComponentType(component.toTypeReference());
		return result;
	}
	
	@Override
	public boolean isResolved() {
		return component.isResolved();
	}

	@Override
	protected LightweightTypeReference doCopyInto(TypeReferenceOwner owner) {
		LightweightTypeReference copiedComponent = component.copyInto(owner);
		return new ArrayTypeReference(owner, copiedComponent);
	}
	
	@Override
	public String toString() {
		return component + "[]";
	}
	
	@Override
	public boolean isType(Class<?> clazz) {
		if (clazz.isArray()) {
			return component.isType(clazz.getComponentType());
		}
		return false;
	}
	
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
