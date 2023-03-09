/**
 */
package org.eclipse.xtext.builder.trace.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.xtext.builder.trace.DebugLocationData;
import org.eclipse.xtext.builder.trace.DebugTraceRegion;
import org.eclipse.xtext.builder.trace.TraceFactory;
import org.eclipse.xtext.builder.trace.TracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TracePackageImpl extends EPackageImpl implements TracePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass debugTraceRegionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass debugLocationDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

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
	 * @see org.eclipse.xtext.builder.trace.TracePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TracePackageImpl() {
		super(eNS_URI, TraceFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link TracePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TracePackage init() {
		if (isInited) return (TracePackage)EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTracePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TracePackageImpl theTracePackage = registeredTracePackage instanceof TracePackageImpl ? (TracePackageImpl)registeredTracePackage : new TracePackageImpl();

		isInited = true;

		// Create package meta-data objects
		theTracePackage.createPackageContents();

		// Initialize created meta-data
		theTracePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTracePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TracePackage.eNS_URI, theTracePackage);
		return theTracePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDebugTraceRegion() {
		return debugTraceRegionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDebugTraceRegion_NestedRegions() {
		return (EReference)debugTraceRegionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDebugTraceRegion_MyEndOffset() {
		return (EAttribute)debugTraceRegionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDebugTraceRegion_Associations() {
		return (EReference)debugTraceRegionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDebugTraceRegion_UseForDebugging() {
		return (EAttribute)debugTraceRegionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDebugLocationData() {
		return debugLocationDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDebugLocationData_Label() {
		return (EAttribute)debugLocationDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDebugLocationData_Offset() {
		return (EAttribute)debugLocationDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDebugLocationData_Length() {
		return (EAttribute)debugLocationDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDebugLocationData_LineNumber() {
		return (EAttribute)debugLocationDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDebugLocationData_EndLineNumber() {
		return (EAttribute)debugLocationDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDebugLocationData_Path() {
		return (EAttribute)debugLocationDataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDebugLocationData_EndOffset() {
		return (EAttribute)debugLocationDataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDebugTraceRegion_Label() {
		return (EAttribute)debugTraceRegionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDebugTraceRegion_MyOffset() {
		return (EAttribute)debugTraceRegionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDebugTraceRegion_MyLength() {
		return (EAttribute)debugTraceRegionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDebugTraceRegion_MyLineNumber() {
		return (EAttribute)debugTraceRegionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDebugTraceRegion_MyEndLineNumber() {
		return (EAttribute)debugTraceRegionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TraceFactory getTraceFactory() {
		return (TraceFactory)getEFactoryInstance();
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
		debugTraceRegionEClass = createEClass(DEBUG_TRACE_REGION);
		createEAttribute(debugTraceRegionEClass, DEBUG_TRACE_REGION__LABEL);
		createEAttribute(debugTraceRegionEClass, DEBUG_TRACE_REGION__MY_OFFSET);
		createEAttribute(debugTraceRegionEClass, DEBUG_TRACE_REGION__MY_LENGTH);
		createEAttribute(debugTraceRegionEClass, DEBUG_TRACE_REGION__MY_LINE_NUMBER);
		createEAttribute(debugTraceRegionEClass, DEBUG_TRACE_REGION__MY_END_LINE_NUMBER);
		createEReference(debugTraceRegionEClass, DEBUG_TRACE_REGION__NESTED_REGIONS);
		createEAttribute(debugTraceRegionEClass, DEBUG_TRACE_REGION__MY_END_OFFSET);
		createEReference(debugTraceRegionEClass, DEBUG_TRACE_REGION__ASSOCIATIONS);
		createEAttribute(debugTraceRegionEClass, DEBUG_TRACE_REGION__USE_FOR_DEBUGGING);

		debugLocationDataEClass = createEClass(DEBUG_LOCATION_DATA);
		createEAttribute(debugLocationDataEClass, DEBUG_LOCATION_DATA__LABEL);
		createEAttribute(debugLocationDataEClass, DEBUG_LOCATION_DATA__OFFSET);
		createEAttribute(debugLocationDataEClass, DEBUG_LOCATION_DATA__LENGTH);
		createEAttribute(debugLocationDataEClass, DEBUG_LOCATION_DATA__LINE_NUMBER);
		createEAttribute(debugLocationDataEClass, DEBUG_LOCATION_DATA__END_LINE_NUMBER);
		createEAttribute(debugLocationDataEClass, DEBUG_LOCATION_DATA__PATH);
		createEAttribute(debugLocationDataEClass, DEBUG_LOCATION_DATA__END_OFFSET);

		// Create data types
		uriEDataType = createEDataType(URI);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(debugTraceRegionEClass, DebugTraceRegion.class, "DebugTraceRegion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDebugTraceRegion_Label(), ecorePackage.getEString(), "label", null, 0, 1, DebugTraceRegion.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugTraceRegion_MyOffset(), ecorePackage.getEInt(), "myOffset", null, 0, 1, DebugTraceRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugTraceRegion_MyLength(), ecorePackage.getEInt(), "myLength", null, 0, 1, DebugTraceRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugTraceRegion_MyLineNumber(), ecorePackage.getEInt(), "myLineNumber", null, 0, 1, DebugTraceRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugTraceRegion_MyEndLineNumber(), ecorePackage.getEInt(), "myEndLineNumber", null, 0, 1, DebugTraceRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDebugTraceRegion_NestedRegions(), this.getDebugTraceRegion(), null, "nestedRegions", null, 0, -1, DebugTraceRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugTraceRegion_MyEndOffset(), ecorePackage.getEInt(), "myEndOffset", null, 0, 1, DebugTraceRegion.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDebugTraceRegion_Associations(), this.getDebugLocationData(), null, "associations", null, 0, -1, DebugTraceRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugTraceRegion_UseForDebugging(), ecorePackage.getEBoolean(), "useForDebugging", null, 0, 1, DebugTraceRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(debugLocationDataEClass, DebugLocationData.class, "DebugLocationData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDebugLocationData_Label(), ecorePackage.getEString(), "label", null, 0, 1, DebugLocationData.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugLocationData_Offset(), ecorePackage.getEInt(), "offset", null, 0, 1, DebugLocationData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugLocationData_Length(), ecorePackage.getEInt(), "length", null, 0, 1, DebugLocationData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugLocationData_LineNumber(), ecorePackage.getEInt(), "lineNumber", null, 0, 1, DebugLocationData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugLocationData_EndLineNumber(), ecorePackage.getEInt(), "endLineNumber", null, 0, 1, DebugLocationData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugLocationData_Path(), this.getURI(), "path", null, 0, 1, DebugLocationData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugLocationData_EndOffset(), ecorePackage.getEInt(), "endOffset", null, 0, 1, DebugLocationData.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //TracePackageImpl
