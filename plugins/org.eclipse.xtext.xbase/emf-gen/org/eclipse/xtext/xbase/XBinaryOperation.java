/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XBinary Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XBinaryOperation#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XBinaryOperation#getRightOperand <em>Right Operand</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XBinaryOperation#isCompoundOperator <em>Compound Operator</em>}</li>
 * </ul>
 * </p>
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
	 * <p>
	 * If the meaning of the '<em>Left Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * <p>
	 * If the meaning of the '<em>Right Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * Returns the value of the '<em><b>Compound Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compound Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compound Operator</em>' attribute.
	 * @see #setCompoundOperator(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXBinaryOperation_CompoundOperator()
	 * @model
	 * @generated
	 */
	boolean isCompoundOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XBinaryOperation#isCompoundOperator <em>Compound Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compound Operator</em>' attribute.
	 * @see #isCompoundOperator()
	 * @generated
	 */
	void setCompoundOperator(boolean value);

} // XBinaryOperation
