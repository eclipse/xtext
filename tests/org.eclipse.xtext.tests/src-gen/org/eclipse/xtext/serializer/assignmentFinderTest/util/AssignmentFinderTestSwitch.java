/**
 */
package org.eclipse.xtext.serializer.assignmentFinderTest.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.serializer.assignmentFinderTest.*;

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
 * @see org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestPackage
 * @generated
 */
public class AssignmentFinderTestSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AssignmentFinderTestPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentFinderTestSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = AssignmentFinderTestPackage.eINSTANCE;
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
      case AssignmentFinderTestPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AssignmentFinderTestPackage.KEYWORD_VAL:
      {
        KeywordVal keywordVal = (KeywordVal)theEObject;
        T result = caseKeywordVal(keywordVal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AssignmentFinderTestPackage.TERMINAL_VAL:
      {
        TerminalVal terminalVal = (TerminalVal)theEObject;
        T result = caseTerminalVal(terminalVal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AssignmentFinderTestPackage.ENUM_VAL:
      {
        EnumVal enumVal = (EnumVal)theEObject;
        T result = caseEnumVal(enumVal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AssignmentFinderTestPackage.KEYWORD_BOOL:
      {
        KeywordBool keywordBool = (KeywordBool)theEObject;
        T result = caseKeywordBool(keywordBool);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AssignmentFinderTestPackage.TERMINAL_BOOL:
      {
        TerminalBool terminalBool = (TerminalBool)theEObject;
        T result = caseTerminalBool(terminalBool);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AssignmentFinderTestPackage.ENUM_BOOL:
      {
        EnumBool enumBool = (EnumBool)theEObject;
        T result = caseEnumBool(enumBool);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AssignmentFinderTestPackage.MIXED_BOOL:
      {
        MixedBool mixedBool = (MixedBool)theEObject;
        T result = caseMixedBool(mixedBool);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AssignmentFinderTestPackage.MIXED_VALUE:
      {
        MixedValue mixedValue = (MixedValue)theEObject;
        T result = caseMixedValue(mixedValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AssignmentFinderTestPackage.CONTAINMENT_REF:
      {
        ContainmentRef containmentRef = (ContainmentRef)theEObject;
        T result = caseContainmentRef(containmentRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AssignmentFinderTestPackage.CONTAINMENT_REF_N:
      {
        ContainmentRefN containmentRefN = (ContainmentRefN)theEObject;
        T result = caseContainmentRefN(containmentRefN);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AssignmentFinderTestPackage.CROSS_REF:
      {
        CrossRef crossRef = (CrossRef)theEObject;
        T result = caseCrossRef(crossRef);
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
   * Returns the result of interpreting the object as an instance of '<em>Keyword Val</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Keyword Val</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseKeywordVal(KeywordVal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Terminal Val</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Terminal Val</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTerminalVal(TerminalVal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Val</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Val</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumVal(EnumVal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Keyword Bool</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Keyword Bool</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseKeywordBool(KeywordBool object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Terminal Bool</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Terminal Bool</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTerminalBool(TerminalBool object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Bool</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Bool</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumBool(EnumBool object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mixed Bool</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mixed Bool</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMixedBool(MixedBool object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mixed Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mixed Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMixedValue(MixedValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Containment Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Containment Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContainmentRef(ContainmentRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Containment Ref N</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Containment Ref N</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContainmentRefN(ContainmentRefN object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cross Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cross Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCrossRef(CrossRef object)
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

} //AssignmentFinderTestSwitch
