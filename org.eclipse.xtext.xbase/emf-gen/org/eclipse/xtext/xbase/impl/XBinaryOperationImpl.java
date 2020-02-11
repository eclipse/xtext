/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XBinary Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XBinaryOperationImpl#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XBinaryOperationImpl#getRightOperand <em>Right Operand</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XBinaryOperationImpl#isReassignFirstArgument <em>Reassign First Argument</em>}</li>
 * </ul>
 *
 * @since 2.7
 * @generated
 */
public class XBinaryOperationImpl extends XAbstractFeatureCallImplCustom implements XBinaryOperation
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
	 * The default value of the '{@link #isReassignFirstArgument() <em>Reassign First Argument</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReassignFirstArgument()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REASSIGN_FIRST_ARGUMENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReassignFirstArgument() <em>Reassign First Argument</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReassignFirstArgument()
	 * @generated
	 * @ordered
	 */
	protected boolean reassignFirstArgument = REASSIGN_FIRST_ARGUMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XBinaryOperationImpl()
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
		return XbasePackage.Literals.XBINARY_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XBINARY_OPERATION__LEFT_OPERAND, oldLeftOperand, newLeftOperand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLeftOperand(XExpression newLeftOperand)
	{
		if (newLeftOperand != leftOperand)
		{
			NotificationChain msgs = null;
			if (leftOperand != null)
				msgs = ((InternalEObject)leftOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XBINARY_OPERATION__LEFT_OPERAND, null, msgs);
			if (newLeftOperand != null)
				msgs = ((InternalEObject)newLeftOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XBINARY_OPERATION__LEFT_OPERAND, null, msgs);
			msgs = basicSetLeftOperand(newLeftOperand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XBINARY_OPERATION__LEFT_OPERAND, newLeftOperand, newLeftOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XBINARY_OPERATION__RIGHT_OPERAND, oldRightOperand, newRightOperand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRightOperand(XExpression newRightOperand)
	{
		if (newRightOperand != rightOperand)
		{
			NotificationChain msgs = null;
			if (rightOperand != null)
				msgs = ((InternalEObject)rightOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XBINARY_OPERATION__RIGHT_OPERAND, null, msgs);
			if (newRightOperand != null)
				msgs = ((InternalEObject)newRightOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XBINARY_OPERATION__RIGHT_OPERAND, null, msgs);
			msgs = basicSetRightOperand(newRightOperand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XBINARY_OPERATION__RIGHT_OPERAND, newRightOperand, newRightOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isReassignFirstArgument()
	{
		return reassignFirstArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReassignFirstArgument(boolean newReassignFirstArgument)
	{
		boolean oldReassignFirstArgument = reassignFirstArgument;
		reassignFirstArgument = newReassignFirstArgument;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XBINARY_OPERATION__REASSIGN_FIRST_ARGUMENT, oldReassignFirstArgument, reassignFirstArgument));
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
			case XbasePackage.XBINARY_OPERATION__LEFT_OPERAND:
				return basicSetLeftOperand(null, msgs);
			case XbasePackage.XBINARY_OPERATION__RIGHT_OPERAND:
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
			case XbasePackage.XBINARY_OPERATION__LEFT_OPERAND:
				return getLeftOperand();
			case XbasePackage.XBINARY_OPERATION__RIGHT_OPERAND:
				return getRightOperand();
			case XbasePackage.XBINARY_OPERATION__REASSIGN_FIRST_ARGUMENT:
				return isReassignFirstArgument();
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
			case XbasePackage.XBINARY_OPERATION__LEFT_OPERAND:
				setLeftOperand((XExpression)newValue);
				return;
			case XbasePackage.XBINARY_OPERATION__RIGHT_OPERAND:
				setRightOperand((XExpression)newValue);
				return;
			case XbasePackage.XBINARY_OPERATION__REASSIGN_FIRST_ARGUMENT:
				setReassignFirstArgument((Boolean)newValue);
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
			case XbasePackage.XBINARY_OPERATION__LEFT_OPERAND:
				setLeftOperand((XExpression)null);
				return;
			case XbasePackage.XBINARY_OPERATION__RIGHT_OPERAND:
				setRightOperand((XExpression)null);
				return;
			case XbasePackage.XBINARY_OPERATION__REASSIGN_FIRST_ARGUMENT:
				setReassignFirstArgument(REASSIGN_FIRST_ARGUMENT_EDEFAULT);
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
			case XbasePackage.XBINARY_OPERATION__LEFT_OPERAND:
				return leftOperand != null;
			case XbasePackage.XBINARY_OPERATION__RIGHT_OPERAND:
				return rightOperand != null;
			case XbasePackage.XBINARY_OPERATION__REASSIGN_FIRST_ARGUMENT:
				return reassignFirstArgument != REASSIGN_FIRST_ARGUMENT_EDEFAULT;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (reassignFirstArgument: ");
		result.append(reassignFirstArgument);
		result.append(')');
		return result.toString();
	}

} //XBinaryOperationImpl
