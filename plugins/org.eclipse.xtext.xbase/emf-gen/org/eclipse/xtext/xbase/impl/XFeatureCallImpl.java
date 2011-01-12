/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xbase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmIdentifyableElement;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XImplicitReceiverCall;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XFeature Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XFeatureCallImpl#getImplicitReceiver <em>Implicit Receiver</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XFeatureCallImpl#getFeatureCallArguments <em>Feature Call Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XFeatureCallImpl#isExplicitOperationCall <em>Explicit Operation Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XFeatureCallImpl extends XAbstractFeatureCallImplCustom implements XFeatureCall
{
	/**
	 * The cached value of the '{@link #getImplicitReceiver() <em>Implicit Receiver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplicitReceiver()
	 * @generated
	 * @ordered
	 */
	protected JvmIdentifyableElement implicitReceiver;

	/**
	 * The cached value of the '{@link #getFeatureCallArguments() <em>Feature Call Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureCallArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<XExpression> featureCallArguments;

	/**
	 * The default value of the '{@link #isExplicitOperationCall() <em>Explicit Operation Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExplicitOperationCall()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXPLICIT_OPERATION_CALL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExplicitOperationCall() <em>Explicit Operation Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExplicitOperationCall()
	 * @generated
	 * @ordered
	 */
	protected boolean explicitOperationCall = EXPLICIT_OPERATION_CALL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XFeatureCallImpl()
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
		return XbasePackage.Literals.XFEATURE_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmIdentifyableElement getImplicitReceiver()
	{
		if (implicitReceiver != null && implicitReceiver.eIsProxy())
		{
			InternalEObject oldImplicitReceiver = (InternalEObject)implicitReceiver;
			implicitReceiver = (JvmIdentifyableElement)eResolveProxy(oldImplicitReceiver);
			if (implicitReceiver != oldImplicitReceiver)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XbasePackage.XFEATURE_CALL__IMPLICIT_RECEIVER, oldImplicitReceiver, implicitReceiver));
			}
		}
		return implicitReceiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmIdentifyableElement basicGetImplicitReceiver()
	{
		return implicitReceiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplicitReceiver(JvmIdentifyableElement newImplicitReceiver)
	{
		JvmIdentifyableElement oldImplicitReceiver = implicitReceiver;
		implicitReceiver = newImplicitReceiver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFEATURE_CALL__IMPLICIT_RECEIVER, oldImplicitReceiver, implicitReceiver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XExpression> getFeatureCallArguments()
	{
		if (featureCallArguments == null)
		{
			featureCallArguments = new EObjectContainmentEList<XExpression>(XExpression.class, this, XbasePackage.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS);
		}
		return featureCallArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExplicitOperationCall()
	{
		return explicitOperationCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExplicitOperationCall(boolean newExplicitOperationCall)
	{
		boolean oldExplicitOperationCall = explicitOperationCall;
		explicitOperationCall = newExplicitOperationCall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFEATURE_CALL__EXPLICIT_OPERATION_CALL, oldExplicitOperationCall, explicitOperationCall));
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
			case XbasePackage.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS:
				return ((InternalEList<?>)getFeatureCallArguments()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case XbasePackage.XFEATURE_CALL__IMPLICIT_RECEIVER:
				if (resolve) return getImplicitReceiver();
				return basicGetImplicitReceiver();
			case XbasePackage.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS:
				return getFeatureCallArguments();
			case XbasePackage.XFEATURE_CALL__EXPLICIT_OPERATION_CALL:
				return isExplicitOperationCall();
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case XbasePackage.XFEATURE_CALL__IMPLICIT_RECEIVER:
				setImplicitReceiver((JvmIdentifyableElement)newValue);
				return;
			case XbasePackage.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS:
				getFeatureCallArguments().clear();
				getFeatureCallArguments().addAll((Collection<? extends XExpression>)newValue);
				return;
			case XbasePackage.XFEATURE_CALL__EXPLICIT_OPERATION_CALL:
				setExplicitOperationCall((Boolean)newValue);
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
			case XbasePackage.XFEATURE_CALL__IMPLICIT_RECEIVER:
				setImplicitReceiver((JvmIdentifyableElement)null);
				return;
			case XbasePackage.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS:
				getFeatureCallArguments().clear();
				return;
			case XbasePackage.XFEATURE_CALL__EXPLICIT_OPERATION_CALL:
				setExplicitOperationCall(EXPLICIT_OPERATION_CALL_EDEFAULT);
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
			case XbasePackage.XFEATURE_CALL__IMPLICIT_RECEIVER:
				return implicitReceiver != null;
			case XbasePackage.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS:
				return featureCallArguments != null && !featureCallArguments.isEmpty();
			case XbasePackage.XFEATURE_CALL__EXPLICIT_OPERATION_CALL:
				return explicitOperationCall != EXPLICIT_OPERATION_CALL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == XImplicitReceiverCall.class)
		{
			switch (derivedFeatureID)
			{
				case XbasePackage.XFEATURE_CALL__IMPLICIT_RECEIVER: return XbasePackage.XIMPLICIT_RECEIVER_CALL__IMPLICIT_RECEIVER;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == XImplicitReceiverCall.class)
		{
			switch (baseFeatureID)
			{
				case XbasePackage.XIMPLICIT_RECEIVER_CALL__IMPLICIT_RECEIVER: return XbasePackage.XFEATURE_CALL__IMPLICIT_RECEIVER;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (explicitOperationCall: ");
		result.append(explicitOperationCall);
		result.append(')');
		return result.toString();
	}

} //XFeatureCallImpl
