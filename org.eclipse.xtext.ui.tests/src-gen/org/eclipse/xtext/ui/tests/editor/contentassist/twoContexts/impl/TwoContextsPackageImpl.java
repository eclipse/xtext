/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.AnElement;
import org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.MainModel;
import org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.TwoContextsFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.TwoContextsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TwoContextsPackageImpl extends EPackageImpl implements TwoContextsPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mainModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anElementEClass = null;

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
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.TwoContextsPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TwoContextsPackageImpl()
  {
    super(eNS_URI, TwoContextsFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link TwoContextsPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TwoContextsPackage init()
  {
    if (isInited) return (TwoContextsPackage)EPackage.Registry.INSTANCE.getEPackage(TwoContextsPackage.eNS_URI);

    // Obtain or create and register package
    TwoContextsPackageImpl theTwoContextsPackage = (TwoContextsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TwoContextsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TwoContextsPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theTwoContextsPackage.createPackageContents();

    // Initialize created meta-data
    theTwoContextsPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTwoContextsPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TwoContextsPackage.eNS_URI, theTwoContextsPackage);
    return theTwoContextsPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMainModel()
  {
    return mainModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMainModel_Elements()
  {
    return (EReference)mainModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnElement()
  {
    return anElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnElement_Name()
  {
    return (EAttribute)anElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnElement_Referred()
  {
    return (EReference)anElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TwoContextsFactory getTwoContextsFactory()
  {
    return (TwoContextsFactory)getEFactoryInstance();
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
    mainModelEClass = createEClass(MAIN_MODEL);
    createEReference(mainModelEClass, MAIN_MODEL__ELEMENTS);

    anElementEClass = createEClass(AN_ELEMENT);
    createEAttribute(anElementEClass, AN_ELEMENT__NAME);
    createEReference(anElementEClass, AN_ELEMENT__REFERRED);
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
    initEClass(mainModelEClass, MainModel.class, "MainModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMainModel_Elements(), this.getAnElement(), null, "elements", null, 0, -1, MainModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(anElementEClass, AnElement.class, "AnElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAnElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, AnElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAnElement_Referred(), this.getAnElement(), null, "referred", null, 0, 1, AnElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //TwoContextsPackageImpl
