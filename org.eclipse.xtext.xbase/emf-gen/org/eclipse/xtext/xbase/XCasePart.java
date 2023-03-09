/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XCase Part</b></em>'.
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
 *   <li>{@link org.eclipse.xtext.xbase.XCasePart#getCase <em>Case</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XCasePart#getThen <em>Then</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XCasePart#getTypeGuard <em>Type Guard</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XCasePart#isFallThrough <em>Fall Through</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXCasePart()
 * @model
 * @generated
 */
public interface XCasePart extends EObject
{
	/**
	 * Returns the value of the '<em><b>Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Case</em>' containment reference.
	 * @see #setCase(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXCasePart_Case()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getCase();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XCasePart#getCase <em>Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Case</em>' containment reference.
	 * @see #getCase()
	 * @generated
	 */
	void setCase(XExpression value);

	/**
	 * Returns the value of the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then</em>' containment reference.
	 * @see #setThen(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXCasePart_Then()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getThen();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XCasePart#getThen <em>Then</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then</em>' containment reference.
	 * @see #getThen()
	 * @generated
	 */
	void setThen(XExpression value);

	/**
	 * Returns the value of the '<em><b>Type Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Guard</em>' containment reference.
	 * @see #setTypeGuard(JvmTypeReference)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXCasePart_TypeGuard()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getTypeGuard();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XCasePart#getTypeGuard <em>Type Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Guard</em>' containment reference.
	 * @see #getTypeGuard()
	 * @generated
	 */
	void setTypeGuard(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Fall Through</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fall Through</em>' attribute.
	 * @see #setFallThrough(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXCasePart_FallThrough()
	 * @model
	 * @generated
	 */
	boolean isFallThrough();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XCasePart#isFallThrough <em>Fall Through</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fall Through</em>' attribute.
	 * @see #isFallThrough()
	 * @generated
	 */
	void setFallThrough(boolean value);

} // XCasePart
