/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAbstract While Expression</b></em>'.
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
 *   <li>{@link org.eclipse.xtext.xbase.XAbstractWhileExpression#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XAbstractWhileExpression#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXAbstractWhileExpression()
 * @model abstract="true"
 * @generated
 */
public interface XAbstractWhileExpression extends XExpression
{
	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' containment reference.
	 * @see #setPredicate(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAbstractWhileExpression_Predicate()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getPredicate();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAbstractWhileExpression#getPredicate <em>Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' containment reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(XExpression value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAbstractWhileExpression_Body()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAbstractWhileExpression#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(XExpression value);

} // XAbstractWhileExpression
