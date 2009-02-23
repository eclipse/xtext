/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtext.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xtext.Wildcard;
import org.eclipse.xtext.xtext.XtextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wildcard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtext.impl.WildcardImpl#isIsWildcard <em>Is Wildcard</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WildcardImpl extends AbstractElementImpl implements Wildcard
{
  /**
   * The default value of the '{@link #isIsWildcard() <em>Is Wildcard</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsWildcard()
   * @generated
   * @ordered
   */
  protected static final boolean IS_WILDCARD_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsWildcard() <em>Is Wildcard</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsWildcard()
   * @generated
   * @ordered
   */
  protected boolean isWildcard = IS_WILDCARD_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WildcardImpl()
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
    return XtextPackage.Literals.WILDCARD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsWildcard()
  {
    return isWildcard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsWildcard(boolean newIsWildcard)
  {
    boolean oldIsWildcard = isWildcard;
    isWildcard = newIsWildcard;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextPackage.WILDCARD__IS_WILDCARD, oldIsWildcard, isWildcard));
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
      case XtextPackage.WILDCARD__IS_WILDCARD:
        return isIsWildcard();
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
      case XtextPackage.WILDCARD__IS_WILDCARD:
        setIsWildcard((Boolean)newValue);
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
      case XtextPackage.WILDCARD__IS_WILDCARD:
        setIsWildcard(IS_WILDCARD_EDEFAULT);
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
      case XtextPackage.WILDCARD__IS_WILDCARD:
        return isWildcard != IS_WILDCARD_EDEFAULT;
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
    result.append(" (isWildcard: ");
    result.append(isWildcard);
    result.append(')');
    return result.toString();
  }

} //WildcardImpl
