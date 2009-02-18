/**
 * <copyright>
 * </copyright>
 *
 * $Id: OtherTestPackageImpl.java,v 1.2 2009/02/18 21:22:44 sefftinge Exp $
 */
package org.eclipse.xtext.metamodelreferencing.tests.otherTest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.XtextPackage;

import org.eclipse.xtext.grammarinheritance.ametamodel.AmetamodelPackage;

import org.eclipse.xtext.metamodelreferencing.tests.otherTest.FooBar;
import org.eclipse.xtext.metamodelreferencing.tests.otherTest.OtherTestFactory;
import org.eclipse.xtext.metamodelreferencing.tests.otherTest.OtherTestPackage;

import org.eclipse.xtext.metamodelreferencing.tests.simpleTest.SimpleTestPackage;

import org.eclipse.xtext.metamodelreferencing.tests.simpleTest.impl.SimpleTestPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OtherTestPackageImpl extends EPackageImpl implements OtherTestPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fooBarEClass = null;

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
   * @see org.eclipse.xtext.metamodelreferencing.tests.otherTest.OtherTestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private OtherTestPackageImpl()
  {
    super(eNS_URI, OtherTestFactory.eINSTANCE);
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
  public static OtherTestPackage init()
  {
    if (isInited) return (OtherTestPackage)EPackage.Registry.INSTANCE.getEPackage(OtherTestPackage.eNS_URI);

    // Obtain or create and register package
    OtherTestPackageImpl theOtherTestPackage = (OtherTestPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof OtherTestPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new OtherTestPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XtextPackage.eINSTANCE.eClass();
    AmetamodelPackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    SimpleTestPackageImpl theSimpleTestPackage = (SimpleTestPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SimpleTestPackage.eNS_URI) instanceof SimpleTestPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SimpleTestPackage.eNS_URI) : SimpleTestPackage.eINSTANCE);

    // Create package meta-data objects
    theOtherTestPackage.createPackageContents();
    theSimpleTestPackage.createPackageContents();

    // Initialize created meta-data
    theOtherTestPackage.initializePackageContents();
    theSimpleTestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theOtherTestPackage.freeze();

    return theOtherTestPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFooBar()
  {
    return fooBarEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFooBar_Name()
  {
    return (EAttribute)fooBarEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OtherTestFactory getOtherTestFactory()
  {
    return (OtherTestFactory)getEFactoryInstance();
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
    fooBarEClass = createEClass(FOO_BAR);
    createEAttribute(fooBarEClass, FOO_BAR__NAME);
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

    // Initialize classes and features; add operations and parameters
    initEClass(fooBarEClass, FooBar.class, "FooBar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFooBar_Name(), ecorePackage.getEString(), "name", null, 0, 1, FooBar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //OtherTestPackageImpl
