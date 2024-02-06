/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.SingleAssignment#getLeftValue <em>Left Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.SingleAssignment#getRightValue <em>Right Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getSingleAssignment()
 * @model
 * @generated
 */
public interface SingleAssignment extends Assignment
{
  /**
   * Returns the value of the '<em><b>Left Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left Value</em>' containment reference.
   * @see #setLeftValue(AssignmentValue)
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getSingleAssignment_LeftValue()
   * @model containment="true"
   * @generated
   */
  AssignmentValue getLeftValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.SingleAssignment#getLeftValue <em>Left Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left Value</em>' containment reference.
   * @see #getLeftValue()
   * @generated
   */
  void setLeftValue(AssignmentValue value);

  /**
   * Returns the value of the '<em><b>Right Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Value</em>' containment reference.
   * @see #setRightValue(AssignmentValue)
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getSingleAssignment_RightValue()
   * @model containment="true"
   * @generated
   */
  AssignmentValue getRightValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.SingleAssignment#getRightValue <em>Right Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Value</em>' containment reference.
   * @see #getRightValue()
   * @generated
   */
  void setRightValue(AssignmentValue value);

} // SingleAssignment
