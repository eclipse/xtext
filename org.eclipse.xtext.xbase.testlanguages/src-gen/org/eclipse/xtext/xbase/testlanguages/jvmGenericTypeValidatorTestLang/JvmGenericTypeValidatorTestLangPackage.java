/**
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang;

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
 * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangFactory
 * @model kind="package"
 * @generated
 */
public interface JvmGenericTypeValidatorTestLangPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "jvmGenericTypeValidatorTestLang";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/xbase/testlanguages/JvmGenericTypeValidatorTestLang";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "jvmGenericTypeValidatorTestLang";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  JvmGenericTypeValidatorTestLangPackage eINSTANCE = org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangModelImpl
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getJvmGenericTypeValidatorTestLangModel()
   * @generated
   */
  int JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL = 0;

  /**
   * The feature id for the '<em><b>Package</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__PACKAGE = 0;

  /**
   * The feature id for the '<em><b>Import Section</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__IMPORT_SECTION = 1;

  /**
   * The feature id for the '<em><b>Model Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__MODEL_TYPES = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyTypeImpl <em>My Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyTypeImpl
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyType()
   * @generated
   */
  int MY_TYPE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_TYPE__NAME = 0;

  /**
   * The number of structural features of the '<em>My Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyClassImpl <em>My Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyClassImpl
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyClass()
   * @generated
   */
  int MY_CLASS = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS__NAME = MY_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Extends</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS__EXTENDS = MY_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Implements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS__IMPLEMENTS = MY_TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>My Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS_FEATURE_COUNT = MY_TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyInterfaceImpl <em>My Interface</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyInterfaceImpl
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyInterface()
   * @generated
   */
  int MY_INTERFACE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_INTERFACE__NAME = MY_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_INTERFACE__TYPE_PARAMETERS = MY_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Extends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_INTERFACE__EXTENDS = MY_TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>My Interface</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_INTERFACE_FEATURE_COUNT = MY_TYPE_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangModel
   * @generated
   */
  EClass getJvmGenericTypeValidatorTestLangModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangModel#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Package</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangModel#getPackage()
   * @see #getJvmGenericTypeValidatorTestLangModel()
   * @generated
   */
  EAttribute getJvmGenericTypeValidatorTestLangModel_Package();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangModel#getImportSection <em>Import Section</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Import Section</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangModel#getImportSection()
   * @see #getJvmGenericTypeValidatorTestLangModel()
   * @generated
   */
  EReference getJvmGenericTypeValidatorTestLangModel_ImportSection();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangModel#getModelTypes <em>Model Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Model Types</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangModel#getModelTypes()
   * @see #getJvmGenericTypeValidatorTestLangModel()
   * @generated
   */
  EReference getJvmGenericTypeValidatorTestLangModel_ModelTypes();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyType <em>My Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Type</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyType
   * @generated
   */
  EClass getMyType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyType#getName()
   * @see #getMyType()
   * @generated
   */
  EAttribute getMyType_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClass <em>My Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Class</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClass
   * @generated
   */
  EClass getMyClass();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClass#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Extends</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClass#getExtends()
   * @see #getMyClass()
   * @generated
   */
  EReference getMyClass_Extends();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClass#getImplements <em>Implements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Implements</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClass#getImplements()
   * @see #getMyClass()
   * @generated
   */
  EReference getMyClass_Implements();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyInterface <em>My Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Interface</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyInterface
   * @generated
   */
  EClass getMyInterface();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyInterface#getTypeParameters <em>Type Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyInterface#getTypeParameters()
   * @see #getMyInterface()
   * @generated
   */
  EReference getMyInterface_TypeParameters();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyInterface#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Extends</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyInterface#getExtends()
   * @see #getMyInterface()
   * @generated
   */
  EReference getMyInterface_Extends();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  JvmGenericTypeValidatorTestLangFactory getJvmGenericTypeValidatorTestLangFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangModelImpl
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getJvmGenericTypeValidatorTestLangModel()
     * @generated
     */
    EClass JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL = eINSTANCE.getJvmGenericTypeValidatorTestLangModel();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__PACKAGE = eINSTANCE.getJvmGenericTypeValidatorTestLangModel_Package();

    /**
     * The meta object literal for the '<em><b>Import Section</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__IMPORT_SECTION = eINSTANCE.getJvmGenericTypeValidatorTestLangModel_ImportSection();

    /**
     * The meta object literal for the '<em><b>Model Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__MODEL_TYPES = eINSTANCE.getJvmGenericTypeValidatorTestLangModel_ModelTypes();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyTypeImpl <em>My Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyTypeImpl
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyType()
     * @generated
     */
    EClass MY_TYPE = eINSTANCE.getMyType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_TYPE__NAME = eINSTANCE.getMyType_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyClassImpl <em>My Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyClassImpl
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyClass()
     * @generated
     */
    EClass MY_CLASS = eINSTANCE.getMyClass();

    /**
     * The meta object literal for the '<em><b>Extends</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_CLASS__EXTENDS = eINSTANCE.getMyClass_Extends();

    /**
     * The meta object literal for the '<em><b>Implements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_CLASS__IMPLEMENTS = eINSTANCE.getMyClass_Implements();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyInterfaceImpl <em>My Interface</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyInterfaceImpl
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyInterface()
     * @generated
     */
    EClass MY_INTERFACE = eINSTANCE.getMyInterface();

    /**
     * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_INTERFACE__TYPE_PARAMETERS = eINSTANCE.getMyInterface_TypeParameters();

    /**
     * The meta object literal for the '<em><b>Extends</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_INTERFACE__EXTENDS = eINSTANCE.getMyInterface_Extends();

  }

} //JvmGenericTypeValidatorTestLangPackage
