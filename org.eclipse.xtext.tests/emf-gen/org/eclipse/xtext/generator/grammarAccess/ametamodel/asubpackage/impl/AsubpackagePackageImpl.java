/**
 * <copyright>
 * </copyright>
 *
 * $Id: AsubpackagePackageImpl.java,v 1.1 2010/02/04 09:24:53 sefftinge Exp $
 */
package org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AModel;
import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AType;
import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AsubpackageFactory;
import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AsubpackagePackage;

import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.emptyPackage.subsubpackage.SubsubpackagePackage;

import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.emptyPackage.subsubpackage.impl.SubsubpackagePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AsubpackagePackageImpl extends EPackageImpl implements AsubpackagePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aModelEClass = null;

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
	 * @see org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AsubpackagePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AsubpackagePackageImpl() {
		super(eNS_URI, AsubpackageFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AsubpackagePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AsubpackagePackage init() {
		if (isInited) return (AsubpackagePackage)EPackage.Registry.INSTANCE.getEPackage(AsubpackagePackage.eNS_URI);

		// Obtain or create and register package
		AsubpackagePackageImpl theAsubpackagePackage = (AsubpackagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AsubpackagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AsubpackagePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		SubsubpackagePackageImpl theSubsubpackagePackage = (SubsubpackagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SubsubpackagePackage.eNS_URI) instanceof SubsubpackagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SubsubpackagePackage.eNS_URI) : SubsubpackagePackage.eINSTANCE);

		// Create package meta-data objects
		theAsubpackagePackage.createPackageContents();
		theSubsubpackagePackage.createPackageContents();

		// Initialize created meta-data
		theAsubpackagePackage.initializePackageContents();
		theSubsubpackagePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAsubpackagePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AsubpackagePackage.eNS_URI, theAsubpackagePackage);
		return theAsubpackagePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAType() {
		return aTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAType_Name() {
		return (EAttribute)aTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAModel() {
		return aModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAModel_Elements() {
		return (EReference)aModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsubpackageFactory getAsubpackageFactory() {
		return (AsubpackageFactory)getEFactoryInstance();
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
		aTypeEClass = createEClass(ATYPE);
		createEAttribute(aTypeEClass, ATYPE__NAME);

		aModelEClass = createEClass(AMODEL);
		createEReference(aModelEClass, AMODEL__ELEMENTS);
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
		SubsubpackagePackage theSubsubpackagePackage = (SubsubpackagePackage)EPackage.Registry.INSTANCE.getEPackage(SubsubpackagePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theSubsubpackagePackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(aTypeEClass, AType.class, "AType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAType_Name(), ecorePackage.getEString(), "name", null, 0, 1, AType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aModelEClass, AModel.class, "AModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAModel_Elements(), this.getAType(), null, "elements", null, 0, -1, AModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //AsubpackagePackageImpl
