/**
 */
package org.eclipse.xtext.valueconverter.bug250313.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.valueconverter.bug250313.Bug250313Package;
import org.eclipse.xtext.valueconverter.bug250313.Child;
import org.eclipse.xtext.valueconverter.bug250313.Model;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.valueconverter.bug250313.impl.ModelImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.valueconverter.bug250313.impl.ModelImpl#getMultiValue <em>Multi Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.valueconverter.bug250313.impl.ModelImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.xtext.valueconverter.bug250313.impl.ModelImpl#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getMultiValue() <em>Multi Value</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiValue()
   * @generated
   * @ordered
   */
  protected EList<String> multiValue;

  /**
   * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChildren()
   * @generated
   * @ordered
   */
  protected Child children;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected Child ref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return Bug250313Package.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(String newValue)
  {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug250313Package.MODEL__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getMultiValue()
  {
    if (multiValue == null)
    {
      multiValue = new EDataTypeEList<String>(String.class, this, Bug250313Package.MODEL__MULTI_VALUE);
    }
    return multiValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Child getChildren()
  {
    return children;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChildren(Child newChildren, NotificationChain msgs)
  {
    Child oldChildren = children;
    children = newChildren;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug250313Package.MODEL__CHILDREN, oldChildren, newChildren);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChildren(Child newChildren)
  {
    if (newChildren != children)
    {
      NotificationChain msgs = null;
      if (children != null)
        msgs = ((InternalEObject)children).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug250313Package.MODEL__CHILDREN, null, msgs);
      if (newChildren != null)
        msgs = ((InternalEObject)newChildren).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug250313Package.MODEL__CHILDREN, null, msgs);
      msgs = basicSetChildren(newChildren, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug250313Package.MODEL__CHILDREN, newChildren, newChildren));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Child getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (Child)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bug250313Package.MODEL__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Child basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(Child newRef)
  {
    Child oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug250313Package.MODEL__REF, oldRef, ref));
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
      case Bug250313Package.MODEL__CHILDREN:
        return basicSetChildren(null, msgs);
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
      case Bug250313Package.MODEL__VALUE:
        return getValue();
      case Bug250313Package.MODEL__MULTI_VALUE:
        return getMultiValue();
      case Bug250313Package.MODEL__CHILDREN:
        return getChildren();
      case Bug250313Package.MODEL__REF:
        if (resolve) return getRef();
        return basicGetRef();
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
      case Bug250313Package.MODEL__VALUE:
        setValue((String)newValue);
        return;
      case Bug250313Package.MODEL__MULTI_VALUE:
        getMultiValue().clear();
        getMultiValue().addAll((Collection<? extends String>)newValue);
        return;
      case Bug250313Package.MODEL__CHILDREN:
        setChildren((Child)newValue);
        return;
      case Bug250313Package.MODEL__REF:
        setRef((Child)newValue);
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
      case Bug250313Package.MODEL__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case Bug250313Package.MODEL__MULTI_VALUE:
        getMultiValue().clear();
        return;
      case Bug250313Package.MODEL__CHILDREN:
        setChildren((Child)null);
        return;
      case Bug250313Package.MODEL__REF:
        setRef((Child)null);
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
      case Bug250313Package.MODEL__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
      case Bug250313Package.MODEL__MULTI_VALUE:
        return multiValue != null && !multiValue.isEmpty();
      case Bug250313Package.MODEL__CHILDREN:
        return children != null;
      case Bug250313Package.MODEL__REF:
        return ref != null;
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
    result.append(" (value: ");
    result.append(value);
    result.append(", multiValue: ");
    result.append(multiValue);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
