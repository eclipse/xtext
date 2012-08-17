/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMember Feature Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XMemberFeatureCall#getMemberCallTarget <em>Member Call Target</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XMemberFeatureCall#getMemberCallArguments <em>Member Call Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isExplicitOperationCall <em>Explicit Operation Call</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isSpreading <em>Spreading</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isNullSafe <em>Null Safe</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXMemberFeatureCall()
 * @model
 * @generated
 */
public interface XMemberFeatureCall extends XAbstractFeatureCall
{
	/**
	 * Returns the value of the '<em><b>Member Call Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member Call Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member Call Target</em>' containment reference.
	 * @see #setMemberCallTarget(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXMemberFeatureCall_MemberCallTarget()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getMemberCallTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XMemberFeatureCall#getMemberCallTarget <em>Member Call Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member Call Target</em>' containment reference.
	 * @see #getMemberCallTarget()
	 * @generated
	 */
	void setMemberCallTarget(XExpression value);

	/**
	 * Returns the value of the '<em><b>Member Call Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member Call Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member Call Arguments</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXMemberFeatureCall_MemberCallArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getMemberCallArguments();

	/**
	 * Returns the value of the '<em><b>Explicit Operation Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Explicit Operation Call</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explicit Operation Call</em>' attribute.
	 * @see #setExplicitOperationCall(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXMemberFeatureCall_ExplicitOperationCall()
	 * @model
	 * @generated
	 */
	boolean isExplicitOperationCall();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isExplicitOperationCall <em>Explicit Operation Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explicit Operation Call</em>' attribute.
	 * @see #isExplicitOperationCall()
	 * @generated
	 */
	void setExplicitOperationCall(boolean value);

	/**
	 * Returns the value of the '<em><b>Spreading</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spreading</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spreading</em>' attribute.
	 * @see #setSpreading(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXMemberFeatureCall_Spreading()
	 * @model
	 * @generated
	 */
	boolean isSpreading();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isSpreading <em>Spreading</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spreading</em>' attribute.
	 * @see #isSpreading()
	 * @generated
	 */
	void setSpreading(boolean value);

	/**
	 * Returns the value of the '<em><b>Null Safe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Null Safe</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Null Safe</em>' attribute.
	 * @see #setNullSafe(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXMemberFeatureCall_NullSafe()
	 * @model
	 * @generated
	 */
	boolean isNullSafe();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isNullSafe <em>Null Safe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Null Safe</em>' attribute.
	 * @see #isNullSafe()
	 * @generated
	 */
	void setNullSafe(boolean value);

} // XMemberFeatureCall
