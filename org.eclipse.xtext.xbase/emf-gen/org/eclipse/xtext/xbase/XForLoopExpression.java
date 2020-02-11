/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase;

import org.eclipse.xtext.common.types.JvmFormalParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XFor Loop Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * @since 2.7
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XForLoopExpression#getForExpression <em>For Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XForLoopExpression#getEachExpression <em>Each Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XForLoopExpression#getDeclaredParam <em>Declared Param</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXForLoopExpression()
 * @model
 * @generated
 */
public interface XForLoopExpression extends XExpression
{
	/**
	 * Returns the value of the '<em><b>For Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For Expression</em>' containment reference.
	 * @see #setForExpression(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXForLoopExpression_ForExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getForExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XForLoopExpression#getForExpression <em>For Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For Expression</em>' containment reference.
	 * @see #getForExpression()
	 * @generated
	 */
	void setForExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Each Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Each Expression</em>' containment reference.
	 * @see #setEachExpression(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXForLoopExpression_EachExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getEachExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XForLoopExpression#getEachExpression <em>Each Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Each Expression</em>' containment reference.
	 * @see #getEachExpression()
	 * @generated
	 */
	void setEachExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Declared Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Param</em>' containment reference.
	 * @see #setDeclaredParam(JvmFormalParameter)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXForLoopExpression_DeclaredParam()
	 * @model containment="true"
	 * @generated
	 */
	JvmFormalParameter getDeclaredParam();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XForLoopExpression#getDeclaredParam <em>Declared Param</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declared Param</em>' containment reference.
	 * @see #getDeclaredParam()
	 * @generated
	 */
	void setDeclaredParam(JvmFormalParameter value);

} // XForLoopExpression
