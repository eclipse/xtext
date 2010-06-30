/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtype;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;

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
   * Returns the value of the '<em><b>Param Types</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param Types</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param Types</em>' reference list.
   * @see org.eclipse.xtext.xtype.XtypePackage#getXFunctionTypeRef_ParamTypes()
   * @model changeable="false" derived="true"
   * @generated
   */
  EList<JvmTypeReference> getParamTypes();

  /**
   * Returns the value of the '<em><b>Return Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Return Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return Type</em>' reference.
   * @see org.eclipse.xtext.xtype.XtypePackage#getXFunctionTypeRef_ReturnType()
   * @model changeable="false" derived="true"
   * @generated
   */
  JvmTypeReference getReturnType();

} // XFunctionTypeRef
