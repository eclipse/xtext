/**
 */
package org.eclipse.xtext.generator.ecore.first.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.generator.ecore.first.First;
import org.eclipse.xtext.generator.ecore.first.FirstFactory;
import org.eclipse.xtext.generator.ecore.first.FirstPackage;

import org.eclipse.xtext.generator.ecore.second.SecondPackage;

import org.eclipse.xtext.generator.ecore.second.impl.SecondPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FirstPackageImpl extends EPackageImpl implements FirstPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass firstEClass = null;

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
   * @see org.eclipse.xtext.generator.ecore.first.FirstPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private FirstPackageImpl()
  {
    super(eNS_URI, FirstFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link FirstPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static FirstPackage init()
  {
    if (isInited) return (FirstPackage)EPackage.Registry.INSTANCE.getEPackage(FirstPackage.eNS_URI);

    // Obtain or create and register package
    FirstPackageImpl theFirstPackage = (FirstPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FirstPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FirstPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    SecondPackageImpl theSecondPackage = (SecondPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SecondPackage.eNS_URI) instanceof SecondPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SecondPackage.eNS_URI) : SecondPackage.eINSTANCE);

    // Create package meta-data objects
    theFirstPackage.createPackageContents();
    theSecondPackage.createPackageContents();

    // Initialize created meta-data
    theFirstPackage.initializePackageContents();
    theSecondPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theFirstPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(FirstPackage.eNS_URI, theFirstPackage);
    return theFirstPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFirst()
  {
    return firstEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFirst_Name()
  {
    return (EAttribute)firstEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FirstFactory getFirstFactory()
  {
    return (FirstFactory)getEFactoryInstance();
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
    firstEClass = createEClass(FIRST);
    createEAttribute(firstEClass, FIRST__NAME);
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
    initEClass(firstEClass, First.class, "First", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFirst_Name(), ecorePackage.getEString(), "name", null, 0, 1, First.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //FirstPackageImpl
