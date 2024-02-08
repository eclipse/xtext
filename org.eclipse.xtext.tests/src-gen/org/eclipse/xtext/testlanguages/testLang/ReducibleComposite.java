/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.testLang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reducible Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.testLang.ReducibleComposite#getActionFeature <em>Action Feature</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.testLang.TestLangPackage#getReducibleComposite()
 * @model
 * @generated
 */
public interface ReducibleComposite extends ReducibleElement
{
  /**
   * Returns the value of the '<em><b>Action Feature</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.testlanguages.testLang.TerminalElement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action Feature</em>' containment reference list.
   * @see org.eclipse.xtext.testlanguages.testLang.TestLangPackage#getReducibleComposite_ActionFeature()
   * @model containment="true"
   * @generated
   */
  EList<TerminalElement> getActionFeature();

} // ReducibleComposite
