/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.xtend.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtend.core.xtend.RichStringForLoop;
import org.eclipse.xtend.core.xtend.XtendPackage;

import org.eclipse.xtext.xbase.XExpression;

import org.eclipse.xtext.xbase.impl.XForLoopExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rich String For Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.RichStringForLoopImpl#getSeparator <em>Separator</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.RichStringForLoopImpl#getBefore <em>Before</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.RichStringForLoopImpl#getAfter <em>After</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RichStringForLoopImpl extends XForLoopExpressionImpl implements RichStringForLoop
{
	/**
	 * The cached value of the '{@link #getSeparator() <em>Separator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeparator()
	 * @generated
	 * @ordered
	 */
	protected XExpression separator;

	/**
	 * The cached value of the '{@link #getBefore() <em>Before</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBefore()
	 * @generated
	 * @ordered
	 */
	protected XExpression before;

	/**
	 * The cached value of the '{@link #getAfter() <em>After</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAfter()
	 * @generated
	 * @ordered
	 */
	protected XExpression after;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RichStringForLoopImpl()
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
		return XtendPackage.Literals.RICH_STRING_FOR_LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XExpression getSeparator()
	{
		return separator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSeparator(XExpression newSeparator, NotificationChain msgs)
	{
		XExpression oldSeparator = separator;
		separator = newSeparator;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtendPackage.RICH_STRING_FOR_LOOP__SEPARATOR, oldSeparator, newSeparator);
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
	public void setSeparator(XExpression newSeparator)
	{
		if (newSeparator != separator)
		{
			NotificationChain msgs = null;
			if (separator != null)
				msgs = ((InternalEObject)separator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtendPackage.RICH_STRING_FOR_LOOP__SEPARATOR, null, msgs);
			if (newSeparator != null)
				msgs = ((InternalEObject)newSeparator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtendPackage.RICH_STRING_FOR_LOOP__SEPARATOR, null, msgs);
			msgs = basicSetSeparator(newSeparator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.RICH_STRING_FOR_LOOP__SEPARATOR, newSeparator, newSeparator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XExpression getBefore()
	{
		return before;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBefore(XExpression newBefore, NotificationChain msgs)
	{
		XExpression oldBefore = before;
		before = newBefore;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtendPackage.RICH_STRING_FOR_LOOP__BEFORE, oldBefore, newBefore);
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
	public void setBefore(XExpression newBefore)
	{
		if (newBefore != before)
		{
			NotificationChain msgs = null;
			if (before != null)
				msgs = ((InternalEObject)before).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtendPackage.RICH_STRING_FOR_LOOP__BEFORE, null, msgs);
			if (newBefore != null)
				msgs = ((InternalEObject)newBefore).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtendPackage.RICH_STRING_FOR_LOOP__BEFORE, null, msgs);
			msgs = basicSetBefore(newBefore, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.RICH_STRING_FOR_LOOP__BEFORE, newBefore, newBefore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XExpression getAfter()
	{
		return after;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAfter(XExpression newAfter, NotificationChain msgs)
	{
		XExpression oldAfter = after;
		after = newAfter;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtendPackage.RICH_STRING_FOR_LOOP__AFTER, oldAfter, newAfter);
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
	public void setAfter(XExpression newAfter)
	{
		if (newAfter != after)
		{
			NotificationChain msgs = null;
			if (after != null)
				msgs = ((InternalEObject)after).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtendPackage.RICH_STRING_FOR_LOOP__AFTER, null, msgs);
			if (newAfter != null)
				msgs = ((InternalEObject)newAfter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtendPackage.RICH_STRING_FOR_LOOP__AFTER, null, msgs);
			msgs = basicSetAfter(newAfter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.RICH_STRING_FOR_LOOP__AFTER, newAfter, newAfter));
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
			case XtendPackage.RICH_STRING_FOR_LOOP__SEPARATOR:
				return basicSetSeparator(null, msgs);
			case XtendPackage.RICH_STRING_FOR_LOOP__BEFORE:
				return basicSetBefore(null, msgs);
			case XtendPackage.RICH_STRING_FOR_LOOP__AFTER:
				return basicSetAfter(null, msgs);
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
			case XtendPackage.RICH_STRING_FOR_LOOP__SEPARATOR:
				return getSeparator();
			case XtendPackage.RICH_STRING_FOR_LOOP__BEFORE:
				return getBefore();
			case XtendPackage.RICH_STRING_FOR_LOOP__AFTER:
				return getAfter();
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
			case XtendPackage.RICH_STRING_FOR_LOOP__SEPARATOR:
				setSeparator((XExpression)newValue);
				return;
			case XtendPackage.RICH_STRING_FOR_LOOP__BEFORE:
				setBefore((XExpression)newValue);
				return;
			case XtendPackage.RICH_STRING_FOR_LOOP__AFTER:
				setAfter((XExpression)newValue);
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
			case XtendPackage.RICH_STRING_FOR_LOOP__SEPARATOR:
				setSeparator((XExpression)null);
				return;
			case XtendPackage.RICH_STRING_FOR_LOOP__BEFORE:
				setBefore((XExpression)null);
				return;
			case XtendPackage.RICH_STRING_FOR_LOOP__AFTER:
				setAfter((XExpression)null);
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
			case XtendPackage.RICH_STRING_FOR_LOOP__SEPARATOR:
				return separator != null;
			case XtendPackage.RICH_STRING_FOR_LOOP__BEFORE:
				return before != null;
			case XtendPackage.RICH_STRING_FOR_LOOP__AFTER:
				return after != null;
		}
		return super.eIsSet(featureID);
	}

} //RichStringForLoopImpl
