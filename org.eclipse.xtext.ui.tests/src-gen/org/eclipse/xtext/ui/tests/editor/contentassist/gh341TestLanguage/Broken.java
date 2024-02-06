/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Broken</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Broken#getIds <em>Ids</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Broken#getRefs <em>Refs</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Gh341TestLanguagePackage#getBroken()
 * @model
 * @generated
 */
public interface Broken extends Element
{
  /**
   * Returns the value of the '<em><b>Ids</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ids</em>' attribute list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Gh341TestLanguagePackage#getBroken_Ids()
   * @model unique="false"
   * @generated
   */
  EList<String> getIds();

  /**
   * Returns the value of the '<em><b>Refs</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Broken}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Refs</em>' reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Gh341TestLanguagePackage#getBroken_Refs()
   * @model
   * @generated
   */
  EList<Broken> getRefs();

} // Broken
