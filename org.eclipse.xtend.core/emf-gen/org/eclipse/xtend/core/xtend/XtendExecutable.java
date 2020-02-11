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

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Executable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendExecutable#getExceptions <em>Exceptions</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendExecutable#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendExecutable#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendExecutable#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendExecutable()
 * @model abstract="true"
 * @generated
 */
public interface XtendExecutable extends XtendMember
{
	/**
	 * Returns the value of the '<em><b>Exceptions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exceptions</em>' containment reference list.
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendExecutable_Exceptions()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getExceptions();

	/**
	 * Returns the value of the '<em><b>Type Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Parameters</em>' containment reference list.
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendExecutable_TypeParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeParameter> getTypeParameters();

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(XExpression)
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendExecutable_Expression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.xtend.XtendExecutable#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtend.core.xtend.XtendParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendExecutable_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<XtendParameter> getParameters();

} // XtendExecutable
