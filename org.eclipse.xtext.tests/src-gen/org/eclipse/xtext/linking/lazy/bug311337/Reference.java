/**
 */
package org.eclipse.xtext.linking.lazy.bug311337;

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
 *   <li>{@link org.eclipse.xtext.linking.lazy.bug311337.Reference#getRefChild <em>Ref Child</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.linking.lazy.bug311337.Bug311337Package#getReference()
 * @model
 * @generated
 */
public interface Reference extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref Child</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref Child</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref Child</em>' reference.
   * @see #setRefChild(Child)
   * @see org.eclipse.xtext.linking.lazy.bug311337.Bug311337Package#getReference_RefChild()
   * @model
   * @generated
   */
  Child getRefChild();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.lazy.bug311337.Reference#getRefChild <em>Ref Child</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref Child</em>' reference.
   * @see #getRefChild()
   * @generated
   */
  void setRefChild(Child value);

} // Reference
