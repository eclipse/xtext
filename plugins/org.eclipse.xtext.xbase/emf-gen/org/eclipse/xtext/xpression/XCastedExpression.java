/**
 * <copyright>
 * </copyright>
 *
 * $Id: XCastedExpression.java,v 1.1 2010/01/16 08:50:53 sefftinge Exp $
 */
package org.eclipse.xtext.xpression;

import org.eclipse.xtext.xtype.XTypeRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XCasted Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xpression.XCastedExpression#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.XCastedExpression#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xpression.XpressionPackage#getXCastedExpression()
 * @model
 * @generated
 */
public interface XCastedExpression extends XExpression {
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
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getXCastedExpression_Type()
	 * @model containment="true"
	 * @generated
	 */
	XTypeRef getType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xpression.XCastedExpression#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(XTypeRef value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(XExpression)
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getXCastedExpression_Target()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xpression.XCastedExpression#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(XExpression value);

} // XCastedExpression
