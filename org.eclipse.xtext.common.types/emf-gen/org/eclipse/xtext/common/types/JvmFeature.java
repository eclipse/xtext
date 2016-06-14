/**
 * Copyright (c) 2011-2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmFeature#getLocalClasses <em>Local Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmFeature()
 * @model abstract="true"
 * @generated
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface JvmFeature extends JvmMember
{
	/**
	 * Returns the value of the '<em><b>Local Classes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmGenericType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Classes</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmFeature_LocalClasses()
	 * @model containment="true"
	 * @generated
	 * @since 2.6
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
