/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.TypeParameter#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.TypeParameter#getDeclarator <em>Declarator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getTypeParameter()
 * @model
 * @generated
 */
public interface TypeParameter extends ReferenceType, ConstrainedType {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getTypeParameter_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.TypeParameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Declarator</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.TypeParameterDeclarator#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declarator</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declarator</em>' container reference.
	 * @see #setDeclarator(TypeParameterDeclarator)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getTypeParameter_Declarator()
	 * @see org.eclipse.xtext.common.types.TypeParameterDeclarator#getTypeParameters
	 * @model opposite="typeParameters" transient="false"
	 * @generated
	 */
	TypeParameterDeclarator getDeclarator();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.TypeParameter#getDeclarator <em>Declarator</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declarator</em>' container reference.
	 * @see #getDeclarator()
	 * @generated
	 */
	void setDeclarator(TypeParameterDeclarator value);

} // TypeParameter
