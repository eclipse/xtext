/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
 * <!-- begin-model-doc -->
 * @since 2.7
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * <!-- end-model-doc -->
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
	 * @since 2.7
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
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__PARAM_TYPES = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__RETURN_TYPE = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__TYPE = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Instance Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__INSTANCE_CONTEXT = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>XFunction Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
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
	 * @since 2.7
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
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XCOMPUTED_TYPE_REFERENCE__TYPE_PROVIDER = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XComputed Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XCOMPUTED_TYPE_REFERENCE_FEATURE_COUNT = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.XImportSectionImpl <em>XImport Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtype.impl.XImportSectionImpl
	 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXImportSection()
	 * @since 2.7
	 * @generated
	 */
	int XIMPORT_SECTION = 2;

	/**
	 * The feature id for the '<em><b>Import Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XIMPORT_SECTION__IMPORT_DECLARATIONS = 0;

	/**
	 * The number of structural features of the '<em>XImport Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XIMPORT_SECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.XImportDeclarationImpl <em>XImport Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtype.impl.XImportDeclarationImpl
	 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXImportDeclaration()
	 * @since 2.7
	 * @generated
	 */
	int XIMPORT_DECLARATION = 3;

	/**
	 * The feature id for the '<em><b>Wildcard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION__WILDCARD = 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION__EXTENSION = 1;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION__STATIC = 2;

	/**
	 * The feature id for the '<em><b>Imported Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION__IMPORTED_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Member Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION__MEMBER_NAME = 4;

	/**
	 * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION__IMPORTED_NAMESPACE = 5;

	/**
	 * The number of structural features of the '<em>XImport Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '<em>IJvm Type Reference Provider</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider
	 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getIJvmTypeReferenceProvider()
	 * @since 2.7
	 * @generated
	 */
	int IJVM_TYPE_REFERENCE_PROVIDER = 4;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtype.XFunctionTypeRef <em>XFunction Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XFunction Type Ref</em>'.
	 * @see org.eclipse.xtext.xtype.XFunctionTypeRef
	 * @since 2.7
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
	 * @since 2.7
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
	 * @since 2.7
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
	 * @since 2.7
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
	 * @since 2.7
	 * @generated
	 */
	EAttribute getXFunctionTypeRef_InstanceContext();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtype.XComputedTypeReference <em>XComputed Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XComputed Type Reference</em>'.
	 * @see org.eclipse.xtext.xtype.XComputedTypeReference
	 * @since 2.7
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
	 * @since 2.7
	 * @generated
	 */
	EAttribute getXComputedTypeReference_TypeProvider();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtype.XImportSection <em>XImport Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XImport Section</em>'.
	 * @see org.eclipse.xtext.xtype.XImportSection
	 * @since 2.7
	 * @generated
	 */
	EClass getXImportSection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtype.XImportSection#getImportDeclarations <em>Import Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import Declarations</em>'.
	 * @see org.eclipse.xtext.xtype.XImportSection#getImportDeclarations()
	 * @see #getXImportSection()
	 * @since 2.7
	 * @generated
	 */
	EReference getXImportSection_ImportDeclarations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtype.XImportDeclaration <em>XImport Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XImport Declaration</em>'.
	 * @see org.eclipse.xtext.xtype.XImportDeclaration
	 * @since 2.7
	 * @generated
	 */
	EClass getXImportDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtype.XImportDeclaration#isWildcard <em>Wildcard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wildcard</em>'.
	 * @see org.eclipse.xtext.xtype.XImportDeclaration#isWildcard()
	 * @see #getXImportDeclaration()
	 * @since 2.7
	 * @generated
	 */
	EAttribute getXImportDeclaration_Wildcard();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtype.XImportDeclaration#isExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see org.eclipse.xtext.xtype.XImportDeclaration#isExtension()
	 * @see #getXImportDeclaration()
	 * @since 2.7
	 * @generated
	 */
	EAttribute getXImportDeclaration_Extension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtype.XImportDeclaration#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.xtext.xtype.XImportDeclaration#isStatic()
	 * @see #getXImportDeclaration()
	 * @since 2.7
	 * @generated
	 */
	EAttribute getXImportDeclaration_Static();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.xtype.XImportDeclaration#getImportedType <em>Imported Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Imported Type</em>'.
	 * @see org.eclipse.xtext.xtype.XImportDeclaration#getImportedType()
	 * @see #getXImportDeclaration()
	 * @since 2.7
	 * @generated
	 */
	EReference getXImportDeclaration_ImportedType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtype.XImportDeclaration#getMemberName <em>Member Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Member Name</em>'.
	 * @see org.eclipse.xtext.xtype.XImportDeclaration#getMemberName()
	 * @see #getXImportDeclaration()
	 * @since 2.7
	 * @generated
	 */
	EAttribute getXImportDeclaration_MemberName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtype.XImportDeclaration#getImportedNamespace <em>Imported Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imported Namespace</em>'.
	 * @see org.eclipse.xtext.xtype.XImportDeclaration#getImportedNamespace()
	 * @see #getXImportDeclaration()
	 * @since 2.7
	 * @generated
	 */
	EAttribute getXImportDeclaration_ImportedNamespace();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider <em>IJvm Type Reference Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * @since 2.7
     * @noextend This interface is not intended to be extended by clients.
     * @noimplement This interface is not intended to be implemented by clients.
     * <!-- end-model-doc -->
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
		 * @since 2.7
		 * @generated
		 */
		EClass XFUNCTION_TYPE_REF = eINSTANCE.getXFunctionTypeRef();

		/**
		 * The meta object literal for the '<em><b>Param Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @since 2.7
		 * @generated
		 */
		EReference XFUNCTION_TYPE_REF__PARAM_TYPES = eINSTANCE.getXFunctionTypeRef_ParamTypes();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @since 2.7
		 * @generated
		 */
		EReference XFUNCTION_TYPE_REF__RETURN_TYPE = eINSTANCE.getXFunctionTypeRef_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @since 2.7
		 * @generated
		 */
		EReference XFUNCTION_TYPE_REF__TYPE = eINSTANCE.getXFunctionTypeRef_Type();

		/**
		 * The meta object literal for the '<em><b>Instance Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @since 2.7
		 * @generated
		 */
		EAttribute XFUNCTION_TYPE_REF__INSTANCE_CONTEXT = eINSTANCE.getXFunctionTypeRef_InstanceContext();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImpl <em>XComputed Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImpl
		 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXComputedTypeReference()
		 * @since 2.7
		 * @generated
		 */
		EClass XCOMPUTED_TYPE_REFERENCE = eINSTANCE.getXComputedTypeReference();

		/**
		 * The meta object literal for the '<em><b>Type Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @since 2.7
		 * @generated
		 */
		EAttribute XCOMPUTED_TYPE_REFERENCE__TYPE_PROVIDER = eINSTANCE.getXComputedTypeReference_TypeProvider();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.XImportSectionImpl <em>XImport Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtype.impl.XImportSectionImpl
		 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXImportSection()
		 * @since 2.7
		 * @generated
		 */
		EClass XIMPORT_SECTION = eINSTANCE.getXImportSection();

		/**
		 * The meta object literal for the '<em><b>Import Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @since 2.7
		 * @generated
		 */
		EReference XIMPORT_SECTION__IMPORT_DECLARATIONS = eINSTANCE.getXImportSection_ImportDeclarations();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.XImportDeclarationImpl <em>XImport Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtype.impl.XImportDeclarationImpl
		 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXImportDeclaration()
		 * @since 2.7
		 * @generated
		 */
		EClass XIMPORT_DECLARATION = eINSTANCE.getXImportDeclaration();

		/**
		 * The meta object literal for the '<em><b>Wildcard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @since 2.7
		 * @generated
		 */
		EAttribute XIMPORT_DECLARATION__WILDCARD = eINSTANCE.getXImportDeclaration_Wildcard();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @since 2.7
		 * @generated
		 */
		EAttribute XIMPORT_DECLARATION__EXTENSION = eINSTANCE.getXImportDeclaration_Extension();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @since 2.7
		 * @generated
		 */
		EAttribute XIMPORT_DECLARATION__STATIC = eINSTANCE.getXImportDeclaration_Static();

		/**
		 * The meta object literal for the '<em><b>Imported Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @since 2.7
		 * @generated
		 */
		EReference XIMPORT_DECLARATION__IMPORTED_TYPE = eINSTANCE.getXImportDeclaration_ImportedType();

		/**
		 * The meta object literal for the '<em><b>Member Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @since 2.7
		 * @generated
		 */
		EAttribute XIMPORT_DECLARATION__MEMBER_NAME = eINSTANCE.getXImportDeclaration_MemberName();

		/**
		 * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @since 2.7
		 * @generated
		 */
		EAttribute XIMPORT_DECLARATION__IMPORTED_NAMESPACE = eINSTANCE.getXImportDeclaration_ImportedNamespace();

		/**
		 * The meta object literal for the '<em>IJvm Type Reference Provider</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider
		 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getIJvmTypeReferenceProvider()
		 * @since 2.7
		 * @generated
		 */
		EDataType IJVM_TYPE_REFERENCE_PROVIDER = eINSTANCE.getIJvmTypeReferenceProvider();

	}

} //XtypePackage
