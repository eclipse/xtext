/**
 */
package org.eclipse.xtext.enumrules.enumRulesTestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.enumrules.enumRulesTestLanguage.EnumRulesTestLanguageFactory;
import org.eclipse.xtext.enumrules.enumRulesTestLanguage.EnumRulesTestLanguagePackage;
import org.eclipse.xtext.enumrules.enumRulesTestLanguage.GeneratedEnum;
import org.eclipse.xtext.enumrules.enumRulesTestLanguage.Model;

import org.eclipse.xtext.enumrules.enums.EnumsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnumRulesTestLanguagePackageImpl extends EPackageImpl implements EnumRulesTestLanguagePackage
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
  private EEnum generatedEnumEEnum = null;

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
   * @see org.eclipse.xtext.enumrules.enumRulesTestLanguage.EnumRulesTestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private EnumRulesTestLanguagePackageImpl()
  {
    super(eNS_URI, EnumRulesTestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link EnumRulesTestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static EnumRulesTestLanguagePackage init()
  {
    if (isInited) return (EnumRulesTestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(EnumRulesTestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    EnumRulesTestLanguagePackageImpl theEnumRulesTestLanguagePackage = (EnumRulesTestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EnumRulesTestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EnumRulesTestLanguagePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EnumsPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theEnumRulesTestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theEnumRulesTestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theEnumRulesTestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(EnumRulesTestLanguagePackage.eNS_URI, theEnumRulesTestLanguagePackage);
    return theEnumRulesTestLanguagePackage;
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
  public EAttribute getModel_Existing()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModel_Generated()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getGeneratedEnum()
  {
    return generatedEnumEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumRulesTestLanguageFactory getEnumRulesTestLanguageFactory()
  {
    return (EnumRulesTestLanguageFactory)getEFactoryInstance();
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
    createEAttribute(modelEClass, MODEL__EXISTING);
    createEAttribute(modelEClass, MODEL__GENERATED);

    // Create enums
    generatedEnumEEnum = createEEnum(GENERATED_ENUM);
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
    EnumsPackage theEnumsPackage = (EnumsPackage)EPackage.Registry.INSTANCE.getEPackage(EnumsPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModel_Existing(), theEnumsPackage.getExistingEnum(), "existing", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModel_Generated(), this.getGeneratedEnum(), "generated", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(generatedEnumEEnum, GeneratedEnum.class, "GeneratedEnum");
    addEEnumLiteral(generatedEnumEEnum, GeneratedEnum.SAME_NAME);
    addEEnumLiteral(generatedEnumEEnum, GeneratedEnum.DIFFERENT_NAME);

    // Create resource
    createResource(eNS_URI);
  }

} //EnumRulesTestLanguagePackageImpl
