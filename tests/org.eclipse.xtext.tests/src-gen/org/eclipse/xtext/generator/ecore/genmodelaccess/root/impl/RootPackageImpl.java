/**
 */
package org.eclipse.xtext.generator.ecore.genmodelaccess.root.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.NestedPackage1Package;

import org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.impl.NestedPackage1PackageImpl;

import org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLiteralsPackage;

import org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.impl.NoLiteralsPackageImpl;

import org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootClass;
import org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootEnum;
import org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootFactory;
import org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RootPackageImpl extends EPackageImpl implements RootPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum rootEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType rootDataTypeEDataType = null;

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
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RootPackageImpl()
	{
		super(eNS_URI, RootFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RootPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RootPackage init()
	{
		if (isInited) return (RootPackage)EPackage.Registry.INSTANCE.getEPackage(RootPackage.eNS_URI);

		// Obtain or create and register package
		RootPackageImpl theRootPackage = (RootPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RootPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RootPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		NestedPackage1PackageImpl theNestedPackage1Package = (NestedPackage1PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NestedPackage1Package.eNS_URI) instanceof NestedPackage1PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NestedPackage1Package.eNS_URI) : NestedPackage1Package.eINSTANCE);
		NoLiteralsPackageImpl theNoLiteralsPackage = (NoLiteralsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NoLiteralsPackage.eNS_URI) instanceof NoLiteralsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NoLiteralsPackage.eNS_URI) : NoLiteralsPackage.eINSTANCE);

		// Create package meta-data objects
		theRootPackage.createPackageContents();
		theNestedPackage1Package.createPackageContents();
		theNoLiteralsPackage.createPackageContents();

		// Initialize created meta-data
		theRootPackage.initializePackageContents();
		theNestedPackage1Package.initializePackageContents();
		theNoLiteralsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRootPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RootPackage.eNS_URI, theRootPackage);
		return theRootPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRootClass()
	{
		return rootClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRootClass_Attribute1()
	{
		return (EAttribute)rootClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRootClass_Reference1()
	{
		return (EReference)rootClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRootEnum()
	{
		return rootEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRootDataType()
	{
		return rootDataTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootFactory getRootFactory()
	{
		return (RootFactory)getEFactoryInstance();
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
		rootClassEClass = createEClass(ROOT_CLASS);
		createEAttribute(rootClassEClass, ROOT_CLASS__ATTRIBUTE1);
		createEReference(rootClassEClass, ROOT_CLASS__REFERENCE1);

		// Create enums
		rootEnumEEnum = createEEnum(ROOT_ENUM);

		// Create data types
		rootDataTypeEDataType = createEDataType(ROOT_DATA_TYPE);
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

		// Obtain other dependent packages
		NestedPackage1Package theNestedPackage1Package = (NestedPackage1Package)EPackage.Registry.INSTANCE.getEPackage(NestedPackage1Package.eNS_URI);
		NoLiteralsPackage theNoLiteralsPackage = (NoLiteralsPackage)EPackage.Registry.INSTANCE.getEPackage(NoLiteralsPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theNestedPackage1Package);
		getESubpackages().add(theNoLiteralsPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(rootClassEClass, RootClass.class, "RootClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRootClass_Attribute1(), ecorePackage.getEString(), "attribute1", null, 0, 1, RootClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRootClass_Reference1(), theNestedPackage1Package.getNestedClass1(), null, "reference1", null, 0, 1, RootClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(rootEnumEEnum, RootEnum.class, "RootEnum");
		addEEnumLiteral(rootEnumEEnum, RootEnum.LITERAL);

		// Initialize data types
		initEDataType(rootDataTypeEDataType, String.class, "RootDataType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //RootPackageImpl
