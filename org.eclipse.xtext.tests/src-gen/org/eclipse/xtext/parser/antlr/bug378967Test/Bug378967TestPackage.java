/**
 */
package org.eclipse.xtext.parser.antlr.bug378967Test;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.xtext.parser.antlr.bug378967Test.Bug378967TestFactory
 * @model kind="package"
 * @generated
 */
public interface Bug378967TestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug378967Test";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://eclipse.org/xtext/Bug378967TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug378967Test";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug378967TestPackage eINSTANCE = org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.impl.RootImpl <em>Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.RootImpl
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getRoot()
   * @generated
   */
  int ROOT = 0;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT__ELEMENT = 0;

  /**
   * The number of structural features of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule1Impl <em>Rule1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule1Impl
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getRule1()
   * @generated
   */
  int RULE1 = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE1__TYPE = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE1__VALUE = 1;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE1__UNIT = 2;

  /**
   * The number of structural features of the '<em>Rule1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE1_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule2Impl <em>Rule2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule2Impl
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getRule2()
   * @generated
   */
  int RULE2 = 2;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE2__VALUE = 0;

  /**
   * The number of structural features of the '<em>Rule2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule3Impl <em>Rule3</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule3Impl
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getRule3()
   * @generated
   */
  int RULE3 = 3;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE3__VALUE = 0;

  /**
   * The number of structural features of the '<em>Rule3</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE3_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule4Impl <em>Rule4</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule4Impl
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getRule4()
   * @generated
   */
  int RULE4 = 4;

  /**
   * The feature id for the '<em><b>After</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE4__AFTER = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE4__VALUE = 1;

  /**
   * The feature id for the '<em><b>S</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE4__S = 2;

  /**
   * The number of structural features of the '<em>Rule4</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE4_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.impl.AfterObjImpl <em>After Obj</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.AfterObjImpl
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getAfterObj()
   * @generated
   */
  int AFTER_OBJ = 5;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFTER_OBJ__VALUE = 0;

  /**
   * The number of structural features of the '<em>After Obj</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFTER_OBJ_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.impl.SObjImpl <em>SObj</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.SObjImpl
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getSObj()
   * @generated
   */
  int SOBJ = 6;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOBJ__VALUE = 0;

  /**
   * The number of structural features of the '<em>SObj</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOBJ_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.FirstEnum <em>First Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.FirstEnum
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getFirstEnum()
   * @generated
   */
  int FIRST_ENUM = 7;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.SecondEnum <em>Second Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.SecondEnum
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getSecondEnum()
   * @generated
   */
  int SECOND_ENUM = 8;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Root <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Root
   * @generated
   */
  EClass getRoot();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Root#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Root#getElement()
   * @see #getRoot()
   * @generated
   */
  EReference getRoot_Element();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule1 <em>Rule1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule1</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Rule1
   * @generated
   */
  EClass getRule1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule1#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Rule1#getType()
   * @see #getRule1()
   * @generated
   */
  EAttribute getRule1_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule1#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Rule1#getValue()
   * @see #getRule1()
   * @generated
   */
  EAttribute getRule1_Value();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule1#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Rule1#getUnit()
   * @see #getRule1()
   * @generated
   */
  EAttribute getRule1_Unit();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule2 <em>Rule2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule2</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Rule2
   * @generated
   */
  EClass getRule2();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule2#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Rule2#getValue()
   * @see #getRule2()
   * @generated
   */
  EAttribute getRule2_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule3 <em>Rule3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule3</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Rule3
   * @generated
   */
  EClass getRule3();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule3#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Rule3#getValue()
   * @see #getRule3()
   * @generated
   */
  EAttribute getRule3_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule4 <em>Rule4</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule4</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Rule4
   * @generated
   */
  EClass getRule4();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule4#getAfter <em>After</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>After</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Rule4#getAfter()
   * @see #getRule4()
   * @generated
   */
  EReference getRule4_After();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule4#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Rule4#getValue()
   * @see #getRule4()
   * @generated
   */
  EAttribute getRule4_Value();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule4#getS <em>S</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>S</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Rule4#getS()
   * @see #getRule4()
   * @generated
   */
  EReference getRule4_S();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.antlr.bug378967Test.AfterObj <em>After Obj</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>After Obj</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.AfterObj
   * @generated
   */
  EClass getAfterObj();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.antlr.bug378967Test.AfterObj#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.AfterObj#getValue()
   * @see #getAfterObj()
   * @generated
   */
  EAttribute getAfterObj_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.antlr.bug378967Test.SObj <em>SObj</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SObj</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.SObj
   * @generated
   */
  EClass getSObj();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.antlr.bug378967Test.SObj#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.SObj#getValue()
   * @see #getSObj()
   * @generated
   */
  EAttribute getSObj_Value();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.parser.antlr.bug378967Test.FirstEnum <em>First Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>First Enum</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.FirstEnum
   * @generated
   */
  EEnum getFirstEnum();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.parser.antlr.bug378967Test.SecondEnum <em>Second Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Second Enum</em>'.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.SecondEnum
   * @generated
   */
  EEnum getSecondEnum();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug378967TestFactory getBug378967TestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.impl.RootImpl <em>Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.RootImpl
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getRoot()
     * @generated
     */
    EClass ROOT = eINSTANCE.getRoot();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOT__ELEMENT = eINSTANCE.getRoot_Element();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule1Impl <em>Rule1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule1Impl
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getRule1()
     * @generated
     */
    EClass RULE1 = eINSTANCE.getRule1();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE1__TYPE = eINSTANCE.getRule1_Type();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE1__VALUE = eINSTANCE.getRule1_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE1__UNIT = eINSTANCE.getRule1_Unit();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule2Impl <em>Rule2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule2Impl
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getRule2()
     * @generated
     */
    EClass RULE2 = eINSTANCE.getRule2();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE2__VALUE = eINSTANCE.getRule2_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule3Impl <em>Rule3</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule3Impl
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getRule3()
     * @generated
     */
    EClass RULE3 = eINSTANCE.getRule3();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE3__VALUE = eINSTANCE.getRule3_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule4Impl <em>Rule4</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule4Impl
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getRule4()
     * @generated
     */
    EClass RULE4 = eINSTANCE.getRule4();

    /**
     * The meta object literal for the '<em><b>After</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE4__AFTER = eINSTANCE.getRule4_After();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE4__VALUE = eINSTANCE.getRule4_Value();

    /**
     * The meta object literal for the '<em><b>S</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE4__S = eINSTANCE.getRule4_S();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.impl.AfterObjImpl <em>After Obj</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.AfterObjImpl
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getAfterObj()
     * @generated
     */
    EClass AFTER_OBJ = eINSTANCE.getAfterObj();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AFTER_OBJ__VALUE = eINSTANCE.getAfterObj_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.impl.SObjImpl <em>SObj</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.SObjImpl
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getSObj()
     * @generated
     */
    EClass SOBJ = eINSTANCE.getSObj();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOBJ__VALUE = eINSTANCE.getSObj_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.FirstEnum <em>First Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.FirstEnum
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getFirstEnum()
     * @generated
     */
    EEnum FIRST_ENUM = eINSTANCE.getFirstEnum();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.SecondEnum <em>Second Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.SecondEnum
     * @see org.eclipse.xtext.parser.antlr.bug378967Test.impl.Bug378967TestPackageImpl#getSecondEnum()
     * @generated
     */
    EEnum SECOND_ENUM = eINSTANCE.getSecondEnum();

  }

} //Bug378967TestPackage
