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

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XConstructor Call</b></em>'.
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
 *   <li>{@link org.eclipse.xtext.xbase.XConstructorCall#getConstructor <em>Constructor</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XConstructorCall#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XConstructorCall#getTypeArguments <em>Type Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XConstructorCall#getInvalidFeatureIssueCode <em>Invalid Feature Issue Code</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XConstructorCall#isValidFeature <em>Valid Feature</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XConstructorCall#isExplicitConstructorCall <em>Explicit Constructor Call</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XConstructorCall#isAnonymousClassConstructorCall <em>Anonymous Class Constructor Call</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXConstructorCall()
 * @model
 * @generated
 */
public interface XConstructorCall extends XExpression
{
	/**
	 * Returns the value of the '<em><b>Constructor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constructor</em>' reference.
	 * @see #setConstructor(JvmConstructor)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXConstructorCall_Constructor()
	 * @model
	 * @generated
	 */
	JvmConstructor getConstructor();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XConstructorCall#getConstructor <em>Constructor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constructor</em>' reference.
	 * @see #getConstructor()
	 * @generated
	 */
	void setConstructor(JvmConstructor value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXConstructorCall_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getArguments();

	/**
	 * Returns the value of the '<em><b>Type Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Arguments</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXConstructorCall_TypeArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getTypeArguments();

	/**
	 * Returns the value of the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invalid Feature Issue Code</em>' attribute.
	 * @see #setInvalidFeatureIssueCode(String)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXConstructorCall_InvalidFeatureIssueCode()
	 * @model transient="true"
	 * @generated
	 */
	String getInvalidFeatureIssueCode();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XConstructorCall#getInvalidFeatureIssueCode <em>Invalid Feature Issue Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invalid Feature Issue Code</em>' attribute.
	 * @see #getInvalidFeatureIssueCode()
	 * @generated
	 */
	void setInvalidFeatureIssueCode(String value);

	/**
	 * Returns the value of the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid Feature</em>' attribute.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXConstructorCall_ValidFeature()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
	boolean isValidFeature();

	/**
	 * Returns the value of the '<em><b>Explicit Constructor Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explicit Constructor Call</em>' attribute.
	 * @see #setExplicitConstructorCall(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXConstructorCall_ExplicitConstructorCall()
	 * @model
	 * @generated
	 */
	boolean isExplicitConstructorCall();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XConstructorCall#isExplicitConstructorCall <em>Explicit Constructor Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explicit Constructor Call</em>' attribute.
	 * @see #isExplicitConstructorCall()
	 * @generated
	 */
	void setExplicitConstructorCall(boolean value);

	/**
	 * Returns the value of the '<em><b>Anonymous Class Constructor Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anonymous Class Constructor Call</em>' attribute.
	 * @see #setAnonymousClassConstructorCall(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXConstructorCall_AnonymousClassConstructorCall()
	 * @model transient="true"
	 * @generated
	 */
	boolean isAnonymousClassConstructorCall();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XConstructorCall#isAnonymousClassConstructorCall <em>Anonymous Class Constructor Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Anonymous Class Constructor Call</em>' attribute.
	 * @see #isAnonymousClassConstructorCall()
	 * @generated
	 */
	void setAnonymousClassConstructorCall(boolean value);

} // XConstructorCall
