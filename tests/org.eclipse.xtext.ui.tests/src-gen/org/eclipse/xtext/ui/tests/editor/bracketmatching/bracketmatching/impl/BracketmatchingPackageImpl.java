/**
 */
package org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.Atom;
import org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.BracketmatchingFactory;
import org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.BracketmatchingPackage;
import org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.Expression;
import org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.File;
import org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.SExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BracketmatchingPackageImpl extends EPackageImpl implements BracketmatchingPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fileEClass = null;

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
  private EClass sExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass atomEClass = null;

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
   * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.BracketmatchingPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private BracketmatchingPackageImpl()
  {
    super(eNS_URI, BracketmatchingFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link BracketmatchingPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static BracketmatchingPackage init()
  {
    if (isInited) return (BracketmatchingPackage)EPackage.Registry.INSTANCE.getEPackage(BracketmatchingPackage.eNS_URI);

    // Obtain or create and register package
    BracketmatchingPackageImpl theBracketmatchingPackage = (BracketmatchingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BracketmatchingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BracketmatchingPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theBracketmatchingPackage.createPackageContents();

    // Initialize created meta-data
    theBracketmatchingPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBracketmatchingPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(BracketmatchingPackage.eNS_URI, theBracketmatchingPackage);
    return theBracketmatchingPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFile()
  {
    return fileEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFile_Expression()
  {
    return (EReference)fileEClass.getEStructuralFeatures().get(0);
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
  public EClass getSExpression()
  {
    return sExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSExpression_Element()
  {
    return (EReference)sExpressionEClass.getEStructuralFeatures().get(0);
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
  public EAttribute getAtom_Value()
  {
    return (EAttribute)atomEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BracketmatchingFactory getBracketmatchingFactory()
  {
    return (BracketmatchingFactory)getEFactoryInstance();
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
    fileEClass = createEClass(FILE);
    createEReference(fileEClass, FILE__EXPRESSION);

    expressionEClass = createEClass(EXPRESSION);

    sExpressionEClass = createEClass(SEXPRESSION);
    createEReference(sExpressionEClass, SEXPRESSION__ELEMENT);

    atomEClass = createEClass(ATOM);
    createEAttribute(atomEClass, ATOM__VALUE);
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
    sExpressionEClass.getESuperTypes().add(this.getExpression());
    atomEClass.getESuperTypes().add(this.getExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(fileEClass, File.class, "File", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFile_Expression(), this.getExpression(), null, "expression", null, 0, -1, File.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(sExpressionEClass, SExpression.class, "SExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSExpression_Element(), this.getExpression(), null, "element", null, 0, -1, SExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(atomEClass, Atom.class, "Atom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAtom_Value(), ecorePackage.getEString(), "value", null, 0, 1, Atom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //BracketmatchingPackageImpl
