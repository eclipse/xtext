/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Parameter Declarator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmTypeParameterDeclarator#getTypeParameters <em>Type Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmTypeParameterDeclarator()
 * @model abstract="true"
 * @generated
 */
public interface JvmTypeParameterDeclarator extends EObject {
	/**
	 * Returns the value of the '<em><b>Type Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeParameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmTypeParameter#getDeclarator <em>Declarator</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Parameters</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmTypeParameterDeclarator_TypeParameters()
	 * @see org.eclipse.xtext.common.types.JvmTypeParameter#getDeclarator
	 * @model opposite="declarator" containment="true"
	 * @generated
	 */
	EList<JvmTypeParameter> getTypeParameters();

} // TypeParameterDeclarator
