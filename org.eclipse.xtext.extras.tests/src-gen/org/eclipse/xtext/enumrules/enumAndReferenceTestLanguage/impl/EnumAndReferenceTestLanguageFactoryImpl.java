/**
 */
package org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnumAndReferenceTestLanguageFactoryImpl extends EFactoryImpl implements EnumAndReferenceTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static EnumAndReferenceTestLanguageFactory init()
  {
    try
    {
      EnumAndReferenceTestLanguageFactory theEnumAndReferenceTestLanguageFactory = (EnumAndReferenceTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(EnumAndReferenceTestLanguagePackage.eNS_URI);
      if (theEnumAndReferenceTestLanguageFactory != null)
      {
        return theEnumAndReferenceTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new EnumAndReferenceTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumAndReferenceTestLanguageFactoryImpl()
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
      case EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE: return createEntityWithEnumAndReference();
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
      case EnumAndReferenceTestLanguagePackage.KIND_OF_KEYWORD:
        return createKindOfKeywordFromString(eDataType, initialValue);
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
      case EnumAndReferenceTestLanguagePackage.KIND_OF_KEYWORD:
        return convertKindOfKeywordToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EntityWithEnumAndReference createEntityWithEnumAndReference()
  {
    EntityWithEnumAndReferenceImpl entityWithEnumAndReference = new EntityWithEnumAndReferenceImpl();
    return entityWithEnumAndReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KindOfKeyword createKindOfKeywordFromString(EDataType eDataType, String initialValue)
  {
    KindOfKeyword result = KindOfKeyword.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertKindOfKeywordToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumAndReferenceTestLanguagePackage getEnumAndReferenceTestLanguagePackage()
  {
    return (EnumAndReferenceTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static EnumAndReferenceTestLanguagePackage getPackage()
  {
    return EnumAndReferenceTestLanguagePackage.eINSTANCE;
  }

} //EnumAndReferenceTestLanguageFactoryImpl
