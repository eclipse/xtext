/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtextgenPackageImpl.java,v 1.5 2008/07/14 08:15:32 sefftinge Exp $
 */
package org.eclipse.xtext.xtextgen.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.xtextgen.GenModel;
import org.eclipse.xtext.xtextgen.GenService;
import org.eclipse.xtext.xtextgen.Outlet;
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
	private EClass outletEClass = null;

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
	public EAttribute getGenService_GenClassFQName() {
		return (EAttribute)genServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenService_ExtensionPointID() {
		return (EAttribute)genServiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenService_TemplatePath() {
		return (EAttribute)genServiceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenService_GenParameters() {
		return (EAttribute)genServiceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenService_UiService() {
		return (EAttribute)genServiceEClass.getEStructuralFeatures().get(4);
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
	public EReference getGenModel_Services() {
		return (EReference)genModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenModel_LanguageInterfaceFQName() {
		return (EAttribute)genModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenModel_NonUIPluginBundleID() {
		return (EAttribute)genModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenModel_UiPluginBundleID() {
		return (EAttribute)genModelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenModel_Outlets() {
		return (EReference)genModelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutlet() {
		return outletEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutlet_Name() {
		return (EAttribute)outletEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutlet_TargetFolder() {
		return (EAttribute)outletEClass.getEStructuralFeatures().get(1);
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
		createEAttribute(genServiceEClass, GEN_SERVICE__GEN_CLASS_FQ_NAME);
		createEAttribute(genServiceEClass, GEN_SERVICE__EXTENSION_POINT_ID);
		createEAttribute(genServiceEClass, GEN_SERVICE__TEMPLATE_PATH);
		createEAttribute(genServiceEClass, GEN_SERVICE__UI_SERVICE);
		createEAttribute(genServiceEClass, GEN_SERVICE__GEN_PARAMETERS);

		genModelEClass = createEClass(GEN_MODEL);
		createEAttribute(genModelEClass, GEN_MODEL__MODEL_FILE_EXTENSIONS);
		createEAttribute(genModelEClass, GEN_MODEL__FILE_HEADER);
		createEReference(genModelEClass, GEN_MODEL__GRAMMAR);
		createEReference(genModelEClass, GEN_MODEL__SERVICES);
		createEAttribute(genModelEClass, GEN_MODEL__LANGUAGE_INTERFACE_FQ_NAME);
		createEAttribute(genModelEClass, GEN_MODEL__NON_UI_PLUGIN_BUNDLE_ID);
		createEAttribute(genModelEClass, GEN_MODEL__UI_PLUGIN_BUNDLE_ID);
		createEReference(genModelEClass, GEN_MODEL__OUTLETS);

		outletEClass = createEClass(OUTLET);
		createEAttribute(outletEClass, OUTLET__NAME);
		createEAttribute(outletEClass, OUTLET__TARGET_FOLDER);
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

		// Initialize classes and features; add operations and parameters
		initEClass(genServiceEClass, GenService.class, "GenService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenService_ServiceInterfaceFQName(), ecorePackage.getEString(), "serviceInterfaceFQName", null, 0, 1, GenService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenService_GenClassFQName(), ecorePackage.getEString(), "genClassFQName", null, 0, 1, GenService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenService_ExtensionPointID(), ecorePackage.getEString(), "extensionPointID", null, 0, 1, GenService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenService_TemplatePath(), ecorePackage.getEString(), "templatePath", null, 0, 1, GenService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenService_UiService(), ecorePackage.getEBoolean(), "uiService", null, 0, 1, GenService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		initEAttribute(getGenService_GenParameters(), g1, "genParameters", null, 0, 1, GenService.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genModelEClass, GenModel.class, "GenModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenModel_ModelFileExtensions(), ecorePackage.getEString(), "modelFileExtensions", null, 0, -1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenModel_FileHeader(), ecorePackage.getEString(), "fileHeader", null, 0, 1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenModel_Grammar(), theXtextPackage.getGrammar(), null, "grammar", null, 0, 1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenModel_Services(), this.getGenService(), null, "services", null, 0, -1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenModel_LanguageInterfaceFQName(), ecorePackage.getEString(), "languageInterfaceFQName", null, 0, 1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenModel_NonUIPluginBundleID(), ecorePackage.getEString(), "nonUIPluginBundleID", null, 0, 1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenModel_UiPluginBundleID(), ecorePackage.getEString(), "uiPluginBundleID", null, 0, 1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenModel_Outlets(), this.getOutlet(), null, "outlets", null, 0, -1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outletEClass, Outlet.class, "Outlet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOutlet_Name(), ecorePackage.getEString(), "name", null, 0, 1, Outlet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOutlet_TargetFolder(), ecorePackage.getEString(), "targetFolder", null, 0, 1, Outlet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //XtextgenPackageImpl
