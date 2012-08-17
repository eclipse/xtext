/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMember Feature Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XMemberFeatureCallImpl#getMemberCallTarget <em>Member Call Target</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XMemberFeatureCallImpl#getMemberCallArguments <em>Member Call Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XMemberFeatureCallImpl#isExplicitOperationCall <em>Explicit Operation Call</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XMemberFeatureCallImpl#isSpreading <em>Spreading</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XMemberFeatureCallImpl#isNullSafe <em>Null Safe</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMemberFeatureCallImpl extends XAbstractFeatureCallImplCustom implements XMemberFeatureCall
{
	/**
	 * The cached value of the '{@link #getMemberCallTarget() <em>Member Call Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberCallTarget()
	 * @generated
	 * @ordered
	 */
	protected XExpression memberCallTarget;

	/**
	 * The cached value of the '{@link #getMemberCallArguments() <em>Member Call Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberCallArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<XExpression> memberCallArguments;

	/**
	 * The default value of the '{@link #isExplicitOperationCall() <em>Explicit Operation Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExplicitOperationCall()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXPLICIT_OPERATION_CALL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExplicitOperationCall() <em>Explicit Operation Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExplicitOperationCall()
	 * @generated
	 * @ordered
	 */
	protected boolean explicitOperationCall = EXPLICIT_OPERATION_CALL_EDEFAULT;

	/**
	 * The default value of the '{@link #isSpreading() <em>Spreading</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSpreading()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SPREADING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSpreading() <em>Spreading</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSpreading()
	 * @generated
	 * @ordered
	 */
	protected boolean spreading = SPREADING_EDEFAULT;

	/**
	 * The default value of the '{@link #isNullSafe() <em>Null Safe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullSafe()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NULL_SAFE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNullSafe() <em>Null Safe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullSafe()
	 * @generated
	 * @ordered
	 */
	protected boolean nullSafe = NULL_SAFE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMemberFeatureCallImpl()
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
		return XbasePackage.Literals.XMEMBER_FEATURE_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getMemberCallTarget()
	{
		return memberCallTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMemberCallTarget(XExpression newMemberCallTarget, NotificationChain msgs)
	{
		XExpression oldMemberCallTarget = memberCallTarget;
		memberCallTarget = newMemberCallTarget;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET, oldMemberCallTarget, newMemberCallTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemberCallTarget(XExpression newMemberCallTarget)
	{
		if (newMemberCallTarget != memberCallTarget)
		{
			NotificationChain msgs = null;
			if (memberCallTarget != null)
				msgs = ((InternalEObject)memberCallTarget).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET, null, msgs);
			if (newMemberCallTarget != null)
				msgs = ((InternalEObject)newMemberCallTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET, null, msgs);
			msgs = basicSetMemberCallTarget(newMemberCallTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET, newMemberCallTarget, newMemberCallTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XExpression> getMemberCallArguments()
	{
		if (memberCallArguments == null)
		{
			memberCallArguments = new EObjectContainmentEList<XExpression>(XExpression.class, this, XbasePackage.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS);
		}
		return memberCallArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExplicitOperationCall()
	{
		return explicitOperationCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExplicitOperationCall(boolean newExplicitOperationCall)
	{
		boolean oldExplicitOperationCall = explicitOperationCall;
		explicitOperationCall = newExplicitOperationCall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XMEMBER_FEATURE_CALL__EXPLICIT_OPERATION_CALL, oldExplicitOperationCall, explicitOperationCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSpreading()
	{
		return spreading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpreading(boolean newSpreading)
	{
		boolean oldSpreading = spreading;
		spreading = newSpreading;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XMEMBER_FEATURE_CALL__SPREADING, oldSpreading, spreading));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNullSafe()
	{
		return nullSafe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNullSafe(boolean newNullSafe)
	{
		boolean oldNullSafe = nullSafe;
		nullSafe = newNullSafe;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XMEMBER_FEATURE_CALL__NULL_SAFE, oldNullSafe, nullSafe));
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
			case XbasePackage.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET:
				return basicSetMemberCallTarget(null, msgs);
			case XbasePackage.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS:
				return ((InternalEList<?>)getMemberCallArguments()).basicRemove(otherEnd, msgs);
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
			case XbasePackage.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET:
				return getMemberCallTarget();
			case XbasePackage.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS:
				return getMemberCallArguments();
			case XbasePackage.XMEMBER_FEATURE_CALL__EXPLICIT_OPERATION_CALL:
				return isExplicitOperationCall();
			case XbasePackage.XMEMBER_FEATURE_CALL__SPREADING:
				return isSpreading();
			case XbasePackage.XMEMBER_FEATURE_CALL__NULL_SAFE:
				return isNullSafe();
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
			case XbasePackage.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET:
				setMemberCallTarget((XExpression)newValue);
				return;
			case XbasePackage.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS:
				getMemberCallArguments().clear();
				getMemberCallArguments().addAll((Collection<? extends XExpression>)newValue);
				return;
			case XbasePackage.XMEMBER_FEATURE_CALL__EXPLICIT_OPERATION_CALL:
				setExplicitOperationCall((Boolean)newValue);
				return;
			case XbasePackage.XMEMBER_FEATURE_CALL__SPREADING:
				setSpreading((Boolean)newValue);
				return;
			case XbasePackage.XMEMBER_FEATURE_CALL__NULL_SAFE:
				setNullSafe((Boolean)newValue);
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
			case XbasePackage.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET:
				setMemberCallTarget((XExpression)null);
				return;
			case XbasePackage.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS:
				getMemberCallArguments().clear();
				return;
			case XbasePackage.XMEMBER_FEATURE_CALL__EXPLICIT_OPERATION_CALL:
				setExplicitOperationCall(EXPLICIT_OPERATION_CALL_EDEFAULT);
				return;
			case XbasePackage.XMEMBER_FEATURE_CALL__SPREADING:
				setSpreading(SPREADING_EDEFAULT);
				return;
			case XbasePackage.XMEMBER_FEATURE_CALL__NULL_SAFE:
				setNullSafe(NULL_SAFE_EDEFAULT);
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
			case XbasePackage.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET:
				return memberCallTarget != null;
			case XbasePackage.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS:
				return memberCallArguments != null && !memberCallArguments.isEmpty();
			case XbasePackage.XMEMBER_FEATURE_CALL__EXPLICIT_OPERATION_CALL:
				return explicitOperationCall != EXPLICIT_OPERATION_CALL_EDEFAULT;
			case XbasePackage.XMEMBER_FEATURE_CALL__SPREADING:
				return spreading != SPREADING_EDEFAULT;
			case XbasePackage.XMEMBER_FEATURE_CALL__NULL_SAFE:
				return nullSafe != NULL_SAFE_EDEFAULT;
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
		result.append(" (explicitOperationCall: ");
		result.append(explicitOperationCall);
		result.append(", spreading: ");
		result.append(spreading);
		result.append(", nullSafe: ");
		result.append(nullSafe);
		result.append(')');
		return result.toString();
	}

} //XMemberFeatureCallImpl
