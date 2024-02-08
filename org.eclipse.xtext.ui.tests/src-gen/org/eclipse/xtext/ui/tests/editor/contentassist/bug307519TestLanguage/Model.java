/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage;

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
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Model#getE1 <em>E1</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Model#getE2 <em>E2</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Bug307519TestLanguagePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>E1</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Elem1}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>E1</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Bug307519TestLanguagePackage#getModel_E1()
   * @model containment="true"
   * @generated
   */
  EList<Elem1> getE1();

  /**
   * Returns the value of the '<em><b>E2</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Elem2}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>E2</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Bug307519TestLanguagePackage#getModel_E2()
   * @model containment="true"
   * @generated
   */
  EList<Elem2> getE2();

} // Model
