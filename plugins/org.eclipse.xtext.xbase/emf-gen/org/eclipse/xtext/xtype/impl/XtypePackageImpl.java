/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtypePackageImpl.java,v 1.1 2010/01/14 14:40:21 sefftinge Exp $
 */
package org.eclipse.xtext.xtype.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.impl.XbasePackageImpl;
import org.eclipse.xtext.xpression.XpressionPackage;
import org.eclipse.xtext.xpression.impl.XpressionPackageImpl;
import org.eclipse.xtext.xtype.FunctionTypeRef;
import org.eclipse.xtext.xtype.SimpleTypeRef;
import org.eclipse.xtext.xtype.TypeParamDeclaration;
import org.eclipse.xtext.xtype.TypeRef;
import org.eclipse.xtext.xtype.WildcardParam;
import org.eclipse.xtext.xtype.XtypeFactory;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtypePackageImpl extends EPackageImpl implements XtypePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionTypeRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleTypeRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wildcardParamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeParamDeclarationEClass = null;

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
	 * @see org.eclipse.xtext.xtype.XtypePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private XtypePackageImpl() {
		super(eNS_URI, XtypeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link XtypePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static XtypePackage init() {
		if (isInited) return (XtypePackage)EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI);

		// Obtain or create and register package
		XtypePackageImpl theXtypePackage = (XtypePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XtypePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XtypePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TypesPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		XbasePackageImpl theXbasePackage = (XbasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI) instanceof XbasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI) : XbasePackage.eINSTANCE);
		XpressionPackageImpl theXpressionPackage = (XpressionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XpressionPackage.eNS_URI) instanceof XpressionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XpressionPackage.eNS_URI) : XpressionPackage.eINSTANCE);

		// Create package meta-data objects
		theXtypePackage.createPackageContents();
		theXbasePackage.createPackageContents();
		theXpressionPackage.createPackageContents();

		// Initialize created meta-data
		theXtypePackage.initializePackageContents();
		theXbasePackage.initializePackageContents();
		theXpressionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXtypePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(XtypePackage.eNS_URI, theXtypePackage);
		return theXtypePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeRef() {
		return typeRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionTypeRef() {
		return functionTypeRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionTypeRef_ParamTypes() {
		return (EReference)functionTypeRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionTypeRef_ReturnType() {
		return (EReference)functionTypeRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleTypeRef() {
		return simpleTypeRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleTypeRef_Type() {
		return (EReference)simpleTypeRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleTypeRef_TypeParams() {
		return (EReference)simpleTypeRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWildcardParam() {
		return wildcardParamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWildcardParam_Extends() {
		return (EReference)wildcardParamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWildcardParam_Super() {
		return (EReference)wildcardParamEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeParamDeclaration() {
		return typeParamDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeParamDeclaration_Extends() {
		return (EReference)typeParamDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeParamDeclaration_Super() {
		return (EReference)typeParamDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeParamDeclaration_Name() {
		return (EAttribute)typeParamDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtypeFactory getXtypeFactory() {
		return (XtypeFactory)getEFactoryInstance();
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
		typeRefEClass = createEClass(TYPE_REF);

		functionTypeRefEClass = createEClass(FUNCTION_TYPE_REF);
		createEReference(functionTypeRefEClass, FUNCTION_TYPE_REF__PARAM_TYPES);
		createEReference(functionTypeRefEClass, FUNCTION_TYPE_REF__RETURN_TYPE);

		simpleTypeRefEClass = createEClass(SIMPLE_TYPE_REF);
		createEReference(simpleTypeRefEClass, SIMPLE_TYPE_REF__TYPE);
		createEReference(simpleTypeRefEClass, SIMPLE_TYPE_REF__TYPE_PARAMS);

		wildcardParamEClass = createEClass(WILDCARD_PARAM);
		createEReference(wildcardParamEClass, WILDCARD_PARAM__EXTENDS);
		createEReference(wildcardParamEClass, WILDCARD_PARAM__SUPER);

		typeParamDeclarationEClass = createEClass(TYPE_PARAM_DECLARATION);
		createEReference(typeParamDeclarationEClass, TYPE_PARAM_DECLARATION__EXTENDS);
		createEReference(typeParamDeclarationEClass, TYPE_PARAM_DECLARATION__SUPER);
		createEAttribute(typeParamDeclarationEClass, TYPE_PARAM_DECLARATION__NAME);
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
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		functionTypeRefEClass.getESuperTypes().add(this.getTypeRef());
		simpleTypeRefEClass.getESuperTypes().add(this.getTypeRef());
		wildcardParamEClass.getESuperTypes().add(this.getTypeRef());
		typeParamDeclarationEClass.getESuperTypes().add(theTypesPackage.getType());

		// Initialize classes and features; add operations and parameters
		initEClass(typeRefEClass, TypeRef.class, "TypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(functionTypeRefEClass, FunctionTypeRef.class, "FunctionTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionTypeRef_ParamTypes(), this.getTypeRef(), null, "paramTypes", null, 0, -1, FunctionTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionTypeRef_ReturnType(), this.getTypeRef(), null, "returnType", null, 0, -1, FunctionTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleTypeRefEClass, SimpleTypeRef.class, "SimpleTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimpleTypeRef_Type(), theTypesPackage.getType(), null, "type", null, 0, 1, SimpleTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimpleTypeRef_TypeParams(), this.getTypeRef(), null, "typeParams", null, 0, -1, SimpleTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wildcardParamEClass, WildcardParam.class, "WildcardParam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWildcardParam_Extends(), this.getTypeRef(), null, "extends", null, 0, 1, WildcardParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWildcardParam_Super(), this.getTypeRef(), null, "super", null, 0, 1, WildcardParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeParamDeclarationEClass, TypeParamDeclaration.class, "TypeParamDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeParamDeclaration_Extends(), this.getTypeRef(), null, "extends", null, 0, -1, TypeParamDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeParamDeclaration_Super(), this.getTypeRef(), null, "super", null, 0, 1, TypeParamDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeParamDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypeParamDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //XtypePackageImpl
