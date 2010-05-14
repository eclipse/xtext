/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Assign;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Decl;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Enum1;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Enumeration;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguageFactory;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguagePackage;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FqnObj;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FqnRef;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Line;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Meth;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Param;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Root;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHidden;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSub;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSubID;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSubSub;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestIndentation;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FormattertestlanguagePackageImpl extends EPackageImpl implements FormattertestlanguagePackage
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
  private EClass lineEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass declEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass methEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass paramEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass testLinewrapEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass testIndentationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fqnObjEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fqnRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumerationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass suppressedHiddenEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass suppressedHiddenSubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass suppressedHiddenSubSubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass suppressedHiddenSubIDEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum enum1EEnum = null;

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
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private FormattertestlanguagePackageImpl()
  {
    super(eNS_URI, FormattertestlanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link FormattertestlanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static FormattertestlanguagePackage init()
  {
    if (isInited) return (FormattertestlanguagePackage)EPackage.Registry.INSTANCE.getEPackage(FormattertestlanguagePackage.eNS_URI);

    // Obtain or create and register package
    FormattertestlanguagePackageImpl theFormattertestlanguagePackage = (FormattertestlanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FormattertestlanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FormattertestlanguagePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theFormattertestlanguagePackage.createPackageContents();

    // Initialize created meta-data
    theFormattertestlanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theFormattertestlanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(FormattertestlanguagePackage.eNS_URI, theFormattertestlanguagePackage);
    return theFormattertestlanguagePackage;
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
  public EReference getRoot_Items()
  {
    return (EReference)rootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLine()
  {
    return lineEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDecl()
  {
    return declEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDecl_Type()
  {
    return (EAttribute)declEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDecl_Name()
  {
    return (EAttribute)declEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssign()
  {
    return assignEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssign_Var()
  {
    return (EAttribute)assignEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssign_Op()
  {
    return (EAttribute)assignEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssign_Val()
  {
    return (EAttribute)assignEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMeth()
  {
    return methEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMeth_Name()
  {
    return (EAttribute)methEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMeth_Param()
  {
    return (EReference)methEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParam()
  {
    return paramEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParam_Name()
  {
    return (EAttribute)paramEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParam_Type()
  {
    return (EAttribute)paramEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTestLinewrap()
  {
    return testLinewrapEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTestIndentation()
  {
    return testIndentationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestIndentation_Sub()
  {
    return (EReference)testIndentationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTestIndentation_Semi()
  {
    return (EAttribute)testIndentationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFqnObj()
  {
    return fqnObjEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFqnObj_Name()
  {
    return (EAttribute)fqnObjEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFqnRef()
  {
    return fqnRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFqnRef_Ref()
  {
    return (EReference)fqnRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumeration()
  {
    return enumerationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnumeration_Val()
  {
    return (EAttribute)enumerationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuppressedHidden()
  {
    return suppressedHiddenEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuppressedHidden_Vals()
  {
    return (EReference)suppressedHiddenEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuppressedHiddenSub()
  {
    return suppressedHiddenSubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSuppressedHiddenSub_Idval()
  {
    return (EAttribute)suppressedHiddenSubEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuppressedHiddenSubSub()
  {
    return suppressedHiddenSubSubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuppressedHiddenSubID()
  {
    return suppressedHiddenSubIDEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getEnum1()
  {
    return enum1EEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormattertestlanguageFactory getFormattertestlanguageFactory()
  {
    return (FormattertestlanguageFactory)getEFactoryInstance();
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
    createEReference(rootEClass, ROOT__ITEMS);

    lineEClass = createEClass(LINE);

    declEClass = createEClass(DECL);
    createEAttribute(declEClass, DECL__TYPE);
    createEAttribute(declEClass, DECL__NAME);

    assignEClass = createEClass(ASSIGN);
    createEAttribute(assignEClass, ASSIGN__VAR);
    createEAttribute(assignEClass, ASSIGN__OP);
    createEAttribute(assignEClass, ASSIGN__VAL);

    methEClass = createEClass(METH);
    createEAttribute(methEClass, METH__NAME);
    createEReference(methEClass, METH__PARAM);

    paramEClass = createEClass(PARAM);
    createEAttribute(paramEClass, PARAM__NAME);
    createEAttribute(paramEClass, PARAM__TYPE);

    testLinewrapEClass = createEClass(TEST_LINEWRAP);

    testIndentationEClass = createEClass(TEST_INDENTATION);
    createEReference(testIndentationEClass, TEST_INDENTATION__SUB);
    createEAttribute(testIndentationEClass, TEST_INDENTATION__SEMI);

    fqnObjEClass = createEClass(FQN_OBJ);
    createEAttribute(fqnObjEClass, FQN_OBJ__NAME);

    fqnRefEClass = createEClass(FQN_REF);
    createEReference(fqnRefEClass, FQN_REF__REF);

    enumerationEClass = createEClass(ENUMERATION);
    createEAttribute(enumerationEClass, ENUMERATION__VAL);

    suppressedHiddenEClass = createEClass(SUPPRESSED_HIDDEN);
    createEReference(suppressedHiddenEClass, SUPPRESSED_HIDDEN__VALS);

    suppressedHiddenSubEClass = createEClass(SUPPRESSED_HIDDEN_SUB);
    createEAttribute(suppressedHiddenSubEClass, SUPPRESSED_HIDDEN_SUB__IDVAL);

    suppressedHiddenSubSubEClass = createEClass(SUPPRESSED_HIDDEN_SUB_SUB);

    suppressedHiddenSubIDEClass = createEClass(SUPPRESSED_HIDDEN_SUB_ID);

    // Create enums
    enum1EEnum = createEEnum(ENUM1);
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
    declEClass.getESuperTypes().add(this.getLine());
    assignEClass.getESuperTypes().add(this.getLine());
    methEClass.getESuperTypes().add(this.getLine());
    testLinewrapEClass.getESuperTypes().add(this.getRoot());
    testIndentationEClass.getESuperTypes().add(this.getRoot());
    fqnObjEClass.getESuperTypes().add(this.getLine());
    fqnRefEClass.getESuperTypes().add(this.getLine());
    enumerationEClass.getESuperTypes().add(this.getLine());
    suppressedHiddenEClass.getESuperTypes().add(this.getLine());
    suppressedHiddenSubSubEClass.getESuperTypes().add(this.getSuppressedHiddenSub());
    suppressedHiddenSubIDEClass.getESuperTypes().add(this.getSuppressedHiddenSub());

    // Initialize classes and features; add operations and parameters
    initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRoot_Items(), this.getLine(), null, "items", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lineEClass, Line.class, "Line", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(declEClass, Decl.class, "Decl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDecl_Type(), ecorePackage.getEString(), "type", null, 0, -1, Decl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDecl_Name(), ecorePackage.getEString(), "name", null, 0, -1, Decl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assignEClass, Assign.class, "Assign", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssign_Var(), ecorePackage.getEString(), "var", null, 0, 1, Assign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssign_Op(), ecorePackage.getEString(), "op", null, 0, 1, Assign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssign_Val(), ecorePackage.getEInt(), "val", null, 0, -1, Assign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(methEClass, Meth.class, "Meth", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMeth_Name(), ecorePackage.getEString(), "name", null, 0, 1, Meth.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMeth_Param(), this.getParam(), null, "param", null, 0, -1, Meth.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(paramEClass, Param.class, "Param", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParam_Name(), ecorePackage.getEString(), "name", null, 0, -1, Param.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getParam_Type(), ecorePackage.getEString(), "type", null, 0, -1, Param.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(testLinewrapEClass, TestLinewrap.class, "TestLinewrap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(testIndentationEClass, TestIndentation.class, "TestIndentation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTestIndentation_Sub(), this.getTestIndentation(), null, "sub", null, 0, -1, TestIndentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTestIndentation_Semi(), ecorePackage.getEBoolean(), "semi", null, 0, 1, TestIndentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fqnObjEClass, FqnObj.class, "FqnObj", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFqnObj_Name(), ecorePackage.getEString(), "name", null, 0, 1, FqnObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fqnRefEClass, FqnRef.class, "FqnRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFqnRef_Ref(), this.getFqnObj(), null, "ref", null, 0, 1, FqnRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(enumerationEClass, Enumeration.class, "Enumeration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEnumeration_Val(), this.getEnum1(), "val", null, 0, -1, Enumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(suppressedHiddenEClass, SuppressedHidden.class, "SuppressedHidden", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSuppressedHidden_Vals(), this.getSuppressedHiddenSub(), null, "vals", null, 0, -1, SuppressedHidden.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(suppressedHiddenSubEClass, SuppressedHiddenSub.class, "SuppressedHiddenSub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSuppressedHiddenSub_Idval(), ecorePackage.getEString(), "idval", null, 0, 1, SuppressedHiddenSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(suppressedHiddenSubSubEClass, SuppressedHiddenSubSub.class, "SuppressedHiddenSubSub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(suppressedHiddenSubIDEClass, SuppressedHiddenSubID.class, "SuppressedHiddenSubID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(enum1EEnum, Enum1.class, "Enum1");
    addEEnumLiteral(enum1EEnum, Enum1.LIT1);
    addEEnumLiteral(enum1EEnum, Enum1.LIT2);
    addEEnumLiteral(enum1EEnum, Enum1.LIT3);

    // Create resource
    createResource(eNS_URI);
  }

} //FormattertestlanguagePackageImpl
