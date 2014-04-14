/**
 */
package org.eclipse.xtext.serializer.hiddentokensequencertest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.serializer.hiddentokensequencertest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HiddentokensequencertestFactoryImpl extends EFactoryImpl implements HiddentokensequencertestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static HiddentokensequencertestFactory init()
  {
    try
    {
      HiddentokensequencertestFactory theHiddentokensequencertestFactory = (HiddentokensequencertestFactory)EPackage.Registry.INSTANCE.getEFactory(HiddentokensequencertestPackage.eNS_URI);
      if (theHiddentokensequencertestFactory != null)
      {
        return theHiddentokensequencertestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new HiddentokensequencertestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HiddentokensequencertestFactoryImpl()
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
      case HiddentokensequencertestPackage.MODEL: return createModel();
      case HiddentokensequencertestPackage.DOMAIN_MODEL: return createDomainModel();
      case HiddentokensequencertestPackage.ENTITY: return createEntity();
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
  public DomainModel createDomainModel()
  {
    DomainModelImpl domainModel = new DomainModelImpl();
    return domainModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entity createEntity()
  {
    EntityImpl entity = new EntityImpl();
    return entity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HiddentokensequencertestPackage getHiddentokensequencertestPackage()
  {
    return (HiddentokensequencertestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static HiddentokensequencertestPackage getPackage()
  {
    return HiddentokensequencertestPackage.eINSTANCE;
  }

} //HiddentokensequencertestFactoryImpl
