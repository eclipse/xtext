/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.xtend2.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.xpression.XpressionPackage;

import org.eclipse.xtext.xtend2.xtend2.Xtend2Factory;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendImport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Xtend2PackageImpl extends EPackageImpl implements Xtend2Package
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendClassEClass = null;

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
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Xtend2PackageImpl()
	{
		super(eNS_URI, Xtend2Factory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Xtend2Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Xtend2Package init()
	{
		if (isInited) return (Xtend2Package)EPackage.Registry.INSTANCE.getEPackage(Xtend2Package.eNS_URI);

		// Obtain or create and register package
		Xtend2PackageImpl theXtend2Package = (Xtend2PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Xtend2PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Xtend2PackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XpressionPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theXtend2Package.createPackageContents();

		// Initialize created meta-data
		theXtend2Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXtend2Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Xtend2Package.eNS_URI, theXtend2Package);
		return theXtend2Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXtendFile()
	{
		return xtendFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXtendFile_Imports()
	{
		return (EReference)xtendFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXtendFile_Classes()
	{
		return (EReference)xtendFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXtendFile_Package()
	{
		return (EAttribute)xtendFileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXtendImport()
	{
		return xtendImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXtendImport_ImportedNamespace()
	{
		return (EAttribute)xtendImportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXtendImport_Wildcard()
	{
		return (EAttribute)xtendImportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXtendFunction()
	{
		return xtendFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXtendFunction_Name()
	{
		return (EAttribute)xtendFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXtendFunction_Expression()
	{
		return (EReference)xtendFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXtendClass()
	{
		return xtendClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXtendClass_Name()
	{
		return (EAttribute)xtendClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXtendClass_Extends()
	{
		return (EReference)xtendClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXtendClass_Implements()
	{
		return (EReference)xtendClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xtend2Factory getXtend2Factory()
	{
		return (Xtend2Factory)getEFactoryInstance();
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
		xtendFileEClass = createEClass(XTEND_FILE);
		createEReference(xtendFileEClass, XTEND_FILE__IMPORTS);
		createEReference(xtendFileEClass, XTEND_FILE__CLASSES);
		createEAttribute(xtendFileEClass, XTEND_FILE__PACKAGE);

		xtendImportEClass = createEClass(XTEND_IMPORT);
		createEAttribute(xtendImportEClass, XTEND_IMPORT__IMPORTED_NAMESPACE);
		createEAttribute(xtendImportEClass, XTEND_IMPORT__WILDCARD);

		xtendFunctionEClass = createEClass(XTEND_FUNCTION);
		createEAttribute(xtendFunctionEClass, XTEND_FUNCTION__NAME);
		createEReference(xtendFunctionEClass, XTEND_FUNCTION__EXPRESSION);

		xtendClassEClass = createEClass(XTEND_CLASS);
		createEAttribute(xtendClassEClass, XTEND_CLASS__NAME);
		createEReference(xtendClassEClass, XTEND_CLASS__EXTENDS);
		createEReference(xtendClassEClass, XTEND_CLASS__IMPLEMENTS);
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
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		XpressionPackage theXpressionPackage = (XpressionPackage)EPackage.Registry.INSTANCE.getEPackage(XpressionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		xtendFunctionEClass.getESuperTypes().add(theTypesPackage.getJvmOperation());
		xtendClassEClass.getESuperTypes().add(theTypesPackage.getJvmGenericType());

		// Initialize classes and features; add operations and parameters
		initEClass(xtendFileEClass, XtendFile.class, "XtendFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXtendFile_Imports(), this.getXtendImport(), null, "imports", null, 0, -1, XtendFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXtendFile_Classes(), this.getXtendClass(), null, "classes", null, 0, -1, XtendFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXtendFile_Package(), ecorePackage.getEString(), "package", null, 0, 1, XtendFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xtendImportEClass, XtendImport.class, "XtendImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXtendImport_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, XtendImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXtendImport_Wildcard(), ecorePackage.getEBoolean(), "wildcard", null, 0, 1, XtendImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xtendFunctionEClass, XtendFunction.class, "XtendFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXtendFunction_Name(), ecorePackage.getEString(), "name", null, 0, 1, XtendFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXtendFunction_Expression(), theXpressionPackage.getXExpression(), null, "expression", null, 0, 1, XtendFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xtendClassEClass, XtendClass.class, "XtendClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXtendClass_Name(), ecorePackage.getEString(), "name", null, 0, 1, XtendClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXtendClass_Extends(), theTypesPackage.getJvmTypeReference(), null, "extends", null, 0, 1, XtendClass.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getXtendClass_Implements(), theTypesPackage.getJvmTypeReference(), null, "implements", null, 0, -1, XtendClass.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Xtend2PackageImpl
