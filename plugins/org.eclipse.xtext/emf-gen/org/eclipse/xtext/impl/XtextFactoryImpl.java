/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtextFactoryImpl.java,v 1.2 2008/05/14 13:29:34 jkohnlein Exp $
 */
package org.eclipse.xtext.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtextFactoryImpl extends EFactoryImpl implements XtextFactory
{
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static XtextFactory init()
  {
		try {
			XtextFactory theXtextFactory = (XtextFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2008/Xtext"); 
			if (theXtextFactory != null) {
				return theXtextFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XtextFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public XtextFactoryImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EObject create(EClass eClass)
  {
		switch (eClass.getClassifierID()) {
			case XtextPackage.LEXER_RULE: return createLexerRule();
			case XtextPackage.TYPE_REF: return createTypeRef();
			case XtextPackage.ABSTRACT_ELEMENT: return createAbstractElement();
			case XtextPackage.PARSER_RULE: return createParserRule();
			case XtextPackage.GRAMMAR: return createGrammar();
			case XtextPackage.GENERATED_METAMODEL: return createGeneratedMetamodel();
			case XtextPackage.REFERENCED_METAMODEL: return createReferencedMetamodel();
			case XtextPackage.ASSIGNMENT: return createAssignment();
			case XtextPackage.ACTION: return createAction();
			case XtextPackage.KEYWORD: return createKeyword();
			case XtextPackage.RULE_CALL: return createRuleCall();
			case XtextPackage.GROUP: return createGroup();
			case XtextPackage.ALTERNATIVES: return createAlternatives();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AbstractElement createAbstractElement()
  {
		AbstractElementImpl abstractElement = new AbstractElementImpl();
		return abstractElement;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypeRef createTypeRef()
  {
		TypeRefImpl typeRef = new TypeRefImpl();
		return typeRef;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ParserRule createParserRule()
  {
		ParserRuleImpl parserRule = new ParserRuleImpl();
		return parserRule;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LexerRule createLexerRule()
  {
		LexerRuleImpl lexerRule = new LexerRuleImpl();
		return lexerRule;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Grammar createGrammar()
  {
		GrammarImpl grammar = new GrammarImpl();
		return grammar;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public GeneratedMetamodel createGeneratedMetamodel()
  {
		GeneratedMetamodelImpl generatedMetamodel = new GeneratedMetamodelImpl();
		return generatedMetamodel;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ReferencedMetamodel createReferencedMetamodel()
  {
		ReferencedMetamodelImpl referencedMetamodel = new ReferencedMetamodelImpl();
		return referencedMetamodel;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Assignment createAssignment()
  {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Action createAction()
  {
		ActionImpl action = new ActionImpl();
		return action;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Keyword createKeyword()
  {
		KeywordImpl keyword = new KeywordImpl();
		return keyword;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RuleCall createRuleCall()
  {
		RuleCallImpl ruleCall = new RuleCallImpl();
		return ruleCall;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Group createGroup()
  {
		GroupImpl group = new GroupImpl();
		return group;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Alternatives createAlternatives()
  {
		AlternativesImpl alternatives = new AlternativesImpl();
		return alternatives;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public XtextPackage getXtextPackage()
  {
		return (XtextPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static XtextPackage getPackage()
  {
		return XtextPackage.eINSTANCE;
	}

} //XtextFactoryImpl
