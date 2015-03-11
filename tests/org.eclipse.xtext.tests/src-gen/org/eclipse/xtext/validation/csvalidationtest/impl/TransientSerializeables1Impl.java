/**
 */
package org.eclipse.xtext.validation.csvalidationtest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage;
import org.eclipse.xtext.validation.csvalidationtest.TransientSerializeables1;
import org.eclipse.xtext.validation.csvalidationtest.TransientSerializeables1Enum;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transient Serializeables1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.TransientSerializeables1Impl#getVal1 <em>Val1</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.TransientSerializeables1Impl#getEnum1 <em>Enum1</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.TransientSerializeables1Impl#getVal2 <em>Val2</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.TransientSerializeables1Impl#getInt1 <em>Int1</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransientSerializeables1Impl extends MinimalEObjectImpl.Container implements TransientSerializeables1
{
  /**
   * The default value of the '{@link #getVal1() <em>Val1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal1()
   * @generated
   * @ordered
   */
  protected static final String VAL1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVal1() <em>Val1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal1()
   * @generated
   * @ordered
   */
  protected String val1 = VAL1_EDEFAULT;

  /**
   * The default value of the '{@link #getEnum1() <em>Enum1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnum1()
   * @generated
   * @ordered
   */
  protected static final TransientSerializeables1Enum ENUM1_EDEFAULT = TransientSerializeables1Enum.LIT1;

  /**
   * The cached value of the '{@link #getEnum1() <em>Enum1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnum1()
   * @generated
   * @ordered
   */
  protected TransientSerializeables1Enum enum1 = ENUM1_EDEFAULT;

  /**
   * The default value of the '{@link #getVal2() <em>Val2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal2()
   * @generated
   * @ordered
   */
  protected static final String VAL2_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVal2() <em>Val2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal2()
   * @generated
   * @ordered
   */
  protected String val2 = VAL2_EDEFAULT;

  /**
   * The default value of the '{@link #getInt1() <em>Int1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInt1()
   * @generated
   * @ordered
   */
  protected static final int INT1_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getInt1() <em>Int1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInt1()
   * @generated
   * @ordered
   */
  protected int int1 = INT1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransientSerializeables1Impl()
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
    return CsvalidationtestPackage.Literals.TRANSIENT_SERIALIZEABLES1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVal1()
  {
    return val1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVal1(String newVal1)
  {
    String oldVal1 = val1;
    val1 = newVal1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__VAL1, oldVal1, val1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransientSerializeables1Enum getEnum1()
  {
    return enum1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnum1(TransientSerializeables1Enum newEnum1)
  {
    TransientSerializeables1Enum oldEnum1 = enum1;
    enum1 = newEnum1 == null ? ENUM1_EDEFAULT : newEnum1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__ENUM1, oldEnum1, enum1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVal2()
  {
    return val2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVal2(String newVal2)
  {
    String oldVal2 = val2;
    val2 = newVal2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__VAL2, oldVal2, val2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getInt1()
  {
    return int1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInt1(int newInt1)
  {
    int oldInt1 = int1;
    int1 = newInt1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__INT1, oldInt1, int1));
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
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__VAL1:
        return getVal1();
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__ENUM1:
        return getEnum1();
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__VAL2:
        return getVal2();
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__INT1:
        return getInt1();
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
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__VAL1:
        setVal1((String)newValue);
        return;
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__ENUM1:
        setEnum1((TransientSerializeables1Enum)newValue);
        return;
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__VAL2:
        setVal2((String)newValue);
        return;
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__INT1:
        setInt1((Integer)newValue);
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
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__VAL1:
        setVal1(VAL1_EDEFAULT);
        return;
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__ENUM1:
        setEnum1(ENUM1_EDEFAULT);
        return;
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__VAL2:
        setVal2(VAL2_EDEFAULT);
        return;
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__INT1:
        setInt1(INT1_EDEFAULT);
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
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__VAL1:
        return VAL1_EDEFAULT == null ? val1 != null : !VAL1_EDEFAULT.equals(val1);
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__ENUM1:
        return enum1 != ENUM1_EDEFAULT;
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__VAL2:
        return VAL2_EDEFAULT == null ? val2 != null : !VAL2_EDEFAULT.equals(val2);
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1__INT1:
        return int1 != INT1_EDEFAULT;
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
    result.append(" (val1: ");
    result.append(val1);
    result.append(", enum1: ");
    result.append(enum1);
    result.append(", val2: ");
    result.append(val2);
    result.append(", int1: ");
    result.append(int1);
    result.append(')');
    return result.toString();
  }

} //TransientSerializeables1Impl
