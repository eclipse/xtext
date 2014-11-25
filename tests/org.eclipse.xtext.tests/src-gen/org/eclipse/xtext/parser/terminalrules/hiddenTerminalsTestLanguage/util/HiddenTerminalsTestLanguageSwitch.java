/**
 */
package org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.*;

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
 * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage
 * @generated
 */
public class HiddenTerminalsTestLanguageSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static HiddenTerminalsTestLanguagePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HiddenTerminalsTestLanguageSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = HiddenTerminalsTestLanguagePackage.eINSTANCE;
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
      case HiddenTerminalsTestLanguagePackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddenTerminalsTestLanguagePackage.WITHOUT_HIDDENS:
      {
        WithoutHiddens withoutHiddens = (WithoutHiddens)theEObject;
        T result = caseWithoutHiddens(withoutHiddens);
        if (result == null) result = caseModel(withoutHiddens);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddenTerminalsTestLanguagePackage.WITH_HIDDENS:
      {
        WithHiddens withHiddens = (WithHiddens)theEObject;
        T result = caseWithHiddens(withHiddens);
        if (result == null) result = caseModel(withHiddens);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS:
      {
        OverridingHiddens overridingHiddens = (OverridingHiddens)theEObject;
        T result = caseOverridingHiddens(overridingHiddens);
        if (result == null) result = caseModel(overridingHiddens);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS_CALL:
      {
        OverridingHiddensCall overridingHiddensCall = (OverridingHiddensCall)theEObject;
        T result = caseOverridingHiddensCall(overridingHiddensCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS:
      {
        InheritingHiddens inheritingHiddens = (InheritingHiddens)theEObject;
        T result = caseInheritingHiddens(inheritingHiddens);
        if (result == null) result = caseModel(inheritingHiddens);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddenTerminalsTestLanguagePackage.DATATYPE_HIDDENS:
      {
        DatatypeHiddens datatypeHiddens = (DatatypeHiddens)theEObject;
        T result = caseDatatypeHiddens(datatypeHiddens);
        if (result == null) result = caseModel(datatypeHiddens);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddenTerminalsTestLanguagePackage.HIDING_HIDDENS:
      {
        HidingHiddens hidingHiddens = (HidingHiddens)theEObject;
        T result = caseHidingHiddens(hidingHiddens);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS_CALL:
      {
        InheritingHiddensCall inheritingHiddensCall = (InheritingHiddensCall)theEObject;
        T result = caseInheritingHiddensCall(inheritingHiddensCall);
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
   * Returns the result of interpreting the object as an instance of '<em>Without Hiddens</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Without Hiddens</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWithoutHiddens(WithoutHiddens object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>With Hiddens</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>With Hiddens</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWithHiddens(WithHiddens object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Overriding Hiddens</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Overriding Hiddens</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOverridingHiddens(OverridingHiddens object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Overriding Hiddens Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Overriding Hiddens Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOverridingHiddensCall(OverridingHiddensCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Inheriting Hiddens</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Inheriting Hiddens</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInheritingHiddens(InheritingHiddens object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Datatype Hiddens</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Datatype Hiddens</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDatatypeHiddens(DatatypeHiddens object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Hiding Hiddens</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Hiding Hiddens</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHidingHiddens(HidingHiddens object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Inheriting Hiddens Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Inheriting Hiddens Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInheritingHiddensCall(InheritingHiddensCall object)
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

} //HiddenTerminalsTestLanguageSwitch
