/**
 */
package org.eclipse.xtext.linking.bug289059Test.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.linking.bug289059Test.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug289059TestFactoryImpl extends EFactoryImpl implements Bug289059TestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Bug289059TestFactory init()
  {
    try
    {
      Bug289059TestFactory theBug289059TestFactory = (Bug289059TestFactory)EPackage.Registry.INSTANCE.getEFactory(Bug289059TestPackage.eNS_URI);
      if (theBug289059TestFactory != null)
      {
        return theBug289059TestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Bug289059TestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug289059TestFactoryImpl()
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
      case Bug289059TestPackage.MODEL: return createModel();
      case Bug289059TestPackage.UNASSIGNED_ACTION: return createUnassignedAction();
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
  public UnassignedAction createUnassignedAction()
  {
    UnassignedActionImpl unassignedAction = new UnassignedActionImpl();
    return unassignedAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug289059TestPackage getBug289059TestPackage()
  {
    return (Bug289059TestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Bug289059TestPackage getPackage()
  {
    return Bug289059TestPackage.eINSTANCE;
  }

} //Bug289059TestFactoryImpl
