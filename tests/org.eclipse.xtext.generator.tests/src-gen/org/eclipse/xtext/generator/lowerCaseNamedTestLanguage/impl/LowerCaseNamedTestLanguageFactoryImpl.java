/**
 * <copyright>
 * </copyright>
 *
 * $Id: LowerCaseNamedTestLanguageFactoryImpl.java,v 1.2 2009/02/18 21:22:42 sefftinge Exp $
 */
package org.eclipse.xtext.generator.lowerCaseNamedTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.generator.lowerCaseNamedTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LowerCaseNamedTestLanguageFactoryImpl extends EFactoryImpl implements LowerCaseNamedTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LowerCaseNamedTestLanguageFactory init()
  {
    try
    {
      LowerCaseNamedTestLanguageFactory theLowerCaseNamedTestLanguageFactory = (LowerCaseNamedTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2009/tmf/xtext/lowerCaseNamedTestLanguage"); 
      if (theLowerCaseNamedTestLanguageFactory != null)
      {
        return theLowerCaseNamedTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new LowerCaseNamedTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LowerCaseNamedTestLanguageFactoryImpl()
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
      case LowerCaseNamedTestLanguagePackage.MODEL: return createModel();
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
  public LowerCaseNamedTestLanguagePackage getLowerCaseNamedTestLanguagePackage()
  {
    return (LowerCaseNamedTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static LowerCaseNamedTestLanguagePackage getPackage()
  {
    return LowerCaseNamedTestLanguagePackage.eINSTANCE;
  }

} //LowerCaseNamedTestLanguageFactoryImpl
