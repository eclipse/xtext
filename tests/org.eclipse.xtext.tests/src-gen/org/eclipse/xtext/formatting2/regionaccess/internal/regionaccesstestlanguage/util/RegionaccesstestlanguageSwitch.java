/**
 */
package org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Action;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Add;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegate;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegation;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Expression;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Named;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedDelegate;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedUnassigned;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Simple;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Unassigned;

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
 * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage
 * @generated
 */
public class RegionaccesstestlanguageSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static RegionaccesstestlanguagePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RegionaccesstestlanguageSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = RegionaccesstestlanguagePackage.eINSTANCE;
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
      case RegionaccesstestlanguagePackage.ROOT:
      {
        Root root = (Root)theEObject;
        T result = caseRoot(root);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RegionaccesstestlanguagePackage.SIMPLE:
      {
        Simple simple = (Simple)theEObject;
        T result = caseSimple(simple);
        if (result == null) result = caseRoot(simple);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RegionaccesstestlanguagePackage.DELEGATION:
      {
        Delegation delegation = (Delegation)theEObject;
        T result = caseDelegation(delegation);
        if (result == null) result = caseRoot(delegation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RegionaccesstestlanguagePackage.UNASSIGNED:
      {
        Unassigned unassigned = (Unassigned)theEObject;
        T result = caseUnassigned(unassigned);
        if (result == null) result = caseRoot(unassigned);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RegionaccesstestlanguagePackage.PREFIXED_UNASSIGNED:
      {
        PrefixedUnassigned prefixedUnassigned = (PrefixedUnassigned)theEObject;
        T result = casePrefixedUnassigned(prefixedUnassigned);
        if (result == null) result = caseRoot(prefixedUnassigned);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RegionaccesstestlanguagePackage.PREFIXED_DELEGATE:
      {
        PrefixedDelegate prefixedDelegate = (PrefixedDelegate)theEObject;
        T result = casePrefixedDelegate(prefixedDelegate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RegionaccesstestlanguagePackage.DELEGATE:
      {
        Delegate delegate = (Delegate)theEObject;
        T result = caseDelegate(delegate);
        if (result == null) result = caseUnassigned(delegate);
        if (result == null) result = casePrefixedDelegate(delegate);
        if (result == null) result = caseRoot(delegate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RegionaccesstestlanguagePackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = caseRoot(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RegionaccesstestlanguagePackage.MIXED:
      {
        Mixed mixed = (Mixed)theEObject;
        T result = caseMixed(mixed);
        if (result == null) result = caseRoot(mixed);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RegionaccesstestlanguagePackage.ADD:
      {
        Add add = (Add)theEObject;
        T result = caseAdd(add);
        if (result == null) result = caseExpression(add);
        if (result == null) result = caseRoot(add);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RegionaccesstestlanguagePackage.NAMED:
      {
        Named named = (Named)theEObject;
        T result = caseNamed(named);
        if (result == null) result = caseExpression(named);
        if (result == null) result = caseRoot(named);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RegionaccesstestlanguagePackage.ACTION:
      {
        Action action = (Action)theEObject;
        T result = caseAction(action);
        if (result == null) result = caseMixed(action);
        if (result == null) result = caseRoot(action);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RegionaccesstestlanguagePackage.ASSIGNED_ACTION:
      {
        AssignedAction assignedAction = (AssignedAction)theEObject;
        T result = caseAssignedAction(assignedAction);
        if (result == null) result = caseMixed(assignedAction);
        if (result == null) result = caseRoot(assignedAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoot(Root object)
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
   * Returns the result of interpreting the object as an instance of '<em>Delegation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Delegation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDelegation(Delegation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unassigned</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unassigned</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnassigned(Unassigned object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Prefixed Unassigned</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Prefixed Unassigned</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrefixedUnassigned(PrefixedUnassigned object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Prefixed Delegate</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Prefixed Delegate</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrefixedDelegate(PrefixedDelegate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Delegate</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Delegate</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDelegate(Delegate object)
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
   * Returns the result of interpreting the object as an instance of '<em>Mixed</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mixed</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMixed(Mixed object)
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
   * Returns the result of interpreting the object as an instance of '<em>Named</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamed(Named object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAction(Action object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assigned Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assigned Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignedAction(AssignedAction object)
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

} //RegionaccesstestlanguageSwitch
