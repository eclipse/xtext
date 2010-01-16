/**
 * <copyright>
 * </copyright>
 *
 * $Id: XTypeParamDeclarationImpl.java,v 1.1 2010/01/16 08:50:50 sefftinge Exp $
 */
package org.eclipse.xtext.xtype.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.impl.TypeImpl;

import org.eclipse.xtext.xtype.XTypeParamDeclaration;
import org.eclipse.xtext.xtype.XTypeRef;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XType Param Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XTypeParamDeclarationImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XTypeParamDeclarationImpl#getSuper <em>Super</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XTypeParamDeclarationImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XTypeParamDeclarationImpl extends TypeImpl implements XTypeParamDeclaration {
	/**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected EList<XTypeRef> extends_;

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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XTypeParamDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XtypePackage.Literals.XTYPE_PARAM_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XTypeRef> getExtends() {
		if (extends_ == null) {
			extends_ = new EObjectContainmentEList<XTypeRef>(XTypeRef.class, this, XtypePackage.XTYPE_PARAM_DECLARATION__EXTENDS);
		}
		return extends_;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtypePackage.XTYPE_PARAM_DECLARATION__SUPER, oldSuper, newSuper);
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
				msgs = ((InternalEObject)super_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtypePackage.XTYPE_PARAM_DECLARATION__SUPER, null, msgs);
			if (newSuper != null)
				msgs = ((InternalEObject)newSuper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtypePackage.XTYPE_PARAM_DECLARATION__SUPER, null, msgs);
			msgs = basicSetSuper(newSuper, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtypePackage.XTYPE_PARAM_DECLARATION__SUPER, newSuper, newSuper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtypePackage.XTYPE_PARAM_DECLARATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XtypePackage.XTYPE_PARAM_DECLARATION__EXTENDS:
				return ((InternalEList<?>)getExtends()).basicRemove(otherEnd, msgs);
			case XtypePackage.XTYPE_PARAM_DECLARATION__SUPER:
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
			case XtypePackage.XTYPE_PARAM_DECLARATION__EXTENDS:
				return getExtends();
			case XtypePackage.XTYPE_PARAM_DECLARATION__SUPER:
				return getSuper();
			case XtypePackage.XTYPE_PARAM_DECLARATION__NAME:
				return getName();
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
			case XtypePackage.XTYPE_PARAM_DECLARATION__EXTENDS:
				getExtends().clear();
				getExtends().addAll((Collection<? extends XTypeRef>)newValue);
				return;
			case XtypePackage.XTYPE_PARAM_DECLARATION__SUPER:
				setSuper((XTypeRef)newValue);
				return;
			case XtypePackage.XTYPE_PARAM_DECLARATION__NAME:
				setName((String)newValue);
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
			case XtypePackage.XTYPE_PARAM_DECLARATION__EXTENDS:
				getExtends().clear();
				return;
			case XtypePackage.XTYPE_PARAM_DECLARATION__SUPER:
				setSuper((XTypeRef)null);
				return;
			case XtypePackage.XTYPE_PARAM_DECLARATION__NAME:
				setName(NAME_EDEFAULT);
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
			case XtypePackage.XTYPE_PARAM_DECLARATION__EXTENDS:
				return extends_ != null && !extends_.isEmpty();
			case XtypePackage.XTYPE_PARAM_DECLARATION__SUPER:
				return super_ != null;
			case XtypePackage.XTYPE_PARAM_DECLARATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getCanonicalName() {
		return getName();
	}

} //XTypeParamDeclarationImpl
