/**
 * ******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  ******************************************************************************
 */
package org.eclipse.xtext.web.example.statemachine.statemachine;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.web.example.statemachine.statemachine.StatemachineFactory
 * @model kind="package"
 * @generated
 */
public interface StatemachinePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "statemachine";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/web/example/Statemachine";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "statemachine";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  StatemachinePackage eINSTANCE = org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachineImpl <em>Statemachine</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachineImpl
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getStatemachine()
   * @generated
   */
  int STATEMACHINE = 0;

  /**
   * The feature id for the '<em><b>Signals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMACHINE__SIGNALS = 0;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMACHINE__STATES = 1;

  /**
   * The number of structural features of the '<em>Statemachine</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMACHINE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.SignalImpl <em>Signal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.SignalImpl
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getSignal()
   * @generated
   */
  int SIGNAL = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNAL__NAME = 0;

  /**
   * The number of structural features of the '<em>Signal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNAL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.InputSignalImpl <em>Input Signal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.InputSignalImpl
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getInputSignal()
   * @generated
   */
  int INPUT_SIGNAL = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_SIGNAL__NAME = SIGNAL__NAME;

  /**
   * The number of structural features of the '<em>Input Signal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_SIGNAL_FEATURE_COUNT = SIGNAL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.OutputSignalImpl <em>Output Signal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.OutputSignalImpl
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getOutputSignal()
   * @generated
   */
  int OUTPUT_SIGNAL = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_SIGNAL__NAME = SIGNAL__NAME;

  /**
   * The number of structural features of the '<em>Output Signal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_SIGNAL_FEATURE_COUNT = SIGNAL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.StateImpl <em>State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StateImpl
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getState()
   * @generated
   */
  int STATE = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__NAME = 0;

  /**
   * The feature id for the '<em><b>Commands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__COMMANDS = 1;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__TRANSITIONS = 2;

  /**
   * The feature id for the '<em><b>Nested States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__NESTED_STATES = 3;

  /**
   * The number of structural features of the '<em>State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.TransitionImpl <em>Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.TransitionImpl
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getTransition()
   * @generated
   */
  int TRANSITION = 5;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__CONDITION = 0;

  /**
   * The feature id for the '<em><b>State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__STATE = 1;

  /**
   * The number of structural features of the '<em>Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.ConditionImpl <em>Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.ConditionImpl
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getCondition()
   * @generated
   */
  int CONDITION = 6;

  /**
   * The feature id for the '<em><b>Events</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITION__EVENTS = 0;

  /**
   * The number of structural features of the '<em>Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.EventImpl <em>Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.EventImpl
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getEvent()
   * @generated
   */
  int EVENT = 7;

  /**
   * The feature id for the '<em><b>Signal</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__SIGNAL = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__VALUE = 1;

  /**
   * The number of structural features of the '<em>Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.CommandImpl <em>Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.CommandImpl
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getCommand()
   * @generated
   */
  int COMMAND = 8;

  /**
   * The feature id for the '<em><b>Signal</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND__SIGNAL = 0;

  /**
   * The feature id for the '<em><b>New Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND__NEW_VALUE = 1;

  /**
   * The number of structural features of the '<em>Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine <em>Statemachine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statemachine</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine
   * @generated
   */
  EClass getStatemachine();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine#getSignals <em>Signals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Signals</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine#getSignals()
   * @see #getStatemachine()
   * @generated
   */
  EReference getStatemachine_Signals();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine#getStates()
   * @see #getStatemachine()
   * @generated
   */
  EReference getStatemachine_States();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Signal <em>Signal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Signal</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.Signal
   * @generated
   */
  EClass getSignal();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Signal#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.Signal#getName()
   * @see #getSignal()
   * @generated
   */
  EAttribute getSignal_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.web.example.statemachine.statemachine.InputSignal <em>Input Signal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Input Signal</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.InputSignal
   * @generated
   */
  EClass getInputSignal();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.web.example.statemachine.statemachine.OutputSignal <em>Output Signal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Output Signal</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.OutputSignal
   * @generated
   */
  EClass getOutputSignal();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.web.example.statemachine.statemachine.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.State
   * @generated
   */
  EClass getState();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.web.example.statemachine.statemachine.State#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.State#getName()
   * @see #getState()
   * @generated
   */
  EAttribute getState_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.web.example.statemachine.statemachine.State#getCommands <em>Commands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Commands</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.State#getCommands()
   * @see #getState()
   * @generated
   */
  EReference getState_Commands();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.web.example.statemachine.statemachine.State#getTransitions <em>Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transitions</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.State#getTransitions()
   * @see #getState()
   * @generated
   */
  EReference getState_Transitions();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.web.example.statemachine.statemachine.State#getNestedStates <em>Nested States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nested States</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.State#getNestedStates()
   * @see #getState()
   * @generated
   */
  EReference getState_NestedStates();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.Transition
   * @generated
   */
  EClass getTransition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Transition#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.Transition#getCondition()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Condition();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Transition#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>State</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.Transition#getState()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_State();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Condition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Condition</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.Condition
   * @generated
   */
  EClass getCondition();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Condition#getEvents <em>Events</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Events</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.Condition#getEvents()
   * @see #getCondition()
   * @generated
   */
  EReference getCondition_Events();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Event <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.Event
   * @generated
   */
  EClass getEvent();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Event#getSignal <em>Signal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Signal</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.Event#getSignal()
   * @see #getEvent()
   * @generated
   */
  EReference getEvent_Signal();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Event#isValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.Event#isValue()
   * @see #getEvent()
   * @generated
   */
  EAttribute getEvent_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Command <em>Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Command</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.Command
   * @generated
   */
  EClass getCommand();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Command#getSignal <em>Signal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Signal</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.Command#getSignal()
   * @see #getCommand()
   * @generated
   */
  EReference getCommand_Signal();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Command#isNewValue <em>New Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>New Value</em>'.
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.Command#isNewValue()
   * @see #getCommand()
   * @generated
   */
  EAttribute getCommand_NewValue();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  StatemachineFactory getStatemachineFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachineImpl <em>Statemachine</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachineImpl
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getStatemachine()
     * @generated
     */
    EClass STATEMACHINE = eINSTANCE.getStatemachine();

    /**
     * The meta object literal for the '<em><b>Signals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMACHINE__SIGNALS = eINSTANCE.getStatemachine_Signals();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMACHINE__STATES = eINSTANCE.getStatemachine_States();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.SignalImpl <em>Signal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.SignalImpl
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getSignal()
     * @generated
     */
    EClass SIGNAL = eINSTANCE.getSignal();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIGNAL__NAME = eINSTANCE.getSignal_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.InputSignalImpl <em>Input Signal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.InputSignalImpl
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getInputSignal()
     * @generated
     */
    EClass INPUT_SIGNAL = eINSTANCE.getInputSignal();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.OutputSignalImpl <em>Output Signal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.OutputSignalImpl
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getOutputSignal()
     * @generated
     */
    EClass OUTPUT_SIGNAL = eINSTANCE.getOutputSignal();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.StateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StateImpl
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getState()
     * @generated
     */
    EClass STATE = eINSTANCE.getState();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__NAME = eINSTANCE.getState_Name();

    /**
     * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__COMMANDS = eINSTANCE.getState_Commands();

    /**
     * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__TRANSITIONS = eINSTANCE.getState_Transitions();

    /**
     * The meta object literal for the '<em><b>Nested States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__NESTED_STATES = eINSTANCE.getState_NestedStates();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.TransitionImpl
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getTransition()
     * @generated
     */
    EClass TRANSITION = eINSTANCE.getTransition();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__CONDITION = eINSTANCE.getTransition_Condition();

    /**
     * The meta object literal for the '<em><b>State</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__STATE = eINSTANCE.getTransition_State();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.ConditionImpl <em>Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.ConditionImpl
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getCondition()
     * @generated
     */
    EClass CONDITION = eINSTANCE.getCondition();

    /**
     * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITION__EVENTS = eINSTANCE.getCondition_Events();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.EventImpl <em>Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.EventImpl
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getEvent()
     * @generated
     */
    EClass EVENT = eINSTANCE.getEvent();

    /**
     * The meta object literal for the '<em><b>Signal</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT__SIGNAL = eINSTANCE.getEvent_Signal();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT__VALUE = eINSTANCE.getEvent_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.CommandImpl <em>Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.CommandImpl
     * @see org.eclipse.xtext.web.example.statemachine.statemachine.impl.StatemachinePackageImpl#getCommand()
     * @generated
     */
    EClass COMMAND = eINSTANCE.getCommand();

    /**
     * The meta object literal for the '<em><b>Signal</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND__SIGNAL = eINSTANCE.getCommand_Signal();

    /**
     * The meta object literal for the '<em><b>New Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMAND__NEW_VALUE = eINSTANCE.getCommand_NewValue();

  }

} //StatemachinePackage
