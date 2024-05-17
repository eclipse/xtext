/**
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JvmGenericTypeValidatorTestLangFactoryImpl extends EFactoryImpl implements JvmGenericTypeValidatorTestLangFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static JvmGenericTypeValidatorTestLangFactory init()
  {
    try
    {
      JvmGenericTypeValidatorTestLangFactory theJvmGenericTypeValidatorTestLangFactory = (JvmGenericTypeValidatorTestLangFactory)EPackage.Registry.INSTANCE.getEFactory(JvmGenericTypeValidatorTestLangPackage.eNS_URI);
      if (theJvmGenericTypeValidatorTestLangFactory != null)
      {
        return theJvmGenericTypeValidatorTestLangFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new JvmGenericTypeValidatorTestLangFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmGenericTypeValidatorTestLangFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL: return createJvmGenericTypeValidatorTestLangModel();
      case JvmGenericTypeValidatorTestLangPackage.MY_TYPE: return createMyType();
      case JvmGenericTypeValidatorTestLangPackage.MY_CLASS: return createMyClass();
      case JvmGenericTypeValidatorTestLangPackage.MY_INTERFACE: return createMyInterface();
      case JvmGenericTypeValidatorTestLangPackage.MY_CLASS_WITH_SUPER_TYPES: return createMyClassWithSuperTypes();
      case JvmGenericTypeValidatorTestLangPackage.MY_CLASS_WITH_WRONG_ADDITIONAL_INFERRED_INTERFACE: return createMyClassWithWrongAdditionalInferredInterface();
      case JvmGenericTypeValidatorTestLangPackage.MY_MEMBER: return createMyMember();
      case JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR: return createMyConstructor();
      case JvmGenericTypeValidatorTestLangPackage.MY_FIELD: return createMyField();
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD: return createMyMethod();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JvmGenericTypeValidatorTestLangModel createJvmGenericTypeValidatorTestLangModel()
  {
    JvmGenericTypeValidatorTestLangModelImpl jvmGenericTypeValidatorTestLangModel = new JvmGenericTypeValidatorTestLangModelImpl();
    return jvmGenericTypeValidatorTestLangModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MyType createMyType()
  {
    MyTypeImpl myType = new MyTypeImpl();
    return myType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MyClass createMyClass()
  {
    MyClassImpl myClass = new MyClassImpl();
    return myClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MyInterface createMyInterface()
  {
    MyInterfaceImpl myInterface = new MyInterfaceImpl();
    return myInterface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MyClassWithSuperTypes createMyClassWithSuperTypes()
  {
    MyClassWithSuperTypesImpl myClassWithSuperTypes = new MyClassWithSuperTypesImpl();
    return myClassWithSuperTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MyClassWithWrongAdditionalInferredInterface createMyClassWithWrongAdditionalInferredInterface()
  {
    MyClassWithWrongAdditionalInferredInterfaceImpl myClassWithWrongAdditionalInferredInterface = new MyClassWithWrongAdditionalInferredInterfaceImpl();
    return myClassWithWrongAdditionalInferredInterface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MyMember createMyMember()
  {
    MyMemberImpl myMember = new MyMemberImpl();
    return myMember;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MyConstructor createMyConstructor()
  {
    MyConstructorImpl myConstructor = new MyConstructorImpl();
    return myConstructor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MyField createMyField()
  {
    MyFieldImpl myField = new MyFieldImpl();
    return myField;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MyMethod createMyMethod()
  {
    MyMethodImpl myMethod = new MyMethodImpl();
    return myMethod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JvmGenericTypeValidatorTestLangPackage getJvmGenericTypeValidatorTestLangPackage()
  {
    return (JvmGenericTypeValidatorTestLangPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static JvmGenericTypeValidatorTestLangPackage getPackage()
  {
    return JvmGenericTypeValidatorTestLangPackage.eINSTANCE;
  }

} //JvmGenericTypeValidatorTestLangFactoryImpl
