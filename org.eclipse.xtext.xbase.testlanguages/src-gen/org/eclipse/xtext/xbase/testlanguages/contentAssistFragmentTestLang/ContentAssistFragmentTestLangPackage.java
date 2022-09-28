/**
 * Copyright (c) 2011, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLangFactory
 * @model kind="package"
 * @generated
 */
public interface ContentAssistFragmentTestLangPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "contentAssistFragmentTestLang";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/xbase/testlanguages/ContentAssistFragmentTestLang";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "contentAssistFragmentTestLang";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ContentAssistFragmentTestLangPackage eINSTANCE = org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.impl.ContentAssistFragmentTestLangPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.impl.ContentAssistFragmentTestLanguageRootImpl <em>Content Assist Fragment Test Language Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.impl.ContentAssistFragmentTestLanguageRootImpl
   * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.impl.ContentAssistFragmentTestLangPackageImpl#getContentAssistFragmentTestLanguageRoot()
   * @generated
   */
  int CONTENT_ASSIST_FRAGMENT_TEST_LANGUAGE_ROOT = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTENT_ASSIST_FRAGMENT_TEST_LANGUAGE_ROOT__EXPRESSION = 0;

  /**
   * The feature id for the '<em><b>Entities</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTENT_ASSIST_FRAGMENT_TEST_LANGUAGE_ROOT__ENTITIES = 1;

  /**
   * The number of structural features of the '<em>Content Assist Fragment Test Language Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTENT_ASSIST_FRAGMENT_TEST_LANGUAGE_ROOT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.impl.EntityImpl <em>Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.impl.EntityImpl
   * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.impl.ContentAssistFragmentTestLangPackageImpl#getEntity()
   * @generated
   */
  int ENTITY = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__NAME = 0;

  /**
   * The feature id for the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__EXTENDS = 1;

  /**
   * The number of structural features of the '<em>Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLanguageRoot <em>Content Assist Fragment Test Language Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Content Assist Fragment Test Language Root</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLanguageRoot
   * @generated
   */
  EClass getContentAssistFragmentTestLanguageRoot();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLanguageRoot#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLanguageRoot#getExpression()
   * @see #getContentAssistFragmentTestLanguageRoot()
   * @generated
   */
  EReference getContentAssistFragmentTestLanguageRoot_Expression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLanguageRoot#getEntities <em>Entities</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entities</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLanguageRoot#getEntities()
   * @see #getContentAssistFragmentTestLanguageRoot()
   * @generated
   */
  EReference getContentAssistFragmentTestLanguageRoot_Entities();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.Entity <em>Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entity</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.Entity
   * @generated
   */
  EClass getEntity();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.Entity#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.Entity#getName()
   * @see #getEntity()
   * @generated
   */
  EAttribute getEntity_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.Entity#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Extends</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.Entity#getExtends()
   * @see #getEntity()
   * @generated
   */
  EReference getEntity_Extends();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ContentAssistFragmentTestLangFactory getContentAssistFragmentTestLangFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.impl.ContentAssistFragmentTestLanguageRootImpl <em>Content Assist Fragment Test Language Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.impl.ContentAssistFragmentTestLanguageRootImpl
     * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.impl.ContentAssistFragmentTestLangPackageImpl#getContentAssistFragmentTestLanguageRoot()
     * @generated
     */
    EClass CONTENT_ASSIST_FRAGMENT_TEST_LANGUAGE_ROOT = eINSTANCE.getContentAssistFragmentTestLanguageRoot();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTENT_ASSIST_FRAGMENT_TEST_LANGUAGE_ROOT__EXPRESSION = eINSTANCE.getContentAssistFragmentTestLanguageRoot_Expression();

    /**
     * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTENT_ASSIST_FRAGMENT_TEST_LANGUAGE_ROOT__ENTITIES = eINSTANCE.getContentAssistFragmentTestLanguageRoot_Entities();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.impl.EntityImpl <em>Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.impl.EntityImpl
     * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.impl.ContentAssistFragmentTestLangPackageImpl#getEntity()
     * @generated
     */
    EClass ENTITY = eINSTANCE.getEntity();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTITY__NAME = eINSTANCE.getEntity_Name();

    /**
     * The meta object literal for the '<em><b>Extends</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY__EXTENDS = eINSTANCE.getEntity_Extends();

  }

} //ContentAssistFragmentTestLangPackage
