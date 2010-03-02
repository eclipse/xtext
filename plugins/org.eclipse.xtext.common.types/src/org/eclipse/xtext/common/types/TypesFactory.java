/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.common.types.TypesPackage
 * @generated
 */
public interface TypesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypesFactory eINSTANCE = org.eclipse.xtext.common.types.impl.TypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Jvm Void</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Void</em>'.
	 * @generated
	 */
	JvmVoid createJvmVoid();

	/**
	 * Returns a new object of class '<em>Jvm Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Primitive Type</em>'.
	 * @generated
	 */
	JvmPrimitiveType createJvmPrimitiveType();

	/**
	 * Returns a new object of class '<em>Jvm Array Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Array Type</em>'.
	 * @generated
	 */
	JvmArrayType createJvmArrayType();

	/**
	 * Returns a new object of class '<em>Jvm Type Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Type Parameter</em>'.
	 * @generated
	 */
	JvmTypeParameter createJvmTypeParameter();

	/**
	 * Returns a new object of class '<em>Jvm Upper Bound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Upper Bound</em>'.
	 * @generated
	 */
	JvmUpperBound createJvmUpperBound();

	/**
	 * Returns a new object of class '<em>Jvm Lower Bound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Lower Bound</em>'.
	 * @generated
	 */
	JvmLowerBound createJvmLowerBound();

	/**
	 * Returns a new object of class '<em>Jvm Annotation Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Annotation Type</em>'.
	 * @generated
	 */
	JvmAnnotationType createJvmAnnotationType();

	/**
	 * Returns a new object of class '<em>Jvm Enumeration Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Enumeration Type</em>'.
	 * @generated
	 */
	JvmEnumerationType createJvmEnumerationType();

	/**
	 * Returns a new object of class '<em>Jvm Generic Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Generic Type</em>'.
	 * @generated
	 */
	JvmGenericType createJvmGenericType();

	/**
	 * Returns a new object of class '<em>Jvm Parameterized Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Parameterized Type Reference</em>'.
	 * @generated
	 */
	JvmParameterizedTypeReference createJvmParameterizedTypeReference();

	/**
	 * Returns a new object of class '<em>Jvm Generic Array Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Generic Array Type Reference</em>'.
	 * @generated
	 */
	JvmGenericArrayTypeReference createJvmGenericArrayTypeReference();

	/**
	 * Returns a new object of class '<em>Jvm Wildcard Type Argument</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Wildcard Type Argument</em>'.
	 * @generated
	 */
	JvmWildcardTypeArgument createJvmWildcardTypeArgument();

	/**
	 * Returns a new object of class '<em>Jvm Reference Type Argument</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Reference Type Argument</em>'.
	 * @generated
	 */
	JvmReferenceTypeArgument createJvmReferenceTypeArgument();

	/**
	 * Returns a new object of class '<em>Jvm Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Field</em>'.
	 * @generated
	 */
	JvmField createJvmField();

	/**
	 * Returns a new object of class '<em>Jvm Constructor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Constructor</em>'.
	 * @generated
	 */
	JvmConstructor createJvmConstructor();

	/**
	 * Returns a new object of class '<em>Jvm Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Operation</em>'.
	 * @generated
	 */
	JvmOperation createJvmOperation();

	/**
	 * Returns a new object of class '<em>Jvm Formal Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Formal Parameter</em>'.
	 * @generated
	 */
	JvmFormalParameter createJvmFormalParameter();

	/**
	 * Returns a new object of class '<em>Jvm Annotation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Annotation Reference</em>'.
	 * @generated
	 */
	JvmAnnotationReference createJvmAnnotationReference();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TypesPackage getTypesPackage();

} //TypesFactory
