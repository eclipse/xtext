/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtextPackage.java,v 1.12 2008/08/07 15:05:36 sefftinge Exp $
 */
package org.eclipse.xtext;

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
 * @see org.eclipse.xtext.XtextFactory
 * @model kind="package"
 * @generated
 */
public interface XtextPackage extends EPackage
{
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "xtext";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://www.eclipse.org/2008/Xtext";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "xtext";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  XtextPackage eINSTANCE = org.eclipse.xtext.impl.XtextPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.eclipse.xtext.impl.AbstractMetamodelDeclarationImpl <em>Abstract Metamodel Declaration</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.impl.AbstractMetamodelDeclarationImpl
	 * @see org.eclipse.xtext.impl.XtextPackageImpl#getAbstractMetamodelDeclaration()
	 * @generated
	 */
  int ABSTRACT_METAMODEL_DECLARATION = 8;

  /**
	 * The meta object id for the '{@link org.eclipse.xtext.impl.GeneratedMetamodelImpl <em>Generated Metamodel</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.impl.GeneratedMetamodelImpl
	 * @see org.eclipse.xtext.impl.XtextPackageImpl#getGeneratedMetamodel()
	 * @generated
	 */
  int GENERATED_METAMODEL = 5;

  /**
	 * The meta object id for the '{@link org.eclipse.xtext.impl.AbstractElementImpl <em>Abstract Element</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.impl.AbstractElementImpl
	 * @see org.eclipse.xtext.impl.XtextPackageImpl#getAbstractElement()
	 * @generated
	 */
  int ABSTRACT_ELEMENT = 11;

  /**
	 * The meta object id for the '{@link org.eclipse.xtext.impl.GrammarImpl <em>Grammar</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.impl.GrammarImpl
	 * @see org.eclipse.xtext.impl.XtextPackageImpl#getGrammar()
	 * @generated
	 */
  int GRAMMAR = 6;

  /**
	 * The meta object id for the '{@link org.eclipse.xtext.impl.AbstractRuleImpl <em>Abstract Rule</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.impl.AbstractRuleImpl
	 * @see org.eclipse.xtext.impl.XtextPackageImpl#getAbstractRule()
	 * @generated
	 */
  int ABSTRACT_RULE = 2;

  /**
	 * The meta object id for the '{@link org.eclipse.xtext.impl.ParserRuleImpl <em>Parser Rule</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.impl.ParserRuleImpl
	 * @see org.eclipse.xtext.impl.XtextPackageImpl#getParserRule()
	 * @generated
	 */
  int PARSER_RULE = 10;

  /**
	 * The meta object id for the '{@link org.eclipse.xtext.impl.TypeRefImpl <em>Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.impl.TypeRefImpl
	 * @see org.eclipse.xtext.impl.XtextPackageImpl#getTypeRef()
	 * @generated
	 */
  int TYPE_REF = 7;

  /**
	 * The meta object id for the '{@link org.eclipse.xtext.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.impl.GroupImpl
	 * @see org.eclipse.xtext.impl.XtextPackageImpl#getGroup()
	 * @generated
	 */
  int GROUP = 13;

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
	 * The meta object id for the '{@link org.eclipse.xtext.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.impl.ActionImpl
	 * @see org.eclipse.xtext.impl.XtextPackageImpl#getAction()
	 * @generated
	 */
  int ACTION = 12;

  /**
	 * The meta object id for the '{@link org.eclipse.xtext.impl.AlternativesImpl <em>Alternatives</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.impl.AlternativesImpl
	 * @see org.eclipse.xtext.impl.XtextPackageImpl#getAlternatives()
	 * @generated
	 */
  int ALTERNATIVES = 0;

  /**
	 * The meta object id for the '{@link org.eclipse.xtext.impl.RuleCallImpl <em>Rule Call</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.impl.RuleCallImpl
	 * @see org.eclipse.xtext.impl.XtextPackageImpl#getRuleCall()
	 * @generated
	 */
  int RULE_CALL = 1;

