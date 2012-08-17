/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.annotations.xAnnotations;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAnnotation Element Value Binary Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation#getRightOperand <em>Right Operand</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage#getXAnnotationElementValueBinaryOperation()
 * @model
 * @generated
 */
public interface XAnnotationElementValueBinaryOperation extends XExpression
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
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage#getXAnnotationElementValueBinaryOperation_LeftOperand()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getLeftOperand();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation#getLeftOperand <em>Left Operand</em>}' containment reference.
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
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage#getXAnnotationElementValueBinaryOperation_RightOperand()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getRightOperand();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation#getRightOperand <em>Right Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Operand</em>' containment reference.
	 * @see #getRightOperand()
	 * @generated
	 */
	void setRightOperand(XExpression value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The default value is <code>"+"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see #setOperator(String)
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage#getXAnnotationElementValueBinaryOperation_Operator()
	 * @model default="+"
	 * @generated
	 */
	String getOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(String value);

} // XAnnotationElementValueBinaryOperation
