/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.EcorePerNsURIFactory;
import org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.EcorePerNsURIPackage;
import org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.ExtendsNsURIEObject;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.EcorePerPlatformPluginPackage;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.impl.EcorePerPlatformPluginPackageImpl;

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
public class EcorePerNsURIPackageImpl extends EPackageImpl implements EcorePerNsURIPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendsNsURIEObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass myEAttributeEClass = null;

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
	 * @see org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.EcorePerNsURIPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EcorePerNsURIPackageImpl() {
		super(eNS_URI, EcorePerNsURIFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EcorePerNsURIPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EcorePerNsURIPackage init() {
		if (isInited) return (EcorePerNsURIPackage)EPackage.Registry.INSTANCE.getEPackage(EcorePerNsURIPackage.eNS_URI);

		// Obtain or create and register package
		EcorePerNsURIPackageImpl theEcorePerNsURIPackage = (EcorePerNsURIPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EcorePerNsURIPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EcorePerNsURIPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EcorePerPlatformPluginPackageImpl theEcorePerPlatformPluginPackage = (EcorePerPlatformPluginPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EcorePerPlatformPluginPackage.eNS_URI) instanceof EcorePerPlatformPluginPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EcorePerPlatformPluginPackage.eNS_URI) : EcorePerPlatformPluginPackage.eINSTANCE);
		EcorePerPlatformResourcePackageImpl theEcorePerPlatformResourcePackage = (EcorePerPlatformResourcePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EcorePerPlatformResourcePackage.eNS_URI) instanceof EcorePerPlatformResourcePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EcorePerPlatformResourcePackage.eNS_URI) : EcorePerPlatformResourcePackage.eINSTANCE);
		EcoreReferencePackageImpl theEcoreReferencePackage = (EcoreReferencePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EcoreReferencePackage.eNS_URI) instanceof EcoreReferencePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EcoreReferencePackage.eNS_URI) : EcoreReferencePackage.eINSTANCE);

		// Create package meta-data objects
		theEcorePerNsURIPackage.createPackageContents();
		theEcorePerPlatformPluginPackage.createPackageContents();
		theEcorePerPlatformResourcePackage.createPackageContents();
		theEcoreReferencePackage.createPackageContents();

		// Initialize created meta-data
		theEcorePerNsURIPackage.initializePackageContents();
		theEcorePerPlatformPluginPackage.initializePackageContents();
		theEcorePerPlatformResourcePackage.initializePackageContents();
		theEcoreReferencePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEcorePerNsURIPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EcorePerNsURIPackage.eNS_URI, theEcorePerNsURIPackage);
		return theEcorePerNsURIPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendsNsURIEObject() {
		return extendsNsURIEObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendsNsURIEObject_Name() {
		return (EAttribute)extendsNsURIEObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendsNsURIEObject_EObjectReference1() {
		return (EReference)extendsNsURIEObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendsNsURIEObject_EAttributeReference() {
		return (EReference)extendsNsURIEObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendsNsURIEObject_EObjectReference2() {
		return (EReference)extendsNsURIEObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendsNsURIEObject_EObjectReference3() {
		return (EReference)extendsNsURIEObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendsNsURIEObject_EObjectReference4() {
		return (EReference)extendsNsURIEObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendsNsURIEObject_EObjectContainment() {
		return (EReference)extendsNsURIEObjectEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMyEAttribute() {
		return myEAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcorePerNsURIFactory getEcorePerNsURIFactory() {
		return (EcorePerNsURIFactory)getEFactoryInstance();
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
		extendsNsURIEObjectEClass = createEClass(EXTENDS_NS_URIE_OBJECT);
		createEAttribute(extendsNsURIEObjectEClass, EXTENDS_NS_URIE_OBJECT__NAME);
		createEReference(extendsNsURIEObjectEClass, EXTENDS_NS_URIE_OBJECT__EOBJECT_REFERENCE1);
		createEReference(extendsNsURIEObjectEClass, EXTENDS_NS_URIE_OBJECT__EATTRIBUTE_REFERENCE);
		createEReference(extendsNsURIEObjectEClass, EXTENDS_NS_URIE_OBJECT__EOBJECT_REFERENCE2);
		createEReference(extendsNsURIEObjectEClass, EXTENDS_NS_URIE_OBJECT__EOBJECT_REFERENCE3);
		createEReference(extendsNsURIEObjectEClass, EXTENDS_NS_URIE_OBJECT__EOBJECT_REFERENCE4);
		createEReference(extendsNsURIEObjectEClass, EXTENDS_NS_URIE_OBJECT__EOBJECT_CONTAINMENT);

		myEAttributeEClass = createEClass(MY_EATTRIBUTE);
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
		EcorePerPlatformPluginPackage theEcorePerPlatformPluginPackage = (EcorePerPlatformPluginPackage)EPackage.Registry.INSTANCE.getEPackage(EcorePerPlatformPluginPackage.eNS_URI);
		EcorePerPlatformResourcePackage theEcorePerPlatformResourcePackage = (EcorePerPlatformResourcePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePerPlatformResourcePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		extendsNsURIEObjectEClass.getESuperTypes().add(ecorePackage.getEObject());

		// Initialize classes and features; add operations and parameters
		initEClass(extendsNsURIEObjectEClass, ExtendsNsURIEObject.class, "ExtendsNsURIEObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtendsNsURIEObject_Name(), ecorePackage.getEString(), "name", null, 0, 1, ExtendsNsURIEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendsNsURIEObject_EObjectReference1(), ecorePackage.getEObject(), null, "eObjectReference1", null, 0, 1, ExtendsNsURIEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendsNsURIEObject_EAttributeReference(), ecorePackage.getEAttribute(), null, "eAttributeReference", null, 0, 1, ExtendsNsURIEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendsNsURIEObject_EObjectReference2(), this.getExtendsNsURIEObject(), null, "eObjectReference2", null, 0, 1, ExtendsNsURIEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendsNsURIEObject_EObjectReference3(), theEcorePerPlatformPluginPackage.getExtendsPluginEObject(), null, "eObjectReference3", null, 0, 1, ExtendsNsURIEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendsNsURIEObject_EObjectReference4(), theEcorePerPlatformResourcePackage.getExtendsResourceEObject(), null, "eObjectReference4", null, 0, 1, ExtendsNsURIEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendsNsURIEObject_EObjectContainment(), ecorePackage.getEObject(), null, "eObjectContainment", null, 0, -1, ExtendsNsURIEObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(myEAttributeEClass, EAttribute.class, "MyEAttribute", IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EcorePerNsURIPackageImpl
