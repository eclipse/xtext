/**
 */
package org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ElementmatchertestlanguageFactoryImpl extends EFactoryImpl implements ElementmatchertestlanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ElementmatchertestlanguageFactory init()
  {
    try
    {
      ElementmatchertestlanguageFactory theElementmatchertestlanguageFactory = (ElementmatchertestlanguageFactory)EPackage.Registry.INSTANCE.getEFactory(ElementmatchertestlanguagePackage.eNS_URI);
      if (theElementmatchertestlanguageFactory != null)
      {
        return theElementmatchertestlanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ElementmatchertestlanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElementmatchertestlanguageFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ElementmatchertestlanguagePackage.MODEL: return createModel();
      case ElementmatchertestlanguagePackage.SIMPLE: return createSimple();
      case ElementmatchertestlanguagePackage.RULE_CALLS: return createRuleCalls();
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB: return createRuleCallsSub();
      case ElementmatchertestlanguagePackage.RULE_CALLS_ASS1: return createRuleCallsAss1();
      case ElementmatchertestlanguagePackage.RULE_CALLS_ASS2: return createRuleCallsAss2();
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS: return createOptionalCalls();
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1: return createOptionalCallsSub1();
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB2: return createOptionalCallsSub2();
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB3: return createOptionalCallsSub3();
      case ElementmatchertestlanguagePackage.RECURSION: return createRecursion();
      case ElementmatchertestlanguagePackage.RECURSION_SUB: return createRecursionSub();
      case ElementmatchertestlanguagePackage.LOOP: return createLoop();
      case ElementmatchertestlanguagePackage.EXPRESSION: return createExpression();
      case ElementmatchertestlanguagePackage.RULE_CALLS12: return createRuleCalls12();
      case ElementmatchertestlanguagePackage.CONSTRUCTOR: return createConstructor();
      case ElementmatchertestlanguagePackage.FIELD: return createField();
      case ElementmatchertestlanguagePackage.PARAMETER: return createParameter();
      case ElementmatchertestlanguagePackage.NESTED_START: return createNestedStart();
      case ElementmatchertestlanguagePackage.NESTED_START_SUB: return createNestedStartSub();
      case ElementmatchertestlanguagePackage.ADD: return createAdd();
      case ElementmatchertestlanguagePackage.MULT: return createMult();
      case ElementmatchertestlanguagePackage.VALUE: return createValue();
      case ElementmatchertestlanguagePackage.FUNCTION: return createFunction();
      case ElementmatchertestlanguagePackage.POINTER: return createPointer();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Simple createSimple()
  {
    SimpleImpl simple = new SimpleImpl();
    return simple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleCalls createRuleCalls()
  {
    RuleCallsImpl ruleCalls = new RuleCallsImpl();
    return ruleCalls;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleCallsSub createRuleCallsSub()
  {
    RuleCallsSubImpl ruleCallsSub = new RuleCallsSubImpl();
    return ruleCallsSub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleCallsAss1 createRuleCallsAss1()
  {
    RuleCallsAss1Impl ruleCallsAss1 = new RuleCallsAss1Impl();
    return ruleCallsAss1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleCallsAss2 createRuleCallsAss2()
  {
    RuleCallsAss2Impl ruleCallsAss2 = new RuleCallsAss2Impl();
    return ruleCallsAss2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionalCalls createOptionalCalls()
  {
    OptionalCallsImpl optionalCalls = new OptionalCallsImpl();
    return optionalCalls;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionalCallsSub1 createOptionalCallsSub1()
  {
    OptionalCallsSub1Impl optionalCallsSub1 = new OptionalCallsSub1Impl();
    return optionalCallsSub1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionalCallsSub2 createOptionalCallsSub2()
  {
    OptionalCallsSub2Impl optionalCallsSub2 = new OptionalCallsSub2Impl();
    return optionalCallsSub2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionalCallsSub3 createOptionalCallsSub3()
  {
    OptionalCallsSub3Impl optionalCallsSub3 = new OptionalCallsSub3Impl();
    return optionalCallsSub3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Recursion createRecursion()
  {
    RecursionImpl recursion = new RecursionImpl();
    return recursion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecursionSub createRecursionSub()
  {
    RecursionSubImpl recursionSub = new RecursionSubImpl();
    return recursionSub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Loop createLoop()
  {
    LoopImpl loop = new LoopImpl();
    return loop;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleCalls12 createRuleCalls12()
  {
    RuleCalls12Impl ruleCalls12 = new RuleCalls12Impl();
    return ruleCalls12;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Constructor createConstructor()
  {
    ConstructorImpl constructor = new ConstructorImpl();
    return constructor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Field createField()
  {
    FieldImpl field = new FieldImpl();
    return field;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameter createParameter()
  {
    ParameterImpl parameter = new ParameterImpl();
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedStart createNestedStart()
  {
    NestedStartImpl nestedStart = new NestedStartImpl();
    return nestedStart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedStartSub createNestedStartSub()
  {
    NestedStartSubImpl nestedStartSub = new NestedStartSubImpl();
    return nestedStartSub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Add createAdd()
  {
    AddImpl add = new AddImpl();
    return add;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mult createMult()
  {
    MultImpl mult = new MultImpl();
    return mult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Value createValue()
  {
    ValueImpl value = new ValueImpl();
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function createFunction()
  {
    FunctionImpl function = new FunctionImpl();
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pointer createPointer()
  {
    PointerImpl pointer = new PointerImpl();
    return pointer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElementmatchertestlanguagePackage getElementmatchertestlanguagePackage()
  {
    return (ElementmatchertestlanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ElementmatchertestlanguagePackage getPackage()
  {
    return ElementmatchertestlanguagePackage.eINSTANCE;
  }

} //ElementmatchertestlanguageFactoryImpl
