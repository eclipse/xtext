/**
 * Copyright (c) 2011, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

import org.eclipse.xtext.xtype.XImportSection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Section Test Language Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.ImportSectionTestLanguageRoot#getImportSection <em>Import Section</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.ImportSectionTestLanguageRoot#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.XImportSectionTestLangPackage#getImportSectionTestLanguageRoot()
 * @model
 * @generated
 */
public interface ImportSectionTestLanguageRoot extends EObject
{
  /**
   * Returns the value of the '<em><b>Import Section</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import Section</em>' containment reference.
   * @see #setImportSection(XImportSection)
   * @see org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.XImportSectionTestLangPackage#getImportSectionTestLanguageRoot_ImportSection()
   * @model containment="true"
   * @generated
   */
  XImportSection getImportSection();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.ImportSectionTestLanguageRoot#getImportSection <em>Import Section</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import Section</em>' containment reference.
   * @see #getImportSection()
   * @generated
   */
  void setImportSection(XImportSection value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(XExpression)
   * @see org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.XImportSectionTestLangPackage#getImportSectionTestLanguageRoot_Expression()
   * @model containment="true"
   * @generated
   */
  XExpression getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.ImportSectionTestLanguageRoot#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(XExpression value);

} // ImportSectionTestLanguageRoot
