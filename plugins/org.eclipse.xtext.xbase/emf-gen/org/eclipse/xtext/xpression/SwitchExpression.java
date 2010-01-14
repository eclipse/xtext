/**
 * <copyright>
 * </copyright>
 *
 * $Id: SwitchExpression.java,v 1.1 2010/01/14 14:40:20 sefftinge Exp $
 */
package org.eclipse.xtext.xpression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xpression.SwitchExpression#getSwitch <em>Switch</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.SwitchExpression#getCases <em>Cases</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.SwitchExpression#getDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xpression.XpressionPackage#getSwitchExpression()
 * @model
 * @generated
 */
public interface SwitchExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Switch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Switch</em>' containment reference.
	 * @see #setSwitch(Expression)
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getSwitchExpression_Switch()
	 * @model containment="true"
	 * @generated
	 */
	Expression getSwitch();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xpression.SwitchExpression#getSwitch <em>Switch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Switch</em>' containment reference.
	 * @see #getSwitch()
	 * @generated
	 */
	void setSwitch(Expression value);

	/**
	 * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xpression.CasePart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cases</em>' containment reference list.
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getSwitchExpression_Cases()
	 * @model containment="true"
	 * @generated
	 */
	EList<CasePart> getCases();

	/**
	 * Returns the value of the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' containment reference.
	 * @see #setDefault(Expression)
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getSwitchExpression_Default()
	 * @model containment="true"
	 * @generated
	 */
	Expression getDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xpression.SwitchExpression#getDefault <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' containment reference.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(Expression value);

} // SwitchExpression
