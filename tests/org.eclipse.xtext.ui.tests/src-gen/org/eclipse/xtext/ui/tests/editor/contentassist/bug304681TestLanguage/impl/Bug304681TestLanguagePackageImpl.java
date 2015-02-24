/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Attribut;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Attribute;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Bug304681TestLanguageFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Bug304681TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.ConstraintDefinition;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Feature;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.PackageDefinition;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug304681TestLanguagePackageImpl extends EPackageImpl implements Bug304681TestLanguagePackage
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
  private EClass packageDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass featureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass referenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constraintDefinitionEClass = null;

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
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Bug304681TestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Bug304681TestLanguagePackageImpl()
  {
    super(eNS_URI, Bug304681TestLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link Bug304681TestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Bug304681TestLanguagePackage init()
  {
    if (isInited) return (Bug304681TestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(Bug304681TestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    Bug304681TestLanguagePackageImpl theBug304681TestLanguagePackage = (Bug304681TestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Bug304681TestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Bug304681TestLanguagePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theBug304681TestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theBug304681TestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBug304681TestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Bug304681TestLanguagePackage.eNS_URI, theBug304681TestLanguagePackage);
    return theBug304681TestLanguagePackage;
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
  public EReference getModel_Definition()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackageDefinition()
  {
    return packageDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPackageDefinition_Namespace()
  {
    return (EAttribute)packageDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDefinition_Contents()
  {
    return (EReference)packageDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObject()
  {
    return objectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObject_Enabled()
  {
    return (EAttribute)objectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObject_Abstract()
  {
    return (EAttribute)objectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObject_Name()
  {
    return (EAttribute)objectEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObject_Parent()
  {
    return (EReference)objectEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObject_ShortDescription()
  {
    return (EAttribute)objectEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObject_LongDescription()
  {
    return (EAttribute)objectEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObject_SerialVersionUID()
  {
    return (EAttribute)objectEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObject_Cloneable()
  {
    return (EAttribute)objectEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObject_Features()
  {
    return (EReference)objectEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFeature()
  {
    return featureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFeature_Name()
  {
    return (EAttribute)featureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttribute()
  {
    return attributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribute_Type()
  {
    return (EAttribute)attributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReference()
  {
    return referenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReference_Type()
  {
    return (EReference)referenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReference_Many()
  {
    return (EAttribute)referenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReference_ShortDescription()
  {
    return (EAttribute)referenceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReference_LongDescription()
  {
    return (EAttribute)referenceEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttribut()
  {
    return attributEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribut_Type()
  {
    return (EAttribute)attributEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribut_ShortDescription()
  {
    return (EAttribute)attributEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribut_LongDescription()
  {
    return (EAttribute)attributEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttribut_ConstraintDefinitions()
  {
    return (EReference)attributEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribut_Required()
  {
    return (EAttribute)attributEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribut_Technical()
  {
    return (EAttribute)attributEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstraintDefinition()
  {
    return constraintDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstraintDefinition_Type()
  {
    return (EAttribute)constraintDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstraintDefinition_Parameters()
  {
    return (EAttribute)constraintDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstraintDefinition_Message()
  {
    return (EAttribute)constraintDefinitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug304681TestLanguageFactory getBug304681TestLanguageFactory()
  {
    return (Bug304681TestLanguageFactory)getEFactoryInstance();
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
    createEReference(modelEClass, MODEL__DEFINITION);

    packageDefinitionEClass = createEClass(PACKAGE_DEFINITION);
    createEAttribute(packageDefinitionEClass, PACKAGE_DEFINITION__NAMESPACE);
    createEReference(packageDefinitionEClass, PACKAGE_DEFINITION__CONTENTS);

    objectEClass = createEClass(OBJECT);
    createEAttribute(objectEClass, OBJECT__ENABLED);
    createEAttribute(objectEClass, OBJECT__ABSTRACT);
    createEAttribute(objectEClass, OBJECT__NAME);
    createEReference(objectEClass, OBJECT__PARENT);
    createEAttribute(objectEClass, OBJECT__SHORT_DESCRIPTION);
    createEAttribute(objectEClass, OBJECT__LONG_DESCRIPTION);
    createEAttribute(objectEClass, OBJECT__SERIAL_VERSION_UID);
    createEAttribute(objectEClass, OBJECT__CLONEABLE);
    createEReference(objectEClass, OBJECT__FEATURES);

    featureEClass = createEClass(FEATURE);
    createEAttribute(featureEClass, FEATURE__NAME);

    attributeEClass = createEClass(ATTRIBUTE);
    createEAttribute(attributeEClass, ATTRIBUTE__TYPE);

    referenceEClass = createEClass(REFERENCE);
    createEReference(referenceEClass, REFERENCE__TYPE);
    createEAttribute(referenceEClass, REFERENCE__MANY);
    createEAttribute(referenceEClass, REFERENCE__SHORT_DESCRIPTION);
    createEAttribute(referenceEClass, REFERENCE__LONG_DESCRIPTION);

    attributEClass = createEClass(ATTRIBUT);
    createEAttribute(attributEClass, ATTRIBUT__TYPE);
    createEAttribute(attributEClass, ATTRIBUT__SHORT_DESCRIPTION);
    createEAttribute(attributEClass, ATTRIBUT__LONG_DESCRIPTION);
    createEReference(attributEClass, ATTRIBUT__CONSTRAINT_DEFINITIONS);
    createEAttribute(attributEClass, ATTRIBUT__REQUIRED);
    createEAttribute(attributEClass, ATTRIBUT__TECHNICAL);

    constraintDefinitionEClass = createEClass(CONSTRAINT_DEFINITION);
    createEAttribute(constraintDefinitionEClass, CONSTRAINT_DEFINITION__TYPE);
    createEAttribute(constraintDefinitionEClass, CONSTRAINT_DEFINITION__PARAMETERS);
    createEAttribute(constraintDefinitionEClass, CONSTRAINT_DEFINITION__MESSAGE);
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
    attributeEClass.getESuperTypes().add(this.getFeature());
    referenceEClass.getESuperTypes().add(this.getFeature());
    attributEClass.getESuperTypes().add(this.getFeature());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Definition(), this.getPackageDefinition(), null, "definition", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(packageDefinitionEClass, PackageDefinition.class, "PackageDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPackageDefinition_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, PackageDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPackageDefinition_Contents(), this.getObject(), null, "contents", null, 0, -1, PackageDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectEClass, org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object.class, "Object", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getObject_Enabled(), ecorePackage.getEBoolean(), "enabled", null, 0, 1, org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObject_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObject_Name(), ecorePackage.getEString(), "name", null, 0, 1, org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObject_Parent(), this.getObject(), null, "parent", null, 0, 1, org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObject_ShortDescription(), ecorePackage.getEString(), "shortDescription", null, 0, 1, org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObject_LongDescription(), ecorePackage.getEString(), "longDescription", null, 0, 1, org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObject_SerialVersionUID(), ecorePackage.getEInt(), "serialVersionUID", null, 0, 1, org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObject_Cloneable(), ecorePackage.getEBoolean(), "cloneable", null, 0, 1, org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObject_Features(), this.getFeature(), null, "features", null, 0, -1, org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFeature_Name(), ecorePackage.getEString(), "name", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAttribute_Type(), ecorePackage.getEString(), "type", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(referenceEClass, Reference.class, "Reference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReference_Type(), this.getObject(), null, "type", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getReference_Many(), ecorePackage.getEBoolean(), "many", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getReference_ShortDescription(), ecorePackage.getEString(), "shortDescription", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getReference_LongDescription(), ecorePackage.getEString(), "longDescription", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributEClass, Attribut.class, "Attribut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAttribut_Type(), ecorePackage.getEString(), "type", null, 0, 1, Attribut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAttribut_ShortDescription(), ecorePackage.getEString(), "shortDescription", null, 0, 1, Attribut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAttribut_LongDescription(), ecorePackage.getEString(), "longDescription", null, 0, 1, Attribut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttribut_ConstraintDefinitions(), this.getConstraintDefinition(), null, "constraintDefinitions", null, 0, -1, Attribut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAttribut_Required(), ecorePackage.getEBoolean(), "required", null, 0, 1, Attribut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAttribut_Technical(), ecorePackage.getEBoolean(), "technical", null, 0, 1, Attribut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constraintDefinitionEClass, ConstraintDefinition.class, "ConstraintDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getConstraintDefinition_Type(), ecorePackage.getEString(), "type", null, 0, 1, ConstraintDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getConstraintDefinition_Parameters(), ecorePackage.getEString(), "parameters", null, 0, -1, ConstraintDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getConstraintDefinition_Message(), ecorePackage.getEString(), "message", null, 0, 1, ConstraintDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //Bug304681TestLanguagePackageImpl
