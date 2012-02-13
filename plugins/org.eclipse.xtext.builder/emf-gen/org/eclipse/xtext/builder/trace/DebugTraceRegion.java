/**
 */
package org.eclipse.xtext.builder.trace;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Debug Trace Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getFromOffset <em>From Offset</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getFromLength <em>From Length</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getToOffset <em>To Offset</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getToLength <em>To Length</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getToProject <em>To Project</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getToPath <em>To Path</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getNestedRegions <em>Nested Regions</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getFromEndOffset <em>From End Offset</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getToEndOffset <em>To End Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion()
 * @model
 * @generated
 */
public interface DebugTraceRegion extends EObject {
	/**
	 * Returns the value of the '<em><b>From Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Offset</em>' attribute.
	 * @see #setFromOffset(int)
	 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion_FromOffset()
	 * @model unique="false"
	 * @generated
	 */
	int getFromOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getFromOffset <em>From Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Offset</em>' attribute.
	 * @see #getFromOffset()
	 * @generated
	 */
	void setFromOffset(int value);

	/**
	 * Returns the value of the '<em><b>From Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Length</em>' attribute.
	 * @see #setFromLength(int)
	 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion_FromLength()
	 * @model unique="false"
	 * @generated
	 */
	int getFromLength();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getFromLength <em>From Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Length</em>' attribute.
	 * @see #getFromLength()
	 * @generated
	 */
	void setFromLength(int value);

	/**
	 * Returns the value of the '<em><b>To Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Offset</em>' attribute.
	 * @see #setToOffset(int)
	 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion_ToOffset()
	 * @model unique="false"
	 * @generated
	 */
	int getToOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getToOffset <em>To Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Offset</em>' attribute.
	 * @see #getToOffset()
	 * @generated
	 */
	void setToOffset(int value);

	/**
	 * Returns the value of the '<em><b>To Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Length</em>' attribute.
	 * @see #setToLength(int)
	 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion_ToLength()
	 * @model unique="false"
	 * @generated
	 */
	int getToLength();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getToLength <em>To Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Length</em>' attribute.
	 * @see #getToLength()
	 * @generated
	 */
	void setToLength(int value);

	/**
	 * Returns the value of the '<em><b>To Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Project</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Project</em>' attribute.
	 * @see #setToProject(String)
	 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion_ToProject()
	 * @model unique="false"
	 * @generated
	 */
	String getToProject();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getToProject <em>To Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Project</em>' attribute.
	 * @see #getToProject()
	 * @generated
	 */
	void setToProject(String value);

	/**
	 * Returns the value of the '<em><b>To Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Path</em>' attribute.
	 * @see #setToPath(URI)
	 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion_ToPath()
	 * @model unique="false" dataType="org.eclipse.xtext.builder.trace.URI"
	 * @generated
	 */
	URI getToPath();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.builder.trace.DebugTraceRegion#getToPath <em>To Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Path</em>' attribute.
	 * @see #getToPath()
	 * @generated
	 */
	void setToPath(URI value);

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
	 * Returns the value of the '<em><b>From End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From End Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From End Offset</em>' attribute.
	 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion_FromEndOffset()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getFromEndOffset();

	/**
	 * Returns the value of the '<em><b>To End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To End Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To End Offset</em>' attribute.
	 * @see org.eclipse.xtext.builder.trace.TracePackage#getDebugTraceRegion_ToEndOffset()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getToEndOffset();

} // DebugTraceRegion
