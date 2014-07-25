/**
 */
package org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.formatting2.internal.formattertestlanguage.*;

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
      case FormattertestlanguagePackage.ID_LIST: return createIDList();
      case FormattertestlanguagePackage.KW_LIST: return createKWList();
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
  public IDList createIDList()
  {
    IDListImpl idList = new IDListImpl();
    return idList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KWList createKWList()
  {
    KWListImpl kwList = new KWListImpl();
    return kwList;
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
