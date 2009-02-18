/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimpleExpressionsPackageImpl.java,v 1.1 2009/02/18 19:43:45 sefftinge Exp $
 */
package org.eclipse.xtext.testlanguages.simpleExpressions.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.XtextPackage;

import org.eclipse.xtext.grammarinheritance.ametamodel.AmetamodelPackage;

import org.eclipse.xtext.testlanguages.simpleExpressions.Atom;
import org.eclipse.xtext.testlanguages.simpleExpressions.Expression;
import org.eclipse.xtext.testlanguages.simpleExpressions.Op;
import org.eclipse.xtext.testlanguages.simpleExpressions.Sequence;
import org.eclipse.xtext.testlanguages.simpleExpressions.SimpleExpressionsFactory;
import org.eclipse.xtext.testlanguages.simpleExpressions.SimpleExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimpleExpressionsPackageImpl extends EPackageImpl implements SimpleExpressionsPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceEClass = null;

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
  private EClass opEClass = null;

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
   * @see org.eclipse.xtext.testlanguages.simpleExpressions.SimpleExpressionsPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private SimpleExpressionsPackageImpl()
  {
    super(eNS_URI, SimpleExpressionsFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this
   * model, and for any others upon which it depends.  Simple
   * dependencies are satisfied by calling this method on all
   * dependent packages before doing anything else.  This method drives
   * initialization for interdependent packages directly, in parallel
   * with this package, itself.
   * <p>Of this package and its interdependencies, all packages which
   * have not yet been registered by their URI values are first created
   * and registered.  The packages are then initialized in two steps:
   * meta-model objects for all of the packages are created before any
   * are initialized, since one package's meta-model objects may refer to
   * those of another.
   * <p>Invocation of this method will not affect any packages that have
   * already been initialized.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static SimpleExpressionsPackage init()
  {
    if (isInited) return (SimpleExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(SimpleExpressionsPackage.eNS_URI);

    // Obtain or create and register package
    SimpleExpressionsPackageImpl theSimpleExpressionsPackage = (SimpleExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof SimpleExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new SimpleExpressionsPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XtextPackage.eINSTANCE.eClass();
    AmetamodelPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theSimpleExpressionsPackage.createPackageContents();

    // Initialize created meta-data
    theSimpleExpressionsPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSimpleExpressionsPackage.freeze();

    return theSimpleExpressionsPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequence()
  {
    return sequenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequence_Expressions()
  {
    return (EReference)sequenceEClass.getEStructuralFeatures().get(0);
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
  public EClass getOp()
  {
    return opEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOp_Values()
  {
    return (EReference)opEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOp_Operator()
  {
    return (EAttribute)opEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleExpressionsFactory getSimpleExpressionsFactory()
  {
    return (SimpleExpressionsFactory)getEFactoryInstance();
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
    sequenceEClass = createEClass(SEQUENCE);
    createEReference(sequenceEClass, SEQUENCE__EXPRESSIONS);

    expressionEClass = createEClass(EXPRESSION);

    atomEClass = createEClass(ATOM);
    createEAttribute(atomEClass, ATOM__NAME);

    opEClass = createEClass(OP);
    createEReference(opEClass, OP__VALUES);
    createEAttribute(opEClass, OP__OPERATOR);
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
    expressionEClass.getESuperTypes().add(this.getSequence());
    atomEClass.getESuperTypes().add(this.getExpression());
    opEClass.getESuperTypes().add(this.getExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(sequenceEClass, Sequence.class, "Sequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSequence_Expressions(), this.getExpression(), null, "expressions", null, 0, -1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(atomEClass, Atom.class, "Atom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAtom_Name(), ecorePackage.getEString(), "name", null, 0, 1, Atom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(opEClass, Op.class, "Op", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOp_Values(), this.getExpression(), null, "values", null, 0, -1, Op.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOp_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, Op.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //SimpleExpressionsPackageImpl
