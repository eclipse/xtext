/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.grammarinheritance.foo.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.grammarinheritance.foo.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FooFactoryImpl extends EFactoryImpl implements FooFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FooFactory init()
  {
    try
    {
      FooFactory theFooFactory = (FooFactory)EPackage.Registry.INSTANCE.getEFactory(FooPackage.eNS_URI);
      if (theFooFactory != null)
      {
        return theFooFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new FooFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FooFactoryImpl()
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
      case FooPackage.ROOT_RULE: return createRootRule();
      case FooPackage.CONCRETE_PARSER_RULE: return createConcreteParserRule();
      case FooPackage.CALL_OVERRIDEN_PARSER_RULE: return createCallOverridenParserRule();
      case FooPackage.ATYPE2: return createAType2();
      case FooPackage.SUBRULE1: return createSubrule1();
      case FooPackage.SUBRULE2: return createSubrule2();
      case FooPackage.SUBRULE3: return createSubrule3();
      case FooPackage.CALL_EXTENDED_PARSER_RULE: return createCallExtendedParserRule();
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
  public RootRule createRootRule()
  {
    RootRuleImpl rootRule = new RootRuleImpl();
    return rootRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ConcreteParserRule createConcreteParserRule()
  {
    ConcreteParserRuleImpl concreteParserRule = new ConcreteParserRuleImpl();
    return concreteParserRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CallOverridenParserRule createCallOverridenParserRule()
  {
    CallOverridenParserRuleImpl callOverridenParserRule = new CallOverridenParserRuleImpl();
    return callOverridenParserRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AType2 createAType2()
  {
    AType2Impl aType2 = new AType2Impl();
    return aType2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Subrule1 createSubrule1()
  {
    Subrule1Impl subrule1 = new Subrule1Impl();
    return subrule1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Subrule2 createSubrule2()
  {
    Subrule2Impl subrule2 = new Subrule2Impl();
    return subrule2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Subrule3 createSubrule3()
  {
    Subrule3Impl subrule3 = new Subrule3Impl();
    return subrule3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CallExtendedParserRule createCallExtendedParserRule()
  {
    CallExtendedParserRuleImpl callExtendedParserRule = new CallExtendedParserRuleImpl();
    return callExtendedParserRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FooPackage getFooPackage()
  {
    return (FooPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static FooPackage getPackage()
  {
    return FooPackage.eINSTANCE;
  }

} //FooFactoryImpl
