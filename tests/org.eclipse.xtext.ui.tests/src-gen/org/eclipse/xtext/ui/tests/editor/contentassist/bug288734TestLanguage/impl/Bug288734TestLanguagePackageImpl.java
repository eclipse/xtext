/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug288734TestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug288734TestLanguage.Bug288734TestLanguageFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug288734TestLanguage.Bug288734TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug288734TestLanguage.Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug288734TestLanguage.TAnnotation;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug288734TestLanguage.TBooleanConstant;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug288734TestLanguage.TConstant;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug288734TestLanguage.TIntegerConstant;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug288734TestLanguage.TStringConstant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug288734TestLanguagePackageImpl extends EPackageImpl implements Bug288734TestLanguagePackage
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
  private EClass tConstantEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tStringConstantEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tIntegerConstantEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tBooleanConstantEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tAnnotationEClass = null;

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
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug288734TestLanguage.Bug288734TestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Bug288734TestLanguagePackageImpl()
  {
    super(eNS_URI, Bug288734TestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link Bug288734TestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Bug288734TestLanguagePackage init()
  {
    if (isInited) return (Bug288734TestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(Bug288734TestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    Bug288734TestLanguagePackageImpl theBug288734TestLanguagePackage = (Bug288734TestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Bug288734TestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Bug288734TestLanguagePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theBug288734TestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theBug288734TestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBug288734TestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Bug288734TestLanguagePackage.eNS_URI, theBug288734TestLanguagePackage);
    return theBug288734TestLanguagePackage;
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
  public EReference getModel_Constants()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTConstant()
  {
    return tConstantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTConstant_Annotations()
  {
    return (EReference)tConstantEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTConstant_Name()
  {
    return (EAttribute)tConstantEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTStringConstant()
  {
    return tStringConstantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTIntegerConstant()
  {
    return tIntegerConstantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTBooleanConstant()
  {
    return tBooleanConstantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTAnnotation()
  {
    return tAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTAnnotation_Description()
  {
    return (EAttribute)tAnnotationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug288734TestLanguageFactory getBug288734TestLanguageFactory()
  {
    return (Bug288734TestLanguageFactory)getEFactoryInstance();
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
    createEReference(modelEClass, MODEL__CONSTANTS);

    tConstantEClass = createEClass(TCONSTANT);
    createEReference(tConstantEClass, TCONSTANT__ANNOTATIONS);
    createEAttribute(tConstantEClass, TCONSTANT__NAME);

    tStringConstantEClass = createEClass(TSTRING_CONSTANT);

    tIntegerConstantEClass = createEClass(TINTEGER_CONSTANT);

    tBooleanConstantEClass = createEClass(TBOOLEAN_CONSTANT);

    tAnnotationEClass = createEClass(TANNOTATION);
    createEAttribute(tAnnotationEClass, TANNOTATION__DESCRIPTION);
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
    tStringConstantEClass.getESuperTypes().add(this.getTConstant());
    tIntegerConstantEClass.getESuperTypes().add(this.getTConstant());
    tBooleanConstantEClass.getESuperTypes().add(this.getTConstant());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Constants(), this.getTConstant(), null, "constants", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tConstantEClass, TConstant.class, "TConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTConstant_Annotations(), this.getTAnnotation(), null, "annotations", null, 0, -1, TConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTConstant_Name(), ecorePackage.getEString(), "name", null, 0, 1, TConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tStringConstantEClass, TStringConstant.class, "TStringConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(tIntegerConstantEClass, TIntegerConstant.class, "TIntegerConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(tBooleanConstantEClass, TBooleanConstant.class, "TBooleanConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(tAnnotationEClass, TAnnotation.class, "TAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTAnnotation_Description(), ecorePackage.getEString(), "description", null, 0, 1, TAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //Bug288734TestLanguagePackageImpl
