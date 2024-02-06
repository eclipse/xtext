/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.parameters.parametersTestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parser Rule Parameters</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParserRuleParameters#getScenario <em>Scenario</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParametersTestLanguagePackage#getParserRuleParameters()
 * @model
 * @generated
 */
public interface ParserRuleParameters extends EObject
{
  /**
   * Returns the value of the '<em><b>Scenario</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scenario</em>' containment reference.
   * @see #setScenario(Scenario)
   * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParametersTestLanguagePackage#getParserRuleParameters_Scenario()
   * @model containment="true"
   * @generated
   */
  Scenario getScenario();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParserRuleParameters#getScenario <em>Scenario</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scenario</em>' containment reference.
   * @see #getScenario()
   * @generated
   */
  void setScenario(Scenario value);

} // ParserRuleParameters
