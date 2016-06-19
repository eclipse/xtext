/**
 */
package org.eclipse.xtext.serializer.sequencertest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Delegation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.ParameterDelegation#getP <em>P</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getParameterDelegation()
 * @model
 * @generated
 */
public interface ParameterDelegation extends EObject
{
  /**
   * Returns the value of the '<em><b>P</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>P</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>P</em>' containment reference.
   * @see #setP(Delegation)
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getParameterDelegation_P()
   * @model containment="true"
   * @generated
   */
  Delegation getP();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.sequencertest.ParameterDelegation#getP <em>P</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>P</em>' containment reference.
   * @see #getP()
   * @generated
   */
  void setP(Delegation value);

} // ParameterDelegation
