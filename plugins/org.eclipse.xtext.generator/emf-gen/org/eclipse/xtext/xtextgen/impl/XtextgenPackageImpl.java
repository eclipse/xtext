/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtextgenPackageImpl.java,v 1.1 2008/06/06 16:15:42 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextgen.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.xtextgen.GenClass;
import org.eclipse.xtext.xtextgen.GenModel;
import org.eclipse.xtext.xtextgen.GenPlugin;
import org.eclipse.xtext.xtextgen.GenService;
import org.eclipse.xtext.xtextgen.RootTemplate;
import org.eclipse.xtext.xtextgen.XtextgenFactory;
import org.eclipse.xtext.xtextgen.XtextgenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtextgenPackageImpl extends EPackageImpl implements XtextgenPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass genServiceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass genModelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rootTemplateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass genClassEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass genPluginEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.xtext.xtextgen.XtextgenPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private XtextgenPackageImpl() {
        super(eNS_URI, XtextgenFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this
     * model, and for any others upon which it depends.  Simple
     * dependencies are satisfied by calling this method on all
     * dependent packages before doing anything else.  This method drives
     * initialization for interdependent packages directly, in parallel
     * with this package, itself.
     * <p>Of this package and its interdependencies, all packages which
     * have not yet been registered by their URI values are first created
     * and registered.  The packages are then initialized in two steps:
     * meta-model objects for all of the packages are created before any
     * are initialized, since one package's meta-model objects may refer to
     * those of another.
     * <p>Invocation of this method will not affect any packages that have
     * already been initialized.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static XtextgenPackage init() {
        if (isInited) return (XtextgenPackage)EPackage.Registry.INSTANCE.getEPackage(XtextgenPackage.eNS_URI);

        // Obtain or create and register package
        XtextgenPackageImpl theXtextgenPackage = (XtextgenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof XtextgenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new XtextgenPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        XtextPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theXtextgenPackage.createPackageContents();

        // Initialize created meta-data
        theXtextgenPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theXtextgenPackage.freeze();

        return theXtextgenPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGenService() {
        return genServiceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGenService_ServiceInterfaceFQName() {
        return (EAttribute)genServiceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGenService_ExtensionPointID() {
        return (EAttribute)genServiceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGenModel() {
        return genModelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGenModel_ModelFileExtensions() {
        return (EAttribute)genModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGenModel_FileHeader() {
        return (EAttribute)genModelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGenModel_Grammar() {
        return (EReference)genModelEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGenModel_GrammarResourceURI() {
        return (EAttribute)genModelEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGenModel_RootTemplates() {
        return (EReference)genModelEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGenModel_OutletMap() {
        return (EReference)genModelEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRootTemplate() {
        return rootTemplateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRootTemplate_TemplatePath() {
        return (EAttribute)rootTemplateEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRootTemplate_GenParameters() {
        return (EReference)rootTemplateEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGenClass() {
        return genClassEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGenClass_GenClassFQName() {
        return (EAttribute)genClassEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGenPlugin() {
        return genPluginEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGenPlugin_BundleID() {
        return (EAttribute)genPluginEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XtextgenFactory getXtextgenFactory() {
        return (XtextgenFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        genServiceEClass = createEClass(GEN_SERVICE);
        createEAttribute(genServiceEClass, GEN_SERVICE__SERVICE_INTERFACE_FQ_NAME);
        createEAttribute(genServiceEClass, GEN_SERVICE__EXTENSION_POINT_ID);

        genModelEClass = createEClass(GEN_MODEL);
        createEAttribute(genModelEClass, GEN_MODEL__MODEL_FILE_EXTENSIONS);
        createEAttribute(genModelEClass, GEN_MODEL__FILE_HEADER);
        createEReference(genModelEClass, GEN_MODEL__GRAMMAR);
        createEAttribute(genModelEClass, GEN_MODEL__GRAMMAR_RESOURCE_URI);
        createEReference(genModelEClass, GEN_MODEL__ROOT_TEMPLATES);
        createEReference(genModelEClass, GEN_MODEL__OUTLET_MAP);

        rootTemplateEClass = createEClass(ROOT_TEMPLATE);
        createEAttribute(rootTemplateEClass, ROOT_TEMPLATE__TEMPLATE_PATH);
        createEReference(rootTemplateEClass, ROOT_TEMPLATE__GEN_PARAMETERS);

        genClassEClass = createEClass(GEN_CLASS);
        createEAttribute(genClassEClass, GEN_CLASS__GEN_CLASS_FQ_NAME);

        genPluginEClass = createEClass(GEN_PLUGIN);
        createEAttribute(genPluginEClass, GEN_PLUGIN__BUNDLE_ID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        XtextPackage theXtextPackage = (XtextPackage)EPackage.Registry.INSTANCE.getEPackage(XtextPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        genServiceEClass.getESuperTypes().add(this.getGenClass());
        genClassEClass.getESuperTypes().add(this.getRootTemplate());
        genPluginEClass.getESuperTypes().add(this.getRootTemplate());

        // Initialize classes and features; add operations and parameters
        initEClass(genServiceEClass, GenService.class, "GenService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getGenService_ServiceInterfaceFQName(), ecorePackage.getEString(), "serviceInterfaceFQName", null, 0, 1, GenService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGenService_ExtensionPointID(), ecorePackage.getEString(), "extensionPointID", null, 0, 1, GenService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(genServiceEClass, ecorePackage.getEString(), "serviceInterfaceName", 0, 1, IS_UNIQUE, IS_ORDERED);

        addEOperation(genServiceEClass, ecorePackage.getEString(), "extensionPointName", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(genModelEClass, GenModel.class, "GenModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getGenModel_ModelFileExtensions(), ecorePackage.getEString(), "modelFileExtensions", null, 0, -1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGenModel_FileHeader(), ecorePackage.getEString(), "fileHeader", null, 0, 1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getGenModel_Grammar(), theXtextPackage.getGrammar(), null, "grammar", null, 0, 1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGenModel_GrammarResourceURI(), ecorePackage.getEString(), "grammarResourceURI", null, 0, 1, GenModel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getGenModel_RootTemplates(), this.getRootTemplate(), null, "rootTemplates", null, 0, -1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getGenModel_OutletMap(), ecorePackage.getEStringToStringMapEntry(), null, "outletMap", null, 0, -1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rootTemplateEClass, RootTemplate.class, "RootTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRootTemplate_TemplatePath(), ecorePackage.getEString(), "templatePath", null, 0, 1, RootTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRootTemplate_GenParameters(), ecorePackage.getEStringToStringMapEntry(), null, "genParameters", null, 0, -1, RootTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(genClassEClass, GenClass.class, "GenClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getGenClass_GenClassFQName(), ecorePackage.getEString(), "genClassFQName", null, 0, 1, GenClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(genClassEClass, ecorePackage.getEString(), "genClassPackageFQName", 0, 1, IS_UNIQUE, IS_ORDERED);

        addEOperation(genClassEClass, ecorePackage.getEString(), "genClassName", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(genPluginEClass, GenPlugin.class, "GenPlugin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getGenPlugin_BundleID(), ecorePackage.getEString(), "bundleID", null, 0, 1, GenPlugin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //XtextgenPackageImpl
