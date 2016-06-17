/**
 */
package org.eclipse.xtext.testlanguages.testLang.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.testlanguages.testLang.AbstractElement;
import org.eclipse.xtext.testlanguages.testLang.ChoiceElement;
import org.eclipse.xtext.testlanguages.testLang.Model;
import org.eclipse.xtext.testlanguages.testLang.ReducibleComposite;
import org.eclipse.xtext.testlanguages.testLang.ReducibleElement;
import org.eclipse.xtext.testlanguages.testLang.TerminalElement;
import org.eclipse.xtext.testlanguages.testLang.TestLangFactory;
import org.eclipse.xtext.testlanguages.testLang.TestLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestLangPackageImpl extends EPackageImpl implements TestLangPackage
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
  private EClass abstractElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass choiceElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reducibleElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass terminalElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reducibleCompositeEClass = null;

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
   * @see org.eclipse.xtext.testlanguages.testLang.TestLangPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TestLangPackageImpl()
  {
    super(eNS_URI, TestLangFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link TestLangPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TestLangPackage init()
  {
    if (isInited) return (TestLangPackage)EPackage.Registry.INSTANCE.getEPackage(TestLangPackage.eNS_URI);

    // Obtain or create and register package
    TestLangPackageImpl theTestLangPackage = (TestLangPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TestLangPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TestLangPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theTestLangPackage.createPackageContents();

    // Initialize created meta-data
    theTestLangPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTestLangPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TestLangPackage.eNS_URI, theTestLangPackage);
    return theTestLangPackage;
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
  public EReference getModel_MultiFeature()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractElement()
  {
    return abstractElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getChoiceElement()
  {
    return choiceElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getChoiceElement_OptionalKeyword()
  {
    return (EAttribute)choiceElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getChoiceElement_Name()
  {
    return (EAttribute)choiceElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReducibleElement()
  {
    return reducibleElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTerminalElement()
  {
    return terminalElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTerminalElement_StringFeature()
  {
    return (EAttribute)terminalElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReducibleComposite()
  {
    return reducibleCompositeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReducibleComposite_ActionFeature()
  {
    return (EReference)reducibleCompositeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestLangFactory getTestLangFactory()
  {
    return (TestLangFactory)getEFactoryInstance();
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
    createEReference(modelEClass, MODEL__MULTI_FEATURE);

    abstractElementEClass = createEClass(ABSTRACT_ELEMENT);

    choiceElementEClass = createEClass(CHOICE_ELEMENT);
    createEAttribute(choiceElementEClass, CHOICE_ELEMENT__OPTIONAL_KEYWORD);
    createEAttribute(choiceElementEClass, CHOICE_ELEMENT__NAME);

    reducibleElementEClass = createEClass(REDUCIBLE_ELEMENT);

    terminalElementEClass = createEClass(TERMINAL_ELEMENT);
    createEAttribute(terminalElementEClass, TERMINAL_ELEMENT__STRING_FEATURE);

    reducibleCompositeEClass = createEClass(REDUCIBLE_COMPOSITE);
    createEReference(reducibleCompositeEClass, REDUCIBLE_COMPOSITE__ACTION_FEATURE);
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
    choiceElementEClass.getESuperTypes().add(this.getAbstractElement());
    reducibleElementEClass.getESuperTypes().add(this.getAbstractElement());
    terminalElementEClass.getESuperTypes().add(this.getReducibleElement());
    reducibleCompositeEClass.getESuperTypes().add(this.getReducibleElement());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_MultiFeature(), this.getAbstractElement(), null, "multiFeature", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractElementEClass, AbstractElement.class, "AbstractElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(choiceElementEClass, ChoiceElement.class, "ChoiceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getChoiceElement_OptionalKeyword(), theEcorePackage.getEBoolean(), "optionalKeyword", null, 0, 1, ChoiceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getChoiceElement_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ChoiceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reducibleElementEClass, ReducibleElement.class, "ReducibleElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(terminalElementEClass, TerminalElement.class, "TerminalElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTerminalElement_StringFeature(), theEcorePackage.getEString(), "stringFeature", null, 0, 1, TerminalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reducibleCompositeEClass, ReducibleComposite.class, "ReducibleComposite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReducibleComposite_ActionFeature(), this.getTerminalElement(), null, "actionFeature", null, 0, -1, ReducibleComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //TestLangPackageImpl
