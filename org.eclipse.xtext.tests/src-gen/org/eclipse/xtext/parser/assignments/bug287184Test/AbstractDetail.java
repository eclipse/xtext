/**
 */
package org.eclipse.xtext.parser.assignments.bug287184Test;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Detail</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.assignments.bug287184Test.AbstractDetail#getDetailClass <em>Detail Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.assignments.bug287184Test.Bug287184TestPackage#getAbstractDetail()
 * @model
 * @generated
 */
public interface AbstractDetail extends EObject
{
  /**
   * Returns the value of the '<em><b>Detail Class</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Detail Class</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Detail Class</em>' reference.
   * @see #setDetailClass(Model)
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.Bug287184TestPackage#getAbstractDetail_DetailClass()
   * @model
   * @generated
   */
  Model getDetailClass();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.assignments.bug287184Test.AbstractDetail#getDetailClass <em>Detail Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Detail Class</em>' reference.
   * @see #getDetailClass()
   * @generated
   */
  void setDetailClass(Model value);

} // AbstractDetail
