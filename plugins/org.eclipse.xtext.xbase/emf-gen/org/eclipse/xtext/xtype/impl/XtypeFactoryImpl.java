/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtype.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xtype.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtypeFactoryImpl extends EFactoryImpl implements XtypeFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static XtypeFactory init()
  {
    try
    {
      XtypeFactory theXtypeFactory = (XtypeFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/xbase/Xtype"); 
      if (theXtypeFactory != null)
      {
        return theXtypeFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new XtypeFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtypeFactoryImpl()
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
      case XtypePackage.XFUNCTION_TYPE_REF: return createXFunctionTypeRef();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XFunctionTypeRef createXFunctionTypeRef()
  {
    XFunctionTypeRefImplCustom xFunctionTypeRef = new XFunctionTypeRefImplCustom();
    return xFunctionTypeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtypePackage getXtypePackage()
  {
    return (XtypePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static XtypePackage getPackage()
  {
    return XtypePackage.eINSTANCE;
  }

} //XtypeFactoryImpl
