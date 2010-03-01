/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
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
public interface TypesPackage extends EPackage {
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
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.IdentifyableElementImpl <em>Identifyable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.IdentifyableElementImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getIdentifyableElement()
	 * @generated
	 */
	int IDENTIFYABLE_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Identifyable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFYABLE_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.TypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 1;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.VoidImpl <em>Void</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.VoidImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getVoid()
	 * @generated
	 */
	int VOID = 2;

	/**
	 * The number of structural features of the '<em>Void</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.ComponentTypeImpl <em>Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.ComponentTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getComponentType()
	 * @generated
	 */
	int COMPONENT_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__ARRAY_TYPE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.PrimitiveTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__ARRAY_TYPE = COMPONENT_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAME = COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.ArrayTypeImpl <em>Array Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.ArrayTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getArrayType()
	 * @generated
	 */
	int ARRAY_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__ARRAY_TYPE = COMPONENT_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Component Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__COMPONENT_TYPE = COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE_FEATURE_COUNT = COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.DeclaredTypeImpl <em>Declared Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.DeclaredTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getDeclaredType()
	 * @generated
	 */
	int DECLARED_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_TYPE__ARRAY_TYPE = COMPONENT_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_TYPE__ANNOTATIONS = COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_TYPE__DECLARING_TYPE = COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_TYPE__VISIBILITY = COMPONENT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_TYPE__FULLY_QUALIFIED_NAME = COMPONENT_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_TYPE__SUPER_TYPES = COMPONENT_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_TYPE__MEMBERS = COMPONENT_TYPE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Declared Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_TYPE_FEATURE_COUNT = COMPONENT_TYPE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.TypeParameterDeclaratorImpl <em>Type Parameter Declarator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.TypeParameterDeclaratorImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getTypeParameterDeclarator()
	 * @generated
	 */
	int TYPE_PARAMETER_DECLARATOR = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.ConstraintOwnerImpl <em>Constraint Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.ConstraintOwnerImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getConstraintOwner()
	 * @generated
	 */
	int CONSTRAINT_OWNER = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.TypeConstraintImpl <em>Type Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.TypeConstraintImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getTypeConstraint()
	 * @generated
	 */
	int TYPE_CONSTRAINT = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.UpperBoundImpl <em>Upper Bound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.UpperBoundImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getUpperBound()
	 * @generated
	 */
	int UPPER_BOUND = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.LowerBoundImpl <em>Lower Bound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.LowerBoundImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getLowerBound()
	 * @generated
	 */
	int LOWER_BOUND = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.AnnotationTypeImpl <em>Annotation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.AnnotationTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getAnnotationType()
	 * @generated
	 */
	int ANNOTATION_TYPE = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.EnumerationTypeImpl <em>Enumeration Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.EnumerationTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getEnumerationType()
	 * @generated
	 */
	int ENUMERATION_TYPE = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.GenericTypeImpl <em>Generic Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.GenericTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getGenericType()
	 * @generated
	 */
	int GENERIC_TYPE = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.TypeArgumentImpl <em>Type Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.TypeArgumentImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getTypeArgument()
	 * @generated
	 */
	int TYPE_ARGUMENT = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.WildcardTypeArgumentImpl <em>Wildcard Type Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.WildcardTypeArgumentImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getWildcardTypeArgument()
	 * @generated
	 */
	int WILDCARD_TYPE_ARGUMENT = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.ReferenceTypeArgumentImpl <em>Reference Type Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.ReferenceTypeArgumentImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getReferenceTypeArgument()
	 * @generated
	 */
	int REFERENCE_TYPE_ARGUMENT = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.TypeParameterImpl <em>Type Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.TypeParameterImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getTypeParameter()
	 * @generated
	 */
	int TYPE_PARAMETER = 7;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER__ARRAY_TYPE = COMPONENT_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER__CONSTRAINTS = COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER__NAME = COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declarator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER__DECLARATOR = COMPONENT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Type Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_FEATURE_COUNT = COMPONENT_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS = 0;

