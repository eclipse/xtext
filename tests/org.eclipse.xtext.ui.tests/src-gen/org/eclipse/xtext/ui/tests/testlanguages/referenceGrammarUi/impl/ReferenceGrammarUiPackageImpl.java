/**
 */
package org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Erwachsener;
import org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Familie;
import org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Farbe;
import org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Kind;
import org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Person;
import org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.ReferenceGrammarUiFactory;
import org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.ReferenceGrammarUiPackage;
import org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz;
import org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielzeug;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReferenceGrammarUiPackageImpl extends EPackageImpl implements ReferenceGrammarUiPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass spielplatzEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass personEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass kindEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass erwachsenerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass spielzeugEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass farbeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass familieEClass = null;

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
   * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.ReferenceGrammarUiPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ReferenceGrammarUiPackageImpl()
  {
    super(eNS_URI, ReferenceGrammarUiFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ReferenceGrammarUiPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ReferenceGrammarUiPackage init()
  {
    if (isInited) return (ReferenceGrammarUiPackage)EPackage.Registry.INSTANCE.getEPackage(ReferenceGrammarUiPackage.eNS_URI);

    // Obtain or create and register package
    ReferenceGrammarUiPackageImpl theReferenceGrammarUiPackage = (ReferenceGrammarUiPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ReferenceGrammarUiPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ReferenceGrammarUiPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theReferenceGrammarUiPackage.createPackageContents();

    // Initialize created meta-data
    theReferenceGrammarUiPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theReferenceGrammarUiPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ReferenceGrammarUiPackage.eNS_URI, theReferenceGrammarUiPackage);
    return theReferenceGrammarUiPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSpielplatz()
  {
    return spielplatzEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpielplatz_Groesse()
  {
    return (EAttribute)spielplatzEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpielplatz_Beschreibung()
  {
    return (EAttribute)spielplatzEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpielplatz_Kinder()
  {
    return (EReference)spielplatzEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpielplatz_Erzieher()
  {
    return (EReference)spielplatzEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpielplatz_Spielzeuge()
  {
    return (EReference)spielplatzEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpielplatz_Familie()
  {
    return (EReference)spielplatzEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPerson()
  {
    return personEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPerson_Name()
  {
    return (EAttribute)personEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPerson_Age()
  {
    return (EAttribute)personEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getKind()
  {
    return kindEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErwachsener()
  {
    return erwachsenerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSpielzeug()
  {
    return spielzeugEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpielzeug_Name()
  {
    return (EAttribute)spielzeugEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpielzeug_Farbe()
  {
    return (EReference)spielzeugEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFarbe()
  {
    return farbeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFarbe_Wert()
  {
    return (EAttribute)farbeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFamilie()
  {
    return familieEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFamilie_Name()
  {
    return (EAttribute)familieEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFamilie_Mutter()
  {
    return (EReference)familieEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFamilie_Vater()
  {
    return (EReference)familieEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFamilie_Kinder()
  {
    return (EReference)familieEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceGrammarUiFactory getReferenceGrammarUiFactory()
  {
    return (ReferenceGrammarUiFactory)getEFactoryInstance();
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
    spielplatzEClass = createEClass(SPIELPLATZ);
    createEAttribute(spielplatzEClass, SPIELPLATZ__GROESSE);
    createEAttribute(spielplatzEClass, SPIELPLATZ__BESCHREIBUNG);
    createEReference(spielplatzEClass, SPIELPLATZ__KINDER);
    createEReference(spielplatzEClass, SPIELPLATZ__ERZIEHER);
    createEReference(spielplatzEClass, SPIELPLATZ__SPIELZEUGE);
    createEReference(spielplatzEClass, SPIELPLATZ__FAMILIE);

    personEClass = createEClass(PERSON);
    createEAttribute(personEClass, PERSON__NAME);
    createEAttribute(personEClass, PERSON__AGE);

    kindEClass = createEClass(KIND);

    erwachsenerEClass = createEClass(ERWACHSENER);

    spielzeugEClass = createEClass(SPIELZEUG);
    createEAttribute(spielzeugEClass, SPIELZEUG__NAME);
    createEReference(spielzeugEClass, SPIELZEUG__FARBE);

    farbeEClass = createEClass(FARBE);
    createEAttribute(farbeEClass, FARBE__WERT);

    familieEClass = createEClass(FAMILIE);
    createEAttribute(familieEClass, FAMILIE__NAME);
    createEReference(familieEClass, FAMILIE__MUTTER);
    createEReference(familieEClass, FAMILIE__VATER);
    createEReference(familieEClass, FAMILIE__KINDER);
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
    kindEClass.getESuperTypes().add(this.getPerson());
    erwachsenerEClass.getESuperTypes().add(this.getPerson());

    // Initialize classes and features; add operations and parameters
    initEClass(spielplatzEClass, Spielplatz.class, "Spielplatz", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSpielplatz_Groesse(), ecorePackage.getEInt(), "groesse", null, 0, 1, Spielplatz.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSpielplatz_Beschreibung(), ecorePackage.getEString(), "beschreibung", null, 0, 1, Spielplatz.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSpielplatz_Kinder(), this.getKind(), null, "kinder", null, 0, -1, Spielplatz.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSpielplatz_Erzieher(), this.getErwachsener(), null, "erzieher", null, 0, -1, Spielplatz.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSpielplatz_Spielzeuge(), this.getSpielzeug(), null, "spielzeuge", null, 0, -1, Spielplatz.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSpielplatz_Familie(), this.getFamilie(), null, "familie", null, 0, -1, Spielplatz.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(personEClass, Person.class, "Person", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPerson_Name(), ecorePackage.getEString(), "name", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPerson_Age(), ecorePackage.getEInt(), "age", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(kindEClass, Kind.class, "Kind", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(erwachsenerEClass, Erwachsener.class, "Erwachsener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(spielzeugEClass, Spielzeug.class, "Spielzeug", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSpielzeug_Name(), ecorePackage.getEString(), "name", null, 0, 1, Spielzeug.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSpielzeug_Farbe(), this.getFarbe(), null, "farbe", null, 0, 1, Spielzeug.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(farbeEClass, Farbe.class, "Farbe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFarbe_Wert(), ecorePackage.getEString(), "wert", null, 0, 1, Farbe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(familieEClass, Familie.class, "Familie", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFamilie_Name(), ecorePackage.getEString(), "name", null, 0, 1, Familie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFamilie_Mutter(), this.getErwachsener(), null, "mutter", null, 0, 1, Familie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFamilie_Vater(), this.getErwachsener(), null, "vater", null, 0, 1, Familie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFamilie_Kinder(), this.getKind(), null, "kinder", null, 0, -1, Familie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ReferenceGrammarUiPackageImpl
