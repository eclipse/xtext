/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtextGrammarTestFactoryImpl extends EFactoryImpl implements XtextGrammarTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static XtextGrammarTestFactory init()
  {
    try
    {
      XtextGrammarTestFactory theXtextGrammarTestFactory = (XtextGrammarTestFactory)EPackage.Registry.INSTANCE.getEFactory(XtextGrammarTestPackage.eNS_URI);
      if (theXtextGrammarTestFactory != null)
      {
        return theXtextGrammarTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new XtextGrammarTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtextGrammarTestFactoryImpl()
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
    switch (eClass.getClassifierID())
    {
      case XtextGrammarTestPackage.GRAMMAR: return createGrammar();
      case XtextGrammarTestPackage.ABSTRACT_RULE: return createAbstractRule();
      case XtextGrammarTestPackage.ABSTRACT_METAMODEL_DECLARATION: return createAbstractMetamodelDeclaration();
      case XtextGrammarTestPackage.GENERATED_METAMODEL: return createGeneratedMetamodel();
      case XtextGrammarTestPackage.REFERENCED_METAMODEL: return createReferencedMetamodel();
      case XtextGrammarTestPackage.PARSER_RULE: return createParserRule();
      case XtextGrammarTestPackage.TYPE_REF: return createTypeRef();
      case XtextGrammarTestPackage.ABSTRACT_ELEMENT: return createAbstractElement();
      case XtextGrammarTestPackage.ACTION: return createAction();
      case XtextGrammarTestPackage.KEYWORD: return createKeyword();
      case XtextGrammarTestPackage.RULE_CALL: return createRuleCall();
      case XtextGrammarTestPackage.ASSIGNMENT: return createAssignment();
      case XtextGrammarTestPackage.CROSS_REFERENCE: return createCrossReference();
      case XtextGrammarTestPackage.TERMINAL_RULE: return createTerminalRule();
      case XtextGrammarTestPackage.ABSTRACT_NEGATED_TOKEN: return createAbstractNegatedToken();
      case XtextGrammarTestPackage.NEGATED_TOKEN: return createNegatedToken();
      case XtextGrammarTestPackage.UNTIL_TOKEN: return createUntilToken();
      case XtextGrammarTestPackage.WILDCARD: return createWildcard();
      case XtextGrammarTestPackage.ENUM_RULE: return createEnumRule();
      case XtextGrammarTestPackage.ENUM_LITERAL_DECLARATION: return createEnumLiteralDeclaration();
      case XtextGrammarTestPackage.ALTERNATIVES: return createAlternatives();
      case XtextGrammarTestPackage.GROUP: return createGroup();
      case XtextGrammarTestPackage.CHARACTER_RANGE: return createCharacterRange();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  @Override
  public AbstractRule createAbstractRule()
  {
    AbstractRuleImpl abstractRule = new AbstractRuleImpl();
    return abstractRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AbstractMetamodelDeclaration createAbstractMetamodelDeclaration()
  {
    AbstractMetamodelDeclarationImpl abstractMetamodelDeclaration = new AbstractMetamodelDeclarationImpl();
    return abstractMetamodelDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
  public CrossReference createCrossReference()
  {
    CrossReferenceImpl crossReference = new CrossReferenceImpl();
    return crossReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TerminalRule createTerminalRule()
  {
    TerminalRuleImpl terminalRule = new TerminalRuleImpl();
    return terminalRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AbstractNegatedToken createAbstractNegatedToken()
  {
    AbstractNegatedTokenImpl abstractNegatedToken = new AbstractNegatedTokenImpl();
    return abstractNegatedToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NegatedToken createNegatedToken()
  {
    NegatedTokenImpl negatedToken = new NegatedTokenImpl();
    return negatedToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UntilToken createUntilToken()
  {
    UntilTokenImpl untilToken = new UntilTokenImpl();
    return untilToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Wildcard createWildcard()
  {
    WildcardImpl wildcard = new WildcardImpl();
    return wildcard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EnumRule createEnumRule()
  {
    EnumRuleImpl enumRule = new EnumRuleImpl();
    return enumRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EnumLiteralDeclaration createEnumLiteralDeclaration()
  {
    EnumLiteralDeclarationImpl enumLiteralDeclaration = new EnumLiteralDeclarationImpl();
    return enumLiteralDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  @Override
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
  @Override
  public CharacterRange createCharacterRange()
  {
    CharacterRangeImpl characterRange = new CharacterRangeImpl();
    return characterRange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XtextGrammarTestPackage getXtextGrammarTestPackage()
  {
    return (XtextGrammarTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static XtextGrammarTestPackage getPackage()
  {
    return XtextGrammarTestPackage.eINSTANCE;
  }

} //XtextGrammarTestFactoryImpl
