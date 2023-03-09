/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmFeatureImpl#getLocalClasses <em>Local Classes</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class JvmFeatureImpl extends JvmMemberImplCustom implements JvmFeature
{
	/**
	 * The cached value of the '{@link #getLocalClasses() <em>Local Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmGenericType> localClasses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmFeatureImpl()
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
		return TypesPackage.Literals.JVM_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<JvmGenericType> getLocalClasses()
	{
		if (localClasses == null)
		{
			localClasses = new EObjectContainmentEList<JvmGenericType>(JvmGenericType.class, this, TypesPackage.JVM_FEATURE__LOCAL_CLASSES);
		}
		return localClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.4
	 * @generated
	 */
	@Override
	public boolean isStatic()
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
			case TypesPackage.JVM_FEATURE__LOCAL_CLASSES:
				return ((InternalEList<?>)getLocalClasses()).basicRemove(otherEnd, msgs);
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
			case TypesPackage.JVM_FEATURE__LOCAL_CLASSES:
				return getLocalClasses();
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
			case TypesPackage.JVM_FEATURE__LOCAL_CLASSES:
				getLocalClasses().clear();
				getLocalClasses().addAll((Collection<? extends JvmGenericType>)newValue);
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
			case TypesPackage.JVM_FEATURE__LOCAL_CLASSES:
				getLocalClasses().clear();
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
			case TypesPackage.JVM_FEATURE__LOCAL_CLASSES:
				return localClasses != null && !localClasses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //JvmFeatureImpl
