/**
 */
package org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage;

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
 * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.BacktrackingBug325745TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface BacktrackingBug325745TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "backtrackingBug325745TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2010/tmf/xtext/backtrackingBug325745TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "backtrackingBug325745TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  BacktrackingBug325745TestLanguagePackage eINSTANCE = org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.BacktrackingBug325745TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.BacktrackingBug325745TestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__FIELDS = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.ElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.ElementImpl
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.BacktrackingBug325745TestLanguagePackageImpl#getElement()
   * @generated
   */
  int ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__DATA_TYPE = 1;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__EXPRESSION = 2;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.DataTypeImpl <em>Data Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.DataTypeImpl
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.BacktrackingBug325745TestLanguagePackageImpl#getDataType()
   * @generated
   */
  int DATA_TYPE = 2;

  /**
   * The feature id for the '<em><b>Base Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__BASE_TYPE = 0;

  /**
   * The feature id for the '<em><b>Default Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__DEFAULT_VALUE = 1;

  /**
   * The number of structural features of the '<em>Data Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.ExpressionImpl
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.BacktrackingBug325745TestLanguagePackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 3;

  /**
   * The feature id for the '<em><b>Prefix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__PREFIX = 0;

  /**
   * The feature id for the '<em><b>Terms</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__TERMS = 1;

  /**
   * The feature id for the '<em><b>Postfix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__POSTFIX = 2;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.SimpleTermImpl <em>Simple Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.SimpleTermImpl
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.BacktrackingBug325745TestLanguagePackageImpl#getSimpleTerm()
   * @generated
   */
  int SIMPLE_TERM = 4;

  /**
   * The feature id for the '<em><b>Line Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_TERM__LINE_COUNT = 0;

  /**
   * The feature id for the '<em><b>Char Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_TERM__CHAR_COUNT = 1;

  /**
   * The feature id for the '<em><b>Char Set</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_TERM__CHAR_SET = 2;

  /**
   * The feature id for the '<em><b>Ref Char</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_TERM__REF_CHAR = 3;

  /**
   * The number of structural features of the '<em>Simple Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_TERM_FEATURE_COUNT = 4;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Model#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Model#getFields()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Fields();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Element
   * @generated
   */
  EClass getElement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Element#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Element#getName()
   * @see #getElement()
   * @generated
   */
  EAttribute getElement_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Element#getDataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Data Type</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Element#getDataType()
   * @see #getElement()
   * @generated
   */
  EReference getElement_DataType();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Element#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Element#getExpression()
   * @see #getElement()
   * @generated
   */
  EReference getElement_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.DataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Type</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.DataType
   * @generated
   */
  EClass getDataType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.DataType#getBaseType <em>Base Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Base Type</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.DataType#getBaseType()
   * @see #getDataType()
   * @generated
   */
  EAttribute getDataType_BaseType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.DataType#getDefaultValue <em>Default Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Default Value</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.DataType#getDefaultValue()
   * @see #getDataType()
   * @generated
   */
  EAttribute getDataType_DefaultValue();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Expression#getPrefix <em>Prefix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Prefix</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Expression#getPrefix()
   * @see #getExpression()
   * @generated
   */
  EAttribute getExpression_Prefix();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Expression#getTerms <em>Terms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Terms</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Expression#getTerms()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Terms();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Expression#getPostfix <em>Postfix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Postfix</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Expression#getPostfix()
   * @see #getExpression()
   * @generated
   */
  EAttribute getExpression_Postfix();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.SimpleTerm <em>Simple Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Term</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.SimpleTerm
   * @generated
   */
  EClass getSimpleTerm();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.SimpleTerm#getLineCount <em>Line Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Line Count</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.SimpleTerm#getLineCount()
   * @see #getSimpleTerm()
   * @generated
   */
  EAttribute getSimpleTerm_LineCount();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.SimpleTerm#getCharCount <em>Char Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Char Count</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.SimpleTerm#getCharCount()
   * @see #getSimpleTerm()
   * @generated
   */
  EAttribute getSimpleTerm_CharCount();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.SimpleTerm#getCharSet <em>Char Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Char Set</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.SimpleTerm#getCharSet()
   * @see #getSimpleTerm()
   * @generated
   */
  EAttribute getSimpleTerm_CharSet();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.SimpleTerm#getRefChar <em>Ref Char</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref Char</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.SimpleTerm#getRefChar()
   * @see #getSimpleTerm()
   * @generated
   */
  EAttribute getSimpleTerm_RefChar();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  BacktrackingBug325745TestLanguageFactory getBacktrackingBug325745TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.BacktrackingBug325745TestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__FIELDS = eINSTANCE.getModel_Fields();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.ElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.ElementImpl
     * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.BacktrackingBug325745TestLanguagePackageImpl#getElement()
     * @generated
     */
    EClass ELEMENT = eINSTANCE.getElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

    /**
     * The meta object literal for the '<em><b>Data Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT__DATA_TYPE = eINSTANCE.getElement_DataType();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT__EXPRESSION = eINSTANCE.getElement_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.DataTypeImpl <em>Data Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.DataTypeImpl
     * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.BacktrackingBug325745TestLanguagePackageImpl#getDataType()
     * @generated
     */
    EClass DATA_TYPE = eINSTANCE.getDataType();

    /**
     * The meta object literal for the '<em><b>Base Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATA_TYPE__BASE_TYPE = eINSTANCE.getDataType_BaseType();

    /**
     * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATA_TYPE__DEFAULT_VALUE = eINSTANCE.getDataType_DefaultValue();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.ExpressionImpl
     * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.BacktrackingBug325745TestLanguagePackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION__PREFIX = eINSTANCE.getExpression_Prefix();

    /**
     * The meta object literal for the '<em><b>Terms</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__TERMS = eINSTANCE.getExpression_Terms();

    /**
     * The meta object literal for the '<em><b>Postfix</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION__POSTFIX = eINSTANCE.getExpression_Postfix();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.SimpleTermImpl <em>Simple Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.SimpleTermImpl
     * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl.BacktrackingBug325745TestLanguagePackageImpl#getSimpleTerm()
     * @generated
     */
    EClass SIMPLE_TERM = eINSTANCE.getSimpleTerm();

    /**
     * The meta object literal for the '<em><b>Line Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_TERM__LINE_COUNT = eINSTANCE.getSimpleTerm_LineCount();

    /**
     * The meta object literal for the '<em><b>Char Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_TERM__CHAR_COUNT = eINSTANCE.getSimpleTerm_CharCount();

    /**
     * The meta object literal for the '<em><b>Char Set</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_TERM__CHAR_SET = eINSTANCE.getSimpleTerm_CharSet();

    /**
     * The meta object literal for the '<em><b>Ref Char</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_TERM__REF_CHAR = eINSTANCE.getSimpleTerm_RefChar();

  }

} //BacktrackingBug325745TestLanguagePackage
