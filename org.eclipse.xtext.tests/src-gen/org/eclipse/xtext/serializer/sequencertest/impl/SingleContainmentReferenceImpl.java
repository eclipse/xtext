/**
 */
package org.eclipse.xtext.serializer.sequencertest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.SingleContainmentReferenceImpl#getChild <em>Child</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SingleContainmentReferenceImpl extends MinimalEObjectImpl.Container implements SingleContainmentReference
{
  /**
   * The cached value of the '{@link #getChild() <em>Child</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChild()
   * @generated
   * @ordered
   */
  protected EObject child;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SingleContainmentReferenceImpl()
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
    return SequencertestPackage.Literals.SINGLE_CONTAINMENT_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getChild()
  {
    return child;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChild(EObject newChild, NotificationChain msgs)
  {
    EObject oldChild = child;
    child = newChild;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE__CHILD, oldChild, newChild);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChild(EObject newChild)
  {
    if (newChild != child)
    {
      NotificationChain msgs = null;
      if (child != null)
        msgs = ((InternalEObject)child).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE__CHILD, null, msgs);
      if (newChild != null)
        msgs = ((InternalEObject)newChild).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE__CHILD, null, msgs);
      msgs = basicSetChild(newChild, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE__CHILD, newChild, newChild));
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
      case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE__CHILD:
        return basicSetChild(null, msgs);
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
      case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE__CHILD:
        return getChild();
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
      case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE__CHILD:
        setChild((EObject)newValue);
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
      case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE__CHILD:
        setChild((EObject)null);
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
      case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE__CHILD:
        return child != null;
    }
    return super.eIsSet(featureID);
  }

} //SingleContainmentReferenceImpl
