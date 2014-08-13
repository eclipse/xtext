/**
 */
package org.eclipse.xtext.resource.bug385636.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.resource.bug385636.Bug385636Factory;
import org.eclipse.xtext.resource.bug385636.Bug385636Package;
import org.eclipse.xtext.resource.bug385636.DefineVariable;
import org.eclipse.xtext.resource.bug385636.DefineVariables;
import org.eclipse.xtext.resource.bug385636.Expression;
import org.eclipse.xtext.resource.bug385636.Expression_Equal;
import org.eclipse.xtext.resource.bug385636.Expression_Larger_Equal;
import org.eclipse.xtext.resource.bug385636.Expression_Not_Equal;
import org.eclipse.xtext.resource.bug385636.Expression_Not_Greater;
import org.eclipse.xtext.resource.bug385636.Expression_Not_Less;
import org.eclipse.xtext.resource.bug385636.Expression_Smaller;
import org.eclipse.xtext.resource.bug385636.Expression_Smaller_Equal;
import org.eclipse.xtext.resource.bug385636.Expression_VariableName;
import org.eclipse.xtext.resource.bug385636.NVariableAccess;
import org.eclipse.xtext.resource.bug385636.Program;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug385636PackageImpl extends EPackageImpl implements Bug385636Package
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass programEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass defineVariablesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass defineVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nVariableAccessEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expression_VariableNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expression_Larger_EqualEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expression_SmallerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expression_Smaller_EqualEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expression_EqualEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expression_Not_EqualEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expression_Not_LessEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expression_Not_GreaterEClass = null;

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
   * @see org.eclipse.xtext.resource.bug385636.Bug385636Package#eNS_URI
   * @see #init()
   * @generated
   */
  private Bug385636PackageImpl()
  {
    super(eNS_URI, Bug385636Factory.eINSTANCE);
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
   * <p>This method is used to initialize {@link Bug385636Package#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Bug385636Package init()
  {
    if (isInited) return (Bug385636Package)EPackage.Registry.INSTANCE.getEPackage(Bug385636Package.eNS_URI);

    // Obtain or create and register package
    Bug385636PackageImpl theBug385636Package = (Bug385636PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Bug385636PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Bug385636PackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theBug385636Package.createPackageContents();

    // Initialize created meta-data
    theBug385636Package.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBug385636Package.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Bug385636Package.eNS_URI, theBug385636Package);
    return theBug385636Package;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProgram()
  {
    return programEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProgram_Define()
  {
    return (EReference)programEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProgram_Statements()
  {
    return (EReference)programEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefineVariables()
  {
    return defineVariablesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDefineVariables_Variables()
  {
    return (EReference)defineVariablesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefineVariable()
  {
    return defineVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDefineVariable_Name()
  {
    return (EAttribute)defineVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNVariableAccess()
  {
    return nVariableAccessEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNVariableAccess_Variable()
  {
    return (EReference)nVariableAccessEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression_VariableName()
  {
    return expression_VariableNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_VariableName_Variable()
  {
    return (EReference)expression_VariableNameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression_Larger_Equal()
  {
    return expression_Larger_EqualEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Larger_Equal_Left()
  {
    return (EReference)expression_Larger_EqualEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Larger_Equal_Right()
  {
    return (EReference)expression_Larger_EqualEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression_Smaller()
  {
    return expression_SmallerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Smaller_Left()
  {
    return (EReference)expression_SmallerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Smaller_Right()
  {
    return (EReference)expression_SmallerEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression_Smaller_Equal()
  {
    return expression_Smaller_EqualEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Smaller_Equal_Left()
  {
    return (EReference)expression_Smaller_EqualEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Smaller_Equal_Right()
  {
    return (EReference)expression_Smaller_EqualEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression_Equal()
  {
    return expression_EqualEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Equal_Left()
  {
    return (EReference)expression_EqualEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Equal_Right()
  {
    return (EReference)expression_EqualEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression_Not_Equal()
  {
    return expression_Not_EqualEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Not_Equal_Left()
  {
    return (EReference)expression_Not_EqualEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Not_Equal_Right()
  {
    return (EReference)expression_Not_EqualEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression_Not_Less()
  {
    return expression_Not_LessEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Not_Less_Left()
  {
    return (EReference)expression_Not_LessEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Not_Less_Right()
  {
    return (EReference)expression_Not_LessEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression_Not_Greater()
  {
    return expression_Not_GreaterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Not_Greater_Left()
  {
    return (EReference)expression_Not_GreaterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Not_Greater_Right()
  {
    return (EReference)expression_Not_GreaterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug385636Factory getBug385636Factory()
  {
    return (Bug385636Factory)getEFactoryInstance();
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
    programEClass = createEClass(PROGRAM);
    createEReference(programEClass, PROGRAM__DEFINE);
    createEReference(programEClass, PROGRAM__STATEMENTS);

    defineVariablesEClass = createEClass(DEFINE_VARIABLES);
    createEReference(defineVariablesEClass, DEFINE_VARIABLES__VARIABLES);

    defineVariableEClass = createEClass(DEFINE_VARIABLE);
    createEAttribute(defineVariableEClass, DEFINE_VARIABLE__NAME);

    nVariableAccessEClass = createEClass(NVARIABLE_ACCESS);
    createEReference(nVariableAccessEClass, NVARIABLE_ACCESS__VARIABLE);

    expressionEClass = createEClass(EXPRESSION);

    expression_VariableNameEClass = createEClass(EXPRESSION_VARIABLE_NAME);
    createEReference(expression_VariableNameEClass, EXPRESSION_VARIABLE_NAME__VARIABLE);

    expression_Larger_EqualEClass = createEClass(EXPRESSION_LARGER_EQUAL);
    createEReference(expression_Larger_EqualEClass, EXPRESSION_LARGER_EQUAL__LEFT);
    createEReference(expression_Larger_EqualEClass, EXPRESSION_LARGER_EQUAL__RIGHT);

    expression_SmallerEClass = createEClass(EXPRESSION_SMALLER);
    createEReference(expression_SmallerEClass, EXPRESSION_SMALLER__LEFT);
    createEReference(expression_SmallerEClass, EXPRESSION_SMALLER__RIGHT);

    expression_Smaller_EqualEClass = createEClass(EXPRESSION_SMALLER_EQUAL);
    createEReference(expression_Smaller_EqualEClass, EXPRESSION_SMALLER_EQUAL__LEFT);
    createEReference(expression_Smaller_EqualEClass, EXPRESSION_SMALLER_EQUAL__RIGHT);

    expression_EqualEClass = createEClass(EXPRESSION_EQUAL);
    createEReference(expression_EqualEClass, EXPRESSION_EQUAL__LEFT);
    createEReference(expression_EqualEClass, EXPRESSION_EQUAL__RIGHT);

    expression_Not_EqualEClass = createEClass(EXPRESSION_NOT_EQUAL);
    createEReference(expression_Not_EqualEClass, EXPRESSION_NOT_EQUAL__LEFT);
    createEReference(expression_Not_EqualEClass, EXPRESSION_NOT_EQUAL__RIGHT);

    expression_Not_LessEClass = createEClass(EXPRESSION_NOT_LESS);
    createEReference(expression_Not_LessEClass, EXPRESSION_NOT_LESS__LEFT);
    createEReference(expression_Not_LessEClass, EXPRESSION_NOT_LESS__RIGHT);

    expression_Not_GreaterEClass = createEClass(EXPRESSION_NOT_GREATER);
    createEReference(expression_Not_GreaterEClass, EXPRESSION_NOT_GREATER__LEFT);
    createEReference(expression_Not_GreaterEClass, EXPRESSION_NOT_GREATER__RIGHT);
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
    expression_VariableNameEClass.getESuperTypes().add(this.getExpression());
    expression_Larger_EqualEClass.getESuperTypes().add(this.getExpression());
    expression_SmallerEClass.getESuperTypes().add(this.getExpression());
    expression_Smaller_EqualEClass.getESuperTypes().add(this.getExpression());
    expression_EqualEClass.getESuperTypes().add(this.getExpression());
    expression_Not_EqualEClass.getESuperTypes().add(this.getExpression());
    expression_Not_LessEClass.getESuperTypes().add(this.getExpression());
    expression_Not_GreaterEClass.getESuperTypes().add(this.getExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(programEClass, Program.class, "Program", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProgram_Define(), this.getDefineVariables(), null, "define", null, 0, 1, Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProgram_Statements(), this.getExpression(), null, "statements", null, 0, -1, Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(defineVariablesEClass, DefineVariables.class, "DefineVariables", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDefineVariables_Variables(), this.getDefineVariable(), null, "variables", null, 0, -1, DefineVariables.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(defineVariableEClass, DefineVariable.class, "DefineVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDefineVariable_Name(), theEcorePackage.getEString(), "name", null, 0, 1, DefineVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nVariableAccessEClass, NVariableAccess.class, "NVariableAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNVariableAccess_Variable(), this.getDefineVariable(), null, "variable", null, 0, 1, NVariableAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(expression_VariableNameEClass, Expression_VariableName.class, "Expression_VariableName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpression_VariableName_Variable(), this.getNVariableAccess(), null, "variable", null, 0, 1, Expression_VariableName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expression_Larger_EqualEClass, Expression_Larger_Equal.class, "Expression_Larger_Equal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpression_Larger_Equal_Left(), this.getExpression(), null, "left", null, 0, 1, Expression_Larger_Equal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpression_Larger_Equal_Right(), this.getExpression_VariableName(), null, "right", null, 0, 1, Expression_Larger_Equal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expression_SmallerEClass, Expression_Smaller.class, "Expression_Smaller", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpression_Smaller_Left(), this.getExpression(), null, "left", null, 0, 1, Expression_Smaller.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpression_Smaller_Right(), this.getExpression_VariableName(), null, "right", null, 0, 1, Expression_Smaller.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expression_Smaller_EqualEClass, Expression_Smaller_Equal.class, "Expression_Smaller_Equal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpression_Smaller_Equal_Left(), this.getExpression(), null, "left", null, 0, 1, Expression_Smaller_Equal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpression_Smaller_Equal_Right(), this.getExpression_VariableName(), null, "right", null, 0, 1, Expression_Smaller_Equal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expression_EqualEClass, Expression_Equal.class, "Expression_Equal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpression_Equal_Left(), this.getExpression(), null, "left", null, 0, 1, Expression_Equal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpression_Equal_Right(), this.getExpression_VariableName(), null, "right", null, 0, 1, Expression_Equal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expression_Not_EqualEClass, Expression_Not_Equal.class, "Expression_Not_Equal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpression_Not_Equal_Left(), this.getExpression(), null, "left", null, 0, 1, Expression_Not_Equal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpression_Not_Equal_Right(), this.getExpression_VariableName(), null, "right", null, 0, 1, Expression_Not_Equal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expression_Not_LessEClass, Expression_Not_Less.class, "Expression_Not_Less", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpression_Not_Less_Left(), this.getExpression(), null, "left", null, 0, 1, Expression_Not_Less.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpression_Not_Less_Right(), this.getExpression_VariableName(), null, "right", null, 0, 1, Expression_Not_Less.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expression_Not_GreaterEClass, Expression_Not_Greater.class, "Expression_Not_Greater", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpression_Not_Greater_Left(), this.getExpression(), null, "left", null, 0, 1, Expression_Not_Greater.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpression_Not_Greater_Right(), this.getExpression_VariableName(), null, "right", null, 0, 1, Expression_Not_Greater.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //Bug385636PackageImpl
