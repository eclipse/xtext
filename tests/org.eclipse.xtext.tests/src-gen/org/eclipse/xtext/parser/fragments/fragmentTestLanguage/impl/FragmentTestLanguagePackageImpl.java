/**
 */
package org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.FragmentTestLanguageFactory;
import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.FragmentTestLanguagePackage;
import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamed;
import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamedWithAction;
import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.ParserRuleFragments;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FragmentTestLanguagePackageImpl extends EPackageImpl implements FragmentTestLanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parserRuleFragmentsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass prfNamedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass prfNamedWithActionEClass = null;

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
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.FragmentTestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private FragmentTestLanguagePackageImpl()
  {
    super(eNS_URI, FragmentTestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link FragmentTestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static FragmentTestLanguagePackage init()
  {
    if (isInited) return (FragmentTestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(FragmentTestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    FragmentTestLanguagePackageImpl theFragmentTestLanguagePackage = (FragmentTestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FragmentTestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FragmentTestLanguagePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theFragmentTestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theFragmentTestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theFragmentTestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(FragmentTestLanguagePackage.eNS_URI, theFragmentTestLanguagePackage);
    return theFragmentTestLanguagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParserRuleFragments()
  {
    return parserRuleFragmentsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParserRuleFragments_Element()
  {
    return (EReference)parserRuleFragmentsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParserRuleFragments_Ref()
  {
    return (EReference)parserRuleFragmentsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPRFNamed()
  {
    return prfNamedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPRFNamed_Ref()
  {
    return (EReference)prfNamedEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPRFNamed_Name()
  {
    return (EAttribute)prfNamedEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPRFNamedWithAction()
  {
    return prfNamedWithActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPRFNamedWithAction_Prev()
  {
    return (EReference)prfNamedWithActionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPRFNamedWithAction_Ref2()
  {
    return (EReference)prfNamedWithActionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FragmentTestLanguageFactory getFragmentTestLanguageFactory()
  {
    return (FragmentTestLanguageFactory)getEFactoryInstance();
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
    parserRuleFragmentsEClass = createEClass(PARSER_RULE_FRAGMENTS);
    createEReference(parserRuleFragmentsEClass, PARSER_RULE_FRAGMENTS__ELEMENT);
    createEReference(parserRuleFragmentsEClass, PARSER_RULE_FRAGMENTS__REF);

    prfNamedEClass = createEClass(PRF_NAMED);
    createEReference(prfNamedEClass, PRF_NAMED__REF);
    createEAttribute(prfNamedEClass, PRF_NAMED__NAME);

    prfNamedWithActionEClass = createEClass(PRF_NAMED_WITH_ACTION);
    createEReference(prfNamedWithActionEClass, PRF_NAMED_WITH_ACTION__PREV);
    createEReference(prfNamedWithActionEClass, PRF_NAMED_WITH_ACTION__REF2);
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
    prfNamedWithActionEClass.getESuperTypes().add(this.getPRFNamed());

    // Initialize classes and features; add operations and parameters
    initEClass(parserRuleFragmentsEClass, ParserRuleFragments.class, "ParserRuleFragments", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParserRuleFragments_Element(), this.getPRFNamed(), null, "element", null, 0, 1, ParserRuleFragments.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParserRuleFragments_Ref(), this.getPRFNamed(), null, "ref", null, 0, 1, ParserRuleFragments.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(prfNamedEClass, PRFNamed.class, "PRFNamed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPRFNamed_Ref(), this.getPRFNamed(), null, "ref", null, 0, 1, PRFNamed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPRFNamed_Name(), theEcorePackage.getEString(), "name", null, 0, 1, PRFNamed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(prfNamedWithActionEClass, PRFNamedWithAction.class, "PRFNamedWithAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPRFNamedWithAction_Prev(), this.getPRFNamed(), null, "prev", null, 0, 1, PRFNamedWithAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPRFNamedWithAction_Ref2(), this.getPRFNamed(), null, "ref2", null, 0, 1, PRFNamedWithAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //FragmentTestLanguagePackageImpl
