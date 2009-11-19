/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResourceDescriptorImpl.java,v 1.1 2009/11/19 08:39:59 sefftinge Exp $
 */
package org.eclipse.xtext.builder.builderState.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.builder.builderState.BuilderStatePackage;
import org.eclipse.xtext.builder.builderState.ResourceDescriptor;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.ResourceDescriptorImpl#getURI <em>URI</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.ResourceDescriptorImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.ResourceDescriptorImpl#getEObjectDescriptions <em>EObject Descriptions</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.ResourceDescriptorImpl#getImportedNames <em>Imported Names</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.ResourceDescriptorImpl#getPathToStorage <em>Path To Storage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceDescriptorImpl extends Container implements ResourceDescriptor {
	/**
	 * The default value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected URI uri = URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEObjectDescriptions() <em>EObject Descriptions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEObjectDescriptions()
	 * @generated
	 * @ordered
	 */
	protected EList<IEObjectDescription> eObjectDescriptions;

	/**
	 * The cached value of the '{@link #getImportedNames() <em>Imported Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> importedNames;

	/**
	 * The default value of the '{@link #getPathToStorage() <em>Path To Storage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathToStorage()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_TO_STORAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPathToStorage() <em>Path To Storage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathToStorage()
	 * @generated
	 * @ordered
	 */
	protected String pathToStorage = PATH_TO_STORAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BuilderStatePackage.Literals.RESOURCE_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getURI() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setURI(URI newURI) {
		URI oldURI = uri;
		uri = newURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuilderStatePackage.RESOURCE_DESCRIPTOR__URI, oldURI, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.xtext.builder.builderState.Container getContainer() {
		if (eContainerFeatureID() != BuilderStatePackage.RESOURCE_DESCRIPTOR__CONTAINER) return null;
		return (org.eclipse.xtext.builder.builderState.Container)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(org.eclipse.xtext.builder.builderState.Container newContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainer, BuilderStatePackage.RESOURCE_DESCRIPTOR__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(org.eclipse.xtext.builder.builderState.Container newContainer) {
		if (newContainer != eInternalContainer() || (eContainerFeatureID() != BuilderStatePackage.RESOURCE_DESCRIPTOR__CONTAINER && newContainer != null)) {
			if (EcoreUtil.isAncestor(this, newContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, BuilderStatePackage.CONTAINER__RESOURCE_DESCRIPTORS, org.eclipse.xtext.builder.builderState.Container.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuilderStatePackage.RESOURCE_DESCRIPTOR__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IEObjectDescription> getEObjectDescriptions() {
		if (eObjectDescriptions == null) {
			eObjectDescriptions = new EObjectContainmentWithInverseEList<IEObjectDescription>(IEObjectDescription.class, this, BuilderStatePackage.RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTIONS, BuilderStatePackage.EOBJECT_DESCRIPTION__RESOURCE_DESCRIPTOR);
		}
		return eObjectDescriptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getImportedNames() {
		if (importedNames == null) {
			importedNames = new EDataTypeUniqueEList<String>(String.class, this, BuilderStatePackage.RESOURCE_DESCRIPTOR__IMPORTED_NAMES);
		}
		return importedNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPathToStorage() {
		return pathToStorage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathToStorage(String newPathToStorage) {
		String oldPathToStorage = pathToStorage;
		pathToStorage = newPathToStorage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuilderStatePackage.RESOURCE_DESCRIPTOR__PATH_TO_STORAGE, oldPathToStorage, pathToStorage));
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
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer((org.eclipse.xtext.builder.builderState.Container)otherEnd, msgs);
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEObjectDescriptions()).basicAdd(otherEnd, msgs);
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
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__CONTAINER:
				return basicSetContainer(null, msgs);
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTIONS:
				return ((InternalEList<?>)getEObjectDescriptions()).basicRemove(otherEnd, msgs);
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
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__CONTAINER:
				return eInternalContainer().eInverseRemove(this, BuilderStatePackage.CONTAINER__RESOURCE_DESCRIPTORS, org.eclipse.xtext.builder.builderState.Container.class, msgs);
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
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__URI:
				return getURI();
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__CONTAINER:
				return getContainer();
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTIONS:
				return getEObjectDescriptions();
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__IMPORTED_NAMES:
				return getImportedNames();
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__PATH_TO_STORAGE:
				return getPathToStorage();
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
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__URI:
				setURI((URI)newValue);
				return;
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__CONTAINER:
				setContainer((org.eclipse.xtext.builder.builderState.Container)newValue);
				return;
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTIONS:
				getEObjectDescriptions().clear();
				getEObjectDescriptions().addAll((Collection<? extends IEObjectDescription>)newValue);
				return;
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__IMPORTED_NAMES:
				getImportedNames().clear();
				getImportedNames().addAll((Collection<? extends String>)newValue);
				return;
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__PATH_TO_STORAGE:
				setPathToStorage((String)newValue);
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
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__URI:
				setURI(URI_EDEFAULT);
				return;
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__CONTAINER:
				setContainer((org.eclipse.xtext.builder.builderState.Container)null);
				return;
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTIONS:
				getEObjectDescriptions().clear();
				return;
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__IMPORTED_NAMES:
				getImportedNames().clear();
				return;
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__PATH_TO_STORAGE:
				setPathToStorage(PATH_TO_STORAGE_EDEFAULT);
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
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__CONTAINER:
				return getContainer() != null;
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTIONS:
				return eObjectDescriptions != null && !eObjectDescriptions.isEmpty();
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__IMPORTED_NAMES:
				return importedNames != null && !importedNames.isEmpty();
			case BuilderStatePackage.RESOURCE_DESCRIPTOR__PATH_TO_STORAGE:
				return PATH_TO_STORAGE_EDEFAULT == null ? pathToStorage != null : !PATH_TO_STORAGE_EDEFAULT.equals(pathToStorage);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (URI: ");
		result.append(uri);
		result.append(", importedNames: ");
		result.append(importedNames);
		result.append(", pathToStorage: ");
		result.append(pathToStorage);
		result.append(')');
		return result.toString();
	}

} //ResourceDescriptorImpl
