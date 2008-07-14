/**
 * <copyright>
 * </copyright>
 *
 * $Id: OutletImpl.java,v 1.1 2008/07/14 08:15:32 sefftinge Exp $
 */
package org.eclipse.xtext.xtextgen.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.xtext.xtextgen.Outlet;
import org.eclipse.xtext.xtextgen.XtextgenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Outlet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.OutletImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.OutletImpl#getTargetFolder <em>Target Folder</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutletImpl extends EObjectImpl implements Outlet {
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
	 * The default value of the '{@link #getTargetFolder() <em>Target Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_FOLDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetFolder() <em>Target Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetFolder()
	 * @generated
	 * @ordered
	 */
	protected String targetFolder = TARGET_FOLDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutletImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XtextgenPackage.Literals.OUTLET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.OUTLET__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetFolder() {
		return targetFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetFolder(String newTargetFolder) {
		String oldTargetFolder = targetFolder;
		targetFolder = newTargetFolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.OUTLET__TARGET_FOLDER, oldTargetFolder, targetFolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XtextgenPackage.OUTLET__NAME:
				return getName();
			case XtextgenPackage.OUTLET__TARGET_FOLDER:
				return getTargetFolder();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XtextgenPackage.OUTLET__NAME:
				setName((String)newValue);
				return;
			case XtextgenPackage.OUTLET__TARGET_FOLDER:
				setTargetFolder((String)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case XtextgenPackage.OUTLET__NAME:
				setName(NAME_EDEFAULT);
				return;
			case XtextgenPackage.OUTLET__TARGET_FOLDER:
				setTargetFolder(TARGET_FOLDER_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case XtextgenPackage.OUTLET__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case XtextgenPackage.OUTLET__TARGET_FOLDER:
				return TARGET_FOLDER_EDEFAULT == null ? targetFolder != null : !TARGET_FOLDER_EDEFAULT.equals(targetFolder);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", targetFolder: ");
		result.append(targetFolder);
		result.append(')');
		return result.toString();
	}

} //OutletImpl
