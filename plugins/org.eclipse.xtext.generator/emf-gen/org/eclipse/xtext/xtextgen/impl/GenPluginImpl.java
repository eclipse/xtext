/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenPluginImpl.java,v 1.1 2008/06/06 16:15:42 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextgen.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xtextgen.GenPlugin;
import org.eclipse.xtext.xtextgen.XtextgenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Plugin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenPluginImpl#getBundleID <em>Bundle ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenPluginImpl extends RootTemplateImpl implements GenPlugin {
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GenPluginImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return XtextgenPackage.Literals.GEN_PLUGIN;
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
            eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.GEN_PLUGIN__BUNDLE_ID, oldBundleID, bundleID));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case XtextgenPackage.GEN_PLUGIN__BUNDLE_ID:
                return getBundleID();
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
            case XtextgenPackage.GEN_PLUGIN__BUNDLE_ID:
                setBundleID((String)newValue);
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
            case XtextgenPackage.GEN_PLUGIN__BUNDLE_ID:
                setBundleID(BUNDLE_ID_EDEFAULT);
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
            case XtextgenPackage.GEN_PLUGIN__BUNDLE_ID:
                return BUNDLE_ID_EDEFAULT == null ? bundleID != null : !BUNDLE_ID_EDEFAULT.equals(bundleID);
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
        result.append(')');
        return result.toString();
    }

} //GenPluginImpl
