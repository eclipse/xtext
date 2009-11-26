/**
 * <copyright>
 * </copyright>
 *
 * $Id: BuilderStateImpl.java,v 1.2 2009/11/26 09:56:26 sefftinge Exp $
 */
package org.eclipse.xtext.builder.builderState.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.builder.builderState.BuilderState;
import org.eclipse.xtext.builder.builderState.BuilderStatePackage;
import org.eclipse.xtext.builder.builderState.Cache;
import org.eclipse.xtext.resource.IResourceDescription;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Builder State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.BuilderStateImpl#getResourceDescriptions <em>Resource Descriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BuilderStateImpl extends Container implements BuilderState {
	/**
	 * The cached value of the '{@link #getResourceDescriptions() <em>Resource Descriptions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceDescriptions()
	 * @generated
	 * @ordered
	 */
	protected EList<IResourceDescription> resourceDescriptions;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BuilderStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BuilderStatePackage.Literals.BUILDER_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IResourceDescription> getResourceDescriptions() {
		if (resourceDescriptions == null) {
			resourceDescriptions = new EObjectContainmentEList<IResourceDescription>(IResourceDescription.class, this, BuilderStatePackage.BUILDER_STATE__RESOURCE_DESCRIPTIONS);
		}
		return resourceDescriptions;
	}
	
	{
		this.cache = new Cache();
		eAdapters().add(this.cache);
	}
	
	private Cache cache;
	
	public IResourceDescription getResourceDescription(URI uri) {
		return cache.getResourceDescription(uri);
	}

	public IResourceDescription getResourceDescriptionForStorage(String externalStorageForm) {
		return cache.getResourceDescriptionForStorage(externalStorageForm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BuilderStatePackage.BUILDER_STATE__RESOURCE_DESCRIPTIONS:
				return ((InternalEList<?>)getResourceDescriptions()).basicRemove(otherEnd, msgs);
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
			case BuilderStatePackage.BUILDER_STATE__RESOURCE_DESCRIPTIONS:
				return getResourceDescriptions();
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
			case BuilderStatePackage.BUILDER_STATE__RESOURCE_DESCRIPTIONS:
				getResourceDescriptions().clear();
				getResourceDescriptions().addAll((Collection<? extends IResourceDescription>)newValue);
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
			case BuilderStatePackage.BUILDER_STATE__RESOURCE_DESCRIPTIONS:
				getResourceDescriptions().clear();
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
			case BuilderStatePackage.BUILDER_STATE__RESOURCE_DESCRIPTIONS:
				return resourceDescriptions != null && !resourceDescriptions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BuilderStateImpl
