/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.EClassRef;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Import;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryChild;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryChildList;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryValue;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ManyMandatoryValues;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ManyOptionalValues;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ManyValues;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Model;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalChild;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalChildList;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalValue;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguageFactory;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PartialSerializationTestLanguagePackageImpl extends EPackageImpl implements PartialSerializationTestLanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mandatoryValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass optionalValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass manyOptionalValuesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass manyMandatoryValuesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mandatoryChildEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass optionalChildEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mandatoryChildListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass optionalChildListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eClassRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass manyValuesEClass = null;

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
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private PartialSerializationTestLanguagePackageImpl()
  {
    super(eNS_URI, PartialSerializationTestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link PartialSerializationTestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static PartialSerializationTestLanguagePackage init()
  {
    if (isInited) return (PartialSerializationTestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(PartialSerializationTestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    PartialSerializationTestLanguagePackageImpl thePartialSerializationTestLanguagePackage = (PartialSerializationTestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PartialSerializationTestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PartialSerializationTestLanguagePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    thePartialSerializationTestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    thePartialSerializationTestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    thePartialSerializationTestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(PartialSerializationTestLanguagePackage.eNS_URI, thePartialSerializationTestLanguagePackage);
    return thePartialSerializationTestLanguagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Clazz()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMandatoryValue()
  {
    return mandatoryValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMandatoryValue_Name()
  {
    return (EAttribute)mandatoryValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOptionalValue()
  {
    return optionalValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOptionalValue_Name()
  {
    return (EAttribute)optionalValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getManyOptionalValues()
  {
    return manyOptionalValuesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getManyMandatoryValues()
  {
    return manyMandatoryValuesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getManyMandatoryValues_Name()
  {
    return (EAttribute)manyMandatoryValuesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMandatoryChild()
  {
    return mandatoryChildEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMandatoryChild_Child()
  {
    return (EReference)mandatoryChildEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOptionalChild()
  {
    return optionalChildEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOptionalChild_Child()
  {
    return (EReference)optionalChildEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMandatoryChildList()
  {
    return mandatoryChildListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMandatoryChildList_Children()
  {
    return (EReference)mandatoryChildListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOptionalChildList()
  {
    return optionalChildListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOptionalChildList_Children()
  {
    return (EReference)optionalChildListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImport()
  {
    return importEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImport_ImportedNamespace()
  {
    return (EAttribute)importEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNode()
  {
    return nodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNode_Imports()
  {
    return (EReference)nodeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNode_Name()
  {
    return (EAttribute)nodeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNode_Refs()
  {
    return (EReference)nodeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNode_Children()
  {
    return (EReference)nodeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNode_Ref()
  {
    return (EReference)nodeEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEClassRef()
  {
    return eClassRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEClassRef_Ref()
  {
    return (EReference)eClassRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getManyValues()
  {
    return manyValuesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getManyValues_Name()
  {
    return (EAttribute)manyValuesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartialSerializationTestLanguageFactory getPartialSerializationTestLanguageFactory()
  {
    return (PartialSerializationTestLanguageFactory)getEFactoryInstance();
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
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__CLAZZ);

    mandatoryValueEClass = createEClass(MANDATORY_VALUE);
    createEAttribute(mandatoryValueEClass, MANDATORY_VALUE__NAME);

    optionalValueEClass = createEClass(OPTIONAL_VALUE);
    createEAttribute(optionalValueEClass, OPTIONAL_VALUE__NAME);

    manyOptionalValuesEClass = createEClass(MANY_OPTIONAL_VALUES);

    manyMandatoryValuesEClass = createEClass(MANY_MANDATORY_VALUES);
    createEAttribute(manyMandatoryValuesEClass, MANY_MANDATORY_VALUES__NAME);

    mandatoryChildEClass = createEClass(MANDATORY_CHILD);
    createEReference(mandatoryChildEClass, MANDATORY_CHILD__CHILD);

    optionalChildEClass = createEClass(OPTIONAL_CHILD);
    createEReference(optionalChildEClass, OPTIONAL_CHILD__CHILD);

    mandatoryChildListEClass = createEClass(MANDATORY_CHILD_LIST);
    createEReference(mandatoryChildListEClass, MANDATORY_CHILD_LIST__CHILDREN);

    optionalChildListEClass = createEClass(OPTIONAL_CHILD_LIST);
    createEReference(optionalChildListEClass, OPTIONAL_CHILD_LIST__CHILDREN);

    importEClass = createEClass(IMPORT);
    createEAttribute(importEClass, IMPORT__IMPORTED_NAMESPACE);

    nodeEClass = createEClass(NODE);
    createEReference(nodeEClass, NODE__IMPORTS);
    createEAttribute(nodeEClass, NODE__NAME);
    createEReference(nodeEClass, NODE__REFS);
    createEReference(nodeEClass, NODE__CHILDREN);
    createEReference(nodeEClass, NODE__REF);

    eClassRefEClass = createEClass(ECLASS_REF);
    createEReference(eClassRefEClass, ECLASS_REF__REF);

    manyValuesEClass = createEClass(MANY_VALUES);
    createEAttribute(manyValuesEClass, MANY_VALUES__NAME);
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
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    mandatoryValueEClass.getESuperTypes().add(this.getModel());
    optionalValueEClass.getESuperTypes().add(this.getModel());
    manyOptionalValuesEClass.getESuperTypes().add(this.getModel());
    manyMandatoryValuesEClass.getESuperTypes().add(this.getModel());
    mandatoryChildEClass.getESuperTypes().add(this.getModel());
    optionalChildEClass.getESuperTypes().add(this.getModel());
    mandatoryChildListEClass.getESuperTypes().add(this.getModel());
    optionalChildListEClass.getESuperTypes().add(this.getModel());
    nodeEClass.getESuperTypes().add(this.getModel());
    eClassRefEClass.getESuperTypes().add(this.getModel());
    manyValuesEClass.getESuperTypes().add(this.getManyOptionalValues());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Clazz(), theEcorePackage.getEClass(), null, "clazz", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mandatoryValueEClass, MandatoryValue.class, "MandatoryValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMandatoryValue_Name(), theEcorePackage.getEString(), "name", null, 0, 1, MandatoryValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optionalValueEClass, OptionalValue.class, "OptionalValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOptionalValue_Name(), theEcorePackage.getEString(), "name", null, 0, 1, OptionalValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(manyOptionalValuesEClass, ManyOptionalValues.class, "ManyOptionalValues", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(manyMandatoryValuesEClass, ManyMandatoryValues.class, "ManyMandatoryValues", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getManyMandatoryValues_Name(), theEcorePackage.getEString(), "name", null, 0, -1, ManyMandatoryValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mandatoryChildEClass, MandatoryChild.class, "MandatoryChild", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMandatoryChild_Child(), this.getMandatoryValue(), null, "child", null, 0, 1, MandatoryChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optionalChildEClass, OptionalChild.class, "OptionalChild", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOptionalChild_Child(), this.getMandatoryValue(), null, "child", null, 0, 1, OptionalChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mandatoryChildListEClass, MandatoryChildList.class, "MandatoryChildList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMandatoryChildList_Children(), this.getMandatoryValue(), null, "children", null, 0, -1, MandatoryChildList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optionalChildListEClass, OptionalChildList.class, "OptionalChildList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOptionalChildList_Children(), this.getMandatoryValue(), null, "children", null, 0, -1, OptionalChildList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImport_ImportedNamespace(), theEcorePackage.getEString(), "importedNamespace", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNode_Imports(), this.getImport(), null, "imports", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNode_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNode_Refs(), this.getNode(), null, "refs", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNode_Children(), this.getNode(), null, "children", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNode_Ref(), this.getNode(), null, "ref", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eClassRefEClass, EClassRef.class, "EClassRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEClassRef_Ref(), theEcorePackage.getEClass(), null, "ref", null, 0, 1, EClassRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(manyValuesEClass, ManyValues.class, "ManyValues", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getManyValues_Name(), theEcorePackage.getEString(), "name", null, 0, -1, ManyValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //PartialSerializationTestLanguagePackageImpl
