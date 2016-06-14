/**
 */
package org.eclipse.xtext.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.Condition;
import org.eclipse.xtext.NamedArgument;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.XtextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Argument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.impl.NamedArgumentImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.xtext.impl.NamedArgumentImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.impl.NamedArgumentImpl#isCalledByName <em>Called By Name</em>}</li>
 * </ul>
 *
 * @generated
 * @since 2.9
 */
public class NamedArgumentImpl extends MinimalEObjectImpl.Container implements NamedArgument {
	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected Parameter parameter;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Condition value;

	/**
	 * The default value of the '{@link #isCalledByName() <em>Called By Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCalledByName()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CALLED_BY_NAME_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCalledByName() <em>Called By Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCalledByName()
	 * @generated
	 * @ordered
	 */
	protected boolean calledByName = CALLED_BY_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedArgumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XtextPackage.Literals.NAMED_ARGUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getParameter() {
		if (parameter != null && parameter.eIsProxy()) {
			InternalEObject oldParameter = (InternalEObject)parameter;
			parameter = (Parameter)eResolveProxy(oldParameter);
			if (parameter != oldParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XtextPackage.NAMED_ARGUMENT__PARAMETER, oldParameter, parameter));
			}
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetParameter() {
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameter(Parameter newParameter) {
		Parameter oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextPackage.NAMED_ARGUMENT__PARAMETER, oldParameter, parameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(Condition newValue, NotificationChain msgs) {
		Condition oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextPackage.NAMED_ARGUMENT__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(Condition newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextPackage.NAMED_ARGUMENT__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextPackage.NAMED_ARGUMENT__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextPackage.NAMED_ARGUMENT__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCalledByName() {
		return calledByName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalledByName(boolean newCalledByName) {
		boolean oldCalledByName = calledByName;
		calledByName = newCalledByName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextPackage.NAMED_ARGUMENT__CALLED_BY_NAME, oldCalledByName, calledByName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XtextPackage.NAMED_ARGUMENT__VALUE:
				return basicSetValue(null, msgs);
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
			case XtextPackage.NAMED_ARGUMENT__PARAMETER:
				if (resolve) return getParameter();
				return basicGetParameter();
			case XtextPackage.NAMED_ARGUMENT__VALUE:
				return getValue();
			case XtextPackage.NAMED_ARGUMENT__CALLED_BY_NAME:
				return isCalledByName();
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
			case XtextPackage.NAMED_ARGUMENT__PARAMETER:
				setParameter((Parameter)newValue);
				return;
			case XtextPackage.NAMED_ARGUMENT__VALUE:
				setValue((Condition)newValue);
				return;
			case XtextPackage.NAMED_ARGUMENT__CALLED_BY_NAME:
				setCalledByName((Boolean)newValue);
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
			case XtextPackage.NAMED_ARGUMENT__PARAMETER:
				setParameter((Parameter)null);
				return;
			case XtextPackage.NAMED_ARGUMENT__VALUE:
				setValue((Condition)null);
				return;
			case XtextPackage.NAMED_ARGUMENT__CALLED_BY_NAME:
				setCalledByName(CALLED_BY_NAME_EDEFAULT);
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
			case XtextPackage.NAMED_ARGUMENT__PARAMETER:
				return parameter != null;
			case XtextPackage.NAMED_ARGUMENT__VALUE:
				return value != null;
			case XtextPackage.NAMED_ARGUMENT__CALLED_BY_NAME:
				return calledByName != CALLED_BY_NAME_EDEFAULT;
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
		result.append(" (calledByName: ");
		result.append(calledByName);
		result.append(')');
		return result.toString();
	}

} //NamedArgumentImpl
