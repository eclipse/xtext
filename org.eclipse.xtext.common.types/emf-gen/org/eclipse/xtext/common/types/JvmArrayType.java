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
 * A representation of the model object '<em><b>Jvm Array Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmArrayType#getComponentType <em>Component Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmArrayType()
 * @model
 * @generated
 */
public interface JvmArrayType extends JvmComponentType
{
	/**
	 * Returns the value of the '<em><b>Component Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmComponentType#getArrayType <em>Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Type</em>' container reference.
	 * @see #setComponentType(JvmComponentType)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmArrayType_ComponentType()
	 * @see org.eclipse.xtext.common.types.JvmComponentType#getArrayType
	 * @model opposite="arrayType" transient="false"
	 * @generated
	 */
	JvmComponentType getComponentType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmArrayType#getComponentType <em>Component Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Type</em>' container reference.
	 * @see #getComponentType()
	 * @generated
	 */
	void setComponentType(JvmComponentType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getDimensions();

} // JvmArrayType
