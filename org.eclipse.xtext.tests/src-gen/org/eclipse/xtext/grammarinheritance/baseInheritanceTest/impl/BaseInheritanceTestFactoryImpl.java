/**
 */
package org.eclipse.xtext.grammarinheritance.baseInheritanceTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.grammarinheritance.baseInheritanceTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BaseInheritanceTestFactoryImpl extends EFactoryImpl implements BaseInheritanceTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static BaseInheritanceTestFactory init()
  {
    try
    {
      BaseInheritanceTestFactory theBaseInheritanceTestFactory = (BaseInheritanceTestFactory)EPackage.Registry.INSTANCE.getEFactory(BaseInheritanceTestPackage.eNS_URI);
      if (theBaseInheritanceTestFactory != null)
      {
        return theBaseInheritanceTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new BaseInheritanceTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BaseInheritanceTestFactoryImpl()
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
      case BaseInheritanceTestPackage.MODEL: return createModel();
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
  public BaseInheritanceTestPackage getBaseInheritanceTestPackage()
  {
    return (BaseInheritanceTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static BaseInheritanceTestPackage getPackage()
  {
    return BaseInheritanceTestPackage.eINSTANCE;
  }

} //BaseInheritanceTestFactoryImpl
