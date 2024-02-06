/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Expression#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Expression#getTerms <em>Terms</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Expression#getPostfix <em>Postfix</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.BacktrackingBug325745TestLanguagePackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends EObject
{
  /**
   * Returns the value of the '<em><b>Prefix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Prefix</em>' attribute.
   * @see #setPrefix(String)
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.BacktrackingBug325745TestLanguagePackage#getExpression_Prefix()
   * @model
   * @generated
   */
  String getPrefix();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Expression#getPrefix <em>Prefix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prefix</em>' attribute.
   * @see #getPrefix()
   * @generated
   */
  void setPrefix(String value);

  /**
   * Returns the value of the '<em><b>Terms</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.SimpleTerm}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Terms</em>' containment reference list.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.BacktrackingBug325745TestLanguagePackage#getExpression_Terms()
   * @model containment="true"
   * @generated
   */
  EList<SimpleTerm> getTerms();

  /**
   * Returns the value of the '<em><b>Postfix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Postfix</em>' attribute.
   * @see #setPostfix(String)
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.BacktrackingBug325745TestLanguagePackage#getExpression_Postfix()
   * @model
   * @generated
   */
  String getPostfix();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Expression#getPostfix <em>Postfix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Postfix</em>' attribute.
   * @see #getPostfix()
   * @generated
   */
  void setPostfix(String value);

} // Expression
