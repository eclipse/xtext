/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmMember#getDeclaringType <em>Declaring Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmMember#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmMember#getFullyQualifiedName <em>Fully Qualified Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmMember()
 * @model abstract="true"
 * @generated
 */
public interface JvmMember extends JvmAnnotationTarget, JvmIdentifyableElement {

	/**
	 * Returns the value of the '<em><b>Declaring Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmDeclaredType#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaring Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaring Type</em>' container reference.
	 * @see #setDeclaringType(JvmDeclaredType)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmMember_DeclaringType()
	 * @see org.eclipse.xtext.common.types.JvmDeclaredType#getMembers
	 * @model opposite="members" transient="false"
	 * @generated
	 */
	JvmDeclaredType getDeclaringType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmMember#getDeclaringType <em>Declaring Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaring Type</em>' container reference.
	 * @see #getDeclaringType()
	 * @generated
	 */
	void setDeclaringType(JvmDeclaredType value);

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.xtext.common.types.JvmVisibility}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see org.eclipse.xtext.common.types.JvmVisibility
	 * @see #setVisibility(JvmVisibility)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmMember_Visibility()
	 * @model
	 * @generated
	 */
	JvmVisibility getVisibility();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmMember#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see org.eclipse.xtext.common.types.JvmVisibility
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(JvmVisibility value);

	/**
	 * Returns the value of the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fully Qualified Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fully Qualified Name</em>' attribute.
	 * @see #setFullyQualifiedName(String)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmMember_FullyQualifiedName()
	 * @model
	 * @generated
	 */
	String getFullyQualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmMember#getFullyQualifiedName <em>Fully Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fully Qualified Name</em>' attribute.
	 * @see #getFullyQualifiedName()
	 * @generated
	 */
	void setFullyQualifiedName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getSimpleName();
} // Member
