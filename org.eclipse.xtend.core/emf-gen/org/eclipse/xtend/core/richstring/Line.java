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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.richstring.Line#getParts <em>Parts</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.richstring.Line#getRichString <em>Rich String</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getLine()
 * @model
 * @generated
 */
public interface Line extends EObject
{
	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtend.core.richstring.LinePart}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtend.core.richstring.LinePart#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getLine_Parts()
	 * @see org.eclipse.xtend.core.richstring.LinePart#getLine
	 * @model opposite="line" containment="true"
	 * @generated
	 */
	EList<LinePart> getParts();

	/**
	 * Returns the value of the '<em><b>Rich String</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtend.core.richstring.ProcessedRichString#getLines <em>Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rich String</em>' container reference.
	 * @see #setRichString(ProcessedRichString)
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getLine_RichString()
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichString#getLines
	 * @model opposite="lines" transient="false"
	 * @generated
	 */
	ProcessedRichString getRichString();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.richstring.Line#getRichString <em>Rich String</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rich String</em>' container reference.
	 * @see #getRichString()
	 * @generated
	 */
	void setRichString(ProcessedRichString value);

} // Line