	/**
	 * The number of structural features of the '<em>Type Parameter Declarator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_DECLARATOR_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OWNER__CONSTRAINTS = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constraint Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OWNER_FEATURE_COUNT = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__TYPE_REFERENCE = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__OWNER = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT_FEATURE_COUNT = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_BOUND__TYPE_REFERENCE = TYPE_CONSTRAINT__TYPE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_BOUND__OWNER = TYPE_CONSTRAINT__OWNER;

	/**
	 * The number of structural features of the '<em>Upper Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_BOUND_FEATURE_COUNT = TYPE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_BOUND__TYPE_REFERENCE = TYPE_CONSTRAINT__TYPE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_BOUND__OWNER = TYPE_CONSTRAINT__OWNER;

	/**
	 * The number of structural features of the '<em>Lower Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_BOUND_FEATURE_COUNT = TYPE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_TYPE__ARRAY_TYPE = DECLARED_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_TYPE__ANNOTATIONS = DECLARED_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_TYPE__DECLARING_TYPE = DECLARED_TYPE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_TYPE__VISIBILITY = DECLARED_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_TYPE__FULLY_QUALIFIED_NAME = DECLARED_TYPE__FULLY_QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_TYPE__SUPER_TYPES = DECLARED_TYPE__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_TYPE__MEMBERS = DECLARED_TYPE__MEMBERS;

	/**
	 * The number of structural features of the '<em>Annotation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_TYPE_FEATURE_COUNT = DECLARED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__ARRAY_TYPE = DECLARED_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__ANNOTATIONS = DECLARED_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__DECLARING_TYPE = DECLARED_TYPE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__VISIBILITY = DECLARED_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__FULLY_QUALIFIED_NAME = DECLARED_TYPE__FULLY_QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__SUPER_TYPES = DECLARED_TYPE__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__MEMBERS = DECLARED_TYPE__MEMBERS;

	/**
	 * The number of structural features of the '<em>Enumeration Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE_FEATURE_COUNT = DECLARED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__ARRAY_TYPE = DECLARED_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__ANNOTATIONS = DECLARED_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__DECLARING_TYPE = DECLARED_TYPE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__VISIBILITY = DECLARED_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__FULLY_QUALIFIED_NAME = DECLARED_TYPE__FULLY_QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__SUPER_TYPES = DECLARED_TYPE__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__MEMBERS = DECLARED_TYPE__MEMBERS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__TYPE_PARAMETERS = DECLARED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__ABSTRACT = DECLARED_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__INTERFACE = DECLARED_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__STATIC = DECLARED_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__FINAL = DECLARED_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Generic Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE_FEATURE_COUNT = DECLARED_TYPE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.TypeReferenceImpl <em>Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.TypeReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getTypeReference()
	 * @generated
	 */
	int TYPE_REFERENCE = 16;

	/**
	 * The number of structural features of the '<em>Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REFERENCE_FEATURE_COUNT = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.ParameterizedTypeReferenceImpl <em>Parameterized Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.ParameterizedTypeReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getParameterizedTypeReference()
	 * @generated
	 */
	int PARAMETERIZED_TYPE_REFERENCE = 17;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS = TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REFERENCE__TYPE = TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameterized Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REFERENCE_FEATURE_COUNT = TYPE_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.GenericArrayTypeReferenceImpl <em>Generic Array Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.GenericArrayTypeReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getGenericArrayTypeReference()
	 * @generated
	 */
	int GENERIC_ARRAY_TYPE_REFERENCE = 18;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ARRAY_TYPE_REFERENCE__TYPE = TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Generic Array Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ARRAY_TYPE_REFERENCE_FEATURE_COUNT = TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declarator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ARGUMENT__DECLARATOR = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ARGUMENT_FEATURE_COUNT = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declarator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_ARGUMENT__DECLARATOR = TYPE_ARGUMENT__DECLARATOR;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_ARGUMENT__CONSTRAINTS = TYPE_ARGUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Wildcard Type Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_ARGUMENT_FEATURE_COUNT = TYPE_ARGUMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declarator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE_ARGUMENT__DECLARATOR = TYPE_ARGUMENT__DECLARATOR;

	/**
	 * The feature id for the '<em><b>Type Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE_ARGUMENT__TYPE_REFERENCE = TYPE_ARGUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Type Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE_ARGUMENT_FEATURE_COUNT = TYPE_ARGUMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.AnnotationTargetImpl <em>Annotation Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.AnnotationTargetImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getAnnotationTarget()
	 * @generated
	 */
	int ANNOTATION_TARGET = 28;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_TARGET__ANNOTATIONS = 0;

