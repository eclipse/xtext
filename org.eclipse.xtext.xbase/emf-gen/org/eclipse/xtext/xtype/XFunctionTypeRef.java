/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtype;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XFunction Type Ref</b></em>'.
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
 *   <li>{@link org.eclipse.xtext.xtype.XFunctionTypeRef#getParamTypes <em>Param Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.XFunctionTypeRef#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.XFunctionTypeRef#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.XFunctionTypeRef#isInstanceContext <em>Instance Context</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xtype.XtypePackage#getXFunctionTypeRef()
 * @model
 * @generated
 */
public interface XFunctionTypeRef extends JvmSpecializedTypeReference
{
	/**
	 * Returns the value of the '<em><b>Param Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param Types</em>' containment reference list.
	 * @see org.eclipse.xtext.xtype.XtypePackage#getXFunctionTypeRef_ParamTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getParamTypes();

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(JvmTypeReference)
	 * @see org.eclipse.xtext.xtype.XtypePackage#getXFunctionTypeRef_ReturnType()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getReturnType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtype.XFunctionTypeRef#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(JvmType)
	 * @see org.eclipse.xtext.xtype.XtypePackage#getXFunctionTypeRef_Type()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	JvmType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtype.XFunctionTypeRef#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JvmType value);

	/**
	 * Returns the value of the '<em><b>Instance Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Context</em>' attribute.
	 * @see #setInstanceContext(boolean)
	 * @see org.eclipse.xtext.xtype.XtypePackage#getXFunctionTypeRef_InstanceContext()
	 * @model
	 * @generated
	 */
	boolean isInstanceContext();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtype.XFunctionTypeRef#isInstanceContext <em>Instance Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Context</em>' attribute.
	 * @see #isInstanceContext()
	 * @generated
	 */
	void setInstanceContext(boolean value);

} // XFunctionTypeRef
