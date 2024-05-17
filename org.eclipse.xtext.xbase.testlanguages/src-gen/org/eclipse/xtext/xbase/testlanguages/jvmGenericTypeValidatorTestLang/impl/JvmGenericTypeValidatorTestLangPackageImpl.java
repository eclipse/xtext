/**
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.xbase.XbasePackage;

import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangFactory;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangModel;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangPackage;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClass;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClassWithSuperTypes;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClassWithWrongAdditionalInferredInterface;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyConstructor;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyField;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyInterface;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMember;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyType;

import org.eclipse.xtext.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JvmGenericTypeValidatorTestLangPackageImpl extends EPackageImpl implements JvmGenericTypeValidatorTestLangPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass jvmGenericTypeValidatorTestLangModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myInterfaceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myClassWithSuperTypesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myClassWithWrongAdditionalInferredInterfaceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myMemberEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myConstructorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myFieldEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myMethodEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private JvmGenericTypeValidatorTestLangPackageImpl()
  {
    super(eNS_URI, JvmGenericTypeValidatorTestLangFactory.eINSTANCE);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   *
   * <p>This method is used to initialize {@link JvmGenericTypeValidatorTestLangPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static JvmGenericTypeValidatorTestLangPackage init()
  {
    if (isInited) return (JvmGenericTypeValidatorTestLangPackage)EPackage.Registry.INSTANCE.getEPackage(JvmGenericTypeValidatorTestLangPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredJvmGenericTypeValidatorTestLangPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    JvmGenericTypeValidatorTestLangPackageImpl theJvmGenericTypeValidatorTestLangPackage = registeredJvmGenericTypeValidatorTestLangPackage instanceof JvmGenericTypeValidatorTestLangPackageImpl ? (JvmGenericTypeValidatorTestLangPackageImpl)registeredJvmGenericTypeValidatorTestLangPackage : new JvmGenericTypeValidatorTestLangPackageImpl();

    isInited = true;

    // Initialize simple dependencies
    TypesPackage.eINSTANCE.eClass();
    XbasePackage.eINSTANCE.eClass();
    XtypePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theJvmGenericTypeValidatorTestLangPackage.createPackageContents();

    // Initialize created meta-data
    theJvmGenericTypeValidatorTestLangPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theJvmGenericTypeValidatorTestLangPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(JvmGenericTypeValidatorTestLangPackage.eNS_URI, theJvmGenericTypeValidatorTestLangPackage);
    return theJvmGenericTypeValidatorTestLangPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getJvmGenericTypeValidatorTestLangModel()
  {
    return jvmGenericTypeValidatorTestLangModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getJvmGenericTypeValidatorTestLangModel_Package()
  {
    return (EAttribute)jvmGenericTypeValidatorTestLangModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getJvmGenericTypeValidatorTestLangModel_ImportSection()
  {
    return (EReference)jvmGenericTypeValidatorTestLangModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getJvmGenericTypeValidatorTestLangModel_ModelTypes()
  {
    return (EReference)jvmGenericTypeValidatorTestLangModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMyType()
  {
    return myTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMyType_Name()
  {
    return (EAttribute)myTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMyClass()
  {
    return myClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMyClass_Abstract()
  {
    return (EAttribute)myClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMyClass_Extends()
  {
    return (EReference)myClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMyClass_Implements()
  {
    return (EReference)myClassEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMyClass_Members()
  {
    return (EReference)myClassEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMyInterface()
  {
    return myInterfaceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMyInterface_TypeParameters()
  {
    return (EReference)myInterfaceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMyInterface_Extends()
  {
    return (EReference)myInterfaceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMyClassWithSuperTypes()
  {
    return myClassWithSuperTypesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMyClassWithSuperTypes_SuperTypes()
  {
    return (EReference)myClassWithSuperTypesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMyClassWithWrongAdditionalInferredInterface()
  {
    return myClassWithWrongAdditionalInferredInterfaceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMyClassWithWrongAdditionalInferredInterface_Members()
  {
    return (EReference)myClassWithWrongAdditionalInferredInterfaceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMyMember()
  {
    return myMemberEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMyConstructor()
  {
    return myConstructorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMyConstructor_Parameters()
  {
    return (EReference)myConstructorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMyConstructor_Exceptions()
  {
    return (EReference)myConstructorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMyConstructor_Expression()
  {
    return (EReference)myConstructorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMyField()
  {
    return myFieldEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMyField_Type()
  {
    return (EReference)myFieldEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMyField_Name()
  {
    return (EAttribute)myFieldEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMyMethod()
  {
    return myMethodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMyMethod_Static()
  {
    return (EAttribute)myMethodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMyMethod_Private()
  {
    return (EAttribute)myMethodEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMyMethod_Synchronized()
  {
    return (EAttribute)myMethodEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMyMethod_TypeParameters()
  {
    return (EReference)myMethodEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMyMethod_Type()
  {
    return (EReference)myMethodEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMyMethod_Name()
  {
    return (EAttribute)myMethodEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMyMethod_Parameters()
  {
    return (EReference)myMethodEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMyMethod_Exceptions()
  {
    return (EReference)myMethodEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMyMethod_Expression()
  {
    return (EReference)myMethodEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JvmGenericTypeValidatorTestLangFactory getJvmGenericTypeValidatorTestLangFactory()
  {
    return (JvmGenericTypeValidatorTestLangFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    jvmGenericTypeValidatorTestLangModelEClass = createEClass(JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL);
    createEAttribute(jvmGenericTypeValidatorTestLangModelEClass, JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__PACKAGE);
    createEReference(jvmGenericTypeValidatorTestLangModelEClass, JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__IMPORT_SECTION);
    createEReference(jvmGenericTypeValidatorTestLangModelEClass, JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__MODEL_TYPES);

    myTypeEClass = createEClass(MY_TYPE);
    createEAttribute(myTypeEClass, MY_TYPE__NAME);

    myClassEClass = createEClass(MY_CLASS);
    createEAttribute(myClassEClass, MY_CLASS__ABSTRACT);
    createEReference(myClassEClass, MY_CLASS__EXTENDS);
    createEReference(myClassEClass, MY_CLASS__IMPLEMENTS);
    createEReference(myClassEClass, MY_CLASS__MEMBERS);

    myInterfaceEClass = createEClass(MY_INTERFACE);
    createEReference(myInterfaceEClass, MY_INTERFACE__TYPE_PARAMETERS);
    createEReference(myInterfaceEClass, MY_INTERFACE__EXTENDS);

    myClassWithSuperTypesEClass = createEClass(MY_CLASS_WITH_SUPER_TYPES);
    createEReference(myClassWithSuperTypesEClass, MY_CLASS_WITH_SUPER_TYPES__SUPER_TYPES);

    myClassWithWrongAdditionalInferredInterfaceEClass = createEClass(MY_CLASS_WITH_WRONG_ADDITIONAL_INFERRED_INTERFACE);
    createEReference(myClassWithWrongAdditionalInferredInterfaceEClass, MY_CLASS_WITH_WRONG_ADDITIONAL_INFERRED_INTERFACE__MEMBERS);

    myMemberEClass = createEClass(MY_MEMBER);

    myConstructorEClass = createEClass(MY_CONSTRUCTOR);
    createEReference(myConstructorEClass, MY_CONSTRUCTOR__PARAMETERS);
    createEReference(myConstructorEClass, MY_CONSTRUCTOR__EXCEPTIONS);
    createEReference(myConstructorEClass, MY_CONSTRUCTOR__EXPRESSION);

    myFieldEClass = createEClass(MY_FIELD);
    createEReference(myFieldEClass, MY_FIELD__TYPE);
    createEAttribute(myFieldEClass, MY_FIELD__NAME);

    myMethodEClass = createEClass(MY_METHOD);
    createEAttribute(myMethodEClass, MY_METHOD__STATIC);
    createEAttribute(myMethodEClass, MY_METHOD__PRIVATE);
    createEAttribute(myMethodEClass, MY_METHOD__SYNCHRONIZED);
    createEReference(myMethodEClass, MY_METHOD__TYPE_PARAMETERS);
    createEReference(myMethodEClass, MY_METHOD__TYPE);
    createEAttribute(myMethodEClass, MY_METHOD__NAME);
    createEReference(myMethodEClass, MY_METHOD__PARAMETERS);
    createEReference(myMethodEClass, MY_METHOD__EXCEPTIONS);
    createEReference(myMethodEClass, MY_METHOD__EXPRESSION);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    XtypePackage theXtypePackage = (XtypePackage)EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI);
    TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
    XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    myClassEClass.getESuperTypes().add(this.getMyType());
    myClassEClass.getESuperTypes().add(this.getMyMember());
    myInterfaceEClass.getESuperTypes().add(this.getMyType());
    myClassWithSuperTypesEClass.getESuperTypes().add(this.getMyType());
    myClassWithWrongAdditionalInferredInterfaceEClass.getESuperTypes().add(this.getMyType());
    myConstructorEClass.getESuperTypes().add(this.getMyMember());
    myFieldEClass.getESuperTypes().add(this.getMyMember());
    myMethodEClass.getESuperTypes().add(this.getMyMember());

    // Initialize classes and features; add operations and parameters
    initEClass(jvmGenericTypeValidatorTestLangModelEClass, JvmGenericTypeValidatorTestLangModel.class, "JvmGenericTypeValidatorTestLangModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getJvmGenericTypeValidatorTestLangModel_Package(), ecorePackage.getEString(), "package", null, 0, 1, JvmGenericTypeValidatorTestLangModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getJvmGenericTypeValidatorTestLangModel_ImportSection(), theXtypePackage.getXImportSection(), null, "importSection", null, 0, 1, JvmGenericTypeValidatorTestLangModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getJvmGenericTypeValidatorTestLangModel_ModelTypes(), this.getMyType(), null, "modelTypes", null, 0, -1, JvmGenericTypeValidatorTestLangModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myTypeEClass, MyType.class, "MyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMyType_Name(), ecorePackage.getEString(), "name", null, 0, 1, MyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myClassEClass, MyClass.class, "MyClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMyClass_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, MyClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMyClass_Extends(), theTypesPackage.getJvmParameterizedTypeReference(), null, "extends", null, 0, 1, MyClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMyClass_Implements(), theTypesPackage.getJvmParameterizedTypeReference(), null, "implements", null, 0, -1, MyClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMyClass_Members(), this.getMyMember(), null, "members", null, 0, -1, MyClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myInterfaceEClass, MyInterface.class, "MyInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMyInterface_TypeParameters(), theTypesPackage.getJvmTypeParameter(), null, "typeParameters", null, 0, -1, MyInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMyInterface_Extends(), theTypesPackage.getJvmParameterizedTypeReference(), null, "extends", null, 0, -1, MyInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myClassWithSuperTypesEClass, MyClassWithSuperTypes.class, "MyClassWithSuperTypes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMyClassWithSuperTypes_SuperTypes(), theTypesPackage.getJvmParameterizedTypeReference(), null, "superTypes", null, 0, -1, MyClassWithSuperTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myClassWithWrongAdditionalInferredInterfaceEClass, MyClassWithWrongAdditionalInferredInterface.class, "MyClassWithWrongAdditionalInferredInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMyClassWithWrongAdditionalInferredInterface_Members(), this.getMyMember(), null, "members", null, 0, -1, MyClassWithWrongAdditionalInferredInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myMemberEClass, MyMember.class, "MyMember", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(myConstructorEClass, MyConstructor.class, "MyConstructor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMyConstructor_Parameters(), theTypesPackage.getJvmFormalParameter(), null, "parameters", null, 0, -1, MyConstructor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMyConstructor_Exceptions(), theTypesPackage.getJvmTypeReference(), null, "exceptions", null, 0, -1, MyConstructor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMyConstructor_Expression(), theXbasePackage.getXExpression(), null, "expression", null, 0, 1, MyConstructor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myFieldEClass, MyField.class, "MyField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMyField_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, MyField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMyField_Name(), ecorePackage.getEString(), "name", null, 0, 1, MyField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myMethodEClass, MyMethod.class, "MyMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMyMethod_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, MyMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMyMethod_Private(), ecorePackage.getEBoolean(), "private", null, 0, 1, MyMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMyMethod_Synchronized(), ecorePackage.getEBoolean(), "synchronized", null, 0, 1, MyMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMyMethod_TypeParameters(), theTypesPackage.getJvmTypeParameter(), null, "typeParameters", null, 0, -1, MyMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMyMethod_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, MyMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMyMethod_Name(), ecorePackage.getEString(), "name", null, 0, 1, MyMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMyMethod_Parameters(), theTypesPackage.getJvmFormalParameter(), null, "parameters", null, 0, -1, MyMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMyMethod_Exceptions(), theTypesPackage.getJvmTypeReference(), null, "exceptions", null, 0, -1, MyMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMyMethod_Expression(), theXbasePackage.getXExpression(), null, "expression", null, 0, 1, MyMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //JvmGenericTypeValidatorTestLangPackageImpl
