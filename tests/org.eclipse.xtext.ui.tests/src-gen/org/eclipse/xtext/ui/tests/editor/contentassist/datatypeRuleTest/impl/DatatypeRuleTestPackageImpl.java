/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.CompositeType;
import org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.CompositeTypeEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.DatatypeRuleTestFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.DatatypeRuleTestPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.SimpleType;
import org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.Type;
import org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.Types;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DatatypeRuleTestPackageImpl extends EPackageImpl implements DatatypeRuleTestPackage
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
  private EClass typesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass compositeTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass compositeTypeEntryEClass = null;

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
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.DatatypeRuleTestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private DatatypeRuleTestPackageImpl()
  {
    super(eNS_URI, DatatypeRuleTestFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link DatatypeRuleTestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static DatatypeRuleTestPackage init()
  {
    if (isInited) return (DatatypeRuleTestPackage)EPackage.Registry.INSTANCE.getEPackage(DatatypeRuleTestPackage.eNS_URI);

    // Obtain or create and register package
    DatatypeRuleTestPackageImpl theDatatypeRuleTestPackage = (DatatypeRuleTestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DatatypeRuleTestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DatatypeRuleTestPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theDatatypeRuleTestPackage.createPackageContents();

    // Initialize created meta-data
    theDatatypeRuleTestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theDatatypeRuleTestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(DatatypeRuleTestPackage.eNS_URI, theDatatypeRuleTestPackage);
    return theDatatypeRuleTestPackage;
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
  public EClass getTypes()
  {
    return typesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypes_Types()
  {
    return (EReference)typesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType()
  {
    return typeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getType_Name()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleType()
  {
    return simpleTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCompositeType()
  {
    return compositeTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompositeType_BaseType()
  {
    return (EReference)compositeTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCompositeTypeEntry()
  {
    return compositeTypeEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompositeTypeEntry_DataType()
  {
    return (EReference)compositeTypeEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DatatypeRuleTestFactory getDatatypeRuleTestFactory()
  {
    return (DatatypeRuleTestFactory)getEFactoryInstance();
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

    typesEClass = createEClass(TYPES);
    createEReference(typesEClass, TYPES__TYPES);

    typeEClass = createEClass(TYPE);
    createEAttribute(typeEClass, TYPE__NAME);

    simpleTypeEClass = createEClass(SIMPLE_TYPE);

    compositeTypeEClass = createEClass(COMPOSITE_TYPE);
    createEReference(compositeTypeEClass, COMPOSITE_TYPE__BASE_TYPE);

    compositeTypeEntryEClass = createEClass(COMPOSITE_TYPE_ENTRY);
    createEReference(compositeTypeEntryEClass, COMPOSITE_TYPE_ENTRY__DATA_TYPE);
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
    typesEClass.getESuperTypes().add(this.getModel());
    simpleTypeEClass.getESuperTypes().add(this.getType());
    compositeTypeEClass.getESuperTypes().add(this.getType());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(typesEClass, Types.class, "Types", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypes_Types(), this.getType(), null, "types", null, 0, -1, Types.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getType_Name(), ecorePackage.getEString(), "name", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleTypeEClass, SimpleType.class, "SimpleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(compositeTypeEClass, CompositeType.class, "CompositeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCompositeType_BaseType(), this.getCompositeTypeEntry(), null, "baseType", null, 0, 1, CompositeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(compositeTypeEntryEClass, CompositeTypeEntry.class, "CompositeTypeEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCompositeTypeEntry_DataType(), this.getType(), null, "dataType", null, 0, 1, CompositeTypeEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //DatatypeRuleTestPackageImpl
