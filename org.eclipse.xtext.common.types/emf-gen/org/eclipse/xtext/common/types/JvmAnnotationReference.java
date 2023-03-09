/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Annotation Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmAnnotationReference#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmAnnotationReference#getExplicitValues <em>Explicit Values</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmAnnotationReference()
 * @model
 * @generated
 */
public interface JvmAnnotationReference extends EObject
{
	/**
	 * Returns the value of the '<em><b>Annotation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation</em>' reference.
	 * @see #setAnnotation(JvmAnnotationType)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmAnnotationReference_Annotation()
	 * @model
	 * @generated
	 */
	JvmAnnotationType getAnnotation();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmAnnotationReference#getAnnotation <em>Annotation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation</em>' reference.
	 * @see #getAnnotation()
	 * @generated
	 */
	void setAnnotation(JvmAnnotationType value);

	/**
	 * Returns the value of the '<em><b>Explicit Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmAnnotationValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns the explicit annotation values. That is, default values are not expected to be contained in that list.</p>
	 * <p>Important note: Some implementations don't have enough information about default values on annotations.
	 * They may choose to consider all available values as explicit values.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Explicit Values</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmAnnotationReference_ExplicitValues()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmAnnotationValue> getExplicitValues();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns all annotation values. That is, default values are included if not explicitly given.</p>
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<JvmAnnotationValue> getValues();

} // JvmAnnotationReference
