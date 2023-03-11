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
 * A representation of the model object '<em><b>For Loop End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.richstring.ForLoopEnd#getStart <em>Start</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getForLoopEnd()
 * @model
 * @generated
 */
public interface ForLoopEnd extends LinePart
{
	/**
	 * Returns the value of the '<em><b>Start</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtend.core.richstring.ForLoopStart#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' reference.
	 * @see #setStart(ForLoopStart)
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#getForLoopEnd_Start()
	 * @see org.eclipse.xtend.core.richstring.ForLoopStart#getEnd
	 * @model opposite="end"
	 * @generated
	 */
	ForLoopStart getStart();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.richstring.ForLoopEnd#getStart <em>Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' reference.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(ForLoopStart value);

} // ForLoopEnd
