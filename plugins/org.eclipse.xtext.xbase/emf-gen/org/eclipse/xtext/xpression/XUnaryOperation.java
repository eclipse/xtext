/**
 * <copyright>
 * </copyright>
 *
 * $Id: XUnaryOperation.java,v 1.1 2010/01/16 08:50:52 sefftinge Exp $
 */
package org.eclipse.xtext.xpression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XUnary Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xpression.XUnaryOperation#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.XUnaryOperation#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xpression.XpressionPackage#getXUnaryOperation()
 * @model
 * @generated
 */
public interface XUnaryOperation extends XExpression {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see #setOperator(String)
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getXUnaryOperation_Operator()
	 * @model required="true"
	 * @generated
	 */
	String getOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xpression.XUnaryOperation#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(String value);

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
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getXUnaryOperation_Target()
	 * @model containment="true" required="true"
	 * @generated
	 */
	XExpression getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xpression.XUnaryOperation#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(XExpression value);

} // XUnaryOperation
