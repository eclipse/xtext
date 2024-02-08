/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.bug385636;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.bug385636.Program#getDefine <em>Define</em>}</li>
 *   <li>{@link org.eclipse.xtext.resource.bug385636.Program#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.resource.bug385636.Bug385636Package#getProgram()
 * @model
 * @generated
 */
public interface Program extends EObject
{
  /**
   * Returns the value of the '<em><b>Define</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Define</em>' containment reference.
   * @see #setDefine(DefineVariables)
   * @see org.eclipse.xtext.resource.bug385636.Bug385636Package#getProgram_Define()
   * @model containment="true"
   * @generated
   */
  DefineVariables getDefine();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.resource.bug385636.Program#getDefine <em>Define</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Define</em>' containment reference.
   * @see #getDefine()
   * @generated
   */
  void setDefine(DefineVariables value);

  /**
   * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.resource.bug385636.Expression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statements</em>' containment reference list.
   * @see org.eclipse.xtext.resource.bug385636.Bug385636Package#getProgram_Statements()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getStatements();

} // Program
