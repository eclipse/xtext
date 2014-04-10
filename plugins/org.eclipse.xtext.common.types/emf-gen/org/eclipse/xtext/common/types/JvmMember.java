/**
 * Copyright (c) 2011-2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.common.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmMember#getDeclaringMember <em>Declaring Member</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmMember#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmMember#getSimpleName <em>Simple Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmMember#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmMember#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmMember()
 * @model abstract="true"
 * @noimplement
 * @generated
 */
public interface JvmMember extends JvmAnnotationTarget
{
	/**
	 * Returns the value of the '<em><b>Declaring Member</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmMember#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaring Member</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaring Member</em>' container reference.
	 * @see #setDeclaringMember(JvmMember)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmMember_DeclaringMember()
	 * @see org.eclipse.xtext.common.types.JvmMember#getMembers
	 * @model opposite="members" transient="false"
	 * @generated
	 * @since 2.6
	 */
	JvmMember getDeclaringMember();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmMember#getDeclaringMember <em>Declaring Member</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaring Member</em>' container reference.
	 * @see #getDeclaringMember()
	 * @generated
	 * @since 2.6
	 */
	void setDeclaringMember(JvmMember value);

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
	 * Returns the value of the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Name</em>' attribute.
	 * @see #setSimpleName(String)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmMember_SimpleName()
	 * @model
	 * @generated
	 */
	String getSimpleName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmMember#getSimpleName <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name</em>' attribute.
	 * @see #getSimpleName()
	 * @generated
	 */
	void setSimpleName(String value);

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmMember_Identifier()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmMember}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmMember#getDeclaringMember <em>Declaring Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmMember_Members()
	 * @see org.eclipse.xtext.common.types.JvmMember#getDeclaringMember
	 * @model opposite="declaringMember" containment="true"
	 * @generated
	 * @since 2.6
	 */
	EList<JvmMember> getMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void internalSetIdentifier(String identifier);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	JvmDeclaredType getDeclaringType();

} // JvmMember
