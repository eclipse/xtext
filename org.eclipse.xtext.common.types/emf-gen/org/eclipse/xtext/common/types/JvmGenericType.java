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
 * A representation of the model object '<em><b>Jvm Generic Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmGenericType#isInterface <em>Interface</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmGenericType#isStrictFloatingPoint <em>Strict Floating Point</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmGenericType#isAnonymous <em>Anonymous</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmGenericType()
 * @model
 * @generated
 */
public interface JvmGenericType extends JvmDeclaredType, JvmTypeParameterDeclarator
{
	/**
	 * Returns the value of the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' attribute.
	 * @see #setInterface(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmGenericType_Interface()
	 * @model
	 * @generated
	 */
	boolean isInterface();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmGenericType#isInterface <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' attribute.
	 * @see #isInterface()
	 * @generated
	 */
	void setInterface(boolean value);

	/**
	 * Returns the value of the '<em><b>Strict Floating Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strict Floating Point</em>' attribute.
	 * @see #setStrictFloatingPoint(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmGenericType_StrictFloatingPoint()
	 * @model
	 * @generated
	 */
	boolean isStrictFloatingPoint();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmGenericType#isStrictFloatingPoint <em>Strict Floating Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strict Floating Point</em>' attribute.
	 * @see #isStrictFloatingPoint()
	 * @generated
	 */
	void setStrictFloatingPoint(boolean value);

	/**
	 * Returns the value of the '<em><b>Anonymous</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anonymous</em>' attribute.
	 * @see #setAnonymous(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmGenericType_Anonymous()
	 * @model
	 * @generated
	 */
	boolean isAnonymous();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmGenericType#isAnonymous <em>Anonymous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Anonymous</em>' attribute.
	 * @see #isAnonymous()
	 * @generated
	 */
	void setAnonymous(boolean value);

} // JvmGenericType
