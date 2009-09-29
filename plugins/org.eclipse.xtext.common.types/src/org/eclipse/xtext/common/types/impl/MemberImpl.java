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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.common.types.DeclaredType;
import org.eclipse.xtext.common.types.Member;
import org.eclipse.xtext.common.types.ParameterizedType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.Visibility;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.MemberImpl#getDeclaringType <em>Declaring Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.MemberImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.MemberImpl#getFullyQualifiedName <em>Fully Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.MemberImpl#getDeclaredParameterizedTypes <em>Declared Parameterized Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MemberImpl extends AnnotationTargetImpl implements Member {
	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final Visibility VISIBILITY_EDEFAULT = Visibility.DEFAULT;
	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected Visibility visibility = VISIBILITY_EDEFAULT;
	/**
	 * The default value of the '{@link #getFullyQualifiedName() <em>Fully Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullyQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String FULLY_QUALIFIED_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getFullyQualifiedName() <em>Fully Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullyQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String fullyQualifiedName = FULLY_QUALIFIED_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDeclaredParameterizedTypes() <em>Declared Parameterized Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredParameterizedTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterizedType> declaredParameterizedTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.MEMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getCanonicalName() {
		return getFullyQualifiedName();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclaredType getDeclaringType() {
		if (eContainerFeatureID() != TypesPackage.MEMBER__DECLARING_TYPE) return null;
		return (DeclaredType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaringType(DeclaredType newDeclaringType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDeclaringType, TypesPackage.MEMBER__DECLARING_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaringType(DeclaredType newDeclaringType) {
		if (newDeclaringType != eInternalContainer() || (eContainerFeatureID() != TypesPackage.MEMBER__DECLARING_TYPE && newDeclaringType != null)) {
			if (EcoreUtil.isAncestor(this, newDeclaringType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDeclaringType != null)
				msgs = ((InternalEObject)newDeclaringType).eInverseAdd(this, TypesPackage.DECLARED_TYPE__MEMBERS, DeclaredType.class, msgs);
			msgs = basicSetDeclaringType(newDeclaringType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.MEMBER__DECLARING_TYPE, newDeclaringType, newDeclaringType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visibility getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(Visibility newVisibility) {
		Visibility oldVisibility = visibility;
		visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.MEMBER__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFullyQualifiedName() {
		return fullyQualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullyQualifiedName(String newFullyQualifiedName) {
		String oldFullyQualifiedName = fullyQualifiedName;
		fullyQualifiedName = newFullyQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.MEMBER__FULLY_QUALIFIED_NAME, oldFullyQualifiedName, fullyQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterizedType> getDeclaredParameterizedTypes() {
		if (declaredParameterizedTypes == null) {
			declaredParameterizedTypes = new EObjectContainmentWithInverseEList<ParameterizedType>(ParameterizedType.class, this, TypesPackage.MEMBER__DECLARED_PARAMETERIZED_TYPES, TypesPackage.PARAMETERIZED_TYPE__DECLARATOR);
		}
		return declaredParameterizedTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSimpleName() {
		if (fullyQualifiedName == null)
			return null;
		int parenIdx = fullyQualifiedName.indexOf('(');
		if (parenIdx < 0)
			parenIdx = fullyQualifiedName.length();
		int dotIdx = fullyQualifiedName.lastIndexOf('.', parenIdx);
		return fullyQualifiedName.substring(dotIdx + 1, parenIdx);
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
			case TypesPackage.MEMBER__DECLARING_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDeclaringType((DeclaredType)otherEnd, msgs);
			case TypesPackage.MEMBER__DECLARED_PARAMETERIZED_TYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDeclaredParameterizedTypes()).basicAdd(otherEnd, msgs);
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
			case TypesPackage.MEMBER__DECLARING_TYPE:
				return basicSetDeclaringType(null, msgs);
			case TypesPackage.MEMBER__DECLARED_PARAMETERIZED_TYPES:
				return ((InternalEList<?>)getDeclaredParameterizedTypes()).basicRemove(otherEnd, msgs);
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
			case TypesPackage.MEMBER__DECLARING_TYPE:
				return eInternalContainer().eInverseRemove(this, TypesPackage.DECLARED_TYPE__MEMBERS, DeclaredType.class, msgs);
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
			case TypesPackage.MEMBER__DECLARING_TYPE:
				return getDeclaringType();
			case TypesPackage.MEMBER__VISIBILITY:
				return getVisibility();
			case TypesPackage.MEMBER__FULLY_QUALIFIED_NAME:
				return getFullyQualifiedName();
			case TypesPackage.MEMBER__DECLARED_PARAMETERIZED_TYPES:
				return getDeclaredParameterizedTypes();
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
			case TypesPackage.MEMBER__DECLARING_TYPE:
				setDeclaringType((DeclaredType)newValue);
				return;
			case TypesPackage.MEMBER__VISIBILITY:
				setVisibility((Visibility)newValue);
				return;
			case TypesPackage.MEMBER__FULLY_QUALIFIED_NAME:
				setFullyQualifiedName((String)newValue);
				return;
			case TypesPackage.MEMBER__DECLARED_PARAMETERIZED_TYPES:
				getDeclaredParameterizedTypes().clear();
				getDeclaredParameterizedTypes().addAll((Collection<? extends ParameterizedType>)newValue);
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
			case TypesPackage.MEMBER__DECLARING_TYPE:
				setDeclaringType((DeclaredType)null);
				return;
			case TypesPackage.MEMBER__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case TypesPackage.MEMBER__FULLY_QUALIFIED_NAME:
				setFullyQualifiedName(FULLY_QUALIFIED_NAME_EDEFAULT);
				return;
			case TypesPackage.MEMBER__DECLARED_PARAMETERIZED_TYPES:
				getDeclaredParameterizedTypes().clear();
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
			case TypesPackage.MEMBER__DECLARING_TYPE:
				return getDeclaringType() != null;
			case TypesPackage.MEMBER__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case TypesPackage.MEMBER__FULLY_QUALIFIED_NAME:
				return FULLY_QUALIFIED_NAME_EDEFAULT == null ? fullyQualifiedName != null : !FULLY_QUALIFIED_NAME_EDEFAULT.equals(fullyQualifiedName);
			case TypesPackage.MEMBER__DECLARED_PARAMETERIZED_TYPES:
				return declaredParameterizedTypes != null && !declaredParameterizedTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (visibility: ");
		result.append(visibility);
		result.append(", fullyQualifiedName: ");
		result.append(fullyQualifiedName);
		result.append(')');
		return result.toString();
	}


} //MemberImpl
