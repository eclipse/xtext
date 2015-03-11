/**
 */
package org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SerializationBug269362TestLanguageFactoryImpl extends EFactoryImpl implements SerializationBug269362TestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SerializationBug269362TestLanguageFactory init()
  {
    try
    {
      SerializationBug269362TestLanguageFactory theSerializationBug269362TestLanguageFactory = (SerializationBug269362TestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(SerializationBug269362TestLanguagePackage.eNS_URI);
      if (theSerializationBug269362TestLanguageFactory != null)
      {
        return theSerializationBug269362TestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SerializationBug269362TestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SerializationBug269362TestLanguageFactoryImpl()
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
      case SerializationBug269362TestLanguagePackage.MODEL: return createModel();
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
  public SerializationBug269362TestLanguagePackage getSerializationBug269362TestLanguagePackage()
  {
    return (SerializationBug269362TestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SerializationBug269362TestLanguagePackage getPackage()
  {
    return SerializationBug269362TestLanguagePackage.eINSTANCE;
  }

} //SerializationBug269362TestLanguageFactoryImpl
