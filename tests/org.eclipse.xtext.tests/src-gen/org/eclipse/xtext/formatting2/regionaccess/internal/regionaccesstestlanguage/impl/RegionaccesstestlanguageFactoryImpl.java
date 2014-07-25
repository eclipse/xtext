/**
 */
package org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RegionaccesstestlanguageFactoryImpl extends EFactoryImpl implements RegionaccesstestlanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static RegionaccesstestlanguageFactory init()
  {
    try
    {
      RegionaccesstestlanguageFactory theRegionaccesstestlanguageFactory = (RegionaccesstestlanguageFactory)EPackage.Registry.INSTANCE.getEFactory(RegionaccesstestlanguagePackage.eNS_URI);
      if (theRegionaccesstestlanguageFactory != null)
      {
        return theRegionaccesstestlanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new RegionaccesstestlanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RegionaccesstestlanguageFactoryImpl()
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
      case RegionaccesstestlanguagePackage.ROOT: return createRoot();
      case RegionaccesstestlanguagePackage.SIMPLE: return createSimple();
      case RegionaccesstestlanguagePackage.DELEGATION: return createDelegation();
      case RegionaccesstestlanguagePackage.UNASSIGNED: return createUnassigned();
      case RegionaccesstestlanguagePackage.PREFIXED_UNASSIGNED: return createPrefixedUnassigned();
      case RegionaccesstestlanguagePackage.PREFIXED_DELEGATE: return createPrefixedDelegate();
      case RegionaccesstestlanguagePackage.DELEGATE: return createDelegate();
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
  public Simple createSimple()
  {
    SimpleImpl simple = new SimpleImpl();
    return simple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Delegation createDelegation()
  {
    DelegationImpl delegation = new DelegationImpl();
    return delegation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Unassigned createUnassigned()
  {
    UnassignedImpl unassigned = new UnassignedImpl();
    return unassigned;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrefixedUnassigned createPrefixedUnassigned()
  {
    PrefixedUnassignedImpl prefixedUnassigned = new PrefixedUnassignedImpl();
    return prefixedUnassigned;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrefixedDelegate createPrefixedDelegate()
  {
    PrefixedDelegateImpl prefixedDelegate = new PrefixedDelegateImpl();
    return prefixedDelegate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Delegate createDelegate()
  {
    DelegateImpl delegate = new DelegateImpl();
    return delegate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RegionaccesstestlanguagePackage getRegionaccesstestlanguagePackage()
  {
    return (RegionaccesstestlanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static RegionaccesstestlanguagePackage getPackage()
  {
    return RegionaccesstestlanguagePackage.eINSTANCE;
  }

} //RegionaccesstestlanguageFactoryImpl
