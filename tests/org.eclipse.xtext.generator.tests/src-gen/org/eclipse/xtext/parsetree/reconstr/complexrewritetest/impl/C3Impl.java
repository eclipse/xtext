/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C2;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C3;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>C3</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.C3Impl#getZ <em>Z</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class C3Impl extends TrickyCImpl implements C3
{
  /**
   * The cached value of the '{@link #getZ() <em>Z</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getZ()
   * @generated
   * @ordered
   */
  protected C2 z;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected C3Impl()
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
    return ComplexrewritetestPackage.Literals.C3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public C2 getZ()
  {
    return z;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetZ(C2 newZ, NotificationChain msgs)
  {
    C2 oldZ = z;
    z = newZ;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComplexrewritetestPackage.C3__Z, oldZ, newZ);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setZ(C2 newZ)
  {
    if (newZ != z)
    {
      NotificationChain msgs = null;
      if (z != null)
        msgs = ((InternalEObject)z).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComplexrewritetestPackage.C3__Z, null, msgs);
      if (newZ != null)
        msgs = ((InternalEObject)newZ).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComplexrewritetestPackage.C3__Z, null, msgs);
      msgs = basicSetZ(newZ, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ComplexrewritetestPackage.C3__Z, newZ, newZ));
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
      case ComplexrewritetestPackage.C3__Z:
        return basicSetZ(null, msgs);
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
      case ComplexrewritetestPackage.C3__Z:
        return getZ();
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
      case ComplexrewritetestPackage.C3__Z:
        setZ((C2)newValue);
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
      case ComplexrewritetestPackage.C3__Z:
        setZ((C2)null);
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
      case ComplexrewritetestPackage.C3__Z:
        return z != null;
    }
    return super.eIsSet(featureID);
  }

} //C3Impl
