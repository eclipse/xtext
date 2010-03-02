/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Executable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmExecutable#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmExecutable#getExceptions <em>Exceptions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmExecutable()
 * @model abstract="true"
 * @generated
 */
public interface JvmExecutable extends JvmMember, JvmTypeParameterDeclarator {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmFormalParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmExecutable_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmFormalParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Exceptions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exceptions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exceptions</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmExecutable_Exceptions()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getExceptions();

} // Executable
