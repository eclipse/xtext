/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtextTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextTest.NamedArgument#isLiteralValue <em>Literal Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.NamedArgument#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.NamedArgument#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getNamedArgument()
 * @model
 * @generated
 */
public interface NamedArgument extends EObject
{
  /**
   * Returns the value of the '<em><b>Literal Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literal Value</em>' attribute.
   * @see #setLiteralValue(boolean)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getNamedArgument_LiteralValue()
   * @model
   * @generated
   */
  boolean isLiteralValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.NamedArgument#isLiteralValue <em>Literal Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Literal Value</em>' attribute.
   * @see #isLiteralValue()
   * @generated
   */
  void setLiteralValue(boolean value);

  /**
   * Returns the value of the '<em><b>Parameter</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' reference.
   * @see #setParameter(Parameter)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getNamedArgument_Parameter()
   * @model
   * @generated
   */
  Parameter getParameter();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.NamedArgument#getParameter <em>Parameter</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter</em>' reference.
   * @see #getParameter()
   * @generated
   */
  void setParameter(Parameter value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' reference.
   * @see #setValue(Parameter)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getNamedArgument_Value()
   * @model
   * @generated
   */
  Parameter getValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.NamedArgument#getValue <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Parameter value);

} // NamedArgument
