/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.lexer.backtrackingTestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xb</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.Xb#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.Xb#getY <em>Y</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getXb()
 * @model
 * @generated
 */
public interface Xb extends EObject
{
  /**
   * Returns the value of the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>X</em>' attribute.
   * @see #setX(String)
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getXb_X()
   * @model
   * @generated
   */
  String getX();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.Xb#getX <em>X</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>X</em>' attribute.
   * @see #getX()
   * @generated
   */
  void setX(String value);

  /**
   * Returns the value of the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Y</em>' attribute.
   * @see #setY(String)
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getXb_Y()
   * @model
   * @generated
   */
  String getY();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.Xb#getY <em>Y</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Y</em>' attribute.
   * @see #getY()
   * @generated
   */
  void setY(String value);

} // Xb
