/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage;

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
 *   <li>{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Model#getFoos <em>Foos</em>}</li>
 *   <li>{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Model#getBars <em>Bars</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.EObjectAtOffsetTestLanguagePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Foos</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Foo}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Foos</em>' containment reference list.
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.EObjectAtOffsetTestLanguagePackage#getModel_Foos()
   * @model containment="true"
   * @generated
   */
  EList<Foo> getFoos();

  /**
   * Returns the value of the '<em><b>Bars</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.AbstractBar}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bars</em>' containment reference list.
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.EObjectAtOffsetTestLanguagePackage#getModel_Bars()
   * @model containment="true"
   * @generated
   */
  EList<AbstractBar> getBars();

} // Model
