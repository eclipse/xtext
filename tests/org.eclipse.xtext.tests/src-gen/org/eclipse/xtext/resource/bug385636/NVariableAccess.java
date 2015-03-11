/**
 */
package org.eclipse.xtext.resource.bug385636;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>NVariable Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.bug385636.NVariableAccess#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.resource.bug385636.Bug385636Package#getNVariableAccess()
 * @model
 * @generated
 */
public interface NVariableAccess extends EObject
{
  /**
   * Returns the value of the '<em><b>Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' reference.
   * @see #setVariable(DefineVariable)
   * @see org.eclipse.xtext.resource.bug385636.Bug385636Package#getNVariableAccess_Variable()
   * @model
   * @generated
   */
  DefineVariable getVariable();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.resource.bug385636.NVariableAccess#getVariable <em>Variable</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(DefineVariable value);

} // NVariableAccess
