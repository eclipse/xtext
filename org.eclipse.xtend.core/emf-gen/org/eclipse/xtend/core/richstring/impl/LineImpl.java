/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.richstring.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtend.core.richstring.Line;
import org.eclipse.xtend.core.richstring.LinePart;
import org.eclipse.xtend.core.richstring.ProcessedRichString;
import org.eclipse.xtend.core.richstring.ProcessedRichStringPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.richstring.impl.LineImpl#getParts <em>Parts</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.richstring.impl.LineImpl#getRichString <em>Rich String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LineImpl extends MinimalEObjectImpl.Container implements Line
{
	/**
	 * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParts()
	 * @generated
	 * @ordered
	 */
	protected EList<LinePart> parts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LineImpl()
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
		return ProcessedRichStringPackage.Literals.LINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LinePart> getParts()
	{
		if (parts == null)
		{
			parts = new EObjectContainmentWithInverseEList<LinePart>(LinePart.class, this, ProcessedRichStringPackage.LINE__PARTS, ProcessedRichStringPackage.LINE_PART__LINE);
		}
		return parts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessedRichString getRichString()
	{
		if (eContainerFeatureID() != ProcessedRichStringPackage.LINE__RICH_STRING) return null;
		return (ProcessedRichString)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRichString(ProcessedRichString newRichString, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newRichString, ProcessedRichStringPackage.LINE__RICH_STRING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRichString(ProcessedRichString newRichString)
	{
		if (newRichString != eInternalContainer() || (eContainerFeatureID() != ProcessedRichStringPackage.LINE__RICH_STRING && newRichString != null))
		{
			if (EcoreUtil.isAncestor(this, newRichString))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRichString != null)
				msgs = ((InternalEObject)newRichString).eInverseAdd(this, ProcessedRichStringPackage.PROCESSED_RICH_STRING__LINES, ProcessedRichString.class, msgs);
			msgs = basicSetRichString(newRichString, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessedRichStringPackage.LINE__RICH_STRING, newRichString, newRichString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ProcessedRichStringPackage.LINE__PARTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParts()).basicAdd(otherEnd, msgs);
			case ProcessedRichStringPackage.LINE__RICH_STRING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRichString((ProcessedRichString)otherEnd, msgs);
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
			case ProcessedRichStringPackage.LINE__PARTS:
				return ((InternalEList<?>)getParts()).basicRemove(otherEnd, msgs);
			case ProcessedRichStringPackage.LINE__RICH_STRING:
				return basicSetRichString(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case ProcessedRichStringPackage.LINE__RICH_STRING:
				return eInternalContainer().eInverseRemove(this, ProcessedRichStringPackage.PROCESSED_RICH_STRING__LINES, ProcessedRichString.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case ProcessedRichStringPackage.LINE__PARTS:
				return getParts();
			case ProcessedRichStringPackage.LINE__RICH_STRING:
				return getRichString();
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
			case ProcessedRichStringPackage.LINE__PARTS:
				getParts().clear();
				getParts().addAll((Collection<? extends LinePart>)newValue);
				return;
			case ProcessedRichStringPackage.LINE__RICH_STRING:
				setRichString((ProcessedRichString)newValue);
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
			case ProcessedRichStringPackage.LINE__PARTS:
				getParts().clear();
				return;
			case ProcessedRichStringPackage.LINE__RICH_STRING:
				setRichString((ProcessedRichString)null);
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
			case ProcessedRichStringPackage.LINE__PARTS:
				return parts != null && !parts.isEmpty();
			case ProcessedRichStringPackage.LINE__RICH_STRING:
				return getRichString() != null;
		}
		return super.eIsSet(featureID);
	}

} //LineImpl
