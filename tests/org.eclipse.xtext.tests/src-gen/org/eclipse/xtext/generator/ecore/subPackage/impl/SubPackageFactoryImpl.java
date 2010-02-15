/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.generator.ecore.subPackage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.generator.ecore.subPackage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SubPackageFactoryImpl extends EFactoryImpl implements SubPackageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SubPackageFactory init()
  {
    try
    {
      SubPackageFactory theSubPackageFactory = (SubPackageFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2009/tmf/xtext/SubTestLanguage"); 
      if (theSubPackageFactory != null)
      {
        return theSubPackageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SubPackageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubPackageFactoryImpl()
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
      case SubPackagePackage.SUB_MAIN: return createSubMain();
      case SubPackagePackage.ANOTHER_SUPER_MAIN: return createAnotherSuperMain();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubMain createSubMain()
  {
    SubMainImpl subMain = new SubMainImpl();
    return subMain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnotherSuperMain createAnotherSuperMain()
  {
    AnotherSuperMainImpl anotherSuperMain = new AnotherSuperMainImpl();
    return anotherSuperMain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubPackagePackage getSubPackagePackage()
  {
    return (SubPackagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SubPackagePackage getPackage()
  {
    return SubPackagePackage.eINSTANCE;
  }

} //SubPackageFactoryImpl
