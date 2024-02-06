/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.linking.langATestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.linking.langATestLanguage.Type#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.langATestLanguage.Type#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.langATestLanguage.Type#getImplements <em>Implements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.linking.langATestLanguage.LangATestLanguagePackage#getType()
 * @model
 * @generated
 */
public interface Type extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.linking.langATestLanguage.LangATestLanguagePackage#getType_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.langATestLanguage.Type#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends</em>' reference.
   * @see #setExtends(Type)
   * @see org.eclipse.xtext.linking.langATestLanguage.LangATestLanguagePackage#getType_Extends()
   * @model
   * @generated
   */
  Type getExtends();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.langATestLanguage.Type#getExtends <em>Extends</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extends</em>' reference.
   * @see #getExtends()
   * @generated
   */
  void setExtends(Type value);

  /**
   * Returns the value of the '<em><b>Implements</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.linking.langATestLanguage.Type}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Implements</em>' reference list.
   * @see org.eclipse.xtext.linking.langATestLanguage.LangATestLanguagePackage#getType_Implements()
   * @model
   * @generated
   */
  EList<Type> getImplements();

} // Type
