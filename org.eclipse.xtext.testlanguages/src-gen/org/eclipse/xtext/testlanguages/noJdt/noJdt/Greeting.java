/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.noJdt.noJdt;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Greeting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.noJdt.noJdt.Greeting#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.noJdt.noJdt.Greeting#getOther <em>Other</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.noJdt.noJdt.NoJdtPackage#getGreeting()
 * @model
 * @generated
 */
public interface Greeting extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.testlanguages.noJdt.noJdt.NoJdtPackage#getGreeting_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.noJdt.noJdt.Greeting#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Other</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Other</em>' reference.
   * @see #setOther(Greeting)
   * @see org.eclipse.xtext.testlanguages.noJdt.noJdt.NoJdtPackage#getGreeting_Other()
   * @model
   * @generated
   */
  Greeting getOther();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.noJdt.noJdt.Greeting#getOther <em>Other</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Other</em>' reference.
   * @see #getOther()
   * @generated
   */
  void setOther(Greeting value);

} // Greeting
