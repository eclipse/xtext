/**
 */
package org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.*;

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
 * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage
 * @generated
 */
public class ElementmatchertestlanguageSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ElementmatchertestlanguagePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElementmatchertestlanguageSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ElementmatchertestlanguagePackage.eINSTANCE;
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
      case ElementmatchertestlanguagePackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.SIMPLE:
      {
        Simple simple = (Simple)theEObject;
        T result = caseSimple(simple);
        if (result == null) result = caseModel(simple);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.RULE_CALLS:
      {
        RuleCalls ruleCalls = (RuleCalls)theEObject;
        T result = caseRuleCalls(ruleCalls);
        if (result == null) result = caseModel(ruleCalls);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB:
      {
        RuleCallsSub ruleCallsSub = (RuleCallsSub)theEObject;
        T result = caseRuleCallsSub(ruleCallsSub);
        if (result == null) result = caseRuleCalls(ruleCallsSub);
        if (result == null) result = caseModel(ruleCallsSub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.RULE_CALLS_ASS1:
      {
        RuleCallsAss1 ruleCallsAss1 = (RuleCallsAss1)theEObject;
        T result = caseRuleCallsAss1(ruleCallsAss1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.RULE_CALLS_ASS2:
      {
        RuleCallsAss2 ruleCallsAss2 = (RuleCallsAss2)theEObject;
        T result = caseRuleCallsAss2(ruleCallsAss2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS:
      {
        OptionalCalls optionalCalls = (OptionalCalls)theEObject;
        T result = caseOptionalCalls(optionalCalls);
        if (result == null) result = caseModel(optionalCalls);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1:
      {
        OptionalCallsSub1 optionalCallsSub1 = (OptionalCallsSub1)theEObject;
        T result = caseOptionalCallsSub1(optionalCallsSub1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB2:
      {
        OptionalCallsSub2 optionalCallsSub2 = (OptionalCallsSub2)theEObject;
        T result = caseOptionalCallsSub2(optionalCallsSub2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB3:
      {
        OptionalCallsSub3 optionalCallsSub3 = (OptionalCallsSub3)theEObject;
        T result = caseOptionalCallsSub3(optionalCallsSub3);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.RECURSION:
      {
        Recursion recursion = (Recursion)theEObject;
        T result = caseRecursion(recursion);
        if (result == null) result = caseModel(recursion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.RECURSION_SUB:
      {
        RecursionSub recursionSub = (RecursionSub)theEObject;
        T result = caseRecursionSub(recursionSub);
        if (result == null) result = caseRecursion(recursionSub);
        if (result == null) result = caseModel(recursionSub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.LOOP:
      {
        Loop loop = (Loop)theEObject;
        T result = caseLoop(loop);
        if (result == null) result = caseModel(loop);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = caseModel(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.RULE_CALLS12:
      {
        RuleCalls12 ruleCalls12 = (RuleCalls12)theEObject;
        T result = caseRuleCalls12(ruleCalls12);
        if (result == null) result = caseModel(ruleCalls12);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.CONSTRUCTOR:
      {
        Constructor constructor = (Constructor)theEObject;
        T result = caseConstructor(constructor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.FIELD:
      {
        Field field = (Field)theEObject;
        T result = caseField(field);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.PARAMETER:
      {
        Parameter parameter = (Parameter)theEObject;
        T result = caseParameter(parameter);
        if (result == null) result = caseField(parameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.NESTED_START:
      {
        NestedStart nestedStart = (NestedStart)theEObject;
        T result = caseNestedStart(nestedStart);
        if (result == null) result = caseModel(nestedStart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.NESTED_START_SUB:
      {
        NestedStartSub nestedStartSub = (NestedStartSub)theEObject;
        T result = caseNestedStartSub(nestedStartSub);
        if (result == null) result = caseNestedStart(nestedStartSub);
        if (result == null) result = caseModel(nestedStartSub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.ADD:
      {
        Add add = (Add)theEObject;
        T result = caseAdd(add);
        if (result == null) result = caseExpression(add);
        if (result == null) result = caseModel(add);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.MULT:
      {
        Mult mult = (Mult)theEObject;
        T result = caseMult(mult);
        if (result == null) result = caseExpression(mult);
        if (result == null) result = caseModel(mult);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.VALUE:
      {
        Value value = (Value)theEObject;
        T result = caseValue(value);
        if (result == null) result = caseExpression(value);
        if (result == null) result = caseModel(value);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.FUNCTION:
      {
        Function function = (Function)theEObject;
        T result = caseFunction(function);
        if (result == null) result = caseExpression(function);
        if (result == null) result = caseModel(function);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ElementmatchertestlanguagePackage.POINTER:
      {
        Pointer pointer = (Pointer)theEObject;
        T result = casePointer(pointer);
        if (result == null) result = caseExpression(pointer);
        if (result == null) result = caseModel(pointer);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimple(Simple object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Calls</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Calls</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleCalls(RuleCalls object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Calls Sub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Calls Sub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleCallsSub(RuleCallsSub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Calls Ass1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Calls Ass1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleCallsAss1(RuleCallsAss1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Calls Ass2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Calls Ass2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleCallsAss2(RuleCallsAss2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Optional Calls</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Optional Calls</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOptionalCalls(OptionalCalls object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Optional Calls Sub1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Optional Calls Sub1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOptionalCallsSub1(OptionalCallsSub1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Optional Calls Sub2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Optional Calls Sub2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOptionalCallsSub2(OptionalCallsSub2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Optional Calls Sub3</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Optional Calls Sub3</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOptionalCallsSub3(OptionalCallsSub3 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Recursion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Recursion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecursion(Recursion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Recursion Sub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Recursion Sub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecursionSub(RecursionSub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Loop</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Loop</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLoop(Loop object)
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
   * Returns the result of interpreting the object as an instance of '<em>Rule Calls12</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Calls12</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleCalls12(RuleCalls12 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constructor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constructor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstructor(Constructor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Field</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Field</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseField(Field object)
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
   * Returns the result of interpreting the object as an instance of '<em>Nested Start</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nested Start</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNestedStart(NestedStart object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Nested Start Sub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nested Start Sub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNestedStartSub(NestedStartSub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Add</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Add</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdd(Add object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mult</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mult</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMult(Mult object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValue(Value object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunction(Function object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pointer</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pointer</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePointer(Pointer object)
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

} //ElementmatchertestlanguageSwitch
