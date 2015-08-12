/**
 */
package org.eclipse.xtext.parser.parameters.parametersTestLanguage;

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
 * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParametersTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface ParametersTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "parametersTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2015/tmf/xtext/parameters";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "parametersTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ParametersTestLanguagePackage eINSTANCE = org.eclipse.xtext.parser.parameters.parametersTestLanguage.impl.ParametersTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.impl.ParserRuleParametersImpl <em>Parser Rule Parameters</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.impl.ParserRuleParametersImpl
   * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.impl.ParametersTestLanguagePackageImpl#getParserRuleParameters()
   * @generated
   */
  int PARSER_RULE_PARAMETERS = 0;

  /**
   * The feature id for the '<em><b>Scenario</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE_PARAMETERS__SCENARIO = 0;

  /**
   * The number of structural features of the '<em>Parser Rule Parameters</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE_PARAMETERS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.impl.ScenarioImpl <em>Scenario</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.impl.ScenarioImpl
   * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.impl.ParametersTestLanguagePackageImpl#getScenario()
   * @generated
   */
  int SCENARIO = 1;

  /**
   * The feature id for the '<em><b>First</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCENARIO__FIRST = 0;

  /**
   * The feature id for the '<em><b>Second</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCENARIO__SECOND = 1;

  /**
   * The number of structural features of the '<em>Scenario</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCENARIO_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParserRuleParameters <em>Parser Rule Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parser Rule Parameters</em>'.
   * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParserRuleParameters
   * @generated
   */
  EClass getParserRuleParameters();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParserRuleParameters#getScenario <em>Scenario</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Scenario</em>'.
   * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParserRuleParameters#getScenario()
   * @see #getParserRuleParameters()
   * @generated
   */
  EReference getParserRuleParameters_Scenario();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.Scenario <em>Scenario</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scenario</em>'.
   * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.Scenario
   * @generated
   */
  EClass getScenario();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.Scenario#getFirst <em>First</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>First</em>'.
   * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.Scenario#getFirst()
   * @see #getScenario()
   * @generated
   */
  EAttribute getScenario_First();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.Scenario#getSecond <em>Second</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Second</em>'.
   * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.Scenario#getSecond()
   * @see #getScenario()
   * @generated
   */
  EAttribute getScenario_Second();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ParametersTestLanguageFactory getParametersTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.impl.ParserRuleParametersImpl <em>Parser Rule Parameters</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.impl.ParserRuleParametersImpl
     * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.impl.ParametersTestLanguagePackageImpl#getParserRuleParameters()
     * @generated
     */
    EClass PARSER_RULE_PARAMETERS = eINSTANCE.getParserRuleParameters();

    /**
     * The meta object literal for the '<em><b>Scenario</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARSER_RULE_PARAMETERS__SCENARIO = eINSTANCE.getParserRuleParameters_Scenario();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.impl.ScenarioImpl <em>Scenario</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.impl.ScenarioImpl
     * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.impl.ParametersTestLanguagePackageImpl#getScenario()
     * @generated
     */
    EClass SCENARIO = eINSTANCE.getScenario();

    /**
     * The meta object literal for the '<em><b>First</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCENARIO__FIRST = eINSTANCE.getScenario_First();

    /**
     * The meta object literal for the '<em><b>Second</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCENARIO__SECOND = eINSTANCE.getScenario_Second();

  }

} //ParametersTestLanguagePackage
