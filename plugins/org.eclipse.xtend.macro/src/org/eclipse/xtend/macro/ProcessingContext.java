/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtend.macro;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Procedures;

/**
 * An instance of this type is passed to any 'do' method in processing annotation.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public interface ProcessingContext {
	
	JvmDeclaredType with(String name, Procedures.Procedure1<JvmGenericType> initializer);

	JvmField field(String name, JvmTypeReference type);

	JvmOperation method(String name, JvmTypeReference returnType, Procedures.Procedure1<JvmOperation> initializer);
	
	JvmConstructor constructor(Procedures.Procedure1<JvmConstructor> initializer);
	
	JvmFormalParameter param(String name, JvmTypeReference type);

	/**
	 * @returns the type T as a {@link JvmTypeReference} instance.
	 */
	<T> JvmTypeReference type();
	
	/**
	 * @returns the type as a {@link JvmTypeReference} instance.
	 */
	JvmTypeReference type(JvmType typeDeclaration, JvmTypeReference ... typeRef);
	
	/**
	 * @returns the type as a {@link JvmTypeReference} instance.
	 */
	JvmTypeReference type(Class<?> clazz, JvmTypeReference ... typeRef);
	
	/**
	 * @returns the type as a {@link JvmTypeReference} instance.
	 */
	JvmTypeReference type(String name, JvmTypeReference ... typeRef);

	/**
	 * @returns a pseudo handle, used to put existing expressions into the context of a new expression.
	 */
	<T> T result(XExpression expression);

	/**
	 * @returns 
	 */
	<T, RETURN_TYPE> XExpression reify(Functions.Function1<T,RETURN_TYPE> expression);
}
