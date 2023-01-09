/**
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.codetemplates.templates;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.Variable#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.Variable#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.Variable#isExpectingParameters <em>Expecting Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.Variable#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends TemplatePart
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getVariable_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.codetemplates.templates.Variable#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getVariable_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.codetemplates.templates.Variable#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Expecting Parameters</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expecting Parameters</em>' attribute.
   * @see #setExpectingParameters(boolean)
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getVariable_ExpectingParameters()
   * @model
   * @generated
   */
  boolean isExpectingParameters();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.codetemplates.templates.Variable#isExpectingParameters <em>Expecting Parameters</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expecting Parameters</em>' attribute.
   * @see #isExpectingParameters()
   * @generated
   */
  void setExpectingParameters(boolean value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' attribute list.
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getVariable_Parameters()
   * @model unique="false"
   * @generated
   */
  EList<String> getParameters();

} // Variable
