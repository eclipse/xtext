/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HiddentokenmergertestFactoryImpl extends EFactoryImpl implements HiddentokenmergertestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static HiddentokenmergertestFactory init()
  {
    try
    {
      HiddentokenmergertestFactory theHiddentokenmergertestFactory = (HiddentokenmergertestFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2009/tmf/xtext/hiddentokensmerger"); 
      if (theHiddentokenmergertestFactory != null)
      {
        return theHiddentokenmergertestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new HiddentokenmergertestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HiddentokenmergertestFactoryImpl()
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
      case HiddentokenmergertestPackage.MODEL: return createModel();
      case HiddentokenmergertestPackage.DATATYPE_BUG286557: return createDatatypeBug286557();
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
  public DatatypeBug286557 createDatatypeBug286557()
  {
    DatatypeBug286557Impl datatypeBug286557 = new DatatypeBug286557Impl();
    return datatypeBug286557;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HiddentokenmergertestPackage getHiddentokenmergertestPackage()
  {
    return (HiddentokenmergertestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static HiddentokenmergertestPackage getPackage()
  {
    return HiddentokenmergertestPackage.eINSTANCE;
  }

} //HiddentokenmergertestFactoryImpl
