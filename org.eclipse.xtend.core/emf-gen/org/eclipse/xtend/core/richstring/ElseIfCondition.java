/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.richstring;

import org.eclipse.xtend.core.xtend.RichStringElseIf;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Else If Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.richstring.ElseIfCondition#getRichStringElseIf <em>Rich String Else If</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.richstring.ElseIfCondition#getIfConditionStart <em>If Condition Start</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getElseIfCondition()
 * @model
 * @generated
 */
public interface ElseIfCondition extends LinePart
{
	/**
	 * Returns the value of the '<em><b>Rich String Else If</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rich String Else If</em>' reference.
	 * @see #setRichStringElseIf(RichStringElseIf)
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getElseIfCondition_RichStringElseIf()
	 * @model
	 * @generated
	 */
	RichStringElseIf getRichStringElseIf();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.richstring.ElseIfCondition#getRichStringElseIf <em>Rich String Else If</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rich String Else If</em>' reference.
	 * @see #getRichStringElseIf()
	 * @generated
	 */
	void setRichStringElseIf(RichStringElseIf value);

	/**
	 * Returns the value of the '<em><b>If Condition Start</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtend.core.richstring.IfConditionStart#getElseIfConditions <em>Else If Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If Condition Start</em>' reference.
	 * @see #setIfConditionStart(IfConditionStart)
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getElseIfCondition_IfConditionStart()
	 * @see org.eclipse.xtend.core.richstring.IfConditionStart#getElseIfConditions
	 * @model opposite="elseIfConditions"
	 * @generated
	 */
	IfConditionStart getIfConditionStart();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.richstring.ElseIfCondition#getIfConditionStart <em>If Condition Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If Condition Start</em>' reference.
	 * @see #getIfConditionStart()
	 * @generated
	 */
	void setIfConditionStart(IfConditionStart value);

} // ElseIfCondition
