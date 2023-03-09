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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XCase Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XCasePartImpl#getCase <em>Case</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XCasePartImpl#getThen <em>Then</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XCasePartImpl#getTypeGuard <em>Type Guard</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XCasePartImpl#isFallThrough <em>Fall Through</em>}</li>
 * </ul>
 *
 * @since 2.7
 * @generated
 */
public class XCasePartImpl extends MinimalEObjectImpl.Container implements XCasePart
{
	/**
	 * The cached value of the '{@link #getCase() <em>Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCase()
	 * @generated
	 * @ordered
	 */
	protected XExpression case_;

	/**
	 * The cached value of the '{@link #getThen() <em>Then</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThen()
	 * @generated
	 * @ordered
	 */
	protected XExpression then;

	/**
	 * The cached value of the '{@link #getTypeGuard() <em>Type Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeGuard()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference typeGuard;

	/**
	 * The default value of the '{@link #isFallThrough() <em>Fall Through</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFallThrough()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FALL_THROUGH_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFallThrough() <em>Fall Through</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFallThrough()
	 * @generated
	 * @ordered
	 */
	protected boolean fallThrough = FALL_THROUGH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XCasePartImpl()
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
		return XbasePackage.Literals.XCASE_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XExpression getCase()
	{
		return case_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCase(XExpression newCase, NotificationChain msgs)
	{
		XExpression oldCase = case_;
		case_ = newCase;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XCASE_PART__CASE, oldCase, newCase);
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
	public void setCase(XExpression newCase)
	{
		if (newCase != case_)
		{
			NotificationChain msgs = null;
			if (case_ != null)
				msgs = ((InternalEObject)case_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCASE_PART__CASE, null, msgs);
			if (newCase != null)
				msgs = ((InternalEObject)newCase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCASE_PART__CASE, null, msgs);
			msgs = basicSetCase(newCase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCASE_PART__CASE, newCase, newCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XExpression getThen()
	{
		return then;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThen(XExpression newThen, NotificationChain msgs)
	{
		XExpression oldThen = then;
		then = newThen;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XCASE_PART__THEN, oldThen, newThen);
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
	public void setThen(XExpression newThen)
	{
		if (newThen != then)
		{
			NotificationChain msgs = null;
			if (then != null)
				msgs = ((InternalEObject)then).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCASE_PART__THEN, null, msgs);
			if (newThen != null)
				msgs = ((InternalEObject)newThen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCASE_PART__THEN, null, msgs);
			msgs = basicSetThen(newThen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCASE_PART__THEN, newThen, newThen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JvmTypeReference getTypeGuard()
	{
		return typeGuard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeGuard(JvmTypeReference newTypeGuard, NotificationChain msgs)
	{
		JvmTypeReference oldTypeGuard = typeGuard;
		typeGuard = newTypeGuard;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XCASE_PART__TYPE_GUARD, oldTypeGuard, newTypeGuard);
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
	public void setTypeGuard(JvmTypeReference newTypeGuard)
	{
		if (newTypeGuard != typeGuard)
		{
			NotificationChain msgs = null;
			if (typeGuard != null)
				msgs = ((InternalEObject)typeGuard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCASE_PART__TYPE_GUARD, null, msgs);
			if (newTypeGuard != null)
				msgs = ((InternalEObject)newTypeGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCASE_PART__TYPE_GUARD, null, msgs);
			msgs = basicSetTypeGuard(newTypeGuard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCASE_PART__TYPE_GUARD, newTypeGuard, newTypeGuard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFallThrough()
	{
		return fallThrough;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFallThrough(boolean newFallThrough)
	{
		boolean oldFallThrough = fallThrough;
		fallThrough = newFallThrough;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCASE_PART__FALL_THROUGH, oldFallThrough, fallThrough));
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
			case XbasePackage.XCASE_PART__CASE:
				return basicSetCase(null, msgs);
			case XbasePackage.XCASE_PART__THEN:
				return basicSetThen(null, msgs);
			case XbasePackage.XCASE_PART__TYPE_GUARD:
				return basicSetTypeGuard(null, msgs);
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
			case XbasePackage.XCASE_PART__CASE:
				return getCase();
			case XbasePackage.XCASE_PART__THEN:
				return getThen();
			case XbasePackage.XCASE_PART__TYPE_GUARD:
				return getTypeGuard();
			case XbasePackage.XCASE_PART__FALL_THROUGH:
				return isFallThrough();
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
			case XbasePackage.XCASE_PART__CASE:
				setCase((XExpression)newValue);
				return;
			case XbasePackage.XCASE_PART__THEN:
				setThen((XExpression)newValue);
				return;
			case XbasePackage.XCASE_PART__TYPE_GUARD:
				setTypeGuard((JvmTypeReference)newValue);
				return;
			case XbasePackage.XCASE_PART__FALL_THROUGH:
				setFallThrough((Boolean)newValue);
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
			case XbasePackage.XCASE_PART__CASE:
				setCase((XExpression)null);
				return;
			case XbasePackage.XCASE_PART__THEN:
				setThen((XExpression)null);
				return;
			case XbasePackage.XCASE_PART__TYPE_GUARD:
				setTypeGuard((JvmTypeReference)null);
				return;
			case XbasePackage.XCASE_PART__FALL_THROUGH:
				setFallThrough(FALL_THROUGH_EDEFAULT);
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
			case XbasePackage.XCASE_PART__CASE:
				return case_ != null;
			case XbasePackage.XCASE_PART__THEN:
				return then != null;
			case XbasePackage.XCASE_PART__TYPE_GUARD:
				return typeGuard != null;
			case XbasePackage.XCASE_PART__FALL_THROUGH:
				return fallThrough != FALL_THROUGH_EDEFAULT;
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
		result.append(" (fallThrough: ");
		result.append(fallThrough);
		result.append(')');
		return result.toString();
	}

} //XCasePartImpl
