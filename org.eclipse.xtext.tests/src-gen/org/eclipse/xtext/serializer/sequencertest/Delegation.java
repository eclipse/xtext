/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.serializer.sequencertest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delegation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.Delegation#getP <em>P</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.Delegation#getNp <em>Np</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getDelegation()
 * @model
 * @generated
 */
public interface Delegation extends EObject
{
  /**
   * Returns the value of the '<em><b>P</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>P</em>' attribute.
   * @see #setP(String)
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getDelegation_P()
   * @model
   * @generated
   */
  String getP();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.sequencertest.Delegation#getP <em>P</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>P</em>' attribute.
   * @see #getP()
   * @generated
   */
  void setP(String value);

  /**
   * Returns the value of the '<em><b>Np</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Np</em>' attribute.
   * @see #setNp(int)
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getDelegation_Np()
   * @model
   * @generated
   */
  int getNp();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.sequencertest.Delegation#getNp <em>Np</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Np</em>' attribute.
   * @see #getNp()
   * @generated
   */
  void setNp(int value);

} // Delegation
