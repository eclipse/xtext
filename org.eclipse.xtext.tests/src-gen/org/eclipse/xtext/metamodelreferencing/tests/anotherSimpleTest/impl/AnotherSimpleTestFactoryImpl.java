/**
 */
package org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnotherSimpleTestFactoryImpl extends EFactoryImpl implements AnotherSimpleTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AnotherSimpleTestFactory init()
  {
    try
    {
      AnotherSimpleTestFactory theAnotherSimpleTestFactory = (AnotherSimpleTestFactory)EPackage.Registry.INSTANCE.getEFactory(AnotherSimpleTestPackage.eNS_URI);
      if (theAnotherSimpleTestFactory != null)
      {
        return theAnotherSimpleTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AnotherSimpleTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnotherSimpleTestFactoryImpl()
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
      case AnotherSimpleTestPackage.FOO: return createFoo();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
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
  public AnotherSimpleTestPackage getAnotherSimpleTestPackage()
  {
    return (AnotherSimpleTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static AnotherSimpleTestPackage getPackage()
  {
    return AnotherSimpleTestPackage.eINSTANCE;
  }

} //AnotherSimpleTestFactoryImpl
