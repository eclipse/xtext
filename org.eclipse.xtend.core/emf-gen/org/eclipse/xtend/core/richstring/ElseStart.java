/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.richstring;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Else Start</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.richstring.ElseStart#getIfConditionStart <em>If Condition Start</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getElseStart()
 * @model
 * @generated
 */
public interface ElseStart extends LinePart
{
	/**
	 * Returns the value of the '<em><b>If Condition Start</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtend.core.richstring.IfConditionStart#getElseStart <em>Else Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If Condition Start</em>' reference.
	 * @see #setIfConditionStart(IfConditionStart)
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getElseStart_IfConditionStart()
	 * @see org.eclipse.xtend.core.richstring.IfConditionStart#getElseStart
	 * @model opposite="elseStart"
	 * @generated
	 */
	IfConditionStart getIfConditionStart();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.richstring.ElseStart#getIfConditionStart <em>If Condition Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If Condition Start</em>' reference.
	 * @see #getIfConditionStart()
	 * @generated
	 */
	void setIfConditionStart(IfConditionStart value);

} // ElseStart
