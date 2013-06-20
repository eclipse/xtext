/**
 */
package org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parsetree.reconstr.partialserializationtest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PartialserializationtestFactoryImpl extends EFactoryImpl implements PartialserializationtestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PartialserializationtestFactory init()
  {
    try
    {
      PartialserializationtestFactory thePartialserializationtestFactory = (PartialserializationtestFactory)EPackage.Registry.INSTANCE.getEFactory(PartialserializationtestPackage.eNS_URI);
      if (thePartialserializationtestFactory != null)
      {
        return thePartialserializationtestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PartialserializationtestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartialserializationtestFactoryImpl()
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
      case PartialserializationtestPackage.MODEL: return createModel();
      case PartialserializationtestPackage.NODE_ROOT: return createNodeRoot();
      case PartialserializationtestPackage.NODE: return createNode();
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
  public NodeRoot createNodeRoot()
  {
    NodeRootImpl nodeRoot = new NodeRootImpl();
    return nodeRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node createNode()
  {
    NodeImpl node = new NodeImpl();
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartialserializationtestPackage getPartialserializationtestPackage()
  {
    return (PartialserializationtestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static PartialserializationtestPackage getPackage()
  {
    return PartialserializationtestPackage.eINSTANCE;
  }

} //PartialserializationtestFactoryImpl
