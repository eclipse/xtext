/**
 */
package org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegate;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegation;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delegation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.DelegationImpl#getDelegate <em>Delegate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DelegationImpl extends RootImpl implements Delegation
{
  /**
   * The cached value of the '{@link #getDelegate() <em>Delegate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDelegate()
   * @generated
   * @ordered
   */
  protected Delegate delegate;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DelegationImpl()
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
    return RegionaccesstestlanguagePackage.Literals.DELEGATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Delegate getDelegate()
  {
    return delegate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDelegate(Delegate newDelegate, NotificationChain msgs)
  {
    Delegate oldDelegate = delegate;
    delegate = newDelegate;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegionaccesstestlanguagePackage.DELEGATION__DELEGATE, oldDelegate, newDelegate);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDelegate(Delegate newDelegate)
  {
    if (newDelegate != delegate)
    {
      NotificationChain msgs = null;
      if (delegate != null)
        msgs = ((InternalEObject)delegate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegionaccesstestlanguagePackage.DELEGATION__DELEGATE, null, msgs);
      if (newDelegate != null)
        msgs = ((InternalEObject)newDelegate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegionaccesstestlanguagePackage.DELEGATION__DELEGATE, null, msgs);
      msgs = basicSetDelegate(newDelegate, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RegionaccesstestlanguagePackage.DELEGATION__DELEGATE, newDelegate, newDelegate));
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
      case RegionaccesstestlanguagePackage.DELEGATION__DELEGATE:
        return basicSetDelegate(null, msgs);
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
      case RegionaccesstestlanguagePackage.DELEGATION__DELEGATE:
        return getDelegate();
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
      case RegionaccesstestlanguagePackage.DELEGATION__DELEGATE:
        setDelegate((Delegate)newValue);
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
      case RegionaccesstestlanguagePackage.DELEGATION__DELEGATE:
        setDelegate((Delegate)null);
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
      case RegionaccesstestlanguagePackage.DELEGATION__DELEGATE:
        return delegate != null;
    }
    return super.eIsSet(featureID);
  }

} //DelegationImpl
