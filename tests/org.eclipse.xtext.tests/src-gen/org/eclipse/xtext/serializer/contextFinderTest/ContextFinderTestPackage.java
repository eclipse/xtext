/**
 */
package org.eclipse.xtext.serializer.contextFinderTest;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestFactory
 * @model kind="package"
 * @generated
 */
public interface ContextFinderTestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "contextFinderTest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/contextfindertestlanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "contextFinderTest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ContextFinderTestPackage eINSTANCE = org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ModelImpl
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__MODEL = 0;

  /**
   * The feature id for the '<em><b>Attribute Exclusion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ATTRIBUTE_EXCLUSION = 1;

  /**
   * The feature id for the '<em><b>Nested Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NESTED_TYPE = 2;

  /**
   * The feature id for the '<em><b>Nested Type Recursive Test2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NESTED_TYPE_RECURSIVE_TEST2 = 3;

  /**
   * The feature id for the '<em><b>Parent Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__PARENT_REF = 4;

  /**
   * The feature id for the '<em><b>Quantity Exclusion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__QUANTITY_EXCLUSION = 5;

  /**
   * The feature id for the '<em><b>Value Exclusion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__VALUE_EXCLUSION = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NAME = 7;

  /**
   * The feature id for the '<em><b>Node Exclusion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NODE_EXCLUSION = 8;

  /**
   * The feature id for the '<em><b>Node Exclusion List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NODE_EXCLUSION_LIST = 9;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 10;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.AttributeExclusionTestImpl <em>Attribute Exclusion Test</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.AttributeExclusionTestImpl
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getAttributeExclusionTest()
   * @generated
   */
  int ATTRIBUTE_EXCLUSION_TEST = 1;

  /**
   * The feature id for the '<em><b>Attr1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_EXCLUSION_TEST__ATTR1 = 0;

  /**
   * The feature id for the '<em><b>Attr2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_EXCLUSION_TEST__ATTR2 = 1;

  /**
   * The number of structural features of the '<em>Attribute Exclusion Test</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_EXCLUSION_TEST_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeTestImpl <em>Nested Type Test</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeTestImpl
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNestedTypeTest()
   * @generated
   */
  int NESTED_TYPE_TEST = 2;

  /**
   * The feature id for the '<em><b>Nested</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_TYPE_TEST__NESTED = 0;

  /**
   * The number of structural features of the '<em>Nested Type Test</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_TYPE_TEST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeChildImpl <em>Nested Type Child</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeChildImpl
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNestedTypeChild()
   * @generated
   */
  int NESTED_TYPE_CHILD = 3;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_TYPE_CHILD__VAL = 0;

  /**
   * The number of structural features of the '<em>Nested Type Child</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_TYPE_CHILD_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeChild1Impl <em>Nested Type Child1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeChild1Impl
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNestedTypeChild1()
   * @generated
   */
  int NESTED_TYPE_CHILD1 = 4;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_TYPE_CHILD1__VAL = NESTED_TYPE_CHILD__VAL;

  /**
   * The number of structural features of the '<em>Nested Type Child1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_TYPE_CHILD1_FEATURE_COUNT = NESTED_TYPE_CHILD_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeChild2Impl <em>Nested Type Child2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeChild2Impl
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNestedTypeChild2()
   * @generated
   */
  int NESTED_TYPE_CHILD2 = 5;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_TYPE_CHILD2__VAL = NESTED_TYPE_CHILD__VAL;

  /**
   * The number of structural features of the '<em>Nested Type Child2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_TYPE_CHILD2_FEATURE_COUNT = NESTED_TYPE_CHILD_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeRecursiveTestImpl <em>Nested Type Recursive Test</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeRecursiveTestImpl
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNestedTypeRecursiveTest()
   * @generated
   */
  int NESTED_TYPE_RECURSIVE_TEST = 6;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_TYPE_RECURSIVE_TEST__LEFT = 0;

  /**
   * The number of structural features of the '<em>Nested Type Recursive Test</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_TYPE_RECURSIVE_TEST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.ParentRefTest1Impl <em>Parent Ref Test1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ParentRefTest1Impl
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getParentRefTest1()
   * @generated
   */
  int PARENT_REF_TEST1 = 7;

  /**
   * The feature id for the '<em><b>Child1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARENT_REF_TEST1__CHILD1 = 0;

  /**
   * The number of structural features of the '<em>Parent Ref Test1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARENT_REF_TEST1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.ParentRefTest2Impl <em>Parent Ref Test2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ParentRefTest2Impl
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getParentRefTest2()
   * @generated
   */
  int PARENT_REF_TEST2 = 8;

  /**
   * The feature id for the '<em><b>Child2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARENT_REF_TEST2__CHILD2 = 0;

  /**
   * The number of structural features of the '<em>Parent Ref Test2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARENT_REF_TEST2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.ParentRefTestChildImpl <em>Parent Ref Test Child</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ParentRefTestChildImpl
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getParentRefTestChild()
   * @generated
   */
  int PARENT_REF_TEST_CHILD = 9;

  /**
   * The feature id for the '<em><b>Child</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARENT_REF_TEST_CHILD__CHILD = 0;

  /**
   * The number of structural features of the '<em>Parent Ref Test Child</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARENT_REF_TEST_CHILD_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.QuantityExclusionTestImpl <em>Quantity Exclusion Test</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.QuantityExclusionTestImpl
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getQuantityExclusionTest()
   * @generated
   */
  int QUANTITY_EXCLUSION_TEST = 10;

  /**
   * The feature id for the '<em><b>Attr1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANTITY_EXCLUSION_TEST__ATTR1 = 0;

  /**
   * The feature id for the '<em><b>Attr2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANTITY_EXCLUSION_TEST__ATTR2 = 1;

  /**
   * The number of structural features of the '<em>Quantity Exclusion Test</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANTITY_EXCLUSION_TEST_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.ValueExclusionTestImpl <em>Value Exclusion Test</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ValueExclusionTestImpl
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getValueExclusionTest()
   * @generated
   */
  int VALUE_EXCLUSION_TEST = 11;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_EXCLUSION_TEST__VAL = 0;

  /**
   * The number of structural features of the '<em>Value Exclusion Test</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_EXCLUSION_TEST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NodeExclusionImpl <em>Node Exclusion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NodeExclusionImpl
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNodeExclusion()
   * @generated
   */
  int NODE_EXCLUSION = 12;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_EXCLUSION__REF = 0;

  /**
   * The number of structural features of the '<em>Node Exclusion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_EXCLUSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NodeExclusionListImpl <em>Node Exclusion List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NodeExclusionListImpl
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNodeExclusionList()
   * @generated
   */
  int NODE_EXCLUSION_LIST = 13;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_EXCLUSION_LIST__REF = 0;

  /**
   * The number of structural features of the '<em>Node Exclusion List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_EXCLUSION_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeRecursiveTest1Impl <em>Nested Type Recursive Test1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeRecursiveTest1Impl
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNestedTypeRecursiveTest1()
   * @generated
   */
  int NESTED_TYPE_RECURSIVE_TEST1 = 14;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_TYPE_RECURSIVE_TEST1__LEFT = NESTED_TYPE_RECURSIVE_TEST__LEFT;

  /**
   * The number of structural features of the '<em>Nested Type Recursive Test1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_TYPE_RECURSIVE_TEST1_FEATURE_COUNT = NESTED_TYPE_RECURSIVE_TEST_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeRecursiveTest2Impl <em>Nested Type Recursive Test2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeRecursiveTest2Impl
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNestedTypeRecursiveTest2()
   * @generated
   */
  int NESTED_TYPE_RECURSIVE_TEST2 = 15;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_TYPE_RECURSIVE_TEST2__LEFT = NESTED_TYPE_RECURSIVE_TEST__LEFT;

  /**
   * The number of structural features of the '<em>Nested Type Recursive Test2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_TYPE_RECURSIVE_TEST2_FEATURE_COUNT = NESTED_TYPE_RECURSIVE_TEST_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTestEn <em>Value Exclusion Test En</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTestEn
   * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getValueExclusionTestEn()
   * @generated
   */
  int VALUE_EXCLUSION_TEST_EN = 16;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.contextFinderTest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.contextFinderTest.Model#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Model</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.Model#getModel()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Model();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.contextFinderTest.Model#getAttributeExclusion <em>Attribute Exclusion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Attribute Exclusion</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.Model#getAttributeExclusion()
   * @see #getModel()
   * @generated
   */
  EReference getModel_AttributeExclusion();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.contextFinderTest.Model#getNestedType <em>Nested Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Nested Type</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.Model#getNestedType()
   * @see #getModel()
   * @generated
   */
  EReference getModel_NestedType();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.contextFinderTest.Model#getNestedTypeRecursiveTest2 <em>Nested Type Recursive Test2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Nested Type Recursive Test2</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.Model#getNestedTypeRecursiveTest2()
   * @see #getModel()
   * @generated
   */
  EReference getModel_NestedTypeRecursiveTest2();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.contextFinderTest.Model#getParentRef <em>Parent Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parent Ref</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.Model#getParentRef()
   * @see #getModel()
   * @generated
   */
  EReference getModel_ParentRef();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.contextFinderTest.Model#getQuantityExclusion <em>Quantity Exclusion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Quantity Exclusion</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.Model#getQuantityExclusion()
   * @see #getModel()
   * @generated
   */
  EReference getModel_QuantityExclusion();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.contextFinderTest.Model#getValueExclusion <em>Value Exclusion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value Exclusion</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.Model#getValueExclusion()
   * @see #getModel()
   * @generated
   */
  EReference getModel_ValueExclusion();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.contextFinderTest.Model#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.Model#getName()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.contextFinderTest.Model#getNodeExclusion <em>Node Exclusion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Node Exclusion</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.Model#getNodeExclusion()
   * @see #getModel()
   * @generated
   */
  EReference getModel_NodeExclusion();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.contextFinderTest.Model#getNodeExclusionList <em>Node Exclusion List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Node Exclusion List</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.Model#getNodeExclusionList()
   * @see #getModel()
   * @generated
   */
  EReference getModel_NodeExclusionList();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.contextFinderTest.AttributeExclusionTest <em>Attribute Exclusion Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Exclusion Test</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.AttributeExclusionTest
   * @generated
   */
  EClass getAttributeExclusionTest();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.contextFinderTest.AttributeExclusionTest#getAttr1 <em>Attr1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Attr1</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.AttributeExclusionTest#getAttr1()
   * @see #getAttributeExclusionTest()
   * @generated
   */
  EAttribute getAttributeExclusionTest_Attr1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.contextFinderTest.AttributeExclusionTest#getAttr2 <em>Attr2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Attr2</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.AttributeExclusionTest#getAttr2()
   * @see #getAttributeExclusionTest()
   * @generated
   */
  EAttribute getAttributeExclusionTest_Attr2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeTest <em>Nested Type Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Type Test</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NestedTypeTest
   * @generated
   */
  EClass getNestedTypeTest();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeTest#getNested <em>Nested</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Nested</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NestedTypeTest#getNested()
   * @see #getNestedTypeTest()
   * @generated
   */
  EReference getNestedTypeTest_Nested();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild <em>Nested Type Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Type Child</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild
   * @generated
   */
  EClass getNestedTypeChild();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild#getVal()
   * @see #getNestedTypeChild()
   * @generated
   */
  EAttribute getNestedTypeChild_Val();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild1 <em>Nested Type Child1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Type Child1</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild1
   * @generated
   */
  EClass getNestedTypeChild1();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild2 <em>Nested Type Child2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Type Child2</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild2
   * @generated
   */
  EClass getNestedTypeChild2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest <em>Nested Type Recursive Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Type Recursive Test</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest
   * @generated
   */
  EClass getNestedTypeRecursiveTest();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest#getLeft()
   * @see #getNestedTypeRecursiveTest()
   * @generated
   */
  EReference getNestedTypeRecursiveTest_Left();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest1 <em>Parent Ref Test1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parent Ref Test1</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest1
   * @generated
   */
  EClass getParentRefTest1();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest1#getChild1 <em>Child1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Child1</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest1#getChild1()
   * @see #getParentRefTest1()
   * @generated
   */
  EReference getParentRefTest1_Child1();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest2 <em>Parent Ref Test2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parent Ref Test2</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest2
   * @generated
   */
  EClass getParentRefTest2();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest2#getChild2 <em>Child2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Child2</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest2#getChild2()
   * @see #getParentRefTest2()
   * @generated
   */
  EReference getParentRefTest2_Child2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.contextFinderTest.ParentRefTestChild <em>Parent Ref Test Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parent Ref Test Child</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.ParentRefTestChild
   * @generated
   */
  EClass getParentRefTestChild();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.serializer.contextFinderTest.ParentRefTestChild#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Child</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.ParentRefTestChild#getChild()
   * @see #getParentRefTestChild()
   * @generated
   */
  EReference getParentRefTestChild_Child();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.contextFinderTest.QuantityExclusionTest <em>Quantity Exclusion Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Quantity Exclusion Test</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.QuantityExclusionTest
   * @generated
   */
  EClass getQuantityExclusionTest();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.contextFinderTest.QuantityExclusionTest#getAttr1 <em>Attr1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Attr1</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.QuantityExclusionTest#getAttr1()
   * @see #getQuantityExclusionTest()
   * @generated
   */
  EAttribute getQuantityExclusionTest_Attr1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.contextFinderTest.QuantityExclusionTest#getAttr2 <em>Attr2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Attr2</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.QuantityExclusionTest#getAttr2()
   * @see #getQuantityExclusionTest()
   * @generated
   */
  EAttribute getQuantityExclusionTest_Attr2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTest <em>Value Exclusion Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Exclusion Test</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTest
   * @generated
   */
  EClass getValueExclusionTest();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTest#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTest#getVal()
   * @see #getValueExclusionTest()
   * @generated
   */
  EAttribute getValueExclusionTest_Val();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.contextFinderTest.NodeExclusion <em>Node Exclusion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Exclusion</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NodeExclusion
   * @generated
   */
  EClass getNodeExclusion();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.serializer.contextFinderTest.NodeExclusion#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NodeExclusion#getRef()
   * @see #getNodeExclusion()
   * @generated
   */
  EReference getNodeExclusion_Ref();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.contextFinderTest.NodeExclusionList <em>Node Exclusion List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Exclusion List</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NodeExclusionList
   * @generated
   */
  EClass getNodeExclusionList();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.serializer.contextFinderTest.NodeExclusionList#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Ref</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NodeExclusionList#getRef()
   * @see #getNodeExclusionList()
   * @generated
   */
  EReference getNodeExclusionList_Ref();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest1 <em>Nested Type Recursive Test1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Type Recursive Test1</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest1
   * @generated
   */
  EClass getNestedTypeRecursiveTest1();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest2 <em>Nested Type Recursive Test2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Type Recursive Test2</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest2
   * @generated
   */
  EClass getNestedTypeRecursiveTest2();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTestEn <em>Value Exclusion Test En</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Value Exclusion Test En</em>'.
   * @see org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTestEn
   * @generated
   */
  EEnum getValueExclusionTestEn();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ContextFinderTestFactory getContextFinderTestFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ModelImpl
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__MODEL = eINSTANCE.getModel_Model();

    /**
     * The meta object literal for the '<em><b>Attribute Exclusion</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ATTRIBUTE_EXCLUSION = eINSTANCE.getModel_AttributeExclusion();

    /**
     * The meta object literal for the '<em><b>Nested Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__NESTED_TYPE = eINSTANCE.getModel_NestedType();

    /**
     * The meta object literal for the '<em><b>Nested Type Recursive Test2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__NESTED_TYPE_RECURSIVE_TEST2 = eINSTANCE.getModel_NestedTypeRecursiveTest2();

    /**
     * The meta object literal for the '<em><b>Parent Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__PARENT_REF = eINSTANCE.getModel_ParentRef();

    /**
     * The meta object literal for the '<em><b>Quantity Exclusion</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__QUANTITY_EXCLUSION = eINSTANCE.getModel_QuantityExclusion();

    /**
     * The meta object literal for the '<em><b>Value Exclusion</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__VALUE_EXCLUSION = eINSTANCE.getModel_ValueExclusion();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

    /**
     * The meta object literal for the '<em><b>Node Exclusion</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__NODE_EXCLUSION = eINSTANCE.getModel_NodeExclusion();

    /**
     * The meta object literal for the '<em><b>Node Exclusion List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__NODE_EXCLUSION_LIST = eINSTANCE.getModel_NodeExclusionList();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.AttributeExclusionTestImpl <em>Attribute Exclusion Test</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.AttributeExclusionTestImpl
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getAttributeExclusionTest()
     * @generated
     */
    EClass ATTRIBUTE_EXCLUSION_TEST = eINSTANCE.getAttributeExclusionTest();

    /**
     * The meta object literal for the '<em><b>Attr1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_EXCLUSION_TEST__ATTR1 = eINSTANCE.getAttributeExclusionTest_Attr1();

    /**
     * The meta object literal for the '<em><b>Attr2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_EXCLUSION_TEST__ATTR2 = eINSTANCE.getAttributeExclusionTest_Attr2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeTestImpl <em>Nested Type Test</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeTestImpl
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNestedTypeTest()
     * @generated
     */
    EClass NESTED_TYPE_TEST = eINSTANCE.getNestedTypeTest();

    /**
     * The meta object literal for the '<em><b>Nested</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NESTED_TYPE_TEST__NESTED = eINSTANCE.getNestedTypeTest_Nested();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeChildImpl <em>Nested Type Child</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeChildImpl
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNestedTypeChild()
     * @generated
     */
    EClass NESTED_TYPE_CHILD = eINSTANCE.getNestedTypeChild();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NESTED_TYPE_CHILD__VAL = eINSTANCE.getNestedTypeChild_Val();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeChild1Impl <em>Nested Type Child1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeChild1Impl
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNestedTypeChild1()
     * @generated
     */
    EClass NESTED_TYPE_CHILD1 = eINSTANCE.getNestedTypeChild1();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeChild2Impl <em>Nested Type Child2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeChild2Impl
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNestedTypeChild2()
     * @generated
     */
    EClass NESTED_TYPE_CHILD2 = eINSTANCE.getNestedTypeChild2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeRecursiveTestImpl <em>Nested Type Recursive Test</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeRecursiveTestImpl
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNestedTypeRecursiveTest()
     * @generated
     */
    EClass NESTED_TYPE_RECURSIVE_TEST = eINSTANCE.getNestedTypeRecursiveTest();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NESTED_TYPE_RECURSIVE_TEST__LEFT = eINSTANCE.getNestedTypeRecursiveTest_Left();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.ParentRefTest1Impl <em>Parent Ref Test1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ParentRefTest1Impl
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getParentRefTest1()
     * @generated
     */
    EClass PARENT_REF_TEST1 = eINSTANCE.getParentRefTest1();

    /**
     * The meta object literal for the '<em><b>Child1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARENT_REF_TEST1__CHILD1 = eINSTANCE.getParentRefTest1_Child1();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.ParentRefTest2Impl <em>Parent Ref Test2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ParentRefTest2Impl
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getParentRefTest2()
     * @generated
     */
    EClass PARENT_REF_TEST2 = eINSTANCE.getParentRefTest2();

    /**
     * The meta object literal for the '<em><b>Child2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARENT_REF_TEST2__CHILD2 = eINSTANCE.getParentRefTest2_Child2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.ParentRefTestChildImpl <em>Parent Ref Test Child</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ParentRefTestChildImpl
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getParentRefTestChild()
     * @generated
     */
    EClass PARENT_REF_TEST_CHILD = eINSTANCE.getParentRefTestChild();

    /**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARENT_REF_TEST_CHILD__CHILD = eINSTANCE.getParentRefTestChild_Child();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.QuantityExclusionTestImpl <em>Quantity Exclusion Test</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.QuantityExclusionTestImpl
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getQuantityExclusionTest()
     * @generated
     */
    EClass QUANTITY_EXCLUSION_TEST = eINSTANCE.getQuantityExclusionTest();

    /**
     * The meta object literal for the '<em><b>Attr1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUANTITY_EXCLUSION_TEST__ATTR1 = eINSTANCE.getQuantityExclusionTest_Attr1();

    /**
     * The meta object literal for the '<em><b>Attr2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUANTITY_EXCLUSION_TEST__ATTR2 = eINSTANCE.getQuantityExclusionTest_Attr2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.ValueExclusionTestImpl <em>Value Exclusion Test</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ValueExclusionTestImpl
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getValueExclusionTest()
     * @generated
     */
    EClass VALUE_EXCLUSION_TEST = eINSTANCE.getValueExclusionTest();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE_EXCLUSION_TEST__VAL = eINSTANCE.getValueExclusionTest_Val();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NodeExclusionImpl <em>Node Exclusion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NodeExclusionImpl
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNodeExclusion()
     * @generated
     */
    EClass NODE_EXCLUSION = eINSTANCE.getNodeExclusion();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_EXCLUSION__REF = eINSTANCE.getNodeExclusion_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NodeExclusionListImpl <em>Node Exclusion List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NodeExclusionListImpl
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNodeExclusionList()
     * @generated
     */
    EClass NODE_EXCLUSION_LIST = eINSTANCE.getNodeExclusionList();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_EXCLUSION_LIST__REF = eINSTANCE.getNodeExclusionList_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeRecursiveTest1Impl <em>Nested Type Recursive Test1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeRecursiveTest1Impl
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNestedTypeRecursiveTest1()
     * @generated
     */
    EClass NESTED_TYPE_RECURSIVE_TEST1 = eINSTANCE.getNestedTypeRecursiveTest1();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeRecursiveTest2Impl <em>Nested Type Recursive Test2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeRecursiveTest2Impl
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getNestedTypeRecursiveTest2()
     * @generated
     */
    EClass NESTED_TYPE_RECURSIVE_TEST2 = eINSTANCE.getNestedTypeRecursiveTest2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTestEn <em>Value Exclusion Test En</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTestEn
     * @see org.eclipse.xtext.serializer.contextFinderTest.impl.ContextFinderTestPackageImpl#getValueExclusionTestEn()
     * @generated
     */
    EEnum VALUE_EXCLUSION_TEST_EN = eINSTANCE.getValueExclusionTestEn();

  }

} //ContextFinderTestPackage
