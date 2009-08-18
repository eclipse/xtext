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

import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C1;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C2;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>C2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.C2Impl#getY <em>Y</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class C2Impl extends TrickyCImpl implements C2
{
  /**
   * The cached value of the '{@link #getY() <em>Y</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getY()
   * @generated
   * @ordered
   */
  protected C1 y;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected C2Impl()
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
    return ComplexrewritetestPackage.Literals.C2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public C1 getY()
  {
    return y;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetY(C1 newY, NotificationChain msgs)
  {
    C1 oldY = y;
    y = newY;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComplexrewritetestPackage.C2__Y, oldY, newY);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setY(C1 newY)
  {
    if (newY != y)
    {
      NotificationChain msgs = null;
      if (y != null)
        msgs = ((InternalEObject)y).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComplexrewritetestPackage.C2__Y, null, msgs);
      if (newY != null)
        msgs = ((InternalEObject)newY).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComplexrewritetestPackage.C2__Y, null, msgs);
      msgs = basicSetY(newY, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ComplexrewritetestPackage.C2__Y, newY, newY));
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
      case ComplexrewritetestPackage.C2__Y:
        return basicSetY(null, msgs);
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
      case ComplexrewritetestPackage.C2__Y:
        return getY();
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
      case ComplexrewritetestPackage.C2__Y:
        setY((C1)newValue);
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
      case ComplexrewritetestPackage.C2__Y:
        setY((C1)null);
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
      case ComplexrewritetestPackage.C2__Y:
        return y != null;
    }
    return super.eIsSet(featureID);
  }

} //C2Impl
