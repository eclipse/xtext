/**
 */
package org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.NestedModel;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguageFactory;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguagePackage;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnorderedGroupsTestLanguagePackageImpl extends EPackageImpl implements UnorderedGroupsTestLanguagePackage
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
  private EClass nestedModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unorderedSerializationEClass = null;

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
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private UnorderedGroupsTestLanguagePackageImpl()
  {
    super(eNS_URI, UnorderedGroupsTestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link UnorderedGroupsTestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static UnorderedGroupsTestLanguagePackage init()
  {
    if (isInited) return (UnorderedGroupsTestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(UnorderedGroupsTestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    UnorderedGroupsTestLanguagePackageImpl theUnorderedGroupsTestLanguagePackage = (UnorderedGroupsTestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UnorderedGroupsTestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UnorderedGroupsTestLanguagePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theUnorderedGroupsTestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theUnorderedGroupsTestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theUnorderedGroupsTestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(UnorderedGroupsTestLanguagePackage.eNS_URI, theUnorderedGroupsTestLanguagePackage);
    return theUnorderedGroupsTestLanguagePackage;
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
  public EAttribute getModel_First()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModel_Second()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModel_Third()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModel_Forth()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModel_FirstAsList()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModel_SecondAsList()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModel_ThirdAsList()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModel_ForthAsList()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModel_Value()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Serialized()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_NestedModel()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNestedModel()
  {
    return nestedModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNestedModel_First()
  {
    return (EAttribute)nestedModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNestedModel_Second()
  {
    return (EAttribute)nestedModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnorderedSerialization()
  {
    return unorderedSerializationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedSerialization_First()
  {
    return (EAttribute)unorderedSerializationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedSerialization_Second()
  {
    return (EAttribute)unorderedSerializationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedSerialization_Third()
  {
    return (EAttribute)unorderedSerializationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedSerialization_Forth()
  {
    return (EAttribute)unorderedSerializationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedSerialization_FirstAsList()
  {
    return (EAttribute)unorderedSerializationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedSerialization_SecondAsList()
  {
    return (EAttribute)unorderedSerializationEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroupsTestLanguageFactory getUnorderedGroupsTestLanguageFactory()
  {
    return (UnorderedGroupsTestLanguageFactory)getEFactoryInstance();
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
    createEAttribute(modelEClass, MODEL__FIRST);
    createEAttribute(modelEClass, MODEL__SECOND);
    createEAttribute(modelEClass, MODEL__THIRD);
    createEAttribute(modelEClass, MODEL__FORTH);
    createEAttribute(modelEClass, MODEL__FIRST_AS_LIST);
    createEAttribute(modelEClass, MODEL__SECOND_AS_LIST);
    createEAttribute(modelEClass, MODEL__THIRD_AS_LIST);
    createEAttribute(modelEClass, MODEL__FORTH_AS_LIST);
    createEAttribute(modelEClass, MODEL__VALUE);
    createEReference(modelEClass, MODEL__SERIALIZED);
    createEReference(modelEClass, MODEL__NESTED_MODEL);

    nestedModelEClass = createEClass(NESTED_MODEL);
    createEAttribute(nestedModelEClass, NESTED_MODEL__FIRST);
    createEAttribute(nestedModelEClass, NESTED_MODEL__SECOND);

    unorderedSerializationEClass = createEClass(UNORDERED_SERIALIZATION);
    createEAttribute(unorderedSerializationEClass, UNORDERED_SERIALIZATION__FIRST);
    createEAttribute(unorderedSerializationEClass, UNORDERED_SERIALIZATION__SECOND);
    createEAttribute(unorderedSerializationEClass, UNORDERED_SERIALIZATION__THIRD);
    createEAttribute(unorderedSerializationEClass, UNORDERED_SERIALIZATION__FORTH);
    createEAttribute(unorderedSerializationEClass, UNORDERED_SERIALIZATION__FIRST_AS_LIST);
    createEAttribute(unorderedSerializationEClass, UNORDERED_SERIALIZATION__SECOND_AS_LIST);
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

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModel_First(), theEcorePackage.getEBoolean(), "first", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModel_Second(), theEcorePackage.getEBoolean(), "second", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModel_Third(), theEcorePackage.getEBoolean(), "third", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModel_Forth(), theEcorePackage.getEBoolean(), "forth", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModel_FirstAsList(), theEcorePackage.getEString(), "firstAsList", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModel_SecondAsList(), theEcorePackage.getEString(), "secondAsList", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModel_ThirdAsList(), theEcorePackage.getEString(), "thirdAsList", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModel_ForthAsList(), theEcorePackage.getEString(), "forthAsList", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModel_Value(), theEcorePackage.getEString(), "value", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_Serialized(), this.getUnorderedSerialization(), null, "serialized", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_NestedModel(), this.getNestedModel(), null, "nestedModel", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nestedModelEClass, NestedModel.class, "NestedModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNestedModel_First(), theEcorePackage.getEBoolean(), "first", null, 0, 1, NestedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNestedModel_Second(), theEcorePackage.getEBoolean(), "second", null, 0, 1, NestedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unorderedSerializationEClass, UnorderedSerialization.class, "UnorderedSerialization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnorderedSerialization_First(), theEcorePackage.getEBoolean(), "first", null, 0, 1, UnorderedSerialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnorderedSerialization_Second(), theEcorePackage.getEBoolean(), "second", null, 0, 1, UnorderedSerialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnorderedSerialization_Third(), theEcorePackage.getEBoolean(), "third", null, 0, 1, UnorderedSerialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnorderedSerialization_Forth(), theEcorePackage.getEBoolean(), "forth", null, 0, 1, UnorderedSerialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnorderedSerialization_FirstAsList(), theEcorePackage.getEString(), "firstAsList", null, 0, -1, UnorderedSerialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnorderedSerialization_SecondAsList(), theEcorePackage.getEString(), "secondAsList", null, 0, -1, UnorderedSerialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //UnorderedGroupsTestLanguagePackageImpl
