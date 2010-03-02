/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Type Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmReferenceTypeArgument#getTypeReference <em>Type Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmReferenceTypeArgument()
 * @model
 * @generated
 */
public interface JvmReferenceTypeArgument extends JvmTypeArgument {
	/**
	 * Returns the value of the '<em><b>Type Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Reference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Reference</em>' containment reference.
	 * @see #setTypeReference(JvmTypeReference)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmReferenceTypeArgument_TypeReference()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getTypeReference();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmReferenceTypeArgument#getTypeReference <em>Type Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Reference</em>' containment reference.
	 * @see #getTypeReference()
	 * @generated
	 */
	void setTypeReference(JvmTypeReference value);

} // ReferenceTypeArgument
