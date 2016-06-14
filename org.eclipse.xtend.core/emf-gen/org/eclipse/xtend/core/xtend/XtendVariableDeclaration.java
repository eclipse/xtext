/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	 * <p>
	 * If the meaning of the '<em>Extension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