	/**
	 * The number of structural features of the '<em>Annotation Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_TARGET_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.MemberImpl <em>Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.MemberImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getMember()
	 * @generated
	 */
	int MEMBER = 22;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER__ANNOTATIONS = ANNOTATION_TARGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER__DECLARING_TYPE = ANNOTATION_TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER__VISIBILITY = ANNOTATION_TARGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER__FULLY_QUALIFIED_NAME = ANNOTATION_TARGET_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_FEATURE_COUNT = ANNOTATION_TARGET_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.FieldImpl <em>Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.FieldImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getField()
	 * @generated
	 */
	int FIELD = 23;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__ANNOTATIONS = MEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__DECLARING_TYPE = MEMBER__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__VISIBILITY = MEMBER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__FULLY_QUALIFIED_NAME = MEMBER__FULLY_QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__STATIC = MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__FINAL = MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__TYPE = MEMBER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_FEATURE_COUNT = MEMBER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.ExecutableImpl <em>Executable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.ExecutableImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getExecutable()
	 * @generated
	 */
	int EXECUTABLE = 24;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE__ANNOTATIONS = MEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE__DECLARING_TYPE = MEMBER__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE__VISIBILITY = MEMBER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE__FULLY_QUALIFIED_NAME = MEMBER__FULLY_QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE__TYPE_PARAMETERS = MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE__PARAMETERS = MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE__EXCEPTIONS = MEMBER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Executable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_FEATURE_COUNT = MEMBER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.ConstructorImpl <em>Constructor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.ConstructorImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getConstructor()
	 * @generated
	 */
	int CONSTRUCTOR = 25;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__ANNOTATIONS = EXECUTABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__DECLARING_TYPE = EXECUTABLE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__VISIBILITY = EXECUTABLE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__FULLY_QUALIFIED_NAME = EXECUTABLE__FULLY_QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__TYPE_PARAMETERS = EXECUTABLE__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__PARAMETERS = EXECUTABLE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__EXCEPTIONS = EXECUTABLE__EXCEPTIONS;

	/**
	 * The number of structural features of the '<em>Constructor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_FEATURE_COUNT = EXECUTABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.OperationImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 26;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__ANNOTATIONS = EXECUTABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__DECLARING_TYPE = EXECUTABLE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__VISIBILITY = EXECUTABLE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__FULLY_QUALIFIED_NAME = EXECUTABLE__FULLY_QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__TYPE_PARAMETERS = EXECUTABLE__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PARAMETERS = EXECUTABLE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__EXCEPTIONS = EXECUTABLE__EXCEPTIONS;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__STATIC = EXECUTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__FINAL = EXECUTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__ABSTRACT = EXECUTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__RETURN_TYPE = EXECUTABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = EXECUTABLE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.FormalParameterImpl <em>Formal Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.FormalParameterImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getFormalParameter()
	 * @generated
	 */
	int FORMAL_PARAMETER = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETER__NAME = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETER__PARAMETER_TYPE = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Formal Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETER_FEATURE_COUNT = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.AnnotationReferenceImpl <em>Annotation Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.AnnotationReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getAnnotationReference()
	 * @generated
	 */
	int ANNOTATION_REFERENCE = 29;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_REFERENCE__ANNOTATION = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_REFERENCE__TARGET = 1;

	/**
	 * The number of structural features of the '<em>Annotation Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_REFERENCE_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.Visibility <em>Visibility</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.Visibility
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getVisibility()
	 * @generated
	 */
	int VISIBILITY = 30;


