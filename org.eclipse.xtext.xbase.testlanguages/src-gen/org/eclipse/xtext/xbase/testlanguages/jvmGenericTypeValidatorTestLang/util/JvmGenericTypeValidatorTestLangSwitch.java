/**
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.*;

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
 * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangPackage
 * @generated
 */
public class JvmGenericTypeValidatorTestLangSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static JvmGenericTypeValidatorTestLangPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmGenericTypeValidatorTestLangSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = JvmGenericTypeValidatorTestLangPackage.eINSTANCE;
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
      case JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL:
      {
        JvmGenericTypeValidatorTestLangModel jvmGenericTypeValidatorTestLangModel = (JvmGenericTypeValidatorTestLangModel)theEObject;
        T result = caseJvmGenericTypeValidatorTestLangModel(jvmGenericTypeValidatorTestLangModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JvmGenericTypeValidatorTestLangPackage.MY_TYPE:
      {
        MyType myType = (MyType)theEObject;
        T result = caseMyType(myType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JvmGenericTypeValidatorTestLangPackage.MY_CLASS:
      {
        MyClass myClass = (MyClass)theEObject;
        T result = caseMyClass(myClass);
        if (result == null) result = caseMyType(myClass);
        if (result == null) result = caseMyMember(myClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JvmGenericTypeValidatorTestLangPackage.MY_INTERFACE:
      {
        MyInterface myInterface = (MyInterface)theEObject;
        T result = caseMyInterface(myInterface);
        if (result == null) result = caseMyType(myInterface);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JvmGenericTypeValidatorTestLangPackage.MY_CLASS_WITH_SUPER_TYPES:
      {
        MyClassWithSuperTypes myClassWithSuperTypes = (MyClassWithSuperTypes)theEObject;
        T result = caseMyClassWithSuperTypes(myClassWithSuperTypes);
        if (result == null) result = caseMyType(myClassWithSuperTypes);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JvmGenericTypeValidatorTestLangPackage.MY_CLASS_WITH_WRONG_ADDITIONAL_INFERRED_INTERFACE:
      {
        MyClassWithWrongAdditionalInferredInterface myClassWithWrongAdditionalInferredInterface = (MyClassWithWrongAdditionalInferredInterface)theEObject;
        T result = caseMyClassWithWrongAdditionalInferredInterface(myClassWithWrongAdditionalInferredInterface);
        if (result == null) result = caseMyType(myClassWithWrongAdditionalInferredInterface);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JvmGenericTypeValidatorTestLangPackage.MY_MEMBER:
      {
        MyMember myMember = (MyMember)theEObject;
        T result = caseMyMember(myMember);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR:
      {
        MyConstructor myConstructor = (MyConstructor)theEObject;
        T result = caseMyConstructor(myConstructor);
        if (result == null) result = caseMyMember(myConstructor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JvmGenericTypeValidatorTestLangPackage.MY_FIELD:
      {
        MyField myField = (MyField)theEObject;
        T result = caseMyField(myField);
        if (result == null) result = caseMyMember(myField);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD:
      {
        MyMethod myMethod = (MyMethod)theEObject;
        T result = caseMyMethod(myMethod);
        if (result == null) result = caseMyMember(myMethod);
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
  public T caseJvmGenericTypeValidatorTestLangModel(JvmGenericTypeValidatorTestLangModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>My Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>My Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMyType(MyType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>My Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>My Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMyClass(MyClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>My Interface</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>My Interface</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMyInterface(MyInterface object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>My Class With Super Types</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>My Class With Super Types</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMyClassWithSuperTypes(MyClassWithSuperTypes object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>My Class With Wrong Additional Inferred Interface</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>My Class With Wrong Additional Inferred Interface</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMyClassWithWrongAdditionalInferredInterface(MyClassWithWrongAdditionalInferredInterface object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>My Member</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>My Member</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMyMember(MyMember object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>My Constructor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>My Constructor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMyConstructor(MyConstructor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>My Field</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>My Field</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMyField(MyField object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>My Method</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>My Method</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMyMethod(MyMethod object)
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

} //JvmGenericTypeValidatorTestLangSwitch
