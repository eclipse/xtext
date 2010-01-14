/**
 * <copyright>
 * </copyright>
 *
 * $Id: FunctionTypeRef.java,v 1.1 2010/01/14 14:40:17 sefftinge Exp $
 */
package org.eclipse.xtext.xtype;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Type Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtype.FunctionTypeRef#getParamTypes <em>Param Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.FunctionTypeRef#getReturnType <em>Return Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtype.XtypePackage#getFunctionTypeRef()
 * @model
 * @generated
 */
public interface FunctionTypeRef extends TypeRef {
	/**
	 * Returns the value of the '<em><b>Param Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xtype.TypeRef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param Types</em>' containment reference list.
	 * @see org.eclipse.xtext.xtype.XtypePackage#getFunctionTypeRef_ParamTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeRef> getParamTypes();

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xtype.TypeRef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference list.
	 * @see org.eclipse.xtext.xtype.XtypePackage#getFunctionTypeRef_ReturnType()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeRef> getReturnType();

} // FunctionTypeRef
