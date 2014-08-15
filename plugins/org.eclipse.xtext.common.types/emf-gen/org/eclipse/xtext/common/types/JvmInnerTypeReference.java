/**
 * Copyright (c) 2011-2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.common.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Inner Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmInnerTypeReference#getOuter <em>Outer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmInnerTypeReference()
 * @model
 * @generated
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 2.7
 */
public interface JvmInnerTypeReference extends JvmParameterizedTypeReference
{
	/**
	 * Returns the value of the '<em><b>Outer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
