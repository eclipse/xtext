/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.ecore.superPackage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.generator.ecore.superPackage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SuperPackageFactoryImpl extends EFactoryImpl implements SuperPackageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SuperPackageFactory init()
  {
    try
    {
      SuperPackageFactory theSuperPackageFactory = (SuperPackageFactory)EPackage.Registry.INSTANCE.getEFactory(SuperPackagePackage.eNS_URI);
      if (theSuperPackageFactory != null)
      {
        return theSuperPackageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SuperPackageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuperPackageFactoryImpl()
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
      case SuperPackagePackage.SUPER_MAIN: return createSuperMain();
      case SuperPackagePackage.ANOTHER_SUPER_MAIN: return createAnotherSuperMain();
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
  public SuperMain createSuperMain()
  {
    SuperMainImpl superMain = new SuperMainImpl();
    return superMain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AnotherSuperMain createAnotherSuperMain()
  {
    AnotherSuperMainImpl anotherSuperMain = new AnotherSuperMainImpl();
    return anotherSuperMain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SuperPackagePackage getSuperPackagePackage()
  {
    return (SuperPackagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SuperPackagePackage getPackage()
  {
    return SuperPackagePackage.eINSTANCE;
  }

} //SuperPackageFactoryImpl
