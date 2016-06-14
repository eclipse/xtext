/**
 */
package org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr;

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
 * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrFactory
 * @model kind="package"
 * @generated
 */
public interface SimpleAntlrPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "simpleAntlr";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/generator/parser/antlr/simpleAntlr";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "simpleAntlr";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SimpleAntlrPackage eINSTANCE = org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.AntlrGrammarImpl <em>Antlr Grammar</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.AntlrGrammarImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getAntlrGrammar()
   * @generated
   */
  int ANTLR_GRAMMAR = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANTLR_GRAMMAR__NAME = 0;

  /**
   * The feature id for the '<em><b>Options</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANTLR_GRAMMAR__OPTIONS = 1;

  /**
   * The feature id for the '<em><b>Rules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANTLR_GRAMMAR__RULES = 2;

  /**
   * The number of structural features of the '<em>Antlr Grammar</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANTLR_GRAMMAR_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.OptionsImpl <em>Options</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.OptionsImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getOptions()
   * @generated
   */
  int OPTIONS = 1;

  /**
   * The feature id for the '<em><b>Option Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTIONS__OPTION_VALUES = 0;

  /**
   * The number of structural features of the '<em>Options</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTIONS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.OptionValueImpl <em>Option Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.OptionValueImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getOptionValue()
   * @generated
   */
  int OPTION_VALUE = 2;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTION_VALUE__KEY = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTION_VALUE__VALUE = 1;

  /**
   * The number of structural features of the '<em>Option Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTION_VALUE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleImpl <em>Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getRule()
   * @generated
   */
  int RULE = 3;

  /**
   * The feature id for the '<em><b>Fragment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__FRAGMENT = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__NAME = 1;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__PARAMETERS = 2;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__BODY = 3;

  /**
   * The number of structural features of the '<em>Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ParameterImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 4;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__NAME = 1;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleElementImpl <em>Rule Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleElementImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getRuleElement()
   * @generated
   */
  int RULE_ELEMENT = 5;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_ELEMENT__GUARD = 0;

  /**
   * The feature id for the '<em><b>Guarded</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_ELEMENT__GUARDED = 1;

  /**
   * The number of structural features of the '<em>Rule Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ExpressionImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 6;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ReferenceOrLiteralImpl <em>Reference Or Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ReferenceOrLiteralImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getReferenceOrLiteral()
   * @generated
   */
  int REFERENCE_OR_LITERAL = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_OR_LITERAL__NAME = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Reference Or Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_OR_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.PredicatedImpl <em>Predicated</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.PredicatedImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getPredicated()
   * @generated
   */
  int PREDICATED = 8;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREDICATED__GUARD = RULE_ELEMENT__GUARD;

  /**
   * The feature id for the '<em><b>Guarded</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREDICATED__GUARDED = RULE_ELEMENT__GUARDED;

  /**
   * The feature id for the '<em><b>Predicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREDICATED__PREDICATE = RULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREDICATED__ELEMENT = RULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Predicated</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREDICATED_FEATURE_COUNT = RULE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleOptionsImpl <em>Rule Options</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleOptionsImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getRuleOptions()
   * @generated
   */
  int RULE_OPTIONS = 9;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_OPTIONS__GUARD = RULE_ELEMENT__GUARD;

  /**
   * The feature id for the '<em><b>Guarded</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_OPTIONS__GUARDED = RULE_ELEMENT__GUARDED;

  /**
   * The feature id for the '<em><b>Options</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_OPTIONS__OPTIONS = RULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_OPTIONS__ELEMENT = RULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Rule Options</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_OPTIONS_FEATURE_COUNT = RULE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleCallImpl <em>Rule Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleCallImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getRuleCall()
   * @generated
   */
  int RULE_CALL = 10;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALL__GUARD = RULE_ELEMENT__GUARD;

  /**
   * The feature id for the '<em><b>Guarded</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALL__GUARDED = RULE_ELEMENT__GUARDED;

  /**
   * The feature id for the '<em><b>Rule</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALL__RULE = RULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALL__ARGUMENTS = RULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Rule Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALL_FEATURE_COUNT = RULE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.KeywordImpl <em>Keyword</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.KeywordImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getKeyword()
   * @generated
   */
  int KEYWORD = 11;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD__GUARD = RULE_ELEMENT__GUARD;

  /**
   * The feature id for the '<em><b>Guarded</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD__GUARDED = RULE_ELEMENT__GUARDED;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD__VALUE = RULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Keyword</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD_FEATURE_COUNT = RULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.WildcardImpl <em>Wildcard</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.WildcardImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getWildcard()
   * @generated
   */
  int WILDCARD = 12;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WILDCARD__GUARD = RULE_ELEMENT__GUARD;

  /**
   * The feature id for the '<em><b>Guarded</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WILDCARD__GUARDED = RULE_ELEMENT__GUARDED;

  /**
   * The number of structural features of the '<em>Wildcard</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WILDCARD_FEATURE_COUNT = RULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.AlternativesImpl <em>Alternatives</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.AlternativesImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getAlternatives()
   * @generated
   */
  int ALTERNATIVES = 13;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVES__GUARD = RULE_ELEMENT__GUARD;

  /**
   * The feature id for the '<em><b>Guarded</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVES__GUARDED = RULE_ELEMENT__GUARDED;

  /**
   * The feature id for the '<em><b>Groups</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVES__GROUPS = RULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Alternatives</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVES_FEATURE_COUNT = RULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.GroupImpl <em>Group</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.GroupImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getGroup()
   * @generated
   */
  int GROUP = 14;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP__GUARD = RULE_ELEMENT__GUARD;

  /**
   * The feature id for the '<em><b>Guarded</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP__GUARDED = RULE_ELEMENT__GUARDED;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP__ELEMENTS = RULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Group</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_FEATURE_COUNT = RULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ElementWithCardinalityImpl <em>Element With Cardinality</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ElementWithCardinalityImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getElementWithCardinality()
   * @generated
   */
  int ELEMENT_WITH_CARDINALITY = 15;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_WITH_CARDINALITY__GUARD = RULE_ELEMENT__GUARD;

  /**
   * The feature id for the '<em><b>Guarded</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_WITH_CARDINALITY__GUARDED = RULE_ELEMENT__GUARDED;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_WITH_CARDINALITY__ELEMENT = RULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_WITH_CARDINALITY__CARDINALITY = RULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Element With Cardinality</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_WITH_CARDINALITY_FEATURE_COUNT = RULE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.NegatedElementImpl <em>Negated Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.NegatedElementImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getNegatedElement()
   * @generated
   */
  int NEGATED_ELEMENT = 16;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATED_ELEMENT__GUARD = RULE_ELEMENT__GUARD;

  /**
   * The feature id for the '<em><b>Guarded</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATED_ELEMENT__GUARDED = RULE_ELEMENT__GUARDED;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATED_ELEMENT__ELEMENT = RULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Negated Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATED_ELEMENT_FEATURE_COUNT = RULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.UntilElementImpl <em>Until Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.UntilElementImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getUntilElement()
   * @generated
   */
  int UNTIL_ELEMENT = 17;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNTIL_ELEMENT__GUARD = RULE_ELEMENT__GUARD;

  /**
   * The feature id for the '<em><b>Guarded</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNTIL_ELEMENT__GUARDED = RULE_ELEMENT__GUARDED;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNTIL_ELEMENT__LEFT = RULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNTIL_ELEMENT__RIGHT = RULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Until Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNTIL_ELEMENT_FEATURE_COUNT = RULE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.OrExpressionImpl <em>Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.OrExpressionImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getOrExpression()
   * @generated
   */
  int OR_EXPRESSION = 18;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.AndExpressionImpl <em>And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.AndExpressionImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getAndExpression()
   * @generated
   */
  int AND_EXPRESSION = 19;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.NotExpressionImpl <em>Not Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.NotExpressionImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getNotExpression()
   * @generated
   */
  int NOT_EXPRESSION = 20;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Not Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SkipImpl <em>Skip</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SkipImpl
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getSkip()
   * @generated
   */
  int SKIP = 21;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SKIP__GUARD = RULE_OPTIONS__GUARD;

  /**
   * The feature id for the '<em><b>Guarded</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SKIP__GUARDED = RULE_OPTIONS__GUARDED;

  /**
   * The feature id for the '<em><b>Options</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SKIP__OPTIONS = RULE_OPTIONS__OPTIONS;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SKIP__ELEMENT = RULE_OPTIONS__ELEMENT;

  /**
   * The number of structural features of the '<em>Skip</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SKIP_FEATURE_COUNT = RULE_OPTIONS_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AntlrGrammar <em>Antlr Grammar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Antlr Grammar</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AntlrGrammar
   * @generated
   */
  EClass getAntlrGrammar();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AntlrGrammar#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AntlrGrammar#getName()
   * @see #getAntlrGrammar()
   * @generated
   */
  EAttribute getAntlrGrammar_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AntlrGrammar#getOptions <em>Options</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Options</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AntlrGrammar#getOptions()
   * @see #getAntlrGrammar()
   * @generated
   */
  EReference getAntlrGrammar_Options();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AntlrGrammar#getRules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rules</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AntlrGrammar#getRules()
   * @see #getAntlrGrammar()
   * @generated
   */
  EReference getAntlrGrammar_Rules();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Options <em>Options</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Options</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Options
   * @generated
   */
  EClass getOptions();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Options#getOptionValues <em>Option Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Option Values</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Options#getOptionValues()
   * @see #getOptions()
   * @generated
   */
  EReference getOptions_OptionValues();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.OptionValue <em>Option Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Option Value</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.OptionValue
   * @generated
   */
  EClass getOptionValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.OptionValue#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.OptionValue#getKey()
   * @see #getOptionValue()
   * @generated
   */
  EAttribute getOptionValue_Key();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.OptionValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.OptionValue#getValue()
   * @see #getOptionValue()
   * @generated
   */
  EAttribute getOptionValue_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule
   * @generated
   */
  EClass getRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule#isFragment <em>Fragment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fragment</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule#isFragment()
   * @see #getRule()
   * @generated
   */
  EAttribute getRule_Fragment();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule#getName()
   * @see #getRule()
   * @generated
   */
  EAttribute getRule_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule#getParameters()
   * @see #getRule()
   * @generated
   */
  EReference getRule_Parameters();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule#getBody()
   * @see #getRule()
   * @generated
   */
  EReference getRule_Body();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Parameter#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Parameter#getType()
   * @see #getParameter()
   * @generated
   */
  EAttribute getParameter_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Parameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Parameter#getName()
   * @see #getParameter()
   * @generated
   */
  EAttribute getParameter_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleElement <em>Rule Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Element</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleElement
   * @generated
   */
  EClass getRuleElement();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleElement#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleElement#getGuard()
   * @see #getRuleElement()
   * @generated
   */
  EReference getRuleElement_Guard();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleElement#getGuarded <em>Guarded</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guarded</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleElement#getGuarded()
   * @see #getRuleElement()
   * @generated
   */
  EReference getRuleElement_Guarded();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ReferenceOrLiteral <em>Reference Or Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference Or Literal</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ReferenceOrLiteral
   * @generated
   */
  EClass getReferenceOrLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ReferenceOrLiteral#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ReferenceOrLiteral#getName()
   * @see #getReferenceOrLiteral()
   * @generated
   */
  EAttribute getReferenceOrLiteral_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Predicated <em>Predicated</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Predicated</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Predicated
   * @generated
   */
  EClass getPredicated();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Predicated#getPredicate <em>Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Predicate</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Predicated#getPredicate()
   * @see #getPredicated()
   * @generated
   */
  EReference getPredicated_Predicate();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Predicated#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Predicated#getElement()
   * @see #getPredicated()
   * @generated
   */
  EReference getPredicated_Element();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleOptions <em>Rule Options</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Options</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleOptions
   * @generated
   */
  EClass getRuleOptions();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleOptions#getOptions <em>Options</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Options</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleOptions#getOptions()
   * @see #getRuleOptions()
   * @generated
   */
  EReference getRuleOptions_Options();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleOptions#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleOptions#getElement()
   * @see #getRuleOptions()
   * @generated
   */
  EReference getRuleOptions_Element();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleCall <em>Rule Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Call</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleCall
   * @generated
   */
  EClass getRuleCall();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleCall#getRule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rule</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleCall#getRule()
   * @see #getRuleCall()
   * @generated
   */
  EAttribute getRuleCall_Rule();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleCall#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arguments</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleCall#getArguments()
   * @see #getRuleCall()
   * @generated
   */
  EReference getRuleCall_Arguments();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Keyword <em>Keyword</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Keyword</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Keyword
   * @generated
   */
  EClass getKeyword();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Keyword#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Keyword#getValue()
   * @see #getKeyword()
   * @generated
   */
  EAttribute getKeyword_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Wildcard <em>Wildcard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Wildcard</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Wildcard
   * @generated
   */
  EClass getWildcard();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Alternatives <em>Alternatives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alternatives</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Alternatives
   * @generated
   */
  EClass getAlternatives();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Alternatives#getGroups <em>Groups</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Groups</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Alternatives#getGroups()
   * @see #getAlternatives()
   * @generated
   */
  EReference getAlternatives_Groups();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Group <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Group</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Group
   * @generated
   */
  EClass getGroup();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Group#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Group#getElements()
   * @see #getGroup()
   * @generated
   */
  EReference getGroup_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ElementWithCardinality <em>Element With Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element With Cardinality</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ElementWithCardinality
   * @generated
   */
  EClass getElementWithCardinality();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ElementWithCardinality#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ElementWithCardinality#getElement()
   * @see #getElementWithCardinality()
   * @generated
   */
  EReference getElementWithCardinality_Element();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ElementWithCardinality#getCardinality <em>Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Cardinality</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ElementWithCardinality#getCardinality()
   * @see #getElementWithCardinality()
   * @generated
   */
  EAttribute getElementWithCardinality_Cardinality();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.NegatedElement <em>Negated Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Negated Element</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.NegatedElement
   * @generated
   */
  EClass getNegatedElement();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.NegatedElement#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.NegatedElement#getElement()
   * @see #getNegatedElement()
   * @generated
   */
  EReference getNegatedElement_Element();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.UntilElement <em>Until Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Until Element</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.UntilElement
   * @generated
   */
  EClass getUntilElement();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.UntilElement#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.UntilElement#getLeft()
   * @see #getUntilElement()
   * @generated
   */
  EReference getUntilElement_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.UntilElement#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.UntilElement#getRight()
   * @see #getUntilElement()
   * @generated
   */
  EReference getUntilElement_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.OrExpression <em>Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Expression</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.OrExpression
   * @generated
   */
  EClass getOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.OrExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.OrExpression#getLeft()
   * @see #getOrExpression()
   * @generated
   */
  EReference getOrExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.OrExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.OrExpression#getRight()
   * @see #getOrExpression()
   * @generated
   */
  EReference getOrExpression_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Expression</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AndExpression
   * @generated
   */
  EClass getAndExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AndExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AndExpression#getLeft()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AndExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AndExpression#getRight()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.NotExpression <em>Not Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Not Expression</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.NotExpression
   * @generated
   */
  EClass getNotExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.NotExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.NotExpression#getValue()
   * @see #getNotExpression()
   * @generated
   */
  EReference getNotExpression_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Skip <em>Skip</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Skip</em>'.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Skip
   * @generated
   */
  EClass getSkip();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SimpleAntlrFactory getSimpleAntlrFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.AntlrGrammarImpl <em>Antlr Grammar</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.AntlrGrammarImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getAntlrGrammar()
     * @generated
     */
    EClass ANTLR_GRAMMAR = eINSTANCE.getAntlrGrammar();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANTLR_GRAMMAR__NAME = eINSTANCE.getAntlrGrammar_Name();

    /**
     * The meta object literal for the '<em><b>Options</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANTLR_GRAMMAR__OPTIONS = eINSTANCE.getAntlrGrammar_Options();

    /**
     * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANTLR_GRAMMAR__RULES = eINSTANCE.getAntlrGrammar_Rules();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.OptionsImpl <em>Options</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.OptionsImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getOptions()
     * @generated
     */
    EClass OPTIONS = eINSTANCE.getOptions();

    /**
     * The meta object literal for the '<em><b>Option Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPTIONS__OPTION_VALUES = eINSTANCE.getOptions_OptionValues();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.OptionValueImpl <em>Option Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.OptionValueImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getOptionValue()
     * @generated
     */
    EClass OPTION_VALUE = eINSTANCE.getOptionValue();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPTION_VALUE__KEY = eINSTANCE.getOptionValue_Key();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPTION_VALUE__VALUE = eINSTANCE.getOptionValue_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleImpl <em>Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getRule()
     * @generated
     */
    EClass RULE = eINSTANCE.getRule();

    /**
     * The meta object literal for the '<em><b>Fragment</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE__FRAGMENT = eINSTANCE.getRule_Fragment();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE__NAME = eINSTANCE.getRule_Name();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE__PARAMETERS = eINSTANCE.getRule_Parameters();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE__BODY = eINSTANCE.getRule_Body();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ParameterImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER__TYPE = eINSTANCE.getParameter_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleElementImpl <em>Rule Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleElementImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getRuleElement()
     * @generated
     */
    EClass RULE_ELEMENT = eINSTANCE.getRuleElement();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_ELEMENT__GUARD = eINSTANCE.getRuleElement_Guard();

    /**
     * The meta object literal for the '<em><b>Guarded</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_ELEMENT__GUARDED = eINSTANCE.getRuleElement_Guarded();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ExpressionImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ReferenceOrLiteralImpl <em>Reference Or Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ReferenceOrLiteralImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getReferenceOrLiteral()
     * @generated
     */
    EClass REFERENCE_OR_LITERAL = eINSTANCE.getReferenceOrLiteral();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REFERENCE_OR_LITERAL__NAME = eINSTANCE.getReferenceOrLiteral_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.PredicatedImpl <em>Predicated</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.PredicatedImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getPredicated()
     * @generated
     */
    EClass PREDICATED = eINSTANCE.getPredicated();

    /**
     * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREDICATED__PREDICATE = eINSTANCE.getPredicated_Predicate();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREDICATED__ELEMENT = eINSTANCE.getPredicated_Element();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleOptionsImpl <em>Rule Options</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleOptionsImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getRuleOptions()
     * @generated
     */
    EClass RULE_OPTIONS = eINSTANCE.getRuleOptions();

    /**
     * The meta object literal for the '<em><b>Options</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_OPTIONS__OPTIONS = eINSTANCE.getRuleOptions_Options();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_OPTIONS__ELEMENT = eINSTANCE.getRuleOptions_Element();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleCallImpl <em>Rule Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleCallImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getRuleCall()
     * @generated
     */
    EClass RULE_CALL = eINSTANCE.getRuleCall();

    /**
     * The meta object literal for the '<em><b>Rule</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_CALL__RULE = eINSTANCE.getRuleCall_Rule();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_CALL__ARGUMENTS = eINSTANCE.getRuleCall_Arguments();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.KeywordImpl <em>Keyword</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.KeywordImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getKeyword()
     * @generated
     */
    EClass KEYWORD = eINSTANCE.getKeyword();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEYWORD__VALUE = eINSTANCE.getKeyword_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.WildcardImpl <em>Wildcard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.WildcardImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getWildcard()
     * @generated
     */
    EClass WILDCARD = eINSTANCE.getWildcard();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.AlternativesImpl <em>Alternatives</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.AlternativesImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getAlternatives()
     * @generated
     */
    EClass ALTERNATIVES = eINSTANCE.getAlternatives();

    /**
     * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALTERNATIVES__GROUPS = eINSTANCE.getAlternatives_Groups();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.GroupImpl <em>Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.GroupImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getGroup()
     * @generated
     */
    EClass GROUP = eINSTANCE.getGroup();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GROUP__ELEMENTS = eINSTANCE.getGroup_Elements();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ElementWithCardinalityImpl <em>Element With Cardinality</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ElementWithCardinalityImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getElementWithCardinality()
     * @generated
     */
    EClass ELEMENT_WITH_CARDINALITY = eINSTANCE.getElementWithCardinality();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT_WITH_CARDINALITY__ELEMENT = eINSTANCE.getElementWithCardinality_Element();

    /**
     * The meta object literal for the '<em><b>Cardinality</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT_WITH_CARDINALITY__CARDINALITY = eINSTANCE.getElementWithCardinality_Cardinality();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.NegatedElementImpl <em>Negated Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.NegatedElementImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getNegatedElement()
     * @generated
     */
    EClass NEGATED_ELEMENT = eINSTANCE.getNegatedElement();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NEGATED_ELEMENT__ELEMENT = eINSTANCE.getNegatedElement_Element();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.UntilElementImpl <em>Until Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.UntilElementImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getUntilElement()
     * @generated
     */
    EClass UNTIL_ELEMENT = eINSTANCE.getUntilElement();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNTIL_ELEMENT__LEFT = eINSTANCE.getUntilElement_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNTIL_ELEMENT__RIGHT = eINSTANCE.getUntilElement_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.OrExpressionImpl <em>Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.OrExpressionImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getOrExpression()
     * @generated
     */
    EClass OR_EXPRESSION = eINSTANCE.getOrExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPRESSION__LEFT = eINSTANCE.getOrExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPRESSION__RIGHT = eINSTANCE.getOrExpression_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.AndExpressionImpl <em>And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.AndExpressionImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getAndExpression()
     * @generated
     */
    EClass AND_EXPRESSION = eINSTANCE.getAndExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__LEFT = eINSTANCE.getAndExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__RIGHT = eINSTANCE.getAndExpression_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.NotExpressionImpl <em>Not Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.NotExpressionImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getNotExpression()
     * @generated
     */
    EClass NOT_EXPRESSION = eINSTANCE.getNotExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOT_EXPRESSION__VALUE = eINSTANCE.getNotExpression_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SkipImpl <em>Skip</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SkipImpl
     * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.SimpleAntlrPackageImpl#getSkip()
     * @generated
     */
    EClass SKIP = eINSTANCE.getSkip();

  }

} //SimpleAntlrPackage
