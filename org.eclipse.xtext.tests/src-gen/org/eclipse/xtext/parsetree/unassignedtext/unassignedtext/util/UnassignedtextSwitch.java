/**
 */
package org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.*;

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
 * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.UnassignedtextPackage
 * @generated
 */
public class UnassignedtextSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static UnassignedtextPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedtextSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = UnassignedtextPackage.eINSTANCE;
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
      case UnassignedtextPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UnassignedtextPackage.CASE_INSENSITIVE_KEYWORD_RULE:
      {
        CaseInsensitiveKeywordRule caseInsensitiveKeywordRule = (CaseInsensitiveKeywordRule)theEObject;
        T result = caseCaseInsensitiveKeywordRule(caseInsensitiveKeywordRule);
        if (result == null) result = caseModel(caseInsensitiveKeywordRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UnassignedtextPackage.PLURAL_RULE:
      {
        PluralRule pluralRule = (PluralRule)theEObject;
        T result = casePluralRule(pluralRule);
        if (result == null) result = caseModel(pluralRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UnassignedtextPackage.MULTI_RULE:
      {
        MultiRule multiRule = (MultiRule)theEObject;
        T result = caseMultiRule(multiRule);
        if (result == null) result = caseModel(multiRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UnassignedtextPackage.DATATYPE_RULE:
      {
        DatatypeRule datatypeRule = (DatatypeRule)theEObject;
        T result = caseDatatypeRule(datatypeRule);
        if (result == null) result = caseModel(datatypeRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UnassignedtextPackage.COMMON_TERMINALS_RULE:
      {
        CommonTerminalsRule commonTerminalsRule = (CommonTerminalsRule)theEObject;
        T result = caseCommonTerminalsRule(commonTerminalsRule);
        if (result == null) result = caseModel(commonTerminalsRule);
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
   * Returns the result of interpreting the object as an instance of '<em>Case Insensitive Keyword Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Case Insensitive Keyword Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCaseInsensitiveKeywordRule(CaseInsensitiveKeywordRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Plural Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Plural Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePluralRule(PluralRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multi Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multi Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiRule(MultiRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Datatype Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Datatype Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDatatypeRule(DatatypeRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Common Terminals Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Common Terminals Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommonTerminalsRule(CommonTerminalsRule object)
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

} //UnassignedtextSwitch
