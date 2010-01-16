/**
 * <copyright>
 * </copyright>
 *
 * $Id: XDeclaredParameter.java,v 1.1 2010/01/16 08:50:52 sefftinge Exp $
 */
package org.eclipse.xtext.xpression;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xtype.XTypeRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XDeclared Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xpression.XDeclaredParameter#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.XDeclaredParameter#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xpression.XpressionPackage#getXDeclaredParameter()
 * @model
 * @generated
 */
public interface XDeclaredParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(XTypeRef)
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getXDeclaredParameter_Type()
	 * @model containment="true"
	 * @generated
	 */
	XTypeRef getType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xpression.XDeclaredParameter#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(XTypeRef value);

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
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getXDeclaredParameter_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xpression.XDeclaredParameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // XDeclaredParameter
