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

import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Inner Type Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmInnerTypeReferenceImpl#getOuter <em>Outer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JvmInnerTypeReferenceImpl extends JvmParameterizedTypeReferenceImplCustom implements JvmInnerTypeReference
{
	/**
	 * The cached value of the '{@link #getOuter() <em>Outer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuter()
	 * @generated
	 * @ordered
	 */
	protected JvmParameterizedTypeReference outer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmInnerTypeReferenceImpl()
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
		return TypesPackage.Literals.JVM_INNER_TYPE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JvmParameterizedTypeReference getOuter()
	{
		return outer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOuter(JvmParameterizedTypeReference newOuter, NotificationChain msgs)
	{
		JvmParameterizedTypeReference oldOuter = outer;
		outer = newOuter;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_INNER_TYPE_REFERENCE__OUTER, oldOuter, newOuter);
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
	public void setOuter(JvmParameterizedTypeReference newOuter)
	{
		if (newOuter != outer)
		{
			NotificationChain msgs = null;
			if (outer != null)
				msgs = ((InternalEObject)outer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_INNER_TYPE_REFERENCE__OUTER, null, msgs);
			if (newOuter != null)
				msgs = ((InternalEObject)newOuter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_INNER_TYPE_REFERENCE__OUTER, null, msgs);
			msgs = basicSetOuter(newOuter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_INNER_TYPE_REFERENCE__OUTER, newOuter, newOuter));
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
			case TypesPackage.JVM_INNER_TYPE_REFERENCE__OUTER:
				return basicSetOuter(null, msgs);
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
			case TypesPackage.JVM_INNER_TYPE_REFERENCE__OUTER:
				return getOuter();
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
			case TypesPackage.JVM_INNER_TYPE_REFERENCE__OUTER:
				setOuter((JvmParameterizedTypeReference)newValue);
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
			case TypesPackage.JVM_INNER_TYPE_REFERENCE__OUTER:
				setOuter((JvmParameterizedTypeReference)null);
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
			case TypesPackage.JVM_INNER_TYPE_REFERENCE__OUTER:
				return outer != null;
		}
		return super.eIsSet(featureID);
	}

} //JvmInnerTypeReferenceImpl
