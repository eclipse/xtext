/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.common.types.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Component Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.impl.JvmComponentTypeImpl#getArrayType <em>Array Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class JvmComponentTypeImpl extends JvmTypeImpl implements JvmComponentType
{
	/**
	 * The cached value of the '{@link #getArrayType() <em>Array Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayType()
	 * @generated
	 * @ordered
	 */
	protected JvmArrayType arrayType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmComponentTypeImpl()
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
		return TypesPackage.Literals.JVM_COMPONENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmArrayType getArrayType()
	{
		if (arrayType != null && arrayType.eIsProxy())
		{
			InternalEObject oldArrayType = (InternalEObject)arrayType;
			arrayType = (JvmArrayType)eResolveProxy(oldArrayType);
			if (arrayType != oldArrayType)
			{
				InternalEObject newArrayType = (InternalEObject)arrayType;
				NotificationChain msgs =  oldArrayType.eInverseRemove(this, TypesPackage.JVM_ARRAY_TYPE__COMPONENT_TYPE, JvmArrayType.class, null);
				if (newArrayType.eInternalContainer() == null)
				{
					msgs =  newArrayType.eInverseAdd(this, TypesPackage.JVM_ARRAY_TYPE__COMPONENT_TYPE, JvmArrayType.class, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypesPackage.JVM_COMPONENT_TYPE__ARRAY_TYPE, oldArrayType, arrayType));
			}
		}
		return arrayType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmArrayType basicGetArrayType()
	{
		return arrayType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArrayType(JvmArrayType newArrayType, NotificationChain msgs)
	{
		JvmArrayType oldArrayType = arrayType;
		arrayType = newArrayType;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_COMPONENT_TYPE__ARRAY_TYPE, oldArrayType, newArrayType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrayType(JvmArrayType newArrayType)
	{
		if (newArrayType != arrayType)
		{
			NotificationChain msgs = null;
			if (arrayType != null)
				msgs = ((InternalEObject)arrayType).eInverseRemove(this, TypesPackage.JVM_ARRAY_TYPE__COMPONENT_TYPE, JvmArrayType.class, msgs);
			if (newArrayType != null)
				msgs = ((InternalEObject)newArrayType).eInverseAdd(this, TypesPackage.JVM_ARRAY_TYPE__COMPONENT_TYPE, JvmArrayType.class, msgs);
			msgs = basicSetArrayType(newArrayType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_COMPONENT_TYPE__ARRAY_TYPE, newArrayType, newArrayType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case TypesPackage.JVM_COMPONENT_TYPE__ARRAY_TYPE:
				if (arrayType != null)
					msgs = ((InternalEObject)arrayType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_COMPONENT_TYPE__ARRAY_TYPE, null, msgs);
				return basicSetArrayType((JvmArrayType)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case TypesPackage.JVM_COMPONENT_TYPE__ARRAY_TYPE:
				return basicSetArrayType(null, msgs);
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
			case TypesPackage.JVM_COMPONENT_TYPE__ARRAY_TYPE:
				if (resolve) return getArrayType();
				return basicGetArrayType();
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
			case TypesPackage.JVM_COMPONENT_TYPE__ARRAY_TYPE:
				setArrayType((JvmArrayType)newValue);
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
			case TypesPackage.JVM_COMPONENT_TYPE__ARRAY_TYPE:
				setArrayType((JvmArrayType)null);
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
			case TypesPackage.JVM_COMPONENT_TYPE__ARRAY_TYPE:
				return arrayType != null;
		}
		return super.eIsSet(featureID);
	}

} //JvmComponentTypeImpl
