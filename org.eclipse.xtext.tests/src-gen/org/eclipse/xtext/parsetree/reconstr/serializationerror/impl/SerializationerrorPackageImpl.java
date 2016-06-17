/**
 */
package org.eclipse.xtext.parsetree.reconstr.serializationerror.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.Model;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.SerializationerrorFactory;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.SerializationerrorPackage;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.Test;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoOptions;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoRequired;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SerializationerrorPackageImpl extends EPackageImpl implements SerializationerrorPackage
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
  private EClass testEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass twoRequiredEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass twoOptionsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass indentEClass = null;

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
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.SerializationerrorPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private SerializationerrorPackageImpl()
  {
    super(eNS_URI, SerializationerrorFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link SerializationerrorPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static SerializationerrorPackage init()
  {
    if (isInited) return (SerializationerrorPackage)EPackage.Registry.INSTANCE.getEPackage(SerializationerrorPackage.eNS_URI);

    // Obtain or create and register package
    SerializationerrorPackageImpl theSerializationerrorPackage = (SerializationerrorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SerializationerrorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SerializationerrorPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theSerializationerrorPackage.createPackageContents();

    // Initialize created meta-data
    theSerializationerrorPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSerializationerrorPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(SerializationerrorPackage.eNS_URI, theSerializationerrorPackage);
    return theSerializationerrorPackage;
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
  public EReference getModel_Test()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTest()
  {
    return testEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTwoRequired()
  {
    return twoRequiredEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTwoRequired_One()
  {
    return (EAttribute)twoRequiredEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTwoRequired_Two()
  {
    return (EAttribute)twoRequiredEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTwoOptions()
  {
    return twoOptionsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTwoOptions_One()
  {
    return (EAttribute)twoOptionsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTwoOptions_Two()
  {
    return (EAttribute)twoOptionsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIndent()
  {
    return indentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIndent_Req()
  {
    return (EReference)indentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIndent_Opt()
  {
    return (EReference)indentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIndent_Indent()
  {
    return (EReference)indentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SerializationerrorFactory getSerializationerrorFactory()
  {
    return (SerializationerrorFactory)getEFactoryInstance();
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
    createEReference(modelEClass, MODEL__TEST);

    testEClass = createEClass(TEST);

    twoRequiredEClass = createEClass(TWO_REQUIRED);
    createEAttribute(twoRequiredEClass, TWO_REQUIRED__ONE);
    createEAttribute(twoRequiredEClass, TWO_REQUIRED__TWO);

    twoOptionsEClass = createEClass(TWO_OPTIONS);
    createEAttribute(twoOptionsEClass, TWO_OPTIONS__ONE);
    createEAttribute(twoOptionsEClass, TWO_OPTIONS__TWO);

    indentEClass = createEClass(INDENT);
    createEReference(indentEClass, INDENT__REQ);
    createEReference(indentEClass, INDENT__OPT);
    createEReference(indentEClass, INDENT__INDENT);
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
    twoRequiredEClass.getESuperTypes().add(this.getTest());
    twoOptionsEClass.getESuperTypes().add(this.getTest());
    indentEClass.getESuperTypes().add(this.getTest());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Test(), this.getTest(), null, "test", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(testEClass, Test.class, "Test", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(twoRequiredEClass, TwoRequired.class, "TwoRequired", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTwoRequired_One(), theEcorePackage.getEString(), "one", null, 0, 1, TwoRequired.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTwoRequired_Two(), theEcorePackage.getEString(), "two", null, 0, 1, TwoRequired.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(twoOptionsEClass, TwoOptions.class, "TwoOptions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTwoOptions_One(), theEcorePackage.getEString(), "one", null, 0, 1, TwoOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTwoOptions_Two(), theEcorePackage.getEString(), "two", null, 0, 1, TwoOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(indentEClass, Indent.class, "Indent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIndent_Req(), this.getTwoRequired(), null, "req", null, 0, 1, Indent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIndent_Opt(), this.getTwoOptions(), null, "opt", null, 0, 1, Indent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIndent_Indent(), this.getIndent(), null, "indent", null, 0, -1, Indent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //SerializationerrorPackageImpl
