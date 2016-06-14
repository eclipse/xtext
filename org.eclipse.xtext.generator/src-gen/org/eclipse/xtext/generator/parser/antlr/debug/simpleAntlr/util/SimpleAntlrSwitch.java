/**
 */
package org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage
 * @generated
 */
public class SimpleAntlrSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SimpleAntlrPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleAntlrSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = SimpleAntlrPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case SimpleAntlrPackage.ANTLR_GRAMMAR:
      {
        AntlrGrammar antlrGrammar = (AntlrGrammar)theEObject;
        T result = caseAntlrGrammar(antlrGrammar);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.OPTIONS:
      {
        Options options = (Options)theEObject;
        T result = caseOptions(options);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.OPTION_VALUE:
      {
        OptionValue optionValue = (OptionValue)theEObject;
        T result = caseOptionValue(optionValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.RULE:
      {
        Rule rule = (Rule)theEObject;
        T result = caseRule(rule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.PARAMETER:
      {
        Parameter parameter = (Parameter)theEObject;
        T result = caseParameter(parameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.RULE_ELEMENT:
      {
        RuleElement ruleElement = (RuleElement)theEObject;
        T result = caseRuleElement(ruleElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.REFERENCE_OR_LITERAL:
      {
        ReferenceOrLiteral referenceOrLiteral = (ReferenceOrLiteral)theEObject;
        T result = caseReferenceOrLiteral(referenceOrLiteral);
        if (result == null) result = caseExpression(referenceOrLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.PREDICATED:
      {
        Predicated predicated = (Predicated)theEObject;
        T result = casePredicated(predicated);
        if (result == null) result = caseRuleElement(predicated);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.RULE_OPTIONS:
      {
        RuleOptions ruleOptions = (RuleOptions)theEObject;
        T result = caseRuleOptions(ruleOptions);
        if (result == null) result = caseRuleElement(ruleOptions);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.RULE_CALL:
      {
        RuleCall ruleCall = (RuleCall)theEObject;
        T result = caseRuleCall(ruleCall);
        if (result == null) result = caseRuleElement(ruleCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.KEYWORD:
      {
        Keyword keyword = (Keyword)theEObject;
        T result = caseKeyword(keyword);
        if (result == null) result = caseRuleElement(keyword);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.WILDCARD:
      {
        Wildcard wildcard = (Wildcard)theEObject;
        T result = caseWildcard(wildcard);
        if (result == null) result = caseRuleElement(wildcard);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.ALTERNATIVES:
      {
        Alternatives alternatives = (Alternatives)theEObject;
        T result = caseAlternatives(alternatives);
        if (result == null) result = caseRuleElement(alternatives);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.GROUP:
      {
        Group group = (Group)theEObject;
        T result = caseGroup(group);
        if (result == null) result = caseRuleElement(group);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.ELEMENT_WITH_CARDINALITY:
      {
        ElementWithCardinality elementWithCardinality = (ElementWithCardinality)theEObject;
        T result = caseElementWithCardinality(elementWithCardinality);
        if (result == null) result = caseRuleElement(elementWithCardinality);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.NEGATED_ELEMENT:
      {
        NegatedElement negatedElement = (NegatedElement)theEObject;
        T result = caseNegatedElement(negatedElement);
        if (result == null) result = caseRuleElement(negatedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.UNTIL_ELEMENT:
      {
        UntilElement untilElement = (UntilElement)theEObject;
        T result = caseUntilElement(untilElement);
        if (result == null) result = caseRuleElement(untilElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.OR_EXPRESSION:
      {
        OrExpression orExpression = (OrExpression)theEObject;
        T result = caseOrExpression(orExpression);
        if (result == null) result = caseExpression(orExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.AND_EXPRESSION:
      {
        AndExpression andExpression = (AndExpression)theEObject;
        T result = caseAndExpression(andExpression);
        if (result == null) result = caseExpression(andExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.NOT_EXPRESSION:
      {
        NotExpression notExpression = (NotExpression)theEObject;
        T result = caseNotExpression(notExpression);
        if (result == null) result = caseExpression(notExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimpleAntlrPackage.SKIP:
      {
        Skip skip = (Skip)theEObject;
        T result = caseSkip(skip);
        if (result == null) result = caseRuleOptions(skip);
        if (result == null) result = caseRuleElement(skip);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Antlr Grammar</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Antlr Grammar</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAntlrGrammar(AntlrGrammar object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Options</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Options</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOptions(Options object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Option Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Option Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOptionValue(OptionValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule(Rule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameter(Parameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleElement(RuleElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reference Or Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reference Or Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReferenceOrLiteral(ReferenceOrLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Predicated</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Predicated</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePredicated(Predicated object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Options</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Options</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleOptions(RuleOptions object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleCall(RuleCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Keyword</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Keyword</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseKeyword(Keyword object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Wildcard</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Wildcard</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWildcard(Wildcard object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Alternatives</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Alternatives</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlternatives(Alternatives object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Group</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Group</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGroup(Group object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element With Cardinality</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element With Cardinality</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElementWithCardinality(ElementWithCardinality object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Negated Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Negated Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNegatedElement(NegatedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Until Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Until Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUntilElement(UntilElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrExpression(OrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAndExpression(AndExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Not Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Not Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNotExpression(NotExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Skip</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Skip</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSkip(Skip object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //SimpleAntlrSwitch
