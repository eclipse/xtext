/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResourceDescriptionImpl.java,v 1.10 2010/04/12 20:19:21 szarnekow Exp $
 */
package org.eclipse.xtext.builder.builderState.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.builder.builderState.BuilderStatePackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.EObjectDescriptionLookUp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl#getURI <em>URI</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl#getExportedObjects <em>Exported Objects</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl#getReferenceDescriptions <em>Reference Descriptions</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl#getImportedNames <em>Imported Names</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceDescriptionImpl extends org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container implements IResourceDescription {
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
	 * The cached value of the '{@link #getReferenceDescriptions() <em>Reference Descriptions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceDescriptions()
	 * @generated
	 * @ordered
	 */
	protected EList<IReferenceDescription> referenceDescriptions;

	/**
	 * The cached value of the '{@link #getImportedNames() <em>Imported Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedNames()
	 * @generated
	 * @ordered
	 */
	protected EList<QualifiedName> importedNames;

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
	@Override
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

	private EObjectDescriptionLookUp lookUp;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("serial")
	public EList<IEObjectDescription> getExportedObjects() {
		if (exportedObjects == null) {
			exportedObjects = new EObjectContainmentEList<IEObjectDescription>(IEObjectDescription.class, this, BuilderStatePackage.RESOURCE_DESCRIPTION__EXPORTED_OBJECTS)  {
				@Override
				protected void didChange() {
					if (lookUp != null)
						lookUp.setExportedObjects(exportedObjects);
				}
			};
		}
		return exportedObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<QualifiedName> getImportedNames() {
		if (importedNames == null) {
			importedNames = new EDataTypeUniqueEList<QualifiedName>(QualifiedName.class, this, BuilderStatePackage.RESOURCE_DESCRIPTION__IMPORTED_NAMES);
		}
		return importedNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean isEmpty() {
		return exportedObjects == null || exportedObjects.isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		return getLookUp().getExportedObjectsByType(type);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		return getLookUp().getExportedObjects(type, name, ignoreCase);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		return getLookUp().getExportedObjectsByObject(object);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IReferenceDescription> getReferenceDescriptions() {
		if (referenceDescriptions == null) {
			referenceDescriptions = new EObjectContainmentEList<IReferenceDescription>(IReferenceDescription.class, this, BuilderStatePackage.RESOURCE_DESCRIPTION__REFERENCE_DESCRIPTIONS);
		}
		return referenceDescriptions;
	}
	
	private EObjectDescriptionLookUp getLookUp() {
		if (lookUp == null) {
			lookUp = new EObjectDescriptionLookUp(getExportedObjects());
		}
		return lookUp;
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
			case BuilderStatePackage.RESOURCE_DESCRIPTION__REFERENCE_DESCRIPTIONS:
				return ((InternalEList<?>)getReferenceDescriptions()).basicRemove(otherEnd, msgs);
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
			case BuilderStatePackage.RESOURCE_DESCRIPTION__REFERENCE_DESCRIPTIONS:
				return getReferenceDescriptions();
			case BuilderStatePackage.RESOURCE_DESCRIPTION__IMPORTED_NAMES:
				return getImportedNames();
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
			case BuilderStatePackage.RESOURCE_DESCRIPTION__REFERENCE_DESCRIPTIONS:
				getReferenceDescriptions().clear();
				getReferenceDescriptions().addAll((Collection<? extends IReferenceDescription>)newValue);
				return;
			case BuilderStatePackage.RESOURCE_DESCRIPTION__IMPORTED_NAMES:
				getImportedNames().clear();
				getImportedNames().addAll((Collection<? extends QualifiedName>)newValue);
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
			case BuilderStatePackage.RESOURCE_DESCRIPTION__REFERENCE_DESCRIPTIONS:
				getReferenceDescriptions().clear();
				return;
			case BuilderStatePackage.RESOURCE_DESCRIPTION__IMPORTED_NAMES:
				getImportedNames().clear();
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
			case BuilderStatePackage.RESOURCE_DESCRIPTION__REFERENCE_DESCRIPTIONS:
				return referenceDescriptions != null && !referenceDescriptions.isEmpty();
			case BuilderStatePackage.RESOURCE_DESCRIPTION__IMPORTED_NAMES:
				return importedNames != null && !importedNames.isEmpty();
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (URI: ");
		result.append(uri);
		result.append(", importedNames: ");
		result.append(importedNames);
		result.append(')');
		return result.toString();
	}

} //ResourceDescriptionImpl
