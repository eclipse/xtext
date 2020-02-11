/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.xtend;

import org.eclipse.xtext.xbase.XVariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendVariableDeclaration#isExtension <em>Extension</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendVariableDeclaration()
 * @model
 * @generated
 */
public interface XtendVariableDeclaration extends XVariableDeclaration
{
	/**
	 * Returns the value of the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' attribute.
	 * @see #setExtension(boolean)
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendVariableDeclaration_Extension()
	 * @model
	 * @generated
	 */
	boolean isExtension();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.xtend.XtendVariableDeclaration#isExtension <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' attribute.
	 * @see #isExtension()
	 * @generated
	 */
	void setExtension(boolean value);

} // XtendVariableDeclaration
