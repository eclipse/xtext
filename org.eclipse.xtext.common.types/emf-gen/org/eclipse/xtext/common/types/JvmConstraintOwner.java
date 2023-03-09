/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Constraint Owner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmConstraintOwner#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmConstraintOwner()
 * @model abstract="true"
 * @generated
 */
public interface JvmConstraintOwner extends EObject
{
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeConstraint}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmTypeConstraint#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmConstraintOwner_Constraints()
	 * @see org.eclipse.xtext.common.types.JvmTypeConstraint#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<JvmTypeConstraint> getConstraints();

} // JvmConstraintOwner
