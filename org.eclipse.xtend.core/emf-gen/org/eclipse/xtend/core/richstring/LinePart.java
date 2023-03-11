/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.richstring;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Line Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.richstring.LinePart#getLine <em>Line</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getLinePart()
 * @model
 * @generated
 */
public interface LinePart extends EObject
{
	/**
	 * Returns the value of the '<em><b>Line</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtend.core.richstring.Line#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line</em>' container reference.
	 * @see #setLine(Line)
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getLinePart_Line()
	 * @see org.eclipse.xtend.core.richstring.Line#getParts
	 * @model opposite="parts" transient="false"
	 * @generated
	 */
	Line getLine();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.richstring.LinePart#getLine <em>Line</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line</em>' container reference.
	 * @see #getLine()
	 * @generated
	 */
	void setLine(Line value);

} // LinePart
