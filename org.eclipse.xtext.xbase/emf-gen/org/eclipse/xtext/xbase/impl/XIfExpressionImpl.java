/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XIf Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XIfExpressionImpl#getIf <em>If</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XIfExpressionImpl#getThen <em>Then</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XIfExpressionImpl#getElse <em>Else</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XIfExpressionImpl#isConditionalExpression <em>Conditional Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XIfExpressionImpl extends XExpressionImpl implements XIfExpression
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
	 * The cached value of the '{@link #getElse() <em>Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElse()
	 * @generated
	 * @ordered
	 */
	protected XExpression else_;

	/**
	 * The default value of the '{@link #isConditionalExpression() <em>Conditional Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConditionalExpression()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONDITIONAL_EXPRESSION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConditionalExpression() <em>Conditional Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConditionalExpression()
	 * @generated
	 * @ordered
	 */
	protected boolean conditionalExpression = CONDITIONAL_EXPRESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XIfExpressionImpl()
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
		return XbasePackage.Literals.XIF_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XIF_EXPRESSION__IF, oldIf, newIf);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIf(XExpression newIf)
	{
		if (newIf != if_)
		{
			NotificationChain msgs = null;
			if (if_ != null)
				msgs = ((InternalEObject)if_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XIF_EXPRESSION__IF, null, msgs);
			if (newIf != null)
				msgs = ((InternalEObject)newIf).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XIF_EXPRESSION__IF, null, msgs);
			msgs = basicSetIf(newIf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XIF_EXPRESSION__IF, newIf, newIf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XIF_EXPRESSION__THEN, oldThen, newThen);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThen(XExpression newThen)
	{
		if (newThen != then)
		{
			NotificationChain msgs = null;
			if (then != null)
				msgs = ((InternalEObject)then).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XIF_EXPRESSION__THEN, null, msgs);
			if (newThen != null)
				msgs = ((InternalEObject)newThen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XIF_EXPRESSION__THEN, null, msgs);
			msgs = basicSetThen(newThen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XIF_EXPRESSION__THEN, newThen, newThen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XIF_EXPRESSION__ELSE, oldElse, newElse);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElse(XExpression newElse)
	{
		if (newElse != else_)
		{
			NotificationChain msgs = null;
			if (else_ != null)
				msgs = ((InternalEObject)else_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XIF_EXPRESSION__ELSE, null, msgs);
			if (newElse != null)
				msgs = ((InternalEObject)newElse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XIF_EXPRESSION__ELSE, null, msgs);
			msgs = basicSetElse(newElse, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XIF_EXPRESSION__ELSE, newElse, newElse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConditionalExpression()
	{
		return conditionalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionalExpression(boolean newConditionalExpression)
	{
		boolean oldConditionalExpression = conditionalExpression;
		conditionalExpression = newConditionalExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XIF_EXPRESSION__CONDITIONAL_EXPRESSION, oldConditionalExpression, conditionalExpression));
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
			case XbasePackage.XIF_EXPRESSION__IF:
				return basicSetIf(null, msgs);
			case XbasePackage.XIF_EXPRESSION__THEN:
				return basicSetThen(null, msgs);
			case XbasePackage.XIF_EXPRESSION__ELSE:
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
			case XbasePackage.XIF_EXPRESSION__IF:
				return getIf();
			case XbasePackage.XIF_EXPRESSION__THEN:
				return getThen();
			case XbasePackage.XIF_EXPRESSION__ELSE:
				return getElse();
			case XbasePackage.XIF_EXPRESSION__CONDITIONAL_EXPRESSION:
				return isConditionalExpression();
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
			case XbasePackage.XIF_EXPRESSION__IF:
				setIf((XExpression)newValue);
				return;
			case XbasePackage.XIF_EXPRESSION__THEN:
				setThen((XExpression)newValue);
				return;
			case XbasePackage.XIF_EXPRESSION__ELSE:
				setElse((XExpression)newValue);
				return;
			case XbasePackage.XIF_EXPRESSION__CONDITIONAL_EXPRESSION:
				setConditionalExpression((Boolean)newValue);
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
			case XbasePackage.XIF_EXPRESSION__IF:
				setIf((XExpression)null);
				return;
			case XbasePackage.XIF_EXPRESSION__THEN:
				setThen((XExpression)null);
				return;
			case XbasePackage.XIF_EXPRESSION__ELSE:
				setElse((XExpression)null);
				return;
			case XbasePackage.XIF_EXPRESSION__CONDITIONAL_EXPRESSION:
				setConditionalExpression(CONDITIONAL_EXPRESSION_EDEFAULT);
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
			case XbasePackage.XIF_EXPRESSION__IF:
				return if_ != null;
			case XbasePackage.XIF_EXPRESSION__THEN:
				return then != null;
			case XbasePackage.XIF_EXPRESSION__ELSE:
				return else_ != null;
			case XbasePackage.XIF_EXPRESSION__CONDITIONAL_EXPRESSION:
				return conditionalExpression != CONDITIONAL_EXPRESSION_EDEFAULT;
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
		result.append(" (conditionalExpression: ");
		result.append(conditionalExpression);
		result.append(')');
		return result.toString();
	}

} //XIfExpressionImpl
