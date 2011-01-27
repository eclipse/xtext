/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.xtend2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtext.common.types.JvmMember;

import org.eclipse.xtext.common.types.impl.JvmIdentifiableElementImpl;

import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendMember;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xtend Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendMemberImpl#getDeclaringType <em>Declaring Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendMemberImpl#getInferredJvmMember <em>Inferred Jvm Member</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class XtendMemberImpl extends JvmIdentifiableElementImpl implements XtendMember
{
	/**
	 * The cached value of the '{@link #getInferredJvmMember() <em>Inferred Jvm Member</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInferredJvmMember()
	 * @generated
	 * @ordered
	 */
	protected JvmMember inferredJvmMember;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XtendMemberImpl()
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
		return Xtend2Package.Literals.XTEND_MEMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendClass getDeclaringType()
	{
		if (eContainerFeatureID() != Xtend2Package.XTEND_MEMBER__DECLARING_TYPE) return null;
		return (XtendClass)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaringType(XtendClass newDeclaringType, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newDeclaringType, Xtend2Package.XTEND_MEMBER__DECLARING_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaringType(XtendClass newDeclaringType)
	{
		if (newDeclaringType != eInternalContainer() || (eContainerFeatureID() != Xtend2Package.XTEND_MEMBER__DECLARING_TYPE && newDeclaringType != null))
		{
			if (EcoreUtil.isAncestor(this, newDeclaringType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDeclaringType != null)
				msgs = ((InternalEObject)newDeclaringType).eInverseAdd(this, Xtend2Package.XTEND_CLASS__MEMBERS, XtendClass.class, msgs);
			msgs = basicSetDeclaringType(newDeclaringType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xtend2Package.XTEND_MEMBER__DECLARING_TYPE, newDeclaringType, newDeclaringType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmMember getInferredJvmMember()
	{
		if (inferredJvmMember != null && inferredJvmMember.eIsProxy())
		{
			InternalEObject oldInferredJvmMember = (InternalEObject)inferredJvmMember;
			inferredJvmMember = (JvmMember)eResolveProxy(oldInferredJvmMember);
			if (inferredJvmMember != oldInferredJvmMember)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xtend2Package.XTEND_MEMBER__INFERRED_JVM_MEMBER, oldInferredJvmMember, inferredJvmMember));
			}
		}
		return inferredJvmMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmMember basicGetInferredJvmMember()
	{
		return inferredJvmMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInferredJvmMember(JvmMember newInferredJvmMember)
	{
		JvmMember oldInferredJvmMember = inferredJvmMember;
		inferredJvmMember = newInferredJvmMember;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xtend2Package.XTEND_MEMBER__INFERRED_JVM_MEMBER, oldInferredJvmMember, inferredJvmMember));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimpleName()
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case Xtend2Package.XTEND_MEMBER__DECLARING_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDeclaringType((XtendClass)otherEnd, msgs);
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
			case Xtend2Package.XTEND_MEMBER__DECLARING_TYPE:
				return basicSetDeclaringType(null, msgs);
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
			case Xtend2Package.XTEND_MEMBER__DECLARING_TYPE:
				return eInternalContainer().eInverseRemove(this, Xtend2Package.XTEND_CLASS__MEMBERS, XtendClass.class, msgs);
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
			case Xtend2Package.XTEND_MEMBER__DECLARING_TYPE:
				return getDeclaringType();
			case Xtend2Package.XTEND_MEMBER__INFERRED_JVM_MEMBER:
				if (resolve) return getInferredJvmMember();
				return basicGetInferredJvmMember();
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
			case Xtend2Package.XTEND_MEMBER__DECLARING_TYPE:
				setDeclaringType((XtendClass)newValue);
				return;
			case Xtend2Package.XTEND_MEMBER__INFERRED_JVM_MEMBER:
				setInferredJvmMember((JvmMember)newValue);
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
			case Xtend2Package.XTEND_MEMBER__DECLARING_TYPE:
				setDeclaringType((XtendClass)null);
				return;
			case Xtend2Package.XTEND_MEMBER__INFERRED_JVM_MEMBER:
				setInferredJvmMember((JvmMember)null);
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
			case Xtend2Package.XTEND_MEMBER__DECLARING_TYPE:
				return getDeclaringType() != null;
			case Xtend2Package.XTEND_MEMBER__INFERRED_JVM_MEMBER:
				return inferredJvmMember != null;
		}
		return super.eIsSet(featureID);
	}

} //XtendMemberImpl
