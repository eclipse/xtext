/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Model#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Model#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Model#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Bug309949TestLanguagePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Errors</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Error}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Errors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Errors</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Bug309949TestLanguagePackage#getModel_Errors()
   * @model containment="true"
   * @generated
   */
  EList<org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Error> getErrors();

  /**
   * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Operation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operations</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Bug309949TestLanguagePackage#getModel_Operations()
   * @model containment="true"
   * @generated
   */
  EList<Operation> getOperations();

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
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Bug309949TestLanguagePackage#getModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Model#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // Model
