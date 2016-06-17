/**
 */
package org.eclipse.xtext.serializer.assignmentFinderTest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestPackage;
import org.eclipse.xtext.serializer.assignmentFinderTest.MixedBool;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mixed Bool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.MixedBoolImpl#isVal <em>Val</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MixedBoolImpl extends MinimalEObjectImpl.Container implements MixedBool
{
  /**
   * The default value of the '{@link #isVal() <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVal()
   * @generated
   * @ordered
   */
  protected static final boolean VAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isVal() <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVal()
   * @generated
   * @ordered
   */
  protected boolean val = VAL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MixedBoolImpl()
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
    return AssignmentFinderTestPackage.Literals.MIXED_BOOL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isVal()
  {
    return val;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVal(boolean newVal)
  {
    boolean oldVal = val;
    val = newVal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MIXED_BOOL__VAL, oldVal, val));
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
      case AssignmentFinderTestPackage.MIXED_BOOL__VAL:
        return isVal();
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
      case AssignmentFinderTestPackage.MIXED_BOOL__VAL:
        setVal((Boolean)newValue);
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
      case AssignmentFinderTestPackage.MIXED_BOOL__VAL:
        setVal(VAL_EDEFAULT);
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
      case AssignmentFinderTestPackage.MIXED_BOOL__VAL:
        return val != VAL_EDEFAULT;
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
    result.append(" (val: ");
    result.append(val);
    result.append(')');
    return result.toString();
  }

} //MixedBoolImpl
