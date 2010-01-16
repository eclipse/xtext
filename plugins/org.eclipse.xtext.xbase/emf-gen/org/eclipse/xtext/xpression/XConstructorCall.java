/**
 * <copyright>
 * </copyright>
 *
 * $Id: XConstructorCall.java,v 1.1 2010/01/16 08:50:53 sefftinge Exp $
 */
package org.eclipse.xtext.xpression;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.xtype.XTypeRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XConstructor Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xpression.XConstructorCall#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.XConstructorCall#getParams <em>Params</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.XConstructorCall#getInitializer <em>Initializer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xpression.XpressionPackage#getXConstructorCall()
 * @model
 * @generated
 */
public interface XConstructorCall extends XExpression {
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
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getXConstructorCall_Type()
	 * @model containment="true"
	 * @generated
	 */
	XTypeRef getType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xpression.XConstructorCall#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(XTypeRef value);

	/**
	 * Returns the value of the '<em><b>Params</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xpression.XExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Params</em>' containment reference list.
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getXConstructorCall_Params()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getParams();

	/**
	 * Returns the value of the '<em><b>Initializer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initializer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initializer</em>' containment reference.
	 * @see #setInitializer(XBlockExpression)
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getXConstructorCall_Initializer()
	 * @model containment="true"
	 * @generated
	 */
	XBlockExpression getInitializer();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xpression.XConstructorCall#getInitializer <em>Initializer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initializer</em>' containment reference.
	 * @see #getInitializer()
	 * @generated
	 */
	void setInitializer(XBlockExpression value);

} // XConstructorCall
