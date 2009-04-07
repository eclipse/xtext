/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.ecoredsl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.example.ecoredsl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcoredslFactoryImpl extends EFactoryImpl implements EcoredslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static EcoredslFactory init()
  {
    try
    {
      EcoredslFactory theEcoredslFactory = (EcoredslFactory)EPackage.Registry.INSTANCE.getEFactory("http://example.xtext.org/EcoreDsl"); 
      if (theEcoredslFactory != null)
      {
        return theEcoredslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new EcoredslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EcoredslFactoryImpl()
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
      case EcoredslPackage.ECORE_DSL: return createEcoreDsl();
      case EcoredslPackage.REFERENCED_METAMODEL: return createReferencedMetamodel();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EcoreDsl createEcoreDsl()
  {
    EcoreDslImpl ecoreDsl = new EcoreDslImpl();
    return ecoreDsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferencedMetamodel createReferencedMetamodel()
  {
    ReferencedMetamodelImpl referencedMetamodel = new ReferencedMetamodelImpl();
    return referencedMetamodel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EcoredslPackage getEcoredslPackage()
  {
    return (EcoredslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static EcoredslPackage getPackage()
  {
    return EcoredslPackage.eINSTANCE;
  }

} //EcoredslFactoryImpl
