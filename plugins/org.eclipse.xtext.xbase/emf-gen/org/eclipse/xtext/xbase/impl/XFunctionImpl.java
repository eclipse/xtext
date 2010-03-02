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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.XFunction;
import org.eclipse.xtext.xbase.XbasePackage;

import org.eclipse.xtext.xpression.XDeclaredParameter;
import org.eclipse.xtext.xpression.XExpression;

import org.eclipse.xtext.xtype.XTypeParamDeclaration;
import org.eclipse.xtext.xtype.XTypeRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XFunction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XFunctionImpl#isPrivate <em>Private</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XFunctionImpl#getTypeParams <em>Type Params</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XFunctionImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XFunctionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XFunctionImpl#getDeclaredParams <em>Declared Params</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.impl.XFunctionImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XFunctionImpl extends MinimalEObjectImpl.Container implements XFunction
{
  /**
   * The default value of the '{@link #isPrivate() <em>Private</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPrivate()
   * @generated
   * @ordered
   */
  protected static final boolean PRIVATE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPrivate() <em>Private</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPrivate()
   * @generated
   * @ordered
   */
  protected boolean private_ = PRIVATE_EDEFAULT;

  /**
   * The cached value of the '{@link #getTypeParams() <em>Type Params</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeParams()
   * @generated
   * @ordered
   */
  protected EList<XTypeParamDeclaration> typeParams;

  /**
   * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnType()
   * @generated
   * @ordered
   */
  protected XTypeRef returnType;

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
   * The cached value of the '{@link #getDeclaredParams() <em>Declared Params</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeclaredParams()
   * @generated
   * @ordered
   */
  protected EList<XDeclaredParameter> declaredParams;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XFunctionImpl()
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
    return XbasePackage.Literals.XFUNCTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPrivate()
  {
    return private_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrivate(boolean newPrivate)
  {
    boolean oldPrivate = private_;
    private_ = newPrivate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFUNCTION__PRIVATE, oldPrivate, private_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XTypeParamDeclaration> getTypeParams()
  {
    if (typeParams == null)
    {
      typeParams = new EObjectContainmentEList<XTypeParamDeclaration>(XTypeParamDeclaration.class, this, XbasePackage.XFUNCTION__TYPE_PARAMS);
    }
    return typeParams;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XTypeRef getReturnType()
  {
    return returnType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReturnType(XTypeRef newReturnType, NotificationChain msgs)
  {
    XTypeRef oldReturnType = returnType;
    returnType = newReturnType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFUNCTION__RETURN_TYPE, oldReturnType, newReturnType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReturnType(XTypeRef newReturnType)
  {
    if (newReturnType != returnType)
    {
      NotificationChain msgs = null;
      if (returnType != null)
        msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFUNCTION__RETURN_TYPE, null, msgs);
      if (newReturnType != null)
        msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFUNCTION__RETURN_TYPE, null, msgs);
      msgs = basicSetReturnType(newReturnType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFUNCTION__RETURN_TYPE, newReturnType, newReturnType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFUNCTION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XDeclaredParameter> getDeclaredParams()
  {
    if (declaredParams == null)
    {
      declaredParams = new EObjectContainmentEList<XDeclaredParameter>(XDeclaredParameter.class, this, XbasePackage.XFUNCTION__DECLARED_PARAMS);
    }
    return declaredParams;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFUNCTION__EXPRESSION, oldExpression, newExpression);
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
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFUNCTION__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFUNCTION__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFUNCTION__EXPRESSION, newExpression, newExpression));
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
      case XbasePackage.XFUNCTION__TYPE_PARAMS:
        return ((InternalEList<?>)getTypeParams()).basicRemove(otherEnd, msgs);
      case XbasePackage.XFUNCTION__RETURN_TYPE:
        return basicSetReturnType(null, msgs);
      case XbasePackage.XFUNCTION__DECLARED_PARAMS:
        return ((InternalEList<?>)getDeclaredParams()).basicRemove(otherEnd, msgs);
      case XbasePackage.XFUNCTION__EXPRESSION:
        return basicSetExpression(null, msgs);
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
      case XbasePackage.XFUNCTION__PRIVATE:
        return isPrivate();
      case XbasePackage.XFUNCTION__TYPE_PARAMS:
        return getTypeParams();
      case XbasePackage.XFUNCTION__RETURN_TYPE:
        return getReturnType();
      case XbasePackage.XFUNCTION__NAME:
        return getName();
      case XbasePackage.XFUNCTION__DECLARED_PARAMS:
        return getDeclaredParams();
      case XbasePackage.XFUNCTION__EXPRESSION:
        return getExpression();
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
      case XbasePackage.XFUNCTION__PRIVATE:
        setPrivate((Boolean)newValue);
        return;
      case XbasePackage.XFUNCTION__TYPE_PARAMS:
        getTypeParams().clear();
        getTypeParams().addAll((Collection<? extends XTypeParamDeclaration>)newValue);
        return;
      case XbasePackage.XFUNCTION__RETURN_TYPE:
        setReturnType((XTypeRef)newValue);
        return;
      case XbasePackage.XFUNCTION__NAME:
        setName((String)newValue);
        return;
      case XbasePackage.XFUNCTION__DECLARED_PARAMS:
        getDeclaredParams().clear();
        getDeclaredParams().addAll((Collection<? extends XDeclaredParameter>)newValue);
        return;
      case XbasePackage.XFUNCTION__EXPRESSION:
        setExpression((XExpression)newValue);
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
      case XbasePackage.XFUNCTION__PRIVATE:
        setPrivate(PRIVATE_EDEFAULT);
        return;
      case XbasePackage.XFUNCTION__TYPE_PARAMS:
        getTypeParams().clear();
        return;
      case XbasePackage.XFUNCTION__RETURN_TYPE:
        setReturnType((XTypeRef)null);
        return;
      case XbasePackage.XFUNCTION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case XbasePackage.XFUNCTION__DECLARED_PARAMS:
        getDeclaredParams().clear();
        return;
      case XbasePackage.XFUNCTION__EXPRESSION:
        setExpression((XExpression)null);
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
      case XbasePackage.XFUNCTION__PRIVATE:
        return private_ != PRIVATE_EDEFAULT;
      case XbasePackage.XFUNCTION__TYPE_PARAMS:
        return typeParams != null && !typeParams.isEmpty();
      case XbasePackage.XFUNCTION__RETURN_TYPE:
        return returnType != null;
      case XbasePackage.XFUNCTION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case XbasePackage.XFUNCTION__DECLARED_PARAMS:
        return declaredParams != null && !declaredParams.isEmpty();
      case XbasePackage.XFUNCTION__EXPRESSION:
        return expression != null;
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
    result.append(" (private: ");
    result.append(private_);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //XFunctionImpl
