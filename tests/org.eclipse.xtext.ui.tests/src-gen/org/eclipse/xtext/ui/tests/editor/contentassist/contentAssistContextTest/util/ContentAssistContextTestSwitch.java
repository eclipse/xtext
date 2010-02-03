/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.*;

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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage
 * @generated
 */
public class ContentAssistContextTestSwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ContentAssistContextTestPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContentAssistContextTestSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ContentAssistContextTestPackage.eINSTANCE;
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
      case ContentAssistContextTestPackage.FIRST_LEVEL:
      {
        FirstLevel firstLevel = (FirstLevel)theEObject;
        T result = caseFirstLevel(firstLevel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContentAssistContextTestPackage.SECOND_LEVEL_A:
      {
        SecondLevelA secondLevelA = (SecondLevelA)theEObject;
        T result = caseSecondLevelA(secondLevelA);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContentAssistContextTestPackage.SECOND_LEVEL_B:
      {
        SecondLevelB secondLevelB = (SecondLevelB)theEObject;
        T result = caseSecondLevelB(secondLevelB);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContentAssistContextTestPackage.THIRD_LEVEL_A1:
      {
        ThirdLevelA1 thirdLevelA1 = (ThirdLevelA1)theEObject;
        T result = caseThirdLevelA1(thirdLevelA1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContentAssistContextTestPackage.THIRD_LEVEL_A2:
      {
        ThirdLevelA2 thirdLevelA2 = (ThirdLevelA2)theEObject;
        T result = caseThirdLevelA2(thirdLevelA2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContentAssistContextTestPackage.THIRD_LEVEL_B1:
      {
        ThirdLevelB1 thirdLevelB1 = (ThirdLevelB1)theEObject;
        T result = caseThirdLevelB1(thirdLevelB1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContentAssistContextTestPackage.THIRD_LEVEL_B2:
      {
        ThirdLevelB2 thirdLevelB2 = (ThirdLevelB2)theEObject;
        T result = caseThirdLevelB2(thirdLevelB2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>First Level</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>First Level</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFirstLevel(FirstLevel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Second Level A</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Second Level A</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSecondLevelA(SecondLevelA object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Second Level B</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Second Level B</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSecondLevelB(SecondLevelB object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Third Level A1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Third Level A1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThirdLevelA1(ThirdLevelA1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Third Level A2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Third Level A2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThirdLevelA2(ThirdLevelA2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Third Level B1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Third Level B1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThirdLevelB1(ThirdLevelB1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Third Level B2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Third Level B2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThirdLevelB2(ThirdLevelB2 object)
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

} //ContentAssistContextTestSwitch
