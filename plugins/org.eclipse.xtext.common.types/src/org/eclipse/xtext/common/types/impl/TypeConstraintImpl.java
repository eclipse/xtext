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
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtext.common.types.ConstrainedType;
import org.eclipse.xtext.common.types.Type;
import org.eclipse.xtext.common.types.TypeConstraint;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.TypeConstraintImpl#getReferencedType <em>Referenced Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.TypeConstraintImpl#getConstrainedType <em>Constrained Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TypeConstraintImpl extends IdentifyableElementImpl implements TypeConstraint {
	/**
	 * The cached value of the '{@link #getReferencedType() <em>Referenced Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedType()
	 * @generated
	 * @ordered
	 */
	protected Type referencedType;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.TYPE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getReferencedType() {
		if (referencedType != null && referencedType.eIsProxy()) {
			InternalEObject oldReferencedType = (InternalEObject)referencedType;
			referencedType = (Type)eResolveProxy(oldReferencedType);
			if (referencedType != oldReferencedType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypesPackage.TYPE_CONSTRAINT__REFERENCED_TYPE, oldReferencedType, referencedType));
			}
		}
		return referencedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetReferencedType() {
		return referencedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedType(Type newReferencedType) {
		Type oldReferencedType = referencedType;
		referencedType = newReferencedType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.TYPE_CONSTRAINT__REFERENCED_TYPE, oldReferencedType, referencedType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstrainedType getConstrainedType() {
		if (eContainerFeatureID() != TypesPackage.TYPE_CONSTRAINT__CONSTRAINED_TYPE) return null;
		return (ConstrainedType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstrainedType(ConstrainedType newConstrainedType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConstrainedType, TypesPackage.TYPE_CONSTRAINT__CONSTRAINED_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstrainedType(ConstrainedType newConstrainedType) {
		if (newConstrainedType != eInternalContainer() || (eContainerFeatureID() != TypesPackage.TYPE_CONSTRAINT__CONSTRAINED_TYPE && newConstrainedType != null)) {
			if (EcoreUtil.isAncestor(this, newConstrainedType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConstrainedType != null)
				msgs = ((InternalEObject)newConstrainedType).eInverseAdd(this, TypesPackage.CONSTRAINED_TYPE__CONSTRAINTS, ConstrainedType.class, msgs);
			msgs = basicSetConstrainedType(newConstrainedType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.TYPE_CONSTRAINT__CONSTRAINED_TYPE, newConstrainedType, newConstrainedType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.TYPE_CONSTRAINT__CONSTRAINED_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConstrainedType((ConstrainedType)otherEnd, msgs);
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
			case TypesPackage.TYPE_CONSTRAINT__CONSTRAINED_TYPE:
				return basicSetConstrainedType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TypesPackage.TYPE_CONSTRAINT__CONSTRAINED_TYPE:
				return eInternalContainer().eInverseRemove(this, TypesPackage.CONSTRAINED_TYPE__CONSTRAINTS, ConstrainedType.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesPackage.TYPE_CONSTRAINT__REFERENCED_TYPE:
				if (resolve) return getReferencedType();
				return basicGetReferencedType();
			case TypesPackage.TYPE_CONSTRAINT__CONSTRAINED_TYPE:
				return getConstrainedType();
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
			case TypesPackage.TYPE_CONSTRAINT__REFERENCED_TYPE:
				setReferencedType((Type)newValue);
				return;
			case TypesPackage.TYPE_CONSTRAINT__CONSTRAINED_TYPE:
				setConstrainedType((ConstrainedType)newValue);
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
			case TypesPackage.TYPE_CONSTRAINT__REFERENCED_TYPE:
				setReferencedType((Type)null);
				return;
			case TypesPackage.TYPE_CONSTRAINT__CONSTRAINED_TYPE:
				setConstrainedType((ConstrainedType)null);
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
			case TypesPackage.TYPE_CONSTRAINT__REFERENCED_TYPE:
				return referencedType != null;
			case TypesPackage.TYPE_CONSTRAINT__CONSTRAINED_TYPE:
				return getConstrainedType() != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public String getCanonicalName() {
		if (referencedType != null) {
			return getReferencedType().getCanonicalName();
		}
		return null;
	}

} //TypeConstraintImpl
