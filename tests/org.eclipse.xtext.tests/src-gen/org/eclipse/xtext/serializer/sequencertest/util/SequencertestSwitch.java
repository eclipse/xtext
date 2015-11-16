/**
 */
package org.eclipse.xtext.serializer.sequencertest.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.serializer.sequencertest.AltList1;
import org.eclipse.xtext.serializer.sequencertest.AltList2;
import org.eclipse.xtext.serializer.sequencertest.AlternativeMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.Complex1;
import org.eclipse.xtext.serializer.sequencertest.Delegation;
import org.eclipse.xtext.serializer.sequencertest.DelegationA;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative1;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative2;
import org.eclipse.xtext.serializer.sequencertest.FragmentCallerType;
import org.eclipse.xtext.serializer.sequencertest.GroupMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.List1;
import org.eclipse.xtext.serializer.sequencertest.List2;
import org.eclipse.xtext.serializer.sequencertest.Model;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywords;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywordsOrID;
import org.eclipse.xtext.serializer.sequencertest.MultiTerminals;
import org.eclipse.xtext.serializer.sequencertest.NullCrossRef;
import org.eclipse.xtext.serializer.sequencertest.NullValue;
import org.eclipse.xtext.serializer.sequencertest.Optional;
import org.eclipse.xtext.serializer.sequencertest.OptionalDouble;
import org.eclipse.xtext.serializer.sequencertest.ParameterCaller;
import org.eclipse.xtext.serializer.sequencertest.ParameterDelegation;
import org.eclipse.xtext.serializer.sequencertest.Parameterized;
import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;
import org.eclipse.xtext.serializer.sequencertest.SimpleAlternative;
import org.eclipse.xtext.serializer.sequencertest.SimpleGroup;
import org.eclipse.xtext.serializer.sequencertest.SimpleMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReference;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild1;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild2;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild3;
import org.eclipse.xtext.serializer.sequencertest.SingleCrossReference;
import org.eclipse.xtext.serializer.sequencertest.SingleEnum;
import org.eclipse.xtext.serializer.sequencertest.SingleKeywords;
import org.eclipse.xtext.serializer.sequencertest.SingleKeywordsOrID;
import org.eclipse.xtext.serializer.sequencertest.SingleTerminals;
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternative;
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternativeVal;
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternativeVal2;
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternativeValDelegate;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroup;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupBoolean;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupOptional;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupVal;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupVal2;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupValDelegate;

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
 * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage
 * @generated
 */
