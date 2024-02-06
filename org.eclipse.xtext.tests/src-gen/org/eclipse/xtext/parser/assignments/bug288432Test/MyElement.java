/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.assignments.bug288432Test;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>My Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.assignments.bug288432Test.MyElement#getBar <em>Bar</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestPackage#getMyElement()
 * @model
 * @generated
 */
public interface MyElement extends Content
{
  /**
   * Returns the value of the '<em><b>Bar</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bar</em>' containment reference.
   * @see #setBar(ParameterObject)
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestPackage#getMyElement_Bar()
   * @model containment="true"
   * @generated
   */
  ParameterObject getBar();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.MyElement#getBar <em>Bar</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bar</em>' containment reference.
   * @see #getBar()
   * @generated
   */
  void setBar(ParameterObject value);

} // MyElement
