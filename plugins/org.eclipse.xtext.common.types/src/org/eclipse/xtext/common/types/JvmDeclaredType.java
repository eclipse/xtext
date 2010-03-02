/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declared Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmDeclaredType()
 * @model abstract="true"
 * @generated
 */
public interface JvmDeclaredType extends JvmComponentType, JvmMember {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getPackageName();

	/**
	 * Returns the value of the '<em><b>Super Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Types</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmDeclaredType_SuperTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getSuperTypes();

	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmMember}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmMember#getDeclaringType <em>Declaring Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmDeclaredType_Members()
	 * @see org.eclipse.xtext.common.types.JvmMember#getDeclaringType
	 * @model opposite="declaringType" containment="true"
	 * @generated
	 */
	EList<JvmMember> getMembers();

} // DeclaredType
