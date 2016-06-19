/**
 */
package org.eclipse.xtext.serializer.assignmentFinderTest;

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
 * @see org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestFactory
 * @model kind="package"
 * @generated
 */
public interface AssignmentFinderTestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "assignmentFinderTest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/assignmentfindertestlanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "assignmentFinderTest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AssignmentFinderTestPackage eINSTANCE = org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.ModelImpl
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Keyword Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__KEYWORD_VAL = 0;

  /**
   * The feature id for the '<em><b>Terminal Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__TERMINAL_VAL = 1;

  /**
   * The feature id for the '<em><b>Enum Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ENUM_VAL = 2;

  /**
   * The feature id for the '<em><b>Keyword Bool</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__KEYWORD_BOOL = 3;

  /**
   * The feature id for the '<em><b>Terminal Bool</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__TERMINAL_BOOL = 4;

  /**
   * The feature id for the '<em><b>Enum Bool</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ENUM_BOOL = 5;

  /**
   * The feature id for the '<em><b>Mixed Bool</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__MIXED_BOOL = 6;

  /**
   * The feature id for the '<em><b>Mixed Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__MIXED_VALUE = 7;

  /**
   * The feature id for the '<em><b>Containment Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__CONTAINMENT_REF = 8;

  /**
   * The feature id for the '<em><b>Cross Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__CROSS_REF = 9;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 10;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.KeywordValImpl <em>Keyword Val</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.KeywordValImpl
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getKeywordVal()
   * @generated
   */
  int KEYWORD_VAL = 1;

  /**
   * The feature id for the '<em><b>Kw</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD_VAL__KW = 0;

  /**
   * The number of structural features of the '<em>Keyword Val</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD_VAL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.TerminalValImpl <em>Terminal Val</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.TerminalValImpl
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getTerminalVal()
   * @generated
   */
  int TERMINAL_VAL = 2;

  /**
   * The feature id for the '<em><b>Term</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERMINAL_VAL__TERM = 0;

  /**
   * The number of structural features of the '<em>Terminal Val</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERMINAL_VAL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.EnumValImpl <em>Enum Val</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.EnumValImpl
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getEnumVal()
   * @generated
   */
  int ENUM_VAL = 3;

  /**
   * The feature id for the '<em><b>En</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_VAL__EN = 0;

  /**
   * The number of structural features of the '<em>Enum Val</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_VAL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.KeywordBoolImpl <em>Keyword Bool</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.KeywordBoolImpl
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getKeywordBool()
   * @generated
   */
  int KEYWORD_BOOL = 4;

  /**
   * The feature id for the '<em><b>Kw</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD_BOOL__KW = 0;

  /**
   * The number of structural features of the '<em>Keyword Bool</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD_BOOL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.TerminalBoolImpl <em>Terminal Bool</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.TerminalBoolImpl
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getTerminalBool()
   * @generated
   */
  int TERMINAL_BOOL = 5;

  /**
   * The feature id for the '<em><b>Term</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERMINAL_BOOL__TERM = 0;

  /**
   * The number of structural features of the '<em>Terminal Bool</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERMINAL_BOOL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.EnumBoolImpl <em>Enum Bool</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.EnumBoolImpl
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getEnumBool()
   * @generated
   */
  int ENUM_BOOL = 6;

  /**
   * The feature id for the '<em><b>En</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_BOOL__EN = 0;

  /**
   * The number of structural features of the '<em>Enum Bool</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_BOOL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.MixedBoolImpl <em>Mixed Bool</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.MixedBoolImpl
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getMixedBool()
   * @generated
   */
  int MIXED_BOOL = 7;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIXED_BOOL__VAL = 0;

  /**
   * The number of structural features of the '<em>Mixed Bool</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIXED_BOOL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.MixedValueImpl <em>Mixed Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.MixedValueImpl
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getMixedValue()
   * @generated
   */
  int MIXED_VALUE = 8;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIXED_VALUE__VAL = 0;

  /**
   * The number of structural features of the '<em>Mixed Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIXED_VALUE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.ContainmentRefImpl <em>Containment Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.ContainmentRefImpl
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getContainmentRef()
   * @generated
   */
  int CONTAINMENT_REF = 9;

  /**
   * The feature id for the '<em><b>Ctx</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTAINMENT_REF__CTX = 0;

  /**
   * The number of structural features of the '<em>Containment Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTAINMENT_REF_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.ContainmentRefNImpl <em>Containment Ref N</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.ContainmentRefNImpl
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getContainmentRefN()
   * @generated
   */
  int CONTAINMENT_REF_N = 10;

  /**
   * The feature id for the '<em><b>Val1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTAINMENT_REF_N__VAL1 = 0;

  /**
   * The feature id for the '<em><b>Val2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTAINMENT_REF_N__VAL2 = 1;

  /**
   * The number of structural features of the '<em>Containment Ref N</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTAINMENT_REF_N_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.CrossRefImpl <em>Cross Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.CrossRefImpl
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getCrossRef()
   * @generated
   */
  int CROSS_REF = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CROSS_REF__NAME = 0;

  /**
   * The feature id for the '<em><b>Cross Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CROSS_REF__CROSS_REF = 1;

  /**
   * The number of structural features of the '<em>Cross Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CROSS_REF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.TestEnum <em>Test Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.TestEnum
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getTestEnum()
   * @generated
   */
  int TEST_ENUM = 12;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.assignmentFinderTest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.assignmentFinderTest.Model#getKeywordVal <em>Keyword Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Keyword Val</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.Model#getKeywordVal()
   * @see #getModel()
   * @generated
   */
  EReference getModel_KeywordVal();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.assignmentFinderTest.Model#getTerminalVal <em>Terminal Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Terminal Val</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.Model#getTerminalVal()
   * @see #getModel()
   * @generated
   */
  EReference getModel_TerminalVal();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.assignmentFinderTest.Model#getEnumVal <em>Enum Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Enum Val</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.Model#getEnumVal()
   * @see #getModel()
   * @generated
   */
  EReference getModel_EnumVal();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.assignmentFinderTest.Model#getKeywordBool <em>Keyword Bool</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Keyword Bool</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.Model#getKeywordBool()
   * @see #getModel()
   * @generated
   */
  EReference getModel_KeywordBool();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.assignmentFinderTest.Model#getTerminalBool <em>Terminal Bool</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Terminal Bool</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.Model#getTerminalBool()
   * @see #getModel()
   * @generated
   */
  EReference getModel_TerminalBool();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.assignmentFinderTest.Model#getEnumBool <em>Enum Bool</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Enum Bool</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.Model#getEnumBool()
   * @see #getModel()
   * @generated
   */
  EReference getModel_EnumBool();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.assignmentFinderTest.Model#getMixedBool <em>Mixed Bool</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Mixed Bool</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.Model#getMixedBool()
   * @see #getModel()
   * @generated
   */
  EReference getModel_MixedBool();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.assignmentFinderTest.Model#getMixedValue <em>Mixed Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Mixed Value</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.Model#getMixedValue()
   * @see #getModel()
   * @generated
   */
  EReference getModel_MixedValue();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.assignmentFinderTest.Model#getContainmentRef <em>Containment Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Containment Ref</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.Model#getContainmentRef()
   * @see #getModel()
   * @generated
   */
  EReference getModel_ContainmentRef();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.assignmentFinderTest.Model#getCrossRef <em>Cross Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cross Ref</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.Model#getCrossRef()
   * @see #getModel()
   * @generated
   */
  EReference getModel_CrossRef();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.assignmentFinderTest.KeywordVal <em>Keyword Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Keyword Val</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.KeywordVal
   * @generated
   */
  EClass getKeywordVal();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.assignmentFinderTest.KeywordVal#getKw <em>Kw</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kw</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.KeywordVal#getKw()
   * @see #getKeywordVal()
   * @generated
   */
  EAttribute getKeywordVal_Kw();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.assignmentFinderTest.TerminalVal <em>Terminal Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Terminal Val</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.TerminalVal
   * @generated
   */
  EClass getTerminalVal();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.assignmentFinderTest.TerminalVal#getTerm <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Term</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.TerminalVal#getTerm()
   * @see #getTerminalVal()
   * @generated
   */
  EAttribute getTerminalVal_Term();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.assignmentFinderTest.EnumVal <em>Enum Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Val</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.EnumVal
   * @generated
   */
  EClass getEnumVal();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.assignmentFinderTest.EnumVal#getEn <em>En</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>En</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.EnumVal#getEn()
   * @see #getEnumVal()
   * @generated
   */
  EAttribute getEnumVal_En();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.assignmentFinderTest.KeywordBool <em>Keyword Bool</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Keyword Bool</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.KeywordBool
   * @generated
   */
  EClass getKeywordBool();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.assignmentFinderTest.KeywordBool#isKw <em>Kw</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kw</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.KeywordBool#isKw()
   * @see #getKeywordBool()
   * @generated
   */
  EAttribute getKeywordBool_Kw();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.assignmentFinderTest.TerminalBool <em>Terminal Bool</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Terminal Bool</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.TerminalBool
   * @generated
   */
  EClass getTerminalBool();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.assignmentFinderTest.TerminalBool#isTerm <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Term</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.TerminalBool#isTerm()
   * @see #getTerminalBool()
   * @generated
   */
  EAttribute getTerminalBool_Term();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.assignmentFinderTest.EnumBool <em>Enum Bool</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Bool</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.EnumBool
   * @generated
   */
  EClass getEnumBool();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.assignmentFinderTest.EnumBool#isEn <em>En</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>En</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.EnumBool#isEn()
   * @see #getEnumBool()
   * @generated
   */
  EAttribute getEnumBool_En();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.assignmentFinderTest.MixedBool <em>Mixed Bool</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mixed Bool</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.MixedBool
   * @generated
   */
  EClass getMixedBool();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.assignmentFinderTest.MixedBool#isVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.MixedBool#isVal()
   * @see #getMixedBool()
   * @generated
   */
  EAttribute getMixedBool_Val();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.assignmentFinderTest.MixedValue <em>Mixed Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mixed Value</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.MixedValue
   * @generated
   */
  EClass getMixedValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.assignmentFinderTest.MixedValue#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.MixedValue#getVal()
   * @see #getMixedValue()
   * @generated
   */
  EAttribute getMixedValue_Val();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.assignmentFinderTest.ContainmentRef <em>Containment Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Containment Ref</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.ContainmentRef
   * @generated
   */
  EClass getContainmentRef();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.assignmentFinderTest.ContainmentRef#getCtx <em>Ctx</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ctx</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.ContainmentRef#getCtx()
   * @see #getContainmentRef()
   * @generated
   */
  EReference getContainmentRef_Ctx();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.assignmentFinderTest.ContainmentRefN <em>Containment Ref N</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Containment Ref N</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.ContainmentRefN
   * @generated
   */
  EClass getContainmentRefN();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.assignmentFinderTest.ContainmentRefN#getVal1 <em>Val1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val1</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.ContainmentRefN#getVal1()
   * @see #getContainmentRefN()
   * @generated
   */
  EAttribute getContainmentRefN_Val1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.assignmentFinderTest.ContainmentRefN#getVal2 <em>Val2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val2</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.ContainmentRefN#getVal2()
   * @see #getContainmentRefN()
   * @generated
   */
  EAttribute getContainmentRefN_Val2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.assignmentFinderTest.CrossRef <em>Cross Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cross Ref</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.CrossRef
   * @generated
   */
  EClass getCrossRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.assignmentFinderTest.CrossRef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.CrossRef#getName()
   * @see #getCrossRef()
   * @generated
   */
  EAttribute getCrossRef_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.serializer.assignmentFinderTest.CrossRef#getCrossRef <em>Cross Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Cross Ref</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.CrossRef#getCrossRef()
   * @see #getCrossRef()
   * @generated
   */
  EReference getCrossRef_CrossRef();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.serializer.assignmentFinderTest.TestEnum <em>Test Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Test Enum</em>'.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.TestEnum
   * @generated
   */
  EEnum getTestEnum();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  AssignmentFinderTestFactory getAssignmentFinderTestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.ModelImpl
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Keyword Val</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__KEYWORD_VAL = eINSTANCE.getModel_KeywordVal();

    /**
     * The meta object literal for the '<em><b>Terminal Val</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__TERMINAL_VAL = eINSTANCE.getModel_TerminalVal();

    /**
     * The meta object literal for the '<em><b>Enum Val</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ENUM_VAL = eINSTANCE.getModel_EnumVal();

    /**
     * The meta object literal for the '<em><b>Keyword Bool</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__KEYWORD_BOOL = eINSTANCE.getModel_KeywordBool();

    /**
     * The meta object literal for the '<em><b>Terminal Bool</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__TERMINAL_BOOL = eINSTANCE.getModel_TerminalBool();

    /**
     * The meta object literal for the '<em><b>Enum Bool</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ENUM_BOOL = eINSTANCE.getModel_EnumBool();

    /**
     * The meta object literal for the '<em><b>Mixed Bool</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__MIXED_BOOL = eINSTANCE.getModel_MixedBool();

    /**
     * The meta object literal for the '<em><b>Mixed Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__MIXED_VALUE = eINSTANCE.getModel_MixedValue();

    /**
     * The meta object literal for the '<em><b>Containment Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__CONTAINMENT_REF = eINSTANCE.getModel_ContainmentRef();

    /**
     * The meta object literal for the '<em><b>Cross Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__CROSS_REF = eINSTANCE.getModel_CrossRef();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.KeywordValImpl <em>Keyword Val</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.KeywordValImpl
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getKeywordVal()
     * @generated
     */
    EClass KEYWORD_VAL = eINSTANCE.getKeywordVal();

    /**
     * The meta object literal for the '<em><b>Kw</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEYWORD_VAL__KW = eINSTANCE.getKeywordVal_Kw();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.TerminalValImpl <em>Terminal Val</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.TerminalValImpl
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getTerminalVal()
     * @generated
     */
    EClass TERMINAL_VAL = eINSTANCE.getTerminalVal();

    /**
     * The meta object literal for the '<em><b>Term</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TERMINAL_VAL__TERM = eINSTANCE.getTerminalVal_Term();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.EnumValImpl <em>Enum Val</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.EnumValImpl
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getEnumVal()
     * @generated
     */
    EClass ENUM_VAL = eINSTANCE.getEnumVal();

    /**
     * The meta object literal for the '<em><b>En</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUM_VAL__EN = eINSTANCE.getEnumVal_En();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.KeywordBoolImpl <em>Keyword Bool</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.KeywordBoolImpl
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getKeywordBool()
     * @generated
     */
    EClass KEYWORD_BOOL = eINSTANCE.getKeywordBool();

    /**
     * The meta object literal for the '<em><b>Kw</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEYWORD_BOOL__KW = eINSTANCE.getKeywordBool_Kw();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.TerminalBoolImpl <em>Terminal Bool</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.TerminalBoolImpl
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getTerminalBool()
     * @generated
     */
    EClass TERMINAL_BOOL = eINSTANCE.getTerminalBool();

    /**
     * The meta object literal for the '<em><b>Term</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TERMINAL_BOOL__TERM = eINSTANCE.getTerminalBool_Term();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.EnumBoolImpl <em>Enum Bool</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.EnumBoolImpl
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getEnumBool()
     * @generated
     */
    EClass ENUM_BOOL = eINSTANCE.getEnumBool();

    /**
     * The meta object literal for the '<em><b>En</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUM_BOOL__EN = eINSTANCE.getEnumBool_En();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.MixedBoolImpl <em>Mixed Bool</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.MixedBoolImpl
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getMixedBool()
     * @generated
     */
    EClass MIXED_BOOL = eINSTANCE.getMixedBool();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MIXED_BOOL__VAL = eINSTANCE.getMixedBool_Val();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.MixedValueImpl <em>Mixed Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.MixedValueImpl
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getMixedValue()
     * @generated
     */
    EClass MIXED_VALUE = eINSTANCE.getMixedValue();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MIXED_VALUE__VAL = eINSTANCE.getMixedValue_Val();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.ContainmentRefImpl <em>Containment Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.ContainmentRefImpl
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getContainmentRef()
     * @generated
     */
    EClass CONTAINMENT_REF = eINSTANCE.getContainmentRef();

    /**
     * The meta object literal for the '<em><b>Ctx</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTAINMENT_REF__CTX = eINSTANCE.getContainmentRef_Ctx();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.ContainmentRefNImpl <em>Containment Ref N</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.ContainmentRefNImpl
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getContainmentRefN()
     * @generated
     */
    EClass CONTAINMENT_REF_N = eINSTANCE.getContainmentRefN();

    /**
     * The meta object literal for the '<em><b>Val1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTAINMENT_REF_N__VAL1 = eINSTANCE.getContainmentRefN_Val1();

    /**
     * The meta object literal for the '<em><b>Val2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTAINMENT_REF_N__VAL2 = eINSTANCE.getContainmentRefN_Val2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.CrossRefImpl <em>Cross Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.CrossRefImpl
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getCrossRef()
     * @generated
     */
    EClass CROSS_REF = eINSTANCE.getCrossRef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CROSS_REF__NAME = eINSTANCE.getCrossRef_Name();

    /**
     * The meta object literal for the '<em><b>Cross Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CROSS_REF__CROSS_REF = eINSTANCE.getCrossRef_CrossRef();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.TestEnum <em>Test Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.TestEnum
     * @see org.eclipse.xtext.serializer.assignmentFinderTest.impl.AssignmentFinderTestPackageImpl#getTestEnum()
     * @generated
     */
    EEnum TEST_ENUM = eINSTANCE.getTestEnum();

  }

} //AssignmentFinderTestPackage
