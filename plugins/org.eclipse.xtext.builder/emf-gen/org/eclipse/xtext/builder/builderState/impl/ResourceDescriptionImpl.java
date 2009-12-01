/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResourceDescriptionImpl.java,v 1.5 2009/12/01 14:07:33 sefftinge Exp $
 */
package org.eclipse.xtext.builder.builderState.impl;

import java.util.Collection;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.builder.builderState.BuilderStatePackage;
import org.eclipse.xtext.builder.builderState.impl.IStorageUtil.Access;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.core.resource.IStorageAwareResourceDescription;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl#getURI <em>URI</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl#getExportedObjects <em>Exported Objects</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl#getImportedNames <em>Imported Names</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl#getStorageAsString <em>Storage As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceDescriptionImpl extends Container implements IStorageAwareResourceDescription {
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
	 * The cached value of the '{@link #getExportedObjects() <em>Exported Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExportedObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<IEObjectDescription> exportedObjects;

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
	 * The default value of the '{@link #getStorageAsString() <em>Storage As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorageAsString()
	 * @generated
	 * @ordered
	 */
	protected static final String STORAGE_AS_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStorageAsString() <em>Storage As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorageAsString()
	 * @generated
	 * @ordered
	 */
	protected String storageAsString = STORAGE_AS_STRING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BuilderStatePackage.Literals.RESOURCE_DESCRIPTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BuilderStatePackage.RESOURCE_DESCRIPTION__URI, oldURI, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IEObjectDescription> getExportedObjects() {
		if (exportedObjects == null) {
			exportedObjects = new EObjectContainmentWithInverseEList<IEObjectDescription>(IEObjectDescription.class, this, BuilderStatePackage.RESOURCE_DESCRIPTION__EXPORTED_OBJECTS, BuilderStatePackage.EOBJECT_DESCRIPTION__RESOURCE_DESCRIPTOR);
		}
		return exportedObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getImportedNames() {
		if (importedNames == null) {
			importedNames = new EDataTypeUniqueEList<String>(String.class, this, BuilderStatePackage.RESOURCE_DESCRIPTION__IMPORTED_NAMES);
		}
		return importedNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStorageAsString() {
		return storageAsString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStorageAsString(String newStorageAsString) {
		String oldStorageAsString = storageAsString;
		storageAsString = newStorageAsString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuilderStatePackage.RESOURCE_DESCRIPTION__STORAGE_AS_STRING, oldStorageAsString, storageAsString));
	}

	public Iterable<IEObjectDescription> getExportedObjects(final EClass clazz, final String name) {
		return Iterables.filter(getExportedObjects(), new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return (clazz == EcorePackage.Literals.EOBJECT || clazz.isSuperTypeOf(input.getEClass())) && input.getName().equals(name);
			}
		});
	}

	public Iterable<IEObjectDescription> getExportedObjects(final EClass clazz) {
		return Iterables.filter(getExportedObjects(), new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return clazz == EcorePackage.Literals.EOBJECT || clazz.isSuperTypeOf(input.getEClass());
			}
		});
	}

	public Iterable<IEObjectDescription> getExportedObjectsForEObject(EObject object) {
		final URI uri = EcoreUtil.getURI(object);
		return Iterables.filter(getExportedObjects(), new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return uri.equals(input.getEObjectURI());
			}
		});
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
			case BuilderStatePackage.RESOURCE_DESCRIPTION__EXPORTED_OBJECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExportedObjects()).basicAdd(otherEnd, msgs);
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
			case BuilderStatePackage.RESOURCE_DESCRIPTION__EXPORTED_OBJECTS:
				return ((InternalEList<?>)getExportedObjects()).basicRemove(otherEnd, msgs);
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
			case BuilderStatePackage.RESOURCE_DESCRIPTION__URI:
				return getURI();
			case BuilderStatePackage.RESOURCE_DESCRIPTION__EXPORTED_OBJECTS:
				return getExportedObjects();
			case BuilderStatePackage.RESOURCE_DESCRIPTION__IMPORTED_NAMES:
				return getImportedNames();
			case BuilderStatePackage.RESOURCE_DESCRIPTION__STORAGE_AS_STRING:
				return getStorageAsString();
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
			case BuilderStatePackage.RESOURCE_DESCRIPTION__URI:
				setURI((URI)newValue);
				return;
			case BuilderStatePackage.RESOURCE_DESCRIPTION__EXPORTED_OBJECTS:
				getExportedObjects().clear();
				getExportedObjects().addAll((Collection<? extends IEObjectDescription>)newValue);
				return;
			case BuilderStatePackage.RESOURCE_DESCRIPTION__IMPORTED_NAMES:
				getImportedNames().clear();
				getImportedNames().addAll((Collection<? extends String>)newValue);
				return;
			case BuilderStatePackage.RESOURCE_DESCRIPTION__STORAGE_AS_STRING:
				setStorageAsString((String)newValue);
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
			case BuilderStatePackage.RESOURCE_DESCRIPTION__URI:
				setURI(URI_EDEFAULT);
				return;
			case BuilderStatePackage.RESOURCE_DESCRIPTION__EXPORTED_OBJECTS:
				getExportedObjects().clear();
				return;
			case BuilderStatePackage.RESOURCE_DESCRIPTION__IMPORTED_NAMES:
				getImportedNames().clear();
				return;
			case BuilderStatePackage.RESOURCE_DESCRIPTION__STORAGE_AS_STRING:
				setStorageAsString(STORAGE_AS_STRING_EDEFAULT);
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
			case BuilderStatePackage.RESOURCE_DESCRIPTION__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case BuilderStatePackage.RESOURCE_DESCRIPTION__EXPORTED_OBJECTS:
				return exportedObjects != null && !exportedObjects.isEmpty();
			case BuilderStatePackage.RESOURCE_DESCRIPTION__IMPORTED_NAMES:
				return importedNames != null && !importedNames.isEmpty();
			case BuilderStatePackage.RESOURCE_DESCRIPTION__STORAGE_AS_STRING:
				return STORAGE_AS_STRING_EDEFAULT == null ? storageAsString != null : !STORAGE_AS_STRING_EDEFAULT.equals(storageAsString);
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
		result.append(", storageAsString: ");
		result.append(storageAsString);
		result.append(')');
		return result.toString();
	}
	
	
	private IStorage storage = null;

	public IStorage getStorage() {
		if (storage==null && getStorageAsString()!=null) {
			storage = Access.storageUtil.getStorage(getStorageAsString());
		}
		return storage;
	}
	
	public void setStorage(IStorage storage) {
		this.storage = storage;
		setStorageAsString(Access.storageUtil.toExternalString(storage));
	}

} //ResourceDescriptionImpl
