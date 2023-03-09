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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Annotation Annotation Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmAnnotationAnnotationValue()
 * @model
 * @generated
 */
public interface JvmAnnotationAnnotationValue extends JvmAnnotationValue
{
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmAnnotationReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmAnnotationAnnotationValue_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmAnnotationReference> getValues();

} // JvmAnnotationAnnotationValue
