/**
 */
package org.eclipse.xtext.resource.locationprovidertest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.resource.locationprovidertest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LocationprovidertestFactoryImpl extends EFactoryImpl implements LocationprovidertestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LocationprovidertestFactory init()
  {
    try
    {
      LocationprovidertestFactory theLocationprovidertestFactory = (LocationprovidertestFactory)EPackage.Registry.INSTANCE.getEFactory(LocationprovidertestPackage.eNS_URI);
      if (theLocationprovidertestFactory != null)
      {
        return theLocationprovidertestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new LocationprovidertestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocationprovidertestFactoryImpl()
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
      case LocationprovidertestPackage.MODEL: return createModel();
      case LocationprovidertestPackage.ELEMENT: return createElement();
      case LocationprovidertestPackage.COMPONENT: return createComponent();
      case LocationprovidertestPackage.BUS: return createBus();
      case LocationprovidertestPackage.PROCESSOR: return createProcessor();
      case LocationprovidertestPackage.MODE: return createMode();
      case LocationprovidertestPackage.TRANSITION: return createTransition();
      case LocationprovidertestPackage.PORT: return createPort();
      case LocationprovidertestPackage.DATA: return createData();
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
  public Element createElement()
  {
    ElementImpl element = new ElementImpl();
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Component createComponent()
  {
    ComponentImpl component = new ComponentImpl();
    return component;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bus createBus()
  {
    BusImpl bus = new BusImpl();
    return bus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Processor createProcessor()
  {
    ProcessorImpl processor = new ProcessorImpl();
    return processor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mode createMode()
  {
    ModeImpl mode = new ModeImpl();
    return mode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transition createTransition()
  {
    TransitionImpl transition = new TransitionImpl();
    return transition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port createPort()
  {
    PortImpl port = new PortImpl();
    return port;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Data createData()
  {
    DataImpl data = new DataImpl();
    return data;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocationprovidertestPackage getLocationprovidertestPackage()
  {
    return (LocationprovidertestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static LocationprovidertestPackage getPackage()
  {
    return LocationprovidertestPackage.eINSTANCE;
  }

} //LocationprovidertestFactoryImpl
