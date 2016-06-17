/**
 */
package org.eclipse.xtext.linking.ignoreCaseLinkingTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.linking.ignoreCaseLinkingTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IgnoreCaseLinkingTestFactoryImpl extends EFactoryImpl implements IgnoreCaseLinkingTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static IgnoreCaseLinkingTestFactory init()
  {
    try
    {
      IgnoreCaseLinkingTestFactory theIgnoreCaseLinkingTestFactory = (IgnoreCaseLinkingTestFactory)EPackage.Registry.INSTANCE.getEFactory(IgnoreCaseLinkingTestPackage.eNS_URI);
      if (theIgnoreCaseLinkingTestFactory != null)
      {
        return theIgnoreCaseLinkingTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new IgnoreCaseLinkingTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IgnoreCaseLinkingTestFactoryImpl()
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
      case IgnoreCaseLinkingTestPackage.MODEL: return createModel();
      case IgnoreCaseLinkingTestPackage.ELEMENT: return createElement();
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
  public IgnoreCaseLinkingTestPackage getIgnoreCaseLinkingTestPackage()
  {
    return (IgnoreCaseLinkingTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static IgnoreCaseLinkingTestPackage getPackage()
  {
    return IgnoreCaseLinkingTestPackage.eINSTANCE;
  }

} //IgnoreCaseLinkingTestFactoryImpl
