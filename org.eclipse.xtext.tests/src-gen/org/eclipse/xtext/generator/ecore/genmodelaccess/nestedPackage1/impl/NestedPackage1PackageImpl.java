/**
 */
package org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.NestedClass1;
import org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.NestedPackage1Factory;
import org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.NestedPackage1Package;

import org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLiteralsPackage;

import org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.impl.NoLiteralsPackageImpl;

import org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootPackage;

import org.eclipse.xtext.generator.ecore.genmodelaccess.root.impl.RootPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NestedPackage1PackageImpl extends EPackageImpl implements NestedPackage1Package
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nestedClass1EClass = null;

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
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.NestedPackage1Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NestedPackage1PackageImpl()
	{
		super(eNS_URI, NestedPackage1Factory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link NestedPackage1Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NestedPackage1Package init()
	{
		if (isInited) return (NestedPackage1Package)EPackage.Registry.INSTANCE.getEPackage(NestedPackage1Package.eNS_URI);

		// Obtain or create and register package
		NestedPackage1PackageImpl theNestedPackage1Package = (NestedPackage1PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NestedPackage1PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NestedPackage1PackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		RootPackageImpl theRootPackage = (RootPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RootPackage.eNS_URI) instanceof RootPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RootPackage.eNS_URI) : RootPackage.eINSTANCE);
		NoLiteralsPackageImpl theNoLiteralsPackage = (NoLiteralsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NoLiteralsPackage.eNS_URI) instanceof NoLiteralsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NoLiteralsPackage.eNS_URI) : NoLiteralsPackage.eINSTANCE);

		// Create package meta-data objects
		theNestedPackage1Package.createPackageContents();
		theRootPackage.createPackageContents();
		theNoLiteralsPackage.createPackageContents();

		// Initialize created meta-data
		theNestedPackage1Package.initializePackageContents();
		theRootPackage.initializePackageContents();
		theNoLiteralsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNestedPackage1Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NestedPackage1Package.eNS_URI, theNestedPackage1Package);
		return theNestedPackage1Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNestedClass1()
	{
		return nestedClass1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedPackage1Factory getNestedPackage1Factory()
	{
		return (NestedPackage1Factory)getEFactoryInstance();
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
		nestedClass1EClass = createEClass(NESTED_CLASS1);
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

		// Initialize classes and features; add operations and parameters
		initEClass(nestedClass1EClass, NestedClass1.class, "NestedClass1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //NestedPackage1PackageImpl
