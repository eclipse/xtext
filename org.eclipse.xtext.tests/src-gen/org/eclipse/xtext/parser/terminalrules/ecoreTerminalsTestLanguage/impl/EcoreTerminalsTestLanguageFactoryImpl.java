/**
 */
package org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcoreTerminalsTestLanguageFactoryImpl extends EFactoryImpl implements EcoreTerminalsTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static EcoreTerminalsTestLanguageFactory init()
  {
    try
    {
      EcoreTerminalsTestLanguageFactory theEcoreTerminalsTestLanguageFactory = (EcoreTerminalsTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(EcoreTerminalsTestLanguagePackage.eNS_URI);
      if (theEcoreTerminalsTestLanguageFactory != null)
      {
        return theEcoreTerminalsTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new EcoreTerminalsTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EcoreTerminalsTestLanguageFactoryImpl()
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
      case EcoreTerminalsTestLanguagePackage.MODEL: return createModel();
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
  public EcoreTerminalsTestLanguagePackage getEcoreTerminalsTestLanguagePackage()
  {
    return (EcoreTerminalsTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static EcoreTerminalsTestLanguagePackage getPackage()
  {
    return EcoreTerminalsTestLanguagePackage.eINSTANCE;
  }

} //EcoreTerminalsTestLanguageFactoryImpl
