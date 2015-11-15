/**
 */
package org.eclipse.xtext.xtextTest;

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
 * @see org.eclipse.xtext.xtextTest.XtextTestFactory
 * @model kind="package"
 * @generated
 */
public interface XtextTestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "xtextTest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/Test/XtextTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "xtextTest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XtextTestPackage eINSTANCE = org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.GrammarImpl <em>Grammar</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.GrammarImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getGrammar()
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
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.AbstractRuleImpl <em>Abstract Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.AbstractRuleImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getAbstractRule()
   * @generated
   */
  int ABSTRACT_RULE = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_RULE__TYPE = 0;

  /**
   * The feature id for the '<em><b>Alternatives</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_RULE__ALTERNATIVES = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_RULE__NAME = 2;

  /**
   * The number of structural features of the '<em>Abstract Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_RULE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.AbstractMetamodelDeclarationImpl <em>Abstract Metamodel Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.AbstractMetamodelDeclarationImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getAbstractMetamodelDeclaration()
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
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.GeneratedMetamodelImpl <em>Generated Metamodel</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.GeneratedMetamodelImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getGeneratedMetamodel()
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
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.ReferencedMetamodelImpl <em>Referenced Metamodel</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.ReferencedMetamodelImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getReferencedMetamodel()
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
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.ParserRuleImpl <em>Parser Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.ParserRuleImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getParserRule()
   * @generated
   */
  int PARSER_RULE = 5;

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
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE__NAME = ABSTRACT_RULE__NAME;

  /**
   * The feature id for the '<em><b>Fragment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE__FRAGMENT = ABSTRACT_RULE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Wildcard</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE__WILDCARD = ABSTRACT_RULE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Defines Hidden Tokens</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE__DEFINES_HIDDEN_TOKENS = ABSTRACT_RULE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Hidden Tokens</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE__HIDDEN_TOKENS = ABSTRACT_RULE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE__PARAMETERS = ABSTRACT_RULE_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Parser Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.ParameterImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__NAME = 0;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.TypeRefImpl <em>Type Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.TypeRefImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getTypeRef()
   * @generated
   */
  int TYPE_REF = 7;

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
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.AbstractElementImpl <em>Abstract Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.AbstractElementImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getAbstractElement()
   * @generated
   */
  int ABSTRACT_ELEMENT = 8;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ELEMENT__CARDINALITY = 0;

  /**
   * The feature id for the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ELEMENT__PREDICATED = 1;

  /**
   * The feature id for the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ELEMENT__FIRST_SET_PREDICATED = 2;

  /**
   * The number of structural features of the '<em>Abstract Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ELEMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.ActionImpl <em>Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.ActionImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getAction()
   * @generated
   */
  int ACTION = 9;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__PREDICATED = ABSTRACT_ELEMENT__PREDICATED;

  /**
   * The feature id for the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__FIRST_SET_PREDICATED = ABSTRACT_ELEMENT__FIRST_SET_PREDICATED;

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
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.KeywordImpl <em>Keyword</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.KeywordImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getKeyword()
   * @generated
   */
  int KEYWORD = 10;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD__PREDICATED = ABSTRACT_ELEMENT__PREDICATED;

  /**
   * The feature id for the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD__FIRST_SET_PREDICATED = ABSTRACT_ELEMENT__FIRST_SET_PREDICATED;

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
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.RuleCallImpl <em>Rule Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.RuleCallImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getRuleCall()
   * @generated
   */
  int RULE_CALL = 11;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALL__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALL__PREDICATED = ABSTRACT_ELEMENT__PREDICATED;

  /**
   * The feature id for the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALL__FIRST_SET_PREDICATED = ABSTRACT_ELEMENT__FIRST_SET_PREDICATED;

  /**
   * The feature id for the '<em><b>Rule</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALL__RULE = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALL__ARGUMENTS = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Rule Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CALL_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.NamedArgumentImpl <em>Named Argument</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.NamedArgumentImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getNamedArgument()
   * @generated
   */
  int NAMED_ARGUMENT = 12;

  /**
   * The feature id for the '<em><b>Literal Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ARGUMENT__LITERAL_VALUE = 0;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ARGUMENT__PARAMETER = 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ARGUMENT__VALUE = 2;

  /**
   * The number of structural features of the '<em>Named Argument</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ARGUMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.AssignmentImpl <em>Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.AssignmentImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getAssignment()
   * @generated
   */
  int ASSIGNMENT = 13;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__PREDICATED = ABSTRACT_ELEMENT__PREDICATED;

  /**
   * The feature id for the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__FIRST_SET_PREDICATED = ABSTRACT_ELEMENT__FIRST_SET_PREDICATED;

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
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.CrossReferenceImpl <em>Cross Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.CrossReferenceImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getCrossReference()
   * @generated
   */
  int CROSS_REFERENCE = 14;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CROSS_REFERENCE__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CROSS_REFERENCE__PREDICATED = ABSTRACT_ELEMENT__PREDICATED;

  /**
   * The feature id for the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CROSS_REFERENCE__FIRST_SET_PREDICATED = ABSTRACT_ELEMENT__FIRST_SET_PREDICATED;

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
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.GroupImpl <em>Group</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.GroupImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getGroup()
   * @generated
   */
  int GROUP = 15;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP__PREDICATED = ABSTRACT_ELEMENT__PREDICATED;

  /**
   * The feature id for the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP__FIRST_SET_PREDICATED = ABSTRACT_ELEMENT__FIRST_SET_PREDICATED;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP__ELEMENTS = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Group</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.TerminalRuleImpl <em>Terminal Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.TerminalRuleImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getTerminalRule()
   * @generated
   */
  int TERMINAL_RULE = 16;

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
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERMINAL_RULE__NAME = ABSTRACT_RULE__NAME;

  /**
   * The feature id for the '<em><b>Fragment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERMINAL_RULE__FRAGMENT = ABSTRACT_RULE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Terminal Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERMINAL_RULE_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.AbstractNegatedTokenImpl <em>Abstract Negated Token</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.AbstractNegatedTokenImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getAbstractNegatedToken()
   * @generated
   */
  int ABSTRACT_NEGATED_TOKEN = 17;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NEGATED_TOKEN__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NEGATED_TOKEN__PREDICATED = ABSTRACT_ELEMENT__PREDICATED;

  /**
   * The feature id for the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NEGATED_TOKEN__FIRST_SET_PREDICATED = ABSTRACT_ELEMENT__FIRST_SET_PREDICATED;

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
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.NegatedTokenImpl <em>Negated Token</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.NegatedTokenImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getNegatedToken()
   * @generated
   */
  int NEGATED_TOKEN = 18;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATED_TOKEN__CARDINALITY = ABSTRACT_NEGATED_TOKEN__CARDINALITY;

  /**
   * The feature id for the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATED_TOKEN__PREDICATED = ABSTRACT_NEGATED_TOKEN__PREDICATED;

  /**
   * The feature id for the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATED_TOKEN__FIRST_SET_PREDICATED = ABSTRACT_NEGATED_TOKEN__FIRST_SET_PREDICATED;

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
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.UntilTokenImpl <em>Until Token</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.UntilTokenImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getUntilToken()
   * @generated
   */
  int UNTIL_TOKEN = 19;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNTIL_TOKEN__CARDINALITY = ABSTRACT_NEGATED_TOKEN__CARDINALITY;

  /**
   * The feature id for the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNTIL_TOKEN__PREDICATED = ABSTRACT_NEGATED_TOKEN__PREDICATED;

  /**
   * The feature id for the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNTIL_TOKEN__FIRST_SET_PREDICATED = ABSTRACT_NEGATED_TOKEN__FIRST_SET_PREDICATED;

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
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.WildcardImpl <em>Wildcard</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.WildcardImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getWildcard()
   * @generated
   */
  int WILDCARD = 20;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WILDCARD__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WILDCARD__PREDICATED = ABSTRACT_ELEMENT__PREDICATED;

  /**
   * The feature id for the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WILDCARD__FIRST_SET_PREDICATED = ABSTRACT_ELEMENT__FIRST_SET_PREDICATED;

  /**
   * The number of structural features of the '<em>Wildcard</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WILDCARD_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.EOFImpl <em>EOF</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.EOFImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getEOF()
   * @generated
   */
  int EOF = 21;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOF__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOF__PREDICATED = ABSTRACT_ELEMENT__PREDICATED;

  /**
   * The feature id for the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOF__FIRST_SET_PREDICATED = ABSTRACT_ELEMENT__FIRST_SET_PREDICATED;

  /**
   * The number of structural features of the '<em>EOF</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOF_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.EnumRuleImpl <em>Enum Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.EnumRuleImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getEnumRule()
   * @generated
   */
  int ENUM_RULE = 22;

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
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_RULE__NAME = ABSTRACT_RULE__NAME;

  /**
   * The number of structural features of the '<em>Enum Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_RULE_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.EnumLiteralDeclarationImpl <em>Enum Literal Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.EnumLiteralDeclarationImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getEnumLiteralDeclaration()
   * @generated
   */
  int ENUM_LITERAL_DECLARATION = 23;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_LITERAL_DECLARATION__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_LITERAL_DECLARATION__PREDICATED = ABSTRACT_ELEMENT__PREDICATED;

  /**
   * The feature id for the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_LITERAL_DECLARATION__FIRST_SET_PREDICATED = ABSTRACT_ELEMENT__FIRST_SET_PREDICATED;

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
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.AlternativesImpl <em>Alternatives</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.AlternativesImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getAlternatives()
   * @generated
   */
  int ALTERNATIVES = 24;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVES__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVES__PREDICATED = ABSTRACT_ELEMENT__PREDICATED;

  /**
   * The feature id for the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVES__FIRST_SET_PREDICATED = ABSTRACT_ELEMENT__FIRST_SET_PREDICATED;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVES__ELEMENTS = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Alternatives</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVES_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.ConditionalBranchImpl <em>Conditional Branch</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.ConditionalBranchImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getConditionalBranch()
   * @generated
   */
  int CONDITIONAL_BRANCH = 25;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_BRANCH__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_BRANCH__PREDICATED = ABSTRACT_ELEMENT__PREDICATED;

  /**
   * The feature id for the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_BRANCH__FIRST_SET_PREDICATED = ABSTRACT_ELEMENT__FIRST_SET_PREDICATED;

  /**
   * The feature id for the '<em><b>Filtered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_BRANCH__FILTERED = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_BRANCH__PARAMETER = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Guarded Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_BRANCH__GUARDED_ELEMENT = ABSTRACT_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Conditional Branch</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_BRANCH_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.UnorderedGroupImpl <em>Unordered Group</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.UnorderedGroupImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getUnorderedGroup()
   * @generated
   */
  int UNORDERED_GROUP = 26;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNORDERED_GROUP__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNORDERED_GROUP__PREDICATED = ABSTRACT_ELEMENT__PREDICATED;

  /**
   * The feature id for the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNORDERED_GROUP__FIRST_SET_PREDICATED = ABSTRACT_ELEMENT__FIRST_SET_PREDICATED;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNORDERED_GROUP__ELEMENTS = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Unordered Group</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNORDERED_GROUP_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextTest.impl.CharacterRangeImpl <em>Character Range</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextTest.impl.CharacterRangeImpl
   * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getCharacterRange()
   * @generated
   */
  int CHARACTER_RANGE = 27;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHARACTER_RANGE__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

  /**
   * The feature id for the '<em><b>Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHARACTER_RANGE__PREDICATED = ABSTRACT_ELEMENT__PREDICATED;

  /**
   * The feature id for the '<em><b>First Set Predicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHARACTER_RANGE__FIRST_SET_PREDICATED = ABSTRACT_ELEMENT__FIRST_SET_PREDICATED;

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
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.Grammar <em>Grammar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Grammar</em>'.
   * @see org.eclipse.xtext.xtextTest.Grammar
   * @generated
   */
  EClass getGrammar();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.Grammar#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.xtextTest.Grammar#getName()
   * @see #getGrammar()
   * @generated
   */
  EAttribute getGrammar_Name();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.xtextTest.Grammar#getUsedGrammars <em>Used Grammars</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Used Grammars</em>'.
   * @see org.eclipse.xtext.xtextTest.Grammar#getUsedGrammars()
   * @see #getGrammar()
   * @generated
   */
  EReference getGrammar_UsedGrammars();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.Grammar#isDefinesHiddenTokens <em>Defines Hidden Tokens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Defines Hidden Tokens</em>'.
   * @see org.eclipse.xtext.xtextTest.Grammar#isDefinesHiddenTokens()
   * @see #getGrammar()
   * @generated
   */
  EAttribute getGrammar_DefinesHiddenTokens();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.xtextTest.Grammar#getHiddenTokens <em>Hidden Tokens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Hidden Tokens</em>'.
   * @see org.eclipse.xtext.xtextTest.Grammar#getHiddenTokens()
   * @see #getGrammar()
   * @generated
   */
  EReference getGrammar_HiddenTokens();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtextTest.Grammar#getMetamodelDeclarations <em>Metamodel Declarations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Metamodel Declarations</em>'.
   * @see org.eclipse.xtext.xtextTest.Grammar#getMetamodelDeclarations()
   * @see #getGrammar()
   * @generated
   */
  EReference getGrammar_MetamodelDeclarations();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtextTest.Grammar#getRules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rules</em>'.
   * @see org.eclipse.xtext.xtextTest.Grammar#getRules()
   * @see #getGrammar()
   * @generated
   */
  EReference getGrammar_Rules();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.AbstractRule <em>Abstract Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Rule</em>'.
   * @see org.eclipse.xtext.xtextTest.AbstractRule
   * @generated
   */
  EClass getAbstractRule();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextTest.AbstractRule#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.xtextTest.AbstractRule#getType()
   * @see #getAbstractRule()
   * @generated
   */
  EReference getAbstractRule_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextTest.AbstractRule#getAlternatives <em>Alternatives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Alternatives</em>'.
   * @see org.eclipse.xtext.xtextTest.AbstractRule#getAlternatives()
   * @see #getAbstractRule()
   * @generated
   */
  EReference getAbstractRule_Alternatives();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.AbstractRule#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.xtextTest.AbstractRule#getName()
   * @see #getAbstractRule()
   * @generated
   */
  EAttribute getAbstractRule_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.AbstractMetamodelDeclaration <em>Abstract Metamodel Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Metamodel Declaration</em>'.
   * @see org.eclipse.xtext.xtextTest.AbstractMetamodelDeclaration
   * @generated
   */
  EClass getAbstractMetamodelDeclaration();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextTest.AbstractMetamodelDeclaration#getEPackage <em>EPackage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>EPackage</em>'.
   * @see org.eclipse.xtext.xtextTest.AbstractMetamodelDeclaration#getEPackage()
   * @see #getAbstractMetamodelDeclaration()
   * @generated
   */
  EReference getAbstractMetamodelDeclaration_EPackage();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.AbstractMetamodelDeclaration#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Alias</em>'.
   * @see org.eclipse.xtext.xtextTest.AbstractMetamodelDeclaration#getAlias()
   * @see #getAbstractMetamodelDeclaration()
   * @generated
   */
  EAttribute getAbstractMetamodelDeclaration_Alias();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.GeneratedMetamodel <em>Generated Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Generated Metamodel</em>'.
   * @see org.eclipse.xtext.xtextTest.GeneratedMetamodel
   * @generated
   */
  EClass getGeneratedMetamodel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.GeneratedMetamodel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.xtextTest.GeneratedMetamodel#getName()
   * @see #getGeneratedMetamodel()
   * @generated
   */
  EAttribute getGeneratedMetamodel_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.ReferencedMetamodel <em>Referenced Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Referenced Metamodel</em>'.
   * @see org.eclipse.xtext.xtextTest.ReferencedMetamodel
   * @generated
   */
  EClass getReferencedMetamodel();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.ParserRule <em>Parser Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parser Rule</em>'.
   * @see org.eclipse.xtext.xtextTest.ParserRule
   * @generated
   */
  EClass getParserRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.ParserRule#isFragment <em>Fragment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fragment</em>'.
   * @see org.eclipse.xtext.xtextTest.ParserRule#isFragment()
   * @see #getParserRule()
   * @generated
   */
  EAttribute getParserRule_Fragment();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.ParserRule#isWildcard <em>Wildcard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Wildcard</em>'.
   * @see org.eclipse.xtext.xtextTest.ParserRule#isWildcard()
   * @see #getParserRule()
   * @generated
   */
  EAttribute getParserRule_Wildcard();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.ParserRule#isDefinesHiddenTokens <em>Defines Hidden Tokens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Defines Hidden Tokens</em>'.
   * @see org.eclipse.xtext.xtextTest.ParserRule#isDefinesHiddenTokens()
   * @see #getParserRule()
   * @generated
   */
  EAttribute getParserRule_DefinesHiddenTokens();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.xtextTest.ParserRule#getHiddenTokens <em>Hidden Tokens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Hidden Tokens</em>'.
   * @see org.eclipse.xtext.xtextTest.ParserRule#getHiddenTokens()
   * @see #getParserRule()
   * @generated
   */
  EReference getParserRule_HiddenTokens();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtextTest.ParserRule#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.eclipse.xtext.xtextTest.ParserRule#getParameters()
   * @see #getParserRule()
   * @generated
   */
  EReference getParserRule_Parameters();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see org.eclipse.xtext.xtextTest.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.Parameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.xtextTest.Parameter#getName()
   * @see #getParameter()
   * @generated
   */
  EAttribute getParameter_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.TypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Ref</em>'.
   * @see org.eclipse.xtext.xtextTest.TypeRef
   * @generated
   */
  EClass getTypeRef();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextTest.TypeRef#getMetamodel <em>Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Metamodel</em>'.
   * @see org.eclipse.xtext.xtextTest.TypeRef#getMetamodel()
   * @see #getTypeRef()
   * @generated
   */
  EReference getTypeRef_Metamodel();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextTest.TypeRef#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Classifier</em>'.
   * @see org.eclipse.xtext.xtextTest.TypeRef#getClassifier()
   * @see #getTypeRef()
   * @generated
   */
  EReference getTypeRef_Classifier();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.AbstractElement <em>Abstract Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Element</em>'.
   * @see org.eclipse.xtext.xtextTest.AbstractElement
   * @generated
   */
  EClass getAbstractElement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.AbstractElement#getCardinality <em>Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Cardinality</em>'.
   * @see org.eclipse.xtext.xtextTest.AbstractElement#getCardinality()
   * @see #getAbstractElement()
   * @generated
   */
  EAttribute getAbstractElement_Cardinality();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.AbstractElement#isPredicated <em>Predicated</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Predicated</em>'.
   * @see org.eclipse.xtext.xtextTest.AbstractElement#isPredicated()
   * @see #getAbstractElement()
   * @generated
   */
  EAttribute getAbstractElement_Predicated();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.AbstractElement#isFirstSetPredicated <em>First Set Predicated</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>First Set Predicated</em>'.
   * @see org.eclipse.xtext.xtextTest.AbstractElement#isFirstSetPredicated()
   * @see #getAbstractElement()
   * @generated
   */
  EAttribute getAbstractElement_FirstSetPredicated();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action</em>'.
   * @see org.eclipse.xtext.xtextTest.Action
   * @generated
   */
  EClass getAction();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextTest.Action#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.xtextTest.Action#getType()
   * @see #getAction()
   * @generated
   */
  EReference getAction_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.Action#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Feature</em>'.
   * @see org.eclipse.xtext.xtextTest.Action#getFeature()
   * @see #getAction()
   * @generated
   */
  EAttribute getAction_Feature();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.Action#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.xtext.xtextTest.Action#getOperator()
   * @see #getAction()
   * @generated
   */
  EAttribute getAction_Operator();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.Keyword <em>Keyword</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Keyword</em>'.
   * @see org.eclipse.xtext.xtextTest.Keyword
   * @generated
   */
  EClass getKeyword();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.Keyword#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.xtextTest.Keyword#getValue()
   * @see #getKeyword()
   * @generated
   */
  EAttribute getKeyword_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.RuleCall <em>Rule Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Call</em>'.
   * @see org.eclipse.xtext.xtextTest.RuleCall
   * @generated
   */
  EClass getRuleCall();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextTest.RuleCall#getRule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Rule</em>'.
   * @see org.eclipse.xtext.xtextTest.RuleCall#getRule()
   * @see #getRuleCall()
   * @generated
   */
  EReference getRuleCall_Rule();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtextTest.RuleCall#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arguments</em>'.
   * @see org.eclipse.xtext.xtextTest.RuleCall#getArguments()
   * @see #getRuleCall()
   * @generated
   */
  EReference getRuleCall_Arguments();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.NamedArgument <em>Named Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Argument</em>'.
   * @see org.eclipse.xtext.xtextTest.NamedArgument
   * @generated
   */
  EClass getNamedArgument();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.NamedArgument#isLiteralValue <em>Literal Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Literal Value</em>'.
   * @see org.eclipse.xtext.xtextTest.NamedArgument#isLiteralValue()
   * @see #getNamedArgument()
   * @generated
   */
  EAttribute getNamedArgument_LiteralValue();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextTest.NamedArgument#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Parameter</em>'.
   * @see org.eclipse.xtext.xtextTest.NamedArgument#getParameter()
   * @see #getNamedArgument()
   * @generated
   */
  EReference getNamedArgument_Parameter();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextTest.NamedArgument#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see org.eclipse.xtext.xtextTest.NamedArgument#getValue()
   * @see #getNamedArgument()
   * @generated
   */
  EReference getNamedArgument_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment</em>'.
   * @see org.eclipse.xtext.xtextTest.Assignment
   * @generated
   */
  EClass getAssignment();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.Assignment#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Feature</em>'.
   * @see org.eclipse.xtext.xtextTest.Assignment#getFeature()
   * @see #getAssignment()
   * @generated
   */
  EAttribute getAssignment_Feature();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.Assignment#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.xtext.xtextTest.Assignment#getOperator()
   * @see #getAssignment()
   * @generated
   */
  EAttribute getAssignment_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextTest.Assignment#getTerminal <em>Terminal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Terminal</em>'.
   * @see org.eclipse.xtext.xtextTest.Assignment#getTerminal()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Terminal();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.CrossReference <em>Cross Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cross Reference</em>'.
   * @see org.eclipse.xtext.xtextTest.CrossReference
   * @generated
   */
  EClass getCrossReference();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextTest.CrossReference#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.xtextTest.CrossReference#getType()
   * @see #getCrossReference()
   * @generated
   */
  EReference getCrossReference_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextTest.CrossReference#getTerminal <em>Terminal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Terminal</em>'.
   * @see org.eclipse.xtext.xtextTest.CrossReference#getTerminal()
   * @see #getCrossReference()
   * @generated
   */
  EReference getCrossReference_Terminal();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.Group <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Group</em>'.
   * @see org.eclipse.xtext.xtextTest.Group
   * @generated
   */
  EClass getGroup();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtextTest.Group#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipse.xtext.xtextTest.Group#getElements()
   * @see #getGroup()
   * @generated
   */
  EReference getGroup_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.TerminalRule <em>Terminal Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Terminal Rule</em>'.
   * @see org.eclipse.xtext.xtextTest.TerminalRule
   * @generated
   */
  EClass getTerminalRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.TerminalRule#isFragment <em>Fragment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fragment</em>'.
   * @see org.eclipse.xtext.xtextTest.TerminalRule#isFragment()
   * @see #getTerminalRule()
   * @generated
   */
  EAttribute getTerminalRule_Fragment();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.AbstractNegatedToken <em>Abstract Negated Token</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Negated Token</em>'.
   * @see org.eclipse.xtext.xtextTest.AbstractNegatedToken
   * @generated
   */
  EClass getAbstractNegatedToken();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextTest.AbstractNegatedToken#getTerminal <em>Terminal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Terminal</em>'.
   * @see org.eclipse.xtext.xtextTest.AbstractNegatedToken#getTerminal()
   * @see #getAbstractNegatedToken()
   * @generated
   */
  EReference getAbstractNegatedToken_Terminal();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.NegatedToken <em>Negated Token</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Negated Token</em>'.
   * @see org.eclipse.xtext.xtextTest.NegatedToken
   * @generated
   */
  EClass getNegatedToken();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.UntilToken <em>Until Token</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Until Token</em>'.
   * @see org.eclipse.xtext.xtextTest.UntilToken
   * @generated
   */
  EClass getUntilToken();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.Wildcard <em>Wildcard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Wildcard</em>'.
   * @see org.eclipse.xtext.xtextTest.Wildcard
   * @generated
   */
  EClass getWildcard();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.EOF <em>EOF</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EOF</em>'.
   * @see org.eclipse.xtext.xtextTest.EOF
   * @generated
   */
  EClass getEOF();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.EnumRule <em>Enum Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Rule</em>'.
   * @see org.eclipse.xtext.xtextTest.EnumRule
   * @generated
   */
  EClass getEnumRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.EnumLiteralDeclaration <em>Enum Literal Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Literal Declaration</em>'.
   * @see org.eclipse.xtext.xtextTest.EnumLiteralDeclaration
   * @generated
   */
  EClass getEnumLiteralDeclaration();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextTest.EnumLiteralDeclaration#getEnumLiteral <em>Enum Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Enum Literal</em>'.
   * @see org.eclipse.xtext.xtextTest.EnumLiteralDeclaration#getEnumLiteral()
   * @see #getEnumLiteralDeclaration()
   * @generated
   */
  EReference getEnumLiteralDeclaration_EnumLiteral();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextTest.EnumLiteralDeclaration#getLiteral <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Literal</em>'.
   * @see org.eclipse.xtext.xtextTest.EnumLiteralDeclaration#getLiteral()
   * @see #getEnumLiteralDeclaration()
   * @generated
   */
  EReference getEnumLiteralDeclaration_Literal();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.Alternatives <em>Alternatives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alternatives</em>'.
   * @see org.eclipse.xtext.xtextTest.Alternatives
   * @generated
   */
  EClass getAlternatives();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtextTest.Alternatives#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipse.xtext.xtextTest.Alternatives#getElements()
   * @see #getAlternatives()
   * @generated
   */
  EReference getAlternatives_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.ConditionalBranch <em>Conditional Branch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Branch</em>'.
   * @see org.eclipse.xtext.xtextTest.ConditionalBranch
   * @generated
   */
  EClass getConditionalBranch();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextTest.ConditionalBranch#isFiltered <em>Filtered</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Filtered</em>'.
   * @see org.eclipse.xtext.xtextTest.ConditionalBranch#isFiltered()
   * @see #getConditionalBranch()
   * @generated
   */
  EAttribute getConditionalBranch_Filtered();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextTest.ConditionalBranch#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Parameter</em>'.
   * @see org.eclipse.xtext.xtextTest.ConditionalBranch#getParameter()
   * @see #getConditionalBranch()
   * @generated
   */
  EReference getConditionalBranch_Parameter();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextTest.ConditionalBranch#getGuardedElement <em>Guarded Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guarded Element</em>'.
   * @see org.eclipse.xtext.xtextTest.ConditionalBranch#getGuardedElement()
   * @see #getConditionalBranch()
   * @generated
   */
  EReference getConditionalBranch_GuardedElement();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.UnorderedGroup <em>Unordered Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unordered Group</em>'.
   * @see org.eclipse.xtext.xtextTest.UnorderedGroup
   * @generated
   */
  EClass getUnorderedGroup();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtextTest.UnorderedGroup#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipse.xtext.xtextTest.UnorderedGroup#getElements()
   * @see #getUnorderedGroup()
   * @generated
   */
  EReference getUnorderedGroup_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextTest.CharacterRange <em>Character Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Character Range</em>'.
   * @see org.eclipse.xtext.xtextTest.CharacterRange
   * @generated
   */
  EClass getCharacterRange();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextTest.CharacterRange#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.xtextTest.CharacterRange#getLeft()
   * @see #getCharacterRange()
   * @generated
   */
  EReference getCharacterRange_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtextTest.CharacterRange#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.xtextTest.CharacterRange#getRight()
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
  XtextTestFactory getXtextTestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.GrammarImpl <em>Grammar</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.GrammarImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getGrammar()
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
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.AbstractRuleImpl <em>Abstract Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.AbstractRuleImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getAbstractRule()
     * @generated
     */
    EClass ABSTRACT_RULE = eINSTANCE.getAbstractRule();

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
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_RULE__NAME = eINSTANCE.getAbstractRule_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.AbstractMetamodelDeclarationImpl <em>Abstract Metamodel Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.AbstractMetamodelDeclarationImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getAbstractMetamodelDeclaration()
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
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.GeneratedMetamodelImpl <em>Generated Metamodel</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.GeneratedMetamodelImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getGeneratedMetamodel()
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
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.ReferencedMetamodelImpl <em>Referenced Metamodel</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.ReferencedMetamodelImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getReferencedMetamodel()
     * @generated
     */
    EClass REFERENCED_METAMODEL = eINSTANCE.getReferencedMetamodel();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.ParserRuleImpl <em>Parser Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.ParserRuleImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getParserRule()
     * @generated
     */
    EClass PARSER_RULE = eINSTANCE.getParserRule();

    /**
     * The meta object literal for the '<em><b>Fragment</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARSER_RULE__FRAGMENT = eINSTANCE.getParserRule_Fragment();

    /**
     * The meta object literal for the '<em><b>Wildcard</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARSER_RULE__WILDCARD = eINSTANCE.getParserRule_Wildcard();

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
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARSER_RULE__PARAMETERS = eINSTANCE.getParserRule_Parameters();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.ParameterImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.TypeRefImpl <em>Type Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.TypeRefImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getTypeRef()
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
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.AbstractElementImpl <em>Abstract Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.AbstractElementImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getAbstractElement()
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
     * The meta object literal for the '<em><b>Predicated</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_ELEMENT__PREDICATED = eINSTANCE.getAbstractElement_Predicated();

    /**
     * The meta object literal for the '<em><b>First Set Predicated</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_ELEMENT__FIRST_SET_PREDICATED = eINSTANCE.getAbstractElement_FirstSetPredicated();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.ActionImpl <em>Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.ActionImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getAction()
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
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.KeywordImpl <em>Keyword</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.KeywordImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getKeyword()
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
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.RuleCallImpl <em>Rule Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.RuleCallImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getRuleCall()
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
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_CALL__ARGUMENTS = eINSTANCE.getRuleCall_Arguments();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.NamedArgumentImpl <em>Named Argument</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.NamedArgumentImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getNamedArgument()
     * @generated
     */
    EClass NAMED_ARGUMENT = eINSTANCE.getNamedArgument();

    /**
     * The meta object literal for the '<em><b>Literal Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_ARGUMENT__LITERAL_VALUE = eINSTANCE.getNamedArgument_LiteralValue();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_ARGUMENT__PARAMETER = eINSTANCE.getNamedArgument_Parameter();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_ARGUMENT__VALUE = eINSTANCE.getNamedArgument_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.AssignmentImpl <em>Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.AssignmentImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getAssignment()
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
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.CrossReferenceImpl <em>Cross Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.CrossReferenceImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getCrossReference()
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
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.GroupImpl <em>Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.GroupImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getGroup()
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
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.TerminalRuleImpl <em>Terminal Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.TerminalRuleImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getTerminalRule()
     * @generated
     */
    EClass TERMINAL_RULE = eINSTANCE.getTerminalRule();

    /**
     * The meta object literal for the '<em><b>Fragment</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TERMINAL_RULE__FRAGMENT = eINSTANCE.getTerminalRule_Fragment();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.AbstractNegatedTokenImpl <em>Abstract Negated Token</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.AbstractNegatedTokenImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getAbstractNegatedToken()
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
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.NegatedTokenImpl <em>Negated Token</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.NegatedTokenImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getNegatedToken()
     * @generated
     */
    EClass NEGATED_TOKEN = eINSTANCE.getNegatedToken();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.UntilTokenImpl <em>Until Token</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.UntilTokenImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getUntilToken()
     * @generated
     */
    EClass UNTIL_TOKEN = eINSTANCE.getUntilToken();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.WildcardImpl <em>Wildcard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.WildcardImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getWildcard()
     * @generated
     */
    EClass WILDCARD = eINSTANCE.getWildcard();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.EOFImpl <em>EOF</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.EOFImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getEOF()
     * @generated
     */
    EClass EOF = eINSTANCE.getEOF();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.EnumRuleImpl <em>Enum Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.EnumRuleImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getEnumRule()
     * @generated
     */
    EClass ENUM_RULE = eINSTANCE.getEnumRule();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.EnumLiteralDeclarationImpl <em>Enum Literal Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.EnumLiteralDeclarationImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getEnumLiteralDeclaration()
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
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.AlternativesImpl <em>Alternatives</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.AlternativesImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getAlternatives()
     * @generated
     */
    EClass ALTERNATIVES = eINSTANCE.getAlternatives();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALTERNATIVES__ELEMENTS = eINSTANCE.getAlternatives_Elements();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.ConditionalBranchImpl <em>Conditional Branch</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.ConditionalBranchImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getConditionalBranch()
     * @generated
     */
    EClass CONDITIONAL_BRANCH = eINSTANCE.getConditionalBranch();

    /**
     * The meta object literal for the '<em><b>Filtered</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONDITIONAL_BRANCH__FILTERED = eINSTANCE.getConditionalBranch_Filtered();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_BRANCH__PARAMETER = eINSTANCE.getConditionalBranch_Parameter();

    /**
     * The meta object literal for the '<em><b>Guarded Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_BRANCH__GUARDED_ELEMENT = eINSTANCE.getConditionalBranch_GuardedElement();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.UnorderedGroupImpl <em>Unordered Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.UnorderedGroupImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getUnorderedGroup()
     * @generated
     */
    EClass UNORDERED_GROUP = eINSTANCE.getUnorderedGroup();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNORDERED_GROUP__ELEMENTS = eINSTANCE.getUnorderedGroup_Elements();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextTest.impl.CharacterRangeImpl <em>Character Range</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextTest.impl.CharacterRangeImpl
     * @see org.eclipse.xtext.xtextTest.impl.XtextTestPackageImpl#getCharacterRange()
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

} //XtextTestPackage
