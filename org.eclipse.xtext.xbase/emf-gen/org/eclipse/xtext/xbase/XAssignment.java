/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAssignment</b></em>'.
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
 *   <li>{@link org.eclipse.xtext.xbase.XAssignment#getAssignable <em>Assignable</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XAssignment#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XAssignment#isExplicitStatic <em>Explicit Static</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XAssignment#isStaticWithDeclaringType <em>Static With Declaring Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXAssignment()
 * @model
 * @generated
 */
public interface XAssignment extends XAbstractFeatureCall
{
	/**
	 * Returns the value of the '<em><b>Assignable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignable</em>' containment reference.
	 * @see #setAssignable(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAssignment_Assignable()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getAssignable();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAssignment#getAssignable <em>Assignable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assignable</em>' containment reference.
	 * @see #getAssignable()
	 * @generated
	 */
	void setAssignable(XExpression value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAssignment_Value()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAssignment#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(XExpression value);

	/**
	 * Returns the value of the '<em><b>Explicit Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explicit Static</em>' attribute.
	 * @see #setExplicitStatic(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAssignment_ExplicitStatic()
	 * @model
	 * @generated
	 */
	boolean isExplicitStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAssignment#isExplicitStatic <em>Explicit Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explicit Static</em>' attribute.
	 * @see #isExplicitStatic()
	 * @generated
	 */
	void setExplicitStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Static With Declaring Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static With Declaring Type</em>' attribute.
	 * @see #setStaticWithDeclaringType(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAssignment_StaticWithDeclaringType()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	boolean isStaticWithDeclaringType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAssignment#isStaticWithDeclaringType <em>Static With Declaring Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static With Declaring Type</em>' attribute.
	 * @see #isStaticWithDeclaringType()
	 * @generated
	 */
	void setStaticWithDeclaringType(boolean value);

} // XAssignment
