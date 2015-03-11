/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Alternative;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Bug360834TestLanguageFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Bug360834TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.ClassMember;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Modifiers;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.RecursiveClassDeclaration;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.SimpleClassDeclaration;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Unordered;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.UnorderedModifiers;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Visibility;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug360834TestLanguagePackageImpl extends EPackageImpl implements Bug360834TestLanguagePackage
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
  private EClass alternativeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recursiveClassDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modifiersEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unorderedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleClassDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classMemberEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unorderedModifiersEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum visibilityEEnum = null;

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
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Bug360834TestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Bug360834TestLanguagePackageImpl()
  {
    super(eNS_URI, Bug360834TestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link Bug360834TestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Bug360834TestLanguagePackage init()
  {
    if (isInited) return (Bug360834TestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(Bug360834TestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    Bug360834TestLanguagePackageImpl theBug360834TestLanguagePackage = (Bug360834TestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Bug360834TestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Bug360834TestLanguagePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theBug360834TestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theBug360834TestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBug360834TestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Bug360834TestLanguagePackage.eNS_URI, theBug360834TestLanguagePackage);
    return theBug360834TestLanguagePackage;
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
  public EReference getModel_Element()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAlternative()
  {
    return alternativeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAlternative_Name()
  {
    return (EAttribute)alternativeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAlternative_RootDeclaration()
  {
    return (EReference)alternativeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecursiveClassDeclaration()
  {
    return recursiveClassDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecursiveClassDeclaration_Modifiers()
  {
    return (EReference)recursiveClassDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRecursiveClassDeclaration_Name()
  {
    return (EAttribute)recursiveClassDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecursiveClassDeclaration_Members()
  {
    return (EReference)recursiveClassDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModifiers()
  {
    return modifiersEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModifiers_Final()
  {
    return (EAttribute)modifiersEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModifiers_Abstract()
  {
    return (EAttribute)modifiersEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModifiers_Extern()
  {
    return (EAttribute)modifiersEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModifiers_Visibility()
  {
    return (EAttribute)modifiersEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnordered()
  {
    return unorderedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnordered_Name()
  {
    return (EAttribute)unorderedEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnordered_RootDeclaration()
  {
    return (EReference)unorderedEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleClassDeclaration()
  {
    return simpleClassDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSimpleClassDeclaration_Modifiers()
  {
    return (EReference)simpleClassDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleClassDeclaration_Name()
  {
    return (EAttribute)simpleClassDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSimpleClassDeclaration_Members()
  {
    return (EReference)simpleClassDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassMember()
  {
    return classMemberEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassMember_Modifiers()
  {
    return (EReference)classMemberEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassMember_Name()
  {
    return (EAttribute)classMemberEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnorderedModifiers()
  {
    return unorderedModifiersEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getVisibility()
  {
    return visibilityEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug360834TestLanguageFactory getBug360834TestLanguageFactory()
  {
    return (Bug360834TestLanguageFactory)getEFactoryInstance();
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
    createEReference(modelEClass, MODEL__ELEMENT);

    alternativeEClass = createEClass(ALTERNATIVE);
    createEAttribute(alternativeEClass, ALTERNATIVE__NAME);
    createEReference(alternativeEClass, ALTERNATIVE__ROOT_DECLARATION);

    recursiveClassDeclarationEClass = createEClass(RECURSIVE_CLASS_DECLARATION);
    createEReference(recursiveClassDeclarationEClass, RECURSIVE_CLASS_DECLARATION__MODIFIERS);
    createEAttribute(recursiveClassDeclarationEClass, RECURSIVE_CLASS_DECLARATION__NAME);
    createEReference(recursiveClassDeclarationEClass, RECURSIVE_CLASS_DECLARATION__MEMBERS);

    modifiersEClass = createEClass(MODIFIERS);
    createEAttribute(modifiersEClass, MODIFIERS__FINAL);
    createEAttribute(modifiersEClass, MODIFIERS__ABSTRACT);
    createEAttribute(modifiersEClass, MODIFIERS__EXTERN);
    createEAttribute(modifiersEClass, MODIFIERS__VISIBILITY);

    unorderedEClass = createEClass(UNORDERED);
    createEAttribute(unorderedEClass, UNORDERED__NAME);
    createEReference(unorderedEClass, UNORDERED__ROOT_DECLARATION);

    simpleClassDeclarationEClass = createEClass(SIMPLE_CLASS_DECLARATION);
    createEReference(simpleClassDeclarationEClass, SIMPLE_CLASS_DECLARATION__MODIFIERS);
    createEAttribute(simpleClassDeclarationEClass, SIMPLE_CLASS_DECLARATION__NAME);
    createEReference(simpleClassDeclarationEClass, SIMPLE_CLASS_DECLARATION__MEMBERS);

    classMemberEClass = createEClass(CLASS_MEMBER);
    createEReference(classMemberEClass, CLASS_MEMBER__MODIFIERS);
    createEAttribute(classMemberEClass, CLASS_MEMBER__NAME);

    unorderedModifiersEClass = createEClass(UNORDERED_MODIFIERS);

    // Create enums
    visibilityEEnum = createEEnum(VISIBILITY);
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
    modifiersEClass.getESuperTypes().add(this.getUnorderedModifiers());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Element(), ecorePackage.getEObject(), null, "element", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(alternativeEClass, Alternative.class, "Alternative", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAlternative_Name(), ecorePackage.getEString(), "name", null, 0, 1, Alternative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAlternative_RootDeclaration(), this.getRecursiveClassDeclaration(), null, "rootDeclaration", null, 0, 1, Alternative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recursiveClassDeclarationEClass, RecursiveClassDeclaration.class, "RecursiveClassDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRecursiveClassDeclaration_Modifiers(), this.getModifiers(), null, "modifiers", null, 0, 1, RecursiveClassDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRecursiveClassDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, RecursiveClassDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecursiveClassDeclaration_Members(), this.getRecursiveClassDeclaration(), null, "members", null, 0, -1, RecursiveClassDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(modifiersEClass, Modifiers.class, "Modifiers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModifiers_Final(), ecorePackage.getEBoolean(), "final", null, 0, 1, Modifiers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModifiers_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, Modifiers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModifiers_Extern(), ecorePackage.getEBoolean(), "extern", null, 0, 1, Modifiers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModifiers_Visibility(), this.getVisibility(), "visibility", null, 0, 1, Modifiers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unorderedEClass, Unordered.class, "Unordered", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnordered_Name(), ecorePackage.getEString(), "name", null, 0, 1, Unordered.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnordered_RootDeclaration(), this.getSimpleClassDeclaration(), null, "rootDeclaration", null, 0, 1, Unordered.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleClassDeclarationEClass, SimpleClassDeclaration.class, "SimpleClassDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSimpleClassDeclaration_Modifiers(), this.getUnorderedModifiers(), null, "modifiers", null, 0, 1, SimpleClassDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleClassDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, SimpleClassDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSimpleClassDeclaration_Members(), this.getClassMember(), null, "members", null, 0, -1, SimpleClassDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classMemberEClass, ClassMember.class, "ClassMember", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassMember_Modifiers(), this.getUnorderedModifiers(), null, "modifiers", null, 0, 1, ClassMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClassMember_Name(), ecorePackage.getEString(), "name", null, 0, 1, ClassMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unorderedModifiersEClass, UnorderedModifiers.class, "UnorderedModifiers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(visibilityEEnum, Visibility.class, "Visibility");
    addEEnumLiteral(visibilityEEnum, Visibility.PUBLIC);
    addEEnumLiteral(visibilityEEnum, Visibility.PROTECTED);
    addEEnumLiteral(visibilityEEnum, Visibility.PRIVATE);

    // Create resource
    createResource(eNS_URI);
  }

} //Bug360834TestLanguagePackageImpl
