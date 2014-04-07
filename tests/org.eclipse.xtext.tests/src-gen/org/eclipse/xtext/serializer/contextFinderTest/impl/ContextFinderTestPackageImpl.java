/**
 */
package org.eclipse.xtext.serializer.contextFinderTest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.serializer.contextFinderTest.AttributeExclusionTest;
import org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestFactory;
import org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage;
import org.eclipse.xtext.serializer.contextFinderTest.Model;
import org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild;
import org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild1;
import org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild2;
import org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest;
import org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest1;
import org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest2;
import org.eclipse.xtext.serializer.contextFinderTest.NestedTypeTest;
import org.eclipse.xtext.serializer.contextFinderTest.NodeExclusion;
import org.eclipse.xtext.serializer.contextFinderTest.NodeExclusionList;
import org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest1;
import org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest2;
import org.eclipse.xtext.serializer.contextFinderTest.ParentRefTestChild;
import org.eclipse.xtext.serializer.contextFinderTest.QuantityExclusionTest;
import org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTest;
import org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTestEn;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContextFinderTestPackageImpl extends EPackageImpl implements ContextFinderTestPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeExclusionTestEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nestedTypeTestEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nestedTypeChildEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nestedTypeChild1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nestedTypeChild2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nestedTypeRecursiveTestEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parentRefTest1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parentRefTest2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parentRefTestChildEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass quantityExclusionTestEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueExclusionTestEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nodeExclusionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nodeExclusionListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nestedTypeRecursiveTest1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nestedTypeRecursiveTest2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum valueExclusionTestEnEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ContextFinderTestPackageImpl()
  {
    super(eNS_URI, ContextFinderTestFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ContextFinderTestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ContextFinderTestPackage init()
  {
    if (isInited) return (ContextFinderTestPackage)EPackage.Registry.INSTANCE.getEPackage(ContextFinderTestPackage.eNS_URI);

    // Obtain or create and register package
    ContextFinderTestPackageImpl theContextFinderTestPackage = (ContextFinderTestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ContextFinderTestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ContextFinderTestPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theContextFinderTestPackage.createPackageContents();

    // Initialize created meta-data
    theContextFinderTestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theContextFinderTestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ContextFinderTestPackage.eNS_URI, theContextFinderTestPackage);
    return theContextFinderTestPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Model()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_AttributeExclusion()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_NestedType()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_NestedTypeRecursiveTest2()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_ParentRef()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_QuantityExclusion()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_ValueExclusion()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModel_Name()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_NodeExclusion()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_NodeExclusionList()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttributeExclusionTest()
  {
    return attributeExclusionTestEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttributeExclusionTest_Attr1()
  {
    return (EAttribute)attributeExclusionTestEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttributeExclusionTest_Attr2()
  {
    return (EAttribute)attributeExclusionTestEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNestedTypeTest()
  {
    return nestedTypeTestEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNestedTypeTest_Nested()
  {
    return (EReference)nestedTypeTestEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNestedTypeChild()
  {
    return nestedTypeChildEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNestedTypeChild_Val()
  {
    return (EAttribute)nestedTypeChildEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNestedTypeChild1()
  {
    return nestedTypeChild1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNestedTypeChild2()
  {
    return nestedTypeChild2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNestedTypeRecursiveTest()
  {
    return nestedTypeRecursiveTestEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNestedTypeRecursiveTest_Left()
  {
    return (EReference)nestedTypeRecursiveTestEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParentRefTest1()
  {
    return parentRefTest1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParentRefTest1_Child1()
  {
    return (EReference)parentRefTest1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParentRefTest2()
  {
    return parentRefTest2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParentRefTest2_Child2()
  {
    return (EReference)parentRefTest2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParentRefTestChild()
  {
    return parentRefTestChildEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParentRefTestChild_Child()
  {
    return (EReference)parentRefTestChildEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQuantityExclusionTest()
  {
    return quantityExclusionTestEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getQuantityExclusionTest_Attr1()
  {
    return (EAttribute)quantityExclusionTestEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getQuantityExclusionTest_Attr2()
  {
    return (EAttribute)quantityExclusionTestEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValueExclusionTest()
  {
    return valueExclusionTestEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getValueExclusionTest_Val()
  {
    return (EAttribute)valueExclusionTestEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNodeExclusion()
  {
    return nodeExclusionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeExclusion_Ref()
  {
    return (EReference)nodeExclusionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNodeExclusionList()
  {
    return nodeExclusionListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeExclusionList_Ref()
  {
    return (EReference)nodeExclusionListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNestedTypeRecursiveTest1()
  {
    return nestedTypeRecursiveTest1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNestedTypeRecursiveTest2()
  {
    return nestedTypeRecursiveTest2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getValueExclusionTestEn()
  {
    return valueExclusionTestEnEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextFinderTestFactory getContextFinderTestFactory()
  {
    return (ContextFinderTestFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__MODEL);
    createEReference(modelEClass, MODEL__ATTRIBUTE_EXCLUSION);
    createEReference(modelEClass, MODEL__NESTED_TYPE);
    createEReference(modelEClass, MODEL__NESTED_TYPE_RECURSIVE_TEST2);
    createEReference(modelEClass, MODEL__PARENT_REF);
    createEReference(modelEClass, MODEL__QUANTITY_EXCLUSION);
    createEReference(modelEClass, MODEL__VALUE_EXCLUSION);
    createEAttribute(modelEClass, MODEL__NAME);
    createEReference(modelEClass, MODEL__NODE_EXCLUSION);
    createEReference(modelEClass, MODEL__NODE_EXCLUSION_LIST);

    attributeExclusionTestEClass = createEClass(ATTRIBUTE_EXCLUSION_TEST);
    createEAttribute(attributeExclusionTestEClass, ATTRIBUTE_EXCLUSION_TEST__ATTR1);
    createEAttribute(attributeExclusionTestEClass, ATTRIBUTE_EXCLUSION_TEST__ATTR2);

    nestedTypeTestEClass = createEClass(NESTED_TYPE_TEST);
    createEReference(nestedTypeTestEClass, NESTED_TYPE_TEST__NESTED);

    nestedTypeChildEClass = createEClass(NESTED_TYPE_CHILD);
    createEAttribute(nestedTypeChildEClass, NESTED_TYPE_CHILD__VAL);

    nestedTypeChild1EClass = createEClass(NESTED_TYPE_CHILD1);

    nestedTypeChild2EClass = createEClass(NESTED_TYPE_CHILD2);

    nestedTypeRecursiveTestEClass = createEClass(NESTED_TYPE_RECURSIVE_TEST);
    createEReference(nestedTypeRecursiveTestEClass, NESTED_TYPE_RECURSIVE_TEST__LEFT);

    parentRefTest1EClass = createEClass(PARENT_REF_TEST1);
    createEReference(parentRefTest1EClass, PARENT_REF_TEST1__CHILD1);

    parentRefTest2EClass = createEClass(PARENT_REF_TEST2);
    createEReference(parentRefTest2EClass, PARENT_REF_TEST2__CHILD2);

    parentRefTestChildEClass = createEClass(PARENT_REF_TEST_CHILD);
    createEReference(parentRefTestChildEClass, PARENT_REF_TEST_CHILD__CHILD);

    quantityExclusionTestEClass = createEClass(QUANTITY_EXCLUSION_TEST);
    createEAttribute(quantityExclusionTestEClass, QUANTITY_EXCLUSION_TEST__ATTR1);
    createEAttribute(quantityExclusionTestEClass, QUANTITY_EXCLUSION_TEST__ATTR2);

    valueExclusionTestEClass = createEClass(VALUE_EXCLUSION_TEST);
    createEAttribute(valueExclusionTestEClass, VALUE_EXCLUSION_TEST__VAL);

    nodeExclusionEClass = createEClass(NODE_EXCLUSION);
    createEReference(nodeExclusionEClass, NODE_EXCLUSION__REF);

    nodeExclusionListEClass = createEClass(NODE_EXCLUSION_LIST);
    createEReference(nodeExclusionListEClass, NODE_EXCLUSION_LIST__REF);

    nestedTypeRecursiveTest1EClass = createEClass(NESTED_TYPE_RECURSIVE_TEST1);

    nestedTypeRecursiveTest2EClass = createEClass(NESTED_TYPE_RECURSIVE_TEST2);

    // Create enums
    valueExclusionTestEnEEnum = createEEnum(VALUE_EXCLUSION_TEST_EN);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    nestedTypeChild1EClass.getESuperTypes().add(this.getNestedTypeChild());
    nestedTypeChild2EClass.getESuperTypes().add(this.getNestedTypeChild());
    nestedTypeRecursiveTest1EClass.getESuperTypes().add(this.getNestedTypeRecursiveTest());
    nestedTypeRecursiveTest2EClass.getESuperTypes().add(this.getNestedTypeRecursiveTest());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Model(), this.getModel(), null, "model", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_AttributeExclusion(), this.getAttributeExclusionTest(), null, "attributeExclusion", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_NestedType(), this.getNestedTypeTest(), null, "nestedType", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_NestedTypeRecursiveTest2(), this.getNestedTypeRecursiveTest(), null, "nestedTypeRecursiveTest2", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_ParentRef(), theEcorePackage.getEObject(), null, "parentRef", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_QuantityExclusion(), this.getQuantityExclusionTest(), null, "quantityExclusion", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_ValueExclusion(), this.getValueExclusionTest(), null, "valueExclusion", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModel_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_NodeExclusion(), this.getNodeExclusion(), null, "nodeExclusion", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_NodeExclusionList(), this.getNodeExclusionList(), null, "nodeExclusionList", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeExclusionTestEClass, AttributeExclusionTest.class, "AttributeExclusionTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAttributeExclusionTest_Attr1(), theEcorePackage.getEString(), "attr1", null, 0, 1, AttributeExclusionTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAttributeExclusionTest_Attr2(), theEcorePackage.getEString(), "attr2", null, 0, 1, AttributeExclusionTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nestedTypeTestEClass, NestedTypeTest.class, "NestedTypeTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNestedTypeTest_Nested(), this.getNestedTypeChild(), null, "nested", null, 0, 1, NestedTypeTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nestedTypeChildEClass, NestedTypeChild.class, "NestedTypeChild", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNestedTypeChild_Val(), theEcorePackage.getEString(), "val", null, 0, 1, NestedTypeChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nestedTypeChild1EClass, NestedTypeChild1.class, "NestedTypeChild1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nestedTypeChild2EClass, NestedTypeChild2.class, "NestedTypeChild2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nestedTypeRecursiveTestEClass, NestedTypeRecursiveTest.class, "NestedTypeRecursiveTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNestedTypeRecursiveTest_Left(), this.getNestedTypeRecursiveTest(), null, "left", null, 0, 1, NestedTypeRecursiveTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parentRefTest1EClass, ParentRefTest1.class, "ParentRefTest1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParentRefTest1_Child1(), this.getParentRefTestChild(), null, "child1", null, 0, 1, ParentRefTest1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parentRefTest2EClass, ParentRefTest2.class, "ParentRefTest2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParentRefTest2_Child2(), this.getParentRefTestChild(), null, "child2", null, 0, 1, ParentRefTest2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parentRefTestChildEClass, ParentRefTestChild.class, "ParentRefTestChild", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParentRefTestChild_Child(), this.getParentRefTestChild(), null, "child", null, 0, 1, ParentRefTestChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(quantityExclusionTestEClass, QuantityExclusionTest.class, "QuantityExclusionTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getQuantityExclusionTest_Attr1(), theEcorePackage.getEString(), "attr1", null, 0, 1, QuantityExclusionTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getQuantityExclusionTest_Attr2(), theEcorePackage.getEString(), "attr2", null, 0, 1, QuantityExclusionTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueExclusionTestEClass, ValueExclusionTest.class, "ValueExclusionTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getValueExclusionTest_Val(), this.getValueExclusionTestEn(), "val", null, 0, 1, ValueExclusionTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nodeExclusionEClass, NodeExclusion.class, "NodeExclusion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNodeExclusion_Ref(), this.getModel(), null, "ref", null, 0, 1, NodeExclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nodeExclusionListEClass, NodeExclusionList.class, "NodeExclusionList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNodeExclusionList_Ref(), this.getModel(), null, "ref", null, 0, -1, NodeExclusionList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nestedTypeRecursiveTest1EClass, NestedTypeRecursiveTest1.class, "NestedTypeRecursiveTest1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nestedTypeRecursiveTest2EClass, NestedTypeRecursiveTest2.class, "NestedTypeRecursiveTest2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(valueExclusionTestEnEEnum, ValueExclusionTestEn.class, "ValueExclusionTestEn");
    addEEnumLiteral(valueExclusionTestEnEEnum, ValueExclusionTestEn.LIT0);
    addEEnumLiteral(valueExclusionTestEnEEnum, ValueExclusionTestEn.LIT1);
    addEEnumLiteral(valueExclusionTestEnEEnum, ValueExclusionTestEn.LIT2);

    // Create resource
    createResource(eNS_URI);
  }

} //ContextFinderTestPackageImpl
