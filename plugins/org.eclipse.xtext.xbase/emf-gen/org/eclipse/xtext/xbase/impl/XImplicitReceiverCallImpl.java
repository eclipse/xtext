/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xbase.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.common.types.JvmIdentifyableElement;

import org.eclipse.xtext.xbase.XImplicitReceiverCall;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XImplicit Receiver Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XImplicitReceiverCallImpl#getImplicitReceiver <em>Implicit Receiver</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XImplicitReceiverCallImpl extends MinimalEObjectImpl.Container implements XImplicitReceiverCall
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XImplicitReceiverCallImpl()
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
		return XbasePackage.Literals.XIMPLICIT_RECEIVER_CALL;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XbasePackage.XIMPLICIT_RECEIVER_CALL__IMPLICIT_RECEIVER, oldImplicitReceiver, implicitReceiver));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XIMPLICIT_RECEIVER_CALL__IMPLICIT_RECEIVER, oldImplicitReceiver, implicitReceiver));
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
			case XbasePackage.XIMPLICIT_RECEIVER_CALL__IMPLICIT_RECEIVER:
				if (resolve) return getImplicitReceiver();
				return basicGetImplicitReceiver();
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
			case XbasePackage.XIMPLICIT_RECEIVER_CALL__IMPLICIT_RECEIVER:
				setImplicitReceiver((JvmIdentifyableElement)newValue);
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
			case XbasePackage.XIMPLICIT_RECEIVER_CALL__IMPLICIT_RECEIVER:
				setImplicitReceiver((JvmIdentifyableElement)null);
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
			case XbasePackage.XIMPLICIT_RECEIVER_CALL__IMPLICIT_RECEIVER:
				return implicitReceiver != null;
		}
		return super.eIsSet(featureID);
	}

} //XImplicitReceiverCallImpl
