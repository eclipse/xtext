/**
 */
package org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.grammarinheritance.inheritanceTest.InheritanceTestPackage;

import org.eclipse.xtext.grammarinheritance.inheritanceTest2.InheritanceTest2Factory;
import org.eclipse.xtext.grammarinheritance.inheritanceTest2.InheritanceTest2Package;
import org.eclipse.xtext.grammarinheritance.inheritanceTest2.Model;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InheritanceTest2PackageImpl extends EPackageImpl implements InheritanceTest2Package
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

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
   * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.InheritanceTest2Package#eNS_URI
   * @see #init()
   * @generated
   */
  private InheritanceTest2PackageImpl()
  {
    super(eNS_URI, InheritanceTest2Factory.eINSTANCE);
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
   * <p>This method is used to initialize {@link InheritanceTest2Package#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static InheritanceTest2Package init()
  {
    if (isInited) return (InheritanceTest2Package)EPackage.Registry.INSTANCE.getEPackage(InheritanceTest2Package.eNS_URI);

    // Obtain or create and register package
    InheritanceTest2PackageImpl theInheritanceTest2Package = (InheritanceTest2PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InheritanceTest2PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InheritanceTest2PackageImpl());

    isInited = true;

    // Initialize simple dependencies
    InheritanceTestPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theInheritanceTest2Package.createPackageContents();

    // Initialize created meta-data
    theInheritanceTest2Package.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theInheritanceTest2Package.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(InheritanceTest2Package.eNS_URI, theInheritanceTest2Package);
    return theInheritanceTest2Package;
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
  public EAttribute getModel_Ids()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InheritanceTest2Factory getInheritanceTest2Factory()
  {
    return (InheritanceTest2Factory)getEFactoryInstance();
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
    createEAttribute(modelEClass, MODEL__IDS);
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
    InheritanceTestPackage theInheritanceTestPackage = (InheritanceTestPackage)EPackage.Registry.INSTANCE.getEPackage(InheritanceTestPackage.eNS_URI);
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    modelEClass.getESuperTypes().add(theInheritanceTestPackage.getModel());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModel_Ids(), theEcorePackage.getEString(), "ids", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //InheritanceTest2PackageImpl
