/**
 * <copyright>
 * </copyright>
 *
 * $Id: SubsubpackagePackageImpl.java,v 1.1 2010/02/04 09:24:54 sefftinge Exp $
 */
package org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.emptyPackage.subsubpackage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AsubpackagePackage;

import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.emptyPackage.subsubpackage.AnotherType;
import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.emptyPackage.subsubpackage.SubsubpackageFactory;
import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.emptyPackage.subsubpackage.SubsubpackagePackage;

import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.impl.AsubpackagePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SubsubpackagePackageImpl extends EPackageImpl implements SubsubpackagePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anotherTypeEClass = null;

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
	 * @see org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.emptyPackage.subsubpackage.SubsubpackagePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SubsubpackagePackageImpl() {
		super(eNS_URI, SubsubpackageFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SubsubpackagePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SubsubpackagePackage init() {
		if (isInited) return (SubsubpackagePackage)EPackage.Registry.INSTANCE.getEPackage(SubsubpackagePackage.eNS_URI);

		// Obtain or create and register package
		SubsubpackagePackageImpl theSubsubpackagePackage = (SubsubpackagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SubsubpackagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SubsubpackagePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		AsubpackagePackageImpl theAsubpackagePackage = (AsubpackagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AsubpackagePackage.eNS_URI) instanceof AsubpackagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AsubpackagePackage.eNS_URI) : AsubpackagePackage.eINSTANCE);

		// Create package meta-data objects
		theSubsubpackagePackage.createPackageContents();
		theAsubpackagePackage.createPackageContents();

		// Initialize created meta-data
		theSubsubpackagePackage.initializePackageContents();
		theAsubpackagePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSubsubpackagePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SubsubpackagePackage.eNS_URI, theSubsubpackagePackage);
		return theSubsubpackagePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnotherType() {
		return anotherTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnotherType_Ref() {
		return (EReference)anotherTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubsubpackageFactory getSubsubpackageFactory() {
		return (SubsubpackageFactory)getEFactoryInstance();
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
		anotherTypeEClass = createEClass(ANOTHER_TYPE);
		createEReference(anotherTypeEClass, ANOTHER_TYPE__REF);
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
		AsubpackagePackage theAsubpackagePackage = (AsubpackagePackage)EPackage.Registry.INSTANCE.getEPackage(AsubpackagePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		anotherTypeEClass.getESuperTypes().add(theAsubpackagePackage.getAType());

		// Initialize classes and features; add operations and parameters
		initEClass(anotherTypeEClass, AnotherType.class, "AnotherType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnotherType_Ref(), theAsubpackagePackage.getAType(), null, "ref", null, 0, 1, AnotherType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //SubsubpackagePackageImpl
