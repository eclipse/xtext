/**
 */
package org.eclipse.xtext.validation.csvalidationtest.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.validation.csvalidationtest.*;

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
 * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage
 * @generated
 */
public class CsvalidationtestSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static CsvalidationtestPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CsvalidationtestSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = CsvalidationtestPackage.eINSTANCE;
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
      case CsvalidationtestPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.SIMPLE_GROUP:
      {
        SimpleGroup simpleGroup = (SimpleGroup)theEObject;
        T result = caseSimpleGroup(simpleGroup);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.SIMPLE_ALTERNATIVE:
      {
        SimpleAlternative simpleAlternative = (SimpleAlternative)theEObject;
        T result = caseSimpleAlternative(simpleAlternative);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.SIMPLE_MULTIPLICITIES:
      {
        SimpleMultiplicities simpleMultiplicities = (SimpleMultiplicities)theEObject;
        T result = caseSimpleMultiplicities(simpleMultiplicities);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.GROUP_MULTIPLICITIES:
      {
        GroupMultiplicities groupMultiplicities = (GroupMultiplicities)theEObject;
        T result = caseGroupMultiplicities(groupMultiplicities);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.ALTERNATIVE_MULTIPLICITIES:
      {
        AlternativeMultiplicities alternativeMultiplicities = (AlternativeMultiplicities)theEObject;
        T result = caseAlternativeMultiplicities(alternativeMultiplicities);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.ASSIGNED_ACTION:
      {
        AssignedAction assignedAction = (AssignedAction)theEObject;
        T result = caseAssignedAction(assignedAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.UNASSIGNED_ACTION1:
      {
        UnassignedAction1 unassignedAction1 = (UnassignedAction1)theEObject;
        T result = caseUnassignedAction1(unassignedAction1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.UNASSIGNED_ACTION2:
      {
        UnassignedAction2 unassignedAction2 = (UnassignedAction2)theEObject;
        T result = caseUnassignedAction2(unassignedAction2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.UNASSIGNED_ACTION3:
      {
        UnassignedAction3 unassignedAction3 = (UnassignedAction3)theEObject;
        T result = caseUnassignedAction3(unassignedAction3);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.UNASSIGNED_RULE_CALL1:
      {
        UnassignedRuleCall1 unassignedRuleCall1 = (UnassignedRuleCall1)theEObject;
        T result = caseUnassignedRuleCall1(unassignedRuleCall1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.UNASSIGNED_RULE_CALL1_SUB:
      {
        UnassignedRuleCall1Sub unassignedRuleCall1Sub = (UnassignedRuleCall1Sub)theEObject;
        T result = caseUnassignedRuleCall1Sub(unassignedRuleCall1Sub);
        if (result == null) result = caseUnassignedRuleCall1(unassignedRuleCall1Sub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.UNASSIGNED_RULE_CALL2:
      {
        UnassignedRuleCall2 unassignedRuleCall2 = (UnassignedRuleCall2)theEObject;
        T result = caseUnassignedRuleCall2(unassignedRuleCall2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.UNASSIGNED_RULE_CALL2_SUB:
      {
        UnassignedRuleCall2Sub unassignedRuleCall2Sub = (UnassignedRuleCall2Sub)theEObject;
        T result = caseUnassignedRuleCall2Sub(unassignedRuleCall2Sub);
        if (result == null) result = caseUnassignedRuleCall2(unassignedRuleCall2Sub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.COMBINATION1:
      {
        Combination1 combination1 = (Combination1)theEObject;
        T result = caseCombination1(combination1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.COMBINATION2:
      {
        Combination2 combination2 = (Combination2)theEObject;
        T result = caseCombination2(combination2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.COMBINATION3:
      {
        Combination3 combination3 = (Combination3)theEObject;
        T result = caseCombination3(combination3);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.COMBINATION4:
      {
        Combination4 combination4 = (Combination4)theEObject;
        T result = caseCombination4(combination4);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.LIST1:
      {
        List1 list1 = (List1)theEObject;
        T result = caseList1(list1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.LIST2:
      {
        List2 list2 = (List2)theEObject;
        T result = caseList2(list2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.LIST3:
      {
        List3 list3 = (List3)theEObject;
        T result = caseList3(list3);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.LIST4:
      {
        List4 list4 = (List4)theEObject;
        T result = caseList4(list4);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.LIST5:
      {
        List5 list5 = (List5)theEObject;
        T result = caseList5(list5);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.ALT_LIST1:
      {
        AltList1 altList1 = (AltList1)theEObject;
        T result = caseAltList1(altList1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.ALT_LIST2:
      {
        AltList2 altList2 = (AltList2)theEObject;
        T result = caseAltList2(altList2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.TRANSIENT_OBJECT:
      {
        TransientObject transientObject = (TransientObject)theEObject;
        T result = caseTransientObject(transientObject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.TRANSIENT_OBJECT_SUB:
      {
        TransientObjectSub transientObjectSub = (TransientObjectSub)theEObject;
        T result = caseTransientObjectSub(transientObjectSub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1:
      {
        TransientSerializeables1 transientSerializeables1 = (TransientSerializeables1)theEObject;
        T result = caseTransientSerializeables1(transientSerializeables1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.STATIC_SIMPLIFICATION:
      {
        StaticSimplification staticSimplification = (StaticSimplification)theEObject;
        T result = caseStaticSimplification(staticSimplification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.TWO_VERSION:
      {
        TwoVersion twoVersion = (TwoVersion)theEObject;
        T result = caseTwoVersion(twoVersion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.HEURISTIC1:
      {
        Heuristic1 heuristic1 = (Heuristic1)theEObject;
        T result = caseHeuristic1(heuristic1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.UNASSIGNED_ACTION2_SUB:
      {
        UnassignedAction2Sub unassignedAction2Sub = (UnassignedAction2Sub)theEObject;
        T result = caseUnassignedAction2Sub(unassignedAction2Sub);
        if (result == null) result = caseUnassignedAction2(unassignedAction2Sub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.UNASSIGNED_ACTION2_SUB1:
      {
        UnassignedAction2Sub1 unassignedAction2Sub1 = (UnassignedAction2Sub1)theEObject;
        T result = caseUnassignedAction2Sub1(unassignedAction2Sub1);
        if (result == null) result = caseUnassignedAction3(unassignedAction2Sub1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.UNASSIGNED_ACTION2_SUB2:
      {
        UnassignedAction2Sub2 unassignedAction2Sub2 = (UnassignedAction2Sub2)theEObject;
        T result = caseUnassignedAction2Sub2(unassignedAction2Sub2);
        if (result == null) result = caseUnassignedAction3(unassignedAction2Sub2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.UNASSIGNED_RULE_CALL2_SUB_ACTION:
      {
        UnassignedRuleCall2SubAction unassignedRuleCall2SubAction = (UnassignedRuleCall2SubAction)theEObject;
        T result = caseUnassignedRuleCall2SubAction(unassignedRuleCall2SubAction);
        if (result == null) result = caseUnassignedRuleCall2Sub(unassignedRuleCall2SubAction);
        if (result == null) result = caseUnassignedRuleCall2(unassignedRuleCall2SubAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CsvalidationtestPackage.EMPTY_ALTERNATIVE_SUB:
      {
        EmptyAlternativeSub emptyAlternativeSub = (EmptyAlternativeSub)theEObject;
        T result = caseEmptyAlternativeSub(emptyAlternativeSub);
        if (result == null) result = caseStaticSimplification(emptyAlternativeSub);
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
   * Returns the result of interpreting the object as an instance of '<em>Simple Group</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Group</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleGroup(SimpleGroup object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Alternative</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Alternative</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleAlternative(SimpleAlternative object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Multiplicities</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Multiplicities</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleMultiplicities(SimpleMultiplicities object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Group Multiplicities</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Group Multiplicities</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGroupMultiplicities(GroupMultiplicities object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Alternative Multiplicities</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Alternative Multiplicities</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlternativeMultiplicities(AlternativeMultiplicities object)
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
   * Returns the result of interpreting the object as an instance of '<em>Unassigned Action1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unassigned Action1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnassignedAction1(UnassignedAction1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unassigned Action2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unassigned Action2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnassignedAction2(UnassignedAction2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unassigned Action3</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unassigned Action3</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnassignedAction3(UnassignedAction3 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unassigned Rule Call1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unassigned Rule Call1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnassignedRuleCall1(UnassignedRuleCall1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unassigned Rule Call1 Sub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unassigned Rule Call1 Sub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnassignedRuleCall1Sub(UnassignedRuleCall1Sub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unassigned Rule Call2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unassigned Rule Call2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnassignedRuleCall2(UnassignedRuleCall2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unassigned Rule Call2 Sub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unassigned Rule Call2 Sub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnassignedRuleCall2Sub(UnassignedRuleCall2Sub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Combination1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Combination1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCombination1(Combination1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Combination2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Combination2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCombination2(Combination2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Combination3</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Combination3</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCombination3(Combination3 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Combination4</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Combination4</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCombination4(Combination4 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseList1(List1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseList2(List2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List3</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List3</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseList3(List3 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List4</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List4</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseList4(List4 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List5</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List5</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseList5(List5 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Alt List1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Alt List1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAltList1(AltList1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Alt List2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Alt List2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAltList2(AltList2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transient Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transient Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransientObject(TransientObject object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transient Object Sub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transient Object Sub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransientObjectSub(TransientObjectSub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transient Serializeables1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transient Serializeables1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransientSerializeables1(TransientSerializeables1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Static Simplification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Static Simplification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStaticSimplification(StaticSimplification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Two Version</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Two Version</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTwoVersion(TwoVersion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Heuristic1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Heuristic1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHeuristic1(Heuristic1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unassigned Action2 Sub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unassigned Action2 Sub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnassignedAction2Sub(UnassignedAction2Sub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unassigned Action2 Sub1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unassigned Action2 Sub1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnassignedAction2Sub1(UnassignedAction2Sub1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unassigned Action2 Sub2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unassigned Action2 Sub2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnassignedAction2Sub2(UnassignedAction2Sub2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unassigned Rule Call2 Sub Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unassigned Rule Call2 Sub Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnassignedRuleCall2SubAction(UnassignedRuleCall2SubAction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Empty Alternative Sub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Empty Alternative Sub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEmptyAlternativeSub(EmptyAlternativeSub object)
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

} //CsvalidationtestSwitch
