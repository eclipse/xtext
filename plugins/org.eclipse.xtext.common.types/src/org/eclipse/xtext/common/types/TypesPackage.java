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
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.ConstrainedTypeImpl <em>Constrained Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.ConstrainedTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getConstrainedType()
	 * @generated
	 */
	int CONSTRAINED_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_TYPE__CONSTRAINTS = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constrained Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.ComponentTypeImpl <em>Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.ComponentTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getComponentType()
	 * @generated
	 */
	int COMPONENT_TYPE = 4;

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
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.ReferenceTypeImpl <em>Reference Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.ReferenceTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getReferenceType()
	 * @generated
	 */
	int REFERENCE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__ARRAY_TYPE = COMPONENT_TYPE__ARRAY_TYPE;

	/**
	 * The number of structural features of the '<em>Reference Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE_FEATURE_COUNT = COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.PrimitiveTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 6;

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
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.WildcardImpl <em>Wildcard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.WildcardImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getWildcard()
	 * @generated
	 */
	int WILDCARD = 7;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD__CONSTRAINTS = CONSTRAINED_TYPE__CONSTRAINTS;

	/**
	 * The number of structural features of the '<em>Wildcard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_FEATURE_COUNT = CONSTRAINED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.ArrayTypeImpl <em>Array Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.ArrayTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getArrayType()
	 * @generated
	 */
	int ARRAY_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__ARRAY_TYPE = REFERENCE_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Component Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__COMPONENT_TYPE = REFERENCE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE_FEATURE_COUNT = REFERENCE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.DeclaredTypeImpl <em>Declared Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.DeclaredTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getDeclaredType()
	 * @generated
	 */
	int DECLARED_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_TYPE__ARRAY_TYPE = REFERENCE_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_TYPE__ANNOTATIONS = REFERENCE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_TYPE__DECLARING_TYPE = REFERENCE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_TYPE__FULLY_QUALIFIED_NAME = REFERENCE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Declared Parameterized Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_TYPE__DECLARED_PARAMETERIZED_TYPES = REFERENCE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_TYPE__VISIBILITY = REFERENCE_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_TYPE__SUPER_TYPES = REFERENCE_TYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_TYPE__MEMBERS = REFERENCE_TYPE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Declared Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_TYPE_FEATURE_COUNT = REFERENCE_TYPE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.TypeVariableDeclaratorImpl <em>Type Variable Declarator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.TypeVariableDeclaratorImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getTypeVariableDeclarator()
	 * @generated
	 */
	int TYPE_VARIABLE_DECLARATOR = 10;

	/**
	 * The feature id for the '<em><b>Type Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE_DECLARATOR__TYPE_VARIABLES = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Variable Declarator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE_DECLARATOR_FEATURE_COUNT = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.TypeVariableImpl <em>Type Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.TypeVariableImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getTypeVariable()
	 * @generated
	 */
	int TYPE_VARIABLE = 11;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE__ARRAY_TYPE = REFERENCE_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE__CONSTRAINTS = REFERENCE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE__NAME = REFERENCE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declarator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE__DECLARATOR = REFERENCE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Type Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE_FEATURE_COUNT = REFERENCE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.TypeConstraintImpl <em>Type Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.TypeConstraintImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getTypeConstraint()
	 * @generated
	 */
	int TYPE_CONSTRAINT = 12;

	/**
	 * The feature id for the '<em><b>Referenced Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__REFERENCED_TYPES = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constrained Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__CONSTRAINED_TYPE = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT_FEATURE_COUNT = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.UpperBoundImpl <em>Upper Bound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.UpperBoundImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getUpperBound()
	 * @generated
	 */
	int UPPER_BOUND = 13;

	/**
	 * The feature id for the '<em><b>Referenced Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_BOUND__REFERENCED_TYPES = TYPE_CONSTRAINT__REFERENCED_TYPES;

	/**
	 * The feature id for the '<em><b>Constrained Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_BOUND__CONSTRAINED_TYPE = TYPE_CONSTRAINT__CONSTRAINED_TYPE;

	/**
	 * The number of structural features of the '<em>Upper Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_BOUND_FEATURE_COUNT = TYPE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.LowerBoundImpl <em>Lower Bound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.LowerBoundImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getLowerBound()
	 * @generated
	 */
	int LOWER_BOUND = 14;

	/**
	 * The feature id for the '<em><b>Referenced Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_BOUND__REFERENCED_TYPES = TYPE_CONSTRAINT__REFERENCED_TYPES;

	/**
	 * The feature id for the '<em><b>Constrained Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_BOUND__CONSTRAINED_TYPE = TYPE_CONSTRAINT__CONSTRAINED_TYPE;

	/**
	 * The number of structural features of the '<em>Lower Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_BOUND_FEATURE_COUNT = TYPE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.AnnotationTypeImpl <em>Annotation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.AnnotationTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getAnnotationType()
	 * @generated
	 */
	int ANNOTATION_TYPE = 15;

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
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_TYPE__FULLY_QUALIFIED_NAME = DECLARED_TYPE__FULLY_QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Declared Parameterized Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_TYPE__DECLARED_PARAMETERIZED_TYPES = DECLARED_TYPE__DECLARED_PARAMETERIZED_TYPES;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_TYPE__VISIBILITY = DECLARED_TYPE__VISIBILITY;

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
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.EnumerationTypeImpl <em>Enumeration Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.EnumerationTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getEnumerationType()
	 * @generated
	 */
	int ENUMERATION_TYPE = 16;

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
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__FULLY_QUALIFIED_NAME = DECLARED_TYPE__FULLY_QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Declared Parameterized Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__DECLARED_PARAMETERIZED_TYPES = DECLARED_TYPE__DECLARED_PARAMETERIZED_TYPES;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__VISIBILITY = DECLARED_TYPE__VISIBILITY;

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
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.GenericTypeImpl <em>Generic Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.GenericTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getGenericType()
	 * @generated
	 */
	int GENERIC_TYPE = 17;

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
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__FULLY_QUALIFIED_NAME = DECLARED_TYPE__FULLY_QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Declared Parameterized Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__DECLARED_PARAMETERIZED_TYPES = DECLARED_TYPE__DECLARED_PARAMETERIZED_TYPES;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__VISIBILITY = DECLARED_TYPE__VISIBILITY;

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
	 * The feature id for the '<em><b>Type Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE__TYPE_VARIABLES = DECLARED_TYPE_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.ParameterizedTypeImpl <em>Parameterized Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.ParameterizedTypeImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getParameterizedType()
	 * @generated
	 */
	int PARAMETERIZED_TYPE = 18;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE__ARRAY_TYPE = REFERENCE_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE__FULLY_QUALIFIED_NAME = REFERENCE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE__PARAMETERS = REFERENCE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declarator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE__DECLARATOR = REFERENCE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Raw Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE__RAW_TYPE = REFERENCE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Parameterized Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_FEATURE_COUNT = REFERENCE_TYPE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.TypeParameterImpl <em>Type Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.TypeParameterImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getTypeParameter()
	 * @generated
	 */
	int TYPE_PARAMETER = 19;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER__VARIABLE = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_FEATURE_COUNT = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.WildcardTypeParameterImpl <em>Wildcard Type Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.WildcardTypeParameterImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getWildcardTypeParameter()
	 * @generated
	 */
	int WILDCARD_TYPE_PARAMETER = 20;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_PARAMETER__VARIABLE = TYPE_PARAMETER__VARIABLE;

	/**
	 * The feature id for the '<em><b>Wildcard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_PARAMETER__WILDCARD = TYPE_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Wildcard Type Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_PARAMETER_FEATURE_COUNT = TYPE_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.ReferenceTypeParameterImpl <em>Reference Type Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.ReferenceTypeParameterImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getReferenceTypeParameter()
	 * @generated
	 */
	int REFERENCE_TYPE_PARAMETER = 21;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE_PARAMETER__VARIABLE = TYPE_PARAMETER__VARIABLE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE_PARAMETER__REFERENCE = TYPE_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Type Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE_PARAMETER_FEATURE_COUNT = TYPE_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.TypeReferenceImpl <em>Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.TypeReferenceImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getTypeReference()
	 * @generated
	 */
	int TYPE_REFERENCE = 22;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REFERENCE__TYPE = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REFERENCE_FEATURE_COUNT = IDENTIFYABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.AnnotationTargetImpl <em>Annotation Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.AnnotationTargetImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getAnnotationTarget()
	 * @generated
	 */
	int ANNOTATION_TARGET = 29;

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
	int MEMBER = 23;

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
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER__FULLY_QUALIFIED_NAME = ANNOTATION_TARGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declared Parameterized Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER__DECLARED_PARAMETERIZED_TYPES = ANNOTATION_TARGET_FEATURE_COUNT + 2;

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
	int FIELD = 24;

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
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__FULLY_QUALIFIED_NAME = MEMBER__FULLY_QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Declared Parameterized Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__DECLARED_PARAMETERIZED_TYPES = MEMBER__DECLARED_PARAMETERIZED_TYPES;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__VISIBILITY = MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__STATIC = MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__FINAL = MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__TYPE = MEMBER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_FEATURE_COUNT = MEMBER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.ExecutableImpl <em>Executable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.ExecutableImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getExecutable()
	 * @generated
	 */
	int EXECUTABLE = 25;

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
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE__FULLY_QUALIFIED_NAME = MEMBER__FULLY_QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Declared Parameterized Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE__DECLARED_PARAMETERIZED_TYPES = MEMBER__DECLARED_PARAMETERIZED_TYPES;

	/**
	 * The feature id for the '<em><b>Type Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE__TYPE_VARIABLES = MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE__VISIBILITY = MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE__PARAMETERS = MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE__EXCEPTIONS = MEMBER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Executable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_FEATURE_COUNT = MEMBER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.common.types.impl.ConstructorImpl <em>Constructor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.common.types.impl.ConstructorImpl
	 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getConstructor()
	 * @generated
	 */
	int CONSTRUCTOR = 26;

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
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__FULLY_QUALIFIED_NAME = EXECUTABLE__FULLY_QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Declared Parameterized Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__DECLARED_PARAMETERIZED_TYPES = EXECUTABLE__DECLARED_PARAMETERIZED_TYPES;

	/**
	 * The feature id for the '<em><b>Type Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__TYPE_VARIABLES = EXECUTABLE__TYPE_VARIABLES;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__VISIBILITY = EXECUTABLE__VISIBILITY;

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
	int OPERATION = 27;

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
	 * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__FULLY_QUALIFIED_NAME = EXECUTABLE__FULLY_QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Declared Parameterized Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__DECLARED_PARAMETERIZED_TYPES = EXECUTABLE__DECLARED_PARAMETERIZED_TYPES;

	/**
	 * The feature id for the '<em><b>Type Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__TYPE_VARIABLES = EXECUTABLE__TYPE_VARIABLES;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__VISIBILITY = EXECUTABLE__VISIBILITY;

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
	int FORMAL_PARAMETER = 28;

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
	int ANNOTATION_REFERENCE = 30;

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
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.ConstrainedType <em>Constrained Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constrained Type</em>'.
	 * @see org.eclipse.xtext.common.types.ConstrainedType
	 * @generated
	 */
	EClass getConstrainedType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.ConstrainedType#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.eclipse.xtext.common.types.ConstrainedType#getConstraints()
	 * @see #getConstrainedType()
	 * @generated
	 */
	EReference getConstrainedType_Constraints();

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
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.ReferenceType <em>Reference Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Type</em>'.
	 * @see org.eclipse.xtext.common.types.ReferenceType
	 * @generated
	 */
	EClass getReferenceType();

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
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.Wildcard <em>Wildcard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wildcard</em>'.
	 * @see org.eclipse.xtext.common.types.Wildcard
	 * @generated
	 */
	EClass getWildcard();

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
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.common.types.ArrayType#getComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Component Type</em>'.
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
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.DeclaredType#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see org.eclipse.xtext.common.types.DeclaredType#getVisibility()
	 * @see #getDeclaredType()
	 * @generated
	 */
	EAttribute getDeclaredType_Visibility();

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
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.TypeVariableDeclarator <em>Type Variable Declarator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Variable Declarator</em>'.
	 * @see org.eclipse.xtext.common.types.TypeVariableDeclarator
	 * @generated
	 */
	EClass getTypeVariableDeclarator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.TypeVariableDeclarator#getTypeVariables <em>Type Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Variables</em>'.
	 * @see org.eclipse.xtext.common.types.TypeVariableDeclarator#getTypeVariables()
	 * @see #getTypeVariableDeclarator()
	 * @generated
	 */
	EReference getTypeVariableDeclarator_TypeVariables();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.TypeVariable <em>Type Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Variable</em>'.
	 * @see org.eclipse.xtext.common.types.TypeVariable
	 * @generated
	 */
	EClass getTypeVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.TypeVariable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.common.types.TypeVariable#getName()
	 * @see #getTypeVariable()
	 * @generated
	 */
	EAttribute getTypeVariable_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.common.types.TypeVariable#getDeclarator <em>Declarator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Declarator</em>'.
	 * @see org.eclipse.xtext.common.types.TypeVariable#getDeclarator()
	 * @see #getTypeVariable()
	 * @generated
	 */
	EReference getTypeVariable_Declarator();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.TypeConstraint#getReferencedTypes <em>Referenced Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Referenced Types</em>'.
	 * @see org.eclipse.xtext.common.types.TypeConstraint#getReferencedTypes()
	 * @see #getTypeConstraint()
	 * @generated
	 */
	EReference getTypeConstraint_ReferencedTypes();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.common.types.TypeConstraint#getConstrainedType <em>Constrained Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Constrained Type</em>'.
	 * @see org.eclipse.xtext.common.types.TypeConstraint#getConstrainedType()
	 * @see #getTypeConstraint()
	 * @generated
	 */
	EReference getTypeConstraint_ConstrainedType();

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
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.ParameterizedType <em>Parameterized Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterized Type</em>'.
	 * @see org.eclipse.xtext.common.types.ParameterizedType
	 * @generated
	 */
	EClass getParameterizedType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.ParameterizedType#getFullyQualifiedName <em>Fully Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fully Qualified Name</em>'.
	 * @see org.eclipse.xtext.common.types.ParameterizedType#getFullyQualifiedName()
	 * @see #getParameterizedType()
	 * @generated
	 */
	EAttribute getParameterizedType_FullyQualifiedName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.ParameterizedType#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.xtext.common.types.ParameterizedType#getParameters()
	 * @see #getParameterizedType()
	 * @generated
	 */
	EReference getParameterizedType_Parameters();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.common.types.ParameterizedType#getDeclarator <em>Declarator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Declarator</em>'.
	 * @see org.eclipse.xtext.common.types.ParameterizedType#getDeclarator()
	 * @see #getParameterizedType()
	 * @generated
	 */
	EReference getParameterizedType_Declarator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.ParameterizedType#getRawType <em>Raw Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Raw Type</em>'.
	 * @see org.eclipse.xtext.common.types.ParameterizedType#getRawType()
	 * @see #getParameterizedType()
	 * @generated
	 */
	EReference getParameterizedType_RawType();

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
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.common.types.TypeParameter#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.eclipse.xtext.common.types.TypeParameter#getVariable()
	 * @see #getTypeParameter()
	 * @generated
	 */
	EReference getTypeParameter_Variable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.WildcardTypeParameter <em>Wildcard Type Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wildcard Type Parameter</em>'.
	 * @see org.eclipse.xtext.common.types.WildcardTypeParameter
	 * @generated
	 */
	EClass getWildcardTypeParameter();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.WildcardTypeParameter#getWildcard <em>Wildcard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Wildcard</em>'.
	 * @see org.eclipse.xtext.common.types.WildcardTypeParameter#getWildcard()
	 * @see #getWildcardTypeParameter()
	 * @generated
	 */
	EReference getWildcardTypeParameter_Wildcard();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.common.types.ReferenceTypeParameter <em>Reference Type Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Type Parameter</em>'.
	 * @see org.eclipse.xtext.common.types.ReferenceTypeParameter
	 * @generated
	 */
	EClass getReferenceTypeParameter();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.ReferenceTypeParameter#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reference</em>'.
	 * @see org.eclipse.xtext.common.types.ReferenceTypeParameter#getReference()
	 * @see #getReferenceTypeParameter()
	 * @generated
	 */
	EReference getReferenceTypeParameter_Reference();

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
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.common.types.TypeReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.common.types.TypeReference#getType()
	 * @see #getTypeReference()
	 * @generated
	 */
	EReference getTypeReference_Type();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.Member#getDeclaredParameterizedTypes <em>Declared Parameterized Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declared Parameterized Types</em>'.
	 * @see org.eclipse.xtext.common.types.Member#getDeclaredParameterizedTypes()
	 * @see #getMember()
	 * @generated
	 */
	EReference getMember_DeclaredParameterizedTypes();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.Field#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see org.eclipse.xtext.common.types.Field#getVisibility()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Visibility();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.Executable#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see org.eclipse.xtext.common.types.Executable#getVisibility()
	 * @see #getExecutable()
	 * @generated
	 */
	EAttribute getExecutable_Visibility();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.ConstrainedTypeImpl <em>Constrained Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.ConstrainedTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getConstrainedType()
		 * @generated
		 */
		EClass CONSTRAINED_TYPE = eINSTANCE.getConstrainedType();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINED_TYPE__CONSTRAINTS = eINSTANCE.getConstrainedType_Constraints();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.ReferenceTypeImpl <em>Reference Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.ReferenceTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getReferenceType()
		 * @generated
		 */
		EClass REFERENCE_TYPE = eINSTANCE.getReferenceType();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.WildcardImpl <em>Wildcard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.WildcardImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getWildcard()
		 * @generated
		 */
		EClass WILDCARD = eINSTANCE.getWildcard();

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
		 * The meta object literal for the '<em><b>Component Type</b></em>' container reference feature.
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
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECLARED_TYPE__VISIBILITY = eINSTANCE.getDeclaredType_Visibility();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.TypeVariableDeclaratorImpl <em>Type Variable Declarator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.TypeVariableDeclaratorImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getTypeVariableDeclarator()
		 * @generated
		 */
		EClass TYPE_VARIABLE_DECLARATOR = eINSTANCE.getTypeVariableDeclarator();

		/**
		 * The meta object literal for the '<em><b>Type Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_VARIABLE_DECLARATOR__TYPE_VARIABLES = eINSTANCE.getTypeVariableDeclarator_TypeVariables();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.TypeVariableImpl <em>Type Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.TypeVariableImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getTypeVariable()
		 * @generated
		 */
		EClass TYPE_VARIABLE = eINSTANCE.getTypeVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_VARIABLE__NAME = eINSTANCE.getTypeVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Declarator</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_VARIABLE__DECLARATOR = eINSTANCE.getTypeVariable_Declarator();

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
		 * The meta object literal for the '<em><b>Referenced Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_CONSTRAINT__REFERENCED_TYPES = eINSTANCE.getTypeConstraint_ReferencedTypes();

		/**
		 * The meta object literal for the '<em><b>Constrained Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_CONSTRAINT__CONSTRAINED_TYPE = eINSTANCE.getTypeConstraint_ConstrainedType();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.ParameterizedTypeImpl <em>Parameterized Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.ParameterizedTypeImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getParameterizedType()
		 * @generated
		 */
		EClass PARAMETERIZED_TYPE = eINSTANCE.getParameterizedType();

		/**
		 * The meta object literal for the '<em><b>Fully Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETERIZED_TYPE__FULLY_QUALIFIED_NAME = eINSTANCE.getParameterizedType_FullyQualifiedName();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERIZED_TYPE__PARAMETERS = eINSTANCE.getParameterizedType_Parameters();

		/**
		 * The meta object literal for the '<em><b>Declarator</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERIZED_TYPE__DECLARATOR = eINSTANCE.getParameterizedType_Declarator();

		/**
		 * The meta object literal for the '<em><b>Raw Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERIZED_TYPE__RAW_TYPE = eINSTANCE.getParameterizedType_RawType();

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
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_PARAMETER__VARIABLE = eINSTANCE.getTypeParameter_Variable();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.WildcardTypeParameterImpl <em>Wildcard Type Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.WildcardTypeParameterImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getWildcardTypeParameter()
		 * @generated
		 */
		EClass WILDCARD_TYPE_PARAMETER = eINSTANCE.getWildcardTypeParameter();

		/**
		 * The meta object literal for the '<em><b>Wildcard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WILDCARD_TYPE_PARAMETER__WILDCARD = eINSTANCE.getWildcardTypeParameter_Wildcard();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.common.types.impl.ReferenceTypeParameterImpl <em>Reference Type Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.common.types.impl.ReferenceTypeParameterImpl
		 * @see org.eclipse.xtext.common.types.impl.TypesPackageImpl#getReferenceTypeParameter()
		 * @generated
		 */
		EClass REFERENCE_TYPE_PARAMETER = eINSTANCE.getReferenceTypeParameter();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_TYPE_PARAMETER__REFERENCE = eINSTANCE.getReferenceTypeParameter_Reference();

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
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_REFERENCE__TYPE = eINSTANCE.getTypeReference_Type();

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
		 * The meta object literal for the '<em><b>Fully Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBER__FULLY_QUALIFIED_NAME = eINSTANCE.getMember_FullyQualifiedName();

		/**
		 * The meta object literal for the '<em><b>Declared Parameterized Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBER__DECLARED_PARAMETERIZED_TYPES = eINSTANCE.getMember_DeclaredParameterizedTypes();

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
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD__VISIBILITY = eINSTANCE.getField_Visibility();

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
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTABLE__VISIBILITY = eINSTANCE.getExecutable_Visibility();

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

	}

} //TypesPackage
