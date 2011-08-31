/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xbase;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XWith Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XWithExpression#getMainExpression <em>Main Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XWithExpression#getBlockExpression <em>Block Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XWithExpression#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXWithExpression()
 * @model
 * @generated
 */
public interface XWithExpression extends XExpression, JvmIdentifiableElement
{
	/**
	 * Returns the value of the '<em><b>Main Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Expression</em>' containment reference.
	 * @see #setMainExpression(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXWithExpression_MainExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getMainExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XWithExpression#getMainExpression <em>Main Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Expression</em>' containment reference.
	 * @see #getMainExpression()
	 * @generated
	 */
	void setMainExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Block Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block Expression</em>' containment reference.
	 * @see #setBlockExpression(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXWithExpression_BlockExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getBlockExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XWithExpression#getBlockExpression <em>Block Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block Expression</em>' containment reference.
	 * @see #getBlockExpression()
	 * @generated
	 */
	void setBlockExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference.
	 * @see #setVariable(JvmFormalParameter)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXWithExpression_Variable()
	 * @model containment="true"
	 * @generated
	 */
	JvmFormalParameter getVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XWithExpression#getVariable <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' containment reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(JvmFormalParameter value);

} // XWithExpression
