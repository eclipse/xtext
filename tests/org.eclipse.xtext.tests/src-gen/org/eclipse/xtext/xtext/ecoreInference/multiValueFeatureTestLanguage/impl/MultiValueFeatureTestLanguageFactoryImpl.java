/**
 */
package org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MultiValueFeatureTestLanguageFactoryImpl extends EFactoryImpl implements MultiValueFeatureTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MultiValueFeatureTestLanguageFactory init()
  {
    try
    {
      MultiValueFeatureTestLanguageFactory theMultiValueFeatureTestLanguageFactory = (MultiValueFeatureTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(MultiValueFeatureTestLanguagePackage.eNS_URI);
      if (theMultiValueFeatureTestLanguageFactory != null)
      {
        return theMultiValueFeatureTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MultiValueFeatureTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiValueFeatureTestLanguageFactoryImpl()
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
      case MultiValueFeatureTestLanguagePackage.START: return createStart();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Start createStart()
  {
    StartImpl start = new StartImpl();
    return start;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiValueFeatureTestLanguagePackage getMultiValueFeatureTestLanguagePackage()
  {
    return (MultiValueFeatureTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MultiValueFeatureTestLanguagePackage getPackage()
  {
    return MultiValueFeatureTestLanguagePackage.eINSTANCE;
  }

} //MultiValueFeatureTestLanguageFactoryImpl
