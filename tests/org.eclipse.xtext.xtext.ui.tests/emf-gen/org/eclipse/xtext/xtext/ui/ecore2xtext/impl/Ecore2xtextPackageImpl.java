/**
 * <copyright>
 * </copyright>
 *
 * $Id: Ecore2xtextPackageImpl.java,v 1.2 2010/03/10 16:34:10 jkohnlein Exp $
 */
package org.eclipse.xtext.xtext.ui.ecore2xtext.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.xtext.ui.ecore2xtext.Abstract;
import org.eclipse.xtext.xtext.ui.ecore2xtext.Concrete0;
import org.eclipse.xtext.xtext.ui.ecore2xtext.Concrete1;
import org.eclipse.xtext.xtext.ui.ecore2xtext.DiamondInheritance;
import org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2xtextFactory;
import org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2xtextPackage;
import org.eclipse.xtext.xtext.ui.ecore2xtext.Root;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Ecore2xtextPackageImpl extends EPackageImpl implements Ecore2xtextPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concrete0EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concrete1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diamondInheritanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType intEDataType = null;

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
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2xtextPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Ecore2xtextPackageImpl() {
		super(eNS_URI, Ecore2xtextFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Ecore2xtextPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Ecore2xtextPackage init() {
		if (isInited) return (Ecore2xtextPackage)EPackage.Registry.INSTANCE.getEPackage(Ecore2xtextPackage.eNS_URI);

		// Obtain or create and register package
		Ecore2xtextPackageImpl theEcore2xtextPackage = (Ecore2xtextPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Ecore2xtextPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Ecore2xtextPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEcore2xtextPackage.createPackageContents();

		// Initialize created meta-data
		theEcore2xtextPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEcore2xtextPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Ecore2xtextPackage.eNS_URI, theEcore2xtextPackage);
		return theEcore2xtextPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstract() {
		return abstractEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstract_Name() {
		return (EAttribute)abstractEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcrete0() {
		return concrete0EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcrete1() {
		return concrete1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoot() {
		return rootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_Classes() {
		return (EReference)rootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoot_Name() {
		return (EAttribute)rootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiamondInheritance() {
		return diamondInheritanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getINT() {
		return intEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ecore2xtextFactory getEcore2xtextFactory() {
		return (Ecore2xtextFactory)getEFactoryInstance();
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
		abstractEClass = createEClass(ABSTRACT);
		createEAttribute(abstractEClass, ABSTRACT__NAME);

		concrete0EClass = createEClass(CONCRETE0);

		concrete1EClass = createEClass(CONCRETE1);

		rootEClass = createEClass(ROOT);
		createEReference(rootEClass, ROOT__CLASSES);
		createEAttribute(rootEClass, ROOT__NAME);

		diamondInheritanceEClass = createEClass(DIAMOND_INHERITANCE);

		// Create data types
		intEDataType = createEDataType(INT);
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
		concrete0EClass.getESuperTypes().add(this.getAbstract());
		concrete1EClass.getESuperTypes().add(this.getAbstract());
		diamondInheritanceEClass.getESuperTypes().add(this.getConcrete0());
		diamondInheritanceEClass.getESuperTypes().add(this.getConcrete1());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractEClass, Abstract.class, "Abstract", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstract_Name(), ecorePackage.getEString(), "name", null, 0, 1, Abstract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(concrete0EClass, Concrete0.class, "Concrete0", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(concrete1EClass, Concrete1.class, "Concrete1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoot_Classes(), this.getAbstract(), null, "classes", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoot_Name(), this.getINT(), "name", null, 0, 1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(diamondInheritanceEClass, DiamondInheritance.class, "DiamondInheritance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(intEDataType, String.class, "INT", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //Ecore2xtextPackageImpl
