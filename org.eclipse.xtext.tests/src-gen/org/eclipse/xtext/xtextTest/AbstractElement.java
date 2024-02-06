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
 * A representation of the model object '<em><b>Abstract Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextTest.AbstractElement#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.AbstractElement#isPredicated <em>Predicated</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.AbstractElement#isFirstSetPredicated <em>First Set Predicated</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getAbstractElement()
 * @model
 * @generated
 */
public interface AbstractElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cardinality</em>' attribute.
   * @see #setCardinality(String)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getAbstractElement_Cardinality()
   * @model
   * @generated
   */
  String getCardinality();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.AbstractElement#getCardinality <em>Cardinality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cardinality</em>' attribute.
   * @see #getCardinality()
   * @generated
   */
  void setCardinality(String value);

  /**
   * Returns the value of the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Predicated</em>' attribute.
   * @see #setPredicated(boolean)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getAbstractElement_Predicated()
   * @model
   * @generated
   */
  boolean isPredicated();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.AbstractElement#isPredicated <em>Predicated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Predicated</em>' attribute.
   * @see #isPredicated()
   * @generated
   */
  void setPredicated(boolean value);

  /**
   * Returns the value of the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>First Set Predicated</em>' attribute.
   * @see #setFirstSetPredicated(boolean)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getAbstractElement_FirstSetPredicated()
   * @model
   * @generated
   */
  boolean isFirstSetPredicated();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.AbstractElement#isFirstSetPredicated <em>First Set Predicated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First Set Predicated</em>' attribute.
   * @see #isFirstSetPredicated()
   * @generated
   */
  void setFirstSetPredicated(boolean value);

} // AbstractElement
