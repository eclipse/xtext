/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtype;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeArgument;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XFunction Type Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtype.XFunctionTypeRef#getParamTypes <em>Param Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.XFunctionTypeRef#getReturnType <em>Return Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtype.XtypePackage#getXFunctionTypeRef()
 * @model
 * @generated
 */
public interface XFunctionTypeRef extends JvmParameterizedTypeReference
{
	/**
	 * Returns the value of the '<em><b>Param Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeArgument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param Types</em>' containment reference list.
	 * @see org.eclipse.xtext.xtype.XtypePackage#getXFunctionTypeRef_ParamTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeArgument> getParamTypes();

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(JvmTypeArgument)
	 * @see org.eclipse.xtext.xtype.XtypePackage#getXFunctionTypeRef_ReturnType()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeArgument getReturnType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtype.XFunctionTypeRef#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(JvmTypeArgument value);

} // XFunctionTypeRef
