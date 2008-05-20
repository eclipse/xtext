/**
 * <copyright>
 * </copyright>
 *
 * $Id: LexerRule.java,v 1.6 2008/05/20 09:09:47 jkohnlein Exp $
 */
package org.eclipse.xtext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lexer Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.LexerRule#getTokenType <em>Token Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.LexerRule#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.XtextPackage#getLexerRule()
 * @model
 * @generated
 */
public interface LexerRule extends AbstractRule
{
  /**
   * Returns the value of the '<em><b>Token Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Token Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Token Type</em>' attribute.
   * @see #setTokenType(String)
   * @see org.eclipse.xtext.XtextPackage#getLexerRule_TokenType()
   * @model
   * @generated
   */
  String getTokenType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.LexerRule#getTokenType <em>Token Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Token Type</em>' attribute.
   * @see #getTokenType()
   * @generated
   */
  void setTokenType(String value);

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
   * @see org.eclipse.xtext.XtextPackage#getLexerRule_Body()
   * @model
   * @generated
   */
  String getBody();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.LexerRule#getBody <em>Body</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' attribute.
   * @see #getBody()
   * @generated
   */
  void setBody(String value);

} // LexerRule
