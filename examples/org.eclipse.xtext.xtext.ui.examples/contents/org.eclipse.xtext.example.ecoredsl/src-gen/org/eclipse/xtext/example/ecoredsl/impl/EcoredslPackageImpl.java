/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.ecoredsl.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.example.ecoredsl.EcoreDsl;
import org.eclipse.xtext.example.ecoredsl.EcoredslFactory;
import org.eclipse.xtext.example.ecoredsl.EcoredslPackage;
import org.eclipse.xtext.example.ecoredsl.ReferencedMetamodel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcoredslPackageImpl extends EPackageImpl implements EcoredslPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ecoreDslEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass referencedMetamodelEClass = null;

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
   * @see org.eclipse.xtext.example.ecoredsl.EcoredslPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private EcoredslPackageImpl()
  {
    super(eNS_URI, EcoredslFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link EcoredslPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static EcoredslPackage init()
  {
    if (isInited) return (EcoredslPackage)EPackage.Registry.INSTANCE.getEPackage(EcoredslPackage.eNS_URI);

    // Obtain or create and register package
    EcoredslPackageImpl theEcoredslPackage = (EcoredslPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EcoredslPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EcoredslPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theEcoredslPackage.createPackageContents();

    // Initialize created meta-data
    theEcoredslPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theEcoredslPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(EcoredslPackage.eNS_URI, theEcoredslPackage);
    return theEcoredslPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEcoreDsl()
  {
    return ecoreDslEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEcoreDsl_MetamodelDeclarations()
  {
    return (EReference)ecoreDslEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEcoreDsl_Package()
  {
    return (EReference)ecoreDslEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReferencedMetamodel()
  {
    return referencedMetamodelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReferencedMetamodel_Alias()
  {
    return (EAttribute)referencedMetamodelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReferencedMetamodel_EPackage()
  {
    return (EReference)referencedMetamodelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EcoredslFactory getEcoredslFactory()
  {
    return (EcoredslFactory)getEFactoryInstance();
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
    ecoreDslEClass = createEClass(ECORE_DSL);
    createEReference(ecoreDslEClass, ECORE_DSL__METAMODEL_DECLARATIONS);
    createEReference(ecoreDslEClass, ECORE_DSL__PACKAGE);

    referencedMetamodelEClass = createEClass(REFERENCED_METAMODEL);
    createEAttribute(referencedMetamodelEClass, REFERENCED_METAMODEL__ALIAS);
    createEReference(referencedMetamodelEClass, REFERENCED_METAMODEL__EPACKAGE);
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
    initEClass(ecoreDslEClass, EcoreDsl.class, "EcoreDsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEcoreDsl_MetamodelDeclarations(), this.getReferencedMetamodel(), null, "metamodelDeclarations", null, 0, -1, EcoreDsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEcoreDsl_Package(), ecorePackage.getEPackage(), null, "package", null, 0, 1, EcoreDsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(referencedMetamodelEClass, ReferencedMetamodel.class, "ReferencedMetamodel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReferencedMetamodel_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, ReferencedMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReferencedMetamodel_EPackage(), ecorePackage.getEPackage(), null, "ePackage", null, 0, 1, ReferencedMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //EcoredslPackageImpl
