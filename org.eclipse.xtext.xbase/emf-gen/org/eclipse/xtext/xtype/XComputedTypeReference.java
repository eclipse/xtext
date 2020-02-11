/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtype;

import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;

import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XComputed Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * @since 2.7
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtype.XComputedTypeReference#getTypeProvider <em>Type Provider</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xtype.XtypePackage#getXComputedTypeReference()
 * @model
 * @generated
 */
public interface XComputedTypeReference extends JvmSpecializedTypeReference
{
	/**
	 * Returns the value of the '<em><b>Type Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Provider</em>' attribute.
	 * @see #setTypeProvider(IJvmTypeReferenceProvider)
	 * @see org.eclipse.xtext.xtype.XtypePackage#getXComputedTypeReference_TypeProvider()
	 * @model dataType="org.eclipse.xtext.xtype.IJvmTypeReferenceProvider" transient="true"
	 * @generated
	 */
	IJvmTypeReferenceProvider getTypeProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtype.XComputedTypeReference#getTypeProvider <em>Type Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Provider</em>' attribute.
	 * @see #getTypeProvider()
	 * @generated
	 */
	void setTypeProvider(IJvmTypeReferenceProvider value);

} // XComputedTypeReference
