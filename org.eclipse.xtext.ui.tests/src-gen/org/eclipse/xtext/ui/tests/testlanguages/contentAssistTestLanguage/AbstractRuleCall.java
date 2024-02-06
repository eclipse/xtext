/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Rule Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.AbstractRuleCall#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.ContentAssistTestLanguagePackage#getAbstractRuleCall()
 * @model
 * @generated
 */
public interface AbstractRuleCall extends EObject
{
  /**
   * Returns the value of the '<em><b>Rule</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule</em>' reference.
   * @see #setRule(AbstractRule)
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.ContentAssistTestLanguagePackage#getAbstractRuleCall_Rule()
   * @model
   * @generated
   */
  AbstractRule getRule();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.AbstractRuleCall#getRule <em>Rule</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rule</em>' reference.
   * @see #getRule()
   * @generated
   */
  void setRule(AbstractRule value);

} // AbstractRuleCall
