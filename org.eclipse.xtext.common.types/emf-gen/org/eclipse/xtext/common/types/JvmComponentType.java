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
 * A representation of the model object '<em><b>Jvm Component Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmComponentType#getArrayType <em>Array Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmComponentType()
 * @model abstract="true"
 * @generated
 */
public interface JvmComponentType extends JvmType
{
	/**
	 * Returns the value of the '<em><b>Array Type</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmArrayType#getComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Type</em>' containment reference.
	 * @see #setArrayType(JvmArrayType)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmComponentType_ArrayType()
	 * @see org.eclipse.xtext.common.types.JvmArrayType#getComponentType
	 * @model opposite="componentType" containment="true"
	 * @generated
	 */
	JvmArrayType getArrayType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmComponentType#getArrayType <em>Array Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Array Type</em>' containment reference.
	 * @see #getArrayType()
	 * @generated
	 */
	void setArrayType(JvmArrayType value);

} // JvmComponentType
