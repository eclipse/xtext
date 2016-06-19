/**
 */
package org.eclipse.xtext.serializer.assignmentFinderTest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestPackage;
import org.eclipse.xtext.serializer.assignmentFinderTest.ContainmentRef;
import org.eclipse.xtext.serializer.assignmentFinderTest.ContainmentRefN;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Containment Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.ContainmentRefImpl#getCtx <em>Ctx</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContainmentRefImpl extends MinimalEObjectImpl.Container implements ContainmentRef
{
  /**
   * The cached value of the '{@link #getCtx() <em>Ctx</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCtx()
   * @generated
   * @ordered
   */
  protected ContainmentRefN ctx;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContainmentRefImpl()
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
    return AssignmentFinderTestPackage.Literals.CONTAINMENT_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContainmentRefN getCtx()
  {
    return ctx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCtx(ContainmentRefN newCtx, NotificationChain msgs)
  {
    ContainmentRefN oldCtx = ctx;
    ctx = newCtx;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.CONTAINMENT_REF__CTX, oldCtx, newCtx);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCtx(ContainmentRefN newCtx)
  {
    if (newCtx != ctx)
    {
      NotificationChain msgs = null;
      if (ctx != null)
        msgs = ((InternalEObject)ctx).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.CONTAINMENT_REF__CTX, null, msgs);
      if (newCtx != null)
        msgs = ((InternalEObject)newCtx).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.CONTAINMENT_REF__CTX, null, msgs);
      msgs = basicSetCtx(newCtx, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.CONTAINMENT_REF__CTX, newCtx, newCtx));
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
      case AssignmentFinderTestPackage.CONTAINMENT_REF__CTX:
        return basicSetCtx(null, msgs);
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
      case AssignmentFinderTestPackage.CONTAINMENT_REF__CTX:
        return getCtx();
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
      case AssignmentFinderTestPackage.CONTAINMENT_REF__CTX:
        setCtx((ContainmentRefN)newValue);
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
      case AssignmentFinderTestPackage.CONTAINMENT_REF__CTX:
        setCtx((ContainmentRefN)null);
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
      case AssignmentFinderTestPackage.CONTAINMENT_REF__CTX:
        return ctx != null;
    }
    return super.eIsSet(featureID);
  }

} //ContainmentRefImpl
