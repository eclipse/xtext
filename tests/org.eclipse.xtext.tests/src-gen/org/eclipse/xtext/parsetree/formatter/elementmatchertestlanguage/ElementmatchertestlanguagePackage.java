/**
 */
package org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage;

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
 * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguageFactory
 * @model kind="package"
 * @generated
 */
public interface ElementmatchertestlanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "elementmatchertestlanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://simple/elementmatchertestlanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "elementmatchertestlanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ElementmatchertestlanguagePackage eINSTANCE = org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ModelImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.SimpleImpl <em>Simple</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.SimpleImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getSimple()
   * @generated
   */
  int SIMPLE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE__NAME = MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE__OPTIONAL = MODEL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Datatype</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE__DATATYPE = MODEL_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Simple</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_FEATURE_COUNT = MODEL_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsImpl <em>Rule Calls</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getRuleCalls()
   * @generated
   */
  int RULE_CALLS = 2;

  /**
   * The number of structural features of the '<em>Rule Calls</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALLS_FEATURE_COUNT = MODEL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsSubImpl <em>Rule Calls Sub</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsSubImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getRuleCallsSub()
   * @generated
   */
  int RULE_CALLS_SUB = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALLS_SUB__NAME = RULE_CALLS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Call1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALLS_SUB__CALL1 = RULE_CALLS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Call2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALLS_SUB__CALL2 = RULE_CALLS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Sub</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALLS_SUB__SUB = RULE_CALLS_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Rule Calls Sub</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALLS_SUB_FEATURE_COUNT = RULE_CALLS_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsAss1Impl <em>Rule Calls Ass1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsAss1Impl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getRuleCallsAss1()
   * @generated
   */
  int RULE_CALLS_ASS1 = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALLS_ASS1__NAME = 0;

  /**
   * The number of structural features of the '<em>Rule Calls Ass1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALLS_ASS1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsAss2Impl <em>Rule Calls Ass2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsAss2Impl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getRuleCallsAss2()
   * @generated
   */
  int RULE_CALLS_ASS2 = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALLS_ASS2__NAME = 0;

  /**
   * The number of structural features of the '<em>Rule Calls Ass2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALLS_ASS2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsImpl <em>Optional Calls</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getOptionalCalls()
   * @generated
   */
  int OPTIONAL_CALLS = 6;

  /**
   * The feature id for the '<em><b>Opt1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTIONAL_CALLS__OPT1 = MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTIONAL_CALLS__NAME = MODEL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Optional Calls</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTIONAL_CALLS_FEATURE_COUNT = MODEL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsSub1Impl <em>Optional Calls Sub1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsSub1Impl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getOptionalCallsSub1()
   * @generated
   */
  int OPTIONAL_CALLS_SUB1 = 7;

  /**
   * The feature id for the '<em><b>Opt2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTIONAL_CALLS_SUB1__OPT2 = 0;

  /**
   * The feature id for the '<em><b>Opt3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTIONAL_CALLS_SUB1__OPT3 = 1;

  /**
   * The number of structural features of the '<em>Optional Calls Sub1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTIONAL_CALLS_SUB1_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsSub2Impl <em>Optional Calls Sub2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsSub2Impl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getOptionalCallsSub2()
   * @generated
   */
  int OPTIONAL_CALLS_SUB2 = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTIONAL_CALLS_SUB2__NAME = 0;

  /**
   * The number of structural features of the '<em>Optional Calls Sub2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTIONAL_CALLS_SUB2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsSub3Impl <em>Optional Calls Sub3</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsSub3Impl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getOptionalCallsSub3()
   * @generated
   */
  int OPTIONAL_CALLS_SUB3 = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTIONAL_CALLS_SUB3__NAME = 0;

  /**
   * The number of structural features of the '<em>Optional Calls Sub3</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTIONAL_CALLS_SUB3_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RecursionImpl <em>Recursion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RecursionImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getRecursion()
   * @generated
   */
  int RECURSION = 10;

  /**
   * The number of structural features of the '<em>Recursion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECURSION_FEATURE_COUNT = MODEL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RecursionSubImpl <em>Recursion Sub</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RecursionSubImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getRecursionSub()
   * @generated
   */
  int RECURSION_SUB = 11;

  /**
   * The feature id for the '<em><b>Sub</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECURSION_SUB__SUB = RECURSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Vals</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECURSION_SUB__VALS = RECURSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Semi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECURSION_SUB__SEMI = RECURSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Recursion Sub</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECURSION_SUB_FEATURE_COUNT = RECURSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.LoopImpl <em>Loop</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.LoopImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getLoop()
   * @generated
   */
  int LOOP = 12;

  /**
   * The feature id for the '<em><b>Names</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP__NAMES = MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Gr</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP__GR = MODEL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Ints</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP__INTS = MODEL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Strings</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP__STRINGS = MODEL_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Loop</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_FEATURE_COUNT = MODEL_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ExpressionImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 13;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = MODEL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCalls12Impl <em>Rule Calls12</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCalls12Impl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getRuleCalls12()
   * @generated
   */
  int RULE_CALLS12 = 14;

  /**
   * The feature id for the '<em><b>Constructor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALLS12__CONSTRUCTOR = MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALLS12__FIELDS = MODEL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Rule Calls12</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALLS12_FEATURE_COUNT = MODEL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ConstructorImpl <em>Constructor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ConstructorImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getConstructor()
   * @generated
   */
  int CONSTRUCTOR = 15;

  /**
   * The feature id for the '<em><b>Kw1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR__KW1 = 0;

  /**
   * The number of structural features of the '<em>Constructor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.FieldImpl <em>Field</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.FieldImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getField()
   * @generated
   */
  int FIELD = 16;

  /**
   * The number of structural features of the '<em>Field</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ParameterImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 17;

  /**
   * The feature id for the '<em><b>Kw2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__KW2 = FIELD_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = FIELD_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.NestedStartImpl <em>Nested Start</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.NestedStartImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getNestedStart()
   * @generated
   */
  int NESTED_START = 18;

  /**
   * The number of structural features of the '<em>Nested Start</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_START_FEATURE_COUNT = MODEL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.NestedStartSubImpl <em>Nested Start Sub</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.NestedStartSubImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getNestedStartSub()
   * @generated
   */
  int NESTED_START_SUB = 19;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_START_SUB__NAME = NESTED_START_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Nested Start Sub</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_START_SUB_FEATURE_COUNT = NESTED_START_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.AddImpl <em>Add</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.AddImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getAdd()
   * @generated
   */
  int ADD = 20;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Add</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.MultImpl <em>Mult</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.MultImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getMult()
   * @generated
   */
  int MULT = 21;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Mult</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ValueImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getValue()
   * @generated
   */
  int VALUE = 22;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__VAL = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.FunctionImpl <em>Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.FunctionImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getFunction()
   * @generated
   */
  int FUNCTION = 23;

  /**
   * The feature id for the '<em><b>Func</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__FUNC = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__PARAM = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.PointerImpl <em>Pointer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.PointerImpl
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getPointer()
   * @generated
   */
  int POINTER = 24;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTER__TARGET = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Pointer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTER_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Simple <em>Simple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Simple
   * @generated
   */
  EClass getSimple();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Simple#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Simple#getName()
   * @see #getSimple()
   * @generated
   */
  EAttribute getSimple_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Simple#getOptional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Optional</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Simple#getOptional()
   * @see #getSimple()
   * @generated
   */
  EAttribute getSimple_Optional();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Simple#getDatatype <em>Datatype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Datatype</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Simple#getDatatype()
   * @see #getSimple()
   * @generated
   */
  EAttribute getSimple_Datatype();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCalls <em>Rule Calls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Calls</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCalls
   * @generated
   */
  EClass getRuleCalls();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub <em>Rule Calls Sub</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Calls Sub</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub
   * @generated
   */
  EClass getRuleCallsSub();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub#getName()
   * @see #getRuleCallsSub()
   * @generated
   */
  EAttribute getRuleCallsSub_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub#getCall1 <em>Call1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call1</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub#getCall1()
   * @see #getRuleCallsSub()
   * @generated
   */
  EReference getRuleCallsSub_Call1();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub#getCall2 <em>Call2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call2</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub#getCall2()
   * @see #getRuleCallsSub()
   * @generated
   */
  EReference getRuleCallsSub_Call2();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub#getSub <em>Sub</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sub</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub#getSub()
   * @see #getRuleCallsSub()
   * @generated
   */
  EAttribute getRuleCallsSub_Sub();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsAss1 <em>Rule Calls Ass1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Calls Ass1</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsAss1
   * @generated
   */
  EClass getRuleCallsAss1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsAss1#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsAss1#getName()
   * @see #getRuleCallsAss1()
   * @generated
   */
  EAttribute getRuleCallsAss1_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsAss2 <em>Rule Calls Ass2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Calls Ass2</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsAss2
   * @generated
   */
  EClass getRuleCallsAss2();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsAss2#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsAss2#getName()
   * @see #getRuleCallsAss2()
   * @generated
   */
  EAttribute getRuleCallsAss2_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCalls <em>Optional Calls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Optional Calls</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCalls
   * @generated
   */
  EClass getOptionalCalls();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCalls#getOpt1 <em>Opt1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Opt1</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCalls#getOpt1()
   * @see #getOptionalCalls()
   * @generated
   */
  EReference getOptionalCalls_Opt1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCalls#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCalls#getName()
   * @see #getOptionalCalls()
   * @generated
   */
  EAttribute getOptionalCalls_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub1 <em>Optional Calls Sub1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Optional Calls Sub1</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub1
   * @generated
   */
  EClass getOptionalCallsSub1();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub1#getOpt2 <em>Opt2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Opt2</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub1#getOpt2()
   * @see #getOptionalCallsSub1()
   * @generated
   */
  EReference getOptionalCallsSub1_Opt2();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub1#getOpt3 <em>Opt3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Opt3</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub1#getOpt3()
   * @see #getOptionalCallsSub1()
   * @generated
   */
  EReference getOptionalCallsSub1_Opt3();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub2 <em>Optional Calls Sub2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Optional Calls Sub2</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub2
   * @generated
   */
  EClass getOptionalCallsSub2();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub2#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub2#getName()
   * @see #getOptionalCallsSub2()
   * @generated
   */
  EAttribute getOptionalCallsSub2_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub3 <em>Optional Calls Sub3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Optional Calls Sub3</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub3
   * @generated
   */
  EClass getOptionalCallsSub3();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub3#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub3#getName()
   * @see #getOptionalCallsSub3()
   * @generated
   */
  EAttribute getOptionalCallsSub3_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Recursion <em>Recursion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Recursion</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Recursion
   * @generated
   */
  EClass getRecursion();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RecursionSub <em>Recursion Sub</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Recursion Sub</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RecursionSub
   * @generated
   */
  EClass getRecursionSub();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RecursionSub#getSub <em>Sub</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sub</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RecursionSub#getSub()
   * @see #getRecursionSub()
   * @generated
   */
  EReference getRecursionSub_Sub();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RecursionSub#getVals <em>Vals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Vals</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RecursionSub#getVals()
   * @see #getRecursionSub()
   * @generated
   */
  EAttribute getRecursionSub_Vals();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RecursionSub#isSemi <em>Semi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Semi</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RecursionSub#isSemi()
   * @see #getRecursionSub()
   * @generated
   */
  EAttribute getRecursionSub_Semi();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Loop <em>Loop</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Loop</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Loop
   * @generated
   */
  EClass getLoop();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Loop#getNames <em>Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Names</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Loop#getNames()
   * @see #getLoop()
   * @generated
   */
  EAttribute getLoop_Names();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Loop#getGr <em>Gr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Gr</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Loop#getGr()
   * @see #getLoop()
   * @generated
   */
  EAttribute getLoop_Gr();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Loop#getInts <em>Ints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Ints</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Loop#getInts()
   * @see #getLoop()
   * @generated
   */
  EAttribute getLoop_Ints();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Loop#getStrings <em>Strings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Strings</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Loop#getStrings()
   * @see #getLoop()
   * @generated
   */
  EAttribute getLoop_Strings();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCalls12 <em>Rule Calls12</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Calls12</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCalls12
   * @generated
   */
  EClass getRuleCalls12();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCalls12#getConstructor <em>Constructor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constructor</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCalls12#getConstructor()
   * @see #getRuleCalls12()
   * @generated
   */
  EReference getRuleCalls12_Constructor();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCalls12#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCalls12#getFields()
   * @see #getRuleCalls12()
   * @generated
   */
  EReference getRuleCalls12_Fields();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Constructor <em>Constructor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constructor</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Constructor
   * @generated
   */
  EClass getConstructor();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Constructor#isKw1 <em>Kw1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kw1</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Constructor#isKw1()
   * @see #getConstructor()
   * @generated
   */
  EAttribute getConstructor_Kw1();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Field <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Field
   * @generated
   */
  EClass getField();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Parameter#isKw2 <em>Kw2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kw2</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Parameter#isKw2()
   * @see #getParameter()
   * @generated
   */
  EAttribute getParameter_Kw2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.NestedStart <em>Nested Start</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Start</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.NestedStart
   * @generated
   */
  EClass getNestedStart();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.NestedStartSub <em>Nested Start Sub</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Start Sub</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.NestedStartSub
   * @generated
   */
  EClass getNestedStartSub();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.NestedStartSub#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.NestedStartSub#getName()
   * @see #getNestedStartSub()
   * @generated
   */
  EAttribute getNestedStartSub_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Add <em>Add</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Add</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Add
   * @generated
   */
  EClass getAdd();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Add#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Add#getLeft()
   * @see #getAdd()
   * @generated
   */
  EReference getAdd_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Add#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Add#getRight()
   * @see #getAdd()
   * @generated
   */
  EReference getAdd_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Mult <em>Mult</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mult</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Mult
   * @generated
   */
  EClass getMult();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Mult#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Mult#getLeft()
   * @see #getMult()
   * @generated
   */
  EReference getMult_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Mult#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Mult#getRight()
   * @see #getMult()
   * @generated
   */
  EReference getMult_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Value
   * @generated
   */
  EClass getValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Value#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Value#getVal()
   * @see #getValue()
   * @generated
   */
  EAttribute getValue_Val();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Function
   * @generated
   */
  EClass getFunction();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Function#getFunc <em>Func</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Func</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Function#getFunc()
   * @see #getFunction()
   * @generated
   */
  EAttribute getFunction_Func();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Function#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Param</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Function#getParam()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_Param();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Pointer <em>Pointer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pointer</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Pointer
   * @generated
   */
  EClass getPointer();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Pointer#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Pointer#getTarget()
   * @see #getPointer()
   * @generated
   */
  EReference getPointer_Target();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ElementmatchertestlanguageFactory getElementmatchertestlanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ModelImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.SimpleImpl <em>Simple</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.SimpleImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getSimple()
     * @generated
     */
    EClass SIMPLE = eINSTANCE.getSimple();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE__NAME = eINSTANCE.getSimple_Name();

    /**
     * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE__OPTIONAL = eINSTANCE.getSimple_Optional();

    /**
     * The meta object literal for the '<em><b>Datatype</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE__DATATYPE = eINSTANCE.getSimple_Datatype();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsImpl <em>Rule Calls</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getRuleCalls()
     * @generated
     */
    EClass RULE_CALLS = eINSTANCE.getRuleCalls();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsSubImpl <em>Rule Calls Sub</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsSubImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getRuleCallsSub()
     * @generated
     */
    EClass RULE_CALLS_SUB = eINSTANCE.getRuleCallsSub();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_CALLS_SUB__NAME = eINSTANCE.getRuleCallsSub_Name();

    /**
     * The meta object literal for the '<em><b>Call1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_CALLS_SUB__CALL1 = eINSTANCE.getRuleCallsSub_Call1();

    /**
     * The meta object literal for the '<em><b>Call2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_CALLS_SUB__CALL2 = eINSTANCE.getRuleCallsSub_Call2();

    /**
     * The meta object literal for the '<em><b>Sub</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_CALLS_SUB__SUB = eINSTANCE.getRuleCallsSub_Sub();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsAss1Impl <em>Rule Calls Ass1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsAss1Impl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getRuleCallsAss1()
     * @generated
     */
    EClass RULE_CALLS_ASS1 = eINSTANCE.getRuleCallsAss1();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_CALLS_ASS1__NAME = eINSTANCE.getRuleCallsAss1_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsAss2Impl <em>Rule Calls Ass2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsAss2Impl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getRuleCallsAss2()
     * @generated
     */
    EClass RULE_CALLS_ASS2 = eINSTANCE.getRuleCallsAss2();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_CALLS_ASS2__NAME = eINSTANCE.getRuleCallsAss2_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsImpl <em>Optional Calls</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getOptionalCalls()
     * @generated
     */
    EClass OPTIONAL_CALLS = eINSTANCE.getOptionalCalls();

    /**
     * The meta object literal for the '<em><b>Opt1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPTIONAL_CALLS__OPT1 = eINSTANCE.getOptionalCalls_Opt1();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPTIONAL_CALLS__NAME = eINSTANCE.getOptionalCalls_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsSub1Impl <em>Optional Calls Sub1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsSub1Impl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getOptionalCallsSub1()
     * @generated
     */
    EClass OPTIONAL_CALLS_SUB1 = eINSTANCE.getOptionalCallsSub1();

    /**
     * The meta object literal for the '<em><b>Opt2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPTIONAL_CALLS_SUB1__OPT2 = eINSTANCE.getOptionalCallsSub1_Opt2();

    /**
     * The meta object literal for the '<em><b>Opt3</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPTIONAL_CALLS_SUB1__OPT3 = eINSTANCE.getOptionalCallsSub1_Opt3();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsSub2Impl <em>Optional Calls Sub2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsSub2Impl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getOptionalCallsSub2()
     * @generated
     */
    EClass OPTIONAL_CALLS_SUB2 = eINSTANCE.getOptionalCallsSub2();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPTIONAL_CALLS_SUB2__NAME = eINSTANCE.getOptionalCallsSub2_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsSub3Impl <em>Optional Calls Sub3</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsSub3Impl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getOptionalCallsSub3()
     * @generated
     */
    EClass OPTIONAL_CALLS_SUB3 = eINSTANCE.getOptionalCallsSub3();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPTIONAL_CALLS_SUB3__NAME = eINSTANCE.getOptionalCallsSub3_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RecursionImpl <em>Recursion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RecursionImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getRecursion()
     * @generated
     */
    EClass RECURSION = eINSTANCE.getRecursion();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RecursionSubImpl <em>Recursion Sub</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RecursionSubImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getRecursionSub()
     * @generated
     */
    EClass RECURSION_SUB = eINSTANCE.getRecursionSub();

    /**
     * The meta object literal for the '<em><b>Sub</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECURSION_SUB__SUB = eINSTANCE.getRecursionSub_Sub();

    /**
     * The meta object literal for the '<em><b>Vals</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RECURSION_SUB__VALS = eINSTANCE.getRecursionSub_Vals();

    /**
     * The meta object literal for the '<em><b>Semi</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RECURSION_SUB__SEMI = eINSTANCE.getRecursionSub_Semi();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.LoopImpl <em>Loop</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.LoopImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getLoop()
     * @generated
     */
    EClass LOOP = eINSTANCE.getLoop();

    /**
     * The meta object literal for the '<em><b>Names</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOP__NAMES = eINSTANCE.getLoop_Names();

    /**
     * The meta object literal for the '<em><b>Gr</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOP__GR = eINSTANCE.getLoop_Gr();

    /**
     * The meta object literal for the '<em><b>Ints</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOP__INTS = eINSTANCE.getLoop_Ints();

    /**
     * The meta object literal for the '<em><b>Strings</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOP__STRINGS = eINSTANCE.getLoop_Strings();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ExpressionImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCalls12Impl <em>Rule Calls12</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCalls12Impl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getRuleCalls12()
     * @generated
     */
    EClass RULE_CALLS12 = eINSTANCE.getRuleCalls12();

    /**
     * The meta object literal for the '<em><b>Constructor</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_CALLS12__CONSTRUCTOR = eINSTANCE.getRuleCalls12_Constructor();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_CALLS12__FIELDS = eINSTANCE.getRuleCalls12_Fields();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ConstructorImpl <em>Constructor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ConstructorImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getConstructor()
     * @generated
     */
    EClass CONSTRUCTOR = eINSTANCE.getConstructor();

    /**
     * The meta object literal for the '<em><b>Kw1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRUCTOR__KW1 = eINSTANCE.getConstructor_Kw1();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.FieldImpl <em>Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.FieldImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getField()
     * @generated
     */
    EClass FIELD = eINSTANCE.getField();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ParameterImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '<em><b>Kw2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER__KW2 = eINSTANCE.getParameter_Kw2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.NestedStartImpl <em>Nested Start</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.NestedStartImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getNestedStart()
     * @generated
     */
    EClass NESTED_START = eINSTANCE.getNestedStart();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.NestedStartSubImpl <em>Nested Start Sub</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.NestedStartSubImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getNestedStartSub()
     * @generated
     */
    EClass NESTED_START_SUB = eINSTANCE.getNestedStartSub();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NESTED_START_SUB__NAME = eINSTANCE.getNestedStartSub_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.AddImpl <em>Add</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.AddImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getAdd()
     * @generated
     */
    EClass ADD = eINSTANCE.getAdd();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADD__LEFT = eINSTANCE.getAdd_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADD__RIGHT = eINSTANCE.getAdd_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.MultImpl <em>Mult</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.MultImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getMult()
     * @generated
     */
    EClass MULT = eINSTANCE.getMult();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULT__LEFT = eINSTANCE.getMult_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULT__RIGHT = eINSTANCE.getMult_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ValueImpl <em>Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ValueImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getValue()
     * @generated
     */
    EClass VALUE = eINSTANCE.getValue();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE__VAL = eINSTANCE.getValue_Val();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.FunctionImpl <em>Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.FunctionImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getFunction()
     * @generated
     */
    EClass FUNCTION = eINSTANCE.getFunction();

    /**
     * The meta object literal for the '<em><b>Func</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION__FUNC = eINSTANCE.getFunction_Func();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION__PARAM = eINSTANCE.getFunction_Param();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.PointerImpl <em>Pointer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.PointerImpl
     * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ElementmatchertestlanguagePackageImpl#getPointer()
     * @generated
     */
    EClass POINTER = eINSTANCE.getPointer();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POINTER__TARGET = eINSTANCE.getPointer_Target();

  }

} //ElementmatchertestlanguagePackage
