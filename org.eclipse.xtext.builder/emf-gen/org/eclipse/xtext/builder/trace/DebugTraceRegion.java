/**
 */
package org.eclipse.xtext.builder.trace;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Debug Trace Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyOffset <em>My Offset</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyLength <em>My Length</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyLineNumber <em>My Line Number</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyEndLineNumber <em>My End Line Number</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getNestedRegions <em>Nested Regions</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyEndOffset <em>My End Offset</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getAssociations <em>Associations</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#isUseForDebugging <em>Use For Debugging</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion()
 * @model
 * @generated
 */
public interface DebugTraceRegion extends EObject {
	/**
	 * Returns the value of the '<em><b>Nested Regions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.builder.trace.DebugTraceRegion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Regions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Regions</em>' containment reference list.
	 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion_NestedRegions()
	 * @model containment="true"
	 * @generated
	 */
	EList<DebugTraceRegion> getNestedRegions();

	/**
	 * Returns the value of the '<em><b>My End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>My End Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>My End Offset</em>' attribute.
	 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion_MyEndOffset()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getMyEndOffset();

	/**
	 * Returns the value of the '<em><b>Associations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.builder.trace.DebugLocationData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associations</em>' containment reference list.
	 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion_Associations()
	 * @model containment="true"
	 * @generated
	 */
	EList<DebugLocationData> getAssociations();

	/**
	 * Returns the value of the '<em><b>Use For Debugging</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use For Debugging</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use For Debugging</em>' attribute.
	 * @see #setUseForDebugging(boolean)
	 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion_UseForDebugging()
	 * @model
	 * @generated
	 */
	boolean isUseForDebugging();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#isUseForDebugging <em>Use For Debugging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use For Debugging</em>' attribute.
	 * @see #isUseForDebugging()
	 * @generated
	 */
	void setUseForDebugging(boolean value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion_Label()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Returns the value of the '<em><b>My Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>My Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>My Offset</em>' attribute.
	 * @see #setMyOffset(int)
	 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion_MyOffset()
	 * @model unique="false"
	 * @generated
	 */
	int getMyOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyOffset <em>My Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>My Offset</em>' attribute.
	 * @see #getMyOffset()
	 * @generated
	 */
	void setMyOffset(int value);

	/**
	 * Returns the value of the '<em><b>My Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>My Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>My Length</em>' attribute.
	 * @see #setMyLength(int)
	 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion_MyLength()
	 * @model unique="false"
	 * @generated
	 */
	int getMyLength();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyLength <em>My Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>My Length</em>' attribute.
	 * @see #getMyLength()
	 * @generated
	 */
	void setMyLength(int value);

	/**
	 * Returns the value of the '<em><b>My Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>My Line Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>My Line Number</em>' attribute.
	 * @see #setMyLineNumber(int)
	 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion_MyLineNumber()
	 * @model unique="false"
	 * @generated
	 */
	int getMyLineNumber();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyLineNumber <em>My Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>My Line Number</em>' attribute.
	 * @see #getMyLineNumber()
	 * @generated
	 */
	void setMyLineNumber(int value);

	/**
	 * Returns the value of the '<em><b>My End Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>My End Line Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>My End Line Number</em>' attribute.
	 * @see #setMyEndLineNumber(int)
	 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion_MyEndLineNumber()
	 * @model unique="false"
	 * @generated
	 */
	int getMyEndLineNumber();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getMyEndLineNumber <em>My End Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>My End Line Number</em>' attribute.
	 * @see #getMyEndLineNumber()
	 * @generated
	 */
	void setMyEndLineNumber(int value);

} // DebugTraceRegion
