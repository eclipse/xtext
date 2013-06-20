/**
 */
package org.eclipse.xtext.linking.bug287988Test.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.linking.bug287988Test.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug287988TestFactoryImpl extends EFactoryImpl implements Bug287988TestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Bug287988TestFactory init()
  {
    try
    {
      Bug287988TestFactory theBug287988TestFactory = (Bug287988TestFactory)EPackage.Registry.INSTANCE.getEFactory(Bug287988TestPackage.eNS_URI);
      if (theBug287988TestFactory != null)
      {
        return theBug287988TestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Bug287988TestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug287988TestFactoryImpl()
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
      case Bug287988TestPackage.MODEL: return createModel();
      case Bug287988TestPackage.BASE_ATTRIBUTE: return createBaseAttribute();
      case Bug287988TestPackage.ATTRIBUTE: return createAttribute();
      case Bug287988TestPackage.MASTER: return createMaster();
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
  public BaseAttribute createBaseAttribute()
  {
    BaseAttributeImpl baseAttribute = new BaseAttributeImpl();
    return baseAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Master createMaster()
  {
    MasterImpl master = new MasterImpl();
    return master;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug287988TestPackage getBug287988TestPackage()
  {
    return (Bug287988TestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Bug287988TestPackage getPackage()
  {
    return Bug287988TestPackage.eINSTANCE;
  }

} //Bug287988TestFactoryImpl
