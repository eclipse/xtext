/**
 */
package org.eclipse.xtext.serializer.assignmentFinderTest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestPackage;
import org.eclipse.xtext.serializer.assignmentFinderTest.KeywordBool;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Keyword Bool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.KeywordBoolImpl#isKw <em>Kw</em>}</li>
 * </ul>
 *
 * @generated
 */
public class KeywordBoolImpl extends MinimalEObjectImpl.Container implements KeywordBool
{
  /**
   * The default value of the '{@link #isKw() <em>Kw</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isKw()
   * @generated
   * @ordered
   */
  protected static final boolean KW_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isKw() <em>Kw</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isKw()
   * @generated
   * @ordered
   */
  protected boolean kw = KW_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected KeywordBoolImpl()
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
    return AssignmentFinderTestPackage.Literals.KEYWORD_BOOL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isKw()
  {
    return kw;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKw(boolean newKw)
  {
    boolean oldKw = kw;
    kw = newKw;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.KEYWORD_BOOL__KW, oldKw, kw));
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
      case AssignmentFinderTestPackage.KEYWORD_BOOL__KW:
        return isKw();
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
      case AssignmentFinderTestPackage.KEYWORD_BOOL__KW:
        setKw((Boolean)newValue);
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
      case AssignmentFinderTestPackage.KEYWORD_BOOL__KW:
        setKw(KW_EDEFAULT);
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
      case AssignmentFinderTestPackage.KEYWORD_BOOL__KW:
        return kw != KW_EDEFAULT;
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
    result.append(" (kw: ");
    result.append(kw);
    result.append(')');
    return result.toString();
  }

} //KeywordBoolImpl
