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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmAnnotationReferenceImpl#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmAnnotationReferenceImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmAnnotationReferenceImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JvmAnnotationReferenceImpl extends MinimalEObjectImpl.Container implements JvmAnnotationReference {
	/**
	 * The cached value of the '{@link #getAnnotation() <em>Annotation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotation()
	 * @generated
	 * @ordered
	 */
	protected JvmAnnotationType annotation;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmAnnotationValue> values;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmAnnotationReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.JVM_ANNOTATION_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmAnnotationType getAnnotation() {
		if (annotation != null && annotation.eIsProxy()) {
			InternalEObject oldAnnotation = (InternalEObject)annotation;
			annotation = (JvmAnnotationType)eResolveProxy(oldAnnotation);
			if (annotation != oldAnnotation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypesPackage.JVM_ANNOTATION_REFERENCE__ANNOTATION, oldAnnotation, annotation));
			}
		}
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmAnnotationType basicGetAnnotation() {
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotation(JvmAnnotationType newAnnotation) {
		JvmAnnotationType oldAnnotation = annotation;
		annotation = newAnnotation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_ANNOTATION_REFERENCE__ANNOTATION, oldAnnotation, annotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmAnnotationTarget getTarget() {
		if (eContainerFeatureID() != TypesPackage.JVM_ANNOTATION_REFERENCE__TARGET) return null;
		return (JvmAnnotationTarget)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(JvmAnnotationTarget newTarget, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTarget, TypesPackage.JVM_ANNOTATION_REFERENCE__TARGET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(JvmAnnotationTarget newTarget) {
		if (newTarget != eInternalContainer() || (eContainerFeatureID() != TypesPackage.JVM_ANNOTATION_REFERENCE__TARGET && newTarget != null)) {
			if (EcoreUtil.isAncestor(this, newTarget))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, TypesPackage.JVM_ANNOTATION_TARGET__ANNOTATIONS, JvmAnnotationTarget.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_ANNOTATION_REFERENCE__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmAnnotationValue> getValues() {
		if (values == null) {
			values = new EObjectContainmentEList<JvmAnnotationValue>(JvmAnnotationValue.class, this, TypesPackage.JVM_ANNOTATION_REFERENCE__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.JVM_ANNOTATION_REFERENCE__TARGET:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTarget((JvmAnnotationTarget)otherEnd, msgs);
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
			case TypesPackage.JVM_ANNOTATION_REFERENCE__TARGET:
				return basicSetTarget(null, msgs);
			case TypesPackage.JVM_ANNOTATION_REFERENCE__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
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
			case TypesPackage.JVM_ANNOTATION_REFERENCE__TARGET:
				return eInternalContainer().eInverseRemove(this, TypesPackage.JVM_ANNOTATION_TARGET__ANNOTATIONS, JvmAnnotationTarget.class, msgs);
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
			case TypesPackage.JVM_ANNOTATION_REFERENCE__ANNOTATION:
				if (resolve) return getAnnotation();
				return basicGetAnnotation();
			case TypesPackage.JVM_ANNOTATION_REFERENCE__TARGET:
				return getTarget();
			case TypesPackage.JVM_ANNOTATION_REFERENCE__VALUES:
				return getValues();
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
			case TypesPackage.JVM_ANNOTATION_REFERENCE__ANNOTATION:
				setAnnotation((JvmAnnotationType)newValue);
				return;
			case TypesPackage.JVM_ANNOTATION_REFERENCE__TARGET:
				setTarget((JvmAnnotationTarget)newValue);
				return;
			case TypesPackage.JVM_ANNOTATION_REFERENCE__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends JvmAnnotationValue>)newValue);
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
			case TypesPackage.JVM_ANNOTATION_REFERENCE__ANNOTATION:
				setAnnotation((JvmAnnotationType)null);
				return;
			case TypesPackage.JVM_ANNOTATION_REFERENCE__TARGET:
				setTarget((JvmAnnotationTarget)null);
				return;
			case TypesPackage.JVM_ANNOTATION_REFERENCE__VALUES:
				getValues().clear();
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
			case TypesPackage.JVM_ANNOTATION_REFERENCE__ANNOTATION:
				return annotation != null;
			case TypesPackage.JVM_ANNOTATION_REFERENCE__TARGET:
				return getTarget() != null;
			case TypesPackage.JVM_ANNOTATION_REFERENCE__VALUES:
				return values != null && !values.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AnnotationReferenceImpl
