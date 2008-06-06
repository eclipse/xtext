/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenServiceImpl.java,v 1.1 2008/06/06 16:15:42 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextgen.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.xtext.xtextgen.GenService;
import org.eclipse.xtext.xtextgen.XtextgenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenServiceImpl#getServiceInterfaceFQName <em>Service Interface FQ Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenServiceImpl#getExtensionPointID <em>Extension Point ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenServiceImpl extends GenClassImpl implements GenService {
    /**
     * The default value of the '{@link #getServiceInterfaceFQName() <em>Service Interface FQ Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServiceInterfaceFQName()
     * @generated
     * @ordered
     */
    protected static final String SERVICE_INTERFACE_FQ_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getServiceInterfaceFQName() <em>Service Interface FQ Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServiceInterfaceFQName()
     * @generated
     * @ordered
     */
    protected String serviceInterfaceFQName = SERVICE_INTERFACE_FQ_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getExtensionPointID() <em>Extension Point ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExtensionPointID()
     * @generated
     * @ordered
     */
    protected static final String EXTENSION_POINT_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExtensionPointID() <em>Extension Point ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExtensionPointID()
     * @generated
     * @ordered
     */
    protected String extensionPointID = EXTENSION_POINT_ID_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GenServiceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return XtextgenPackage.Literals.GEN_SERVICE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getServiceInterfaceFQName() {
        return serviceInterfaceFQName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setServiceInterfaceFQName(String newServiceInterfaceFQName) {
        String oldServiceInterfaceFQName = serviceInterfaceFQName;
        serviceInterfaceFQName = newServiceInterfaceFQName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.GEN_SERVICE__SERVICE_INTERFACE_FQ_NAME, oldServiceInterfaceFQName, serviceInterfaceFQName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExtensionPointID() {
        return extensionPointID;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExtensionPointID(String newExtensionPointID) {
        String oldExtensionPointID = extensionPointID;
        extensionPointID = newExtensionPointID;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.GEN_SERVICE__EXTENSION_POINT_ID, oldExtensionPointID, extensionPointID));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String serviceInterfaceName() {
        {return XtextgenUtil.serviceInterfaceName((GenServiceImpl) this);}
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String extensionPointName() {
        {return XtextgenUtil.extensionPointName((GenServiceImpl) this);}
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case XtextgenPackage.GEN_SERVICE__SERVICE_INTERFACE_FQ_NAME:
                return getServiceInterfaceFQName();
            case XtextgenPackage.GEN_SERVICE__EXTENSION_POINT_ID:
                return getExtensionPointID();
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
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case XtextgenPackage.GEN_SERVICE__SERVICE_INTERFACE_FQ_NAME:
                setServiceInterfaceFQName((String)newValue);
                return;
            case XtextgenPackage.GEN_SERVICE__EXTENSION_POINT_ID:
                setExtensionPointID((String)newValue);
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
            case XtextgenPackage.GEN_SERVICE__SERVICE_INTERFACE_FQ_NAME:
                setServiceInterfaceFQName(SERVICE_INTERFACE_FQ_NAME_EDEFAULT);
                return;
            case XtextgenPackage.GEN_SERVICE__EXTENSION_POINT_ID:
                setExtensionPointID(EXTENSION_POINT_ID_EDEFAULT);
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
            case XtextgenPackage.GEN_SERVICE__SERVICE_INTERFACE_FQ_NAME:
                return SERVICE_INTERFACE_FQ_NAME_EDEFAULT == null ? serviceInterfaceFQName != null : !SERVICE_INTERFACE_FQ_NAME_EDEFAULT.equals(serviceInterfaceFQName);
            case XtextgenPackage.GEN_SERVICE__EXTENSION_POINT_ID:
                return EXTENSION_POINT_ID_EDEFAULT == null ? extensionPointID != null : !EXTENSION_POINT_ID_EDEFAULT.equals(extensionPointID);
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
        result.append(" (serviceInterfaceFQName: ");
        result.append(serviceInterfaceFQName);
        result.append(", extensionPointID: ");
        result.append(extensionPointID);
        result.append(')');
        return result.toString();
    }

} //GenServiceImpl
