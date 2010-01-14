/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConstructorCallImpl.java,v 1.1 2010/01/14 14:40:18 sefftinge Exp $
 */
package org.eclipse.xtext.xpression.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xpression.BlockExpression;
import org.eclipse.xtext.xpression.ConstructorCall;
import org.eclipse.xtext.xpression.Expression;
import org.eclipse.xtext.xpression.XpressionPackage;

import org.eclipse.xtext.xtype.TypeRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constructor Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xpression.impl.ConstructorCallImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.impl.ConstructorCallImpl#getParams <em>Params</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.impl.ConstructorCallImpl#getInitializer <em>Initializer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstructorCallImpl extends ExpressionImpl implements ConstructorCall {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TypeRef type;

	/**
	 * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParams()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> params;

	/**
	 * The cached value of the '{@link #getInitializer() <em>Initializer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializer()
	 * @generated
	 * @ordered
	 */
	protected BlockExpression initializer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstructorCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XpressionPackage.Literals.CONSTRUCTOR_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeRef getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(TypeRef newType, NotificationChain msgs) {
		TypeRef oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XpressionPackage.CONSTRUCTOR_CALL__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TypeRef newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XpressionPackage.CONSTRUCTOR_CALL__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XpressionPackage.CONSTRUCTOR_CALL__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XpressionPackage.CONSTRUCTOR_CALL__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getParams() {
		if (params == null) {
			params = new EObjectContainmentEList<Expression>(Expression.class, this, XpressionPackage.CONSTRUCTOR_CALL__PARAMS);
		}
		return params;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockExpression getInitializer() {
		return initializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitializer(BlockExpression newInitializer, NotificationChain msgs) {
		BlockExpression oldInitializer = initializer;
		initializer = newInitializer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XpressionPackage.CONSTRUCTOR_CALL__INITIALIZER, oldInitializer, newInitializer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializer(BlockExpression newInitializer) {
		if (newInitializer != initializer) {
			NotificationChain msgs = null;
			if (initializer != null)
				msgs = ((InternalEObject)initializer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XpressionPackage.CONSTRUCTOR_CALL__INITIALIZER, null, msgs);
			if (newInitializer != null)
				msgs = ((InternalEObject)newInitializer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XpressionPackage.CONSTRUCTOR_CALL__INITIALIZER, null, msgs);
			msgs = basicSetInitializer(newInitializer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XpressionPackage.CONSTRUCTOR_CALL__INITIALIZER, newInitializer, newInitializer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XpressionPackage.CONSTRUCTOR_CALL__TYPE:
				return basicSetType(null, msgs);
			case XpressionPackage.CONSTRUCTOR_CALL__PARAMS:
				return ((InternalEList<?>)getParams()).basicRemove(otherEnd, msgs);
			case XpressionPackage.CONSTRUCTOR_CALL__INITIALIZER:
				return basicSetInitializer(null, msgs);
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
			case XpressionPackage.CONSTRUCTOR_CALL__TYPE:
				return getType();
			case XpressionPackage.CONSTRUCTOR_CALL__PARAMS:
				return getParams();
			case XpressionPackage.CONSTRUCTOR_CALL__INITIALIZER:
				return getInitializer();
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
			case XpressionPackage.CONSTRUCTOR_CALL__TYPE:
				setType((TypeRef)newValue);
				return;
			case XpressionPackage.CONSTRUCTOR_CALL__PARAMS:
				getParams().clear();
				getParams().addAll((Collection<? extends Expression>)newValue);
				return;
			case XpressionPackage.CONSTRUCTOR_CALL__INITIALIZER:
				setInitializer((BlockExpression)newValue);
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
			case XpressionPackage.CONSTRUCTOR_CALL__TYPE:
				setType((TypeRef)null);
				return;
			case XpressionPackage.CONSTRUCTOR_CALL__PARAMS:
				getParams().clear();
				return;
			case XpressionPackage.CONSTRUCTOR_CALL__INITIALIZER:
				setInitializer((BlockExpression)null);
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
			case XpressionPackage.CONSTRUCTOR_CALL__TYPE:
				return type != null;
			case XpressionPackage.CONSTRUCTOR_CALL__PARAMS:
				return params != null && !params.isEmpty();
			case XpressionPackage.CONSTRUCTOR_CALL__INITIALIZER:
				return initializer != null;
		}
		return super.eIsSet(featureID);
	}

} //ConstructorCallImpl
