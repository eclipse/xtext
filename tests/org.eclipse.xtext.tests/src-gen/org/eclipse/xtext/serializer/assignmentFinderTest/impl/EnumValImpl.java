/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.serializer.assignmentFinderTest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestPackage;
import org.eclipse.xtext.serializer.assignmentFinderTest.EnumN;
import org.eclipse.xtext.serializer.assignmentFinderTest.EnumVal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Val</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.EnumValImpl#getEn <em>En</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumValImpl extends MinimalEObjectImpl.Container implements EnumVal
{
  /**
   * The default value of the '{@link #getEn() <em>En</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEn()
   * @generated
   * @ordered
   */
  protected static final EnumN EN_EDEFAULT = EnumN.LIT1;

  /**
   * The cached value of the '{@link #getEn() <em>En</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEn()
   * @generated
   * @ordered
   */
  protected EnumN en = EN_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumValImpl()
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
    return AssignmentFinderTestPackage.Literals.ENUM_VAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumN getEn()
  {
    return en;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEn(EnumN newEn)
  {
    EnumN oldEn = en;
    en = newEn == null ? EN_EDEFAULT : newEn;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.ENUM_VAL__EN, oldEn, en));
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
      case AssignmentFinderTestPackage.ENUM_VAL__EN:
        return getEn();
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
      case AssignmentFinderTestPackage.ENUM_VAL__EN:
        setEn((EnumN)newValue);
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
      case AssignmentFinderTestPackage.ENUM_VAL__EN:
        setEn(EN_EDEFAULT);
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
      case AssignmentFinderTestPackage.ENUM_VAL__EN:
        return en != EN_EDEFAULT;
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
    result.append(" (en: ");
    result.append(en);
    result.append(')');
    return result.toString();
  }

} //EnumValImpl
