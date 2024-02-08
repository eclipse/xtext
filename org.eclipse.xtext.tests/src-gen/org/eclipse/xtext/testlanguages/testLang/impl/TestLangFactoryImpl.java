/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.testLang.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.testlanguages.testLang.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestLangFactoryImpl extends EFactoryImpl implements TestLangFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TestLangFactory init()
  {
    try
    {
      TestLangFactory theTestLangFactory = (TestLangFactory)EPackage.Registry.INSTANCE.getEFactory(TestLangPackage.eNS_URI);
      if (theTestLangFactory != null)
      {
        return theTestLangFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TestLangFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestLangFactoryImpl()
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
      case TestLangPackage.MODEL: return createModel();
      case TestLangPackage.ABSTRACT_ELEMENT: return createAbstractElement();
      case TestLangPackage.CHOICE_ELEMENT: return createChoiceElement();
      case TestLangPackage.REDUCIBLE_ELEMENT: return createReducibleElement();
      case TestLangPackage.TERMINAL_ELEMENT: return createTerminalElement();
      case TestLangPackage.REDUCIBLE_COMPOSITE: return createReducibleComposite();
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
  public AbstractElement createAbstractElement()
  {
    AbstractElementImpl abstractElement = new AbstractElementImpl();
    return abstractElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ChoiceElement createChoiceElement()
  {
    ChoiceElementImpl choiceElement = new ChoiceElementImpl();
    return choiceElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ReducibleElement createReducibleElement()
  {
    ReducibleElementImpl reducibleElement = new ReducibleElementImpl();
    return reducibleElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TerminalElement createTerminalElement()
  {
    TerminalElementImpl terminalElement = new TerminalElementImpl();
    return terminalElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ReducibleComposite createReducibleComposite()
  {
    ReducibleCompositeImpl reducibleComposite = new ReducibleCompositeImpl();
    return reducibleComposite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TestLangPackage getTestLangPackage()
  {
    return (TestLangPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TestLangPackage getPackage()
  {
    return TestLangPackage.eINSTANCE;
  }

} //TestLangFactoryImpl
