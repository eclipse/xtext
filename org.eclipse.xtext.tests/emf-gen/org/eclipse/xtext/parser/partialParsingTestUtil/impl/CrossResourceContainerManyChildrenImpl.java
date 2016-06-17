/**
 * <copyright>
 * </copyright>
 *
 * $Id: CrossResourceContainerManyChildrenImpl.java,v 1.1 2010/02/04 09:24:53 sefftinge Exp $
 */
package org.eclipse.xtext.parser.partialParsingTestUtil.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerManyChildren;
import org.eclipse.xtext.parser.partialParsingTestUtil.PartialParsingTestUtilPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cross Resource Container Many Children</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.partialParsingTestUtil.impl.CrossResourceContainerManyChildrenImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CrossResourceContainerManyChildrenImpl extends EObjectImpl implements CrossResourceContainerManyChildren {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> children;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CrossResourceContainerManyChildrenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PartialParsingTestUtilPackage.Literals.CROSS_RESOURCE_CONTAINER_MANY_CHILDREN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList.Resolving<EObject>(EObject.class, this, PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_MANY_CHILDREN__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_MANY_CHILDREN__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_MANY_CHILDREN__CHILDREN:
				return getChildren();
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
			case PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_MANY_CHILDREN__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends EObject>)newValue);
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
			case PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_MANY_CHILDREN__CHILDREN:
				getChildren().clear();
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
			case PartialParsingTestUtilPackage.CROSS_RESOURCE_CONTAINER_MANY_CHILDREN__CHILDREN:
				return children != null && !children.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CrossResourceContainerManyChildrenImpl
