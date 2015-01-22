/**
 */
package org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefObj;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.SingleRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.SingleRefImpl#getObj <em>Obj</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.SingleRefImpl#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SingleRefImpl extends ModelImpl implements SingleRef
{
  /**
   * The cached value of the '{@link #getObj() <em>Obj</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObj()
   * @generated
   * @ordered
   */
  protected RefObj obj;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected RefObj ref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SingleRefImpl()
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
    return HiddentokenmergertestPackage.Literals.SINGLE_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefObj getObj()
  {
    return obj;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetObj(RefObj newObj, NotificationChain msgs)
  {
    RefObj oldObj = obj;
    obj = newObj;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HiddentokenmergertestPackage.SINGLE_REF__OBJ, oldObj, newObj);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObj(RefObj newObj)
  {
    if (newObj != obj)
    {
      NotificationChain msgs = null;
      if (obj != null)
        msgs = ((InternalEObject)obj).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HiddentokenmergertestPackage.SINGLE_REF__OBJ, null, msgs);
      if (newObj != null)
        msgs = ((InternalEObject)newObj).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HiddentokenmergertestPackage.SINGLE_REF__OBJ, null, msgs);
      msgs = basicSetObj(newObj, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HiddentokenmergertestPackage.SINGLE_REF__OBJ, newObj, newObj));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefObj getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (RefObj)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, HiddentokenmergertestPackage.SINGLE_REF__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefObj basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(RefObj newRef)
  {
    RefObj oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HiddentokenmergertestPackage.SINGLE_REF__REF, oldRef, ref));
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
      case HiddentokenmergertestPackage.SINGLE_REF__OBJ:
        return basicSetObj(null, msgs);
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
      case HiddentokenmergertestPackage.SINGLE_REF__OBJ:
        return getObj();
      case HiddentokenmergertestPackage.SINGLE_REF__REF:
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
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case HiddentokenmergertestPackage.SINGLE_REF__OBJ:
        setObj((RefObj)newValue);
        return;
      case HiddentokenmergertestPackage.SINGLE_REF__REF:
        setRef((RefObj)newValue);
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
      case HiddentokenmergertestPackage.SINGLE_REF__OBJ:
        setObj((RefObj)null);
        return;
      case HiddentokenmergertestPackage.SINGLE_REF__REF:
        setRef((RefObj)null);
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
      case HiddentokenmergertestPackage.SINGLE_REF__OBJ:
        return obj != null;
      case HiddentokenmergertestPackage.SINGLE_REF__REF:
        return ref != null;
    }
    return super.eIsSet(featureID);
  }

} //SingleRefImpl
