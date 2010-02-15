/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.generator.ecore.superPackage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.generator.ecore.superPackage.AnotherSuperMain;
import org.eclipse.xtext.generator.ecore.superPackage.SuperMain;
import org.eclipse.xtext.generator.ecore.superPackage.SuperPackageFactory;
import org.eclipse.xtext.generator.ecore.superPackage.SuperPackagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SuperPackagePackageImpl extends EPackageImpl implements SuperPackagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass superMainEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anotherSuperMainEClass = null;

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
   * @see org.eclipse.xtext.generator.ecore.superPackage.SuperPackagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private SuperPackagePackageImpl()
  {
    super(eNS_URI, SuperPackageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link SuperPackagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static SuperPackagePackage init()
  {
    if (isInited) return (SuperPackagePackage)EPackage.Registry.INSTANCE.getEPackage(SuperPackagePackage.eNS_URI);

    // Obtain or create and register package
    SuperPackagePackageImpl theSuperPackagePackage = (SuperPackagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SuperPackagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SuperPackagePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theSuperPackagePackage.createPackageContents();

    // Initialize created meta-data
    theSuperPackagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSuperPackagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(SuperPackagePackage.eNS_URI, theSuperPackagePackage);
    return theSuperPackagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuperMain()
  {
    return superMainEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSuperMain_Name()
  {
    return (EAttribute)superMainEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnotherSuperMain()
  {
    return anotherSuperMainEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnotherSuperMain_Name()
  {
    return (EAttribute)anotherSuperMainEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuperPackageFactory getSuperPackageFactory()
  {
    return (SuperPackageFactory)getEFactoryInstance();
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
    superMainEClass = createEClass(SUPER_MAIN);
    createEAttribute(superMainEClass, SUPER_MAIN__NAME);

    anotherSuperMainEClass = createEClass(ANOTHER_SUPER_MAIN);
    createEAttribute(anotherSuperMainEClass, ANOTHER_SUPER_MAIN__NAME);
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
    initEClass(superMainEClass, SuperMain.class, "SuperMain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSuperMain_Name(), ecorePackage.getEString(), "name", null, 0, 1, SuperMain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(anotherSuperMainEClass, AnotherSuperMain.class, "AnotherSuperMain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAnotherSuperMain_Name(), ecorePackage.getEString(), "name", null, 0, 1, AnotherSuperMain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //SuperPackagePackageImpl
