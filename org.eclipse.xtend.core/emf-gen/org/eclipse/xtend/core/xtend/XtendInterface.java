/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.xtend;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendInterface#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendInterface#getTypeParameters <em>Type Parameters</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendInterface()
 * @model
 * @generated
 */
public interface XtendInterface extends XtendTypeDeclaration
{
	/**
	 * Returns the value of the '<em><b>Extends</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' containment reference list.
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendInterface_Extends()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getExtends();

	/**
	 * Returns the value of the '<em><b>Type Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Parameters</em>' containment reference list.
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendInterface_TypeParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeParameter> getTypeParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isStrictFloatingPoint();

} // XtendInterface
