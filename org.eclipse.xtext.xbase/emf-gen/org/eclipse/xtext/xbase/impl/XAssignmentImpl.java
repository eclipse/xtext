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

import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XAssignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XAssignmentImpl#getAssignable <em>Assignable</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XAssignmentImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XAssignmentImpl#isExplicitStatic <em>Explicit Static</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XAssignmentImpl#isStaticWithDeclaringType <em>Static With Declaring Type</em>}</li>
 * </ul>
 *
 * @since 2.7
 * @generated
 */
public class XAssignmentImpl extends XAbstractFeatureCallImplCustom implements XAssignment
{
	/**
	 * The cached value of the '{@link #getAssignable() <em>Assignable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignable()
	 * @generated
	 * @ordered
	 */
	protected XExpression assignable;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected XExpression value;

	/**
	 * The default value of the '{@link #isExplicitStatic() <em>Explicit Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExplicitStatic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXPLICIT_STATIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExplicitStatic() <em>Explicit Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExplicitStatic()
	 * @generated
	 * @ordered
	 */
	protected boolean explicitStatic = EXPLICIT_STATIC_EDEFAULT;

	/**
	 * The default value of the '{@link #isStaticWithDeclaringType() <em>Static With Declaring Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStaticWithDeclaringType()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STATIC_WITH_DECLARING_TYPE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStaticWithDeclaringType() <em>Static With Declaring Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStaticWithDeclaringType()
	 * @generated
	 * @ordered
	 */
	protected boolean staticWithDeclaringType = STATIC_WITH_DECLARING_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XAssignmentImpl()
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
		return XbasePackage.Literals.XASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XExpression getAssignable()
	{
		return assignable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssignable(XExpression newAssignable, NotificationChain msgs)
	{
		XExpression oldAssignable = assignable;
		assignable = newAssignable;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XASSIGNMENT__ASSIGNABLE, oldAssignable, newAssignable);
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
	public void setAssignable(XExpression newAssignable)
	{
		if (newAssignable != assignable)
		{
			NotificationChain msgs = null;
			if (assignable != null)
				msgs = ((InternalEObject)assignable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XASSIGNMENT__ASSIGNABLE, null, msgs);
			if (newAssignable != null)
				msgs = ((InternalEObject)newAssignable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XASSIGNMENT__ASSIGNABLE, null, msgs);
			msgs = basicSetAssignable(newAssignable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XASSIGNMENT__ASSIGNABLE, newAssignable, newAssignable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XExpression getValue()
	{
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(XExpression newValue, NotificationChain msgs)
	{
		XExpression oldValue = value;
		value = newValue;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XASSIGNMENT__VALUE, oldValue, newValue);
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
	public void setValue(XExpression newValue)
	{
		if (newValue != value)
		{
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XASSIGNMENT__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XASSIGNMENT__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XASSIGNMENT__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isExplicitStatic()
	{
		return explicitStatic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExplicitStatic(boolean newExplicitStatic)
	{
		boolean oldExplicitStatic = explicitStatic;
		explicitStatic = newExplicitStatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XASSIGNMENT__EXPLICIT_STATIC, oldExplicitStatic, explicitStatic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isStaticWithDeclaringType()
	{
		return staticWithDeclaringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStaticWithDeclaringType(boolean newStaticWithDeclaringType)
	{
		boolean oldStaticWithDeclaringType = staticWithDeclaringType;
		staticWithDeclaringType = newStaticWithDeclaringType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XASSIGNMENT__STATIC_WITH_DECLARING_TYPE, oldStaticWithDeclaringType, staticWithDeclaringType));
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
			case XbasePackage.XASSIGNMENT__ASSIGNABLE:
				return basicSetAssignable(null, msgs);
			case XbasePackage.XASSIGNMENT__VALUE:
				return basicSetValue(null, msgs);
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
			case XbasePackage.XASSIGNMENT__ASSIGNABLE:
				return getAssignable();
			case XbasePackage.XASSIGNMENT__VALUE:
				return getValue();
			case XbasePackage.XASSIGNMENT__EXPLICIT_STATIC:
				return isExplicitStatic();
			case XbasePackage.XASSIGNMENT__STATIC_WITH_DECLARING_TYPE:
				return isStaticWithDeclaringType();
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
			case XbasePackage.XASSIGNMENT__ASSIGNABLE:
				setAssignable((XExpression)newValue);
				return;
			case XbasePackage.XASSIGNMENT__VALUE:
				setValue((XExpression)newValue);
				return;
			case XbasePackage.XASSIGNMENT__EXPLICIT_STATIC:
				setExplicitStatic((Boolean)newValue);
				return;
			case XbasePackage.XASSIGNMENT__STATIC_WITH_DECLARING_TYPE:
				setStaticWithDeclaringType((Boolean)newValue);
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
			case XbasePackage.XASSIGNMENT__ASSIGNABLE:
				setAssignable((XExpression)null);
				return;
			case XbasePackage.XASSIGNMENT__VALUE:
				setValue((XExpression)null);
				return;
			case XbasePackage.XASSIGNMENT__EXPLICIT_STATIC:
				setExplicitStatic(EXPLICIT_STATIC_EDEFAULT);
				return;
			case XbasePackage.XASSIGNMENT__STATIC_WITH_DECLARING_TYPE:
				setStaticWithDeclaringType(STATIC_WITH_DECLARING_TYPE_EDEFAULT);
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
			case XbasePackage.XASSIGNMENT__ASSIGNABLE:
				return assignable != null;
			case XbasePackage.XASSIGNMENT__VALUE:
				return value != null;
			case XbasePackage.XASSIGNMENT__EXPLICIT_STATIC:
				return explicitStatic != EXPLICIT_STATIC_EDEFAULT;
			case XbasePackage.XASSIGNMENT__STATIC_WITH_DECLARING_TYPE:
				return staticWithDeclaringType != STATIC_WITH_DECLARING_TYPE_EDEFAULT;
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
		result.append(" (explicitStatic: ");
		result.append(explicitStatic);
		result.append(", staticWithDeclaringType: ");
		result.append(staticWithDeclaringType);
		result.append(')');
		return result.toString();
	}

} //XAssignmentImpl
