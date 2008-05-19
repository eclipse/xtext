/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtextutilFactoryImpl.java,v 1.7 2008/05/19 12:11:20 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextutil.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xtextutil.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtextutilFactoryImpl extends EFactoryImpl implements XtextutilFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static XtextutilFactory init()
  {
    try
    {
      XtextutilFactory theXtextutilFactory = (XtextutilFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2008/Xtext/Utilities"); 
      if (theXtextutilFactory != null)
      {
        return theXtextutilFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new XtextutilFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtextutilFactoryImpl()
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
      case XtextutilPackage.RESOLVED_TYPE: return createResolvedType();
      case XtextutilPackage.META_MODEL: return createMetaModel();
      case XtextutilPackage.BUILTIN_TYPE: return createBuiltinType();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResolvedType createResolvedType()
  {
    ResolvedTypeImpl resolvedType = new ResolvedTypeImpl();
    return resolvedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetaModel createMetaModel()
  {
    MetaModelImpl metaModel = new MetaModelImpl();
    return metaModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BuiltinType createBuiltinType()
  {
    BuiltinTypeImpl builtinType = new BuiltinTypeImpl();
    return builtinType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtextutilPackage getXtextutilPackage()
  {
    return (XtextutilPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static XtextutilPackage getPackage()
  {
    return XtextutilPackage.eINSTANCE;
  }

} //XtextutilFactoryImpl
