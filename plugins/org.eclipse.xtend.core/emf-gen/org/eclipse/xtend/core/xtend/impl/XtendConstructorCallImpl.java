/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.xtend.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructorCall;
import org.eclipse.xtend.core.xtend.XtendPackage;

import org.eclipse.xtext.xbase.impl.XConstructorCallImplCustom;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constructor Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.XtendConstructorCallImpl#getAnonymousClass <em>Anonymous Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XtendConstructorCallImpl extends XConstructorCallImplCustom implements XtendConstructorCall
{
	/**
	 * The cached value of the '{@link #getAnonymousClass() <em>Anonymous Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnonymousClass()
	 * @generated
	 * @ordered
	 */
	protected XtendClass anonymousClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XtendConstructorCallImpl()
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
		return XtendPackage.Literals.XTEND_CONSTRUCTOR_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendClass getAnonymousClass()
	{
		return anonymousClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnonymousClass(XtendClass newAnonymousClass, NotificationChain msgs)
	{
		XtendClass oldAnonymousClass = anonymousClass;
		anonymousClass = newAnonymousClass;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtendPackage.XTEND_CONSTRUCTOR_CALL__ANONYMOUS_CLASS, oldAnonymousClass, newAnonymousClass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnonymousClass(XtendClass newAnonymousClass)
	{
		if (newAnonymousClass != anonymousClass)
		{
			NotificationChain msgs = null;
			if (anonymousClass != null)
				msgs = ((InternalEObject)anonymousClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtendPackage.XTEND_CONSTRUCTOR_CALL__ANONYMOUS_CLASS, null, msgs);
			if (newAnonymousClass != null)
				msgs = ((InternalEObject)newAnonymousClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtendPackage.XTEND_CONSTRUCTOR_CALL__ANONYMOUS_CLASS, null, msgs);
			msgs = basicSetAnonymousClass(newAnonymousClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.XTEND_CONSTRUCTOR_CALL__ANONYMOUS_CLASS, newAnonymousClass, newAnonymousClass));
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
			case XtendPackage.XTEND_CONSTRUCTOR_CALL__ANONYMOUS_CLASS:
				return basicSetAnonymousClass(null, msgs);
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
			case XtendPackage.XTEND_CONSTRUCTOR_CALL__ANONYMOUS_CLASS:
				return getAnonymousClass();
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
			case XtendPackage.XTEND_CONSTRUCTOR_CALL__ANONYMOUS_CLASS:
				setAnonymousClass((XtendClass)newValue);
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
			case XtendPackage.XTEND_CONSTRUCTOR_CALL__ANONYMOUS_CLASS:
				setAnonymousClass((XtendClass)null);
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
			case XtendPackage.XTEND_CONSTRUCTOR_CALL__ANONYMOUS_CLASS:
				return anonymousClass != null;
		}
		return super.eIsSet(featureID);
	}

} //XtendConstructorCallImpl
