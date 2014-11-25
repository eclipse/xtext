/**
 */
package org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Element#getFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Element#getSecond <em>Second</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Element#getThird <em>Third</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Element#getForth <em>Forth</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Bug317840TestLanguagePackage#getElement()
 * @model
 * @generated
 */
public interface Element extends EObject
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
   * @see #setFirst(Named)
   * @see org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Bug317840TestLanguagePackage#getElement_First()
   * @model containment="true"
   * @generated
   */
  Named getFirst();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Element#getFirst <em>First</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First</em>' containment reference.
   * @see #getFirst()
   * @generated
   */
  void setFirst(Named value);

  /**
   * Returns the value of the '<em><b>Second</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second</em>' containment reference.
   * @see #setSecond(Named)
   * @see org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Bug317840TestLanguagePackage#getElement_Second()
   * @model containment="true"
   * @generated
   */
  Named getSecond();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Element#getSecond <em>Second</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Second</em>' containment reference.
   * @see #getSecond()
   * @generated
   */
  void setSecond(Named value);

  /**
   * Returns the value of the '<em><b>Third</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Named}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Third</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Third</em>' containment reference list.
   * @see org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Bug317840TestLanguagePackage#getElement_Third()
   * @model containment="true"
   * @generated
   */
  EList<Named> getThird();

  /**
   * Returns the value of the '<em><b>Forth</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Named}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Forth</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Forth</em>' containment reference list.
   * @see org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Bug317840TestLanguagePackage#getElement_Forth()
   * @model containment="true"
   * @generated
   */
  EList<Named> getForth();

} // Element
