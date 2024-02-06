/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parsetree.reconstr.bug299395;

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
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.bug299395.Model#getStrings <em>Strings</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.bug299395.Model#getKeys <em>Keys</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.bug299395.Model#getValues <em>Values</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.bug299395.Model#getSubModel <em>Sub Model</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.bug299395.Bug299395Package#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Strings</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Strings</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.Bug299395Package#getModel_Strings()
   * @model unique="false"
   * @generated
   */
  EList<String> getStrings();

  /**
   * Returns the value of the '<em><b>Keys</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Keys</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.Bug299395Package#getModel_Keys()
   * @model unique="false"
   * @generated
   */
  EList<String> getKeys();

  /**
   * Returns the value of the '<em><b>Values</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.Bug299395Package#getModel_Values()
   * @model unique="false"
   * @generated
   */
  EList<String> getValues();

  /**
   * Returns the value of the '<em><b>Sub Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Model</em>' containment reference.
   * @see #setSubModel(SubModel)
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.Bug299395Package#getModel_SubModel()
   * @model containment="true"
   * @generated
   */
  SubModel getSubModel();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.bug299395.Model#getSubModel <em>Sub Model</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sub Model</em>' containment reference.
   * @see #getSubModel()
   * @generated
   */
  void setSubModel(SubModel value);

} // Model
