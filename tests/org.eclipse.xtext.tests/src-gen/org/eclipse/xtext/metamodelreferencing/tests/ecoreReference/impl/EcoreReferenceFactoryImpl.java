/**
 */
package org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcoreReferenceFactoryImpl extends EFactoryImpl implements EcoreReferenceFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static EcoreReferenceFactory init()
  {
    try
    {
      EcoreReferenceFactory theEcoreReferenceFactory = (EcoreReferenceFactory)EPackage.Registry.INSTANCE.getEFactory(EcoreReferencePackage.eNS_URI);
      if (theEcoreReferenceFactory != null)
      {
        return theEcoreReferenceFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new EcoreReferenceFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EcoreReferenceFactoryImpl()
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
      case EcoreReferencePackage.MODEL: return createModel();
      case EcoreReferencePackage.MY_NAMED_ELEMENT_01: return createMyNamedElement_01();
      case EcoreReferencePackage.MY_NAMED_ELEMENT_02: return createMyNamedElement_02();
      case EcoreReferencePackage.MY_NAMED_ELEMENT_03: return createMyNamedElement_03();
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
  public MyNamedElement_01 createMyNamedElement_01()
  {
    MyNamedElement_01Impl myNamedElement_01 = new MyNamedElement_01Impl();
    return myNamedElement_01;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyNamedElement_02 createMyNamedElement_02()
  {
    MyNamedElement_02Impl myNamedElement_02 = new MyNamedElement_02Impl();
    return myNamedElement_02;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyNamedElement_03 createMyNamedElement_03()
  {
    MyNamedElement_03Impl myNamedElement_03 = new MyNamedElement_03Impl();
    return myNamedElement_03;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EcoreReferencePackage getEcoreReferencePackage()
  {
    return (EcoreReferencePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static EcoreReferencePackage getPackage()
  {
    return EcoreReferencePackage.eINSTANCE;
  }

} //EcoreReferenceFactoryImpl
