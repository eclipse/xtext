/**
 */
package org.eclipse.xtext.parsetree.reconstr.complexrewritetest;

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
 * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestFactory
 * @model kind="package"
 * @generated
 */
public interface ComplexrewritetestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "complexrewritetest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/complexrewritetest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "complexrewritetest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ComplexrewritetestPackage eINSTANCE = org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.RootImpl <em>Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.RootImpl
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getRoot()
   * @generated
   */
  int ROOT = 0;

  /**
   * The number of structural features of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ExpressionImpl
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 1;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EM = ROOT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = ROOT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.AtomImpl <em>Atom</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.AtomImpl
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getAtom()
   * @generated
   */
  int ATOM = 2;

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
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyBImpl <em>Tricky B</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyBImpl
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getTrickyB()
   * @generated
   */
  int TRICKY_B = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_B__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_B__TYPE = 1;

  /**
   * The number of structural features of the '<em>Tricky B</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_B_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyCImpl <em>Tricky C</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyCImpl
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getTrickyC()
   * @generated
   */
  int TRICKY_C = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_C__NAME = 0;

  /**
   * The number of structural features of the '<em>Tricky C</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_C_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyDImpl <em>Tricky D</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyDImpl
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getTrickyD()
   * @generated
   */
  int TRICKY_D = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_D__NAME = 0;

  /**
   * The feature id for the '<em><b>Foo</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_D__FOO = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_D__TYPE = 2;

  /**
   * The number of structural features of the '<em>Tricky D</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_D_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyEImpl <em>Tricky E</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyEImpl
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getTrickyE()
   * @generated
   */
  int TRICKY_E = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_E__NAME = 0;

  /**
   * The feature id for the '<em><b>Foo</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_E__FOO = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_E__TYPE = 2;

  /**
   * The number of structural features of the '<em>Tricky E</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_E_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyFImpl <em>Tricky F</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyFImpl
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getTrickyF()
   * @generated
   */
  int TRICKY_F = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_F__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_F__TYPE = 1;

  /**
   * The number of structural features of the '<em>Tricky F</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_F_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyGImpl <em>Tricky G</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyGImpl
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getTrickyG()
   * @generated
   */
  int TRICKY_G = 8;

  /**
   * The feature id for the '<em><b>Tree</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_G__TREE = ROOT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tricky G</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_G_FEATURE_COUNT = ROOT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyG2Impl <em>Tricky G2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyG2Impl
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getTrickyG2()
   * @generated
   */
  int TRICKY_G2 = 10;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_G2__VAL = 0;

  /**
   * The number of structural features of the '<em>Tricky G2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_G2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyG1Impl <em>Tricky G1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyG1Impl
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getTrickyG1()
   * @generated
   */
  int TRICKY_G1 = 9;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_G1__VAL = TRICKY_G2__VAL;

  /**
   * The feature id for the '<em><b>Vals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_G1__VALS = TRICKY_G2_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tricky G1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRICKY_G1_FEATURE_COUNT = TRICKY_G2_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.AddImpl <em>Add</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.AddImpl
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getAdd()
   * @generated
   */
  int ADD = 11;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Add Operands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD__ADD_OPERANDS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Add</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.MinusImpl <em>Minus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.MinusImpl
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getMinus()
   * @generated
   */
  int MINUS = 12;

  /**
   * The feature id for the '<em><b>Em</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINUS__EM = EXPRESSION__EM;

  /**
   * The feature id for the '<em><b>Minus Operands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINUS__MINUS_OPERANDS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Minus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINUS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.C1Impl <em>C1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.C1Impl
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getC1()
   * @generated
   */
  int C1 = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int C1__NAME = TRICKY_C__NAME;

  /**
   * The feature id for the '<em><b>X</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int C1__X = TRICKY_C_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>C1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int C1_FEATURE_COUNT = TRICKY_C_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.C2Impl <em>C2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.C2Impl
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getC2()
   * @generated
   */
  int C2 = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int C2__NAME = TRICKY_C__NAME;

  /**
   * The feature id for the '<em><b>Y</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int C2__Y = TRICKY_C_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>C2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int C2_FEATURE_COUNT = TRICKY_C_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.C3Impl <em>C3</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.C3Impl
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getC3()
   * @generated
   */
  int C3 = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int C3__NAME = TRICKY_C__NAME;

  /**
   * The feature id for the '<em><b>Z</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int C3__Z = TRICKY_C_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>C3</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int C3_FEATURE_COUNT = TRICKY_C_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Root <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Root
   * @generated
   */
  EClass getRoot();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Expression#getEm <em>Em</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Em</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Expression#getEm()
   * @see #getExpression()
   * @generated
   */
  EAttribute getExpression_Em();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Atom <em>Atom</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atom</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Atom
   * @generated
   */
  EClass getAtom();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Atom#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Atom#getName()
   * @see #getAtom()
   * @generated
   */
  EAttribute getAtom_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyB <em>Tricky B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tricky B</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyB
   * @generated
   */
  EClass getTrickyB();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyB#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyB#getName()
   * @see #getTrickyB()
   * @generated
   */
  EAttribute getTrickyB_Name();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyB#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Type</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyB#getType()
   * @see #getTrickyB()
   * @generated
   */
  EAttribute getTrickyB_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyC <em>Tricky C</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tricky C</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyC
   * @generated
   */
  EClass getTrickyC();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyC#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyC#getName()
   * @see #getTrickyC()
   * @generated
   */
  EAttribute getTrickyC_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyD <em>Tricky D</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tricky D</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyD
   * @generated
   */
  EClass getTrickyD();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyD#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyD#getName()
   * @see #getTrickyD()
   * @generated
   */
  EAttribute getTrickyD_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyD#getFoo <em>Foo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Foo</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyD#getFoo()
   * @see #getTrickyD()
   * @generated
   */
  EAttribute getTrickyD_Foo();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyD#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Type</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyD#getType()
   * @see #getTrickyD()
   * @generated
   */
  EAttribute getTrickyD_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyE <em>Tricky E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tricky E</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyE
   * @generated
   */
  EClass getTrickyE();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyE#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyE#getName()
   * @see #getTrickyE()
   * @generated
   */
  EAttribute getTrickyE_Name();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyE#getFoo <em>Foo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Foo</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyE#getFoo()
   * @see #getTrickyE()
   * @generated
   */
  EAttribute getTrickyE_Foo();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyE#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Type</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyE#getType()
   * @see #getTrickyE()
   * @generated
   */
  EAttribute getTrickyE_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyF <em>Tricky F</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tricky F</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyF
   * @generated
   */
  EClass getTrickyF();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyF#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyF#getName()
   * @see #getTrickyF()
   * @generated
   */
  EAttribute getTrickyF_Name();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyF#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Type</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyF#getType()
   * @see #getTrickyF()
   * @generated
   */
  EAttribute getTrickyF_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG <em>Tricky G</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tricky G</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG
   * @generated
   */
  EClass getTrickyG();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG#getTree <em>Tree</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tree</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG#getTree()
   * @see #getTrickyG()
   * @generated
   */
  EReference getTrickyG_Tree();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG1 <em>Tricky G1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tricky G1</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG1
   * @generated
   */
  EClass getTrickyG1();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG1#getVals <em>Vals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Vals</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG1#getVals()
   * @see #getTrickyG1()
   * @generated
   */
  EReference getTrickyG1_Vals();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG2 <em>Tricky G2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tricky G2</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG2
   * @generated
   */
  EClass getTrickyG2();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG2#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG2#getVal()
   * @see #getTrickyG2()
   * @generated
   */
  EAttribute getTrickyG2_Val();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Add <em>Add</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Add</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Add
   * @generated
   */
  EClass getAdd();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Add#getAddOperands <em>Add Operands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Add Operands</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Add#getAddOperands()
   * @see #getAdd()
   * @generated
   */
  EReference getAdd_AddOperands();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Minus <em>Minus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Minus</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Minus
   * @generated
   */
  EClass getMinus();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Minus#getMinusOperands <em>Minus Operands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Minus Operands</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Minus#getMinusOperands()
   * @see #getMinus()
   * @generated
   */
  EReference getMinus_MinusOperands();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C1 <em>C1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>C1</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C1
   * @generated
   */
  EClass getC1();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C1#getX <em>X</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>X</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C1#getX()
   * @see #getC1()
   * @generated
   */
  EReference getC1_X();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C2 <em>C2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>C2</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C2
   * @generated
   */
  EClass getC2();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C2#getY <em>Y</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Y</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C2#getY()
   * @see #getC2()
   * @generated
   */
  EReference getC2_Y();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C3 <em>C3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>C3</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C3
   * @generated
   */
  EClass getC3();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C3#getZ <em>Z</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Z</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C3#getZ()
   * @see #getC3()
   * @generated
   */
  EReference getC3_Z();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ComplexrewritetestFactory getComplexrewritetestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.RootImpl <em>Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.RootImpl
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getRoot()
     * @generated
     */
    EClass ROOT = eINSTANCE.getRoot();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ExpressionImpl
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getExpression()
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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.AtomImpl <em>Atom</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.AtomImpl
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getAtom()
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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyBImpl <em>Tricky B</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyBImpl
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getTrickyB()
     * @generated
     */
    EClass TRICKY_B = eINSTANCE.getTrickyB();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRICKY_B__NAME = eINSTANCE.getTrickyB_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRICKY_B__TYPE = eINSTANCE.getTrickyB_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyCImpl <em>Tricky C</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyCImpl
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getTrickyC()
     * @generated
     */
    EClass TRICKY_C = eINSTANCE.getTrickyC();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRICKY_C__NAME = eINSTANCE.getTrickyC_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyDImpl <em>Tricky D</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyDImpl
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getTrickyD()
     * @generated
     */
    EClass TRICKY_D = eINSTANCE.getTrickyD();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRICKY_D__NAME = eINSTANCE.getTrickyD_Name();

    /**
     * The meta object literal for the '<em><b>Foo</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRICKY_D__FOO = eINSTANCE.getTrickyD_Foo();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRICKY_D__TYPE = eINSTANCE.getTrickyD_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyEImpl <em>Tricky E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyEImpl
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getTrickyE()
     * @generated
     */
    EClass TRICKY_E = eINSTANCE.getTrickyE();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRICKY_E__NAME = eINSTANCE.getTrickyE_Name();

    /**
     * The meta object literal for the '<em><b>Foo</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRICKY_E__FOO = eINSTANCE.getTrickyE_Foo();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRICKY_E__TYPE = eINSTANCE.getTrickyE_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyFImpl <em>Tricky F</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyFImpl
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getTrickyF()
     * @generated
     */
    EClass TRICKY_F = eINSTANCE.getTrickyF();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRICKY_F__NAME = eINSTANCE.getTrickyF_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRICKY_F__TYPE = eINSTANCE.getTrickyF_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyGImpl <em>Tricky G</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyGImpl
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getTrickyG()
     * @generated
     */
    EClass TRICKY_G = eINSTANCE.getTrickyG();

    /**
     * The meta object literal for the '<em><b>Tree</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRICKY_G__TREE = eINSTANCE.getTrickyG_Tree();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyG1Impl <em>Tricky G1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyG1Impl
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getTrickyG1()
     * @generated
     */
    EClass TRICKY_G1 = eINSTANCE.getTrickyG1();

    /**
     * The meta object literal for the '<em><b>Vals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRICKY_G1__VALS = eINSTANCE.getTrickyG1_Vals();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyG2Impl <em>Tricky G2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyG2Impl
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getTrickyG2()
     * @generated
     */
    EClass TRICKY_G2 = eINSTANCE.getTrickyG2();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRICKY_G2__VAL = eINSTANCE.getTrickyG2_Val();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.AddImpl <em>Add</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.AddImpl
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getAdd()
     * @generated
     */
    EClass ADD = eINSTANCE.getAdd();

    /**
     * The meta object literal for the '<em><b>Add Operands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADD__ADD_OPERANDS = eINSTANCE.getAdd_AddOperands();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.MinusImpl <em>Minus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.MinusImpl
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getMinus()
     * @generated
     */
    EClass MINUS = eINSTANCE.getMinus();

    /**
     * The meta object literal for the '<em><b>Minus Operands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MINUS__MINUS_OPERANDS = eINSTANCE.getMinus_MinusOperands();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.C1Impl <em>C1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.C1Impl
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getC1()
     * @generated
     */
    EClass C1 = eINSTANCE.getC1();

    /**
     * The meta object literal for the '<em><b>X</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference C1__X = eINSTANCE.getC1_X();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.C2Impl <em>C2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.C2Impl
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getC2()
     * @generated
     */
    EClass C2 = eINSTANCE.getC2();

    /**
     * The meta object literal for the '<em><b>Y</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference C2__Y = eINSTANCE.getC2_Y();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.C3Impl <em>C3</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.C3Impl
     * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.ComplexrewritetestPackageImpl#getC3()
     * @generated
     */
    EClass C3 = eINSTANCE.getC3();

    /**
     * The meta object literal for the '<em><b>Z</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference C3__Z = eINSTANCE.getC3_Z();

  }

} //ComplexrewritetestPackage
