/**
 */
package org.eclipse.xtext.linking.ignoreCaseImportsTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.linking.ignoreCaseImportsTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IgnoreCaseImportsTestFactoryImpl extends EFactoryImpl implements IgnoreCaseImportsTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static IgnoreCaseImportsTestFactory init()
  {
    try
    {
      IgnoreCaseImportsTestFactory theIgnoreCaseImportsTestFactory = (IgnoreCaseImportsTestFactory)EPackage.Registry.INSTANCE.getEFactory(IgnoreCaseImportsTestPackage.eNS_URI);
      if (theIgnoreCaseImportsTestFactory != null)
      {
        return theIgnoreCaseImportsTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new IgnoreCaseImportsTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IgnoreCaseImportsTestFactoryImpl()
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
      case IgnoreCaseImportsTestPackage.MODEL: return createModel();
      case IgnoreCaseImportsTestPackage.IMPORT: return createImport();
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
  public IgnoreCaseImportsTestPackage getIgnoreCaseImportsTestPackage()
  {
    return (IgnoreCaseImportsTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static IgnoreCaseImportsTestPackage getPackage()
  {
    return IgnoreCaseImportsTestPackage.eINSTANCE;
  }

} //IgnoreCaseImportsTestFactoryImpl
