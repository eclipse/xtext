/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug348427TestLanguageFactoryImpl extends EFactoryImpl implements Bug348427TestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Bug348427TestLanguageFactory init()
  {
    try
    {
      Bug348427TestLanguageFactory theBug348427TestLanguageFactory = (Bug348427TestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(Bug348427TestLanguagePackage.eNS_URI);
      if (theBug348427TestLanguageFactory != null)
      {
        return theBug348427TestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Bug348427TestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug348427TestLanguageFactoryImpl()
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
      case Bug348427TestLanguagePackage.MODEL: return createModel();
      case Bug348427TestLanguagePackage.SCENARIO1: return createScenario1();
      case Bug348427TestLanguagePackage.CHILD1: return createChild1();
      case Bug348427TestLanguagePackage.SCENARIO2: return createScenario2();
      case Bug348427TestLanguagePackage.CHILD2: return createChild2();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case Bug348427TestLanguagePackage.ENUM_TYPE:
        return createEnumTypeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case Bug348427TestLanguagePackage.ENUM_TYPE:
        return convertEnumTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
  public Scenario1 createScenario1()
  {
    Scenario1Impl scenario1 = new Scenario1Impl();
    return scenario1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Child1 createChild1()
  {
    Child1Impl child1 = new Child1Impl();
    return child1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scenario2 createScenario2()
  {
    Scenario2Impl scenario2 = new Scenario2Impl();
    return scenario2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Child2 createChild2()
  {
    Child2Impl child2 = new Child2Impl();
    return child2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumType createEnumTypeFromString(EDataType eDataType, String initialValue)
  {
    EnumType result = EnumType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertEnumTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug348427TestLanguagePackage getBug348427TestLanguagePackage()
  {
    return (Bug348427TestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Bug348427TestLanguagePackage getPackage()
  {
    return Bug348427TestLanguagePackage.eINSTANCE;
  }

} //Bug348427TestLanguageFactoryImpl
