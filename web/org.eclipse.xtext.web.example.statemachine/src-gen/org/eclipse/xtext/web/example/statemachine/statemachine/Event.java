/**
 */
package org.eclipse.xtext.web.example.statemachine.statemachine;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.web.example.statemachine.statemachine.Event#getSignal <em>Signal</em>}</li>
 *   <li>{@link org.eclipse.xtext.web.example.statemachine.statemachine.Event#isState <em>State</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage#getEvent()
 * @model
 * @generated
 */
public interface Event extends EObject
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
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage#getEvent_Signal()
   * @model
   * @generated
   */
  Signal getSignal();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Event#getSignal <em>Signal</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Signal</em>' reference.
   * @see #getSignal()
   * @generated
   */
  void setSignal(Signal value);

  /**
   * Returns the value of the '<em><b>State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State</em>' attribute.
   * @see #setState(boolean)
   * @see org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage#getEvent_State()
   * @model
   * @generated
   */
  boolean isState();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.web.example.statemachine.statemachine.Event#isState <em>State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State</em>' attribute.
   * @see #isState()
   * @generated
   */
  void setState(boolean value);

} // Event
