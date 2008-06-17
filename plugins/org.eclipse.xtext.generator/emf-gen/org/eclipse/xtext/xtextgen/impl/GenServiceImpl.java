/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenServiceImpl.java,v 1.3 2008/06/17 14:45:51 pfriese Exp $
 */
package org.eclipse.xtext.xtextgen.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

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
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenServiceImpl#getGenClassFQName <em>Gen Class FQ Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenServiceImpl#getExtensionPointID <em>Extension Point ID</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenServiceImpl#getTemplatePath <em>Template Path</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenServiceImpl#getGenParameters <em>Gen Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenServiceImpl#isUiService <em>Ui Service</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenServiceImpl extends EObjectImpl implements GenService {
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
     * The default value of the '{@link #getGenClassFQName() <em>Gen Class FQ Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGenClassFQName()
     * @generated
     * @ordered
     */
    protected static final String GEN_CLASS_FQ_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getGenClassFQName() <em>Gen Class FQ Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGenClassFQName()
     * @generated
     * @ordered
     */
    protected String genClassFQName = GEN_CLASS_FQ_NAME_EDEFAULT;

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
     * The default value of the '{@link #getTemplatePath() <em>Template Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTemplatePath()
     * @generated
     * @ordered
     */
    protected static final String TEMPLATE_PATH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTemplatePath() <em>Template Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTemplatePath()
     * @generated
     * @ordered
     */
    protected String templatePath = TEMPLATE_PATH_EDEFAULT;

    /**
     * This is true if the Template Path attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean templatePathESet;

    /**
     * The cached value of the '{@link #getGenParameters() <em>Gen Parameters</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGenParameters()
     * @generated
     * @ordered
     */
    protected EMap<String, String> genParameters;

    /**
     * The default value of the '{@link #isUiService() <em>Ui Service</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isUiService()
     * @generated
     * @ordered
     */
    protected static final boolean UI_SERVICE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isUiService() <em>Ui Service</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isUiService()
     * @generated
     * @ordered
     */
    protected boolean uiService = UI_SERVICE_EDEFAULT;

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
    public String getGenClassFQName() {
        return genClassFQName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGenClassFQName(String newGenClassFQName) {
        String oldGenClassFQName = genClassFQName;
        genClassFQName = newGenClassFQName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.GEN_SERVICE__GEN_CLASS_FQ_NAME, oldGenClassFQName, genClassFQName));
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
    public String getTemplatePath() {
        return templatePath;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTemplatePath(String newTemplatePath) {
        String oldTemplatePath = templatePath;
        templatePath = newTemplatePath;
        boolean oldTemplatePathESet = templatePathESet;
        templatePathESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.GEN_SERVICE__TEMPLATE_PATH, oldTemplatePath, templatePath, !oldTemplatePathESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetTemplatePath() {
        String oldTemplatePath = templatePath;
        boolean oldTemplatePathESet = templatePathESet;
        templatePath = TEMPLATE_PATH_EDEFAULT;
        templatePathESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, XtextgenPackage.GEN_SERVICE__TEMPLATE_PATH, oldTemplatePath, TEMPLATE_PATH_EDEFAULT, oldTemplatePathESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetTemplatePath() {
        return templatePathESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, String> getGenParameters() {
        if (genParameters == null) {
            genParameters = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, XtextgenPackage.GEN_SERVICE__GEN_PARAMETERS);
        }
        return genParameters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isUiService() {
        return uiService;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUiService(boolean newUiService) {
        boolean oldUiService = uiService;
        uiService = newUiService;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.GEN_SERVICE__UI_SERVICE, oldUiService, uiService));
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
            case XtextgenPackage.GEN_SERVICE__GEN_CLASS_FQ_NAME:
                return getGenClassFQName();
            case XtextgenPackage.GEN_SERVICE__EXTENSION_POINT_ID:
                return getExtensionPointID();
            case XtextgenPackage.GEN_SERVICE__TEMPLATE_PATH:
                return getTemplatePath();
            case XtextgenPackage.GEN_SERVICE__GEN_PARAMETERS:
                if (coreType) return getGenParameters();
                else return getGenParameters().map();
            case XtextgenPackage.GEN_SERVICE__UI_SERVICE:
                return isUiService() ? Boolean.TRUE : Boolean.FALSE;
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
            case XtextgenPackage.GEN_SERVICE__SERVICE_INTERFACE_FQ_NAME:
                setServiceInterfaceFQName((String)newValue);
                return;
            case XtextgenPackage.GEN_SERVICE__GEN_CLASS_FQ_NAME:
                setGenClassFQName((String)newValue);
                return;
            case XtextgenPackage.GEN_SERVICE__EXTENSION_POINT_ID:
                setExtensionPointID((String)newValue);
                return;
            case XtextgenPackage.GEN_SERVICE__TEMPLATE_PATH:
                setTemplatePath((String)newValue);
                return;
            case XtextgenPackage.GEN_SERVICE__GEN_PARAMETERS:
                ((EStructuralFeature.Setting)getGenParameters()).set(newValue);
                return;
            case XtextgenPackage.GEN_SERVICE__UI_SERVICE:
                setUiService(((Boolean)newValue).booleanValue());
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
            case XtextgenPackage.GEN_SERVICE__GEN_CLASS_FQ_NAME:
                setGenClassFQName(GEN_CLASS_FQ_NAME_EDEFAULT);
                return;
            case XtextgenPackage.GEN_SERVICE__EXTENSION_POINT_ID:
                setExtensionPointID(EXTENSION_POINT_ID_EDEFAULT);
                return;
            case XtextgenPackage.GEN_SERVICE__TEMPLATE_PATH:
                unsetTemplatePath();
                return;
            case XtextgenPackage.GEN_SERVICE__GEN_PARAMETERS:
                getGenParameters().clear();
                return;
            case XtextgenPackage.GEN_SERVICE__UI_SERVICE:
                setUiService(UI_SERVICE_EDEFAULT);
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
            case XtextgenPackage.GEN_SERVICE__GEN_CLASS_FQ_NAME:
                return GEN_CLASS_FQ_NAME_EDEFAULT == null ? genClassFQName != null : !GEN_CLASS_FQ_NAME_EDEFAULT.equals(genClassFQName);
            case XtextgenPackage.GEN_SERVICE__EXTENSION_POINT_ID:
                return EXTENSION_POINT_ID_EDEFAULT == null ? extensionPointID != null : !EXTENSION_POINT_ID_EDEFAULT.equals(extensionPointID);
            case XtextgenPackage.GEN_SERVICE__TEMPLATE_PATH:
                return isSetTemplatePath();
            case XtextgenPackage.GEN_SERVICE__GEN_PARAMETERS:
                return genParameters != null && !genParameters.isEmpty();
            case XtextgenPackage.GEN_SERVICE__UI_SERVICE:
                return uiService != UI_SERVICE_EDEFAULT;
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
        result.append(", genClassFQName: ");
        result.append(genClassFQName);
        result.append(", extensionPointID: ");
        result.append(extensionPointID);
        result.append(", templatePath: ");
        if (templatePathESet) result.append(templatePath); else result.append("<unset>");
        result.append(", uiService: ");
        result.append(uiService);
        result.append(')');
        return result.toString();
    }

} //GenServiceImpl
