/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>First Level</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.FirstLevel#getSecondLevelA <em>Second Level A</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.FirstLevel#getSecondLevelB <em>Second Level B</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage#getFirstLevel()
 * @model
 * @generated
 */
public interface FirstLevel extends EObject
{
  /**
   * Returns the value of the '<em><b>Second Level A</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.SecondLevelA}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second Level A</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage#getFirstLevel_SecondLevelA()
   * @model containment="true"
   * @generated
   */
  EList<SecondLevelA> getSecondLevelA();

  /**
   * Returns the value of the '<em><b>Second Level B</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.SecondLevelB}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second Level B</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage#getFirstLevel_SecondLevelB()
   * @model containment="true"
   * @generated
   */
  EList<SecondLevelB> getSecondLevelB();

} // FirstLevel
