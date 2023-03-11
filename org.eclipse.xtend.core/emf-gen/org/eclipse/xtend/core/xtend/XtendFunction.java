/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.xtend;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendFunction#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendFunction#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendFunction#getCreateExtensionInfo <em>Create Extension Info</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendFunction()
 * @model
 * @generated
 */
public interface XtendFunction extends XtendExecutable
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendFunction_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.xtend.XtendFunction#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(JvmTypeReference)
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendFunction_ReturnType()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getReturnType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.xtend.XtendFunction#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Create Extension Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create Extension Info</em>' containment reference.
	 * @see #setCreateExtensionInfo(CreateExtensionInfo)
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendFunction_CreateExtensionInfo()
	 * @model containment="true"
	 * @generated
	 */
	CreateExtensionInfo getCreateExtensionInfo();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.xtend.XtendFunction#getCreateExtensionInfo <em>Create Extension Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Extension Info</em>' containment reference.
	 * @see #getCreateExtensionInfo()
	 * @generated
	 */
	void setCreateExtensionInfo(CreateExtensionInfo value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isOverride();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isDispatch();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isStrictFloatingPoint();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isNative();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isSynchonized();

} // XtendFunction
