/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.formatter.formattertestlanguage;

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
 * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguageFactory
 * @model kind="package"
 * @generated
 */
public interface FormattertestlanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "formattertestlanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://simple/formattertestlanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "formattertestlanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FormattertestlanguagePackage eINSTANCE = org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.RootImpl <em>Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.RootImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getRoot()
   * @generated
   */
  int ROOT = 0;

  /**
   * The feature id for the '<em><b>Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT__ITEMS = 0;

  /**
   * The number of structural features of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.LineImpl <em>Line</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.LineImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getLine()
   * @generated
   */
  int LINE = 1;

  /**
   * The number of structural features of the '<em>Line</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.DeclImpl <em>Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.DeclImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getDecl()
   * @generated
   */
  int DECL = 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL__TYPE = LINE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL__NAME = LINE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_FEATURE_COUNT = LINE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.AssignImpl <em>Assign</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.AssignImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getAssign()
   * @generated
   */
  int ASSIGN = 3;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN__VAR = LINE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN__OP = LINE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN__VAL = LINE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Assign</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN_FEATURE_COUNT = LINE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.MethImpl <em>Meth</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.MethImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getMeth()
   * @generated
   */
  int METH = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METH__NAME = LINE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METH__PARAM = LINE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Meth</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METH_FEATURE_COUNT = LINE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.ParamImpl <em>Param</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.ParamImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getParam()
   * @generated
   */
  int PARAM = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM__TYPE = 1;

  /**
   * The number of structural features of the '<em>Param</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestLinewrapImpl <em>Test Linewrap</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestLinewrapImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getTestLinewrap()
   * @generated
   */
  int TEST_LINEWRAP = 6;

  /**
   * The feature id for the '<em><b>Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_LINEWRAP__ITEMS = ROOT__ITEMS;

  /**
   * The number of structural features of the '<em>Test Linewrap</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_LINEWRAP_FEATURE_COUNT = ROOT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestIndentationImpl <em>Test Indentation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestIndentationImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getTestIndentation()
   * @generated
   */
  int TEST_INDENTATION = 7;

  /**
   * The feature id for the '<em><b>Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_INDENTATION__ITEMS = ROOT__ITEMS;

  /**
   * The feature id for the '<em><b>Sub</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_INDENTATION__SUB = ROOT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Semi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_INDENTATION__SEMI = ROOT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Test Indentation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_INDENTATION_FEATURE_COUNT = ROOT_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Root <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Root
   * @generated
   */
  EClass getRoot();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Root#getItems <em>Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Items</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Root#getItems()
   * @see #getRoot()
   * @generated
   */
  EReference getRoot_Items();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Line <em>Line</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Line</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Line
   * @generated
   */
  EClass getLine();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Decl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decl</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Decl
   * @generated
   */
  EClass getDecl();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Decl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Type</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Decl#getType()
   * @see #getDecl()
   * @generated
   */
  EAttribute getDecl_Type();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Decl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Decl#getName()
   * @see #getDecl()
   * @generated
   */
  EAttribute getDecl_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Assign <em>Assign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assign</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Assign
   * @generated
   */
  EClass getAssign();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Assign#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Assign#getVar()
   * @see #getAssign()
   * @generated
   */
  EAttribute getAssign_Var();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Assign#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Assign#getOp()
   * @see #getAssign()
   * @generated
   */
  EAttribute getAssign_Op();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Assign#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Val</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Assign#getVal()
   * @see #getAssign()
   * @generated
   */
  EAttribute getAssign_Val();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Meth <em>Meth</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Meth</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Meth
   * @generated
   */
  EClass getMeth();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Meth#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Meth#getName()
   * @see #getMeth()
   * @generated
   */
  EAttribute getMeth_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Meth#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Param</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Meth#getParam()
   * @see #getMeth()
   * @generated
   */
  EReference getMeth_Param();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Param <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Param</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Param
   * @generated
   */
  EClass getParam();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Param#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Param#getName()
   * @see #getParam()
   * @generated
   */
  EAttribute getParam_Name();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Param#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Type</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Param#getType()
   * @see #getParam()
   * @generated
   */
  EAttribute getParam_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrap <em>Test Linewrap</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test Linewrap</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrap
   * @generated
   */
  EClass getTestLinewrap();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestIndentation <em>Test Indentation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test Indentation</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestIndentation
   * @generated
   */
  EClass getTestIndentation();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestIndentation#getSub <em>Sub</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sub</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestIndentation#getSub()
   * @see #getTestIndentation()
   * @generated
   */
  EReference getTestIndentation_Sub();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestIndentation#isSemi <em>Semi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Semi</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestIndentation#isSemi()
   * @see #getTestIndentation()
   * @generated
   */
  EAttribute getTestIndentation_Semi();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FormattertestlanguageFactory getFormattertestlanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.RootImpl <em>Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.RootImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getRoot()
     * @generated
     */
    EClass ROOT = eINSTANCE.getRoot();

    /**
     * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOT__ITEMS = eINSTANCE.getRoot_Items();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.LineImpl <em>Line</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.LineImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getLine()
     * @generated
     */
    EClass LINE = eINSTANCE.getLine();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.DeclImpl <em>Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.DeclImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getDecl()
     * @generated
     */
    EClass DECL = eINSTANCE.getDecl();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECL__TYPE = eINSTANCE.getDecl_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECL__NAME = eINSTANCE.getDecl_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.AssignImpl <em>Assign</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.AssignImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getAssign()
     * @generated
     */
    EClass ASSIGN = eINSTANCE.getAssign();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGN__VAR = eINSTANCE.getAssign_Var();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGN__OP = eINSTANCE.getAssign_Op();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGN__VAL = eINSTANCE.getAssign_Val();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.MethImpl <em>Meth</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.MethImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getMeth()
     * @generated
     */
    EClass METH = eINSTANCE.getMeth();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METH__NAME = eINSTANCE.getMeth_Name();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METH__PARAM = eINSTANCE.getMeth_Param();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.ParamImpl <em>Param</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.ParamImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getParam()
     * @generated
     */
    EClass PARAM = eINSTANCE.getParam();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAM__NAME = eINSTANCE.getParam_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAM__TYPE = eINSTANCE.getParam_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestLinewrapImpl <em>Test Linewrap</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestLinewrapImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getTestLinewrap()
     * @generated
     */
    EClass TEST_LINEWRAP = eINSTANCE.getTestLinewrap();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestIndentationImpl <em>Test Indentation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestIndentationImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getTestIndentation()
     * @generated
     */
    EClass TEST_INDENTATION = eINSTANCE.getTestIndentation();

    /**
     * The meta object literal for the '<em><b>Sub</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_INDENTATION__SUB = eINSTANCE.getTestIndentation_Sub();

    /**
     * The meta object literal for the '<em><b>Semi</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEST_INDENTATION__SEMI = eINSTANCE.getTestIndentation_Semi();

  }

} //FormattertestlanguagePackage
