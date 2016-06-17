/**
 */
package org.eclipse.xtext.parsetree.formatter.formattertestlanguage;

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
   * The number of structural features of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_FEATURE_COUNT = 0;

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
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SpaceImpl <em>Space</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SpaceImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getSpace()
   * @generated
   */
  int SPACE = 6;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPACE__VAL = LINE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Space</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPACE_FEATURE_COUNT = LINE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestLinewrapImpl <em>Test Linewrap</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestLinewrapImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getTestLinewrap()
   * @generated
   */
  int TEST_LINEWRAP = 7;

  /**
   * The feature id for the '<em><b>Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_LINEWRAP__ITEMS = ROOT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Test Linewrap</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_LINEWRAP_FEATURE_COUNT = ROOT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestLinewrapMinMaxImpl <em>Test Linewrap Min Max</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestLinewrapMinMaxImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getTestLinewrapMinMax()
   * @generated
   */
  int TEST_LINEWRAP_MIN_MAX = 8;

  /**
   * The feature id for the '<em><b>Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_LINEWRAP_MIN_MAX__ITEMS = ROOT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Test Linewrap Min Max</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_LINEWRAP_MIN_MAX_FEATURE_COUNT = ROOT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestIndentationImpl <em>Test Indentation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestIndentationImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getTestIndentation()
   * @generated
   */
  int TEST_INDENTATION = 9;

  /**
   * The feature id for the '<em><b>Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_INDENTATION__ITEMS = ROOT_FEATURE_COUNT + 0;

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
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FqnObjImpl <em>Fqn Obj</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FqnObjImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getFqnObj()
   * @generated
   */
  int FQN_OBJ = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FQN_OBJ__NAME = LINE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Fqn Obj</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FQN_OBJ_FEATURE_COUNT = LINE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FqnRefImpl <em>Fqn Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FqnRefImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getFqnRef()
   * @generated
   */
  int FQN_REF = 11;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FQN_REF__REF = LINE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Fqn Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FQN_REF_FEATURE_COUNT = LINE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.EnumerationImpl <em>Enumeration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.EnumerationImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getEnumeration()
   * @generated
   */
  int ENUMERATION = 12;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION__VAL = LINE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Enumeration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_FEATURE_COUNT = LINE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SuppressedHiddenImpl <em>Suppressed Hidden</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SuppressedHiddenImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getSuppressedHidden()
   * @generated
   */
  int SUPPRESSED_HIDDEN = 13;

  /**
   * The feature id for the '<em><b>Vals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPRESSED_HIDDEN__VALS = LINE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Suppressed Hidden</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPRESSED_HIDDEN_FEATURE_COUNT = LINE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SuppressedHiddenSubImpl <em>Suppressed Hidden Sub</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SuppressedHiddenSubImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getSuppressedHiddenSub()
   * @generated
   */
  int SUPPRESSED_HIDDEN_SUB = 14;

  /**
   * The feature id for the '<em><b>Idval</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPRESSED_HIDDEN_SUB__IDVAL = 0;

  /**
   * The number of structural features of the '<em>Suppressed Hidden Sub</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPRESSED_HIDDEN_SUB_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SuppressedHiddenSubSubImpl <em>Suppressed Hidden Sub Sub</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SuppressedHiddenSubSubImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getSuppressedHiddenSubSub()
   * @generated
   */
  int SUPPRESSED_HIDDEN_SUB_SUB = 15;

  /**
   * The feature id for the '<em><b>Idval</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPRESSED_HIDDEN_SUB_SUB__IDVAL = SUPPRESSED_HIDDEN_SUB__IDVAL;

  /**
   * The number of structural features of the '<em>Suppressed Hidden Sub Sub</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPRESSED_HIDDEN_SUB_SUB_FEATURE_COUNT = SUPPRESSED_HIDDEN_SUB_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SuppressedHiddenSubIDImpl <em>Suppressed Hidden Sub ID</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SuppressedHiddenSubIDImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getSuppressedHiddenSubID()
   * @generated
   */
  int SUPPRESSED_HIDDEN_SUB_ID = 16;

  /**
   * The feature id for the '<em><b>Idval</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPRESSED_HIDDEN_SUB_ID__IDVAL = SUPPRESSED_HIDDEN_SUB__IDVAL;

  /**
   * The number of structural features of the '<em>Suppressed Hidden Sub ID</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPRESSED_HIDDEN_SUB_ID_FEATURE_COUNT = SUPPRESSED_HIDDEN_SUB_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.DatatypesImpl <em>Datatypes</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.DatatypesImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getDatatypes()
   * @generated
   */
  int DATATYPES = 17;

  /**
   * The feature id for the '<em><b>Val1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATATYPES__VAL1 = LINE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Val2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATATYPES__VAL2 = LINE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Val3</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATATYPES__VAL3 = LINE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Datatypes</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATATYPES_FEATURE_COUNT = LINE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.WrappingDataTypeTestImpl <em>Wrapping Data Type Test</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.WrappingDataTypeTestImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getWrappingDataTypeTest()
   * @generated
   */
  int WRAPPING_DATA_TYPE_TEST = 18;

  /**
   * The feature id for the '<em><b>Datatype</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRAPPING_DATA_TYPE_TEST__DATATYPE = ROOT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Wrapping Data Type Test</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRAPPING_DATA_TYPE_TEST_FEATURE_COUNT = ROOT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Enum1 <em>Enum1</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Enum1
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getEnum1()
   * @generated
   */
  int ENUM1 = 19;


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
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Space <em>Space</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Space</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Space
   * @generated
   */
  EClass getSpace();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Space#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Space#getVal()
   * @see #getSpace()
   * @generated
   */
  EAttribute getSpace_Val();

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
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrap#getItems <em>Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Items</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrap#getItems()
   * @see #getTestLinewrap()
   * @generated
   */
  EReference getTestLinewrap_Items();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrapMinMax <em>Test Linewrap Min Max</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test Linewrap Min Max</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrapMinMax
   * @generated
   */
  EClass getTestLinewrapMinMax();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrapMinMax#getItems <em>Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Items</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrapMinMax#getItems()
   * @see #getTestLinewrapMinMax()
   * @generated
   */
  EReference getTestLinewrapMinMax_Items();

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
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestIndentation#getItems <em>Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Items</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestIndentation#getItems()
   * @see #getTestIndentation()
   * @generated
   */
  EReference getTestIndentation_Items();

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
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FqnObj <em>Fqn Obj</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fqn Obj</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FqnObj
   * @generated
   */
  EClass getFqnObj();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FqnObj#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FqnObj#getName()
   * @see #getFqnObj()
   * @generated
   */
  EAttribute getFqnObj_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FqnRef <em>Fqn Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fqn Ref</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FqnRef
   * @generated
   */
  EClass getFqnRef();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FqnRef#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FqnRef#getRef()
   * @see #getFqnRef()
   * @generated
   */
  EReference getFqnRef_Ref();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Enumeration <em>Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enumeration</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Enumeration
   * @generated
   */
  EClass getEnumeration();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Enumeration#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Val</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Enumeration#getVal()
   * @see #getEnumeration()
   * @generated
   */
  EAttribute getEnumeration_Val();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHidden <em>Suppressed Hidden</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suppressed Hidden</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHidden
   * @generated
   */
  EClass getSuppressedHidden();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHidden#getVals <em>Vals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Vals</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHidden#getVals()
   * @see #getSuppressedHidden()
   * @generated
   */
  EReference getSuppressedHidden_Vals();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSub <em>Suppressed Hidden Sub</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suppressed Hidden Sub</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSub
   * @generated
   */
  EClass getSuppressedHiddenSub();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSub#getIdval <em>Idval</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Idval</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSub#getIdval()
   * @see #getSuppressedHiddenSub()
   * @generated
   */
  EAttribute getSuppressedHiddenSub_Idval();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSubSub <em>Suppressed Hidden Sub Sub</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suppressed Hidden Sub Sub</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSubSub
   * @generated
   */
  EClass getSuppressedHiddenSubSub();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSubID <em>Suppressed Hidden Sub ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suppressed Hidden Sub ID</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSubID
   * @generated
   */
  EClass getSuppressedHiddenSubID();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Datatypes <em>Datatypes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Datatypes</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Datatypes
   * @generated
   */
  EClass getDatatypes();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Datatypes#getVal1 <em>Val1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val1</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Datatypes#getVal1()
   * @see #getDatatypes()
   * @generated
   */
  EAttribute getDatatypes_Val1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Datatypes#getVal2 <em>Val2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val2</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Datatypes#getVal2()
   * @see #getDatatypes()
   * @generated
   */
  EAttribute getDatatypes_Val2();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Datatypes#getVal3 <em>Val3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val3</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Datatypes#getVal3()
   * @see #getDatatypes()
   * @generated
   */
  EAttribute getDatatypes_Val3();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.WrappingDataTypeTest <em>Wrapping Data Type Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Wrapping Data Type Test</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.WrappingDataTypeTest
   * @generated
   */
  EClass getWrappingDataTypeTest();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.WrappingDataTypeTest#getDatatype <em>Datatype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Datatype</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.WrappingDataTypeTest#getDatatype()
   * @see #getWrappingDataTypeTest()
   * @generated
   */
  EAttribute getWrappingDataTypeTest_Datatype();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Enum1 <em>Enum1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Enum1</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Enum1
   * @generated
   */
  EEnum getEnum1();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SpaceImpl <em>Space</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SpaceImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getSpace()
     * @generated
     */
    EClass SPACE = eINSTANCE.getSpace();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SPACE__VAL = eINSTANCE.getSpace_Val();

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
     * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_LINEWRAP__ITEMS = eINSTANCE.getTestLinewrap_Items();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestLinewrapMinMaxImpl <em>Test Linewrap Min Max</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestLinewrapMinMaxImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getTestLinewrapMinMax()
     * @generated
     */
    EClass TEST_LINEWRAP_MIN_MAX = eINSTANCE.getTestLinewrapMinMax();

    /**
     * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_LINEWRAP_MIN_MAX__ITEMS = eINSTANCE.getTestLinewrapMinMax_Items();

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
     * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_INDENTATION__ITEMS = eINSTANCE.getTestIndentation_Items();

    /**
     * The meta object literal for the '<em><b>Semi</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEST_INDENTATION__SEMI = eINSTANCE.getTestIndentation_Semi();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FqnObjImpl <em>Fqn Obj</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FqnObjImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getFqnObj()
     * @generated
     */
    EClass FQN_OBJ = eINSTANCE.getFqnObj();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FQN_OBJ__NAME = eINSTANCE.getFqnObj_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FqnRefImpl <em>Fqn Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FqnRefImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getFqnRef()
     * @generated
     */
    EClass FQN_REF = eINSTANCE.getFqnRef();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FQN_REF__REF = eINSTANCE.getFqnRef_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.EnumerationImpl <em>Enumeration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.EnumerationImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getEnumeration()
     * @generated
     */
    EClass ENUMERATION = eINSTANCE.getEnumeration();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUMERATION__VAL = eINSTANCE.getEnumeration_Val();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SuppressedHiddenImpl <em>Suppressed Hidden</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SuppressedHiddenImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getSuppressedHidden()
     * @generated
     */
    EClass SUPPRESSED_HIDDEN = eINSTANCE.getSuppressedHidden();

    /**
     * The meta object literal for the '<em><b>Vals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUPPRESSED_HIDDEN__VALS = eINSTANCE.getSuppressedHidden_Vals();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SuppressedHiddenSubImpl <em>Suppressed Hidden Sub</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SuppressedHiddenSubImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getSuppressedHiddenSub()
     * @generated
     */
    EClass SUPPRESSED_HIDDEN_SUB = eINSTANCE.getSuppressedHiddenSub();

    /**
     * The meta object literal for the '<em><b>Idval</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUPPRESSED_HIDDEN_SUB__IDVAL = eINSTANCE.getSuppressedHiddenSub_Idval();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SuppressedHiddenSubSubImpl <em>Suppressed Hidden Sub Sub</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SuppressedHiddenSubSubImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getSuppressedHiddenSubSub()
     * @generated
     */
    EClass SUPPRESSED_HIDDEN_SUB_SUB = eINSTANCE.getSuppressedHiddenSubSub();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SuppressedHiddenSubIDImpl <em>Suppressed Hidden Sub ID</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.SuppressedHiddenSubIDImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getSuppressedHiddenSubID()
     * @generated
     */
    EClass SUPPRESSED_HIDDEN_SUB_ID = eINSTANCE.getSuppressedHiddenSubID();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.DatatypesImpl <em>Datatypes</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.DatatypesImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getDatatypes()
     * @generated
     */
    EClass DATATYPES = eINSTANCE.getDatatypes();

    /**
     * The meta object literal for the '<em><b>Val1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATATYPES__VAL1 = eINSTANCE.getDatatypes_Val1();

    /**
     * The meta object literal for the '<em><b>Val2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATATYPES__VAL2 = eINSTANCE.getDatatypes_Val2();

    /**
     * The meta object literal for the '<em><b>Val3</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATATYPES__VAL3 = eINSTANCE.getDatatypes_Val3();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.WrappingDataTypeTestImpl <em>Wrapping Data Type Test</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.WrappingDataTypeTestImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getWrappingDataTypeTest()
     * @generated
     */
    EClass WRAPPING_DATA_TYPE_TEST = eINSTANCE.getWrappingDataTypeTest();

    /**
     * The meta object literal for the '<em><b>Datatype</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WRAPPING_DATA_TYPE_TEST__DATATYPE = eINSTANCE.getWrappingDataTypeTest_Datatype();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Enum1 <em>Enum1</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Enum1
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getEnum1()
     * @generated
     */
    EEnum ENUM1 = eINSTANCE.getEnum1();

  }

} //FormattertestlanguagePackage
