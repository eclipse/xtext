/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.*;

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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage
 * @generated
 */
public class UnorderedGroupsTestSwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static UnorderedGroupsTestPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroupsTestSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = UnorderedGroupsTestPackage.eINSTANCE;
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
      case UnorderedGroupsTestPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UnorderedGroupsTestPackage.SIMPLE_MODEL:
      {
        SimpleModel simpleModel = (SimpleModel)theEObject;
        T result = caseSimpleModel(simpleModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UnorderedGroupsTestPackage.MANDATORY_MODEL:
      {
        MandatoryModel mandatoryModel = (MandatoryModel)theEObject;
        T result = caseMandatoryModel(mandatoryModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UnorderedGroupsTestPackage.LOOPED_MODEL:
      {
        LoopedModel loopedModel = (LoopedModel)theEObject;
        T result = caseLoopedModel(loopedModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UnorderedGroupsTestPackage.GROUP_LOOPED_MODEL:
      {
        GroupLoopedModel groupLoopedModel = (GroupLoopedModel)theEObject;
        T result = caseGroupLoopedModel(groupLoopedModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UnorderedGroupsTestPackage.BUG304681_MODEL:
      {
        Bug304681Model bug304681Model = (Bug304681Model)theEObject;
        T result = caseBug304681Model(bug304681Model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UnorderedGroupsTestPackage.BUG304681_FEATURE:
      {
        Bug304681Feature bug304681Feature = (Bug304681Feature)theEObject;
        T result = caseBug304681Feature(bug304681Feature);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UnorderedGroupsTestPackage.BUG304681_ATTRIBUTE:
      {
        Bug304681Attribute bug304681Attribute = (Bug304681Attribute)theEObject;
        T result = caseBug304681Attribute(bug304681Attribute);
        if (result == null) result = caseBug304681Feature(bug304681Attribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UnorderedGroupsTestPackage.BUG304681_REFERENCE:
      {
        Bug304681Reference bug304681Reference = (Bug304681Reference)theEObject;
        T result = caseBug304681Reference(bug304681Reference);
        if (result == null) result = caseBug304681Feature(bug304681Reference);
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
   * Returns the result of interpreting the object as an instance of '<em>Simple Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleModel(SimpleModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mandatory Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mandatory Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMandatoryModel(MandatoryModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Looped Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Looped Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLoopedModel(LoopedModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Group Looped Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Group Looped Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGroupLoopedModel(GroupLoopedModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bug304681 Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bug304681 Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBug304681Model(Bug304681Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bug304681 Feature</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bug304681 Feature</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBug304681Feature(Bug304681Feature object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bug304681 Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bug304681 Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBug304681Attribute(Bug304681Attribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bug304681 Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bug304681 Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBug304681Reference(Bug304681Reference object)
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

} //UnorderedGroupsTestSwitch
