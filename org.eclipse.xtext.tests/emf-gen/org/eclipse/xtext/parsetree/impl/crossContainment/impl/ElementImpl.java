/**
 * <copyright>
 * </copyright>
 *
 * $Id: ElementImpl.java,v 1.1 2010/04/09 10:00:00 jkohnlein Exp $
 */
package org.eclipse.xtext.parsetree.impl.crossContainment.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.parsetree.impl.crossContainment.CrossContainmentPackage;
import org.eclipse.xtext.parsetree.impl.crossContainment.Element;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.crossContainment.impl.ElementImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.crossContainment.impl.ElementImpl#getContainment <em>Containment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementImpl extends EObjectImpl implements Element {
	/**
	 * The cached value of the '{@link #getContainment() <em>Containment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainment()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> containment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CrossContainmentPackage.Literals.ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getContainer() {
		if (eContainerFeatureID() != CrossContainmentPackage.ELEMENT__CONTAINER) return null;
		return (Element)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetContainer() {
		if (eContainerFeatureID() != CrossContainmentPackage.ELEMENT__CONTAINER) return null;
		return (Element)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(Element newContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainer, CrossContainmentPackage.ELEMENT__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(Element newContainer) {
		if (newContainer != eInternalContainer() || (eContainerFeatureID() != CrossContainmentPackage.ELEMENT__CONTAINER && newContainer != null)) {
			if (EcoreUtil.isAncestor(this, newContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, CrossContainmentPackage.ELEMENT__CONTAINMENT, Element.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CrossContainmentPackage.ELEMENT__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getContainment() {
		if (containment == null) {
			containment = new EObjectContainmentWithInverseEList.Resolving<Element>(Element.class, this, CrossContainmentPackage.ELEMENT__CONTAINMENT, CrossContainmentPackage.ELEMENT__CONTAINER);
		}
		return containment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CrossContainmentPackage.ELEMENT__CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer((Element)otherEnd, msgs);
			case CrossContainmentPackage.ELEMENT__CONTAINMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContainment()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CrossContainmentPackage.ELEMENT__CONTAINER:
				return basicSetContainer(null, msgs);
			case CrossContainmentPackage.ELEMENT__CONTAINMENT:
				return ((InternalEList<?>)getContainment()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CrossContainmentPackage.ELEMENT__CONTAINER:
				return eInternalContainer().eInverseRemove(this, CrossContainmentPackage.ELEMENT__CONTAINMENT, Element.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CrossContainmentPackage.ELEMENT__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
			case CrossContainmentPackage.ELEMENT__CONTAINMENT:
				return getContainment();
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
			case CrossContainmentPackage.ELEMENT__CONTAINER:
				setContainer((Element)newValue);
				return;
			case CrossContainmentPackage.ELEMENT__CONTAINMENT:
				getContainment().clear();
				getContainment().addAll((Collection<? extends Element>)newValue);
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
			case CrossContainmentPackage.ELEMENT__CONTAINER:
				setContainer((Element)null);
				return;
			case CrossContainmentPackage.ELEMENT__CONTAINMENT:
				getContainment().clear();
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
			case CrossContainmentPackage.ELEMENT__CONTAINER:
				return basicGetContainer() != null;
			case CrossContainmentPackage.ELEMENT__CONTAINMENT:
				return containment != null && !containment.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ElementImpl
