/**
 */
package org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root#getMixed <em>Mixed</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends EObject
{
  /**
   * Returns the value of the '<em><b>Mixed</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mixed</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mixed</em>' containment reference.
   * @see #setMixed(Mixed)
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage#getRoot_Mixed()
   * @model containment="true"
   * @generated
   */
  Mixed getMixed();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root#getMixed <em>Mixed</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mixed</em>' containment reference.
   * @see #getMixed()
   * @generated
   */
  void setMixed(Mixed value);

} // Root
