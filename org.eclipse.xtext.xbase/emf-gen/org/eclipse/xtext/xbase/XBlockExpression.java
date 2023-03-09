/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XBlock Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * @since 2.7
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XBlockExpression#getExpressions <em>Expressions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXBlockExpression()
 * @model
 * @generated
 */
public interface XBlockExpression extends XExpression
{
	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXBlockExpression_Expressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getExpressions();

} // XBlockExpression
