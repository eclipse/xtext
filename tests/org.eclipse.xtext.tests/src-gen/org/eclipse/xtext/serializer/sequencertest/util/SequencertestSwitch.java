/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.serializer.sequencertest.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.serializer.sequencertest.AltList1;
import org.eclipse.xtext.serializer.sequencertest.AltList2;
import org.eclipse.xtext.serializer.sequencertest.AlternativeMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative1;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative2;
import org.eclipse.xtext.serializer.sequencertest.GroupMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.List1;
import org.eclipse.xtext.serializer.sequencertest.List2;
import org.eclipse.xtext.serializer.sequencertest.Model;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywords;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywordsOrID;
import org.eclipse.xtext.serializer.sequencertest.MultiTerminals;
import org.eclipse.xtext.serializer.sequencertest.Optional;
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
public class SequencertestSwitch<T>
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
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T doSwitch(EObject theEObject)
  {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(EClass theEClass, EObject theEObject)
  {
    if (theEClass.eContainer() == modelPackage)
    {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else
    {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          defaultCase(theEObject) :
          doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
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
  public T defaultCase(EObject object)
  {
    return null;
  }

} //SequencertestSwitch
