/**
 */
package org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.*;

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
 * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.ContentAssistTestLanguagePackage
 * @generated
 */
public class ContentAssistTestLanguageSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ContentAssistTestLanguagePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContentAssistTestLanguageSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ContentAssistTestLanguagePackage.eINSTANCE;
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
      case ContentAssistTestLanguagePackage.START:
      {
        Start start = (Start)theEObject;
        T result = caseStart(start);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContentAssistTestLanguagePackage.ABSTRACT_RULE:
      {
        AbstractRule abstractRule = (AbstractRule)theEObject;
        T result = caseAbstractRule(abstractRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContentAssistTestLanguagePackage.FIRST_ABSTRACT_RULE_CHILD:
      {
        FirstAbstractRuleChild firstAbstractRuleChild = (FirstAbstractRuleChild)theEObject;
        T result = caseFirstAbstractRuleChild(firstAbstractRuleChild);
        if (result == null) result = caseAbstractRule(firstAbstractRuleChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContentAssistTestLanguagePackage.SECOND_ABSTRACT_RULE_CHILD:
      {
        SecondAbstractRuleChild secondAbstractRuleChild = (SecondAbstractRuleChild)theEObject;
        T result = caseSecondAbstractRuleChild(secondAbstractRuleChild);
        if (result == null) result = caseAbstractRule(secondAbstractRuleChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContentAssistTestLanguagePackage.ABSTRACT_RULE_CALL:
      {
        AbstractRuleCall abstractRuleCall = (AbstractRuleCall)theEObject;
        T result = caseAbstractRuleCall(abstractRuleCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Start</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Start</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStart(Start object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractRule(AbstractRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>First Abstract Rule Child</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>First Abstract Rule Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFirstAbstractRuleChild(FirstAbstractRuleChild object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Second Abstract Rule Child</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Second Abstract Rule Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSecondAbstractRuleChild(SecondAbstractRuleChild object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Rule Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Rule Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractRuleCall(AbstractRuleCall object)
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

} //ContentAssistTestLanguageSwitch
