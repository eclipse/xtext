/**
 * <copyright>
 * </copyright>
 *
 * $Id: CrossResourceContainerOneChildImpl.java,v 1.1 2010/02/04 09:24:53 sefftinge Exp $
 */
package org.eclipse.xtext.parser.partialParsingTestUtil.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerOneChild;
import org.eclipse.xtext.parser.partialParsingTestUtil.PartialParsingTestUtilPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cross Resource Container One Child</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.partialParsingTestUtil.impl.CrossResourceContainerOneChildImpl#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CrossResourceContainerOneChildImpl extends EObjectImpl implements CrossResourceContainerOneChild {
	/**
	 * The cached value of the '{@link #getChild() <em>Child</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChild()
	 * @generated
	 * @ordered
	 */
	protected EObject child;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CrossResourceContainerOneChildImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PartialParsingTestUtilPackage.Literals.CROSS_RESOURCE_CONTAINER_ONE_CHILD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getChild() {
		if (child != null && child.eIsProxy()) {
			InternalEObject oldChild = (InternalEObject)child;
			child = eResolveProxy(oldChild);
			if (child != oldChild) {
				InternalEObject newChild = (InternalEObject)child;
				NotificationChain msgs = oldChild.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_ONE_CHILD__CHILD, null, null);
				if (newChild.eInternalContainer() == null) {
					msgs = newChild.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_ONE_CHILD__CHILD, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_ONE_CHILD__CHILD, oldChild, child));
			}
		}
		return child;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetChild() {
		return child;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChild(EObject newChild, NotificationChain msgs) {
		EObject oldChild = child;
		child = newChild;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_ONE_CHILD__CHILD, oldChild, newChild);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChild(EObject newChild) {
		if (newChild != child) {
			NotificationChain msgs = null;
			if (child != null)
				msgs = ((InternalEObject)child).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_ONE_CHILD__CHILD, null, msgs);
			if (newChild != null)
				msgs = ((InternalEObject)newChild).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_ONE_CHILD__CHILD, null, msgs);
			msgs = basicSetChild(newChild, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_ONE_CHILD__CHILD, newChild, newChild));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_ONE_CHILD__CHILD:
				return basicSetChild(null, msgs);
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
			case PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_ONE_CHILD__CHILD:
				if (resolve) return getChild();
				return basicGetChild();
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
			case PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_ONE_CHILD__CHILD:
				setChild((EObject)newValue);
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
			case PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_ONE_CHILD__CHILD:
				setChild((EObject)null);
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
			case PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_ONE_CHILD__CHILD:
				return child != null;
		}
		return super.eIsSet(featureID);
	}

} //CrossResourceContainerOneChildImpl
