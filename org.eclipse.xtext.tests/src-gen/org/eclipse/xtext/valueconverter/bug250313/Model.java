/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.valueconverter.bug250313;

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
 *   <li>{@link org.eclipse.xtext.valueconverter.bug250313.Model#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.valueconverter.bug250313.Model#getMultiValue <em>Multi Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.valueconverter.bug250313.Model#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.valueconverter.bug250313.Bug250313Package#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.eclipse.xtext.valueconverter.bug250313.Bug250313Package#getModel_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.valueconverter.bug250313.Model#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Multi Value</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multi Value</em>' attribute list.
   * @see org.eclipse.xtext.valueconverter.bug250313.Bug250313Package#getModel_MultiValue()
   * @model unique="false"
   * @generated
   */
  EList<String> getMultiValue();

  /**
   * Returns the value of the '<em><b>Children</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Children</em>' containment reference.
   * @see #setChildren(Child)
   * @see org.eclipse.xtext.valueconverter.bug250313.Bug250313Package#getModel_Children()
   * @model containment="true"
   * @generated
   */
  Child getChildren();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.valueconverter.bug250313.Model#getChildren <em>Children</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Children</em>' containment reference.
   * @see #getChildren()
   * @generated
   */
  void setChildren(Child value);

} // Model
