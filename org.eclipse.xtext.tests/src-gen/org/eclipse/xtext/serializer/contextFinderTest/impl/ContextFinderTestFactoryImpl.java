/**
 */
package org.eclipse.xtext.serializer.contextFinderTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.serializer.contextFinderTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContextFinderTestFactoryImpl extends EFactoryImpl implements ContextFinderTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ContextFinderTestFactory init()
  {
    try
    {
      ContextFinderTestFactory theContextFinderTestFactory = (ContextFinderTestFactory)EPackage.Registry.INSTANCE.getEFactory(ContextFinderTestPackage.eNS_URI);
      if (theContextFinderTestFactory != null)
      {
        return theContextFinderTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ContextFinderTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextFinderTestFactoryImpl()
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
      case ContextFinderTestPackage.MODEL: return createModel();
      case ContextFinderTestPackage.ATTRIBUTE_EXCLUSION_TEST: return createAttributeExclusionTest();
      case ContextFinderTestPackage.NESTED_TYPE_TEST: return createNestedTypeTest();
      case ContextFinderTestPackage.NESTED_TYPE_CHILD: return createNestedTypeChild();
      case ContextFinderTestPackage.NESTED_TYPE_CHILD1: return createNestedTypeChild1();
      case ContextFinderTestPackage.NESTED_TYPE_CHILD2: return createNestedTypeChild2();
      case ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST: return createNestedTypeRecursiveTest();
      case ContextFinderTestPackage.PARENT_REF_TEST1: return createParentRefTest1();
      case ContextFinderTestPackage.PARENT_REF_TEST2: return createParentRefTest2();
      case ContextFinderTestPackage.PARENT_REF_TEST_CHILD: return createParentRefTestChild();
      case ContextFinderTestPackage.QUANTITY_EXCLUSION_TEST: return createQuantityExclusionTest();
      case ContextFinderTestPackage.VALUE_EXCLUSION_TEST: return createValueExclusionTest();
      case ContextFinderTestPackage.NODE_EXCLUSION: return createNodeExclusion();
      case ContextFinderTestPackage.NODE_EXCLUSION_LIST: return createNodeExclusionList();
      case ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST1: return createNestedTypeRecursiveTest1();
      case ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST2: return createNestedTypeRecursiveTest2();
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
      case ContextFinderTestPackage.VALUE_EXCLUSION_TEST_EN:
        return createValueExclusionTestEnFromString(eDataType, initialValue);
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
      case ContextFinderTestPackage.VALUE_EXCLUSION_TEST_EN:
        return convertValueExclusionTestEnToString(eDataType, instanceValue);
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
  public AttributeExclusionTest createAttributeExclusionTest()
  {
    AttributeExclusionTestImpl attributeExclusionTest = new AttributeExclusionTestImpl();
    return attributeExclusionTest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedTypeTest createNestedTypeTest()
  {
    NestedTypeTestImpl nestedTypeTest = new NestedTypeTestImpl();
    return nestedTypeTest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedTypeChild createNestedTypeChild()
  {
    NestedTypeChildImpl nestedTypeChild = new NestedTypeChildImpl();
    return nestedTypeChild;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedTypeChild1 createNestedTypeChild1()
  {
    NestedTypeChild1Impl nestedTypeChild1 = new NestedTypeChild1Impl();
    return nestedTypeChild1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedTypeChild2 createNestedTypeChild2()
  {
    NestedTypeChild2Impl nestedTypeChild2 = new NestedTypeChild2Impl();
    return nestedTypeChild2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedTypeRecursiveTest createNestedTypeRecursiveTest()
  {
    NestedTypeRecursiveTestImpl nestedTypeRecursiveTest = new NestedTypeRecursiveTestImpl();
    return nestedTypeRecursiveTest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParentRefTest1 createParentRefTest1()
  {
    ParentRefTest1Impl parentRefTest1 = new ParentRefTest1Impl();
    return parentRefTest1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParentRefTest2 createParentRefTest2()
  {
    ParentRefTest2Impl parentRefTest2 = new ParentRefTest2Impl();
    return parentRefTest2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParentRefTestChild createParentRefTestChild()
  {
    ParentRefTestChildImpl parentRefTestChild = new ParentRefTestChildImpl();
    return parentRefTestChild;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QuantityExclusionTest createQuantityExclusionTest()
  {
    QuantityExclusionTestImpl quantityExclusionTest = new QuantityExclusionTestImpl();
    return quantityExclusionTest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueExclusionTest createValueExclusionTest()
  {
    ValueExclusionTestImpl valueExclusionTest = new ValueExclusionTestImpl();
    return valueExclusionTest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeExclusion createNodeExclusion()
  {
    NodeExclusionImpl nodeExclusion = new NodeExclusionImpl();
    return nodeExclusion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeExclusionList createNodeExclusionList()
  {
    NodeExclusionListImpl nodeExclusionList = new NodeExclusionListImpl();
    return nodeExclusionList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedTypeRecursiveTest1 createNestedTypeRecursiveTest1()
  {
    NestedTypeRecursiveTest1Impl nestedTypeRecursiveTest1 = new NestedTypeRecursiveTest1Impl();
    return nestedTypeRecursiveTest1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedTypeRecursiveTest2 createNestedTypeRecursiveTest2()
  {
    NestedTypeRecursiveTest2Impl nestedTypeRecursiveTest2 = new NestedTypeRecursiveTest2Impl();
    return nestedTypeRecursiveTest2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueExclusionTestEn createValueExclusionTestEnFromString(EDataType eDataType, String initialValue)
  {
    ValueExclusionTestEn result = ValueExclusionTestEn.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertValueExclusionTestEnToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextFinderTestPackage getContextFinderTestPackage()
  {
    return (ContextFinderTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ContextFinderTestPackage getPackage()
  {
    return ContextFinderTestPackage.eINSTANCE;
  }

} //ContextFinderTestFactoryImpl
