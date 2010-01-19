/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtypePackageImpl.java,v 1.4 2010/01/19 19:53:07 sefftinge Exp $
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

import org.eclipse.xtext.xtype.XAbstractTypeParamDeclaration;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XSimpleTypeRef;
import org.eclipse.xtext.xtype.XTypeParamDeclaration;
import org.eclipse.xtext.xtype.XTypeRef;
import org.eclipse.xtext.xtype.XWildcardParam;
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
  private EClass xTypeRefEClass = null;

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
  private EClass xSimpleTypeRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xWildcardParamEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xAbstractTypeParamDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xTypeParamDeclarationEClass = null;

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
  public EClass getXTypeRef()
  {
    return xTypeRefEClass;
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
  public EClass getXSimpleTypeRef()
  {
    return xSimpleTypeRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXSimpleTypeRef_Type()
  {
    return (EReference)xSimpleTypeRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXSimpleTypeRef_TypeParams()
  {
    return (EReference)xSimpleTypeRefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXWildcardParam()
  {
    return xWildcardParamEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXWildcardParam_Extends()
  {
    return (EReference)xWildcardParamEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXWildcardParam_Super()
  {
    return (EReference)xWildcardParamEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXAbstractTypeParamDeclaration()
  {
    return xAbstractTypeParamDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXAbstractTypeParamDeclaration_Extends()
  {
    return (EReference)xAbstractTypeParamDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXAbstractTypeParamDeclaration_Super()
  {
    return (EReference)xAbstractTypeParamDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getXAbstractTypeParamDeclaration_Name()
  {
    return (EAttribute)xAbstractTypeParamDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXTypeParamDeclaration()
  {
    return xTypeParamDeclarationEClass;
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
    xTypeRefEClass = createEClass(XTYPE_REF);

    xFunctionTypeRefEClass = createEClass(XFUNCTION_TYPE_REF);
    createEReference(xFunctionTypeRefEClass, XFUNCTION_TYPE_REF__PARAM_TYPES);
    createEReference(xFunctionTypeRefEClass, XFUNCTION_TYPE_REF__RETURN_TYPE);

    xSimpleTypeRefEClass = createEClass(XSIMPLE_TYPE_REF);
    createEReference(xSimpleTypeRefEClass, XSIMPLE_TYPE_REF__TYPE);
    createEReference(xSimpleTypeRefEClass, XSIMPLE_TYPE_REF__TYPE_PARAMS);

    xWildcardParamEClass = createEClass(XWILDCARD_PARAM);
    createEReference(xWildcardParamEClass, XWILDCARD_PARAM__EXTENDS);
    createEReference(xWildcardParamEClass, XWILDCARD_PARAM__SUPER);

    xAbstractTypeParamDeclarationEClass = createEClass(XABSTRACT_TYPE_PARAM_DECLARATION);
    createEReference(xAbstractTypeParamDeclarationEClass, XABSTRACT_TYPE_PARAM_DECLARATION__EXTENDS);
    createEReference(xAbstractTypeParamDeclarationEClass, XABSTRACT_TYPE_PARAM_DECLARATION__SUPER);
    createEAttribute(xAbstractTypeParamDeclarationEClass, XABSTRACT_TYPE_PARAM_DECLARATION__NAME);

    xTypeParamDeclarationEClass = createEClass(XTYPE_PARAM_DECLARATION);
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
    xFunctionTypeRefEClass.getESuperTypes().add(this.getXTypeRef());
    xSimpleTypeRefEClass.getESuperTypes().add(this.getXTypeRef());
    xWildcardParamEClass.getESuperTypes().add(this.getXTypeRef());
    xAbstractTypeParamDeclarationEClass.getESuperTypes().add(theTypesPackage.getType());
    xTypeParamDeclarationEClass.getESuperTypes().add(this.getXAbstractTypeParamDeclaration());

    // Initialize classes and features; add operations and parameters
    initEClass(xTypeRefEClass, XTypeRef.class, "XTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(xFunctionTypeRefEClass, XFunctionTypeRef.class, "XFunctionTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXFunctionTypeRef_ParamTypes(), this.getXTypeRef(), null, "paramTypes", null, 0, -1, XFunctionTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXFunctionTypeRef_ReturnType(), this.getXTypeRef(), null, "returnType", null, 0, 1, XFunctionTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xSimpleTypeRefEClass, XSimpleTypeRef.class, "XSimpleTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXSimpleTypeRef_Type(), theTypesPackage.getType(), null, "type", null, 0, 1, XSimpleTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXSimpleTypeRef_TypeParams(), this.getXTypeRef(), null, "typeParams", null, 0, -1, XSimpleTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xWildcardParamEClass, XWildcardParam.class, "XWildcardParam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXWildcardParam_Extends(), this.getXTypeRef(), null, "extends", null, 0, 1, XWildcardParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXWildcardParam_Super(), this.getXTypeRef(), null, "super", null, 0, 1, XWildcardParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xAbstractTypeParamDeclarationEClass, XAbstractTypeParamDeclaration.class, "XAbstractTypeParamDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXAbstractTypeParamDeclaration_Extends(), this.getXTypeRef(), null, "extends", null, 0, -1, XAbstractTypeParamDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXAbstractTypeParamDeclaration_Super(), this.getXTypeRef(), null, "super", null, 0, 1, XAbstractTypeParamDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getXAbstractTypeParamDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, XAbstractTypeParamDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xTypeParamDeclarationEClass, XTypeParamDeclaration.class, "XTypeParamDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //XtypePackageImpl
