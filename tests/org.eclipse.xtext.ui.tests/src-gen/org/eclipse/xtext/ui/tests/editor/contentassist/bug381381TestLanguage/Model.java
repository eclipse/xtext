/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage;

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
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.Model#getStmt <em>Stmt</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.Bug381381TestLanguagePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stmt</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stmt</em>' containment reference.
   * @see #setStmt(CopyFieldNameToVariableStmt)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.Bug381381TestLanguagePackage#getModel_Stmt()
   * @model containment="true"
   * @generated
   */
  CopyFieldNameToVariableStmt getStmt();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.Model#getStmt <em>Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stmt</em>' containment reference.
   * @see #getStmt()
   * @generated
   */
  void setStmt(CopyFieldNameToVariableStmt value);

} // Model
