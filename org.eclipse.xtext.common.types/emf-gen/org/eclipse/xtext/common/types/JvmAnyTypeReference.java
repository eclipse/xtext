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
 * A representation of the model object '<em><b>Jvm Any Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmAnyTypeReference#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmAnyTypeReference()
 * @model
 * @generated
 */
public interface JvmAnyTypeReference extends JvmTypeReference
{
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(JvmType)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmAnyTypeReference_Type()
	 * @model
	 * @generated
	 */
	JvmType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmAnyTypeReference#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JvmType value);

} // JvmAnyTypeReference