	/**
	 * The meta object id for the '<em>Iterable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Iterable
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getIterable()
	 * @generated
	 */
	int ITERABLE = 31;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.IdentifyableElement <em>Identifyable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifyable Element</em>'.
	 * @see org.eclipse.xtext.common.types.IdentifyableElement
	 * @generated
	 */
	EClass getIdentifyableElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.eclipse.xtext.common.types.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.Void <em>Void</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Void</em>'.
	 * @see org.eclipse.xtext.common.types.Void
	 * @generated
	 */
	EClass getVoid();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Type</em>'.
	 * @see org.eclipse.xtext.common.types.ComponentType
	 * @generated
	 */
	EClass getComponentType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.ComponentType#getArrayType <em>Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Array Type</em>'.
	 * @see org.eclipse.xtext.common.types.ComponentType#getArrayType()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_ArrayType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see org.eclipse.xtext.common.types.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.PrimitiveType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.common.types.PrimitiveType#getName()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EAttribute getPrimitiveType_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.ArrayType <em>Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Type</em>'.
	 * @see org.eclipse.xtext.common.types.ArrayType
	 * @generated
	 */
	EClass getArrayType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.ArrayType#getComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component Type</em>'.
	 * @see org.eclipse.xtext.common.types.ArrayType#getComponentType()
	 * @see #getArrayType()
	 * @generated
	 */
	EReference getArrayType_ComponentType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.DeclaredType <em>Declared Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Declared Type</em>'.
	 * @see org.eclipse.xtext.common.types.DeclaredType
	 * @generated
	 */
	EClass getDeclaredType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.DeclaredType#getSuperTypes <em>Super Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Super Types</em>'.
	 * @see org.eclipse.xtext.common.types.DeclaredType#getSuperTypes()
	 * @see #getDeclaredType()
	 * @generated
	 */
	EReference getDeclaredType_SuperTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.DeclaredType#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see org.eclipse.xtext.common.types.DeclaredType#getMembers()
	 * @see #getDeclaredType()
	 * @generated
	 */
	EReference getDeclaredType_Members();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.TypeParameterDeclarator <em>Type Parameter Declarator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Parameter Declarator</em>'.
	 * @see org.eclipse.xtext.common.types.TypeParameterDeclarator
	 * @generated
	 */
	EClass getTypeParameterDeclarator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.TypeParameterDeclarator#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.eclipse.xtext.common.types.TypeParameterDeclarator#getTypeParameters()
	 * @see #getTypeParameterDeclarator()
	 * @generated
	 */
	EReference getTypeParameterDeclarator_TypeParameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.ConstraintOwner <em>Constraint Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Owner</em>'.
	 * @see org.eclipse.xtext.common.types.ConstraintOwner
	 * @generated
	 */
	EClass getConstraintOwner();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.ConstraintOwner#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.eclipse.xtext.common.types.ConstraintOwner#getConstraints()
	 * @see #getConstraintOwner()
	 * @generated
	 */
	EReference getConstraintOwner_Constraints();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.TypeConstraint <em>Type Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Constraint</em>'.
	 * @see org.eclipse.xtext.common.types.TypeConstraint
	 * @generated
	 */
	EClass getTypeConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.TypeConstraint#getTypeReference <em>Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.TypeConstraint#getTypeReference()
	 * @see #getTypeConstraint()
	 * @generated
	 */
	EReference getTypeConstraint_TypeReference();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.common.types.TypeConstraint#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.xtext.common.types.TypeConstraint#getOwner()
	 * @see #getTypeConstraint()
	 * @generated
	 */
	EReference getTypeConstraint_Owner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.UpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Upper Bound</em>'.
	 * @see org.eclipse.xtext.common.types.UpperBound
	 * @generated
	 */
	EClass getUpperBound();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.LowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lower Bound</em>'.
	 * @see org.eclipse.xtext.common.types.LowerBound
	 * @generated
	 */
	EClass getLowerBound();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.AnnotationType <em>Annotation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Type</em>'.
	 * @see org.eclipse.xtext.common.types.AnnotationType
	 * @generated
	 */
	EClass getAnnotationType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.EnumerationType <em>Enumeration Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Type</em>'.
	 * @see org.eclipse.xtext.common.types.EnumerationType
	 * @generated
	 */
	EClass getEnumerationType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.GenericType <em>Generic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Type</em>'.
	 * @see org.eclipse.xtext.common.types.GenericType
	 * @generated
	 */
	EClass getGenericType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.GenericType#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see org.eclipse.xtext.common.types.GenericType#isAbstract()
	 * @see #getGenericType()
	 * @generated
	 */
	EAttribute getGenericType_Abstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.GenericType#isInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interface</em>'.
	 * @see org.eclipse.xtext.common.types.GenericType#isInterface()
	 * @see #getGenericType()
	 * @generated
	 */
	EAttribute getGenericType_Interface();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.GenericType#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.xtext.common.types.GenericType#isStatic()
	 * @see #getGenericType()
	 * @generated
	 */
	EAttribute getGenericType_Static();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.GenericType#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see org.eclipse.xtext.common.types.GenericType#isFinal()
	 * @see #getGenericType()
	 * @generated
	 */
	EAttribute getGenericType_Final();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.TypeReference <em>Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.TypeReference
	 * @generated
	 */
	EClass getTypeReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.ParameterizedTypeReference <em>Parameterized Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterized Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.ParameterizedTypeReference
	 * @generated
	 */
	EClass getParameterizedTypeReference();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.ParameterizedTypeReference#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipse.xtext.common.types.ParameterizedTypeReference#getArguments()
	 * @see #getParameterizedTypeReference()
	 * @generated
	 */
	EReference getParameterizedTypeReference_Arguments();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.common.types.ParameterizedTypeReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.common.types.ParameterizedTypeReference#getType()
	 * @see #getParameterizedTypeReference()
	 * @generated
	 */
	EReference getParameterizedTypeReference_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.GenericArrayTypeReference <em>Generic Array Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Array Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.GenericArrayTypeReference
	 * @generated
	 */
	EClass getGenericArrayTypeReference();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.GenericArrayTypeReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.common.types.GenericArrayTypeReference#getType()
	 * @see #getGenericArrayTypeReference()
	 * @generated
	 */
	EReference getGenericArrayTypeReference_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.TypeArgument <em>Type Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Argument</em>'.
	 * @see org.eclipse.xtext.common.types.TypeArgument
	 * @generated
	 */
	EClass getTypeArgument();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.common.types.TypeArgument#getDeclarator <em>Declarator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Declarator</em>'.
	 * @see org.eclipse.xtext.common.types.TypeArgument#getDeclarator()
	 * @see #getTypeArgument()
	 * @generated
	 */
	EReference getTypeArgument_Declarator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.WildcardTypeArgument <em>Wildcard Type Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wildcard Type Argument</em>'.
	 * @see org.eclipse.xtext.common.types.WildcardTypeArgument
	 * @generated
	 */
	EClass getWildcardTypeArgument();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.ReferenceTypeArgument <em>Reference Type Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Type Argument</em>'.
	 * @see org.eclipse.xtext.common.types.ReferenceTypeArgument
	 * @generated
	 */
	EClass getReferenceTypeArgument();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.ReferenceTypeArgument#getTypeReference <em>Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Reference</em>'.
	 * @see org.eclipse.xtext.common.types.ReferenceTypeArgument#getTypeReference()
	 * @see #getReferenceTypeArgument()
	 * @generated
	 */
	EReference getReferenceTypeArgument_TypeReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.TypeParameter <em>Type Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Parameter</em>'.
	 * @see org.eclipse.xtext.common.types.TypeParameter
	 * @generated
	 */
	EClass getTypeParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.TypeParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.common.types.TypeParameter#getName()
	 * @see #getTypeParameter()
	 * @generated
	 */
	EAttribute getTypeParameter_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.common.types.TypeParameter#getDeclarator <em>Declarator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Declarator</em>'.
	 * @see org.eclipse.xtext.common.types.TypeParameter#getDeclarator()
	 * @see #getTypeParameter()
	 * @generated
	 */
	EReference getTypeParameter_Declarator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.Member <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Member</em>'.
	 * @see org.eclipse.xtext.common.types.Member
	 * @generated
	 */
	EClass getMember();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.common.types.Member#getDeclaringType <em>Declaring Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Declaring Type</em>'.
	 * @see org.eclipse.xtext.common.types.Member#getDeclaringType()
	 * @see #getMember()
	 * @generated
	 */
	EReference getMember_DeclaringType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.Member#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see org.eclipse.xtext.common.types.Member#getVisibility()
	 * @see #getMember()
	 * @generated
	 */
	EAttribute getMember_Visibility();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.Member#getFullyQualifiedName <em>Fully Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fully Qualified Name</em>'.
	 * @see org.eclipse.xtext.common.types.Member#getFullyQualifiedName()
	 * @see #getMember()
	 * @generated
	 */
	EAttribute getMember_FullyQualifiedName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field</em>'.
	 * @see org.eclipse.xtext.common.types.Field
	 * @generated
	 */
	EClass getField();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.Field#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.xtext.common.types.Field#isStatic()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Static();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.Field#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see org.eclipse.xtext.common.types.Field#isFinal()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Final();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.Field#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.common.types.Field#getType()
	 * @see #getField()
	 * @generated
	 */
	EReference getField_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.Executable <em>Executable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Executable</em>'.
	 * @see org.eclipse.xtext.common.types.Executable
	 * @generated
	 */
	EClass getExecutable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.Executable#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.xtext.common.types.Executable#getParameters()
	 * @see #getExecutable()
	 * @generated
	 */
	EReference getExecutable_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.Executable#getExceptions <em>Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exceptions</em>'.
	 * @see org.eclipse.xtext.common.types.Executable#getExceptions()
	 * @see #getExecutable()
	 * @generated
	 */
	EReference getExecutable_Exceptions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.Constructor <em>Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructor</em>'.
	 * @see org.eclipse.xtext.common.types.Constructor
	 * @generated
	 */
	EClass getConstructor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see org.eclipse.xtext.common.types.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.Operation#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.xtext.common.types.Operation#isStatic()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Static();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.Operation#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see org.eclipse.xtext.common.types.Operation#isFinal()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Final();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.Operation#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see org.eclipse.xtext.common.types.Operation#isAbstract()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Abstract();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.Operation#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.eclipse.xtext.common.types.Operation#getReturnType()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_ReturnType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.FormalParameter <em>Formal Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formal Parameter</em>'.
	 * @see org.eclipse.xtext.common.types.FormalParameter
	 * @generated
	 */
	EClass getFormalParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.FormalParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.common.types.FormalParameter#getName()
	 * @see #getFormalParameter()
	 * @generated
	 */
	EAttribute getFormalParameter_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.FormalParameter#getParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameter Type</em>'.
	 * @see org.eclipse.xtext.common.types.FormalParameter#getParameterType()
	 * @see #getFormalParameter()
	 * @generated
	 */
	EReference getFormalParameter_ParameterType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.AnnotationTarget <em>Annotation Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Target</em>'.
	 * @see org.eclipse.xtext.common.types.AnnotationTarget
	 * @generated
	 */
	EClass getAnnotationTarget();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.AnnotationTarget#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see org.eclipse.xtext.common.types.AnnotationTarget#getAnnotations()
	 * @see #getAnnotationTarget()
	 * @generated
	 */
	EReference getAnnotationTarget_Annotations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.AnnotationReference <em>Annotation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Reference</em>'.
	 * @see org.eclipse.xtext.common.types.AnnotationReference
	 * @generated
	 */
	EClass getAnnotationReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.common.types.AnnotationReference#getAnnotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Annotation</em>'.
	 * @see org.eclipse.xtext.common.types.AnnotationReference#getAnnotation()
	 * @see #getAnnotationReference()
	 * @generated
	 */
	EReference getAnnotationReference_Annotation();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.common.types.AnnotationReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Target</em>'.
	 * @see org.eclipse.xtext.common.types.AnnotationReference#getTarget()
	 * @see #getAnnotationReference()
	 * @generated
	 */
	EReference getAnnotationReference_Target();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.xtext.common.types.Visibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Visibility</em>'.
	 * @see org.eclipse.xtext.common.types.Visibility
	 * @generated
	 */
	EEnum getVisibility();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.IdentifyableElementImpl <em>Identifyable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.IdentifyableElementImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getIdentifyableElement()
		 * @generated
		 */
		EClass IDENTIFYABLE_ELEMENT = eINSTANCE.getIdentifyableElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.TypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.VoidImpl <em>Void</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.VoidImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getVoid()
		 * @generated
		 */
		EClass VOID = eINSTANCE.getVoid();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.ComponentTypeImpl <em>Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.ComponentTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getComponentType()
		 * @generated
		 */
		EClass COMPONENT_TYPE = eINSTANCE.getComponentType();

