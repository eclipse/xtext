/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmFormalParameter;

import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XSwitch Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XSwitchExpressionImpl#getSwitch <em>Switch</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XSwitchExpressionImpl#getCases <em>Cases</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XSwitchExpressionImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XSwitchExpressionImpl#getDeclaredParam <em>Declared Param</em>}</li>
 * </ul>
 *
 * @since 2.7
 * @generated
 */
public class XSwitchExpressionImpl extends XExpressionImpl implements XSwitchExpression
{
	/**
	 * The cached value of the '{@link #getSwitch() <em>Switch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitch()
	 * @generated
	 * @ordered
	 */
	protected XExpression switch_;

	/**
	 * The cached value of the '{@link #getCases() <em>Cases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCases()
	 * @generated
	 * @ordered
	 */
	protected EList<XCasePart> cases;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected XExpression default_;

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
	protected XSwitchExpressionImpl()
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
		return XbasePackage.Literals.XSWITCH_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XExpression getSwitch()
	{
		return switch_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSwitch(XExpression newSwitch, NotificationChain msgs)
	{
		XExpression oldSwitch = switch_;
		switch_ = newSwitch;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XSWITCH_EXPRESSION__SWITCH, oldSwitch, newSwitch);
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
	public void setSwitch(XExpression newSwitch)
	{
		if (newSwitch != switch_)
		{
			NotificationChain msgs = null;
			if (switch_ != null)
				msgs = ((InternalEObject)switch_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XSWITCH_EXPRESSION__SWITCH, null, msgs);
			if (newSwitch != null)
				msgs = ((InternalEObject)newSwitch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XSWITCH_EXPRESSION__SWITCH, null, msgs);
			msgs = basicSetSwitch(newSwitch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XSWITCH_EXPRESSION__SWITCH, newSwitch, newSwitch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<XCasePart> getCases()
	{
		if (cases == null)
		{
			cases = new EObjectContainmentEList<XCasePart>(XCasePart.class, this, XbasePackage.XSWITCH_EXPRESSION__CASES);
		}
		return cases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XExpression getDefault()
	{
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefault(XExpression newDefault, NotificationChain msgs)
	{
		XExpression oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XSWITCH_EXPRESSION__DEFAULT, oldDefault, newDefault);
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
	public void setDefault(XExpression newDefault)
	{
		if (newDefault != default_)
		{
			NotificationChain msgs = null;
			if (default_ != null)
				msgs = ((InternalEObject)default_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XSWITCH_EXPRESSION__DEFAULT, null, msgs);
			if (newDefault != null)
				msgs = ((InternalEObject)newDefault).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XSWITCH_EXPRESSION__DEFAULT, null, msgs);
			msgs = basicSetDefault(newDefault, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XSWITCH_EXPRESSION__DEFAULT, newDefault, newDefault));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XSWITCH_EXPRESSION__DECLARED_PARAM, oldDeclaredParam, newDeclaredParam);
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
				msgs = ((InternalEObject)declaredParam).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XSWITCH_EXPRESSION__DECLARED_PARAM, null, msgs);
			if (newDeclaredParam != null)
				msgs = ((InternalEObject)newDeclaredParam).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XSWITCH_EXPRESSION__DECLARED_PARAM, null, msgs);
			msgs = basicSetDeclaredParam(newDeclaredParam, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XSWITCH_EXPRESSION__DECLARED_PARAM, newDeclaredParam, newDeclaredParam));
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
			case XbasePackage.XSWITCH_EXPRESSION__SWITCH:
				return basicSetSwitch(null, msgs);
			case XbasePackage.XSWITCH_EXPRESSION__CASES:
				return ((InternalEList<?>)getCases()).basicRemove(otherEnd, msgs);
			case XbasePackage.XSWITCH_EXPRESSION__DEFAULT:
				return basicSetDefault(null, msgs);
			case XbasePackage.XSWITCH_EXPRESSION__DECLARED_PARAM:
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
			case XbasePackage.XSWITCH_EXPRESSION__SWITCH:
				return getSwitch();
			case XbasePackage.XSWITCH_EXPRESSION__CASES:
				return getCases();
			case XbasePackage.XSWITCH_EXPRESSION__DEFAULT:
				return getDefault();
			case XbasePackage.XSWITCH_EXPRESSION__DECLARED_PARAM:
				return getDeclaredParam();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case XbasePackage.XSWITCH_EXPRESSION__SWITCH:
				setSwitch((XExpression)newValue);
				return;
			case XbasePackage.XSWITCH_EXPRESSION__CASES:
				getCases().clear();
				getCases().addAll((Collection<? extends XCasePart>)newValue);
				return;
			case XbasePackage.XSWITCH_EXPRESSION__DEFAULT:
				setDefault((XExpression)newValue);
				return;
			case XbasePackage.XSWITCH_EXPRESSION__DECLARED_PARAM:
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
			case XbasePackage.XSWITCH_EXPRESSION__SWITCH:
				setSwitch((XExpression)null);
				return;
			case XbasePackage.XSWITCH_EXPRESSION__CASES:
				getCases().clear();
				return;
			case XbasePackage.XSWITCH_EXPRESSION__DEFAULT:
				setDefault((XExpression)null);
				return;
			case XbasePackage.XSWITCH_EXPRESSION__DECLARED_PARAM:
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
			case XbasePackage.XSWITCH_EXPRESSION__SWITCH:
				return switch_ != null;
			case XbasePackage.XSWITCH_EXPRESSION__CASES:
				return cases != null && !cases.isEmpty();
			case XbasePackage.XSWITCH_EXPRESSION__DEFAULT:
				return default_ != null;
			case XbasePackage.XSWITCH_EXPRESSION__DECLARED_PARAM:
				return declaredParam != null;
		}
		return super.eIsSet(featureID);
	}

} //XSwitchExpressionImpl
