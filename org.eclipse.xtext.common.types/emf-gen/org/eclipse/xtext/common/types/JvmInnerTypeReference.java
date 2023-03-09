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
 * A representation of the model object '<em><b>Jvm Inner Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmInnerTypeReference#getOuter <em>Outer</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmInnerTypeReference()
 * @model
 * @generated
 */
public interface JvmInnerTypeReference extends JvmParameterizedTypeReference
{
	/**
	 * Returns the value of the '<em><b>Outer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer</em>' containment reference.
	 * @see #setOuter(JvmParameterizedTypeReference)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmInnerTypeReference_Outer()
	 * @model containment="true"
	 * @generated
	 */
	JvmParameterizedTypeReference getOuter();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmInnerTypeReference#getOuter <em>Outer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer</em>' containment reference.
	 * @see #getOuter()
	 * @generated
	 */
	void setOuter(JvmParameterizedTypeReference value);

} // JvmInnerTypeReference
