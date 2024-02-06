/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.actionLang3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>P3</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.actionLang3.P3#getP <em>P</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.actionLang3.P3#getI <em>I</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.actionLang3.ActionLang3Package#getP3()
 * @model
 * @generated
 */
public interface P3 extends ProductionRule1
{
  /**
   * Returns the value of the '<em><b>P</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>P</em>' containment reference.
   * @see #setP(P2)
   * @see org.eclipse.xtext.testlanguages.actionLang3.ActionLang3Package#getP3_P()
   * @model containment="true"
   * @generated
   */
  P2 getP();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.actionLang3.P3#getP <em>P</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>P</em>' containment reference.
   * @see #getP()
   * @generated
   */
  void setP(P2 value);

  /**
   * Returns the value of the '<em><b>I</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>I</em>' attribute.
   * @see #setI(int)
   * @see org.eclipse.xtext.testlanguages.actionLang3.ActionLang3Package#getP3_I()
   * @model
   * @generated
   */
  int getI();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.actionLang3.P3#getI <em>I</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>I</em>' attribute.
   * @see #getI()
   * @generated
   */
  void setI(int value);

} // P3
