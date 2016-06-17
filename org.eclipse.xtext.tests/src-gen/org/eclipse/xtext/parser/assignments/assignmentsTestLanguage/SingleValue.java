/**
 */
package org.eclipse.xtext.parser.assignments.assignmentsTestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.SingleValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.AssignmentsTestLanguagePackage#getSingleValue()
 * @model
 * @generated
 */
public interface SingleValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.AssignmentsTestLanguagePackage#getSingleValue_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.SingleValue#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // SingleValue
