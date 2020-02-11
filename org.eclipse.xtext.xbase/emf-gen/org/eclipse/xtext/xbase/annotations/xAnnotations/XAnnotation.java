/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.annotations.xAnnotations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmType;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAnnotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * @since 2.7
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation#getElementValuePairs <em>Element Value Pairs</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation#getAnnotationType <em>Annotation Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage#getXAnnotation()
 * @model
 * @generated
 */
public interface XAnnotation extends XExpression
{
	/**
	 * Returns the value of the '<em><b>Element Value Pairs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Value Pairs</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage#getXAnnotation_ElementValuePairs()
	 * @model containment="true"
	 * @generated
	 */
	EList<XAnnotationElementValuePair> getElementValuePairs();

	/**
	 * Returns the value of the '<em><b>Annotation Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation Type</em>' reference.
	 * @see #setAnnotationType(JvmType)
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage#getXAnnotation_AnnotationType()
	 * @model
	 * @generated
	 */
	JvmType getAnnotationType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation#getAnnotationType <em>Annotation Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation Type</em>' reference.
	 * @see #getAnnotationType()
	 * @generated
	 */
	void setAnnotationType(JvmType value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(XExpression)
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage#getXAnnotation_Value()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(XExpression value);

} // XAnnotation
