/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.annotations.xAnnotations.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmType;

import org.eclipse.xtext.xbase.XExpression;

import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;

import org.eclipse.xtext.xbase.impl.XExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XAnnotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationImpl#getElementValuePairs <em>Element Value Pairs</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationImpl#getAnnotationType <em>Annotation Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @since 2.7
 * @generated
 */
public class XAnnotationImpl extends XExpressionImpl implements XAnnotation
{
	/**
	 * The cached value of the '{@link #getElementValuePairs() <em>Element Value Pairs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementValuePairs()
	 * @generated
	 * @ordered
	 */
	protected EList<XAnnotationElementValuePair> elementValuePairs;

	/**
	 * The cached value of the '{@link #getAnnotationType() <em>Annotation Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotationType()
	 * @generated
	 * @ordered
	 */
	protected JvmType annotationType;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected XExpression value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XAnnotationImpl()
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
		return XAnnotationsPackage.Literals.XANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<XAnnotationElementValuePair> getElementValuePairs()
	{
		if (elementValuePairs == null)
		{
			elementValuePairs = new EObjectContainmentEList<XAnnotationElementValuePair>(XAnnotationElementValuePair.class, this, XAnnotationsPackage.XANNOTATION__ELEMENT_VALUE_PAIRS);
		}
		return elementValuePairs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JvmType getAnnotationType()
	{
		if (annotationType != null && annotationType.eIsProxy())
		{
			InternalEObject oldAnnotationType = (InternalEObject)annotationType;
			annotationType = (JvmType)eResolveProxy(oldAnnotationType);
			if (annotationType != oldAnnotationType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XAnnotationsPackage.XANNOTATION__ANNOTATION_TYPE, oldAnnotationType, annotationType));
			}
		}
		return annotationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmType basicGetAnnotationType()
	{
		return annotationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAnnotationType(JvmType newAnnotationType)
	{
		JvmType oldAnnotationType = annotationType;
		annotationType = newAnnotationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XAnnotationsPackage.XANNOTATION__ANNOTATION_TYPE, oldAnnotationType, annotationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XExpression getValue()
	{
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(XExpression newValue, NotificationChain msgs)
	{
		XExpression oldValue = value;
		value = newValue;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XAnnotationsPackage.XANNOTATION__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(XExpression newValue)
	{
		if (newValue != value)
		{
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XAnnotationsPackage.XANNOTATION__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XAnnotationsPackage.XANNOTATION__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XAnnotationsPackage.XANNOTATION__VALUE, newValue, newValue));
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
			case XAnnotationsPackage.XANNOTATION__ELEMENT_VALUE_PAIRS:
				return ((InternalEList<?>)getElementValuePairs()).basicRemove(otherEnd, msgs);
			case XAnnotationsPackage.XANNOTATION__VALUE:
				return basicSetValue(null, msgs);
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
			case XAnnotationsPackage.XANNOTATION__ELEMENT_VALUE_PAIRS:
				return getElementValuePairs();
			case XAnnotationsPackage.XANNOTATION__ANNOTATION_TYPE:
				if (resolve) return getAnnotationType();
				return basicGetAnnotationType();
			case XAnnotationsPackage.XANNOTATION__VALUE:
				return getValue();
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
			case XAnnotationsPackage.XANNOTATION__ELEMENT_VALUE_PAIRS:
				getElementValuePairs().clear();
				getElementValuePairs().addAll((Collection<? extends XAnnotationElementValuePair>)newValue);
				return;
			case XAnnotationsPackage.XANNOTATION__ANNOTATION_TYPE:
				setAnnotationType((JvmType)newValue);
				return;
			case XAnnotationsPackage.XANNOTATION__VALUE:
				setValue((XExpression)newValue);
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
			case XAnnotationsPackage.XANNOTATION__ELEMENT_VALUE_PAIRS:
				getElementValuePairs().clear();
				return;
			case XAnnotationsPackage.XANNOTATION__ANNOTATION_TYPE:
				setAnnotationType((JvmType)null);
				return;
			case XAnnotationsPackage.XANNOTATION__VALUE:
				setValue((XExpression)null);
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
			case XAnnotationsPackage.XANNOTATION__ELEMENT_VALUE_PAIRS:
				return elementValuePairs != null && !elementValuePairs.isEmpty();
			case XAnnotationsPackage.XANNOTATION__ANNOTATION_TYPE:
				return annotationType != null;
			case XAnnotationsPackage.XANNOTATION__VALUE:
				return value != null;
		}
		return super.eIsSet(featureID);
	}

} //XAnnotationImpl
