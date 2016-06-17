/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ListAssignment#getLeftValues <em>Left Values</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ListAssignment#getRightValues <em>Right Values</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getListAssignment()
 * @model
 * @generated
 */
public interface ListAssignment extends Assignment
{
  /**
   * Returns the value of the '<em><b>Left Values</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left Values</em>' containment reference list.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getListAssignment_LeftValues()
   * @model containment="true"
   * @generated
   */
  EList<AssignmentValue> getLeftValues();

  /**
   * Returns the value of the '<em><b>Right Values</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Values</em>' containment reference list.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getListAssignment_RightValues()
   * @model containment="true"
   * @generated
   */
  EList<AssignmentValue> getRightValues();

} // ListAssignment
