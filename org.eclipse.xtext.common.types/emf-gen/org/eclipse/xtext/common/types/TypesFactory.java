/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
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
public interface TypesFactory extends EFactory
{
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
	 * Returns a new object of class '<em>Jvm Enumeration Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Enumeration Literal</em>'.
	 * @generated
	 */
	JvmEnumerationLiteral createJvmEnumerationLiteral();

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
	 * Returns a new object of class '<em>Jvm Wildcard Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Wildcard Type Reference</em>'.
	 * @generated
	 */
	JvmWildcardTypeReference createJvmWildcardTypeReference();

	/**
	 * Returns a new object of class '<em>Jvm Any Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Any Type Reference</em>'.
	 * @generated
	 */
	JvmAnyTypeReference createJvmAnyTypeReference();

	/**
	 * Returns a new object of class '<em>Jvm Multi Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Multi Type Reference</em>'.
	 * @generated
	 */
	JvmMultiTypeReference createJvmMultiTypeReference();

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
	 * Returns a new object of class '<em>Jvm Int Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Int Annotation Value</em>'.
	 * @generated
	 */
	JvmIntAnnotationValue createJvmIntAnnotationValue();

	/**
	 * Returns a new object of class '<em>Jvm Boolean Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Boolean Annotation Value</em>'.
	 * @generated
	 */
	JvmBooleanAnnotationValue createJvmBooleanAnnotationValue();

	/**
	 * Returns a new object of class '<em>Jvm Byte Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Byte Annotation Value</em>'.
	 * @generated
	 */
	JvmByteAnnotationValue createJvmByteAnnotationValue();

	/**
	 * Returns a new object of class '<em>Jvm Short Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Short Annotation Value</em>'.
	 * @generated
	 */
	JvmShortAnnotationValue createJvmShortAnnotationValue();

	/**
	 * Returns a new object of class '<em>Jvm Long Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Long Annotation Value</em>'.
	 * @generated
	 */
	JvmLongAnnotationValue createJvmLongAnnotationValue();

	/**
	 * Returns a new object of class '<em>Jvm Double Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Double Annotation Value</em>'.
	 * @generated
	 */
	JvmDoubleAnnotationValue createJvmDoubleAnnotationValue();

	/**
	 * Returns a new object of class '<em>Jvm Float Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Float Annotation Value</em>'.
	 * @generated
	 */
	JvmFloatAnnotationValue createJvmFloatAnnotationValue();

	/**
	 * Returns a new object of class '<em>Jvm Char Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Char Annotation Value</em>'.
	 * @generated
	 */
	JvmCharAnnotationValue createJvmCharAnnotationValue();

	/**
	 * Returns a new object of class '<em>Jvm String Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm String Annotation Value</em>'.
	 * @generated
	 */
	JvmStringAnnotationValue createJvmStringAnnotationValue();

	/**
	 * Returns a new object of class '<em>Jvm Type Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Type Annotation Value</em>'.
	 * @generated
	 */
	JvmTypeAnnotationValue createJvmTypeAnnotationValue();

	/**
	 * Returns a new object of class '<em>Jvm Annotation Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Annotation Annotation Value</em>'.
	 * @generated
	 */
	JvmAnnotationAnnotationValue createJvmAnnotationAnnotationValue();

	/**
	 * Returns a new object of class '<em>Jvm Enum Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Enum Annotation Value</em>'.
	 * @generated
	 */
	JvmEnumAnnotationValue createJvmEnumAnnotationValue();

	/**
	 * Returns a new object of class '<em>Jvm Delegate Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Delegate Type Reference</em>'.
	 * @generated
	 */
	JvmDelegateTypeReference createJvmDelegateTypeReference();

	/**
	 * Returns a new object of class '<em>Jvm Synonym Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Synonym Type Reference</em>'.
	 * @generated
	 */
	JvmSynonymTypeReference createJvmSynonymTypeReference();

	/**
	 * Returns a new object of class '<em>Jvm Unknown Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Unknown Type Reference</em>'.
	 * @generated
	 */
	JvmUnknownTypeReference createJvmUnknownTypeReference();

	/**
	 * Returns a new object of class '<em>Jvm Custom Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Custom Annotation Value</em>'.
	 * @generated
	 */
	JvmCustomAnnotationValue createJvmCustomAnnotationValue();

	/**
	 * Returns a new object of class '<em>Jvm Inner Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Inner Type Reference</em>'.
	 * @generated
	 */
	JvmInnerTypeReference createJvmInnerTypeReference();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TypesPackage getTypesPackage();

} //TypesFactory
