/**
 */
package org.eclipse.xtext.metamodelreferencing.tests.otherTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.metamodelreferencing.tests.otherTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OtherTestFactoryImpl extends EFactoryImpl implements OtherTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static OtherTestFactory init()
  {
    try
    {
      OtherTestFactory theOtherTestFactory = (OtherTestFactory)EPackage.Registry.INSTANCE.getEFactory(OtherTestPackage.eNS_URI);
      if (theOtherTestFactory != null)
      {
        return theOtherTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new OtherTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OtherTestFactoryImpl()
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
      case OtherTestPackage.FOO_BAR: return createFooBar();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
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
  public OtherTestPackage getOtherTestPackage()
  {
    return (OtherTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static OtherTestPackage getPackage()
  {
    return OtherTestPackage.eINSTANCE;
  }

} //OtherTestFactoryImpl
