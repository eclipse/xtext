/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmAnnotationTarget#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmAnnotationTarget()
 * @model abstract="true"
 * @generated
 */
public interface JvmAnnotationTarget extends EObject {
	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmAnnotationReference}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmAnnotationReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmAnnotationTarget_Annotations()
	 * @see org.eclipse.xtext.common.types.JvmAnnotationReference#getTarget
	 * @model opposite="target" containment="true"
	 * @generated
	 */
	EList<JvmAnnotationReference> getAnnotations();

} // AnnotationTarget
