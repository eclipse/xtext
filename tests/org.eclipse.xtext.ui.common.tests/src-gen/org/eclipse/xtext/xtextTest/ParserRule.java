/**
 * <copyright>
 * </copyright>
 *
 * $Id: ParserRule.java,v 1.1 2009/02/18 19:36:22 sefftinge Exp $
 */
package org.eclipse.xtext.xtextTest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parser Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextTest.ParserRule#isDefinesHiddenTokens <em>Defines Hidden Tokens</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.ParserRule#getHiddenTokens <em>Hidden Tokens</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.ParserRule#getAlternatives <em>Alternatives</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.ParserRule#isTerminal <em>Terminal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getParserRule()
 * @model
 * @generated
 */
public interface ParserRule extends AbstractRule
{
  /**
   * Returns the value of the '<em><b>Defines Hidden Tokens</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Defines Hidden Tokens</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Defines Hidden Tokens</em>' attribute.
   * @see #setDefinesHiddenTokens(boolean)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getParserRule_DefinesHiddenTokens()
   * @model
   * @generated
   */
  boolean isDefinesHiddenTokens();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.ParserRule#isDefinesHiddenTokens <em>Defines Hidden Tokens</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Defines Hidden Tokens</em>' attribute.
   * @see #isDefinesHiddenTokens()
   * @generated
   */
  void setDefinesHiddenTokens(boolean value);

  /**
   * Returns the value of the '<em><b>Hidden Tokens</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.xtextTest.AbstractRule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hidden Tokens</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hidden Tokens</em>' reference list.
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getParserRule_HiddenTokens()
   * @model
   * @generated
   */
  EList<AbstractRule> getHiddenTokens();

  /**
   * Returns the value of the '<em><b>Alternatives</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Alternatives</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alternatives</em>' containment reference.
   * @see #setAlternatives(AbstractElement)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getParserRule_Alternatives()
   * @model containment="true"
   * @generated
   */
  AbstractElement getAlternatives();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.ParserRule#getAlternatives <em>Alternatives</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alternatives</em>' containment reference.
   * @see #getAlternatives()
   * @generated
   */
  void setAlternatives(AbstractElement value);

  /**
   * Returns the value of the '<em><b>Terminal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Terminal</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Terminal</em>' attribute.
   * @see #setTerminal(boolean)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getParserRule_Terminal()
   * @model
   * @generated
   */
  boolean isTerminal();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.ParserRule#isTerminal <em>Terminal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Terminal</em>' attribute.
   * @see #isTerminal()
   * @generated
   */
  void setTerminal(boolean value);

} // ParserRule
