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

import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Generic Array Type Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmGenericArrayTypeReferenceImpl#getComponentType <em>Component Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JvmGenericArrayTypeReferenceImpl extends JvmTypeReferenceImplCustom implements JvmGenericArrayTypeReference
{
	/**
	 * The cached value of the '{@link #getComponentType() <em>Component Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentType()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference componentType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmGenericArrayTypeReferenceImpl()
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
		return TypesPackage.Literals.JVM_GENERIC_ARRAY_TYPE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JvmTypeReference getComponentType()
	{
		return componentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentType(JvmTypeReference newComponentType, NotificationChain msgs)
	{
		JvmTypeReference oldComponentType = componentType;
		componentType = newComponentType;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE, oldComponentType, newComponentType);
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
	public void setComponentType(JvmTypeReference newComponentType)
	{
		if (newComponentType != componentType)
		{
			NotificationChain msgs = null;
			if (componentType != null)
				msgs = ((InternalEObject)componentType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE, null, msgs);
			if (newComponentType != null)
				msgs = ((InternalEObject)newComponentType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE, null, msgs);
			msgs = basicSetComponentType(newComponentType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE, newComponentType, newComponentType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getDimensions()
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JvmArrayType getType()
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE:
				return basicSetComponentType(null, msgs);
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
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE:
				return getComponentType();
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
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE:
				setComponentType((JvmTypeReference)newValue);
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
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE:
				setComponentType((JvmTypeReference)null);
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
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE:
				return componentType != null;
		}
		return super.eIsSet(featureID);
	}

} //JvmGenericArrayTypeReferenceImpl