  /**
	 * The meta object id for the '{@link org.eclipse.xtext.impl.ReferencedMetamodelImpl <em>Referenced Metamodel</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.impl.ReferencedMetamodelImpl
	 * @see org.eclipse.xtext.impl.XtextPackageImpl#getReferencedMetamodel()
	 * @generated
	 */
  int REFERENCED_METAMODEL = 14;

  /**
	 * The meta object id for the '{@link org.eclipse.xtext.impl.LexerRuleImpl <em>Lexer Rule</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.impl.LexerRuleImpl
	 * @see org.eclipse.xtext.impl.XtextPackageImpl#getLexerRule()
	 * @generated
	 */
  int LEXER_RULE = 3;

  /**
	 * The meta object id for the '{@link org.eclipse.xtext.impl.KeywordImpl <em>Keyword</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.impl.KeywordImpl
	 * @see org.eclipse.xtext.impl.XtextPackageImpl#getKeyword()
	 * @generated
	 */
  int KEYWORD = 4;

  /**
	 * The meta object id for the '{@link org.eclipse.xtext.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.impl.AssignmentImpl
	 * @see org.eclipse.xtext.impl.XtextPackageImpl#getAssignment()
	 * @generated
	 */
  int ASSIGNMENT = 15;

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
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RULE_CALL__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

		/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RULE_CALL__NAME = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

		/**
	 * The number of structural features of the '<em>Rule Call</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RULE_CALL_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

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
	 * The number of structural features of the '<em>Abstract Rule</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ABSTRACT_RULE_FEATURE_COUNT = 2;

		/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LEXER_RULE__NAME = ABSTRACT_RULE__NAME;

		/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LEXER_RULE__TYPE = ABSTRACT_RULE__TYPE;

		/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LEXER_RULE__BODY = ABSTRACT_RULE_FEATURE_COUNT + 0;

		/**
	 * The number of structural features of the '<em>Lexer Rule</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LEXER_RULE_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 1;

		/**
	 * The meta object id for the '{@link org.eclipse.xtext.impl.CrossReferenceImpl <em>Cross Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.impl.CrossReferenceImpl
	 * @see org.eclipse.xtext.impl.XtextPackageImpl#getCrossReference()
	 * @generated
	 */
	int CROSS_REFERENCE = 9;

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
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ABSTRACT_METAMODEL_DECLARATION__ALIAS = 0;

