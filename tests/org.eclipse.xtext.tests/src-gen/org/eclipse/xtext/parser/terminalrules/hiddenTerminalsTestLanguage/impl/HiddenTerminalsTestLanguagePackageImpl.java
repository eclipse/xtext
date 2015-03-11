/**
 */
package org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.DatatypeHiddens;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguageFactory;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HidingHiddens;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddens;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddensCall;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.Model;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddens;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddensCall;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.WithHiddens;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.WithoutHiddens;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HiddenTerminalsTestLanguagePackageImpl extends EPackageImpl implements HiddenTerminalsTestLanguagePackage
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
  private EClass withoutHiddensEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass withHiddensEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass overridingHiddensEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass overridingHiddensCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inheritingHiddensEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass datatypeHiddensEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass hidingHiddensEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inheritingHiddensCallEClass = null;

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
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private HiddenTerminalsTestLanguagePackageImpl()
  {
    super(eNS_URI, HiddenTerminalsTestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link HiddenTerminalsTestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static HiddenTerminalsTestLanguagePackage init()
  {
    if (isInited) return (HiddenTerminalsTestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(HiddenTerminalsTestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    HiddenTerminalsTestLanguagePackageImpl theHiddenTerminalsTestLanguagePackage = (HiddenTerminalsTestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof HiddenTerminalsTestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new HiddenTerminalsTestLanguagePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theHiddenTerminalsTestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theHiddenTerminalsTestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theHiddenTerminalsTestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(HiddenTerminalsTestLanguagePackage.eNS_URI, theHiddenTerminalsTestLanguagePackage);
    return theHiddenTerminalsTestLanguagePackage;
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
  public EAttribute getModel_Valid()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWithoutHiddens()
  {
    return withoutHiddensEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWithoutHiddens_Spaces()
  {
    return (EAttribute)withoutHiddensEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWithHiddens()
  {
    return withHiddensEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOverridingHiddens()
  {
    return overridingHiddensEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOverridingHiddens_Called()
  {
    return (EReference)overridingHiddensEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOverridingHiddensCall()
  {
    return overridingHiddensCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOverridingHiddensCall_Spaces()
  {
    return (EAttribute)overridingHiddensCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOverridingHiddensCall_Valid()
  {
    return (EAttribute)overridingHiddensCallEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInheritingHiddens()
  {
    return inheritingHiddensEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInheritingHiddens_Called()
  {
    return (EReference)inheritingHiddensEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInheritingHiddens_HidingCalled()
  {
    return (EReference)inheritingHiddensEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDatatypeHiddens()
  {
    return datatypeHiddensEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHidingHiddens()
  {
    return hidingHiddensEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHidingHiddens_Space()
  {
    return (EAttribute)hidingHiddensEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHidingHiddens_Called()
  {
    return (EReference)hidingHiddensEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInheritingHiddensCall()
  {
    return inheritingHiddensCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInheritingHiddensCall_Valid()
  {
    return (EAttribute)inheritingHiddensCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HiddenTerminalsTestLanguageFactory getHiddenTerminalsTestLanguageFactory()
  {
    return (HiddenTerminalsTestLanguageFactory)getEFactoryInstance();
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
    createEAttribute(modelEClass, MODEL__VALID);

    withoutHiddensEClass = createEClass(WITHOUT_HIDDENS);
    createEAttribute(withoutHiddensEClass, WITHOUT_HIDDENS__SPACES);

    withHiddensEClass = createEClass(WITH_HIDDENS);

    overridingHiddensEClass = createEClass(OVERRIDING_HIDDENS);
    createEReference(overridingHiddensEClass, OVERRIDING_HIDDENS__CALLED);

    overridingHiddensCallEClass = createEClass(OVERRIDING_HIDDENS_CALL);
    createEAttribute(overridingHiddensCallEClass, OVERRIDING_HIDDENS_CALL__SPACES);
    createEAttribute(overridingHiddensCallEClass, OVERRIDING_HIDDENS_CALL__VALID);

    inheritingHiddensEClass = createEClass(INHERITING_HIDDENS);
    createEReference(inheritingHiddensEClass, INHERITING_HIDDENS__CALLED);
    createEReference(inheritingHiddensEClass, INHERITING_HIDDENS__HIDING_CALLED);

    datatypeHiddensEClass = createEClass(DATATYPE_HIDDENS);

    hidingHiddensEClass = createEClass(HIDING_HIDDENS);
    createEAttribute(hidingHiddensEClass, HIDING_HIDDENS__SPACE);
    createEReference(hidingHiddensEClass, HIDING_HIDDENS__CALLED);

    inheritingHiddensCallEClass = createEClass(INHERITING_HIDDENS_CALL);
    createEAttribute(inheritingHiddensCallEClass, INHERITING_HIDDENS_CALL__VALID);
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
    withoutHiddensEClass.getESuperTypes().add(this.getModel());
    withHiddensEClass.getESuperTypes().add(this.getModel());
    overridingHiddensEClass.getESuperTypes().add(this.getModel());
    inheritingHiddensEClass.getESuperTypes().add(this.getModel());
    datatypeHiddensEClass.getESuperTypes().add(this.getModel());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModel_Valid(), theEcorePackage.getEBoolean(), "valid", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(withoutHiddensEClass, WithoutHiddens.class, "WithoutHiddens", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getWithoutHiddens_Spaces(), theEcorePackage.getEString(), "spaces", null, 0, -1, WithoutHiddens.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(withHiddensEClass, WithHiddens.class, "WithHiddens", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(overridingHiddensEClass, OverridingHiddens.class, "OverridingHiddens", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOverridingHiddens_Called(), this.getOverridingHiddensCall(), null, "called", null, 0, 1, OverridingHiddens.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(overridingHiddensCallEClass, OverridingHiddensCall.class, "OverridingHiddensCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOverridingHiddensCall_Spaces(), theEcorePackage.getEString(), "spaces", null, 0, -1, OverridingHiddensCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOverridingHiddensCall_Valid(), theEcorePackage.getEBoolean(), "valid", null, 0, 1, OverridingHiddensCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inheritingHiddensEClass, InheritingHiddens.class, "InheritingHiddens", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInheritingHiddens_Called(), this.getInheritingHiddensCall(), null, "called", null, 0, 1, InheritingHiddens.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInheritingHiddens_HidingCalled(), this.getHidingHiddens(), null, "hidingCalled", null, 0, 1, InheritingHiddens.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(datatypeHiddensEClass, DatatypeHiddens.class, "DatatypeHiddens", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(hidingHiddensEClass, HidingHiddens.class, "HidingHiddens", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getHidingHiddens_Space(), theEcorePackage.getEString(), "space", null, 0, 1, HidingHiddens.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getHidingHiddens_Called(), this.getInheritingHiddensCall(), null, "called", null, 0, 1, HidingHiddens.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inheritingHiddensCallEClass, InheritingHiddensCall.class, "InheritingHiddensCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInheritingHiddensCall_Valid(), theEcorePackage.getEBoolean(), "valid", null, 0, 1, InheritingHiddensCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //HiddenTerminalsTestLanguagePackageImpl
