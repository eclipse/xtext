/**
 */
package org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.CaseInsensitiveKeywordRule;
import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.CommonTerminalsRule;
import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.DatatypeRule;
import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.Model;
import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.MultiRule;
import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.PluralRule;
import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.UnassignedtextFactory;
import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.UnassignedtextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnassignedtextPackageImpl extends EPackageImpl implements UnassignedtextPackage
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
  private EClass caseInsensitiveKeywordRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pluralRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass datatypeRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass commonTerminalsRuleEClass = null;

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
   * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.UnassignedtextPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private UnassignedtextPackageImpl()
  {
    super(eNS_URI, UnassignedtextFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link UnassignedtextPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static UnassignedtextPackage init()
  {
    if (isInited) return (UnassignedtextPackage)EPackage.Registry.INSTANCE.getEPackage(UnassignedtextPackage.eNS_URI);

    // Obtain or create and register package
    UnassignedtextPackageImpl theUnassignedtextPackage = (UnassignedtextPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UnassignedtextPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UnassignedtextPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theUnassignedtextPackage.createPackageContents();

    // Initialize created meta-data
    theUnassignedtextPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theUnassignedtextPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(UnassignedtextPackage.eNS_URI, theUnassignedtextPackage);
    return theUnassignedtextPackage;
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
  public EClass getCaseInsensitiveKeywordRule()
  {
    return caseInsensitiveKeywordRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCaseInsensitiveKeywordRule_Val()
  {
    return (EAttribute)caseInsensitiveKeywordRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPluralRule()
  {
    return pluralRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPluralRule_Count()
  {
    return (EAttribute)pluralRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiRule()
  {
    return multiRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiRule_Val()
  {
    return (EAttribute)multiRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDatatypeRule()
  {
    return datatypeRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDatatypeRule_Val()
  {
    return (EAttribute)datatypeRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCommonTerminalsRule()
  {
    return commonTerminalsRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCommonTerminalsRule_Val()
  {
    return (EAttribute)commonTerminalsRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedtextFactory getUnassignedtextFactory()
  {
    return (UnassignedtextFactory)getEFactoryInstance();
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

    caseInsensitiveKeywordRuleEClass = createEClass(CASE_INSENSITIVE_KEYWORD_RULE);
    createEAttribute(caseInsensitiveKeywordRuleEClass, CASE_INSENSITIVE_KEYWORD_RULE__VAL);

    pluralRuleEClass = createEClass(PLURAL_RULE);
    createEAttribute(pluralRuleEClass, PLURAL_RULE__COUNT);

    multiRuleEClass = createEClass(MULTI_RULE);
    createEAttribute(multiRuleEClass, MULTI_RULE__VAL);

    datatypeRuleEClass = createEClass(DATATYPE_RULE);
    createEAttribute(datatypeRuleEClass, DATATYPE_RULE__VAL);

    commonTerminalsRuleEClass = createEClass(COMMON_TERMINALS_RULE);
    createEAttribute(commonTerminalsRuleEClass, COMMON_TERMINALS_RULE__VAL);
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
    caseInsensitiveKeywordRuleEClass.getESuperTypes().add(this.getModel());
    pluralRuleEClass.getESuperTypes().add(this.getModel());
    multiRuleEClass.getESuperTypes().add(this.getModel());
    datatypeRuleEClass.getESuperTypes().add(this.getModel());
    commonTerminalsRuleEClass.getESuperTypes().add(this.getModel());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(caseInsensitiveKeywordRuleEClass, CaseInsensitiveKeywordRule.class, "CaseInsensitiveKeywordRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCaseInsensitiveKeywordRule_Val(), theEcorePackage.getEInt(), "val", null, 0, 1, CaseInsensitiveKeywordRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pluralRuleEClass, PluralRule.class, "PluralRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPluralRule_Count(), theEcorePackage.getEInt(), "count", null, 0, 1, PluralRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiRuleEClass, MultiRule.class, "MultiRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMultiRule_Val(), theEcorePackage.getEInt(), "val", null, 0, 1, MultiRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(datatypeRuleEClass, DatatypeRule.class, "DatatypeRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDatatypeRule_Val(), theEcorePackage.getEInt(), "val", null, 0, 1, DatatypeRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(commonTerminalsRuleEClass, CommonTerminalsRule.class, "CommonTerminalsRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCommonTerminalsRule_Val(), theEcorePackage.getEString(), "val", null, 0, 1, CommonTerminalsRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //UnassignedtextPackageImpl
