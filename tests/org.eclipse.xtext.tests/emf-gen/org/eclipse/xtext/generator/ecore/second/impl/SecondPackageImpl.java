/**
 */
package org.eclipse.xtext.generator.ecore.second.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.generator.ecore.first.FirstPackage;

import org.eclipse.xtext.generator.ecore.first.impl.FirstPackageImpl;

import org.eclipse.xtext.generator.ecore.second.Second;
import org.eclipse.xtext.generator.ecore.second.SecondFactory;
import org.eclipse.xtext.generator.ecore.second.SecondPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SecondPackageImpl extends EPackageImpl implements SecondPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass secondEClass = null;

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
   * @see org.eclipse.xtext.generator.ecore.second.SecondPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private SecondPackageImpl()
  {
    super(eNS_URI, SecondFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link SecondPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static SecondPackage init()
  {
    if (isInited) return (SecondPackage)EPackage.Registry.INSTANCE.getEPackage(SecondPackage.eNS_URI);

    // Obtain or create and register package
    SecondPackageImpl theSecondPackage = (SecondPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SecondPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SecondPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    FirstPackageImpl theFirstPackage = (FirstPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FirstPackage.eNS_URI) instanceof FirstPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FirstPackage.eNS_URI) : FirstPackage.eINSTANCE);

    // Create package meta-data objects
    theSecondPackage.createPackageContents();
    theFirstPackage.createPackageContents();

    // Initialize created meta-data
    theSecondPackage.initializePackageContents();
    theFirstPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSecondPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(SecondPackage.eNS_URI, theSecondPackage);
    return theSecondPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSecond()
  {
    return secondEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSecond_Name()
  {
    return (EAttribute)secondEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSecond_First()
  {
    return (EReference)secondEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SecondFactory getSecondFactory()
  {
    return (SecondFactory)getEFactoryInstance();
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
    secondEClass = createEClass(SECOND);
    createEAttribute(secondEClass, SECOND__NAME);
    createEReference(secondEClass, SECOND__FIRST);
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
    FirstPackage theFirstPackage = (FirstPackage)EPackage.Registry.INSTANCE.getEPackage(FirstPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(secondEClass, Second.class, "Second", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSecond_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Second.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSecond_First(), theFirstPackage.getFirst(), null, "first", null, 0, 1, Second.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //SecondPackageImpl
