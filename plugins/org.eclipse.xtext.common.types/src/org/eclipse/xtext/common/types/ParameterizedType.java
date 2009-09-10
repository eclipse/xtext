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
 *   <li>{@link org.eclipse.xtext.common.types.ParameterizedType#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.ParameterizedType#getDeclarator <em>Declarator</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.ParameterizedType#getRawType <em>Raw Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getParameterizedType()
 * @model
 * @generated
 */
public interface ParameterizedType extends ReferenceType {
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

	/**
	 * Returns the value of the '<em><b>Declarator</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.Member#getDeclaredParameterizedTypes <em>Declared Parameterized Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declarator</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declarator</em>' container reference.
	 * @see #setDeclarator(Member)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getParameterizedType_Declarator()
	 * @see org.eclipse.xtext.common.types.Member#getDeclaredParameterizedTypes
	 * @model opposite="declaredParameterizedTypes" transient="false"
	 * @generated
	 */
	Member getDeclarator();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.ParameterizedType#getDeclarator <em>Declarator</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declarator</em>' container reference.
	 * @see #getDeclarator()
	 * @generated
	 */
	void setDeclarator(Member value);

	/**
	 * Returns the value of the '<em><b>Raw Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Type</em>' containment reference.
	 * @see #setRawType(TypeReference)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getParameterizedType_RawType()
	 * @model containment="true"
	 * @generated
	 */
	TypeReference getRawType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.ParameterizedType#getRawType <em>Raw Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Type</em>' containment reference.
	 * @see #getRawType()
	 * @generated
	 */
	void setRawType(TypeReference value);

} // ParameterizedType
