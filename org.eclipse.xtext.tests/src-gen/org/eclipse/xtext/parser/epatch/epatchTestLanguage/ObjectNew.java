/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object New</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectNew#getImport <em>Import</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectNew#getImpFrag <em>Imp Frag</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getObjectNew()
 * @model
 * @generated
 */
public interface ObjectNew extends CreatedObject
{
  /**
   * Returns the value of the '<em><b>Import</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import</em>' reference.
   * @see #setImport(Import)
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getObjectNew_Import()
   * @model
   * @generated
   */
  Import getImport();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectNew#getImport <em>Import</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import</em>' reference.
   * @see #getImport()
   * @generated
   */
  void setImport(Import value);

  /**
   * Returns the value of the '<em><b>Imp Frag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imp Frag</em>' attribute.
   * @see #setImpFrag(String)
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getObjectNew_ImpFrag()
   * @model
   * @generated
   */
  String getImpFrag();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectNew#getImpFrag <em>Imp Frag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Imp Frag</em>' attribute.
   * @see #getImpFrag()
   * @generated
   */
  void setImpFrag(String value);

} // ObjectNew
