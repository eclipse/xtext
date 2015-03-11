/**
 */
package org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.AbstractRule;
import org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.AbstractRuleCall;
import org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.ContentAssistTestLanguageFactory;
import org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.ContentAssistTestLanguagePackage;
import org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.FirstAbstractRuleChild;
import org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.SecondAbstractRuleChild;
import org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.Start;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContentAssistTestLanguagePackageImpl extends EPackageImpl implements ContentAssistTestLanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass startEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass firstAbstractRuleChildEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass secondAbstractRuleChildEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractRuleCallEClass = null;

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
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.ContentAssistTestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ContentAssistTestLanguagePackageImpl()
  {
    super(eNS_URI, ContentAssistTestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ContentAssistTestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ContentAssistTestLanguagePackage init()
  {
    if (isInited) return (ContentAssistTestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(ContentAssistTestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    ContentAssistTestLanguagePackageImpl theContentAssistTestLanguagePackage = (ContentAssistTestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ContentAssistTestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ContentAssistTestLanguagePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theContentAssistTestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theContentAssistTestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theContentAssistTestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ContentAssistTestLanguagePackage.eNS_URI, theContentAssistTestLanguagePackage);
    return theContentAssistTestLanguagePackage;
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
  public EReference getStart_Rules()
  {
    return (EReference)startEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractRule()
  {
    return abstractRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractRule_Name()
  {
    return (EAttribute)abstractRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFirstAbstractRuleChild()
  {
    return firstAbstractRuleChildEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFirstAbstractRuleChild_Elements()
  {
    return (EReference)firstAbstractRuleChildEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSecondAbstractRuleChild()
  {
    return secondAbstractRuleChildEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSecondAbstractRuleChild_Rule()
  {
    return (EReference)secondAbstractRuleChildEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractRuleCall()
  {
    return abstractRuleCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractRuleCall_Rule()
  {
    return (EReference)abstractRuleCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContentAssistTestLanguageFactory getContentAssistTestLanguageFactory()
  {
    return (ContentAssistTestLanguageFactory)getEFactoryInstance();
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
    createEReference(startEClass, START__RULES);

    abstractRuleEClass = createEClass(ABSTRACT_RULE);
    createEAttribute(abstractRuleEClass, ABSTRACT_RULE__NAME);

    firstAbstractRuleChildEClass = createEClass(FIRST_ABSTRACT_RULE_CHILD);
    createEReference(firstAbstractRuleChildEClass, FIRST_ABSTRACT_RULE_CHILD__ELEMENTS);

    secondAbstractRuleChildEClass = createEClass(SECOND_ABSTRACT_RULE_CHILD);
    createEReference(secondAbstractRuleChildEClass, SECOND_ABSTRACT_RULE_CHILD__RULE);

    abstractRuleCallEClass = createEClass(ABSTRACT_RULE_CALL);
    createEReference(abstractRuleCallEClass, ABSTRACT_RULE_CALL__RULE);
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
    firstAbstractRuleChildEClass.getESuperTypes().add(this.getAbstractRule());
    secondAbstractRuleChildEClass.getESuperTypes().add(this.getAbstractRule());

    // Initialize classes and features; add operations and parameters
    initEClass(startEClass, Start.class, "Start", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStart_Rules(), this.getAbstractRule(), null, "rules", null, 0, -1, Start.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractRuleEClass, AbstractRule.class, "AbstractRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractRule_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(firstAbstractRuleChildEClass, FirstAbstractRuleChild.class, "FirstAbstractRuleChild", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFirstAbstractRuleChild_Elements(), this.getAbstractRule(), null, "elements", null, 0, -1, FirstAbstractRuleChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(secondAbstractRuleChildEClass, SecondAbstractRuleChild.class, "SecondAbstractRuleChild", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSecondAbstractRuleChild_Rule(), this.getAbstractRuleCall(), null, "rule", null, 0, 1, SecondAbstractRuleChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractRuleCallEClass, AbstractRuleCall.class, "AbstractRuleCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractRuleCall_Rule(), this.getAbstractRule(), null, "rule", null, 0, 1, AbstractRuleCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ContentAssistTestLanguagePackageImpl
