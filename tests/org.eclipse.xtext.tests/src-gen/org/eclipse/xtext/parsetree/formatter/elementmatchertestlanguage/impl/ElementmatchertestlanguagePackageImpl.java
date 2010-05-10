/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguageFactory;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Loop;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Model;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCalls;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub1;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub2;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub3;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Recursion;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RecursionSub;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCalls;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsAss1;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsAss2;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Simple;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ElementmatchertestlanguagePackageImpl extends EPackageImpl implements ElementmatchertestlanguagePackage
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
  private EClass simpleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleCallsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleCallsSubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleCallsAss1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleCallsAss2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass optionalCallsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass optionalCallsSub1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass optionalCallsSub2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass optionalCallsSub3EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recursionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recursionSubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass loopEClass = null;

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
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ElementmatchertestlanguagePackageImpl()
  {
    super(eNS_URI, ElementmatchertestlanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ElementmatchertestlanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ElementmatchertestlanguagePackage init()
  {
    if (isInited) return (ElementmatchertestlanguagePackage)EPackage.Registry.INSTANCE.getEPackage(ElementmatchertestlanguagePackage.eNS_URI);

    // Obtain or create and register package
    ElementmatchertestlanguagePackageImpl theElementmatchertestlanguagePackage = (ElementmatchertestlanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ElementmatchertestlanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ElementmatchertestlanguagePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theElementmatchertestlanguagePackage.createPackageContents();

    // Initialize created meta-data
    theElementmatchertestlanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theElementmatchertestlanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ElementmatchertestlanguagePackage.eNS_URI, theElementmatchertestlanguagePackage);
    return theElementmatchertestlanguagePackage;
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
  public EClass getSimple()
  {
    return simpleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimple_Name()
  {
    return (EAttribute)simpleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimple_Optional()
  {
    return (EAttribute)simpleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimple_Datatype()
  {
    return (EAttribute)simpleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleCalls()
  {
    return ruleCallsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleCallsSub()
  {
    return ruleCallsSubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRuleCallsSub_Name()
  {
    return (EAttribute)ruleCallsSubEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleCallsSub_Call1()
  {
    return (EReference)ruleCallsSubEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleCallsSub_Call2()
  {
    return (EReference)ruleCallsSubEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRuleCallsSub_Sub()
  {
    return (EAttribute)ruleCallsSubEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleCallsAss1()
  {
    return ruleCallsAss1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRuleCallsAss1_Name()
  {
    return (EAttribute)ruleCallsAss1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleCallsAss2()
  {
    return ruleCallsAss2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRuleCallsAss2_Name()
  {
    return (EAttribute)ruleCallsAss2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOptionalCalls()
  {
    return optionalCallsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOptionalCalls_Opt1()
  {
    return (EReference)optionalCallsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOptionalCalls_Name()
  {
    return (EAttribute)optionalCallsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOptionalCallsSub1()
  {
    return optionalCallsSub1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOptionalCallsSub1_Opt2()
  {
    return (EReference)optionalCallsSub1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOptionalCallsSub1_Opt3()
  {
    return (EReference)optionalCallsSub1EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOptionalCallsSub2()
  {
    return optionalCallsSub2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOptionalCallsSub2_Name()
  {
    return (EAttribute)optionalCallsSub2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOptionalCallsSub3()
  {
    return optionalCallsSub3EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOptionalCallsSub3_Name()
  {
    return (EAttribute)optionalCallsSub3EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecursion()
  {
    return recursionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecursionSub()
  {
    return recursionSubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecursionSub_Sub()
  {
    return (EReference)recursionSubEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRecursionSub_Vals()
  {
    return (EAttribute)recursionSubEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRecursionSub_Semi()
  {
    return (EAttribute)recursionSubEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLoop()
  {
    return loopEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoop_Names()
  {
    return (EAttribute)loopEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoop_Gr()
  {
    return (EAttribute)loopEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoop_Ints()
  {
    return (EAttribute)loopEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoop_Strings()
  {
    return (EAttribute)loopEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElementmatchertestlanguageFactory getElementmatchertestlanguageFactory()
  {
    return (ElementmatchertestlanguageFactory)getEFactoryInstance();
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

    simpleEClass = createEClass(SIMPLE);
    createEAttribute(simpleEClass, SIMPLE__NAME);
    createEAttribute(simpleEClass, SIMPLE__OPTIONAL);
    createEAttribute(simpleEClass, SIMPLE__DATATYPE);

    ruleCallsEClass = createEClass(RULE_CALLS);

    ruleCallsSubEClass = createEClass(RULE_CALLS_SUB);
    createEAttribute(ruleCallsSubEClass, RULE_CALLS_SUB__NAME);
    createEReference(ruleCallsSubEClass, RULE_CALLS_SUB__CALL1);
    createEReference(ruleCallsSubEClass, RULE_CALLS_SUB__CALL2);
    createEAttribute(ruleCallsSubEClass, RULE_CALLS_SUB__SUB);

    ruleCallsAss1EClass = createEClass(RULE_CALLS_ASS1);
    createEAttribute(ruleCallsAss1EClass, RULE_CALLS_ASS1__NAME);

    ruleCallsAss2EClass = createEClass(RULE_CALLS_ASS2);
    createEAttribute(ruleCallsAss2EClass, RULE_CALLS_ASS2__NAME);

    optionalCallsEClass = createEClass(OPTIONAL_CALLS);
    createEReference(optionalCallsEClass, OPTIONAL_CALLS__OPT1);
    createEAttribute(optionalCallsEClass, OPTIONAL_CALLS__NAME);

    optionalCallsSub1EClass = createEClass(OPTIONAL_CALLS_SUB1);
    createEReference(optionalCallsSub1EClass, OPTIONAL_CALLS_SUB1__OPT2);
    createEReference(optionalCallsSub1EClass, OPTIONAL_CALLS_SUB1__OPT3);

    optionalCallsSub2EClass = createEClass(OPTIONAL_CALLS_SUB2);
    createEAttribute(optionalCallsSub2EClass, OPTIONAL_CALLS_SUB2__NAME);

    optionalCallsSub3EClass = createEClass(OPTIONAL_CALLS_SUB3);
    createEAttribute(optionalCallsSub3EClass, OPTIONAL_CALLS_SUB3__NAME);

    recursionEClass = createEClass(RECURSION);

    recursionSubEClass = createEClass(RECURSION_SUB);
    createEReference(recursionSubEClass, RECURSION_SUB__SUB);
    createEAttribute(recursionSubEClass, RECURSION_SUB__VALS);
    createEAttribute(recursionSubEClass, RECURSION_SUB__SEMI);

    loopEClass = createEClass(LOOP);
    createEAttribute(loopEClass, LOOP__NAMES);
    createEAttribute(loopEClass, LOOP__GR);
    createEAttribute(loopEClass, LOOP__INTS);
    createEAttribute(loopEClass, LOOP__STRINGS);
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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    simpleEClass.getESuperTypes().add(this.getModel());
    ruleCallsEClass.getESuperTypes().add(this.getModel());
    ruleCallsSubEClass.getESuperTypes().add(this.getRuleCalls());
    optionalCallsEClass.getESuperTypes().add(this.getModel());
    recursionEClass.getESuperTypes().add(this.getModel());
    recursionSubEClass.getESuperTypes().add(this.getRecursion());
    loopEClass.getESuperTypes().add(this.getModel());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(simpleEClass, Simple.class, "Simple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimple_Name(), ecorePackage.getEString(), "name", null, 0, 1, Simple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimple_Optional(), ecorePackage.getEString(), "optional", null, 0, 1, Simple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimple_Datatype(), ecorePackage.getEString(), "datatype", null, 0, 1, Simple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleCallsEClass, RuleCalls.class, "RuleCalls", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ruleCallsSubEClass, RuleCallsSub.class, "RuleCallsSub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRuleCallsSub_Name(), ecorePackage.getEString(), "name", null, 0, 1, RuleCallsSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleCallsSub_Call1(), this.getRuleCallsAss1(), null, "call1", null, 0, 1, RuleCallsSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleCallsSub_Call2(), this.getRuleCallsAss2(), null, "call2", null, 0, 1, RuleCallsSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRuleCallsSub_Sub(), ecorePackage.getEString(), "sub", null, 0, 1, RuleCallsSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleCallsAss1EClass, RuleCallsAss1.class, "RuleCallsAss1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRuleCallsAss1_Name(), ecorePackage.getEString(), "name", null, 0, 1, RuleCallsAss1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleCallsAss2EClass, RuleCallsAss2.class, "RuleCallsAss2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRuleCallsAss2_Name(), ecorePackage.getEString(), "name", null, 0, 1, RuleCallsAss2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optionalCallsEClass, OptionalCalls.class, "OptionalCalls", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOptionalCalls_Opt1(), this.getOptionalCallsSub1(), null, "opt1", null, 0, 1, OptionalCalls.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOptionalCalls_Name(), ecorePackage.getEString(), "name", null, 0, 1, OptionalCalls.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optionalCallsSub1EClass, OptionalCallsSub1.class, "OptionalCallsSub1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOptionalCallsSub1_Opt2(), this.getOptionalCallsSub2(), null, "opt2", null, 0, 1, OptionalCallsSub1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOptionalCallsSub1_Opt3(), this.getOptionalCallsSub3(), null, "opt3", null, 0, 1, OptionalCallsSub1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optionalCallsSub2EClass, OptionalCallsSub2.class, "OptionalCallsSub2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOptionalCallsSub2_Name(), ecorePackage.getEString(), "name", null, 0, 1, OptionalCallsSub2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optionalCallsSub3EClass, OptionalCallsSub3.class, "OptionalCallsSub3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOptionalCallsSub3_Name(), ecorePackage.getEString(), "name", null, 0, 1, OptionalCallsSub3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recursionEClass, Recursion.class, "Recursion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(recursionSubEClass, RecursionSub.class, "RecursionSub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRecursionSub_Sub(), this.getRecursionSub(), null, "sub", null, 0, -1, RecursionSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRecursionSub_Vals(), ecorePackage.getEString(), "vals", null, 0, -1, RecursionSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRecursionSub_Semi(), ecorePackage.getEBoolean(), "semi", null, 0, 1, RecursionSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(loopEClass, Loop.class, "Loop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLoop_Names(), ecorePackage.getEString(), "names", null, 0, -1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoop_Gr(), ecorePackage.getEString(), "gr", null, 0, -1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoop_Ints(), ecorePackage.getEInt(), "ints", null, 0, -1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoop_Strings(), ecorePackage.getEString(), "strings", null, 0, -1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ElementmatchertestlanguagePackageImpl
