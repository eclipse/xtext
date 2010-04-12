/**
 * <copyright>
 * </copyright>
 *
 * $Id: BuilderStatePackageImpl.java,v 1.11 2010/04/12 20:19:21 szarnekow Exp $
 */
package org.eclipse.xtext.builder.builderState.impl;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.xtext.builder.builderState.BuilderStateFactory;
import org.eclipse.xtext.builder.builderState.BuilderStatePackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.ignorecase.IIgnoreCaseResourceDescription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BuilderStatePackageImpl extends EPackageImpl implements BuilderStatePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eObjectDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userDataEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType euriEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eStringArrayEDataType = null;

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
	 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BuilderStatePackageImpl() {
		super(eNS_URI, BuilderStateFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BuilderStatePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BuilderStatePackage init() {
		if (isInited) return (BuilderStatePackage)EPackage.Registry.INSTANCE.getEPackage(BuilderStatePackage.eNS_URI);

		// Obtain or create and register package
		BuilderStatePackageImpl theBuilderStatePackage = (BuilderStatePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BuilderStatePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BuilderStatePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theBuilderStatePackage.createPackageContents();

		// Initialize created meta-data
		theBuilderStatePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBuilderStatePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BuilderStatePackage.eNS_URI, theBuilderStatePackage);
		return theBuilderStatePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceDescription() {
		return resourceDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceDescription_URI() {
		return (EAttribute)resourceDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceDescription_ExportedObjects() {
		return (EReference)resourceDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceDescription_ImportedNames() {
		return (EAttribute)resourceDescriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceDescription_ReferenceDescriptions() {
		return (EReference)resourceDescriptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEObjectDescription() {
		return eObjectDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEObjectDescription_Name() {
		return (EAttribute)eObjectDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEObjectDescription_Fragment() {
		return (EAttribute)eObjectDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEObjectDescription_EClass() {
		return (EReference)eObjectDescriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEObjectDescription_ResourceDescriptor() {
		return (EReference)eObjectDescriptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEObjectDescription_UserData() {
		return (EReference)eObjectDescriptionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserDataEntry() {
		return userDataEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserDataEntry_Key() {
		return (EAttribute)userDataEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserDataEntry_Value() {
		return (EAttribute)userDataEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceDescription() {
		return referenceDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceDescription_SourceEObjectUri() {
		return (EAttribute)referenceDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceDescription_TargetEObjectUri() {
		return (EAttribute)referenceDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceDescription_IndexInList() {
		return (EAttribute)referenceDescriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceDescription_ExternalFormOfEReference() {
		return (EAttribute)referenceDescriptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceDescription_ContainerEObjectURI() {
		return (EAttribute)referenceDescriptionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEURI() {
		return euriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEStringArray() {
		return eStringArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuilderStateFactory getBuilderStateFactory() {
		return (BuilderStateFactory)getEFactoryInstance();
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
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		resourceDescriptionEClass = createEClass(RESOURCE_DESCRIPTION);
		createEAttribute(resourceDescriptionEClass, RESOURCE_DESCRIPTION__URI);
		createEReference(resourceDescriptionEClass, RESOURCE_DESCRIPTION__EXPORTED_OBJECTS);
		createEAttribute(resourceDescriptionEClass, RESOURCE_DESCRIPTION__IMPORTED_NAMES);
		createEReference(resourceDescriptionEClass, RESOURCE_DESCRIPTION__REFERENCE_DESCRIPTIONS);

		eObjectDescriptionEClass = createEClass(EOBJECT_DESCRIPTION);
		createEAttribute(eObjectDescriptionEClass, EOBJECT_DESCRIPTION__NAME);
		createEAttribute(eObjectDescriptionEClass, EOBJECT_DESCRIPTION__FRAGMENT);
		createEReference(eObjectDescriptionEClass, EOBJECT_DESCRIPTION__ECLASS);
		createEReference(eObjectDescriptionEClass, EOBJECT_DESCRIPTION__RESOURCE_DESCRIPTOR);
		createEReference(eObjectDescriptionEClass, EOBJECT_DESCRIPTION__USER_DATA);

		userDataEntryEClass = createEClass(USER_DATA_ENTRY);
		createEAttribute(userDataEntryEClass, USER_DATA_ENTRY__KEY);
		createEAttribute(userDataEntryEClass, USER_DATA_ENTRY__VALUE);

		referenceDescriptionEClass = createEClass(REFERENCE_DESCRIPTION);
		createEAttribute(referenceDescriptionEClass, REFERENCE_DESCRIPTION__SOURCE_EOBJECT_URI);
		createEAttribute(referenceDescriptionEClass, REFERENCE_DESCRIPTION__TARGET_EOBJECT_URI);
		createEAttribute(referenceDescriptionEClass, REFERENCE_DESCRIPTION__INDEX_IN_LIST);
		createEAttribute(referenceDescriptionEClass, REFERENCE_DESCRIPTION__EXTERNAL_FORM_OF_EREFERENCE);
		createEAttribute(referenceDescriptionEClass, REFERENCE_DESCRIPTION__CONTAINER_EOBJECT_URI);

		// Create data types
		euriEDataType = createEDataType(EURI);
		eStringArrayEDataType = createEDataType(ESTRING_ARRAY);
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
	public void initializePackageContents() {
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
		initEClass(resourceDescriptionEClass, IIgnoreCaseResourceDescription.class, "ResourceDescription", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceDescription_URI(), this.getEURI(), "URI", null, 1, 1, IIgnoreCaseResourceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceDescription_ExportedObjects(), this.getEObjectDescription(), this.getEObjectDescription_ResourceDescriptor(), "exportedObjects", null, 0, -1, IIgnoreCaseResourceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceDescription_ImportedNames(), ecorePackage.getEString(), "importedNames", null, 0, -1, IIgnoreCaseResourceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceDescription_ReferenceDescriptions(), this.getReferenceDescription(), null, "referenceDescriptions", null, 0, -1, IIgnoreCaseResourceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(resourceDescriptionEClass, this.getEObjectDescription(), "getExportedObjects", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEClass(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(resourceDescriptionEClass, this.getEObjectDescription(), "getExportedObjects", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEClass(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(resourceDescriptionEClass, this.getEObjectDescription(), "getExportedObjectsForEObject", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eObjectDescriptionEClass, IEObjectDescription.class, "EObjectDescription", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEObjectDescription_Name(), ecorePackage.getEString(), "name", null, 0, 1, IEObjectDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEObjectDescription_Fragment(), ecorePackage.getEString(), "fragment", null, 1, 1, IEObjectDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEObjectDescription_EClass(), ecorePackage.getEClass(), null, "eClass", null, 1, 1, IEObjectDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEObjectDescription_ResourceDescriptor(), this.getResourceDescription(), this.getResourceDescription_ExportedObjects(), "resourceDescriptor", null, 0, 1, IEObjectDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEObjectDescription_UserData(), this.getUserDataEntry(), null, "userData", null, 0, -1, IEObjectDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(eObjectDescriptionEClass, this.getEURI(), "getEObjectURI", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eObjectDescriptionEClass, ecorePackage.getEObject(), "getEObjectOrProxy", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eObjectDescriptionEClass, ecorePackage.getEString(), "getUserData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eObjectDescriptionEClass, this.getEStringArray(), "getUserDataKeys", 0, 1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(eObjectDescriptionEClass, ecorePackage.getEString(), "getQualifiedName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(userDataEntryEClass, Map.Entry.class, "UserDataEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUserDataEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUserDataEntry_Value(), ecorePackage.getEString(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceDescriptionEClass, IReferenceDescription.class, "ReferenceDescription", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceDescription_SourceEObjectUri(), this.getEURI(), "sourceEObjectUri", null, 0, 1, IReferenceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceDescription_TargetEObjectUri(), this.getEURI(), "targetEObjectUri", null, 0, 1, IReferenceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceDescription_IndexInList(), ecorePackage.getEInt(), "indexInList", "-1", 0, 1, IReferenceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceDescription_ExternalFormOfEReference(), ecorePackage.getEString(), "externalFormOfEReference", null, 0, 1, IReferenceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceDescription_ContainerEObjectURI(), this.getEURI(), "containerEObjectURI", null, 0, 1, IReferenceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(euriEDataType, URI.class, "EURI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eStringArrayEDataType, Object[].class, "EStringArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //BuilderStatePackageImpl
