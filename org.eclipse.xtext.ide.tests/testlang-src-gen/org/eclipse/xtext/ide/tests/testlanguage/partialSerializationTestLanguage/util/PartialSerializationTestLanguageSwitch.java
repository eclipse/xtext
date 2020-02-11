/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.*;

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
 * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage
 * @generated
 */
public class PartialSerializationTestLanguageSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PartialSerializationTestLanguagePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartialSerializationTestLanguageSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = PartialSerializationTestLanguagePackage.eINSTANCE;
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
      case PartialSerializationTestLanguagePackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.MANDATORY_VALUE:
      {
        MandatoryValue mandatoryValue = (MandatoryValue)theEObject;
        T result = caseMandatoryValue(mandatoryValue);
        if (result == null) result = caseModel(mandatoryValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.OPTIONAL_VALUE:
      {
        OptionalValue optionalValue = (OptionalValue)theEObject;
        T result = caseOptionalValue(optionalValue);
        if (result == null) result = caseModel(optionalValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.MANY_OPTIONAL_VALUES:
      {
        ManyOptionalValues manyOptionalValues = (ManyOptionalValues)theEObject;
        T result = caseManyOptionalValues(manyOptionalValues);
        if (result == null) result = caseModel(manyOptionalValues);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.MANY_MANDATORY_VALUES:
      {
        ManyMandatoryValues manyMandatoryValues = (ManyMandatoryValues)theEObject;
        T result = caseManyMandatoryValues(manyMandatoryValues);
        if (result == null) result = caseModel(manyMandatoryValues);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.MANDATORY_CHILD:
      {
        MandatoryChild mandatoryChild = (MandatoryChild)theEObject;
        T result = caseMandatoryChild(mandatoryChild);
        if (result == null) result = caseModel(mandatoryChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.OPTIONAL_CHILD:
      {
        OptionalChild optionalChild = (OptionalChild)theEObject;
        T result = caseOptionalChild(optionalChild);
        if (result == null) result = caseModel(optionalChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.TWO_CHILD_LISTS:
      {
        TwoChildLists twoChildLists = (TwoChildLists)theEObject;
        T result = caseTwoChildLists(twoChildLists);
        if (result == null) result = caseModel(twoChildLists);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.TWO_CHILDS:
      {
        TwoChilds twoChilds = (TwoChilds)theEObject;
        T result = caseTwoChilds(twoChilds);
        if (result == null) result = caseModel(twoChilds);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.CHILD_WITH_SUB_CHILDS:
      {
        ChildWithSubChilds childWithSubChilds = (ChildWithSubChilds)theEObject;
        T result = caseChildWithSubChilds(childWithSubChilds);
        if (result == null) result = caseModel(childWithSubChilds);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.CHILD_WITH_SUB_CHILD:
      {
        ChildWithSubChild childWithSubChild = (ChildWithSubChild)theEObject;
        T result = caseChildWithSubChild(childWithSubChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.SUB_CHILD:
      {
        SubChild subChild = (SubChild)theEObject;
        T result = caseSubChild(subChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.MANDATORY_CHILD_LIST:
      {
        MandatoryChildList mandatoryChildList = (MandatoryChildList)theEObject;
        T result = caseMandatoryChildList(mandatoryChildList);
        if (result == null) result = caseModel(mandatoryChildList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.OPTIONAL_CHILD_LIST:
      {
        OptionalChildList optionalChildList = (OptionalChildList)theEObject;
        T result = caseOptionalChildList(optionalChildList);
        if (result == null) result = caseModel(optionalChildList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.NODE:
      {
        Node node = (Node)theEObject;
        T result = caseNode(node);
        if (result == null) result = caseModel(node);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.ECLASS_REF:
      {
        EClassRef eClassRef = (EClassRef)theEObject;
        T result = caseEClassRef(eClassRef);
        if (result == null) result = caseModel(eClassRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.WITH_TRANSIENT_CONTAINER:
      {
        WithTransientContainer withTransientContainer = (WithTransientContainer)theEObject;
        T result = caseWithTransientContainer(withTransientContainer);
        if (result == null) result = caseModel(withTransientContainer);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PartialSerializationTestLanguagePackage.MANY_VALUES:
      {
        ManyValues manyValues = (ManyValues)theEObject;
        T result = caseManyValues(manyValues);
        if (result == null) result = caseManyOptionalValues(manyValues);
        if (result == null) result = caseModel(manyValues);
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
   * Returns the result of interpreting the object as an instance of '<em>Mandatory Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mandatory Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMandatoryValue(MandatoryValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Optional Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Optional Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOptionalValue(OptionalValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Many Optional Values</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Many Optional Values</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseManyOptionalValues(ManyOptionalValues object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Many Mandatory Values</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Many Mandatory Values</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseManyMandatoryValues(ManyMandatoryValues object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mandatory Child</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mandatory Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMandatoryChild(MandatoryChild object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Optional Child</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Optional Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOptionalChild(OptionalChild object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Two Child Lists</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Two Child Lists</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTwoChildLists(TwoChildLists object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Two Childs</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Two Childs</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTwoChilds(TwoChilds object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Child With Sub Childs</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Child With Sub Childs</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseChildWithSubChilds(ChildWithSubChilds object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Child With Sub Child</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Child With Sub Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseChildWithSubChild(ChildWithSubChild object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sub Child</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sub Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubChild(SubChild object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mandatory Child List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mandatory Child List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMandatoryChildList(MandatoryChildList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Optional Child List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Optional Child List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOptionalChildList(OptionalChildList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNode(Node object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EClass Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EClass Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEClassRef(EClassRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>With Transient Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>With Transient Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWithTransientContainer(WithTransientContainer object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Many Values</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Many Values</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseManyValues(ManyValues object)
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

} //PartialSerializationTestLanguageSwitch
