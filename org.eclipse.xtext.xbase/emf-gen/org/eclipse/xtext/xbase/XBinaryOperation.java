/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XBinary Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * @since 2.7
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XBinaryOperation#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XBinaryOperation#getRightOperand <em>Right Operand</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XBinaryOperation#isReassignFirstArgument <em>Reassign First Argument</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXBinaryOperation()
 * @model
 * @generated
 */
public interface XBinaryOperation extends XAbstractFeatureCall
{
	/**
	 * Returns the value of the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Operand</em>' containment reference.
	 * @see #setLeftOperand(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXBinaryOperation_LeftOperand()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getLeftOperand();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XBinaryOperation#getLeftOperand <em>Left Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Operand</em>' containment reference.
	 * @see #getLeftOperand()
	 * @generated
	 */
	void setLeftOperand(XExpression value);

	/**
	 * Returns the value of the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Operand</em>' containment reference.
	 * @see #setRightOperand(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXBinaryOperation_RightOperand()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getRightOperand();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XBinaryOperation#getRightOperand <em>Right Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Operand</em>' containment reference.
	 * @see #getRightOperand()
	 * @generated
	 */
	void setRightOperand(XExpression value);

	/**
	 * Returns the value of the '<em><b>Reassign First Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reassign First Argument</em>' attribute.
	 * @see #setReassignFirstArgument(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXBinaryOperation_ReassignFirstArgument()
	 * @model
	 * @generated
	 */
	boolean isReassignFirstArgument();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XBinaryOperation#isReassignFirstArgument <em>Reassign First Argument</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reassign First Argument</em>' attribute.
	 * @see #isReassignFirstArgument()
	 * @generated
	 */
	void setReassignFirstArgument(boolean value);

} // XBinaryOperation
