/**
 * <copyright>
 * </copyright>
 *
 * $Id: BuilderStatePackageImpl.java,v 1.1 2009/11/19 08:39:59 sefftinge Exp $
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
import org.eclipse.xtext.builder.builderState.BuilderState;
import org.eclipse.xtext.builder.builderState.BuilderStateFactory;
import org.eclipse.xtext.builder.builderState.BuilderStatePackage;
import org.eclipse.xtext.builder.builderState.ResourceDescriptor;
import org.eclipse.xtext.resource.IEObjectDescription;

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
	private EClass containerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceDescriptorEClass = null;

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
	private EClass builderStateEClass = null;

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
	public EClass getContainer() {
		return containerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContainer_Name() {
		return (EAttribute)containerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainer_ResourceDescriptors() {
		return (EReference)containerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContainer_Project() {
		return (EAttribute)containerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceDescriptor() {
		return resourceDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceDescriptor_URI() {
		return (EAttribute)resourceDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceDescriptor_Container() {
		return (EReference)resourceDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceDescriptor_EObjectDescriptions() {
		return (EReference)resourceDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceDescriptor_ImportedNames() {
		return (EAttribute)resourceDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceDescriptor_PathToStorage() {
		return (EAttribute)resourceDescriptorEClass.getEStructuralFeatures().get(4);
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
	public EClass getBuilderState() {
		return builderStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderState_Containers() {
		return (EReference)builderStateEClass.getEStructuralFeatures().get(0);
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
		containerEClass = createEClass(CONTAINER);
		createEAttribute(containerEClass, CONTAINER__NAME);
		createEReference(containerEClass, CONTAINER__RESOURCE_DESCRIPTORS);
		createEAttribute(containerEClass, CONTAINER__PROJECT);

		resourceDescriptorEClass = createEClass(RESOURCE_DESCRIPTOR);
		createEAttribute(resourceDescriptorEClass, RESOURCE_DESCRIPTOR__URI);
		createEReference(resourceDescriptorEClass, RESOURCE_DESCRIPTOR__CONTAINER);
		createEReference(resourceDescriptorEClass, RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTIONS);
		createEAttribute(resourceDescriptorEClass, RESOURCE_DESCRIPTOR__IMPORTED_NAMES);
		createEAttribute(resourceDescriptorEClass, RESOURCE_DESCRIPTOR__PATH_TO_STORAGE);

		eObjectDescriptionEClass = createEClass(EOBJECT_DESCRIPTION);
		createEAttribute(eObjectDescriptionEClass, EOBJECT_DESCRIPTION__NAME);
		createEAttribute(eObjectDescriptionEClass, EOBJECT_DESCRIPTION__FRAGMENT);
		createEReference(eObjectDescriptionEClass, EOBJECT_DESCRIPTION__ECLASS);
		createEReference(eObjectDescriptionEClass, EOBJECT_DESCRIPTION__RESOURCE_DESCRIPTOR);
		createEReference(eObjectDescriptionEClass, EOBJECT_DESCRIPTION__USER_DATA);

		userDataEntryEClass = createEClass(USER_DATA_ENTRY);
		createEAttribute(userDataEntryEClass, USER_DATA_ENTRY__KEY);
		createEAttribute(userDataEntryEClass, USER_DATA_ENTRY__VALUE);

		builderStateEClass = createEClass(BUILDER_STATE);
		createEReference(builderStateEClass, BUILDER_STATE__CONTAINERS);

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
		initEClass(containerEClass, org.eclipse.xtext.builder.builderState.Container.class, "Container", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContainer_Name(), ecorePackage.getEString(), "name", null, 0, 1, org.eclipse.xtext.builder.builderState.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContainer_ResourceDescriptors(), this.getResourceDescriptor(), this.getResourceDescriptor_Container(), "resourceDescriptors", null, 0, -1, org.eclipse.xtext.builder.builderState.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContainer_Project(), ecorePackage.getEString(), "project", null, 0, 1, org.eclipse.xtext.builder.builderState.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(containerEClass, this.getResourceDescriptor(), "getResourceDescriptor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEURI(), "uri", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(resourceDescriptorEClass, ResourceDescriptor.class, "ResourceDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceDescriptor_URI(), this.getEURI(), "URI", null, 1, 1, ResourceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceDescriptor_Container(), this.getContainer(), this.getContainer_ResourceDescriptors(), "container", null, 0, 1, ResourceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceDescriptor_EObjectDescriptions(), this.getEObjectDescription(), this.getEObjectDescription_ResourceDescriptor(), "eObjectDescriptions", null, 0, -1, ResourceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceDescriptor_ImportedNames(), ecorePackage.getEString(), "importedNames", null, 0, -1, ResourceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceDescriptor_PathToStorage(), ecorePackage.getEString(), "pathToStorage", null, 0, 1, ResourceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eObjectDescriptionEClass, IEObjectDescription.class, "EObjectDescription", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEObjectDescription_Name(), ecorePackage.getEString(), "name", null, 0, 1, IEObjectDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEObjectDescription_Fragment(), ecorePackage.getEString(), "fragment", null, 1, 1, IEObjectDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEObjectDescription_EClass(), ecorePackage.getEClass(), null, "eClass", null, 1, 1, IEObjectDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEObjectDescription_ResourceDescriptor(), this.getResourceDescriptor(), this.getResourceDescriptor_EObjectDescriptions(), "resourceDescriptor", null, 0, 1, IEObjectDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEObjectDescription_UserData(), this.getUserDataEntry(), null, "userData", null, 0, -1, IEObjectDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(eObjectDescriptionEClass, this.getEURI(), "getEObjectURI", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eObjectDescriptionEClass, ecorePackage.getEObject(), "getEObjectOrProxy", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eObjectDescriptionEClass, ecorePackage.getEString(), "getUserData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eObjectDescriptionEClass, this.getEStringArray(), "getUserDataKeys", 0, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(userDataEntryEClass, Map.Entry.class, "UserDataEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUserDataEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUserDataEntry_Value(), ecorePackage.getEString(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(builderStateEClass, BuilderState.class, "BuilderState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBuilderState_Containers(), this.getContainer(), null, "containers", null, 0, -1, BuilderState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(euriEDataType, URI.class, "EURI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eStringArrayEDataType, Object[].class, "EStringArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //BuilderStatePackageImpl
