/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Enumeration Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmEnumerationTypeImpl#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JvmEnumerationTypeImpl extends JvmDeclaredTypeImplCustom implements JvmEnumerationType
{
	/**
	 * The cached value of the '{@link #getLiterals() <em>Literals</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmEnumerationLiteral> literals;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmEnumerationTypeImpl()
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
		return TypesPackage.Literals.JVM_ENUMERATION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<JvmEnumerationLiteral> getLiterals()
	{
		if (literals == null)
		{
			literals = new EObjectResolvingEList<JvmEnumerationLiteral>(JvmEnumerationLiteral.class, this, TypesPackage.JVM_ENUMERATION_TYPE__LITERALS);
		}
		return literals;
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
			case TypesPackage.JVM_ENUMERATION_TYPE__LITERALS:
				return getLiterals();
		}
		return super.eGet(featureID, resolve, coreType);
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
			case TypesPackage.JVM_ENUMERATION_TYPE__LITERALS:
				return literals != null && !literals.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //JvmEnumerationTypeImpl
