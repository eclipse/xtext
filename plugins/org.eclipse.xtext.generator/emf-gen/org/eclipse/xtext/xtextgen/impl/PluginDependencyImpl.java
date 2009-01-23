/**
 * <copyright>
 * </copyright>
 *
 * $Id: PluginDependencyImpl.java,v 1.1 2009/01/23 14:12:00 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextgen.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.xtext.xtextgen.PluginDependency;
import org.eclipse.xtext.xtextgen.XtextgenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plugin Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.PluginDependencyImpl#getBundleID <em>Bundle ID</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.PluginDependencyImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.PluginDependencyImpl#isReexport <em>Reexport</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.PluginDependencyImpl#isOptional <em>Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PluginDependencyImpl extends EObjectImpl implements PluginDependency {
	/**
	 * The default value of the '{@link #getBundleID() <em>Bundle ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundleID()
	 * @generated
	 * @ordered
	 */
	protected static final String BUNDLE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBundleID() <em>Bundle ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundleID()
	 * @generated
	 * @ordered
	 */
	protected String bundleID = BUNDLE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #isReexport() <em>Reexport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReexport()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REEXPORT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReexport() <em>Reexport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReexport()
	 * @generated
	 * @ordered
	 */
	protected boolean reexport = REEXPORT_EDEFAULT;

	/**
	 * The default value of the '{@link #isOptional() <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OPTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOptional() <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected boolean optional = OPTIONAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PluginDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XtextgenPackage.Literals.PLUGIN_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBundleID() {
		return bundleID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBundleID(String newBundleID) {
		String oldBundleID = bundleID;
		bundleID = newBundleID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.PLUGIN_DEPENDENCY__BUNDLE_ID, oldBundleID, bundleID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.PLUGIN_DEPENDENCY__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReexport() {
		return reexport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReexport(boolean newReexport) {
		boolean oldReexport = reexport;
		reexport = newReexport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.PLUGIN_DEPENDENCY__REEXPORT, oldReexport, reexport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOptional() {
		return optional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptional(boolean newOptional) {
		boolean oldOptional = optional;
		optional = newOptional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.PLUGIN_DEPENDENCY__OPTIONAL, oldOptional, optional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XtextgenPackage.PLUGIN_DEPENDENCY__BUNDLE_ID:
				return getBundleID();
			case XtextgenPackage.PLUGIN_DEPENDENCY__VERSION:
				return getVersion();
			case XtextgenPackage.PLUGIN_DEPENDENCY__REEXPORT:
				return isReexport() ? Boolean.TRUE : Boolean.FALSE;
			case XtextgenPackage.PLUGIN_DEPENDENCY__OPTIONAL:
				return isOptional() ? Boolean.TRUE : Boolean.FALSE;
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
			case XtextgenPackage.PLUGIN_DEPENDENCY__BUNDLE_ID:
				setBundleID((String)newValue);
				return;
			case XtextgenPackage.PLUGIN_DEPENDENCY__VERSION:
				setVersion((String)newValue);
				return;
			case XtextgenPackage.PLUGIN_DEPENDENCY__REEXPORT:
				setReexport(((Boolean)newValue).booleanValue());
				return;
			case XtextgenPackage.PLUGIN_DEPENDENCY__OPTIONAL:
				setOptional(((Boolean)newValue).booleanValue());
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
			case XtextgenPackage.PLUGIN_DEPENDENCY__BUNDLE_ID:
				setBundleID(BUNDLE_ID_EDEFAULT);
				return;
			case XtextgenPackage.PLUGIN_DEPENDENCY__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case XtextgenPackage.PLUGIN_DEPENDENCY__REEXPORT:
				setReexport(REEXPORT_EDEFAULT);
				return;
			case XtextgenPackage.PLUGIN_DEPENDENCY__OPTIONAL:
				setOptional(OPTIONAL_EDEFAULT);
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
			case XtextgenPackage.PLUGIN_DEPENDENCY__BUNDLE_ID:
				return BUNDLE_ID_EDEFAULT == null ? bundleID != null : !BUNDLE_ID_EDEFAULT.equals(bundleID);
			case XtextgenPackage.PLUGIN_DEPENDENCY__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case XtextgenPackage.PLUGIN_DEPENDENCY__REEXPORT:
				return reexport != REEXPORT_EDEFAULT;
			case XtextgenPackage.PLUGIN_DEPENDENCY__OPTIONAL:
				return optional != OPTIONAL_EDEFAULT;
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
		result.append(" (bundleID: ");
		result.append(bundleID);
		result.append(", version: ");
		result.append(version);
		result.append(", reexport: ");
		result.append(reexport);
		result.append(", optional: ");
		result.append(optional);
		result.append(')');
		return result.toString();
	}

} //PluginDependencyImpl
