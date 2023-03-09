/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtype.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.common.types.JvmDeclaredType;

import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XImport Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XImportDeclarationImpl#isWildcard <em>Wildcard</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XImportDeclarationImpl#isExtension <em>Extension</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XImportDeclarationImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XImportDeclarationImpl#getImportedType <em>Imported Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XImportDeclarationImpl#getMemberName <em>Member Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XImportDeclarationImpl#getImportedNamespace <em>Imported Namespace</em>}</li>
 * </ul>
 *
 * @since 2.7
 * @generated
 */
public class XImportDeclarationImpl extends MinimalEObjectImpl.Container implements XImportDeclaration
{
	/**
	 * The default value of the '{@link #isWildcard() <em>Wildcard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWildcard()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WILDCARD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isWildcard() <em>Wildcard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWildcard()
	 * @generated
	 * @ordered
	 */
	protected boolean wildcard = WILDCARD_EDEFAULT;

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
	 * The default value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STATIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected boolean static_ = STATIC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImportedType() <em>Imported Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedType()
	 * @generated
	 * @ordered
	 */
	protected JvmDeclaredType importedType;

	/**
	 * The default value of the '{@link #getMemberName() <em>Member Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberName()
	 * @generated
	 * @ordered
	 */
	protected static final String MEMBER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMemberName() <em>Member Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberName()
	 * @generated
	 * @ordered
	 */
	protected String memberName = MEMBER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getImportedNamespace() <em>Imported Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPORTED_NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImportedNamespace() <em>Imported Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedNamespace()
	 * @generated
	 * @ordered
	 */
	protected String importedNamespace = IMPORTED_NAMESPACE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XImportDeclarationImpl()
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
		return XtypePackage.Literals.XIMPORT_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isWildcard()
	{
		return wildcard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWildcard(boolean newWildcard)
	{
		boolean oldWildcard = wildcard;
		wildcard = newWildcard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtypePackage.XIMPORT_DECLARATION__WILDCARD, oldWildcard, wildcard));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XtypePackage.XIMPORT_DECLARATION__EXTENSION, oldExtension, extension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isStatic()
	{
		return static_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatic(boolean newStatic)
	{
		boolean oldStatic = static_;
		static_ = newStatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtypePackage.XIMPORT_DECLARATION__STATIC, oldStatic, static_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JvmDeclaredType getImportedType()
	{
		if (importedType != null && importedType.eIsProxy())
		{
			InternalEObject oldImportedType = (InternalEObject)importedType;
			importedType = (JvmDeclaredType)eResolveProxy(oldImportedType);
			if (importedType != oldImportedType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XtypePackage.XIMPORT_DECLARATION__IMPORTED_TYPE, oldImportedType, importedType));
			}
		}
		return importedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmDeclaredType basicGetImportedType()
	{
		return importedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImportedType(JvmDeclaredType newImportedType)
	{
		JvmDeclaredType oldImportedType = importedType;
		importedType = newImportedType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtypePackage.XIMPORT_DECLARATION__IMPORTED_TYPE, oldImportedType, importedType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMemberName()
	{
		return memberName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMemberName(String newMemberName)
	{
		String oldMemberName = memberName;
		memberName = newMemberName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtypePackage.XIMPORT_DECLARATION__MEMBER_NAME, oldMemberName, memberName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getImportedNamespace()
	{
		return importedNamespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImportedNamespace(String newImportedNamespace)
	{
		String oldImportedNamespace = importedNamespace;
		importedNamespace = newImportedNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtypePackage.XIMPORT_DECLARATION__IMPORTED_NAMESPACE, oldImportedNamespace, importedNamespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getImportedName()
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
	public String getImportedTypeName()
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
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case XtypePackage.XIMPORT_DECLARATION__WILDCARD:
				return isWildcard();
			case XtypePackage.XIMPORT_DECLARATION__EXTENSION:
				return isExtension();
			case XtypePackage.XIMPORT_DECLARATION__STATIC:
				return isStatic();
			case XtypePackage.XIMPORT_DECLARATION__IMPORTED_TYPE:
				if (resolve) return getImportedType();
				return basicGetImportedType();
			case XtypePackage.XIMPORT_DECLARATION__MEMBER_NAME:
				return getMemberName();
			case XtypePackage.XIMPORT_DECLARATION__IMPORTED_NAMESPACE:
				return getImportedNamespace();
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
			case XtypePackage.XIMPORT_DECLARATION__WILDCARD:
				setWildcard((Boolean)newValue);
				return;
			case XtypePackage.XIMPORT_DECLARATION__EXTENSION:
				setExtension((Boolean)newValue);
				return;
			case XtypePackage.XIMPORT_DECLARATION__STATIC:
				setStatic((Boolean)newValue);
				return;
			case XtypePackage.XIMPORT_DECLARATION__IMPORTED_TYPE:
				setImportedType((JvmDeclaredType)newValue);
				return;
			case XtypePackage.XIMPORT_DECLARATION__MEMBER_NAME:
				setMemberName((String)newValue);
				return;
			case XtypePackage.XIMPORT_DECLARATION__IMPORTED_NAMESPACE:
				setImportedNamespace((String)newValue);
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
			case XtypePackage.XIMPORT_DECLARATION__WILDCARD:
				setWildcard(WILDCARD_EDEFAULT);
				return;
			case XtypePackage.XIMPORT_DECLARATION__EXTENSION:
				setExtension(EXTENSION_EDEFAULT);
				return;
			case XtypePackage.XIMPORT_DECLARATION__STATIC:
				setStatic(STATIC_EDEFAULT);
				return;
			case XtypePackage.XIMPORT_DECLARATION__IMPORTED_TYPE:
				setImportedType((JvmDeclaredType)null);
				return;
			case XtypePackage.XIMPORT_DECLARATION__MEMBER_NAME:
				setMemberName(MEMBER_NAME_EDEFAULT);
				return;
			case XtypePackage.XIMPORT_DECLARATION__IMPORTED_NAMESPACE:
				setImportedNamespace(IMPORTED_NAMESPACE_EDEFAULT);
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
			case XtypePackage.XIMPORT_DECLARATION__WILDCARD:
				return wildcard != WILDCARD_EDEFAULT;
			case XtypePackage.XIMPORT_DECLARATION__EXTENSION:
				return extension != EXTENSION_EDEFAULT;
			case XtypePackage.XIMPORT_DECLARATION__STATIC:
				return static_ != STATIC_EDEFAULT;
			case XtypePackage.XIMPORT_DECLARATION__IMPORTED_TYPE:
				return importedType != null;
			case XtypePackage.XIMPORT_DECLARATION__MEMBER_NAME:
				return MEMBER_NAME_EDEFAULT == null ? memberName != null : !MEMBER_NAME_EDEFAULT.equals(memberName);
			case XtypePackage.XIMPORT_DECLARATION__IMPORTED_NAMESPACE:
				return IMPORTED_NAMESPACE_EDEFAULT == null ? importedNamespace != null : !IMPORTED_NAMESPACE_EDEFAULT.equals(importedNamespace);
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
		result.append(" (wildcard: ");
		result.append(wildcard);
		result.append(", extension: ");
		result.append(extension);
		result.append(", static: ");
		result.append(static_);
		result.append(", memberName: ");
		result.append(memberName);
		result.append(", importedNamespace: ");
		result.append(importedNamespace);
		result.append(')');
		return result.toString();
	}

} //XImportDeclarationImpl
