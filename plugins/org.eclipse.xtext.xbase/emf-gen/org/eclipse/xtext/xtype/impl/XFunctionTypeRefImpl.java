/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtype.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XTypeRef;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XFunction Type Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl#getParamTypes <em>Param Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl#getReturnType <em>Return Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XFunctionTypeRefImpl extends XTypeRefImpl implements XFunctionTypeRef
{
  /**
   * The cached value of the '{@link #getParamTypes() <em>Param Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParamTypes()
   * @generated
   * @ordered
   */
  protected EList<XTypeRef> paramTypes;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XFunctionTypeRefImpl()
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
    return XtypePackage.Literals.XFUNCTION_TYPE_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XTypeRef> getParamTypes()
  {
    if (paramTypes == null)
    {
      paramTypes = new EObjectContainmentEList<XTypeRef>(XTypeRef.class, this, XtypePackage.XFUNCTION_TYPE_REF__PARAM_TYPES);
    }
    return paramTypes;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE, oldReturnType, newReturnType);
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
        msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE, null, msgs);
      if (newReturnType != null)
        msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE, null, msgs);
      msgs = basicSetReturnType(newReturnType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE, newReturnType, newReturnType));
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
      case XtypePackage.XFUNCTION_TYPE_REF__PARAM_TYPES:
        return ((InternalEList<?>)getParamTypes()).basicRemove(otherEnd, msgs);
      case XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE:
        return basicSetReturnType(null, msgs);
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
      case XtypePackage.XFUNCTION_TYPE_REF__PARAM_TYPES:
        return getParamTypes();
      case XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE:
        return getReturnType();
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
      case XtypePackage.XFUNCTION_TYPE_REF__PARAM_TYPES:
        getParamTypes().clear();
        getParamTypes().addAll((Collection<? extends XTypeRef>)newValue);
        return;
      case XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE:
        setReturnType((XTypeRef)newValue);
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
      case XtypePackage.XFUNCTION_TYPE_REF__PARAM_TYPES:
        getParamTypes().clear();
        return;
      case XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE:
        setReturnType((XTypeRef)null);
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
      case XtypePackage.XFUNCTION_TYPE_REF__PARAM_TYPES:
        return paramTypes != null && !paramTypes.isEmpty();
      case XtypePackage.XFUNCTION_TYPE_REF__RETURN_TYPE:
        return returnType != null;
    }
    return super.eIsSet(featureID);
  }

} //XFunctionTypeRefImpl
