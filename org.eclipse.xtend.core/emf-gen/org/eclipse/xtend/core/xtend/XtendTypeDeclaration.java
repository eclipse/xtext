/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.xtend;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendTypeDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendTypeDeclaration#getMembers <em>Members</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendTypeDeclaration()
 * @model
 * @generated
 */
public interface XtendTypeDeclaration extends XtendMember
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendTypeDeclaration_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.xtend.XtendTypeDeclaration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtend.core.xtend.XtendMember}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtend.core.xtend.XtendMember#getDeclaringType <em>Declaring Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendTypeDeclaration_Members()
	 * @see org.eclipse.xtend.core.xtend.XtendMember#getDeclaringType
	 * @model opposite="declaringType" containment="true"
	 * @generated
	 */
	EList<XtendMember> getMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isAnonymous();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isLocal();

} // XtendTypeDeclaration
