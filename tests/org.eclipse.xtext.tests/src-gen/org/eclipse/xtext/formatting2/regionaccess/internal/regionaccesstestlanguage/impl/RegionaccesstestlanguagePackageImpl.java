/**
 */
package org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegate;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegation;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedDelegate;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedUnassigned;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguageFactory;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Simple;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Unassigned;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RegionaccesstestlanguagePackageImpl extends EPackageImpl implements RegionaccesstestlanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass delegationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unassignedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass prefixedUnassignedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass prefixedDelegateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass delegateEClass = null;

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
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private RegionaccesstestlanguagePackageImpl()
  {
    super(eNS_URI, RegionaccesstestlanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link RegionaccesstestlanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static RegionaccesstestlanguagePackage init()
  {
    if (isInited) return (RegionaccesstestlanguagePackage)EPackage.Registry.INSTANCE.getEPackage(RegionaccesstestlanguagePackage.eNS_URI);

    // Obtain or create and register package
    RegionaccesstestlanguagePackageImpl theRegionaccesstestlanguagePackage = (RegionaccesstestlanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RegionaccesstestlanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RegionaccesstestlanguagePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theRegionaccesstestlanguagePackage.createPackageContents();

    // Initialize created meta-data
    theRegionaccesstestlanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theRegionaccesstestlanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(RegionaccesstestlanguagePackage.eNS_URI, theRegionaccesstestlanguagePackage);
    return theRegionaccesstestlanguagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoot()
  {
    return rootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimple()
  {
    return simpleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimple_Name()
  {
    return (EAttribute)simpleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDelegation()
  {
    return delegationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDelegation_Delegate()
  {
    return (EReference)delegationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnassigned()
  {
    return unassignedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrefixedUnassigned()
  {
    return prefixedUnassignedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrefixedUnassigned_Delegate()
  {
    return (EReference)prefixedUnassignedEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrefixedDelegate()
  {
    return prefixedDelegateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDelegate()
  {
    return delegateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDelegate_Name()
  {
    return (EAttribute)delegateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RegionaccesstestlanguageFactory getRegionaccesstestlanguageFactory()
  {
    return (RegionaccesstestlanguageFactory)getEFactoryInstance();
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
    rootEClass = createEClass(ROOT);

    simpleEClass = createEClass(SIMPLE);
    createEAttribute(simpleEClass, SIMPLE__NAME);

    delegationEClass = createEClass(DELEGATION);
    createEReference(delegationEClass, DELEGATION__DELEGATE);

    unassignedEClass = createEClass(UNASSIGNED);

    prefixedUnassignedEClass = createEClass(PREFIXED_UNASSIGNED);
    createEReference(prefixedUnassignedEClass, PREFIXED_UNASSIGNED__DELEGATE);

    prefixedDelegateEClass = createEClass(PREFIXED_DELEGATE);

    delegateEClass = createEClass(DELEGATE);
    createEAttribute(delegateEClass, DELEGATE__NAME);
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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    simpleEClass.getESuperTypes().add(this.getRoot());
    delegationEClass.getESuperTypes().add(this.getRoot());
    unassignedEClass.getESuperTypes().add(this.getRoot());
    prefixedUnassignedEClass.getESuperTypes().add(this.getRoot());
    delegateEClass.getESuperTypes().add(this.getUnassigned());
    delegateEClass.getESuperTypes().add(this.getPrefixedDelegate());

    // Initialize classes and features; add operations and parameters
    initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(simpleEClass, Simple.class, "Simple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimple_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Simple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(delegationEClass, Delegation.class, "Delegation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDelegation_Delegate(), this.getDelegate(), null, "delegate", null, 0, 1, Delegation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unassignedEClass, Unassigned.class, "Unassigned", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(prefixedUnassignedEClass, PrefixedUnassigned.class, "PrefixedUnassigned", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPrefixedUnassigned_Delegate(), this.getPrefixedDelegate(), null, "delegate", null, 0, 1, PrefixedUnassigned.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(prefixedDelegateEClass, PrefixedDelegate.class, "PrefixedDelegate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(delegateEClass, Delegate.class, "Delegate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDelegate_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Delegate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //RegionaccesstestlanguagePackageImpl
