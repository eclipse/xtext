/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.validation.csvalidationtest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.SimpleGroup#getVal1 <em>Val1</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.SimpleGroup#getVal2 <em>Val2</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getSimpleGroup()
 * @model
 * @generated
 */
public interface SimpleGroup extends EObject
{
  /**
   * Returns the value of the '<em><b>Val1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val1</em>' attribute.
   * @see #setVal1(String)
   * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getSimpleGroup_Val1()
   * @model
   * @generated
   */
  String getVal1();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.validation.csvalidationtest.SimpleGroup#getVal1 <em>Val1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val1</em>' attribute.
   * @see #getVal1()
   * @generated
   */
  void setVal1(String value);

  /**
   * Returns the value of the '<em><b>Val2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val2</em>' attribute.
   * @see #setVal2(String)
   * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getSimpleGroup_Val2()
   * @model
   * @generated
   */
  String getVal2();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.validation.csvalidationtest.SimpleGroup#getVal2 <em>Val2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val2</em>' attribute.
   * @see #getVal2()
   * @generated
   */
  void setVal2(String value);

} // SimpleGroup
