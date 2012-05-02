/**
 */
package org.eclipse.xtend.core.xtend.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendClassSuperCallReferable;
import org.eclipse.xtend.core.xtend.XtendPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Super Call Referable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.impl.XtendClassSuperCallReferableImpl#getXtendClass <em>Xtend Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XtendClassSuperCallReferableImpl extends MinimalEObjectImpl.Container implements XtendClassSuperCallReferable
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XtendClassSuperCallReferableImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return XtendPackage.Literals.XTEND_CLASS_SUPER_CALL_REFERABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendClass getXtendClass()
	{
		if (eContainerFeatureID() != XtendPackage.XTEND_CLASS_SUPER_CALL_REFERABLE__XTEND_CLASS) return null;
		return (XtendClass)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetXtendClass(XtendClass newXtendClass, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newXtendClass, XtendPackage.XTEND_CLASS_SUPER_CALL_REFERABLE__XTEND_CLASS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXtendClass(XtendClass newXtendClass)
	{
		if (newXtendClass != eInternalContainer() || (eContainerFeatureID() != XtendPackage.XTEND_CLASS_SUPER_CALL_REFERABLE__XTEND_CLASS && newXtendClass != null))
		{
			if (EcoreUtil.isAncestor(this, newXtendClass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newXtendClass != null)
				msgs = ((InternalEObject)newXtendClass).eInverseAdd(this, XtendPackage.XTEND_CLASS__SUPER_CALL_REFERABLE, XtendClass.class, msgs);
			msgs = basicSetXtendClass(newXtendClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtendPackage.XTEND_CLASS_SUPER_CALL_REFERABLE__XTEND_CLASS, newXtendClass, newXtendClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case XtendPackage.XTEND_CLASS_SUPER_CALL_REFERABLE__XTEND_CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetXtendClass((XtendClass)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case XtendPackage.XTEND_CLASS_SUPER_CALL_REFERABLE__XTEND_CLASS:
				return basicSetXtendClass(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case XtendPackage.XTEND_CLASS_SUPER_CALL_REFERABLE__XTEND_CLASS:
				return eInternalContainer().eInverseRemove(this, XtendPackage.XTEND_CLASS__SUPER_CALL_REFERABLE, XtendClass.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case XtendPackage.XTEND_CLASS_SUPER_CALL_REFERABLE__XTEND_CLASS:
				return getXtendClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case XtendPackage.XTEND_CLASS_SUPER_CALL_REFERABLE__XTEND_CLASS:
				setXtendClass((XtendClass)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case XtendPackage.XTEND_CLASS_SUPER_CALL_REFERABLE__XTEND_CLASS:
				setXtendClass((XtendClass)null);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case XtendPackage.XTEND_CLASS_SUPER_CALL_REFERABLE__XTEND_CLASS:
				return getXtendClass() != null;
		}
		return super.eIsSet(featureID);
	}

} //XtendClassSuperCallReferableImpl
