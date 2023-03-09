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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Type Parameter Declarator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmTypeParameterDeclarator#getTypeParameters <em>Type Parameters</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmTypeParameterDeclarator()
 * @model abstract="true"
 * @generated
 */
public interface JvmTypeParameterDeclarator extends EObject
{
	/**
	 * Returns the value of the '<em><b>Type Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeParameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmTypeParameter#getDeclarator <em>Declarator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Parameters</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmTypeParameterDeclarator_TypeParameters()
	 * @see org.eclipse.xtext.common.types.JvmTypeParameter#getDeclarator
	 * @model opposite="declarator" containment="true"
	 * @generated
	 */
	EList<JvmTypeParameter> getTypeParameters();

} // JvmTypeParameterDeclarator
