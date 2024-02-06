/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parsetree.transientvalues.transientvaluestest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestList#getItem <em>Item</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TransientvaluestestPackage#getTestList()
 * @model
 * @generated
 */
public interface TestList extends Root
{
  /**
   * Returns the value of the '<em><b>Item</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Item</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TransientvaluestestPackage#getTestList_Item()
   * @model unique="false"
   * @generated
   */
  EList<Integer> getItem();

} // TestList
