/**
 * <copyright>
 * </copyright>
 *
 * $Id: LexerRule.java,v 1.2 2009/02/18 21:20:04 sefftinge Exp $
 */
package org.eclipse.xtext.xtextTest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lexer Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextTest.LexerRule#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getLexerRule()
 * @model
 * @generated
 */
public interface LexerRule extends AbstractRule
{
  /**
   * Returns the value of the '<em><b>Body</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' attribute.
   * @see #setBody(String)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getLexerRule_Body()
   * @model
   * @generated
   */
  String getBody();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.LexerRule#getBody <em>Body</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' attribute.
   * @see #getBody()
   * @generated
   */
  void setBody(String value);

} // LexerRule
