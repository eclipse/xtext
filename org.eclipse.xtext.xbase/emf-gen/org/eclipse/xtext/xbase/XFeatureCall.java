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
 * A representation of the model object '<em><b>XFeature Call</b></em>'.
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
 *   <li>{@link org.eclipse.xtext.xbase.XFeatureCall#getFeatureCallArguments <em>Feature Call Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XFeatureCall#isExplicitOperationCall <em>Explicit Operation Call</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XFeatureCall#isTypeLiteral <em>Type Literal</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XFeatureCall#isPackageFragment <em>Package Fragment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXFeatureCall()
 * @model
 * @generated
 */
public interface XFeatureCall extends XAbstractFeatureCall
{
	/**
	 * Returns the value of the '<em><b>Feature Call Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Call Arguments</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXFeatureCall_FeatureCallArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getFeatureCallArguments();

	/**
	 * Returns the value of the '<em><b>Explicit Operation Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explicit Operation Call</em>' attribute.
	 * @see #setExplicitOperationCall(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXFeatureCall_ExplicitOperationCall()
	 * @model
	 * @generated
	 */
	boolean isExplicitOperationCall();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XFeatureCall#isExplicitOperationCall <em>Explicit Operation Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explicit Operation Call</em>' attribute.
	 * @see #isExplicitOperationCall()
	 * @generated
	 */
	void setExplicitOperationCall(boolean value);

	/**
	 * Returns the value of the '<em><b>Type Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Literal</em>' attribute.
	 * @see #setTypeLiteral(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXFeatureCall_TypeLiteral()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	boolean isTypeLiteral();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XFeatureCall#isTypeLiteral <em>Type Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Literal</em>' attribute.
	 * @see #isTypeLiteral()
	 * @generated
	 */
	void setTypeLiteral(boolean value);

	/**
	 * Returns the value of the '<em><b>Package Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Fragment</em>' attribute.
	 * @see #setPackageFragment(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXFeatureCall_PackageFragment()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	boolean isPackageFragment();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XFeatureCall#isPackageFragment <em>Package Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Fragment</em>' attribute.
	 * @see #isPackageFragment()
	 * @generated
	 */
	void setPackageFragment(boolean value);

} // XFeatureCall
