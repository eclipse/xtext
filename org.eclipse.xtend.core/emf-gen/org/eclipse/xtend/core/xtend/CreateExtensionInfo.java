/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.xtend;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Extension Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.CreateExtensionInfo#getCreateExpression <em>Create Expression</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.CreateExtensionInfo#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtend.core.xtend.XtendPackage#getCreateExtensionInfo()
 * @model
 * @generated
 */
public interface CreateExtensionInfo extends EObject
{
	/**
	 * Returns the value of the '<em><b>Create Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create Expression</em>' containment reference.
	 * @see #setCreateExpression(XExpression)
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getCreateExtensionInfo_CreateExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getCreateExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.xtend.CreateExtensionInfo#getCreateExpression <em>Create Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Expression</em>' containment reference.
	 * @see #getCreateExpression()
	 * @generated
	 */
	void setCreateExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"it"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getCreateExtensionInfo_Name()
	 * @model default="it"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.xtend.CreateExtensionInfo#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // CreateExtensionInfo
