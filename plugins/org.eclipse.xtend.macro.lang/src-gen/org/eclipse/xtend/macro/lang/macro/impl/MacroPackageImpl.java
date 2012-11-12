/**
 */
package org.eclipse.xtend.macro.lang.macro.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtend.core.xtend.XtendPackage;

import org.eclipse.xtend.macro.lang.macro.MacroAnnotation;
import org.eclipse.xtend.macro.lang.macro.MacroFactory;
import org.eclipse.xtend.macro.lang.macro.MacroPackage;
import org.eclipse.xtend.macro.lang.macro.Processor;
import org.eclipse.xtend.macro.lang.macro.Registrator;
import org.eclipse.xtend.macro.lang.macro.TargetType;

import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MacroPackageImpl extends EPackageImpl implements MacroPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass macroAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass registratorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass processorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum targetTypeEEnum = null;

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
   * @see org.eclipse.xtend.macro.lang.macro.MacroPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private MacroPackageImpl()
  {
    super(eNS_URI, MacroFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link MacroPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static MacroPackage init()
  {
    if (isInited) return (MacroPackage)EPackage.Registry.INSTANCE.getEPackage(MacroPackage.eNS_URI);

    // Obtain or create and register package
    MacroPackageImpl theMacroPackage = (MacroPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MacroPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MacroPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XtendPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theMacroPackage.createPackageContents();

    // Initialize created meta-data
    theMacroPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMacroPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(MacroPackage.eNS_URI, theMacroPackage);
    return theMacroPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMacroAnnotation()
  {
    return macroAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMacroAnnotation_TargetType()
  {
    return (EAttribute)macroAnnotationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMacroAnnotation_Members()
  {
    return (EReference)macroAnnotationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRegistrator()
  {
    return registratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRegistrator_Each()
  {
    return (EAttribute)registratorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRegistrator_VariableName()
  {
    return (EAttribute)registratorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRegistrator_Expression()
  {
    return (EReference)registratorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProcessor()
  {
    return processorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProcessor_Each()
  {
    return (EAttribute)processorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProcessor_VariableName()
  {
    return (EAttribute)processorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProcessor_Expression()
  {
    return (EReference)processorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getTargetType()
  {
    return targetTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MacroFactory getMacroFactory()
  {
    return (MacroFactory)getEFactoryInstance();
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
    macroAnnotationEClass = createEClass(MACRO_ANNOTATION);
    createEAttribute(macroAnnotationEClass, MACRO_ANNOTATION__TARGET_TYPE);
    createEReference(macroAnnotationEClass, MACRO_ANNOTATION__MEMBERS);

    registratorEClass = createEClass(REGISTRATOR);
    createEAttribute(registratorEClass, REGISTRATOR__EACH);
    createEAttribute(registratorEClass, REGISTRATOR__VARIABLE_NAME);
    createEReference(registratorEClass, REGISTRATOR__EXPRESSION);

    processorEClass = createEClass(PROCESSOR);
    createEAttribute(processorEClass, PROCESSOR__EACH);
    createEAttribute(processorEClass, PROCESSOR__VARIABLE_NAME);
    createEReference(processorEClass, PROCESSOR__EXPRESSION);

    // Create enums
    targetTypeEEnum = createEEnum(TARGET_TYPE);
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
    XtendPackage theXtendPackage = (XtendPackage)EPackage.Registry.INSTANCE.getEPackage(XtendPackage.eNS_URI);
    XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    macroAnnotationEClass.getESuperTypes().add(theXtendPackage.getXtendTypeDeclaration());
    registratorEClass.getESuperTypes().add(theXtendPackage.getXtendMember());
    processorEClass.getESuperTypes().add(theXtendPackage.getXtendMember());

    // Initialize classes and features; add operations and parameters
    initEClass(macroAnnotationEClass, MacroAnnotation.class, "MacroAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMacroAnnotation_TargetType(), this.getTargetType(), "targetType", null, 0, -1, MacroAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMacroAnnotation_Members(), theXtendPackage.getXtendMember(), null, "members", null, 0, -1, MacroAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(registratorEClass, Registrator.class, "Registrator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRegistrator_Each(), ecorePackage.getEBoolean(), "each", null, 0, 1, Registrator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRegistrator_VariableName(), ecorePackage.getEString(), "variableName", null, 0, 1, Registrator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRegistrator_Expression(), theXbasePackage.getXExpression(), null, "expression", null, 0, 1, Registrator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(processorEClass, Processor.class, "Processor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getProcessor_Each(), ecorePackage.getEBoolean(), "each", null, 0, 1, Processor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getProcessor_VariableName(), ecorePackage.getEString(), "variableName", null, 0, 1, Processor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProcessor_Expression(), theXbasePackage.getXExpression(), null, "expression", null, 0, 1, Processor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(targetTypeEEnum, TargetType.class, "TargetType");
    addEEnumLiteral(targetTypeEEnum, TargetType.CLASS);
    addEEnumLiteral(targetTypeEEnum, TargetType.FIELD);
    addEEnumLiteral(targetTypeEEnum, TargetType.METHOD);
    addEEnumLiteral(targetTypeEEnum, TargetType.PARAMETER);
    addEEnumLiteral(targetTypeEEnum, TargetType.CONSTRUCTOR);

    // Create resource
    createResource(eNS_URI);
  }

} //MacroPackageImpl
