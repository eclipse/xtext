/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.annotations.xAnnotations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.XExpression;

import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;

import org.eclipse.xtext.xbase.impl.XExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XAnnotation Element Value Binary Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationElementValueBinaryOperationImpl#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationElementValueBinaryOperationImpl#getRightOperand <em>Right Operand</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationElementValueBinaryOperationImpl#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XAnnotationElementValueBinaryOperationImpl extends XExpressionImpl implements XAnnotationElementValueBinaryOperation
{
	/**
	 * The cached value of the '{@link #getLeftOperand() <em>Left Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftOperand()
	 * @generated
	 * @ordered
	 */
	protected XExpression leftOperand;

	/**
	 * The cached value of the '{@link #getRightOperand() <em>Right Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightOperand()
	 * @generated
	 * @ordered
	 */
	protected XExpression rightOperand;

	/**
	 * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATOR_EDEFAULT = "+";

	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected String operator = OPERATOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XAnnotationElementValueBinaryOperationImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getLeftOperand()
	{
		return leftOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftOperand(XExpression newLeftOperand, NotificationChain msgs)
	{
		XExpression oldLeftOperand = leftOperand;
		leftOperand = newLeftOperand;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__LEFT_OPERAND, oldLeftOperand, newLeftOperand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftOperand(XExpression newLeftOperand)
	{
		if (newLeftOperand != leftOperand)
		{
			NotificationChain msgs = null;
			if (leftOperand != null)
				msgs = ((InternalEObject)leftOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__LEFT_OPERAND, null, msgs);
			if (newLeftOperand != null)
				msgs = ((InternalEObject)newLeftOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__LEFT_OPERAND, null, msgs);
			msgs = basicSetLeftOperand(newLeftOperand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__LEFT_OPERAND, newLeftOperand, newLeftOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getRightOperand()
	{
		return rightOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightOperand(XExpression newRightOperand, NotificationChain msgs)
	{
		XExpression oldRightOperand = rightOperand;
		rightOperand = newRightOperand;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__RIGHT_OPERAND, oldRightOperand, newRightOperand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightOperand(XExpression newRightOperand)
	{
		if (newRightOperand != rightOperand)
		{
			NotificationChain msgs = null;
			if (rightOperand != null)
				msgs = ((InternalEObject)rightOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__RIGHT_OPERAND, null, msgs);
			if (newRightOperand != null)
				msgs = ((InternalEObject)newRightOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__RIGHT_OPERAND, null, msgs);
			msgs = basicSetRightOperand(newRightOperand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__RIGHT_OPERAND, newRightOperand, newRightOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperator()
	{
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(String newOperator)
	{
		String oldOperator = operator;
		operator = newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__OPERATOR, oldOperator, operator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__LEFT_OPERAND:
				return basicSetLeftOperand(null, msgs);
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__RIGHT_OPERAND:
				return basicSetRightOperand(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__LEFT_OPERAND:
				return getLeftOperand();
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__RIGHT_OPERAND:
				return getRightOperand();
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__OPERATOR:
				return getOperator();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__LEFT_OPERAND:
				setLeftOperand((XExpression)newValue);
				return;
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__RIGHT_OPERAND:
				setRightOperand((XExpression)newValue);
				return;
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__OPERATOR:
				setOperator((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__LEFT_OPERAND:
				setLeftOperand((XExpression)null);
				return;
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__RIGHT_OPERAND:
				setRightOperand((XExpression)null);
				return;
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__LEFT_OPERAND:
				return leftOperand != null;
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__RIGHT_OPERAND:
				return rightOperand != null;
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__OPERATOR:
				return OPERATOR_EDEFAULT == null ? operator != null : !OPERATOR_EDEFAULT.equals(operator);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (operator: ");
		result.append(operator);
		result.append(')');
		return result.toString();
	}

} //XAnnotationElementValueBinaryOperationImpl
