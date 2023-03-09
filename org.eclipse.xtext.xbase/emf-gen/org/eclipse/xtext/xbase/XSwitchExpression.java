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

import org.eclipse.xtext.common.types.JvmFormalParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XSwitch Expression</b></em>'.
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
 *   <li>{@link org.eclipse.xtext.xbase.XSwitchExpression#getSwitch <em>Switch</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XSwitchExpression#getCases <em>Cases</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XSwitchExpression#getDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XSwitchExpression#getDeclaredParam <em>Declared Param</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXSwitchExpression()
 * @model
 * @generated
 */
public interface XSwitchExpression extends XExpression
{
	/**
	 * Returns the value of the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Switch</em>' containment reference.
	 * @see #setSwitch(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXSwitchExpression_Switch()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getSwitch();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XSwitchExpression#getSwitch <em>Switch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Switch</em>' containment reference.
	 * @see #getSwitch()
	 * @generated
	 */
	void setSwitch(XExpression value);

	/**
	 * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XCasePart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cases</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXSwitchExpression_Cases()
	 * @model containment="true"
	 * @generated
	 */
	EList<XCasePart> getCases();

	/**
	 * Returns the value of the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' containment reference.
	 * @see #setDefault(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXSwitchExpression_Default()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XSwitchExpression#getDefault <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' containment reference.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(XExpression value);

	/**
	 * Returns the value of the '<em><b>Declared Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Param</em>' containment reference.
	 * @see #setDeclaredParam(JvmFormalParameter)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXSwitchExpression_DeclaredParam()
	 * @model containment="true"
	 * @generated
	 */
	JvmFormalParameter getDeclaredParam();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XSwitchExpression#getDeclaredParam <em>Declared Param</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declared Param</em>' containment reference.
	 * @see #getDeclaredParam()
	 * @generated
	 */
	void setDeclaredParam(JvmFormalParameter value);

} // XSwitchExpression
