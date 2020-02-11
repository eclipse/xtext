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

import org.eclipse.xtext.common.types.JvmFormalParameter;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XFor Loop Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XForLoopExpressionImpl#getForExpression <em>For Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XForLoopExpressionImpl#getEachExpression <em>Each Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XForLoopExpressionImpl#getDeclaredParam <em>Declared Param</em>}</li>
 * </ul>
 *
 * @since 2.7
 * @generated
 */
public class XForLoopExpressionImpl extends XExpressionImpl implements XForLoopExpression
{
	/**
	 * The cached value of the '{@link #getForExpression() <em>For Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression forExpression;

	/**
	 * The cached value of the '{@link #getEachExpression() <em>Each Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEachExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression eachExpression;

	/**
	 * The cached value of the '{@link #getDeclaredParam() <em>Declared Param</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredParam()
	 * @generated
	 * @ordered
	 */
	protected JvmFormalParameter declaredParam;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XForLoopExpressionImpl()
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
		return XbasePackage.Literals.XFOR_LOOP_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XExpression getForExpression()
	{
		return forExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetForExpression(XExpression newForExpression, NotificationChain msgs)
	{
		XExpression oldForExpression = forExpression;
		forExpression = newForExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION, oldForExpression, newForExpression);
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
	public void setForExpression(XExpression newForExpression)
	{
		if (newForExpression != forExpression)
		{
			NotificationChain msgs = null;
			if (forExpression != null)
				msgs = ((InternalEObject)forExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION, null, msgs);
			if (newForExpression != null)
				msgs = ((InternalEObject)newForExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION, null, msgs);
			msgs = basicSetForExpression(newForExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION, newForExpression, newForExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XExpression getEachExpression()
	{
		return eachExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEachExpression(XExpression newEachExpression, NotificationChain msgs)
	{
		XExpression oldEachExpression = eachExpression;
		eachExpression = newEachExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION, oldEachExpression, newEachExpression);
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
	public void setEachExpression(XExpression newEachExpression)
	{
		if (newEachExpression != eachExpression)
		{
			NotificationChain msgs = null;
			if (eachExpression != null)
				msgs = ((InternalEObject)eachExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION, null, msgs);
			if (newEachExpression != null)
				msgs = ((InternalEObject)newEachExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION, null, msgs);
			msgs = basicSetEachExpression(newEachExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION, newEachExpression, newEachExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JvmFormalParameter getDeclaredParam()
	{
		return declaredParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaredParam(JvmFormalParameter newDeclaredParam, NotificationChain msgs)
	{
		JvmFormalParameter oldDeclaredParam = declaredParam;
		declaredParam = newDeclaredParam;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_EXPRESSION__DECLARED_PARAM, oldDeclaredParam, newDeclaredParam);
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
	public void setDeclaredParam(JvmFormalParameter newDeclaredParam)
	{
		if (newDeclaredParam != declaredParam)
		{
			NotificationChain msgs = null;
			if (declaredParam != null)
				msgs = ((InternalEObject)declaredParam).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_EXPRESSION__DECLARED_PARAM, null, msgs);
			if (newDeclaredParam != null)
				msgs = ((InternalEObject)newDeclaredParam).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_EXPRESSION__DECLARED_PARAM, null, msgs);
			msgs = basicSetDeclaredParam(newDeclaredParam, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_EXPRESSION__DECLARED_PARAM, newDeclaredParam, newDeclaredParam));
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
			case XbasePackage.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION:
				return basicSetForExpression(null, msgs);
			case XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION:
				return basicSetEachExpression(null, msgs);
			case XbasePackage.XFOR_LOOP_EXPRESSION__DECLARED_PARAM:
				return basicSetDeclaredParam(null, msgs);
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
			case XbasePackage.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION:
				return getForExpression();
			case XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION:
				return getEachExpression();
			case XbasePackage.XFOR_LOOP_EXPRESSION__DECLARED_PARAM:
				return getDeclaredParam();
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
			case XbasePackage.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION:
				setForExpression((XExpression)newValue);
				return;
			case XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION:
				setEachExpression((XExpression)newValue);
				return;
			case XbasePackage.XFOR_LOOP_EXPRESSION__DECLARED_PARAM:
				setDeclaredParam((JvmFormalParameter)newValue);
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
			case XbasePackage.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION:
				setForExpression((XExpression)null);
				return;
			case XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION:
				setEachExpression((XExpression)null);
				return;
			case XbasePackage.XFOR_LOOP_EXPRESSION__DECLARED_PARAM:
				setDeclaredParam((JvmFormalParameter)null);
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
			case XbasePackage.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION:
				return forExpression != null;
			case XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION:
				return eachExpression != null;
			case XbasePackage.XFOR_LOOP_EXPRESSION__DECLARED_PARAM:
				return declaredParam != null;
		}
		return super.eIsSet(featureID);
	}

} //XForLoopExpressionImpl
