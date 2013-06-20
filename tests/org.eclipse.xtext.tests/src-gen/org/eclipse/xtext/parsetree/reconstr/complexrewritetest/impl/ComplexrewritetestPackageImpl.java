/**
 */
package org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Add;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Atom;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestFactory;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Expression;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Minus;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Root;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyB;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyC;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyD;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyE;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyF;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG1;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComplexrewritetestPackageImpl extends EPackageImpl implements ComplexrewritetestPackage
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
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass atomEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trickyBEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trickyCEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trickyDEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trickyEEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trickyFEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trickyGEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trickyG1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trickyG2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass addEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass minusEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass c1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass c2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass c3EClass = null;

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
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ComplexrewritetestPackageImpl()
  {
    super(eNS_URI, ComplexrewritetestFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ComplexrewritetestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ComplexrewritetestPackage init()
  {
    if (isInited) return (ComplexrewritetestPackage)EPackage.Registry.INSTANCE.getEPackage(ComplexrewritetestPackage.eNS_URI);

    // Obtain or create and register package
    ComplexrewritetestPackageImpl theComplexrewritetestPackage = (ComplexrewritetestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ComplexrewritetestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ComplexrewritetestPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theComplexrewritetestPackage.createPackageContents();

    // Initialize created meta-data
    theComplexrewritetestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theComplexrewritetestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ComplexrewritetestPackage.eNS_URI, theComplexrewritetestPackage);
    return theComplexrewritetestPackage;
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
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExpression_Em()
  {
    return (EAttribute)expressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAtom()
  {
    return atomEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAtom_Name()
  {
    return (EAttribute)atomEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrickyB()
  {
    return trickyBEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTrickyB_Name()
  {
    return (EAttribute)trickyBEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTrickyB_Type()
  {
    return (EAttribute)trickyBEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrickyC()
  {
    return trickyCEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTrickyC_Name()
  {
    return (EAttribute)trickyCEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrickyD()
  {
    return trickyDEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTrickyD_Name()
  {
    return (EAttribute)trickyDEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTrickyD_Foo()
  {
    return (EAttribute)trickyDEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTrickyD_Type()
  {
    return (EAttribute)trickyDEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrickyE()
  {
    return trickyEEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTrickyE_Name()
  {
    return (EAttribute)trickyEEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTrickyE_Foo()
  {
    return (EAttribute)trickyEEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTrickyE_Type()
  {
    return (EAttribute)trickyEEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrickyF()
  {
    return trickyFEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTrickyF_Name()
  {
    return (EAttribute)trickyFEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTrickyF_Type()
  {
    return (EAttribute)trickyFEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrickyG()
  {
    return trickyGEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTrickyG_Tree()
  {
    return (EReference)trickyGEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrickyG1()
  {
    return trickyG1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTrickyG1_Vals()
  {
    return (EReference)trickyG1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrickyG2()
  {
    return trickyG2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTrickyG2_Val()
  {
    return (EAttribute)trickyG2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAdd()
  {
    return addEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdd_AddOperands()
  {
    return (EReference)addEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMinus()
  {
    return minusEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMinus_MinusOperands()
  {
    return (EReference)minusEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getC1()
  {
    return c1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getC1_X()
  {
    return (EReference)c1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getC2()
  {
    return c2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getC2_Y()
  {
    return (EReference)c2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getC3()
  {
    return c3EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getC3_Z()
  {
    return (EReference)c3EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComplexrewritetestFactory getComplexrewritetestFactory()
  {
    return (ComplexrewritetestFactory)getEFactoryInstance();
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

    expressionEClass = createEClass(EXPRESSION);
    createEAttribute(expressionEClass, EXPRESSION__EM);

    atomEClass = createEClass(ATOM);
    createEAttribute(atomEClass, ATOM__NAME);

    trickyBEClass = createEClass(TRICKY_B);
    createEAttribute(trickyBEClass, TRICKY_B__NAME);
    createEAttribute(trickyBEClass, TRICKY_B__TYPE);

    trickyCEClass = createEClass(TRICKY_C);
    createEAttribute(trickyCEClass, TRICKY_C__NAME);

    trickyDEClass = createEClass(TRICKY_D);
    createEAttribute(trickyDEClass, TRICKY_D__NAME);
    createEAttribute(trickyDEClass, TRICKY_D__FOO);
    createEAttribute(trickyDEClass, TRICKY_D__TYPE);

    trickyEEClass = createEClass(TRICKY_E);
    createEAttribute(trickyEEClass, TRICKY_E__NAME);
    createEAttribute(trickyEEClass, TRICKY_E__FOO);
    createEAttribute(trickyEEClass, TRICKY_E__TYPE);

    trickyFEClass = createEClass(TRICKY_F);
    createEAttribute(trickyFEClass, TRICKY_F__NAME);
    createEAttribute(trickyFEClass, TRICKY_F__TYPE);

    trickyGEClass = createEClass(TRICKY_G);
    createEReference(trickyGEClass, TRICKY_G__TREE);

    trickyG1EClass = createEClass(TRICKY_G1);
    createEReference(trickyG1EClass, TRICKY_G1__VALS);

    trickyG2EClass = createEClass(TRICKY_G2);
    createEAttribute(trickyG2EClass, TRICKY_G2__VAL);

    addEClass = createEClass(ADD);
    createEReference(addEClass, ADD__ADD_OPERANDS);

    minusEClass = createEClass(MINUS);
    createEReference(minusEClass, MINUS__MINUS_OPERANDS);

    c1EClass = createEClass(C1);
    createEReference(c1EClass, C1__X);

    c2EClass = createEClass(C2);
    createEReference(c2EClass, C2__Y);

    c3EClass = createEClass(C3);
    createEReference(c3EClass, C3__Z);
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
    expressionEClass.getESuperTypes().add(this.getRoot());
    atomEClass.getESuperTypes().add(this.getExpression());
    trickyGEClass.getESuperTypes().add(this.getRoot());
    trickyG1EClass.getESuperTypes().add(this.getTrickyG2());
    addEClass.getESuperTypes().add(this.getExpression());
    minusEClass.getESuperTypes().add(this.getExpression());
    c1EClass.getESuperTypes().add(this.getTrickyC());
    c2EClass.getESuperTypes().add(this.getTrickyC());
    c3EClass.getESuperTypes().add(this.getTrickyC());

    // Initialize classes and features; add operations and parameters
    initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExpression_Em(), theEcorePackage.getEString(), "em", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(atomEClass, Atom.class, "Atom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAtom_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Atom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(trickyBEClass, TrickyB.class, "TrickyB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTrickyB_Name(), theEcorePackage.getEString(), "name", null, 0, 1, TrickyB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTrickyB_Type(), theEcorePackage.getEInt(), "type", null, 0, -1, TrickyB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(trickyCEClass, TrickyC.class, "TrickyC", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTrickyC_Name(), theEcorePackage.getEString(), "name", null, 0, 1, TrickyC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(trickyDEClass, TrickyD.class, "TrickyD", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTrickyD_Name(), theEcorePackage.getEInt(), "name", null, 0, -1, TrickyD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTrickyD_Foo(), theEcorePackage.getEString(), "foo", null, 0, 1, TrickyD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTrickyD_Type(), theEcorePackage.getEString(), "type", null, 0, -1, TrickyD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(trickyEEClass, TrickyE.class, "TrickyE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTrickyE_Name(), theEcorePackage.getEInt(), "name", null, 0, -1, TrickyE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTrickyE_Foo(), theEcorePackage.getEString(), "foo", null, 0, -1, TrickyE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTrickyE_Type(), theEcorePackage.getEString(), "type", null, 0, -1, TrickyE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(trickyFEClass, TrickyF.class, "TrickyF", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTrickyF_Name(), theEcorePackage.getEString(), "name", null, 0, -1, TrickyF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTrickyF_Type(), theEcorePackage.getEInt(), "type", null, 0, -1, TrickyF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(trickyGEClass, TrickyG.class, "TrickyG", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTrickyG_Tree(), this.getTrickyG1(), null, "tree", null, 0, 1, TrickyG.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(trickyG1EClass, TrickyG1.class, "TrickyG1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTrickyG1_Vals(), this.getTrickyG2(), null, "vals", null, 0, -1, TrickyG1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(trickyG2EClass, TrickyG2.class, "TrickyG2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTrickyG2_Val(), theEcorePackage.getEInt(), "val", null, 0, 1, TrickyG2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(addEClass, Add.class, "Add", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAdd_AddOperands(), this.getExpression(), null, "addOperands", null, 0, -1, Add.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(minusEClass, Minus.class, "Minus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMinus_MinusOperands(), this.getExpression(), null, "minusOperands", null, 0, -1, Minus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(c1EClass, org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C1.class, "C1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getC1_X(), this.getTrickyC(), null, "x", null, 0, 1, org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(c2EClass, org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C2.class, "C2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getC2_Y(), this.getTrickyC(), null, "y", null, 0, 1, org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(c3EClass, org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C3.class, "C3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getC3_Z(), this.getTrickyC(), null, "z", null, 0, 1, org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ComplexrewritetestPackageImpl
