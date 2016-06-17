/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ContentAssistContextTestFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.FirstLevel;
import org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.SecondLevelA;
import org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.SecondLevelB;
import org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ThirdLevelA1;
import org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ThirdLevelA2;
import org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ThirdLevelB1;
import org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ThirdLevelB2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContentAssistContextTestPackageImpl extends EPackageImpl implements ContentAssistContextTestPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass firstLevelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass secondLevelAEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass secondLevelBEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass thirdLevelA1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass thirdLevelA2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass thirdLevelB1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass thirdLevelB2EClass = null;

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
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ContentAssistContextTestPackageImpl()
  {
    super(eNS_URI, ContentAssistContextTestFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ContentAssistContextTestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ContentAssistContextTestPackage init()
  {
    if (isInited) return (ContentAssistContextTestPackage)EPackage.Registry.INSTANCE.getEPackage(ContentAssistContextTestPackage.eNS_URI);

    // Obtain or create and register package
    ContentAssistContextTestPackageImpl theContentAssistContextTestPackage = (ContentAssistContextTestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ContentAssistContextTestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ContentAssistContextTestPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theContentAssistContextTestPackage.createPackageContents();

    // Initialize created meta-data
    theContentAssistContextTestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theContentAssistContextTestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ContentAssistContextTestPackage.eNS_URI, theContentAssistContextTestPackage);
    return theContentAssistContextTestPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFirstLevel()
  {
    return firstLevelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFirstLevel_SecondLevelA()
  {
    return (EReference)firstLevelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFirstLevel_SecondLevelB()
  {
    return (EReference)firstLevelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSecondLevelA()
  {
    return secondLevelAEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSecondLevelA_ThirdLevelA1()
  {
    return (EReference)secondLevelAEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSecondLevelA_ThirdLevelA2()
  {
    return (EReference)secondLevelAEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSecondLevelB()
  {
    return secondLevelBEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSecondLevelB_ThirdLevelB1()
  {
    return (EReference)secondLevelBEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSecondLevelB_ThirdLevelB2()
  {
    return (EReference)secondLevelBEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThirdLevelA1()
  {
    return thirdLevelA1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getThirdLevelA1_Name()
  {
    return (EAttribute)thirdLevelA1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThirdLevelA2()
  {
    return thirdLevelA2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getThirdLevelA2_Name()
  {
    return (EAttribute)thirdLevelA2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThirdLevelB1()
  {
    return thirdLevelB1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getThirdLevelB1_Name()
  {
    return (EAttribute)thirdLevelB1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThirdLevelB2()
  {
    return thirdLevelB2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getThirdLevelB2_Name()
  {
    return (EAttribute)thirdLevelB2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContentAssistContextTestFactory getContentAssistContextTestFactory()
  {
    return (ContentAssistContextTestFactory)getEFactoryInstance();
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
    firstLevelEClass = createEClass(FIRST_LEVEL);
    createEReference(firstLevelEClass, FIRST_LEVEL__SECOND_LEVEL_A);
    createEReference(firstLevelEClass, FIRST_LEVEL__SECOND_LEVEL_B);

    secondLevelAEClass = createEClass(SECOND_LEVEL_A);
    createEReference(secondLevelAEClass, SECOND_LEVEL_A__THIRD_LEVEL_A1);
    createEReference(secondLevelAEClass, SECOND_LEVEL_A__THIRD_LEVEL_A2);

    secondLevelBEClass = createEClass(SECOND_LEVEL_B);
    createEReference(secondLevelBEClass, SECOND_LEVEL_B__THIRD_LEVEL_B1);
    createEReference(secondLevelBEClass, SECOND_LEVEL_B__THIRD_LEVEL_B2);

    thirdLevelA1EClass = createEClass(THIRD_LEVEL_A1);
    createEAttribute(thirdLevelA1EClass, THIRD_LEVEL_A1__NAME);

    thirdLevelA2EClass = createEClass(THIRD_LEVEL_A2);
    createEAttribute(thirdLevelA2EClass, THIRD_LEVEL_A2__NAME);

    thirdLevelB1EClass = createEClass(THIRD_LEVEL_B1);
    createEAttribute(thirdLevelB1EClass, THIRD_LEVEL_B1__NAME);

    thirdLevelB2EClass = createEClass(THIRD_LEVEL_B2);
    createEAttribute(thirdLevelB2EClass, THIRD_LEVEL_B2__NAME);
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
    initEClass(firstLevelEClass, FirstLevel.class, "FirstLevel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFirstLevel_SecondLevelA(), this.getSecondLevelA(), null, "secondLevelA", null, 0, -1, FirstLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFirstLevel_SecondLevelB(), this.getSecondLevelB(), null, "secondLevelB", null, 0, -1, FirstLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(secondLevelAEClass, SecondLevelA.class, "SecondLevelA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSecondLevelA_ThirdLevelA1(), this.getThirdLevelA1(), null, "thirdLevelA1", null, 0, -1, SecondLevelA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSecondLevelA_ThirdLevelA2(), this.getThirdLevelA2(), null, "thirdLevelA2", null, 0, -1, SecondLevelA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(secondLevelBEClass, SecondLevelB.class, "SecondLevelB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSecondLevelB_ThirdLevelB1(), this.getThirdLevelB1(), null, "thirdLevelB1", null, 0, -1, SecondLevelB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSecondLevelB_ThirdLevelB2(), this.getThirdLevelB2(), null, "thirdLevelB2", null, 0, -1, SecondLevelB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(thirdLevelA1EClass, ThirdLevelA1.class, "ThirdLevelA1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getThirdLevelA1_Name(), ecorePackage.getEString(), "name", null, 0, 1, ThirdLevelA1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(thirdLevelA2EClass, ThirdLevelA2.class, "ThirdLevelA2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getThirdLevelA2_Name(), ecorePackage.getEString(), "name", null, 0, 1, ThirdLevelA2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(thirdLevelB1EClass, ThirdLevelB1.class, "ThirdLevelB1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getThirdLevelB1_Name(), ecorePackage.getEString(), "name", null, 0, 1, ThirdLevelB1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(thirdLevelB2EClass, ThirdLevelB2.class, "ThirdLevelB2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getThirdLevelB2_Name(), ecorePackage.getEString(), "name", null, 0, 1, ThirdLevelB2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ContentAssistContextTestPackageImpl
