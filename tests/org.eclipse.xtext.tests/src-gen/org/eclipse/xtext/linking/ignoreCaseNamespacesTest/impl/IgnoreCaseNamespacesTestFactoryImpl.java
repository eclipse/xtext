/**
 */
package org.eclipse.xtext.linking.ignoreCaseNamespacesTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.linking.ignoreCaseNamespacesTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IgnoreCaseNamespacesTestFactoryImpl extends EFactoryImpl implements IgnoreCaseNamespacesTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static IgnoreCaseNamespacesTestFactory init()
  {
    try
    {
      IgnoreCaseNamespacesTestFactory theIgnoreCaseNamespacesTestFactory = (IgnoreCaseNamespacesTestFactory)EPackage.Registry.INSTANCE.getEFactory(IgnoreCaseNamespacesTestPackage.eNS_URI);
      if (theIgnoreCaseNamespacesTestFactory != null)
      {
        return theIgnoreCaseNamespacesTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new IgnoreCaseNamespacesTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IgnoreCaseNamespacesTestFactoryImpl()
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
      case IgnoreCaseNamespacesTestPackage.MODEL: return createModel();
      case IgnoreCaseNamespacesTestPackage.IMPORT: return createImport();
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
  public IgnoreCaseNamespacesTestPackage getIgnoreCaseNamespacesTestPackage()
  {
    return (IgnoreCaseNamespacesTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static IgnoreCaseNamespacesTestPackage getPackage()
  {
    return IgnoreCaseNamespacesTestPackage.eINSTANCE;
  }

} //IgnoreCaseNamespacesTestFactoryImpl
