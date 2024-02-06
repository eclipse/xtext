/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.Model#getIntValues <em>Int Values</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.Model#getDoubleValues <em>Double Values</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.Model#getDateValues <em>Date Values</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.EcoreTerminalsTestLanguagePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Int Values</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Int Values</em>' attribute list.
   * @see org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.EcoreTerminalsTestLanguagePackage#getModel_IntValues()
   * @model unique="false"
   * @generated
   */
  EList<Integer> getIntValues();

  /**
   * Returns the value of the '<em><b>Double Values</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Double}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Double Values</em>' attribute list.
   * @see org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.EcoreTerminalsTestLanguagePackage#getModel_DoubleValues()
   * @model unique="false"
   * @generated
   */
  EList<Double> getDoubleValues();

  /**
   * Returns the value of the '<em><b>Date Values</b></em>' attribute list.
   * The list contents are of type {@link java.util.Date}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Date Values</em>' attribute list.
   * @see org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.EcoreTerminalsTestLanguagePackage#getModel_DateValues()
   * @model unique="false"
   * @generated
   */
  EList<Date> getDateValues();

} // Model
