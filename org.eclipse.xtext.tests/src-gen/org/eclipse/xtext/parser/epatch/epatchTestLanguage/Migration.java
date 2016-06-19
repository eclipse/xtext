/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Migration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration#getFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration#getAsOp <em>As Op</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration#getEachOp <em>Each Op</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getMigration()
 * @model
 * @generated
 */
public interface Migration extends EObject
{
  /**
   * Returns the value of the '<em><b>First</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First</em>' containment reference.
   * @see #setFirst(Executable)
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getMigration_First()
   * @model containment="true"
   * @generated
   */
  Executable getFirst();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration#getFirst <em>First</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First</em>' containment reference.
   * @see #getFirst()
   * @generated
   */
  void setFirst(Executable value);

  /**
   * Returns the value of the '<em><b>As Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>As Op</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>As Op</em>' containment reference.
   * @see #setAsOp(Executable)
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getMigration_AsOp()
   * @model containment="true"
   * @generated
   */
  Executable getAsOp();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration#getAsOp <em>As Op</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>As Op</em>' containment reference.
   * @see #getAsOp()
   * @generated
   */
  void setAsOp(Executable value);

  /**
   * Returns the value of the '<em><b>Each Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Each Op</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Each Op</em>' containment reference.
   * @see #setEachOp(Executable)
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getMigration_EachOp()
   * @model containment="true"
   * @generated
   */
  Executable getEachOp();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration#getEachOp <em>Each Op</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Each Op</em>' containment reference.
   * @see #getEachOp()
   * @generated
   */
  void setEachOp(Executable value);

} // Migration
