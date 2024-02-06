/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.actionLang3.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.testlanguages.actionLang3.*;

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
 * @see org.eclipse.xtext.testlanguages.actionLang3.ActionLang3Package
 * @generated
 */
public class ActionLang3Switch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ActionLang3Package modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActionLang3Switch()
  {
    if (modelPackage == null)
    {
      modelPackage = ActionLang3Package.eINSTANCE;
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
      case ActionLang3Package.PRODUCTION_RULES:
      {
        ProductionRules productionRules = (ProductionRules)theEObject;
        T result = caseProductionRules(productionRules);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ActionLang3Package.PRODUCTION_RULE1:
      {
        ProductionRule1 productionRule1 = (ProductionRule1)theEObject;
        T result = caseProductionRule1(productionRule1);
        if (result == null) result = caseProductionRules(productionRule1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ActionLang3Package.PRODUCTION_RULE2:
      {
        ProductionRule2 productionRule2 = (ProductionRule2)theEObject;
        T result = caseProductionRule2(productionRule2);
        if (result == null) result = caseProductionRules(productionRule2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ActionLang3Package.P1:
      {
        P1 p1 = (P1)theEObject;
        T result = caseP1(p1);
        if (result == null) result = caseProductionRule1(p1);
        if (result == null) result = caseProductionRules(p1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ActionLang3Package.P2:
      {
        P2 p2 = (P2)theEObject;
        T result = caseP2(p2);
        if (result == null) result = caseProductionRule1(p2);
        if (result == null) result = caseProductionRules(p2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ActionLang3Package.P3:
      {
        P3 p3 = (P3)theEObject;
        T result = caseP3(p3);
        if (result == null) result = caseProductionRule1(p3);
        if (result == null) result = caseProductionRules(p3);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ActionLang3Package.ENTRY:
      {
        Entry entry = (Entry)theEObject;
        T result = caseEntry(entry);
        if (result == null) result = caseProductionRule2(entry);
        if (result == null) result = caseProductionRules(entry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Production Rules</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Production Rules</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProductionRules(ProductionRules object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Production Rule1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Production Rule1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProductionRule1(ProductionRule1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Production Rule2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Production Rule2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProductionRule2(ProductionRule2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>P1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>P1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseP1(P1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>P2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>P2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseP2(P2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>P3</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>P3</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseP3(P3 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEntry(Entry object)
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

} //ActionLang3Switch
