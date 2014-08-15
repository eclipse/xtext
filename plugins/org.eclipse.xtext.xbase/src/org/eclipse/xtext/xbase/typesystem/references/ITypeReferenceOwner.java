/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JAvaDoc, factory (methods?) for lightweight type references
 */
public interface ITypeReferenceOwner {
	
	CommonTypeComputationServices getServices();
	
	/**
	 * Returns the context resource set if any.
	 * May return null if there is no context information available.
	 * 
	 * In those cases, the owner is rather useless.
	 */
	ResourceSet getContextResourceSet();
	
	CompoundTypeReference newCompoundTypeReference(boolean synonym);
	ArrayTypeReference newArrayTypeReference(LightweightTypeReference componentTypeReference);
	WildcardTypeReference newWildcardTypeReference();
	ParameterizedTypeReference newParameterizedTypeReference(JvmType type);
	InnerTypeReference newParameterizedTypeReference(LightweightTypeReference outer, JvmType type);
	FunctionTypeReference newFunctionTypeReference(JvmType type);
	InnerFunctionTypeReference newFunctionTypeReference(LightweightTypeReference outer, JvmType type);

	LightweightTypeReference toPlainTypeReference(JvmType type);
	LightweightTypeReference toPlainTypeReference(JvmTypeReference type);
//	LightweightTypeReference getRawTypeReference(Type type);
//	LightweightTypeReference getRawTypeReference(String typeName);
	
	LightweightTypeReference toLightweightTypeReference(JvmType type);
	LightweightTypeReference toLightweightTypeReference(JvmTypeReference type);
//	LightweightTypeReference getTypeReference(Type type);
//	LightweightTypeReference getTypeReference(String typeName);
	
//	LightweightTypeReference getTypeReferenceFromSignature(String signature);
	
	/*
	 * TODO move the following methods to a more suitable location if possible
	 */
	/**
	 * @throws UnsupportedOperationException if this owner is not capable of handling unbound type references.
	 */
	void acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument);

	/**
	 * @throws UnsupportedOperationException if this owner is not capable of handling unbound type references.
	 */
	List<LightweightBoundTypeArgument> getAllHints(Object handle);

	/**
	 * @throws UnsupportedOperationException if this owner is not capable of handling unbound type references.
	 */
	boolean isResolved(Object handle);

	List<JvmTypeParameter> getDeclaredTypeParameters();

	UnknownTypeReference newUnknownTypeReference();
	UnknownTypeReference newUnknownTypeReference(String name);

	AnyTypeReference newAnyTypeReference();

}
