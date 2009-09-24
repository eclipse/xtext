/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.Wildcard;
import org.eclipse.xtext.common.types.WildcardTypeArgument;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wildcard Type Argument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.WildcardTypeArgumentImpl#getWildcard <em>Wildcard</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WildcardTypeArgumentImpl extends TypeArgumentImpl implements WildcardTypeArgument {
	/**
	 * The cached value of the '{@link #getWildcard() <em>Wildcard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWildcard()
	 * @generated
	 * @ordered
	 */
	protected Wildcard wildcard;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WildcardTypeArgumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.WILDCARD_TYPE_ARGUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Wildcard getWildcard() {
		return wildcard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWildcard(Wildcard newWildcard, NotificationChain msgs) {
		Wildcard oldWildcard = wildcard;
		wildcard = newWildcard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.WILDCARD_TYPE_ARGUMENT__WILDCARD, oldWildcard, newWildcard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWildcard(Wildcard newWildcard) {
		if (newWildcard != wildcard) {
			NotificationChain msgs = null;
			if (wildcard != null)
				msgs = ((InternalEObject)wildcard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.WILDCARD_TYPE_ARGUMENT__WILDCARD, null, msgs);
			if (newWildcard != null)
				msgs = ((InternalEObject)newWildcard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.WILDCARD_TYPE_ARGUMENT__WILDCARD, null, msgs);
			msgs = basicSetWildcard(newWildcard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.WILDCARD_TYPE_ARGUMENT__WILDCARD, newWildcard, newWildcard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.WILDCARD_TYPE_ARGUMENT__WILDCARD:
				return basicSetWildcard(null, msgs);
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
			case TypesPackage.WILDCARD_TYPE_ARGUMENT__WILDCARD:
				return getWildcard();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TypesPackage.WILDCARD_TYPE_ARGUMENT__WILDCARD:
				setWildcard((Wildcard)newValue);
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
			case TypesPackage.WILDCARD_TYPE_ARGUMENT__WILDCARD:
				setWildcard((Wildcard)null);
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
			case TypesPackage.WILDCARD_TYPE_ARGUMENT__WILDCARD:
				return wildcard != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public String getCanonicalName() {
		if (wildcard != null)
			return wildcard.getCanonicalName();
		return null;
	}

} //WildcardTypeArgumentImpl
