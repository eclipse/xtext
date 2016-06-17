/**
 */
package org.eclipse.xtext.testlanguages.lookaheadLang.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.testlanguages.lookaheadLang.*;

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
 * @see org.eclipse.xtext.testlanguages.lookaheadLang.LookaheadLangPackage
 * @generated
 */
public class LookaheadLangSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static LookaheadLangPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LookaheadLangSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = LookaheadLangPackage.eINSTANCE;
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
      case LookaheadLangPackage.ENTRY:
      {
        Entry entry = (Entry)theEObject;
        T result = caseEntry(entry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LookaheadLangPackage.ALTS:
      {
        Alts alts = (Alts)theEObject;
        T result = caseAlts(alts);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LookaheadLangPackage.LOOK_AHEAD0:
      {
        LookAhead0 lookAhead0 = (LookAhead0)theEObject;
        T result = caseLookAhead0(lookAhead0);
        if (result == null) result = caseAlts(lookAhead0);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LookaheadLangPackage.LOOK_AHEAD1:
      {
        LookAhead1 lookAhead1 = (LookAhead1)theEObject;
        T result = caseLookAhead1(lookAhead1);
        if (result == null) result = caseAlts(lookAhead1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LookaheadLangPackage.LOOK_AHEAD2:
      {
        LookAhead2 lookAhead2 = (LookAhead2)theEObject;
        T result = caseLookAhead2(lookAhead2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LookaheadLangPackage.LOOK_AHEAD3:
      {
        LookAhead3 lookAhead3 = (LookAhead3)theEObject;
        T result = caseLookAhead3(lookAhead3);
        if (result == null) result = caseAlts(lookAhead3);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LookaheadLangPackage.LOOK_AHEAD4:
      {
        LookAhead4 lookAhead4 = (LookAhead4)theEObject;
        T result = caseLookAhead4(lookAhead4);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
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
   * Returns the result of interpreting the object as an instance of '<em>Alts</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Alts</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlts(Alts object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Look Ahead0</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Look Ahead0</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLookAhead0(LookAhead0 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Look Ahead1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Look Ahead1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLookAhead1(LookAhead1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Look Ahead2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Look Ahead2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLookAhead2(LookAhead2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Look Ahead3</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Look Ahead3</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLookAhead3(LookAhead3 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Look Ahead4</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Look Ahead4</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLookAhead4(LookAhead4 object)
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

} //LookaheadLangSwitch
