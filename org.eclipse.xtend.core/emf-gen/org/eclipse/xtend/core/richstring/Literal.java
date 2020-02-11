/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.richstring;

import org.eclipse.xtend.core.xtend.RichStringLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.richstring.Literal#getLiteral <em>Literal</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.richstring.Literal#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.richstring.Literal#getLength <em>Length</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getLiteral()
 * @model
 * @generated
 */
public interface Literal extends LinePart
{
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' reference.
	 * @see #setLiteral(RichStringLiteral)
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getLiteral_Literal()
	 * @model
	 * @generated
	 */
	RichStringLiteral getLiteral();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.richstring.Literal#getLiteral <em>Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' reference.
	 * @see #getLiteral()
	 * @generated
	 */
	void setLiteral(RichStringLiteral value);

	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(int)
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getLiteral_Offset()
	 * @model
	 * @generated
	 */
	int getOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.richstring.Literal#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(int value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(int)
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getLiteral_Length()
	 * @model
	 * @generated
	 */
	int getLength();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.richstring.Literal#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(int value);

} // Literal
