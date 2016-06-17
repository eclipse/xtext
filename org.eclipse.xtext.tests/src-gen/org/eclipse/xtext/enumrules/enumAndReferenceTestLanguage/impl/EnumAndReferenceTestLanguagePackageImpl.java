/**
 */
package org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference;
import org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EnumAndReferenceTestLanguageFactory;
import org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EnumAndReferenceTestLanguagePackage;
import org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.KindOfKeyword;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnumAndReferenceTestLanguagePackageImpl extends EPackageImpl implements EnumAndReferenceTestLanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass entityWithEnumAndReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum kindOfKeywordEEnum = null;

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
   * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EnumAndReferenceTestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private EnumAndReferenceTestLanguagePackageImpl()
  {
    super(eNS_URI, EnumAndReferenceTestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link EnumAndReferenceTestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static EnumAndReferenceTestLanguagePackage init()
  {
    if (isInited) return (EnumAndReferenceTestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(EnumAndReferenceTestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    EnumAndReferenceTestLanguagePackageImpl theEnumAndReferenceTestLanguagePackage = (EnumAndReferenceTestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EnumAndReferenceTestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EnumAndReferenceTestLanguagePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theEnumAndReferenceTestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theEnumAndReferenceTestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theEnumAndReferenceTestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(EnumAndReferenceTestLanguagePackage.eNS_URI, theEnumAndReferenceTestLanguagePackage);
    return theEnumAndReferenceTestLanguagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEntityWithEnumAndReference()
  {
    return entityWithEnumAndReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEntityWithEnumAndReference_Type()
  {
    return (EAttribute)entityWithEnumAndReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEntityWithEnumAndReference_Name()
  {
    return (EAttribute)entityWithEnumAndReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntityWithEnumAndReference_Ref()
  {
    return (EReference)entityWithEnumAndReferenceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getKindOfKeyword()
  {
    return kindOfKeywordEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumAndReferenceTestLanguageFactory getEnumAndReferenceTestLanguageFactory()
  {
    return (EnumAndReferenceTestLanguageFactory)getEFactoryInstance();
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
    entityWithEnumAndReferenceEClass = createEClass(ENTITY_WITH_ENUM_AND_REFERENCE);
    createEAttribute(entityWithEnumAndReferenceEClass, ENTITY_WITH_ENUM_AND_REFERENCE__TYPE);
    createEAttribute(entityWithEnumAndReferenceEClass, ENTITY_WITH_ENUM_AND_REFERENCE__NAME);
    createEReference(entityWithEnumAndReferenceEClass, ENTITY_WITH_ENUM_AND_REFERENCE__REF);

    // Create enums
    kindOfKeywordEEnum = createEEnum(KIND_OF_KEYWORD);
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
    initEClass(entityWithEnumAndReferenceEClass, EntityWithEnumAndReference.class, "EntityWithEnumAndReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEntityWithEnumAndReference_Type(), this.getKindOfKeyword(), "type", null, 0, 1, EntityWithEnumAndReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEntityWithEnumAndReference_Name(), theEcorePackage.getEString(), "name", null, 0, 1, EntityWithEnumAndReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEntityWithEnumAndReference_Ref(), this.getEntityWithEnumAndReference(), null, "ref", null, 0, 1, EntityWithEnumAndReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(kindOfKeywordEEnum, KindOfKeyword.class, "KindOfKeyword");
    addEEnumLiteral(kindOfKeywordEEnum, KindOfKeyword.KIND_OF_KEYWORD);
    addEEnumLiteral(kindOfKeywordEEnum, KindOfKeyword.ANOTHER_ENUM_LITERAL);

    // Create resource
    createResource(eNS_URI);
  }

} //EnumAndReferenceTestLanguagePackageImpl
