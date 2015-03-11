/**
 */
package org.eclipse.xtext.grammarinheritance.foo.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.grammarinheritance.ametamodel.AType;

import org.eclipse.xtext.grammarinheritance.foo.*;

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
 * @see org.eclipse.xtext.grammarinheritance.foo.FooPackage
 * @generated
 */
public class FooSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static FooPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FooSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = FooPackage.eINSTANCE;
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
      case FooPackage.ROOT_RULE:
      {
        RootRule rootRule = (RootRule)theEObject;
        T result = caseRootRule(rootRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FooPackage.CONCRETE_PARSER_RULE:
      {
        ConcreteParserRule concreteParserRule = (ConcreteParserRule)theEObject;
        T result = caseConcreteParserRule(concreteParserRule);
        if (result == null) result = caseRootRule(concreteParserRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FooPackage.CALL_OVERRIDEN_PARSER_RULE:
      {
        CallOverridenParserRule callOverridenParserRule = (CallOverridenParserRule)theEObject;
        T result = caseCallOverridenParserRule(callOverridenParserRule);
        if (result == null) result = caseRootRule(callOverridenParserRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FooPackage.ATYPE2:
      {
        AType2 aType2 = (AType2)theEObject;
        T result = caseAType2(aType2);
        if (result == null) result = caseRootRule(aType2);
        if (result == null) result = caseAType(aType2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FooPackage.SUBRULE1:
      {
        Subrule1 subrule1 = (Subrule1)theEObject;
        T result = caseSubrule1(subrule1);
        if (result == null) result = caseAType(subrule1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FooPackage.SUBRULE2:
      {
        Subrule2 subrule2 = (Subrule2)theEObject;
        T result = caseSubrule2(subrule2);
        if (result == null) result = caseAType(subrule2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FooPackage.SUBRULE3:
      {
        Subrule3 subrule3 = (Subrule3)theEObject;
        T result = caseSubrule3(subrule3);
        if (result == null) result = caseAType(subrule3);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FooPackage.CALL_EXTENDED_PARSER_RULE:
      {
        CallExtendedParserRule callExtendedParserRule = (CallExtendedParserRule)theEObject;
        T result = caseCallExtendedParserRule(callExtendedParserRule);
        if (result == null) result = caseRootRule(callExtendedParserRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Root Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Root Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRootRule(RootRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Concrete Parser Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Concrete Parser Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConcreteParserRule(ConcreteParserRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Call Overriden Parser Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Call Overriden Parser Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCallOverridenParserRule(CallOverridenParserRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>AType2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>AType2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAType2(AType2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subrule1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subrule1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubrule1(Subrule1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subrule2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subrule2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubrule2(Subrule2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subrule3</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subrule3</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubrule3(Subrule3 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Call Extended Parser Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Call Extended Parser Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCallExtendedParserRule(CallExtendedParserRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>AType</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>AType</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAType(AType object)
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

} //FooSwitch
