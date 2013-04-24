/**
 */
package org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnorderedGroupsTestLanguageFactoryImpl extends EFactoryImpl implements UnorderedGroupsTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UnorderedGroupsTestLanguageFactory init()
  {
    try
    {
      UnorderedGroupsTestLanguageFactory theUnorderedGroupsTestLanguageFactory = (UnorderedGroupsTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(UnorderedGroupsTestLanguagePackage.eNS_URI);
      if (theUnorderedGroupsTestLanguageFactory != null)
      {
        return theUnorderedGroupsTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new UnorderedGroupsTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroupsTestLanguageFactoryImpl()
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
      case UnorderedGroupsTestLanguagePackage.MODEL: return createModel();
      case UnorderedGroupsTestLanguagePackage.NESTED_MODEL: return createNestedModel();
      case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION: return createUnorderedSerialization();
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
  public NestedModel createNestedModel()
  {
    NestedModelImpl nestedModel = new NestedModelImpl();
    return nestedModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedSerialization createUnorderedSerialization()
  {
    UnorderedSerializationImpl unorderedSerialization = new UnorderedSerializationImpl();
    return unorderedSerialization;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroupsTestLanguagePackage getUnorderedGroupsTestLanguagePackage()
  {
    return (UnorderedGroupsTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static UnorderedGroupsTestLanguagePackage getPackage()
  {
    return UnorderedGroupsTestLanguagePackage.eINSTANCE;
  }

} //UnorderedGroupsTestLanguageFactoryImpl
