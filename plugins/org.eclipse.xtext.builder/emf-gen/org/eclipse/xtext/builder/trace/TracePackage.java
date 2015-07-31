/**
 */
package org.eclipse.xtext.builder.trace;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.eclipse.xtext.builder.trace.TraceFactory
 * @model kind="package"
 * @generated
 */
public interface TracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "trace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/xtext/trace/debug/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "trace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TracePackage eINSTANCE = org.eclipse.xtext.builder.trace.impl.TracePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl <em>Debug Trace Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl
	 * @see org.eclipse.xtext.builder.trace.impl.TracePackageImpl#getDebugTraceRegion()
	 * @generated
	 */
	int DEBUG_TRACE_REGION = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__LABEL = 0;

	/**
	 * The feature id for the '<em><b>My Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__MY_OFFSET = 1;

	/**
	 * The feature id for the '<em><b>My Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__MY_LENGTH = 2;

	/**
	 * The feature id for the '<em><b>My Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__MY_LINE_NUMBER = 3;

	/**
	 * The feature id for the '<em><b>My End Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__MY_END_LINE_NUMBER = 4;

	/**
	 * The feature id for the '<em><b>Nested Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__NESTED_REGIONS = 5;

	/**
	 * The feature id for the '<em><b>My End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__MY_END_OFFSET = 6;

	/**
	 * The feature id for the '<em><b>Associations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__ASSOCIATIONS = 7;

	/**
	 * The feature id for the '<em><b>Use For Debugging</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__USE_FOR_DEBUGGING = 8;

	/**
	 * The number of structural features of the '<em>Debug Trace Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.builder.trace.impl.DebugLocationDataImpl <em>Debug Location Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.builder.trace.impl.DebugLocationDataImpl
	 * @see org.eclipse.xtext.builder.trace.impl.TracePackageImpl#getDebugLocationData()
	 * @generated
	 */
	int DEBUG_LOCATION_DATA = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_LOCATION_DATA__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_LOCATION_DATA__OFFSET = 1;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_LOCATION_DATA__LENGTH = 2;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_LOCATION_DATA__LINE_NUMBER = 3;

	/**
	 * The feature id for the '<em><b>End Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_LOCATION_DATA__END_LINE_NUMBER = 4;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_LOCATION_DATA__PATH = 5;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_LOCATION_DATA__END_OFFSET = 6;

	/**
	 * The number of structural features of the '<em>Debug Location Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_LOCATION_DATA_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.eclipse.xtext.builder.trace.impl.TracePackageImpl#getURI()
	 * @generated
	 */
	int URI = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion <em>Debug Trace Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Debug Trace Region</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion
	 * @generated
	 */
	EClass getDebugTraceRegion();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getNestedRegions <em>Nested Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nested Regions</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion#getNestedRegions()
	 * @see #getDebugTraceRegion()
	 * @generated
	 */
	EReference getDebugTraceRegion_NestedRegions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyEndOffset <em>My End Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>My End Offset</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyEndOffset()
	 * @see #getDebugTraceRegion()
	 * @generated
	 */
	EAttribute getDebugTraceRegion_MyEndOffset();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getAssociations <em>Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Associations</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion#getAssociations()
	 * @see #getDebugTraceRegion()
	 * @generated
	 */
	EReference getDebugTraceRegion_Associations();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#isUseForDebugging <em>Use For Debugging</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use For Debugging</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion#isUseForDebugging()
	 * @see #getDebugTraceRegion()
	 * @generated
	 */
	EAttribute getDebugTraceRegion_UseForDebugging();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.builder.trace.DebugLocationData <em>Debug Location Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Debug Location Data</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugLocationData
	 * @generated
	 */
	EClass getDebugLocationData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugLocationData#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugLocationData#getLabel()
	 * @see #getDebugLocationData()
	 * @generated
	 */
	EAttribute getDebugLocationData_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugLocationData#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugLocationData#getOffset()
	 * @see #getDebugLocationData()
	 * @generated
	 */
	EAttribute getDebugLocationData_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugLocationData#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugLocationData#getLength()
	 * @see #getDebugLocationData()
	 * @generated
	 */
	EAttribute getDebugLocationData_Length();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugLocationData#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Number</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugLocationData#getLineNumber()
	 * @see #getDebugLocationData()
	 * @generated
	 */
	EAttribute getDebugLocationData_LineNumber();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugLocationData#getEndLineNumber <em>End Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Line Number</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugLocationData#getEndLineNumber()
	 * @see #getDebugLocationData()
	 * @generated
	 */
	EAttribute getDebugLocationData_EndLineNumber();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugLocationData#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugLocationData#getPath()
	 * @see #getDebugLocationData()
	 * @generated
	 */
	EAttribute getDebugLocationData_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugLocationData#getEndOffset <em>End Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Offset</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugLocationData#getEndOffset()
	 * @see #getDebugLocationData()
	 * @generated
	 */
	EAttribute getDebugLocationData_EndOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion#getLabel()
	 * @see #getDebugTraceRegion()
	 * @generated
	 */
	EAttribute getDebugTraceRegion_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyOffset <em>My Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>My Offset</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyOffset()
	 * @see #getDebugTraceRegion()
	 * @generated
	 */
	EAttribute getDebugTraceRegion_MyOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyLength <em>My Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>My Length</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyLength()
	 * @see #getDebugTraceRegion()
	 * @generated
	 */
	EAttribute getDebugTraceRegion_MyLength();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyLineNumber <em>My Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>My Line Number</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyLineNumber()
	 * @see #getDebugTraceRegion()
	 * @generated
	 */
	EAttribute getDebugTraceRegion_MyLineNumber();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyEndLineNumber <em>My End Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>My End Line Number</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyEndLineNumber()
	 * @see #getDebugTraceRegion()
	 * @generated
	 */
	EAttribute getDebugTraceRegion_MyEndLineNumber();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TraceFactory getTraceFactory();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl <em>Debug Trace Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl
		 * @see org.eclipse.xtext.builder.trace.impl.TracePackageImpl#getDebugTraceRegion()
		 * @generated
		 */
		EClass DEBUG_TRACE_REGION = eINSTANCE.getDebugTraceRegion();

		/**
		 * The meta object literal for the '<em><b>Nested Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEBUG_TRACE_REGION__NESTED_REGIONS = eINSTANCE.getDebugTraceRegion_NestedRegions();

		/**
		 * The meta object literal for the '<em><b>My End Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_TRACE_REGION__MY_END_OFFSET = eINSTANCE.getDebugTraceRegion_MyEndOffset();

		/**
		 * The meta object literal for the '<em><b>Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEBUG_TRACE_REGION__ASSOCIATIONS = eINSTANCE.getDebugTraceRegion_Associations();

		/**
		 * The meta object literal for the '<em><b>Use For Debugging</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_TRACE_REGION__USE_FOR_DEBUGGING = eINSTANCE.getDebugTraceRegion_UseForDebugging();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.builder.trace.impl.DebugLocationDataImpl <em>Debug Location Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.builder.trace.impl.DebugLocationDataImpl
		 * @see org.eclipse.xtext.builder.trace.impl.TracePackageImpl#getDebugLocationData()
		 * @generated
		 */
		EClass DEBUG_LOCATION_DATA = eINSTANCE.getDebugLocationData();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_LOCATION_DATA__LABEL = eINSTANCE.getDebugLocationData_Label();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_LOCATION_DATA__OFFSET = eINSTANCE.getDebugLocationData_Offset();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_LOCATION_DATA__LENGTH = eINSTANCE.getDebugLocationData_Length();

		/**
		 * The meta object literal for the '<em><b>Line Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_LOCATION_DATA__LINE_NUMBER = eINSTANCE.getDebugLocationData_LineNumber();

		/**
		 * The meta object literal for the '<em><b>End Line Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_LOCATION_DATA__END_LINE_NUMBER = eINSTANCE.getDebugLocationData_EndLineNumber();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_LOCATION_DATA__PATH = eINSTANCE.getDebugLocationData_Path();

		/**
		 * The meta object literal for the '<em><b>End Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_LOCATION_DATA__END_OFFSET = eINSTANCE.getDebugLocationData_EndOffset();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_TRACE_REGION__LABEL = eINSTANCE.getDebugTraceRegion_Label();

		/**
		 * The meta object literal for the '<em><b>My Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_TRACE_REGION__MY_OFFSET = eINSTANCE.getDebugTraceRegion_MyOffset();

		/**
		 * The meta object literal for the '<em><b>My Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_TRACE_REGION__MY_LENGTH = eINSTANCE.getDebugTraceRegion_MyLength();

		/**
		 * The meta object literal for the '<em><b>My Line Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_TRACE_REGION__MY_LINE_NUMBER = eINSTANCE.getDebugTraceRegion_MyLineNumber();

		/**
		 * The meta object literal for the '<em><b>My End Line Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_TRACE_REGION__MY_END_LINE_NUMBER = eINSTANCE.getDebugTraceRegion_MyEndLineNumber();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see org.eclipse.xtext.builder.trace.impl.TracePackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

} //TracePackage
