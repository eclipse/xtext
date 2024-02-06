/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.liveContainerBuilderIntegerationTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.resource.liveContainerBuilderIntegerationTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LiveContainerBuilderIntegerationTestLanguageFactoryImpl extends EFactoryImpl implements LiveContainerBuilderIntegerationTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LiveContainerBuilderIntegerationTestLanguageFactory init()
  {
    try
    {
      LiveContainerBuilderIntegerationTestLanguageFactory theLiveContainerBuilderIntegerationTestLanguageFactory = (LiveContainerBuilderIntegerationTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(LiveContainerBuilderIntegerationTestLanguagePackage.eNS_URI);
      if (theLiveContainerBuilderIntegerationTestLanguageFactory != null)
      {
        return theLiveContainerBuilderIntegerationTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new LiveContainerBuilderIntegerationTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LiveContainerBuilderIntegerationTestLanguageFactoryImpl()
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
      case LiveContainerBuilderIntegerationTestLanguagePackage.MODEL: return createModel();
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
  public LiveContainerBuilderIntegerationTestLanguagePackage getLiveContainerBuilderIntegerationTestLanguagePackage()
  {
    return (LiveContainerBuilderIntegerationTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static LiveContainerBuilderIntegerationTestLanguagePackage getPackage()
  {
    return LiveContainerBuilderIntegerationTestLanguagePackage.eINSTANCE;
  }

} //LiveContainerBuilderIntegerationTestLanguageFactoryImpl
