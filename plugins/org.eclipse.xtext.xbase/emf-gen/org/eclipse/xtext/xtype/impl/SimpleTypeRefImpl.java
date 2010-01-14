/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimpleTypeRefImpl.java,v 1.1 2010/01/14 14:40:22 sefftinge Exp $
 */
package org.eclipse.xtext.xtype.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.Type;

import org.eclipse.xtext.xtype.SimpleTypeRef;
import org.eclipse.xtext.xtype.TypeRef;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Type Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtype.impl.SimpleTypeRefImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.impl.SimpleTypeRefImpl#getTypeParams <em>Type Params</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleTypeRefImpl extends TypeRefImpl implements SimpleTypeRef {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

	/**
	 * The cached value of the '{@link #getTypeParams() <em>Type Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeParams()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeRef> typeParams;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleTypeRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XtypePackage.Literals.SIMPLE_TYPE_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XtypePackage.SIMPLE_TYPE_REF__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtypePackage.SIMPLE_TYPE_REF__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeRef> getTypeParams() {
		if (typeParams == null) {
			typeParams = new EObjectContainmentEList<TypeRef>(TypeRef.class, this, XtypePackage.SIMPLE_TYPE_REF__TYPE_PARAMS);
		}
		return typeParams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XtypePackage.SIMPLE_TYPE_REF__TYPE_PARAMS:
				return ((InternalEList<?>)getTypeParams()).basicRemove(otherEnd, msgs);
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
			case XtypePackage.SIMPLE_TYPE_REF__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case XtypePackage.SIMPLE_TYPE_REF__TYPE_PARAMS:
				return getTypeParams();
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
			case XtypePackage.SIMPLE_TYPE_REF__TYPE:
				setType((Type)newValue);
				return;
			case XtypePackage.SIMPLE_TYPE_REF__TYPE_PARAMS:
				getTypeParams().clear();
				getTypeParams().addAll((Collection<? extends TypeRef>)newValue);
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
			case XtypePackage.SIMPLE_TYPE_REF__TYPE:
				setType((Type)null);
				return;
			case XtypePackage.SIMPLE_TYPE_REF__TYPE_PARAMS:
				getTypeParams().clear();
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
			case XtypePackage.SIMPLE_TYPE_REF__TYPE:
				return type != null;
			case XtypePackage.SIMPLE_TYPE_REF__TYPE_PARAMS:
				return typeParams != null && !typeParams.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SimpleTypeRefImpl
