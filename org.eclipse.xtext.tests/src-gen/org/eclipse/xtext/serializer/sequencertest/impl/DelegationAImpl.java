/**
 */
package org.eclipse.xtext.serializer.sequencertest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.serializer.sequencertest.Delegation;
import org.eclipse.xtext.serializer.sequencertest.DelegationA;
import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delegation A</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.DelegationAImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.DelegationAImpl#getRc2 <em>Rc2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DelegationAImpl extends DelegationImpl implements DelegationA
{
  /**
   * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeft()
   * @generated
   * @ordered
   */
  protected Delegation left;

  /**
   * The cached value of the '{@link #getRc2() <em>Rc2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRc2()
   * @generated
   * @ordered
   */
  protected Delegation rc2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DelegationAImpl()
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
    return SequencertestPackage.Literals.DELEGATION_A;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Delegation getLeft()
  {
    return left;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeft(Delegation newLeft, NotificationChain msgs)
  {
    Delegation oldLeft = left;
    left = newLeft;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.DELEGATION_A__LEFT, oldLeft, newLeft);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeft(Delegation newLeft)
  {
    if (newLeft != left)
    {
      NotificationChain msgs = null;
      if (left != null)
        msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.DELEGATION_A__LEFT, null, msgs);
      if (newLeft != null)
        msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.DELEGATION_A__LEFT, null, msgs);
      msgs = basicSetLeft(newLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.DELEGATION_A__LEFT, newLeft, newLeft));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Delegation getRc2()
  {
    return rc2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRc2(Delegation newRc2, NotificationChain msgs)
  {
    Delegation oldRc2 = rc2;
    rc2 = newRc2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.DELEGATION_A__RC2, oldRc2, newRc2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRc2(Delegation newRc2)
  {
    if (newRc2 != rc2)
    {
      NotificationChain msgs = null;
      if (rc2 != null)
        msgs = ((InternalEObject)rc2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.DELEGATION_A__RC2, null, msgs);
      if (newRc2 != null)
        msgs = ((InternalEObject)newRc2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.DELEGATION_A__RC2, null, msgs);
      msgs = basicSetRc2(newRc2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.DELEGATION_A__RC2, newRc2, newRc2));
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
      case SequencertestPackage.DELEGATION_A__LEFT:
        return basicSetLeft(null, msgs);
      case SequencertestPackage.DELEGATION_A__RC2:
        return basicSetRc2(null, msgs);
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
      case SequencertestPackage.DELEGATION_A__LEFT:
        return getLeft();
      case SequencertestPackage.DELEGATION_A__RC2:
        return getRc2();
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
      case SequencertestPackage.DELEGATION_A__LEFT:
        setLeft((Delegation)newValue);
        return;
      case SequencertestPackage.DELEGATION_A__RC2:
        setRc2((Delegation)newValue);
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
      case SequencertestPackage.DELEGATION_A__LEFT:
        setLeft((Delegation)null);
        return;
      case SequencertestPackage.DELEGATION_A__RC2:
        setRc2((Delegation)null);
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
      case SequencertestPackage.DELEGATION_A__LEFT:
        return left != null;
      case SequencertestPackage.DELEGATION_A__RC2:
        return rc2 != null;
    }
    return super.eIsSet(featureID);
  }

} //DelegationAImpl
