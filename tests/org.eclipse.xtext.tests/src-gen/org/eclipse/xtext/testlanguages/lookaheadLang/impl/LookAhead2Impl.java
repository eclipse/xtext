/**
 */
package org.eclipse.xtext.testlanguages.lookaheadLang.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead2;
import org.eclipse.xtext.testlanguages.lookaheadLang.LookaheadLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Look Ahead2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.lookaheadLang.impl.LookAhead2Impl#getZ <em>Z</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LookAhead2Impl extends MinimalEObjectImpl.Container implements LookAhead2
{
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
  protected LookAhead2Impl()
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
    return LookaheadLangPackage.Literals.LOOK_AHEAD2;
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
      eNotify(new ENotificationImpl(this, Notification.SET, LookaheadLangPackage.LOOK_AHEAD2__Z, oldZ, z));
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
      case LookaheadLangPackage.LOOK_AHEAD2__Z:
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
      case LookaheadLangPackage.LOOK_AHEAD2__Z:
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
      case LookaheadLangPackage.LOOK_AHEAD2__Z:
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
      case LookaheadLangPackage.LOOK_AHEAD2__Z:
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

} //LookAhead2Impl
