/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.actionLang3;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.testlanguages.actionLang3.ActionLang3Package
 * @generated
 */
public interface ActionLang3Factory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ActionLang3Factory eINSTANCE = org.eclipse.xtext.testlanguages.actionLang3.impl.ActionLang3FactoryImpl.init();

  /**
   * Returns a new object of class '<em>Production Rules</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Production Rules</em>'.
   * @generated
   */
  ProductionRules createProductionRules();

  /**
   * Returns a new object of class '<em>Production Rule1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Production Rule1</em>'.
   * @generated
   */
  ProductionRule1 createProductionRule1();

  /**
   * Returns a new object of class '<em>Production Rule2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Production Rule2</em>'.
   * @generated
   */
  ProductionRule2 createProductionRule2();

  /**
   * Returns a new object of class '<em>P1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>P1</em>'.
   * @generated
   */
  P1 createP1();

  /**
   * Returns a new object of class '<em>P2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>P2</em>'.
   * @generated
   */
  P2 createP2();

  /**
   * Returns a new object of class '<em>P3</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>P3</em>'.
   * @generated
   */
  P3 createP3();

  /**
   * Returns a new object of class '<em>Entry</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entry</em>'.
   * @generated
   */
  Entry createEntry();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ActionLang3Package getActionLang3Package();

} //ActionLang3Factory
