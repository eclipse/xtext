/**
 * <copyright>
 * </copyright>
 *
 * $Id: BImpl.java,v 1.1 2010/03/31 13:22:30 jkohnlein Exp $
 */
package org.eclipse.xtext.util.genericTest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.util.genericTest.A;
import org.eclipse.xtext.util.genericTest.B;
import org.eclipse.xtext.util.genericTest.GenericTestPackage;
import org.eclipse.xtext.util.genericTest.OtherType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>B</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.util.genericTest.impl.BImpl#getOtherReference <em>Other Reference</em>}</li>
 *   <li>{@link org.eclipse.xtext.util.genericTest.impl.BImpl#getOtherReference1 <em>Other Reference1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BImpl<U, V> extends AImpl<V> implements B<U, V> {
	/**
	 * The cached value of the '{@link #getOtherReference() <em>Other Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherReference()
	 * @generated
	 * @ordered
	 */
	protected U otherReference;

	/**
	 * The cached value of the '{@link #getOtherReference1() <em>Other Reference1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherReference1()
	 * @generated
	 * @ordered
	 */
	protected A<OtherType> otherReference1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericTestPackage.Literals.B;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public U getOtherReference() {
		if (otherReference != null && ((EObject)otherReference).eIsProxy()) {
			InternalEObject oldOtherReference = (InternalEObject)otherReference;
			otherReference = (U)eResolveProxy(oldOtherReference);
			if (otherReference != oldOtherReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenericTestPackage.B__OTHER_REFERENCE, oldOtherReference, otherReference));
			}
		}
		return otherReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public U basicGetOtherReference() {
		return otherReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOtherReference(U newOtherReference) {
		U oldOtherReference = otherReference;
		otherReference = newOtherReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericTestPackage.B__OTHER_REFERENCE, oldOtherReference, otherReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public A<OtherType> getOtherReference1() {
		if (otherReference1 != null && otherReference1.eIsProxy()) {
			InternalEObject oldOtherReference1 = (InternalEObject)otherReference1;
			otherReference1 = (A<OtherType>)eResolveProxy(oldOtherReference1);
			if (otherReference1 != oldOtherReference1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenericTestPackage.B__OTHER_REFERENCE1, oldOtherReference1, otherReference1));
			}
		}
		return otherReference1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A<OtherType> basicGetOtherReference1() {
		return otherReference1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOtherReference1(A<OtherType> newOtherReference1) {
		A<OtherType> oldOtherReference1 = otherReference1;
		otherReference1 = newOtherReference1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericTestPackage.B__OTHER_REFERENCE1, oldOtherReference1, otherReference1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenericTestPackage.B__OTHER_REFERENCE:
				if (resolve) return getOtherReference();
				return basicGetOtherReference();
			case GenericTestPackage.B__OTHER_REFERENCE1:
				if (resolve) return getOtherReference1();
				return basicGetOtherReference1();
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
			case GenericTestPackage.B__OTHER_REFERENCE:
				setOtherReference((U)newValue);
				return;
			case GenericTestPackage.B__OTHER_REFERENCE1:
				setOtherReference1((A<OtherType>)newValue);
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
			case GenericTestPackage.B__OTHER_REFERENCE:
				setOtherReference((U)null);
				return;
			case GenericTestPackage.B__OTHER_REFERENCE1:
				setOtherReference1((A<OtherType>)null);
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
			case GenericTestPackage.B__OTHER_REFERENCE:
				return otherReference != null;
			case GenericTestPackage.B__OTHER_REFERENCE1:
				return otherReference1 != null;
		}
		return super.eIsSet(featureID);
	}

} //BImpl
