/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parsetree.reconstr.serializationerror.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parsetree.reconstr.serializationerror.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SerializationerrorFactoryImpl extends EFactoryImpl implements SerializationerrorFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SerializationerrorFactory init()
  {
    try
    {
      SerializationerrorFactory theSerializationerrorFactory = (SerializationerrorFactory)EPackage.Registry.INSTANCE.getEFactory(SerializationerrorPackage.eNS_URI);
      if (theSerializationerrorFactory != null)
      {
        return theSerializationerrorFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SerializationerrorFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SerializationerrorFactoryImpl()
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
      case SerializationerrorPackage.MODEL: return createModel();
      case SerializationerrorPackage.TEST: return createTest();
      case SerializationerrorPackage.TWO_REQUIRED: return createTwoRequired();
      case SerializationerrorPackage.TWO_OPTIONS: return createTwoOptions();
      case SerializationerrorPackage.INDENT: return createIndent();
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
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Test createTest()
  {
    TestImpl test = new TestImpl();
    return test;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TwoRequired createTwoRequired()
  {
    TwoRequiredImpl twoRequired = new TwoRequiredImpl();
    return twoRequired;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TwoOptions createTwoOptions()
  {
    TwoOptionsImpl twoOptions = new TwoOptionsImpl();
    return twoOptions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Indent createIndent()
  {
    IndentImpl indent = new IndentImpl();
    return indent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SerializationerrorPackage getSerializationerrorPackage()
  {
    return (SerializationerrorPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SerializationerrorPackage getPackage()
  {
    return SerializationerrorPackage.eINSTANCE;
  }

} //SerializationerrorFactoryImpl
