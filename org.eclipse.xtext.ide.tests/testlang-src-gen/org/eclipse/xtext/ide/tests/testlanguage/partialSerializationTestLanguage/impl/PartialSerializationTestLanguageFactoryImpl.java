/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PartialSerializationTestLanguageFactoryImpl extends EFactoryImpl implements PartialSerializationTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PartialSerializationTestLanguageFactory init()
  {
    try
    {
      PartialSerializationTestLanguageFactory thePartialSerializationTestLanguageFactory = (PartialSerializationTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(PartialSerializationTestLanguagePackage.eNS_URI);
      if (thePartialSerializationTestLanguageFactory != null)
      {
        return thePartialSerializationTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PartialSerializationTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartialSerializationTestLanguageFactoryImpl()
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
      case PartialSerializationTestLanguagePackage.MODEL: return createModel();
      case PartialSerializationTestLanguagePackage.MANDATORY_VALUE: return createMandatoryValue();
      case PartialSerializationTestLanguagePackage.OPTIONAL_VALUE: return createOptionalValue();
      case PartialSerializationTestLanguagePackage.MANY_OPTIONAL_VALUES: return createManyOptionalValues();
      case PartialSerializationTestLanguagePackage.MANY_MANDATORY_VALUES: return createManyMandatoryValues();
      case PartialSerializationTestLanguagePackage.MANDATORY_CHILD: return createMandatoryChild();
      case PartialSerializationTestLanguagePackage.OPTIONAL_CHILD: return createOptionalChild();
      case PartialSerializationTestLanguagePackage.MANDATORY_CHILD_LIST: return createMandatoryChildList();
      case PartialSerializationTestLanguagePackage.OPTIONAL_CHILD_LIST: return createOptionalChildList();
      case PartialSerializationTestLanguagePackage.IMPORT: return createImport();
      case PartialSerializationTestLanguagePackage.NODE: return createNode();
      case PartialSerializationTestLanguagePackage.ECLASS_REF: return createEClassRef();
      case PartialSerializationTestLanguagePackage.MANY_VALUES: return createManyValues();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
  public MandatoryValue createMandatoryValue()
  {
    MandatoryValueImpl mandatoryValue = new MandatoryValueImpl();
    return mandatoryValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionalValue createOptionalValue()
  {
    OptionalValueImpl optionalValue = new OptionalValueImpl();
    return optionalValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ManyOptionalValues createManyOptionalValues()
  {
    ManyOptionalValuesImpl manyOptionalValues = new ManyOptionalValuesImpl();
    return manyOptionalValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ManyMandatoryValues createManyMandatoryValues()
  {
    ManyMandatoryValuesImpl manyMandatoryValues = new ManyMandatoryValuesImpl();
    return manyMandatoryValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MandatoryChild createMandatoryChild()
  {
    MandatoryChildImpl mandatoryChild = new MandatoryChildImpl();
    return mandatoryChild;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionalChild createOptionalChild()
  {
    OptionalChildImpl optionalChild = new OptionalChildImpl();
    return optionalChild;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MandatoryChildList createMandatoryChildList()
  {
    MandatoryChildListImpl mandatoryChildList = new MandatoryChildListImpl();
    return mandatoryChildList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionalChildList createOptionalChildList()
  {
    OptionalChildListImpl optionalChildList = new OptionalChildListImpl();
    return optionalChildList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node createNode()
  {
    NodeImpl node = new NodeImpl();
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClassRef createEClassRef()
  {
    EClassRefImpl eClassRef = new EClassRefImpl();
    return eClassRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ManyValues createManyValues()
  {
    ManyValuesImpl manyValues = new ManyValuesImpl();
    return manyValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartialSerializationTestLanguagePackage getPartialSerializationTestLanguagePackage()
  {
    return (PartialSerializationTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static PartialSerializationTestLanguagePackage getPackage()
  {
    return PartialSerializationTestLanguagePackage.eINSTANCE;
  }

} //PartialSerializationTestLanguageFactoryImpl
