/**
 */
package org.eclipse.xtext.builder.trace.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.builder.trace.DebugTraceRegion;
import org.eclipse.xtext.builder.trace.TracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Debug Trace Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getFromOffset <em>From Offset</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getFromLength <em>From Length</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getToOffset <em>To Offset</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getToLength <em>To Length</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getToProject <em>To Project</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getToPath <em>To Path</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getNestedRegions <em>Nested Regions</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getFromEndOffset <em>From End Offset</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getToEndOffset <em>To End Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DebugTraceRegionImpl extends MinimalEObjectImpl.Container implements DebugTraceRegion {
	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getFromOffset() <em>From Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int FROM_OFFSET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFromOffset() <em>From Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromOffset()
	 * @generated
	 * @ordered
	 */
	protected int fromOffset = FROM_OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getFromLength() <em>From Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromLength()
	 * @generated
	 * @ordered
	 */
	protected static final int FROM_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFromLength() <em>From Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromLength()
	 * @generated
	 * @ordered
	 */
	protected int fromLength = FROM_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getToOffset() <em>To Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int TO_OFFSET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getToOffset() <em>To Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToOffset()
	 * @generated
	 * @ordered
	 */
	protected int toOffset = TO_OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getToLength() <em>To Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToLength()
	 * @generated
	 * @ordered
	 */
	protected static final int TO_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getToLength() <em>To Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToLength()
	 * @generated
	 * @ordered
	 */
	protected int toLength = TO_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getToProject() <em>To Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToProject()
	 * @generated
	 * @ordered
	 */
	protected static final String TO_PROJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToProject() <em>To Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToProject()
	 * @generated
	 * @ordered
	 */
	protected String toProject = TO_PROJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getToPath() <em>To Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToPath()
	 * @generated
	 * @ordered
	 */
	protected static final URI TO_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToPath() <em>To Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToPath()
	 * @generated
	 * @ordered
	 */
	protected URI toPath = TO_PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNestedRegions() <em>Nested Regions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<DebugTraceRegion> nestedRegions;

	/**
	 * The default value of the '{@link #getFromEndOffset() <em>From End Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromEndOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int FROM_END_OFFSET_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getToEndOffset() <em>To End Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToEndOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int TO_END_OFFSET_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DebugTraceRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.DEBUG_TRACE_REGION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFromOffset() {
		return fromOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromOffset(int newFromOffset) {
		int oldFromOffset = fromOffset;
		fromOffset = newFromOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.DEBUG_TRACE_REGION__FROM_OFFSET, oldFromOffset, fromOffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFromLength() {
		return fromLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromLength(int newFromLength) {
		int oldFromLength = fromLength;
		fromLength = newFromLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.DEBUG_TRACE_REGION__FROM_LENGTH, oldFromLength, fromLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getToOffset() {
		return toOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToOffset(int newToOffset) {
		int oldToOffset = toOffset;
		toOffset = newToOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.DEBUG_TRACE_REGION__TO_OFFSET, oldToOffset, toOffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getToLength() {
		return toLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToLength(int newToLength) {
		int oldToLength = toLength;
		toLength = newToLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.DEBUG_TRACE_REGION__TO_LENGTH, oldToLength, toLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getToProject() {
		return toProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToProject(String newToProject) {
		String oldToProject = toProject;
		toProject = newToProject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.DEBUG_TRACE_REGION__TO_PROJECT, oldToProject, toProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getToPath() {
		return toPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToPath(URI newToPath) {
		URI oldToPath = toPath;
		toPath = newToPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.DEBUG_TRACE_REGION__TO_PATH, oldToPath, toPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DebugTraceRegion> getNestedRegions() {
		if (nestedRegions == null) {
			nestedRegions = new EObjectContainmentEList<DebugTraceRegion>(DebugTraceRegion.class, this, TracePackage.DEBUG_TRACE_REGION__NESTED_REGIONS);
		}
		return nestedRegions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLabel() {
		return String.format("[%d - %d]", getFromOffset(), getFromEndOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getFromEndOffset() {
		return getFromOffset() + getFromLength();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getToEndOffset() {
		return getToOffset() + getToLength();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.DEBUG_TRACE_REGION__NESTED_REGIONS:
				return ((InternalEList<?>)getNestedRegions()).basicRemove(otherEnd, msgs);
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
			case TracePackage.DEBUG_TRACE_REGION__LABEL:
				return getLabel();
			case TracePackage.DEBUG_TRACE_REGION__FROM_OFFSET:
				return getFromOffset();
			case TracePackage.DEBUG_TRACE_REGION__FROM_LENGTH:
				return getFromLength();
			case TracePackage.DEBUG_TRACE_REGION__TO_OFFSET:
				return getToOffset();
			case TracePackage.DEBUG_TRACE_REGION__TO_LENGTH:
				return getToLength();
			case TracePackage.DEBUG_TRACE_REGION__TO_PROJECT:
				return getToProject();
			case TracePackage.DEBUG_TRACE_REGION__TO_PATH:
				return getToPath();
			case TracePackage.DEBUG_TRACE_REGION__NESTED_REGIONS:
				return getNestedRegions();
			case TracePackage.DEBUG_TRACE_REGION__FROM_END_OFFSET:
				return getFromEndOffset();
			case TracePackage.DEBUG_TRACE_REGION__TO_END_OFFSET:
				return getToEndOffset();
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
			case TracePackage.DEBUG_TRACE_REGION__FROM_OFFSET:
				setFromOffset((Integer)newValue);
				return;
			case TracePackage.DEBUG_TRACE_REGION__FROM_LENGTH:
				setFromLength((Integer)newValue);
				return;
			case TracePackage.DEBUG_TRACE_REGION__TO_OFFSET:
				setToOffset((Integer)newValue);
				return;
			case TracePackage.DEBUG_TRACE_REGION__TO_LENGTH:
				setToLength((Integer)newValue);
				return;
			case TracePackage.DEBUG_TRACE_REGION__TO_PROJECT:
				setToProject((String)newValue);
				return;
			case TracePackage.DEBUG_TRACE_REGION__TO_PATH:
				setToPath((URI)newValue);
				return;
			case TracePackage.DEBUG_TRACE_REGION__NESTED_REGIONS:
				getNestedRegions().clear();
				getNestedRegions().addAll((Collection<? extends DebugTraceRegion>)newValue);
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
			case TracePackage.DEBUG_TRACE_REGION__FROM_OFFSET:
				setFromOffset(FROM_OFFSET_EDEFAULT);
				return;
			case TracePackage.DEBUG_TRACE_REGION__FROM_LENGTH:
				setFromLength(FROM_LENGTH_EDEFAULT);
				return;
			case TracePackage.DEBUG_TRACE_REGION__TO_OFFSET:
				setToOffset(TO_OFFSET_EDEFAULT);
				return;
			case TracePackage.DEBUG_TRACE_REGION__TO_LENGTH:
				setToLength(TO_LENGTH_EDEFAULT);
				return;
			case TracePackage.DEBUG_TRACE_REGION__TO_PROJECT:
				setToProject(TO_PROJECT_EDEFAULT);
				return;
			case TracePackage.DEBUG_TRACE_REGION__TO_PATH:
				setToPath(TO_PATH_EDEFAULT);
				return;
			case TracePackage.DEBUG_TRACE_REGION__NESTED_REGIONS:
				getNestedRegions().clear();
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
			case TracePackage.DEBUG_TRACE_REGION__LABEL:
				return LABEL_EDEFAULT == null ? getLabel() != null : !LABEL_EDEFAULT.equals(getLabel());
			case TracePackage.DEBUG_TRACE_REGION__FROM_OFFSET:
				return fromOffset != FROM_OFFSET_EDEFAULT;
			case TracePackage.DEBUG_TRACE_REGION__FROM_LENGTH:
				return fromLength != FROM_LENGTH_EDEFAULT;
			case TracePackage.DEBUG_TRACE_REGION__TO_OFFSET:
				return toOffset != TO_OFFSET_EDEFAULT;
			case TracePackage.DEBUG_TRACE_REGION__TO_LENGTH:
				return toLength != TO_LENGTH_EDEFAULT;
			case TracePackage.DEBUG_TRACE_REGION__TO_PROJECT:
				return TO_PROJECT_EDEFAULT == null ? toProject != null : !TO_PROJECT_EDEFAULT.equals(toProject);
			case TracePackage.DEBUG_TRACE_REGION__TO_PATH:
				return TO_PATH_EDEFAULT == null ? toPath != null : !TO_PATH_EDEFAULT.equals(toPath);
			case TracePackage.DEBUG_TRACE_REGION__NESTED_REGIONS:
				return nestedRegions != null && !nestedRegions.isEmpty();
			case TracePackage.DEBUG_TRACE_REGION__FROM_END_OFFSET:
				return getFromEndOffset() != FROM_END_OFFSET_EDEFAULT;
			case TracePackage.DEBUG_TRACE_REGION__TO_END_OFFSET:
				return getToEndOffset() != TO_END_OFFSET_EDEFAULT;
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
		result.append(" (fromOffset: ");
		result.append(fromOffset);
		result.append(", fromLength: ");
		result.append(fromLength);
		result.append(", toOffset: ");
		result.append(toOffset);
		result.append(", toLength: ");
		result.append(toLength);
		result.append(", toProject: ");
		result.append(toProject);
		result.append(", toPath: ");
		result.append(toPath);
		result.append(')');
		return result.toString();
	}

} //DebugTraceRegionImpl
