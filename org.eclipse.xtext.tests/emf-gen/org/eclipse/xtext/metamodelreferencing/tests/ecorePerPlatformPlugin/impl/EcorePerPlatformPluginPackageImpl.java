/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.EcorePerNsURIPackage;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.impl.EcorePerNsURIPackageImpl;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.EcorePerPlatformPluginFactory;
import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.EcorePerPlatformPluginPackage;
import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.ExtendsEAttribute;
import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.ExtendsPluginEObject;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.EcorePerPlatformResourcePackage;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.impl.EcorePerPlatformResourcePackageImpl;

import org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.EcoreReferencePackage;

import org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.impl.EcoreReferencePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcorePerPlatformPluginPackageImpl extends EPackageImpl implements EcorePerPlatformPluginPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendsPluginEObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendsEAttributeEClass = null;

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
	 * @see org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.EcorePerPlatformPluginPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EcorePerPlatformPluginPackageImpl() {
		super(eNS_URI, EcorePerPlatformPluginFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EcorePerPlatformPluginPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EcorePerPlatformPluginPackage init() {
		if (isInited) return (EcorePerPlatformPluginPackage)EPackage.Registry.INSTANCE.getEPackage(EcorePerPlatformPluginPackage.eNS_URI);

		// Obtain or create and register package
		EcorePerPlatformPluginPackageImpl theEcorePerPlatformPluginPackage = (EcorePerPlatformPluginPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EcorePerPlatformPluginPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EcorePerPlatformPluginPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EcorePerNsURIPackageImpl theEcorePerNsURIPackage = (EcorePerNsURIPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EcorePerNsURIPackage.eNS_URI) instanceof EcorePerNsURIPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EcorePerNsURIPackage.eNS_URI) : EcorePerNsURIPackage.eINSTANCE);
		EcorePerPlatformResourcePackageImpl theEcorePerPlatformResourcePackage = (EcorePerPlatformResourcePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EcorePerPlatformResourcePackage.eNS_URI) instanceof EcorePerPlatformResourcePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EcorePerPlatformResourcePackage.eNS_URI) : EcorePerPlatformResourcePackage.eINSTANCE);
		EcoreReferencePackageImpl theEcoreReferencePackage = (EcoreReferencePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EcoreReferencePackage.eNS_URI) instanceof EcoreReferencePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EcoreReferencePackage.eNS_URI) : EcoreReferencePackage.eINSTANCE);

		// Create package meta-data objects
		theEcorePerPlatformPluginPackage.createPackageContents();
		theEcorePerNsURIPackage.createPackageContents();
		theEcorePerPlatformResourcePackage.createPackageContents();
		theEcoreReferencePackage.createPackageContents();

		// Initialize created meta-data
		theEcorePerPlatformPluginPackage.initializePackageContents();
		theEcorePerNsURIPackage.initializePackageContents();
		theEcorePerPlatformResourcePackage.initializePackageContents();
		theEcoreReferencePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEcorePerPlatformPluginPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EcorePerPlatformPluginPackage.eNS_URI, theEcorePerPlatformPluginPackage);
		return theEcorePerPlatformPluginPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendsPluginEObject() {
		return extendsPluginEObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendsPluginEObject_Name() {
		return (EAttribute)extendsPluginEObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendsPluginEObject_EObjectReference1() {
		return (EReference)extendsPluginEObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendsPluginEObject_EObjectReference2() {
		return (EReference)extendsPluginEObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendsPluginEObject_EObjectReference3() {
		return (EReference)extendsPluginEObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendsPluginEObject_EObjectReference4() {
		return (EReference)extendsPluginEObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendsPluginEObject_EObjectContainment() {
		return (EReference)extendsPluginEObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendsEAttribute() {
		return extendsEAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcorePerPlatformPluginFactory getEcorePerPlatformPluginFactory() {
		return (EcorePerPlatformPluginFactory)getEFactoryInstance();
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
		extendsPluginEObjectEClass = createEClass(EXTENDS_PLUGIN_EOBJECT);
		createEAttribute(extendsPluginEObjectEClass, EXTENDS_PLUGIN_EOBJECT__NAME);
		createEReference(extendsPluginEObjectEClass, EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE1);
		createEReference(extendsPluginEObjectEClass, EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE2);
		createEReference(extendsPluginEObjectEClass, EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE3);
		createEReference(extendsPluginEObjectEClass, EXTENDS_PLUGIN_EOBJECT__EOBJECT_REFERENCE4);
		createEReference(extendsPluginEObjectEClass, EXTENDS_PLUGIN_EOBJECT__EOBJECT_CONTAINMENT);

		extendsEAttributeEClass = createEClass(EXTENDS_EATTRIBUTE);
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
		EcorePerPlatformResourcePackage theEcorePerPlatformResourcePackage = (EcorePerPlatformResourcePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePerPlatformResourcePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		extendsPluginEObjectEClass.getESuperTypes().add(theEcorePackage.getEObject());
		extendsEAttributeEClass.getESuperTypes().add(theEcorePackage.getEAttribute());

		// Initialize classes and features; add operations and parameters
		initEClass(extendsPluginEObjectEClass, ExtendsPluginEObject.class, "ExtendsPluginEObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtendsPluginEObject_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ExtendsPluginEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendsPluginEObject_EObjectReference1(), theEcorePackage.getEObject(), null, "eObjectReference1", null, 0, 1, ExtendsPluginEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendsPluginEObject_EObjectReference2(), theEcorePerNsURIPackage.getExtendsNsURIEObject(), null, "eObjectReference2", null, 0, 1, ExtendsPluginEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendsPluginEObject_EObjectReference3(), this.getExtendsPluginEObject(), null, "eObjectReference3", null, 0, 1, ExtendsPluginEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendsPluginEObject_EObjectReference4(), theEcorePerPlatformResourcePackage.getExtendsResourceEObject(), null, "eObjectReference4", null, 0, 1, ExtendsPluginEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendsPluginEObject_EObjectContainment(), theEcorePackage.getEObject(), null, "eObjectContainment", null, 0, -1, ExtendsPluginEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extendsEAttributeEClass, ExtendsEAttribute.class, "ExtendsEAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EcorePerPlatformPluginPackageImpl
