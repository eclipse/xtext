/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Bug347012TestLanguageFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Bug347012TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Identifier;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Literal;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttribute;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttributes;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyBinding;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyClass;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyField;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyPrimary;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyProgram;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug347012TestLanguagePackageImpl extends EPackageImpl implements Bug347012TestLanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myProgramEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass identifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass literalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myPrimaryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myPackageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myAttributesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myFieldEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myBindingEClass = null;

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
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Bug347012TestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Bug347012TestLanguagePackageImpl()
  {
    super(eNS_URI, Bug347012TestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link Bug347012TestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Bug347012TestLanguagePackage init()
  {
    if (isInited) return (Bug347012TestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(Bug347012TestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    Bug347012TestLanguagePackageImpl theBug347012TestLanguagePackage = (Bug347012TestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Bug347012TestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Bug347012TestLanguagePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theBug347012TestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theBug347012TestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBug347012TestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Bug347012TestLanguagePackage.eNS_URI, theBug347012TestLanguagePackage);
    return theBug347012TestLanguagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMyProgram()
  {
    return myProgramEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMyProgram_Package()
  {
    return (EReference)myProgramEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIdentifier()
  {
    return identifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIdentifier_Name()
  {
    return (EAttribute)identifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLiteral()
  {
    return literalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLiteral_Num()
  {
    return (EAttribute)literalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLiteral_Str()
  {
    return (EAttribute)literalEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLiteral_Bool()
  {
    return (EAttribute)literalEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMyPrimary()
  {
    return myPrimaryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMyPackage()
  {
    return myPackageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMyPackage_Name()
  {
    return (EAttribute)myPackageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMyPackage_Directives()
  {
    return (EReference)myPackageEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMyClass()
  {
    return myClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMyClass_Name()
  {
    return (EAttribute)myClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMyClass_Directives()
  {
    return (EReference)myClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMyAttribute()
  {
    return myAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMyAttribute_PUBLIC()
  {
    return (EAttribute)myAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMyAttribute_PRIVATE()
  {
    return (EAttribute)myAttributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMyAttributes()
  {
    return myAttributesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMyAttributes_Attributes()
  {
    return (EReference)myAttributesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMyField()
  {
    return myFieldEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMyField_Attr()
  {
    return (EReference)myFieldEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMyField_Bindings()
  {
    return (EReference)myFieldEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMyBinding()
  {
    return myBindingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMyBinding_Name()
  {
    return (EAttribute)myBindingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMyBinding_Type()
  {
    return (EAttribute)myBindingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMyBinding_Expression()
  {
    return (EReference)myBindingEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug347012TestLanguageFactory getBug347012TestLanguageFactory()
  {
    return (Bug347012TestLanguageFactory)getEFactoryInstance();
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
    myProgramEClass = createEClass(MY_PROGRAM);
    createEReference(myProgramEClass, MY_PROGRAM__PACKAGE);

    identifierEClass = createEClass(IDENTIFIER);
    createEAttribute(identifierEClass, IDENTIFIER__NAME);

    literalEClass = createEClass(LITERAL);
    createEAttribute(literalEClass, LITERAL__NUM);
    createEAttribute(literalEClass, LITERAL__STR);
    createEAttribute(literalEClass, LITERAL__BOOL);

    myPrimaryEClass = createEClass(MY_PRIMARY);

    myPackageEClass = createEClass(MY_PACKAGE);
    createEAttribute(myPackageEClass, MY_PACKAGE__NAME);
    createEReference(myPackageEClass, MY_PACKAGE__DIRECTIVES);

    myClassEClass = createEClass(MY_CLASS);
    createEAttribute(myClassEClass, MY_CLASS__NAME);
    createEReference(myClassEClass, MY_CLASS__DIRECTIVES);

    myAttributeEClass = createEClass(MY_ATTRIBUTE);
    createEAttribute(myAttributeEClass, MY_ATTRIBUTE__PUBLIC);
    createEAttribute(myAttributeEClass, MY_ATTRIBUTE__PRIVATE);

    myAttributesEClass = createEClass(MY_ATTRIBUTES);
    createEReference(myAttributesEClass, MY_ATTRIBUTES__ATTRIBUTES);

    myFieldEClass = createEClass(MY_FIELD);
    createEReference(myFieldEClass, MY_FIELD__ATTR);
    createEReference(myFieldEClass, MY_FIELD__BINDINGS);

    myBindingEClass = createEClass(MY_BINDING);
    createEAttribute(myBindingEClass, MY_BINDING__NAME);
    createEAttribute(myBindingEClass, MY_BINDING__TYPE);
    createEReference(myBindingEClass, MY_BINDING__EXPRESSION);
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
    identifierEClass.getESuperTypes().add(this.getMyPrimary());
    literalEClass.getESuperTypes().add(this.getMyPrimary());

    // Initialize classes and features; add operations and parameters
    initEClass(myProgramEClass, MyProgram.class, "MyProgram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMyProgram_Package(), this.getMyPackage(), null, "package", null, 0, 1, MyProgram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(identifierEClass, Identifier.class, "Identifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIdentifier_Name(), ecorePackage.getEString(), "name", null, 0, 1, Identifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(literalEClass, Literal.class, "Literal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLiteral_Num(), ecorePackage.getEDouble(), "num", null, 0, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLiteral_Str(), ecorePackage.getEString(), "str", null, 0, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLiteral_Bool(), ecorePackage.getEString(), "bool", null, 0, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myPrimaryEClass, MyPrimary.class, "MyPrimary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(myPackageEClass, MyPackage.class, "MyPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMyPackage_Name(), ecorePackage.getEString(), "name", null, 0, 1, MyPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMyPackage_Directives(), this.getMyClass(), null, "directives", null, 0, -1, MyPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myClassEClass, MyClass.class, "MyClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMyClass_Name(), ecorePackage.getEString(), "name", null, 0, 1, MyClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMyClass_Directives(), this.getMyField(), null, "directives", null, 0, -1, MyClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myAttributeEClass, MyAttribute.class, "MyAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMyAttribute_PUBLIC(), ecorePackage.getEString(), "PUBLIC", null, 0, 1, MyAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMyAttribute_PRIVATE(), ecorePackage.getEString(), "PRIVATE", null, 0, 1, MyAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myAttributesEClass, MyAttributes.class, "MyAttributes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMyAttributes_Attributes(), this.getMyAttribute(), null, "attributes", null, 0, -1, MyAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myFieldEClass, MyField.class, "MyField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMyField_Attr(), this.getMyAttributes(), null, "attr", null, 0, 1, MyField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMyField_Bindings(), this.getMyBinding(), null, "bindings", null, 0, -1, MyField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myBindingEClass, MyBinding.class, "MyBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMyBinding_Name(), ecorePackage.getEString(), "name", null, 0, 1, MyBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMyBinding_Type(), ecorePackage.getEString(), "type", null, 0, 1, MyBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMyBinding_Expression(), this.getMyPrimary(), null, "expression", null, 0, 1, MyBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //Bug347012TestLanguagePackageImpl
