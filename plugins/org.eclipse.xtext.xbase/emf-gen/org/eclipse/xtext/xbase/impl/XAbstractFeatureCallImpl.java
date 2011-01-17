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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XAbstract Feature Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XAbstractFeatureCallImpl#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XAbstractFeatureCallImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XAbstractFeatureCallImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XAbstractFeatureCallImpl#getTypeArguments <em>Type Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XAbstractFeatureCallImpl#getImplicitReceiver <em>Implicit Receiver</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XAbstractFeatureCallImpl#isTargetsMemberSyntaxCall <em>Targets Member Syntax Call</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XAbstractFeatureCallImpl#getInvalidFeatureIssueCode <em>Invalid Feature Issue Code</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XAbstractFeatureCallImpl#isValidFeature <em>Valid Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class XAbstractFeatureCallImpl extends XExpressionImpl implements XAbstractFeatureCall
{
	/**
	 * The default value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected String featureName = FEATURE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<XExpression> arguments;

	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected JvmIdentifyableElement feature;

	/**
	 * The cached value of the '{@link #getTypeArguments() <em>Type Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeReference> typeArguments;

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
	 * The default value of the '{@link #isTargetsMemberSyntaxCall() <em>Targets Member Syntax Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTargetsMemberSyntaxCall()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TARGETS_MEMBER_SYNTAX_CALL_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isTargetsMemberSyntaxCall() <em>Targets Member Syntax Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTargetsMemberSyntaxCall()
	 * @generated
	 * @ordered
	 */
	protected boolean targetsMemberSyntaxCall = TARGETS_MEMBER_SYNTAX_CALL_EDEFAULT;

	/**
	 * The default value of the '{@link #getInvalidFeatureIssueCode() <em>Invalid Feature Issue Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvalidFeatureIssueCode()
	 * @generated
	 * @ordered
	 */
	protected static final String INVALID_FEATURE_ISSUE_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInvalidFeatureIssueCode() <em>Invalid Feature Issue Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvalidFeatureIssueCode()
	 * @generated
	 * @ordered
	 */
	protected String invalidFeatureIssueCode = INVALID_FEATURE_ISSUE_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #isValidFeature() <em>Valid Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidFeature()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALID_FEATURE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValidFeature() <em>Valid Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidFeature()
	 * @generated
	 * @ordered
	 */
	protected boolean validFeature = VALID_FEATURE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XAbstractFeatureCallImpl()
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
		return XbasePackage.Literals.XABSTRACT_FEATURE_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeatureName()
	{
		return featureName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XExpression> getArguments()
	{
		if (arguments == null)
		{
			arguments = new EObjectResolvingEList<XExpression>(XExpression.class, this, XbasePackage.XABSTRACT_FEATURE_CALL__ARGUMENTS);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmIdentifyableElement getFeature()
	{
		if (feature != null && feature.eIsProxy())
		{
			InternalEObject oldFeature = (InternalEObject)feature;
			feature = (JvmIdentifyableElement)eResolveProxy(oldFeature);
			if (feature != oldFeature)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE, oldFeature, feature));
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmIdentifyableElement basicGetFeature()
	{
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(JvmIdentifyableElement newFeature)
	{
		JvmIdentifyableElement oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE, oldFeature, feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmTypeReference> getTypeArguments()
	{
		if (typeArguments == null)
		{
			typeArguments = new EObjectContainmentEList<JvmTypeReference>(JvmTypeReference.class, this, XbasePackage.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS);
		}
		return typeArguments;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER, oldImplicitReceiver, implicitReceiver));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER, oldImplicitReceiver, implicitReceiver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTargetsMemberSyntaxCall()
	{
		return targetsMemberSyntaxCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetsMemberSyntaxCall(boolean newTargetsMemberSyntaxCall)
	{
		boolean oldTargetsMemberSyntaxCall = targetsMemberSyntaxCall;
		targetsMemberSyntaxCall = newTargetsMemberSyntaxCall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XABSTRACT_FEATURE_CALL__TARGETS_MEMBER_SYNTAX_CALL, oldTargetsMemberSyntaxCall, targetsMemberSyntaxCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInvalidFeatureIssueCode()
	{
		return invalidFeatureIssueCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvalidFeatureIssueCode(String newInvalidFeatureIssueCode)
	{
		String oldInvalidFeatureIssueCode = invalidFeatureIssueCode;
		invalidFeatureIssueCode = newInvalidFeatureIssueCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE, oldInvalidFeatureIssueCode, invalidFeatureIssueCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValidFeature()
	{
		return validFeature;
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
			case XbasePackage.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS:
				return ((InternalEList<?>)getTypeArguments()).basicRemove(otherEnd, msgs);
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
			case XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE_NAME:
				return getFeatureName();
			case XbasePackage.XABSTRACT_FEATURE_CALL__ARGUMENTS:
				return getArguments();
			case XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
			case XbasePackage.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS:
				return getTypeArguments();
			case XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER:
				if (resolve) return getImplicitReceiver();
				return basicGetImplicitReceiver();
			case XbasePackage.XABSTRACT_FEATURE_CALL__TARGETS_MEMBER_SYNTAX_CALL:
				return isTargetsMemberSyntaxCall();
			case XbasePackage.XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE:
				return getInvalidFeatureIssueCode();
			case XbasePackage.XABSTRACT_FEATURE_CALL__VALID_FEATURE:
				return isValidFeature();
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
			case XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE:
				setFeature((JvmIdentifyableElement)newValue);
				return;
			case XbasePackage.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS:
				getTypeArguments().clear();
				getTypeArguments().addAll((Collection<? extends JvmTypeReference>)newValue);
				return;
			case XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER:
				setImplicitReceiver((JvmIdentifyableElement)newValue);
				return;
			case XbasePackage.XABSTRACT_FEATURE_CALL__TARGETS_MEMBER_SYNTAX_CALL:
				setTargetsMemberSyntaxCall((Boolean)newValue);
				return;
			case XbasePackage.XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE:
				setInvalidFeatureIssueCode((String)newValue);
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
			case XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE:
				setFeature((JvmIdentifyableElement)null);
				return;
			case XbasePackage.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS:
				getTypeArguments().clear();
				return;
			case XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER:
				setImplicitReceiver((JvmIdentifyableElement)null);
				return;
			case XbasePackage.XABSTRACT_FEATURE_CALL__TARGETS_MEMBER_SYNTAX_CALL:
				setTargetsMemberSyntaxCall(TARGETS_MEMBER_SYNTAX_CALL_EDEFAULT);
				return;
			case XbasePackage.XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE:
				setInvalidFeatureIssueCode(INVALID_FEATURE_ISSUE_CODE_EDEFAULT);
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
			case XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE_NAME:
				return FEATURE_NAME_EDEFAULT == null ? featureName != null : !FEATURE_NAME_EDEFAULT.equals(featureName);
			case XbasePackage.XABSTRACT_FEATURE_CALL__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
			case XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE:
				return feature != null;
			case XbasePackage.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS:
				return typeArguments != null && !typeArguments.isEmpty();
			case XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER:
				return implicitReceiver != null;
			case XbasePackage.XABSTRACT_FEATURE_CALL__TARGETS_MEMBER_SYNTAX_CALL:
				return targetsMemberSyntaxCall != TARGETS_MEMBER_SYNTAX_CALL_EDEFAULT;
			case XbasePackage.XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE:
				return INVALID_FEATURE_ISSUE_CODE_EDEFAULT == null ? invalidFeatureIssueCode != null : !INVALID_FEATURE_ISSUE_CODE_EDEFAULT.equals(invalidFeatureIssueCode);
			case XbasePackage.XABSTRACT_FEATURE_CALL__VALID_FEATURE:
				return validFeature != VALID_FEATURE_EDEFAULT;
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
		result.append(" (featureName: ");
		result.append(featureName);
		result.append(", targetsMemberSyntaxCall: ");
		result.append(targetsMemberSyntaxCall);
		result.append(", invalidFeatureIssueCode: ");
		result.append(invalidFeatureIssueCode);
		result.append(", validFeature: ");
		result.append(validFeature);
		result.append(')');
		return result.toString();
	}

} //XAbstractFeatureCallImpl
