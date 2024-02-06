/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.actionLang3.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.testlanguages.actionLang3.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionLang3FactoryImpl extends EFactoryImpl implements ActionLang3Factory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ActionLang3Factory init()
  {
    try
    {
      ActionLang3Factory theActionLang3Factory = (ActionLang3Factory)EPackage.Registry.INSTANCE.getEFactory(ActionLang3Package.eNS_URI);
      if (theActionLang3Factory != null)
      {
        return theActionLang3Factory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ActionLang3FactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActionLang3FactoryImpl()
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
      case ActionLang3Package.PRODUCTION_RULES: return createProductionRules();
      case ActionLang3Package.PRODUCTION_RULE1: return createProductionRule1();
      case ActionLang3Package.PRODUCTION_RULE2: return createProductionRule2();
      case ActionLang3Package.P1: return createP1();
      case ActionLang3Package.P2: return createP2();
      case ActionLang3Package.P3: return createP3();
      case ActionLang3Package.ENTRY: return createEntry();
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
  public ProductionRules createProductionRules()
  {
    ProductionRulesImpl productionRules = new ProductionRulesImpl();
    return productionRules;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ProductionRule1 createProductionRule1()
  {
    ProductionRule1Impl productionRule1 = new ProductionRule1Impl();
    return productionRule1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ProductionRule2 createProductionRule2()
  {
    ProductionRule2Impl productionRule2 = new ProductionRule2Impl();
    return productionRule2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public P1 createP1()
  {
    P1Impl p1 = new P1Impl();
    return p1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public P2 createP2()
  {
    P2Impl p2 = new P2Impl();
    return p2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public P3 createP3()
  {
    P3Impl p3 = new P3Impl();
    return p3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Entry createEntry()
  {
    EntryImpl entry = new EntryImpl();
    return entry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ActionLang3Package getActionLang3Package()
  {
    return (ActionLang3Package)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ActionLang3Package getPackage()
  {
    return ActionLang3Package.eINSTANCE;
  }

} //ActionLang3FactoryImpl