		/**
		 * The meta object literal for the '<em><b>Array Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__ARRAY_TYPE = eINSTANCE.getComponentType_ArrayType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.PrimitiveTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE__NAME = eINSTANCE.getPrimitiveType_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.ArrayTypeImpl <em>Array Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.ArrayTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getArrayType()
		 * @generated
		 */
		EClass ARRAY_TYPE = eINSTANCE.getArrayType();

		/**
		 * The meta object literal for the '<em><b>Component Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_TYPE__COMPONENT_TYPE = eINSTANCE.getArrayType_ComponentType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.DeclaredTypeImpl <em>Declared Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.DeclaredTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getDeclaredType()
		 * @generated
		 */
		EClass DECLARED_TYPE = eINSTANCE.getDeclaredType();

		/**
		 * The meta object literal for the '<em><b>Super Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECLARED_TYPE__SUPER_TYPES = eINSTANCE.getDeclaredType_SuperTypes();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECLARED_TYPE__MEMBERS = eINSTANCE.getDeclaredType_Members();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.TypeParameterDeclaratorImpl <em>Type Parameter Declarator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.TypeParameterDeclaratorImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getTypeParameterDeclarator()
		 * @generated
		 */
		EClass TYPE_PARAMETER_DECLARATOR = eINSTANCE.getTypeParameterDeclarator();

