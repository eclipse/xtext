/**
 */
package org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.AbstractBar;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Bar;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.EObjectAtOffsetTestLanguageFactory;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.EObjectAtOffsetTestLanguagePackage;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Foo;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.FooBar;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Model;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EObjectAtOffsetTestLanguagePackageImpl extends EPackageImpl implements EObjectAtOffsetTestLanguagePackage
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
  private EClass abstractBarEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass barEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fooEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fooBarEClass = null;

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
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.EObjectAtOffsetTestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private EObjectAtOffsetTestLanguagePackageImpl()
  {
    super(eNS_URI, EObjectAtOffsetTestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link EObjectAtOffsetTestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static EObjectAtOffsetTestLanguagePackage init()
  {
    if (isInited) return (EObjectAtOffsetTestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(EObjectAtOffsetTestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    EObjectAtOffsetTestLanguagePackageImpl theEObjectAtOffsetTestLanguagePackage = (EObjectAtOffsetTestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EObjectAtOffsetTestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EObjectAtOffsetTestLanguagePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theEObjectAtOffsetTestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theEObjectAtOffsetTestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theEObjectAtOffsetTestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(EObjectAtOffsetTestLanguagePackage.eNS_URI, theEObjectAtOffsetTestLanguagePackage);
    return theEObjectAtOffsetTestLanguagePackage;
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
  public EReference getModel_Foos()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Bars()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractBar()
  {
    return abstractBarEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractBar_Foo()
  {
    return (EReference)abstractBarEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBar()
  {
    return barEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBar_Name()
  {
    return (EAttribute)barEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFoo()
  {
    return fooEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFoo_Name()
  {
    return (EAttribute)fooEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFooBar()
  {
    return fooBarEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFooBar_Bar()
  {
    return (EReference)fooBarEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObjectAtOffsetTestLanguageFactory getEObjectAtOffsetTestLanguageFactory()
  {
    return (EObjectAtOffsetTestLanguageFactory)getEFactoryInstance();
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
    createEReference(modelEClass, MODEL__FOOS);
    createEReference(modelEClass, MODEL__BARS);

    abstractBarEClass = createEClass(ABSTRACT_BAR);
    createEReference(abstractBarEClass, ABSTRACT_BAR__FOO);

    barEClass = createEClass(BAR);
    createEAttribute(barEClass, BAR__NAME);

    fooEClass = createEClass(FOO);
    createEAttribute(fooEClass, FOO__NAME);

    fooBarEClass = createEClass(FOO_BAR);
    createEReference(fooBarEClass, FOO_BAR__BAR);
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
    barEClass.getESuperTypes().add(this.getAbstractBar());
    fooBarEClass.getESuperTypes().add(this.getAbstractBar());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Foos(), this.getFoo(), null, "foos", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_Bars(), this.getAbstractBar(), null, "bars", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractBarEClass, AbstractBar.class, "AbstractBar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractBar_Foo(), this.getFoo(), null, "foo", null, 0, -1, AbstractBar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(barEClass, Bar.class, "Bar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBar_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Bar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fooEClass, Foo.class, "Foo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFoo_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Foo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fooBarEClass, FooBar.class, "FooBar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFooBar_Bar(), this.getBar(), null, "bar", null, 0, 1, FooBar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //EObjectAtOffsetTestLanguagePackageImpl
