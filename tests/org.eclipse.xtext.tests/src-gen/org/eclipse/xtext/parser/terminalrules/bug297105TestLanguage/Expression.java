/**
 */
package org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Expression#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Expression#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Bug297105TestLanguagePackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends EObject
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Literal)
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Bug297105TestLanguagePackage#getExpression_Left()
   * @model containment="true"
   * @generated
   */
  Literal getLeft();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Expression#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Literal value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Literal)
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Bug297105TestLanguagePackage#getExpression_Right()
   * @model containment="true"
   * @generated
   */
  Literal getRight();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Expression#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Literal value);

} // Expression
