/**
 */
package org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Add;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Constructor;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguageFactory;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Expression;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Field;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Function;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Loop;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Model;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Mult;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.NestedStart;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.NestedStartSub;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCalls;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub1;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub2;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub3;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Parameter;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Pointer;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Recursion;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RecursionSub;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCalls;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCalls12;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsAss1;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsAss2;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Simple;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Value;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleCalls12EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constructorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fieldEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nestedStartEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nestedStartSubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass addEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pointerEClass = null;

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

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

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
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleCalls12()
  {
    return ruleCalls12EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleCalls12_Constructor()
  {
    return (EReference)ruleCalls12EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleCalls12_Fields()
  {
    return (EReference)ruleCalls12EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstructor()
  {
    return constructorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstructor_Kw1()
  {
    return (EAttribute)constructorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getField()
  {
    return fieldEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameter()
  {
    return parameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParameter_Kw2()
  {
    return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNestedStart()
  {
    return nestedStartEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNestedStartSub()
  {
    return nestedStartSubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNestedStartSub_Name()
  {
    return (EAttribute)nestedStartSubEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAdd()
  {
    return addEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdd_Left()
  {
    return (EReference)addEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdd_Right()
  {
    return (EReference)addEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMult()
  {
    return multEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMult_Left()
  {
    return (EReference)multEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMult_Right()
  {
    return (EReference)multEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValue()
  {
    return valueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getValue_Val()
  {
    return (EAttribute)valueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunction()
  {
    return functionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunction_Func()
  {
    return (EAttribute)functionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunction_Param()
  {
    return (EReference)functionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPointer()
  {
    return pointerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPointer_Target()
  {
    return (EReference)pointerEClass.getEStructuralFeatures().get(0);
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

    expressionEClass = createEClass(EXPRESSION);

    ruleCalls12EClass = createEClass(RULE_CALLS12);
    createEReference(ruleCalls12EClass, RULE_CALLS12__CONSTRUCTOR);
    createEReference(ruleCalls12EClass, RULE_CALLS12__FIELDS);

    constructorEClass = createEClass(CONSTRUCTOR);
    createEAttribute(constructorEClass, CONSTRUCTOR__KW1);

    fieldEClass = createEClass(FIELD);

    parameterEClass = createEClass(PARAMETER);
    createEAttribute(parameterEClass, PARAMETER__KW2);

    nestedStartEClass = createEClass(NESTED_START);

    nestedStartSubEClass = createEClass(NESTED_START_SUB);
    createEAttribute(nestedStartSubEClass, NESTED_START_SUB__NAME);

    addEClass = createEClass(ADD);
    createEReference(addEClass, ADD__LEFT);
    createEReference(addEClass, ADD__RIGHT);

    multEClass = createEClass(MULT);
    createEReference(multEClass, MULT__LEFT);
    createEReference(multEClass, MULT__RIGHT);

    valueEClass = createEClass(VALUE);
    createEAttribute(valueEClass, VALUE__VAL);

    functionEClass = createEClass(FUNCTION);
    createEAttribute(functionEClass, FUNCTION__FUNC);
    createEReference(functionEClass, FUNCTION__PARAM);

    pointerEClass = createEClass(POINTER);
    createEReference(pointerEClass, POINTER__TARGET);
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
    simpleEClass.getESuperTypes().add(this.getModel());
    ruleCallsEClass.getESuperTypes().add(this.getModel());
    ruleCallsSubEClass.getESuperTypes().add(this.getRuleCalls());
    optionalCallsEClass.getESuperTypes().add(this.getModel());
    recursionEClass.getESuperTypes().add(this.getModel());
    recursionSubEClass.getESuperTypes().add(this.getRecursion());
    loopEClass.getESuperTypes().add(this.getModel());
    expressionEClass.getESuperTypes().add(this.getModel());
    ruleCalls12EClass.getESuperTypes().add(this.getModel());
    parameterEClass.getESuperTypes().add(this.getField());
    nestedStartEClass.getESuperTypes().add(this.getModel());
    nestedStartSubEClass.getESuperTypes().add(this.getNestedStart());
    addEClass.getESuperTypes().add(this.getExpression());
    multEClass.getESuperTypes().add(this.getExpression());
    valueEClass.getESuperTypes().add(this.getExpression());
    functionEClass.getESuperTypes().add(this.getExpression());
    pointerEClass.getESuperTypes().add(this.getExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(simpleEClass, Simple.class, "Simple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimple_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Simple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimple_Optional(), theEcorePackage.getEString(), "optional", null, 0, 1, Simple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimple_Datatype(), theEcorePackage.getEString(), "datatype", null, 0, 1, Simple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleCallsEClass, RuleCalls.class, "RuleCalls", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ruleCallsSubEClass, RuleCallsSub.class, "RuleCallsSub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRuleCallsSub_Name(), theEcorePackage.getEString(), "name", null, 0, 1, RuleCallsSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleCallsSub_Call1(), this.getRuleCallsAss1(), null, "call1", null, 0, 1, RuleCallsSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleCallsSub_Call2(), this.getRuleCallsAss2(), null, "call2", null, 0, 1, RuleCallsSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRuleCallsSub_Sub(), theEcorePackage.getEString(), "sub", null, 0, 1, RuleCallsSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleCallsAss1EClass, RuleCallsAss1.class, "RuleCallsAss1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRuleCallsAss1_Name(), theEcorePackage.getEString(), "name", null, 0, 1, RuleCallsAss1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleCallsAss2EClass, RuleCallsAss2.class, "RuleCallsAss2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRuleCallsAss2_Name(), theEcorePackage.getEString(), "name", null, 0, 1, RuleCallsAss2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optionalCallsEClass, OptionalCalls.class, "OptionalCalls", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOptionalCalls_Opt1(), this.getOptionalCallsSub1(), null, "opt1", null, 0, 1, OptionalCalls.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOptionalCalls_Name(), theEcorePackage.getEString(), "name", null, 0, 1, OptionalCalls.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optionalCallsSub1EClass, OptionalCallsSub1.class, "OptionalCallsSub1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOptionalCallsSub1_Opt2(), this.getOptionalCallsSub2(), null, "opt2", null, 0, 1, OptionalCallsSub1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOptionalCallsSub1_Opt3(), this.getOptionalCallsSub3(), null, "opt3", null, 0, 1, OptionalCallsSub1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optionalCallsSub2EClass, OptionalCallsSub2.class, "OptionalCallsSub2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOptionalCallsSub2_Name(), theEcorePackage.getEString(), "name", null, 0, 1, OptionalCallsSub2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optionalCallsSub3EClass, OptionalCallsSub3.class, "OptionalCallsSub3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOptionalCallsSub3_Name(), theEcorePackage.getEString(), "name", null, 0, 1, OptionalCallsSub3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recursionEClass, Recursion.class, "Recursion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(recursionSubEClass, RecursionSub.class, "RecursionSub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRecursionSub_Sub(), this.getRecursionSub(), null, "sub", null, 0, -1, RecursionSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRecursionSub_Vals(), theEcorePackage.getEString(), "vals", null, 0, -1, RecursionSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRecursionSub_Semi(), theEcorePackage.getEBoolean(), "semi", null, 0, 1, RecursionSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(loopEClass, Loop.class, "Loop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLoop_Names(), theEcorePackage.getEString(), "names", null, 0, -1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoop_Gr(), theEcorePackage.getEString(), "gr", null, 0, -1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoop_Ints(), theEcorePackage.getEInt(), "ints", null, 0, -1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoop_Strings(), theEcorePackage.getEString(), "strings", null, 0, -1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ruleCalls12EClass, RuleCalls12.class, "RuleCalls12", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRuleCalls12_Constructor(), this.getConstructor(), null, "constructor", null, 0, 1, RuleCalls12.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleCalls12_Fields(), this.getField(), null, "fields", null, 0, -1, RuleCalls12.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constructorEClass, Constructor.class, "Constructor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getConstructor_Kw1(), theEcorePackage.getEBoolean(), "kw1", null, 0, 1, Constructor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fieldEClass, Field.class, "Field", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParameter_Kw2(), theEcorePackage.getEBoolean(), "kw2", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nestedStartEClass, NestedStart.class, "NestedStart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nestedStartSubEClass, NestedStartSub.class, "NestedStartSub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNestedStartSub_Name(), theEcorePackage.getEString(), "name", null, 0, 1, NestedStartSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(addEClass, Add.class, "Add", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAdd_Left(), this.getExpression(), null, "left", null, 0, 1, Add.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAdd_Right(), this.getExpression(), null, "right", null, 0, 1, Add.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multEClass, Mult.class, "Mult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMult_Left(), this.getExpression(), null, "left", null, 0, 1, Mult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMult_Right(), this.getExpression(), null, "right", null, 0, 1, Mult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueEClass, Value.class, "Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getValue_Val(), theEcorePackage.getEInt(), "val", null, 0, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFunction_Func(), theEcorePackage.getEString(), "func", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunction_Param(), this.getExpression(), null, "param", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pointerEClass, Pointer.class, "Pointer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPointer_Target(), this.getExpression(), null, "target", null, 0, 1, Pointer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ElementmatchertestlanguagePackageImpl
