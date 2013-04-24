/**
 */
package org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.XtextPackage;

import org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.AnotherSimpleTestFactory;
import org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.AnotherSimpleTestPackage;
import org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.Foo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnotherSimpleTestPackageImpl extends EPackageImpl implements AnotherSimpleTestPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fooEClass = null;

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
   * @see org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.AnotherSimpleTestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private AnotherSimpleTestPackageImpl()
  {
    super(eNS_URI, AnotherSimpleTestFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link AnotherSimpleTestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static AnotherSimpleTestPackage init()
  {
    if (isInited) return (AnotherSimpleTestPackage)EPackage.Registry.INSTANCE.getEPackage(AnotherSimpleTestPackage.eNS_URI);

    // Obtain or create and register package
    AnotherSimpleTestPackageImpl theAnotherSimpleTestPackage = (AnotherSimpleTestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AnotherSimpleTestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AnotherSimpleTestPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XtextPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theAnotherSimpleTestPackage.createPackageContents();

    // Initialize created meta-data
    theAnotherSimpleTestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theAnotherSimpleTestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(AnotherSimpleTestPackage.eNS_URI, theAnotherSimpleTestPackage);
    return theAnotherSimpleTestPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFoo()
  {
    return fooEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFoo_Name()
  {
    return (EAttribute)fooEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFoo_NameRefs()
  {
    return (EReference)fooEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnotherSimpleTestFactory getAnotherSimpleTestFactory()
  {
    return (AnotherSimpleTestFactory)getEFactoryInstance();
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
    fooEClass = createEClass(FOO);
    createEAttribute(fooEClass, FOO__NAME);
    createEReference(fooEClass, FOO__NAME_REFS);
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
    XtextPackage theXtextPackage = (XtextPackage)EPackage.Registry.INSTANCE.getEPackage(XtextPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(fooEClass, Foo.class, "Foo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFoo_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Foo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFoo_NameRefs(), theXtextPackage.getRuleCall(), null, "nameRefs", null, 0, -1, Foo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //AnotherSimpleTestPackageImpl
