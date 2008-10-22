/**
 * <copyright>
 * </copyright>
 *
 * $Id: OutletImpl.java,v 1.2 2008/10/22 14:02:04 jkohnlein Exp $
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
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.OutletImpl#isOverwrite <em>Overwrite</em>}</li>
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
	 * The default value of the '{@link #isOverwrite() <em>Overwrite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverwrite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OVERWRITE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOverwrite() <em>Overwrite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverwrite()
	 * @generated
	 * @ordered
	 */
	protected boolean overwrite = OVERWRITE_EDEFAULT;

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
	public boolean isOverwrite() {
		return overwrite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverwrite(boolean newOverwrite) {
		boolean oldOverwrite = overwrite;
		overwrite = newOverwrite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.OUTLET__OVERWRITE, oldOverwrite, overwrite));
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
			case XtextgenPackage.OUTLET__OVERWRITE:
				return isOverwrite() ? Boolean.TRUE : Boolean.FALSE;
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
			case XtextgenPackage.OUTLET__OVERWRITE:
				setOverwrite(((Boolean)newValue).booleanValue());
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
			case XtextgenPackage.OUTLET__OVERWRITE:
				setOverwrite(OVERWRITE_EDEFAULT);
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
			case XtextgenPackage.OUTLET__OVERWRITE:
				return overwrite != OVERWRITE_EDEFAULT;
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
		result.append(", Overwrite: ");
		result.append(overwrite);
		result.append(')');
		return result.toString();
	}

} //OutletImpl
