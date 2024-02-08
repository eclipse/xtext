/**
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity With Enum And Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EnumAndReferenceTestLanguagePackage#getEntityWithEnumAndReference()
 * @model
 * @generated
 */
public interface EntityWithEnumAndReference extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.KindOfKeyword}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.KindOfKeyword
   * @see #setType(KindOfKeyword)
   * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EnumAndReferenceTestLanguagePackage#getEntityWithEnumAndReference_Type()
   * @model
   * @generated
   */
  KindOfKeyword getType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.KindOfKeyword
   * @see #getType()
   * @generated
   */
  void setType(KindOfKeyword value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EnumAndReferenceTestLanguagePackage#getEntityWithEnumAndReference_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(EntityWithEnumAndReference)
   * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EnumAndReferenceTestLanguagePackage#getEntityWithEnumAndReference_Ref()
   * @model
   * @generated
   */
  EntityWithEnumAndReference getRef();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(EntityWithEnumAndReference value);

} // EntityWithEnumAndReference
