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
 * A representation of the model object '<em><b>Type Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.TypeConstraint#getReferencedType <em>Referenced Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.TypeConstraint#getConstrainedType <em>Constrained Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getTypeConstraint()
 * @model abstract="true"
 * @generated
 */
public interface TypeConstraint extends IdentifyableElement {
	/**
	 * Returns the value of the '<em><b>Referenced Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Type</em>' containment reference.
	 * @see #setReferencedType(TypeReference)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getTypeConstraint_ReferencedType()
	 * @model containment="true"
	 * @generated
	 */
	TypeReference getReferencedType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.TypeConstraint#getReferencedType <em>Referenced Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Type</em>' containment reference.
	 * @see #getReferencedType()
	 * @generated
	 */
	void setReferencedType(TypeReference value);

	/**
	 * Returns the value of the '<em><b>Constrained Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.ConstrainedType#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrained Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constrained Type</em>' container reference.
	 * @see #setConstrainedType(ConstrainedType)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getTypeConstraint_ConstrainedType()
	 * @see org.eclipse.xtext.common.types.ConstrainedType#getConstraints
	 * @model opposite="constraints" transient="false"
	 * @generated
	 */
	ConstrainedType getConstrainedType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.TypeConstraint#getConstrainedType <em>Constrained Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constrained Type</em>' container reference.
	 * @see #getConstrainedType()
	 * @generated
	 */
	void setConstrainedType(ConstrainedType value);

} // TypeConstraint
