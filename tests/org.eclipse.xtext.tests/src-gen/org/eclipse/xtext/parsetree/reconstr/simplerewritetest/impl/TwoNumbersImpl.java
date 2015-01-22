/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Two Numbers</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TwoNumbersImpl#getNum1 <em>Num1</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TwoNumbersImpl#getNum2 <em>Num2</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.TwoNumbersImpl#getNum3 <em>Num3</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TwoNumbersImpl extends ExpressionImpl implements TwoNumbers
{
  /**
   * The default value of the '{@link #getNum1() <em>Num1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNum1()
   * @generated
   * @ordered
   */
  protected static final int NUM1_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getNum1() <em>Num1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNum1()
   * @generated
   * @ordered
   */
  protected int num1 = NUM1_EDEFAULT;

  /**
   * The default value of the '{@link #getNum2() <em>Num2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNum2()
   * @generated
   * @ordered
   */
  protected static final int NUM2_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getNum2() <em>Num2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNum2()
   * @generated
   * @ordered
   */
  protected int num2 = NUM2_EDEFAULT;

  /**
   * The cached value of the '{@link #getNum3() <em>Num3</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNum3()
   * @generated
   * @ordered
   */
  protected EList<Integer> num3;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TwoNumbersImpl()
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
    return SimplerewritetestPackage.Literals.TWO_NUMBERS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getNum1()
  {
    return num1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNum1(int newNum1)
  {
    int oldNum1 = num1;
    num1 = newNum1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimplerewritetestPackage.TWO_NUMBERS__NUM1, oldNum1, num1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getNum2()
  {
    return num2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNum2(int newNum2)
  {
    int oldNum2 = num2;
    num2 = newNum2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimplerewritetestPackage.TWO_NUMBERS__NUM2, oldNum2, num2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Integer> getNum3()
  {
    if (num3 == null)
    {
      num3 = new EDataTypeEList<Integer>(Integer.class, this, SimplerewritetestPackage.TWO_NUMBERS__NUM3);
    }
    return num3;
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
      case SimplerewritetestPackage.TWO_NUMBERS__NUM1:
        return getNum1();
      case SimplerewritetestPackage.TWO_NUMBERS__NUM2:
        return getNum2();
      case SimplerewritetestPackage.TWO_NUMBERS__NUM3:
        return getNum3();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SimplerewritetestPackage.TWO_NUMBERS__NUM1:
        setNum1((Integer)newValue);
        return;
      case SimplerewritetestPackage.TWO_NUMBERS__NUM2:
        setNum2((Integer)newValue);
        return;
      case SimplerewritetestPackage.TWO_NUMBERS__NUM3:
        getNum3().clear();
        getNum3().addAll((Collection<? extends Integer>)newValue);
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
      case SimplerewritetestPackage.TWO_NUMBERS__NUM1:
        setNum1(NUM1_EDEFAULT);
        return;
      case SimplerewritetestPackage.TWO_NUMBERS__NUM2:
        setNum2(NUM2_EDEFAULT);
        return;
      case SimplerewritetestPackage.TWO_NUMBERS__NUM3:
        getNum3().clear();
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
      case SimplerewritetestPackage.TWO_NUMBERS__NUM1:
        return num1 != NUM1_EDEFAULT;
      case SimplerewritetestPackage.TWO_NUMBERS__NUM2:
        return num2 != NUM2_EDEFAULT;
      case SimplerewritetestPackage.TWO_NUMBERS__NUM3:
        return num3 != null && !num3.isEmpty();
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
    result.append(" (num1: ");
    result.append(num1);
    result.append(", num2: ");
    result.append(num2);
    result.append(", num3: ");
    result.append(num3);
    result.append(')');
    return result.toString();
  }

} //TwoNumbersImpl
