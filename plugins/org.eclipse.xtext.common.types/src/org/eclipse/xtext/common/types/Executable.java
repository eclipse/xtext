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
 *   <li>{@link org.eclipse.xtext.common.types.Executable#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.Executable#getExceptions <em>Exceptions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getExecutable()
 * @model abstract="true"
 * @generated
 */
public interface Executable extends Member, TypeParameterDeclarator {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.FormalParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getExecutable_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<FormalParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Exceptions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exceptions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exceptions</em>' reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getExecutable_Exceptions()
	 * @model
	 * @generated
	 */
	EList<Type> getExceptions();

} // Executable
