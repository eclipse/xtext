/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.example.statemachine.statemachine;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statemachine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine#getSignals <em>Signals</em>}</li>
 *   <li>{@link org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage#getStatemachine()
 * @model
 * @generated
 */
public interface Statemachine extends EObject
{
  /**
   * Returns the value of the '<em><b>Signals</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.web.example.statemachine.statemachine.Signal}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Signals</em>' containment reference list.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage#getStatemachine_Signals()
   * @model containment="true"
   * @generated
   */
  EList<Signal> getSignals();

  /**
   * Returns the value of the '<em><b>States</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.web.example.statemachine.statemachine.State}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>States</em>' containment reference list.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage#getStatemachine_States()
   * @model containment="true"
   * @generated
   */
  EList<State> getStates();

} // Statemachine
