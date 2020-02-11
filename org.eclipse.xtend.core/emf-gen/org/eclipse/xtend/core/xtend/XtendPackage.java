/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.xtend;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.xbase.XbasePackage;

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
 * @see org.eclipse.xtend.core.xtend.XtendFactory
 * @model kind="package"
 * @generated
 */
public interface XtendPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xtend";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/xtend";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xtend";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XtendPackage eINSTANCE = org.eclipse.xtend.core.xtend.impl.XtendPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.XtendFileImpl <em>File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.XtendFileImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendFile()
	 * @generated
	 */
	int XTEND_FILE = 0;

	/**
	 * The feature id for the '<em><b>Import Section</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FILE__IMPORT_SECTION = 0;

	/**
	 * The feature id for the '<em><b>Xtend Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FILE__XTEND_TYPES = 1;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FILE__PACKAGE = 2;

	/**
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FILE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.XtendAnnotationTargetImpl <em>Annotation Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.XtendAnnotationTargetImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendAnnotationTarget()
	 * @generated
	 */
	int XTEND_ANNOTATION_TARGET = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TARGET__ANNOTATIONS = 0;

	/**
	 * The number of structural features of the '<em>Annotation Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TARGET_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.XtendMemberImpl <em>Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.XtendMemberImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendMember()
	 * @generated
	 */
	int XTEND_MEMBER = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_MEMBER__ANNOTATIONS = XTEND_ANNOTATION_TARGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_MEMBER__ANNOTATION_INFO = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_MEMBER__MODIFIERS = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_MEMBER__DECLARING_TYPE = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_MEMBER_FEATURE_COUNT = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.XtendTypeDeclarationImpl <em>Type Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.XtendTypeDeclarationImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendTypeDeclaration()
	 * @generated
	 */
	int XTEND_TYPE_DECLARATION = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_TYPE_DECLARATION__ANNOTATIONS = XTEND_MEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_TYPE_DECLARATION__ANNOTATION_INFO = XTEND_MEMBER__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_TYPE_DECLARATION__MODIFIERS = XTEND_MEMBER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_TYPE_DECLARATION__DECLARING_TYPE = XTEND_MEMBER__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_TYPE_DECLARATION__NAME = XTEND_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_TYPE_DECLARATION__MEMBERS = XTEND_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_TYPE_DECLARATION_FEATURE_COUNT = XTEND_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.XtendClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.XtendClassImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendClass()
	 * @generated
	 */
	int XTEND_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__ANNOTATIONS = XTEND_TYPE_DECLARATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__ANNOTATION_INFO = XTEND_TYPE_DECLARATION__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__MODIFIERS = XTEND_TYPE_DECLARATION__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__DECLARING_TYPE = XTEND_TYPE_DECLARATION__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__NAME = XTEND_TYPE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__MEMBERS = XTEND_TYPE_DECLARATION__MEMBERS;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__EXTENDS = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__IMPLEMENTS = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__TYPE_PARAMETERS = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS_FEATURE_COUNT = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.XtendExecutableImpl <em>Executable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.XtendExecutableImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendExecutable()
	 * @generated
	 */
	int XTEND_EXECUTABLE = 21;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_EXECUTABLE__ANNOTATIONS = XTEND_MEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_EXECUTABLE__ANNOTATION_INFO = XTEND_MEMBER__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_EXECUTABLE__MODIFIERS = XTEND_MEMBER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_EXECUTABLE__DECLARING_TYPE = XTEND_MEMBER__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_EXECUTABLE__EXCEPTIONS = XTEND_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_EXECUTABLE__TYPE_PARAMETERS = XTEND_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_EXECUTABLE__EXPRESSION = XTEND_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_EXECUTABLE__PARAMETERS = XTEND_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Executable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_EXECUTABLE_FEATURE_COUNT = XTEND_MEMBER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.XtendFunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.XtendFunctionImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendFunction()
	 * @generated
	 */
	int XTEND_FUNCTION = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__ANNOTATIONS = XTEND_EXECUTABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__ANNOTATION_INFO = XTEND_EXECUTABLE__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__MODIFIERS = XTEND_EXECUTABLE__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__DECLARING_TYPE = XTEND_EXECUTABLE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__EXCEPTIONS = XTEND_EXECUTABLE__EXCEPTIONS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__TYPE_PARAMETERS = XTEND_EXECUTABLE__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__EXPRESSION = XTEND_EXECUTABLE__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__PARAMETERS = XTEND_EXECUTABLE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__NAME = XTEND_EXECUTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__RETURN_TYPE = XTEND_EXECUTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Create Extension Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__CREATE_EXTENSION_INFO = XTEND_EXECUTABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION_FEATURE_COUNT = XTEND_EXECUTABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.XtendFieldImpl <em>Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.XtendFieldImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendField()
	 * @generated
	 */
	int XTEND_FIELD = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FIELD__ANNOTATIONS = XTEND_MEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FIELD__ANNOTATION_INFO = XTEND_MEMBER__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FIELD__MODIFIERS = XTEND_MEMBER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FIELD__DECLARING_TYPE = XTEND_MEMBER__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FIELD__NAME = XTEND_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FIELD__TYPE = XTEND_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FIELD__INITIAL_VALUE = XTEND_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FIELD_FEATURE_COUNT = XTEND_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.XtendParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.XtendParameterImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendParameter()
	 * @generated
	 */
	int XTEND_PARAMETER = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_PARAMETER__ANNOTATIONS = XTEND_ANNOTATION_TARGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_PARAMETER__NAME = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_PARAMETER__PARAMETER_TYPE = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Var Arg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_PARAMETER__VAR_ARG = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_PARAMETER__EXTENSION = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_PARAMETER_FEATURE_COUNT = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.RichStringImpl <em>Rich String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.RichStringImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getRichString()
	 * @generated
	 */
	int RICH_STRING = 7;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int RICH_STRING__EXPRESSIONS = XbasePackage.XBLOCK_EXPRESSION__EXPRESSIONS;

	/**
	 * The number of structural features of the '<em>Rich String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FEATURE_COUNT = XbasePackage.XBLOCK_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.RichStringLiteralImpl <em>Rich String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.RichStringLiteralImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getRichStringLiteral()
	 * @generated
	 */
	int RICH_STRING_LITERAL = 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_LITERAL__VALUE = XbasePackage.XSTRING_LITERAL__VALUE;

	/**
	 * The number of structural features of the '<em>Rich String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_LITERAL_FEATURE_COUNT = XbasePackage.XSTRING_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.RichStringForLoopImpl <em>Rich String For Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.RichStringForLoopImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getRichStringForLoop()
	 * @generated
	 */
	int RICH_STRING_FOR_LOOP = 9;

	/**
	 * The feature id for the '<em><b>For Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP__FOR_EXPRESSION = XbasePackage.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Each Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP__EACH_EXPRESSION = XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Declared Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP__DECLARED_PARAM = XbasePackage.XFOR_LOOP_EXPRESSION__DECLARED_PARAM;

	/**
	 * The feature id for the '<em><b>Separator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP__SEPARATOR = XbasePackage.XFOR_LOOP_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Before</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP__BEFORE = XbasePackage.XFOR_LOOP_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>After</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP__AFTER = XbasePackage.XFOR_LOOP_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rich String For Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP_FEATURE_COUNT = XbasePackage.XFOR_LOOP_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.RichStringIfImpl <em>Rich String If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.RichStringIfImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getRichStringIf()
	 * @generated
	 */
	int RICH_STRING_IF = 10;

	/**
	 * The feature id for the '<em><b>If</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_IF__IF = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_IF__THEN = XbasePackage.XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Ifs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_IF__ELSE_IFS = XbasePackage.XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_IF__ELSE = XbasePackage.XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rich String If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_IF_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.RichStringElseIfImpl <em>Rich String Else If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.RichStringElseIfImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getRichStringElseIf()
	 * @generated
	 */
	int RICH_STRING_ELSE_IF = 11;

	/**
	 * The feature id for the '<em><b>If</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_ELSE_IF__IF = 0;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_ELSE_IF__THEN = 1;

	/**
	 * The number of structural features of the '<em>Rich String Else If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_ELSE_IF_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.CreateExtensionInfoImpl <em>Create Extension Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.CreateExtensionInfoImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getCreateExtensionInfo()
	 * @generated
	 */
	int CREATE_EXTENSION_INFO = 12;

	/**
	 * The feature id for the '<em><b>Create Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_EXTENSION_INFO__CREATE_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_EXTENSION_INFO__NAME = 1;

	/**
	 * The number of structural features of the '<em>Create Extension Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_EXTENSION_INFO_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.XtendConstructorImpl <em>Constructor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.XtendConstructorImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendConstructor()
	 * @generated
	 */
	int XTEND_CONSTRUCTOR = 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR__ANNOTATIONS = XTEND_EXECUTABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR__ANNOTATION_INFO = XTEND_EXECUTABLE__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR__MODIFIERS = XTEND_EXECUTABLE__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR__DECLARING_TYPE = XTEND_EXECUTABLE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR__EXCEPTIONS = XTEND_EXECUTABLE__EXCEPTIONS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR__TYPE_PARAMETERS = XTEND_EXECUTABLE__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR__EXPRESSION = XTEND_EXECUTABLE__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR__PARAMETERS = XTEND_EXECUTABLE__PARAMETERS;

	/**
	 * The number of structural features of the '<em>Constructor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR_FEATURE_COUNT = XTEND_EXECUTABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.XtendAnnotationTypeImpl <em>Annotation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.XtendAnnotationTypeImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendAnnotationType()
	 * @generated
	 */
	int XTEND_ANNOTATION_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TYPE__ANNOTATIONS = XTEND_TYPE_DECLARATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TYPE__ANNOTATION_INFO = XTEND_TYPE_DECLARATION__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TYPE__MODIFIERS = XTEND_TYPE_DECLARATION__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TYPE__DECLARING_TYPE = XTEND_TYPE_DECLARATION__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TYPE__NAME = XTEND_TYPE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TYPE__MEMBERS = XTEND_TYPE_DECLARATION__MEMBERS;

	/**
	 * The number of structural features of the '<em>Annotation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TYPE_FEATURE_COUNT = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.XtendInterfaceImpl <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.XtendInterfaceImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendInterface()
	 * @generated
	 */
	int XTEND_INTERFACE = 16;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE__ANNOTATIONS = XTEND_TYPE_DECLARATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE__ANNOTATION_INFO = XTEND_TYPE_DECLARATION__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE__MODIFIERS = XTEND_TYPE_DECLARATION__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE__DECLARING_TYPE = XTEND_TYPE_DECLARATION__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE__NAME = XTEND_TYPE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE__MEMBERS = XTEND_TYPE_DECLARATION__MEMBERS;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE__EXTENDS = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE__TYPE_PARAMETERS = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE_FEATURE_COUNT = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.XtendEnumImpl <em>Enum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.XtendEnumImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendEnum()
	 * @generated
	 */
	int XTEND_ENUM = 17;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM__ANNOTATIONS = XTEND_TYPE_DECLARATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM__ANNOTATION_INFO = XTEND_TYPE_DECLARATION__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM__MODIFIERS = XTEND_TYPE_DECLARATION__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM__DECLARING_TYPE = XTEND_TYPE_DECLARATION__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM__NAME = XTEND_TYPE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM__MEMBERS = XTEND_TYPE_DECLARATION__MEMBERS;

	/**
	 * The number of structural features of the '<em>Enum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM_FEATURE_COUNT = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.XtendEnumLiteralImpl <em>Enum Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.XtendEnumLiteralImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendEnumLiteral()
	 * @generated
	 */
	int XTEND_ENUM_LITERAL = 18;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM_LITERAL__ANNOTATIONS = XTEND_MEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM_LITERAL__ANNOTATION_INFO = XTEND_MEMBER__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM_LITERAL__MODIFIERS = XTEND_MEMBER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM_LITERAL__DECLARING_TYPE = XTEND_MEMBER__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM_LITERAL__NAME = XTEND_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM_LITERAL_FEATURE_COUNT = XTEND_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.XtendVariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.XtendVariableDeclarationImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendVariableDeclaration()
	 * @generated
	 */
	int XTEND_VARIABLE_DECLARATION = 19;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XTEND_VARIABLE_DECLARATION__TYPE = XbasePackage.XVARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XTEND_VARIABLE_DECLARATION__NAME = XbasePackage.XVARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XTEND_VARIABLE_DECLARATION__RIGHT = XbasePackage.XVARIABLE_DECLARATION__RIGHT;

	/**
	 * The feature id for the '<em><b>Writeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 * @ordered
	 */
	int XTEND_VARIABLE_DECLARATION__WRITEABLE = XbasePackage.XVARIABLE_DECLARATION__WRITEABLE;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_VARIABLE_DECLARATION__EXTENSION = XbasePackage.XVARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_VARIABLE_DECLARATION_FEATURE_COUNT = XbasePackage.XVARIABLE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.XtendFormalParameterImpl <em>Formal Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.XtendFormalParameterImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendFormalParameter()
	 * @generated
	 */
	int XTEND_FORMAL_PARAMETER = 20;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FORMAL_PARAMETER__ANNOTATIONS = TypesPackage.JVM_FORMAL_PARAMETER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FORMAL_PARAMETER__NAME = TypesPackage.JVM_FORMAL_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Parameter Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FORMAL_PARAMETER__PARAMETER_TYPE = TypesPackage.JVM_FORMAL_PARAMETER__PARAMETER_TYPE;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FORMAL_PARAMETER__EXTENSION = TypesPackage.JVM_FORMAL_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Formal Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FORMAL_PARAMETER_FEATURE_COUNT = TypesPackage.JVM_FORMAL_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.xtend.impl.AnonymousClassImpl <em>Anonymous Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.xtend.impl.AnonymousClassImpl
	 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getAnonymousClass()
	 * @generated
	 */
	int ANONYMOUS_CLASS = 22;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CLASS__ANNOTATIONS = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CLASS__ANNOTATION_INFO = XbasePackage.XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CLASS__MODIFIERS = XbasePackage.XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CLASS__DECLARING_TYPE = XbasePackage.XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CLASS__NAME = XbasePackage.XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CLASS__MEMBERS = XbasePackage.XEXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Constructor Call</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CLASS__CONSTRUCTOR_CALL = XbasePackage.XEXPRESSION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Anonymous Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CLASS_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 7;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.XtendFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendFile
	 * @generated
	 */
	EClass getXtendFile();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.XtendFile#getImportSection <em>Import Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Import Section</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendFile#getImportSection()
	 * @see #getXtendFile()
	 * @generated
	 */
	EReference getXtendFile_ImportSection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtend.core.xtend.XtendFile#getXtendTypes <em>Xtend Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Xtend Types</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendFile#getXtendTypes()
	 * @see #getXtendFile()
	 * @generated
	 */
	EReference getXtendFile_XtendTypes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtend.core.xtend.XtendFile#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendFile#getPackage()
	 * @see #getXtendFile()
	 * @generated
	 */
	EAttribute getXtendFile_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.XtendClass <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendClass
	 * @generated
	 */
	EClass getXtendClass();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.XtendClass#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendClass#getExtends()
	 * @see #getXtendClass()
	 * @generated
	 */
	EReference getXtendClass_Extends();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtend.core.xtend.XtendClass#getImplements <em>Implements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Implements</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendClass#getImplements()
	 * @see #getXtendClass()
	 * @generated
	 */
	EReference getXtendClass_Implements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtend.core.xtend.XtendClass#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendClass#getTypeParameters()
	 * @see #getXtendClass()
	 * @generated
	 */
	EReference getXtendClass_TypeParameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.XtendAnnotationTarget <em>Annotation Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Target</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendAnnotationTarget
	 * @generated
	 */
	EClass getXtendAnnotationTarget();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtend.core.xtend.XtendAnnotationTarget#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendAnnotationTarget#getAnnotations()
	 * @see #getXtendAnnotationTarget()
	 * @generated
	 */
	EReference getXtendAnnotationTarget_Annotations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.XtendMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Member</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendMember
	 * @generated
	 */
	EClass getXtendMember();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.XtendMember#getAnnotationInfo <em>Annotation Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Annotation Info</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendMember#getAnnotationInfo()
	 * @see #getXtendMember()
	 * @generated
	 */
	EReference getXtendMember_AnnotationInfo();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.xtend.core.xtend.XtendMember#getModifiers <em>Modifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Modifiers</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendMember#getModifiers()
	 * @see #getXtendMember()
	 * @generated
	 */
	EAttribute getXtendMember_Modifiers();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtend.core.xtend.XtendMember#getDeclaringType <em>Declaring Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Declaring Type</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendMember#getDeclaringType()
	 * @see #getXtendMember()
	 * @generated
	 */
	EReference getXtendMember_DeclaringType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.XtendFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendFunction
	 * @generated
	 */
	EClass getXtendFunction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtend.core.xtend.XtendFunction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendFunction#getName()
	 * @see #getXtendFunction()
	 * @generated
	 */
	EAttribute getXtendFunction_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.XtendFunction#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendFunction#getReturnType()
	 * @see #getXtendFunction()
	 * @generated
	 */
	EReference getXtendFunction_ReturnType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.XtendFunction#getCreateExtensionInfo <em>Create Extension Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Create Extension Info</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendFunction#getCreateExtensionInfo()
	 * @see #getXtendFunction()
	 * @generated
	 */
	EReference getXtendFunction_CreateExtensionInfo();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.XtendField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendField
	 * @generated
	 */
	EClass getXtendField();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtend.core.xtend.XtendField#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendField#getName()
	 * @see #getXtendField()
	 * @generated
	 */
	EAttribute getXtendField_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.XtendField#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendField#getType()
	 * @see #getXtendField()
	 * @generated
	 */
	EReference getXtendField_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.XtendField#getInitialValue <em>Initial Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Value</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendField#getInitialValue()
	 * @see #getXtendField()
	 * @generated
	 */
	EReference getXtendField_InitialValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.XtendParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendParameter
	 * @generated
	 */
	EClass getXtendParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtend.core.xtend.XtendParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendParameter#getName()
	 * @see #getXtendParameter()
	 * @generated
	 */
	EAttribute getXtendParameter_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.XtendParameter#getParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameter Type</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendParameter#getParameterType()
	 * @see #getXtendParameter()
	 * @generated
	 */
	EReference getXtendParameter_ParameterType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtend.core.xtend.XtendParameter#isVarArg <em>Var Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var Arg</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendParameter#isVarArg()
	 * @see #getXtendParameter()
	 * @generated
	 */
	EAttribute getXtendParameter_VarArg();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtend.core.xtend.XtendParameter#isExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendParameter#isExtension()
	 * @see #getXtendParameter()
	 * @generated
	 */
	EAttribute getXtendParameter_Extension();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.RichString <em>Rich String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rich String</em>'.
	 * @see org.eclipse.xtend.core.xtend.RichString
	 * @generated
	 */
	EClass getRichString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.RichStringLiteral <em>Rich String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rich String Literal</em>'.
	 * @see org.eclipse.xtend.core.xtend.RichStringLiteral
	 * @generated
	 */
	EClass getRichStringLiteral();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.RichStringForLoop <em>Rich String For Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rich String For Loop</em>'.
	 * @see org.eclipse.xtend.core.xtend.RichStringForLoop
	 * @generated
	 */
	EClass getRichStringForLoop();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.RichStringForLoop#getSeparator <em>Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Separator</em>'.
	 * @see org.eclipse.xtend.core.xtend.RichStringForLoop#getSeparator()
	 * @see #getRichStringForLoop()
	 * @generated
	 */
	EReference getRichStringForLoop_Separator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.RichStringForLoop#getBefore <em>Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Before</em>'.
	 * @see org.eclipse.xtend.core.xtend.RichStringForLoop#getBefore()
	 * @see #getRichStringForLoop()
	 * @generated
	 */
	EReference getRichStringForLoop_Before();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.RichStringForLoop#getAfter <em>After</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>After</em>'.
	 * @see org.eclipse.xtend.core.xtend.RichStringForLoop#getAfter()
	 * @see #getRichStringForLoop()
	 * @generated
	 */
	EReference getRichStringForLoop_After();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.RichStringIf <em>Rich String If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rich String If</em>'.
	 * @see org.eclipse.xtend.core.xtend.RichStringIf
	 * @generated
	 */
	EClass getRichStringIf();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.RichStringIf#getIf <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>If</em>'.
	 * @see org.eclipse.xtend.core.xtend.RichStringIf#getIf()
	 * @see #getRichStringIf()
	 * @generated
	 */
	EReference getRichStringIf_If();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.RichStringIf#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.eclipse.xtend.core.xtend.RichStringIf#getThen()
	 * @see #getRichStringIf()
	 * @generated
	 */
	EReference getRichStringIf_Then();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtend.core.xtend.RichStringIf#getElseIfs <em>Else Ifs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Else Ifs</em>'.
	 * @see org.eclipse.xtend.core.xtend.RichStringIf#getElseIfs()
	 * @see #getRichStringIf()
	 * @generated
	 */
	EReference getRichStringIf_ElseIfs();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.RichStringIf#getElse <em>Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else</em>'.
	 * @see org.eclipse.xtend.core.xtend.RichStringIf#getElse()
	 * @see #getRichStringIf()
	 * @generated
	 */
	EReference getRichStringIf_Else();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.RichStringElseIf <em>Rich String Else If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rich String Else If</em>'.
	 * @see org.eclipse.xtend.core.xtend.RichStringElseIf
	 * @generated
	 */
	EClass getRichStringElseIf();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.RichStringElseIf#getIf <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>If</em>'.
	 * @see org.eclipse.xtend.core.xtend.RichStringElseIf#getIf()
	 * @see #getRichStringElseIf()
	 * @generated
	 */
	EReference getRichStringElseIf_If();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.RichStringElseIf#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.eclipse.xtend.core.xtend.RichStringElseIf#getThen()
	 * @see #getRichStringElseIf()
	 * @generated
	 */
	EReference getRichStringElseIf_Then();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.CreateExtensionInfo <em>Create Extension Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Extension Info</em>'.
	 * @see org.eclipse.xtend.core.xtend.CreateExtensionInfo
	 * @generated
	 */
	EClass getCreateExtensionInfo();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.CreateExtensionInfo#getCreateExpression <em>Create Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Create Expression</em>'.
	 * @see org.eclipse.xtend.core.xtend.CreateExtensionInfo#getCreateExpression()
	 * @see #getCreateExtensionInfo()
	 * @generated
	 */
	EReference getCreateExtensionInfo_CreateExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtend.core.xtend.CreateExtensionInfo#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtend.core.xtend.CreateExtensionInfo#getName()
	 * @see #getCreateExtensionInfo()
	 * @generated
	 */
	EAttribute getCreateExtensionInfo_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.XtendConstructor <em>Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructor</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendConstructor
	 * @generated
	 */
	EClass getXtendConstructor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.XtendTypeDeclaration <em>Type Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Declaration</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendTypeDeclaration
	 * @generated
	 */
	EClass getXtendTypeDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtend.core.xtend.XtendTypeDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendTypeDeclaration#getName()
	 * @see #getXtendTypeDeclaration()
	 * @generated
	 */
	EAttribute getXtendTypeDeclaration_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtend.core.xtend.XtendTypeDeclaration#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendTypeDeclaration#getMembers()
	 * @see #getXtendTypeDeclaration()
	 * @generated
	 */
	EReference getXtendTypeDeclaration_Members();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.XtendAnnotationType <em>Annotation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Type</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendAnnotationType
	 * @generated
	 */
	EClass getXtendAnnotationType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.XtendInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendInterface
	 * @generated
	 */
	EClass getXtendInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtend.core.xtend.XtendInterface#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extends</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendInterface#getExtends()
	 * @see #getXtendInterface()
	 * @generated
	 */
	EReference getXtendInterface_Extends();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtend.core.xtend.XtendInterface#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendInterface#getTypeParameters()
	 * @see #getXtendInterface()
	 * @generated
	 */
	EReference getXtendInterface_TypeParameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.XtendEnum <em>Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendEnum
	 * @generated
	 */
	EClass getXtendEnum();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.XtendEnumLiteral <em>Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendEnumLiteral
	 * @generated
	 */
	EClass getXtendEnumLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtend.core.xtend.XtendEnumLiteral#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendEnumLiteral#getName()
	 * @see #getXtendEnumLiteral()
	 * @generated
	 */
	EAttribute getXtendEnumLiteral_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.XtendVariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendVariableDeclaration
	 * @generated
	 */
	EClass getXtendVariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtend.core.xtend.XtendVariableDeclaration#isExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendVariableDeclaration#isExtension()
	 * @see #getXtendVariableDeclaration()
	 * @generated
	 */
	EAttribute getXtendVariableDeclaration_Extension();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.XtendFormalParameter <em>Formal Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formal Parameter</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendFormalParameter
	 * @generated
	 */
	EClass getXtendFormalParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtend.core.xtend.XtendFormalParameter#isExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendFormalParameter#isExtension()
	 * @see #getXtendFormalParameter()
	 * @generated
	 */
	EAttribute getXtendFormalParameter_Extension();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.XtendExecutable <em>Executable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Executable</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendExecutable
	 * @generated
	 */
	EClass getXtendExecutable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtend.core.xtend.XtendExecutable#getExceptions <em>Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exceptions</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendExecutable#getExceptions()
	 * @see #getXtendExecutable()
	 * @generated
	 */
	EReference getXtendExecutable_Exceptions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtend.core.xtend.XtendExecutable#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendExecutable#getTypeParameters()
	 * @see #getXtendExecutable()
	 * @generated
	 */
	EReference getXtendExecutable_TypeParameters();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.XtendExecutable#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendExecutable#getExpression()
	 * @see #getXtendExecutable()
	 * @generated
	 */
	EReference getXtendExecutable_Expression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtend.core.xtend.XtendExecutable#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.xtend.core.xtend.XtendExecutable#getParameters()
	 * @see #getXtendExecutable()
	 * @generated
	 */
	EReference getXtendExecutable_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.xtend.AnonymousClass <em>Anonymous Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Anonymous Class</em>'.
	 * @see org.eclipse.xtend.core.xtend.AnonymousClass
	 * @generated
	 */
	EClass getAnonymousClass();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtend.core.xtend.AnonymousClass#getConstructorCall <em>Constructor Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constructor Call</em>'.
	 * @see org.eclipse.xtend.core.xtend.AnonymousClass#getConstructorCall()
	 * @see #getAnonymousClass()
	 * @generated
	 */
	EReference getAnonymousClass_ConstructorCall();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XtendFactory getXtendFactory();

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
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.XtendFileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.XtendFileImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendFile()
		 * @generated
		 */
		EClass XTEND_FILE = eINSTANCE.getXtendFile();

		/**
		 * The meta object literal for the '<em><b>Import Section</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FILE__IMPORT_SECTION = eINSTANCE.getXtendFile_ImportSection();

		/**
		 * The meta object literal for the '<em><b>Xtend Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FILE__XTEND_TYPES = eINSTANCE.getXtendFile_XtendTypes();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_FILE__PACKAGE = eINSTANCE.getXtendFile_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.XtendClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.XtendClassImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendClass()
		 * @generated
		 */
		EClass XTEND_CLASS = eINSTANCE.getXtendClass();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_CLASS__EXTENDS = eINSTANCE.getXtendClass_Extends();

		/**
		 * The meta object literal for the '<em><b>Implements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_CLASS__IMPLEMENTS = eINSTANCE.getXtendClass_Implements();

		/**
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_CLASS__TYPE_PARAMETERS = eINSTANCE.getXtendClass_TypeParameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.XtendAnnotationTargetImpl <em>Annotation Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.XtendAnnotationTargetImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendAnnotationTarget()
		 * @generated
		 */
		EClass XTEND_ANNOTATION_TARGET = eINSTANCE.getXtendAnnotationTarget();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_ANNOTATION_TARGET__ANNOTATIONS = eINSTANCE.getXtendAnnotationTarget_Annotations();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.XtendMemberImpl <em>Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.XtendMemberImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendMember()
		 * @generated
		 */
		EClass XTEND_MEMBER = eINSTANCE.getXtendMember();

		/**
		 * The meta object literal for the '<em><b>Annotation Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_MEMBER__ANNOTATION_INFO = eINSTANCE.getXtendMember_AnnotationInfo();

		/**
		 * The meta object literal for the '<em><b>Modifiers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_MEMBER__MODIFIERS = eINSTANCE.getXtendMember_Modifiers();

		/**
		 * The meta object literal for the '<em><b>Declaring Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_MEMBER__DECLARING_TYPE = eINSTANCE.getXtendMember_DeclaringType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.XtendFunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.XtendFunctionImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendFunction()
		 * @generated
		 */
		EClass XTEND_FUNCTION = eINSTANCE.getXtendFunction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_FUNCTION__NAME = eINSTANCE.getXtendFunction_Name();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FUNCTION__RETURN_TYPE = eINSTANCE.getXtendFunction_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Create Extension Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FUNCTION__CREATE_EXTENSION_INFO = eINSTANCE.getXtendFunction_CreateExtensionInfo();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.XtendFieldImpl <em>Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.XtendFieldImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendField()
		 * @generated
		 */
		EClass XTEND_FIELD = eINSTANCE.getXtendField();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_FIELD__NAME = eINSTANCE.getXtendField_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FIELD__TYPE = eINSTANCE.getXtendField_Type();

		/**
		 * The meta object literal for the '<em><b>Initial Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FIELD__INITIAL_VALUE = eINSTANCE.getXtendField_InitialValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.XtendParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.XtendParameterImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendParameter()
		 * @generated
		 */
		EClass XTEND_PARAMETER = eINSTANCE.getXtendParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_PARAMETER__NAME = eINSTANCE.getXtendParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Parameter Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_PARAMETER__PARAMETER_TYPE = eINSTANCE.getXtendParameter_ParameterType();

		/**
		 * The meta object literal for the '<em><b>Var Arg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_PARAMETER__VAR_ARG = eINSTANCE.getXtendParameter_VarArg();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_PARAMETER__EXTENSION = eINSTANCE.getXtendParameter_Extension();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.RichStringImpl <em>Rich String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.RichStringImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getRichString()
		 * @generated
		 */
		EClass RICH_STRING = eINSTANCE.getRichString();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.RichStringLiteralImpl <em>Rich String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.RichStringLiteralImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getRichStringLiteral()
		 * @generated
		 */
		EClass RICH_STRING_LITERAL = eINSTANCE.getRichStringLiteral();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.RichStringForLoopImpl <em>Rich String For Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.RichStringForLoopImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getRichStringForLoop()
		 * @generated
		 */
		EClass RICH_STRING_FOR_LOOP = eINSTANCE.getRichStringForLoop();

		/**
		 * The meta object literal for the '<em><b>Separator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_FOR_LOOP__SEPARATOR = eINSTANCE.getRichStringForLoop_Separator();

		/**
		 * The meta object literal for the '<em><b>Before</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_FOR_LOOP__BEFORE = eINSTANCE.getRichStringForLoop_Before();

		/**
		 * The meta object literal for the '<em><b>After</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_FOR_LOOP__AFTER = eINSTANCE.getRichStringForLoop_After();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.RichStringIfImpl <em>Rich String If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.RichStringIfImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getRichStringIf()
		 * @generated
		 */
		EClass RICH_STRING_IF = eINSTANCE.getRichStringIf();

		/**
		 * The meta object literal for the '<em><b>If</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_IF__IF = eINSTANCE.getRichStringIf_If();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_IF__THEN = eINSTANCE.getRichStringIf_Then();

		/**
		 * The meta object literal for the '<em><b>Else Ifs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_IF__ELSE_IFS = eINSTANCE.getRichStringIf_ElseIfs();

		/**
		 * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_IF__ELSE = eINSTANCE.getRichStringIf_Else();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.RichStringElseIfImpl <em>Rich String Else If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.RichStringElseIfImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getRichStringElseIf()
		 * @generated
		 */
		EClass RICH_STRING_ELSE_IF = eINSTANCE.getRichStringElseIf();

		/**
		 * The meta object literal for the '<em><b>If</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_ELSE_IF__IF = eINSTANCE.getRichStringElseIf_If();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_ELSE_IF__THEN = eINSTANCE.getRichStringElseIf_Then();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.CreateExtensionInfoImpl <em>Create Extension Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.CreateExtensionInfoImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getCreateExtensionInfo()
		 * @generated
		 */
		EClass CREATE_EXTENSION_INFO = eINSTANCE.getCreateExtensionInfo();

		/**
		 * The meta object literal for the '<em><b>Create Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_EXTENSION_INFO__CREATE_EXPRESSION = eINSTANCE.getCreateExtensionInfo_CreateExpression();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_EXTENSION_INFO__NAME = eINSTANCE.getCreateExtensionInfo_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.XtendConstructorImpl <em>Constructor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.XtendConstructorImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendConstructor()
		 * @generated
		 */
		EClass XTEND_CONSTRUCTOR = eINSTANCE.getXtendConstructor();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.XtendTypeDeclarationImpl <em>Type Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.XtendTypeDeclarationImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendTypeDeclaration()
		 * @generated
		 */
		EClass XTEND_TYPE_DECLARATION = eINSTANCE.getXtendTypeDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_TYPE_DECLARATION__NAME = eINSTANCE.getXtendTypeDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_TYPE_DECLARATION__MEMBERS = eINSTANCE.getXtendTypeDeclaration_Members();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.XtendAnnotationTypeImpl <em>Annotation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.XtendAnnotationTypeImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendAnnotationType()
		 * @generated
		 */
		EClass XTEND_ANNOTATION_TYPE = eINSTANCE.getXtendAnnotationType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.XtendInterfaceImpl <em>Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.XtendInterfaceImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendInterface()
		 * @generated
		 */
		EClass XTEND_INTERFACE = eINSTANCE.getXtendInterface();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_INTERFACE__EXTENDS = eINSTANCE.getXtendInterface_Extends();

		/**
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_INTERFACE__TYPE_PARAMETERS = eINSTANCE.getXtendInterface_TypeParameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.XtendEnumImpl <em>Enum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.XtendEnumImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendEnum()
		 * @generated
		 */
		EClass XTEND_ENUM = eINSTANCE.getXtendEnum();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.XtendEnumLiteralImpl <em>Enum Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.XtendEnumLiteralImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendEnumLiteral()
		 * @generated
		 */
		EClass XTEND_ENUM_LITERAL = eINSTANCE.getXtendEnumLiteral();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_ENUM_LITERAL__NAME = eINSTANCE.getXtendEnumLiteral_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.XtendVariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.XtendVariableDeclarationImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendVariableDeclaration()
		 * @generated
		 */
		EClass XTEND_VARIABLE_DECLARATION = eINSTANCE.getXtendVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_VARIABLE_DECLARATION__EXTENSION = eINSTANCE.getXtendVariableDeclaration_Extension();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.XtendFormalParameterImpl <em>Formal Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.XtendFormalParameterImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendFormalParameter()
		 * @generated
		 */
		EClass XTEND_FORMAL_PARAMETER = eINSTANCE.getXtendFormalParameter();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_FORMAL_PARAMETER__EXTENSION = eINSTANCE.getXtendFormalParameter_Extension();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.XtendExecutableImpl <em>Executable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.XtendExecutableImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getXtendExecutable()
		 * @generated
		 */
		EClass XTEND_EXECUTABLE = eINSTANCE.getXtendExecutable();

		/**
		 * The meta object literal for the '<em><b>Exceptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_EXECUTABLE__EXCEPTIONS = eINSTANCE.getXtendExecutable_Exceptions();

		/**
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_EXECUTABLE__TYPE_PARAMETERS = eINSTANCE.getXtendExecutable_TypeParameters();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_EXECUTABLE__EXPRESSION = eINSTANCE.getXtendExecutable_Expression();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_EXECUTABLE__PARAMETERS = eINSTANCE.getXtendExecutable_Parameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.xtend.impl.AnonymousClassImpl <em>Anonymous Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.xtend.impl.AnonymousClassImpl
		 * @see org.eclipse.xtend.core.xtend.impl.XtendPackageImpl#getAnonymousClass()
		 * @generated
		 */
		EClass ANONYMOUS_CLASS = eINSTANCE.getAnonymousClass();

		/**
		 * The meta object literal for the '<em><b>Constructor Call</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANONYMOUS_CLASS__CONSTRUCTOR_CALL = eINSTANCE.getAnonymousClass_ConstructorCall();

	}

} //XtendPackage
