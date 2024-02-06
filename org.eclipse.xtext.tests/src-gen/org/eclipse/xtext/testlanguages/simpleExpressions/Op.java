/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.simpleExpressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Op</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.simpleExpressions.Op#getValues <em>Values</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.simpleExpressions.Op#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.simpleExpressions.SimpleExpressionsPackage#getOp()
 * @model
 * @generated
 */
public interface Op extends Expression
{
  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.testlanguages.simpleExpressions.Expression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.SimpleExpressionsPackage#getOp_Values()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getValues();

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see #setOperator(String)
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.SimpleExpressionsPackage#getOp_Operator()
   * @model
   * @generated
   */
  String getOperator();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.simpleExpressions.Op#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see #getOperator()
   * @generated
   */
  void setOperator(String value);

} // Op
