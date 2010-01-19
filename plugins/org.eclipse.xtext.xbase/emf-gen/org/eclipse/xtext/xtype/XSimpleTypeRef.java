/**
 * <copyright>
 * </copyright>
 *
 * $Id: XSimpleTypeRef.java,v 1.2 2010/01/19 19:53:12 sefftinge Exp $
 */
package org.eclipse.xtext.xtype;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XSimple Type Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtype.XSimpleTypeRef#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.XSimpleTypeRef#getTypeParams <em>Type Params</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtype.XtypePackage#getXSimpleTypeRef()
 * @model
 * @generated
 */
public interface XSimpleTypeRef extends XTypeRef
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(Type)
   * @see org.eclipse.xtext.xtype.XtypePackage#getXSimpleTypeRef_Type()
   * @model
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtype.XSimpleTypeRef#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

  /**
   * Returns the value of the '<em><b>Type Params</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xtype.XTypeRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Params</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Params</em>' containment reference list.
   * @see org.eclipse.xtext.xtype.XtypePackage#getXSimpleTypeRef_TypeParams()
   * @model containment="true"
   * @generated
   */
  EList<XTypeRef> getTypeParams();

} // XSimpleTypeRef
