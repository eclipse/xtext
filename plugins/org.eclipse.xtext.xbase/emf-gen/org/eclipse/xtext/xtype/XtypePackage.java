/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtype;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public interface XtypePackage extends EPackage
{
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
	 * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl <em>XFunction Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl
	 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXFunctionTypeRef()
	 * @generated
	 */
	int XFUNCTION_TYPE_REF = 0;

	/**
	 * The feature id for the '<em><b>Equivalent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__EQUIVALENT = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT;

	/**
	 * The feature id for the '<em><b>Param Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__PARAM_TYPES = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__RETURN_TYPE = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__TYPE = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Instance Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__INSTANCE_CONTEXT = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>XFunction Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF_FEATURE_COUNT = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImpl <em>XComputed Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImpl
	 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXComputedTypeReference()
	 * @generated
	 */
	int XCOMPUTED_TYPE_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Equivalent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCOMPUTED_TYPE_REFERENCE__EQUIVALENT = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT;

	/**
	 * The feature id for the '<em><b>Type Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCOMPUTED_TYPE_REFERENCE__TYPE_PROVIDER = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XComputed Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCOMPUTED_TYPE_REFERENCE_FEATURE_COUNT = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>IJvm Type Reference Provider</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider
	 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getIJvmTypeReferenceProvider()
	 * @generated
	 */
	int IJVM_TYPE_REFERENCE_PROVIDER = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtype.XFunctionTypeRef <em>XFunction Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XFunction Type Ref</em>'.
	 * @see org.eclipse.xtext.xtype.XFunctionTypeRef
	 * @generated
	 */
	EClass getXFunctionTypeRef();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtype.XFunctionTypeRef#getParamTypes <em>Param Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param Types</em>'.
	 * @see org.eclipse.xtext.xtype.XFunctionTypeRef#getParamTypes()
	 * @see #getXFunctionTypeRef()
	 * @generated
	 */
	EReference getXFunctionTypeRef_ParamTypes();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtype.XFunctionTypeRef#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.eclipse.xtext.xtype.XFunctionTypeRef#getReturnType()
	 * @see #getXFunctionTypeRef()
	 * @generated
	 */
	EReference getXFunctionTypeRef_ReturnType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.xtype.XFunctionTypeRef#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.xtype.XFunctionTypeRef#getType()
	 * @see #getXFunctionTypeRef()
	 * @generated
	 */
	EReference getXFunctionTypeRef_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtype.XFunctionTypeRef#isInstanceContext <em>Instance Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Context</em>'.
	 * @see org.eclipse.xtext.xtype.XFunctionTypeRef#isInstanceContext()
	 * @see #getXFunctionTypeRef()
	 * @generated
	 */
	EAttribute getXFunctionTypeRef_InstanceContext();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtype.XComputedTypeReference <em>XComputed Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XComputed Type Reference</em>'.
	 * @see org.eclipse.xtext.xtype.XComputedTypeReference
	 * @generated
	 */
	EClass getXComputedTypeReference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtype.XComputedTypeReference#getTypeProvider <em>Type Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Provider</em>'.
	 * @see org.eclipse.xtext.xtype.XComputedTypeReference#getTypeProvider()
	 * @see #getXComputedTypeReference()
	 * @generated
	 */
	EAttribute getXComputedTypeReference_TypeProvider();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider <em>IJvm Type Reference Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IJvm Type Reference Provider</em>'.
	 * @see org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider
	 * @model instanceClass="org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider" serializeable="false"
	 * @generated
	 */
	EDataType getIJvmTypeReferenceProvider();

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
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl <em>XFunction Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl
		 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXFunctionTypeRef()
		 * @generated
		 */
		EClass XFUNCTION_TYPE_REF = eINSTANCE.getXFunctionTypeRef();

		/**
		 * The meta object literal for the '<em><b>Param Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFUNCTION_TYPE_REF__PARAM_TYPES = eINSTANCE.getXFunctionTypeRef_ParamTypes();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFUNCTION_TYPE_REF__RETURN_TYPE = eINSTANCE.getXFunctionTypeRef_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFUNCTION_TYPE_REF__TYPE = eINSTANCE.getXFunctionTypeRef_Type();

		/**
		 * The meta object literal for the '<em><b>Instance Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XFUNCTION_TYPE_REF__INSTANCE_CONTEXT = eINSTANCE.getXFunctionTypeRef_InstanceContext();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImpl <em>XComputed Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImpl
		 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXComputedTypeReference()
		 * @generated
		 */
		EClass XCOMPUTED_TYPE_REFERENCE = eINSTANCE.getXComputedTypeReference();

		/**
		 * The meta object literal for the '<em><b>Type Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCOMPUTED_TYPE_REFERENCE__TYPE_PROVIDER = eINSTANCE.getXComputedTypeReference_TypeProvider();

		/**
		 * The meta object literal for the '<em>IJvm Type Reference Provider</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider
		 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getIJvmTypeReferenceProvider()
		 * @generated
		 */
		EDataType IJVM_TYPE_REFERENCE_PROVIDER = eINSTANCE.getIJvmTypeReferenceProvider();

	}

} //XtypePackage
