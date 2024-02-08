/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.grammarinheritance.inheritanceTest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.grammarinheritance.inheritanceTest.Model#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.grammarinheritance.inheritanceTest.InheritanceTestPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends org.eclipse.xtext.grammarinheritance.baseInheritanceTest.Model
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.grammarinheritance.inheritanceTest.Element}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.eclipse.xtext.grammarinheritance.inheritanceTest.InheritanceTestPackage#getModel_Elements()
   * @model containment="true"
   * @generated
   */
  EList<Element> getElements();

} // Model
