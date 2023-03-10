/**
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
import org.eclipse.xtext.builder.builderState.EObjectDescription;
import org.eclipse.xtext.builder.builderState.ReferenceDescription;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;

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
	private EClass ieObjectDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iReferenceDescriptionEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType qualifiedNameEDataType = null;

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
		Object registeredBuilderStatePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		BuilderStatePackageImpl theBuilderStatePackage = registeredBuilderStatePackage instanceof BuilderStatePackageImpl ? (BuilderStatePackageImpl)registeredBuilderStatePackage : new BuilderStatePackageImpl();

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
	@Override
	public EClass getResourceDescription() {
		return resourceDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getResourceDescription_URI() {
		return (EAttribute)resourceDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getResourceDescription_ExportedObjects() {
		return (EReference)resourceDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getResourceDescription_ReferenceDescriptions() {
		return (EReference)resourceDescriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getResourceDescription_ImportedNames() {
		return (EAttribute)resourceDescriptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEObjectDescription() {
		return eObjectDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEObjectDescription_Fragment() {
		return (EAttribute)eObjectDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEObjectDescription_UserData() {
		return (EReference)eObjectDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUserDataEntry() {
		return userDataEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUserDataEntry_Key() {
		return (EAttribute)userDataEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUserDataEntry_Value() {
		return (EAttribute)userDataEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReferenceDescription() {
		return referenceDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getReferenceDescription_ExternalFormOfEReference() {
		return (EAttribute)referenceDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIEObjectDescription() {
		return ieObjectDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIEObjectDescription_EClass() {
		return (EReference)ieObjectDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIEObjectDescription_Name() {
		return (EAttribute)ieObjectDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIReferenceDescription() {
		return iReferenceDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIReferenceDescription_SourceEObjectUri() {
		return (EAttribute)iReferenceDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIReferenceDescription_TargetEObjectUri() {
		return (EAttribute)iReferenceDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIReferenceDescription_IndexInList() {
		return (EAttribute)iReferenceDescriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIReferenceDescription_ContainerEObjectURI() {
		return (EAttribute)iReferenceDescriptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getEURI() {
		return euriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getEStringArray() {
		return eStringArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getQualifiedName() {
		return qualifiedNameEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		createEReference(resourceDescriptionEClass, RESOURCE_DESCRIPTION__REFERENCE_DESCRIPTIONS);
		createEAttribute(resourceDescriptionEClass, RESOURCE_DESCRIPTION__IMPORTED_NAMES);

		eObjectDescriptionEClass = createEClass(EOBJECT_DESCRIPTION);
		createEAttribute(eObjectDescriptionEClass, EOBJECT_DESCRIPTION__FRAGMENT);
		createEReference(eObjectDescriptionEClass, EOBJECT_DESCRIPTION__USER_DATA);

		userDataEntryEClass = createEClass(USER_DATA_ENTRY);
		createEAttribute(userDataEntryEClass, USER_DATA_ENTRY__KEY);
		createEAttribute(userDataEntryEClass, USER_DATA_ENTRY__VALUE);

		referenceDescriptionEClass = createEClass(REFERENCE_DESCRIPTION);
		createEAttribute(referenceDescriptionEClass, REFERENCE_DESCRIPTION__EXTERNAL_FORM_OF_EREFERENCE);

		ieObjectDescriptionEClass = createEClass(IE_OBJECT_DESCRIPTION);
		createEReference(ieObjectDescriptionEClass, IE_OBJECT_DESCRIPTION__ECLASS);
		createEAttribute(ieObjectDescriptionEClass, IE_OBJECT_DESCRIPTION__NAME);

		iReferenceDescriptionEClass = createEClass(IREFERENCE_DESCRIPTION);
		createEAttribute(iReferenceDescriptionEClass, IREFERENCE_DESCRIPTION__SOURCE_EOBJECT_URI);
		createEAttribute(iReferenceDescriptionEClass, IREFERENCE_DESCRIPTION__TARGET_EOBJECT_URI);
		createEAttribute(iReferenceDescriptionEClass, IREFERENCE_DESCRIPTION__INDEX_IN_LIST);
		createEAttribute(iReferenceDescriptionEClass, IREFERENCE_DESCRIPTION__CONTAINER_EOBJECT_URI);

		// Create data types
		euriEDataType = createEDataType(EURI);
		eStringArrayEDataType = createEDataType(ESTRING_ARRAY);
		qualifiedNameEDataType = createEDataType(QUALIFIED_NAME);
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
		eObjectDescriptionEClass.getESuperTypes().add(this.getIEObjectDescription());
		referenceDescriptionEClass.getESuperTypes().add(this.getIReferenceDescription());

		// Initialize classes and features; add operations and parameters
		initEClass(resourceDescriptionEClass, IResourceDescription.class, "ResourceDescription", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceDescription_URI(), this.getEURI(), "URI", null, 1, 1, IResourceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceDescription_ExportedObjects(), this.getIEObjectDescription(), null, "exportedObjects", null, 0, -1, IResourceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceDescription_ReferenceDescriptions(), this.getIReferenceDescription(), null, "referenceDescriptions", null, 0, -1, IResourceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceDescription_ImportedNames(), this.getQualifiedName(), "importedNames", null, 0, -1, IResourceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(resourceDescriptionEClass, ecorePackage.getEBoolean(), "isEmpty", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(resourceDescriptionEClass, this.getIEObjectDescription(), "getExportedObjectsByType", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEClass(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(resourceDescriptionEClass, this.getIEObjectDescription(), "getExportedObjects", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEClass(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getQualifiedName(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "ignoreCase", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(resourceDescriptionEClass, this.getIEObjectDescription(), "getExportedObjectsByObject", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eObjectDescriptionEClass, EObjectDescription.class, "EObjectDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEObjectDescription_Fragment(), ecorePackage.getEString(), "fragment", null, 1, 1, EObjectDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEObjectDescription_UserData(), this.getUserDataEntry(), null, "userData", null, 0, -1, EObjectDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userDataEntryEClass, Map.Entry.class, "UserDataEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUserDataEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUserDataEntry_Value(), ecorePackage.getEString(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceDescriptionEClass, ReferenceDescription.class, "ReferenceDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceDescription_ExternalFormOfEReference(), ecorePackage.getEString(), "externalFormOfEReference", null, 0, 1, ReferenceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ieObjectDescriptionEClass, IEObjectDescription.class, "IEObjectDescription", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIEObjectDescription_EClass(), ecorePackage.getEClass(), null, "eClass", null, 1, 1, IEObjectDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIEObjectDescription_Name(), this.getQualifiedName(), "name", null, 0, 1, IEObjectDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(ieObjectDescriptionEClass, this.getEURI(), "getEObjectURI", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(ieObjectDescriptionEClass, ecorePackage.getEObject(), "getEObjectOrProxy", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ieObjectDescriptionEClass, ecorePackage.getEString(), "getUserData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(ieObjectDescriptionEClass, this.getEStringArray(), "getUserDataKeys", 0, 1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(ieObjectDescriptionEClass, this.getQualifiedName(), "getQualifiedName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(iReferenceDescriptionEClass, IReferenceDescription.class, "IReferenceDescription", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIReferenceDescription_SourceEObjectUri(), this.getEURI(), "sourceEObjectUri", null, 0, 1, IReferenceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIReferenceDescription_TargetEObjectUri(), this.getEURI(), "targetEObjectUri", null, 0, 1, IReferenceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIReferenceDescription_IndexInList(), ecorePackage.getEInt(), "indexInList", "-1", 0, 1, IReferenceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIReferenceDescription_ContainerEObjectURI(), this.getEURI(), "containerEObjectURI", null, 0, 1, IReferenceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(euriEDataType, URI.class, "EURI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eStringArrayEDataType, Object[].class, "EStringArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(qualifiedNameEDataType, QualifiedName.class, "QualifiedName", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //BuilderStatePackageImpl
