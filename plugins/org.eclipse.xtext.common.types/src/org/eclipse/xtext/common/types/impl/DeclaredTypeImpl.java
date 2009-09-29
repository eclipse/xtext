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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.AnnotationReference;
import org.eclipse.xtext.common.types.AnnotationTarget;
import org.eclipse.xtext.common.types.DeclaredType;
import org.eclipse.xtext.common.types.Member;
import org.eclipse.xtext.common.types.ParameterizedType;
import org.eclipse.xtext.common.types.Type;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.Visibility;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declared Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.DeclaredTypeImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.DeclaredTypeImpl#getDeclaringType <em>Declaring Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.DeclaredTypeImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.DeclaredTypeImpl#getFullyQualifiedName <em>Fully Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.DeclaredTypeImpl#getDeclaredParameterizedTypes <em>Declared Parameterized Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.DeclaredTypeImpl#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.DeclaredTypeImpl#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DeclaredTypeImpl extends ComponentTypeImpl implements DeclaredType {
	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<AnnotationReference> annotations;

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
	 * The cached value of the '{@link #getSuperTypes() <em>Super Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> superTypes;

	/**
	 * The cached value of the '{@link #getMembers() <em>Members</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected EList<Member> members;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclaredTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.DECLARED_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnotationReference> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentWithInverseEList<AnnotationReference>(AnnotationReference.class, this, TypesPackage.DECLARED_TYPE__ANNOTATIONS, TypesPackage.ANNOTATION_REFERENCE__TARGET);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclaredType getDeclaringType() {
		if (eContainerFeatureID() != TypesPackage.DECLARED_TYPE__DECLARING_TYPE) return null;
		return (DeclaredType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaringType(DeclaredType newDeclaringType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDeclaringType, TypesPackage.DECLARED_TYPE__DECLARING_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaringType(DeclaredType newDeclaringType) {
		if (newDeclaringType != eInternalContainer() || (eContainerFeatureID() != TypesPackage.DECLARED_TYPE__DECLARING_TYPE && newDeclaringType != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.DECLARED_TYPE__DECLARING_TYPE, newDeclaringType, newDeclaringType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.DECLARED_TYPE__FULLY_QUALIFIED_NAME, oldFullyQualifiedName, fullyQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterizedType> getDeclaredParameterizedTypes() {
		if (declaredParameterizedTypes == null) {
			declaredParameterizedTypes = new EObjectContainmentWithInverseEList<ParameterizedType>(ParameterizedType.class, this, TypesPackage.DECLARED_TYPE__DECLARED_PARAMETERIZED_TYPES, TypesPackage.PARAMETERIZED_TYPE__DECLARATOR);
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
		int dollarIdx = fullyQualifiedName.lastIndexOf('$');
		if (dollarIdx != -1) {
			return fullyQualifiedName.substring(dollarIdx + 1);
		}
		int dotIdx = fullyQualifiedName.lastIndexOf('.');
		return fullyQualifiedName.substring(dotIdx + 1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPackageName() {
		if (fullyQualifiedName == null)
			return null;
		int dotIdx = fullyQualifiedName.lastIndexOf('.');
		if (dotIdx == -1)
			return "";
		return fullyQualifiedName.substring(0, dotIdx);
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
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.DECLARED_TYPE__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getSuperTypes() {
		if (superTypes == null) {
			superTypes = new EObjectResolvingEList<Type>(Type.class, this, TypesPackage.DECLARED_TYPE__SUPER_TYPES);
		}
		return superTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Member> getMembers() {
		if (members == null) {
			members = new EObjectContainmentWithInverseEList<Member>(Member.class, this, TypesPackage.DECLARED_TYPE__MEMBERS, TypesPackage.MEMBER__DECLARING_TYPE);
		}
		return members;
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
			case TypesPackage.DECLARED_TYPE__ANNOTATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnnotations()).basicAdd(otherEnd, msgs);
			case TypesPackage.DECLARED_TYPE__DECLARING_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDeclaringType((DeclaredType)otherEnd, msgs);
			case TypesPackage.DECLARED_TYPE__DECLARED_PARAMETERIZED_TYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDeclaredParameterizedTypes()).basicAdd(otherEnd, msgs);
			case TypesPackage.DECLARED_TYPE__MEMBERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMembers()).basicAdd(otherEnd, msgs);
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
			case TypesPackage.DECLARED_TYPE__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case TypesPackage.DECLARED_TYPE__DECLARING_TYPE:
				return basicSetDeclaringType(null, msgs);
			case TypesPackage.DECLARED_TYPE__DECLARED_PARAMETERIZED_TYPES:
				return ((InternalEList<?>)getDeclaredParameterizedTypes()).basicRemove(otherEnd, msgs);
			case TypesPackage.DECLARED_TYPE__MEMBERS:
				return ((InternalEList<?>)getMembers()).basicRemove(otherEnd, msgs);
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
			case TypesPackage.DECLARED_TYPE__DECLARING_TYPE:
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
			case TypesPackage.DECLARED_TYPE__ANNOTATIONS:
				return getAnnotations();
			case TypesPackage.DECLARED_TYPE__DECLARING_TYPE:
				return getDeclaringType();
			case TypesPackage.DECLARED_TYPE__VISIBILITY:
				return getVisibility();
			case TypesPackage.DECLARED_TYPE__FULLY_QUALIFIED_NAME:
				return getFullyQualifiedName();
			case TypesPackage.DECLARED_TYPE__DECLARED_PARAMETERIZED_TYPES:
				return getDeclaredParameterizedTypes();
			case TypesPackage.DECLARED_TYPE__SUPER_TYPES:
				return getSuperTypes();
			case TypesPackage.DECLARED_TYPE__MEMBERS:
				return getMembers();
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
			case TypesPackage.DECLARED_TYPE__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends AnnotationReference>)newValue);
				return;
			case TypesPackage.DECLARED_TYPE__DECLARING_TYPE:
				setDeclaringType((DeclaredType)newValue);
				return;
			case TypesPackage.DECLARED_TYPE__VISIBILITY:
				setVisibility((Visibility)newValue);
				return;
			case TypesPackage.DECLARED_TYPE__FULLY_QUALIFIED_NAME:
				setFullyQualifiedName((String)newValue);
				return;
			case TypesPackage.DECLARED_TYPE__DECLARED_PARAMETERIZED_TYPES:
				getDeclaredParameterizedTypes().clear();
				getDeclaredParameterizedTypes().addAll((Collection<? extends ParameterizedType>)newValue);
				return;
			case TypesPackage.DECLARED_TYPE__SUPER_TYPES:
				getSuperTypes().clear();
				getSuperTypes().addAll((Collection<? extends Type>)newValue);
				return;
			case TypesPackage.DECLARED_TYPE__MEMBERS:
				getMembers().clear();
				getMembers().addAll((Collection<? extends Member>)newValue);
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
			case TypesPackage.DECLARED_TYPE__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case TypesPackage.DECLARED_TYPE__DECLARING_TYPE:
				setDeclaringType((DeclaredType)null);
				return;
			case TypesPackage.DECLARED_TYPE__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case TypesPackage.DECLARED_TYPE__FULLY_QUALIFIED_NAME:
				setFullyQualifiedName(FULLY_QUALIFIED_NAME_EDEFAULT);
				return;
			case TypesPackage.DECLARED_TYPE__DECLARED_PARAMETERIZED_TYPES:
				getDeclaredParameterizedTypes().clear();
				return;
			case TypesPackage.DECLARED_TYPE__SUPER_TYPES:
				getSuperTypes().clear();
				return;
			case TypesPackage.DECLARED_TYPE__MEMBERS:
				getMembers().clear();
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
			case TypesPackage.DECLARED_TYPE__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case TypesPackage.DECLARED_TYPE__DECLARING_TYPE:
				return getDeclaringType() != null;
			case TypesPackage.DECLARED_TYPE__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case TypesPackage.DECLARED_TYPE__FULLY_QUALIFIED_NAME:
				return FULLY_QUALIFIED_NAME_EDEFAULT == null ? fullyQualifiedName != null : !FULLY_QUALIFIED_NAME_EDEFAULT.equals(fullyQualifiedName);
			case TypesPackage.DECLARED_TYPE__DECLARED_PARAMETERIZED_TYPES:
				return declaredParameterizedTypes != null && !declaredParameterizedTypes.isEmpty();
			case TypesPackage.DECLARED_TYPE__SUPER_TYPES:
				return superTypes != null && !superTypes.isEmpty();
			case TypesPackage.DECLARED_TYPE__MEMBERS:
				return members != null && !members.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == AnnotationTarget.class) {
			switch (derivedFeatureID) {
				case TypesPackage.DECLARED_TYPE__ANNOTATIONS: return TypesPackage.ANNOTATION_TARGET__ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == Member.class) {
			switch (derivedFeatureID) {
				case TypesPackage.DECLARED_TYPE__DECLARING_TYPE: return TypesPackage.MEMBER__DECLARING_TYPE;
				case TypesPackage.DECLARED_TYPE__VISIBILITY: return TypesPackage.MEMBER__VISIBILITY;
				case TypesPackage.DECLARED_TYPE__FULLY_QUALIFIED_NAME: return TypesPackage.MEMBER__FULLY_QUALIFIED_NAME;
				case TypesPackage.DECLARED_TYPE__DECLARED_PARAMETERIZED_TYPES: return TypesPackage.MEMBER__DECLARED_PARAMETERIZED_TYPES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == AnnotationTarget.class) {
			switch (baseFeatureID) {
				case TypesPackage.ANNOTATION_TARGET__ANNOTATIONS: return TypesPackage.DECLARED_TYPE__ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == Member.class) {
			switch (baseFeatureID) {
				case TypesPackage.MEMBER__DECLARING_TYPE: return TypesPackage.DECLARED_TYPE__DECLARING_TYPE;
				case TypesPackage.MEMBER__VISIBILITY: return TypesPackage.DECLARED_TYPE__VISIBILITY;
				case TypesPackage.MEMBER__FULLY_QUALIFIED_NAME: return TypesPackage.DECLARED_TYPE__FULLY_QUALIFIED_NAME;
				case TypesPackage.MEMBER__DECLARED_PARAMETERIZED_TYPES: return TypesPackage.DECLARED_TYPE__DECLARED_PARAMETERIZED_TYPES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

	@Override
	public String getCanonicalName() {
		return getFullyQualifiedName();
	}
	
} //DeclaredTypeImpl
