/**
 */
package org.eclipse.xtext.web.example.statemachine.statemachine;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.web.example.statemachine.statemachine.Command#getSignal <em>Signal</em>}</li>
 *   <li>{@link org.eclipse.xtext.web.example.statemachine.statemachine.Command#isNewState <em>New State</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage#getCommand()
 * @model
 * @generated
 */
public interface Command extends EObject
{
  /**
   * Returns the value of the '<em><b>Signal</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Signal</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Signal</em>' reference.
   * @see #setSignal(Signal)
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage#getCommand_Signal()
   * @model
   * @generated
   */
  Signal getSignal();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Command#getSignal <em>Signal</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Signal</em>' reference.
   * @see #getSignal()
   * @generated
   */
  void setSignal(Signal value);

  /**
   * Returns the value of the '<em><b>New State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>New State</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>New State</em>' attribute.
   * @see #setNewState(boolean)
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage#getCommand_NewState()
   * @model
   * @generated
   */
  boolean isNewState();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Command#isNewState <em>New State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>New State</em>' attribute.
   * @see #isNewState()
   * @generated
   */
  void setNewState(boolean value);

} // Command
