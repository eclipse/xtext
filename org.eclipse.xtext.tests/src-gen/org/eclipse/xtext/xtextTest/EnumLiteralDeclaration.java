/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtextTest;

import org.eclipse.emf.ecore.EEnumLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Literal Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextTest.EnumLiteralDeclaration#getEnumLiteral <em>Enum Literal</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.EnumLiteralDeclaration#getLiteral <em>Literal</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getEnumLiteralDeclaration()
 * @model
 * @generated
 */
public interface EnumLiteralDeclaration extends AbstractElement
{
  /**
   * Returns the value of the '<em><b>Enum Literal</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enum Literal</em>' reference.
   * @see #setEnumLiteral(EEnumLiteral)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getEnumLiteralDeclaration_EnumLiteral()
   * @model
   * @generated
   */
  EEnumLiteral getEnumLiteral();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.EnumLiteralDeclaration#getEnumLiteral <em>Enum Literal</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enum Literal</em>' reference.
   * @see #getEnumLiteral()
   * @generated
   */
  void setEnumLiteral(EEnumLiteral value);

  /**
   * Returns the value of the '<em><b>Literal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literal</em>' containment reference.
   * @see #setLiteral(Keyword)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getEnumLiteralDeclaration_Literal()
   * @model containment="true"
   * @generated
   */
  Keyword getLiteral();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.EnumLiteralDeclaration#getLiteral <em>Literal</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Literal</em>' containment reference.
   * @see #getLiteral()
   * @generated
   */
  void setLiteral(Keyword value);

} // EnumLiteralDeclaration
