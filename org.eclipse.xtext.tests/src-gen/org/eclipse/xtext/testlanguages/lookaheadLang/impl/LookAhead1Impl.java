/**
 */
package org.eclipse.xtext.testlanguages.lookaheadLang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead1;
import org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead2;
import org.eclipse.xtext.testlanguages.lookaheadLang.LookaheadLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Look Ahead1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.lookaheadLang.impl.LookAhead1Impl#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.lookaheadLang.impl.LookAhead1Impl#getZ <em>Z</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LookAhead1Impl extends AltsImpl implements LookAhead1
{
  /**
   * The cached value of the '{@link #getY() <em>Y</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getY()
   * @generated
   * @ordered
   */
  protected LookAhead2 y;

  /**
   * The default value of the '{@link #getZ() <em>Z</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getZ()
   * @generated
   * @ordered
   */
  protected static final String Z_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getZ() <em>Z</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getZ()
   * @generated
   * @ordered
   */
  protected String z = Z_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LookAhead1Impl()
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
    return LookaheadLangPackage.Literals.LOOK_AHEAD1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LookAhead2 getY()
  {
    return y;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetY(LookAhead2 newY, NotificationChain msgs)
  {
    LookAhead2 oldY = y;
    y = newY;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LookaheadLangPackage.LOOK_AHEAD1__Y, oldY, newY);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setY(LookAhead2 newY)
  {
    if (newY != y)
    {
      NotificationChain msgs = null;
      if (y != null)
        msgs = ((InternalEObject)y).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LookaheadLangPackage.LOOK_AHEAD1__Y, null, msgs);
      if (newY != null)
        msgs = ((InternalEObject)newY).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LookaheadLangPackage.LOOK_AHEAD1__Y, null, msgs);
      msgs = basicSetY(newY, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LookaheadLangPackage.LOOK_AHEAD1__Y, newY, newY));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getZ()
  {
    return z;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setZ(String newZ)
  {
    String oldZ = z;
    z = newZ;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LookaheadLangPackage.LOOK_AHEAD1__Z, oldZ, z));
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
      case LookaheadLangPackage.LOOK_AHEAD1__Y:
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
      case LookaheadLangPackage.LOOK_AHEAD1__Y:
        return getY();
      case LookaheadLangPackage.LOOK_AHEAD1__Z:
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
      case LookaheadLangPackage.LOOK_AHEAD1__Y:
        setY((LookAhead2)newValue);
        return;
      case LookaheadLangPackage.LOOK_AHEAD1__Z:
        setZ((String)newValue);
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
      case LookaheadLangPackage.LOOK_AHEAD1__Y:
        setY((LookAhead2)null);
        return;
      case LookaheadLangPackage.LOOK_AHEAD1__Z:
        setZ(Z_EDEFAULT);
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
      case LookaheadLangPackage.LOOK_AHEAD1__Y:
        return y != null;
      case LookaheadLangPackage.LOOK_AHEAD1__Z:
        return Z_EDEFAULT == null ? z != null : !Z_EDEFAULT.equals(z);
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
    result.append(" (z: ");
    result.append(z);
    result.append(')');
    return result.toString();
  }

} //LookAhead1Impl
