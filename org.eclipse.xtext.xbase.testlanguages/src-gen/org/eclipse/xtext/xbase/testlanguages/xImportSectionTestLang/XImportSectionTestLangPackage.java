/**
 * Copyright (c) 2011, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.XImportSectionTestLangFactory
 * @model kind="package"
 * @generated
 */
public interface XImportSectionTestLangPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "xImportSectionTestLang";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/xbase/testlanguages/XImportSectionTestLang";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "xImportSectionTestLang";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XImportSectionTestLangPackage eINSTANCE = org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.impl.XImportSectionTestLangPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.impl.ImportSectionTestLanguageRootImpl <em>Import Section Test Language Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.impl.ImportSectionTestLanguageRootImpl
   * @see org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.impl.XImportSectionTestLangPackageImpl#getImportSectionTestLanguageRoot()
   * @generated
   */
  int IMPORT_SECTION_TEST_LANGUAGE_ROOT = 0;

  /**
   * The feature id for the '<em><b>Import Section</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_SECTION_TEST_LANGUAGE_ROOT__IMPORT_SECTION = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_SECTION_TEST_LANGUAGE_ROOT__EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Import Section Test Language Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_SECTION_TEST_LANGUAGE_ROOT_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.ImportSectionTestLanguageRoot <em>Import Section Test Language Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import Section Test Language Root</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.ImportSectionTestLanguageRoot
   * @generated
   */
  EClass getImportSectionTestLanguageRoot();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.ImportSectionTestLanguageRoot#getImportSection <em>Import Section</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Import Section</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.ImportSectionTestLanguageRoot#getImportSection()
   * @see #getImportSectionTestLanguageRoot()
   * @generated
   */
  EReference getImportSectionTestLanguageRoot_ImportSection();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.ImportSectionTestLanguageRoot#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.ImportSectionTestLanguageRoot#getExpression()
   * @see #getImportSectionTestLanguageRoot()
   * @generated
   */
  EReference getImportSectionTestLanguageRoot_Expression();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  XImportSectionTestLangFactory getXImportSectionTestLangFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.impl.ImportSectionTestLanguageRootImpl <em>Import Section Test Language Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.impl.ImportSectionTestLanguageRootImpl
     * @see org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.impl.XImportSectionTestLangPackageImpl#getImportSectionTestLanguageRoot()
     * @generated
     */
    EClass IMPORT_SECTION_TEST_LANGUAGE_ROOT = eINSTANCE.getImportSectionTestLanguageRoot();

    /**
     * The meta object literal for the '<em><b>Import Section</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPORT_SECTION_TEST_LANGUAGE_ROOT__IMPORT_SECTION = eINSTANCE.getImportSectionTestLanguageRoot_ImportSection();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPORT_SECTION_TEST_LANGUAGE_ROOT__EXPRESSION = eINSTANCE.getImportSectionTestLanguageRoot_Expression();

  }

} //XImportSectionTestLangPackage
