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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtend.core.xtend.RichString;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processed Rich String</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.richstring.ProcessedRichString#getRichString <em>Rich String</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.richstring.ProcessedRichString#getLines <em>Lines</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getProcessedRichString()
 * @model
 * @generated
 */
public interface ProcessedRichString extends EObject
{
	/**
	 * Returns the value of the '<em><b>Rich String</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rich String</em>' reference.
	 * @see #setRichString(RichString)
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getProcessedRichString_RichString()
	 * @model
	 * @generated
	 */
	RichString getRichString();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.richstring.ProcessedRichString#getRichString <em>Rich String</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rich String</em>' reference.
	 * @see #getRichString()
	 * @generated
	 */
	void setRichString(RichString value);

	/**
	 * Returns the value of the '<em><b>Lines</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtend.core.richstring.Line}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtend.core.richstring.Line#getRichString <em>Rich String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lines</em>' containment reference list.
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getProcessedRichString_Lines()
	 * @see org.eclipse.xtend.core.richstring.Line#getRichString
	 * @model opposite="richString" containment="true"
	 * @generated
	 */
	EList<Line> getLines();

} // ProcessedRichString
