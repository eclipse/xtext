/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.testLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terminal Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.testLang.TerminalElement#getStringFeature <em>String Feature</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.testLang.TestLangPackage#getTerminalElement()
 * @model
 * @generated
 */
public interface TerminalElement extends ReducibleElement
{
  /**
   * Returns the value of the '<em><b>String Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>String Feature</em>' attribute.
   * @see #setStringFeature(String)
   * @see org.eclipse.xtext.testlanguages.testLang.TestLangPackage#getTerminalElement_StringFeature()
   * @model
   * @generated
   */
  String getStringFeature();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.testLang.TerminalElement#getStringFeature <em>String Feature</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String Feature</em>' attribute.
   * @see #getStringFeature()
   * @generated
   */
  void setStringFeature(String value);

} // TerminalElement
