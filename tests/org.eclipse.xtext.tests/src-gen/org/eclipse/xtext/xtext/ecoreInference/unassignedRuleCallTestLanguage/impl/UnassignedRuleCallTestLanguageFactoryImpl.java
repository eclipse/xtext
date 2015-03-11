/**
 */
package org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnassignedRuleCallTestLanguageFactoryImpl extends EFactoryImpl implements UnassignedRuleCallTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UnassignedRuleCallTestLanguageFactory init()
  {
    try
    {
      UnassignedRuleCallTestLanguageFactory theUnassignedRuleCallTestLanguageFactory = (UnassignedRuleCallTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(UnassignedRuleCallTestLanguagePackage.eNS_URI);
      if (theUnassignedRuleCallTestLanguageFactory != null)
      {
        return theUnassignedRuleCallTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new UnassignedRuleCallTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedRuleCallTestLanguageFactoryImpl()
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
      case UnassignedRuleCallTestLanguagePackage.MODEL: return createModel();
      case UnassignedRuleCallTestLanguagePackage.MODEL_FEATURES: return createModelFeatures();
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
  public ModelFeatures createModelFeatures()
  {
    ModelFeaturesImpl modelFeatures = new ModelFeaturesImpl();
    return modelFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedRuleCallTestLanguagePackage getUnassignedRuleCallTestLanguagePackage()
  {
    return (UnassignedRuleCallTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static UnassignedRuleCallTestLanguagePackage getPackage()
  {
    return UnassignedRuleCallTestLanguagePackage.eINSTANCE;
  }

} //UnassignedRuleCallTestLanguageFactoryImpl