		/**
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS = eINSTANCE.getTypeParameterDeclarator_TypeParameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.ConstraintOwnerImpl <em>Constraint Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.ConstraintOwnerImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getConstraintOwner()
		 * @generated
		 */
		EClass CONSTRAINT_OWNER = eINSTANCE.getConstraintOwner();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_OWNER__CONSTRAINTS = eINSTANCE.getConstraintOwner_Constraints();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.TypeConstraintImpl <em>Type Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.TypeConstraintImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getTypeConstraint()
		 * @generated
		 */
		EClass TYPE_CONSTRAINT = eINSTANCE.getTypeConstraint();

		/**
		 * The meta object literal for the '<em><b>Type Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_CONSTRAINT__TYPE_REFERENCE = eINSTANCE.getTypeConstraint_TypeReference();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_CONSTRAINT__OWNER = eINSTANCE.getTypeConstraint_Owner();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.UpperBoundImpl <em>Upper Bound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.UpperBoundImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getUpperBound()
		 * @generated
		 */
		EClass UPPER_BOUND = eINSTANCE.getUpperBound();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.LowerBoundImpl <em>Lower Bound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.LowerBoundImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getLowerBound()
		 * @generated
		 */
		EClass LOWER_BOUND = eINSTANCE.getLowerBound();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.AnnotationTypeImpl <em>Annotation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.AnnotationTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getAnnotationType()
		 * @generated
		 */
		EClass ANNOTATION_TYPE = eINSTANCE.getAnnotationType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.EnumerationTypeImpl <em>Enumeration Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.EnumerationTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getEnumerationType()
		 * @generated
		 */
		EClass ENUMERATION_TYPE = eINSTANCE.getEnumerationType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.GenericTypeImpl <em>Generic Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.GenericTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getGenericType()
		 * @generated
		 */
		EClass GENERIC_TYPE = eINSTANCE.getGenericType();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_TYPE__ABSTRACT = eINSTANCE.getGenericType_Abstract();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_TYPE__INTERFACE = eINSTANCE.getGenericType_Interface();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_TYPE__STATIC = eINSTANCE.getGenericType_Static();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_TYPE__FINAL = eINSTANCE.getGenericType_Final();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.TypeReferenceImpl <em>Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.TypeReferenceImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getTypeReference()
		 * @generated
		 */
		EClass TYPE_REFERENCE = eINSTANCE.getTypeReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.ParameterizedTypeReferenceImpl <em>Parameterized Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.ParameterizedTypeReferenceImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getParameterizedTypeReference()
		 * @generated
		 */
		EClass PARAMETERIZED_TYPE_REFERENCE = eINSTANCE.getParameterizedTypeReference();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS = eINSTANCE.getParameterizedTypeReference_Arguments();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERIZED_TYPE_REFERENCE__TYPE = eINSTANCE.getParameterizedTypeReference_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.GenericArrayTypeReferenceImpl <em>Generic Array Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.GenericArrayTypeReferenceImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getGenericArrayTypeReference()
		 * @generated
		 */
		EClass GENERIC_ARRAY_TYPE_REFERENCE = eINSTANCE.getGenericArrayTypeReference();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_ARRAY_TYPE_REFERENCE__TYPE = eINSTANCE.getGenericArrayTypeReference_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.TypeArgumentImpl <em>Type Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.TypeArgumentImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getTypeArgument()
		 * @generated
		 */
		EClass TYPE_ARGUMENT = eINSTANCE.getTypeArgument();

