/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.referenceGrammar;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.referenceGrammar.Person#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.referenceGrammar.Person#getAge <em>Age</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.referenceGrammar.ReferenceGrammarPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.testlanguages.referenceGrammar.ReferenceGrammarPackage#getPerson_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.referenceGrammar.Person#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Age</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Age</em>' attribute.
   * @see #setAge(int)
   * @see org.eclipse.xtext.testlanguages.referenceGrammar.ReferenceGrammarPackage#getPerson_Age()
   * @model
   * @generated
   */
  int getAge();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.referenceGrammar.Person#getAge <em>Age</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Age</em>' attribute.
   * @see #getAge()
   * @generated
   */
  void setAge(int value);

} // Person
