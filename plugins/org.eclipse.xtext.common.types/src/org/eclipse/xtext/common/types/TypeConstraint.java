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
 * A representation of the model object '<em><b>Type Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.TypeConstraint#getReferencedTypes <em>Referenced Types</em>}</li>
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
	 * Returns the value of the '<em><b>Referenced Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.TypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Types</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getTypeConstraint_ReferencedTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeReference> getReferencedTypes();

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
