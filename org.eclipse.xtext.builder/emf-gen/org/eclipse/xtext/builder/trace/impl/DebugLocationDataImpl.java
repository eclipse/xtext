/**
 */
package org.eclipse.xtext.builder.trace.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.xtext.builder.trace.DebugLocationData;
import org.eclipse.xtext.builder.trace.TracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Debug Location Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugLocationDataImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugLocationDataImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugLocationDataImpl#getLength <em>Length</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugLocationDataImpl#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugLocationDataImpl#getEndLineNumber <em>End Line Number</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugLocationDataImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.trace.impl.DebugLocationDataImpl#getEndOffset <em>End Offset</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DebugLocationDataImpl extends MinimalEObjectImpl.Container implements DebugLocationData {
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
	 * The default value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int OFFSET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected int offset = OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final int LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected int length = LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumber()
	 * @generated
	 * @ordered
	 */
	protected int lineNumber = LINE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndLineNumber() <em>End Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLineNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int END_LINE_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEndLineNumber() <em>End Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLineNumber()
	 * @generated
	 * @ordered
	 */
	protected int endLineNumber = END_LINE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final URI PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected URI path = PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndOffset() <em>End Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int END_OFFSET_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DebugLocationDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.DEBUG_LOCATION_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getLabel() {
		return String.format("[%d - %d]", getOffset(), getEndOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getOffset() {
		return offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffset(int newOffset) {
		int oldOffset = offset;
		offset = newOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.DEBUG_LOCATION_DATA__OFFSET, oldOffset, offset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLength(int newLength) {
		int oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.DEBUG_LOCATION_DATA__LENGTH, oldLength, length));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLineNumber(int newLineNumber) {
		int oldLineNumber = lineNumber;
		lineNumber = newLineNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.DEBUG_LOCATION_DATA__LINE_NUMBER, oldLineNumber, lineNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getEndLineNumber() {
		return endLineNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndLineNumber(int newEndLineNumber) {
		int oldEndLineNumber = endLineNumber;
		endLineNumber = newEndLineNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.DEBUG_LOCATION_DATA__END_LINE_NUMBER, oldEndLineNumber, endLineNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public URI getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPath(URI newPath) {
		URI oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.DEBUG_LOCATION_DATA__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public int getEndOffset() {
		return getOffset() + getLength();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TracePackage.DEBUG_LOCATION_DATA__LABEL:
				return getLabel();
			case TracePackage.DEBUG_LOCATION_DATA__OFFSET:
				return getOffset();
			case TracePackage.DEBUG_LOCATION_DATA__LENGTH:
				return getLength();
			case TracePackage.DEBUG_LOCATION_DATA__LINE_NUMBER:
				return getLineNumber();
			case TracePackage.DEBUG_LOCATION_DATA__END_LINE_NUMBER:
				return getEndLineNumber();
			case TracePackage.DEBUG_LOCATION_DATA__PATH:
				return getPath();
			case TracePackage.DEBUG_LOCATION_DATA__END_OFFSET:
				return getEndOffset();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TracePackage.DEBUG_LOCATION_DATA__OFFSET:
				setOffset((Integer)newValue);
				return;
			case TracePackage.DEBUG_LOCATION_DATA__LENGTH:
				setLength((Integer)newValue);
				return;
			case TracePackage.DEBUG_LOCATION_DATA__LINE_NUMBER:
				setLineNumber((Integer)newValue);
				return;
			case TracePackage.DEBUG_LOCATION_DATA__END_LINE_NUMBER:
				setEndLineNumber((Integer)newValue);
				return;
			case TracePackage.DEBUG_LOCATION_DATA__PATH:
				setPath((URI)newValue);
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
			case TracePackage.DEBUG_LOCATION_DATA__OFFSET:
				setOffset(OFFSET_EDEFAULT);
				return;
			case TracePackage.DEBUG_LOCATION_DATA__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case TracePackage.DEBUG_LOCATION_DATA__LINE_NUMBER:
				setLineNumber(LINE_NUMBER_EDEFAULT);
				return;
			case TracePackage.DEBUG_LOCATION_DATA__END_LINE_NUMBER:
				setEndLineNumber(END_LINE_NUMBER_EDEFAULT);
				return;
			case TracePackage.DEBUG_LOCATION_DATA__PATH:
				setPath(PATH_EDEFAULT);
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
			case TracePackage.DEBUG_LOCATION_DATA__LABEL:
				return LABEL_EDEFAULT == null ? getLabel() != null : !LABEL_EDEFAULT.equals(getLabel());
			case TracePackage.DEBUG_LOCATION_DATA__OFFSET:
				return offset != OFFSET_EDEFAULT;
			case TracePackage.DEBUG_LOCATION_DATA__LENGTH:
				return length != LENGTH_EDEFAULT;
			case TracePackage.DEBUG_LOCATION_DATA__LINE_NUMBER:
				return lineNumber != LINE_NUMBER_EDEFAULT;
			case TracePackage.DEBUG_LOCATION_DATA__END_LINE_NUMBER:
				return endLineNumber != END_LINE_NUMBER_EDEFAULT;
			case TracePackage.DEBUG_LOCATION_DATA__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case TracePackage.DEBUG_LOCATION_DATA__END_OFFSET:
				return getEndOffset() != END_OFFSET_EDEFAULT;
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
		result.append(" (offset: ");
		result.append(offset);
		result.append(", length: ");
		result.append(length);
		result.append(", lineNumber: ");
		result.append(lineNumber);
		result.append(", endLineNumber: ");
		result.append(endLineNumber);
		result.append(", path: ");
		result.append(path);
		result.append(')');
		return result.toString();
	}

} //DebugLocationDataImpl
