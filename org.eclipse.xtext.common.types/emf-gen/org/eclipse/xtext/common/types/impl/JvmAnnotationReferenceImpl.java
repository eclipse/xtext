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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Annotation Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmAnnotationReferenceImpl#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmAnnotationReferenceImpl#getExplicitValues <em>Explicit Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JvmAnnotationReferenceImpl extends MinimalEObjectImpl.Container implements JvmAnnotationReference
{
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
	 * The cached value of the '{@link #getExplicitValues() <em>Explicit Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExplicitValues()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmAnnotationValue> explicitValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmAnnotationReferenceImpl()
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
		return TypesPackage.Literals.JVM_ANNOTATION_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JvmAnnotationType getAnnotation()
	{
		if (annotation != null && annotation.eIsProxy())
		{
			InternalEObject oldAnnotation = (InternalEObject)annotation;
			annotation = (JvmAnnotationType)eResolveProxy(oldAnnotation);
			if (annotation != oldAnnotation)
			{
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
	public JvmAnnotationType basicGetAnnotation()
	{
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAnnotation(JvmAnnotationType newAnnotation)
	{
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
	@Override
	public EList<JvmAnnotationValue> getExplicitValues()
	{
		if (explicitValues == null)
		{
			explicitValues = new EObjectContainmentEList<JvmAnnotationValue>(JvmAnnotationValue.class, this, TypesPackage.JVM_ANNOTATION_REFERENCE__EXPLICIT_VALUES);
		}
		return explicitValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<JvmAnnotationValue> getValues()
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
			case TypesPackage.JVM_ANNOTATION_REFERENCE__EXPLICIT_VALUES:
				return ((InternalEList<?>)getExplicitValues()).basicRemove(otherEnd, msgs);
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
			case TypesPackage.JVM_ANNOTATION_REFERENCE__ANNOTATION:
				if (resolve) return getAnnotation();
				return basicGetAnnotation();
			case TypesPackage.JVM_ANNOTATION_REFERENCE__EXPLICIT_VALUES:
				return getExplicitValues();
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
			case TypesPackage.JVM_ANNOTATION_REFERENCE__ANNOTATION:
				setAnnotation((JvmAnnotationType)newValue);
				return;
			case TypesPackage.JVM_ANNOTATION_REFERENCE__EXPLICIT_VALUES:
				getExplicitValues().clear();
				getExplicitValues().addAll((Collection<? extends JvmAnnotationValue>)newValue);
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
			case TypesPackage.JVM_ANNOTATION_REFERENCE__ANNOTATION:
				setAnnotation((JvmAnnotationType)null);
				return;
			case TypesPackage.JVM_ANNOTATION_REFERENCE__EXPLICIT_VALUES:
				getExplicitValues().clear();
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
			case TypesPackage.JVM_ANNOTATION_REFERENCE__ANNOTATION:
				return annotation != null;
			case TypesPackage.JVM_ANNOTATION_REFERENCE__EXPLICIT_VALUES:
				return explicitValues != null && !explicitValues.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //JvmAnnotationReferenceImpl
