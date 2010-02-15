/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.TypeArgument#getDeclarator <em>Declarator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getTypeArgument()
 * @model abstract="true"
 * @generated
 */
public interface TypeArgument extends IdentifyableElement {
	/**
	 * Returns the value of the '<em><b>Declarator</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.ParameterizedTypeReference#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declarator</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declarator</em>' container reference.
	 * @see #setDeclarator(ParameterizedTypeReference)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getTypeArgument_Declarator()
	 * @see org.eclipse.xtext.common.types.ParameterizedTypeReference#getArguments
	 * @model opposite="arguments" transient="false"
	 * @generated
	 */
	ParameterizedTypeReference getDeclarator();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.TypeArgument#getDeclarator <em>Declarator</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declarator</em>' container reference.
	 * @see #getDeclarator()
	 * @generated
	 */
	void setDeclarator(ParameterizedTypeReference value);

} // TypeArgument
