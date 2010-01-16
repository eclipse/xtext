/**
 * <copyright>
 * </copyright>
 *
 * $Id: XbasePackageImpl.java,v 1.3 2010/01/16 08:50:53 sefftinge Exp $
 */
package org.eclipse.xtext.xbase.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.xbase.XClass;
import org.eclipse.xtext.xbase.XFile;
import org.eclipse.xtext.xbase.XFunction;
import org.eclipse.xtext.xbase.XImport;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.XbasePackage;

import org.eclipse.xtext.xpression.XpressionPackage;

import org.eclipse.xtext.xpression.impl.XpressionPackageImpl;

import org.eclipse.xtext.xtype.XtypePackage;

import org.eclipse.xtext.xtype.impl.XtypePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XbasePackageImpl extends EPackageImpl implements XbasePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xClassEClass = null;

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
	 * @see org.eclipse.xtext.xbase.XbasePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private XbasePackageImpl() {
		super(eNS_URI, XbaseFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link XbasePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static XbasePackage init() {
		if (isInited) return (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

		// Obtain or create and register package
		XbasePackageImpl theXbasePackage = (XbasePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XbasePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XbasePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TypesPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		XtypePackageImpl theXtypePackage = (XtypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI) instanceof XtypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI) : XtypePackage.eINSTANCE);
		XpressionPackageImpl theXpressionPackage = (XpressionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XpressionPackage.eNS_URI) instanceof XpressionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XpressionPackage.eNS_URI) : XpressionPackage.eINSTANCE);

		// Create package meta-data objects
		theXbasePackage.createPackageContents();
		theXtypePackage.createPackageContents();
		theXpressionPackage.createPackageContents();

		// Initialize created meta-data
		theXbasePackage.initializePackageContents();
		theXtypePackage.initializePackageContents();
		theXpressionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXbasePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(XbasePackage.eNS_URI, theXbasePackage);
		return theXbasePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXFile() {
		return xFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFile_Imports() {
		return (EReference)xFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFile_Classes() {
		return (EReference)xFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXFile_Package() {
		return (EAttribute)xFileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXImport() {
		return xImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXImport_ImportedNamespace() {
		return (EAttribute)xImportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXImport_Wildcard() {
		return (EAttribute)xImportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXFunction() {
		return xFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXFunction_Private() {
		return (EAttribute)xFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFunction_TypeParams() {
		return (EReference)xFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFunction_ReturnType() {
		return (EReference)xFunctionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXFunction_Name() {
		return (EAttribute)xFunctionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFunction_DeclaredParams() {
		return (EReference)xFunctionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFunction_Expression() {
		return (EReference)xFunctionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXClass() {
		return xClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXClass_Name() {
		return (EAttribute)xClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXClass_Extends() {
		return (EReference)xClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXClass_Implements() {
		return (EReference)xClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXClass_Functions() {
		return (EReference)xClassEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XbaseFactory getXbaseFactory() {
		return (XbaseFactory)getEFactoryInstance();
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
		xFileEClass = createEClass(XFILE);
		createEReference(xFileEClass, XFILE__IMPORTS);
		createEReference(xFileEClass, XFILE__CLASSES);
		createEAttribute(xFileEClass, XFILE__PACKAGE);

		xImportEClass = createEClass(XIMPORT);
		createEAttribute(xImportEClass, XIMPORT__IMPORTED_NAMESPACE);
		createEAttribute(xImportEClass, XIMPORT__WILDCARD);

		xFunctionEClass = createEClass(XFUNCTION);
		createEAttribute(xFunctionEClass, XFUNCTION__PRIVATE);
		createEReference(xFunctionEClass, XFUNCTION__TYPE_PARAMS);
		createEReference(xFunctionEClass, XFUNCTION__RETURN_TYPE);
		createEAttribute(xFunctionEClass, XFUNCTION__NAME);
		createEReference(xFunctionEClass, XFUNCTION__DECLARED_PARAMS);
		createEReference(xFunctionEClass, XFUNCTION__EXPRESSION);

		xClassEClass = createEClass(XCLASS);
		createEAttribute(xClassEClass, XCLASS__NAME);
		createEReference(xClassEClass, XCLASS__EXTENDS);
		createEReference(xClassEClass, XCLASS__IMPLEMENTS);
		createEReference(xClassEClass, XCLASS__FUNCTIONS);
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
		XtypePackage theXtypePackage = (XtypePackage)EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI);
		XpressionPackage theXpressionPackage = (XpressionPackage)EPackage.Registry.INSTANCE.getEPackage(XpressionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(xFileEClass, XFile.class, "XFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXFile_Imports(), this.getXImport(), null, "imports", null, 0, -1, XFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXFile_Classes(), this.getXClass(), null, "classes", null, 0, -1, XFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXFile_Package(), ecorePackage.getEString(), "package", null, 0, 1, XFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xImportEClass, XImport.class, "XImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXImport_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, XImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXImport_Wildcard(), ecorePackage.getEBoolean(), "wildcard", null, 0, 1, XImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xFunctionEClass, XFunction.class, "XFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXFunction_Private(), ecorePackage.getEBoolean(), "private", null, 0, 1, XFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXFunction_TypeParams(), theXtypePackage.getXTypeParamDeclaration(), null, "typeParams", null, 0, -1, XFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXFunction_ReturnType(), theXtypePackage.getXTypeRef(), null, "returnType", null, 0, 1, XFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXFunction_Name(), ecorePackage.getEString(), "name", null, 0, 1, XFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXFunction_DeclaredParams(), theXpressionPackage.getXDeclaredParameter(), null, "declaredParams", null, 0, -1, XFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXFunction_Expression(), theXpressionPackage.getXExpression(), null, "expression", null, 0, 1, XFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xClassEClass, XClass.class, "XClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXClass_Name(), ecorePackage.getEString(), "name", null, 0, 1, XClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXClass_Extends(), theXtypePackage.getXTypeRef(), null, "extends", null, 0, 1, XClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXClass_Implements(), theXtypePackage.getXTypeRef(), null, "implements", null, 0, -1, XClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXClass_Functions(), this.getXFunction(), null, "functions", null, 0, -1, XClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //XbasePackageImpl
