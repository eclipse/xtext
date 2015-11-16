/**
 */
package org.eclipse.xtext.serializer.sequencertest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delegation A</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.DelegationA#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.DelegationA#getRc2 <em>Rc2</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getDelegationA()
 * @model
 * @generated
 */
public interface DelegationA extends Delegation
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Delegation)
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getDelegationA_Left()
   * @model containment="true"
   * @generated
   */
  Delegation getLeft();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.sequencertest.DelegationA#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Delegation value);

  /**
   * Returns the value of the '<em><b>Rc2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rc2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rc2</em>' containment reference.
   * @see #setRc2(Delegation)
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getDelegationA_Rc2()
   * @model containment="true"
   * @generated
   */
  Delegation getRc2();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.sequencertest.DelegationA#getRc2 <em>Rc2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rc2</em>' containment reference.
   * @see #getRc2()
   * @generated
   */
  void setRc2(Delegation value);

} // DelegationA
