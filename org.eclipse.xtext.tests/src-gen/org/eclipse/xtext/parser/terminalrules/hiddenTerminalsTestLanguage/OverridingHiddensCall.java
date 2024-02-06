/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Overriding Hiddens Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddensCall#getSpaces <em>Spaces</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddensCall#isValid <em>Valid</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage#getOverridingHiddensCall()
 * @model
 * @generated
 */
public interface OverridingHiddensCall extends EObject
{
  /**
   * Returns the value of the '<em><b>Spaces</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Spaces</em>' attribute list.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage#getOverridingHiddensCall_Spaces()
   * @model unique="false"
   * @generated
   */
  EList<String> getSpaces();

  /**
   * Returns the value of the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Valid</em>' attribute.
   * @see #setValid(boolean)
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage#getOverridingHiddensCall_Valid()
   * @model
   * @generated
   */
  boolean isValid();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddensCall#isValid <em>Valid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Valid</em>' attribute.
   * @see #isValid()
   * @generated
   */
  void setValid(boolean value);

} // OverridingHiddensCall
