/**
 * <copyright>
 * </copyright>
 *
 * $Id: XWhileExpression.java,v 1.1 2010/01/16 08:50:52 sefftinge Exp $
 */
package org.eclipse.xtext.xpression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XWhile Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xpression.XWhileExpression#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.XWhileExpression#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xpression.XpressionPackage#getXWhileExpression()
 * @model
 * @generated
 */
public interface XWhileExpression extends XExpression {
	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' containment reference.
	 * @see #setPredicate(XExpression)
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getXWhileExpression_Predicate()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getPredicate();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xpression.XWhileExpression#getPredicate <em>Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' containment reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(XExpression value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(XExpression)
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getXWhileExpression_Body()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xpression.XWhileExpression#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(XExpression value);

} // XWhileExpression
