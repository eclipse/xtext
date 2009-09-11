/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtextUiTest;

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
 * @see org.eclipse.xtext.xtextUiTest.XtextUiTestFactory
 * @model kind="package"
 * @generated
 */
public interface XtextUiTestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "xtextUiTest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/xtext/ui/common/tests/XtextTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "xtextUiTest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XtextUiTestPackage eINSTANCE = org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.GrammarImpl <em>Grammar</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.GrammarImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getGrammar()
   * @generated
   */
  int GRAMMAR = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAMMAR__NAME = 0;

  /**
   * The feature id for the '<em><b>Used Grammars</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAMMAR__USED_GRAMMARS = 1;

  /**
   * The feature id for the '<em><b>Defines Hidden Tokens</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAMMAR__DEFINES_HIDDEN_TOKENS = 2;

  /**
   * The feature id for the '<em><b>Hidden Tokens</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAMMAR__HIDDEN_TOKENS = 3;

  /**
   * The feature id for the '<em><b>Metamodel Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAMMAR__METAMODEL_DECLARATIONS = 4;

  /**
   * The feature id for the '<em><b>Rules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAMMAR__RULES = 5;

  /**
   * The number of structural features of the '<em>Grammar</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAMMAR_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.AbstractRuleImpl <em>Abstract Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.AbstractRuleImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getAbstractRule()
   * @generated
   */
  int ABSTRACT_RULE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_RULE__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_RULE__TYPE = 1;

  /**
   * The feature id for the '<em><b>Alternatives</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_RULE__ALTERNATIVES = 2;

  /**
   * The number of structural features of the '<em>Abstract Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_RULE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.AbstractMetamodelDeclarationImpl <em>Abstract Metamodel Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.AbstractMetamodelDeclarationImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getAbstractMetamodelDeclaration()
   * @generated
   */
  int ABSTRACT_METAMODEL_DECLARATION = 2;

  /**
   * The feature id for the '<em><b>EPackage</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_METAMODEL_DECLARATION__EPACKAGE = 0;

  /**
   * The feature id for the '<em><b>Alias</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_METAMODEL_DECLARATION__ALIAS = 1;

  /**
   * The number of structural features of the '<em>Abstract Metamodel Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_METAMODEL_DECLARATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.GeneratedMetamodelImpl <em>Generated Metamodel</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.GeneratedMetamodelImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getGeneratedMetamodel()
   * @generated
   */
  int GENERATED_METAMODEL = 3;

  /**
   * The feature id for the '<em><b>EPackage</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATED_METAMODEL__EPACKAGE = ABSTRACT_METAMODEL_DECLARATION__EPACKAGE;

  /**
   * The feature id for the '<em><b>Alias</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATED_METAMODEL__ALIAS = ABSTRACT_METAMODEL_DECLARATION__ALIAS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATED_METAMODEL__NAME = ABSTRACT_METAMODEL_DECLARATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Generated Metamodel</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATED_METAMODEL_FEATURE_COUNT = ABSTRACT_METAMODEL_DECLARATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.ReferencedMetamodelImpl <em>Referenced Metamodel</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.ReferencedMetamodelImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getReferencedMetamodel()
   * @generated
   */
  int REFERENCED_METAMODEL = 4;

  /**
   * The feature id for the '<em><b>EPackage</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCED_METAMODEL__EPACKAGE = ABSTRACT_METAMODEL_DECLARATION__EPACKAGE;

  /**
   * The feature id for the '<em><b>Alias</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCED_METAMODEL__ALIAS = ABSTRACT_METAMODEL_DECLARATION__ALIAS;

  /**
   * The number of structural features of the '<em>Referenced Metamodel</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCED_METAMODEL_FEATURE_COUNT = ABSTRACT_METAMODEL_DECLARATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.ParserRuleImpl <em>Parser Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.ParserRuleImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getParserRule()
   * @generated
   */
  int PARSER_RULE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE__NAME = ABSTRACT_RULE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE__TYPE = ABSTRACT_RULE__TYPE;

  /**
   * The feature id for the '<em><b>Alternatives</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE__ALTERNATIVES = ABSTRACT_RULE__ALTERNATIVES;

  /**
   * The feature id for the '<em><b>Defines Hidden Tokens</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE__DEFINES_HIDDEN_TOKENS = ABSTRACT_RULE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Hidden Tokens</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE__HIDDEN_TOKENS = ABSTRACT_RULE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Parser Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.TypeRefImpl <em>Type Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.TypeRefImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getTypeRef()
   * @generated
   */
  int TYPE_REF = 6;

  /**
   * The feature id for the '<em><b>Metamodel</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF__METAMODEL = 0;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF__CLASSIFIER = 1;

  /**
   * The number of structural features of the '<em>Type Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.AbstractElementImpl <em>Abstract Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.AbstractElementImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getAbstractElement()
   * @generated
   */
  int ABSTRACT_ELEMENT = 7;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ELEMENT__CARDINALITY = 0;

  /**
   * The number of structural features of the '<em>Abstract Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.ActionImpl <em>Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.ActionImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getAction()
   * @generated
   */
  int ACTION = 8;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__TYPE = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__FEATURE = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__OPERATOR = ABSTRACT_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.KeywordImpl <em>Keyword</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.KeywordImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getKeyword()
   * @generated
   */
  int KEYWORD = 9;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD__VALUE = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Keyword</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.RuleCallImpl <em>Rule Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.RuleCallImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getRuleCall()
   * @generated
   */
  int RULE_CALL = 10;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALL__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Rule</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALL__RULE = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Rule Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALL_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.AssignmentImpl <em>Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.AssignmentImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getAssignment()
   * @generated
   */
  int ASSIGNMENT = 11;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__FEATURE = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__OPERATOR = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Terminal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__TERMINAL = ABSTRACT_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.CrossReferenceImpl <em>Cross Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.CrossReferenceImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getCrossReference()
   * @generated
   */
  int CROSS_REFERENCE = 12;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CROSS_REFERENCE__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CROSS_REFERENCE__TYPE = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Terminal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CROSS_REFERENCE__TERMINAL = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Cross Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CROSS_REFERENCE_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.TerminalRuleImpl <em>Terminal Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.TerminalRuleImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getTerminalRule()
   * @generated
   */
  int TERMINAL_RULE = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERMINAL_RULE__NAME = ABSTRACT_RULE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERMINAL_RULE__TYPE = ABSTRACT_RULE__TYPE;

  /**
   * The feature id for the '<em><b>Alternatives</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERMINAL_RULE__ALTERNATIVES = ABSTRACT_RULE__ALTERNATIVES;

  /**
   * The number of structural features of the '<em>Terminal Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERMINAL_RULE_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.AbstractNegatedTokenImpl <em>Abstract Negated Token</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.AbstractNegatedTokenImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getAbstractNegatedToken()
   * @generated
   */
  int ABSTRACT_NEGATED_TOKEN = 14;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NEGATED_TOKEN__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Terminal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NEGATED_TOKEN__TERMINAL = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Abstract Negated Token</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NEGATED_TOKEN_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.NegatedTokenImpl <em>Negated Token</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.NegatedTokenImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getNegatedToken()
   * @generated
   */
  int NEGATED_TOKEN = 15;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATED_TOKEN__CARDINALITY = ABSTRACT_NEGATED_TOKEN__CARDINALITY;

  /**
   * The feature id for the '<em><b>Terminal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATED_TOKEN__TERMINAL = ABSTRACT_NEGATED_TOKEN__TERMINAL;

  /**
   * The number of structural features of the '<em>Negated Token</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATED_TOKEN_FEATURE_COUNT = ABSTRACT_NEGATED_TOKEN_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.UntilTokenImpl <em>Until Token</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.UntilTokenImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getUntilToken()
   * @generated
   */
  int UNTIL_TOKEN = 16;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNTIL_TOKEN__CARDINALITY = ABSTRACT_NEGATED_TOKEN__CARDINALITY;

  /**
   * The feature id for the '<em><b>Terminal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNTIL_TOKEN__TERMINAL = ABSTRACT_NEGATED_TOKEN__TERMINAL;

  /**
   * The number of structural features of the '<em>Until Token</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNTIL_TOKEN_FEATURE_COUNT = ABSTRACT_NEGATED_TOKEN_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.WildcardImpl <em>Wildcard</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.WildcardImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getWildcard()
   * @generated
   */
  int WILDCARD = 17;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WILDCARD__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The number of structural features of the '<em>Wildcard</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WILDCARD_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.EnumRuleImpl <em>Enum Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.EnumRuleImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getEnumRule()
   * @generated
   */
  int ENUM_RULE = 18;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_RULE__NAME = ABSTRACT_RULE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_RULE__TYPE = ABSTRACT_RULE__TYPE;

  /**
   * The feature id for the '<em><b>Alternatives</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_RULE__ALTERNATIVES = ABSTRACT_RULE__ALTERNATIVES;

  /**
   * The number of structural features of the '<em>Enum Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_RULE_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.EnumLiteralDeclarationImpl <em>Enum Literal Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.EnumLiteralDeclarationImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getEnumLiteralDeclaration()
   * @generated
   */
  int ENUM_LITERAL_DECLARATION = 19;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_LITERAL_DECLARATION__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Enum Literal</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_LITERAL_DECLARATION__ENUM_LITERAL = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Literal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_LITERAL_DECLARATION__LITERAL = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Enum Literal Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_LITERAL_DECLARATION_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.AlternativesImpl <em>Alternatives</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.AlternativesImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getAlternatives()
   * @generated
   */
  int ALTERNATIVES = 20;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVES__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Groups</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVES__GROUPS = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Alternatives</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVES_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.GroupImpl <em>Group</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.GroupImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getGroup()
   * @generated
   */
  int GROUP = 21;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Tokens</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP__TOKENS = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Group</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextUiTest.impl.CharacterRangeImpl <em>Character Range</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextUiTest.impl.CharacterRangeImpl
   * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getCharacterRange()
   * @generated
   */
  int CHARACTER_RANGE = 22;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHARACTER_RANGE__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHARACTER_RANGE__LEFT = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHARACTER_RANGE__RIGHT = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Character Range</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHARACTER_RANGE_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.Grammar <em>Grammar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Grammar</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Grammar
   * @generated
   */
  EClass getGrammar();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextUiTest.Grammar#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Grammar#getName()
   * @see #getGrammar()
   * @generated
   */
  EAttribute getGrammar_Name();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.xtextUiTest.Grammar#getUsedGrammars <em>Used Grammars</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Used Grammars</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Grammar#getUsedGrammars()
   * @see #getGrammar()
   * @generated
   */
  EReference getGrammar_UsedGrammars();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextUiTest.Grammar#isDefinesHiddenTokens <em>Defines Hidden Tokens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Defines Hidden Tokens</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Grammar#isDefinesHiddenTokens()
   * @see #getGrammar()
   * @generated
   */
  EAttribute getGrammar_DefinesHiddenTokens();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.xtextUiTest.Grammar#getHiddenTokens <em>Hidden Tokens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Hidden Tokens</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Grammar#getHiddenTokens()
   * @see #getGrammar()
   * @generated
   */
  EReference getGrammar_HiddenTokens();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtextUiTest.Grammar#getMetamodelDeclarations <em>Metamodel Declarations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Metamodel Declarations</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Grammar#getMetamodelDeclarations()
   * @see #getGrammar()
   * @generated
   */
  EReference getGrammar_MetamodelDeclarations();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtextUiTest.Grammar#getRules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rules</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Grammar#getRules()
   * @see #getGrammar()
   * @generated
   */
  EReference getGrammar_Rules();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.AbstractRule <em>Abstract Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Rule</em>'.
   * @see org.eclipse.xtext.xtextUiTest.AbstractRule
   * @generated
   */
  EClass getAbstractRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextUiTest.AbstractRule#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.xtextUiTest.AbstractRule#getName()
   * @see #getAbstractRule()
   * @generated
   */
  EAttribute getAbstractRule_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextUiTest.AbstractRule#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.xtextUiTest.AbstractRule#getType()
   * @see #getAbstractRule()
   * @generated
   */
  EReference getAbstractRule_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextUiTest.AbstractRule#getAlternatives <em>Alternatives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Alternatives</em>'.
   * @see org.eclipse.xtext.xtextUiTest.AbstractRule#getAlternatives()
   * @see #getAbstractRule()
   * @generated
   */
  EReference getAbstractRule_Alternatives();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.AbstractMetamodelDeclaration <em>Abstract Metamodel Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Metamodel Declaration</em>'.
   * @see org.eclipse.xtext.xtextUiTest.AbstractMetamodelDeclaration
   * @generated
   */
  EClass getAbstractMetamodelDeclaration();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextUiTest.AbstractMetamodelDeclaration#getEPackage <em>EPackage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>EPackage</em>'.
   * @see org.eclipse.xtext.xtextUiTest.AbstractMetamodelDeclaration#getEPackage()
   * @see #getAbstractMetamodelDeclaration()
   * @generated
   */
  EReference getAbstractMetamodelDeclaration_EPackage();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextUiTest.AbstractMetamodelDeclaration#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Alias</em>'.
   * @see org.eclipse.xtext.xtextUiTest.AbstractMetamodelDeclaration#getAlias()
   * @see #getAbstractMetamodelDeclaration()
   * @generated
   */
  EAttribute getAbstractMetamodelDeclaration_Alias();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.GeneratedMetamodel <em>Generated Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Generated Metamodel</em>'.
   * @see org.eclipse.xtext.xtextUiTest.GeneratedMetamodel
   * @generated
   */
  EClass getGeneratedMetamodel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextUiTest.GeneratedMetamodel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.xtextUiTest.GeneratedMetamodel#getName()
   * @see #getGeneratedMetamodel()
   * @generated
   */
  EAttribute getGeneratedMetamodel_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.ReferencedMetamodel <em>Referenced Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Referenced Metamodel</em>'.
   * @see org.eclipse.xtext.xtextUiTest.ReferencedMetamodel
   * @generated
   */
  EClass getReferencedMetamodel();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.ParserRule <em>Parser Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parser Rule</em>'.
   * @see org.eclipse.xtext.xtextUiTest.ParserRule
   * @generated
   */
  EClass getParserRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextUiTest.ParserRule#isDefinesHiddenTokens <em>Defines Hidden Tokens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Defines Hidden Tokens</em>'.
   * @see org.eclipse.xtext.xtextUiTest.ParserRule#isDefinesHiddenTokens()
   * @see #getParserRule()
   * @generated
   */
  EAttribute getParserRule_DefinesHiddenTokens();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.xtextUiTest.ParserRule#getHiddenTokens <em>Hidden Tokens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Hidden Tokens</em>'.
   * @see org.eclipse.xtext.xtextUiTest.ParserRule#getHiddenTokens()
   * @see #getParserRule()
   * @generated
   */
  EReference getParserRule_HiddenTokens();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.TypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Ref</em>'.
   * @see org.eclipse.xtext.xtextUiTest.TypeRef
   * @generated
   */
  EClass getTypeRef();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextUiTest.TypeRef#getMetamodel <em>Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Metamodel</em>'.
   * @see org.eclipse.xtext.xtextUiTest.TypeRef#getMetamodel()
   * @see #getTypeRef()
   * @generated
   */
  EReference getTypeRef_Metamodel();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextUiTest.TypeRef#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Classifier</em>'.
   * @see org.eclipse.xtext.xtextUiTest.TypeRef#getClassifier()
   * @see #getTypeRef()
   * @generated
   */
  EReference getTypeRef_Classifier();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.AbstractElement <em>Abstract Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Element</em>'.
   * @see org.eclipse.xtext.xtextUiTest.AbstractElement
   * @generated
   */
  EClass getAbstractElement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextUiTest.AbstractElement#getCardinality <em>Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Cardinality</em>'.
   * @see org.eclipse.xtext.xtextUiTest.AbstractElement#getCardinality()
   * @see #getAbstractElement()
   * @generated
   */
  EAttribute getAbstractElement_Cardinality();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Action
   * @generated
   */
  EClass getAction();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextUiTest.Action#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Action#getType()
   * @see #getAction()
   * @generated
   */
  EReference getAction_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextUiTest.Action#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Feature</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Action#getFeature()
   * @see #getAction()
   * @generated
   */
  EAttribute getAction_Feature();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextUiTest.Action#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Action#getOperator()
   * @see #getAction()
   * @generated
   */
  EAttribute getAction_Operator();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.Keyword <em>Keyword</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Keyword</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Keyword
   * @generated
   */
  EClass getKeyword();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextUiTest.Keyword#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Keyword#getValue()
   * @see #getKeyword()
   * @generated
   */
  EAttribute getKeyword_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.RuleCall <em>Rule Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Call</em>'.
   * @see org.eclipse.xtext.xtextUiTest.RuleCall
   * @generated
   */
  EClass getRuleCall();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextUiTest.RuleCall#getRule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Rule</em>'.
   * @see org.eclipse.xtext.xtextUiTest.RuleCall#getRule()
   * @see #getRuleCall()
   * @generated
   */
  EReference getRuleCall_Rule();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Assignment
   * @generated
   */
  EClass getAssignment();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextUiTest.Assignment#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Feature</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Assignment#getFeature()
   * @see #getAssignment()
   * @generated
   */
  EAttribute getAssignment_Feature();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextUiTest.Assignment#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Assignment#getOperator()
   * @see #getAssignment()
   * @generated
   */
  EAttribute getAssignment_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextUiTest.Assignment#getTerminal <em>Terminal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Terminal</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Assignment#getTerminal()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Terminal();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.CrossReference <em>Cross Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cross Reference</em>'.
   * @see org.eclipse.xtext.xtextUiTest.CrossReference
   * @generated
   */
  EClass getCrossReference();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextUiTest.CrossReference#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.xtextUiTest.CrossReference#getType()
   * @see #getCrossReference()
   * @generated
   */
  EReference getCrossReference_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextUiTest.CrossReference#getTerminal <em>Terminal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Terminal</em>'.
   * @see org.eclipse.xtext.xtextUiTest.CrossReference#getTerminal()
   * @see #getCrossReference()
   * @generated
   */
  EReference getCrossReference_Terminal();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.TerminalRule <em>Terminal Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Terminal Rule</em>'.
   * @see org.eclipse.xtext.xtextUiTest.TerminalRule
   * @generated
   */
  EClass getTerminalRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.AbstractNegatedToken <em>Abstract Negated Token</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Negated Token</em>'.
   * @see org.eclipse.xtext.xtextUiTest.AbstractNegatedToken
   * @generated
   */
  EClass getAbstractNegatedToken();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextUiTest.AbstractNegatedToken#getTerminal <em>Terminal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Terminal</em>'.
   * @see org.eclipse.xtext.xtextUiTest.AbstractNegatedToken#getTerminal()
   * @see #getAbstractNegatedToken()
   * @generated
   */
  EReference getAbstractNegatedToken_Terminal();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.NegatedToken <em>Negated Token</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Negated Token</em>'.
   * @see org.eclipse.xtext.xtextUiTest.NegatedToken
   * @generated
   */
  EClass getNegatedToken();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.UntilToken <em>Until Token</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Until Token</em>'.
   * @see org.eclipse.xtext.xtextUiTest.UntilToken
   * @generated
   */
  EClass getUntilToken();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.Wildcard <em>Wildcard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Wildcard</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Wildcard
   * @generated
   */
  EClass getWildcard();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.EnumRule <em>Enum Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Rule</em>'.
   * @see org.eclipse.xtext.xtextUiTest.EnumRule
   * @generated
   */
  EClass getEnumRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.EnumLiteralDeclaration <em>Enum Literal Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Literal Declaration</em>'.
   * @see org.eclipse.xtext.xtextUiTest.EnumLiteralDeclaration
   * @generated
   */
  EClass getEnumLiteralDeclaration();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextUiTest.EnumLiteralDeclaration#getEnumLiteral <em>Enum Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Enum Literal</em>'.
   * @see org.eclipse.xtext.xtextUiTest.EnumLiteralDeclaration#getEnumLiteral()
   * @see #getEnumLiteralDeclaration()
   * @generated
   */
  EReference getEnumLiteralDeclaration_EnumLiteral();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextUiTest.EnumLiteralDeclaration#getLiteral <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Literal</em>'.
   * @see org.eclipse.xtext.xtextUiTest.EnumLiteralDeclaration#getLiteral()
   * @see #getEnumLiteralDeclaration()
   * @generated
   */
  EReference getEnumLiteralDeclaration_Literal();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.Alternatives <em>Alternatives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alternatives</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Alternatives
   * @generated
   */
  EClass getAlternatives();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtextUiTest.Alternatives#getGroups <em>Groups</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Groups</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Alternatives#getGroups()
   * @see #getAlternatives()
   * @generated
   */
  EReference getAlternatives_Groups();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.Group <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Group</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Group
   * @generated
   */
  EClass getGroup();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtextUiTest.Group#getTokens <em>Tokens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tokens</em>'.
   * @see org.eclipse.xtext.xtextUiTest.Group#getTokens()
   * @see #getGroup()
   * @generated
   */
  EReference getGroup_Tokens();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextUiTest.CharacterRange <em>Character Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Character Range</em>'.
   * @see org.eclipse.xtext.xtextUiTest.CharacterRange
   * @generated
   */
  EClass getCharacterRange();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextUiTest.CharacterRange#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.xtextUiTest.CharacterRange#getLeft()
   * @see #getCharacterRange()
   * @generated
   */
  EReference getCharacterRange_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextUiTest.CharacterRange#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.xtextUiTest.CharacterRange#getRight()
   * @see #getCharacterRange()
   * @generated
   */
  EReference getCharacterRange_Right();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  XtextUiTestFactory getXtextUiTestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.GrammarImpl <em>Grammar</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.GrammarImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getGrammar()
     * @generated
     */
    EClass GRAMMAR = eINSTANCE.getGrammar();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GRAMMAR__NAME = eINSTANCE.getGrammar_Name();

    /**
     * The meta object literal for the '<em><b>Used Grammars</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GRAMMAR__USED_GRAMMARS = eINSTANCE.getGrammar_UsedGrammars();

    /**
     * The meta object literal for the '<em><b>Defines Hidden Tokens</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GRAMMAR__DEFINES_HIDDEN_TOKENS = eINSTANCE.getGrammar_DefinesHiddenTokens();

    /**
     * The meta object literal for the '<em><b>Hidden Tokens</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GRAMMAR__HIDDEN_TOKENS = eINSTANCE.getGrammar_HiddenTokens();

    /**
     * The meta object literal for the '<em><b>Metamodel Declarations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GRAMMAR__METAMODEL_DECLARATIONS = eINSTANCE.getGrammar_MetamodelDeclarations();

    /**
     * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GRAMMAR__RULES = eINSTANCE.getGrammar_Rules();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.AbstractRuleImpl <em>Abstract Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.AbstractRuleImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getAbstractRule()
     * @generated
     */
    EClass ABSTRACT_RULE = eINSTANCE.getAbstractRule();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_RULE__NAME = eINSTANCE.getAbstractRule_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_RULE__TYPE = eINSTANCE.getAbstractRule_Type();

    /**
     * The meta object literal for the '<em><b>Alternatives</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_RULE__ALTERNATIVES = eINSTANCE.getAbstractRule_Alternatives();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.AbstractMetamodelDeclarationImpl <em>Abstract Metamodel Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.AbstractMetamodelDeclarationImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getAbstractMetamodelDeclaration()
     * @generated
     */
    EClass ABSTRACT_METAMODEL_DECLARATION = eINSTANCE.getAbstractMetamodelDeclaration();

    /**
     * The meta object literal for the '<em><b>EPackage</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_METAMODEL_DECLARATION__EPACKAGE = eINSTANCE.getAbstractMetamodelDeclaration_EPackage();

    /**
     * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_METAMODEL_DECLARATION__ALIAS = eINSTANCE.getAbstractMetamodelDeclaration_Alias();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.GeneratedMetamodelImpl <em>Generated Metamodel</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.GeneratedMetamodelImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getGeneratedMetamodel()
     * @generated
     */
    EClass GENERATED_METAMODEL = eINSTANCE.getGeneratedMetamodel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GENERATED_METAMODEL__NAME = eINSTANCE.getGeneratedMetamodel_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.ReferencedMetamodelImpl <em>Referenced Metamodel</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.ReferencedMetamodelImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getReferencedMetamodel()
     * @generated
     */
    EClass REFERENCED_METAMODEL = eINSTANCE.getReferencedMetamodel();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.ParserRuleImpl <em>Parser Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.ParserRuleImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getParserRule()
     * @generated
     */
    EClass PARSER_RULE = eINSTANCE.getParserRule();

    /**
     * The meta object literal for the '<em><b>Defines Hidden Tokens</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARSER_RULE__DEFINES_HIDDEN_TOKENS = eINSTANCE.getParserRule_DefinesHiddenTokens();

    /**
     * The meta object literal for the '<em><b>Hidden Tokens</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARSER_RULE__HIDDEN_TOKENS = eINSTANCE.getParserRule_HiddenTokens();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.TypeRefImpl <em>Type Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.TypeRefImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getTypeRef()
     * @generated
     */
    EClass TYPE_REF = eINSTANCE.getTypeRef();

    /**
     * The meta object literal for the '<em><b>Metamodel</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_REF__METAMODEL = eINSTANCE.getTypeRef_Metamodel();

    /**
     * The meta object literal for the '<em><b>Classifier</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_REF__CLASSIFIER = eINSTANCE.getTypeRef_Classifier();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.AbstractElementImpl <em>Abstract Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.AbstractElementImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getAbstractElement()
     * @generated
     */
    EClass ABSTRACT_ELEMENT = eINSTANCE.getAbstractElement();

    /**
     * The meta object literal for the '<em><b>Cardinality</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_ELEMENT__CARDINALITY = eINSTANCE.getAbstractElement_Cardinality();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.ActionImpl <em>Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.ActionImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getAction()
     * @generated
     */
    EClass ACTION = eINSTANCE.getAction();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTION__TYPE = eINSTANCE.getAction_Type();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTION__FEATURE = eINSTANCE.getAction_Feature();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTION__OPERATOR = eINSTANCE.getAction_Operator();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.KeywordImpl <em>Keyword</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.KeywordImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getKeyword()
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
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.RuleCallImpl <em>Rule Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.RuleCallImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getRuleCall()
     * @generated
     */
    EClass RULE_CALL = eINSTANCE.getRuleCall();

    /**
     * The meta object literal for the '<em><b>Rule</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_CALL__RULE = eINSTANCE.getRuleCall_Rule();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.AssignmentImpl <em>Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.AssignmentImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getAssignment()
     * @generated
     */
    EClass ASSIGNMENT = eINSTANCE.getAssignment();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT__FEATURE = eINSTANCE.getAssignment_Feature();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT__OPERATOR = eINSTANCE.getAssignment_Operator();

    /**
     * The meta object literal for the '<em><b>Terminal</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__TERMINAL = eINSTANCE.getAssignment_Terminal();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.CrossReferenceImpl <em>Cross Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.CrossReferenceImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getCrossReference()
     * @generated
     */
    EClass CROSS_REFERENCE = eINSTANCE.getCrossReference();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CROSS_REFERENCE__TYPE = eINSTANCE.getCrossReference_Type();

    /**
     * The meta object literal for the '<em><b>Terminal</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CROSS_REFERENCE__TERMINAL = eINSTANCE.getCrossReference_Terminal();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.TerminalRuleImpl <em>Terminal Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.TerminalRuleImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getTerminalRule()
     * @generated
     */
    EClass TERMINAL_RULE = eINSTANCE.getTerminalRule();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.AbstractNegatedTokenImpl <em>Abstract Negated Token</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.AbstractNegatedTokenImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getAbstractNegatedToken()
     * @generated
     */
    EClass ABSTRACT_NEGATED_TOKEN = eINSTANCE.getAbstractNegatedToken();

    /**
     * The meta object literal for the '<em><b>Terminal</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_NEGATED_TOKEN__TERMINAL = eINSTANCE.getAbstractNegatedToken_Terminal();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.NegatedTokenImpl <em>Negated Token</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.NegatedTokenImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getNegatedToken()
     * @generated
     */
    EClass NEGATED_TOKEN = eINSTANCE.getNegatedToken();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.UntilTokenImpl <em>Until Token</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.UntilTokenImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getUntilToken()
     * @generated
     */
    EClass UNTIL_TOKEN = eINSTANCE.getUntilToken();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.WildcardImpl <em>Wildcard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.WildcardImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getWildcard()
     * @generated
     */
    EClass WILDCARD = eINSTANCE.getWildcard();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.EnumRuleImpl <em>Enum Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.EnumRuleImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getEnumRule()
     * @generated
     */
    EClass ENUM_RULE = eINSTANCE.getEnumRule();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.EnumLiteralDeclarationImpl <em>Enum Literal Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.EnumLiteralDeclarationImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getEnumLiteralDeclaration()
     * @generated
     */
    EClass ENUM_LITERAL_DECLARATION = eINSTANCE.getEnumLiteralDeclaration();

    /**
     * The meta object literal for the '<em><b>Enum Literal</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_LITERAL_DECLARATION__ENUM_LITERAL = eINSTANCE.getEnumLiteralDeclaration_EnumLiteral();

    /**
     * The meta object literal for the '<em><b>Literal</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_LITERAL_DECLARATION__LITERAL = eINSTANCE.getEnumLiteralDeclaration_Literal();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.AlternativesImpl <em>Alternatives</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.AlternativesImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getAlternatives()
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
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.GroupImpl <em>Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.GroupImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getGroup()
     * @generated
     */
    EClass GROUP = eINSTANCE.getGroup();

    /**
     * The meta object literal for the '<em><b>Tokens</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GROUP__TOKENS = eINSTANCE.getGroup_Tokens();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextUiTest.impl.CharacterRangeImpl <em>Character Range</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextUiTest.impl.CharacterRangeImpl
     * @see org.eclipse.xtext.xtextUiTest.impl.XtextUiTestPackageImpl#getCharacterRange()
     * @generated
     */
    EClass CHARACTER_RANGE = eINSTANCE.getCharacterRange();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHARACTER_RANGE__LEFT = eINSTANCE.getCharacterRange_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHARACTER_RANGE__RIGHT = eINSTANCE.getCharacterRange_Right();

  }

} //XtextUiTestPackage
