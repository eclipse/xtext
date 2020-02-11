/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage
 * @generated
 */
public class PartialSerializationTestLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PartialSerializationTestLanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartialSerializationTestLanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = PartialSerializationTestLanguagePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PartialSerializationTestLanguageSwitch<Adapter> modelSwitch =
    new PartialSerializationTestLanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseMandatoryValue(MandatoryValue object)
      {
        return createMandatoryValueAdapter();
      }
      @Override
      public Adapter caseOptionalValue(OptionalValue object)
      {
        return createOptionalValueAdapter();
      }
      @Override
      public Adapter caseManyOptionalValues(ManyOptionalValues object)
      {
        return createManyOptionalValuesAdapter();
      }
      @Override
      public Adapter caseManyMandatoryValues(ManyMandatoryValues object)
      {
        return createManyMandatoryValuesAdapter();
      }
      @Override
      public Adapter caseMandatoryChild(MandatoryChild object)
      {
        return createMandatoryChildAdapter();
      }
      @Override
      public Adapter caseOptionalChild(OptionalChild object)
      {
        return createOptionalChildAdapter();
      }
      @Override
      public Adapter caseTwoChildLists(TwoChildLists object)
      {
        return createTwoChildListsAdapter();
      }
      @Override
      public Adapter caseTwoChilds(TwoChilds object)
      {
        return createTwoChildsAdapter();
      }
      @Override
      public Adapter caseChildWithSubChilds(ChildWithSubChilds object)
      {
        return createChildWithSubChildsAdapter();
      }
      @Override
      public Adapter caseChildWithSubChild(ChildWithSubChild object)
      {
        return createChildWithSubChildAdapter();
      }
      @Override
      public Adapter caseSubChild(SubChild object)
      {
        return createSubChildAdapter();
      }
      @Override
      public Adapter caseMandatoryChildList(MandatoryChildList object)
      {
        return createMandatoryChildListAdapter();
      }
      @Override
      public Adapter caseOptionalChildList(OptionalChildList object)
      {
        return createOptionalChildListAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseNode(Node object)
      {
        return createNodeAdapter();
      }
      @Override
      public Adapter caseEClassRef(EClassRef object)
      {
        return createEClassRefAdapter();
      }
      @Override
      public Adapter caseWithTransientContainer(WithTransientContainer object)
      {
        return createWithTransientContainerAdapter();
      }
      @Override
      public Adapter caseManyValues(ManyValues object)
      {
        return createManyValuesAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryValue <em>Mandatory Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryValue
   * @generated
   */
  public Adapter createMandatoryValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalValue <em>Optional Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalValue
   * @generated
   */
  public Adapter createOptionalValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ManyOptionalValues <em>Many Optional Values</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ManyOptionalValues
   * @generated
   */
  public Adapter createManyOptionalValuesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ManyMandatoryValues <em>Many Mandatory Values</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ManyMandatoryValues
   * @generated
   */
  public Adapter createManyMandatoryValuesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryChild <em>Mandatory Child</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryChild
   * @generated
   */
  public Adapter createMandatoryChildAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalChild <em>Optional Child</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalChild
   * @generated
   */
  public Adapter createOptionalChildAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChildLists <em>Two Child Lists</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChildLists
   * @generated
   */
  public Adapter createTwoChildListsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChilds <em>Two Childs</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChilds
   * @generated
   */
  public Adapter createTwoChildsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ChildWithSubChilds <em>Child With Sub Childs</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ChildWithSubChilds
   * @generated
   */
  public Adapter createChildWithSubChildsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ChildWithSubChild <em>Child With Sub Child</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ChildWithSubChild
   * @generated
   */
  public Adapter createChildWithSubChildAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.SubChild <em>Sub Child</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.SubChild
   * @generated
   */
  public Adapter createSubChildAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryChildList <em>Mandatory Child List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryChildList
   * @generated
   */
  public Adapter createMandatoryChildListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalChildList <em>Optional Child List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalChildList
   * @generated
   */
  public Adapter createOptionalChildListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node
   * @generated
   */
  public Adapter createNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.EClassRef <em>EClass Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.EClassRef
   * @generated
   */
  public Adapter createEClassRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.WithTransientContainer <em>With Transient Container</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.WithTransientContainer
   * @generated
   */
  public Adapter createWithTransientContainerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ManyValues <em>Many Values</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ManyValues
   * @generated
   */
  public Adapter createManyValuesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //PartialSerializationTestLanguageAdapterFactory
