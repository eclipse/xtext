/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmFormalParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XClosure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XClosure#getDeclaredFormalParameters <em>Declared Formal Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XClosure#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XClosure#isExplicitSyntax <em>Explicit Syntax</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XClosure#getImplicitFormalParameters <em>Implicit Formal Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXClosure()
 * @model
 * @generated
 */
public interface XClosure extends XExpression
{
	/**
	 * Returns the value of the '<em><b>Declared Formal Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmFormalParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declared Formal Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Formal Parameters</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXClosure_DeclaredFormalParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmFormalParameter> getDeclaredFormalParameters();

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXClosure_Expression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XClosure#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Explicit Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Explicit Syntax</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explicit Syntax</em>' attribute.
	 * @see #setExplicitSyntax(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXClosure_ExplicitSyntax()
	 * @model
	 * @generated
	 */
	boolean isExplicitSyntax();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XClosure#isExplicitSyntax <em>Explicit Syntax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explicit Syntax</em>' attribute.
	 * @see #isExplicitSyntax()
	 * @generated
	 */
	void setExplicitSyntax(boolean value);

	/**
	 * Returns the value of the '<em><b>Implicit Formal Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmFormalParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implicit Formal Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implicit Formal Parameters</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXClosure_ImplicitFormalParameters()
	 * @model containment="true" transient="true" derived="true"
	 * @generated
	 */
	EList<JvmFormalParameter> getImplicitFormalParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<JvmFormalParameter> getFormalParameters();

} // XClosure
