/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xbase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.common.types.JvmIdentifyableElement;

import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XImplicitReceiverCall;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XAssignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XAssignmentImpl#getImplicitReceiver <em>Implicit Receiver</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XAssignmentImpl#getAssignable <em>Assignable</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XAssignmentImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XAssignmentImpl extends XAbstractFeatureCallImplCustom implements XAssignment
{
	/**
	 * The cached value of the '{@link #getImplicitReceiver() <em>Implicit Receiver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplicitReceiver()
	 * @generated
	 * @ordered
	 */
	protected JvmIdentifyableElement implicitReceiver;

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
	public JvmIdentifyableElement getImplicitReceiver()
	{
		if (implicitReceiver != null && implicitReceiver.eIsProxy())
		{
			InternalEObject oldImplicitReceiver = (InternalEObject)implicitReceiver;
			implicitReceiver = (JvmIdentifyableElement)eResolveProxy(oldImplicitReceiver);
			if (implicitReceiver != oldImplicitReceiver)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XbasePackage.XASSIGNMENT__IMPLICIT_RECEIVER, oldImplicitReceiver, implicitReceiver));
			}
		}
		return implicitReceiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmIdentifyableElement basicGetImplicitReceiver()
	{
		return implicitReceiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplicitReceiver(JvmIdentifyableElement newImplicitReceiver)
	{
		JvmIdentifyableElement oldImplicitReceiver = implicitReceiver;
		implicitReceiver = newImplicitReceiver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XASSIGNMENT__IMPLICIT_RECEIVER, oldImplicitReceiver, implicitReceiver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			case XbasePackage.XASSIGNMENT__IMPLICIT_RECEIVER:
				if (resolve) return getImplicitReceiver();
				return basicGetImplicitReceiver();
			case XbasePackage.XASSIGNMENT__ASSIGNABLE:
				return getAssignable();
			case XbasePackage.XASSIGNMENT__VALUE:
				return getValue();
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
			case XbasePackage.XASSIGNMENT__IMPLICIT_RECEIVER:
				setImplicitReceiver((JvmIdentifyableElement)newValue);
				return;
			case XbasePackage.XASSIGNMENT__ASSIGNABLE:
				setAssignable((XExpression)newValue);
				return;
			case XbasePackage.XASSIGNMENT__VALUE:
				setValue((XExpression)newValue);
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
			case XbasePackage.XASSIGNMENT__IMPLICIT_RECEIVER:
				setImplicitReceiver((JvmIdentifyableElement)null);
				return;
			case XbasePackage.XASSIGNMENT__ASSIGNABLE:
				setAssignable((XExpression)null);
				return;
			case XbasePackage.XASSIGNMENT__VALUE:
				setValue((XExpression)null);
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
			case XbasePackage.XASSIGNMENT__IMPLICIT_RECEIVER:
				return implicitReceiver != null;
			case XbasePackage.XASSIGNMENT__ASSIGNABLE:
				return assignable != null;
			case XbasePackage.XASSIGNMENT__VALUE:
				return value != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == XImplicitReceiverCall.class)
		{
			switch (derivedFeatureID)
			{
				case XbasePackage.XASSIGNMENT__IMPLICIT_RECEIVER: return XbasePackage.XIMPLICIT_RECEIVER_CALL__IMPLICIT_RECEIVER;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == XImplicitReceiverCall.class)
		{
			switch (baseFeatureID)
			{
				case XbasePackage.XIMPLICIT_RECEIVER_CALL__IMPLICIT_RECEIVER: return XbasePackage.XASSIGNMENT__IMPLICIT_RECEIVER;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //XAssignmentImpl
