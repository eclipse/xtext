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

import org.eclipse.xtext.common.types.Member;
import org.eclipse.xtext.common.types.ParameterizedType;
import org.eclipse.xtext.common.types.Type;
import org.eclipse.xtext.common.types.TypeArgument;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameterized Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.ParameterizedTypeImpl#getFullyQualifiedName <em>Fully Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.ParameterizedTypeImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.ParameterizedTypeImpl#getDeclarator <em>Declarator</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.ParameterizedTypeImpl#getRawType <em>Raw Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterizedTypeImpl extends ComponentTypeImpl implements ParameterizedType {
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
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeArgument> arguments;

	/**
	 * The cached value of the '{@link #getRawType() <em>Raw Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawType()
	 * @generated
	 * @ordered
	 */
	protected Type rawType;

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
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.PARAMETERIZED_TYPE__FULLY_QUALIFIED_NAME, oldFullyQualifiedName, fullyQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeArgument> getArguments() {
		if (arguments == null) {
			arguments = new EObjectContainmentWithInverseEList<TypeArgument>(TypeArgument.class, this, TypesPackage.PARAMETERIZED_TYPE__ARGUMENTS, TypesPackage.TYPE_ARGUMENT__DECLARATOR);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Member getDeclarator() {
		if (eContainerFeatureID() != TypesPackage.PARAMETERIZED_TYPE__DECLARATOR) return null;
		return (Member)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclarator(Member newDeclarator, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDeclarator, TypesPackage.PARAMETERIZED_TYPE__DECLARATOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclarator(Member newDeclarator) {
		if (newDeclarator != eInternalContainer() || (eContainerFeatureID() != TypesPackage.PARAMETERIZED_TYPE__DECLARATOR && newDeclarator != null)) {
			if (EcoreUtil.isAncestor(this, newDeclarator))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDeclarator != null)
				msgs = ((InternalEObject)newDeclarator).eInverseAdd(this, TypesPackage.MEMBER__DECLARED_PARAMETERIZED_TYPES, Member.class, msgs);
			msgs = basicSetDeclarator(newDeclarator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.PARAMETERIZED_TYPE__DECLARATOR, newDeclarator, newDeclarator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getRawType() {
		if (rawType != null && rawType.eIsProxy()) {
			InternalEObject oldRawType = (InternalEObject)rawType;
			rawType = (Type)eResolveProxy(oldRawType);
			if (rawType != oldRawType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypesPackage.PARAMETERIZED_TYPE__RAW_TYPE, oldRawType, rawType));
			}
		}
		return rawType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetRawType() {
		return rawType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawType(Type newRawType) {
		Type oldRawType = rawType;
		rawType = newRawType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.PARAMETERIZED_TYPE__RAW_TYPE, oldRawType, rawType));
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
			case TypesPackage.PARAMETERIZED_TYPE__ARGUMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getArguments()).basicAdd(otherEnd, msgs);
			case TypesPackage.PARAMETERIZED_TYPE__DECLARATOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDeclarator((Member)otherEnd, msgs);
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
			case TypesPackage.PARAMETERIZED_TYPE__ARGUMENTS:
				return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
			case TypesPackage.PARAMETERIZED_TYPE__DECLARATOR:
				return basicSetDeclarator(null, msgs);
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
			case TypesPackage.PARAMETERIZED_TYPE__DECLARATOR:
				return eInternalContainer().eInverseRemove(this, TypesPackage.MEMBER__DECLARED_PARAMETERIZED_TYPES, Member.class, msgs);
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
			case TypesPackage.PARAMETERIZED_TYPE__FULLY_QUALIFIED_NAME:
				return getFullyQualifiedName();
			case TypesPackage.PARAMETERIZED_TYPE__ARGUMENTS:
				return getArguments();
			case TypesPackage.PARAMETERIZED_TYPE__DECLARATOR:
				return getDeclarator();
			case TypesPackage.PARAMETERIZED_TYPE__RAW_TYPE:
				if (resolve) return getRawType();
				return basicGetRawType();
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
			case TypesPackage.PARAMETERIZED_TYPE__FULLY_QUALIFIED_NAME:
				setFullyQualifiedName((String)newValue);
				return;
			case TypesPackage.PARAMETERIZED_TYPE__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection<? extends TypeArgument>)newValue);
				return;
			case TypesPackage.PARAMETERIZED_TYPE__DECLARATOR:
				setDeclarator((Member)newValue);
				return;
			case TypesPackage.PARAMETERIZED_TYPE__RAW_TYPE:
				setRawType((Type)newValue);
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
			case TypesPackage.PARAMETERIZED_TYPE__FULLY_QUALIFIED_NAME:
				setFullyQualifiedName(FULLY_QUALIFIED_NAME_EDEFAULT);
				return;
			case TypesPackage.PARAMETERIZED_TYPE__ARGUMENTS:
				getArguments().clear();
				return;
			case TypesPackage.PARAMETERIZED_TYPE__DECLARATOR:
				setDeclarator((Member)null);
				return;
			case TypesPackage.PARAMETERIZED_TYPE__RAW_TYPE:
				setRawType((Type)null);
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
			case TypesPackage.PARAMETERIZED_TYPE__FULLY_QUALIFIED_NAME:
				return FULLY_QUALIFIED_NAME_EDEFAULT == null ? fullyQualifiedName != null : !FULLY_QUALIFIED_NAME_EDEFAULT.equals(fullyQualifiedName);
			case TypesPackage.PARAMETERIZED_TYPE__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
			case TypesPackage.PARAMETERIZED_TYPE__DECLARATOR:
				return getDeclarator() != null;
			case TypesPackage.PARAMETERIZED_TYPE__RAW_TYPE:
				return rawType != null;
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
		result.append(" (fullyQualifiedName: ");
		result.append(fullyQualifiedName);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getCanonicalName() {
		return fullyQualifiedName;
	}

} //ParameterizedTypeImpl
