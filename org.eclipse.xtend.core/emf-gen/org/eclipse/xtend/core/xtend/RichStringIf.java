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

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rich String If</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.RichStringIf#getIf <em>If</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.RichStringIf#getThen <em>Then</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.RichStringIf#getElseIfs <em>Else Ifs</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.RichStringIf#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtend.core.xtend.XtendPackage#getRichStringIf()
 * @model
 * @generated
 */
public interface RichStringIf extends XExpression
{
	/**
	 * Returns the value of the '<em><b>If</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If</em>' containment reference.
	 * @see #setIf(XExpression)
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getRichStringIf_If()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getIf();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.xtend.RichStringIf#getIf <em>If</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If</em>' containment reference.
	 * @see #getIf()
	 * @generated
	 */
	void setIf(XExpression value);

	/**
	 * Returns the value of the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then</em>' containment reference.
	 * @see #setThen(XExpression)
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getRichStringIf_Then()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getThen();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.xtend.RichStringIf#getThen <em>Then</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then</em>' containment reference.
	 * @see #getThen()
	 * @generated
	 */
	void setThen(XExpression value);

	/**
	 * Returns the value of the '<em><b>Else Ifs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtend.core.xtend.RichStringElseIf}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Ifs</em>' containment reference list.
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getRichStringIf_ElseIfs()
	 * @model containment="true"
	 * @generated
	 */
	EList<RichStringElseIf> getElseIfs();

	/**
	 * Returns the value of the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else</em>' containment reference.
	 * @see #setElse(XExpression)
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getRichStringIf_Else()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getElse();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.xtend.RichStringIf#getElse <em>Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else</em>' containment reference.
	 * @see #getElse()
	 * @generated
	 */
	void setElse(XExpression value);

} // RichStringIf
