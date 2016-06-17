/**
 */
package org.eclipse.xtext.xtextTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xtextTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtextTestFactoryImpl extends EFactoryImpl implements XtextTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static XtextTestFactory init()
  {
    try
    {
      XtextTestFactory theXtextTestFactory = (XtextTestFactory)EPackage.Registry.INSTANCE.getEFactory(XtextTestPackage.eNS_URI);
      if (theXtextTestFactory != null)
      {
        return theXtextTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new XtextTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtextTestFactoryImpl()
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
      case XtextTestPackage.GRAMMAR: return createGrammar();
      case XtextTestPackage.ABSTRACT_RULE: return createAbstractRule();
      case XtextTestPackage.ABSTRACT_METAMODEL_DECLARATION: return createAbstractMetamodelDeclaration();
      case XtextTestPackage.GENERATED_METAMODEL: return createGeneratedMetamodel();
      case XtextTestPackage.REFERENCED_METAMODEL: return createReferencedMetamodel();
      case XtextTestPackage.PARSER_RULE: return createParserRule();
      case XtextTestPackage.PARAMETER: return createParameter();
      case XtextTestPackage.TYPE_REF: return createTypeRef();
      case XtextTestPackage.ABSTRACT_ELEMENT: return createAbstractElement();
      case XtextTestPackage.ACTION: return createAction();
      case XtextTestPackage.KEYWORD: return createKeyword();
      case XtextTestPackage.RULE_CALL: return createRuleCall();
      case XtextTestPackage.NAMED_ARGUMENT: return createNamedArgument();
      case XtextTestPackage.ASSIGNMENT: return createAssignment();
      case XtextTestPackage.CROSS_REFERENCE: return createCrossReference();
      case XtextTestPackage.GROUP: return createGroup();
      case XtextTestPackage.TERMINAL_RULE: return createTerminalRule();
      case XtextTestPackage.ABSTRACT_NEGATED_TOKEN: return createAbstractNegatedToken();
      case XtextTestPackage.NEGATED_TOKEN: return createNegatedToken();
      case XtextTestPackage.UNTIL_TOKEN: return createUntilToken();
      case XtextTestPackage.WILDCARD: return createWildcard();
      case XtextTestPackage.EOF: return createEOF();
      case XtextTestPackage.ENUM_RULE: return createEnumRule();
      case XtextTestPackage.ENUM_LITERAL_DECLARATION: return createEnumLiteralDeclaration();
      case XtextTestPackage.ALTERNATIVES: return createAlternatives();
      case XtextTestPackage.CONDITIONAL_BRANCH: return createConditionalBranch();
      case XtextTestPackage.UNORDERED_GROUP: return createUnorderedGroup();
      case XtextTestPackage.CHARACTER_RANGE: return createCharacterRange();
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
  public Parameter createParameter()
  {
    ParameterImpl parameter = new ParameterImpl();
    return parameter;
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
  public NamedArgument createNamedArgument()
  {
    NamedArgumentImpl namedArgument = new NamedArgumentImpl();
    return namedArgument;
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
  public EOF createEOF()
  {
    EOFImpl eof = new EOFImpl();
    return eof;
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
  public ConditionalBranch createConditionalBranch()
  {
    ConditionalBranchImpl conditionalBranch = new ConditionalBranchImpl();
    return conditionalBranch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroup createUnorderedGroup()
  {
    UnorderedGroupImpl unorderedGroup = new UnorderedGroupImpl();
    return unorderedGroup;
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
  public XtextTestPackage getXtextTestPackage()
  {
    return (XtextTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static XtextTestPackage getPackage()
  {
    return XtextTestPackage.eINSTANCE;
  }

} //XtextTestFactoryImpl
