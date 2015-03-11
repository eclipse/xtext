/**
 */
package org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.Root;
import org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestList;
import org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestOptional;
import org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestRequired;
import org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TransientvaluestestFactory;
import org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TransientvaluestestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TransientvaluestestPackageImpl extends EPackageImpl implements TransientvaluestestPackage
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
  private EClass testRequiredEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass testOptionalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass testListEClass = null;

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
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TransientvaluestestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TransientvaluestestPackageImpl()
  {
    super(eNS_URI, TransientvaluestestFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link TransientvaluestestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TransientvaluestestPackage init()
  {
    if (isInited) return (TransientvaluestestPackage)EPackage.Registry.INSTANCE.getEPackage(TransientvaluestestPackage.eNS_URI);

    // Obtain or create and register package
    TransientvaluestestPackageImpl theTransientvaluestestPackage = (TransientvaluestestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TransientvaluestestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TransientvaluestestPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theTransientvaluestestPackage.createPackageContents();

    // Initialize created meta-data
    theTransientvaluestestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTransientvaluestestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TransientvaluestestPackage.eNS_URI, theTransientvaluestestPackage);
    return theTransientvaluestestPackage;
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
  public EClass getTestRequired()
  {
    return testRequiredEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTestRequired_Required1()
  {
    return (EAttribute)testRequiredEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTestRequired_Required2()
  {
    return (EAttribute)testRequiredEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTestOptional()
  {
    return testOptionalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTestOptional_Opt1()
  {
    return (EAttribute)testOptionalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTestOptional_Opt2()
  {
    return (EAttribute)testOptionalEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTestList()
  {
    return testListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTestList_Item()
  {
    return (EAttribute)testListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransientvaluestestFactory getTransientvaluestestFactory()
  {
    return (TransientvaluestestFactory)getEFactoryInstance();
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

    testRequiredEClass = createEClass(TEST_REQUIRED);
    createEAttribute(testRequiredEClass, TEST_REQUIRED__REQUIRED1);
    createEAttribute(testRequiredEClass, TEST_REQUIRED__REQUIRED2);

    testOptionalEClass = createEClass(TEST_OPTIONAL);
    createEAttribute(testOptionalEClass, TEST_OPTIONAL__OPT1);
    createEAttribute(testOptionalEClass, TEST_OPTIONAL__OPT2);

    testListEClass = createEClass(TEST_LIST);
    createEAttribute(testListEClass, TEST_LIST__ITEM);
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
    testRequiredEClass.getESuperTypes().add(this.getRoot());
    testOptionalEClass.getESuperTypes().add(this.getRoot());
    testListEClass.getESuperTypes().add(this.getRoot());

    // Initialize classes and features; add operations and parameters
    initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(testRequiredEClass, TestRequired.class, "TestRequired", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTestRequired_Required1(), theEcorePackage.getEInt(), "required1", null, 0, 1, TestRequired.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTestRequired_Required2(), theEcorePackage.getEInt(), "required2", null, 0, 1, TestRequired.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(testOptionalEClass, TestOptional.class, "TestOptional", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTestOptional_Opt1(), theEcorePackage.getEInt(), "opt1", null, 0, 1, TestOptional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTestOptional_Opt2(), theEcorePackage.getEInt(), "opt2", null, 0, 1, TestOptional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(testListEClass, TestList.class, "TestList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTestList_Item(), theEcorePackage.getEInt(), "item", null, 0, -1, TestList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //TransientvaluestestPackageImpl
