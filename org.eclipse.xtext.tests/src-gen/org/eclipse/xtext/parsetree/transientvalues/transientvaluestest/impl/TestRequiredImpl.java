/**
 */
package org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestRequired;
import org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TransientvaluestestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Required</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TestRequiredImpl#getRequired1 <em>Required1</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TestRequiredImpl#getRequired2 <em>Required2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestRequiredImpl extends RootImpl implements TestRequired
{
  /**
   * The default value of the '{@link #getRequired1() <em>Required1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequired1()
   * @generated
   * @ordered
   */
  protected static final int REQUIRED1_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getRequired1() <em>Required1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequired1()
   * @generated
   * @ordered
   */
  protected int required1 = REQUIRED1_EDEFAULT;

  /**
   * The default value of the '{@link #getRequired2() <em>Required2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequired2()
   * @generated
   * @ordered
   */
  protected static final int REQUIRED2_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getRequired2() <em>Required2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequired2()
   * @generated
   * @ordered
   */
  protected int required2 = REQUIRED2_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TestRequiredImpl()
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
    return TransientvaluestestPackage.Literals.TEST_REQUIRED;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getRequired1()
  {
    return required1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequired1(int newRequired1)
  {
    int oldRequired1 = required1;
    required1 = newRequired1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TransientvaluestestPackage.TEST_REQUIRED__REQUIRED1, oldRequired1, required1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getRequired2()
  {
    return required2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequired2(int newRequired2)
  {
    int oldRequired2 = required2;
    required2 = newRequired2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TransientvaluestestPackage.TEST_REQUIRED__REQUIRED2, oldRequired2, required2));
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
      case TransientvaluestestPackage.TEST_REQUIRED__REQUIRED1:
        return getRequired1();
      case TransientvaluestestPackage.TEST_REQUIRED__REQUIRED2:
        return getRequired2();
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
      case TransientvaluestestPackage.TEST_REQUIRED__REQUIRED1:
        setRequired1((Integer)newValue);
        return;
      case TransientvaluestestPackage.TEST_REQUIRED__REQUIRED2:
        setRequired2((Integer)newValue);
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
      case TransientvaluestestPackage.TEST_REQUIRED__REQUIRED1:
        setRequired1(REQUIRED1_EDEFAULT);
        return;
      case TransientvaluestestPackage.TEST_REQUIRED__REQUIRED2:
        setRequired2(REQUIRED2_EDEFAULT);
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
      case TransientvaluestestPackage.TEST_REQUIRED__REQUIRED1:
        return required1 != REQUIRED1_EDEFAULT;
      case TransientvaluestestPackage.TEST_REQUIRED__REQUIRED2:
        return required2 != REQUIRED2_EDEFAULT;
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
    result.append(" (required1: ");
    result.append(required1);
    result.append(", required2: ");
    result.append(required2);
    result.append(')');
    return result.toString();
  }

} //TestRequiredImpl
