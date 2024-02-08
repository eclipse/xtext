/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parser Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.ParserRule#isDefinesHiddenTokens <em>Defines Hidden Tokens</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.ParserRule#getHiddenTokens <em>Hidden Tokens</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.XtextTerminalsTestLanguagePackage#getParserRule()
 * @model
 * @generated
 */
public interface ParserRule extends AbstractRule
{
  /**
   * Returns the value of the '<em><b>Defines Hidden Tokens</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Defines Hidden Tokens</em>' attribute.
   * @see #setDefinesHiddenTokens(boolean)
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.XtextTerminalsTestLanguagePackage#getParserRule_DefinesHiddenTokens()
   * @model
   * @generated
   */
  boolean isDefinesHiddenTokens();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.ParserRule#isDefinesHiddenTokens <em>Defines Hidden Tokens</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Defines Hidden Tokens</em>' attribute.
   * @see #isDefinesHiddenTokens()
   * @generated
   */
  void setDefinesHiddenTokens(boolean value);

  /**
   * Returns the value of the '<em><b>Hidden Tokens</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.AbstractRule}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hidden Tokens</em>' reference list.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.XtextTerminalsTestLanguagePackage#getParserRule_HiddenTokens()
   * @model
   * @generated
   */
  EList<AbstractRule> getHiddenTokens();

} // ParserRule
