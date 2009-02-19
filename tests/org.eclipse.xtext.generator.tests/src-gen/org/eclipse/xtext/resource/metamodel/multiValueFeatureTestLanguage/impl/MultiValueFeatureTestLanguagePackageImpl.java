/**
 * <copyright>
 * </copyright>
 *
 * $Id: MultiValueFeatureTestLanguagePackageImpl.java,v 1.4 2009/02/19 16:26:54 sefftinge Exp $
 */
package org.eclipse.xtext.resource.metamodel.multiValueFeatureTestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.resource.metamodel.multiValueFeatureTestLanguage.MultiValueFeatureTestLanguageFactory;
import org.eclipse.xtext.resource.metamodel.multiValueFeatureTestLanguage.MultiValueFeatureTestLanguagePackage;
import org.eclipse.xtext.resource.metamodel.multiValueFeatureTestLanguage.Start;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MultiValueFeatureTestLanguagePackageImpl extends EPackageImpl implements MultiValueFeatureTestLanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass startEClass = null;

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
   * @see org.eclipse.xtext.resource.metamodel.multiValueFeatureTestLanguage.MultiValueFeatureTestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private MultiValueFeatureTestLanguagePackageImpl()
  {
    super(eNS_URI, MultiValueFeatureTestLanguageFactory.eINSTANCE);
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
  public static MultiValueFeatureTestLanguagePackage init()
  {
    if (isInited) return (MultiValueFeatureTestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(MultiValueFeatureTestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    MultiValueFeatureTestLanguagePackageImpl theMultiValueFeatureTestLanguagePackage = (MultiValueFeatureTestLanguagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof MultiValueFeatureTestLanguagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new MultiValueFeatureTestLanguagePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theMultiValueFeatureTestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theMultiValueFeatureTestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMultiValueFeatureTestLanguagePackage.freeze();

    return theMultiValueFeatureTestLanguagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStart()
  {
    return startEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStart_FeatureA()
  {
    return (EAttribute)startEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiValueFeatureTestLanguageFactory getMultiValueFeatureTestLanguageFactory()
  {
    return (MultiValueFeatureTestLanguageFactory)getEFactoryInstance();
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
    startEClass = createEClass(START);
    createEAttribute(startEClass, START__FEATURE_A);
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
    initEClass(startEClass, Start.class, "Start", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStart_FeatureA(), ecorePackage.getEString(), "featureA", null, 0, -1, Start.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //MultiValueFeatureTestLanguagePackageImpl