		/**
	 * The number of structural features of the '<em>Abstract Metamodel Declaration</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ABSTRACT_METAMODEL_DECLARATION_FEATURE_COUNT = 1;

		/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GENERATED_METAMODEL__ALIAS = ABSTRACT_METAMODEL_DECLARATION__ALIAS;

		/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GENERATED_METAMODEL__NS_URI = ABSTRACT_METAMODEL_DECLARATION_FEATURE_COUNT + 0;

		/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GENERATED_METAMODEL__NAME = ABSTRACT_METAMODEL_DECLARATION_FEATURE_COUNT + 1;

		/**
	 * The number of structural features of the '<em>Generated Metamodel</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GENERATED_METAMODEL_FEATURE_COUNT = ABSTRACT_METAMODEL_DECLARATION_FEATURE_COUNT + 2;

		/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GRAMMAR__ABSTRACT = 0;

		/**
	 * The feature id for the '<em><b>Id Elements</b></em>' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GRAMMAR__ID_ELEMENTS = 1;

		/**
	 * The feature id for the '<em><b>Lexer Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GRAMMAR__LEXER_RULES = 2;

		/**
	 * The feature id for the '<em><b>Parser Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GRAMMAR__PARSER_RULES = 3;

		/**
	 * The feature id for the '<em><b>Super Grammar Id Elements</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR__SUPER_GRAMMAR_ID_ELEMENTS = 4;

		/**
	 * The feature id for the '<em><b>Metamodel Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GRAMMAR__METAMODEL_DECLARATIONS = 5;

		/**
	 * The number of structural features of the '<em>Grammar</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GRAMMAR_FEATURE_COUNT = 6;

		/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TYPE_REF__NAME = 0;

		/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TYPE_REF__ALIAS = 1;

		/**
	 * The number of structural features of the '<em>Type Ref</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TYPE_REF_FEATURE_COUNT = 2;

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
	 * The feature id for the '<em><b>Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCE__RULE = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

		/**
	 * The number of structural features of the '<em>Cross Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCE_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 2;

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
  int PARSER_RULE__ALTERNATIVES = ABSTRACT_RULE_FEATURE_COUNT + 0;

		/**
	 * The number of structural features of the '<em>Parser Rule</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARSER_RULE_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 1;

		/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTION__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

		/**
	 * The feature id for the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTION__FEATURE = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

		/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTION__OPERATOR = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

		/**
	 * The feature id for the '<em><b>Type Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTION__TYPE_NAME = ABSTRACT_ELEMENT_FEATURE_COUNT + 2;

		/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTION_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 3;

		/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GROUP__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

		/**
	 * The feature id for the '<em><b>Abstract Tokens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GROUP__ABSTRACT_TOKENS = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

		/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GROUP_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

		/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REFERENCED_METAMODEL__ALIAS = ABSTRACT_METAMODEL_DECLARATION__ALIAS;

		/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REFERENCED_METAMODEL__URI = ABSTRACT_METAMODEL_DECLARATION_FEATURE_COUNT + 0;

		/**
	 * The number of structural features of the '<em>Referenced Metamodel</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REFERENCED_METAMODEL_FEATURE_COUNT = ABSTRACT_METAMODEL_DECLARATION_FEATURE_COUNT + 1;

		/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGNMENT__CARDINALITY = ABSTRACT_ELEMENT__CARDINALITY;

		/**
	 * The feature id for the '<em><b>Terminal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGNMENT__TERMINAL = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

		/**
	 * The feature id for the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGNMENT__FEATURE = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

		/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGNMENT__OPERATOR = ABSTRACT_ELEMENT_FEATURE_COUNT + 2;

		/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGNMENT_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 3;


  /**
	 * Returns the meta object for class '{@link org.eclipse.xtext.GeneratedMetamodel <em>Generated Metamodel</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generated Metamodel</em>'.
	 * @see org.eclipse.xtext.GeneratedMetamodel
	 * @generated
	 */
  EClass getGeneratedMetamodel();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.GeneratedMetamodel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.GeneratedMetamodel#getName()
	 * @see #getGeneratedMetamodel()
	 * @generated
	 */
  EAttribute getGeneratedMetamodel_Name();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.GeneratedMetamodel#getNsURI <em>Ns URI</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns URI</em>'.
	 * @see org.eclipse.xtext.GeneratedMetamodel#getNsURI()
	 * @see #getGeneratedMetamodel()
	 * @generated
	 */
  EAttribute getGeneratedMetamodel_NsURI();

  /**
	 * Returns the meta object for class '{@link org.eclipse.xtext.AbstractElement <em>Abstract Element</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Element</em>'.
	 * @see org.eclipse.xtext.AbstractElement
	 * @generated
	 */
  EClass getAbstractElement();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.AbstractElement#getCardinality <em>Cardinality</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cardinality</em>'.
	 * @see org.eclipse.xtext.AbstractElement#getCardinality()
	 * @see #getAbstractElement()
	 * @generated
	 */
  EAttribute getAbstractElement_Cardinality();

  /**
	 * Returns the meta object for class '{@link org.eclipse.xtext.Grammar <em>Grammar</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grammar</em>'.
	 * @see org.eclipse.xtext.Grammar
	 * @generated
	 */
  EClass getGrammar();

  /**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.Grammar#getParserRules <em>Parser Rules</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parser Rules</em>'.
	 * @see org.eclipse.xtext.Grammar#getParserRules()
	 * @see #getGrammar()
	 * @generated
	 */
  EReference getGrammar_ParserRules();

