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
 * A representation of the model object '<em><b>Jvm Specialized Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmSpecializedTypeReference#getEquivalent <em>Equivalent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmSpecializedTypeReference()
 * @model abstract="true"
 * @since 2.1
 * @generated
 */
public interface JvmSpecializedTypeReference extends JvmTypeReference
{
	/**
	 * Returns the value of the '<em><b>Equivalent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equivalent</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equivalent</em>' containment reference.
	 * @see #setEquivalent(JvmTypeReference)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmSpecializedTypeReference_Equivalent()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getEquivalent();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmSpecializedTypeReference#getEquivalent <em>Equivalent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Equivalent</em>' containment reference.
	 * @see #getEquivalent()
	 * @generated
	 */
	void setEquivalent(JvmTypeReference value);

} // JvmSpecializedTypeReference
