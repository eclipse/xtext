/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.xtend.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtend.core.xtend.RichStringElseIf;
import org.eclipse.xtend.core.xtend.RichStringIf;
import org.eclipse.xtend.core.xtend.XtendPackage;

import org.eclipse.xtext.xbase.XExpression;

import org.eclipse.xtext.xbase.impl.XExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rich String If</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.RichStringIfImpl#getIf <em>If</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.RichStringIfImpl#getThen <em>Then</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.RichStringIfImpl#getElseIfs <em>Else Ifs</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.RichStringIfImpl#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RichStringIfImpl extends XExpressionImpl implements RichStringIf
{
	/**
	 * The cached value of the '{@link #getIf() <em>If</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIf()
	 * @generated
	 * @ordered
	 */
	protected XExpression if_;

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
	 * The cached value of the '{@link #getElseIfs() <em>Else Ifs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseIfs()
	 * @generated
	 * @ordered
	 */
	protected EList<RichStringElseIf> elseIfs;

	/**
	 * The cached value of the '{@link #getElse() <em>Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElse()
	 * @generated
	 * @ordered
	 */
	protected XExpression else_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RichStringIfImpl()
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
		return XtendPackage.Literals.RICH_STRING_IF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XExpression getIf()
	{
		return if_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIf(XExpression newIf, NotificationChain msgs)
	{
		XExpression oldIf = if_;
		if_ = newIf;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtendPackage.RICH_STRING_IF__IF, oldIf, newIf);
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
	public void setIf(XExpression newIf)
	{
		if (newIf != if_)
		{
			NotificationChain msgs = null;
			if (if_ != null)
				msgs = ((InternalEObject)if_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtendPackage.RICH_STRING_IF__IF, null, msgs);
			if (newIf != null)
				msgs = ((InternalEObject)newIf).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtendPackage.RICH_STRING_IF__IF, null, msgs);
			msgs = basicSetIf(newIf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.RICH_STRING_IF__IF, newIf, newIf));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtendPackage.RICH_STRING_IF__THEN, oldThen, newThen);
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
				msgs = ((InternalEObject)then).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtendPackage.RICH_STRING_IF__THEN, null, msgs);
			if (newThen != null)
				msgs = ((InternalEObject)newThen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtendPackage.RICH_STRING_IF__THEN, null, msgs);
			msgs = basicSetThen(newThen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.RICH_STRING_IF__THEN, newThen, newThen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RichStringElseIf> getElseIfs()
	{
		if (elseIfs == null)
		{
			elseIfs = new EObjectContainmentEList<RichStringElseIf>(RichStringElseIf.class, this, XtendPackage.RICH_STRING_IF__ELSE_IFS);
		}
		return elseIfs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XExpression getElse()
	{
		return else_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElse(XExpression newElse, NotificationChain msgs)
	{
		XExpression oldElse = else_;
		else_ = newElse;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtendPackage.RICH_STRING_IF__ELSE, oldElse, newElse);
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
	public void setElse(XExpression newElse)
	{
		if (newElse != else_)
		{
			NotificationChain msgs = null;
			if (else_ != null)
				msgs = ((InternalEObject)else_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtendPackage.RICH_STRING_IF__ELSE, null, msgs);
			if (newElse != null)
				msgs = ((InternalEObject)newElse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtendPackage.RICH_STRING_IF__ELSE, null, msgs);
			msgs = basicSetElse(newElse, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.RICH_STRING_IF__ELSE, newElse, newElse));
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
			case XtendPackage.RICH_STRING_IF__IF:
				return basicSetIf(null, msgs);
			case XtendPackage.RICH_STRING_IF__THEN:
				return basicSetThen(null, msgs);
			case XtendPackage.RICH_STRING_IF__ELSE_IFS:
				return ((InternalEList<?>)getElseIfs()).basicRemove(otherEnd, msgs);
			case XtendPackage.RICH_STRING_IF__ELSE:
				return basicSetElse(null, msgs);
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
			case XtendPackage.RICH_STRING_IF__IF:
				return getIf();
			case XtendPackage.RICH_STRING_IF__THEN:
				return getThen();
			case XtendPackage.RICH_STRING_IF__ELSE_IFS:
				return getElseIfs();
			case XtendPackage.RICH_STRING_IF__ELSE:
				return getElse();
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
			case XtendPackage.RICH_STRING_IF__IF:
				setIf((XExpression)newValue);
				return;
			case XtendPackage.RICH_STRING_IF__THEN:
				setThen((XExpression)newValue);
				return;
			case XtendPackage.RICH_STRING_IF__ELSE_IFS:
				getElseIfs().clear();
				getElseIfs().addAll((Collection<? extends RichStringElseIf>)newValue);
				return;
			case XtendPackage.RICH_STRING_IF__ELSE:
				setElse((XExpression)newValue);
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
			case XtendPackage.RICH_STRING_IF__IF:
				setIf((XExpression)null);
				return;
			case XtendPackage.RICH_STRING_IF__THEN:
				setThen((XExpression)null);
				return;
			case XtendPackage.RICH_STRING_IF__ELSE_IFS:
				getElseIfs().clear();
				return;
			case XtendPackage.RICH_STRING_IF__ELSE:
				setElse((XExpression)null);
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
			case XtendPackage.RICH_STRING_IF__IF:
				return if_ != null;
			case XtendPackage.RICH_STRING_IF__THEN:
				return then != null;
			case XtendPackage.RICH_STRING_IF__ELSE_IFS:
				return elseIfs != null && !elseIfs.isEmpty();
			case XtendPackage.RICH_STRING_IF__ELSE:
				return else_ != null;
		}
		return super.eIsSet(featureID);
	}

} //RichStringIfImpl
