/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmOperationImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmOperationImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmOperationImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmOperationImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmOperationImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmOperationImpl#isSynchronized <em>Synchronized</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmOperationImpl#isDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmOperationImpl#isNative <em>Native</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmOperationImpl#isStrictFloatingPoint <em>Strict Floating Point</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JvmOperationImpl extends JvmExecutableImplCustom implements JvmOperation
{
	/**
	 * The default value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STATIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected boolean static_ = STATIC_EDEFAULT;

	/**
	 * The default value of the '{@link #isFinal() <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFinal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FINAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFinal() <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFinal()
	 * @generated
	 * @ordered
	 */
	protected boolean final_ = FINAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference returnType;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected JvmAnnotationValue defaultValue;

	/**
	 * The default value of the '{@link #isSynchronized() <em>Synchronized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSynchronized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SYNCHRONIZED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSynchronized() <em>Synchronized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSynchronized()
	 * @generated
	 * @ordered
	 */
	protected boolean synchronized_ = SYNCHRONIZED_EDEFAULT;

	/**
	 * The default value of the '{@link #isDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFAULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefault()
	 * @generated
	 * @ordered
	 */
	protected boolean default_ = DEFAULT_EDEFAULT;

	/**
	 * The default value of the '{@link #isNative() <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNative()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NATIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNative() <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNative()
	 * @generated
	 * @ordered
	 */
	protected boolean native_ = NATIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isStrictFloatingPoint() <em>Strict Floating Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStrictFloatingPoint()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STRICT_FLOATING_POINT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStrictFloatingPoint() <em>Strict Floating Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStrictFloatingPoint()
	 * @generated
	 * @ordered
	 */
	protected boolean strictFloatingPoint = STRICT_FLOATING_POINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmOperationImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return TypesPackage.Literals.JVM_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isStatic()
	{
		return static_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatic(boolean newStatic)
	{
		boolean oldStatic = static_;
		static_ = newStatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__STATIC, oldStatic, static_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFinal()
	{
		return final_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFinal(boolean newFinal)
	{
		boolean oldFinal = final_;
		final_ = newFinal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__FINAL, oldFinal, final_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAbstract()
	{
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAbstract(boolean newAbstract)
	{
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JvmTypeReference getReturnType()
	{
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturnType(JvmTypeReference newReturnType, NotificationChain msgs)
	{
		JvmTypeReference oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__RETURN_TYPE, oldReturnType, newReturnType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReturnType(JvmTypeReference newReturnType)
	{
		if (newReturnType != returnType)
		{
			NotificationChain msgs = null;
			if (returnType != null)
				msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_OPERATION__RETURN_TYPE, null, msgs);
			if (newReturnType != null)
				msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_OPERATION__RETURN_TYPE, null, msgs);
			msgs = basicSetReturnType(newReturnType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__RETURN_TYPE, newReturnType, newReturnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JvmAnnotationValue getDefaultValue()
	{
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultValue(JvmAnnotationValue newDefaultValue, NotificationChain msgs)
	{
		JvmAnnotationValue oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__DEFAULT_VALUE, oldDefaultValue, newDefaultValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefaultValue(JvmAnnotationValue newDefaultValue)
	{
		if (newDefaultValue != defaultValue)
		{
			NotificationChain msgs = null;
			if (defaultValue != null)
				msgs = ((InternalEObject)defaultValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_OPERATION__DEFAULT_VALUE, null, msgs);
			if (newDefaultValue != null)
				msgs = ((InternalEObject)newDefaultValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_OPERATION__DEFAULT_VALUE, null, msgs);
			msgs = basicSetDefaultValue(newDefaultValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__DEFAULT_VALUE, newDefaultValue, newDefaultValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSynchronized()
	{
		return synchronized_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSynchronized(boolean newSynchronized)
	{
		boolean oldSynchronized = synchronized_;
		synchronized_ = newSynchronized;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__SYNCHRONIZED, oldSynchronized, synchronized_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDefault()
	{
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefault(boolean newDefault)
	{
		boolean oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNative()
	{
		return native_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNative(boolean newNative)
	{
		boolean oldNative = native_;
		native_ = newNative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__NATIVE, oldNative, native_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isStrictFloatingPoint()
	{
		return strictFloatingPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStrictFloatingPoint(boolean newStrictFloatingPoint)
	{
		boolean oldStrictFloatingPoint = strictFloatingPoint;
		strictFloatingPoint = newStrictFloatingPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__STRICT_FLOATING_POINT, oldStrictFloatingPoint, strictFloatingPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case TypesPackage.JVM_OPERATION__RETURN_TYPE:
				return basicSetReturnType(null, msgs);
			case TypesPackage.JVM_OPERATION__DEFAULT_VALUE:
				return basicSetDefaultValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case TypesPackage.JVM_OPERATION__STATIC:
				return isStatic();
			case TypesPackage.JVM_OPERATION__FINAL:
				return isFinal();
			case TypesPackage.JVM_OPERATION__ABSTRACT:
				return isAbstract();
			case TypesPackage.JVM_OPERATION__RETURN_TYPE:
				return getReturnType();
			case TypesPackage.JVM_OPERATION__DEFAULT_VALUE:
				return getDefaultValue();
			case TypesPackage.JVM_OPERATION__SYNCHRONIZED:
				return isSynchronized();
			case TypesPackage.JVM_OPERATION__DEFAULT:
				return isDefault();
			case TypesPackage.JVM_OPERATION__NATIVE:
				return isNative();
			case TypesPackage.JVM_OPERATION__STRICT_FLOATING_POINT:
				return isStrictFloatingPoint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case TypesPackage.JVM_OPERATION__STATIC:
				setStatic((Boolean)newValue);
				return;
			case TypesPackage.JVM_OPERATION__FINAL:
				setFinal((Boolean)newValue);
				return;
			case TypesPackage.JVM_OPERATION__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case TypesPackage.JVM_OPERATION__RETURN_TYPE:
				setReturnType((JvmTypeReference)newValue);
				return;
			case TypesPackage.JVM_OPERATION__DEFAULT_VALUE:
				setDefaultValue((JvmAnnotationValue)newValue);
				return;
			case TypesPackage.JVM_OPERATION__SYNCHRONIZED:
				setSynchronized((Boolean)newValue);
				return;
			case TypesPackage.JVM_OPERATION__DEFAULT:
				setDefault((Boolean)newValue);
				return;
			case TypesPackage.JVM_OPERATION__NATIVE:
				setNative((Boolean)newValue);
				return;
			case TypesPackage.JVM_OPERATION__STRICT_FLOATING_POINT:
				setStrictFloatingPoint((Boolean)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case TypesPackage.JVM_OPERATION__STATIC:
				setStatic(STATIC_EDEFAULT);
				return;
			case TypesPackage.JVM_OPERATION__FINAL:
				setFinal(FINAL_EDEFAULT);
				return;
			case TypesPackage.JVM_OPERATION__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case TypesPackage.JVM_OPERATION__RETURN_TYPE:
				setReturnType((JvmTypeReference)null);
				return;
			case TypesPackage.JVM_OPERATION__DEFAULT_VALUE:
				setDefaultValue((JvmAnnotationValue)null);
				return;
			case TypesPackage.JVM_OPERATION__SYNCHRONIZED:
				setSynchronized(SYNCHRONIZED_EDEFAULT);
				return;
			case TypesPackage.JVM_OPERATION__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case TypesPackage.JVM_OPERATION__NATIVE:
				setNative(NATIVE_EDEFAULT);
				return;
			case TypesPackage.JVM_OPERATION__STRICT_FLOATING_POINT:
				setStrictFloatingPoint(STRICT_FLOATING_POINT_EDEFAULT);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case TypesPackage.JVM_OPERATION__STATIC:
				return static_ != STATIC_EDEFAULT;
			case TypesPackage.JVM_OPERATION__FINAL:
				return final_ != FINAL_EDEFAULT;
			case TypesPackage.JVM_OPERATION__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case TypesPackage.JVM_OPERATION__RETURN_TYPE:
				return returnType != null;
			case TypesPackage.JVM_OPERATION__DEFAULT_VALUE:
				return defaultValue != null;
			case TypesPackage.JVM_OPERATION__SYNCHRONIZED:
				return synchronized_ != SYNCHRONIZED_EDEFAULT;
			case TypesPackage.JVM_OPERATION__DEFAULT:
				return default_ != DEFAULT_EDEFAULT;
			case TypesPackage.JVM_OPERATION__NATIVE:
				return native_ != NATIVE_EDEFAULT;
			case TypesPackage.JVM_OPERATION__STRICT_FLOATING_POINT:
				return strictFloatingPoint != STRICT_FLOATING_POINT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (static: ");
		result.append(static_);
		result.append(", final: ");
		result.append(final_);
		result.append(", abstract: ");
		result.append(abstract_);
		result.append(", synchronized: ");
		result.append(synchronized_);
		result.append(", default: ");
		result.append(default_);
		result.append(", native: ");
		result.append(native_);
		result.append(", strictFloatingPoint: ");
		result.append(strictFloatingPoint);
		result.append(')');
		return result.toString();
	}

} //JvmOperationImpl
