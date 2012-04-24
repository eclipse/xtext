/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.resource.flatResourceSetBasedAllContainersStateTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.resource.flatResourceSetBasedAllContainersStateTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FlatResourceSetBasedAllContainersStateTestFactoryImpl extends EFactoryImpl implements FlatResourceSetBasedAllContainersStateTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FlatResourceSetBasedAllContainersStateTestFactory init()
  {
    try
    {
      FlatResourceSetBasedAllContainersStateTestFactory theFlatResourceSetBasedAllContainersStateTestFactory = (FlatResourceSetBasedAllContainersStateTestFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.xtext.org/FlatResourceSetBasedAllContainersStateTestLanguage"); 
      if (theFlatResourceSetBasedAllContainersStateTestFactory != null)
      {
        return theFlatResourceSetBasedAllContainersStateTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new FlatResourceSetBasedAllContainersStateTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FlatResourceSetBasedAllContainersStateTestFactoryImpl()
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
      case FlatResourceSetBasedAllContainersStateTestPackage.MODEL: return createModel();
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
  public FlatResourceSetBasedAllContainersStateTestPackage getFlatResourceSetBasedAllContainersStateTestPackage()
  {
    return (FlatResourceSetBasedAllContainersStateTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static FlatResourceSetBasedAllContainersStateTestPackage getPackage()
  {
    return FlatResourceSetBasedAllContainersStateTestPackage.eINSTANCE;
  }

} //FlatResourceSetBasedAllContainersStateTestFactoryImpl
