/**
 */
package org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.ExtendsNsURIEObject;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.ExtendsPluginEObject;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.ExtendsResourceEObject;

import org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.EcoreReferencePackage
 * @generated
 */
public class EcoreReferenceAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static EcoreReferencePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EcoreReferenceAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = EcoreReferencePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EcoreReferenceSwitch<Adapter> modelSwitch =
    new EcoreReferenceSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseMyNamedElement_01(MyNamedElement_01 object)
      {
        return createMyNamedElement_01Adapter();
      }
      @Override
      public Adapter caseMyNamedElement_02(MyNamedElement_02 object)
      {
        return createMyNamedElement_02Adapter();
      }
      @Override
      public Adapter caseMyNamedElement_03(MyNamedElement_03 object)
      {
        return createMyNamedElement_03Adapter();
      }
      @Override
      public Adapter caseExtendsNsURIEObject(ExtendsNsURIEObject object)
      {
        return createExtendsNsURIEObjectAdapter();
      }
      @Override
      public Adapter caseExtendsResourceEObject(ExtendsResourceEObject object)
      {
        return createExtendsResourceEObjectAdapter();
      }
      @Override
      public Adapter caseExtendsPluginEObject(ExtendsPluginEObject object)
      {
        return createExtendsPluginEObjectAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.MyNamedElement_01 <em>My Named Element 01</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.MyNamedElement_01
   * @generated
   */
  public Adapter createMyNamedElement_01Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.MyNamedElement_02 <em>My Named Element 02</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.MyNamedElement_02
   * @generated
   */
  public Adapter createMyNamedElement_02Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.MyNamedElement_03 <em>My Named Element 03</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.MyNamedElement_03
   * @generated
   */
  public Adapter createMyNamedElement_03Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.ExtendsNsURIEObject <em>Extends Ns URIE Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.ExtendsNsURIEObject
   * @generated
   */
  public Adapter createExtendsNsURIEObjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.ExtendsResourceEObject <em>Extends Resource EObject</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.ExtendsResourceEObject
   * @generated
   */
  public Adapter createExtendsResourceEObjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.ExtendsPluginEObject <em>Extends Plugin EObject</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.ExtendsPluginEObject
   * @generated
   */
  public Adapter createExtendsPluginEObjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //EcoreReferenceAdapterFactory