		/**
		 * The meta object literal for the '<em><b>Declarator</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_ARGUMENT__DECLARATOR = eINSTANCE.getTypeArgument_Declarator();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.WildcardTypeArgumentImpl <em>Wildcard Type Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.WildcardTypeArgumentImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getWildcardTypeArgument()
		 * @generated
		 */
		EClass WILDCARD_TYPE_ARGUMENT = eINSTANCE.getWildcardTypeArgument();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.ReferenceTypeArgumentImpl <em>Reference Type Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.ReferenceTypeArgumentImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getReferenceTypeArgument()
		 * @generated
		 */
		EClass REFERENCE_TYPE_ARGUMENT = eINSTANCE.getReferenceTypeArgument();

		/**
		 * The meta object literal for the '<em><b>Type Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_TYPE_ARGUMENT__TYPE_REFERENCE = eINSTANCE.getReferenceTypeArgument_TypeReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.TypeParameterImpl <em>Type Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.TypeParameterImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getTypeParameter()
		 * @generated
		 */
		EClass TYPE_PARAMETER = eINSTANCE.getTypeParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_PARAMETER__NAME = eINSTANCE.getTypeParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Declarator</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_PARAMETER__DECLARATOR = eINSTANCE.getTypeParameter_Declarator();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.MemberImpl <em>Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.MemberImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getMember()
		 * @generated
		 */
		EClass MEMBER = eINSTANCE.getMember();

