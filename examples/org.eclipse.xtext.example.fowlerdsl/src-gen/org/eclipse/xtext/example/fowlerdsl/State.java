/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.fowlerdsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.fowlerdsl.State#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.fowlerdsl.State#getActions <em>Actions</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.fowlerdsl.State#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.fowlerdsl.FowlerdslPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.example.fowlerdsl.FowlerdslPackage#getState_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.fowlerdsl.State#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Actions</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.fowlerdsl.Command}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actions</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actions</em>' reference list.
   * @see org.eclipse.xtext.example.fowlerdsl.FowlerdslPackage#getState_Actions()
   * @model
   * @generated
   */
  EList<Command> getActions();

  /**
   * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.fowlerdsl.Transition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transitions</em>' containment reference list.
   * @see org.eclipse.xtext.example.fowlerdsl.FowlerdslPackage#getState_Transitions()
   * @model containment="true"
   * @generated
   */
  EList<Transition> getTransitions();

} // State
