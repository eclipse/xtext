/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Bug348427TestLanguageFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Bug348427TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child1;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child2;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.EnumType;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Scenario1;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Scenario2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug348427TestLanguagePackageImpl extends EPackageImpl implements Bug348427TestLanguagePackage
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
  private EClass scenario1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass child1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scenario2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass child2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum enumTypeEEnum = null;

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
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Bug348427TestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Bug348427TestLanguagePackageImpl()
  {
    super(eNS_URI, Bug348427TestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link Bug348427TestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Bug348427TestLanguagePackage init()
  {
    if (isInited) return (Bug348427TestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(Bug348427TestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    Bug348427TestLanguagePackageImpl theBug348427TestLanguagePackage = (Bug348427TestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Bug348427TestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Bug348427TestLanguagePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theBug348427TestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theBug348427TestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBug348427TestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Bug348427TestLanguagePackage.eNS_URI, theBug348427TestLanguagePackage);
    return theBug348427TestLanguagePackage;
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
  public EReference getModel_Element1()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Element2()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScenario1()
  {
    return scenario1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScenario1_Child()
  {
    return (EReference)scenario1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getChild1()
  {
    return child1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getChild1_Name()
  {
    return (EAttribute)child1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getChild1_Bool()
  {
    return (EAttribute)child1EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getChild1_EnumType()
  {
    return (EAttribute)child1EClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScenario2()
  {
    return scenario2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScenario2_Child()
  {
    return (EReference)scenario2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getChild2()
  {
    return child2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getChild2_Name()
  {
    return (EAttribute)child2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getChild2_Bool()
  {
    return (EAttribute)child2EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getChild2_String()
  {
    return (EAttribute)child2EClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getEnumType()
  {
    return enumTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug348427TestLanguageFactory getBug348427TestLanguageFactory()
  {
    return (Bug348427TestLanguageFactory)getEFactoryInstance();
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
    createEReference(modelEClass, MODEL__ELEMENT1);
    createEReference(modelEClass, MODEL__ELEMENT2);

    scenario1EClass = createEClass(SCENARIO1);
    createEReference(scenario1EClass, SCENARIO1__CHILD);

    child1EClass = createEClass(CHILD1);
    createEAttribute(child1EClass, CHILD1__NAME);
    createEAttribute(child1EClass, CHILD1__BOOL);
    createEAttribute(child1EClass, CHILD1__ENUM_TYPE);

    scenario2EClass = createEClass(SCENARIO2);
    createEReference(scenario2EClass, SCENARIO2__CHILD);

    child2EClass = createEClass(CHILD2);
    createEAttribute(child2EClass, CHILD2__NAME);
    createEAttribute(child2EClass, CHILD2__BOOL);
    createEAttribute(child2EClass, CHILD2__STRING);

    // Create enums
    enumTypeEEnum = createEEnum(ENUM_TYPE);
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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Element1(), this.getScenario1(), null, "element1", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_Element2(), this.getScenario2(), null, "element2", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scenario1EClass, Scenario1.class, "Scenario1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getScenario1_Child(), this.getChild1(), null, "child", null, 0, -1, Scenario1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(child1EClass, Child1.class, "Child1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getChild1_Name(), ecorePackage.getEString(), "name", null, 0, 1, Child1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getChild1_Bool(), ecorePackage.getEBoolean(), "bool", null, 0, 1, Child1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getChild1_EnumType(), this.getEnumType(), "enumType", null, 0, 1, Child1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scenario2EClass, Scenario2.class, "Scenario2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getScenario2_Child(), this.getChild2(), null, "child", null, 0, -1, Scenario2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(child2EClass, Child2.class, "Child2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getChild2_Name(), ecorePackage.getEString(), "name", null, 0, 1, Child2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getChild2_Bool(), ecorePackage.getEBoolean(), "bool", null, 0, 1, Child2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getChild2_String(), ecorePackage.getEString(), "string", null, 0, 1, Child2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(enumTypeEEnum, EnumType.class, "EnumType");
    addEEnumLiteral(enumTypeEEnum, EnumType.A);
    addEEnumLiteral(enumTypeEEnum, EnumType.B);

    // Create resource
    createResource(eNS_URI);
  }

} //Bug348427TestLanguagePackageImpl
