/**
 */
package org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage;

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
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Model#getFix <em>Fix</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Model#getError <em>Error</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Model#getTick <em>Tick</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Bug292245TestLanguagePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Fix</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fix</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fix</em>' attribute list.
   * @see org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Bug292245TestLanguagePackage#getModel_Fix()
   * @model unique="false"
   * @generated
   */
  EList<String> getFix();

  /**
   * Returns the value of the '<em><b>Error</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Error</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Error</em>' attribute list.
   * @see org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Bug292245TestLanguagePackage#getModel_Error()
   * @model unique="false"
   * @generated
   */
  EList<String> getError();

  /**
   * Returns the value of the '<em><b>Tick</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tick</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tick</em>' attribute list.
   * @see org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Bug292245TestLanguagePackage#getModel_Tick()
   * @model unique="false"
   * @generated
   */
  EList<String> getTick();

} // Model
