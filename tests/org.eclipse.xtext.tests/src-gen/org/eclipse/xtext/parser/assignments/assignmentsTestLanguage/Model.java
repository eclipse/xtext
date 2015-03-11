/**
 */
package org.eclipse.xtext.parser.assignments.assignmentsTestLanguage;

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
 *   <li>{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model#getSingle <em>Single</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model#getMulti <em>Multi</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model#getObject <em>Object</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.AssignmentsTestLanguagePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Single</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Single</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Single</em>' containment reference.
   * @see #setSingle(SingleValue)
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.AssignmentsTestLanguagePackage#getModel_Single()
   * @model containment="true"
   * @generated
   */
  SingleValue getSingle();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model#getSingle <em>Single</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Single</em>' containment reference.
   * @see #getSingle()
   * @generated
   */
  void setSingle(SingleValue value);

  /**
   * Returns the value of the '<em><b>Multi</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multi</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multi</em>' containment reference.
   * @see #setMulti(MultiValue)
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.AssignmentsTestLanguagePackage#getModel_Multi()
   * @model containment="true"
   * @generated
   */
  MultiValue getMulti();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model#getMulti <em>Multi</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multi</em>' containment reference.
   * @see #getMulti()
   * @generated
   */
  void setMulti(MultiValue value);

  /**
   * Returns the value of the '<em><b>Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Object</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object</em>' containment reference.
   * @see #setObject(EObject)
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.AssignmentsTestLanguagePackage#getModel_Object()
   * @model containment="true"
   * @generated
   */
  EObject getObject();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model#getObject <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object</em>' containment reference.
   * @see #getObject()
   * @generated
   */
  void setObject(EObject value);

} // Model
