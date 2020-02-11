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

import org.eclipse.xtend.core.xtend.RichStringForLoop;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Loop Start</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.richstring.impl.ForLoopStartImpl#getLoop <em>Loop</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.richstring.impl.ForLoopStartImpl#getEnd <em>End</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForLoopStartImpl extends LinePartImpl implements ForLoopStart
{
	/**
	 * The cached value of the '{@link #getLoop() <em>Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoop()
	 * @generated
	 * @ordered
	 */
	protected RichStringForLoop loop;

	/**
	 * The cached value of the '{@link #getEnd() <em>End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected ForLoopEnd end;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForLoopStartImpl()
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
		return ProcessedRichStringPackage.Literals.FOR_LOOP_START;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RichStringForLoop getLoop()
	{
		if (loop != null && loop.eIsProxy())
		{
			InternalEObject oldLoop = (InternalEObject)loop;
			loop = (RichStringForLoop)eResolveProxy(oldLoop);
			if (loop != oldLoop)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessedRichStringPackage.FOR_LOOP_START__LOOP, oldLoop, loop));
			}
		}
		return loop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RichStringForLoop basicGetLoop()
	{
		return loop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLoop(RichStringForLoop newLoop)
	{
		RichStringForLoop oldLoop = loop;
		loop = newLoop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessedRichStringPackage.FOR_LOOP_START__LOOP, oldLoop, loop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForLoopEnd getEnd()
	{
		if (end != null && end.eIsProxy())
		{
			InternalEObject oldEnd = (InternalEObject)end;
			end = (ForLoopEnd)eResolveProxy(oldEnd);
			if (end != oldEnd)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessedRichStringPackage.FOR_LOOP_START__END, oldEnd, end));
			}
		}
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForLoopEnd basicGetEnd()
	{
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnd(ForLoopEnd newEnd, NotificationChain msgs)
	{
		ForLoopEnd oldEnd = end;
		end = newEnd;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessedRichStringPackage.FOR_LOOP_START__END, oldEnd, newEnd);
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
	public void setEnd(ForLoopEnd newEnd)
	{
		if (newEnd != end)
		{
			NotificationChain msgs = null;
			if (end != null)
				msgs = ((InternalEObject)end).eInverseRemove(this, ProcessedRichStringPackage.FOR_LOOP_END__START, ForLoopEnd.class, msgs);
			if (newEnd != null)
				msgs = ((InternalEObject)newEnd).eInverseAdd(this, ProcessedRichStringPackage.FOR_LOOP_END__START, ForLoopEnd.class, msgs);
			msgs = basicSetEnd(newEnd, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessedRichStringPackage.FOR_LOOP_START__END, newEnd, newEnd));
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
			case ProcessedRichStringPackage.FOR_LOOP_START__END:
				if (end != null)
					msgs = ((InternalEObject)end).eInverseRemove(this, ProcessedRichStringPackage.FOR_LOOP_END__START, ForLoopEnd.class, msgs);
				return basicSetEnd((ForLoopEnd)otherEnd, msgs);
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
			case ProcessedRichStringPackage.FOR_LOOP_START__END:
				return basicSetEnd(null, msgs);
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
			case ProcessedRichStringPackage.FOR_LOOP_START__LOOP:
				if (resolve) return getLoop();
				return basicGetLoop();
			case ProcessedRichStringPackage.FOR_LOOP_START__END:
				if (resolve) return getEnd();
				return basicGetEnd();
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
			case ProcessedRichStringPackage.FOR_LOOP_START__LOOP:
				setLoop((RichStringForLoop)newValue);
				return;
			case ProcessedRichStringPackage.FOR_LOOP_START__END:
				setEnd((ForLoopEnd)newValue);
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
			case ProcessedRichStringPackage.FOR_LOOP_START__LOOP:
				setLoop((RichStringForLoop)null);
				return;
			case ProcessedRichStringPackage.FOR_LOOP_START__END:
				setEnd((ForLoopEnd)null);
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
			case ProcessedRichStringPackage.FOR_LOOP_START__LOOP:
				return loop != null;
			case ProcessedRichStringPackage.FOR_LOOP_START__END:
				return end != null;
		}
		return super.eIsSet(featureID);
	}

} //ForLoopStartImpl
