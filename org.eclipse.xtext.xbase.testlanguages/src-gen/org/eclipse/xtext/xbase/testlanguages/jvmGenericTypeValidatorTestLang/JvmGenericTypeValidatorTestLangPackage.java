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
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS__ABSTRACT = MY_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Extends</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS__EXTENDS = MY_TYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Implements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS__IMPLEMENTS = MY_TYPE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Members</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS__MEMBERS = MY_TYPE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>My Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS_FEATURE_COUNT = MY_TYPE_FEATURE_COUNT + 4;

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
   * The meta object id for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyClassWithSuperTypesImpl <em>My Class With Super Types</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyClassWithSuperTypesImpl
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyClassWithSuperTypes()
   * @generated
   */
  int MY_CLASS_WITH_SUPER_TYPES = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS_WITH_SUPER_TYPES__NAME = MY_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS_WITH_SUPER_TYPES__SUPER_TYPES = MY_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>My Class With Super Types</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS_WITH_SUPER_TYPES_FEATURE_COUNT = MY_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyClassWithWrongAdditionalInferredInterfaceImpl <em>My Class With Wrong Additional Inferred Interface</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyClassWithWrongAdditionalInferredInterfaceImpl
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyClassWithWrongAdditionalInferredInterface()
   * @generated
   */
  int MY_CLASS_WITH_WRONG_ADDITIONAL_INFERRED_INTERFACE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS_WITH_WRONG_ADDITIONAL_INFERRED_INTERFACE__NAME = MY_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Members</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS_WITH_WRONG_ADDITIONAL_INFERRED_INTERFACE__MEMBERS = MY_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>My Class With Wrong Additional Inferred Interface</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS_WITH_WRONG_ADDITIONAL_INFERRED_INTERFACE_FEATURE_COUNT = MY_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyMemberImpl <em>My Member</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyMemberImpl
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyMember()
   * @generated
   */
  int MY_MEMBER = 6;

  /**
   * The number of structural features of the '<em>My Member</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_MEMBER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyConstructorImpl <em>My Constructor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyConstructorImpl
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyConstructor()
   * @generated
   */
  int MY_CONSTRUCTOR = 7;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CONSTRUCTOR__PARAMETERS = MY_MEMBER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CONSTRUCTOR__EXCEPTIONS = MY_MEMBER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CONSTRUCTOR__EXPRESSION = MY_MEMBER_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>My Constructor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CONSTRUCTOR_FEATURE_COUNT = MY_MEMBER_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyFieldImpl <em>My Field</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyFieldImpl
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyField()
   * @generated
   */
  int MY_FIELD = 8;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_FIELD__TYPE = MY_MEMBER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_FIELD__NAME = MY_MEMBER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>My Field</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_FIELD_FEATURE_COUNT = MY_MEMBER_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyMethodImpl <em>My Method</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyMethodImpl
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyMethod()
   * @generated
   */
  int MY_METHOD = 9;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_METHOD__STATIC = MY_MEMBER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Private</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_METHOD__PRIVATE = MY_MEMBER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Synchronized</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_METHOD__SYNCHRONIZED = MY_MEMBER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_METHOD__TYPE_PARAMETERS = MY_MEMBER_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_METHOD__TYPE = MY_MEMBER_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_METHOD__NAME = MY_MEMBER_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_METHOD__PARAMETERS = MY_MEMBER_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_METHOD__EXCEPTIONS = MY_MEMBER_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_METHOD__EXPRESSION = MY_MEMBER_FEATURE_COUNT + 8;

  /**
   * The number of structural features of the '<em>My Method</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_METHOD_FEATURE_COUNT = MY_MEMBER_FEATURE_COUNT + 9;


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
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClass#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClass#isAbstract()
   * @see #getMyClass()
   * @generated
   */
  EAttribute getMyClass_Abstract();

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
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClass#getMembers <em>Members</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Members</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClass#getMembers()
   * @see #getMyClass()
   * @generated
   */
  EReference getMyClass_Members();

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
   * Returns the meta object for class '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClassWithSuperTypes <em>My Class With Super Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Class With Super Types</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClassWithSuperTypes
   * @generated
   */
  EClass getMyClassWithSuperTypes();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClassWithSuperTypes#getSuperTypes <em>Super Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Super Types</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClassWithSuperTypes#getSuperTypes()
   * @see #getMyClassWithSuperTypes()
   * @generated
   */
  EReference getMyClassWithSuperTypes_SuperTypes();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClassWithWrongAdditionalInferredInterface <em>My Class With Wrong Additional Inferred Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Class With Wrong Additional Inferred Interface</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClassWithWrongAdditionalInferredInterface
   * @generated
   */
  EClass getMyClassWithWrongAdditionalInferredInterface();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClassWithWrongAdditionalInferredInterface#getMembers <em>Members</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Members</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClassWithWrongAdditionalInferredInterface#getMembers()
   * @see #getMyClassWithWrongAdditionalInferredInterface()
   * @generated
   */
  EReference getMyClassWithWrongAdditionalInferredInterface_Members();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMember <em>My Member</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Member</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMember
   * @generated
   */
  EClass getMyMember();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyConstructor <em>My Constructor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Constructor</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyConstructor
   * @generated
   */
  EClass getMyConstructor();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyConstructor#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyConstructor#getParameters()
   * @see #getMyConstructor()
   * @generated
   */
  EReference getMyConstructor_Parameters();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyConstructor#getExceptions <em>Exceptions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exceptions</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyConstructor#getExceptions()
   * @see #getMyConstructor()
   * @generated
   */
  EReference getMyConstructor_Exceptions();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyConstructor#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyConstructor#getExpression()
   * @see #getMyConstructor()
   * @generated
   */
  EReference getMyConstructor_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyField <em>My Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Field</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyField
   * @generated
   */
  EClass getMyField();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyField#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyField#getType()
   * @see #getMyField()
   * @generated
   */
  EReference getMyField_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyField#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyField#getName()
   * @see #getMyField()
   * @generated
   */
  EAttribute getMyField_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod <em>My Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Method</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod
   * @generated
   */
  EClass getMyMethod();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#isStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#isStatic()
   * @see #getMyMethod()
   * @generated
   */
  EAttribute getMyMethod_Static();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#isPrivate <em>Private</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Private</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#isPrivate()
   * @see #getMyMethod()
   * @generated
   */
  EAttribute getMyMethod_Private();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#isSynchronized <em>Synchronized</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Synchronized</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#isSynchronized()
   * @see #getMyMethod()
   * @generated
   */
  EAttribute getMyMethod_Synchronized();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#getTypeParameters <em>Type Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#getTypeParameters()
   * @see #getMyMethod()
   * @generated
   */
  EReference getMyMethod_TypeParameters();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#getType()
   * @see #getMyMethod()
   * @generated
   */
  EReference getMyMethod_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#getName()
   * @see #getMyMethod()
   * @generated
   */
  EAttribute getMyMethod_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#getParameters()
   * @see #getMyMethod()
   * @generated
   */
  EReference getMyMethod_Parameters();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#getExceptions <em>Exceptions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exceptions</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#getExceptions()
   * @see #getMyMethod()
   * @generated
   */
  EReference getMyMethod_Exceptions();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod#getExpression()
   * @see #getMyMethod()
   * @generated
   */
  EReference getMyMethod_Expression();

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
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_CLASS__ABSTRACT = eINSTANCE.getMyClass_Abstract();

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
     * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_CLASS__MEMBERS = eINSTANCE.getMyClass_Members();

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

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyClassWithSuperTypesImpl <em>My Class With Super Types</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyClassWithSuperTypesImpl
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyClassWithSuperTypes()
     * @generated
     */
    EClass MY_CLASS_WITH_SUPER_TYPES = eINSTANCE.getMyClassWithSuperTypes();

    /**
     * The meta object literal for the '<em><b>Super Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_CLASS_WITH_SUPER_TYPES__SUPER_TYPES = eINSTANCE.getMyClassWithSuperTypes_SuperTypes();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyClassWithWrongAdditionalInferredInterfaceImpl <em>My Class With Wrong Additional Inferred Interface</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyClassWithWrongAdditionalInferredInterfaceImpl
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyClassWithWrongAdditionalInferredInterface()
     * @generated
     */
    EClass MY_CLASS_WITH_WRONG_ADDITIONAL_INFERRED_INTERFACE = eINSTANCE.getMyClassWithWrongAdditionalInferredInterface();

    /**
     * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_CLASS_WITH_WRONG_ADDITIONAL_INFERRED_INTERFACE__MEMBERS = eINSTANCE.getMyClassWithWrongAdditionalInferredInterface_Members();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyMemberImpl <em>My Member</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyMemberImpl
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyMember()
     * @generated
     */
    EClass MY_MEMBER = eINSTANCE.getMyMember();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyConstructorImpl <em>My Constructor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyConstructorImpl
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyConstructor()
     * @generated
     */
    EClass MY_CONSTRUCTOR = eINSTANCE.getMyConstructor();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_CONSTRUCTOR__PARAMETERS = eINSTANCE.getMyConstructor_Parameters();

    /**
     * The meta object literal for the '<em><b>Exceptions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_CONSTRUCTOR__EXCEPTIONS = eINSTANCE.getMyConstructor_Exceptions();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_CONSTRUCTOR__EXPRESSION = eINSTANCE.getMyConstructor_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyFieldImpl <em>My Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyFieldImpl
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyField()
     * @generated
     */
    EClass MY_FIELD = eINSTANCE.getMyField();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_FIELD__TYPE = eINSTANCE.getMyField_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_FIELD__NAME = eINSTANCE.getMyField_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyMethodImpl <em>My Method</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyMethodImpl
     * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangPackageImpl#getMyMethod()
     * @generated
     */
    EClass MY_METHOD = eINSTANCE.getMyMethod();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_METHOD__STATIC = eINSTANCE.getMyMethod_Static();

    /**
     * The meta object literal for the '<em><b>Private</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_METHOD__PRIVATE = eINSTANCE.getMyMethod_Private();

    /**
     * The meta object literal for the '<em><b>Synchronized</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_METHOD__SYNCHRONIZED = eINSTANCE.getMyMethod_Synchronized();

    /**
     * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_METHOD__TYPE_PARAMETERS = eINSTANCE.getMyMethod_TypeParameters();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_METHOD__TYPE = eINSTANCE.getMyMethod_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_METHOD__NAME = eINSTANCE.getMyMethod_Name();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_METHOD__PARAMETERS = eINSTANCE.getMyMethod_Parameters();

    /**
     * The meta object literal for the '<em><b>Exceptions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_METHOD__EXCEPTIONS = eINSTANCE.getMyMethod_Exceptions();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_METHOD__EXPRESSION = eINSTANCE.getMyMethod_Expression();

  }

} //JvmGenericTypeValidatorTestLangPackage
