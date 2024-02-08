/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.validation.csvalidationtest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Combination4</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.Combination4#getVal1 <em>Val1</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.Combination4#getVal2 <em>Val2</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.Combination4#getVal3 <em>Val3</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getCombination4()
 * @model
 * @generated
 */
public interface Combination4 extends EObject
{
  /**
   * Returns the value of the '<em><b>Val1</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val1</em>' attribute list.
   * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getCombination4_Val1()
   * @model unique="false"
   * @generated
   */
  EList<String> getVal1();

  /**
   * Returns the value of the '<em><b>Val2</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val2</em>' attribute list.
   * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getCombination4_Val2()
   * @model unique="false"
   * @generated
   */
  EList<String> getVal2();

  /**
   * Returns the value of the '<em><b>Val3</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val3</em>' attribute list.
   * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getCombination4_Val3()
   * @model unique="false"
   * @generated
   */
  EList<String> getVal3();

} // Combination4
