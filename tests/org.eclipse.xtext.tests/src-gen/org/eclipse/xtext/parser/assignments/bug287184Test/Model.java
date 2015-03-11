/**
 */
package org.eclipse.xtext.parser.assignments.bug287184Test;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.assignments.bug287184Test.Model#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.assignments.bug287184Test.Model#getDetail <em>Detail</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.assignments.bug287184Test.Bug287184TestPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
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
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.Bug287184TestPackage#getModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.assignments.bug287184Test.Model#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Detail</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.assignments.bug287184Test.AbstractDetail}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Detail</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Detail</em>' containment reference list.
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.Bug287184TestPackage#getModel_Detail()
   * @model containment="true"
   * @generated
   */
  EList<AbstractDetail> getDetail();

} // Model
