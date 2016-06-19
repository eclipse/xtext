/**
 */
package org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.EcorePerNsURIPackage;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.EcorePerPlatformPluginPackage;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.EcorePerPlatformResourcePackage;

import org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.EcoreReferenceFactory;
import org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.EcoreReferencePackage;
import org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.Model;
import org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.MyNamedElement_01;
import org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.MyNamedElement_02;
import org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.MyNamedElement_03;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcoreReferencePackageImpl extends EPackageImpl implements EcoreReferencePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myNamedElement_01EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myNamedElement_02EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myNamedElement_03EClass = null;

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
   * @see org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.EcoreReferencePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private EcoreReferencePackageImpl()
  {
    super(eNS_URI, EcoreReferenceFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link EcoreReferencePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static EcoreReferencePackage init()
  {
    if (isInited) return (EcoreReferencePackage)EPackage.Registry.INSTANCE.getEPackage(EcoreReferencePackage.eNS_URI);

    // Obtain or create and register package
    EcoreReferencePackageImpl theEcoreReferencePackage = (EcoreReferencePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EcoreReferencePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EcoreReferencePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePerNsURIPackage.eINSTANCE.eClass();
    EcorePerPlatformPluginPackage.eINSTANCE.eClass();
    EcorePerPlatformResourcePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theEcoreReferencePackage.createPackageContents();

    // Initialize created meta-data
    theEcoreReferencePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theEcoreReferencePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(EcoreReferencePackage.eNS_URI, theEcoreReferencePackage);
    return theEcoreReferencePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Extends()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMyNamedElement_01()
  {
    return myNamedElement_01EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMyNamedElement_02()
  {
    return myNamedElement_02EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMyNamedElement_03()
  {
    return myNamedElement_03EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EcoreReferenceFactory getEcoreReferenceFactory()
  {
    return (EcoreReferenceFactory)getEFactoryInstance();
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
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__EXTENDS);

    myNamedElement_01EClass = createEClass(MY_NAMED_ELEMENT_01);

    myNamedElement_02EClass = createEClass(MY_NAMED_ELEMENT_02);

    myNamedElement_03EClass = createEClass(MY_NAMED_ELEMENT_03);
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
    EcorePerNsURIPackage theEcorePerNsURIPackage = (EcorePerNsURIPackage)EPackage.Registry.INSTANCE.getEPackage(EcorePerNsURIPackage.eNS_URI);
    EcorePerPlatformResourcePackage theEcorePerPlatformResourcePackage = (EcorePerPlatformResourcePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePerPlatformResourcePackage.eNS_URI);
    EcorePerPlatformPluginPackage theEcorePerPlatformPluginPackage = (EcorePerPlatformPluginPackage)EPackage.Registry.INSTANCE.getEPackage(EcorePerPlatformPluginPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    myNamedElement_01EClass.getESuperTypes().add(theEcorePerNsURIPackage.getExtendsNsURIEObject());
    myNamedElement_02EClass.getESuperTypes().add(theEcorePerPlatformResourcePackage.getExtendsResourceEObject());
    myNamedElement_03EClass.getESuperTypes().add(theEcorePerPlatformPluginPackage.getExtendsPluginEObject());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Extends(), theEcorePackage.getEObject(), null, "extends", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myNamedElement_01EClass, MyNamedElement_01.class, "MyNamedElement_01", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(myNamedElement_02EClass, MyNamedElement_02.class, "MyNamedElement_02", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(myNamedElement_03EClass, MyNamedElement_03.class, "MyNamedElement_03", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //EcoreReferencePackageImpl
