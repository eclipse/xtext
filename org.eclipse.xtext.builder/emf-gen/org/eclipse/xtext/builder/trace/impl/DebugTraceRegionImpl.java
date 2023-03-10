/**
 */
package org.eclipse.xtext.builder.trace.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.builder.trace.DebugLocationData;
import org.eclipse.xtext.builder.trace.DebugTraceRegion;
import org.eclipse.xtext.builder.trace.TracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Debug Trace Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getMyOffset <em>My Offset</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getMyLength <em>My Length</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getMyLineNumber <em>My Line Number</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getMyEndLineNumber <em>My End Line Number</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getNestedRegions <em>Nested Regions</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getMyEndOffset <em>My End Offset</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#getAssociations <em>Associations</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugTraceRegionImpl#isUseForDebugging <em>Use For Debugging</em>}</li>
 * </ul>
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
	 * The default value of the '{@link #getMyOffset() <em>My Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int MY_OFFSET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMyOffset() <em>My Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyOffset()
	 * @generated
	 * @ordered
	 */
	protected int myOffset = MY_OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getMyLength() <em>My Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyLength()
	 * @generated
	 * @ordered
	 */
	protected static final int MY_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMyLength() <em>My Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyLength()
	 * @generated
	 * @ordered
	 */
	protected int myLength = MY_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMyLineNumber() <em>My Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyLineNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int MY_LINE_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMyLineNumber() <em>My Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyLineNumber()
	 * @generated
	 * @ordered
	 */
	protected int myLineNumber = MY_LINE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getMyEndLineNumber() <em>My End Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyEndLineNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int MY_END_LINE_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMyEndLineNumber() <em>My End Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyEndLineNumber()
	 * @generated
	 * @ordered
	 */
	protected int myEndLineNumber = MY_END_LINE_NUMBER_EDEFAULT;

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
	 * The default value of the '{@link #getMyEndOffset() <em>My End Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyEndOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int MY_END_OFFSET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAssociations() <em>Associations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<DebugLocationData> associations;

	/**
	 * The default value of the '{@link #isUseForDebugging() <em>Use For Debugging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseForDebugging()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_FOR_DEBUGGING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseForDebugging() <em>Use For Debugging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseForDebugging()
	 * @generated
	 * @ordered
	 */
	protected boolean useForDebugging = USE_FOR_DEBUGGING_EDEFAULT;

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
	@Override
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
	@Override
	public int getMyEndOffset() {
		return getMyOffset() + getMyLength();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DebugLocationData> getAssociations() {
		if (associations == null) {
			associations = new EObjectContainmentEList<DebugLocationData>(DebugLocationData.class, this, TracePackage.DEBUG_TRACE_REGION__ASSOCIATIONS);
		}
		return associations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isUseForDebugging() {
		return useForDebugging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUseForDebugging(boolean newUseForDebugging) {
		boolean oldUseForDebugging = useForDebugging;
		useForDebugging = newUseForDebugging;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.DEBUG_TRACE_REGION__USE_FOR_DEBUGGING, oldUseForDebugging, useForDebugging));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getLabel() {
		return String.format("[%d - %d]", getMyOffset(), getMyEndOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMyOffset() {
		return myOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMyOffset(int newMyOffset) {
		int oldMyOffset = myOffset;
		myOffset = newMyOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.DEBUG_TRACE_REGION__MY_OFFSET, oldMyOffset, myOffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMyLength() {
		return myLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMyLength(int newMyLength) {
		int oldMyLength = myLength;
		myLength = newMyLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.DEBUG_TRACE_REGION__MY_LENGTH, oldMyLength, myLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMyLineNumber() {
		return myLineNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMyLineNumber(int newMyLineNumber) {
		int oldMyLineNumber = myLineNumber;
		myLineNumber = newMyLineNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.DEBUG_TRACE_REGION__MY_LINE_NUMBER, oldMyLineNumber, myLineNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMyEndLineNumber() {
		return myEndLineNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMyEndLineNumber(int newMyEndLineNumber) {
		int oldMyEndLineNumber = myEndLineNumber;
		myEndLineNumber = newMyEndLineNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.DEBUG_TRACE_REGION__MY_END_LINE_NUMBER, oldMyEndLineNumber, myEndLineNumber));
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
			case TracePackage.DEBUG_TRACE_REGION__ASSOCIATIONS:
				return ((InternalEList<?>)getAssociations()).basicRemove(otherEnd, msgs);
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
			case TracePackage.DEBUG_TRACE_REGION__MY_OFFSET:
				return getMyOffset();
			case TracePackage.DEBUG_TRACE_REGION__MY_LENGTH:
				return getMyLength();
			case TracePackage.DEBUG_TRACE_REGION__MY_LINE_NUMBER:
				return getMyLineNumber();
			case TracePackage.DEBUG_TRACE_REGION__MY_END_LINE_NUMBER:
				return getMyEndLineNumber();
			case TracePackage.DEBUG_TRACE_REGION__NESTED_REGIONS:
				return getNestedRegions();
			case TracePackage.DEBUG_TRACE_REGION__MY_END_OFFSET:
				return getMyEndOffset();
			case TracePackage.DEBUG_TRACE_REGION__ASSOCIATIONS:
				return getAssociations();
			case TracePackage.DEBUG_TRACE_REGION__USE_FOR_DEBUGGING:
				return isUseForDebugging();
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
			case TracePackage.DEBUG_TRACE_REGION__MY_OFFSET:
				setMyOffset((Integer)newValue);
				return;
			case TracePackage.DEBUG_TRACE_REGION__MY_LENGTH:
				setMyLength((Integer)newValue);
				return;
			case TracePackage.DEBUG_TRACE_REGION__MY_LINE_NUMBER:
				setMyLineNumber((Integer)newValue);
				return;
			case TracePackage.DEBUG_TRACE_REGION__MY_END_LINE_NUMBER:
				setMyEndLineNumber((Integer)newValue);
				return;
			case TracePackage.DEBUG_TRACE_REGION__NESTED_REGIONS:
				getNestedRegions().clear();
				getNestedRegions().addAll((Collection<? extends DebugTraceRegion>)newValue);
				return;
			case TracePackage.DEBUG_TRACE_REGION__ASSOCIATIONS:
				getAssociations().clear();
				getAssociations().addAll((Collection<? extends DebugLocationData>)newValue);
				return;
			case TracePackage.DEBUG_TRACE_REGION__USE_FOR_DEBUGGING:
				setUseForDebugging((Boolean)newValue);
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
			case TracePackage.DEBUG_TRACE_REGION__MY_OFFSET:
				setMyOffset(MY_OFFSET_EDEFAULT);
				return;
			case TracePackage.DEBUG_TRACE_REGION__MY_LENGTH:
				setMyLength(MY_LENGTH_EDEFAULT);
				return;
			case TracePackage.DEBUG_TRACE_REGION__MY_LINE_NUMBER:
				setMyLineNumber(MY_LINE_NUMBER_EDEFAULT);
				return;
			case TracePackage.DEBUG_TRACE_REGION__MY_END_LINE_NUMBER:
				setMyEndLineNumber(MY_END_LINE_NUMBER_EDEFAULT);
				return;
			case TracePackage.DEBUG_TRACE_REGION__NESTED_REGIONS:
				getNestedRegions().clear();
				return;
			case TracePackage.DEBUG_TRACE_REGION__ASSOCIATIONS:
				getAssociations().clear();
				return;
			case TracePackage.DEBUG_TRACE_REGION__USE_FOR_DEBUGGING:
				setUseForDebugging(USE_FOR_DEBUGGING_EDEFAULT);
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
			case TracePackage.DEBUG_TRACE_REGION__MY_OFFSET:
				return myOffset != MY_OFFSET_EDEFAULT;
			case TracePackage.DEBUG_TRACE_REGION__MY_LENGTH:
				return myLength != MY_LENGTH_EDEFAULT;
			case TracePackage.DEBUG_TRACE_REGION__MY_LINE_NUMBER:
				return myLineNumber != MY_LINE_NUMBER_EDEFAULT;
			case TracePackage.DEBUG_TRACE_REGION__MY_END_LINE_NUMBER:
				return myEndLineNumber != MY_END_LINE_NUMBER_EDEFAULT;
			case TracePackage.DEBUG_TRACE_REGION__NESTED_REGIONS:
				return nestedRegions != null && !nestedRegions.isEmpty();
			case TracePackage.DEBUG_TRACE_REGION__MY_END_OFFSET:
				return getMyEndOffset() != MY_END_OFFSET_EDEFAULT;
			case TracePackage.DEBUG_TRACE_REGION__ASSOCIATIONS:
				return associations != null && !associations.isEmpty();
			case TracePackage.DEBUG_TRACE_REGION__USE_FOR_DEBUGGING:
				return useForDebugging != USE_FOR_DEBUGGING_EDEFAULT;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (myOffset: ");
		result.append(myOffset);
		result.append(", myLength: ");
		result.append(myLength);
		result.append(", myLineNumber: ");
		result.append(myLineNumber);
		result.append(", myEndLineNumber: ");
		result.append(myEndLineNumber);
		result.append(", useForDebugging: ");
		result.append(useForDebugging);
		result.append(')');
		return result.toString();
	}

} //DebugTraceRegionImpl
