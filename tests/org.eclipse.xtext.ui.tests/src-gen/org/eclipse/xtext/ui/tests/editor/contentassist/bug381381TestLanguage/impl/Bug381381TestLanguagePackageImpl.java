/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.Bug381381TestLanguageFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.Bug381381TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.CopyFieldNameToVariableStmt;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.Model;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug381381TestLanguagePackageImpl extends EPackageImpl implements Bug381381TestLanguagePackage
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
  private EClass copyFieldNameToVariableStmtEClass = null;

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
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.Bug381381TestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Bug381381TestLanguagePackageImpl()
  {
    super(eNS_URI, Bug381381TestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link Bug381381TestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Bug381381TestLanguagePackage init()
  {
    if (isInited) return (Bug381381TestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(Bug381381TestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    Bug381381TestLanguagePackageImpl theBug381381TestLanguagePackage = (Bug381381TestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Bug381381TestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Bug381381TestLanguagePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theBug381381TestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theBug381381TestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBug381381TestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Bug381381TestLanguagePackage.eNS_URI, theBug381381TestLanguagePackage);
    return theBug381381TestLanguagePackage;
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
  public EReference getModel_Stmt()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCopyFieldNameToVariableStmt()
  {
    return copyFieldNameToVariableStmtEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCopyFieldNameToVariableStmt_Line()
  {
    return (EAttribute)copyFieldNameToVariableStmtEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCopyFieldNameToVariableStmt_Column()
  {
    return (EAttribute)copyFieldNameToVariableStmtEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCopyFieldNameToVariableStmt_Name()
  {
    return (EAttribute)copyFieldNameToVariableStmtEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug381381TestLanguageFactory getBug381381TestLanguageFactory()
  {
    return (Bug381381TestLanguageFactory)getEFactoryInstance();
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
    createEReference(modelEClass, MODEL__STMT);

    copyFieldNameToVariableStmtEClass = createEClass(COPY_FIELD_NAME_TO_VARIABLE_STMT);
    createEAttribute(copyFieldNameToVariableStmtEClass, COPY_FIELD_NAME_TO_VARIABLE_STMT__LINE);
    createEAttribute(copyFieldNameToVariableStmtEClass, COPY_FIELD_NAME_TO_VARIABLE_STMT__COLUMN);
    createEAttribute(copyFieldNameToVariableStmtEClass, COPY_FIELD_NAME_TO_VARIABLE_STMT__NAME);
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
    initEReference(getModel_Stmt(), this.getCopyFieldNameToVariableStmt(), null, "stmt", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(copyFieldNameToVariableStmtEClass, CopyFieldNameToVariableStmt.class, "CopyFieldNameToVariableStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCopyFieldNameToVariableStmt_Line(), ecorePackage.getEInt(), "line", null, 0, 1, CopyFieldNameToVariableStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCopyFieldNameToVariableStmt_Column(), ecorePackage.getEInt(), "column", null, 0, 1, CopyFieldNameToVariableStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCopyFieldNameToVariableStmt_Name(), ecorePackage.getEString(), "name", null, 0, 1, CopyFieldNameToVariableStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //Bug381381TestLanguagePackageImpl
