/**
 */
package org.eclipse.xtext.ui.tests.refactoring.refactoring;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.refactoring.refactoring.Element#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.refactoring.refactoring.Element#getContained <em>Contained</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.refactoring.refactoring.Element#getReferenced <em>Referenced</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.refactoring.refactoring.RefactoringPackage#getElement()
 * @model
 * @generated
 */
public interface Element extends AbstractElement
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
   * @see org.eclipse.xtext.ui.tests.refactoring.refactoring.RefactoringPackage#getElement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.refactoring.refactoring.Element#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Contained</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.refactoring.refactoring.Element}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contained</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contained</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.refactoring.refactoring.RefactoringPackage#getElement_Contained()
   * @model containment="true"
   * @generated
   */
  EList<Element> getContained();

  /**
   * Returns the value of the '<em><b>Referenced</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.refactoring.refactoring.Element}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Referenced</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referenced</em>' reference list.
   * @see org.eclipse.xtext.ui.tests.refactoring.refactoring.RefactoringPackage#getElement_Referenced()
   * @model
   * @generated
   */
  EList<Element> getReferenced();

} // Element
