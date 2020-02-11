/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmFeature#getLocalClasses <em>Local Classes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmFeature()
 * @model abstract="true"
 * @generated
 */
public interface JvmFeature extends JvmMember
{
	/**
	 * Returns the value of the '<em><b>Local Classes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmGenericType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Classes</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmFeature_LocalClasses()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmGenericType> getLocalClasses();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns <code>true</code> if the feature is a static field or static operation.</p>
	 * 
	 * @since 2.4
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isStatic();

} // JvmFeature
