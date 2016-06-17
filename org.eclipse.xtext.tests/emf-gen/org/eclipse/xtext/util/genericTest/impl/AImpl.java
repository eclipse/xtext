/**
 * <copyright>
 * </copyright>
 *
 * $Id: AImpl.java,v 1.1 2010/03/31 13:22:30 jkohnlein Exp $
 */
package org.eclipse.xtext.util.genericTest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.xtext.util.genericTest.A;
import org.eclipse.xtext.util.genericTest.GenericTestPackage;
import org.eclipse.xtext.util.genericTest.SomeType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.util.genericTest.impl.AImpl#getSomeReference <em>Some Reference</em>}</li>
 *   <li>{@link org.eclipse.xtext.util.genericTest.impl.AImpl#getSomeReference1 <em>Some Reference1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AImpl<T> extends EObjectImpl implements A<T> {
	/**
	 * The cached value of the '{@link #getSomeReference() <em>Some Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSomeReference()
	 * @generated
	 * @ordered
	 */
	protected T someReference;

	/**
	 * The cached value of the '{@link #getSomeReference1() <em>Some Reference1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSomeReference1()
	 * @generated
	 * @ordered
	 */
	protected SomeType someReference1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericTestPackage.Literals.A;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public T getSomeReference() {
		if (someReference != null && ((EObject)someReference).eIsProxy()) {
			InternalEObject oldSomeReference = (InternalEObject)someReference;
			someReference = (T)eResolveProxy(oldSomeReference);
			if (someReference != oldSomeReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenericTestPackage.A__SOME_REFERENCE, oldSomeReference, someReference));
			}
		}
		return someReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public T basicGetSomeReference() {
		return someReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSomeReference(T newSomeReference) {
		T oldSomeReference = someReference;
		someReference = newSomeReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericTestPackage.A__SOME_REFERENCE, oldSomeReference, someReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SomeType getSomeReference1() {
		if (someReference1 != null && someReference1.eIsProxy()) {
			InternalEObject oldSomeReference1 = (InternalEObject)someReference1;
			someReference1 = (SomeType)eResolveProxy(oldSomeReference1);
			if (someReference1 != oldSomeReference1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenericTestPackage.A__SOME_REFERENCE1, oldSomeReference1, someReference1));
			}
		}
		return someReference1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SomeType basicGetSomeReference1() {
		return someReference1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSomeReference1(SomeType newSomeReference1) {
		SomeType oldSomeReference1 = someReference1;
		someReference1 = newSomeReference1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericTestPackage.A__SOME_REFERENCE1, oldSomeReference1, someReference1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenericTestPackage.A__SOME_REFERENCE:
				if (resolve) return getSomeReference();
				return basicGetSomeReference();
			case GenericTestPackage.A__SOME_REFERENCE1:
				if (resolve) return getSomeReference1();
				return basicGetSomeReference1();
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
			case GenericTestPackage.A__SOME_REFERENCE:
				setSomeReference((T)newValue);
				return;
			case GenericTestPackage.A__SOME_REFERENCE1:
				setSomeReference1((SomeType)newValue);
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
			case GenericTestPackage.A__SOME_REFERENCE:
				setSomeReference((T)null);
				return;
			case GenericTestPackage.A__SOME_REFERENCE1:
				setSomeReference1((SomeType)null);
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
			case GenericTestPackage.A__SOME_REFERENCE:
				return someReference != null;
			case GenericTestPackage.A__SOME_REFERENCE1:
				return someReference1 != null;
		}
		return super.eIsSet(featureID);
	}

} //AImpl
