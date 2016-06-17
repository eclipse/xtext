/**
 */
package org.eclipse.xtext.parser.parameters.parametersTestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parser Rule Parameters</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParserRuleParameters#getScenario <em>Scenario</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParametersTestLanguagePackage#getParserRuleParameters()
 * @model
 * @generated
 */
public interface ParserRuleParameters extends EObject
{
  /**
   * Returns the value of the '<em><b>Scenario</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scenario</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scenario</em>' containment reference.
   * @see #setScenario(Scenario)
   * @see org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParametersTestLanguagePackage#getParserRuleParameters_Scenario()
   * @model containment="true"
   * @generated
   */
  Scenario getScenario();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParserRuleParameters#getScenario <em>Scenario</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scenario</em>' containment reference.
   * @see #getScenario()
   * @generated
   */
  void setScenario(Scenario value);

} // ParserRuleParameters
