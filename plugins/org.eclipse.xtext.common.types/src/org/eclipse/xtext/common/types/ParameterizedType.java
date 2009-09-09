/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameterized Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.ParameterizedType#getRawType <em>Raw Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.ParameterizedType#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getParameterizedType()
 * @model
 * @generated
 */
public interface ParameterizedType extends ReferenceType {
	/**
	 * Returns the value of the '<em><b>Raw Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Type</em>' containment reference.
	 * @see #setRawType(GenericType)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getParameterizedType_RawType()
	 * @model containment="true"
	 * @generated
	 */
	GenericType getRawType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.ParameterizedType#getRawType <em>Raw Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Type</em>' containment reference.
	 * @see #getRawType()
	 * @generated
	 */
	void setRawType(GenericType value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.TypeParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getParameterizedType_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeParameter> getParameters();

} // ParameterizedType
