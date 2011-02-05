/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.serializer.syntacticsequencertest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.syntacticsequencertest.Exp0;
import org.eclipse.xtext.serializer.syntacticsequencertest.Exp1;
import org.eclipse.xtext.serializer.syntacticsequencertest.Exp2;
import org.eclipse.xtext.serializer.syntacticsequencertest.MandatoryKeywords;
import org.eclipse.xtext.serializer.syntacticsequencertest.Model;
import org.eclipse.xtext.serializer.syntacticsequencertest.SyntacticsequencertestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX1 <em>X1</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX2 <em>X2</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX3 <em>X3</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX4 <em>X4</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getX1() <em>X1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX1()
   * @generated
   * @ordered
   */
  protected MandatoryKeywords x1;

  /**
   * The cached value of the '{@link #getX2() <em>X2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX2()
   * @generated
   * @ordered
   */
  protected Exp0 x2;

  /**
   * The cached value of the '{@link #getX3() <em>X3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX3()
   * @generated
   * @ordered
   */
  protected Exp1 x3;

  /**
   * The cached value of the '{@link #getX4() <em>X4</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX4()
   * @generated
   * @ordered
   */
  protected Exp2 x4;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return SyntacticsequencertestPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MandatoryKeywords getX1()
  {
    return x1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX1(MandatoryKeywords newX1, NotificationChain msgs)
  {
    MandatoryKeywords oldX1 = x1;
    x1 = newX1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X1, oldX1, newX1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX1(MandatoryKeywords newX1)
  {
    if (newX1 != x1)
    {
      NotificationChain msgs = null;
      if (x1 != null)
        msgs = ((InternalEObject)x1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X1, null, msgs);
      if (newX1 != null)
        msgs = ((InternalEObject)newX1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X1, null, msgs);
      msgs = basicSetX1(newX1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X1, newX1, newX1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exp0 getX2()
  {
    return x2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX2(Exp0 newX2, NotificationChain msgs)
  {
    Exp0 oldX2 = x2;
    x2 = newX2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X2, oldX2, newX2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX2(Exp0 newX2)
  {
    if (newX2 != x2)
    {
      NotificationChain msgs = null;
      if (x2 != null)
        msgs = ((InternalEObject)x2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X2, null, msgs);
      if (newX2 != null)
        msgs = ((InternalEObject)newX2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X2, null, msgs);
      msgs = basicSetX2(newX2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X2, newX2, newX2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exp1 getX3()
  {
    return x3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX3(Exp1 newX3, NotificationChain msgs)
  {
    Exp1 oldX3 = x3;
    x3 = newX3;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X3, oldX3, newX3);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX3(Exp1 newX3)
  {
    if (newX3 != x3)
    {
      NotificationChain msgs = null;
      if (x3 != null)
        msgs = ((InternalEObject)x3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X3, null, msgs);
      if (newX3 != null)
        msgs = ((InternalEObject)newX3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X3, null, msgs);
      msgs = basicSetX3(newX3, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X3, newX3, newX3));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exp2 getX4()
  {
    return x4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX4(Exp2 newX4, NotificationChain msgs)
  {
    Exp2 oldX4 = x4;
    x4 = newX4;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X4, oldX4, newX4);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX4(Exp2 newX4)
  {
    if (newX4 != x4)
    {
      NotificationChain msgs = null;
      if (x4 != null)
        msgs = ((InternalEObject)x4).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X4, null, msgs);
      if (newX4 != null)
        msgs = ((InternalEObject)newX4).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X4, null, msgs);
      msgs = basicSetX4(newX4, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X4, newX4, newX4));
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
      case SyntacticsequencertestPackage.MODEL__X1:
        return basicSetX1(null, msgs);
      case SyntacticsequencertestPackage.MODEL__X2:
        return basicSetX2(null, msgs);
      case SyntacticsequencertestPackage.MODEL__X3:
        return basicSetX3(null, msgs);
      case SyntacticsequencertestPackage.MODEL__X4:
        return basicSetX4(null, msgs);
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
      case SyntacticsequencertestPackage.MODEL__X1:
        return getX1();
      case SyntacticsequencertestPackage.MODEL__X2:
        return getX2();
      case SyntacticsequencertestPackage.MODEL__X3:
        return getX3();
      case SyntacticsequencertestPackage.MODEL__X4:
        return getX4();
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
      case SyntacticsequencertestPackage.MODEL__X1:
        setX1((MandatoryKeywords)newValue);
        return;
      case SyntacticsequencertestPackage.MODEL__X2:
        setX2((Exp0)newValue);
        return;
      case SyntacticsequencertestPackage.MODEL__X3:
        setX3((Exp1)newValue);
        return;
      case SyntacticsequencertestPackage.MODEL__X4:
        setX4((Exp2)newValue);
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
      case SyntacticsequencertestPackage.MODEL__X1:
        setX1((MandatoryKeywords)null);
        return;
      case SyntacticsequencertestPackage.MODEL__X2:
        setX2((Exp0)null);
        return;
      case SyntacticsequencertestPackage.MODEL__X3:
        setX3((Exp1)null);
        return;
      case SyntacticsequencertestPackage.MODEL__X4:
        setX4((Exp2)null);
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
      case SyntacticsequencertestPackage.MODEL__X1:
        return x1 != null;
      case SyntacticsequencertestPackage.MODEL__X2:
        return x2 != null;
      case SyntacticsequencertestPackage.MODEL__X3:
        return x3 != null;
      case SyntacticsequencertestPackage.MODEL__X4:
        return x4 != null;
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
