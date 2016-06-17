/**
 */
package org.eclipse.xtext.resource.liveContainerTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.resource.liveContainerTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LiveContainerTestLanguageFactoryImpl extends EFactoryImpl implements LiveContainerTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LiveContainerTestLanguageFactory init()
  {
    try
    {
      LiveContainerTestLanguageFactory theLiveContainerTestLanguageFactory = (LiveContainerTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(LiveContainerTestLanguagePackage.eNS_URI);
      if (theLiveContainerTestLanguageFactory != null)
      {
        return theLiveContainerTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new LiveContainerTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LiveContainerTestLanguageFactoryImpl()
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
      case LiveContainerTestLanguagePackage.MODEL: return createModel();
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
  public LiveContainerTestLanguagePackage getLiveContainerTestLanguagePackage()
  {
    return (LiveContainerTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static LiveContainerTestLanguagePackage getPackage()
  {
    return LiveContainerTestLanguagePackage.eINSTANCE;
  }

} //LiveContainerTestLanguageFactoryImpl
