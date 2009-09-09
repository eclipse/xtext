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
 * A representation of the model object '<em><b>Wildcard Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.WildcardTypeParameter#getWildcard <em>Wildcard</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getWildcardTypeParameter()
 * @model
 * @generated
 */
public interface WildcardTypeParameter extends TypeParameter {
	/**
	 * Returns the value of the '<em><b>Wildcard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wildcard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wildcard</em>' containment reference.
	 * @see #setWildcard(Wildcard)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getWildcardTypeParameter_Wildcard()
	 * @model containment="true"
	 * @generated
	 */
	Wildcard getWildcard();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.WildcardTypeParameter#getWildcard <em>Wildcard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wildcard</em>' containment reference.
	 * @see #getWildcard()
	 * @generated
	 */
	void setWildcard(Wildcard value);

} // WildcardTypeParameter
