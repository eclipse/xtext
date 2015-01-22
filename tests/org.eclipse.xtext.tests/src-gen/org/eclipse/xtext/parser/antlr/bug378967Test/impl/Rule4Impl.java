/**
 */
package org.eclipse.xtext.parser.antlr.bug378967Test.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parser.antlr.bug378967Test.AfterObj;
import org.eclipse.xtext.parser.antlr.bug378967Test.Bug378967TestPackage;
import org.eclipse.xtext.parser.antlr.bug378967Test.Rule4;
import org.eclipse.xtext.parser.antlr.bug378967Test.SObj;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule4</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule4Impl#getAfter <em>After</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule4Impl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug378967Test.impl.Rule4Impl#getS <em>S</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Rule4Impl extends MinimalEObjectImpl.Container implements Rule4
{
  /**
   * The cached value of the '{@link #getAfter() <em>After</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAfter()
   * @generated
   * @ordered
   */
  protected AfterObj after;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final int VALUE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected int value = VALUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getS() <em>S</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getS()
   * @generated
   * @ordered
   */
  protected SObj s;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Rule4Impl()
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
    return Bug378967TestPackage.Literals.RULE4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AfterObj getAfter()
  {
    return after;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAfter(AfterObj newAfter, NotificationChain msgs)
  {
    AfterObj oldAfter = after;
    after = newAfter;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug378967TestPackage.RULE4__AFTER, oldAfter, newAfter);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAfter(AfterObj newAfter)
  {
    if (newAfter != after)
    {
      NotificationChain msgs = null;
      if (after != null)
        msgs = ((InternalEObject)after).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug378967TestPackage.RULE4__AFTER, null, msgs);
      if (newAfter != null)
        msgs = ((InternalEObject)newAfter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug378967TestPackage.RULE4__AFTER, null, msgs);
      msgs = basicSetAfter(newAfter, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug378967TestPackage.RULE4__AFTER, newAfter, newAfter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(int newValue)
  {
    int oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug378967TestPackage.RULE4__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SObj getS()
  {
    return s;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetS(SObj newS, NotificationChain msgs)
  {
    SObj oldS = s;
    s = newS;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug378967TestPackage.RULE4__S, oldS, newS);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setS(SObj newS)
  {
    if (newS != s)
    {
      NotificationChain msgs = null;
      if (s != null)
        msgs = ((InternalEObject)s).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug378967TestPackage.RULE4__S, null, msgs);
      if (newS != null)
        msgs = ((InternalEObject)newS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug378967TestPackage.RULE4__S, null, msgs);
      msgs = basicSetS(newS, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug378967TestPackage.RULE4__S, newS, newS));
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
      case Bug378967TestPackage.RULE4__AFTER:
        return basicSetAfter(null, msgs);
      case Bug378967TestPackage.RULE4__S:
        return basicSetS(null, msgs);
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
      case Bug378967TestPackage.RULE4__AFTER:
        return getAfter();
      case Bug378967TestPackage.RULE4__VALUE:
        return getValue();
      case Bug378967TestPackage.RULE4__S:
        return getS();
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
      case Bug378967TestPackage.RULE4__AFTER:
        setAfter((AfterObj)newValue);
        return;
      case Bug378967TestPackage.RULE4__VALUE:
        setValue((Integer)newValue);
        return;
      case Bug378967TestPackage.RULE4__S:
        setS((SObj)newValue);
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
      case Bug378967TestPackage.RULE4__AFTER:
        setAfter((AfterObj)null);
        return;
      case Bug378967TestPackage.RULE4__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case Bug378967TestPackage.RULE4__S:
        setS((SObj)null);
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
      case Bug378967TestPackage.RULE4__AFTER:
        return after != null;
      case Bug378967TestPackage.RULE4__VALUE:
        return value != VALUE_EDEFAULT;
      case Bug378967TestPackage.RULE4__S:
        return s != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (value: ");
    result.append(value);
    result.append(')');
    return result.toString();
  }

} //Rule4Impl
