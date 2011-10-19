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

import org.eclipse.xtext.common.types.JvmDeclaredType;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XFeature Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XFeatureCallImpl#getFeatureCallArguments <em>Feature Call Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XFeatureCallImpl#isExplicitOperationCall <em>Explicit Operation Call</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XFeatureCallImpl#getDeclaringType <em>Declaring Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XFeatureCallImpl#getImplicitFirstArgument <em>Implicit First Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XFeatureCallImpl extends XAbstractFeatureCallImplCustom implements XFeatureCall
{
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
	 * The cached value of the '{@link #getDeclaringType() <em>Declaring Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaringType()
	 * @generated
	 * @ordered
	 */
	protected JvmDeclaredType declaringType;

	/**
	 * The cached value of the '{@link #getImplicitFirstArgument() <em>Implicit First Argument</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplicitFirstArgument()
	 * @generated
	 * @ordered
	 */
	protected XExpression implicitFirstArgument;

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
	public JvmDeclaredType getDeclaringType()
	{
		if (declaringType != null && declaringType.eIsProxy())
		{
			InternalEObject oldDeclaringType = (InternalEObject)declaringType;
			declaringType = (JvmDeclaredType)eResolveProxy(oldDeclaringType);
			if (declaringType != oldDeclaringType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XbasePackage.XFEATURE_CALL__DECLARING_TYPE, oldDeclaringType, declaringType));
			}
		}
		return declaringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmDeclaredType basicGetDeclaringType()
	{
		return declaringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaringType(JvmDeclaredType newDeclaringType)
	{
		JvmDeclaredType oldDeclaringType = declaringType;
		declaringType = newDeclaringType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFEATURE_CALL__DECLARING_TYPE, oldDeclaringType, declaringType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getImplicitFirstArgument()
	{
		return implicitFirstArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImplicitFirstArgument(XExpression newImplicitFirstArgument, NotificationChain msgs)
	{
		XExpression oldImplicitFirstArgument = implicitFirstArgument;
		implicitFirstArgument = newImplicitFirstArgument;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFEATURE_CALL__IMPLICIT_FIRST_ARGUMENT, oldImplicitFirstArgument, newImplicitFirstArgument);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplicitFirstArgument(XExpression newImplicitFirstArgument)
	{
		if (newImplicitFirstArgument != implicitFirstArgument)
		{
			NotificationChain msgs = null;
			if (implicitFirstArgument != null)
				msgs = ((InternalEObject)implicitFirstArgument).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFEATURE_CALL__IMPLICIT_FIRST_ARGUMENT, null, msgs);
			if (newImplicitFirstArgument != null)
				msgs = ((InternalEObject)newImplicitFirstArgument).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFEATURE_CALL__IMPLICIT_FIRST_ARGUMENT, null, msgs);
			msgs = basicSetImplicitFirstArgument(newImplicitFirstArgument, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFEATURE_CALL__IMPLICIT_FIRST_ARGUMENT, newImplicitFirstArgument, newImplicitFirstArgument));
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
			case XbasePackage.XFEATURE_CALL__IMPLICIT_FIRST_ARGUMENT:
				return basicSetImplicitFirstArgument(null, msgs);
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
			case XbasePackage.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS:
				return getFeatureCallArguments();
			case XbasePackage.XFEATURE_CALL__EXPLICIT_OPERATION_CALL:
				return isExplicitOperationCall();
			case XbasePackage.XFEATURE_CALL__DECLARING_TYPE:
				if (resolve) return getDeclaringType();
				return basicGetDeclaringType();
			case XbasePackage.XFEATURE_CALL__IMPLICIT_FIRST_ARGUMENT:
				return getImplicitFirstArgument();
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
			case XbasePackage.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS:
				getFeatureCallArguments().clear();
				getFeatureCallArguments().addAll((Collection<? extends XExpression>)newValue);
				return;
			case XbasePackage.XFEATURE_CALL__EXPLICIT_OPERATION_CALL:
				setExplicitOperationCall((Boolean)newValue);
				return;
			case XbasePackage.XFEATURE_CALL__DECLARING_TYPE:
				setDeclaringType((JvmDeclaredType)newValue);
				return;
			case XbasePackage.XFEATURE_CALL__IMPLICIT_FIRST_ARGUMENT:
				setImplicitFirstArgument((XExpression)newValue);
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
			case XbasePackage.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS:
				getFeatureCallArguments().clear();
				return;
			case XbasePackage.XFEATURE_CALL__EXPLICIT_OPERATION_CALL:
				setExplicitOperationCall(EXPLICIT_OPERATION_CALL_EDEFAULT);
				return;
			case XbasePackage.XFEATURE_CALL__DECLARING_TYPE:
				setDeclaringType((JvmDeclaredType)null);
				return;
			case XbasePackage.XFEATURE_CALL__IMPLICIT_FIRST_ARGUMENT:
				setImplicitFirstArgument((XExpression)null);
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
			case XbasePackage.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS:
				return featureCallArguments != null && !featureCallArguments.isEmpty();
			case XbasePackage.XFEATURE_CALL__EXPLICIT_OPERATION_CALL:
				return explicitOperationCall != EXPLICIT_OPERATION_CALL_EDEFAULT;
			case XbasePackage.XFEATURE_CALL__DECLARING_TYPE:
				return declaringType != null;
			case XbasePackage.XFEATURE_CALL__IMPLICIT_FIRST_ARGUMENT:
				return implicitFirstArgument != null;
		}
		return super.eIsSet(featureID);
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
