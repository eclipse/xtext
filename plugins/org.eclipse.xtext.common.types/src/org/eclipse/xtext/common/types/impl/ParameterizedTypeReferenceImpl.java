/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.ParameterizedTypeReference;
import org.eclipse.xtext.common.types.Type;
import org.eclipse.xtext.common.types.TypeArgument;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameterized Type Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.ParameterizedTypeReferenceImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.ParameterizedTypeReferenceImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterizedTypeReferenceImpl extends TypeReferenceImpl implements ParameterizedTypeReference {
	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeArgument> arguments;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterizedTypeReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.PARAMETERIZED_TYPE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeArgument> getArguments() {
		if (arguments == null) {
			arguments = new EObjectContainmentWithInverseEList<TypeArgument>(TypeArgument.class, this, TypesPackage.PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS, TypesPackage.TYPE_ARGUMENT__DECLARATOR);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypesPackage.PARAMETERIZED_TYPE_REFERENCE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.PARAMETERIZED_TYPE_REFERENCE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getArguments()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS:
				return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
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
			case TypesPackage.PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS:
				return getArguments();
			case TypesPackage.PARAMETERIZED_TYPE_REFERENCE__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case TypesPackage.PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection<? extends TypeArgument>)newValue);
				return;
			case TypesPackage.PARAMETERIZED_TYPE_REFERENCE__TYPE:
				setType((Type)newValue);
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
			case TypesPackage.PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS:
				getArguments().clear();
				return;
			case TypesPackage.PARAMETERIZED_TYPE_REFERENCE__TYPE:
				setType((Type)null);
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
			case TypesPackage.PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
			case TypesPackage.PARAMETERIZED_TYPE_REFERENCE__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public String getCanonicalName() {
		if (type == null)
			return null;
		String result = getType().getCanonicalName();
		if (arguments != null && !arguments.isEmpty()) {
			StringBuilder mutableResult = new StringBuilder(result);
			mutableResult.append("<");
			appendCanonicalArguments(mutableResult, arguments);
			mutableResult.append(">");
			return mutableResult.toString();
		}
		return result;
	}
	
	static void appendCanonicalArguments(StringBuilder result, List<TypeArgument> arguments) {
		if (arguments == null || arguments.isEmpty())
			return;
		int wasLength = result.length();
		for(TypeArgument argument: arguments) {
			if (result.length() != wasLength)
				result.append(",");
			result.append(argument.getCanonicalName());
		}
	}

} //ParameterizedTypeReferenceImpl
