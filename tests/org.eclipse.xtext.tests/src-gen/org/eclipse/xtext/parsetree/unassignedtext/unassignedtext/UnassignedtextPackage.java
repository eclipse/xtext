/**
 */
package org.eclipse.xtext.parsetree.unassignedtext.unassignedtext;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.UnassignedtextFactory
 * @model kind="package"
 * @generated
 */
public interface UnassignedtextPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "unassignedtext";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://simple/unassignedtext";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "unassignedtext";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UnassignedtextPackage eINSTANCE = org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.UnassignedtextPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.ModelImpl
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.UnassignedtextPackageImpl#getModel()
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
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.CaseInsensitiveKeywordRuleImpl <em>Case Insensitive Keyword Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.CaseInsensitiveKeywordRuleImpl
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.UnassignedtextPackageImpl#getCaseInsensitiveKeywordRule()
   * @generated
   */
  int CASE_INSENSITIVE_KEYWORD_RULE = 1;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_INSENSITIVE_KEYWORD_RULE__VAL = MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Case Insensitive Keyword Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_INSENSITIVE_KEYWORD_RULE_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.PluralRuleImpl <em>Plural Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.PluralRuleImpl
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.UnassignedtextPackageImpl#getPluralRule()
   * @generated
   */
  int PLURAL_RULE = 2;

  /**
   * The feature id for the '<em><b>Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLURAL_RULE__COUNT = MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Plural Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLURAL_RULE_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.MultiRuleImpl <em>Multi Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.MultiRuleImpl
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.UnassignedtextPackageImpl#getMultiRule()
   * @generated
   */
  int MULTI_RULE = 3;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_RULE__VAL = MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Multi Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_RULE_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.DatatypeRuleImpl <em>Datatype Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.DatatypeRuleImpl
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.UnassignedtextPackageImpl#getDatatypeRule()
   * @generated
   */
  int DATATYPE_RULE = 4;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATATYPE_RULE__VAL = MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Datatype Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATATYPE_RULE_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.CommonTerminalsRuleImpl <em>Common Terminals Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.CommonTerminalsRuleImpl
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.UnassignedtextPackageImpl#getCommonTerminalsRule()
   * @generated
   */
  int COMMON_TERMINALS_RULE = 5;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMON_TERMINALS_RULE__VAL = MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Common Terminals Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMON_TERMINALS_RULE_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.CaseInsensitiveKeywordRule <em>Case Insensitive Keyword Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Case Insensitive Keyword Rule</em>'.
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.CaseInsensitiveKeywordRule
   * @generated
   */
  EClass getCaseInsensitiveKeywordRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.CaseInsensitiveKeywordRule#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.CaseInsensitiveKeywordRule#getVal()
   * @see #getCaseInsensitiveKeywordRule()
   * @generated
   */
  EAttribute getCaseInsensitiveKeywordRule_Val();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.PluralRule <em>Plural Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Plural Rule</em>'.
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.PluralRule
   * @generated
   */
  EClass getPluralRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.PluralRule#getCount <em>Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Count</em>'.
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.PluralRule#getCount()
   * @see #getPluralRule()
   * @generated
   */
  EAttribute getPluralRule_Count();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.MultiRule <em>Multi Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multi Rule</em>'.
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.MultiRule
   * @generated
   */
  EClass getMultiRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.MultiRule#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.MultiRule#getVal()
   * @see #getMultiRule()
   * @generated
   */
  EAttribute getMultiRule_Val();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.DatatypeRule <em>Datatype Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Datatype Rule</em>'.
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.DatatypeRule
   * @generated
   */
  EClass getDatatypeRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.DatatypeRule#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.DatatypeRule#getVal()
   * @see #getDatatypeRule()
   * @generated
   */
  EAttribute getDatatypeRule_Val();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.CommonTerminalsRule <em>Common Terminals Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Common Terminals Rule</em>'.
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.CommonTerminalsRule
   * @generated
   */
  EClass getCommonTerminalsRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.CommonTerminalsRule#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.CommonTerminalsRule#getVal()
   * @see #getCommonTerminalsRule()
   * @generated
   */
  EAttribute getCommonTerminalsRule_Val();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  UnassignedtextFactory getUnassignedtextFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.ModelImpl
     * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.UnassignedtextPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.CaseInsensitiveKeywordRuleImpl <em>Case Insensitive Keyword Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.CaseInsensitiveKeywordRuleImpl
     * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.UnassignedtextPackageImpl#getCaseInsensitiveKeywordRule()
     * @generated
     */
    EClass CASE_INSENSITIVE_KEYWORD_RULE = eINSTANCE.getCaseInsensitiveKeywordRule();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CASE_INSENSITIVE_KEYWORD_RULE__VAL = eINSTANCE.getCaseInsensitiveKeywordRule_Val();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.PluralRuleImpl <em>Plural Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.PluralRuleImpl
     * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.UnassignedtextPackageImpl#getPluralRule()
     * @generated
     */
    EClass PLURAL_RULE = eINSTANCE.getPluralRule();

    /**
     * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PLURAL_RULE__COUNT = eINSTANCE.getPluralRule_Count();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.MultiRuleImpl <em>Multi Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.MultiRuleImpl
     * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.UnassignedtextPackageImpl#getMultiRule()
     * @generated
     */
    EClass MULTI_RULE = eINSTANCE.getMultiRule();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTI_RULE__VAL = eINSTANCE.getMultiRule_Val();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.DatatypeRuleImpl <em>Datatype Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.DatatypeRuleImpl
     * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.UnassignedtextPackageImpl#getDatatypeRule()
     * @generated
     */
    EClass DATATYPE_RULE = eINSTANCE.getDatatypeRule();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATATYPE_RULE__VAL = eINSTANCE.getDatatypeRule_Val();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.CommonTerminalsRuleImpl <em>Common Terminals Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.CommonTerminalsRuleImpl
     * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.UnassignedtextPackageImpl#getCommonTerminalsRule()
     * @generated
     */
    EClass COMMON_TERMINALS_RULE = eINSTANCE.getCommonTerminalsRule();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMON_TERMINALS_RULE__VAL = eINSTANCE.getCommonTerminalsRule_Val();

  }

} //UnassignedtextPackage
