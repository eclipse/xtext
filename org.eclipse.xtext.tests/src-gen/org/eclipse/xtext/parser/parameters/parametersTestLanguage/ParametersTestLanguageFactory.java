/**
 */
package org.eclipse.xtext.parser.parameters.parametersTestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParametersTestLanguagePackage
 * @generated
 */
public interface ParametersTestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ParametersTestLanguageFactory eINSTANCE = org.eclipse.xtext.parser.parameters.parametersTestLanguage.impl.ParametersTestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Parser Rule Parameters</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parser Rule Parameters</em>'.
   * @generated
   */
  ParserRuleParameters createParserRuleParameters();

  /**
   * Returns a new object of class '<em>Scenario</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scenario</em>'.
   * @generated
   */
  Scenario createScenario();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ParametersTestLanguagePackage getParametersTestLanguagePackage();

} //ParametersTestLanguageFactory
