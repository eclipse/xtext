/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtypePackage.java,v 1.2 2010/01/14 15:53:25 sefftinge Exp $
 */
package org.eclipse.xtext.xtype;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xtype.XtypeFactory
 * @model kind="package"
 * @generated
 */
public interface XtypePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xtype";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/xtext/xbase/Xtype";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xtype";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XtypePackage eINSTANCE = org.eclipse.xtext.xtype.impl.XtypePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.TypeRefImpl <em>Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtype.impl.TypeRefImpl
	 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getTypeRef()
	 * @generated
	 */
	int TYPE_REF = 0;

	/**
	 * The number of structural features of the '<em>Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.FunctionTypeRefImpl <em>Function Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtype.impl.FunctionTypeRefImpl
	 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getFunctionTypeRef()
	 * @generated
	 */
	int FUNCTION_TYPE_REF = 1;

	/**
	 * The feature id for the '<em><b>Param Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_REF__PARAM_TYPES = TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_REF__RETURN_TYPE = TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TYPE_REF_FEATURE_COUNT = TYPE_REF_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.SimpleTypeRefImpl <em>Simple Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtype.impl.SimpleTypeRefImpl
	 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getSimpleTypeRef()
	 * @generated
	 */
	int SIMPLE_TYPE_REF = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE_REF__TYPE = TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE_REF__TYPE_PARAMS = TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE_REF_FEATURE_COUNT = TYPE_REF_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.WildcardParamImpl <em>Wildcard Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtype.impl.WildcardParamImpl
	 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getWildcardParam()
	 * @generated
	 */
	int WILDCARD_PARAM = 3;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_PARAM__EXTENDS = TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_PARAM__SUPER = TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Wildcard Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_PARAM_FEATURE_COUNT = TYPE_REF_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.TypeParamDeclarationImpl <em>Type Param Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtype.impl.TypeParamDeclarationImpl
	 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getTypeParamDeclaration()
	 * @generated
	 */
	int TYPE_PARAM_DECLARATION = 4;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAM_DECLARATION__EXTENDS = TypesPackage.TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAM_DECLARATION__SUPER = TypesPackage.TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAM_DECLARATION__NAME = TypesPackage.TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Type Param Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAM_DECLARATION_FEATURE_COUNT = TypesPackage.TYPE_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtype.TypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Ref</em>'.
	 * @see org.eclipse.xtext.xtype.TypeRef
	 * @generated
	 */
	EClass getTypeRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtype.FunctionTypeRef <em>Function Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Type Ref</em>'.
	 * @see org.eclipse.xtext.xtype.FunctionTypeRef
	 * @generated
	 */
	EClass getFunctionTypeRef();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtype.FunctionTypeRef#getParamTypes <em>Param Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param Types</em>'.
	 * @see org.eclipse.xtext.xtype.FunctionTypeRef#getParamTypes()
	 * @see #getFunctionTypeRef()
	 * @generated
	 */
	EReference getFunctionTypeRef_ParamTypes();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtype.FunctionTypeRef#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.eclipse.xtext.xtype.FunctionTypeRef#getReturnType()
	 * @see #getFunctionTypeRef()
	 * @generated
	 */
	EReference getFunctionTypeRef_ReturnType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtype.SimpleTypeRef <em>Simple Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Type Ref</em>'.
	 * @see org.eclipse.xtext.xtype.SimpleTypeRef
	 * @generated
	 */
	EClass getSimpleTypeRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.xtype.SimpleTypeRef#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.xtype.SimpleTypeRef#getType()
	 * @see #getSimpleTypeRef()
	 * @generated
	 */
	EReference getSimpleTypeRef_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtype.SimpleTypeRef#getTypeParams <em>Type Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Params</em>'.
	 * @see org.eclipse.xtext.xtype.SimpleTypeRef#getTypeParams()
	 * @see #getSimpleTypeRef()
	 * @generated
	 */
	EReference getSimpleTypeRef_TypeParams();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtype.WildcardParam <em>Wildcard Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wildcard Param</em>'.
	 * @see org.eclipse.xtext.xtype.WildcardParam
	 * @generated
	 */
	EClass getWildcardParam();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtype.WildcardParam#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends</em>'.
	 * @see org.eclipse.xtext.xtype.WildcardParam#getExtends()
	 * @see #getWildcardParam()
	 * @generated
	 */
	EReference getWildcardParam_Extends();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtype.WildcardParam#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Super</em>'.
	 * @see org.eclipse.xtext.xtype.WildcardParam#getSuper()
	 * @see #getWildcardParam()
	 * @generated
	 */
	EReference getWildcardParam_Super();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtype.TypeParamDeclaration <em>Type Param Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Param Declaration</em>'.
	 * @see org.eclipse.xtext.xtype.TypeParamDeclaration
	 * @generated
	 */
	EClass getTypeParamDeclaration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtype.TypeParamDeclaration#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extends</em>'.
	 * @see org.eclipse.xtext.xtype.TypeParamDeclaration#getExtends()
	 * @see #getTypeParamDeclaration()
	 * @generated
	 */
	EReference getTypeParamDeclaration_Extends();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtype.TypeParamDeclaration#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Super</em>'.
	 * @see org.eclipse.xtext.xtype.TypeParamDeclaration#getSuper()
	 * @see #getTypeParamDeclaration()
	 * @generated
	 */
	EReference getTypeParamDeclaration_Super();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtype.TypeParamDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.xtype.TypeParamDeclaration#getName()
	 * @see #getTypeParamDeclaration()
	 * @generated
	 */
	EAttribute getTypeParamDeclaration_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XtypeFactory getXtypeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.TypeRefImpl <em>Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtype.impl.TypeRefImpl
		 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getTypeRef()
		 * @generated
		 */
		EClass TYPE_REF = eINSTANCE.getTypeRef();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.FunctionTypeRefImpl <em>Function Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtype.impl.FunctionTypeRefImpl
		 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getFunctionTypeRef()
		 * @generated
		 */
		EClass FUNCTION_TYPE_REF = eINSTANCE.getFunctionTypeRef();

		/**
		 * The meta object literal for the '<em><b>Param Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TYPE_REF__PARAM_TYPES = eINSTANCE.getFunctionTypeRef_ParamTypes();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TYPE_REF__RETURN_TYPE = eINSTANCE.getFunctionTypeRef_ReturnType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.SimpleTypeRefImpl <em>Simple Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtype.impl.SimpleTypeRefImpl
		 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getSimpleTypeRef()
		 * @generated
		 */
		EClass SIMPLE_TYPE_REF = eINSTANCE.getSimpleTypeRef();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_TYPE_REF__TYPE = eINSTANCE.getSimpleTypeRef_Type();

		/**
		 * The meta object literal for the '<em><b>Type Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_TYPE_REF__TYPE_PARAMS = eINSTANCE.getSimpleTypeRef_TypeParams();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.WildcardParamImpl <em>Wildcard Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtype.impl.WildcardParamImpl
		 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getWildcardParam()
		 * @generated
		 */
		EClass WILDCARD_PARAM = eINSTANCE.getWildcardParam();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WILDCARD_PARAM__EXTENDS = eINSTANCE.getWildcardParam_Extends();

		/**
		 * The meta object literal for the '<em><b>Super</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WILDCARD_PARAM__SUPER = eINSTANCE.getWildcardParam_Super();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.TypeParamDeclarationImpl <em>Type Param Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtype.impl.TypeParamDeclarationImpl
		 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getTypeParamDeclaration()
		 * @generated
		 */
		EClass TYPE_PARAM_DECLARATION = eINSTANCE.getTypeParamDeclaration();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_PARAM_DECLARATION__EXTENDS = eINSTANCE.getTypeParamDeclaration_Extends();

		/**
		 * The meta object literal for the '<em><b>Super</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_PARAM_DECLARATION__SUPER = eINSTANCE.getTypeParamDeclaration_Super();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_PARAM_DECLARATION__NAME = eINSTANCE.getTypeParamDeclaration_Name();

	}

} //XtypePackage
