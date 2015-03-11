/**
 */
package org.eclipse.xtext.linking.ignoreCaseImportsTest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.linking.ignoreCaseImportsTest.IgnoreCaseImportsTestFactory;
import org.eclipse.xtext.linking.ignoreCaseImportsTest.IgnoreCaseImportsTestPackage;
import org.eclipse.xtext.linking.ignoreCaseImportsTest.Import;
import org.eclipse.xtext.linking.ignoreCaseImportsTest.Model;

import org.eclipse.xtext.linking.ignoreCaseLinkingTest.IgnoreCaseLinkingTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IgnoreCaseImportsTestPackageImpl extends EPackageImpl implements IgnoreCaseImportsTestPackage
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
  private EClass importEClass = null;

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
   * @see org.eclipse.xtext.linking.ignoreCaseImportsTest.IgnoreCaseImportsTestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private IgnoreCaseImportsTestPackageImpl()
  {
    super(eNS_URI, IgnoreCaseImportsTestFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link IgnoreCaseImportsTestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static IgnoreCaseImportsTestPackage init()
  {
    if (isInited) return (IgnoreCaseImportsTestPackage)EPackage.Registry.INSTANCE.getEPackage(IgnoreCaseImportsTestPackage.eNS_URI);

    // Obtain or create and register package
    IgnoreCaseImportsTestPackageImpl theIgnoreCaseImportsTestPackage = (IgnoreCaseImportsTestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof IgnoreCaseImportsTestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new IgnoreCaseImportsTestPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    IgnoreCaseLinkingTestPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theIgnoreCaseImportsTestPackage.createPackageContents();

    // Initialize created meta-data
    theIgnoreCaseImportsTestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theIgnoreCaseImportsTestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(IgnoreCaseImportsTestPackage.eNS_URI, theIgnoreCaseImportsTestPackage);
    return theIgnoreCaseImportsTestPackage;
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
  public EReference getModel_Imports()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImport()
  {
    return importEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImport_ImportURI()
  {
    return (EAttribute)importEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IgnoreCaseImportsTestFactory getIgnoreCaseImportsTestFactory()
  {
    return (IgnoreCaseImportsTestFactory)getEFactoryInstance();
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
    createEReference(modelEClass, MODEL__IMPORTS);

    importEClass = createEClass(IMPORT);
    createEAttribute(importEClass, IMPORT__IMPORT_URI);
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
    IgnoreCaseLinkingTestPackage theIgnoreCaseLinkingTestPackage = (IgnoreCaseLinkingTestPackage)EPackage.Registry.INSTANCE.getEPackage(IgnoreCaseLinkingTestPackage.eNS_URI);
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    modelEClass.getESuperTypes().add(theIgnoreCaseLinkingTestPackage.getModel());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Imports(), this.getImport(), null, "imports", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImport_ImportURI(), theEcorePackage.getEString(), "importURI", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //IgnoreCaseImportsTestPackageImpl
