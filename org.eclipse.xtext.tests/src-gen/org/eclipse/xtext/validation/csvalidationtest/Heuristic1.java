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
 * A representation of the model object '<em><b>Heuristic1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.Heuristic1#getA <em>A</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.Heuristic1#getB <em>B</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.Heuristic1#getC <em>C</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getHeuristic1()
 * @model
 * @generated
 */
public interface Heuristic1 extends EObject
{
  /**
   * Returns the value of the '<em><b>A</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>A</em>' attribute list.
   * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getHeuristic1_A()
   * @model unique="false"
   * @generated
   */
  EList<String> getA();

  /**
   * Returns the value of the '<em><b>B</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>B</em>' attribute list.
   * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getHeuristic1_B()
   * @model unique="false"
   * @generated
   */
  EList<String> getB();

  /**
   * Returns the value of the '<em><b>C</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>C</em>' attribute list.
   * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getHeuristic1_C()
   * @model unique="false"
   * @generated
   */
  EList<String> getC();

} // Heuristic1
