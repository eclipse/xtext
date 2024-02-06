/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parsetree.unassignedtext.unassignedtext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plural Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.PluralRule#getCount <em>Count</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.UnassignedtextPackage#getPluralRule()
 * @model
 * @generated
 */
public interface PluralRule extends Model
{
  /**
   * Returns the value of the '<em><b>Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Count</em>' attribute.
   * @see #setCount(int)
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.UnassignedtextPackage#getPluralRule_Count()
   * @model
   * @generated
   */
  int getCount();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.PluralRule#getCount <em>Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Count</em>' attribute.
   * @see #getCount()
   * @generated
   */
  void setCount(int value);

} // PluralRule
