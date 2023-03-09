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
 * A representation of the model object '<em><b>XIf Expression</b></em>'.
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
 *   <li>{@link org.eclipse.xtext.xbase.XIfExpression#getIf <em>If</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XIfExpression#getThen <em>Then</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XIfExpression#getElse <em>Else</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XIfExpression#isConditionalExpression <em>Conditional Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXIfExpression()
 * @model
 * @generated
 */
public interface XIfExpression extends XExpression
{
	/**
	 * Returns the value of the '<em><b>If</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If</em>' containment reference.
	 * @see #setIf(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXIfExpression_If()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getIf();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XIfExpression#getIf <em>If</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If</em>' containment reference.
	 * @see #getIf()
	 * @generated
	 */
	void setIf(XExpression value);

	/**
	 * Returns the value of the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then</em>' containment reference.
	 * @see #setThen(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXIfExpression_Then()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getThen();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XIfExpression#getThen <em>Then</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then</em>' containment reference.
	 * @see #getThen()
	 * @generated
	 */
	void setThen(XExpression value);

	/**
	 * Returns the value of the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else</em>' containment reference.
	 * @see #setElse(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXIfExpression_Else()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getElse();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XIfExpression#getElse <em>Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else</em>' containment reference.
	 * @see #getElse()
	 * @generated
	 */
	void setElse(XExpression value);

	/**
	 * Returns the value of the '<em><b>Conditional Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @since 2.18
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Conditional Expression</em>' attribute.
	 * @see #setConditionalExpression(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXIfExpression_ConditionalExpression()
	 * @model
	 * @generated
	 */
	boolean isConditionalExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XIfExpression#isConditionalExpression <em>Conditional Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conditional Expression</em>' attribute.
	 * @see #isConditionalExpression()
	 * @since 2.18
	 * @generated
	 */
	void setConditionalExpression(boolean value);

} // XIfExpression
