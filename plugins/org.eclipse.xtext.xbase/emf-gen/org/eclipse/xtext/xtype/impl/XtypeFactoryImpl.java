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
      case XtypePackage.XTYPE_REF: return createXTypeRef();
      case XtypePackage.XFUNCTION_TYPE_REF: return createXFunctionTypeRef();
      case XtypePackage.XSIMPLE_TYPE_REF: return createXSimpleTypeRef();
      case XtypePackage.XWILDCARD_PARAM: return createXWildcardParam();
      case XtypePackage.XTYPE_PARAM_DECLARATION: return createXTypeParamDeclaration();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XTypeRef createXTypeRef()
  {
    XTypeRefImpl xTypeRef = new XTypeRefImpl();
    return xTypeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XFunctionTypeRef createXFunctionTypeRef()
  {
    XFunctionTypeRefImpl xFunctionTypeRef = new XFunctionTypeRefImpl();
    return xFunctionTypeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XSimpleTypeRef createXSimpleTypeRef()
  {
    XSimpleTypeRefImpl xSimpleTypeRef = new XSimpleTypeRefImpl();
    return xSimpleTypeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XWildcardParam createXWildcardParam()
  {
    XWildcardParamImpl xWildcardParam = new XWildcardParamImpl();
    return xWildcardParam;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XTypeParamDeclaration createXTypeParamDeclaration()
  {
    XTypeParamDeclarationImpl xTypeParamDeclaration = new XTypeParamDeclarationImpl();
    return xTypeParamDeclaration;
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
