/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtype.impl;

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
import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.common.types.impl.JvmSpecializedTypeReferenceImplCustom;

import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XFunction Type Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl#getParamTypes <em>Param Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl#isInstanceContext <em>Instance Context</em>}</li>
 * </ul>
 *
 * @since 2.7
 * @generated
 */
public class XFunctionTypeRefImpl extends JvmSpecializedTypeReferenceImplCustom implements XFunctionTypeRef
{
	/**
	 * The cached value of the '{@link #getParamTypes() <em>Param Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParamTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeReference> paramTypes;

	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference returnType;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected JvmType type;

	/**
	 * The default value of the '{@link #isInstanceContext() <em>Instance Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInstanceContext()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INSTANCE_CONTEXT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInstanceContext() <em>Instance Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInstanceContext()
	 * @generated
	 * @ordered
	 */
	protected boolean instanceContext = INSTANCE_CONTEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XFunctionTypeRefImpl()
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
		return XtypePackage.Literals.XFUNCTION_TYPE_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<JvmTypeReference> getParamTypes()
	{
		if (paramTypes == null)
		{
			paramTypes = new EObjectContainmentEList<JvmTypeReference>(JvmTypeReference.class, this, XtypePackage.XFUNCTION_TYPE_REF__PARAM_TYPES);
		}
		return paramTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JvmTypeReference getReturnType()
	{
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturnType(JvmTypeReference newReturnType, NotificationChain msgs)
	{
		JvmTypeReference oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE, oldReturnType, newReturnType);
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
	public void setReturnType(JvmTypeReference newReturnType)
	{
		if (newReturnType != returnType)
		{
			NotificationChain msgs = null;
			if (returnType != null)
				msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE, null, msgs);
			if (newReturnType != null)
				msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE, null, msgs);
			msgs = basicSetReturnType(newReturnType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE, newReturnType, newReturnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JvmType getType()
	{
		if (type != null && type.eIsProxy())
		{
			InternalEObject oldType = (InternalEObject)type;
			type = (JvmType)eResolveProxy(oldType);
			if (type != oldType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XtypePackage.XFUNCTION_TYPE_REF__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmType basicGetType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(JvmType newType)
	{
		JvmType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtypePackage.XFUNCTION_TYPE_REF__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isInstanceContext()
	{
		return instanceContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstanceContext(boolean newInstanceContext)
	{
		boolean oldInstanceContext = instanceContext;
		instanceContext = newInstanceContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtypePackage.XFUNCTION_TYPE_REF__INSTANCE_CONTEXT, oldInstanceContext, instanceContext));
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
			case XtypePackage.XFUNCTION_TYPE_REF__PARAM_TYPES:
				return ((InternalEList<?>)getParamTypes()).basicRemove(otherEnd, msgs);
			case XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE:
				return basicSetReturnType(null, msgs);
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
			case XtypePackage.XFUNCTION_TYPE_REF__PARAM_TYPES:
				return getParamTypes();
			case XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE:
				return getReturnType();
			case XtypePackage.XFUNCTION_TYPE_REF__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case XtypePackage.XFUNCTION_TYPE_REF__INSTANCE_CONTEXT:
				return isInstanceContext();
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
			case XtypePackage.XFUNCTION_TYPE_REF__PARAM_TYPES:
				getParamTypes().clear();
				getParamTypes().addAll((Collection<? extends JvmTypeReference>)newValue);
				return;
			case XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE:
				setReturnType((JvmTypeReference)newValue);
				return;
			case XtypePackage.XFUNCTION_TYPE_REF__TYPE:
				setType((JvmType)newValue);
				return;
			case XtypePackage.XFUNCTION_TYPE_REF__INSTANCE_CONTEXT:
				setInstanceContext((Boolean)newValue);
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
			case XtypePackage.XFUNCTION_TYPE_REF__PARAM_TYPES:
				getParamTypes().clear();
				return;
			case XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE:
				setReturnType((JvmTypeReference)null);
				return;
			case XtypePackage.XFUNCTION_TYPE_REF__TYPE:
				setType((JvmType)null);
				return;
			case XtypePackage.XFUNCTION_TYPE_REF__INSTANCE_CONTEXT:
				setInstanceContext(INSTANCE_CONTEXT_EDEFAULT);
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
			case XtypePackage.XFUNCTION_TYPE_REF__PARAM_TYPES:
				return paramTypes != null && !paramTypes.isEmpty();
			case XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE:
				return returnType != null;
			case XtypePackage.XFUNCTION_TYPE_REF__TYPE:
				return type != null;
			case XtypePackage.XFUNCTION_TYPE_REF__INSTANCE_CONTEXT:
				return instanceContext != INSTANCE_CONTEXT_EDEFAULT;
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
		result.append(" (instanceContext: ");
		result.append(instanceContext);
		result.append(')');
		return result.toString();
	}

} //XFunctionTypeRefImpl
