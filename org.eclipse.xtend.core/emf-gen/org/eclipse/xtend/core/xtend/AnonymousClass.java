/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.xtend;

import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Anonymous Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.AnonymousClass#getConstructorCall <em>Constructor Call</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtend.core.xtend.XtendPackage#getAnonymousClass()
 * @model
 * @generated
 */
public interface AnonymousClass extends XExpression, XtendTypeDeclaration
{
	/**
	 * Returns the value of the '<em><b>Constructor Call</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constructor Call</em>' containment reference.
	 * @see #setConstructorCall(XConstructorCall)
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getAnonymousClass_ConstructorCall()
	 * @model containment="true"
	 * @generated
	 */
	XConstructorCall getConstructorCall();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.xtend.AnonymousClass#getConstructorCall <em>Constructor Call</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constructor Call</em>' containment reference.
	 * @see #getConstructorCall()
	 * @generated
	 */
	void setConstructorCall(XConstructorCall value);

} // AnonymousClass