  /**
	 * Returns the meta object for the attribute list '{@link org.eclipse.xtext.Grammar#getSuperGrammarIdElements <em>Super Grammar Id Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Super Grammar Id Elements</em>'.
	 * @see org.eclipse.xtext.Grammar#getSuperGrammarIdElements()
	 * @see #getGrammar()
	 * @generated
	 */
	EAttribute getGrammar_SuperGrammarIdElements();

		/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.xtext.Grammar#getIdElements <em>Id Elements</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Id Elements</em>'.
	 * @see org.eclipse.xtext.Grammar#getIdElements()
	 * @see #getGrammar()
	 * @generated
	 */
  EAttribute getGrammar_IdElements();

  /**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.Grammar#getMetamodelDeclarations <em>Metamodel Declarations</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metamodel Declarations</em>'.
	 * @see org.eclipse.xtext.Grammar#getMetamodelDeclarations()
	 * @see #getGrammar()
	 * @generated
	 */
  EReference getGrammar_MetamodelDeclarations();

  /**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.Grammar#getLexerRules <em>Lexer Rules</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lexer Rules</em>'.
	 * @see org.eclipse.xtext.Grammar#getLexerRules()
	 * @see #getGrammar()
	 * @generated
	 */
  EReference getGrammar_LexerRules();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.Grammar#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see org.eclipse.xtext.Grammar#isAbstract()
	 * @see #getGrammar()
	 * @generated
	 */
  EAttribute getGrammar_Abstract();

  /**
	 * Returns the meta object for class '{@link org.eclipse.xtext.ParserRule <em>Parser Rule</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parser Rule</em>'.
	 * @see org.eclipse.xtext.ParserRule
	 * @generated
	 */
  EClass getParserRule();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ParserRule#getAlternatives <em>Alternatives</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Alternatives</em>'.
	 * @see org.eclipse.xtext.ParserRule#getAlternatives()
	 * @see #getParserRule()
	 * @generated
	 */
  EReference getParserRule_Alternatives();

  /**
	 * Returns the meta object for class '{@link org.eclipse.xtext.TypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Ref</em>'.
	 * @see org.eclipse.xtext.TypeRef
	 * @generated
	 */
  EClass getTypeRef();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.TypeRef#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.TypeRef#getName()
	 * @see #getTypeRef()
	 * @generated
	 */
  EAttribute getTypeRef_Name();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.TypeRef#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see org.eclipse.xtext.TypeRef#getAlias()
	 * @see #getTypeRef()
	 * @generated
	 */
  EAttribute getTypeRef_Alias();

  /**
	 * Returns the meta object for class '{@link org.eclipse.xtext.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see org.eclipse.xtext.Group
	 * @generated
	 */
  EClass getGroup();

  /**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.Group#getAbstractTokens <em>Abstract Tokens</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Abstract Tokens</em>'.
	 * @see org.eclipse.xtext.Group#getAbstractTokens()
	 * @see #getGroup()
	 * @generated
	 */
  EReference getGroup_AbstractTokens();

  /**
	 * Returns the meta object for class '{@link org.eclipse.xtext.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.eclipse.xtext.Action
	 * @generated
	 */
  EClass getAction();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.Action#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature</em>'.
	 * @see org.eclipse.xtext.Action#getFeature()
	 * @see #getAction()
	 * @generated
	 */
  EAttribute getAction_Feature();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.Action#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipse.xtext.Action#getOperator()
	 * @see #getAction()
	 * @generated
	 */
  EAttribute getAction_Operator();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.Action#getTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Name</em>'.
	 * @see org.eclipse.xtext.Action#getTypeName()
	 * @see #getAction()
	 * @generated
	 */
  EReference getAction_TypeName();

  /**
	 * Returns the meta object for class '{@link org.eclipse.xtext.AbstractRule <em>Abstract Rule</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Rule</em>'.
	 * @see org.eclipse.xtext.AbstractRule
	 * @generated
	 */
  EClass getAbstractRule();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.AbstractRule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.AbstractRule#getName()
	 * @see #getAbstractRule()
	 * @generated
	 */
  EAttribute getAbstractRule_Name();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.AbstractRule#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.AbstractRule#getType()
	 * @see #getAbstractRule()
	 * @generated
	 */
  EReference getAbstractRule_Type();

