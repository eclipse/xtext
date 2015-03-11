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
 * A representation of the model object '<em><b>Jvm Delegate Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDelegateTypeReference#getDelegate <em>Delegate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmDelegateTypeReference()
 * @model
 * @since 2.1
 * @generated
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface JvmDelegateTypeReference extends JvmTypeReference
{
	/**
	 * Returns the value of the '<em><b>Delegate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delegate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delegate</em>' reference.
	 * @see #setDelegate(JvmTypeReference)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmDelegateTypeReference_Delegate()
	 * @model
	 * @generated
	 */
	JvmTypeReference getDelegate();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmDelegateTypeReference#getDelegate <em>Delegate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delegate</em>' reference.
	 * @see #getDelegate()
	 * @generated
	 */
	void setDelegate(JvmTypeReference value);

} // JvmDelegateTypeReference
