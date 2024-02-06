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
 * A representation of the model object '<em><b>Unordered Alternative</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.UnorderedAlternative#getVal1 <em>Val1</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.UnorderedAlternative#getVal2 <em>Val2</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.UnorderedAlternative#getVal3 <em>Val3</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.UnorderedAlternative#getVal4 <em>Val4</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getUnorderedAlternative()
 * @model
 * @generated
 */
public interface UnorderedAlternative extends EObject
{
  /**
   * Returns the value of the '<em><b>Val1</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val1</em>' attribute list.
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getUnorderedAlternative_Val1()
   * @model unique="false"
   * @generated
   */
  EList<String> getVal1();

  /**
   * Returns the value of the '<em><b>Val2</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val2</em>' attribute list.
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getUnorderedAlternative_Val2()
   * @model unique="false"
   * @generated
   */
  EList<Integer> getVal2();

  /**
   * Returns the value of the '<em><b>Val3</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.serializer.sequencertest.UnorderedAlternativeVal}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val3</em>' containment reference list.
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getUnorderedAlternative_Val3()
   * @model containment="true"
   * @generated
   */
  EList<UnorderedAlternativeVal> getVal3();

  /**
   * Returns the value of the '<em><b>Val4</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.serializer.sequencertest.UnorderedAlternativeValDelegate}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val4</em>' containment reference list.
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getUnorderedAlternative_Val4()
   * @model containment="true"
   * @generated
   */
  EList<UnorderedAlternativeValDelegate> getVal4();

} // UnorderedAlternative
