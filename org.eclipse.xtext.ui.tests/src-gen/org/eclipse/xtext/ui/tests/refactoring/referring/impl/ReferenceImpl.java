/**
 */
package org.eclipse.xtext.ui.tests.refactoring.referring.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.ui.tests.refactoring.referring.Reference;
import org.eclipse.xtext.ui.tests.refactoring.referring.ReferringPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.refactoring.referring.impl.ReferenceImpl#getReferenced <em>Referenced</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceImpl extends MinimalEObjectImpl.Container implements Reference
{
  /**
   * The cached value of the '{@link #getReferenced() <em>Referenced</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferenced()
   * @generated
   * @ordered
   */
  protected EObject referenced;

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
    return ReferringPackage.Literals.REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getReferenced()
  {
    if (referenced != null && referenced.eIsProxy())
    {
      InternalEObject oldReferenced = (InternalEObject)referenced;
      referenced = eResolveProxy(oldReferenced);
      if (referenced != oldReferenced)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReferringPackage.REFERENCE__REFERENCED, oldReferenced, referenced));
      }
    }
    return referenced;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetReferenced()
  {
    return referenced;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReferenced(EObject newReferenced)
  {
    EObject oldReferenced = referenced;
    referenced = newReferenced;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReferringPackage.REFERENCE__REFERENCED, oldReferenced, referenced));
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
      case ReferringPackage.REFERENCE__REFERENCED:
        if (resolve) return getReferenced();
        return basicGetReferenced();
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
      case ReferringPackage.REFERENCE__REFERENCED:
        setReferenced((EObject)newValue);
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
      case ReferringPackage.REFERENCE__REFERENCED:
        setReferenced((EObject)null);
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
      case ReferringPackage.REFERENCE__REFERENCED:
        return referenced != null;
    }
    return super.eIsSet(featureID);
  }

} //ReferenceImpl
