/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.serializer.sequencertest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alt List2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.AltList2#getVal1 <em>Val1</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.AltList2#getVal2 <em>Val2</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.AltList2#getVal3 <em>Val3</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getAltList2()
 * @model
 * @generated
 */
public interface AltList2 extends EObject
{
  /**
   * Returns the value of the '<em><b>Val1</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val1</em>' attribute list.
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getAltList2_Val1()
   * @model unique="false"
   * @generated
   */
  EList<String> getVal1();

  /**
   * Returns the value of the '<em><b>Val2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val2</em>' attribute.
   * @see #setVal2(String)
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getAltList2_Val2()
   * @model
   * @generated
   */
  String getVal2();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.sequencertest.AltList2#getVal2 <em>Val2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val2</em>' attribute.
   * @see #getVal2()
   * @generated
   */
  void setVal2(String value);

  /**
   * Returns the value of the '<em><b>Val3</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val3</em>' attribute.
   * @see #setVal3(String)
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getAltList2_Val3()
   * @model
   * @generated
   */
  String getVal3();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.sequencertest.AltList2#getVal3 <em>Val3</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val3</em>' attribute.
   * @see #getVal3()
   * @generated
   */
  void setVal3(String value);

} // AltList2
