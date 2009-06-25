/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.datatypeRuleTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.ui.common.editor.contentassist.datatypeRuleTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DatatypeRuleTestFactoryImpl extends EFactoryImpl implements DatatypeRuleTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static DatatypeRuleTestFactory init()
  {
    try
    {
      DatatypeRuleTestFactory theDatatypeRuleTestFactory = (DatatypeRuleTestFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/tmf/tests/2009/datatypeRuleTest"); 
      if (theDatatypeRuleTestFactory != null)
      {
        return theDatatypeRuleTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new DatatypeRuleTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DatatypeRuleTestFactoryImpl()
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
      case DatatypeRuleTestPackage.MODEL: return createModel();
      case DatatypeRuleTestPackage.TYPES: return createTypes();
      case DatatypeRuleTestPackage.TYPE: return createType();
      case DatatypeRuleTestPackage.SIMPLE_TYPE: return createSimpleType();
      case DatatypeRuleTestPackage.COMPOSITE_TYPE: return createCompositeType();
      case DatatypeRuleTestPackage.COMPOSITE_TYPE_ENTRY: return createCompositeTypeEntry();
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
  public Types createTypes()
  {
    TypesImpl types = new TypesImpl();
    return types;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createType()
  {
    TypeImpl type = new TypeImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleType createSimpleType()
  {
    SimpleTypeImpl simpleType = new SimpleTypeImpl();
    return simpleType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompositeType createCompositeType()
  {
    CompositeTypeImpl compositeType = new CompositeTypeImpl();
    return compositeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompositeTypeEntry createCompositeTypeEntry()
  {
    CompositeTypeEntryImpl compositeTypeEntry = new CompositeTypeEntryImpl();
    return compositeTypeEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DatatypeRuleTestPackage getDatatypeRuleTestPackage()
  {
    return (DatatypeRuleTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static DatatypeRuleTestPackage getPackage()
  {
    return DatatypeRuleTestPackage.eINSTANCE;
  }

} //DatatypeRuleTestFactoryImpl
