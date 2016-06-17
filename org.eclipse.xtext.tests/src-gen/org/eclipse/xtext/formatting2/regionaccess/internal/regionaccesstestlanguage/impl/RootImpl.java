/**
 */
package org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RootImpl#getMixed <em>Mixed</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RootImpl extends MinimalEObjectImpl.Container implements Root
{
  /**
   * The cached value of the '{@link #getMixed() <em>Mixed</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMixed()
   * @generated
   * @ordered
   */
  protected Mixed mixed;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RootImpl()
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
    return RegionaccesstestlanguagePackage.Literals.ROOT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mixed getMixed()
  {
    return mixed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMixed(Mixed newMixed, NotificationChain msgs)
  {
    Mixed oldMixed = mixed;
    mixed = newMixed;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegionaccesstestlanguagePackage.ROOT__MIXED, oldMixed, newMixed);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMixed(Mixed newMixed)
  {
    if (newMixed != mixed)
    {
      NotificationChain msgs = null;
      if (mixed != null)
        msgs = ((InternalEObject)mixed).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegionaccesstestlanguagePackage.ROOT__MIXED, null, msgs);
      if (newMixed != null)
        msgs = ((InternalEObject)newMixed).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegionaccesstestlanguagePackage.ROOT__MIXED, null, msgs);
      msgs = basicSetMixed(newMixed, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RegionaccesstestlanguagePackage.ROOT__MIXED, newMixed, newMixed));
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
      case RegionaccesstestlanguagePackage.ROOT__MIXED:
        return basicSetMixed(null, msgs);
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
      case RegionaccesstestlanguagePackage.ROOT__MIXED:
        return getMixed();
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
      case RegionaccesstestlanguagePackage.ROOT__MIXED:
        setMixed((Mixed)newValue);
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
      case RegionaccesstestlanguagePackage.ROOT__MIXED:
        setMixed((Mixed)null);
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
      case RegionaccesstestlanguagePackage.ROOT__MIXED:
        return mixed != null;
    }
    return super.eIsSet(featureID);
  }

} //RootImpl
