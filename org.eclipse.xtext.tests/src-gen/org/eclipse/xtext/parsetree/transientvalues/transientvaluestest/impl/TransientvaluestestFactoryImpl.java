/**
 */
package org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TransientvaluestestFactoryImpl extends EFactoryImpl implements TransientvaluestestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TransientvaluestestFactory init()
  {
    try
    {
      TransientvaluestestFactory theTransientvaluestestFactory = (TransientvaluestestFactory)EPackage.Registry.INSTANCE.getEFactory(TransientvaluestestPackage.eNS_URI);
      if (theTransientvaluestestFactory != null)
      {
        return theTransientvaluestestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TransientvaluestestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransientvaluestestFactoryImpl()
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
      case TransientvaluestestPackage.ROOT: return createRoot();
      case TransientvaluestestPackage.TEST_REQUIRED: return createTestRequired();
      case TransientvaluestestPackage.TEST_OPTIONAL: return createTestOptional();
      case TransientvaluestestPackage.TEST_LIST: return createTestList();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Root createRoot()
  {
    RootImpl root = new RootImpl();
    return root;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestRequired createTestRequired()
  {
    TestRequiredImpl testRequired = new TestRequiredImpl();
    return testRequired;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestOptional createTestOptional()
  {
    TestOptionalImpl testOptional = new TestOptionalImpl();
    return testOptional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestList createTestList()
  {
    TestListImpl testList = new TestListImpl();
    return testList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransientvaluestestPackage getTransientvaluestestPackage()
  {
    return (TransientvaluestestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TransientvaluestestPackage getPackage()
  {
    return TransientvaluestestPackage.eINSTANCE;
  }

} //TransientvaluestestFactoryImpl
