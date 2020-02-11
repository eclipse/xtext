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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtend.core.xtend.XtendExecutable;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendParameter;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Executable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.XtendExecutableImpl#getExceptions <em>Exceptions</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.XtendExecutableImpl#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.XtendExecutableImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.XtendExecutableImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class XtendExecutableImpl extends XtendMemberImplCustom implements XtendExecutable
{
	/**
	 * The cached value of the '{@link #getExceptions() <em>Exceptions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptions()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeReference> exceptions;

	/**
	 * The cached value of the '{@link #getTypeParameters() <em>Type Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeParameter> typeParameters;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression expression;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<XtendParameter> parameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XtendExecutableImpl()
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
		return XtendPackage.Literals.XTEND_EXECUTABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<JvmTypeReference> getExceptions()
	{
		if (exceptions == null)
		{
			exceptions = new EObjectContainmentEList<JvmTypeReference>(JvmTypeReference.class, this, XtendPackage.XTEND_EXECUTABLE__EXCEPTIONS);
		}
		return exceptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<JvmTypeParameter> getTypeParameters()
	{
		if (typeParameters == null)
		{
			typeParameters = new EObjectContainmentEList<JvmTypeParameter>(JvmTypeParameter.class, this, XtendPackage.XTEND_EXECUTABLE__TYPE_PARAMETERS);
		}
		return typeParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XExpression getExpression()
	{
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(XExpression newExpression, NotificationChain msgs)
	{
		XExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtendPackage.XTEND_EXECUTABLE__EXPRESSION, oldExpression, newExpression);
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
	public void setExpression(XExpression newExpression)
	{
		if (newExpression != expression)
		{
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtendPackage.XTEND_EXECUTABLE__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtendPackage.XTEND_EXECUTABLE__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.XTEND_EXECUTABLE__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<XtendParameter> getParameters()
	{
		if (parameters == null)
		{
			parameters = new EObjectContainmentEList<XtendParameter>(XtendParameter.class, this, XtendPackage.XTEND_EXECUTABLE__PARAMETERS);
		}
		return parameters;
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
			case XtendPackage.XTEND_EXECUTABLE__EXCEPTIONS:
				return ((InternalEList<?>)getExceptions()).basicRemove(otherEnd, msgs);
			case XtendPackage.XTEND_EXECUTABLE__TYPE_PARAMETERS:
				return ((InternalEList<?>)getTypeParameters()).basicRemove(otherEnd, msgs);
			case XtendPackage.XTEND_EXECUTABLE__EXPRESSION:
				return basicSetExpression(null, msgs);
			case XtendPackage.XTEND_EXECUTABLE__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case XtendPackage.XTEND_EXECUTABLE__EXCEPTIONS:
				return getExceptions();
			case XtendPackage.XTEND_EXECUTABLE__TYPE_PARAMETERS:
				return getTypeParameters();
			case XtendPackage.XTEND_EXECUTABLE__EXPRESSION:
				return getExpression();
			case XtendPackage.XTEND_EXECUTABLE__PARAMETERS:
				return getParameters();
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
			case XtendPackage.XTEND_EXECUTABLE__EXCEPTIONS:
				getExceptions().clear();
				getExceptions().addAll((Collection<? extends JvmTypeReference>)newValue);
				return;
			case XtendPackage.XTEND_EXECUTABLE__TYPE_PARAMETERS:
				getTypeParameters().clear();
				getTypeParameters().addAll((Collection<? extends JvmTypeParameter>)newValue);
				return;
			case XtendPackage.XTEND_EXECUTABLE__EXPRESSION:
				setExpression((XExpression)newValue);
				return;
			case XtendPackage.XTEND_EXECUTABLE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends XtendParameter>)newValue);
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
			case XtendPackage.XTEND_EXECUTABLE__EXCEPTIONS:
				getExceptions().clear();
				return;
			case XtendPackage.XTEND_EXECUTABLE__TYPE_PARAMETERS:
				getTypeParameters().clear();
				return;
			case XtendPackage.XTEND_EXECUTABLE__EXPRESSION:
				setExpression((XExpression)null);
				return;
			case XtendPackage.XTEND_EXECUTABLE__PARAMETERS:
				getParameters().clear();
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
			case XtendPackage.XTEND_EXECUTABLE__EXCEPTIONS:
				return exceptions != null && !exceptions.isEmpty();
			case XtendPackage.XTEND_EXECUTABLE__TYPE_PARAMETERS:
				return typeParameters != null && !typeParameters.isEmpty();
			case XtendPackage.XTEND_EXECUTABLE__EXPRESSION:
				return expression != null;
			case XtendPackage.XTEND_EXECUTABLE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //XtendExecutableImpl
