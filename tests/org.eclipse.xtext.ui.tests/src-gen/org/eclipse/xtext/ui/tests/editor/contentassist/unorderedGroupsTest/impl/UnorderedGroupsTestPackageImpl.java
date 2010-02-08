/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.GroupLoopedModel;
import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.LoopedModel;
import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.MandatoryModel;
import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.SimpleModel;
import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnorderedGroupsTestPackageImpl extends EPackageImpl implements UnorderedGroupsTestPackage
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
  private EClass simpleModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mandatoryModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass loopedModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass groupLoopedModelEClass = null;

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
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private UnorderedGroupsTestPackageImpl()
  {
    super(eNS_URI, UnorderedGroupsTestFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link UnorderedGroupsTestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static UnorderedGroupsTestPackage init()
  {
    if (isInited) return (UnorderedGroupsTestPackage)EPackage.Registry.INSTANCE.getEPackage(UnorderedGroupsTestPackage.eNS_URI);

    // Obtain or create and register package
    UnorderedGroupsTestPackageImpl theUnorderedGroupsTestPackage = (UnorderedGroupsTestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UnorderedGroupsTestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UnorderedGroupsTestPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theUnorderedGroupsTestPackage.createPackageContents();

    // Initialize created meta-data
    theUnorderedGroupsTestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theUnorderedGroupsTestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(UnorderedGroupsTestPackage.eNS_URI, theUnorderedGroupsTestPackage);
    return theUnorderedGroupsTestPackage;
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
  public EReference getModel_First()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Second()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Thrird()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Forth()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleModel()
  {
    return simpleModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleModel_Visibility()
  {
    return (EAttribute)simpleModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleModel_Static()
  {
    return (EAttribute)simpleModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleModel_Synchronized()
  {
    return (EAttribute)simpleModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleModel_Abstract()
  {
    return (EAttribute)simpleModelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleModel_Final()
  {
    return (EAttribute)simpleModelEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleModel_Name()
  {
    return (EAttribute)simpleModelEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMandatoryModel()
  {
    return mandatoryModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMandatoryModel_Visibility()
  {
    return (EAttribute)mandatoryModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMandatoryModel_Static()
  {
    return (EAttribute)mandatoryModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMandatoryModel_Synchronized()
  {
    return (EAttribute)mandatoryModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMandatoryModel_Abstract()
  {
    return (EAttribute)mandatoryModelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMandatoryModel_Final()
  {
    return (EAttribute)mandatoryModelEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMandatoryModel_Name()
  {
    return (EAttribute)mandatoryModelEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLoopedModel()
  {
    return loopedModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoopedModel_Visibility()
  {
    return (EAttribute)loopedModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoopedModel_Static()
  {
    return (EAttribute)loopedModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoopedModel_Synchronized()
  {
    return (EAttribute)loopedModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoopedModel_Abstract()
  {
    return (EAttribute)loopedModelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoopedModel_Final()
  {
    return (EAttribute)loopedModelEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoopedModel_Name()
  {
    return (EAttribute)loopedModelEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGroupLoopedModel()
  {
    return groupLoopedModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGroupLoopedModel_Visibility()
  {
    return (EAttribute)groupLoopedModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGroupLoopedModel_Static()
  {
    return (EAttribute)groupLoopedModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGroupLoopedModel_Synchronized()
  {
    return (EAttribute)groupLoopedModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGroupLoopedModel_Abstract()
  {
    return (EAttribute)groupLoopedModelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGroupLoopedModel_Final()
  {
    return (EAttribute)groupLoopedModelEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGroupLoopedModel_Name()
  {
    return (EAttribute)groupLoopedModelEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroupsTestFactory getUnorderedGroupsTestFactory()
  {
    return (UnorderedGroupsTestFactory)getEFactoryInstance();
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
    createEReference(modelEClass, MODEL__FIRST);
    createEReference(modelEClass, MODEL__SECOND);
    createEReference(modelEClass, MODEL__THRIRD);
    createEReference(modelEClass, MODEL__FORTH);

    simpleModelEClass = createEClass(SIMPLE_MODEL);
    createEAttribute(simpleModelEClass, SIMPLE_MODEL__VISIBILITY);
    createEAttribute(simpleModelEClass, SIMPLE_MODEL__STATIC);
    createEAttribute(simpleModelEClass, SIMPLE_MODEL__SYNCHRONIZED);
    createEAttribute(simpleModelEClass, SIMPLE_MODEL__ABSTRACT);
    createEAttribute(simpleModelEClass, SIMPLE_MODEL__FINAL);
    createEAttribute(simpleModelEClass, SIMPLE_MODEL__NAME);

    mandatoryModelEClass = createEClass(MANDATORY_MODEL);
    createEAttribute(mandatoryModelEClass, MANDATORY_MODEL__VISIBILITY);
    createEAttribute(mandatoryModelEClass, MANDATORY_MODEL__STATIC);
    createEAttribute(mandatoryModelEClass, MANDATORY_MODEL__SYNCHRONIZED);
    createEAttribute(mandatoryModelEClass, MANDATORY_MODEL__ABSTRACT);
    createEAttribute(mandatoryModelEClass, MANDATORY_MODEL__FINAL);
    createEAttribute(mandatoryModelEClass, MANDATORY_MODEL__NAME);

    loopedModelEClass = createEClass(LOOPED_MODEL);
    createEAttribute(loopedModelEClass, LOOPED_MODEL__VISIBILITY);
    createEAttribute(loopedModelEClass, LOOPED_MODEL__STATIC);
    createEAttribute(loopedModelEClass, LOOPED_MODEL__SYNCHRONIZED);
    createEAttribute(loopedModelEClass, LOOPED_MODEL__ABSTRACT);
    createEAttribute(loopedModelEClass, LOOPED_MODEL__FINAL);
    createEAttribute(loopedModelEClass, LOOPED_MODEL__NAME);

    groupLoopedModelEClass = createEClass(GROUP_LOOPED_MODEL);
    createEAttribute(groupLoopedModelEClass, GROUP_LOOPED_MODEL__VISIBILITY);
    createEAttribute(groupLoopedModelEClass, GROUP_LOOPED_MODEL__STATIC);
    createEAttribute(groupLoopedModelEClass, GROUP_LOOPED_MODEL__SYNCHRONIZED);
    createEAttribute(groupLoopedModelEClass, GROUP_LOOPED_MODEL__ABSTRACT);
    createEAttribute(groupLoopedModelEClass, GROUP_LOOPED_MODEL__FINAL);
    createEAttribute(groupLoopedModelEClass, GROUP_LOOPED_MODEL__NAME);
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
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_First(), this.getSimpleModel(), null, "first", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_Second(), this.getMandatoryModel(), null, "second", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_Thrird(), this.getLoopedModel(), null, "thrird", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_Forth(), this.getGroupLoopedModel(), null, "forth", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleModelEClass, SimpleModel.class, "SimpleModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleModel_Visibility(), ecorePackage.getEString(), "visibility", null, 0, 1, SimpleModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleModel_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, SimpleModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleModel_Synchronized(), ecorePackage.getEBoolean(), "synchronized", null, 0, 1, SimpleModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleModel_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, SimpleModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleModel_Final(), ecorePackage.getEBoolean(), "final", null, 0, 1, SimpleModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, SimpleModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mandatoryModelEClass, MandatoryModel.class, "MandatoryModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMandatoryModel_Visibility(), ecorePackage.getEString(), "visibility", null, 0, 1, MandatoryModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMandatoryModel_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, MandatoryModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMandatoryModel_Synchronized(), ecorePackage.getEBoolean(), "synchronized", null, 0, 1, MandatoryModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMandatoryModel_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, MandatoryModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMandatoryModel_Final(), ecorePackage.getEBoolean(), "final", null, 0, 1, MandatoryModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMandatoryModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, MandatoryModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(loopedModelEClass, LoopedModel.class, "LoopedModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLoopedModel_Visibility(), ecorePackage.getEString(), "visibility", null, 0, -1, LoopedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoopedModel_Static(), ecorePackage.getEString(), "static", null, 0, -1, LoopedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoopedModel_Synchronized(), ecorePackage.getEString(), "synchronized", null, 0, -1, LoopedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoopedModel_Abstract(), ecorePackage.getEString(), "abstract", null, 0, -1, LoopedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoopedModel_Final(), ecorePackage.getEString(), "final", null, 0, -1, LoopedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoopedModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, LoopedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(groupLoopedModelEClass, GroupLoopedModel.class, "GroupLoopedModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGroupLoopedModel_Visibility(), ecorePackage.getEString(), "visibility", null, 0, -1, GroupLoopedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGroupLoopedModel_Static(), ecorePackage.getEString(), "static", null, 0, -1, GroupLoopedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGroupLoopedModel_Synchronized(), ecorePackage.getEString(), "synchronized", null, 0, -1, GroupLoopedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGroupLoopedModel_Abstract(), ecorePackage.getEString(), "abstract", null, 0, -1, GroupLoopedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGroupLoopedModel_Final(), ecorePackage.getEString(), "final", null, 0, -1, GroupLoopedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGroupLoopedModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, GroupLoopedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //UnorderedGroupsTestPackageImpl
