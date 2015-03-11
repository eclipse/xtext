/**
 */
package org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.NestedPackage1Package;

import org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.impl.NestedPackage1PackageImpl;

import org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLitClass;
import org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLitEnum;
import org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLiteralsFactory;
import org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLiteralsPackage;

import org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootPackage;

import org.eclipse.xtext.generator.ecore.genmodelaccess.root.impl.RootPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NoLiteralsPackageImpl extends EPackageImpl implements NoLiteralsPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass noLitClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum noLitEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType noLitDataTypeEDataType = null;

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
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLiteralsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NoLiteralsPackageImpl()
	{
		super(eNS_URI, NoLiteralsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link NoLiteralsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NoLiteralsPackage init()
	{
		if (isInited) return (NoLiteralsPackage)EPackage.Registry.INSTANCE.getEPackage(NoLiteralsPackage.eNS_URI);

		// Obtain or create and register package
		NoLiteralsPackageImpl theNoLiteralsPackage = (NoLiteralsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NoLiteralsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NoLiteralsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		RootPackageImpl theRootPackage = (RootPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RootPackage.eNS_URI) instanceof RootPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RootPackage.eNS_URI) : RootPackage.eINSTANCE);
		NestedPackage1PackageImpl theNestedPackage1Package = (NestedPackage1PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NestedPackage1Package.eNS_URI) instanceof NestedPackage1PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NestedPackage1Package.eNS_URI) : NestedPackage1Package.eINSTANCE);

		// Create package meta-data objects
		theNoLiteralsPackage.createPackageContents();
		theRootPackage.createPackageContents();
		theNestedPackage1Package.createPackageContents();

		// Initialize created meta-data
		theNoLiteralsPackage.initializePackageContents();
		theRootPackage.initializePackageContents();
		theNestedPackage1Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNoLiteralsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NoLiteralsPackage.eNS_URI, theNoLiteralsPackage);
		return theNoLiteralsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNoLitClass()
	{
		return noLitClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNoLitClass_Attribute2()
	{
		return (EAttribute)noLitClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNoLitClass_Reference2()
	{
		return (EReference)noLitClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNoLitEnum()
	{
		return noLitEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNoLitDataType()
	{
		return noLitDataTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoLiteralsFactory getNoLiteralsFactory()
	{
		return (NoLiteralsFactory)getEFactoryInstance();
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
		noLitClassEClass = createEClass(NO_LIT_CLASS);
		createEAttribute(noLitClassEClass, NO_LIT_CLASS__ATTRIBUTE2);
		createEReference(noLitClassEClass, NO_LIT_CLASS__REFERENCE2);

		// Create enums
		noLitEnumEEnum = createEEnum(NO_LIT_ENUM);

		// Create data types
		noLitDataTypeEDataType = createEDataType(NO_LIT_DATA_TYPE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(noLitClassEClass, NoLitClass.class, "NoLitClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNoLitClass_Attribute2(), ecorePackage.getEString(), "attribute2", null, 0, 1, NoLitClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNoLitClass_Reference2(), theNestedPackage1Package.getNestedClass1(), null, "reference2", null, 0, 1, NoLitClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(noLitEnumEEnum, NoLitEnum.class, "NoLitEnum");
		addEEnumLiteral(noLitEnumEEnum, NoLitEnum.LITERAL);

		// Initialize data types
		initEDataType(noLitDataTypeEDataType, String.class, "NoLitDataType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
	}

} //NoLiteralsPackageImpl
