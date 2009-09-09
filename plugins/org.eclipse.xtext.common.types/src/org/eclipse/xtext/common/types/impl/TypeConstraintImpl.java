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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.ConstrainedType;
import org.eclipse.xtext.common.types.TypeConstraint;
import org.eclipse.xtext.common.types.TypeReference;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.TypeConstraintImpl#getReferencedTypes <em>Referenced Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.TypeConstraintImpl#getConstrainedType <em>Constrained Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TypeConstraintImpl extends IdentifyableElementImpl implements TypeConstraint {
	/**
	 * The cached value of the '{@link #getReferencedTypes() <em>Referenced Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeReference> referencedTypes;

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
	public EList<TypeReference> getReferencedTypes() {
		if (referencedTypes == null) {
			referencedTypes = new EObjectContainmentEList<TypeReference>(TypeReference.class, this, TypesPackage.TYPE_CONSTRAINT__REFERENCED_TYPES);
		}
		return referencedTypes;
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
			case TypesPackage.TYPE_CONSTRAINT__REFERENCED_TYPES:
				return ((InternalEList<?>)getReferencedTypes()).basicRemove(otherEnd, msgs);
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
			case TypesPackage.TYPE_CONSTRAINT__REFERENCED_TYPES:
				return getReferencedTypes();
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TypesPackage.TYPE_CONSTRAINT__REFERENCED_TYPES:
				getReferencedTypes().clear();
				getReferencedTypes().addAll((Collection<? extends TypeReference>)newValue);
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
			case TypesPackage.TYPE_CONSTRAINT__REFERENCED_TYPES:
				getReferencedTypes().clear();
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
			case TypesPackage.TYPE_CONSTRAINT__REFERENCED_TYPES:
				return referencedTypes != null && !referencedTypes.isEmpty();
			case TypesPackage.TYPE_CONSTRAINT__CONSTRAINED_TYPE:
				return getConstrainedType() != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public String getCanonicalName() {
		if (referencedTypes != null && !referencedTypes.isEmpty()) {
			StringBuilder result = new StringBuilder(64);
			for(TypeReference referencedType: referencedTypes) {
				if (result.length() != 0)
					result.append(" & ");
				result.append(referencedType.getCanonicalName());
			}
			return result.toString();
		}
		return null;
	}

} //TypeConstraintImpl
