/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XBasic For Loop Expression</b></em>'.
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
 *   <li>{@link org.eclipse.xtext.xbase.XBasicForLoopExpression#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XBasicForLoopExpression#getEachExpression <em>Each Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XBasicForLoopExpression#getInitExpressions <em>Init Expressions</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XBasicForLoopExpression#getUpdateExpressions <em>Update Expressions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXBasicForLoopExpression()
 * @model
 * @generated
 */
public interface XBasicForLoopExpression extends XExpression
{
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXBasicForLoopExpression_Expression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XBasicForLoopExpression#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Each Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Each Expression</em>' containment reference.
	 * @see #setEachExpression(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXBasicForLoopExpression_EachExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getEachExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XBasicForLoopExpression#getEachExpression <em>Each Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Each Expression</em>' containment reference.
	 * @see #getEachExpression()
	 * @generated
	 */
	void setEachExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Init Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Expressions</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXBasicForLoopExpression_InitExpressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getInitExpressions();

	/**
	 * Returns the value of the '<em><b>Update Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Update Expressions</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXBasicForLoopExpression_UpdateExpressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getUpdateExpressions();

} // XBasicForLoopExpression
