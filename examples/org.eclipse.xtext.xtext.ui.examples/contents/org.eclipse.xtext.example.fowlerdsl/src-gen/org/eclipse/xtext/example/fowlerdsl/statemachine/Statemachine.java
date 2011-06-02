/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.fowlerdsl.statemachine;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statemachine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine#getEvents <em>Events</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine#getResetEvents <em>Reset Events</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine#getCommands <em>Commands</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine#getStates <em>States</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.fowlerdsl.statemachine.StatemachinePackage#getStatemachine()
 * @model
 * @generated
 */
public interface Statemachine extends EObject
{
  /**
   * Returns the value of the '<em><b>Events</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.fowlerdsl.statemachine.Event}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Events</em>' containment reference list.
   * @see org.eclipse.xtext.example.fowlerdsl.statemachine.StatemachinePackage#getStatemachine_Events()
   * @model containment="true"
   * @generated
   */
  EList<Event> getEvents();

  /**
   * Returns the value of the '<em><b>Reset Events</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.fowlerdsl.statemachine.Event}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reset Events</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reset Events</em>' reference list.
   * @see org.eclipse.xtext.example.fowlerdsl.statemachine.StatemachinePackage#getStatemachine_ResetEvents()
   * @model
   * @generated
   */
  EList<Event> getResetEvents();

  /**
   * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.fowlerdsl.statemachine.Command}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Commands</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Commands</em>' containment reference list.
   * @see org.eclipse.xtext.example.fowlerdsl.statemachine.StatemachinePackage#getStatemachine_Commands()
   * @model containment="true"
   * @generated
   */
  EList<Command> getCommands();

  /**
   * Returns the value of the '<em><b>States</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.fowlerdsl.statemachine.State}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>States</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>States</em>' containment reference list.
   * @see org.eclipse.xtext.example.fowlerdsl.statemachine.StatemachinePackage#getStatemachine_States()
   * @model containment="true"
   * @generated
   */
  EList<State> getStates();

} // Statemachine
