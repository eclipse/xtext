/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage;

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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Gh341TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface Gh341TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "gh341TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2012/gh341TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "gh341TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Gh341TestLanguagePackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.Gh341TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.Gh341TestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.ElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.ElementImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.Gh341TestLanguagePackageImpl#getElement()
   * @generated
   */
  int ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__NAME = 0;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.WorksImpl <em>Works</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.WorksImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.Gh341TestLanguagePackageImpl#getWorks()
   * @generated
   */
  int WORKS = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORKS__NAME = ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORKS__IDS = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Refs</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORKS__REFS = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Works</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORKS_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.BrokenImpl <em>Broken</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.BrokenImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.Gh341TestLanguagePackageImpl#getBroken()
   * @generated
   */
  int BROKEN = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BROKEN__NAME = ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BROKEN__IDS = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Refs</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BROKEN__REFS = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Broken</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BROKEN_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.ThirdImpl <em>Third</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.ThirdImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.Gh341TestLanguagePackageImpl#getThird()
   * @generated
   */
  int THIRD = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD__NAME = ELEMENT__NAME;

  /**
   * The number of structural features of the '<em>Third</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Model#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Model#getElements()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Element
   * @generated
   */
  EClass getElement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Element#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Element#getName()
   * @see #getElement()
   * @generated
   */
  EAttribute getElement_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Works <em>Works</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Works</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Works
   * @generated
   */
  EClass getWorks();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Works#getIds <em>Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Ids</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Works#getIds()
   * @see #getWorks()
   * @generated
   */
  EAttribute getWorks_Ids();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Works#getRefs <em>Refs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Refs</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Works#getRefs()
   * @see #getWorks()
   * @generated
   */
  EReference getWorks_Refs();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Broken <em>Broken</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Broken</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Broken
   * @generated
   */
  EClass getBroken();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Broken#getIds <em>Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Ids</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Broken#getIds()
   * @see #getBroken()
   * @generated
   */
  EAttribute getBroken_Ids();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Broken#getRefs <em>Refs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Refs</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Broken#getRefs()
   * @see #getBroken()
   * @generated
   */
  EReference getBroken_Refs();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Third <em>Third</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Third</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Third
   * @generated
   */
  EClass getThird();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Gh341TestLanguageFactory getGh341TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.Gh341TestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ELEMENTS = eINSTANCE.getModel_Elements();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.ElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.ElementImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.Gh341TestLanguagePackageImpl#getElement()
     * @generated
     */
    EClass ELEMENT = eINSTANCE.getElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.WorksImpl <em>Works</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.WorksImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.Gh341TestLanguagePackageImpl#getWorks()
     * @generated
     */
    EClass WORKS = eINSTANCE.getWorks();

    /**
     * The meta object literal for the '<em><b>Ids</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WORKS__IDS = eINSTANCE.getWorks_Ids();

    /**
     * The meta object literal for the '<em><b>Refs</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WORKS__REFS = eINSTANCE.getWorks_Refs();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.BrokenImpl <em>Broken</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.BrokenImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.Gh341TestLanguagePackageImpl#getBroken()
     * @generated
     */
    EClass BROKEN = eINSTANCE.getBroken();

    /**
     * The meta object literal for the '<em><b>Ids</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BROKEN__IDS = eINSTANCE.getBroken_Ids();

    /**
     * The meta object literal for the '<em><b>Refs</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BROKEN__REFS = eINSTANCE.getBroken_Refs();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.ThirdImpl <em>Third</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.ThirdImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.impl.Gh341TestLanguagePackageImpl#getThird()
     * @generated
     */
    EClass THIRD = eINSTANCE.getThird();

  }

} //Gh341TestLanguagePackage
