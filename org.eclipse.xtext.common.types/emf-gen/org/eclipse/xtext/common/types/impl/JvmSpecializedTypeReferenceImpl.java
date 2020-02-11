/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Specialized Type Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmSpecializedTypeReferenceImpl#getEquivalent <em>Equivalent</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class JvmSpecializedTypeReferenceImpl extends JvmTypeReferenceImplCustom implements JvmSpecializedTypeReference
{
	/**
	 * The cached value of the '{@link #getEquivalent() <em>Equivalent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquivalent()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference equivalent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmSpecializedTypeReferenceImpl()
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
		return TypesPackage.Literals.JVM_SPECIALIZED_TYPE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JvmTypeReference getEquivalent()
	{
		return equivalent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEquivalent(JvmTypeReference newEquivalent, NotificationChain msgs)
	{
		JvmTypeReference oldEquivalent = equivalent;
		equivalent = newEquivalent;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT, oldEquivalent, newEquivalent);
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
	public void setEquivalent(JvmTypeReference newEquivalent)
	{
		if (newEquivalent != equivalent)
		{
			NotificationChain msgs = null;
			if (equivalent != null)
				msgs = ((InternalEObject)equivalent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT, null, msgs);
			if (newEquivalent != null)
				msgs = ((InternalEObject)newEquivalent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT, null, msgs);
			msgs = basicSetEquivalent(newEquivalent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT, newEquivalent, newEquivalent));
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
			case TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT:
				return basicSetEquivalent(null, msgs);
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
			case TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT:
				return getEquivalent();
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
			case TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT:
				setEquivalent((JvmTypeReference)newValue);
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
			case TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT:
				setEquivalent((JvmTypeReference)null);
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
			case TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT:
				return equivalent != null;
		}
		return super.eIsSet(featureID);
	}

} //JvmSpecializedTypeReferenceImpl
