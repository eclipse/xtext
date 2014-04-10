/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.xtend;

import org.eclipse.xtext.xbase.XConstructorCall;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constructor Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendConstructorCall#getAnonymousClass <em>Anonymous Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendConstructorCall()
 * @model
 * @generated
 */
public interface XtendConstructorCall extends XConstructorCall
{
	/**
	 * Returns the value of the '<em><b>Anonymous Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anonymous Class</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anonymous Class</em>' containment reference.
	 * @see #setAnonymousClass(XtendClass)
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendConstructorCall_AnonymousClass()
	 * @model containment="true"
	 * @generated
	 */
	XtendClass getAnonymousClass();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.xtend.XtendConstructorCall#getAnonymousClass <em>Anonymous Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Anonymous Class</em>' containment reference.
	 * @see #getAnonymousClass()
	 * @generated
	 */
	void setAnonymousClass(XtendClass value);

} // XtendConstructorCall
