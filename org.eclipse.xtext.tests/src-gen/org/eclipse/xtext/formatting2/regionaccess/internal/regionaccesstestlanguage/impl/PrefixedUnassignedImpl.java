/**
 */
package org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedDelegate;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedUnassigned;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Prefixed Unassigned</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.PrefixedUnassignedImpl#getDelegate <em>Delegate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrefixedUnassignedImpl extends RootImpl implements PrefixedUnassigned
{
  /**
   * The cached value of the '{@link #getDelegate() <em>Delegate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDelegate()
   * @generated
   * @ordered
   */
  protected PrefixedDelegate delegate;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrefixedUnassignedImpl()
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
    return RegionaccesstestlanguagePackage.Literals.PREFIXED_UNASSIGNED;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrefixedDelegate getDelegate()
  {
    return delegate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDelegate(PrefixedDelegate newDelegate, NotificationChain msgs)
  {
    PrefixedDelegate oldDelegate = delegate;
    delegate = newDelegate;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegionaccesstestlanguagePackage.PREFIXED_UNASSIGNED__DELEGATE, oldDelegate, newDelegate);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDelegate(PrefixedDelegate newDelegate)
  {
    if (newDelegate != delegate)
    {
      NotificationChain msgs = null;
      if (delegate != null)
        msgs = ((InternalEObject)delegate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegionaccesstestlanguagePackage.PREFIXED_UNASSIGNED__DELEGATE, null, msgs);
      if (newDelegate != null)
        msgs = ((InternalEObject)newDelegate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegionaccesstestlanguagePackage.PREFIXED_UNASSIGNED__DELEGATE, null, msgs);
      msgs = basicSetDelegate(newDelegate, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RegionaccesstestlanguagePackage.PREFIXED_UNASSIGNED__DELEGATE, newDelegate, newDelegate));
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
      case RegionaccesstestlanguagePackage.PREFIXED_UNASSIGNED__DELEGATE:
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
      case RegionaccesstestlanguagePackage.PREFIXED_UNASSIGNED__DELEGATE:
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
      case RegionaccesstestlanguagePackage.PREFIXED_UNASSIGNED__DELEGATE:
        setDelegate((PrefixedDelegate)newValue);
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
      case RegionaccesstestlanguagePackage.PREFIXED_UNASSIGNED__DELEGATE:
        setDelegate((PrefixedDelegate)null);
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
      case RegionaccesstestlanguagePackage.PREFIXED_UNASSIGNED__DELEGATE:
        return delegate != null;
    }
    return super.eIsSet(featureID);
  }

} //PrefixedUnassignedImpl
