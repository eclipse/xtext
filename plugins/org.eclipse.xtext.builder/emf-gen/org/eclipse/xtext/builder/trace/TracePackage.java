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
	 * The feature id for the '<em><b>From Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__FROM_OFFSET = 1;

	/**
	 * The feature id for the '<em><b>From Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__FROM_LENGTH = 2;

	/**
	 * The feature id for the '<em><b>To Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__TO_OFFSET = 3;

	/**
	 * The feature id for the '<em><b>To Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__TO_LENGTH = 4;

	/**
	 * The feature id for the '<em><b>To Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__TO_PROJECT = 5;

	/**
	 * The feature id for the '<em><b>To Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__TO_PATH = 6;

	/**
	 * The feature id for the '<em><b>Nested Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__NESTED_REGIONS = 7;

	/**
	 * The feature id for the '<em><b>From End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__FROM_END_OFFSET = 8;

	/**
	 * The feature id for the '<em><b>To End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION__TO_END_OFFSET = 9;

	/**
	 * The number of structural features of the '<em>Debug Trace Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_TRACE_REGION_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.eclipse.xtext.builder.trace.impl.TracePackageImpl#getURI()
	 * @generated
	 */
	int URI = 1;


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
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getFromOffset <em>From Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Offset</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion#getFromOffset()
	 * @see #getDebugTraceRegion()
	 * @generated
	 */
	EAttribute getDebugTraceRegion_FromOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getFromLength <em>From Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Length</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion#getFromLength()
	 * @see #getDebugTraceRegion()
	 * @generated
	 */
	EAttribute getDebugTraceRegion_FromLength();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getToOffset <em>To Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Offset</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion#getToOffset()
	 * @see #getDebugTraceRegion()
	 * @generated
	 */
	EAttribute getDebugTraceRegion_ToOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getToLength <em>To Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Length</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion#getToLength()
	 * @see #getDebugTraceRegion()
	 * @generated
	 */
	EAttribute getDebugTraceRegion_ToLength();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getToProject <em>To Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Project</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion#getToProject()
	 * @see #getDebugTraceRegion()
	 * @generated
	 */
	EAttribute getDebugTraceRegion_ToProject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getToPath <em>To Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Path</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion#getToPath()
	 * @see #getDebugTraceRegion()
	 * @generated
	 */
	EAttribute getDebugTraceRegion_ToPath();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getFromEndOffset <em>From End Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From End Offset</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion#getFromEndOffset()
	 * @see #getDebugTraceRegion()
	 * @generated
	 */
	EAttribute getDebugTraceRegion_FromEndOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getToEndOffset <em>To End Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To End Offset</em>'.
	 * @see org.eclipse.xtext.builder.trace.DebugTraceRegion#getToEndOffset()
	 * @see #getDebugTraceRegion()
	 * @generated
	 */
	EAttribute getDebugTraceRegion_ToEndOffset();

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
		 * The meta object literal for the '<em><b>From Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_TRACE_REGION__FROM_OFFSET = eINSTANCE.getDebugTraceRegion_FromOffset();

		/**
		 * The meta object literal for the '<em><b>From Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_TRACE_REGION__FROM_LENGTH = eINSTANCE.getDebugTraceRegion_FromLength();

		/**
		 * The meta object literal for the '<em><b>To Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_TRACE_REGION__TO_OFFSET = eINSTANCE.getDebugTraceRegion_ToOffset();

		/**
		 * The meta object literal for the '<em><b>To Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_TRACE_REGION__TO_LENGTH = eINSTANCE.getDebugTraceRegion_ToLength();

		/**
		 * The meta object literal for the '<em><b>To Project</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_TRACE_REGION__TO_PROJECT = eINSTANCE.getDebugTraceRegion_ToProject();

		/**
		 * The meta object literal for the '<em><b>To Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_TRACE_REGION__TO_PATH = eINSTANCE.getDebugTraceRegion_ToPath();

		/**
		 * The meta object literal for the '<em><b>Nested Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEBUG_TRACE_REGION__NESTED_REGIONS = eINSTANCE.getDebugTraceRegion_NestedRegions();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_TRACE_REGION__LABEL = eINSTANCE.getDebugTraceRegion_Label();

		/**
		 * The meta object literal for the '<em><b>From End Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_TRACE_REGION__FROM_END_OFFSET = eINSTANCE.getDebugTraceRegion_FromEndOffset();

		/**
		 * The meta object literal for the '<em><b>To End Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_TRACE_REGION__TO_END_OFFSET = eINSTANCE.getDebugTraceRegion_ToEndOffset();

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
