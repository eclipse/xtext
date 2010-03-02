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
 *   <li>{@link org.eclipse.xtext.common.types.JvmTypeConstraint#getTypeReference <em>Type Reference</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmTypeConstraint#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmTypeConstraint()
 * @model abstract="true"
 * @generated
 */
public interface JvmTypeConstraint extends JvmIdentifyableElement {
	/**
	 * Returns the value of the '<em><b>Type Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Reference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Reference</em>' containment reference.
	 * @see #setTypeReference(JvmTypeReference)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmTypeConstraint_TypeReference()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getTypeReference();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmTypeConstraint#getTypeReference <em>Type Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Reference</em>' containment reference.
	 * @see #getTypeReference()
	 * @generated
	 */
	void setTypeReference(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmConstraintOwner#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(JvmConstraintOwner)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmTypeConstraint_Owner()
	 * @see org.eclipse.xtext.common.types.JvmConstraintOwner#getConstraints
	 * @model opposite="constraints" transient="false"
	 * @generated
	 */
	JvmConstraintOwner getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmTypeConstraint#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(JvmConstraintOwner value);

} // TypeConstraint
