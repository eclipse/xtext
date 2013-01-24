/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package org.eclipse.xtend.core.xtend;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendFunction#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendFunction#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendFunction#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendFunction#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendFunction#getCreateExtensionInfo <em>Create Extension Info</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendFunction#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendFunction#getExceptions <em>Exceptions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendFunction()
 * @model
 * @generated
 */
public interface XtendFunction extends XtendMember
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(XExpression)
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendFunction_Expression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.xtend.XtendFunction#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtend.core.xtend.XtendParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendFunction_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<XtendParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Create Extension Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Extension Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * Returns the value of the '<em><b>Type Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Parameters</em>' containment reference list.
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendFunction_TypeParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeParameter> getTypeParameters();

	/**
	 * Returns the value of the '<em><b>Exceptions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exceptions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exceptions</em>' containment reference list.
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendFunction_Exceptions()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getExceptions();

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

} // XtendFunction
