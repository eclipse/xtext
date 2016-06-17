/**
 */
package org.eclipse.xtext.grammarinheritance.foo.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.grammarinheritance.ametamodel.AmetamodelPackage;

import org.eclipse.xtext.grammarinheritance.foo.AType2;
import org.eclipse.xtext.grammarinheritance.foo.CallExtendedParserRule;
import org.eclipse.xtext.grammarinheritance.foo.CallOverridenParserRule;
import org.eclipse.xtext.grammarinheritance.foo.ConcreteParserRule;
import org.eclipse.xtext.grammarinheritance.foo.FooFactory;
import org.eclipse.xtext.grammarinheritance.foo.FooPackage;
import org.eclipse.xtext.grammarinheritance.foo.RootRule;
import org.eclipse.xtext.grammarinheritance.foo.Subrule1;
import org.eclipse.xtext.grammarinheritance.foo.Subrule2;
import org.eclipse.xtext.grammarinheritance.foo.Subrule3;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FooPackageImpl extends EPackageImpl implements FooPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rootRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass concreteParserRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass callOverridenParserRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aType2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subrule1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subrule2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subrule3EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass callExtendedParserRuleEClass = null;

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
   * @see org.eclipse.xtext.grammarinheritance.foo.FooPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private FooPackageImpl()
  {
    super(eNS_URI, FooFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link FooPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static FooPackage init()
  {
    if (isInited) return (FooPackage)EPackage.Registry.INSTANCE.getEPackage(FooPackage.eNS_URI);

    // Obtain or create and register package
    FooPackageImpl theFooPackage = (FooPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FooPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FooPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();
    AmetamodelPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theFooPackage.createPackageContents();

    // Initialize created meta-data
    theFooPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theFooPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(FooPackage.eNS_URI, theFooPackage);
    return theFooPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRootRule()
  {
    return rootRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConcreteParserRule()
  {
    return concreteParserRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConcreteParserRule_MagicNumber()
  {
    return (EAttribute)concreteParserRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConcreteParserRule_Elements()
  {
    return (EReference)concreteParserRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCallOverridenParserRule()
  {
    return callOverridenParserRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCallOverridenParserRule_Call()
  {
    return (EReference)callOverridenParserRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAType2()
  {
    return aType2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAType2_Age()
  {
    return (EAttribute)aType2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubrule1()
  {
    return subrule1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSubrule1_Sub1()
  {
    return (EAttribute)subrule1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubrule2()
  {
    return subrule2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSubrule2_Sub2()
  {
    return (EAttribute)subrule2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubrule3()
  {
    return subrule3EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSubrule3_Sub1()
  {
    return (EAttribute)subrule3EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCallExtendedParserRule()
  {
    return callExtendedParserRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCallExtendedParserRule_Call()
  {
    return (EReference)callExtendedParserRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FooFactory getFooFactory()
  {
    return (FooFactory)getEFactoryInstance();
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
    rootRuleEClass = createEClass(ROOT_RULE);

    concreteParserRuleEClass = createEClass(CONCRETE_PARSER_RULE);
    createEAttribute(concreteParserRuleEClass, CONCRETE_PARSER_RULE__MAGIC_NUMBER);
    createEReference(concreteParserRuleEClass, CONCRETE_PARSER_RULE__ELEMENTS);

    callOverridenParserRuleEClass = createEClass(CALL_OVERRIDEN_PARSER_RULE);
    createEReference(callOverridenParserRuleEClass, CALL_OVERRIDEN_PARSER_RULE__CALL);

    aType2EClass = createEClass(ATYPE2);
    createEAttribute(aType2EClass, ATYPE2__AGE);

    subrule1EClass = createEClass(SUBRULE1);
    createEAttribute(subrule1EClass, SUBRULE1__SUB1);

    subrule2EClass = createEClass(SUBRULE2);
    createEAttribute(subrule2EClass, SUBRULE2__SUB2);

    subrule3EClass = createEClass(SUBRULE3);
    createEAttribute(subrule3EClass, SUBRULE3__SUB1);

    callExtendedParserRuleEClass = createEClass(CALL_EXTENDED_PARSER_RULE);
    createEReference(callExtendedParserRuleEClass, CALL_EXTENDED_PARSER_RULE__CALL);
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
    AmetamodelPackage theAmetamodelPackage = (AmetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(AmetamodelPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    concreteParserRuleEClass.getESuperTypes().add(this.getRootRule());
    callOverridenParserRuleEClass.getESuperTypes().add(this.getRootRule());
    aType2EClass.getESuperTypes().add(this.getRootRule());
    aType2EClass.getESuperTypes().add(theAmetamodelPackage.getAType());
    subrule1EClass.getESuperTypes().add(theAmetamodelPackage.getAType());
    subrule2EClass.getESuperTypes().add(theAmetamodelPackage.getAType());
    subrule3EClass.getESuperTypes().add(theAmetamodelPackage.getAType());
    callExtendedParserRuleEClass.getESuperTypes().add(this.getRootRule());

    // Initialize classes and features; add operations and parameters
    initEClass(rootRuleEClass, RootRule.class, "RootRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(concreteParserRuleEClass, ConcreteParserRule.class, "ConcreteParserRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getConcreteParserRule_MagicNumber(), theEcorePackage.getEDouble(), "magicNumber", null, 0, 1, ConcreteParserRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConcreteParserRule_Elements(), theAmetamodelPackage.getAType(), null, "elements", null, 0, -1, ConcreteParserRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(callOverridenParserRuleEClass, CallOverridenParserRule.class, "CallOverridenParserRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCallOverridenParserRule_Call(), theAmetamodelPackage.getAModel(), null, "call", null, 0, 1, CallOverridenParserRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aType2EClass, AType2.class, "AType2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAType2_Age(), theEcorePackage.getEInt(), "age", null, 0, 1, AType2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subrule1EClass, Subrule1.class, "Subrule1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSubrule1_Sub1(), theEcorePackage.getEString(), "sub1", null, 0, 1, Subrule1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subrule2EClass, Subrule2.class, "Subrule2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSubrule2_Sub2(), theEcorePackage.getEString(), "sub2", null, 0, 1, Subrule2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subrule3EClass, Subrule3.class, "Subrule3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSubrule3_Sub1(), theEcorePackage.getEInt(), "sub1", null, 0, 1, Subrule3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(callExtendedParserRuleEClass, CallExtendedParserRule.class, "CallExtendedParserRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCallExtendedParserRule_Call(), theAmetamodelPackage.getAModel(), null, "call", null, 0, 1, CallExtendedParserRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //FooPackageImpl
