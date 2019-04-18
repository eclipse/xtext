/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XTry Catch Finally Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XTryCatchFinallyExpressionImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XTryCatchFinallyExpressionImpl#getFinallyExpression <em>Finally Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XTryCatchFinallyExpressionImpl#getCatchClauses <em>Catch Clauses</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XTryCatchFinallyExpressionImpl#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XTryCatchFinallyExpressionImpl extends XExpressionImpl implements XTryCatchFinallyExpression
{
	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression expression;

	/**
	 * The cached value of the '{@link #getFinallyExpression() <em>Finally Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinallyExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression finallyExpression;

	/**
	 * The cached value of the '{@link #getCatchClauses() <em>Catch Clauses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatchClauses()
	 * @generated
	 * @ordered
	 */
	protected EList<XCatchClause> catchClauses;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<XVariableDeclaration> resources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XTryCatchFinallyExpressionImpl()
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
		return XbasePackage.Literals.XTRY_CATCH_FINALLY_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getExpression()
	{
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(XExpression newExpression, NotificationChain msgs)
	{
		XExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(XExpression newExpression)
	{
		if (newExpression != expression)
		{
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getFinallyExpression()
	{
		return finallyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFinallyExpression(XExpression newFinallyExpression, NotificationChain msgs)
	{
		XExpression oldFinallyExpression = finallyExpression;
		finallyExpression = newFinallyExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION, oldFinallyExpression, newFinallyExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinallyExpression(XExpression newFinallyExpression)
	{
		if (newFinallyExpression != finallyExpression)
		{
			NotificationChain msgs = null;
			if (finallyExpression != null)
				msgs = ((InternalEObject)finallyExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION, null, msgs);
			if (newFinallyExpression != null)
				msgs = ((InternalEObject)newFinallyExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION, null, msgs);
			msgs = basicSetFinallyExpression(newFinallyExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION, newFinallyExpression, newFinallyExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XCatchClause> getCatchClauses()
	{
		if (catchClauses == null)
		{
			catchClauses = new EObjectContainmentEList<XCatchClause>(XCatchClause.class, this, XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSES);
		}
		return catchClauses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XVariableDeclaration> getResources()
	{
		if (resources == null)
		{
			resources = new EObjectContainmentEList<XVariableDeclaration>(XVariableDeclaration.class, this, XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__RESOURCES);
		}
		return resources;
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
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION:
				return basicSetExpression(null, msgs);
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION:
				return basicSetFinallyExpression(null, msgs);
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSES:
				return ((InternalEList<?>)getCatchClauses()).basicRemove(otherEnd, msgs);
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
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
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION:
				return getExpression();
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION:
				return getFinallyExpression();
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSES:
				return getCatchClauses();
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__RESOURCES:
				return getResources();
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
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION:
				setExpression((XExpression)newValue);
				return;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION:
				setFinallyExpression((XExpression)newValue);
				return;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSES:
				getCatchClauses().clear();
				getCatchClauses().addAll((Collection<? extends XCatchClause>)newValue);
				return;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends XVariableDeclaration>)newValue);
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
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION:
				setExpression((XExpression)null);
				return;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION:
				setFinallyExpression((XExpression)null);
				return;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSES:
				getCatchClauses().clear();
				return;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__RESOURCES:
				getResources().clear();
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
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION:
				return expression != null;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION:
				return finallyExpression != null;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSES:
				return catchClauses != null && !catchClauses.isEmpty();
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__RESOURCES:
				return resources != null && !resources.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //XTryCatchFinallyExpressionImpl
