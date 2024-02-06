/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delegation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegation#getDelegate <em>Delegate</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage#getDelegation()
 * @model
 * @generated
 */
public interface Delegation extends Root
{
  /**
   * Returns the value of the '<em><b>Delegate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Delegate</em>' containment reference.
   * @see #setDelegate(Delegate)
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage#getDelegation_Delegate()
   * @model containment="true"
   * @generated
   */
  Delegate getDelegate();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegation#getDelegate <em>Delegate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Delegate</em>' containment reference.
   * @see #getDelegate()
   * @generated
   */
  void setDelegate(Delegate value);

} // Delegation