  /**
	 * Returns the meta object for class '{@link org.eclipse.xtext.Alternatives <em>Alternatives</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternatives</em>'.
	 * @see org.eclipse.xtext.Alternatives
	 * @generated
	 */
  EClass getAlternatives();

  /**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.Alternatives#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Groups</em>'.
	 * @see org.eclipse.xtext.Alternatives#getGroups()
	 * @see #getAlternatives()
	 * @generated
	 */
  EReference getAlternatives_Groups();

  /**
	 * Returns the meta object for class '{@link org.eclipse.xtext.RuleCall <em>Rule Call</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Call</em>'.
	 * @see org.eclipse.xtext.RuleCall
	 * @generated
	 */
  EClass getRuleCall();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.RuleCall#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.RuleCall#getName()
	 * @see #getRuleCall()
	 * @generated
	 */
  EAttribute getRuleCall_Name();

  /**
	 * Returns the meta object for class '{@link org.eclipse.xtext.ReferencedMetamodel <em>Referenced Metamodel</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Referenced Metamodel</em>'.
	 * @see org.eclipse.xtext.ReferencedMetamodel
	 * @generated
	 */
  EClass getReferencedMetamodel();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.ReferencedMetamodel#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.xtext.ReferencedMetamodel#getUri()
	 * @see #getReferencedMetamodel()
	 * @generated
	 */
  EAttribute getReferencedMetamodel_Uri();

  /**
	 * Returns the meta object for class '{@link org.eclipse.xtext.LexerRule <em>Lexer Rule</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lexer Rule</em>'.
	 * @see org.eclipse.xtext.LexerRule
	 * @generated
	 */
  EClass getLexerRule();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.LexerRule#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see org.eclipse.xtext.LexerRule#getBody()
	 * @see #getLexerRule()
	 * @generated
	 */
  EAttribute getLexerRule_Body();

  /**
	 * Returns the meta object for class '{@link org.eclipse.xtext.Keyword <em>Keyword</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Keyword</em>'.
	 * @see org.eclipse.xtext.Keyword
	 * @generated
	 */
  EClass getKeyword();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.Keyword#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.xtext.Keyword#getValue()
	 * @see #getKeyword()
	 * @generated
	 */
  EAttribute getKeyword_Value();

  /**
	 * Returns the meta object for class '{@link org.eclipse.xtext.AbstractMetamodelDeclaration <em>Abstract Metamodel Declaration</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Metamodel Declaration</em>'.
	 * @see org.eclipse.xtext.AbstractMetamodelDeclaration
	 * @generated
	 */
  EClass getAbstractMetamodelDeclaration();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.AbstractMetamodelDeclaration#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see org.eclipse.xtext.AbstractMetamodelDeclaration#getAlias()
	 * @see #getAbstractMetamodelDeclaration()
	 * @generated
	 */
  EAttribute getAbstractMetamodelDeclaration_Alias();

  /**
	 * Returns the meta object for class '{@link org.eclipse.xtext.CrossReference <em>Cross Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cross Reference</em>'.
	 * @see org.eclipse.xtext.CrossReference
	 * @generated
	 */
	EClass getCrossReference();

		/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.CrossReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.CrossReference#getType()
	 * @see #getCrossReference()
	 * @generated
	 */
	EReference getCrossReference_Type();

		/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.CrossReference#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rule</em>'.
	 * @see org.eclipse.xtext.CrossReference#getRule()
	 * @see #getCrossReference()
	 * @generated
	 */
	EReference getCrossReference_Rule();

