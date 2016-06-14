/**
 */
package org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage
 * @generated
 */
public interface SimpleAntlrFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SimpleAntlrFactory eINSTANCE = org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Antlr Grammar</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Antlr Grammar</em>'.
   * @generated
   */
  AntlrGrammar createAntlrGrammar();

  /**
   * Returns a new object of class '<em>Options</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Options</em>'.
   * @generated
   */
  Options createOptions();

  /**
   * Returns a new object of class '<em>Option Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Option Value</em>'.
   * @generated
   */
  OptionValue createOptionValue();

  /**
   * Returns a new object of class '<em>Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule</em>'.
   * @generated
   */
  Rule createRule();

  /**
   * Returns a new object of class '<em>Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter</em>'.
   * @generated
   */
  Parameter createParameter();

  /**
   * Returns a new object of class '<em>Rule Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Element</em>'.
   * @generated
   */
  RuleElement createRuleElement();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Reference Or Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reference Or Literal</em>'.
   * @generated
   */
  ReferenceOrLiteral createReferenceOrLiteral();

  /**
   * Returns a new object of class '<em>Predicated</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Predicated</em>'.
   * @generated
   */
  Predicated createPredicated();

  /**
   * Returns a new object of class '<em>Rule Options</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Options</em>'.
   * @generated
   */
  RuleOptions createRuleOptions();

  /**
   * Returns a new object of class '<em>Rule Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Call</em>'.
   * @generated
   */
  RuleCall createRuleCall();

  /**
   * Returns a new object of class '<em>Keyword</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Keyword</em>'.
   * @generated
   */
  Keyword createKeyword();

  /**
   * Returns a new object of class '<em>Wildcard</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Wildcard</em>'.
   * @generated
   */
  Wildcard createWildcard();

  /**
   * Returns a new object of class '<em>Alternatives</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Alternatives</em>'.
   * @generated
   */
  Alternatives createAlternatives();

  /**
   * Returns a new object of class '<em>Group</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Group</em>'.
   * @generated
   */
  Group createGroup();

  /**
   * Returns a new object of class '<em>Element With Cardinality</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Element With Cardinality</em>'.
   * @generated
   */
  ElementWithCardinality createElementWithCardinality();

  /**
   * Returns a new object of class '<em>Negated Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Negated Element</em>'.
   * @generated
   */
  NegatedElement createNegatedElement();

  /**
   * Returns a new object of class '<em>Until Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Until Element</em>'.
   * @generated
   */
  UntilElement createUntilElement();

  /**
   * Returns a new object of class '<em>Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or Expression</em>'.
   * @generated
   */
  OrExpression createOrExpression();

  /**
   * Returns a new object of class '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Expression</em>'.
   * @generated
   */
  AndExpression createAndExpression();

  /**
   * Returns a new object of class '<em>Not Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Not Expression</em>'.
   * @generated
   */
  NotExpression createNotExpression();

  /**
   * Returns a new object of class '<em>Skip</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Skip</em>'.
   * @generated
   */
  Skip createSkip();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  SimpleAntlrPackage getSimpleAntlrPackage();

} //SimpleAntlrFactory
