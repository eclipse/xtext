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
 * A representation of the model object '<em><b>Type Variable Declarator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.TypeVariableDeclarator#getTypeVariables <em>Type Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getTypeVariableDeclarator()
 * @model abstract="true"
 * @generated
 */
public interface TypeVariableDeclarator extends IdentifyableElement {
	/**
	 * Returns the value of the '<em><b>Type Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.TypeVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Variables</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getTypeVariableDeclarator_TypeVariables()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeVariable> getTypeVariables();

} // TypeVariableDeclarator
