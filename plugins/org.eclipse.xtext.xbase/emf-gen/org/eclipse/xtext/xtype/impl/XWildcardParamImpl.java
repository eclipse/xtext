/**
 * <copyright>
 * </copyright>
 *
 * $Id: XWildcardParamImpl.java,v 1.1 2010/01/16 08:50:50 sefftinge Exp $
 */
package org.eclipse.xtext.xtype.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xtype.XTypeRef;
import org.eclipse.xtext.xtype.XWildcardParam;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XWildcard Param</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XWildcardParamImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XWildcardParamImpl#getSuper <em>Super</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XWildcardParamImpl extends XTypeRefImpl implements XWildcardParam {
	/**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected XTypeRef extends_;

	/**
	 * The cached value of the '{@link #getSuper() <em>Super</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuper()
	 * @generated
	 * @ordered
	 */
	protected XTypeRef super_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XWildcardParamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XtypePackage.Literals.XWILDCARD_PARAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XTypeRef getExtends() {
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtends(XTypeRef newExtends, NotificationChain msgs) {
		XTypeRef oldExtends = extends_;
		extends_ = newExtends;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtypePackage.XWILDCARD_PARAM__EXTENDS, oldExtends, newExtends);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtends(XTypeRef newExtends) {
		if (newExtends != extends_) {
			NotificationChain msgs = null;
			if (extends_ != null)
				msgs = ((InternalEObject)extends_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtypePackage.XWILDCARD_PARAM__EXTENDS, null, msgs);
			if (newExtends != null)
				msgs = ((InternalEObject)newExtends).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtypePackage.XWILDCARD_PARAM__EXTENDS, null, msgs);
			msgs = basicSetExtends(newExtends, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtypePackage.XWILDCARD_PARAM__EXTENDS, newExtends, newExtends));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XTypeRef getSuper() {
		return super_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuper(XTypeRef newSuper, NotificationChain msgs) {
		XTypeRef oldSuper = super_;
		super_ = newSuper;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtypePackage.XWILDCARD_PARAM__SUPER, oldSuper, newSuper);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuper(XTypeRef newSuper) {
		if (newSuper != super_) {
			NotificationChain msgs = null;
			if (super_ != null)
				msgs = ((InternalEObject)super_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtypePackage.XWILDCARD_PARAM__SUPER, null, msgs);
			if (newSuper != null)
				msgs = ((InternalEObject)newSuper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtypePackage.XWILDCARD_PARAM__SUPER, null, msgs);
			msgs = basicSetSuper(newSuper, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtypePackage.XWILDCARD_PARAM__SUPER, newSuper, newSuper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XtypePackage.XWILDCARD_PARAM__EXTENDS:
				return basicSetExtends(null, msgs);
			case XtypePackage.XWILDCARD_PARAM__SUPER:
				return basicSetSuper(null, msgs);
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
			case XtypePackage.XWILDCARD_PARAM__EXTENDS:
				return getExtends();
			case XtypePackage.XWILDCARD_PARAM__SUPER:
				return getSuper();
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
			case XtypePackage.XWILDCARD_PARAM__EXTENDS:
				setExtends((XTypeRef)newValue);
				return;
			case XtypePackage.XWILDCARD_PARAM__SUPER:
				setSuper((XTypeRef)newValue);
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
			case XtypePackage.XWILDCARD_PARAM__EXTENDS:
				setExtends((XTypeRef)null);
				return;
			case XtypePackage.XWILDCARD_PARAM__SUPER:
				setSuper((XTypeRef)null);
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
			case XtypePackage.XWILDCARD_PARAM__EXTENDS:
				return extends_ != null;
			case XtypePackage.XWILDCARD_PARAM__SUPER:
				return super_ != null;
		}
		return super.eIsSet(featureID);
	}

} //XWildcardParamImpl
