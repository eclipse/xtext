/**
 */
package org.eclipse.xtext.formatting2.regionaccess.internal.formattertestlanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.formatting2.regionaccess.internal.formattertestlanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FormattertestlanguageFactoryImpl extends EFactoryImpl implements FormattertestlanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FormattertestlanguageFactory init()
  {
    try
    {
      FormattertestlanguageFactory theFormattertestlanguageFactory = (FormattertestlanguageFactory)EPackage.Registry.INSTANCE.getEFactory(FormattertestlanguagePackage.eNS_URI);
      if (theFormattertestlanguageFactory != null)
      {
        return theFormattertestlanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new FormattertestlanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormattertestlanguageFactoryImpl()
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
      case FormattertestlanguagePackage.ROOT: return createRoot();
      case FormattertestlanguagePackage.SIMPLE: return createSimple();
      case FormattertestlanguagePackage.DELEGATION: return createDelegation();
      case FormattertestlanguagePackage.UNASSIGNED: return createUnassigned();
      case FormattertestlanguagePackage.PREFIXED_UNASSIGNED: return createPrefixedUnassigned();
      case FormattertestlanguagePackage.PREFIXED_DELEGATE: return createPrefixedDelegate();
      case FormattertestlanguagePackage.DELEGATE: return createDelegate();
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
  public FormattertestlanguagePackage getFormattertestlanguagePackage()
  {
    return (FormattertestlanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static FormattertestlanguagePackage getPackage()
  {
    return FormattertestlanguagePackage.eINSTANCE;
  }

} //FormattertestlanguageFactoryImpl
