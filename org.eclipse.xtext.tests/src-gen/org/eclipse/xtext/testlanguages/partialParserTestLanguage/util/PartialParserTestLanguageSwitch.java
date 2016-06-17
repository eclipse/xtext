/**
 */
package org.eclipse.xtext.testlanguages.partialParserTestLanguage.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.testlanguages.partialParserTestLanguage.*;

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
 * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage
 * @generated
 */
public class PartialParserTestLanguageSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PartialParserTestLanguagePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartialParserTestLanguageSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = PartialParserTestLanguagePackage.eINSTANCE;
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
      case PartialParserTestLanguagePackage.SOME_CONTAINER:
      {
        SomeContainer someContainer = (SomeContainer)theEObject;
        T result = caseSomeContainer(someContainer);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialParserTestLanguagePackage.NESTED:
      {
        Nested nested = (Nested)theEObject;
        T result = caseNested(nested);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialParserTestLanguagePackage.CONTENT:
      {
        Content content = (Content)theEObject;
        T result = caseContent(content);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialParserTestLanguagePackage.CHILDREN:
      {
        Children children = (Children)theEObject;
        T result = caseChildren(children);
        if (result == null) result = caseContent(children);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialParserTestLanguagePackage.CHILD:
      {
        Child child = (Child)theEObject;
        T result = caseChild(child);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialParserTestLanguagePackage.ABSTRACT_CHILDREN:
      {
        AbstractChildren abstractChildren = (AbstractChildren)theEObject;
        T result = caseAbstractChildren(abstractChildren);
        if (result == null) result = caseContent(abstractChildren);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialParserTestLanguagePackage.ABSTRACT_CHILD:
      {
        AbstractChild abstractChild = (AbstractChild)theEObject;
        T result = caseAbstractChild(abstractChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialParserTestLanguagePackage.FIRST_CONCRETE:
      {
        FirstConcrete firstConcrete = (FirstConcrete)theEObject;
        T result = caseFirstConcrete(firstConcrete);
        if (result == null) result = caseAbstractChild(firstConcrete);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialParserTestLanguagePackage.SECOND_CONCRETE:
      {
        SecondConcrete secondConcrete = (SecondConcrete)theEObject;
        T result = caseSecondConcrete(secondConcrete);
        if (result == null) result = caseAbstractChild(secondConcrete);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialParserTestLanguagePackage.NAMED:
      {
        Named named = (Named)theEObject;
        T result = caseNamed(named);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Some Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Some Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSomeContainer(SomeContainer object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Nested</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nested</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNested(Nested object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Content</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Content</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContent(Content object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Children</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Children</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseChildren(Children object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Child</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseChild(Child object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Children</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Children</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractChildren(AbstractChildren object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Child</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractChild(AbstractChild object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>First Concrete</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>First Concrete</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFirstConcrete(FirstConcrete object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Second Concrete</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Second Concrete</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSecondConcrete(SecondConcrete object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamed(Named object)
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

} //PartialParserTestLanguageSwitch
