/**
 */
package org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EObjectAtOffsetTestLanguageFactoryImpl extends EFactoryImpl implements EObjectAtOffsetTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static EObjectAtOffsetTestLanguageFactory init()
  {
    try
    {
      EObjectAtOffsetTestLanguageFactory theEObjectAtOffsetTestLanguageFactory = (EObjectAtOffsetTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(EObjectAtOffsetTestLanguagePackage.eNS_URI);
      if (theEObjectAtOffsetTestLanguageFactory != null)
      {
        return theEObjectAtOffsetTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new EObjectAtOffsetTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObjectAtOffsetTestLanguageFactoryImpl()
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
      case EObjectAtOffsetTestLanguagePackage.MODEL: return createModel();
      case EObjectAtOffsetTestLanguagePackage.ABSTRACT_BAR: return createAbstractBar();
      case EObjectAtOffsetTestLanguagePackage.BAR: return createBar();
      case EObjectAtOffsetTestLanguagePackage.FOO: return createFoo();
      case EObjectAtOffsetTestLanguagePackage.FOO_BAR: return createFooBar();
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
  public AbstractBar createAbstractBar()
  {
    AbstractBarImpl abstractBar = new AbstractBarImpl();
    return abstractBar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bar createBar()
  {
    BarImpl bar = new BarImpl();
    return bar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Foo createFoo()
  {
    FooImpl foo = new FooImpl();
    return foo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FooBar createFooBar()
  {
    FooBarImpl fooBar = new FooBarImpl();
    return fooBar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObjectAtOffsetTestLanguagePackage getEObjectAtOffsetTestLanguagePackage()
  {
    return (EObjectAtOffsetTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static EObjectAtOffsetTestLanguagePackage getPackage()
  {
    return EObjectAtOffsetTestLanguagePackage.eINSTANCE;
  }

} //EObjectAtOffsetTestLanguageFactoryImpl
