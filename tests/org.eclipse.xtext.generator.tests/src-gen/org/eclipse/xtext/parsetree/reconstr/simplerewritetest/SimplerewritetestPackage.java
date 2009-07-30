/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest;

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
 * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestFactory
 * @model kind="package"
 * @generated
 */
public interface SimplerewritetestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "simplerewritetest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/simplerewritetest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "simplerewritetest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SimplerewritetestPackage eINSTANCE = org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.ExpressionImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 0;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EM = 0;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.AtomImpl <em>Atom</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.AtomImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getAtom()
   * @generated
   */
  int ATOM = 1;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM__NAME = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Atom</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TwoNumbersImpl <em>Two Numbers</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TwoNumbersImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getTwoNumbers()
   * @generated
   */
  int TWO_NUMBERS = 2;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TWO_NUMBERS__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Num1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TWO_NUMBERS__NUM1 = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Num2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TWO_NUMBERS__NUM2 = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Num3</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TWO_NUMBERS__NUM3 = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Two Numbers</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TWO_NUMBERS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.ManyStringsImpl <em>Many Strings</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.ManyStringsImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getManyStrings()
   * @generated
   */
  int MANY_STRINGS = 3;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MANY_STRINGS__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Str1</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MANY_STRINGS__STR1 = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Str2</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MANY_STRINGS__STR2 = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Many Strings</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MANY_STRINGS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getType()
   * @generated
   */
  int TYPE = 4;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__NAME = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__EXTENDS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Ref2Impl <em>Ref2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Ref2Impl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getRef2()
   * @generated
   */
  int REF2 = 5;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF2__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Ref2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF2__REF2 = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Ref2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF2_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SpareImpl <em>Spare</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SpareImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getSpare()
   * @generated
   */
  int SPARE = 6;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPARE__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPARE__ID = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Spare</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPARE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.BooleanImpl <em>Boolean</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.BooleanImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getBoolean()
   * @generated
   */
  int BOOLEAN = 7;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Bool</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN__BOOL = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN__VALUE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Boolean</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Transient1Impl <em>Transient1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Transient1Impl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getTransient1()
   * @generated
   */
  int TRANSIENT1 = 8;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSIENT1__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Prec Star</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSIENT1__PREC_STAR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Prec</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSIENT1__PREC = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Scale Star</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSIENT1__SCALE_STAR = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Scale</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSIENT1__SCALE = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Transient1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSIENT1_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Consumed1Impl <em>Consumed1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Consumed1Impl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getConsumed1()
   * @generated
   */
  int CONSUMED1 = 9;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSUMED1__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>V1</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSUMED1__V1 = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>V2</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSUMED1__V2 = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Consumed1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSUMED1_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Consumed2Impl <em>Consumed2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Consumed2Impl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getConsumed2()
   * @generated
   */
  int CONSUMED2 = 10;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSUMED2__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Child</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSUMED2__CHILD = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Consumed2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSUMED2_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.OpImpl <em>Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.OpImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getOp()
   * @generated
   */
  int OP = 11;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP__VALUES = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Op</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Expression#getEm <em>Em</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Em</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Expression#getEm()
   * @see #getExpression()
   * @generated
   */
  EAttribute getExpression_Em();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Atom <em>Atom</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atom</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Atom
   * @generated
   */
  EClass getAtom();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Atom#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Atom#getName()
   * @see #getAtom()
   * @generated
   */
  EAttribute getAtom_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers <em>Two Numbers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Two Numbers</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers
   * @generated
   */
  EClass getTwoNumbers();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers#getNum1 <em>Num1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Num1</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers#getNum1()
   * @see #getTwoNumbers()
   * @generated
   */
  EAttribute getTwoNumbers_Num1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers#getNum2 <em>Num2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Num2</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers#getNum2()
   * @see #getTwoNumbers()
   * @generated
   */
  EAttribute getTwoNumbers_Num2();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers#getNum3 <em>Num3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Num3</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers#getNum3()
   * @see #getTwoNumbers()
   * @generated
   */
  EAttribute getTwoNumbers_Num3();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ManyStrings <em>Many Strings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Many Strings</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ManyStrings
   * @generated
   */
  EClass getManyStrings();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ManyStrings#getStr1 <em>Str1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Str1</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ManyStrings#getStr1()
   * @see #getManyStrings()
   * @generated
   */
  EAttribute getManyStrings_Str1();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ManyStrings#getStr2 <em>Str2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Str2</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ManyStrings#getStr2()
   * @see #getManyStrings()
   * @generated
   */
  EAttribute getManyStrings_Str2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Type#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Type#getName()
   * @see #getType()
   * @generated
   */
  EAttribute getType_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Type#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Extends</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Type#getExtends()
   * @see #getType()
   * @generated
   */
  EReference getType_Extends();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Ref2 <em>Ref2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ref2</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Ref2
   * @generated
   */
  EClass getRef2();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Ref2#getRef2 <em>Ref2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref2</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Ref2#getRef2()
   * @see #getRef2()
   * @generated
   */
  EAttribute getRef2_Ref2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Spare <em>Spare</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Spare</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Spare
   * @generated
   */
  EClass getSpare();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Spare#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Id</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Spare#getId()
   * @see #getSpare()
   * @generated
   */
  EAttribute getSpare_Id();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean <em>Boolean</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean
   * @generated
   */
  EClass getBoolean();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean#isBool <em>Bool</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bool</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean#isBool()
   * @see #getBoolean()
   * @generated
   */
  EAttribute getBoolean_Bool();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean#getValue()
   * @see #getBoolean()
   * @generated
   */
  EAttribute getBoolean_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Transient1 <em>Transient1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transient1</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Transient1
   * @generated
   */
  EClass getTransient1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Transient1#isPrecStar <em>Prec Star</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Prec Star</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Transient1#isPrecStar()
   * @see #getTransient1()
   * @generated
   */
  EAttribute getTransient1_PrecStar();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Transient1#getPrec <em>Prec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Prec</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Transient1#getPrec()
   * @see #getTransient1()
   * @generated
   */
  EAttribute getTransient1_Prec();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Transient1#isScaleStar <em>Scale Star</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Scale Star</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Transient1#isScaleStar()
   * @see #getTransient1()
   * @generated
   */
  EAttribute getTransient1_ScaleStar();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Transient1#getScale <em>Scale</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Scale</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Transient1#getScale()
   * @see #getTransient1()
   * @generated
   */
  EAttribute getTransient1_Scale();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed1 <em>Consumed1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Consumed1</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed1
   * @generated
   */
  EClass getConsumed1();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed1#getV1 <em>V1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>V1</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed1#getV1()
   * @see #getConsumed1()
   * @generated
   */
  EAttribute getConsumed1_V1();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed1#getV2 <em>V2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>V2</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed1#getV2()
   * @see #getConsumed1()
   * @generated
   */
  EAttribute getConsumed1_V2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed2 <em>Consumed2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Consumed2</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed2
   * @generated
   */
  EClass getConsumed2();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed2#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Child</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed2#getChild()
   * @see #getConsumed2()
   * @generated
   */
  EReference getConsumed2_Child();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Op <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Op
   * @generated
   */
  EClass getOp();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Op#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Op#getValues()
   * @see #getOp()
   * @generated
   */
  EReference getOp_Values();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SimplerewritetestFactory getSimplerewritetestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.ExpressionImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Em</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION__EM = eINSTANCE.getExpression_Em();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.AtomImpl <em>Atom</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.AtomImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getAtom()
     * @generated
     */
    EClass ATOM = eINSTANCE.getAtom();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATOM__NAME = eINSTANCE.getAtom_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TwoNumbersImpl <em>Two Numbers</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TwoNumbersImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getTwoNumbers()
     * @generated
     */
    EClass TWO_NUMBERS = eINSTANCE.getTwoNumbers();

    /**
     * The meta object literal for the '<em><b>Num1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TWO_NUMBERS__NUM1 = eINSTANCE.getTwoNumbers_Num1();

    /**
     * The meta object literal for the '<em><b>Num2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TWO_NUMBERS__NUM2 = eINSTANCE.getTwoNumbers_Num2();

    /**
     * The meta object literal for the '<em><b>Num3</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TWO_NUMBERS__NUM3 = eINSTANCE.getTwoNumbers_Num3();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.ManyStringsImpl <em>Many Strings</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.ManyStringsImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getManyStrings()
     * @generated
     */
    EClass MANY_STRINGS = eINSTANCE.getManyStrings();

    /**
     * The meta object literal for the '<em><b>Str1</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MANY_STRINGS__STR1 = eINSTANCE.getManyStrings_Str1();

    /**
     * The meta object literal for the '<em><b>Str2</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MANY_STRINGS__STR2 = eINSTANCE.getManyStrings_Str2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE__NAME = eINSTANCE.getType_Name();

    /**
     * The meta object literal for the '<em><b>Extends</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE__EXTENDS = eINSTANCE.getType_Extends();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Ref2Impl <em>Ref2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Ref2Impl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getRef2()
     * @generated
     */
    EClass REF2 = eINSTANCE.getRef2();

    /**
     * The meta object literal for the '<em><b>Ref2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REF2__REF2 = eINSTANCE.getRef2_Ref2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SpareImpl <em>Spare</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SpareImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getSpare()
     * @generated
     */
    EClass SPARE = eINSTANCE.getSpare();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SPARE__ID = eINSTANCE.getSpare_Id();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.BooleanImpl <em>Boolean</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.BooleanImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getBoolean()
     * @generated
     */
    EClass BOOLEAN = eINSTANCE.getBoolean();

    /**
     * The meta object literal for the '<em><b>Bool</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN__BOOL = eINSTANCE.getBoolean_Bool();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN__VALUE = eINSTANCE.getBoolean_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Transient1Impl <em>Transient1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Transient1Impl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getTransient1()
     * @generated
     */
    EClass TRANSIENT1 = eINSTANCE.getTransient1();

    /**
     * The meta object literal for the '<em><b>Prec Star</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSIENT1__PREC_STAR = eINSTANCE.getTransient1_PrecStar();

    /**
     * The meta object literal for the '<em><b>Prec</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSIENT1__PREC = eINSTANCE.getTransient1_Prec();

    /**
     * The meta object literal for the '<em><b>Scale Star</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSIENT1__SCALE_STAR = eINSTANCE.getTransient1_ScaleStar();

    /**
     * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSIENT1__SCALE = eINSTANCE.getTransient1_Scale();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Consumed1Impl <em>Consumed1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Consumed1Impl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getConsumed1()
     * @generated
     */
    EClass CONSUMED1 = eINSTANCE.getConsumed1();

    /**
     * The meta object literal for the '<em><b>V1</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSUMED1__V1 = eINSTANCE.getConsumed1_V1();

    /**
     * The meta object literal for the '<em><b>V2</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSUMED1__V2 = eINSTANCE.getConsumed1_V2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Consumed2Impl <em>Consumed2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Consumed2Impl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getConsumed2()
     * @generated
     */
    EClass CONSUMED2 = eINSTANCE.getConsumed2();

    /**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSUMED2__CHILD = eINSTANCE.getConsumed2_Child();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.OpImpl <em>Op</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.OpImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getOp()
     * @generated
     */
    EClass OP = eINSTANCE.getOp();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OP__VALUES = eINSTANCE.getOp_Values();

  }

} //SimplerewritetestPackage
