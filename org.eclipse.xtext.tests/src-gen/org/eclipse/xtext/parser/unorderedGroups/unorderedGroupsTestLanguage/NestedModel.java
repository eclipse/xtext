/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nested Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.NestedModel#isFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.NestedModel#isSecond <em>Second</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguagePackage#getNestedModel()
 * @model
 * @generated
 */
public interface NestedModel extends EObject
{
  /**
   * Returns the value of the '<em><b>First</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>First</em>' attribute.
   * @see #setFirst(boolean)
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguagePackage#getNestedModel_First()
   * @model
   * @generated
   */
  boolean isFirst();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.NestedModel#isFirst <em>First</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First</em>' attribute.
   * @see #isFirst()
   * @generated
   */
  void setFirst(boolean value);

  /**
   * Returns the value of the '<em><b>Second</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second</em>' attribute.
   * @see #setSecond(boolean)
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguagePackage#getNestedModel_Second()
   * @model
   * @generated
   */
  boolean isSecond();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.NestedModel#isSecond <em>Second</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Second</em>' attribute.
   * @see #isSecond()
   * @generated
   */
  void setSecond(boolean value);

} // NestedModel
