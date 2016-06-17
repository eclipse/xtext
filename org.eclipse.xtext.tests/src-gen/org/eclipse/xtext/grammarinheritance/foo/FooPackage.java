/**
 */
package org.eclipse.xtext.grammarinheritance.foo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.xtext.grammarinheritance.ametamodel.AmetamodelPackage;

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
 * @see org.eclipse.xtext.grammarinheritance.foo.FooFactory
 * @model kind="package"
 * @generated
 */
public interface FooPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "foo";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://holla";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "foo";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FooPackage eINSTANCE = org.eclipse.xtext.grammarinheritance.foo.impl.FooPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.grammarinheritance.foo.impl.RootRuleImpl <em>Root Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.grammarinheritance.foo.impl.RootRuleImpl
   * @see org.eclipse.xtext.grammarinheritance.foo.impl.FooPackageImpl#getRootRule()
   * @generated
   */
  int ROOT_RULE = 0;

  /**
   * The number of structural features of the '<em>Root Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_RULE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.grammarinheritance.foo.impl.ConcreteParserRuleImpl <em>Concrete Parser Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.grammarinheritance.foo.impl.ConcreteParserRuleImpl
   * @see org.eclipse.xtext.grammarinheritance.foo.impl.FooPackageImpl#getConcreteParserRule()
   * @generated
   */
  int CONCRETE_PARSER_RULE = 1;

  /**
   * The feature id for the '<em><b>Magic Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCRETE_PARSER_RULE__MAGIC_NUMBER = ROOT_RULE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCRETE_PARSER_RULE__ELEMENTS = ROOT_RULE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Concrete Parser Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCRETE_PARSER_RULE_FEATURE_COUNT = ROOT_RULE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.grammarinheritance.foo.impl.CallOverridenParserRuleImpl <em>Call Overriden Parser Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.grammarinheritance.foo.impl.CallOverridenParserRuleImpl
   * @see org.eclipse.xtext.grammarinheritance.foo.impl.FooPackageImpl#getCallOverridenParserRule()
   * @generated
   */
  int CALL_OVERRIDEN_PARSER_RULE = 2;

  /**
   * The feature id for the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_OVERRIDEN_PARSER_RULE__CALL = ROOT_RULE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Call Overriden Parser Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_OVERRIDEN_PARSER_RULE_FEATURE_COUNT = ROOT_RULE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.grammarinheritance.foo.impl.AType2Impl <em>AType2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.grammarinheritance.foo.impl.AType2Impl
   * @see org.eclipse.xtext.grammarinheritance.foo.impl.FooPackageImpl#getAType2()
   * @generated
   */
  int ATYPE2 = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATYPE2__NAME = ROOT_RULE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Age</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATYPE2__AGE = ROOT_RULE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>AType2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATYPE2_FEATURE_COUNT = ROOT_RULE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.grammarinheritance.foo.impl.Subrule1Impl <em>Subrule1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.grammarinheritance.foo.impl.Subrule1Impl
   * @see org.eclipse.xtext.grammarinheritance.foo.impl.FooPackageImpl#getSubrule1()
   * @generated
   */
  int SUBRULE1 = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBRULE1__NAME = AmetamodelPackage.ATYPE__NAME;

  /**
   * The feature id for the '<em><b>Sub1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBRULE1__SUB1 = AmetamodelPackage.ATYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Subrule1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBRULE1_FEATURE_COUNT = AmetamodelPackage.ATYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.grammarinheritance.foo.impl.Subrule2Impl <em>Subrule2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.grammarinheritance.foo.impl.Subrule2Impl
   * @see org.eclipse.xtext.grammarinheritance.foo.impl.FooPackageImpl#getSubrule2()
   * @generated
   */
  int SUBRULE2 = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBRULE2__NAME = AmetamodelPackage.ATYPE__NAME;

  /**
   * The feature id for the '<em><b>Sub2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBRULE2__SUB2 = AmetamodelPackage.ATYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Subrule2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBRULE2_FEATURE_COUNT = AmetamodelPackage.ATYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.grammarinheritance.foo.impl.Subrule3Impl <em>Subrule3</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.grammarinheritance.foo.impl.Subrule3Impl
   * @see org.eclipse.xtext.grammarinheritance.foo.impl.FooPackageImpl#getSubrule3()
   * @generated
   */
  int SUBRULE3 = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBRULE3__NAME = AmetamodelPackage.ATYPE__NAME;

  /**
   * The feature id for the '<em><b>Sub1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBRULE3__SUB1 = AmetamodelPackage.ATYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Subrule3</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBRULE3_FEATURE_COUNT = AmetamodelPackage.ATYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.grammarinheritance.foo.impl.CallExtendedParserRuleImpl <em>Call Extended Parser Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.grammarinheritance.foo.impl.CallExtendedParserRuleImpl
   * @see org.eclipse.xtext.grammarinheritance.foo.impl.FooPackageImpl#getCallExtendedParserRule()
   * @generated
   */
  int CALL_EXTENDED_PARSER_RULE = 7;

  /**
   * The feature id for the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_EXTENDED_PARSER_RULE__CALL = ROOT_RULE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Call Extended Parser Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_EXTENDED_PARSER_RULE_FEATURE_COUNT = ROOT_RULE_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.grammarinheritance.foo.RootRule <em>Root Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root Rule</em>'.
   * @see org.eclipse.xtext.grammarinheritance.foo.RootRule
   * @generated
   */
  EClass getRootRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.grammarinheritance.foo.ConcreteParserRule <em>Concrete Parser Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Concrete Parser Rule</em>'.
   * @see org.eclipse.xtext.grammarinheritance.foo.ConcreteParserRule
   * @generated
   */
  EClass getConcreteParserRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.grammarinheritance.foo.ConcreteParserRule#getMagicNumber <em>Magic Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Magic Number</em>'.
   * @see org.eclipse.xtext.grammarinheritance.foo.ConcreteParserRule#getMagicNumber()
   * @see #getConcreteParserRule()
   * @generated
   */
  EAttribute getConcreteParserRule_MagicNumber();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.grammarinheritance.foo.ConcreteParserRule#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipse.xtext.grammarinheritance.foo.ConcreteParserRule#getElements()
   * @see #getConcreteParserRule()
   * @generated
   */
  EReference getConcreteParserRule_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.grammarinheritance.foo.CallOverridenParserRule <em>Call Overriden Parser Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Call Overriden Parser Rule</em>'.
   * @see org.eclipse.xtext.grammarinheritance.foo.CallOverridenParserRule
   * @generated
   */
  EClass getCallOverridenParserRule();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.grammarinheritance.foo.CallOverridenParserRule#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see org.eclipse.xtext.grammarinheritance.foo.CallOverridenParserRule#getCall()
   * @see #getCallOverridenParserRule()
   * @generated
   */
  EReference getCallOverridenParserRule_Call();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.grammarinheritance.foo.AType2 <em>AType2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AType2</em>'.
   * @see org.eclipse.xtext.grammarinheritance.foo.AType2
   * @generated
   */
  EClass getAType2();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.grammarinheritance.foo.AType2#getAge <em>Age</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Age</em>'.
   * @see org.eclipse.xtext.grammarinheritance.foo.AType2#getAge()
   * @see #getAType2()
   * @generated
   */
  EAttribute getAType2_Age();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.grammarinheritance.foo.Subrule1 <em>Subrule1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subrule1</em>'.
   * @see org.eclipse.xtext.grammarinheritance.foo.Subrule1
   * @generated
   */
  EClass getSubrule1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.grammarinheritance.foo.Subrule1#getSub1 <em>Sub1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sub1</em>'.
   * @see org.eclipse.xtext.grammarinheritance.foo.Subrule1#getSub1()
   * @see #getSubrule1()
   * @generated
   */
  EAttribute getSubrule1_Sub1();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.grammarinheritance.foo.Subrule2 <em>Subrule2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subrule2</em>'.
   * @see org.eclipse.xtext.grammarinheritance.foo.Subrule2
   * @generated
   */
  EClass getSubrule2();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.grammarinheritance.foo.Subrule2#getSub2 <em>Sub2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sub2</em>'.
   * @see org.eclipse.xtext.grammarinheritance.foo.Subrule2#getSub2()
   * @see #getSubrule2()
   * @generated
   */
  EAttribute getSubrule2_Sub2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.grammarinheritance.foo.Subrule3 <em>Subrule3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subrule3</em>'.
   * @see org.eclipse.xtext.grammarinheritance.foo.Subrule3
   * @generated
   */
  EClass getSubrule3();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.grammarinheritance.foo.Subrule3#getSub1 <em>Sub1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sub1</em>'.
   * @see org.eclipse.xtext.grammarinheritance.foo.Subrule3#getSub1()
   * @see #getSubrule3()
   * @generated
   */
  EAttribute getSubrule3_Sub1();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.grammarinheritance.foo.CallExtendedParserRule <em>Call Extended Parser Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Call Extended Parser Rule</em>'.
   * @see org.eclipse.xtext.grammarinheritance.foo.CallExtendedParserRule
   * @generated
   */
  EClass getCallExtendedParserRule();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.grammarinheritance.foo.CallExtendedParserRule#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see org.eclipse.xtext.grammarinheritance.foo.CallExtendedParserRule#getCall()
   * @see #getCallExtendedParserRule()
   * @generated
   */
  EReference getCallExtendedParserRule_Call();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FooFactory getFooFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.grammarinheritance.foo.impl.RootRuleImpl <em>Root Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.grammarinheritance.foo.impl.RootRuleImpl
     * @see org.eclipse.xtext.grammarinheritance.foo.impl.FooPackageImpl#getRootRule()
     * @generated
     */
    EClass ROOT_RULE = eINSTANCE.getRootRule();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.grammarinheritance.foo.impl.ConcreteParserRuleImpl <em>Concrete Parser Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.grammarinheritance.foo.impl.ConcreteParserRuleImpl
     * @see org.eclipse.xtext.grammarinheritance.foo.impl.FooPackageImpl#getConcreteParserRule()
     * @generated
     */
    EClass CONCRETE_PARSER_RULE = eINSTANCE.getConcreteParserRule();

    /**
     * The meta object literal for the '<em><b>Magic Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONCRETE_PARSER_RULE__MAGIC_NUMBER = eINSTANCE.getConcreteParserRule_MagicNumber();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONCRETE_PARSER_RULE__ELEMENTS = eINSTANCE.getConcreteParserRule_Elements();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.grammarinheritance.foo.impl.CallOverridenParserRuleImpl <em>Call Overriden Parser Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.grammarinheritance.foo.impl.CallOverridenParserRuleImpl
     * @see org.eclipse.xtext.grammarinheritance.foo.impl.FooPackageImpl#getCallOverridenParserRule()
     * @generated
     */
    EClass CALL_OVERRIDEN_PARSER_RULE = eINSTANCE.getCallOverridenParserRule();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALL_OVERRIDEN_PARSER_RULE__CALL = eINSTANCE.getCallOverridenParserRule_Call();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.grammarinheritance.foo.impl.AType2Impl <em>AType2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.grammarinheritance.foo.impl.AType2Impl
     * @see org.eclipse.xtext.grammarinheritance.foo.impl.FooPackageImpl#getAType2()
     * @generated
     */
    EClass ATYPE2 = eINSTANCE.getAType2();

    /**
     * The meta object literal for the '<em><b>Age</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATYPE2__AGE = eINSTANCE.getAType2_Age();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.grammarinheritance.foo.impl.Subrule1Impl <em>Subrule1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.grammarinheritance.foo.impl.Subrule1Impl
     * @see org.eclipse.xtext.grammarinheritance.foo.impl.FooPackageImpl#getSubrule1()
     * @generated
     */
    EClass SUBRULE1 = eINSTANCE.getSubrule1();

    /**
     * The meta object literal for the '<em><b>Sub1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUBRULE1__SUB1 = eINSTANCE.getSubrule1_Sub1();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.grammarinheritance.foo.impl.Subrule2Impl <em>Subrule2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.grammarinheritance.foo.impl.Subrule2Impl
     * @see org.eclipse.xtext.grammarinheritance.foo.impl.FooPackageImpl#getSubrule2()
     * @generated
     */
    EClass SUBRULE2 = eINSTANCE.getSubrule2();

    /**
     * The meta object literal for the '<em><b>Sub2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUBRULE2__SUB2 = eINSTANCE.getSubrule2_Sub2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.grammarinheritance.foo.impl.Subrule3Impl <em>Subrule3</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.grammarinheritance.foo.impl.Subrule3Impl
     * @see org.eclipse.xtext.grammarinheritance.foo.impl.FooPackageImpl#getSubrule3()
     * @generated
     */
    EClass SUBRULE3 = eINSTANCE.getSubrule3();

    /**
     * The meta object literal for the '<em><b>Sub1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUBRULE3__SUB1 = eINSTANCE.getSubrule3_Sub1();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.grammarinheritance.foo.impl.CallExtendedParserRuleImpl <em>Call Extended Parser Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.grammarinheritance.foo.impl.CallExtendedParserRuleImpl
     * @see org.eclipse.xtext.grammarinheritance.foo.impl.FooPackageImpl#getCallExtendedParserRule()
     * @generated
     */
    EClass CALL_EXTENDED_PARSER_RULE = eINSTANCE.getCallExtendedParserRule();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALL_EXTENDED_PARSER_RULE__CALL = eINSTANCE.getCallExtendedParserRule_Call();

  }

} //FooPackage
