/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenModelImpl.java,v 1.4 2008/07/14 08:15:32 sefftinge Exp $
 */
package org.eclipse.xtext.xtextgen.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xtextgen.GenModel;
import org.eclipse.xtext.xtextgen.GenService;
import org.eclipse.xtext.xtextgen.Outlet;
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
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenModelImpl#getServices <em>Services</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenModelImpl#getLanguageInterfaceFQName <em>Language Interface FQ Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenModelImpl#getNonUIPluginBundleID <em>Non UI Plugin Bundle ID</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenModelImpl#getUiPluginBundleID <em>Ui Plugin Bundle ID</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.impl.GenModelImpl#getOutlets <em>Outlets</em>}</li>
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
	 * The cached value of the '{@link #getServices() <em>Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServices()
	 * @generated
	 * @ordered
	 */
	protected EList<GenService> services;

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
	 * The cached value of the '{@link #getOutlets() <em>Outlets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutlets()
	 * @generated
	 * @ordered
	 */
	protected EList<Outlet> outlets;

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
	public EList<Outlet> getOutlets() {
		if (outlets == null) {
			outlets = new EObjectContainmentEList<Outlet>(Outlet.class, this, XtextgenPackage.GEN_MODEL__OUTLETS);
		}
		return outlets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XtextgenPackage.GEN_MODEL__OUTLETS:
				return ((InternalEList<?>)getOutlets()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case XtextgenPackage.GEN_MODEL__SERVICES:
				return getServices();
			case XtextgenPackage.GEN_MODEL__LANGUAGE_INTERFACE_FQ_NAME:
				return getLanguageInterfaceFQName();
			case XtextgenPackage.GEN_MODEL__NON_UI_PLUGIN_BUNDLE_ID:
				return getNonUIPluginBundleID();
			case XtextgenPackage.GEN_MODEL__UI_PLUGIN_BUNDLE_ID:
				return getUiPluginBundleID();
			case XtextgenPackage.GEN_MODEL__OUTLETS:
				return getOutlets();
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
			case XtextgenPackage.GEN_MODEL__SERVICES:
				getServices().clear();
				getServices().addAll((Collection<? extends GenService>)newValue);
				return;
			case XtextgenPackage.GEN_MODEL__LANGUAGE_INTERFACE_FQ_NAME:
				setLanguageInterfaceFQName((String)newValue);
				return;
			case XtextgenPackage.GEN_MODEL__NON_UI_PLUGIN_BUNDLE_ID:
				setNonUIPluginBundleID((String)newValue);
				return;
			case XtextgenPackage.GEN_MODEL__UI_PLUGIN_BUNDLE_ID:
				setUiPluginBundleID((String)newValue);
				return;
			case XtextgenPackage.GEN_MODEL__OUTLETS:
				getOutlets().clear();
				getOutlets().addAll((Collection<? extends Outlet>)newValue);
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
			case XtextgenPackage.GEN_MODEL__SERVICES:
				getServices().clear();
				return;
			case XtextgenPackage.GEN_MODEL__LANGUAGE_INTERFACE_FQ_NAME:
				setLanguageInterfaceFQName(LANGUAGE_INTERFACE_FQ_NAME_EDEFAULT);
				return;
			case XtextgenPackage.GEN_MODEL__NON_UI_PLUGIN_BUNDLE_ID:
				setNonUIPluginBundleID(NON_UI_PLUGIN_BUNDLE_ID_EDEFAULT);
				return;
			case XtextgenPackage.GEN_MODEL__UI_PLUGIN_BUNDLE_ID:
				setUiPluginBundleID(UI_PLUGIN_BUNDLE_ID_EDEFAULT);
				return;
			case XtextgenPackage.GEN_MODEL__OUTLETS:
				getOutlets().clear();
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
			case XtextgenPackage.GEN_MODEL__SERVICES:
				return services != null && !services.isEmpty();
			case XtextgenPackage.GEN_MODEL__LANGUAGE_INTERFACE_FQ_NAME:
				return LANGUAGE_INTERFACE_FQ_NAME_EDEFAULT == null ? languageInterfaceFQName != null : !LANGUAGE_INTERFACE_FQ_NAME_EDEFAULT.equals(languageInterfaceFQName);
			case XtextgenPackage.GEN_MODEL__NON_UI_PLUGIN_BUNDLE_ID:
				return NON_UI_PLUGIN_BUNDLE_ID_EDEFAULT == null ? nonUIPluginBundleID != null : !NON_UI_PLUGIN_BUNDLE_ID_EDEFAULT.equals(nonUIPluginBundleID);
			case XtextgenPackage.GEN_MODEL__UI_PLUGIN_BUNDLE_ID:
				return UI_PLUGIN_BUNDLE_ID_EDEFAULT == null ? uiPluginBundleID != null : !UI_PLUGIN_BUNDLE_ID_EDEFAULT.equals(uiPluginBundleID);
			case XtextgenPackage.GEN_MODEL__OUTLETS:
				return outlets != null && !outlets.isEmpty();
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
		result.append(", languageInterfaceFQName: ");
		result.append(languageInterfaceFQName);
		result.append(", nonUIPluginBundleID: ");
		result.append(nonUIPluginBundleID);
		result.append(", uiPluginBundleID: ");
		result.append(uiPluginBundleID);
		result.append(')');
		return result.toString();
	}

} //GenModelImpl
