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
 * A representation of the model object '<em><b>Jvm Enumeration Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmEnumerationLiteral#getEnumType <em>Enum Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmEnumerationLiteral()
 * @model
 * @generated
 */
public interface JvmEnumerationLiteral extends JvmIdentifyableElement {
	/**
	 * Returns the value of the '<em><b>Enum Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmEnumerationType#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum Type</em>' container reference.
	 * @see #setEnumType(JvmEnumerationType)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmEnumerationLiteral_EnumType()
	 * @see org.eclipse.xtext.common.types.JvmEnumerationType#getLiterals
	 * @model opposite="literals" transient="false"
	 * @generated
	 */
	JvmEnumerationType getEnumType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmEnumerationLiteral#getEnumType <em>Enum Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum Type</em>' container reference.
	 * @see #getEnumType()
	 * @generated
	 */
	void setEnumType(JvmEnumerationType value);

} // JvmEnumerationLiteral
