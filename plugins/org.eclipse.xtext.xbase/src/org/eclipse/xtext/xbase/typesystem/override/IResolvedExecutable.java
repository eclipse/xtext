/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * Resolved representation of a {@link JvmExecutable}.
 * 
 * Parameter types and declared exceptions are put into the context of a specific declaring
 * reference, e.g. {@link List#add(Object) List#add(Object)} becomes <code>List#add(String)</code> in the context of an
 * {@link ArrayList ArrayList&lt;String&gt;}
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IResolvedExecutable {

	/**
	 * Returns the resolved parameter types in the current context. That is, all free type variables are bound according
	 * the the bottom of this method hierarchy.
	 * 
	 * @see #getContextType()
	 * @return the list of parameter types.
	 */
	List<LightweightTypeReference> getResolvedParameterTypes();
	
	/**
	 * Returns the resolved signature of this operation. The resolved representation of
	 * <code>List&lt;String&gt;.addAll(int, Collection&lt;E&gt)</code> is
	 * <code>addAll(int,java.util.Collection&lt;String&gt;)</code>.
	 * 
	 * @return the resolved signature.
	 */
	String getResolvedSignature();

	/**
	 * Returns the simple signature of this operation. The simple signature of
	 * <code>List&lt;String&gt;.addAll(int, Collection&lt;E&gt)</code> is
	 * <code>addAll(int, Collection&lt;String&gt;)</code>.
	 * 
	 * @return the simple, human readable signature.
	 */
	String getSimpleSignature();

	/**
	 * Returns the resolved erased signature of this operation. The resolved representation of
	 * <code>List&lt;String&gt;.addAll(int,java.util.Collection&lt;E&gt)</code> is 
	 * <code>addAll(int,Collection)</code>.
	 * 
	 * @return the erased signature.
	 */
	String getResolvedErasureSignature();
	
	/**
	 * Returns the resolved declared exceptions in the current context. That is, all free type variables are bound
	 * according the the bottom of this method hierarchy.
	 * 
	 * @see #getContextType()
	 * @return the declared exceptions.
	 */
	List<LightweightTypeReference> getResolvedExceptions();

	/**
	 * Returns the declared executable that is resolved.
	 * 
	 * @return the declaration.
	 */
	JvmExecutable getDeclaration();

	/**
	 * Returns the current context type.
	 * 
	 * @return the context.
	 */
	LightweightTypeReference getContextType();
	
	/**
	 * Returns the resolved type of the declarator of this {@link #getDeclaration() declaration}.
	 */
	LightweightTypeReference getResolvedDeclarator();
	
	/**
	 * Returns the list of declared type parameters of the {@link #getDeclaration() executable}.
	 * 
	 * @return the list of declared type parameters.
	 */
	List<JvmTypeParameter> getTypeParameters();
	
}
