/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge
 */
@Beta
public interface TypeReference extends Element {

	Type getType();

	List<TypeReference> getActualTypeArguments();

	boolean isWildCard();

	TypeReference getUpperBound();

	TypeReference getLowerBound();

	boolean isArray();

	TypeReference getArrayComponentType();

	boolean isAnyType();

	/**
	 * @return whether this is a primitive type (i.e. one of boolean, char, byte, short, int, long, float, double).
	 */
	boolean isPrimitive();

	TypeReference getWrapperIfPrimitive();

	/**
	 * Checks whether this type is one of the wrapper types for the primitive value types.
	 * 
	 * @return wither this is one of the wrapper types for the primitive value types.
	 */
	boolean isWrapper();

	TypeReference getPrimitiveIfWrapper();

	/**
	 * @return whether this type is 'void' (doesn't include 'java.lang.Void')
	 */
	boolean isVoid();

	/**
	 * Determines if the specified <code>TypeReference</code> parameter can be assigned to this 
	 * <code>TypeReference</code>. It returns <code>true</code> if so;
	 * otherwise it returns <code>false</code>.
	 * 
	 * @param typeReference
	 * @return returns <code>true</code> is the specified type reference parameter can be assigned to this type reference.
	 */
	boolean isAssignableFrom(TypeReference typeReference);
	
	// TODO super types, features
}
