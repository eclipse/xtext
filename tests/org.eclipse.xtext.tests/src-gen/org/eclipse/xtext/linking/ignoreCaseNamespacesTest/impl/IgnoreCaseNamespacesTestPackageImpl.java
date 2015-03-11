/**
 */
package org.eclipse.xtext.linking.ignoreCaseNamespacesTest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.linking.ignoreCaseLinkingTest.IgnoreCaseLinkingTestPackage;

import org.eclipse.xtext.linking.ignoreCaseNamespacesTest.IgnoreCaseNamespacesTestFactory;
import org.eclipse.xtext.linking.ignoreCaseNamespacesTest.IgnoreCaseNamespacesTestPackage;
import org.eclipse.xtext.linking.ignoreCaseNamespacesTest.Import;
import org.eclipse.xtext.linking.ignoreCaseNamespacesTest.Model;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IgnoreCaseNamespacesTestPackageImpl extends EPackageImpl implements IgnoreCaseNamespacesTestPackage
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
   * @see org.eclipse.xtext.linking.ignoreCaseNamespacesTest.IgnoreCaseNamespacesTestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private IgnoreCaseNamespacesTestPackageImpl()
  {
    super(eNS_URI, IgnoreCaseNamespacesTestFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link IgnoreCaseNamespacesTestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static IgnoreCaseNamespacesTestPackage init()
  {
    if (isInited) return (IgnoreCaseNamespacesTestPackage)EPackage.Registry.INSTANCE.getEPackage(IgnoreCaseNamespacesTestPackage.eNS_URI);

    // Obtain or create and register package
    IgnoreCaseNamespacesTestPackageImpl theIgnoreCaseNamespacesTestPackage = (IgnoreCaseNamespacesTestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof IgnoreCaseNamespacesTestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new IgnoreCaseNamespacesTestPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    IgnoreCaseLinkingTestPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theIgnoreCaseNamespacesTestPackage.createPackageContents();

    // Initialize created meta-data
    theIgnoreCaseNamespacesTestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theIgnoreCaseNamespacesTestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(IgnoreCaseNamespacesTestPackage.eNS_URI, theIgnoreCaseNamespacesTestPackage);
    return theIgnoreCaseNamespacesTestPackage;
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
  public EAttribute getImport_ImportedNamespace()
  {
    return (EAttribute)importEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IgnoreCaseNamespacesTestFactory getIgnoreCaseNamespacesTestFactory()
  {
    return (IgnoreCaseNamespacesTestFactory)getEFactoryInstance();
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
    createEAttribute(importEClass, IMPORT__IMPORTED_NAMESPACE);
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
    initEAttribute(getImport_ImportedNamespace(), theEcorePackage.getEString(), "importedNamespace", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //IgnoreCaseNamespacesTestPackageImpl
