/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug286935TestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug286935TestLanguage.Bug286935TestLanguageFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug286935TestLanguage.Bug286935TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug286935TestLanguage.State;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug286935TestLanguage.StateType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug286935TestLanguagePackageImpl extends EPackageImpl implements Bug286935TestLanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum stateTypeEEnum = null;

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
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug286935TestLanguage.Bug286935TestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Bug286935TestLanguagePackageImpl()
  {
    super(eNS_URI, Bug286935TestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link Bug286935TestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Bug286935TestLanguagePackage init()
  {
    if (isInited) return (Bug286935TestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(Bug286935TestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    Bug286935TestLanguagePackageImpl theBug286935TestLanguagePackage = (Bug286935TestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Bug286935TestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Bug286935TestLanguagePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theBug286935TestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theBug286935TestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBug286935TestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Bug286935TestLanguagePackage.eNS_URI, theBug286935TestLanguagePackage);
    return theBug286935TestLanguagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getState()
  {
    return stateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getState_IsInitial()
  {
    return (EAttribute)stateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getState_IsFinal()
  {
    return (EAttribute)stateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getState_StateKind()
  {
    return (EAttribute)stateEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getState_StateName()
  {
    return (EAttribute)stateEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getState_Label()
  {
    return (EAttribute)stateEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getStateType()
  {
    return stateTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug286935TestLanguageFactory getBug286935TestLanguageFactory()
  {
    return (Bug286935TestLanguageFactory)getEFactoryInstance();
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
    stateEClass = createEClass(STATE);
    createEAttribute(stateEClass, STATE__IS_INITIAL);
    createEAttribute(stateEClass, STATE__IS_FINAL);
    createEAttribute(stateEClass, STATE__STATE_KIND);
    createEAttribute(stateEClass, STATE__STATE_NAME);
    createEAttribute(stateEClass, STATE__LABEL);

    // Create enums
    stateTypeEEnum = createEEnum(STATE_TYPE);
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
    initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getState_IsInitial(), ecorePackage.getEBoolean(), "isInitial", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getState_IsFinal(), ecorePackage.getEBoolean(), "isFinal", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getState_StateKind(), this.getStateType(), "stateKind", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getState_StateName(), ecorePackage.getEString(), "stateName", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getState_Label(), ecorePackage.getEString(), "label", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(stateTypeEEnum, StateType.class, "StateType");
    addEEnumLiteral(stateTypeEEnum, StateType.NORMAL);
    addEEnumLiteral(stateTypeEEnum, StateType.PSEUDO);
    addEEnumLiteral(stateTypeEEnum, StateType.REFERENCE);
    addEEnumLiteral(stateTypeEEnum, StateType.TEXTUAL);

    // Create resource
    createResource(eNS_URI);
  }

} //Bug286935TestLanguagePackageImpl
