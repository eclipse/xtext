/**
 * <copyright>
 * </copyright>
 *
 * $Id: ReferenceDescriptionImpl.java,v 1.1 2009/12/02 16:38:29 sefftinge Exp $
 */
package org.eclipse.xtext.builder.builderState.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.builder.builderState.BuilderStatePackage;
import org.eclipse.xtext.resource.IReferenceDescription;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Reference Description</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.ReferenceDescriptionImpl#getSourceEObjectUri <em>Source EObject Uri</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.ReferenceDescriptionImpl#getTargetEObjectUri <em>Target EObject Uri</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.ReferenceDescriptionImpl#getIndexInList <em>Index In List</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.impl.ReferenceDescriptionImpl#getExternalFormOfEReference <em>External Form Of EReference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceDescriptionImpl extends Container implements IReferenceDescription {
	/**
	 * The default value of the '{@link #getSourceEObjectUri() <em>Source EObject Uri</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSourceEObjectUri()
	 * @generated
	 * @ordered
	 */
	protected static final URI SOURCE_EOBJECT_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceEObjectUri() <em>Source EObject Uri</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSourceEObjectUri()
	 * @generated
	 * @ordered
	 */
	protected URI sourceEObjectUri = SOURCE_EOBJECT_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetEObjectUri() <em>Target EObject Uri</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTargetEObjectUri()
	 * @generated
	 * @ordered
	 */
	protected static final URI TARGET_EOBJECT_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetEObjectUri() <em>Target EObject Uri</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTargetEObjectUri()
	 * @generated
	 * @ordered
	 */
	protected URI targetEObjectUri = TARGET_EOBJECT_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndexInList() <em>Index In List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexInList()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_IN_LIST_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getIndexInList() <em>Index In List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexInList()
	 * @generated
	 * @ordered
	 */
	protected int indexInList = INDEX_IN_LIST_EDEFAULT;

	/**
	 * The default value of the '{@link #getExternalFormOfEReference() <em>External Form Of EReference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalFormOfEReference()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTERNAL_FORM_OF_EREFERENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExternalFormOfEReference() <em>External Form Of EReference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalFormOfEReference()
	 * @generated
	 * @ordered
	 */
	protected String externalFormOfEReference = EXTERNAL_FORM_OF_EREFERENCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BuilderStatePackage.Literals.REFERENCE_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URI getSourceEObjectUri() {
		return sourceEObjectUri;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceEObjectUri(URI newSourceEObjectUri) {
		URI oldSourceEObjectUri = sourceEObjectUri;
		sourceEObjectUri = newSourceEObjectUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuilderStatePackage.REFERENCE_DESCRIPTION__SOURCE_EOBJECT_URI, oldSourceEObjectUri, sourceEObjectUri));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URI getTargetEObjectUri() {
		return targetEObjectUri;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetEObjectUri(URI newTargetEObjectUri) {
		URI oldTargetEObjectUri = targetEObjectUri;
		targetEObjectUri = newTargetEObjectUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuilderStatePackage.REFERENCE_DESCRIPTION__TARGET_EOBJECT_URI, oldTargetEObjectUri, targetEObjectUri));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndexInList() {
		return indexInList;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexInList(int newIndexInList) {
		int oldIndexInList = indexInList;
		indexInList = newIndexInList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuilderStatePackage.REFERENCE_DESCRIPTION__INDEX_IN_LIST, oldIndexInList, indexInList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExternalFormOfEReference() {
		return externalFormOfEReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExternalFormOfEReference(String newExternalFormOfEReference) {
		String oldExternalFormOfEReference = externalFormOfEReference;
		externalFormOfEReference = newExternalFormOfEReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuilderStatePackage.REFERENCE_DESCRIPTION__EXTERNAL_FORM_OF_EREFERENCE, oldExternalFormOfEReference, externalFormOfEReference));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BuilderStatePackage.REFERENCE_DESCRIPTION__SOURCE_EOBJECT_URI:
				return getSourceEObjectUri();
			case BuilderStatePackage.REFERENCE_DESCRIPTION__TARGET_EOBJECT_URI:
				return getTargetEObjectUri();
			case BuilderStatePackage.REFERENCE_DESCRIPTION__INDEX_IN_LIST:
				return getIndexInList();
			case BuilderStatePackage.REFERENCE_DESCRIPTION__EXTERNAL_FORM_OF_EREFERENCE:
				return getExternalFormOfEReference();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BuilderStatePackage.REFERENCE_DESCRIPTION__SOURCE_EOBJECT_URI:
				setSourceEObjectUri((URI)newValue);
				return;
			case BuilderStatePackage.REFERENCE_DESCRIPTION__TARGET_EOBJECT_URI:
				setTargetEObjectUri((URI)newValue);
				return;
			case BuilderStatePackage.REFERENCE_DESCRIPTION__INDEX_IN_LIST:
				setIndexInList((Integer)newValue);
				return;
			case BuilderStatePackage.REFERENCE_DESCRIPTION__EXTERNAL_FORM_OF_EREFERENCE:
				setExternalFormOfEReference((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BuilderStatePackage.REFERENCE_DESCRIPTION__SOURCE_EOBJECT_URI:
				setSourceEObjectUri(SOURCE_EOBJECT_URI_EDEFAULT);
				return;
			case BuilderStatePackage.REFERENCE_DESCRIPTION__TARGET_EOBJECT_URI:
				setTargetEObjectUri(TARGET_EOBJECT_URI_EDEFAULT);
				return;
			case BuilderStatePackage.REFERENCE_DESCRIPTION__INDEX_IN_LIST:
				setIndexInList(INDEX_IN_LIST_EDEFAULT);
				return;
			case BuilderStatePackage.REFERENCE_DESCRIPTION__EXTERNAL_FORM_OF_EREFERENCE:
				setExternalFormOfEReference(EXTERNAL_FORM_OF_EREFERENCE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BuilderStatePackage.REFERENCE_DESCRIPTION__SOURCE_EOBJECT_URI:
				return SOURCE_EOBJECT_URI_EDEFAULT == null ? sourceEObjectUri != null : !SOURCE_EOBJECT_URI_EDEFAULT.equals(sourceEObjectUri);
			case BuilderStatePackage.REFERENCE_DESCRIPTION__TARGET_EOBJECT_URI:
				return TARGET_EOBJECT_URI_EDEFAULT == null ? targetEObjectUri != null : !TARGET_EOBJECT_URI_EDEFAULT.equals(targetEObjectUri);
			case BuilderStatePackage.REFERENCE_DESCRIPTION__INDEX_IN_LIST:
				return indexInList != INDEX_IN_LIST_EDEFAULT;
			case BuilderStatePackage.REFERENCE_DESCRIPTION__EXTERNAL_FORM_OF_EREFERENCE:
				return EXTERNAL_FORM_OF_EREFERENCE_EDEFAULT == null ? externalFormOfEReference != null : !EXTERNAL_FORM_OF_EREFERENCE_EDEFAULT.equals(externalFormOfEReference);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sourceEObjectUri: ");
		result.append(sourceEObjectUri);
		result.append(", targetEObjectUri: ");
		result.append(targetEObjectUri);
		result.append(", indexInList: ");
		result.append(indexInList);
		result.append(", externalFormOfEReference: ");
		result.append(externalFormOfEReference);
		result.append(')');
		return result.toString();
	}

	private EReference reference;

	public EReference getEReference() {
		if (reference==null) {
			reference = EcoreUtil2.getEReferenceFromExternalForm(EPackage.Registry.INSTANCE, getExternalFormOfEReference());
		}
		return reference;
	}
	
	public void setReference(EReference reference) {
		this.reference = reference;
		this.setExternalFormOfEReference(EcoreUtil2.toExternalForm(reference));
	}

} //ReferenceDescriptionImpl
