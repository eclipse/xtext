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
 * A representation of the model object '<em><b>Constrained Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.ConstrainedType#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getConstrainedType()
 * @model abstract="true"
 * @generated
 */
public interface ConstrainedType extends Type {
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.TypeConstraint}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.TypeConstraint#getConstrainedType <em>Constrained Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getConstrainedType_Constraints()
	 * @see org.eclipse.xtext.common.types.TypeConstraint#getConstrainedType
	 * @model opposite="constrainedType" containment="true"
	 * @generated
	 */
	EList<TypeConstraint> getConstraints();

} // ConstrainedType
