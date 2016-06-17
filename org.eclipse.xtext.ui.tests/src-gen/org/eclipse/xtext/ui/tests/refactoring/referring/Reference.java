/**
 */
package org.eclipse.xtext.ui.tests.refactoring.referring;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.refactoring.referring.Reference#getReferenced <em>Referenced</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.refactoring.referring.ReferringPackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends EObject
{
  /**
   * Returns the value of the '<em><b>Referenced</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Referenced</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referenced</em>' reference.
   * @see #setReferenced(EObject)
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.ReferringPackage#getReference_Referenced()
   * @model
   * @generated
   */
  EObject getReferenced();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.refactoring.referring.Reference#getReferenced <em>Referenced</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Referenced</em>' reference.
   * @see #getReferenced()
   * @generated
   */
  void setReferenced(EObject value);

} // Reference
