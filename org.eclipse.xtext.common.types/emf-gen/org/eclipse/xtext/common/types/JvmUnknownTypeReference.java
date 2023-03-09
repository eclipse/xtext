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
 * A representation of the model object '<em><b>Jvm Unknown Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmUnknownTypeReference#getQualifiedName <em>Qualified Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmUnknownTypeReference()
 * @model
 * @generated
 */
public interface JvmUnknownTypeReference extends JvmTypeReference
{
	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns the known qualified name of the otherwise unresolveable type. May be <code>null</code>.</p>
	 * 
	 * @since 2.4
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmUnknownTypeReference_QualifiedName()
	 * @model transient="true"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmUnknownTypeReference#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @since 2.4
	 * @generated
	 */
	void setQualifiedName(String value);

} // JvmUnknownTypeReference
