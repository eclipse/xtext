/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmMember#getDeclaringType <em>Declaring Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmMember#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmMember#getSimpleName <em>Simple Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmMember#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmMember#isDeprecated <em>Deprecated</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmMember()
 * @model abstract="true"
 * @generated
 */
public interface JvmMember extends JvmAnnotationTarget
{
	/**
	 * Returns the value of the '<em><b>Declaring Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmDeclaredType#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmMember_Identifier()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Returns the value of the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deprecated</em>' attribute.
	 * @see #isSetDeprecated()
	 * @see #unsetDeprecated()
	 * @see #setDeprecated(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmMember_Deprecated()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isDeprecated();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmMember#isDeprecated <em>Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deprecated</em>' attribute.
	 * @see #isSetDeprecated()
	 * @see #unsetDeprecated()
	 * @see #isDeprecated()
	 * @generated
	 */
	void setDeprecated(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.xtext.common.types.JvmMember#isDeprecated <em>Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDeprecated()
	 * @see #isDeprecated()
	 * @see #setDeprecated(boolean)
	 * @generated
	 */
	void unsetDeprecated();

	/**
	 * Returns whether the value of the '{@link org.eclipse.xtext.common.types.JvmMember#isDeprecated <em>Deprecated</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Deprecated</em>' attribute is set.
	 * @see #unsetDeprecated()
	 * @see #isDeprecated()
	 * @see #setDeprecated(boolean)
	 * @generated
	 */
	boolean isSetDeprecated();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void internalSetIdentifier(String identifier);

} // JvmMember
