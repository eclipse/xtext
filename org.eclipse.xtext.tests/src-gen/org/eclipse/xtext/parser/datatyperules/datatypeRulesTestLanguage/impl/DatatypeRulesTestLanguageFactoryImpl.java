/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DatatypeRulesTestLanguageFactoryImpl extends EFactoryImpl implements DatatypeRulesTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static DatatypeRulesTestLanguageFactory init()
  {
    try
    {
      DatatypeRulesTestLanguageFactory theDatatypeRulesTestLanguageFactory = (DatatypeRulesTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(DatatypeRulesTestLanguagePackage.eNS_URI);
      if (theDatatypeRulesTestLanguageFactory != null)
      {
        return theDatatypeRulesTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new DatatypeRulesTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DatatypeRulesTestLanguageFactoryImpl()
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
      case DatatypeRulesTestLanguagePackage.COMPOSITE_MODEL: return createCompositeModel();
      case DatatypeRulesTestLanguagePackage.MODEL: return createModel();
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
  public CompositeModel createCompositeModel()
  {
    CompositeModelImpl compositeModel = new CompositeModelImpl();
    return compositeModel;
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
  public DatatypeRulesTestLanguagePackage getDatatypeRulesTestLanguagePackage()
  {
    return (DatatypeRulesTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static DatatypeRulesTestLanguagePackage getPackage()
  {
    return DatatypeRulesTestLanguagePackage.eINSTANCE;
  }

} //DatatypeRulesTestLanguageFactoryImpl
