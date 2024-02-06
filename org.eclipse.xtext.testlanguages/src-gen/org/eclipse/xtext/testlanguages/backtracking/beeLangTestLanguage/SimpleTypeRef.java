/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Type Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.SimpleTypeRef#getRawType <em>Raw Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.SimpleTypeRef#getActualArgumentsList <em>Actual Arguments List</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.BeeLangTestLanguagePackage#getSimpleTypeRef()
 * @model
 * @generated
 */
public interface SimpleTypeRef extends TypeRef
{
  /**
   * Returns the value of the '<em><b>Raw Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Raw Type</em>' attribute.
   * @see #setRawType(String)
   * @see org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.BeeLangTestLanguagePackage#getSimpleTypeRef_RawType()
   * @model
   * @generated
   */
  String getRawType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.SimpleTypeRef#getRawType <em>Raw Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Raw Type</em>' attribute.
   * @see #getRawType()
   * @generated
   */
  void setRawType(String value);

  /**
   * Returns the value of the '<em><b>Actual Arguments List</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actual Arguments List</em>' attribute list.
   * @see org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.BeeLangTestLanguagePackage#getSimpleTypeRef_ActualArgumentsList()
   * @model unique="false"
   * @generated
   */
  EList<String> getActualArgumentsList();

} // SimpleTypeRef
