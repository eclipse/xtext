/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmAnnotationReference#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmAnnotationReference#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmAnnotationReference()
 * @model
 * @generated
 */
public interface JvmAnnotationReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Annotation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * Returns the value of the '<em><b>Target</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmAnnotationTarget#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' container reference.
	 * @see #setTarget(JvmAnnotationTarget)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmAnnotationReference_Target()
	 * @see org.eclipse.xtext.common.types.JvmAnnotationTarget#getAnnotations
	 * @model opposite="annotations" transient="false"
	 * @generated
	 */
	JvmAnnotationTarget getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmAnnotationReference#getTarget <em>Target</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' container reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(JvmAnnotationTarget value);

} // AnnotationReference
