/**
 * <copyright>
 * </copyright>
 *
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

import org.eclipse.xtext.xpression.XBlockExpression;
import org.eclipse.xtext.xpression.XConstructorCall;
import org.eclipse.xtext.xpression.XExpression;
import org.eclipse.xtext.xpression.XpressionPackage;

import org.eclipse.xtext.xtype.XTypeRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XConstructor Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xpression.impl.XConstructorCallImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.impl.XConstructorCallImpl#getParams <em>Params</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.impl.XConstructorCallImpl#getInitializer <em>Initializer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XConstructorCallImpl extends XExpressionImpl implements XConstructorCall
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected XTypeRef type;

  /**
   * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParams()
   * @generated
   * @ordered
   */
  protected EList<XExpression> params;

  /**
   * The cached value of the '{@link #getInitializer() <em>Initializer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitializer()
   * @generated
   * @ordered
   */
  protected XBlockExpression initializer;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XConstructorCallImpl()
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
    return XpressionPackage.Literals.XCONSTRUCTOR_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XTypeRef getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(XTypeRef newType, NotificationChain msgs)
  {
    XTypeRef oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XpressionPackage.XCONSTRUCTOR_CALL__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(XTypeRef newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XpressionPackage.XCONSTRUCTOR_CALL__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XpressionPackage.XCONSTRUCTOR_CALL__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XpressionPackage.XCONSTRUCTOR_CALL__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XExpression> getParams()
  {
    if (params == null)
    {
      params = new EObjectContainmentEList<XExpression>(XExpression.class, this, XpressionPackage.XCONSTRUCTOR_CALL__PARAMS);
    }
    return params;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XBlockExpression getInitializer()
  {
    return initializer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitializer(XBlockExpression newInitializer, NotificationChain msgs)
  {
    XBlockExpression oldInitializer = initializer;
    initializer = newInitializer;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XpressionPackage.XCONSTRUCTOR_CALL__INITIALIZER, oldInitializer, newInitializer);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitializer(XBlockExpression newInitializer)
  {
    if (newInitializer != initializer)
    {
      NotificationChain msgs = null;
      if (initializer != null)
        msgs = ((InternalEObject)initializer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XpressionPackage.XCONSTRUCTOR_CALL__INITIALIZER, null, msgs);
      if (newInitializer != null)
        msgs = ((InternalEObject)newInitializer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XpressionPackage.XCONSTRUCTOR_CALL__INITIALIZER, null, msgs);
      msgs = basicSetInitializer(newInitializer, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XpressionPackage.XCONSTRUCTOR_CALL__INITIALIZER, newInitializer, newInitializer));
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
      case XpressionPackage.XCONSTRUCTOR_CALL__TYPE:
        return basicSetType(null, msgs);
      case XpressionPackage.XCONSTRUCTOR_CALL__PARAMS:
        return ((InternalEList<?>)getParams()).basicRemove(otherEnd, msgs);
      case XpressionPackage.XCONSTRUCTOR_CALL__INITIALIZER:
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
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case XpressionPackage.XCONSTRUCTOR_CALL__TYPE:
        return getType();
      case XpressionPackage.XCONSTRUCTOR_CALL__PARAMS:
        return getParams();
      case XpressionPackage.XCONSTRUCTOR_CALL__INITIALIZER:
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case XpressionPackage.XCONSTRUCTOR_CALL__TYPE:
        setType((XTypeRef)newValue);
        return;
      case XpressionPackage.XCONSTRUCTOR_CALL__PARAMS:
        getParams().clear();
        getParams().addAll((Collection<? extends XExpression>)newValue);
        return;
      case XpressionPackage.XCONSTRUCTOR_CALL__INITIALIZER:
        setInitializer((XBlockExpression)newValue);
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
      case XpressionPackage.XCONSTRUCTOR_CALL__TYPE:
        setType((XTypeRef)null);
        return;
      case XpressionPackage.XCONSTRUCTOR_CALL__PARAMS:
        getParams().clear();
        return;
      case XpressionPackage.XCONSTRUCTOR_CALL__INITIALIZER:
        setInitializer((XBlockExpression)null);
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
      case XpressionPackage.XCONSTRUCTOR_CALL__TYPE:
        return type != null;
      case XpressionPackage.XCONSTRUCTOR_CALL__PARAMS:
        return params != null && !params.isEmpty();
      case XpressionPackage.XCONSTRUCTOR_CALL__INITIALIZER:
        return initializer != null;
    }
    return super.eIsSet(featureID);
  }

} //XConstructorCallImpl
