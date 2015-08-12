/**
 */
package org.eclipse.xtext.xtextTest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xtextTest.TerminalRule;
import org.eclipse.xtext.xtextTest.XtextTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Terminal Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.TerminalRuleImpl#isFragment <em>Fragment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TerminalRuleImpl extends AbstractRuleImpl implements TerminalRule
{
  /**
   * The default value of the '{@link #isFragment() <em>Fragment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFragment()
   * @generated
   * @ordered
   */
  protected static final boolean FRAGMENT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFragment() <em>Fragment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFragment()
   * @generated
   * @ordered
   */
  protected boolean fragment = FRAGMENT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TerminalRuleImpl()
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
    return XtextTestPackage.Literals.TERMINAL_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isFragment()
  {
    return fragment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFragment(boolean newFragment)
  {
    boolean oldFragment = fragment;
    fragment = newFragment;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.TERMINAL_RULE__FRAGMENT, oldFragment, fragment));
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
      case XtextTestPackage.TERMINAL_RULE__FRAGMENT:
        return isFragment();
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
      case XtextTestPackage.TERMINAL_RULE__FRAGMENT:
        setFragment((Boolean)newValue);
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
      case XtextTestPackage.TERMINAL_RULE__FRAGMENT:
        setFragment(FRAGMENT_EDEFAULT);
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
      case XtextTestPackage.TERMINAL_RULE__FRAGMENT:
        return fragment != FRAGMENT_EDEFAULT;
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
    result.append(" (fragment: ");
    result.append(fragment);
    result.append(')');
    return result.toString();
  }

} //TerminalRuleImpl
