/**
 */
package org.eclipse.xtext.linking.lazy.bug311337.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.linking.lazy.bug311337.Bug311337Package;
import org.eclipse.xtext.linking.lazy.bug311337.Child;
import org.eclipse.xtext.linking.lazy.bug311337.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.linking.lazy.bug311337.impl.ReferenceImpl#getRefChild <em>Ref Child</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceImpl extends MinimalEObjectImpl.Container implements Reference
{
  /**
   * The cached value of the '{@link #getRefChild() <em>Ref Child</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefChild()
   * @generated
   * @ordered
   */
  protected Child refChild;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReferenceImpl()
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
    return Bug311337Package.Literals.REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Child getRefChild()
  {
    if (refChild != null && refChild.eIsProxy())
    {
      InternalEObject oldRefChild = (InternalEObject)refChild;
      refChild = (Child)eResolveProxy(oldRefChild);
      if (refChild != oldRefChild)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bug311337Package.REFERENCE__REF_CHILD, oldRefChild, refChild));
      }
    }
    return refChild;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Child basicGetRefChild()
  {
    return refChild;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRefChild(Child newRefChild)
  {
    Child oldRefChild = refChild;
    refChild = newRefChild;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug311337Package.REFERENCE__REF_CHILD, oldRefChild, refChild));
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
      case Bug311337Package.REFERENCE__REF_CHILD:
        if (resolve) return getRefChild();
        return basicGetRefChild();
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
      case Bug311337Package.REFERENCE__REF_CHILD:
        setRefChild((Child)newValue);
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
      case Bug311337Package.REFERENCE__REF_CHILD:
        setRefChild((Child)null);
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
      case Bug311337Package.REFERENCE__REF_CHILD:
        return refChild != null;
    }
    return super.eIsSet(featureID);
  }

} //ReferenceImpl