public class SequencertestSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SequencertestPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequencertestSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = SequencertestPackage.eINSTANCE;
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
      case SequencertestPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.SIMPLE_GROUP:
      {
        SimpleGroup simpleGroup = (SimpleGroup)theEObject;
        T result = caseSimpleGroup(simpleGroup);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.SIMPLE_ALTERNATIVE:
      {
        SimpleAlternative simpleAlternative = (SimpleAlternative)theEObject;
        T result = caseSimpleAlternative(simpleAlternative);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.SIMPLE_MULTIPLICITIES:
      {
        SimpleMultiplicities simpleMultiplicities = (SimpleMultiplicities)theEObject;
        T result = caseSimpleMultiplicities(simpleMultiplicities);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.GROUP_MULTIPLICITIES:
      {
        GroupMultiplicities groupMultiplicities = (GroupMultiplicities)theEObject;
        T result = caseGroupMultiplicities(groupMultiplicities);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.ALTERNATIVE_MULTIPLICITIES:
      {
        AlternativeMultiplicities alternativeMultiplicities = (AlternativeMultiplicities)theEObject;
        T result = caseAlternativeMultiplicities(alternativeMultiplicities);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.LIST1:
      {
        List1 list1 = (List1)theEObject;
        T result = caseList1(list1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.LIST2:
      {
        List2 list2 = (List2)theEObject;
        T result = caseList2(list2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.ALT_LIST1:
      {
        AltList1 altList1 = (AltList1)theEObject;
        T result = caseAltList1(altList1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.ALT_LIST2:
      {
        AltList2 altList2 = (AltList2)theEObject;
        T result = caseAltList2(altList2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.SINGLE_KEYWORDS:
      {
        SingleKeywords singleKeywords = (SingleKeywords)theEObject;
        T result = caseSingleKeywords(singleKeywords);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.SINGLE_KEYWORDS_OR_ID:
      {
        SingleKeywordsOrID singleKeywordsOrID = (SingleKeywordsOrID)theEObject;
        T result = caseSingleKeywordsOrID(singleKeywordsOrID);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.SINGLE_TERMINALS:
      {
        SingleTerminals singleTerminals = (SingleTerminals)theEObject;
        T result = caseSingleTerminals(singleTerminals);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.SINGLE_ENUM:
      {
        SingleEnum singleEnum = (SingleEnum)theEObject;
        T result = caseSingleEnum(singleEnum);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.SINGLE_CROSS_REFERENCE:
      {
        SingleCrossReference singleCrossReference = (SingleCrossReference)theEObject;
        T result = caseSingleCrossReference(singleCrossReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE:
      {
        SingleContainmentReference singleContainmentReference = (SingleContainmentReference)theEObject;
        T result = caseSingleContainmentReference(singleContainmentReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE_CHILD1:
      {
        SingleContainmentReferenceChild1 singleContainmentReferenceChild1 = (SingleContainmentReferenceChild1)theEObject;
        T result = caseSingleContainmentReferenceChild1(singleContainmentReferenceChild1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE_CHILD2:
      {
        SingleContainmentReferenceChild2 singleContainmentReferenceChild2 = (SingleContainmentReferenceChild2)theEObject;
        T result = caseSingleContainmentReferenceChild2(singleContainmentReferenceChild2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE_CHILD3:
      {
        SingleContainmentReferenceChild3 singleContainmentReferenceChild3 = (SingleContainmentReferenceChild3)theEObject;
        T result = caseSingleContainmentReferenceChild3(singleContainmentReferenceChild3);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.MULTI_KEYWORDS:
      {
        MultiKeywords multiKeywords = (MultiKeywords)theEObject;
        T result = caseMultiKeywords(multiKeywords);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.MULTI_KEYWORDS_OR_ID:
      {
        MultiKeywordsOrID multiKeywordsOrID = (MultiKeywordsOrID)theEObject;
        T result = caseMultiKeywordsOrID(multiKeywordsOrID);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.MULTI_TERMINALS:
      {
        MultiTerminals multiTerminals = (MultiTerminals)theEObject;
        T result = caseMultiTerminals(multiTerminals);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.DEPENDENT_ALTERNATIVE1:
      {
        DependentAlternative1 dependentAlternative1 = (DependentAlternative1)theEObject;
        T result = caseDependentAlternative1(dependentAlternative1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.DEPENDENT_ALTERNATIVE2:
      {
        DependentAlternative2 dependentAlternative2 = (DependentAlternative2)theEObject;
        T result = caseDependentAlternative2(dependentAlternative2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.OPTIONAL:
      {
        Optional optional = (Optional)theEObject;
        T result = caseOptional(optional);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.FLOAT:
      {
        org.eclipse.xtext.serializer.sequencertest.Float float_ = (org.eclipse.xtext.serializer.sequencertest.Float)theEObject;
        T result = caseFloat(float_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.UNORDERED_ALTERNATIVE:
      {
        UnorderedAlternative unorderedAlternative = (UnorderedAlternative)theEObject;
        T result = caseUnorderedAlternative(unorderedAlternative);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.UNORDERED_ALTERNATIVE_VAL:
      {
        UnorderedAlternativeVal unorderedAlternativeVal = (UnorderedAlternativeVal)theEObject;
        T result = caseUnorderedAlternativeVal(unorderedAlternativeVal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.UNORDERED_ALTERNATIVE_VAL_DELEGATE:
      {
        UnorderedAlternativeValDelegate unorderedAlternativeValDelegate = (UnorderedAlternativeValDelegate)theEObject;
        T result = caseUnorderedAlternativeValDelegate(unorderedAlternativeValDelegate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.UNORDERED_ALTERNATIVE_VAL2:
      {
        UnorderedAlternativeVal2 unorderedAlternativeVal2 = (UnorderedAlternativeVal2)theEObject;
        T result = caseUnorderedAlternativeVal2(unorderedAlternativeVal2);
        if (result == null) result = caseUnorderedAlternativeValDelegate(unorderedAlternativeVal2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.UNORDERED_GROUP:
      {
        UnorderedGroup unorderedGroup = (UnorderedGroup)theEObject;
        T result = caseUnorderedGroup(unorderedGroup);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.UNORDERED_GROUP_VAL:
      {
        UnorderedGroupVal unorderedGroupVal = (UnorderedGroupVal)theEObject;
        T result = caseUnorderedGroupVal(unorderedGroupVal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.UNORDERED_GROUP_VAL_DELEGATE:
      {
        UnorderedGroupValDelegate unorderedGroupValDelegate = (UnorderedGroupValDelegate)theEObject;
        T result = caseUnorderedGroupValDelegate(unorderedGroupValDelegate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.UNORDERED_GROUP_VAL2:
      {
        UnorderedGroupVal2 unorderedGroupVal2 = (UnorderedGroupVal2)theEObject;
        T result = caseUnorderedGroupVal2(unorderedGroupVal2);
        if (result == null) result = caseUnorderedGroupValDelegate(unorderedGroupVal2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.UNORDERED_GROUP_OPTIONAL:
      {
        UnorderedGroupOptional unorderedGroupOptional = (UnorderedGroupOptional)theEObject;
        T result = caseUnorderedGroupOptional(unorderedGroupOptional);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.UNORDERED_GROUP_BOOLEAN:
      {
        UnorderedGroupBoolean unorderedGroupBoolean = (UnorderedGroupBoolean)theEObject;
        T result = caseUnorderedGroupBoolean(unorderedGroupBoolean);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.COMPLEX1:
      {
        Complex1 complex1 = (Complex1)theEObject;
        T result = caseComplex1(complex1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.OPTIONAL_DOUBLE:
      {
        OptionalDouble optionalDouble = (OptionalDouble)theEObject;
        T result = caseOptionalDouble(optionalDouble);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.NULL_VALUE:
      {
        NullValue nullValue = (NullValue)theEObject;
        T result = caseNullValue(nullValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.NULL_CROSS_REF:
      {
        NullCrossRef nullCrossRef = (NullCrossRef)theEObject;
        T result = caseNullCrossRef(nullCrossRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.FRAGMENT_CALLER_TYPE:
      {
        FragmentCallerType fragmentCallerType = (FragmentCallerType)theEObject;
        T result = caseFragmentCallerType(fragmentCallerType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.PARAMETER_CALLER:
      {
        ParameterCaller parameterCaller = (ParameterCaller)theEObject;
        T result = caseParameterCaller(parameterCaller);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.PARAMETERIZED:
      {
        Parameterized parameterized = (Parameterized)theEObject;
        T result = caseParameterized(parameterized);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.PARAMETER_DELEGATION:
      {
        ParameterDelegation parameterDelegation = (ParameterDelegation)theEObject;
        T result = caseParameterDelegation(parameterDelegation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.DELEGATION:
      {
        Delegation delegation = (Delegation)theEObject;
        T result = caseDelegation(delegation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SequencertestPackage.DELEGATION_A:
      {
        DelegationA delegationA = (DelegationA)theEObject;
        T result = caseDelegationA(delegationA);
        if (result == null) result = caseDelegation(delegationA);
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
   * Returns the result of interpreting the object as an instance of '<em>Single Keywords</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Keywords</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSingleKeywords(SingleKeywords object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Single Keywords Or ID</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Keywords Or ID</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSingleKeywordsOrID(SingleKeywordsOrID object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Single Terminals</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Terminals</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSingleTerminals(SingleTerminals object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Single Enum</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Enum</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSingleEnum(SingleEnum object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Single Cross Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Cross Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSingleCrossReference(SingleCrossReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Single Containment Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Containment Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSingleContainmentReference(SingleContainmentReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Single Containment Reference Child1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Containment Reference Child1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSingleContainmentReferenceChild1(SingleContainmentReferenceChild1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Single Containment Reference Child2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Containment Reference Child2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSingleContainmentReferenceChild2(SingleContainmentReferenceChild2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Single Containment Reference Child3</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Containment Reference Child3</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSingleContainmentReferenceChild3(SingleContainmentReferenceChild3 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multi Keywords</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multi Keywords</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiKeywords(MultiKeywords object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multi Keywords Or ID</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multi Keywords Or ID</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiKeywordsOrID(MultiKeywordsOrID object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multi Terminals</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multi Terminals</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiTerminals(MultiTerminals object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Dependent Alternative1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dependent Alternative1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDependentAlternative1(DependentAlternative1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Dependent Alternative2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dependent Alternative2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDependentAlternative2(DependentAlternative2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Optional</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Optional</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOptional(Optional object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Float</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Float</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFloat(org.eclipse.xtext.serializer.sequencertest.Float object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unordered Alternative</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unordered Alternative</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnorderedAlternative(UnorderedAlternative object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unordered Alternative Val</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unordered Alternative Val</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnorderedAlternativeVal(UnorderedAlternativeVal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unordered Alternative Val Delegate</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unordered Alternative Val Delegate</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnorderedAlternativeValDelegate(UnorderedAlternativeValDelegate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unordered Alternative Val2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unordered Alternative Val2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnorderedAlternativeVal2(UnorderedAlternativeVal2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unordered Group</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unordered Group</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnorderedGroup(UnorderedGroup object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unordered Group Val</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unordered Group Val</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnorderedGroupVal(UnorderedGroupVal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unordered Group Val Delegate</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unordered Group Val Delegate</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnorderedGroupValDelegate(UnorderedGroupValDelegate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unordered Group Val2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unordered Group Val2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnorderedGroupVal2(UnorderedGroupVal2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unordered Group Optional</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unordered Group Optional</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnorderedGroupOptional(UnorderedGroupOptional object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unordered Group Boolean</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unordered Group Boolean</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnorderedGroupBoolean(UnorderedGroupBoolean object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Complex1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Complex1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComplex1(Complex1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Optional Double</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Optional Double</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOptionalDouble(OptionalDouble object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Null Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Null Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNullValue(NullValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Null Cross Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Null Cross Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNullCrossRef(NullCrossRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fragment Caller Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fragment Caller Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFragmentCallerType(FragmentCallerType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter Caller</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter Caller</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterCaller(ParameterCaller object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameterized</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameterized</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterized(Parameterized object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter Delegation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter Delegation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterDelegation(ParameterDelegation object)
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
   * Returns the result of interpreting the object as an instance of '<em>Delegation A</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Delegation A</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDelegationA(DelegationA object)
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

} //SequencertestSwitch
