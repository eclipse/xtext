/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.generator.ecore.superPackage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.generator.ecore.superPackage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SuperPackageFactoryImpl extends EFactoryImpl implements SuperPackageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SuperPackageFactory init()
  {
    try
    {
      SuperPackageFactory theSuperPackageFactory = (SuperPackageFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2009/tmf/xtext/SuperTestLanguage"); 
      if (theSuperPackageFactory != null)
      {
        return theSuperPackageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SuperPackageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuperPackageFactoryImpl()
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
      case SuperPackagePackage.SUPER_MAIN: return createSuperMain();
      case SuperPackagePackage.ANOTHER_SUPER_MAIN: return createAnotherSuperMain();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuperMain createSuperMain()
  {
    SuperMainImpl superMain = new SuperMainImpl();
    return superMain;
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
  public SuperPackagePackage getSuperPackagePackage()
  {
    return (SuperPackagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SuperPackagePackage getPackage()
  {
    return SuperPackagePackage.eINSTANCE;
  }

} //SuperPackageFactoryImpl
