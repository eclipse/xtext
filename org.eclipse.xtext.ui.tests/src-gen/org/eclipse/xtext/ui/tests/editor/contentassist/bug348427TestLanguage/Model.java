/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage;

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
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Model#getElement1 <em>Element1</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Model#getElement2 <em>Element2</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Bug348427TestLanguagePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Element1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element1</em>' containment reference.
   * @see #setElement1(Scenario1)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Bug348427TestLanguagePackage#getModel_Element1()
   * @model containment="true"
   * @generated
   */
  Scenario1 getElement1();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Model#getElement1 <em>Element1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element1</em>' containment reference.
   * @see #getElement1()
   * @generated
   */
  void setElement1(Scenario1 value);

  /**
   * Returns the value of the '<em><b>Element2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element2</em>' containment reference.
   * @see #setElement2(Scenario2)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Bug348427TestLanguagePackage#getModel_Element2()
   * @model containment="true"
   * @generated
   */
  Scenario2 getElement2();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Model#getElement2 <em>Element2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element2</em>' containment reference.
   * @see #getElement2()
   * @generated
   */
  void setElement2(Scenario2 value);

} // Model
