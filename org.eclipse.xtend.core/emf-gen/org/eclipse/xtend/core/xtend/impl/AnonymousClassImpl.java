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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;

import org.eclipse.xtext.common.types.JvmVisibility;

import org.eclipse.xtext.xbase.XConstructorCall;

import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;

import org.eclipse.xtext.xbase.impl.XExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Anonymous Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.AnonymousClassImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.AnonymousClassImpl#getAnnotationInfo <em>Annotation Info</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.AnonymousClassImpl#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.AnonymousClassImpl#getDeclaringType <em>Declaring Type</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.AnonymousClassImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.AnonymousClassImpl#getMembers <em>Members</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.AnonymousClassImpl#getConstructorCall <em>Constructor Call</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnonymousClassImpl extends XExpressionImpl implements AnonymousClass
{
	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<XAnnotation> annotations;

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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMembers() <em>Members</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected EList<XtendMember> members;

	/**
	 * The cached value of the '{@link #getConstructorCall() <em>Constructor Call</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstructorCall()
	 * @generated
	 * @ordered
	 */
	protected XConstructorCall constructorCall;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnonymousClassImpl()
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
		return XtendPackage.Literals.ANONYMOUS_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<XAnnotation> getAnnotations()
	{
		if (annotations == null)
		{
			annotations = new EObjectContainmentEList<XAnnotation>(XAnnotation.class, this, XtendPackage.ANONYMOUS_CLASS__ANNOTATIONS);
		}
		return annotations;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtendPackage.ANONYMOUS_CLASS__ANNOTATION_INFO, oldAnnotationInfo, newAnnotationInfo);
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
				msgs = ((InternalEObject)annotationInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtendPackage.ANONYMOUS_CLASS__ANNOTATION_INFO, null, msgs);
			if (newAnnotationInfo != null)
				msgs = ((InternalEObject)newAnnotationInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtendPackage.ANONYMOUS_CLASS__ANNOTATION_INFO, null, msgs);
			msgs = basicSetAnnotationInfo(newAnnotationInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.ANONYMOUS_CLASS__ANNOTATION_INFO, newAnnotationInfo, newAnnotationInfo));
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
			modifiers = new EDataTypeEList<String>(String.class, this, XtendPackage.ANONYMOUS_CLASS__MODIFIERS);
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
		if (eContainerFeatureID() != XtendPackage.ANONYMOUS_CLASS__DECLARING_TYPE) return null;
		return (XtendTypeDeclaration)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaringType(XtendTypeDeclaration newDeclaringType, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newDeclaringType, XtendPackage.ANONYMOUS_CLASS__DECLARING_TYPE, msgs);
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
		if (newDeclaringType != eInternalContainer() || (eContainerFeatureID() != XtendPackage.ANONYMOUS_CLASS__DECLARING_TYPE && newDeclaringType != null))
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
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.ANONYMOUS_CLASS__DECLARING_TYPE, newDeclaringType, newDeclaringType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.ANONYMOUS_CLASS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<XtendMember> getMembers()
	{
		if (members == null)
		{
			members = new EObjectContainmentWithInverseEList<XtendMember>(XtendMember.class, this, XtendPackage.ANONYMOUS_CLASS__MEMBERS, XtendPackage.XTEND_MEMBER__DECLARING_TYPE);
		}
		return members;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XConstructorCall getConstructorCall()
	{
		return constructorCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstructorCall(XConstructorCall newConstructorCall, NotificationChain msgs)
	{
		XConstructorCall oldConstructorCall = constructorCall;
		constructorCall = newConstructorCall;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtendPackage.ANONYMOUS_CLASS__CONSTRUCTOR_CALL, oldConstructorCall, newConstructorCall);
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
	public void setConstructorCall(XConstructorCall newConstructorCall)
	{
		if (newConstructorCall != constructorCall)
		{
			NotificationChain msgs = null;
			if (constructorCall != null)
				msgs = ((InternalEObject)constructorCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtendPackage.ANONYMOUS_CLASS__CONSTRUCTOR_CALL, null, msgs);
			if (newConstructorCall != null)
				msgs = ((InternalEObject)newConstructorCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtendPackage.ANONYMOUS_CLASS__CONSTRUCTOR_CALL, null, msgs);
			msgs = basicSetConstructorCall(newConstructorCall, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.ANONYMOUS_CLASS__CONSTRUCTOR_CALL, newConstructorCall, newConstructorCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAnonymous()
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
	public boolean isLocal()
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case XtendPackage.ANONYMOUS_CLASS__DECLARING_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDeclaringType((XtendTypeDeclaration)otherEnd, msgs);
			case XtendPackage.ANONYMOUS_CLASS__MEMBERS:
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case XtendPackage.ANONYMOUS_CLASS__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case XtendPackage.ANONYMOUS_CLASS__ANNOTATION_INFO:
				return basicSetAnnotationInfo(null, msgs);
			case XtendPackage.ANONYMOUS_CLASS__DECLARING_TYPE:
				return basicSetDeclaringType(null, msgs);
			case XtendPackage.ANONYMOUS_CLASS__MEMBERS:
				return ((InternalEList<?>)getMembers()).basicRemove(otherEnd, msgs);
			case XtendPackage.ANONYMOUS_CLASS__CONSTRUCTOR_CALL:
				return basicSetConstructorCall(null, msgs);
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
			case XtendPackage.ANONYMOUS_CLASS__DECLARING_TYPE:
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
			case XtendPackage.ANONYMOUS_CLASS__ANNOTATIONS:
				return getAnnotations();
			case XtendPackage.ANONYMOUS_CLASS__ANNOTATION_INFO:
				return getAnnotationInfo();
			case XtendPackage.ANONYMOUS_CLASS__MODIFIERS:
				return getModifiers();
			case XtendPackage.ANONYMOUS_CLASS__DECLARING_TYPE:
				return getDeclaringType();
			case XtendPackage.ANONYMOUS_CLASS__NAME:
				return getName();
			case XtendPackage.ANONYMOUS_CLASS__MEMBERS:
				return getMembers();
			case XtendPackage.ANONYMOUS_CLASS__CONSTRUCTOR_CALL:
				return getConstructorCall();
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
			case XtendPackage.ANONYMOUS_CLASS__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends XAnnotation>)newValue);
				return;
			case XtendPackage.ANONYMOUS_CLASS__ANNOTATION_INFO:
				setAnnotationInfo((XtendAnnotationTarget)newValue);
				return;
			case XtendPackage.ANONYMOUS_CLASS__MODIFIERS:
				getModifiers().clear();
				getModifiers().addAll((Collection<? extends String>)newValue);
				return;
			case XtendPackage.ANONYMOUS_CLASS__DECLARING_TYPE:
				setDeclaringType((XtendTypeDeclaration)newValue);
				return;
			case XtendPackage.ANONYMOUS_CLASS__NAME:
				setName((String)newValue);
				return;
			case XtendPackage.ANONYMOUS_CLASS__MEMBERS:
				getMembers().clear();
				getMembers().addAll((Collection<? extends XtendMember>)newValue);
				return;
			case XtendPackage.ANONYMOUS_CLASS__CONSTRUCTOR_CALL:
				setConstructorCall((XConstructorCall)newValue);
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
			case XtendPackage.ANONYMOUS_CLASS__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case XtendPackage.ANONYMOUS_CLASS__ANNOTATION_INFO:
				setAnnotationInfo((XtendAnnotationTarget)null);
				return;
			case XtendPackage.ANONYMOUS_CLASS__MODIFIERS:
				getModifiers().clear();
				return;
			case XtendPackage.ANONYMOUS_CLASS__DECLARING_TYPE:
				setDeclaringType((XtendTypeDeclaration)null);
				return;
			case XtendPackage.ANONYMOUS_CLASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case XtendPackage.ANONYMOUS_CLASS__MEMBERS:
				getMembers().clear();
				return;
			case XtendPackage.ANONYMOUS_CLASS__CONSTRUCTOR_CALL:
				setConstructorCall((XConstructorCall)null);
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
			case XtendPackage.ANONYMOUS_CLASS__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case XtendPackage.ANONYMOUS_CLASS__ANNOTATION_INFO:
				return annotationInfo != null;
			case XtendPackage.ANONYMOUS_CLASS__MODIFIERS:
				return modifiers != null && !modifiers.isEmpty();
			case XtendPackage.ANONYMOUS_CLASS__DECLARING_TYPE:
				return getDeclaringType() != null;
			case XtendPackage.ANONYMOUS_CLASS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case XtendPackage.ANONYMOUS_CLASS__MEMBERS:
				return members != null && !members.isEmpty();
			case XtendPackage.ANONYMOUS_CLASS__CONSTRUCTOR_CALL:
				return constructorCall != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == XtendAnnotationTarget.class)
		{
			switch (derivedFeatureID)
			{
				case XtendPackage.ANONYMOUS_CLASS__ANNOTATIONS: return XtendPackage.XTEND_ANNOTATION_TARGET__ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == XtendMember.class)
		{
			switch (derivedFeatureID)
			{
				case XtendPackage.ANONYMOUS_CLASS__ANNOTATION_INFO: return XtendPackage.XTEND_MEMBER__ANNOTATION_INFO;
				case XtendPackage.ANONYMOUS_CLASS__MODIFIERS: return XtendPackage.XTEND_MEMBER__MODIFIERS;
				case XtendPackage.ANONYMOUS_CLASS__DECLARING_TYPE: return XtendPackage.XTEND_MEMBER__DECLARING_TYPE;
				default: return -1;
			}
		}
		if (baseClass == XtendTypeDeclaration.class)
		{
			switch (derivedFeatureID)
			{
				case XtendPackage.ANONYMOUS_CLASS__NAME: return XtendPackage.XTEND_TYPE_DECLARATION__NAME;
				case XtendPackage.ANONYMOUS_CLASS__MEMBERS: return XtendPackage.XTEND_TYPE_DECLARATION__MEMBERS;
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
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == XtendAnnotationTarget.class)
		{
			switch (baseFeatureID)
			{
				case XtendPackage.XTEND_ANNOTATION_TARGET__ANNOTATIONS: return XtendPackage.ANONYMOUS_CLASS__ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == XtendMember.class)
		{
			switch (baseFeatureID)
			{
				case XtendPackage.XTEND_MEMBER__ANNOTATION_INFO: return XtendPackage.ANONYMOUS_CLASS__ANNOTATION_INFO;
				case XtendPackage.XTEND_MEMBER__MODIFIERS: return XtendPackage.ANONYMOUS_CLASS__MODIFIERS;
				case XtendPackage.XTEND_MEMBER__DECLARING_TYPE: return XtendPackage.ANONYMOUS_CLASS__DECLARING_TYPE;
				default: return -1;
			}
		}
		if (baseClass == XtendTypeDeclaration.class)
		{
			switch (baseFeatureID)
			{
				case XtendPackage.XTEND_TYPE_DECLARATION__NAME: return XtendPackage.ANONYMOUS_CLASS__NAME;
				case XtendPackage.XTEND_TYPE_DECLARATION__MEMBERS: return XtendPackage.ANONYMOUS_CLASS__MEMBERS;
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
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (modifiers: ");
		result.append(modifiers);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //AnonymousClassImpl
