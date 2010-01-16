/**
 * <copyright>
 * </copyright>
 *
 * $Id: XFunction.java,v 1.1 2010/01/16 08:50:53 sefftinge Exp $
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xpression.XDeclaredParameter;
import org.eclipse.xtext.xpression.XExpression;

import org.eclipse.xtext.xtype.XTypeParamDeclaration;
import org.eclipse.xtext.xtype.XTypeRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XFunction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XFunction#isPrivate <em>Private</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XFunction#getTypeParams <em>Type Params</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XFunction#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XFunction#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XFunction#getDeclaredParams <em>Declared Params</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XFunction#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXFunction()
 * @model
 * @generated
 */
public interface XFunction extends EObject {
	/**
	 * Returns the value of the '<em><b>Private</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Private</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Private</em>' attribute.
	 * @see #setPrivate(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXFunction_Private()
	 * @model
	 * @generated
	 */
	boolean isPrivate();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XFunction#isPrivate <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Private</em>' attribute.
	 * @see #isPrivate()
	 * @generated
	 */
	void setPrivate(boolean value);

	/**
	 * Returns the value of the '<em><b>Type Params</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xtype.XTypeParamDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Params</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Params</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXFunction_TypeParams()
	 * @model containment="true"
	 * @generated
	 */
	EList<XTypeParamDeclaration> getTypeParams();

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(XTypeRef)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXFunction_ReturnType()
	 * @model containment="true"
	 * @generated
	 */
	XTypeRef getReturnType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XFunction#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(XTypeRef value);

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
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXFunction_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XFunction#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Declared Params</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xpression.XDeclaredParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declared Params</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Params</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXFunction_DeclaredParams()
	 * @model containment="true"
	 * @generated
	 */
	EList<XDeclaredParameter> getDeclaredParams();

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
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXFunction_Expression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XFunction#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(XExpression value);

} // XFunction