		/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see org.eclipse.xtext.Assignment
	 * @generated
	 */
  EClass getAssignment();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.Assignment#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature</em>'.
	 * @see org.eclipse.xtext.Assignment#getFeature()
	 * @see #getAssignment()
	 * @generated
	 */
  EAttribute getAssignment_Feature();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.Assignment#getTerminal <em>Terminal</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Terminal</em>'.
	 * @see org.eclipse.xtext.Assignment#getTerminal()
	 * @see #getAssignment()
	 * @generated
	 */
  EReference getAssignment_Terminal();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.Assignment#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipse.xtext.Assignment#getOperator()
	 * @see #getAssignment()
	 * @generated
	 */
  EAttribute getAssignment_Operator();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  XtextFactory getXtextFactory();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.impl.GeneratedMetamodelImpl <em>Generated Metamodel</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.impl.GeneratedMetamodelImpl
		 * @see org.eclipse.xtext.impl.XtextPackageImpl#getGeneratedMetamodel()
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
		 * The meta object literal for the '<em><b>Ns URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute GENERATED_METAMODEL__NS_URI = eINSTANCE.getGeneratedMetamodel_NsURI();

    /**
		 * The meta object literal for the '{@link org.eclipse.xtext.impl.AbstractElementImpl <em>Abstract Element</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.impl.AbstractElementImpl
		 * @see org.eclipse.xtext.impl.XtextPackageImpl#getAbstractElement()
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
		 * The meta object literal for the '{@link org.eclipse.xtext.impl.GrammarImpl <em>Grammar</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.impl.GrammarImpl
		 * @see org.eclipse.xtext.impl.XtextPackageImpl#getGrammar()
		 * @generated
		 */
    EClass GRAMMAR = eINSTANCE.getGrammar();

    /**
		 * The meta object literal for the '<em><b>Parser Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference GRAMMAR__PARSER_RULES = eINSTANCE.getGrammar_ParserRules();

    /**
		 * The meta object literal for the '<em><b>Super Grammar Id Elements</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAMMAR__SUPER_GRAMMAR_ID_ELEMENTS = eINSTANCE.getGrammar_SuperGrammarIdElements();

				/**
		 * The meta object literal for the '<em><b>Id Elements</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute GRAMMAR__ID_ELEMENTS = eINSTANCE.getGrammar_IdElements();

    /**
		 * The meta object literal for the '<em><b>Metamodel Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference GRAMMAR__METAMODEL_DECLARATIONS = eINSTANCE.getGrammar_MetamodelDeclarations();

    /**
		 * The meta object literal for the '<em><b>Lexer Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference GRAMMAR__LEXER_RULES = eINSTANCE.getGrammar_LexerRules();

    /**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute GRAMMAR__ABSTRACT = eINSTANCE.getGrammar_Abstract();

    /**
		 * The meta object literal for the '{@link org.eclipse.xtext.impl.ParserRuleImpl <em>Parser Rule</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.impl.ParserRuleImpl
		 * @see org.eclipse.xtext.impl.XtextPackageImpl#getParserRule()
		 * @generated
		 */
    EClass PARSER_RULE = eINSTANCE.getParserRule();

    /**
		 * The meta object literal for the '<em><b>Alternatives</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference PARSER_RULE__ALTERNATIVES = eINSTANCE.getParserRule_Alternatives();

    /**
		 * The meta object literal for the '{@link org.eclipse.xtext.impl.TypeRefImpl <em>Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.impl.TypeRefImpl
		 * @see org.eclipse.xtext.impl.XtextPackageImpl#getTypeRef()
		 * @generated
		 */
    EClass TYPE_REF = eINSTANCE.getTypeRef();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TYPE_REF__NAME = eINSTANCE.getTypeRef_Name();

    /**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TYPE_REF__ALIAS = eINSTANCE.getTypeRef_Alias();

    /**
		 * The meta object literal for the '{@link org.eclipse.xtext.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.impl.GroupImpl
		 * @see org.eclipse.xtext.impl.XtextPackageImpl#getGroup()
		 * @generated
		 */
    EClass GROUP = eINSTANCE.getGroup();

