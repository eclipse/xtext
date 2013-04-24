/**
 */
package org.eclipse.xtext.parser.antlr.bug378967Test.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.parser.antlr.bug378967Test.AfterObj;
import org.eclipse.xtext.parser.antlr.bug378967Test.Bug378967TestFactory;
import org.eclipse.xtext.parser.antlr.bug378967Test.Bug378967TestPackage;
import org.eclipse.xtext.parser.antlr.bug378967Test.FirstEnum;
import org.eclipse.xtext.parser.antlr.bug378967Test.Root;
import org.eclipse.xtext.parser.antlr.bug378967Test.Rule1;
import org.eclipse.xtext.parser.antlr.bug378967Test.Rule2;
import org.eclipse.xtext.parser.antlr.bug378967Test.Rule3;
import org.eclipse.xtext.parser.antlr.bug378967Test.Rule4;
import org.eclipse.xtext.parser.antlr.bug378967Test.SObj;
import org.eclipse.xtext.parser.antlr.bug378967Test.SecondEnum;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug378967TestPackageImpl extends EPackageImpl implements Bug378967TestPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rule1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rule2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rule3EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rule4EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass afterObjEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sObjEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum firstEnumEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum secondEnumEEnum = null;

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
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Bug378967TestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Bug378967TestPackageImpl()
  {
    super(eNS_URI, Bug378967TestFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link Bug378967TestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Bug378967TestPackage init()
  {
    if (isInited) return (Bug378967TestPackage)EPackage.Registry.INSTANCE.getEPackage(Bug378967TestPackage.eNS_URI);

    // Obtain or create and register package
    Bug378967TestPackageImpl theBug378967TestPackage = (Bug378967TestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Bug378967TestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Bug378967TestPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theBug378967TestPackage.createPackageContents();

    // Initialize created meta-data
    theBug378967TestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBug378967TestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Bug378967TestPackage.eNS_URI, theBug378967TestPackage);
    return theBug378967TestPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoot()
  {
    return rootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoot_Element()
  {
    return (EReference)rootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRule1()
  {
    return rule1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRule1_Type()
  {
    return (EAttribute)rule1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRule1_Value()
  {
    return (EAttribute)rule1EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRule1_Unit()
  {
    return (EAttribute)rule1EClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRule2()
  {
    return rule2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRule2_Value()
  {
    return (EAttribute)rule2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRule3()
  {
    return rule3EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRule3_Value()
  {
    return (EAttribute)rule3EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRule4()
  {
    return rule4EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRule4_After()
  {
    return (EReference)rule4EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRule4_Value()
  {
    return (EAttribute)rule4EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRule4_S()
  {
    return (EReference)rule4EClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAfterObj()
  {
    return afterObjEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAfterObj_Value()
  {
    return (EAttribute)afterObjEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSObj()
  {
    return sObjEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSObj_Value()
  {
    return (EAttribute)sObjEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getFirstEnum()
  {
    return firstEnumEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getSecondEnum()
  {
    return secondEnumEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug378967TestFactory getBug378967TestFactory()
  {
    return (Bug378967TestFactory)getEFactoryInstance();
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
    rootEClass = createEClass(ROOT);
    createEReference(rootEClass, ROOT__ELEMENT);

    rule1EClass = createEClass(RULE1);
    createEAttribute(rule1EClass, RULE1__TYPE);
    createEAttribute(rule1EClass, RULE1__VALUE);
    createEAttribute(rule1EClass, RULE1__UNIT);

    rule2EClass = createEClass(RULE2);
    createEAttribute(rule2EClass, RULE2__VALUE);

    rule3EClass = createEClass(RULE3);
    createEAttribute(rule3EClass, RULE3__VALUE);

    rule4EClass = createEClass(RULE4);
    createEReference(rule4EClass, RULE4__AFTER);
    createEAttribute(rule4EClass, RULE4__VALUE);
    createEReference(rule4EClass, RULE4__S);

    afterObjEClass = createEClass(AFTER_OBJ);
    createEAttribute(afterObjEClass, AFTER_OBJ__VALUE);

    sObjEClass = createEClass(SOBJ);
    createEAttribute(sObjEClass, SOBJ__VALUE);

    // Create enums
    firstEnumEEnum = createEEnum(FIRST_ENUM);
    secondEnumEEnum = createEEnum(SECOND_ENUM);
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
    initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRoot_Element(), theEcorePackage.getEObject(), null, "element", null, 0, 1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rule1EClass, Rule1.class, "Rule1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRule1_Type(), this.getFirstEnum(), "type", null, 0, 1, Rule1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRule1_Value(), theEcorePackage.getEInt(), "value", null, 0, 1, Rule1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRule1_Unit(), this.getSecondEnum(), "unit", null, 0, 1, Rule1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rule2EClass, Rule2.class, "Rule2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRule2_Value(), theEcorePackage.getEInt(), "value", null, 0, 1, Rule2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rule3EClass, Rule3.class, "Rule3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRule3_Value(), theEcorePackage.getEInt(), "value", null, 0, 1, Rule3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rule4EClass, Rule4.class, "Rule4", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRule4_After(), this.getAfterObj(), null, "after", null, 0, 1, Rule4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRule4_Value(), theEcorePackage.getEInt(), "value", null, 0, 1, Rule4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRule4_S(), this.getSObj(), null, "s", null, 0, 1, Rule4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(afterObjEClass, AfterObj.class, "AfterObj", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAfterObj_Value(), theEcorePackage.getEString(), "value", null, 0, 1, AfterObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sObjEClass, SObj.class, "SObj", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSObj_Value(), theEcorePackage.getEString(), "value", null, 0, 1, SObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(firstEnumEEnum, FirstEnum.class, "FirstEnum");
    addEEnumLiteral(firstEnumEEnum, FirstEnum.VALUE);

    initEEnum(secondEnumEEnum, SecondEnum.class, "SecondEnum");
    addEEnumLiteral(secondEnumEEnum, SecondEnum.VALUE);

    // Create resource
    createResource(eNS_URI);
  }

} //Bug378967TestPackageImpl
