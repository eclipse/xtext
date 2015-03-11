/**
 */
package org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtextTerminalsTestLanguageFactoryImpl extends EFactoryImpl implements XtextTerminalsTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static XtextTerminalsTestLanguageFactory init()
  {
    try
    {
      XtextTerminalsTestLanguageFactory theXtextTerminalsTestLanguageFactory = (XtextTerminalsTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(XtextTerminalsTestLanguagePackage.eNS_URI);
      if (theXtextTerminalsTestLanguageFactory != null)
      {
        return theXtextTerminalsTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new XtextTerminalsTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtextTerminalsTestLanguageFactoryImpl()
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
      case XtextTerminalsTestLanguagePackage.GRAMMAR: return createGrammar();
      case XtextTerminalsTestLanguagePackage.ABSTRACT_RULE: return createAbstractRule();
      case XtextTerminalsTestLanguagePackage.ABSTRACT_METAMODEL_DECLARATION: return createAbstractMetamodelDeclaration();
      case XtextTerminalsTestLanguagePackage.GENERATED_METAMODEL: return createGeneratedMetamodel();
      case XtextTerminalsTestLanguagePackage.REFERENCED_METAMODEL: return createReferencedMetamodel();
      case XtextTerminalsTestLanguagePackage.PARSER_RULE: return createParserRule();
      case XtextTerminalsTestLanguagePackage.TYPE_REF: return createTypeRef();
      case XtextTerminalsTestLanguagePackage.ABSTRACT_ELEMENT: return createAbstractElement();
      case XtextTerminalsTestLanguagePackage.ACTION: return createAction();
      case XtextTerminalsTestLanguagePackage.KEYWORD: return createKeyword();
      case XtextTerminalsTestLanguagePackage.RULE_CALL: return createRuleCall();
      case XtextTerminalsTestLanguagePackage.ASSIGNMENT: return createAssignment();
      case XtextTerminalsTestLanguagePackage.CROSS_REFERENCE: return createCrossReference();
      case XtextTerminalsTestLanguagePackage.TERMINAL_RULE: return createTerminalRule();
      case XtextTerminalsTestLanguagePackage.ABSTRACT_NEGATED_TOKEN: return createAbstractNegatedToken();
      case XtextTerminalsTestLanguagePackage.NEGATED_TOKEN: return createNegatedToken();
      case XtextTerminalsTestLanguagePackage.UNTIL_TOKEN: return createUntilToken();
      case XtextTerminalsTestLanguagePackage.WILDCARD: return createWildcard();
      case XtextTerminalsTestLanguagePackage.ENUM_RULE: return createEnumRule();
      case XtextTerminalsTestLanguagePackage.ENUM_LITERAL_DECLARATION: return createEnumLiteralDeclaration();
      case XtextTerminalsTestLanguagePackage.ALTERNATIVES: return createAlternatives();
      case XtextTerminalsTestLanguagePackage.GROUP: return createGroup();
      case XtextTerminalsTestLanguagePackage.CHARACTER_RANGE: return createCharacterRange();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
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
  public XtextTerminalsTestLanguagePackage getXtextTerminalsTestLanguagePackage()
  {
    return (XtextTerminalsTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static XtextTerminalsTestLanguagePackage getPackage()
  {
    return XtextTerminalsTestLanguagePackage.eINSTANCE;
  }

} //XtextTerminalsTestLanguageFactoryImpl
