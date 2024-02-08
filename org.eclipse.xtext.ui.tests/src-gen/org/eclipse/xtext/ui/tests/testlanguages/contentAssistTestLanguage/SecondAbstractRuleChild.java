/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Second Abstract Rule Child</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.SecondAbstractRuleChild#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.ContentAssistTestLanguagePackage#getSecondAbstractRuleChild()
 * @model
 * @generated
 */
public interface SecondAbstractRuleChild extends AbstractRule
{
  /**
   * Returns the value of the '<em><b>Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule</em>' containment reference.
   * @see #setRule(AbstractRuleCall)
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.ContentAssistTestLanguagePackage#getSecondAbstractRuleChild_Rule()
   * @model containment="true"
   * @generated
   */
  AbstractRuleCall getRule();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.SecondAbstractRuleChild#getRule <em>Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rule</em>' containment reference.
   * @see #getRule()
   * @generated
   */
  void setRule(AbstractRuleCall value);

} // SecondAbstractRuleChild
