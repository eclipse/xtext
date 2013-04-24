/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Bug348199TestLanguageFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Bug348199TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.TimeDef;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Timeperiod;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug348199TestLanguagePackageImpl extends EPackageImpl implements Bug348199TestLanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timeperiodEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timeDefEClass = null;

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
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Bug348199TestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Bug348199TestLanguagePackageImpl()
  {
    super(eNS_URI, Bug348199TestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link Bug348199TestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Bug348199TestLanguagePackage init()
  {
    if (isInited) return (Bug348199TestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(Bug348199TestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    Bug348199TestLanguagePackageImpl theBug348199TestLanguagePackage = (Bug348199TestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Bug348199TestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Bug348199TestLanguagePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theBug348199TestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theBug348199TestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBug348199TestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Bug348199TestLanguagePackage.eNS_URI, theBug348199TestLanguagePackage);
    return theBug348199TestLanguagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTimeperiod()
  {
    return timeperiodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTimeperiod_Time()
  {
    return (EReference)timeperiodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeperiod_Name()
  {
    return (EAttribute)timeperiodEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeperiod_Alias()
  {
    return (EAttribute)timeperiodEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTimeDef()
  {
    return timeDefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeDef_Day()
  {
    return (EAttribute)timeDefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug348199TestLanguageFactory getBug348199TestLanguageFactory()
  {
    return (Bug348199TestLanguageFactory)getEFactoryInstance();
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
    timeperiodEClass = createEClass(TIMEPERIOD);
    createEReference(timeperiodEClass, TIMEPERIOD__TIME);
    createEAttribute(timeperiodEClass, TIMEPERIOD__NAME);
    createEAttribute(timeperiodEClass, TIMEPERIOD__ALIAS);

    timeDefEClass = createEClass(TIME_DEF);
    createEAttribute(timeDefEClass, TIME_DEF__DAY);
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
    initEClass(timeperiodEClass, Timeperiod.class, "Timeperiod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTimeperiod_Time(), this.getTimeDef(), null, "time", null, 0, -1, Timeperiod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTimeperiod_Name(), ecorePackage.getEString(), "name", null, 0, -1, Timeperiod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTimeperiod_Alias(), ecorePackage.getEString(), "alias", null, 0, -1, Timeperiod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timeDefEClass, TimeDef.class, "TimeDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTimeDef_Day(), ecorePackage.getEInt(), "day", null, 0, 1, TimeDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //Bug348199TestLanguagePackageImpl
