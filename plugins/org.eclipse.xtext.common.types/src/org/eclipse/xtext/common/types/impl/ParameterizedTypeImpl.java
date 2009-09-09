/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.GenericType;
import org.eclipse.xtext.common.types.ParameterizedType;
import org.eclipse.xtext.common.types.TypeParameter;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameterized Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.ParameterizedTypeImpl#getRawType <em>Raw Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.ParameterizedTypeImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterizedTypeImpl extends ReferenceTypeImpl implements ParameterizedType {
	/**
	 * The cached value of the '{@link #getRawType() <em>Raw Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawType()
	 * @generated
	 * @ordered
	 */
	protected GenericType rawType;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeParameter> parameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterizedTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.PARAMETERIZED_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericType getRawType() {
		return rawType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRawType(GenericType newRawType, NotificationChain msgs) {
		GenericType oldRawType = rawType;
		rawType = newRawType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.PARAMETERIZED_TYPE__RAW_TYPE, oldRawType, newRawType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawType(GenericType newRawType) {
		if (newRawType != rawType) {
			NotificationChain msgs = null;
			if (rawType != null)
				msgs = ((InternalEObject)rawType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.PARAMETERIZED_TYPE__RAW_TYPE, null, msgs);
			if (newRawType != null)
				msgs = ((InternalEObject)newRawType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.PARAMETERIZED_TYPE__RAW_TYPE, null, msgs);
			msgs = basicSetRawType(newRawType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.PARAMETERIZED_TYPE__RAW_TYPE, newRawType, newRawType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<TypeParameter>(TypeParameter.class, this, TypesPackage.PARAMETERIZED_TYPE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.PARAMETERIZED_TYPE__RAW_TYPE:
				return basicSetRawType(null, msgs);
			case TypesPackage.PARAMETERIZED_TYPE__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesPackage.PARAMETERIZED_TYPE__RAW_TYPE:
				return getRawType();
			case TypesPackage.PARAMETERIZED_TYPE__PARAMETERS:
				return getParameters();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TypesPackage.PARAMETERIZED_TYPE__RAW_TYPE:
				setRawType((GenericType)newValue);
				return;
			case TypesPackage.PARAMETERIZED_TYPE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends TypeParameter>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case TypesPackage.PARAMETERIZED_TYPE__RAW_TYPE:
				setRawType((GenericType)null);
				return;
			case TypesPackage.PARAMETERIZED_TYPE__PARAMETERS:
				getParameters().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TypesPackage.PARAMETERIZED_TYPE__RAW_TYPE:
				return rawType != null;
			case TypesPackage.PARAMETERIZED_TYPE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public String getCanonicalName() {
		if (rawType == null)
			return null;
		if (parameters != null && !parameters.isEmpty()) {
			StringBuilder result = new StringBuilder(64);
			result.append(rawType.getFullyQualifiedName());
			result.append('<');
			boolean first = true;
			for(TypeParameter parameter: parameters) {
				if (!first)
					result.append(", ");
				result.append(parameter.getCanonicalName());
				first = false;
			}
			result.append('>');
			return result.toString();
		}
		return rawType.getFullyQualifiedName();
	}

} //ParameterizedTypeImpl
