/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.xtend.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendParameter;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.XtendParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.XtendParameterImpl#getParameterType <em>Parameter Type</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.XtendParameterImpl#isVarArg <em>Var Arg</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.XtendParameterImpl#isExtension <em>Extension</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XtendParameterImpl extends XtendAnnotationTargetImpl implements XtendParameter
{
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
	 * The cached value of the '{@link #getParameterType() <em>Parameter Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterType()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference parameterType;

	/**
	 * The default value of the '{@link #isVarArg() <em>Var Arg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVarArg()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VAR_ARG_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVarArg() <em>Var Arg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVarArg()
	 * @generated
	 * @ordered
	 */
	protected boolean varArg = VAR_ARG_EDEFAULT;

	/**
	 * The default value of the '{@link #isExtension() <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtension()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTENSION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExtension() <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtension()
	 * @generated
	 * @ordered
	 */
	protected boolean extension = EXTENSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XtendParameterImpl()
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
		return XtendPackage.Literals.XTEND_PARAMETER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.XTEND_PARAMETER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JvmTypeReference getParameterType()
	{
		return parameterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameterType(JvmTypeReference newParameterType, NotificationChain msgs)
	{
		JvmTypeReference oldParameterType = parameterType;
		parameterType = newParameterType;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtendPackage.XTEND_PARAMETER__PARAMETER_TYPE, oldParameterType, newParameterType);
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
	public void setParameterType(JvmTypeReference newParameterType)
	{
		if (newParameterType != parameterType)
		{
			NotificationChain msgs = null;
			if (parameterType != null)
				msgs = ((InternalEObject)parameterType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtendPackage.XTEND_PARAMETER__PARAMETER_TYPE, null, msgs);
			if (newParameterType != null)
				msgs = ((InternalEObject)newParameterType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtendPackage.XTEND_PARAMETER__PARAMETER_TYPE, null, msgs);
			msgs = basicSetParameterType(newParameterType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.XTEND_PARAMETER__PARAMETER_TYPE, newParameterType, newParameterType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isVarArg()
	{
		return varArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVarArg(boolean newVarArg)
	{
		boolean oldVarArg = varArg;
		varArg = newVarArg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.XTEND_PARAMETER__VAR_ARG, oldVarArg, varArg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isExtension()
	{
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExtension(boolean newExtension)
	{
		boolean oldExtension = extension;
		extension = newExtension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.XTEND_PARAMETER__EXTENSION, oldExtension, extension));
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
			case XtendPackage.XTEND_PARAMETER__PARAMETER_TYPE:
				return basicSetParameterType(null, msgs);
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
			case XtendPackage.XTEND_PARAMETER__NAME:
				return getName();
			case XtendPackage.XTEND_PARAMETER__PARAMETER_TYPE:
				return getParameterType();
			case XtendPackage.XTEND_PARAMETER__VAR_ARG:
				return isVarArg();
			case XtendPackage.XTEND_PARAMETER__EXTENSION:
				return isExtension();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case XtendPackage.XTEND_PARAMETER__NAME:
				setName((String)newValue);
				return;
			case XtendPackage.XTEND_PARAMETER__PARAMETER_TYPE:
				setParameterType((JvmTypeReference)newValue);
				return;
			case XtendPackage.XTEND_PARAMETER__VAR_ARG:
				setVarArg((Boolean)newValue);
				return;
			case XtendPackage.XTEND_PARAMETER__EXTENSION:
				setExtension((Boolean)newValue);
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
			case XtendPackage.XTEND_PARAMETER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case XtendPackage.XTEND_PARAMETER__PARAMETER_TYPE:
				setParameterType((JvmTypeReference)null);
				return;
			case XtendPackage.XTEND_PARAMETER__VAR_ARG:
				setVarArg(VAR_ARG_EDEFAULT);
				return;
			case XtendPackage.XTEND_PARAMETER__EXTENSION:
				setExtension(EXTENSION_EDEFAULT);
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
			case XtendPackage.XTEND_PARAMETER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case XtendPackage.XTEND_PARAMETER__PARAMETER_TYPE:
				return parameterType != null;
			case XtendPackage.XTEND_PARAMETER__VAR_ARG:
				return varArg != VAR_ARG_EDEFAULT;
			case XtendPackage.XTEND_PARAMETER__EXTENSION:
				return extension != EXTENSION_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", varArg: ");
		result.append(varArg);
		result.append(", extension: ");
		result.append(extension);
		result.append(')');
		return result.toString();
	}

} //XtendParameterImpl
