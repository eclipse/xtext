/**
 */
package org.eclipse.xtext.testlanguages.testLang.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.testlanguages.testLang.TerminalElement;
import org.eclipse.xtext.testlanguages.testLang.TestLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Terminal Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.testLang.impl.TerminalElementImpl#getStringFeature <em>String Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TerminalElementImpl extends ReducibleElementImpl implements TerminalElement
{
  /**
   * The default value of the '{@link #getStringFeature() <em>String Feature</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStringFeature()
   * @generated
   * @ordered
   */
  protected static final String STRING_FEATURE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStringFeature() <em>String Feature</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStringFeature()
   * @generated
   * @ordered
   */
  protected String stringFeature = STRING_FEATURE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TerminalElementImpl()
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
    return TestLangPackage.Literals.TERMINAL_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStringFeature()
  {
    return stringFeature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStringFeature(String newStringFeature)
  {
    String oldStringFeature = stringFeature;
    stringFeature = newStringFeature;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.TERMINAL_ELEMENT__STRING_FEATURE, oldStringFeature, stringFeature));
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
      case TestLangPackage.TERMINAL_ELEMENT__STRING_FEATURE:
        return getStringFeature();
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
      case TestLangPackage.TERMINAL_ELEMENT__STRING_FEATURE:
        setStringFeature((String)newValue);
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
      case TestLangPackage.TERMINAL_ELEMENT__STRING_FEATURE:
        setStringFeature(STRING_FEATURE_EDEFAULT);
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
      case TestLangPackage.TERMINAL_ELEMENT__STRING_FEATURE:
        return STRING_FEATURE_EDEFAULT == null ? stringFeature != null : !STRING_FEATURE_EDEFAULT.equals(stringFeature);
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
    result.append(" (stringFeature: ");
    result.append(stringFeature);
    result.append(')');
    return result.toString();
  }

} //TerminalElementImpl
