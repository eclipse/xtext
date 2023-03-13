/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.richstring;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtend.core.xtend.RichStringIf;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Condition Start</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.richstring.IfConditionStart#getRichStringIf <em>Rich String If</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.richstring.IfConditionStart#getElseStart <em>Else Start</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.richstring.IfConditionStart#getElseIfConditions <em>Else If Conditions</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.richstring.IfConditionStart#getEndIf <em>End If</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getIfConditionStart()
 * @model
 * @generated
 */
public interface IfConditionStart extends LinePart
{
	/**
	 * Returns the value of the '<em><b>Rich String If</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rich String If</em>' reference.
	 * @see #setRichStringIf(RichStringIf)
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getIfConditionStart_RichStringIf()
	 * @model
	 * @generated
	 */
	RichStringIf getRichStringIf();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.richstring.IfConditionStart#getRichStringIf <em>Rich String If</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rich String If</em>' reference.
	 * @see #getRichStringIf()
	 * @generated
	 */
	void setRichStringIf(RichStringIf value);

	/**
	 * Returns the value of the '<em><b>Else Start</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtend.core.richstring.ElseStart#getIfConditionStart <em>If Condition Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Start</em>' reference.
	 * @see #setElseStart(ElseStart)
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getIfConditionStart_ElseStart()
	 * @see org.eclipse.xtend.core.richstring.ElseStart#getIfConditionStart
	 * @model opposite="ifConditionStart"
	 * @generated
	 */
	ElseStart getElseStart();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.richstring.IfConditionStart#getElseStart <em>Else Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Start</em>' reference.
	 * @see #getElseStart()
	 * @generated
	 */
	void setElseStart(ElseStart value);

	/**
	 * Returns the value of the '<em><b>Else If Conditions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.xtend.core.richstring.ElseIfCondition}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtend.core.richstring.ElseIfCondition#getIfConditionStart <em>If Condition Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else If Conditions</em>' reference list.
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getIfConditionStart_ElseIfConditions()
	 * @see org.eclipse.xtend.core.richstring.ElseIfCondition#getIfConditionStart
	 * @model opposite="ifConditionStart"
	 * @generated
	 */
	EList<ElseIfCondition> getElseIfConditions();

	/**
	 * Returns the value of the '<em><b>End If</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End If</em>' reference.
	 * @see #setEndIf(EndIf)
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getIfConditionStart_EndIf()
	 * @model
	 * @generated
	 */
	EndIf getEndIf();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.richstring.IfConditionStart#getEndIf <em>End If</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End If</em>' reference.
	 * @see #getEndIf()
	 * @generated
	 */
	void setEndIf(EndIf value);

} // IfConditionStart
