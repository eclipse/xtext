/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.EcorePerNsURIPackage;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.impl.EcorePerNsURIPackageImpl;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.EcorePerPlatformPluginPackage;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.impl.EcorePerPlatformPluginPackageImpl;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.EcorePerPlatformResourceFactory;
import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.EcorePerPlatformResourcePackage;
import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.ExtendsResourceEObject;

import org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.EcoreReferencePackage;

import org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.impl.EcoreReferencePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcorePerPlatformResourcePackageImpl extends EPackageImpl implements EcorePerPlatformResourcePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendsResourceEObjectEClass = null;

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
	 * @see org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.EcorePerPlatformResourcePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EcorePerPlatformResourcePackageImpl() {
		super(eNS_URI, EcorePerPlatformResourceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EcorePerPlatformResourcePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EcorePerPlatformResourcePackage init() {
		if (isInited) return (EcorePerPlatformResourcePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePerPlatformResourcePackage.eNS_URI);

		// Obtain or create and register package
		EcorePerPlatformResourcePackageImpl theEcorePerPlatformResourcePackage = (EcorePerPlatformResourcePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EcorePerPlatformResourcePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EcorePerPlatformResourcePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EcorePerNsURIPackageImpl theEcorePerNsURIPackage = (EcorePerNsURIPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EcorePerNsURIPackage.eNS_URI) instanceof EcorePerNsURIPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EcorePerNsURIPackage.eNS_URI) : EcorePerNsURIPackage.eINSTANCE);
		EcorePerPlatformPluginPackageImpl theEcorePerPlatformPluginPackage = (EcorePerPlatformPluginPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EcorePerPlatformPluginPackage.eNS_URI) instanceof EcorePerPlatformPluginPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EcorePerPlatformPluginPackage.eNS_URI) : EcorePerPlatformPluginPackage.eINSTANCE);
		EcoreReferencePackageImpl theEcoreReferencePackage = (EcoreReferencePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EcoreReferencePackage.eNS_URI) instanceof EcoreReferencePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EcoreReferencePackage.eNS_URI) : EcoreReferencePackage.eINSTANCE);

		// Create package meta-data objects
		theEcorePerPlatformResourcePackage.createPackageContents();
		theEcorePerNsURIPackage.createPackageContents();
		theEcorePerPlatformPluginPackage.createPackageContents();
		theEcoreReferencePackage.createPackageContents();

		// Initialize created meta-data
		theEcorePerPlatformResourcePackage.initializePackageContents();
		theEcorePerNsURIPackage.initializePackageContents();
		theEcorePerPlatformPluginPackage.initializePackageContents();
		theEcoreReferencePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEcorePerPlatformResourcePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EcorePerPlatformResourcePackage.eNS_URI, theEcorePerPlatformResourcePackage);
		return theEcorePerPlatformResourcePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendsResourceEObject() {
		return extendsResourceEObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendsResourceEObject_Name() {
		return (EAttribute)extendsResourceEObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendsResourceEObject_EObjectReference1() {
		return (EReference)extendsResourceEObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendsResourceEObject_EObjectReference2() {
		return (EReference)extendsResourceEObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendsResourceEObject_EObjectReference3() {
		return (EReference)extendsResourceEObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendsResourceEObject_EObjectReference4() {
		return (EReference)extendsResourceEObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendsResourceEObject_EObjectContainment() {
		return (EReference)extendsResourceEObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcorePerPlatformResourceFactory getEcorePerPlatformResourceFactory() {
		return (EcorePerPlatformResourceFactory)getEFactoryInstance();
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
		extendsResourceEObjectEClass = createEClass(EXTENDS_RESOURCE_EOBJECT);
		createEAttribute(extendsResourceEObjectEClass, EXTENDS_RESOURCE_EOBJECT__NAME);
		createEReference(extendsResourceEObjectEClass, EXTENDS_RESOURCE_EOBJECT__EOBJECT_REFERENCE1);
		createEReference(extendsResourceEObjectEClass, EXTENDS_RESOURCE_EOBJECT__EOBJECT_REFERENCE2);
		createEReference(extendsResourceEObjectEClass, EXTENDS_RESOURCE_EOBJECT__EOBJECT_REFERENCE3);
		createEReference(extendsResourceEObjectEClass, EXTENDS_RESOURCE_EOBJECT__EOBJECT_REFERENCE4);
		createEReference(extendsResourceEObjectEClass, EXTENDS_RESOURCE_EOBJECT__EOBJECT_CONTAINMENT);
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

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		EcorePerNsURIPackage theEcorePerNsURIPackage = (EcorePerNsURIPackage)EPackage.Registry.INSTANCE.getEPackage(EcorePerNsURIPackage.eNS_URI);
		EcorePerPlatformPluginPackage theEcorePerPlatformPluginPackage = (EcorePerPlatformPluginPackage)EPackage.Registry.INSTANCE.getEPackage(EcorePerPlatformPluginPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		extendsResourceEObjectEClass.getESuperTypes().add(theEcorePackage.getEObject());

		// Initialize classes and features; add operations and parameters
		initEClass(extendsResourceEObjectEClass, ExtendsResourceEObject.class, "ExtendsResourceEObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtendsResourceEObject_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ExtendsResourceEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendsResourceEObject_EObjectReference1(), theEcorePackage.getEObject(), null, "eObjectReference1", null, 0, 1, ExtendsResourceEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendsResourceEObject_EObjectReference2(), theEcorePerNsURIPackage.getExtendsNsURIEObject(), null, "eObjectReference2", null, 0, 1, ExtendsResourceEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendsResourceEObject_EObjectReference3(), theEcorePerPlatformPluginPackage.getExtendsPluginEObject(), null, "eObjectReference3", null, 0, 1, ExtendsResourceEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendsResourceEObject_EObjectReference4(), this.getExtendsResourceEObject(), null, "eObjectReference4", null, 0, 1, ExtendsResourceEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendsResourceEObject_EObjectContainment(), theEcorePackage.getEObject(), null, "eObjectContainment", null, 0, -1, ExtendsResourceEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //EcorePerPlatformResourcePackageImpl
