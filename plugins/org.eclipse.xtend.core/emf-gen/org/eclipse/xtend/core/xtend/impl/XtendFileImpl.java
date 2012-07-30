/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.xtend.impl;

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

import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendImport;
import org.eclipse.xtend.core.xtend.XtendPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.XtendFileImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.XtendFileImpl#getXtendClasses <em>Xtend Classes</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.XtendFileImpl#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XtendFileImpl extends MinimalEObjectImpl.Container implements XtendFile
{
	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<XtendImport> imports;

	/**
	 * The cached value of the '{@link #getXtendClasses() <em>Xtend Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXtendClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<XtendClass> xtendClasses;

	/**
	 * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected String package_ = PACKAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XtendFileImpl()
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
		return XtendPackage.Literals.XTEND_FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XtendImport> getImports()
	{
		if (imports == null)
		{
			imports = new EObjectContainmentEList<XtendImport>(XtendImport.class, this, XtendPackage.XTEND_FILE__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XtendClass> getXtendClasses()
	{
		if (xtendClasses == null)
		{
			xtendClasses = new EObjectContainmentEList<XtendClass>(XtendClass.class, this, XtendPackage.XTEND_FILE__XTEND_CLASSES);
		}
		return xtendClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackage()
	{
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackage(String newPackage)
	{
		String oldPackage = package_;
		package_ = newPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.XTEND_FILE__PACKAGE, oldPackage, package_));
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
			case XtendPackage.XTEND_FILE__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case XtendPackage.XTEND_FILE__XTEND_CLASSES:
				return ((InternalEList<?>)getXtendClasses()).basicRemove(otherEnd, msgs);
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
			case XtendPackage.XTEND_FILE__IMPORTS:
				return getImports();
			case XtendPackage.XTEND_FILE__XTEND_CLASSES:
				return getXtendClasses();
			case XtendPackage.XTEND_FILE__PACKAGE:
				return getPackage();
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
			case XtendPackage.XTEND_FILE__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends XtendImport>)newValue);
				return;
			case XtendPackage.XTEND_FILE__XTEND_CLASSES:
				getXtendClasses().clear();
				getXtendClasses().addAll((Collection<? extends XtendClass>)newValue);
				return;
			case XtendPackage.XTEND_FILE__PACKAGE:
				setPackage((String)newValue);
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
			case XtendPackage.XTEND_FILE__IMPORTS:
				getImports().clear();
				return;
			case XtendPackage.XTEND_FILE__XTEND_CLASSES:
				getXtendClasses().clear();
				return;
			case XtendPackage.XTEND_FILE__PACKAGE:
				setPackage(PACKAGE_EDEFAULT);
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
			case XtendPackage.XTEND_FILE__IMPORTS:
				return imports != null && !imports.isEmpty();
			case XtendPackage.XTEND_FILE__XTEND_CLASSES:
				return xtendClasses != null && !xtendClasses.isEmpty();
			case XtendPackage.XTEND_FILE__PACKAGE:
				return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (package: ");
		result.append(package_);
		result.append(')');
		return result.toString();
	}

} //XtendFileImpl
