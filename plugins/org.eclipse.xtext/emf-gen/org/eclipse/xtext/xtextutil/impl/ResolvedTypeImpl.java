/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResolvedTypeImpl.java,v 1.1 2008/05/13 13:07:23 sefftinge Exp $
 */
package org.eclipse.xtext.xtextutil.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xtextutil.MetaModel;
import org.eclipse.xtext.xtextutil.ResolvedType;
import org.eclipse.xtext.xtextutil.XtextutilPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resolved Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextutil.impl.ResolvedTypeImpl#getMetaModel <em>Meta Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResolvedTypeImpl extends AbstractTypeImpl implements ResolvedType {
	/**
	 * The cached value of the '{@link #getMetaModel() <em>Meta Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModel()
	 * @generated
	 * @ordered
	 */
	protected MetaModel metaModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResolvedTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XtextutilPackage.Literals.RESOLVED_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaModel getMetaModel() {
		if (metaModel != null && metaModel.eIsProxy()) {
			InternalEObject oldMetaModel = (InternalEObject)metaModel;
			metaModel = (MetaModel)eResolveProxy(oldMetaModel);
			if (metaModel != oldMetaModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XtextutilPackage.RESOLVED_TYPE__META_MODEL, oldMetaModel, metaModel));
			}
		}
		return metaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaModel basicGetMetaModel() {
		return metaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaModel(MetaModel newMetaModel) {
		MetaModel oldMetaModel = metaModel;
		metaModel = newMetaModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextutilPackage.RESOLVED_TYPE__META_MODEL, oldMetaModel, metaModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XtextutilPackage.RESOLVED_TYPE__META_MODEL:
				if (resolve) return getMetaModel();
				return basicGetMetaModel();
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
			case XtextutilPackage.RESOLVED_TYPE__META_MODEL:
				setMetaModel((MetaModel)newValue);
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
			case XtextutilPackage.RESOLVED_TYPE__META_MODEL:
				setMetaModel((MetaModel)null);
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
			case XtextutilPackage.RESOLVED_TYPE__META_MODEL:
				return metaModel != null;
		}
		return super.eIsSet(featureID);
	}

} //ResolvedTypeImpl
