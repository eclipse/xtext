/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XTry Catch Finally Expression</b></em>'.
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
 *   <li>{@link org.eclipse.xtext.xbase.XTryCatchFinallyExpression#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XTryCatchFinallyExpression#getFinallyExpression <em>Finally Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XTryCatchFinallyExpression#getCatchClauses <em>Catch Clauses</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XTryCatchFinallyExpression#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXTryCatchFinallyExpression()
 * @model
 * @generated
 */
public interface XTryCatchFinallyExpression extends XExpression
{
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
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXTryCatchFinallyExpression_Expression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XTryCatchFinallyExpression#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Finally Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finally Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finally Expression</em>' containment reference.
	 * @see #setFinallyExpression(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXTryCatchFinallyExpression_FinallyExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getFinallyExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XTryCatchFinallyExpression#getFinallyExpression <em>Finally Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finally Expression</em>' containment reference.
	 * @see #getFinallyExpression()
	 * @generated
	 */
	void setFinallyExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Catch Clauses</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XCatchClause}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Catch Clauses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catch Clauses</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXTryCatchFinallyExpression_CatchClauses()
	 * @model containment="true"
	 * @generated
	 */
	EList<XCatchClause> getCatchClauses();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XVariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @since 2.18
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXTryCatchFinallyExpression_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<XVariableDeclaration> getResources();

} // XTryCatchFinallyExpression
