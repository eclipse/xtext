/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtextgenPackage.java,v 1.2 2008/06/09 12:52:54 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextgen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xtextgen.XtextgenFactory
 * @model kind="package"
 * @generated
 */
public interface XtextgenPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "xtextgen";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "htpp://www.eclipse.org/xtext/2008/xtextgen";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "xtextgen";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    XtextgenPackage eINSTANCE = org.eclipse.xtext.xtextgen.impl.XtextgenPackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.xtext.xtextgen.impl.GenServiceImpl <em>Gen Service</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextgen.impl.GenServiceImpl
     * @see org.eclipse.xtext.xtextgen.impl.XtextgenPackageImpl#getGenService()
     * @generated
     */
    int GEN_SERVICE = 0;

    /**
     * The feature id for the '<em><b>Service Interface FQ Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GEN_SERVICE__SERVICE_INTERFACE_FQ_NAME = 0;

    /**
     * The feature id for the '<em><b>Gen Class FQ Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GEN_SERVICE__GEN_CLASS_FQ_NAME = 1;

    /**
     * The feature id for the '<em><b>Extension Point ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GEN_SERVICE__EXTENSION_POINT_ID = 2;

    /**
     * The feature id for the '<em><b>Template Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GEN_SERVICE__TEMPLATE_PATH = 3;

    /**
     * The feature id for the '<em><b>Gen Parameters</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GEN_SERVICE__GEN_PARAMETERS = 4;

    /**
     * The number of structural features of the '<em>Gen Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GEN_SERVICE_FEATURE_COUNT = 5;

    /**
     * The meta object id for the '{@link org.eclipse.xtext.xtextgen.impl.GenModelImpl <em>Gen Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextgen.impl.GenModelImpl
     * @see org.eclipse.xtext.xtextgen.impl.XtextgenPackageImpl#getGenModel()
     * @generated
     */
    int GEN_MODEL = 1;

    /**
     * The feature id for the '<em><b>Model File Extensions</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GEN_MODEL__MODEL_FILE_EXTENSIONS = 0;

    /**
     * The feature id for the '<em><b>File Header</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GEN_MODEL__FILE_HEADER = 1;

    /**
     * The feature id for the '<em><b>Grammar</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GEN_MODEL__GRAMMAR = 2;

    /**
     * The feature id for the '<em><b>Grammar Resource URI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GEN_MODEL__GRAMMAR_RESOURCE_URI = 3;

    /**
     * The feature id for the '<em><b>Services</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GEN_MODEL__SERVICES = 4;

    /**
     * The feature id for the '<em><b>Outlet Map</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GEN_MODEL__OUTLET_MAP = 5;

    /**
     * The feature id for the '<em><b>Language Interface FQ Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GEN_MODEL__LANGUAGE_INTERFACE_FQ_NAME = 6;

    /**
     * The feature id for the '<em><b>Standalone Setup Class FQ Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GEN_MODEL__STANDALONE_SETUP_CLASS_FQ_NAME = 7;

    /**
     * The feature id for the '<em><b>Non UI Plugin Bundle ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GEN_MODEL__NON_UI_PLUGIN_BUNDLE_ID = 8;

    /**
     * The feature id for the '<em><b>Ui Plugin Bundle ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GEN_MODEL__UI_PLUGIN_BUNDLE_ID = 9;

    /**
     * The number of structural features of the '<em>Gen Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GEN_MODEL_FEATURE_COUNT = 10;


    /**
     * Returns the meta object for class '{@link org.eclipse.xtext.xtextgen.GenService <em>Gen Service</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Gen Service</em>'.
     * @see org.eclipse.xtext.xtextgen.GenService
     * @generated
     */
    EClass getGenService();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextgen.GenService#getServiceInterfaceFQName <em>Service Interface FQ Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Service Interface FQ Name</em>'.
     * @see org.eclipse.xtext.xtextgen.GenService#getServiceInterfaceFQName()
     * @see #getGenService()
     * @generated
     */
    EAttribute getGenService_ServiceInterfaceFQName();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextgen.GenService#getGenClassFQName <em>Gen Class FQ Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Gen Class FQ Name</em>'.
     * @see org.eclipse.xtext.xtextgen.GenService#getGenClassFQName()
     * @see #getGenService()
     * @generated
     */
    EAttribute getGenService_GenClassFQName();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextgen.GenService#getExtensionPointID <em>Extension Point ID</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Extension Point ID</em>'.
     * @see org.eclipse.xtext.xtextgen.GenService#getExtensionPointID()
     * @see #getGenService()
     * @generated
     */
    EAttribute getGenService_ExtensionPointID();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextgen.GenService#getTemplatePath <em>Template Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Template Path</em>'.
     * @see org.eclipse.xtext.xtextgen.GenService#getTemplatePath()
     * @see #getGenService()
     * @generated
     */
    EAttribute getGenService_TemplatePath();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.xtext.xtextgen.GenService#getGenParameters <em>Gen Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Gen Parameters</em>'.
     * @see org.eclipse.xtext.xtextgen.GenService#getGenParameters()
     * @see #getGenService()
     * @generated
     */
    EReference getGenService_GenParameters();

    /**
     * Returns the meta object for class '{@link org.eclipse.xtext.xtextgen.GenModel <em>Gen Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Gen Model</em>'.
     * @see org.eclipse.xtext.xtextgen.GenModel
     * @generated
     */
    EClass getGenModel();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.xtext.xtextgen.GenModel#getModelFileExtensions <em>Model File Extensions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Model File Extensions</em>'.
     * @see org.eclipse.xtext.xtextgen.GenModel#getModelFileExtensions()
     * @see #getGenModel()
     * @generated
     */
    EAttribute getGenModel_ModelFileExtensions();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextgen.GenModel#getFileHeader <em>File Header</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>File Header</em>'.
     * @see org.eclipse.xtext.xtextgen.GenModel#getFileHeader()
     * @see #getGenModel()
     * @generated
     */
    EAttribute getGenModel_FileHeader();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextgen.GenModel#getGrammar <em>Grammar</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Grammar</em>'.
     * @see org.eclipse.xtext.xtextgen.GenModel#getGrammar()
     * @see #getGenModel()
     * @generated
     */
    EReference getGenModel_Grammar();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextgen.GenModel#getGrammarResourceURI <em>Grammar Resource URI</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Grammar Resource URI</em>'.
     * @see org.eclipse.xtext.xtextgen.GenModel#getGrammarResourceURI()
     * @see #getGenModel()
     * @generated
     */
    EAttribute getGenModel_GrammarResourceURI();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.xtext.xtextgen.GenModel#getServices <em>Services</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Services</em>'.
     * @see org.eclipse.xtext.xtextgen.GenModel#getServices()
     * @see #getGenModel()
     * @generated
     */
    EReference getGenModel_Services();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.xtext.xtextgen.GenModel#getOutletMap <em>Outlet Map</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Outlet Map</em>'.
     * @see org.eclipse.xtext.xtextgen.GenModel#getOutletMap()
     * @see #getGenModel()
     * @generated
     */
    EReference getGenModel_OutletMap();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextgen.GenModel#getUiPluginBundleID <em>Ui Plugin Bundle ID</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ui Plugin Bundle ID</em>'.
     * @see org.eclipse.xtext.xtextgen.GenModel#getUiPluginBundleID()
     * @see #getGenModel()
     * @generated
     */
    EAttribute getGenModel_UiPluginBundleID();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextgen.GenModel#getLanguageInterfaceFQName <em>Language Interface FQ Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Language Interface FQ Name</em>'.
     * @see org.eclipse.xtext.xtextgen.GenModel#getLanguageInterfaceFQName()
     * @see #getGenModel()
     * @generated
     */
    EAttribute getGenModel_LanguageInterfaceFQName();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextgen.GenModel#getStandaloneSetupClassFQName <em>Standalone Setup Class FQ Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Standalone Setup Class FQ Name</em>'.
     * @see org.eclipse.xtext.xtextgen.GenModel#getStandaloneSetupClassFQName()
     * @see #getGenModel()
     * @generated
     */
    EAttribute getGenModel_StandaloneSetupClassFQName();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextgen.GenModel#getNonUIPluginBundleID <em>Non UI Plugin Bundle ID</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Non UI Plugin Bundle ID</em>'.
     * @see org.eclipse.xtext.xtextgen.GenModel#getNonUIPluginBundleID()
     * @see #getGenModel()
     * @generated
     */
    EAttribute getGenModel_NonUIPluginBundleID();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    XtextgenFactory getXtextgenFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link org.eclipse.xtext.xtextgen.impl.GenServiceImpl <em>Gen Service</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.xtext.xtextgen.impl.GenServiceImpl
         * @see org.eclipse.xtext.xtextgen.impl.XtextgenPackageImpl#getGenService()
         * @generated
         */
        EClass GEN_SERVICE = eINSTANCE.getGenService();

        /**
         * The meta object literal for the '<em><b>Service Interface FQ Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GEN_SERVICE__SERVICE_INTERFACE_FQ_NAME = eINSTANCE.getGenService_ServiceInterfaceFQName();

        /**
         * The meta object literal for the '<em><b>Gen Class FQ Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GEN_SERVICE__GEN_CLASS_FQ_NAME = eINSTANCE.getGenService_GenClassFQName();

        /**
         * The meta object literal for the '<em><b>Extension Point ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GEN_SERVICE__EXTENSION_POINT_ID = eINSTANCE.getGenService_ExtensionPointID();

        /**
         * The meta object literal for the '<em><b>Template Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GEN_SERVICE__TEMPLATE_PATH = eINSTANCE.getGenService_TemplatePath();

        /**
         * The meta object literal for the '<em><b>Gen Parameters</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GEN_SERVICE__GEN_PARAMETERS = eINSTANCE.getGenService_GenParameters();

        /**
         * The meta object literal for the '{@link org.eclipse.xtext.xtextgen.impl.GenModelImpl <em>Gen Model</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.xtext.xtextgen.impl.GenModelImpl
         * @see org.eclipse.xtext.xtextgen.impl.XtextgenPackageImpl#getGenModel()
         * @generated
         */
        EClass GEN_MODEL = eINSTANCE.getGenModel();

        /**
         * The meta object literal for the '<em><b>Model File Extensions</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GEN_MODEL__MODEL_FILE_EXTENSIONS = eINSTANCE.getGenModel_ModelFileExtensions();

        /**
         * The meta object literal for the '<em><b>File Header</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GEN_MODEL__FILE_HEADER = eINSTANCE.getGenModel_FileHeader();

        /**
         * The meta object literal for the '<em><b>Grammar</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GEN_MODEL__GRAMMAR = eINSTANCE.getGenModel_Grammar();

        /**
         * The meta object literal for the '<em><b>Grammar Resource URI</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GEN_MODEL__GRAMMAR_RESOURCE_URI = eINSTANCE.getGenModel_GrammarResourceURI();

        /**
         * The meta object literal for the '<em><b>Services</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GEN_MODEL__SERVICES = eINSTANCE.getGenModel_Services();

        /**
         * The meta object literal for the '<em><b>Outlet Map</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GEN_MODEL__OUTLET_MAP = eINSTANCE.getGenModel_OutletMap();

        /**
         * The meta object literal for the '<em><b>Ui Plugin Bundle ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GEN_MODEL__UI_PLUGIN_BUNDLE_ID = eINSTANCE.getGenModel_UiPluginBundleID();

        /**
         * The meta object literal for the '<em><b>Language Interface FQ Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GEN_MODEL__LANGUAGE_INTERFACE_FQ_NAME = eINSTANCE.getGenModel_LanguageInterfaceFQName();

        /**
         * The meta object literal for the '<em><b>Standalone Setup Class FQ Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GEN_MODEL__STANDALONE_SETUP_CLASS_FQ_NAME = eINSTANCE.getGenModel_StandaloneSetupClassFQName();

        /**
         * The meta object literal for the '<em><b>Non UI Plugin Bundle ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GEN_MODEL__NON_UI_PLUGIN_BUNDLE_ID = eINSTANCE.getGenModel_NonUIPluginBundleID();

    }

} //XtextgenPackage
