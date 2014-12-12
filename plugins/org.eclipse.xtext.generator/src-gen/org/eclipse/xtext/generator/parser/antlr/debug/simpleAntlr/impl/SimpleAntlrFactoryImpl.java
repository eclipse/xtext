/**
 */
package org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimpleAntlrFactoryImpl extends EFactoryImpl implements SimpleAntlrFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SimpleAntlrFactory init()
  {
    try
    {
      SimpleAntlrFactory theSimpleAntlrFactory = (SimpleAntlrFactory)EPackage.Registry.INSTANCE.getEFactory(SimpleAntlrPackage.eNS_URI);
      if (theSimpleAntlrFactory != null)
      {
        return theSimpleAntlrFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SimpleAntlrFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleAntlrFactoryImpl()
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
      case SimpleAntlrPackage.ANTLR_GRAMMAR: return createAntlrGrammar();
      case SimpleAntlrPackage.OPTIONS: return createOptions();
      case SimpleAntlrPackage.OPTION_VALUE: return createOptionValue();
      case SimpleAntlrPackage.RULE: return createRule();
      case SimpleAntlrPackage.RULE_ELEMENT: return createRuleElement();
      case SimpleAntlrPackage.PREDICATED: return createPredicated();
      case SimpleAntlrPackage.RULE_OPTIONS: return createRuleOptions();
      case SimpleAntlrPackage.RULE_CALL: return createRuleCall();
      case SimpleAntlrPackage.KEYWORD: return createKeyword();
      case SimpleAntlrPackage.WILDCARD: return createWildcard();
      case SimpleAntlrPackage.ALTERNATIVES: return createAlternatives();
      case SimpleAntlrPackage.GROUP: return createGroup();
      case SimpleAntlrPackage.ELEMENT_WITH_CARDINALITY: return createElementWithCardinality();
      case SimpleAntlrPackage.NEGATED_ELEMENT: return createNegatedElement();
      case SimpleAntlrPackage.UNTIL_ELEMENT: return createUntilElement();
      case SimpleAntlrPackage.SKIP: return createSkip();
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
public AntlrGrammar createAntlrGrammar()
  {
    AntlrGrammarImpl antlrGrammar = new AntlrGrammarImpl();
    return antlrGrammar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public Options createOptions()
  {
    OptionsImpl options = new OptionsImpl();
    return options;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public OptionValue createOptionValue()
  {
    OptionValueImpl optionValue = new OptionValueImpl();
    return optionValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public Rule createRule()
  {
    RuleImpl rule = new RuleImpl();
    return rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public RuleElement createRuleElement()
  {
    RuleElementImpl ruleElement = new RuleElementImpl();
    return ruleElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public Predicated createPredicated()
  {
    PredicatedImpl predicated = new PredicatedImpl();
    return predicated;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public RuleOptions createRuleOptions()
  {
    RuleOptionsImpl ruleOptions = new RuleOptionsImpl();
    return ruleOptions;
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
public ElementWithCardinality createElementWithCardinality()
  {
    ElementWithCardinalityImpl elementWithCardinality = new ElementWithCardinalityImpl();
    return elementWithCardinality;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public NegatedElement createNegatedElement()
  {
    NegatedElementImpl negatedElement = new NegatedElementImpl();
    return negatedElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public UntilElement createUntilElement()
  {
    UntilElementImpl untilElement = new UntilElementImpl();
    return untilElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public Skip createSkip()
  {
    SkipImpl skip = new SkipImpl();
    return skip;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public SimpleAntlrPackage getSimpleAntlrPackage()
  {
    return (SimpleAntlrPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SimpleAntlrPackage getPackage()
  {
    return SimpleAntlrPackage.eINSTANCE;
  }

} //SimpleAntlrFactoryImpl
