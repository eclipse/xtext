/**
 */
package org.eclipse.xtext.parser.assignments.bug287184Test.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.assignments.bug287184Test.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug287184TestFactoryImpl extends EFactoryImpl implements Bug287184TestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Bug287184TestFactory init()
  {
    try
    {
      Bug287184TestFactory theBug287184TestFactory = (Bug287184TestFactory)EPackage.Registry.INSTANCE.getEFactory(Bug287184TestPackage.eNS_URI);
      if (theBug287184TestFactory != null)
      {
        return theBug287184TestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Bug287184TestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug287184TestFactoryImpl()
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
      case Bug287184TestPackage.MODEL: return createModel();
      case Bug287184TestPackage.ABSTRACT_DETAIL: return createAbstractDetail();
      case Bug287184TestPackage.DETAIL: return createDetail();
      case Bug287184TestPackage.ASSOCIATED_DETAIL: return createAssociatedDetail();
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
  public AbstractDetail createAbstractDetail()
  {
    AbstractDetailImpl abstractDetail = new AbstractDetailImpl();
    return abstractDetail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Detail createDetail()
  {
    DetailImpl detail = new DetailImpl();
    return detail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociatedDetail createAssociatedDetail()
  {
    AssociatedDetailImpl associatedDetail = new AssociatedDetailImpl();
    return associatedDetail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug287184TestPackage getBug287184TestPackage()
  {
    return (Bug287184TestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Bug287184TestPackage getPackage()
  {
    return Bug287184TestPackage.eINSTANCE;
  }

} //Bug287184TestFactoryImpl
