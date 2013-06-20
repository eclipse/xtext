/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest;

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
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Loop1Impl <em>Loop1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Loop1Impl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getLoop1()
   * @generated
   */
  int LOOP1 = 11;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP1__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP1__ID = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Loop1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP1_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Loop2Impl <em>Loop2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Loop2Impl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getLoop2()
   * @generated
   */
  int LOOP2 = 12;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP2__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP2__ID = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Loop2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP2_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Loop3Impl <em>Loop3</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Loop3Impl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getLoop3()
   * @generated
   */
  int LOOP3 = 13;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP3__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP3__ID = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Loop3</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP3_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Loop4Impl <em>Loop4</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Loop4Impl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getLoop4()
   * @generated
   */
  int LOOP4 = 14;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP4__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP4__ID = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Loop4</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP4_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.LoopBug285452Impl <em>Loop Bug285452</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.LoopBug285452Impl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getLoopBug285452()
   * @generated
   */
  int LOOP_BUG285452 = 15;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_BUG285452__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_BUG285452__INTERFACE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_BUG285452__NAME = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Loop Bug285452</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_BUG285452_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.DuplicateBug284491Impl <em>Duplicate Bug284491</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.DuplicateBug284491Impl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getDuplicateBug284491()
   * @generated
   */
  int DUPLICATE_BUG284491 = 16;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DUPLICATE_BUG284491__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DUPLICATE_BUG284491__STATIC = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DUPLICATE_BUG284491__FINAL = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Transient</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DUPLICATE_BUG284491__TRANSIENT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Duplicate Bug284491</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DUPLICATE_BUG284491_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EmptyObjectBug284850Impl <em>Empty Object Bug284850</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EmptyObjectBug284850Impl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getEmptyObjectBug284850()
   * @generated
   */
  int EMPTY_OBJECT_BUG284850 = 17;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMPTY_OBJECT_BUG284850__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Items</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMPTY_OBJECT_BUG284850__ITEMS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Empty Object Bug284850</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMPTY_OBJECT_BUG284850_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EmptyObjectItemsImpl <em>Empty Object Items</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EmptyObjectItemsImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getEmptyObjectItems()
   * @generated
   */
  int EMPTY_OBJECT_ITEMS = 18;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMPTY_OBJECT_ITEMS__LIST = 0;

  /**
   * The number of structural features of the '<em>Empty Object Items</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMPTY_OBJECT_ITEMS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EmptyObjectItemImpl <em>Empty Object Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EmptyObjectItemImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getEmptyObjectItem()
   * @generated
   */
  int EMPTY_OBJECT_ITEM = 19;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMPTY_OBJECT_ITEM__NAME = 0;

  /**
   * The number of structural features of the '<em>Empty Object Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMPTY_OBJECT_ITEM_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.MultiInheritanceBug280439Impl <em>Multi Inheritance Bug280439</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.MultiInheritanceBug280439Impl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getMultiInheritanceBug280439()
   * @generated
   */
  int MULTI_INHERITANCE_BUG280439 = 20;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_INHERITANCE_BUG280439__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_INHERITANCE_BUG280439__VAL = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Multi Inheritance Bug280439</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_INHERITANCE_BUG280439_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.AbstractMulti1Impl <em>Abstract Multi1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.AbstractMulti1Impl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getAbstractMulti1()
   * @generated
   */
  int ABSTRACT_MULTI1 = 21;

  /**
   * The feature id for the '<em><b>M1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_MULTI1__M1 = 0;

  /**
   * The number of structural features of the '<em>Abstract Multi1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_MULTI1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.AbstractMulti2Impl <em>Abstract Multi2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.AbstractMulti2Impl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getAbstractMulti2()
   * @generated
   */
  int ABSTRACT_MULTI2 = 22;

  /**
   * The feature id for the '<em><b>M2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_MULTI2__M2 = 0;

  /**
   * The number of structural features of the '<em>Abstract Multi2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_MULTI2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.ConcreteMultiImpl <em>Concrete Multi</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.ConcreteMultiImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getConcreteMulti()
   * @generated
   */
  int CONCRETE_MULTI = 23;

  /**
   * The feature id for the '<em><b>M1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCRETE_MULTI__M1 = ABSTRACT_MULTI1__M1;

  /**
   * The feature id for the '<em><b>M2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCRETE_MULTI__M2 = ABSTRACT_MULTI1_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Concrete Multi</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCRETE_MULTI_FEATURE_COUNT = ABSTRACT_MULTI1_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EObjectRefImpl <em>EObject Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EObjectRefImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getEObjectRef()
   * @generated
   */
  int EOBJECT_REF = 24;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOBJECT_REF__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Obj</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOBJECT_REF__OBJ = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOBJECT_REF__REF = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>EObject Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOBJECT_REF_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EObjectElementImpl <em>EObject Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EObjectElementImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getEObjectElement()
   * @generated
   */
  int EOBJECT_ELEMENT = 25;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOBJECT_ELEMENT__NAME = 0;

  /**
   * The number of structural features of the '<em>EObject Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOBJECT_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug305577_1Impl <em>Type Bug305577 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug305577_1Impl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getTypeBug305577_1()
   * @generated
   */
  int TYPE_BUG305577_1 = 26;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_BUG305577_1__EM = EXPRESSION__EM;

  /**
   * The number of structural features of the '<em>Type Bug305577 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_BUG305577_1_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug305577_2Impl <em>Type Bug305577 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug305577_2Impl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getTypeBug305577_2()
   * @generated
   */
  int TYPE_BUG305577_2 = 27;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_BUG305577_2__EM = EXPRESSION__EM;

  /**
   * The number of structural features of the '<em>Type Bug305577 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_BUG305577_2_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug1AImpl <em>Type Bug1 A</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug1AImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getTypeBug1A()
   * @generated
   */
  int TYPE_BUG1_A = 28;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_BUG1_A__EM = TYPE_BUG305577_1__EM;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_BUG1_A__NAME = TYPE_BUG305577_1_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type Bug1 A</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_BUG1_A_FEATURE_COUNT = TYPE_BUG305577_1_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug1BImpl <em>Type Bug1 B</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug1BImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getTypeBug1B()
   * @generated
   */
  int TYPE_BUG1_B = 29;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_BUG1_B__EM = TYPE_BUG305577_1__EM;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_BUG1_B__NAME = TYPE_BUG305577_1_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type Bug1 B</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_BUG1_B_FEATURE_COUNT = TYPE_BUG305577_1_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug2AImpl <em>Type Bug2 A</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug2AImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getTypeBug2A()
   * @generated
   */
  int TYPE_BUG2_A = 30;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_BUG2_A__EM = TYPE_BUG305577_2__EM;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_BUG2_A__NAME = TYPE_BUG305577_2_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type Bug2 A</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_BUG2_A_FEATURE_COUNT = TYPE_BUG305577_2_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug2BImpl <em>Type Bug2 B</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug2BImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getTypeBug2B()
   * @generated
   */
  int TYPE_BUG2_B = 31;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_BUG2_B__EM = TYPE_BUG305577_2__EM;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_BUG2_B__NAME = TYPE_BUG305577_2_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type Bug2 B</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_BUG2_B_FEATURE_COUNT = TYPE_BUG305577_2_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug305171Impl <em>Bug305171</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug305171Impl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getBug305171()
   * @generated
   */
  int BUG305171 = 32;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG305171__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG305171__X = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG305171__Y = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Z</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG305171__Z = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG305171__NAME = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Bug305171</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG305171_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug310435EnumImpl <em>Bug310435 Enum</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug310435EnumImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getBug310435Enum()
   * @generated
   */
  int BUG310435_ENUM = 33;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG310435_ENUM__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Lits</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG310435_ENUM__LITS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Bug310435 Enum</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG310435_ENUM_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug310435ValImpl <em>Bug310435 Val</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug310435ValImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getBug310435Val()
   * @generated
   */
  int BUG310435_VAL = 34;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG310435_VAL__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Lits</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG310435_VAL__LITS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Bug310435 Val</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUG310435_VAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.CrossRefNameTestImpl <em>Cross Ref Name Test</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.CrossRefNameTestImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getCrossRefNameTest()
   * @generated
   */
  int CROSS_REF_NAME_TEST = 35;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CROSS_REF_NAME_TEST__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Named</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CROSS_REF_NAME_TEST__NAMED = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CROSS_REF_NAME_TEST__REF = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Cross Ref Name Test</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CROSS_REF_NAME_TEST_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.CrossRefNamedImpl <em>Cross Ref Named</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.CrossRefNamedImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getCrossRefNamed()
   * @generated
   */
  int CROSS_REF_NAMED = 36;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CROSS_REF_NAMED__NAME = 0;

  /**
   * The number of structural features of the '<em>Cross Ref Named</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CROSS_REF_NAMED_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.OpImpl <em>Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.OpImpl
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getOp()
   * @generated
   */
  int OP = 37;

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
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EnumBug310435Enum <em>Enum Bug310435 Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EnumBug310435Enum
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getEnumBug310435Enum()
   * @generated
   */
  int ENUM_BUG310435_ENUM = 38;


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
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop1 <em>Loop1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Loop1</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop1
   * @generated
   */
  EClass getLoop1();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop1#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Id</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop1#getId()
   * @see #getLoop1()
   * @generated
   */
  EAttribute getLoop1_Id();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop2 <em>Loop2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Loop2</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop2
   * @generated
   */
  EClass getLoop2();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop2#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Id</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop2#getId()
   * @see #getLoop2()
   * @generated
   */
  EAttribute getLoop2_Id();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop3 <em>Loop3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Loop3</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop3
   * @generated
   */
  EClass getLoop3();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop3#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Id</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop3#getId()
   * @see #getLoop3()
   * @generated
   */
  EAttribute getLoop3_Id();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop4 <em>Loop4</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Loop4</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop4
   * @generated
   */
  EClass getLoop4();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop4#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Id</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop4#getId()
   * @see #getLoop4()
   * @generated
   */
  EAttribute getLoop4_Id();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.LoopBug285452 <em>Loop Bug285452</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Loop Bug285452</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.LoopBug285452
   * @generated
   */
  EClass getLoopBug285452();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.LoopBug285452#isInterface <em>Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Interface</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.LoopBug285452#isInterface()
   * @see #getLoopBug285452()
   * @generated
   */
  EAttribute getLoopBug285452_Interface();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.LoopBug285452#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.LoopBug285452#getName()
   * @see #getLoopBug285452()
   * @generated
   */
  EAttribute getLoopBug285452_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.DuplicateBug284491 <em>Duplicate Bug284491</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Duplicate Bug284491</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.DuplicateBug284491
   * @generated
   */
  EClass getDuplicateBug284491();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.DuplicateBug284491#isStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.DuplicateBug284491#isStatic()
   * @see #getDuplicateBug284491()
   * @generated
   */
  EAttribute getDuplicateBug284491_Static();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.DuplicateBug284491#isFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.DuplicateBug284491#isFinal()
   * @see #getDuplicateBug284491()
   * @generated
   */
  EAttribute getDuplicateBug284491_Final();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.DuplicateBug284491#isTransient <em>Transient</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Transient</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.DuplicateBug284491#isTransient()
   * @see #getDuplicateBug284491()
   * @generated
   */
  EAttribute getDuplicateBug284491_Transient();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectBug284850 <em>Empty Object Bug284850</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Empty Object Bug284850</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectBug284850
   * @generated
   */
  EClass getEmptyObjectBug284850();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectBug284850#getItems <em>Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Items</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectBug284850#getItems()
   * @see #getEmptyObjectBug284850()
   * @generated
   */
  EReference getEmptyObjectBug284850_Items();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItems <em>Empty Object Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Empty Object Items</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItems
   * @generated
   */
  EClass getEmptyObjectItems();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItems#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>List</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItems#getList()
   * @see #getEmptyObjectItems()
   * @generated
   */
  EReference getEmptyObjectItems_List();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItem <em>Empty Object Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Empty Object Item</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItem
   * @generated
   */
  EClass getEmptyObjectItem();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItem#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItem#getName()
   * @see #getEmptyObjectItem()
   * @generated
   */
  EAttribute getEmptyObjectItem_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.MultiInheritanceBug280439 <em>Multi Inheritance Bug280439</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multi Inheritance Bug280439</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.MultiInheritanceBug280439
   * @generated
   */
  EClass getMultiInheritanceBug280439();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.MultiInheritanceBug280439#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Val</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.MultiInheritanceBug280439#getVal()
   * @see #getMultiInheritanceBug280439()
   * @generated
   */
  EReference getMultiInheritanceBug280439_Val();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti1 <em>Abstract Multi1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Multi1</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti1
   * @generated
   */
  EClass getAbstractMulti1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti1#getM1 <em>M1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>M1</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti1#getM1()
   * @see #getAbstractMulti1()
   * @generated
   */
  EAttribute getAbstractMulti1_M1();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti2 <em>Abstract Multi2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Multi2</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti2
   * @generated
   */
  EClass getAbstractMulti2();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti2#getM2 <em>M2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>M2</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti2#getM2()
   * @see #getAbstractMulti2()
   * @generated
   */
  EAttribute getAbstractMulti2_M2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ConcreteMulti <em>Concrete Multi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Concrete Multi</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ConcreteMulti
   * @generated
   */
  EClass getConcreteMulti();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectRef <em>EObject Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EObject Ref</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectRef
   * @generated
   */
  EClass getEObjectRef();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectRef#getObj <em>Obj</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Obj</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectRef#getObj()
   * @see #getEObjectRef()
   * @generated
   */
  EReference getEObjectRef_Obj();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectRef#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectRef#getRef()
   * @see #getEObjectRef()
   * @generated
   */
  EReference getEObjectRef_Ref();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectElement <em>EObject Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EObject Element</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectElement
   * @generated
   */
  EClass getEObjectElement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectElement#getName()
   * @see #getEObjectElement()
   * @generated
   */
  EAttribute getEObjectElement_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug305577_1 <em>Type Bug305577 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Bug305577 1</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug305577_1
   * @generated
   */
  EClass getTypeBug305577_1();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug305577_2 <em>Type Bug305577 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Bug305577 2</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug305577_2
   * @generated
   */
  EClass getTypeBug305577_2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug1A <em>Type Bug1 A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Bug1 A</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug1A
   * @generated
   */
  EClass getTypeBug1A();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug1A#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug1A#getName()
   * @see #getTypeBug1A()
   * @generated
   */
  EAttribute getTypeBug1A_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug1B <em>Type Bug1 B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Bug1 B</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug1B
   * @generated
   */
  EClass getTypeBug1B();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug2A <em>Type Bug2 A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Bug2 A</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug2A
   * @generated
   */
  EClass getTypeBug2A();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug2A#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug2A#getName()
   * @see #getTypeBug2A()
   * @generated
   */
  EAttribute getTypeBug2A_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug2B <em>Type Bug2 B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Bug2 B</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug2B
   * @generated
   */
  EClass getTypeBug2B();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug305171 <em>Bug305171</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bug305171</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug305171
   * @generated
   */
  EClass getBug305171();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug305171#getX <em>X</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>X</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug305171#getX()
   * @see #getBug305171()
   * @generated
   */
  EAttribute getBug305171_X();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug305171#getY <em>Y</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Y</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug305171#getY()
   * @see #getBug305171()
   * @generated
   */
  EAttribute getBug305171_Y();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug305171#getZ <em>Z</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Z</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug305171#getZ()
   * @see #getBug305171()
   * @generated
   */
  EAttribute getBug305171_Z();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug305171#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug305171#getName()
   * @see #getBug305171()
   * @generated
   */
  EAttribute getBug305171_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Enum <em>Bug310435 Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bug310435 Enum</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Enum
   * @generated
   */
  EClass getBug310435Enum();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Enum#getLits <em>Lits</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Lits</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Enum#getLits()
   * @see #getBug310435Enum()
   * @generated
   */
  EAttribute getBug310435Enum_Lits();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Val <em>Bug310435 Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bug310435 Val</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Val
   * @generated
   */
  EClass getBug310435Val();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Val#getLits <em>Lits</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Lits</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Val#getLits()
   * @see #getBug310435Val()
   * @generated
   */
  EAttribute getBug310435Val_Lits();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNameTest <em>Cross Ref Name Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cross Ref Name Test</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNameTest
   * @generated
   */
  EClass getCrossRefNameTest();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNameTest#getNamed <em>Named</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Named</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNameTest#getNamed()
   * @see #getCrossRefNameTest()
   * @generated
   */
  EReference getCrossRefNameTest_Named();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNameTest#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Ref</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNameTest#getRef()
   * @see #getCrossRefNameTest()
   * @generated
   */
  EReference getCrossRefNameTest_Ref();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNamed <em>Cross Ref Named</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cross Ref Named</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNamed
   * @generated
   */
  EClass getCrossRefNamed();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNamed#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNamed#getName()
   * @see #getCrossRefNamed()
   * @generated
   */
  EAttribute getCrossRefNamed_Name();

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
   * Returns the meta object for enum '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EnumBug310435Enum <em>Enum Bug310435 Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Enum Bug310435 Enum</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EnumBug310435Enum
   * @generated
   */
  EEnum getEnumBug310435Enum();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Loop1Impl <em>Loop1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Loop1Impl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getLoop1()
     * @generated
     */
    EClass LOOP1 = eINSTANCE.getLoop1();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOP1__ID = eINSTANCE.getLoop1_Id();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Loop2Impl <em>Loop2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Loop2Impl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getLoop2()
     * @generated
     */
    EClass LOOP2 = eINSTANCE.getLoop2();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOP2__ID = eINSTANCE.getLoop2_Id();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Loop3Impl <em>Loop3</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Loop3Impl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getLoop3()
     * @generated
     */
    EClass LOOP3 = eINSTANCE.getLoop3();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOP3__ID = eINSTANCE.getLoop3_Id();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Loop4Impl <em>Loop4</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Loop4Impl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getLoop4()
     * @generated
     */
    EClass LOOP4 = eINSTANCE.getLoop4();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOP4__ID = eINSTANCE.getLoop4_Id();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.LoopBug285452Impl <em>Loop Bug285452</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.LoopBug285452Impl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getLoopBug285452()
     * @generated
     */
    EClass LOOP_BUG285452 = eINSTANCE.getLoopBug285452();

    /**
     * The meta object literal for the '<em><b>Interface</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOP_BUG285452__INTERFACE = eINSTANCE.getLoopBug285452_Interface();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOP_BUG285452__NAME = eINSTANCE.getLoopBug285452_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.DuplicateBug284491Impl <em>Duplicate Bug284491</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.DuplicateBug284491Impl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getDuplicateBug284491()
     * @generated
     */
    EClass DUPLICATE_BUG284491 = eINSTANCE.getDuplicateBug284491();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DUPLICATE_BUG284491__STATIC = eINSTANCE.getDuplicateBug284491_Static();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DUPLICATE_BUG284491__FINAL = eINSTANCE.getDuplicateBug284491_Final();

    /**
     * The meta object literal for the '<em><b>Transient</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DUPLICATE_BUG284491__TRANSIENT = eINSTANCE.getDuplicateBug284491_Transient();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EmptyObjectBug284850Impl <em>Empty Object Bug284850</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EmptyObjectBug284850Impl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getEmptyObjectBug284850()
     * @generated
     */
    EClass EMPTY_OBJECT_BUG284850 = eINSTANCE.getEmptyObjectBug284850();

    /**
     * The meta object literal for the '<em><b>Items</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EMPTY_OBJECT_BUG284850__ITEMS = eINSTANCE.getEmptyObjectBug284850_Items();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EmptyObjectItemsImpl <em>Empty Object Items</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EmptyObjectItemsImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getEmptyObjectItems()
     * @generated
     */
    EClass EMPTY_OBJECT_ITEMS = eINSTANCE.getEmptyObjectItems();

    /**
     * The meta object literal for the '<em><b>List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EMPTY_OBJECT_ITEMS__LIST = eINSTANCE.getEmptyObjectItems_List();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EmptyObjectItemImpl <em>Empty Object Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EmptyObjectItemImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getEmptyObjectItem()
     * @generated
     */
    EClass EMPTY_OBJECT_ITEM = eINSTANCE.getEmptyObjectItem();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EMPTY_OBJECT_ITEM__NAME = eINSTANCE.getEmptyObjectItem_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.MultiInheritanceBug280439Impl <em>Multi Inheritance Bug280439</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.MultiInheritanceBug280439Impl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getMultiInheritanceBug280439()
     * @generated
     */
    EClass MULTI_INHERITANCE_BUG280439 = eINSTANCE.getMultiInheritanceBug280439();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTI_INHERITANCE_BUG280439__VAL = eINSTANCE.getMultiInheritanceBug280439_Val();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.AbstractMulti1Impl <em>Abstract Multi1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.AbstractMulti1Impl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getAbstractMulti1()
     * @generated
     */
    EClass ABSTRACT_MULTI1 = eINSTANCE.getAbstractMulti1();

    /**
     * The meta object literal for the '<em><b>M1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_MULTI1__M1 = eINSTANCE.getAbstractMulti1_M1();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.AbstractMulti2Impl <em>Abstract Multi2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.AbstractMulti2Impl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getAbstractMulti2()
     * @generated
     */
    EClass ABSTRACT_MULTI2 = eINSTANCE.getAbstractMulti2();

    /**
     * The meta object literal for the '<em><b>M2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_MULTI2__M2 = eINSTANCE.getAbstractMulti2_M2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.ConcreteMultiImpl <em>Concrete Multi</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.ConcreteMultiImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getConcreteMulti()
     * @generated
     */
    EClass CONCRETE_MULTI = eINSTANCE.getConcreteMulti();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EObjectRefImpl <em>EObject Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EObjectRefImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getEObjectRef()
     * @generated
     */
    EClass EOBJECT_REF = eINSTANCE.getEObjectRef();

    /**
     * The meta object literal for the '<em><b>Obj</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EOBJECT_REF__OBJ = eINSTANCE.getEObjectRef_Obj();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EOBJECT_REF__REF = eINSTANCE.getEObjectRef_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EObjectElementImpl <em>EObject Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.EObjectElementImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getEObjectElement()
     * @generated
     */
    EClass EOBJECT_ELEMENT = eINSTANCE.getEObjectElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EOBJECT_ELEMENT__NAME = eINSTANCE.getEObjectElement_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug305577_1Impl <em>Type Bug305577 1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug305577_1Impl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getTypeBug305577_1()
     * @generated
     */
    EClass TYPE_BUG305577_1 = eINSTANCE.getTypeBug305577_1();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug305577_2Impl <em>Type Bug305577 2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug305577_2Impl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getTypeBug305577_2()
     * @generated
     */
    EClass TYPE_BUG305577_2 = eINSTANCE.getTypeBug305577_2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug1AImpl <em>Type Bug1 A</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug1AImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getTypeBug1A()
     * @generated
     */
    EClass TYPE_BUG1_A = eINSTANCE.getTypeBug1A();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_BUG1_A__NAME = eINSTANCE.getTypeBug1A_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug1BImpl <em>Type Bug1 B</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug1BImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getTypeBug1B()
     * @generated
     */
    EClass TYPE_BUG1_B = eINSTANCE.getTypeBug1B();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug2AImpl <em>Type Bug2 A</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug2AImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getTypeBug2A()
     * @generated
     */
    EClass TYPE_BUG2_A = eINSTANCE.getTypeBug2A();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_BUG2_A__NAME = eINSTANCE.getTypeBug2A_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug2BImpl <em>Type Bug2 B</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TypeBug2BImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getTypeBug2B()
     * @generated
     */
    EClass TYPE_BUG2_B = eINSTANCE.getTypeBug2B();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug305171Impl <em>Bug305171</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug305171Impl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getBug305171()
     * @generated
     */
    EClass BUG305171 = eINSTANCE.getBug305171();

    /**
     * The meta object literal for the '<em><b>X</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BUG305171__X = eINSTANCE.getBug305171_X();

    /**
     * The meta object literal for the '<em><b>Y</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BUG305171__Y = eINSTANCE.getBug305171_Y();

    /**
     * The meta object literal for the '<em><b>Z</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BUG305171__Z = eINSTANCE.getBug305171_Z();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BUG305171__NAME = eINSTANCE.getBug305171_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug310435EnumImpl <em>Bug310435 Enum</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug310435EnumImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getBug310435Enum()
     * @generated
     */
    EClass BUG310435_ENUM = eINSTANCE.getBug310435Enum();

    /**
     * The meta object literal for the '<em><b>Lits</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BUG310435_ENUM__LITS = eINSTANCE.getBug310435Enum_Lits();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug310435ValImpl <em>Bug310435 Val</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug310435ValImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getBug310435Val()
     * @generated
     */
    EClass BUG310435_VAL = eINSTANCE.getBug310435Val();

    /**
     * The meta object literal for the '<em><b>Lits</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BUG310435_VAL__LITS = eINSTANCE.getBug310435Val_Lits();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.CrossRefNameTestImpl <em>Cross Ref Name Test</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.CrossRefNameTestImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getCrossRefNameTest()
     * @generated
     */
    EClass CROSS_REF_NAME_TEST = eINSTANCE.getCrossRefNameTest();

    /**
     * The meta object literal for the '<em><b>Named</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CROSS_REF_NAME_TEST__NAMED = eINSTANCE.getCrossRefNameTest_Named();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CROSS_REF_NAME_TEST__REF = eINSTANCE.getCrossRefNameTest_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.CrossRefNamedImpl <em>Cross Ref Named</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.CrossRefNamedImpl
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getCrossRefNamed()
     * @generated
     */
    EClass CROSS_REF_NAMED = eINSTANCE.getCrossRefNamed();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CROSS_REF_NAMED__NAME = eINSTANCE.getCrossRefNamed_Name();

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

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EnumBug310435Enum <em>Enum Bug310435 Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EnumBug310435Enum
     * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.SimplerewritetestPackageImpl#getEnumBug310435Enum()
     * @generated
     */
    EEnum ENUM_BUG310435_ENUM = eINSTANCE.getEnumBug310435Enum();

  }

} //SimplerewritetestPackage
