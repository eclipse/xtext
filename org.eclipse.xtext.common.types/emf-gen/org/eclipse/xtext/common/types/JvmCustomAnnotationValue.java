/**
 * Copyright (c) 2011-2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.common.types;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Custom Annotation Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmCustomAnnotationValue#getValues <em>Values</em>}</li>
 * </ul>
 * 
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmCustomAnnotationValue()
 * @model
 * @generated
 * @since 2.1
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface JvmCustomAnnotationValue extends JvmAnnotationValue
{
	/**
	 * Returns the value of the '<em><b>Values</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmCustomAnnotationValue_Values()
	 * @model
	 * @generated
	 */
	EList<EObject> getValues();

} // JvmCustomAnnotationValue