		/**
		 * The meta object literal for the '<em><b>Declaring Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBER__DECLARING_TYPE = eINSTANCE.getMember_DeclaringType();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBER__VISIBILITY = eINSTANCE.getMember_Visibility();

		/**
		 * The meta object literal for the '<em><b>Fully Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBER__FULLY_QUALIFIED_NAME = eINSTANCE.getMember_FullyQualifiedName();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.FieldImpl <em>Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.FieldImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getField()
		 * @generated
		 */
		EClass FIELD = eINSTANCE.getField();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD__STATIC = eINSTANCE.getField_Static();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD__FINAL = eINSTANCE.getField_Final();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIELD__TYPE = eINSTANCE.getField_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.ExecutableImpl <em>Executable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.ExecutableImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getExecutable()
		 * @generated
		 */
		EClass EXECUTABLE = eINSTANCE.getExecutable();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTABLE__PARAMETERS = eINSTANCE.getExecutable_Parameters();

		/**
		 * The meta object literal for the '<em><b>Exceptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTABLE__EXCEPTIONS = eINSTANCE.getExecutable_Exceptions();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.ConstructorImpl <em>Constructor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.ConstructorImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getConstructor()
		 * @generated
		 */
		EClass CONSTRUCTOR = eINSTANCE.getConstructor();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.OperationImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__STATIC = eINSTANCE.getOperation_Static();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__FINAL = eINSTANCE.getOperation_Final();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__ABSTRACT = eINSTANCE.getOperation_Abstract();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__RETURN_TYPE = eINSTANCE.getOperation_ReturnType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.FormalParameterImpl <em>Formal Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.FormalParameterImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getFormalParameter()
		 * @generated
		 */
		EClass FORMAL_PARAMETER = eINSTANCE.getFormalParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORMAL_PARAMETER__NAME = eINSTANCE.getFormalParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Parameter Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMAL_PARAMETER__PARAMETER_TYPE = eINSTANCE.getFormalParameter_ParameterType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.AnnotationTargetImpl <em>Annotation Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.AnnotationTargetImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getAnnotationTarget()
		 * @generated
		 */
		EClass ANNOTATION_TARGET = eINSTANCE.getAnnotationTarget();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_TARGET__ANNOTATIONS = eINSTANCE.getAnnotationTarget_Annotations();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.AnnotationReferenceImpl <em>Annotation Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.AnnotationReferenceImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getAnnotationReference()
		 * @generated
		 */
		EClass ANNOTATION_REFERENCE = eINSTANCE.getAnnotationReference();

		/**
		 * The meta object literal for the '<em><b>Annotation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_REFERENCE__ANNOTATION = eINSTANCE.getAnnotationReference_Annotation();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_REFERENCE__TARGET = eINSTANCE.getAnnotationReference_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.Visibility <em>Visibility</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.Visibility
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getVisibility()
		 * @generated
		 */
		EEnum VISIBILITY = eINSTANCE.getVisibility();

		/**
		 * The meta object literal for the '<em>Iterable</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Iterable
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getIterable()
		 * @generated
		 */
		EDataType ITERABLE = eINSTANCE.getIterable();

	}

} //TypesPackage
