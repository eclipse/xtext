/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.serializer.contextFinderTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parent Ref Test1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest1#getChild1 <em>Child1</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage#getParentRefTest1()
 * @model
 * @generated
 */
public interface ParentRefTest1 extends EObject
{
  /**
   * Returns the value of the '<em><b>Child1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Child1</em>' containment reference.
   * @see #setChild1(ParentRefTestChild)
   * @see org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage#getParentRefTest1_Child1()
   * @model containment="true"
   * @generated
   */
  ParentRefTestChild getChild1();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest1#getChild1 <em>Child1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Child1</em>' containment reference.
   * @see #getChild1()
   * @generated
   */
  void setChild1(ParentRefTestChild value);

} // ParentRefTest1
