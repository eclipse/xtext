/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.validation.csvalidationtest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assigned Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.AssignedAction#getVal1 <em>Val1</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.AssignedAction#getChild <em>Child</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.AssignedAction#getVal2 <em>Val2</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getAssignedAction()
 * @model
 * @generated
 */
public interface AssignedAction extends EObject
{
  /**
   * Returns the value of the '<em><b>Val1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val1</em>' attribute.
   * @see #setVal1(String)
   * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getAssignedAction_Val1()
   * @model
   * @generated
   */
  String getVal1();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.validation.csvalidationtest.AssignedAction#getVal1 <em>Val1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val1</em>' attribute.
   * @see #getVal1()
   * @generated
   */
  void setVal1(String value);

  /**
   * Returns the value of the '<em><b>Child</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Child</em>' containment reference.
   * @see #setChild(AssignedAction)
   * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getAssignedAction_Child()
   * @model containment="true"
   * @generated
   */
  AssignedAction getChild();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.validation.csvalidationtest.AssignedAction#getChild <em>Child</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Child</em>' containment reference.
   * @see #getChild()
   * @generated
   */
  void setChild(AssignedAction value);

  /**
   * Returns the value of the '<em><b>Val2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val2</em>' attribute.
   * @see #setVal2(String)
   * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getAssignedAction_Val2()
   * @model
   * @generated
   */
  String getVal2();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.validation.csvalidationtest.AssignedAction#getVal2 <em>Val2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val2</em>' attribute.
   * @see #getVal2()
   * @generated
   */
  void setVal2(String value);

} // AssignedAction
