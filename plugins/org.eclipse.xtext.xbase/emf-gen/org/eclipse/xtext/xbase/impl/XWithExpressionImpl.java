/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xbase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.common.types.JvmFormalParameter;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XWithExpression;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XWith Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XWithExpressionImpl#getMainExpression <em>Main Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XWithExpressionImpl#getBlockExpression <em>Block Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XWithExpressionImpl#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XWithExpressionImpl extends XExpressionImpl implements XWithExpression
{
	/**
	 * The cached value of the '{@link #getMainExpression() <em>Main Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression mainExpression;

	/**
	 * The cached value of the '{@link #getBlockExpression() <em>Block Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression blockExpression;

	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected JvmFormalParameter variable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XWithExpressionImpl()
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
		return XbasePackage.Literals.XWITH_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getMainExpression()
	{
		return mainExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMainExpression(XExpression newMainExpression, NotificationChain msgs)
	{
		XExpression oldMainExpression = mainExpression;
		mainExpression = newMainExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XWITH_EXPRESSION__MAIN_EXPRESSION, oldMainExpression, newMainExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainExpression(XExpression newMainExpression)
	{
		if (newMainExpression != mainExpression)
		{
			NotificationChain msgs = null;
			if (mainExpression != null)
				msgs = ((InternalEObject)mainExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XWITH_EXPRESSION__MAIN_EXPRESSION, null, msgs);
			if (newMainExpression != null)
				msgs = ((InternalEObject)newMainExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XWITH_EXPRESSION__MAIN_EXPRESSION, null, msgs);
			msgs = basicSetMainExpression(newMainExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XWITH_EXPRESSION__MAIN_EXPRESSION, newMainExpression, newMainExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getBlockExpression()
	{
		return blockExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBlockExpression(XExpression newBlockExpression, NotificationChain msgs)
	{
		XExpression oldBlockExpression = blockExpression;
		blockExpression = newBlockExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XWITH_EXPRESSION__BLOCK_EXPRESSION, oldBlockExpression, newBlockExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlockExpression(XExpression newBlockExpression)
	{
		if (newBlockExpression != blockExpression)
		{
			NotificationChain msgs = null;
			if (blockExpression != null)
				msgs = ((InternalEObject)blockExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XWITH_EXPRESSION__BLOCK_EXPRESSION, null, msgs);
			if (newBlockExpression != null)
				msgs = ((InternalEObject)newBlockExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XWITH_EXPRESSION__BLOCK_EXPRESSION, null, msgs);
			msgs = basicSetBlockExpression(newBlockExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XWITH_EXPRESSION__BLOCK_EXPRESSION, newBlockExpression, newBlockExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmFormalParameter getVariable()
	{
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariable(JvmFormalParameter newVariable, NotificationChain msgs)
	{
		JvmFormalParameter oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XWITH_EXPRESSION__VARIABLE, oldVariable, newVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(JvmFormalParameter newVariable)
	{
		if (newVariable != variable)
		{
			NotificationChain msgs = null;
			if (variable != null)
				msgs = ((InternalEObject)variable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XWITH_EXPRESSION__VARIABLE, null, msgs);
			if (newVariable != null)
				msgs = ((InternalEObject)newVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XWITH_EXPRESSION__VARIABLE, null, msgs);
			msgs = basicSetVariable(newVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XWITH_EXPRESSION__VARIABLE, newVariable, newVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier()
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
	public String getQualifiedName()
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
	public String getQualifiedName(char innerClassDelimiter)
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case XbasePackage.XWITH_EXPRESSION__MAIN_EXPRESSION:
				return basicSetMainExpression(null, msgs);
			case XbasePackage.XWITH_EXPRESSION__BLOCK_EXPRESSION:
				return basicSetBlockExpression(null, msgs);
			case XbasePackage.XWITH_EXPRESSION__VARIABLE:
				return basicSetVariable(null, msgs);
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
			case XbasePackage.XWITH_EXPRESSION__MAIN_EXPRESSION:
				return getMainExpression();
			case XbasePackage.XWITH_EXPRESSION__BLOCK_EXPRESSION:
				return getBlockExpression();
			case XbasePackage.XWITH_EXPRESSION__VARIABLE:
				return getVariable();
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
			case XbasePackage.XWITH_EXPRESSION__MAIN_EXPRESSION:
				setMainExpression((XExpression)newValue);
				return;
			case XbasePackage.XWITH_EXPRESSION__BLOCK_EXPRESSION:
				setBlockExpression((XExpression)newValue);
				return;
			case XbasePackage.XWITH_EXPRESSION__VARIABLE:
				setVariable((JvmFormalParameter)newValue);
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
			case XbasePackage.XWITH_EXPRESSION__MAIN_EXPRESSION:
				setMainExpression((XExpression)null);
				return;
			case XbasePackage.XWITH_EXPRESSION__BLOCK_EXPRESSION:
				setBlockExpression((XExpression)null);
				return;
			case XbasePackage.XWITH_EXPRESSION__VARIABLE:
				setVariable((JvmFormalParameter)null);
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
			case XbasePackage.XWITH_EXPRESSION__MAIN_EXPRESSION:
				return mainExpression != null;
			case XbasePackage.XWITH_EXPRESSION__BLOCK_EXPRESSION:
				return blockExpression != null;
			case XbasePackage.XWITH_EXPRESSION__VARIABLE:
				return variable != null;
		}
		return super.eIsSet(featureID);
	}

} //XWithExpressionImpl