    /**
		 * The meta object literal for the '<em><b>Abstract Tokens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference GROUP__ABSTRACT_TOKENS = eINSTANCE.getGroup_AbstractTokens();

    /**
		 * The meta object literal for the '{@link org.eclipse.xtext.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.impl.ActionImpl
		 * @see org.eclipse.xtext.impl.XtextPackageImpl#getAction()
		 * @generated
		 */
    EClass ACTION = eINSTANCE.getAction();

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
		 * The meta object literal for the '<em><b>Type Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ACTION__TYPE_NAME = eINSTANCE.getAction_TypeName();

    /**
		 * The meta object literal for the '{@link org.eclipse.xtext.impl.AbstractRuleImpl <em>Abstract Rule</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.impl.AbstractRuleImpl
		 * @see org.eclipse.xtext.impl.XtextPackageImpl#getAbstractRule()
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
		 * The meta object literal for the '{@link org.eclipse.xtext.impl.AlternativesImpl <em>Alternatives</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.impl.AlternativesImpl
		 * @see org.eclipse.xtext.impl.XtextPackageImpl#getAlternatives()
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
		 * The meta object literal for the '{@link org.eclipse.xtext.impl.RuleCallImpl <em>Rule Call</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.impl.RuleCallImpl
		 * @see org.eclipse.xtext.impl.XtextPackageImpl#getRuleCall()
		 * @generated
		 */
    EClass RULE_CALL = eINSTANCE.getRuleCall();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute RULE_CALL__NAME = eINSTANCE.getRuleCall_Name();

    /**
		 * The meta object literal for the '{@link org.eclipse.xtext.impl.ReferencedMetamodelImpl <em>Referenced Metamodel</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.impl.ReferencedMetamodelImpl
		 * @see org.eclipse.xtext.impl.XtextPackageImpl#getReferencedMetamodel()
		 * @generated
		 */
    EClass REFERENCED_METAMODEL = eINSTANCE.getReferencedMetamodel();

    /**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute REFERENCED_METAMODEL__URI = eINSTANCE.getReferencedMetamodel_Uri();

    /**
		 * The meta object literal for the '{@link org.eclipse.xtext.impl.LexerRuleImpl <em>Lexer Rule</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.impl.LexerRuleImpl
		 * @see org.eclipse.xtext.impl.XtextPackageImpl#getLexerRule()
		 * @generated
		 */
    EClass LEXER_RULE = eINSTANCE.getLexerRule();

    /**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LEXER_RULE__BODY = eINSTANCE.getLexerRule_Body();

    /**
		 * The meta object literal for the '{@link org.eclipse.xtext.impl.KeywordImpl <em>Keyword</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.impl.KeywordImpl
		 * @see org.eclipse.xtext.impl.XtextPackageImpl#getKeyword()
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
		 * The meta object literal for the '{@link org.eclipse.xtext.impl.AbstractMetamodelDeclarationImpl <em>Abstract Metamodel Declaration</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.impl.AbstractMetamodelDeclarationImpl
		 * @see org.eclipse.xtext.impl.XtextPackageImpl#getAbstractMetamodelDeclaration()
		 * @generated
		 */
    EClass ABSTRACT_METAMODEL_DECLARATION = eINSTANCE.getAbstractMetamodelDeclaration();

    /**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ABSTRACT_METAMODEL_DECLARATION__ALIAS = eINSTANCE.getAbstractMetamodelDeclaration_Alias();

    /**
		 * The meta object literal for the '{@link org.eclipse.xtext.impl.CrossReferenceImpl <em>Cross Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.impl.CrossReferenceImpl
		 * @see org.eclipse.xtext.impl.XtextPackageImpl#getCrossReference()
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
		 * The meta object literal for the '<em><b>Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CROSS_REFERENCE__RULE = eINSTANCE.getCrossReference_Rule();

				/**
		 * The meta object literal for the '{@link org.eclipse.xtext.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.impl.AssignmentImpl
		 * @see org.eclipse.xtext.impl.XtextPackageImpl#getAssignment()
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
		 * The meta object literal for the '<em><b>Terminal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ASSIGNMENT__TERMINAL = eINSTANCE.getAssignment_Terminal();

    /**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASSIGNMENT__OPERATOR = eINSTANCE.getAssignment_Operator();

  }

} //XtextPackage
