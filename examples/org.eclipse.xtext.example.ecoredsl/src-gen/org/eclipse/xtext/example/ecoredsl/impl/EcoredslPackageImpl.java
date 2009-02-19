/**
 * <copyright>
 * </copyright>
 *
 * $Id: EcoredslPackageImpl.java,v 1.6 2009/02/19 21:08:23 sefftinge Exp $
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
import org.eclipse.xtext.example.ecoredsl.ImportStatementDecl;
import org.eclipse.xtext.example.ecoredsl.MapEntry;
import org.eclipse.xtext.example.ecoredsl.MultiplicityExpr;

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
  private EClass importStatementDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mapEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicityExprEClass = null;

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
  public static EcoredslPackage init()
  {
    if (isInited) return (EcoredslPackage)EPackage.Registry.INSTANCE.getEPackage(EcoredslPackage.eNS_URI);

    // Obtain or create and register package
    EcoredslPackageImpl theEcoredslPackage = (EcoredslPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EcoredslPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new EcoredslPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theEcoredslPackage.createPackageContents();

    // Initialize created meta-data
    theEcoredslPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theEcoredslPackage.freeze();

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
  public EReference getEcoreDsl_Imports()
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
  public EClass getImportStatementDecl()
  {
    return importStatementDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImportStatementDecl_Alias()
  {
    return (EAttribute)importStatementDeclEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImportStatementDecl_ImportURI()
  {
    return (EAttribute)importStatementDeclEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMapEntry()
  {
    return mapEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMapEntry_DetailKey()
  {
    return (EAttribute)mapEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMapEntry_DetailValue()
  {
    return (EAttribute)mapEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicityExpr()
  {
    return multiplicityExprEClass;
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
    createEReference(ecoreDslEClass, ECORE_DSL__IMPORTS);
    createEReference(ecoreDslEClass, ECORE_DSL__PACKAGE);

    importStatementDeclEClass = createEClass(IMPORT_STATEMENT_DECL);
    createEAttribute(importStatementDeclEClass, IMPORT_STATEMENT_DECL__ALIAS);
    createEAttribute(importStatementDeclEClass, IMPORT_STATEMENT_DECL__IMPORT_URI);

    mapEntryEClass = createEClass(MAP_ENTRY);
    createEAttribute(mapEntryEClass, MAP_ENTRY__DETAIL_KEY);
    createEAttribute(mapEntryEClass, MAP_ENTRY__DETAIL_VALUE);

    multiplicityExprEClass = createEClass(MULTIPLICITY_EXPR);
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
    mapEntryEClass.getESuperTypes().add(ecorePackage.getEObject());

    // Initialize classes and features; add operations and parameters
    initEClass(ecoreDslEClass, EcoreDsl.class, "EcoreDsl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEcoreDsl_Imports(), this.getImportStatementDecl(), null, "imports", null, 0, -1, EcoreDsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEcoreDsl_Package(), ecorePackage.getEPackage(), null, "package", null, 0, 1, EcoreDsl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importStatementDeclEClass, ImportStatementDecl.class, "ImportStatementDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImportStatementDecl_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, ImportStatementDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getImportStatementDecl_ImportURI(), ecorePackage.getEString(), "importURI", null, 0, 1, ImportStatementDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mapEntryEClass, MapEntry.class, "MapEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMapEntry_DetailKey(), ecorePackage.getEString(), "detailKey", null, 0, 1, MapEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMapEntry_DetailValue(), ecorePackage.getEString(), "detailValue", null, 0, 1, MapEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiplicityExprEClass, MultiplicityExpr.class, "MultiplicityExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //EcoredslPackageImpl
