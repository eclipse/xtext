/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenModelImpl.java,v 1.2 2008/06/09 12:52:54 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextgen.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;

import org.eclipse.xtext.Grammar;

import org.eclipse.xtext.xtextgen.GenModel;
import org.eclipse.xtext.xtextgen.GenService;
import org.eclipse.xtext.xtextgen.XtextgenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenModelImpl#getModelFileExtensions <em>Model File Extensions</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenModelImpl#getFileHeader <em>File Header</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenModelImpl#getGrammar <em>Grammar</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenModelImpl#getGrammarResourceURI <em>Grammar Resource URI</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenModelImpl#getServices <em>Services</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenModelImpl#getOutletMap <em>Outlet Map</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenModelImpl#getLanguageInterfaceFQName <em>Language Interface FQ Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenModelImpl#getStandaloneSetupClassFQName <em>Standalone Setup Class FQ Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenModelImpl#getNonUIPluginBundleID <em>Non UI Plugin Bundle ID</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenModelImpl#getUiPluginBundleID <em>Ui Plugin Bundle ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenModelImpl extends EObjectImpl implements GenModel {
    /**
     * The cached value of the '{@link #getModelFileExtensions() <em>Model File Extensions</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getModelFileExtensions()
     * @generated
     * @ordered
     */
    protected EList<String> modelFileExtensions;

    /**
     * The default value of the '{@link #getFileHeader() <em>File Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFileHeader()
     * @generated
     * @ordered
     */
    protected static final String FILE_HEADER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFileHeader() <em>File Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFileHeader()
     * @generated
     * @ordered
     */
    protected String fileHeader = FILE_HEADER_EDEFAULT;

    /**
     * The cached value of the '{@link #getGrammar() <em>Grammar</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGrammar()
     * @generated
     * @ordered
     */
    protected Grammar grammar;

    /**
     * The default value of the '{@link #getGrammarResourceURI() <em>Grammar Resource URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGrammarResourceURI()
     * @generated
     * @ordered
     */
    protected static final String GRAMMAR_RESOURCE_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getGrammarResourceURI() <em>Grammar Resource URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGrammarResourceURI()
     * @generated
     * @ordered
     */
    protected String grammarResourceURI = GRAMMAR_RESOURCE_URI_EDEFAULT;

    /**
     * The cached value of the '{@link #getServices() <em>Services</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServices()
     * @generated
     * @ordered
     */
    protected EList<GenService> services;

    /**
     * The cached value of the '{@link #getOutletMap() <em>Outlet Map</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutletMap()
     * @generated
     * @ordered
     */
    protected EMap<String, String> outletMap;

    /**
     * The default value of the '{@link #getLanguageInterfaceFQName() <em>Language Interface FQ Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLanguageInterfaceFQName()
     * @generated
     * @ordered
     */
    protected static final String LANGUAGE_INTERFACE_FQ_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLanguageInterfaceFQName() <em>Language Interface FQ Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLanguageInterfaceFQName()
     * @generated
     * @ordered
     */
    protected String languageInterfaceFQName = LANGUAGE_INTERFACE_FQ_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getStandaloneSetupClassFQName() <em>Standalone Setup Class FQ Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStandaloneSetupClassFQName()
     * @generated
     * @ordered
     */
    protected static final String STANDALONE_SETUP_CLASS_FQ_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getStandaloneSetupClassFQName() <em>Standalone Setup Class FQ Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStandaloneSetupClassFQName()
     * @generated
     * @ordered
     */
    protected String standaloneSetupClassFQName = STANDALONE_SETUP_CLASS_FQ_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getNonUIPluginBundleID() <em>Non UI Plugin Bundle ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNonUIPluginBundleID()
     * @generated
     * @ordered
     */
    protected static final String NON_UI_PLUGIN_BUNDLE_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getNonUIPluginBundleID() <em>Non UI Plugin Bundle ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNonUIPluginBundleID()
     * @generated
     * @ordered
     */
    protected String nonUIPluginBundleID = NON_UI_PLUGIN_BUNDLE_ID_EDEFAULT;

    /**
     * The default value of the '{@link #getUiPluginBundleID() <em>Ui Plugin Bundle ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUiPluginBundleID()
     * @generated
     * @ordered
     */
    protected static final String UI_PLUGIN_BUNDLE_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUiPluginBundleID() <em>Ui Plugin Bundle ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUiPluginBundleID()
     * @generated
     * @ordered
     */
    protected String uiPluginBundleID = UI_PLUGIN_BUNDLE_ID_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GenModelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return XtextgenPackage.Literals.GEN_MODEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getModelFileExtensions() {
        if (modelFileExtensions == null) {
            modelFileExtensions = new EDataTypeUniqueEList<String>(String.class, this, XtextgenPackage.GEN_MODEL__MODEL_FILE_EXTENSIONS);
        }
        return modelFileExtensions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFileHeader() {
        return fileHeader;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFileHeader(String newFileHeader) {
        String oldFileHeader = fileHeader;
        fileHeader = newFileHeader;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.GEN_MODEL__FILE_HEADER, oldFileHeader, fileHeader));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Grammar getGrammar() {
        if (grammar != null && grammar.eIsProxy()) {
            InternalEObject oldGrammar = (InternalEObject)grammar;
            grammar = (Grammar)eResolveProxy(oldGrammar);
            if (grammar != oldGrammar) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, XtextgenPackage.GEN_MODEL__GRAMMAR, oldGrammar, grammar));
            }
        }
        return grammar;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Grammar basicGetGrammar() {
        return grammar;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGrammar(Grammar newGrammar) {
        Grammar oldGrammar = grammar;
        grammar = newGrammar;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.GEN_MODEL__GRAMMAR, oldGrammar, grammar));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getGrammarResourceURI() {
        return grammarResourceURI;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGrammarResourceURI(String newGrammarResourceURI) {
        String oldGrammarResourceURI = grammarResourceURI;
        grammarResourceURI = newGrammarResourceURI;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.GEN_MODEL__GRAMMAR_RESOURCE_URI, oldGrammarResourceURI, grammarResourceURI));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<GenService> getServices() {
        if (services == null) {
            services = new EObjectResolvingEList<GenService>(GenService.class, this, XtextgenPackage.GEN_MODEL__SERVICES);
        }
        return services;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, String> getOutletMap() {
        if (outletMap == null) {
            outletMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, XtextgenPackage.GEN_MODEL__OUTLET_MAP);
        }
        return outletMap;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getUiPluginBundleID() {
        return uiPluginBundleID;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUiPluginBundleID(String newUiPluginBundleID) {
        String oldUiPluginBundleID = uiPluginBundleID;
        uiPluginBundleID = newUiPluginBundleID;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.GEN_MODEL__UI_PLUGIN_BUNDLE_ID, oldUiPluginBundleID, uiPluginBundleID));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLanguageInterfaceFQName() {
        return languageInterfaceFQName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLanguageInterfaceFQName(String newLanguageInterfaceFQName) {
        String oldLanguageInterfaceFQName = languageInterfaceFQName;
        languageInterfaceFQName = newLanguageInterfaceFQName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.GEN_MODEL__LANGUAGE_INTERFACE_FQ_NAME, oldLanguageInterfaceFQName, languageInterfaceFQName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getStandaloneSetupClassFQName() {
        return standaloneSetupClassFQName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStandaloneSetupClassFQName(String newStandaloneSetupClassFQName) {
        String oldStandaloneSetupClassFQName = standaloneSetupClassFQName;
        standaloneSetupClassFQName = newStandaloneSetupClassFQName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.GEN_MODEL__STANDALONE_SETUP_CLASS_FQ_NAME, oldStandaloneSetupClassFQName, standaloneSetupClassFQName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getNonUIPluginBundleID() {
        return nonUIPluginBundleID;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNonUIPluginBundleID(String newNonUIPluginBundleID) {
        String oldNonUIPluginBundleID = nonUIPluginBundleID;
        nonUIPluginBundleID = newNonUIPluginBundleID;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XtextgenPackage.GEN_MODEL__NON_UI_PLUGIN_BUNDLE_ID, oldNonUIPluginBundleID, nonUIPluginBundleID));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case XtextgenPackage.GEN_MODEL__MODEL_FILE_EXTENSIONS:
                return getModelFileExtensions();
            case XtextgenPackage.GEN_MODEL__FILE_HEADER:
                return getFileHeader();
            case XtextgenPackage.GEN_MODEL__GRAMMAR:
                if (resolve) return getGrammar();
                return basicGetGrammar();
            case XtextgenPackage.GEN_MODEL__GRAMMAR_RESOURCE_URI:
                return getGrammarResourceURI();
            case XtextgenPackage.GEN_MODEL__SERVICES:
                return getServices();
            case XtextgenPackage.GEN_MODEL__OUTLET_MAP:
                if (coreType) return getOutletMap();
                else return getOutletMap().map();
            case XtextgenPackage.GEN_MODEL__LANGUAGE_INTERFACE_FQ_NAME:
                return getLanguageInterfaceFQName();
            case XtextgenPackage.GEN_MODEL__STANDALONE_SETUP_CLASS_FQ_NAME:
                return getStandaloneSetupClassFQName();
            case XtextgenPackage.GEN_MODEL__NON_UI_PLUGIN_BUNDLE_ID:
                return getNonUIPluginBundleID();
            case XtextgenPackage.GEN_MODEL__UI_PLUGIN_BUNDLE_ID:
                return getUiPluginBundleID();
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
            case XtextgenPackage.GEN_MODEL__MODEL_FILE_EXTENSIONS:
                getModelFileExtensions().clear();
                getModelFileExtensions().addAll((Collection<? extends String>)newValue);
                return;
            case XtextgenPackage.GEN_MODEL__FILE_HEADER:
                setFileHeader((String)newValue);
                return;
            case XtextgenPackage.GEN_MODEL__GRAMMAR:
                setGrammar((Grammar)newValue);
                return;
            case XtextgenPackage.GEN_MODEL__GRAMMAR_RESOURCE_URI:
                setGrammarResourceURI((String)newValue);
                return;
            case XtextgenPackage.GEN_MODEL__SERVICES:
                getServices().clear();
                getServices().addAll((Collection<? extends GenService>)newValue);
                return;
            case XtextgenPackage.GEN_MODEL__OUTLET_MAP:
                ((EStructuralFeature.Setting)getOutletMap()).set(newValue);
                return;
            case XtextgenPackage.GEN_MODEL__LANGUAGE_INTERFACE_FQ_NAME:
                setLanguageInterfaceFQName((String)newValue);
                return;
            case XtextgenPackage.GEN_MODEL__STANDALONE_SETUP_CLASS_FQ_NAME:
                setStandaloneSetupClassFQName((String)newValue);
                return;
            case XtextgenPackage.GEN_MODEL__NON_UI_PLUGIN_BUNDLE_ID:
                setNonUIPluginBundleID((String)newValue);
                return;
            case XtextgenPackage.GEN_MODEL__UI_PLUGIN_BUNDLE_ID:
                setUiPluginBundleID((String)newValue);
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
            case XtextgenPackage.GEN_MODEL__MODEL_FILE_EXTENSIONS:
                getModelFileExtensions().clear();
                return;
            case XtextgenPackage.GEN_MODEL__FILE_HEADER:
                setFileHeader(FILE_HEADER_EDEFAULT);
                return;
            case XtextgenPackage.GEN_MODEL__GRAMMAR:
                setGrammar((Grammar)null);
                return;
            case XtextgenPackage.GEN_MODEL__GRAMMAR_RESOURCE_URI:
                setGrammarResourceURI(GRAMMAR_RESOURCE_URI_EDEFAULT);
                return;
            case XtextgenPackage.GEN_MODEL__SERVICES:
                getServices().clear();
                return;
            case XtextgenPackage.GEN_MODEL__OUTLET_MAP:
                getOutletMap().clear();
                return;
            case XtextgenPackage.GEN_MODEL__LANGUAGE_INTERFACE_FQ_NAME:
                setLanguageInterfaceFQName(LANGUAGE_INTERFACE_FQ_NAME_EDEFAULT);
                return;
            case XtextgenPackage.GEN_MODEL__STANDALONE_SETUP_CLASS_FQ_NAME:
                setStandaloneSetupClassFQName(STANDALONE_SETUP_CLASS_FQ_NAME_EDEFAULT);
                return;
            case XtextgenPackage.GEN_MODEL__NON_UI_PLUGIN_BUNDLE_ID:
                setNonUIPluginBundleID(NON_UI_PLUGIN_BUNDLE_ID_EDEFAULT);
                return;
            case XtextgenPackage.GEN_MODEL__UI_PLUGIN_BUNDLE_ID:
                setUiPluginBundleID(UI_PLUGIN_BUNDLE_ID_EDEFAULT);
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
            case XtextgenPackage.GEN_MODEL__MODEL_FILE_EXTENSIONS:
                return modelFileExtensions != null && !modelFileExtensions.isEmpty();
            case XtextgenPackage.GEN_MODEL__FILE_HEADER:
                return FILE_HEADER_EDEFAULT == null ? fileHeader != null : !FILE_HEADER_EDEFAULT.equals(fileHeader);
            case XtextgenPackage.GEN_MODEL__GRAMMAR:
                return grammar != null;
            case XtextgenPackage.GEN_MODEL__GRAMMAR_RESOURCE_URI:
                return GRAMMAR_RESOURCE_URI_EDEFAULT == null ? grammarResourceURI != null : !GRAMMAR_RESOURCE_URI_EDEFAULT.equals(grammarResourceURI);
            case XtextgenPackage.GEN_MODEL__SERVICES:
                return services != null && !services.isEmpty();
            case XtextgenPackage.GEN_MODEL__OUTLET_MAP:
                return outletMap != null && !outletMap.isEmpty();
            case XtextgenPackage.GEN_MODEL__LANGUAGE_INTERFACE_FQ_NAME:
                return LANGUAGE_INTERFACE_FQ_NAME_EDEFAULT == null ? languageInterfaceFQName != null : !LANGUAGE_INTERFACE_FQ_NAME_EDEFAULT.equals(languageInterfaceFQName);
            case XtextgenPackage.GEN_MODEL__STANDALONE_SETUP_CLASS_FQ_NAME:
                return STANDALONE_SETUP_CLASS_FQ_NAME_EDEFAULT == null ? standaloneSetupClassFQName != null : !STANDALONE_SETUP_CLASS_FQ_NAME_EDEFAULT.equals(standaloneSetupClassFQName);
            case XtextgenPackage.GEN_MODEL__NON_UI_PLUGIN_BUNDLE_ID:
                return NON_UI_PLUGIN_BUNDLE_ID_EDEFAULT == null ? nonUIPluginBundleID != null : !NON_UI_PLUGIN_BUNDLE_ID_EDEFAULT.equals(nonUIPluginBundleID);
            case XtextgenPackage.GEN_MODEL__UI_PLUGIN_BUNDLE_ID:
                return UI_PLUGIN_BUNDLE_ID_EDEFAULT == null ? uiPluginBundleID != null : !UI_PLUGIN_BUNDLE_ID_EDEFAULT.equals(uiPluginBundleID);
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
        result.append(" (modelFileExtensions: ");
        result.append(modelFileExtensions);
        result.append(", fileHeader: ");
        result.append(fileHeader);
        result.append(", grammarResourceURI: ");
        result.append(grammarResourceURI);
        result.append(", languageInterfaceFQName: ");
        result.append(languageInterfaceFQName);
        result.append(", standaloneSetupClassFQName: ");
        result.append(standaloneSetupClassFQName);
        result.append(", nonUIPluginBundleID: ");
        result.append(nonUIPluginBundleID);
        result.append(", uiPluginBundleID: ");
        result.append(uiPluginBundleID);
        result.append(')');
        return result.toString();
    }

} //GenModelImpl
