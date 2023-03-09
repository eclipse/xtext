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
 * A representation of the model object '<em><b>XMember Feature Call</b></em>'.
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
 *   <li>{@link org.eclipse.xtext.xbase.XMemberFeatureCall#getMemberCallTarget <em>Member Call Target</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XMemberFeatureCall#getMemberCallArguments <em>Member Call Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isExplicitOperationCall <em>Explicit Operation Call</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isExplicitStatic <em>Explicit Static</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isNullSafe <em>Null Safe</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isTypeLiteral <em>Type Literal</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isStaticWithDeclaringType <em>Static With Declaring Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isPackageFragment <em>Package Fragment</em>}</li>
 * </ul>
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
	 * Returns the value of the '<em><b>Explicit Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explicit Static</em>' attribute.
	 * @see #setExplicitStatic(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXMemberFeatureCall_ExplicitStatic()
	 * @model
	 * @generated
	 */
	boolean isExplicitStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isExplicitStatic <em>Explicit Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explicit Static</em>' attribute.
	 * @see #isExplicitStatic()
	 * @generated
	 */
	void setExplicitStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Null Safe</b></em>' attribute.
	 * <!-- begin-user-doc -->
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

	/**
	 * Returns the value of the '<em><b>Type Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Literal</em>' attribute.
	 * @see #setTypeLiteral(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXMemberFeatureCall_TypeLiteral()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	boolean isTypeLiteral();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isTypeLiteral <em>Type Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Literal</em>' attribute.
	 * @see #isTypeLiteral()
	 * @generated
	 */
	void setTypeLiteral(boolean value);

	/**
	 * Returns the value of the '<em><b>Static With Declaring Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static With Declaring Type</em>' attribute.
	 * @see #setStaticWithDeclaringType(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXMemberFeatureCall_StaticWithDeclaringType()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	boolean isStaticWithDeclaringType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isStaticWithDeclaringType <em>Static With Declaring Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static With Declaring Type</em>' attribute.
	 * @see #isStaticWithDeclaringType()
	 * @generated
	 */
	void setStaticWithDeclaringType(boolean value);

	/**
	 * Returns the value of the '<em><b>Package Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Fragment</em>' attribute.
	 * @see #setPackageFragment(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXMemberFeatureCall_PackageFragment()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	boolean isPackageFragment();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isPackageFragment <em>Package Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Fragment</em>' attribute.
	 * @see #isPackageFragment()
	 * @generated
	 */
	void setPackageFragment(boolean value);

} // XMemberFeatureCall
