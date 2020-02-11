/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Type Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmTypeConstraint#getTypeReference <em>Type Reference</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmTypeConstraint#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmTypeConstraint()
 * @model abstract="true"
 * @generated
 */
public interface JvmTypeConstraint extends EObject
{
	/**
	 * Returns the value of the '<em><b>Type Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The identifier of a JvmTypeConstraint is a canonical representation of the constraint information.</p>
	 * <p>Examples for constraint identifiers are:</p>
	 * <ul>
	 * <li>extends java.util.List<java.lang.Map$Entry<java.lang.Object,java.lang.Object>></li>
	 * <li>super java.lang.Object</li>
	 * </ul>
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getSimpleName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getQualifiedName(char innerClassDelimiter);

} // JvmTypeConstraint
