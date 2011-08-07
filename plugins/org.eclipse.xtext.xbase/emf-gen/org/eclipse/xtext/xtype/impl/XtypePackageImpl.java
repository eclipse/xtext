/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtype.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.xbase.XbasePackage;

import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;

import org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationsPackageImpl;

import org.eclipse.xtext.xbase.impl.XbasePackageImpl;

import org.eclipse.xtext.xtype.XDelegateTypeReference;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XSynonymTypeReference;
import org.eclipse.xtext.xtype.XtypeFactory;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtypePackageImpl extends EPackageImpl implements XtypePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xFunctionTypeRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xSynonymTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xDelegateTypeReferenceEClass = null;

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
	private XtypePackageImpl()
	{
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
	public static XtypePackage init()
	{
		if (isInited) return (XtypePackage)EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI);

		// Obtain or create and register package
		XtypePackageImpl theXtypePackage = (XtypePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XtypePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XtypePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TypesPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		XAnnotationsPackageImpl theXAnnotationsPackage = (XAnnotationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XAnnotationsPackage.eNS_URI) instanceof XAnnotationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XAnnotationsPackage.eNS_URI) : XAnnotationsPackage.eINSTANCE);
		XbasePackageImpl theXbasePackage = (XbasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI) instanceof XbasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI) : XbasePackage.eINSTANCE);

		// Create package meta-data objects
		theXtypePackage.createPackageContents();
		theXAnnotationsPackage.createPackageContents();
		theXbasePackage.createPackageContents();

		// Initialize created meta-data
		theXtypePackage.initializePackageContents();
		theXAnnotationsPackage.initializePackageContents();
		theXbasePackage.initializePackageContents();

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
	public EClass getXFunctionTypeRef()
	{
		return xFunctionTypeRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFunctionTypeRef_ParamTypes()
	{
		return (EReference)xFunctionTypeRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFunctionTypeRef_ReturnType()
	{
		return (EReference)xFunctionTypeRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSynonymTypeReference()
	{
		return xSynonymTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSynonymTypeReference_Synonymes()
	{
		return (EReference)xSynonymTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSynonymTypeReference_Type()
	{
		return (EReference)xSynonymTypeReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXDelegateTypeReference()
	{
		return xDelegateTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXDelegateTypeReference_Delegate()
	{
		return (EReference)xDelegateTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtypeFactory getXtypeFactory()
	{
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
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		xFunctionTypeRefEClass = createEClass(XFUNCTION_TYPE_REF);
		createEReference(xFunctionTypeRefEClass, XFUNCTION_TYPE_REF__PARAM_TYPES);
		createEReference(xFunctionTypeRefEClass, XFUNCTION_TYPE_REF__RETURN_TYPE);

		xSynonymTypeReferenceEClass = createEClass(XSYNONYM_TYPE_REFERENCE);
		createEReference(xSynonymTypeReferenceEClass, XSYNONYM_TYPE_REFERENCE__SYNONYMES);
		createEReference(xSynonymTypeReferenceEClass, XSYNONYM_TYPE_REFERENCE__TYPE);

		xDelegateTypeReferenceEClass = createEClass(XDELEGATE_TYPE_REFERENCE);
		createEReference(xDelegateTypeReferenceEClass, XDELEGATE_TYPE_REFERENCE__DELEGATE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		xFunctionTypeRefEClass.getESuperTypes().add(theTypesPackage.getJvmParameterizedTypeReference());
		xSynonymTypeReferenceEClass.getESuperTypes().add(theTypesPackage.getJvmTypeReference());
		xDelegateTypeReferenceEClass.getESuperTypes().add(theTypesPackage.getJvmTypeReference());

		// Initialize classes and features; add operations and parameters
		initEClass(xFunctionTypeRefEClass, XFunctionTypeRef.class, "XFunctionTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXFunctionTypeRef_ParamTypes(), theTypesPackage.getJvmTypeReference(), null, "paramTypes", null, 0, -1, XFunctionTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXFunctionTypeRef_ReturnType(), theTypesPackage.getJvmTypeReference(), null, "returnType", null, 0, 1, XFunctionTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xSynonymTypeReferenceEClass, XSynonymTypeReference.class, "XSynonymTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXSynonymTypeReference_Synonymes(), theTypesPackage.getJvmTypeReference(), null, "synonymes", null, 0, -1, XSynonymTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSynonymTypeReference_Type(), theTypesPackage.getJvmType(), null, "type", null, 0, 1, XSynonymTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(xSynonymTypeReferenceEClass, theTypesPackage.getJvmTypeReference(), "getPrimaryType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(xDelegateTypeReferenceEClass, XDelegateTypeReference.class, "XDelegateTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXDelegateTypeReference_Delegate(), theTypesPackage.getJvmTypeReference(), null, "delegate", null, 0, 1, XDelegateTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //XtypePackageImpl
