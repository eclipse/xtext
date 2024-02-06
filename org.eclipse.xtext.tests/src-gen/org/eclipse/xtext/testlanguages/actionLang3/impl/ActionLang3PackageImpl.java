/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.actionLang3.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.testlanguages.actionLang3.ActionLang3Factory;
import org.eclipse.xtext.testlanguages.actionLang3.ActionLang3Package;
import org.eclipse.xtext.testlanguages.actionLang3.Entry;
import org.eclipse.xtext.testlanguages.actionLang3.ProductionRule1;
import org.eclipse.xtext.testlanguages.actionLang3.ProductionRule2;
import org.eclipse.xtext.testlanguages.actionLang3.ProductionRules;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionLang3PackageImpl extends EPackageImpl implements ActionLang3Package
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass productionRulesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass productionRule1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass productionRule2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass p1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass p2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass p3EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass entryEClass = null;

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
   * @see org.eclipse.xtext.testlanguages.actionLang3.ActionLang3Package#eNS_URI
   * @see #init()
   * @generated
   */
  private ActionLang3PackageImpl()
  {
    super(eNS_URI, ActionLang3Factory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ActionLang3Package#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ActionLang3Package init()
  {
    if (isInited) return (ActionLang3Package)EPackage.Registry.INSTANCE.getEPackage(ActionLang3Package.eNS_URI);

    // Obtain or create and register package
    Object registeredActionLang3Package = EPackage.Registry.INSTANCE.get(eNS_URI);
    ActionLang3PackageImpl theActionLang3Package = registeredActionLang3Package instanceof ActionLang3PackageImpl ? (ActionLang3PackageImpl)registeredActionLang3Package : new ActionLang3PackageImpl();

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theActionLang3Package.createPackageContents();

    // Initialize created meta-data
    theActionLang3Package.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theActionLang3Package.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ActionLang3Package.eNS_URI, theActionLang3Package);
    return theActionLang3Package;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getProductionRules()
  {
    return productionRulesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getProductionRule1()
  {
    return productionRule1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getProductionRule2()
  {
    return productionRule2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getP1()
  {
    return p1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getP1_Id()
  {
    return (EAttribute)p1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getP2()
  {
    return p2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getP2_P()
  {
    return (EReference)p2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getP2_String()
  {
    return (EAttribute)p2EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getP3()
  {
    return p3EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getP3_P()
  {
    return (EReference)p3EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getP3_I()
  {
    return (EAttribute)p3EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getEntry()
  {
    return entryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getEntry_Name()
  {
    return (EAttribute)entryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ActionLang3Factory getActionLang3Factory()
  {
    return (ActionLang3Factory)getEFactoryInstance();
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
    productionRulesEClass = createEClass(PRODUCTION_RULES);

    productionRule1EClass = createEClass(PRODUCTION_RULE1);

    productionRule2EClass = createEClass(PRODUCTION_RULE2);

    p1EClass = createEClass(P1);
    createEAttribute(p1EClass, P1__ID);

    p2EClass = createEClass(P2);
    createEReference(p2EClass, P2__P);
    createEAttribute(p2EClass, P2__STRING);

    p3EClass = createEClass(P3);
    createEReference(p3EClass, P3__P);
    createEAttribute(p3EClass, P3__I);

    entryEClass = createEClass(ENTRY);
    createEAttribute(entryEClass, ENTRY__NAME);
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
    productionRule1EClass.getESuperTypes().add(this.getProductionRules());
    productionRule2EClass.getESuperTypes().add(this.getProductionRules());
    p1EClass.getESuperTypes().add(this.getProductionRule1());
    p2EClass.getESuperTypes().add(this.getProductionRule1());
    p3EClass.getESuperTypes().add(this.getProductionRule1());
    entryEClass.getESuperTypes().add(this.getProductionRule2());

    // Initialize classes and features; add operations and parameters
    initEClass(productionRulesEClass, ProductionRules.class, "ProductionRules", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(productionRule1EClass, ProductionRule1.class, "ProductionRule1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(productionRule2EClass, ProductionRule2.class, "ProductionRule2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(p1EClass, org.eclipse.xtext.testlanguages.actionLang3.P1.class, "P1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getP1_Id(), theEcorePackage.getEString(), "id", null, 0, 1, org.eclipse.xtext.testlanguages.actionLang3.P1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(p2EClass, org.eclipse.xtext.testlanguages.actionLang3.P2.class, "P2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getP2_P(), this.getP1(), null, "p", null, 0, 1, org.eclipse.xtext.testlanguages.actionLang3.P2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getP2_String(), theEcorePackage.getEString(), "string", null, 0, 1, org.eclipse.xtext.testlanguages.actionLang3.P2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(p3EClass, org.eclipse.xtext.testlanguages.actionLang3.P3.class, "P3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getP3_P(), this.getP2(), null, "p", null, 0, 1, org.eclipse.xtext.testlanguages.actionLang3.P3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getP3_I(), theEcorePackage.getEInt(), "i", null, 0, 1, org.eclipse.xtext.testlanguages.actionLang3.P3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(entryEClass, Entry.class, "Entry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEntry_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ActionLang3PackageImpl
