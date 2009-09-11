/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtextUiTest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parser Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextUiTest.ParserRule#isDefinesHiddenTokens <em>Defines Hidden Tokens</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextUiTest.ParserRule#getHiddenTokens <em>Hidden Tokens</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextUiTest.XtextUiTestPackage#getParserRule()
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
   * @see org.eclipse.xtext.xtextUiTest.XtextUiTestPackage#getParserRule_DefinesHiddenTokens()
   * @model
   * @generated
   */
  boolean isDefinesHiddenTokens();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextUiTest.ParserRule#isDefinesHiddenTokens <em>Defines Hidden Tokens</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Defines Hidden Tokens</em>' attribute.
   * @see #isDefinesHiddenTokens()
   * @generated
   */
  void setDefinesHiddenTokens(boolean value);

  /**
   * Returns the value of the '<em><b>Hidden Tokens</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.xtextUiTest.AbstractRule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hidden Tokens</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hidden Tokens</em>' reference list.
   * @see org.eclipse.xtext.xtextUiTest.XtextUiTestPackage#getParserRule_HiddenTokens()
   * @model
   * @generated
   */
  EList<AbstractRule> getHiddenTokens();

} // ParserRule
