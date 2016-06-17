/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Bug348199TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.TimeDef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.TimeDefImpl#getDay <em>Day</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimeDefImpl extends MinimalEObjectImpl.Container implements TimeDef
{
  /**
   * The default value of the '{@link #getDay() <em>Day</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDay()
   * @generated
   * @ordered
   */
  protected static final int DAY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getDay() <em>Day</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDay()
   * @generated
   * @ordered
   */
  protected int day = DAY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TimeDefImpl()
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
    return Bug348199TestLanguagePackage.Literals.TIME_DEF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getDay()
  {
    return day;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDay(int newDay)
  {
    int oldDay = day;
    day = newDay;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug348199TestLanguagePackage.TIME_DEF__DAY, oldDay, day));
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
      case Bug348199TestLanguagePackage.TIME_DEF__DAY:
        return getDay();
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
      case Bug348199TestLanguagePackage.TIME_DEF__DAY:
        setDay((Integer)newValue);
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
      case Bug348199TestLanguagePackage.TIME_DEF__DAY:
        setDay(DAY_EDEFAULT);
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
      case Bug348199TestLanguagePackage.TIME_DEF__DAY:
        return day != DAY_EDEFAULT;
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
    result.append(" (day: ");
    result.append(day);
    result.append(')');
    return result.toString();
  }

} //TimeDefImpl
