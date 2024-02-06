/**
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.enumrules.multiRuleenums;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.enumrules.multiRuleenums.Model#getA <em>A</em>}</li>
 *   <li>{@link org.eclipse.xtext.enumrules.multiRuleenums.Model#getB <em>B</em>}</li>
 *   <li>{@link org.eclipse.xtext.enumrules.multiRuleenums.Model#getC <em>C</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.enumrules.multiRuleenums.MultiRuleenumsPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>A</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.xtext.enumrules.multiRuleenums.MyEnum}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>A</em>' attribute.
   * @see org.eclipse.xtext.enumrules.multiRuleenums.MyEnum
   * @see #setA(MyEnum)
   * @see org.eclipse.xtext.enumrules.multiRuleenums.MultiRuleenumsPackage#getModel_A()
   * @model
   * @generated
   */
  MyEnum getA();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.enumrules.multiRuleenums.Model#getA <em>A</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>A</em>' attribute.
   * @see org.eclipse.xtext.enumrules.multiRuleenums.MyEnum
   * @see #getA()
   * @generated
   */
  void setA(MyEnum value);

  /**
   * Returns the value of the '<em><b>B</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.xtext.enumrules.multiRuleenums.MyEnum}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>B</em>' attribute.
   * @see org.eclipse.xtext.enumrules.multiRuleenums.MyEnum
   * @see #setB(MyEnum)
   * @see org.eclipse.xtext.enumrules.multiRuleenums.MultiRuleenumsPackage#getModel_B()
   * @model
   * @generated
   */
  MyEnum getB();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.enumrules.multiRuleenums.Model#getB <em>B</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>B</em>' attribute.
   * @see org.eclipse.xtext.enumrules.multiRuleenums.MyEnum
   * @see #getB()
   * @generated
   */
  void setB(MyEnum value);

  /**
   * Returns the value of the '<em><b>C</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.xtext.enumrules.multiRuleenums.MyEnum}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>C</em>' attribute.
   * @see org.eclipse.xtext.enumrules.multiRuleenums.MyEnum
   * @see #setC(MyEnum)
   * @see org.eclipse.xtext.enumrules.multiRuleenums.MultiRuleenumsPackage#getModel_C()
   * @model
   * @generated
   */
  MyEnum getC();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.enumrules.multiRuleenums.Model#getC <em>C</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>C</em>' attribute.
   * @see org.eclipse.xtext.enumrules.multiRuleenums.MyEnum
   * @see #getC()
   * @generated
   */
  void setC(MyEnum value);

} // Model
