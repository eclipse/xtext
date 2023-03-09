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

import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmFieldImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmFieldImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmFieldImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmFieldImpl#isVolatile <em>Volatile</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmFieldImpl#isTransient <em>Transient</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmFieldImpl#isConstant <em>Constant</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmFieldImpl#getConstantValue <em>Constant Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JvmFieldImpl extends JvmFeatureImpl implements JvmField
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
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference type;

	/**
	 * The default value of the '{@link #isVolatile() <em>Volatile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVolatile()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VOLATILE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVolatile() <em>Volatile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVolatile()
	 * @generated
	 * @ordered
	 */
	protected boolean volatile_ = VOLATILE_EDEFAULT;

	/**
	 * The default value of the '{@link #isTransient() <em>Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSIENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTransient() <em>Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected boolean transient_ = TRANSIENT_EDEFAULT;

	/**
	 * The default value of the '{@link #isConstant() <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONSTANT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConstant() <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstant()
	 * @generated
	 * @ordered
	 */
	protected boolean constant = CONSTANT_EDEFAULT;

	/**
	 * This is true if the Constant attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean constantESet;

	/**
	 * The default value of the '{@link #getConstantValue() <em>Constant Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object CONSTANT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConstantValue() <em>Constant Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantValue()
	 * @generated
	 * @ordered
	 */
	protected Object constantValue = CONSTANT_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmFieldImpl()
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
		return TypesPackage.Literals.JVM_FIELD;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__STATIC, oldStatic, static_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__FINAL, oldFinal, final_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JvmTypeReference getType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(JvmTypeReference newType, NotificationChain msgs)
	{
		JvmTypeReference oldType = type;
		type = newType;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__TYPE, oldType, newType);
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
	public void setType(JvmTypeReference newType)
	{
		if (newType != type)
		{
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_FIELD__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_FIELD__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isVolatile()
	{
		return volatile_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVolatile(boolean newVolatile)
	{
		boolean oldVolatile = volatile_;
		volatile_ = newVolatile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__VOLATILE, oldVolatile, volatile_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isTransient()
	{
		return transient_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransient(boolean newTransient)
	{
		boolean oldTransient = transient_;
		transient_ = newTransient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__TRANSIENT, oldTransient, transient_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isConstant()
	{
		return constant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstant(boolean newConstant)
	{
		boolean oldConstant = constant;
		constant = newConstant;
		boolean oldConstantESet = constantESet;
		constantESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__CONSTANT, oldConstant, constant, !oldConstantESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConstant()
	{
		boolean oldConstant = constant;
		boolean oldConstantESet = constantESet;
		constant = CONSTANT_EDEFAULT;
		constantESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, TypesPackage.JVM_FIELD__CONSTANT, oldConstant, CONSTANT_EDEFAULT, oldConstantESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConstant()
	{
		return constantESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getConstantValue()
	{
		return constantValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstantValue(Object newConstantValue)
	{
		Object oldConstantValue = constantValue;
		constantValue = newConstantValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__CONSTANT_VALUE, oldConstantValue, constantValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getConstantValueAsLong()
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getConstantValueAsInt()
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public short getConstantValueAsShort()
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public byte getConstantValueAsByte()
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getConstantValueAsDouble()
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getConstantValueAsFloat()
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public char getConstantValueAsChar()
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean getConstantValueAsBoolean()
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getConstantValueAsString()
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case TypesPackage.JVM_FIELD__TYPE:
				return basicSetType(null, msgs);
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
			case TypesPackage.JVM_FIELD__STATIC:
				return isStatic();
			case TypesPackage.JVM_FIELD__FINAL:
				return isFinal();
			case TypesPackage.JVM_FIELD__TYPE:
				return getType();
			case TypesPackage.JVM_FIELD__VOLATILE:
				return isVolatile();
			case TypesPackage.JVM_FIELD__TRANSIENT:
				return isTransient();
			case TypesPackage.JVM_FIELD__CONSTANT:
				return isConstant();
			case TypesPackage.JVM_FIELD__CONSTANT_VALUE:
				return getConstantValue();
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
			case TypesPackage.JVM_FIELD__STATIC:
				setStatic((Boolean)newValue);
				return;
			case TypesPackage.JVM_FIELD__FINAL:
				setFinal((Boolean)newValue);
				return;
			case TypesPackage.JVM_FIELD__TYPE:
				setType((JvmTypeReference)newValue);
				return;
			case TypesPackage.JVM_FIELD__VOLATILE:
				setVolatile((Boolean)newValue);
				return;
			case TypesPackage.JVM_FIELD__TRANSIENT:
				setTransient((Boolean)newValue);
				return;
			case TypesPackage.JVM_FIELD__CONSTANT:
				setConstant((Boolean)newValue);
				return;
			case TypesPackage.JVM_FIELD__CONSTANT_VALUE:
				setConstantValue(newValue);
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
			case TypesPackage.JVM_FIELD__STATIC:
				setStatic(STATIC_EDEFAULT);
				return;
			case TypesPackage.JVM_FIELD__FINAL:
				setFinal(FINAL_EDEFAULT);
				return;
			case TypesPackage.JVM_FIELD__TYPE:
				setType((JvmTypeReference)null);
				return;
			case TypesPackage.JVM_FIELD__VOLATILE:
				setVolatile(VOLATILE_EDEFAULT);
				return;
			case TypesPackage.JVM_FIELD__TRANSIENT:
				setTransient(TRANSIENT_EDEFAULT);
				return;
			case TypesPackage.JVM_FIELD__CONSTANT:
				unsetConstant();
				return;
			case TypesPackage.JVM_FIELD__CONSTANT_VALUE:
				setConstantValue(CONSTANT_VALUE_EDEFAULT);
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
			case TypesPackage.JVM_FIELD__STATIC:
				return static_ != STATIC_EDEFAULT;
			case TypesPackage.JVM_FIELD__FINAL:
				return final_ != FINAL_EDEFAULT;
			case TypesPackage.JVM_FIELD__TYPE:
				return type != null;
			case TypesPackage.JVM_FIELD__VOLATILE:
				return volatile_ != VOLATILE_EDEFAULT;
			case TypesPackage.JVM_FIELD__TRANSIENT:
				return transient_ != TRANSIENT_EDEFAULT;
			case TypesPackage.JVM_FIELD__CONSTANT:
				return isSetConstant();
			case TypesPackage.JVM_FIELD__CONSTANT_VALUE:
				return CONSTANT_VALUE_EDEFAULT == null ? constantValue != null : !CONSTANT_VALUE_EDEFAULT.equals(constantValue);
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
		result.append(", volatile: ");
		result.append(volatile_);
		result.append(", transient: ");
		result.append(transient_);
		result.append(", constant: ");
		if (constantESet) result.append(constant); else result.append("<unset>");
		result.append(", constantValue: ");
		result.append(constantValue);
		result.append(')');
		return result.toString();
	}

} //JvmFieldImpl
