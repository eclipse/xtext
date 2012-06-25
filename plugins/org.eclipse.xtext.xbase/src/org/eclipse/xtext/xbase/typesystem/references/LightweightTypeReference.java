/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO document the purpose of this class
 *  - get rid of containment constraints
 *  - easier copying
 *  - isResolved
 */
@NonNullByDefault
public abstract class LightweightTypeReference {
	
	private TypeReferenceOwner owner;
	
	protected LightweightTypeReference(TypeReferenceOwner owner) {
		this.owner = owner;
	}

	public boolean isResolved() {
		return true;
	}
	
	protected TypeReferenceOwner getOwner() {
		return owner;
	}
	
	protected TypesFactory getTypesFactory() {
		return getOwner().getServices().getTypesFactory();
	}
	
	protected CommonTypeComputationServices getServices() {
		return getOwner().getServices();
	}
	
	public boolean isOwnedBy(TypeReferenceOwner owner) {
		if (isResolved()) {
			return true;
		}
		return owner == getOwner();
	}
	
	protected <T> List<T> expose(@Nullable List<T> list) {
		if (list == null) {
			return Collections.emptyList();
		}
		return Collections.unmodifiableList(list);
	}
	
	public abstract JvmTypeReference toTypeReference();
	
	@Nullable
	public JvmType getType() {
		return null;
	}
	
	public LightweightTypeReference getWrapperTypeIfPrimitive() {
		return this;
	}
	
	/*
	 * Does pretty much the same as the RawTypeHelper
	 * TODO implement me
	 */
	public List<JvmType> getRawTypes() {
		throw new UnsupportedOperationException();
	}
	
	/*
	 * Replaced wildcards and type parameters by their respective
	 * constraints. Returns the JvmTypes without arguments.
	 * TODO implement me
	 */
	public LightweightTypeReference getRawTypeReference() {
		throw new UnsupportedOperationException();
	}
	
	/*
	 * Returns true if the associated type expects arguments but none are given
	 * TODO implement me
	 */
	public boolean isRawType() {
		throw new UnsupportedOperationException();
	}
	
	public LightweightTypeReference copyInto(TypeReferenceOwner owner) {
		if (isResolved()) {
			return this;
		}
		return doCopyInto(owner);
	}

	protected abstract LightweightTypeReference doCopyInto(TypeReferenceOwner owner);
	
	@Override
	public abstract String toString();

	public boolean isType(Class<?> clazz) {
		return false;
	}
	
	public boolean isType(Type type) {
		throw new UnsupportedOperationException();
	}

	public void accept(TypeReferenceVisitor visitor) {
		visitor.doVisitTypeReference(this);
	}
	
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		visitor.doVisitTypeReference(this, param);
	}
	
	@Nullable
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		return visitor.doVisitTypeReference(this);
	}
	
	@Nullable
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		return visitor.doVisitTypeReference(this, param);
	}
	
	public <Result> Result accept(TypeReferenceVisitorWithNonNullResult<Result> visitor) {
		Result result = accept((TypeReferenceVisitorWithResult<Result>)visitor);
		if (result == null)
			throw new IllegalStateException("result may not be null");
		return result;
	}
	
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndNonNullResult<Param, Result> visitor, Param param) {
		Result result = accept((TypeReferenceVisitorWithParameterAndResult<Param, Result>)visitor, param);
		if (result == null)
			throw new IllegalStateException("result may not be null");
		return result;
	}

	public CompoundTypeReference toMultiType(LightweightTypeReference reference) {
		if (reference == null) {
			throw new NullPointerException("reference may not be null");
		}
		CompoundTypeReference result = new CompoundTypeReference(getOwner(), false);
		result.addComponent(this);
		result.addComponent(reference);
		return result;
	}

	public boolean isPrimitive() {
		return false;
	}
	
}
