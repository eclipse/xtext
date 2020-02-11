/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.richstring.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtend.core.richstring.ForLoopEnd;
import org.eclipse.xtend.core.richstring.ForLoopStart;
import org.eclipse.xtend.core.richstring.ProcessedRichStringPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Loop End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.richstring.impl.ForLoopEndImpl#getStart <em>Start</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForLoopEndImpl extends LinePartImpl implements ForLoopEnd
{
	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected ForLoopStart start;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForLoopEndImpl()
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
		return ProcessedRichStringPackage.Literals.FOR_LOOP_END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForLoopStart getStart()
	{
		if (start != null && start.eIsProxy())
		{
			InternalEObject oldStart = (InternalEObject)start;
			start = (ForLoopStart)eResolveProxy(oldStart);
			if (start != oldStart)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessedRichStringPackage.FOR_LOOP_END__START, oldStart, start));
			}
		}
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForLoopStart basicGetStart()
	{
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStart(ForLoopStart newStart, NotificationChain msgs)
	{
		ForLoopStart oldStart = start;
		start = newStart;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessedRichStringPackage.FOR_LOOP_END__START, oldStart, newStart);
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
	public void setStart(ForLoopStart newStart)
	{
		if (newStart != start)
		{
			NotificationChain msgs = null;
			if (start != null)
				msgs = ((InternalEObject)start).eInverseRemove(this, ProcessedRichStringPackage.FOR_LOOP_START__END, ForLoopStart.class, msgs);
			if (newStart != null)
				msgs = ((InternalEObject)newStart).eInverseAdd(this, ProcessedRichStringPackage.FOR_LOOP_START__END, ForLoopStart.class, msgs);
			msgs = basicSetStart(newStart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessedRichStringPackage.FOR_LOOP_END__START, newStart, newStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ProcessedRichStringPackage.FOR_LOOP_END__START:
				if (start != null)
					msgs = ((InternalEObject)start).eInverseRemove(this, ProcessedRichStringPackage.FOR_LOOP_START__END, ForLoopStart.class, msgs);
				return basicSetStart((ForLoopStart)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case ProcessedRichStringPackage.FOR_LOOP_END__START:
				return basicSetStart(null, msgs);
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
			case ProcessedRichStringPackage.FOR_LOOP_END__START:
				if (resolve) return getStart();
				return basicGetStart();
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
			case ProcessedRichStringPackage.FOR_LOOP_END__START:
				setStart((ForLoopStart)newValue);
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
			case ProcessedRichStringPackage.FOR_LOOP_END__START:
				setStart((ForLoopStart)null);
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
			case ProcessedRichStringPackage.FOR_LOOP_END__START:
				return start != null;
		}
		return super.eIsSet(featureID);
	}

} //ForLoopEndImpl
