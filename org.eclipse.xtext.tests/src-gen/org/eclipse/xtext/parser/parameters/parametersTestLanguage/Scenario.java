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
 * A representation of the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.Scenario#getFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.Scenario#getSecond <em>Second</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParametersTestLanguagePackage#getScenario()
 * @model
 * @generated
 */
public interface Scenario extends EObject
{
  /**
   * Returns the value of the '<em><b>First</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>First</em>' attribute.
   * @see #setFirst(String)
   * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParametersTestLanguagePackage#getScenario_First()
   * @model
   * @generated
   */
  String getFirst();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.Scenario#getFirst <em>First</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First</em>' attribute.
   * @see #getFirst()
   * @generated
   */
  void setFirst(String value);

  /**
   * Returns the value of the '<em><b>Second</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second</em>' attribute.
   * @see #setSecond(String)
   * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParametersTestLanguagePackage#getScenario_Second()
   * @model
   * @generated
   */
  String getSecond();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.Scenario#getSecond <em>Second</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Second</em>' attribute.
   * @see #getSecond()
   * @generated
   */
  void setSecond(String value);

} // Scenario
