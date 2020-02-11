/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.xtend.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;

import org.eclipse.xtext.common.types.JvmVisibility;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.XtendMemberImpl#getAnnotationInfo <em>Annotation Info</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.XtendMemberImpl#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.XtendMemberImpl#getDeclaringType <em>Declaring Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XtendMemberImpl extends XtendAnnotationTargetImpl implements XtendMember
{
	/**
	 * The cached value of the '{@link #getAnnotationInfo() <em>Annotation Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotationInfo()
	 * @generated
	 * @ordered
	 */
	protected XtendAnnotationTarget annotationInfo;

	/**
	 * The cached value of the '{@link #getModifiers() <em>Modifiers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<String> modifiers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XtendMemberImpl()
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
		return XtendPackage.Literals.XTEND_MEMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtendAnnotationTarget getAnnotationInfo()
	{
		return annotationInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnnotationInfo(XtendAnnotationTarget newAnnotationInfo, NotificationChain msgs)
	{
		XtendAnnotationTarget oldAnnotationInfo = annotationInfo;
		annotationInfo = newAnnotationInfo;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtendPackage.XTEND_MEMBER__ANNOTATION_INFO, oldAnnotationInfo, newAnnotationInfo);
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
	public void setAnnotationInfo(XtendAnnotationTarget newAnnotationInfo)
	{
		if (newAnnotationInfo != annotationInfo)
		{
			NotificationChain msgs = null;
			if (annotationInfo != null)
				msgs = ((InternalEObject)annotationInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtendPackage.XTEND_MEMBER__ANNOTATION_INFO, null, msgs);
			if (newAnnotationInfo != null)
				msgs = ((InternalEObject)newAnnotationInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtendPackage.XTEND_MEMBER__ANNOTATION_INFO, null, msgs);
			msgs = basicSetAnnotationInfo(newAnnotationInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.XTEND_MEMBER__ANNOTATION_INFO, newAnnotationInfo, newAnnotationInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getModifiers()
	{
		if (modifiers == null)
		{
			modifiers = new EDataTypeEList<String>(String.class, this, XtendPackage.XTEND_MEMBER__MODIFIERS);
		}
		return modifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtendTypeDeclaration getDeclaringType()
	{
		if (eContainerFeatureID() != XtendPackage.XTEND_MEMBER__DECLARING_TYPE) return null;
		return (XtendTypeDeclaration)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaringType(XtendTypeDeclaration newDeclaringType, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newDeclaringType, XtendPackage.XTEND_MEMBER__DECLARING_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeclaringType(XtendTypeDeclaration newDeclaringType)
	{
		if (newDeclaringType != eInternalContainer() || (eContainerFeatureID() != XtendPackage.XTEND_MEMBER__DECLARING_TYPE && newDeclaringType != null))
		{
			if (EcoreUtil.isAncestor(this, newDeclaringType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDeclaringType != null)
				msgs = ((InternalEObject)newDeclaringType).eInverseAdd(this, XtendPackage.XTEND_TYPE_DECLARATION__MEMBERS, XtendTypeDeclaration.class, msgs);
			msgs = basicSetDeclaringType(newDeclaringType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.XTEND_MEMBER__DECLARING_TYPE, newDeclaringType, newDeclaringType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JvmVisibility getVisibility()
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
	public JvmVisibility getDeclaredVisibility()
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
	public boolean isStatic()
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
	public boolean isFinal()
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case XtendPackage.XTEND_MEMBER__DECLARING_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDeclaringType((XtendTypeDeclaration)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case XtendPackage.XTEND_MEMBER__ANNOTATION_INFO:
				return basicSetAnnotationInfo(null, msgs);
			case XtendPackage.XTEND_MEMBER__DECLARING_TYPE:
				return basicSetDeclaringType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case XtendPackage.XTEND_MEMBER__DECLARING_TYPE:
				return eInternalContainer().eInverseRemove(this, XtendPackage.XTEND_TYPE_DECLARATION__MEMBERS, XtendTypeDeclaration.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case XtendPackage.XTEND_MEMBER__ANNOTATION_INFO:
				return getAnnotationInfo();
			case XtendPackage.XTEND_MEMBER__MODIFIERS:
				return getModifiers();
			case XtendPackage.XTEND_MEMBER__DECLARING_TYPE:
				return getDeclaringType();
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
			case XtendPackage.XTEND_MEMBER__ANNOTATION_INFO:
				setAnnotationInfo((XtendAnnotationTarget)newValue);
				return;
			case XtendPackage.XTEND_MEMBER__MODIFIERS:
				getModifiers().clear();
				getModifiers().addAll((Collection<? extends String>)newValue);
				return;
			case XtendPackage.XTEND_MEMBER__DECLARING_TYPE:
				setDeclaringType((XtendTypeDeclaration)newValue);
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
			case XtendPackage.XTEND_MEMBER__ANNOTATION_INFO:
				setAnnotationInfo((XtendAnnotationTarget)null);
				return;
			case XtendPackage.XTEND_MEMBER__MODIFIERS:
				getModifiers().clear();
				return;
			case XtendPackage.XTEND_MEMBER__DECLARING_TYPE:
				setDeclaringType((XtendTypeDeclaration)null);
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
			case XtendPackage.XTEND_MEMBER__ANNOTATION_INFO:
				return annotationInfo != null;
			case XtendPackage.XTEND_MEMBER__MODIFIERS:
				return modifiers != null && !modifiers.isEmpty();
			case XtendPackage.XTEND_MEMBER__DECLARING_TYPE:
				return getDeclaringType() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (modifiers: ");
		result.append(modifiers);
		result.append(')');
		return result.toString();
	}

} //XtendMemberImpl
