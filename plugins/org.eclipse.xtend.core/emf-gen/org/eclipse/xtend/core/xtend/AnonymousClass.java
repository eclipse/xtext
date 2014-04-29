/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.AnonymousClass#getConstructorCall <em>Constructor Call</em>}</li>
 * </ul>
 * </p>
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
	 * <p>
	 * If the meaning of the '<em>Constructor Call</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
