/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject#getLeftMig <em>Left Mig</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getNamedObject()
 * @model
 * @generated
 */
public interface NamedObject extends EObject
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
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getNamedObject_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Assignments</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Assignment}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assignments</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assignments</em>' containment reference list.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getNamedObject_Assignments()
   * @model containment="true"
   * @generated
   */
  EList<Assignment> getAssignments();

  /**
   * Returns the value of the '<em><b>Left Mig</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left Mig</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left Mig</em>' containment reference.
   * @see #setLeftMig(Migration)
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getNamedObject_LeftMig()
   * @model containment="true"
   * @generated
   */
  Migration getLeftMig();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject#getLeftMig <em>Left Mig</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left Mig</em>' containment reference.
   * @see #getLeftMig()
   * @generated
   */
  void setLeftMig(Migration value);

} // NamedObject
