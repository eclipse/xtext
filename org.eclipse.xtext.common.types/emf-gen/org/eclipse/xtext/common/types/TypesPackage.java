/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.xtext.common.types.TypesFactory
 * @model kind="package"
 * @generated
 */
public interface TypesPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "types";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/xtext/common/JavaVMTypes";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "types";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypesPackage eINSTANCE = org.eclipse.xtext.common.types.impl.TypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmIdentifiableElementImpl <em>Jvm Identifiable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmIdentifiableElementImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmIdentifiableElement()
	 * @generated
	 */
	int JVM_IDENTIFIABLE_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Jvm Identifiable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmTypeImpl <em>Jvm Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmType()
	 * @generated
	 */
	int JVM_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Jvm Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_FEATURE_COUNT = JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmVoidImpl <em>Jvm Void</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmVoidImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmVoid()
	 * @generated
	 */
	int JVM_VOID = 2;

	/**
	 * The number of structural features of the '<em>Jvm Void</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_VOID_FEATURE_COUNT = JVM_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmComponentTypeImpl <em>Jvm Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmComponentTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmComponentType()
	 * @generated
	 */
	int JVM_COMPONENT_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_COMPONENT_TYPE__ARRAY_TYPE = JVM_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_COMPONENT_TYPE_FEATURE_COUNT = JVM_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmPrimitiveTypeImpl <em>Jvm Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmPrimitiveTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmPrimitiveType()
	 * @generated
	 */
	int JVM_PRIMITIVE_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_PRIMITIVE_TYPE__ARRAY_TYPE = JVM_COMPONENT_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_PRIMITIVE_TYPE__SIMPLE_NAME = JVM_COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_PRIMITIVE_TYPE_FEATURE_COUNT = JVM_COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmArrayTypeImpl <em>Jvm Array Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmArrayTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmArrayType()
	 * @generated
	 */
	int JVM_ARRAY_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ARRAY_TYPE__ARRAY_TYPE = JVM_COMPONENT_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Component Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ARRAY_TYPE__COMPONENT_TYPE = JVM_COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Array Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ARRAY_TYPE_FEATURE_COUNT = JVM_COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmAnnotationTargetImpl <em>Jvm Annotation Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmAnnotationTargetImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmAnnotationTarget()
	 * @generated
	 */
	int JVM_ANNOTATION_TARGET = 30;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TARGET__ANNOTATIONS = JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Annotation Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TARGET_FEATURE_COUNT = JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmMemberImpl <em>Jvm Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmMemberImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmMember()
	 * @generated
	 */
	int JVM_MEMBER = 23;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MEMBER__ANNOTATIONS = JVM_ANNOTATION_TARGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MEMBER__DECLARING_TYPE = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MEMBER__VISIBILITY = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MEMBER__SIMPLE_NAME = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MEMBER__IDENTIFIER = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MEMBER__DEPRECATED = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Jvm Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MEMBER_FEATURE_COUNT = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmDeclaredTypeImpl <em>Jvm Declared Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmDeclaredTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmDeclaredType()
	 * @generated
	 */
	int JVM_DECLARED_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__ANNOTATIONS = JVM_MEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__DECLARING_TYPE = JVM_MEMBER__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__VISIBILITY = JVM_MEMBER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__SIMPLE_NAME = JVM_MEMBER__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__IDENTIFIER = JVM_MEMBER__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__DEPRECATED = JVM_MEMBER__DEPRECATED;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__ARRAY_TYPE = JVM_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__SUPER_TYPES = JVM_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__MEMBERS = JVM_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__ABSTRACT = JVM_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__STATIC = JVM_MEMBER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__FINAL = JVM_MEMBER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__PACKAGE_NAME = JVM_MEMBER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Jvm Declared Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE_FEATURE_COUNT = JVM_MEMBER_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmTypeParameterImpl <em>Jvm Type Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmTypeParameterImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmTypeParameter()
	 * @generated
	 */
	int JVM_TYPE_PARAMETER = 7;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_PARAMETER__ARRAY_TYPE = JVM_COMPONENT_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_PARAMETER__CONSTRAINTS = JVM_COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_PARAMETER__NAME = JVM_COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declarator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_PARAMETER__DECLARATOR = JVM_COMPONENT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Jvm Type Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_PARAMETER_FEATURE_COUNT = JVM_COMPONENT_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmTypeParameterDeclaratorImpl <em>Jvm Type Parameter Declarator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmTypeParameterDeclaratorImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmTypeParameterDeclarator()
	 * @generated
	 */
	int JVM_TYPE_PARAMETER_DECLARATOR = 8;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS = 0;

	/**
	 * The number of structural features of the '<em>Jvm Type Parameter Declarator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_PARAMETER_DECLARATOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmConstraintOwnerImpl <em>Jvm Constraint Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmConstraintOwnerImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmConstraintOwner()
	 * @generated
	 */
	int JVM_CONSTRAINT_OWNER = 9;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRAINT_OWNER__CONSTRAINTS = 0;

	/**
	 * The number of structural features of the '<em>Jvm Constraint Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRAINT_OWNER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmTypeConstraintImpl <em>Jvm Type Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmTypeConstraintImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmTypeConstraint()
	 * @generated
	 */
	int JVM_TYPE_CONSTRAINT = 10;

	/**
	 * The feature id for the '<em><b>Type Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_CONSTRAINT__TYPE_REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_CONSTRAINT__OWNER = 1;

	/**
	 * The number of structural features of the '<em>Jvm Type Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_CONSTRAINT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmUpperBoundImpl <em>Jvm Upper Bound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmUpperBoundImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmUpperBound()
	 * @generated
	 */
	int JVM_UPPER_BOUND = 11;

	/**
	 * The feature id for the '<em><b>Type Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_UPPER_BOUND__TYPE_REFERENCE = JVM_TYPE_CONSTRAINT__TYPE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_UPPER_BOUND__OWNER = JVM_TYPE_CONSTRAINT__OWNER;

	/**
	 * The number of structural features of the '<em>Jvm Upper Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_UPPER_BOUND_FEATURE_COUNT = JVM_TYPE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmLowerBoundImpl <em>Jvm Lower Bound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmLowerBoundImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmLowerBound()
	 * @generated
	 */
	int JVM_LOWER_BOUND = 12;

	/**
	 * The feature id for the '<em><b>Type Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_LOWER_BOUND__TYPE_REFERENCE = JVM_TYPE_CONSTRAINT__TYPE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_LOWER_BOUND__OWNER = JVM_TYPE_CONSTRAINT__OWNER;

	/**
	 * The number of structural features of the '<em>Jvm Lower Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_LOWER_BOUND_FEATURE_COUNT = JVM_TYPE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmAnnotationTypeImpl <em>Jvm Annotation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmAnnotationTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmAnnotationType()
	 * @generated
	 */
	int JVM_ANNOTATION_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__ANNOTATIONS = JVM_DECLARED_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__DECLARING_TYPE = JVM_DECLARED_TYPE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__VISIBILITY = JVM_DECLARED_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__SIMPLE_NAME = JVM_DECLARED_TYPE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__IDENTIFIER = JVM_DECLARED_TYPE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__DEPRECATED = JVM_DECLARED_TYPE__DEPRECATED;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__ARRAY_TYPE = JVM_DECLARED_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__SUPER_TYPES = JVM_DECLARED_TYPE__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__MEMBERS = JVM_DECLARED_TYPE__MEMBERS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__ABSTRACT = JVM_DECLARED_TYPE__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__STATIC = JVM_DECLARED_TYPE__STATIC;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__FINAL = JVM_DECLARED_TYPE__FINAL;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__PACKAGE_NAME = JVM_DECLARED_TYPE__PACKAGE_NAME;

	/**
	 * The number of structural features of the '<em>Jvm Annotation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE_FEATURE_COUNT = JVM_DECLARED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmEnumerationTypeImpl <em>Jvm Enumeration Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmEnumerationTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmEnumerationType()
	 * @generated
	 */
	int JVM_ENUMERATION_TYPE = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__ANNOTATIONS = JVM_DECLARED_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__DECLARING_TYPE = JVM_DECLARED_TYPE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__VISIBILITY = JVM_DECLARED_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__SIMPLE_NAME = JVM_DECLARED_TYPE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__IDENTIFIER = JVM_DECLARED_TYPE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__DEPRECATED = JVM_DECLARED_TYPE__DEPRECATED;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__ARRAY_TYPE = JVM_DECLARED_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__SUPER_TYPES = JVM_DECLARED_TYPE__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__MEMBERS = JVM_DECLARED_TYPE__MEMBERS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__ABSTRACT = JVM_DECLARED_TYPE__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__STATIC = JVM_DECLARED_TYPE__STATIC;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__FINAL = JVM_DECLARED_TYPE__FINAL;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__PACKAGE_NAME = JVM_DECLARED_TYPE__PACKAGE_NAME;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__LITERALS = JVM_DECLARED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Enumeration Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE_FEATURE_COUNT = JVM_DECLARED_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmFeatureImpl <em>Jvm Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmFeatureImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmFeature()
	 * @generated
	 */
	int JVM_FEATURE = 24;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FEATURE__ANNOTATIONS = JVM_MEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FEATURE__DECLARING_TYPE = JVM_MEMBER__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FEATURE__VISIBILITY = JVM_MEMBER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FEATURE__SIMPLE_NAME = JVM_MEMBER__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FEATURE__IDENTIFIER = JVM_MEMBER__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FEATURE__DEPRECATED = JVM_MEMBER__DEPRECATED;

	/**
	 * The feature id for the '<em><b>Local Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FEATURE__LOCAL_CLASSES = JVM_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FEATURE_FEATURE_COUNT = JVM_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmFieldImpl <em>Jvm Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmFieldImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmField()
	 * @generated
	 */
	int JVM_FIELD = 25;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__ANNOTATIONS = JVM_FEATURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__DECLARING_TYPE = JVM_FEATURE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__VISIBILITY = JVM_FEATURE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__SIMPLE_NAME = JVM_FEATURE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__IDENTIFIER = JVM_FEATURE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__DEPRECATED = JVM_FEATURE__DEPRECATED;

	/**
	 * The feature id for the '<em><b>Local Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__LOCAL_CLASSES = JVM_FEATURE__LOCAL_CLASSES;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__STATIC = JVM_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__FINAL = JVM_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__TYPE = JVM_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__VOLATILE = JVM_FEATURE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__TRANSIENT = JVM_FEATURE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__CONSTANT = JVM_FEATURE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Constant Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__CONSTANT_VALUE = JVM_FEATURE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Jvm Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD_FEATURE_COUNT = JVM_FEATURE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmEnumerationLiteralImpl <em>Jvm Enumeration Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmEnumerationLiteralImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmEnumerationLiteral()
	 * @generated
	 */
	int JVM_ENUMERATION_LITERAL = 15;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__ANNOTATIONS = JVM_FIELD__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__DECLARING_TYPE = JVM_FIELD__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__VISIBILITY = JVM_FIELD__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__SIMPLE_NAME = JVM_FIELD__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__IDENTIFIER = JVM_FIELD__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__DEPRECATED = JVM_FIELD__DEPRECATED;

	/**
	 * The feature id for the '<em><b>Local Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__LOCAL_CLASSES = JVM_FIELD__LOCAL_CLASSES;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__STATIC = JVM_FIELD__STATIC;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__FINAL = JVM_FIELD__FINAL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__TYPE = JVM_FIELD__TYPE;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__VOLATILE = JVM_FIELD__VOLATILE;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__TRANSIENT = JVM_FIELD__TRANSIENT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__CONSTANT = JVM_FIELD__CONSTANT;

	/**
	 * The feature id for the '<em><b>Constant Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__CONSTANT_VALUE = JVM_FIELD__CONSTANT_VALUE;

	/**
	 * The number of structural features of the '<em>Jvm Enumeration Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL_FEATURE_COUNT = JVM_FIELD_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmGenericTypeImpl <em>Jvm Generic Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmGenericTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmGenericType()
	 * @generated
	 */
	int JVM_GENERIC_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__ANNOTATIONS = JVM_DECLARED_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__DECLARING_TYPE = JVM_DECLARED_TYPE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__VISIBILITY = JVM_DECLARED_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__SIMPLE_NAME = JVM_DECLARED_TYPE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__IDENTIFIER = JVM_DECLARED_TYPE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__DEPRECATED = JVM_DECLARED_TYPE__DEPRECATED;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__ARRAY_TYPE = JVM_DECLARED_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__SUPER_TYPES = JVM_DECLARED_TYPE__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__MEMBERS = JVM_DECLARED_TYPE__MEMBERS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__ABSTRACT = JVM_DECLARED_TYPE__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__STATIC = JVM_DECLARED_TYPE__STATIC;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__FINAL = JVM_DECLARED_TYPE__FINAL;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__PACKAGE_NAME = JVM_DECLARED_TYPE__PACKAGE_NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__TYPE_PARAMETERS = JVM_DECLARED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__INTERFACE = JVM_DECLARED_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Strict Floating Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__STRICT_FLOATING_POINT = JVM_DECLARED_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Anonymous</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__ANONYMOUS = JVM_DECLARED_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Jvm Generic Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE_FEATURE_COUNT = JVM_DECLARED_TYPE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmTypeReferenceImpl <em>Jvm Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmTypeReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmTypeReference()
	 * @generated
	 */
	int JVM_TYPE_REFERENCE = 17;

	/**
	 * The number of structural features of the '<em>Jvm Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_REFERENCE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmParameterizedTypeReferenceImpl <em>Jvm Parameterized Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmParameterizedTypeReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmParameterizedTypeReference()
	 * @generated
	 */
	int JVM_PARAMETERIZED_TYPE_REFERENCE = 18;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS = JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE = JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Jvm Parameterized Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_PARAMETERIZED_TYPE_REFERENCE_FEATURE_COUNT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmGenericArrayTypeReferenceImpl <em>Jvm Generic Array Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmGenericArrayTypeReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmGenericArrayTypeReference()
	 * @generated
	 */
	int JVM_GENERIC_ARRAY_TYPE_REFERENCE = 19;

	/**
	 * The feature id for the '<em><b>Component Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE = JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Generic Array Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_ARRAY_TYPE_REFERENCE_FEATURE_COUNT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmWildcardTypeReferenceImpl <em>Jvm Wildcard Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmWildcardTypeReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmWildcardTypeReference()
	 * @generated
	 */
	int JVM_WILDCARD_TYPE_REFERENCE = 20;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_WILDCARD_TYPE_REFERENCE__CONSTRAINTS = JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Wildcard Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_WILDCARD_TYPE_REFERENCE_FEATURE_COUNT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmAnyTypeReferenceImpl <em>Jvm Any Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmAnyTypeReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmAnyTypeReference()
	 * @generated
	 */
	int JVM_ANY_TYPE_REFERENCE = 21;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANY_TYPE_REFERENCE__TYPE = JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Any Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANY_TYPE_REFERENCE_FEATURE_COUNT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmCompoundTypeReferenceImpl <em>Jvm Compound Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmCompoundTypeReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmCompoundTypeReference()
	 * @generated
	 */
	int JVM_COMPOUND_TYPE_REFERENCE = 49;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_COMPOUND_TYPE_REFERENCE__TYPE = JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_COMPOUND_TYPE_REFERENCE__REFERENCES = JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Jvm Compound Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_COMPOUND_TYPE_REFERENCE_FEATURE_COUNT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmMultiTypeReferenceImpl <em>Jvm Multi Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmMultiTypeReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmMultiTypeReference()
	 * @generated
	 */
	int JVM_MULTI_TYPE_REFERENCE = 22;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MULTI_TYPE_REFERENCE__TYPE = JVM_COMPOUND_TYPE_REFERENCE__TYPE;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MULTI_TYPE_REFERENCE__REFERENCES = JVM_COMPOUND_TYPE_REFERENCE__REFERENCES;

	/**
	 * The number of structural features of the '<em>Jvm Multi Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MULTI_TYPE_REFERENCE_FEATURE_COUNT = JVM_COMPOUND_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmExecutableImpl <em>Jvm Executable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmExecutableImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmExecutable()
	 * @generated
	 */
	int JVM_EXECUTABLE = 26;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__ANNOTATIONS = JVM_FEATURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__DECLARING_TYPE = JVM_FEATURE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__VISIBILITY = JVM_FEATURE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__SIMPLE_NAME = JVM_FEATURE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__IDENTIFIER = JVM_FEATURE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__DEPRECATED = JVM_FEATURE__DEPRECATED;

	/**
	 * The feature id for the '<em><b>Local Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__LOCAL_CLASSES = JVM_FEATURE__LOCAL_CLASSES;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__TYPE_PARAMETERS = JVM_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__PARAMETERS = JVM_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__EXCEPTIONS = JVM_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Var Args</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__VAR_ARGS = JVM_FEATURE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Jvm Executable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE_FEATURE_COUNT = JVM_FEATURE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmConstructorImpl <em>Jvm Constructor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmConstructorImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmConstructor()
	 * @generated
	 */
	int JVM_CONSTRUCTOR = 27;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__ANNOTATIONS = JVM_EXECUTABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__DECLARING_TYPE = JVM_EXECUTABLE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__VISIBILITY = JVM_EXECUTABLE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__SIMPLE_NAME = JVM_EXECUTABLE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__IDENTIFIER = JVM_EXECUTABLE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__DEPRECATED = JVM_EXECUTABLE__DEPRECATED;

	/**
	 * The feature id for the '<em><b>Local Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__LOCAL_CLASSES = JVM_EXECUTABLE__LOCAL_CLASSES;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__TYPE_PARAMETERS = JVM_EXECUTABLE__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__PARAMETERS = JVM_EXECUTABLE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__EXCEPTIONS = JVM_EXECUTABLE__EXCEPTIONS;

	/**
	 * The feature id for the '<em><b>Var Args</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__VAR_ARGS = JVM_EXECUTABLE__VAR_ARGS;

	/**
	 * The number of structural features of the '<em>Jvm Constructor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR_FEATURE_COUNT = JVM_EXECUTABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmOperationImpl <em>Jvm Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmOperationImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmOperation()
	 * @generated
	 */
	int JVM_OPERATION = 28;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__ANNOTATIONS = JVM_EXECUTABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__DECLARING_TYPE = JVM_EXECUTABLE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__VISIBILITY = JVM_EXECUTABLE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__SIMPLE_NAME = JVM_EXECUTABLE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__IDENTIFIER = JVM_EXECUTABLE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__DEPRECATED = JVM_EXECUTABLE__DEPRECATED;

	/**
	 * The feature id for the '<em><b>Local Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__LOCAL_CLASSES = JVM_EXECUTABLE__LOCAL_CLASSES;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__TYPE_PARAMETERS = JVM_EXECUTABLE__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__PARAMETERS = JVM_EXECUTABLE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__EXCEPTIONS = JVM_EXECUTABLE__EXCEPTIONS;

	/**
	 * The feature id for the '<em><b>Var Args</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__VAR_ARGS = JVM_EXECUTABLE__VAR_ARGS;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__STATIC = JVM_EXECUTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__FINAL = JVM_EXECUTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__ABSTRACT = JVM_EXECUTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__RETURN_TYPE = JVM_EXECUTABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__DEFAULT_VALUE = JVM_EXECUTABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Synchronized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__SYNCHRONIZED = JVM_EXECUTABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__DEFAULT = JVM_EXECUTABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__NATIVE = JVM_EXECUTABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Strict Floating Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__STRICT_FLOATING_POINT = JVM_EXECUTABLE_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Jvm Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION_FEATURE_COUNT = JVM_EXECUTABLE_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmFormalParameterImpl <em>Jvm Formal Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmFormalParameterImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmFormalParameter()
	 * @generated
	 */
	int JVM_FORMAL_PARAMETER = 29;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FORMAL_PARAMETER__ANNOTATIONS = JVM_ANNOTATION_TARGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FORMAL_PARAMETER__NAME = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FORMAL_PARAMETER__PARAMETER_TYPE = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Jvm Formal Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FORMAL_PARAMETER_FEATURE_COUNT = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmAnnotationReferenceImpl <em>Jvm Annotation Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmAnnotationReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmAnnotationReference()
	 * @generated
	 */
	int JVM_ANNOTATION_REFERENCE = 31;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_REFERENCE__ANNOTATION = 0;

	/**
	 * The feature id for the '<em><b>Explicit Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_REFERENCE__EXPLICIT_VALUES = 1;

	/**
	 * The number of structural features of the '<em>Jvm Annotation Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_REFERENCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmAnnotationValueImpl <em>Jvm Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmAnnotationValueImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmAnnotationValue()
	 * @generated
	 */
	int JVM_ANNOTATION_VALUE = 32;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_VALUE__OPERATION = 0;

	/**
	 * The number of structural features of the '<em>Jvm Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_VALUE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmIntAnnotationValueImpl <em>Jvm Int Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmIntAnnotationValueImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmIntAnnotationValue()
	 * @generated
	 */
	int JVM_INT_ANNOTATION_VALUE = 33;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_INT_ANNOTATION_VALUE__OPERATION = JVM_ANNOTATION_VALUE__OPERATION;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_INT_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Int Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_INT_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmBooleanAnnotationValueImpl <em>Jvm Boolean Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmBooleanAnnotationValueImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmBooleanAnnotationValue()
	 * @generated
	 */
	int JVM_BOOLEAN_ANNOTATION_VALUE = 34;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_BOOLEAN_ANNOTATION_VALUE__OPERATION = JVM_ANNOTATION_VALUE__OPERATION;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_BOOLEAN_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Boolean Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_BOOLEAN_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmByteAnnotationValueImpl <em>Jvm Byte Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmByteAnnotationValueImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmByteAnnotationValue()
	 * @generated
	 */
	int JVM_BYTE_ANNOTATION_VALUE = 35;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_BYTE_ANNOTATION_VALUE__OPERATION = JVM_ANNOTATION_VALUE__OPERATION;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_BYTE_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Byte Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_BYTE_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmShortAnnotationValueImpl <em>Jvm Short Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmShortAnnotationValueImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmShortAnnotationValue()
	 * @generated
	 */
	int JVM_SHORT_ANNOTATION_VALUE = 36;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_SHORT_ANNOTATION_VALUE__OPERATION = JVM_ANNOTATION_VALUE__OPERATION;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_SHORT_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Short Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_SHORT_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmLongAnnotationValueImpl <em>Jvm Long Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmLongAnnotationValueImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmLongAnnotationValue()
	 * @generated
	 */
	int JVM_LONG_ANNOTATION_VALUE = 37;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_LONG_ANNOTATION_VALUE__OPERATION = JVM_ANNOTATION_VALUE__OPERATION;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_LONG_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Long Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_LONG_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmDoubleAnnotationValueImpl <em>Jvm Double Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmDoubleAnnotationValueImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmDoubleAnnotationValue()
	 * @generated
	 */
	int JVM_DOUBLE_ANNOTATION_VALUE = 38;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DOUBLE_ANNOTATION_VALUE__OPERATION = JVM_ANNOTATION_VALUE__OPERATION;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DOUBLE_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Double Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DOUBLE_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmFloatAnnotationValueImpl <em>Jvm Float Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmFloatAnnotationValueImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmFloatAnnotationValue()
	 * @generated
	 */
	int JVM_FLOAT_ANNOTATION_VALUE = 39;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FLOAT_ANNOTATION_VALUE__OPERATION = JVM_ANNOTATION_VALUE__OPERATION;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FLOAT_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Float Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FLOAT_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmCharAnnotationValueImpl <em>Jvm Char Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmCharAnnotationValueImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmCharAnnotationValue()
	 * @generated
	 */
	int JVM_CHAR_ANNOTATION_VALUE = 40;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CHAR_ANNOTATION_VALUE__OPERATION = JVM_ANNOTATION_VALUE__OPERATION;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CHAR_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Char Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CHAR_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmStringAnnotationValueImpl <em>Jvm String Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmStringAnnotationValueImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmStringAnnotationValue()
	 * @generated
	 */
	int JVM_STRING_ANNOTATION_VALUE = 41;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRING_ANNOTATION_VALUE__OPERATION = JVM_ANNOTATION_VALUE__OPERATION;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRING_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm String Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRING_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmTypeAnnotationValueImpl <em>Jvm Type Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmTypeAnnotationValueImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmTypeAnnotationValue()
	 * @generated
	 */
	int JVM_TYPE_ANNOTATION_VALUE = 42;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_ANNOTATION_VALUE__OPERATION = JVM_ANNOTATION_VALUE__OPERATION;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Type Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmAnnotationAnnotationValueImpl <em>Jvm Annotation Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmAnnotationAnnotationValueImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmAnnotationAnnotationValue()
	 * @generated
	 */
	int JVM_ANNOTATION_ANNOTATION_VALUE = 43;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_ANNOTATION_VALUE__OPERATION = JVM_ANNOTATION_VALUE__OPERATION;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Annotation Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmEnumAnnotationValueImpl <em>Jvm Enum Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmEnumAnnotationValueImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmEnumAnnotationValue()
	 * @generated
	 */
	int JVM_ENUM_ANNOTATION_VALUE = 44;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUM_ANNOTATION_VALUE__OPERATION = JVM_ANNOTATION_VALUE__OPERATION;

	/**
	 * The feature id for the '<em><b>Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUM_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Enum Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUM_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmDelegateTypeReferenceImpl <em>Jvm Delegate Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmDelegateTypeReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmDelegateTypeReference()
	 * @generated
	 */
	int JVM_DELEGATE_TYPE_REFERENCE = 45;

	/**
	 * The feature id for the '<em><b>Delegate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DELEGATE_TYPE_REFERENCE__DELEGATE = JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Delegate Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DELEGATE_TYPE_REFERENCE_FEATURE_COUNT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmSpecializedTypeReferenceImpl <em>Jvm Specialized Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmSpecializedTypeReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmSpecializedTypeReference()
	 * @generated
	 */
	int JVM_SPECIALIZED_TYPE_REFERENCE = 46;

	/**
	 * The feature id for the '<em><b>Equivalent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Specialized Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmSynonymTypeReferenceImpl <em>Jvm Synonym Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmSynonymTypeReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmSynonymTypeReference()
	 * @generated
	 */
	int JVM_SYNONYM_TYPE_REFERENCE = 47;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_SYNONYM_TYPE_REFERENCE__TYPE = JVM_COMPOUND_TYPE_REFERENCE__TYPE;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_SYNONYM_TYPE_REFERENCE__REFERENCES = JVM_COMPOUND_TYPE_REFERENCE__REFERENCES;

	/**
	 * The number of structural features of the '<em>Jvm Synonym Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_SYNONYM_TYPE_REFERENCE_FEATURE_COUNT = JVM_COMPOUND_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmUnknownTypeReferenceImpl <em>Jvm Unknown Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmUnknownTypeReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmUnknownTypeReference()
	 * @generated
	 */
	int JVM_UNKNOWN_TYPE_REFERENCE = 48;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.4
	 * @generated
	 * @ordered
	 */
	int JVM_UNKNOWN_TYPE_REFERENCE__QUALIFIED_NAME = JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Unknown Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_UNKNOWN_TYPE_REFERENCE_FEATURE_COUNT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmCustomAnnotationValueImpl <em>Jvm Custom Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmCustomAnnotationValueImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmCustomAnnotationValue()
	 * @generated
	 */
	int JVM_CUSTOM_ANNOTATION_VALUE = 50;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CUSTOM_ANNOTATION_VALUE__OPERATION = JVM_ANNOTATION_VALUE__OPERATION;

	/**
	 * The feature id for the '<em><b>Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CUSTOM_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Custom Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CUSTOM_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.JvmInnerTypeReferenceImpl <em>Jvm Inner Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.JvmInnerTypeReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmInnerTypeReference()
	 * @generated
	 */
	int JVM_INNER_TYPE_REFERENCE = 51;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_INNER_TYPE_REFERENCE__ARGUMENTS = JVM_PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_INNER_TYPE_REFERENCE__TYPE = JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE;

	/**
	 * The feature id for the '<em><b>Outer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_INNER_TYPE_REFERENCE__OUTER = JVM_PARAMETERIZED_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Inner Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_INNER_TYPE_REFERENCE_FEATURE_COUNT = JVM_PARAMETERIZED_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.JvmVisibility <em>Jvm Visibility</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.JvmVisibility
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmVisibility()
	 * @generated
	 */
	int JVM_VISIBILITY = 52;

	/**
	 * The meta object id for the '<em>Iterable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Iterable
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getIterable()
	 * @generated
	 */
	int ITERABLE = 53;

	/**
	 * The meta object id for the '<em>IType Reference Visitor</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.util.ITypeReferenceVisitor
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getITypeReferenceVisitor()
	 * @generated
	 */
	int ITYPE_REFERENCE_VISITOR = 54;

	/**
	 * The meta object id for the '<em>IType Reference Visitor With Parameter</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.util.ITypeReferenceVisitorWithParameter
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getITypeReferenceVisitorWithParameter()
	 * @generated
	 */
	int ITYPE_REFERENCE_VISITOR_WITH_PARAMETER = 55;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmIdentifiableElement <em>Jvm Identifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Identifiable Element</em>'.
	 * @see org.eclipse.xtext.common.types.JvmIdentifiableElement
	 * @generated
	 */
	EClass getJvmIdentifiableElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmType <em>Jvm Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmType
	 * @generated
	 */
	EClass getJvmType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmVoid <em>Jvm Void</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Void</em>'.
	 * @see org.eclipse.xtext.common.types.JvmVoid
	 * @generated
	 */
	EClass getJvmVoid();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmComponentType <em>Jvm Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Component Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmComponentType
	 * @generated
	 */
	EClass getJvmComponentType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.JvmComponentType#getArrayType <em>Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Array Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmComponentType#getArrayType()
	 * @see #getJvmComponentType()
	 * @generated
	 */
	EReference getJvmComponentType_ArrayType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmPrimitiveType <em>Jvm Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Primitive Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmPrimitiveType
	 * @generated
	 */
	EClass getJvmPrimitiveType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmPrimitiveType#getSimpleName <em>Simple Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name</em>'.
	 * @see org.eclipse.xtext.common.types.JvmPrimitiveType#getSimpleName()
	 * @see #getJvmPrimitiveType()
	 * @generated
	 */
	EAttribute getJvmPrimitiveType_SimpleName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmArrayType <em>Jvm Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Array Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmArrayType
	 * @generated
	 */
	EClass getJvmArrayType();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.common.types.JvmArrayType#getComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Component Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmArrayType#getComponentType()
	 * @see #getJvmArrayType()
	 * @generated
	 */
	EReference getJvmArrayType_ComponentType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmDeclaredType <em>Jvm Declared Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Declared Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmDeclaredType
	 * @generated
	 */
	EClass getJvmDeclaredType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.JvmDeclaredType#getSuperTypes <em>Super Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Super Types</em>'.
	 * @see org.eclipse.xtext.common.types.JvmDeclaredType#getSuperTypes()
	 * @see #getJvmDeclaredType()
	 * @generated
	 */
	EReference getJvmDeclaredType_SuperTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.JvmDeclaredType#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see org.eclipse.xtext.common.types.JvmDeclaredType#getMembers()
	 * @see #getJvmDeclaredType()
	 * @generated
	 */
	EReference getJvmDeclaredType_Members();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmDeclaredType#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see org.eclipse.xtext.common.types.JvmDeclaredType#isAbstract()
	 * @see #getJvmDeclaredType()
	 * @generated
	 */
	EAttribute getJvmDeclaredType_Abstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmDeclaredType#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.xtext.common.types.JvmDeclaredType#isStatic()
	 * @see #getJvmDeclaredType()
	 * @generated
	 */
	EAttribute getJvmDeclaredType_Static();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmDeclaredType#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see org.eclipse.xtext.common.types.JvmDeclaredType#isFinal()
	 * @see #getJvmDeclaredType()
	 * @generated
	 */
	EAttribute getJvmDeclaredType_Final();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmDeclaredType#getPackageName <em>Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Name</em>'.
	 * @see org.eclipse.xtext.common.types.JvmDeclaredType#getPackageName()
	 * @see #getJvmDeclaredType()
	 * @generated
	 */
	EAttribute getJvmDeclaredType_PackageName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmTypeParameter <em>Jvm Type Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Type Parameter</em>'.
	 * @see org.eclipse.xtext.common.types.JvmTypeParameter
	 * @generated
	 */
	EClass getJvmTypeParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmTypeParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.common.types.JvmTypeParameter#getName()
	 * @see #getJvmTypeParameter()
	 * @generated
	 */
	EAttribute getJvmTypeParameter_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.common.types.JvmTypeParameter#getDeclarator <em>Declarator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Declarator</em>'.
	 * @see org.eclipse.xtext.common.types.JvmTypeParameter#getDeclarator()
	 * @see #getJvmTypeParameter()
	 * @generated
	 */
	EReference getJvmTypeParameter_Declarator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmTypeParameterDeclarator <em>Jvm Type Parameter Declarator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Type Parameter Declarator</em>'.
	 * @see org.eclipse.xtext.common.types.JvmTypeParameterDeclarator
	 * @generated
	 */
	EClass getJvmTypeParameterDeclarator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.JvmTypeParameterDeclarator#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.eclipse.xtext.common.types.JvmTypeParameterDeclarator#getTypeParameters()
	 * @see #getJvmTypeParameterDeclarator()
	 * @generated
	 */
	EReference getJvmTypeParameterDeclarator_TypeParameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmConstraintOwner <em>Jvm Constraint Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Constraint Owner</em>'.
	 * @see org.eclipse.xtext.common.types.JvmConstraintOwner
	 * @generated
	 */
	EClass getJvmConstraintOwner();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.JvmConstraintOwner#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.eclipse.xtext.common.types.JvmConstraintOwner#getConstraints()
	 * @see #getJvmConstraintOwner()
	 * @generated
	 */
	EReference getJvmConstraintOwner_Constraints();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmTypeConstraint <em>Jvm Type Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Type Constraint</em>'.
	 * @see org.eclipse.xtext.common.types.JvmTypeConstraint
	 * @generated
	 */
	EClass getJvmTypeConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.JvmTypeConstraint#getTypeReference <em>Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.JvmTypeConstraint#getTypeReference()
	 * @see #getJvmTypeConstraint()
	 * @generated
	 */
	EReference getJvmTypeConstraint_TypeReference();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.common.types.JvmTypeConstraint#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.xtext.common.types.JvmTypeConstraint#getOwner()
	 * @see #getJvmTypeConstraint()
	 * @generated
	 */
	EReference getJvmTypeConstraint_Owner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmUpperBound <em>Jvm Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Upper Bound</em>'.
	 * @see org.eclipse.xtext.common.types.JvmUpperBound
	 * @generated
	 */
	EClass getJvmUpperBound();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmLowerBound <em>Jvm Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Lower Bound</em>'.
	 * @see org.eclipse.xtext.common.types.JvmLowerBound
	 * @generated
	 */
	EClass getJvmLowerBound();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmAnnotationType <em>Jvm Annotation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Annotation Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmAnnotationType
	 * @generated
	 */
	EClass getJvmAnnotationType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmEnumerationType <em>Jvm Enumeration Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Enumeration Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmEnumerationType
	 * @generated
	 */
	EClass getJvmEnumerationType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.xtext.common.types.JvmEnumerationType#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Literals</em>'.
	 * @see org.eclipse.xtext.common.types.JvmEnumerationType#getLiterals()
	 * @see #getJvmEnumerationType()
	 * @generated
	 */
	EReference getJvmEnumerationType_Literals();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmEnumerationLiteral <em>Jvm Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Enumeration Literal</em>'.
	 * @see org.eclipse.xtext.common.types.JvmEnumerationLiteral
	 * @generated
	 */
	EClass getJvmEnumerationLiteral();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmGenericType <em>Jvm Generic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Generic Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmGenericType
	 * @generated
	 */
	EClass getJvmGenericType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmGenericType#isInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interface</em>'.
	 * @see org.eclipse.xtext.common.types.JvmGenericType#isInterface()
	 * @see #getJvmGenericType()
	 * @generated
	 */
	EAttribute getJvmGenericType_Interface();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmGenericType#isStrictFloatingPoint <em>Strict Floating Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strict Floating Point</em>'.
	 * @see org.eclipse.xtext.common.types.JvmGenericType#isStrictFloatingPoint()
	 * @see #getJvmGenericType()
	 * @generated
	 */
	EAttribute getJvmGenericType_StrictFloatingPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmGenericType#isAnonymous <em>Anonymous</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Anonymous</em>'.
	 * @see org.eclipse.xtext.common.types.JvmGenericType#isAnonymous()
	 * @see #getJvmGenericType()
	 * @generated
	 */
	EAttribute getJvmGenericType_Anonymous();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmTypeReference <em>Jvm Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.JvmTypeReference
	 * @generated
	 */
	EClass getJvmTypeReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmParameterizedTypeReference <em>Jvm Parameterized Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Parameterized Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.JvmParameterizedTypeReference
	 * @generated
	 */
	EClass getJvmParameterizedTypeReference();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.JvmParameterizedTypeReference#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipse.xtext.common.types.JvmParameterizedTypeReference#getArguments()
	 * @see #getJvmParameterizedTypeReference()
	 * @generated
	 */
	EReference getJvmParameterizedTypeReference_Arguments();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.common.types.JvmParameterizedTypeReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmParameterizedTypeReference#getType()
	 * @see #getJvmParameterizedTypeReference()
	 * @generated
	 */
	EReference getJvmParameterizedTypeReference_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmGenericArrayTypeReference <em>Jvm Generic Array Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Generic Array Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.JvmGenericArrayTypeReference
	 * @generated
	 */
	EClass getJvmGenericArrayTypeReference();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.JvmGenericArrayTypeReference#getComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmGenericArrayTypeReference#getComponentType()
	 * @see #getJvmGenericArrayTypeReference()
	 * @generated
	 */
	EReference getJvmGenericArrayTypeReference_ComponentType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmWildcardTypeReference <em>Jvm Wildcard Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Wildcard Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.JvmWildcardTypeReference
	 * @generated
	 */
	EClass getJvmWildcardTypeReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmAnyTypeReference <em>Jvm Any Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Any Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.JvmAnyTypeReference
	 * @generated
	 */
	EClass getJvmAnyTypeReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.common.types.JvmAnyTypeReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmAnyTypeReference#getType()
	 * @see #getJvmAnyTypeReference()
	 * @generated
	 */
	EReference getJvmAnyTypeReference_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmMultiTypeReference <em>Jvm Multi Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Multi Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.JvmMultiTypeReference
	 * @generated
	 */
	EClass getJvmMultiTypeReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmMember <em>Jvm Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Member</em>'.
	 * @see org.eclipse.xtext.common.types.JvmMember
	 * @generated
	 */
	EClass getJvmMember();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.common.types.JvmMember#getDeclaringType <em>Declaring Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Declaring Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmMember#getDeclaringType()
	 * @see #getJvmMember()
	 * @generated
	 */
	EReference getJvmMember_DeclaringType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmMember#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see org.eclipse.xtext.common.types.JvmMember#getVisibility()
	 * @see #getJvmMember()
	 * @generated
	 */
	EAttribute getJvmMember_Visibility();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmMember#getSimpleName <em>Simple Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name</em>'.
	 * @see org.eclipse.xtext.common.types.JvmMember#getSimpleName()
	 * @see #getJvmMember()
	 * @generated
	 */
	EAttribute getJvmMember_SimpleName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmMember#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.eclipse.xtext.common.types.JvmMember#getIdentifier()
	 * @see #getJvmMember()
	 * @generated
	 */
	EAttribute getJvmMember_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmMember#isDeprecated <em>Deprecated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deprecated</em>'.
	 * @see org.eclipse.xtext.common.types.JvmMember#isDeprecated()
	 * @see #getJvmMember()
	 * @generated
	 */
	EAttribute getJvmMember_Deprecated();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmFeature <em>Jvm Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Feature</em>'.
	 * @see org.eclipse.xtext.common.types.JvmFeature
	 * @generated
	 */
	EClass getJvmFeature();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.JvmFeature#getLocalClasses <em>Local Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Local Classes</em>'.
	 * @see org.eclipse.xtext.common.types.JvmFeature#getLocalClasses()
	 * @see #getJvmFeature()
	 * @generated
	 */
	EReference getJvmFeature_LocalClasses();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmField <em>Jvm Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Field</em>'.
	 * @see org.eclipse.xtext.common.types.JvmField
	 * @generated
	 */
	EClass getJvmField();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmField#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.xtext.common.types.JvmField#isStatic()
	 * @see #getJvmField()
	 * @generated
	 */
	EAttribute getJvmField_Static();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmField#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see org.eclipse.xtext.common.types.JvmField#isFinal()
	 * @see #getJvmField()
	 * @generated
	 */
	EAttribute getJvmField_Final();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.JvmField#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmField#getType()
	 * @see #getJvmField()
	 * @generated
	 */
	EReference getJvmField_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmField#isVolatile <em>Volatile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Volatile</em>'.
	 * @see org.eclipse.xtext.common.types.JvmField#isVolatile()
	 * @see #getJvmField()
	 * @generated
	 */
	EAttribute getJvmField_Volatile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmField#isTransient <em>Transient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transient</em>'.
	 * @see org.eclipse.xtext.common.types.JvmField#isTransient()
	 * @see #getJvmField()
	 * @generated
	 */
	EAttribute getJvmField_Transient();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmField#isConstant <em>Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constant</em>'.
	 * @see org.eclipse.xtext.common.types.JvmField#isConstant()
	 * @see #getJvmField()
	 * @generated
	 */
	EAttribute getJvmField_Constant();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmField#getConstantValue <em>Constant Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constant Value</em>'.
	 * @see org.eclipse.xtext.common.types.JvmField#getConstantValue()
	 * @see #getJvmField()
	 * @generated
	 */
	EAttribute getJvmField_ConstantValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmExecutable <em>Jvm Executable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Executable</em>'.
	 * @see org.eclipse.xtext.common.types.JvmExecutable
	 * @generated
	 */
	EClass getJvmExecutable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.JvmExecutable#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.xtext.common.types.JvmExecutable#getParameters()
	 * @see #getJvmExecutable()
	 * @generated
	 */
	EReference getJvmExecutable_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.JvmExecutable#getExceptions <em>Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exceptions</em>'.
	 * @see org.eclipse.xtext.common.types.JvmExecutable#getExceptions()
	 * @see #getJvmExecutable()
	 * @generated
	 */
	EReference getJvmExecutable_Exceptions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmExecutable#isVarArgs <em>Var Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var Args</em>'.
	 * @see org.eclipse.xtext.common.types.JvmExecutable#isVarArgs()
	 * @see #getJvmExecutable()
	 * @generated
	 */
	EAttribute getJvmExecutable_VarArgs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmConstructor <em>Jvm Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Constructor</em>'.
	 * @see org.eclipse.xtext.common.types.JvmConstructor
	 * @generated
	 */
	EClass getJvmConstructor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmOperation <em>Jvm Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Operation</em>'.
	 * @see org.eclipse.xtext.common.types.JvmOperation
	 * @generated
	 */
	EClass getJvmOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmOperation#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.xtext.common.types.JvmOperation#isStatic()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EAttribute getJvmOperation_Static();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmOperation#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see org.eclipse.xtext.common.types.JvmOperation#isFinal()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EAttribute getJvmOperation_Final();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmOperation#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see org.eclipse.xtext.common.types.JvmOperation#isAbstract()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EAttribute getJvmOperation_Abstract();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.JvmOperation#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmOperation#getReturnType()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EReference getJvmOperation_ReturnType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.JvmOperation#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Value</em>'.
	 * @see org.eclipse.xtext.common.types.JvmOperation#getDefaultValue()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EReference getJvmOperation_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmOperation#isSynchronized <em>Synchronized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Synchronized</em>'.
	 * @see org.eclipse.xtext.common.types.JvmOperation#isSynchronized()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EAttribute getJvmOperation_Synchronized();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmOperation#isDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipse.xtext.common.types.JvmOperation#isDefault()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EAttribute getJvmOperation_Default();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmOperation#isNative <em>Native</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Native</em>'.
	 * @see org.eclipse.xtext.common.types.JvmOperation#isNative()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EAttribute getJvmOperation_Native();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmOperation#isStrictFloatingPoint <em>Strict Floating Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strict Floating Point</em>'.
	 * @see org.eclipse.xtext.common.types.JvmOperation#isStrictFloatingPoint()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EAttribute getJvmOperation_StrictFloatingPoint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmFormalParameter <em>Jvm Formal Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Formal Parameter</em>'.
	 * @see org.eclipse.xtext.common.types.JvmFormalParameter
	 * @generated
	 */
	EClass getJvmFormalParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmFormalParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.common.types.JvmFormalParameter#getName()
	 * @see #getJvmFormalParameter()
	 * @generated
	 */
	EAttribute getJvmFormalParameter_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.JvmFormalParameter#getParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameter Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmFormalParameter#getParameterType()
	 * @see #getJvmFormalParameter()
	 * @generated
	 */
	EReference getJvmFormalParameter_ParameterType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmAnnotationTarget <em>Jvm Annotation Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Annotation Target</em>'.
	 * @see org.eclipse.xtext.common.types.JvmAnnotationTarget
	 * @generated
	 */
	EClass getJvmAnnotationTarget();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.JvmAnnotationTarget#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see org.eclipse.xtext.common.types.JvmAnnotationTarget#getAnnotations()
	 * @see #getJvmAnnotationTarget()
	 * @generated
	 */
	EReference getJvmAnnotationTarget_Annotations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmAnnotationReference <em>Jvm Annotation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Annotation Reference</em>'.
	 * @see org.eclipse.xtext.common.types.JvmAnnotationReference
	 * @generated
	 */
	EClass getJvmAnnotationReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.common.types.JvmAnnotationReference#getAnnotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Annotation</em>'.
	 * @see org.eclipse.xtext.common.types.JvmAnnotationReference#getAnnotation()
	 * @see #getJvmAnnotationReference()
	 * @generated
	 */
	EReference getJvmAnnotationReference_Annotation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.JvmAnnotationReference#getExplicitValues <em>Explicit Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Explicit Values</em>'.
	 * @see org.eclipse.xtext.common.types.JvmAnnotationReference#getExplicitValues()
	 * @see #getJvmAnnotationReference()
	 * @generated
	 */
	EReference getJvmAnnotationReference_ExplicitValues();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmAnnotationValue <em>Jvm Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Annotation Value</em>'.
	 * @see org.eclipse.xtext.common.types.JvmAnnotationValue
	 * @generated
	 */
	EClass getJvmAnnotationValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.common.types.JvmAnnotationValue#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see org.eclipse.xtext.common.types.JvmAnnotationValue#getOperation()
	 * @see #getJvmAnnotationValue()
	 * @generated
	 */
	EReference getJvmAnnotationValue_Operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmIntAnnotationValue <em>Jvm Int Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Int Annotation Value</em>'.
	 * @see org.eclipse.xtext.common.types.JvmIntAnnotationValue
	 * @generated
	 */
	EClass getJvmIntAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.xtext.common.types.JvmIntAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.xtext.common.types.JvmIntAnnotationValue#getValues()
	 * @see #getJvmIntAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmIntAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmBooleanAnnotationValue <em>Jvm Boolean Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Boolean Annotation Value</em>'.
	 * @see org.eclipse.xtext.common.types.JvmBooleanAnnotationValue
	 * @generated
	 */
	EClass getJvmBooleanAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.xtext.common.types.JvmBooleanAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.xtext.common.types.JvmBooleanAnnotationValue#getValues()
	 * @see #getJvmBooleanAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmBooleanAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmByteAnnotationValue <em>Jvm Byte Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Byte Annotation Value</em>'.
	 * @see org.eclipse.xtext.common.types.JvmByteAnnotationValue
	 * @generated
	 */
	EClass getJvmByteAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.xtext.common.types.JvmByteAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.xtext.common.types.JvmByteAnnotationValue#getValues()
	 * @see #getJvmByteAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmByteAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmShortAnnotationValue <em>Jvm Short Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Short Annotation Value</em>'.
	 * @see org.eclipse.xtext.common.types.JvmShortAnnotationValue
	 * @generated
	 */
	EClass getJvmShortAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.xtext.common.types.JvmShortAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.xtext.common.types.JvmShortAnnotationValue#getValues()
	 * @see #getJvmShortAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmShortAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmLongAnnotationValue <em>Jvm Long Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Long Annotation Value</em>'.
	 * @see org.eclipse.xtext.common.types.JvmLongAnnotationValue
	 * @generated
	 */
	EClass getJvmLongAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.xtext.common.types.JvmLongAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.xtext.common.types.JvmLongAnnotationValue#getValues()
	 * @see #getJvmLongAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmLongAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmDoubleAnnotationValue <em>Jvm Double Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Double Annotation Value</em>'.
	 * @see org.eclipse.xtext.common.types.JvmDoubleAnnotationValue
	 * @generated
	 */
	EClass getJvmDoubleAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.xtext.common.types.JvmDoubleAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.xtext.common.types.JvmDoubleAnnotationValue#getValues()
	 * @see #getJvmDoubleAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmDoubleAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmFloatAnnotationValue <em>Jvm Float Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Float Annotation Value</em>'.
	 * @see org.eclipse.xtext.common.types.JvmFloatAnnotationValue
	 * @generated
	 */
	EClass getJvmFloatAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.xtext.common.types.JvmFloatAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.xtext.common.types.JvmFloatAnnotationValue#getValues()
	 * @see #getJvmFloatAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmFloatAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmCharAnnotationValue <em>Jvm Char Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Char Annotation Value</em>'.
	 * @see org.eclipse.xtext.common.types.JvmCharAnnotationValue
	 * @generated
	 */
	EClass getJvmCharAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.xtext.common.types.JvmCharAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.xtext.common.types.JvmCharAnnotationValue#getValues()
	 * @see #getJvmCharAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmCharAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmStringAnnotationValue <em>Jvm String Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm String Annotation Value</em>'.
	 * @see org.eclipse.xtext.common.types.JvmStringAnnotationValue
	 * @generated
	 */
	EClass getJvmStringAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.xtext.common.types.JvmStringAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.xtext.common.types.JvmStringAnnotationValue#getValues()
	 * @see #getJvmStringAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmStringAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmTypeAnnotationValue <em>Jvm Type Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Type Annotation Value</em>'.
	 * @see org.eclipse.xtext.common.types.JvmTypeAnnotationValue
	 * @generated
	 */
	EClass getJvmTypeAnnotationValue();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.JvmTypeAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.eclipse.xtext.common.types.JvmTypeAnnotationValue#getValues()
	 * @see #getJvmTypeAnnotationValue()
	 * @generated
	 */
	EReference getJvmTypeAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue <em>Jvm Annotation Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Annotation Annotation Value</em>'.
	 * @see org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue
	 * @generated
	 */
	EClass getJvmAnnotationAnnotationValue();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue#getValues()
	 * @see #getJvmAnnotationAnnotationValue()
	 * @generated
	 */
	EReference getJvmAnnotationAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmEnumAnnotationValue <em>Jvm Enum Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Enum Annotation Value</em>'.
	 * @see org.eclipse.xtext.common.types.JvmEnumAnnotationValue
	 * @generated
	 */
	EClass getJvmEnumAnnotationValue();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.xtext.common.types.JvmEnumAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see org.eclipse.xtext.common.types.JvmEnumAnnotationValue#getValues()
	 * @see #getJvmEnumAnnotationValue()
	 * @generated
	 */
	EReference getJvmEnumAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmDelegateTypeReference <em>Jvm Delegate Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Delegate Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.JvmDelegateTypeReference
	 * @generated
	 */
	EClass getJvmDelegateTypeReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.common.types.JvmDelegateTypeReference#getDelegate <em>Delegate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Delegate</em>'.
	 * @see org.eclipse.xtext.common.types.JvmDelegateTypeReference#getDelegate()
	 * @see #getJvmDelegateTypeReference()
	 * @generated
	 */
	EReference getJvmDelegateTypeReference_Delegate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmSpecializedTypeReference <em>Jvm Specialized Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Specialized Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.JvmSpecializedTypeReference
	 * @generated
	 */
	EClass getJvmSpecializedTypeReference();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.JvmSpecializedTypeReference#getEquivalent <em>Equivalent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Equivalent</em>'.
	 * @see org.eclipse.xtext.common.types.JvmSpecializedTypeReference#getEquivalent()
	 * @see #getJvmSpecializedTypeReference()
	 * @generated
	 */
	EReference getJvmSpecializedTypeReference_Equivalent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmSynonymTypeReference <em>Jvm Synonym Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Synonym Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.JvmSynonymTypeReference
	 * @generated
	 */
	EClass getJvmSynonymTypeReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmUnknownTypeReference <em>Jvm Unknown Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Unknown Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.JvmUnknownTypeReference
	 * @generated
	 */
	EClass getJvmUnknownTypeReference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.JvmUnknownTypeReference#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see org.eclipse.xtext.common.types.JvmUnknownTypeReference#getQualifiedName()
	 * @see #getJvmUnknownTypeReference()
	 * @since 2.4
	 * @generated
	 */
	EAttribute getJvmUnknownTypeReference_QualifiedName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmCompoundTypeReference <em>Jvm Compound Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Compound Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.JvmCompoundTypeReference
	 * @generated
	 */
	EClass getJvmCompoundTypeReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.common.types.JvmCompoundTypeReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.common.types.JvmCompoundTypeReference#getType()
	 * @see #getJvmCompoundTypeReference()
	 * @generated
	 */
	EReference getJvmCompoundTypeReference_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.JvmCompoundTypeReference#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see org.eclipse.xtext.common.types.JvmCompoundTypeReference#getReferences()
	 * @see #getJvmCompoundTypeReference()
	 * @generated
	 */
	EReference getJvmCompoundTypeReference_References();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmCustomAnnotationValue <em>Jvm Custom Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Custom Annotation Value</em>'.
	 * @see org.eclipse.xtext.common.types.JvmCustomAnnotationValue
	 * @generated
	 */
	EClass getJvmCustomAnnotationValue();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.xtext.common.types.JvmCustomAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see org.eclipse.xtext.common.types.JvmCustomAnnotationValue#getValues()
	 * @see #getJvmCustomAnnotationValue()
	 * @generated
	 */
	EReference getJvmCustomAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.JvmInnerTypeReference <em>Jvm Inner Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Inner Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.JvmInnerTypeReference
	 * @generated
	 */
	EClass getJvmInnerTypeReference();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.JvmInnerTypeReference#getOuter <em>Outer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Outer</em>'.
	 * @see org.eclipse.xtext.common.types.JvmInnerTypeReference#getOuter()
	 * @see #getJvmInnerTypeReference()
	 * @generated
	 */
	EReference getJvmInnerTypeReference_Outer();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.xtext.common.types.JvmVisibility <em>Jvm Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Jvm Visibility</em>'.
	 * @see org.eclipse.xtext.common.types.JvmVisibility
	 * @generated
	 */
	EEnum getJvmVisibility();

	/**
	 * Returns the meta object for data type '{@link java.lang.Iterable <em>Iterable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Iterable</em>'.
	 * @see java.lang.Iterable
	 * @model instanceClass="java.lang.Iterable" typeParameters="E"
	 * @generated
	 */
	EDataType getIterable();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.xtext.common.types.util.ITypeReferenceVisitor <em>IType Reference Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IType Reference Visitor</em>'.
	 * @see org.eclipse.xtext.common.types.util.ITypeReferenceVisitor
	 * @model instanceClass="org.eclipse.xtext.common.types.util.ITypeReferenceVisitor" serializeable="false" typeParameters="Result"
	 * @generated
	 */
	EDataType getITypeReferenceVisitor();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.xtext.common.types.util.ITypeReferenceVisitorWithParameter <em>IType Reference Visitor With Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IType Reference Visitor With Parameter</em>'.
	 * @see org.eclipse.xtext.common.types.util.ITypeReferenceVisitorWithParameter
	 * @model instanceClass="org.eclipse.xtext.common.types.util.ITypeReferenceVisitorWithParameter" serializeable="false" typeParameters="Parameter Result"
	 * @generated
	 */
	EDataType getITypeReferenceVisitorWithParameter();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TypesFactory getTypesFactory();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmIdentifiableElementImpl <em>Jvm Identifiable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmIdentifiableElementImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmIdentifiableElement()
		 * @generated
		 */
		EClass JVM_IDENTIFIABLE_ELEMENT = eINSTANCE.getJvmIdentifiableElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmTypeImpl <em>Jvm Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmType()
		 * @generated
		 */
		EClass JVM_TYPE = eINSTANCE.getJvmType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmVoidImpl <em>Jvm Void</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmVoidImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmVoid()
		 * @generated
		 */
		EClass JVM_VOID = eINSTANCE.getJvmVoid();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmComponentTypeImpl <em>Jvm Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmComponentTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmComponentType()
		 * @generated
		 */
		EClass JVM_COMPONENT_TYPE = eINSTANCE.getJvmComponentType();

		/**
		 * The meta object literal for the '<em><b>Array Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_COMPONENT_TYPE__ARRAY_TYPE = eINSTANCE.getJvmComponentType_ArrayType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmPrimitiveTypeImpl <em>Jvm Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmPrimitiveTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmPrimitiveType()
		 * @generated
		 */
		EClass JVM_PRIMITIVE_TYPE = eINSTANCE.getJvmPrimitiveType();

		/**
		 * The meta object literal for the '<em><b>Simple Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_PRIMITIVE_TYPE__SIMPLE_NAME = eINSTANCE.getJvmPrimitiveType_SimpleName();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmArrayTypeImpl <em>Jvm Array Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmArrayTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmArrayType()
		 * @generated
		 */
		EClass JVM_ARRAY_TYPE = eINSTANCE.getJvmArrayType();

		/**
		 * The meta object literal for the '<em><b>Component Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ARRAY_TYPE__COMPONENT_TYPE = eINSTANCE.getJvmArrayType_ComponentType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmDeclaredTypeImpl <em>Jvm Declared Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmDeclaredTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmDeclaredType()
		 * @generated
		 */
		EClass JVM_DECLARED_TYPE = eINSTANCE.getJvmDeclaredType();

		/**
		 * The meta object literal for the '<em><b>Super Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_DECLARED_TYPE__SUPER_TYPES = eINSTANCE.getJvmDeclaredType_SuperTypes();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_DECLARED_TYPE__MEMBERS = eINSTANCE.getJvmDeclaredType_Members();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_DECLARED_TYPE__ABSTRACT = eINSTANCE.getJvmDeclaredType_Abstract();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_DECLARED_TYPE__STATIC = eINSTANCE.getJvmDeclaredType_Static();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_DECLARED_TYPE__FINAL = eINSTANCE.getJvmDeclaredType_Final();

		/**
		 * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_DECLARED_TYPE__PACKAGE_NAME = eINSTANCE.getJvmDeclaredType_PackageName();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmTypeParameterImpl <em>Jvm Type Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmTypeParameterImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmTypeParameter()
		 * @generated
		 */
		EClass JVM_TYPE_PARAMETER = eINSTANCE.getJvmTypeParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_TYPE_PARAMETER__NAME = eINSTANCE.getJvmTypeParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Declarator</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_TYPE_PARAMETER__DECLARATOR = eINSTANCE.getJvmTypeParameter_Declarator();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmTypeParameterDeclaratorImpl <em>Jvm Type Parameter Declarator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmTypeParameterDeclaratorImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmTypeParameterDeclarator()
		 * @generated
		 */
		EClass JVM_TYPE_PARAMETER_DECLARATOR = eINSTANCE.getJvmTypeParameterDeclarator();

		/**
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS = eINSTANCE.getJvmTypeParameterDeclarator_TypeParameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmConstraintOwnerImpl <em>Jvm Constraint Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmConstraintOwnerImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmConstraintOwner()
		 * @generated
		 */
		EClass JVM_CONSTRAINT_OWNER = eINSTANCE.getJvmConstraintOwner();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_CONSTRAINT_OWNER__CONSTRAINTS = eINSTANCE.getJvmConstraintOwner_Constraints();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmTypeConstraintImpl <em>Jvm Type Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmTypeConstraintImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmTypeConstraint()
		 * @generated
		 */
		EClass JVM_TYPE_CONSTRAINT = eINSTANCE.getJvmTypeConstraint();

		/**
		 * The meta object literal for the '<em><b>Type Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_TYPE_CONSTRAINT__TYPE_REFERENCE = eINSTANCE.getJvmTypeConstraint_TypeReference();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_TYPE_CONSTRAINT__OWNER = eINSTANCE.getJvmTypeConstraint_Owner();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmUpperBoundImpl <em>Jvm Upper Bound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmUpperBoundImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmUpperBound()
		 * @generated
		 */
		EClass JVM_UPPER_BOUND = eINSTANCE.getJvmUpperBound();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmLowerBoundImpl <em>Jvm Lower Bound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmLowerBoundImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmLowerBound()
		 * @generated
		 */
		EClass JVM_LOWER_BOUND = eINSTANCE.getJvmLowerBound();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmAnnotationTypeImpl <em>Jvm Annotation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmAnnotationTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmAnnotationType()
		 * @generated
		 */
		EClass JVM_ANNOTATION_TYPE = eINSTANCE.getJvmAnnotationType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmEnumerationTypeImpl <em>Jvm Enumeration Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmEnumerationTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmEnumerationType()
		 * @generated
		 */
		EClass JVM_ENUMERATION_TYPE = eINSTANCE.getJvmEnumerationType();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ENUMERATION_TYPE__LITERALS = eINSTANCE.getJvmEnumerationType_Literals();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmEnumerationLiteralImpl <em>Jvm Enumeration Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmEnumerationLiteralImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmEnumerationLiteral()
		 * @generated
		 */
		EClass JVM_ENUMERATION_LITERAL = eINSTANCE.getJvmEnumerationLiteral();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmGenericTypeImpl <em>Jvm Generic Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmGenericTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmGenericType()
		 * @generated
		 */
		EClass JVM_GENERIC_TYPE = eINSTANCE.getJvmGenericType();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_GENERIC_TYPE__INTERFACE = eINSTANCE.getJvmGenericType_Interface();

		/**
		 * The meta object literal for the '<em><b>Strict Floating Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_GENERIC_TYPE__STRICT_FLOATING_POINT = eINSTANCE.getJvmGenericType_StrictFloatingPoint();

		/**
		 * The meta object literal for the '<em><b>Anonymous</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_GENERIC_TYPE__ANONYMOUS = eINSTANCE.getJvmGenericType_Anonymous();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmTypeReferenceImpl <em>Jvm Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmTypeReferenceImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmTypeReference()
		 * @generated
		 */
		EClass JVM_TYPE_REFERENCE = eINSTANCE.getJvmTypeReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmParameterizedTypeReferenceImpl <em>Jvm Parameterized Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmParameterizedTypeReferenceImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmParameterizedTypeReference()
		 * @generated
		 */
		EClass JVM_PARAMETERIZED_TYPE_REFERENCE = eINSTANCE.getJvmParameterizedTypeReference();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS = eINSTANCE.getJvmParameterizedTypeReference_Arguments();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE = eINSTANCE.getJvmParameterizedTypeReference_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmGenericArrayTypeReferenceImpl <em>Jvm Generic Array Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmGenericArrayTypeReferenceImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmGenericArrayTypeReference()
		 * @generated
		 */
		EClass JVM_GENERIC_ARRAY_TYPE_REFERENCE = eINSTANCE.getJvmGenericArrayTypeReference();

		/**
		 * The meta object literal for the '<em><b>Component Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE = eINSTANCE.getJvmGenericArrayTypeReference_ComponentType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmWildcardTypeReferenceImpl <em>Jvm Wildcard Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmWildcardTypeReferenceImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmWildcardTypeReference()
		 * @generated
		 */
		EClass JVM_WILDCARD_TYPE_REFERENCE = eINSTANCE.getJvmWildcardTypeReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmAnyTypeReferenceImpl <em>Jvm Any Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmAnyTypeReferenceImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmAnyTypeReference()
		 * @generated
		 */
		EClass JVM_ANY_TYPE_REFERENCE = eINSTANCE.getJvmAnyTypeReference();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ANY_TYPE_REFERENCE__TYPE = eINSTANCE.getJvmAnyTypeReference_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmMultiTypeReferenceImpl <em>Jvm Multi Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmMultiTypeReferenceImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmMultiTypeReference()
		 * @generated
		 */
		EClass JVM_MULTI_TYPE_REFERENCE = eINSTANCE.getJvmMultiTypeReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmMemberImpl <em>Jvm Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmMemberImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmMember()
		 * @generated
		 */
		EClass JVM_MEMBER = eINSTANCE.getJvmMember();

		/**
		 * The meta object literal for the '<em><b>Declaring Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_MEMBER__DECLARING_TYPE = eINSTANCE.getJvmMember_DeclaringType();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_MEMBER__VISIBILITY = eINSTANCE.getJvmMember_Visibility();

		/**
		 * The meta object literal for the '<em><b>Simple Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_MEMBER__SIMPLE_NAME = eINSTANCE.getJvmMember_SimpleName();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_MEMBER__IDENTIFIER = eINSTANCE.getJvmMember_Identifier();

		/**
		 * The meta object literal for the '<em><b>Deprecated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_MEMBER__DEPRECATED = eINSTANCE.getJvmMember_Deprecated();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmFeatureImpl <em>Jvm Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmFeatureImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmFeature()
		 * @generated
		 */
		EClass JVM_FEATURE = eINSTANCE.getJvmFeature();

		/**
		 * The meta object literal for the '<em><b>Local Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_FEATURE__LOCAL_CLASSES = eINSTANCE.getJvmFeature_LocalClasses();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmFieldImpl <em>Jvm Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmFieldImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmField()
		 * @generated
		 */
		EClass JVM_FIELD = eINSTANCE.getJvmField();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_FIELD__STATIC = eINSTANCE.getJvmField_Static();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_FIELD__FINAL = eINSTANCE.getJvmField_Final();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_FIELD__TYPE = eINSTANCE.getJvmField_Type();

		/**
		 * The meta object literal for the '<em><b>Volatile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_FIELD__VOLATILE = eINSTANCE.getJvmField_Volatile();

		/**
		 * The meta object literal for the '<em><b>Transient</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_FIELD__TRANSIENT = eINSTANCE.getJvmField_Transient();

		/**
		 * The meta object literal for the '<em><b>Constant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_FIELD__CONSTANT = eINSTANCE.getJvmField_Constant();

		/**
		 * The meta object literal for the '<em><b>Constant Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_FIELD__CONSTANT_VALUE = eINSTANCE.getJvmField_ConstantValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmExecutableImpl <em>Jvm Executable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmExecutableImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmExecutable()
		 * @generated
		 */
		EClass JVM_EXECUTABLE = eINSTANCE.getJvmExecutable();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_EXECUTABLE__PARAMETERS = eINSTANCE.getJvmExecutable_Parameters();

		/**
		 * The meta object literal for the '<em><b>Exceptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_EXECUTABLE__EXCEPTIONS = eINSTANCE.getJvmExecutable_Exceptions();

		/**
		 * The meta object literal for the '<em><b>Var Args</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_EXECUTABLE__VAR_ARGS = eINSTANCE.getJvmExecutable_VarArgs();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmConstructorImpl <em>Jvm Constructor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmConstructorImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmConstructor()
		 * @generated
		 */
		EClass JVM_CONSTRUCTOR = eINSTANCE.getJvmConstructor();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmOperationImpl <em>Jvm Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmOperationImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmOperation()
		 * @generated
		 */
		EClass JVM_OPERATION = eINSTANCE.getJvmOperation();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_OPERATION__STATIC = eINSTANCE.getJvmOperation_Static();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_OPERATION__FINAL = eINSTANCE.getJvmOperation_Final();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_OPERATION__ABSTRACT = eINSTANCE.getJvmOperation_Abstract();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_OPERATION__RETURN_TYPE = eINSTANCE.getJvmOperation_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_OPERATION__DEFAULT_VALUE = eINSTANCE.getJvmOperation_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Synchronized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_OPERATION__SYNCHRONIZED = eINSTANCE.getJvmOperation_Synchronized();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_OPERATION__DEFAULT = eINSTANCE.getJvmOperation_Default();

		/**
		 * The meta object literal for the '<em><b>Native</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_OPERATION__NATIVE = eINSTANCE.getJvmOperation_Native();

		/**
		 * The meta object literal for the '<em><b>Strict Floating Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_OPERATION__STRICT_FLOATING_POINT = eINSTANCE.getJvmOperation_StrictFloatingPoint();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmFormalParameterImpl <em>Jvm Formal Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmFormalParameterImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmFormalParameter()
		 * @generated
		 */
		EClass JVM_FORMAL_PARAMETER = eINSTANCE.getJvmFormalParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_FORMAL_PARAMETER__NAME = eINSTANCE.getJvmFormalParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Parameter Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_FORMAL_PARAMETER__PARAMETER_TYPE = eINSTANCE.getJvmFormalParameter_ParameterType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmAnnotationTargetImpl <em>Jvm Annotation Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmAnnotationTargetImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmAnnotationTarget()
		 * @generated
		 */
		EClass JVM_ANNOTATION_TARGET = eINSTANCE.getJvmAnnotationTarget();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ANNOTATION_TARGET__ANNOTATIONS = eINSTANCE.getJvmAnnotationTarget_Annotations();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmAnnotationReferenceImpl <em>Jvm Annotation Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmAnnotationReferenceImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmAnnotationReference()
		 * @generated
		 */
		EClass JVM_ANNOTATION_REFERENCE = eINSTANCE.getJvmAnnotationReference();

		/**
		 * The meta object literal for the '<em><b>Annotation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ANNOTATION_REFERENCE__ANNOTATION = eINSTANCE.getJvmAnnotationReference_Annotation();

		/**
		 * The meta object literal for the '<em><b>Explicit Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ANNOTATION_REFERENCE__EXPLICIT_VALUES = eINSTANCE.getJvmAnnotationReference_ExplicitValues();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmAnnotationValueImpl <em>Jvm Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmAnnotationValueImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmAnnotationValue()
		 * @generated
		 */
		EClass JVM_ANNOTATION_VALUE = eINSTANCE.getJvmAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ANNOTATION_VALUE__OPERATION = eINSTANCE.getJvmAnnotationValue_Operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmIntAnnotationValueImpl <em>Jvm Int Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmIntAnnotationValueImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmIntAnnotationValue()
		 * @generated
		 */
		EClass JVM_INT_ANNOTATION_VALUE = eINSTANCE.getJvmIntAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_INT_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmIntAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmBooleanAnnotationValueImpl <em>Jvm Boolean Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmBooleanAnnotationValueImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmBooleanAnnotationValue()
		 * @generated
		 */
		EClass JVM_BOOLEAN_ANNOTATION_VALUE = eINSTANCE.getJvmBooleanAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_BOOLEAN_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmBooleanAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmByteAnnotationValueImpl <em>Jvm Byte Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmByteAnnotationValueImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmByteAnnotationValue()
		 * @generated
		 */
		EClass JVM_BYTE_ANNOTATION_VALUE = eINSTANCE.getJvmByteAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_BYTE_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmByteAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmShortAnnotationValueImpl <em>Jvm Short Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmShortAnnotationValueImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmShortAnnotationValue()
		 * @generated
		 */
		EClass JVM_SHORT_ANNOTATION_VALUE = eINSTANCE.getJvmShortAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_SHORT_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmShortAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmLongAnnotationValueImpl <em>Jvm Long Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmLongAnnotationValueImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmLongAnnotationValue()
		 * @generated
		 */
		EClass JVM_LONG_ANNOTATION_VALUE = eINSTANCE.getJvmLongAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_LONG_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmLongAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmDoubleAnnotationValueImpl <em>Jvm Double Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmDoubleAnnotationValueImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmDoubleAnnotationValue()
		 * @generated
		 */
		EClass JVM_DOUBLE_ANNOTATION_VALUE = eINSTANCE.getJvmDoubleAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_DOUBLE_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmDoubleAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmFloatAnnotationValueImpl <em>Jvm Float Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmFloatAnnotationValueImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmFloatAnnotationValue()
		 * @generated
		 */
		EClass JVM_FLOAT_ANNOTATION_VALUE = eINSTANCE.getJvmFloatAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_FLOAT_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmFloatAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmCharAnnotationValueImpl <em>Jvm Char Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmCharAnnotationValueImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmCharAnnotationValue()
		 * @generated
		 */
		EClass JVM_CHAR_ANNOTATION_VALUE = eINSTANCE.getJvmCharAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_CHAR_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmCharAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmStringAnnotationValueImpl <em>Jvm String Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmStringAnnotationValueImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmStringAnnotationValue()
		 * @generated
		 */
		EClass JVM_STRING_ANNOTATION_VALUE = eINSTANCE.getJvmStringAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_STRING_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmStringAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmTypeAnnotationValueImpl <em>Jvm Type Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmTypeAnnotationValueImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmTypeAnnotationValue()
		 * @generated
		 */
		EClass JVM_TYPE_ANNOTATION_VALUE = eINSTANCE.getJvmTypeAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_TYPE_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmTypeAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmAnnotationAnnotationValueImpl <em>Jvm Annotation Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmAnnotationAnnotationValueImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmAnnotationAnnotationValue()
		 * @generated
		 */
		EClass JVM_ANNOTATION_ANNOTATION_VALUE = eINSTANCE.getJvmAnnotationAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ANNOTATION_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmAnnotationAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmEnumAnnotationValueImpl <em>Jvm Enum Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmEnumAnnotationValueImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmEnumAnnotationValue()
		 * @generated
		 */
		EClass JVM_ENUM_ANNOTATION_VALUE = eINSTANCE.getJvmEnumAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ENUM_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmEnumAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmDelegateTypeReferenceImpl <em>Jvm Delegate Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmDelegateTypeReferenceImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmDelegateTypeReference()
		 * @generated
		 */
		EClass JVM_DELEGATE_TYPE_REFERENCE = eINSTANCE.getJvmDelegateTypeReference();

		/**
		 * The meta object literal for the '<em><b>Delegate</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_DELEGATE_TYPE_REFERENCE__DELEGATE = eINSTANCE.getJvmDelegateTypeReference_Delegate();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmSpecializedTypeReferenceImpl <em>Jvm Specialized Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmSpecializedTypeReferenceImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmSpecializedTypeReference()
		 * @generated
		 */
		EClass JVM_SPECIALIZED_TYPE_REFERENCE = eINSTANCE.getJvmSpecializedTypeReference();

		/**
		 * The meta object literal for the '<em><b>Equivalent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT = eINSTANCE.getJvmSpecializedTypeReference_Equivalent();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmSynonymTypeReferenceImpl <em>Jvm Synonym Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmSynonymTypeReferenceImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmSynonymTypeReference()
		 * @generated
		 */
		EClass JVM_SYNONYM_TYPE_REFERENCE = eINSTANCE.getJvmSynonymTypeReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmUnknownTypeReferenceImpl <em>Jvm Unknown Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmUnknownTypeReferenceImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmUnknownTypeReference()
		 * @generated
		 */
		EClass JVM_UNKNOWN_TYPE_REFERENCE = eINSTANCE.getJvmUnknownTypeReference();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @since 2.4
		 * @generated
		 */
		EAttribute JVM_UNKNOWN_TYPE_REFERENCE__QUALIFIED_NAME = eINSTANCE.getJvmUnknownTypeReference_QualifiedName();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmCompoundTypeReferenceImpl <em>Jvm Compound Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmCompoundTypeReferenceImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmCompoundTypeReference()
		 * @generated
		 */
		EClass JVM_COMPOUND_TYPE_REFERENCE = eINSTANCE.getJvmCompoundTypeReference();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_COMPOUND_TYPE_REFERENCE__TYPE = eINSTANCE.getJvmCompoundTypeReference_Type();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_COMPOUND_TYPE_REFERENCE__REFERENCES = eINSTANCE.getJvmCompoundTypeReference_References();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmCustomAnnotationValueImpl <em>Jvm Custom Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmCustomAnnotationValueImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmCustomAnnotationValue()
		 * @generated
		 */
		EClass JVM_CUSTOM_ANNOTATION_VALUE = eINSTANCE.getJvmCustomAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_CUSTOM_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmCustomAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.JvmInnerTypeReferenceImpl <em>Jvm Inner Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.JvmInnerTypeReferenceImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmInnerTypeReference()
		 * @generated
		 */
		EClass JVM_INNER_TYPE_REFERENCE = eINSTANCE.getJvmInnerTypeReference();

		/**
		 * The meta object literal for the '<em><b>Outer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_INNER_TYPE_REFERENCE__OUTER = eINSTANCE.getJvmInnerTypeReference_Outer();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.JvmVisibility <em>Jvm Visibility</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.JvmVisibility
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getJvmVisibility()
		 * @generated
		 */
		EEnum JVM_VISIBILITY = eINSTANCE.getJvmVisibility();

		/**
		 * The meta object literal for the '<em>Iterable</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Iterable
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getIterable()
		 * @generated
		 */
		EDataType ITERABLE = eINSTANCE.getIterable();

		/**
		 * The meta object literal for the '<em>IType Reference Visitor</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.util.ITypeReferenceVisitor
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getITypeReferenceVisitor()
		 * @generated
		 */
		EDataType ITYPE_REFERENCE_VISITOR = eINSTANCE.getITypeReferenceVisitor();

		/**
		 * The meta object literal for the '<em>IType Reference Visitor With Parameter</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.util.ITypeReferenceVisitorWithParameter
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getITypeReferenceVisitorWithParameter()
		 * @generated
		 */
		EDataType ITYPE_REFERENCE_VISITOR_WITH_PARAMETER = eINSTANCE.getITypeReferenceVisitorWithParameter();

	}

} //TypesPackage
