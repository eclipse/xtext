/**
 */
package org.eclipse.xtext.resource.bug385636;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Define Variables</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.bug385636.DefineVariables#getVariables <em>Variables</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.resource.bug385636.Bug385636Package#getDefineVariables()
 * @model
 * @generated
 */
public interface DefineVariables extends EObject
{
  /**
   * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.resource.bug385636.DefineVariable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variables</em>' containment reference list.
   * @see org.eclipse.xtext.resource.bug385636.Bug385636Package#getDefineVariables_Variables()
   * @model containment="true"
   * @generated
   */
  EList<DefineVariable> getVariables();

} // DefineVariables
