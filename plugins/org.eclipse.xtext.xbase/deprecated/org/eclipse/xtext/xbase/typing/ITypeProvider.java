/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @deprecated Use the {@link IBatchTypeResolver} instead.
 */
@Deprecated
public interface ITypeProvider {

	/**
	 * Return the expected return type of the given expression. 
	 * @param expression the expression. May not be <code>null</code>.
	 * @param rawType <code>true</code> if the raw type is sufficient.
	 * @return the expected return type of the given expression, if a correct, fully-linkable model is given.
	 *         Returns <code>null</code> if no special return type is expected
	 */
	public JvmTypeReference getExpectedReturnType(XExpression expression, boolean rawType);
	
	/**
	 * Return the resolved expected type of the given expression. 
	 * Same as {@link #getExpectedType(XExpression, boolean) getExpectedType(expression, false}.
	 * @param expression the expression. May not be <code>null</code>.
	 * @return the fully-resolved expected type of the given expression, if a correct, fully-linkable model is given.
	 *         Returns <code>null</code> if no special type is expected
	 * 
	 */
	public JvmTypeReference getExpectedType(XExpression expression);
	
	/**
	 * @param expression the expression. May not be <code>null</code>.
	 * @param rawType <code>true</code> if the raw type is sufficient.
	 * @return the fully-resolved expected type of the given expression, if a correct, fully-linkable model is given.
	 *         Returns <code>null</code> if no special type is expected
	 * 
	 */
	public JvmTypeReference getExpectedType(XExpression expression, boolean rawType);

	/**
	 * Return the resolved type of the given expression. Same as {@link #getType(XExpression, boolean) getType(expression, false}.
	 * @param expression the expression. May not be <code>null</code>.
	 * @return the fully-resolved type of the {@link XExpression}, if a correct, fully-linkable model is given.
	 *         <code>null</code> indicates a problem during resolution.
	 */
	public JvmTypeReference getType(XExpression expression);
	
	/**
	 * @param expression the expression. May not be <code>null</code>.
	 * @param rawType <code>true</code> if the raw type is sufficient.
	 * @return the fully-resolved type of the {@link XExpression}, if a correct, fully-linkable model is given.
	 *         <code>null</code> indicates a problem during resolution.
	 */
	public JvmTypeReference getType(XExpression expression, boolean rawType);
	
	/**
	 * @param expression the expression. May not be <code>null</code>.
	 * @param rawType <code>true</code> if the raw type is sufficient.
	 * @return the fully-resolved type of the {@link XExpression}, if a correct, fully-linkable model is given.
	 *         <code>null</code> indicates a problem during resolution.
	 */
	public JvmTypeReference getType(XExpression expression, JvmTypeReference rawExpectation, boolean rawType);

	/**
	 * Return the resolved type of the element. Same as 
	 * {@link #getTypeForIdentifiable(JvmIdentifiableElement, boolean) getTypeForIdentifiable(identifiableElement, false}.
	 * @param identifiableElement the identifiable element. May not be <code>null</code>.
	 * @return the fully-resolved type of the {@link JvmIdentifiableElement}, if a correct, fully-linkable model is
	 *         given. <code>null</code> indicates a problem during resolution. given.
	 */
	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement);
	
	/**
	 * @param identifiableElement the identifiable element. May not be <code>null</code>.
	 * @param rawType <code>true</code> if the raw type is sufficient.
	 * @return the fully-resolved type of the {@link JvmIdentifiableElement}, if a correct, fully-linkable model is
	 *         given. <code>null</code> indicates a problem during resolution. given.
	 */
	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement, boolean rawType);
	
	/**
	 * The return type of an expression is the common super type of all types used within a return expression.
	 * 
	 * @param expression May not be <code>null</code>.
	 * @param assumeImplicitReturn indicating whether an implicit return expression should be assumed
	 * @return the fully-resolved common return type of the {@link XExpression}, if a correct, fully-linkable model is
	 *         given. <code>null</code> indicates a problem during computation, the primitive void indicates that no return expression was found.
	 */
	public JvmTypeReference getCommonReturnType(XExpression expression, boolean assumeImplicitReturn);
	
}
