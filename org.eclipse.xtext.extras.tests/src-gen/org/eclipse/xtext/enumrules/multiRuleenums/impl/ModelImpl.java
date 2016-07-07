/**
 */
package org.eclipse.xtext.enumrules.multiRuleenums.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.enumrules.multiRuleenums.Model;
import org.eclipse.xtext.enumrules.multiRuleenums.MultiRuleenumsPackage;
import org.eclipse.xtext.enumrules.multiRuleenums.MyEnum;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.enumrules.multiRuleenums.impl.ModelImpl#getA <em>A</em>}</li>
 *   <li>{@link org.eclipse.xtext.enumrules.multiRuleenums.impl.ModelImpl#getB <em>B</em>}</li>
 *   <li>{@link org.eclipse.xtext.enumrules.multiRuleenums.impl.ModelImpl#getC <em>C</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The default value of the '{@link #getA() <em>A</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getA()
   * @generated
   * @ordered
   */
  protected static final MyEnum A_EDEFAULT = MyEnum.A;

  /**
   * The cached value of the '{@link #getA() <em>A</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getA()
   * @generated
   * @ordered
   */
  protected MyEnum a = A_EDEFAULT;

  /**
   * The default value of the '{@link #getB() <em>B</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getB()
   * @generated
   * @ordered
   */
  protected static final MyEnum B_EDEFAULT = MyEnum.A;

  /**
   * The cached value of the '{@link #getB() <em>B</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getB()
   * @generated
   * @ordered
   */
  protected MyEnum b = B_EDEFAULT;

  /**
   * The default value of the '{@link #getC() <em>C</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getC()
   * @generated
   * @ordered
   */
  protected static final MyEnum C_EDEFAULT = MyEnum.A;

  /**
   * The cached value of the '{@link #getC() <em>C</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getC()
   * @generated
   * @ordered
   */
  protected MyEnum c = C_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return MultiRuleenumsPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyEnum getA()
  {
    return a;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setA(MyEnum newA)
  {
    MyEnum oldA = a;
    a = newA == null ? A_EDEFAULT : newA;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MultiRuleenumsPackage.MODEL__A, oldA, a));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyEnum getB()
  {
    return b;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setB(MyEnum newB)
  {
    MyEnum oldB = b;
    b = newB == null ? B_EDEFAULT : newB;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MultiRuleenumsPackage.MODEL__B, oldB, b));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyEnum getC()
  {
    return c;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setC(MyEnum newC)
  {
    MyEnum oldC = c;
    c = newC == null ? C_EDEFAULT : newC;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MultiRuleenumsPackage.MODEL__C, oldC, c));
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
      case MultiRuleenumsPackage.MODEL__A:
        return getA();
      case MultiRuleenumsPackage.MODEL__B:
        return getB();
      case MultiRuleenumsPackage.MODEL__C:
        return getC();
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
      case MultiRuleenumsPackage.MODEL__A:
        setA((MyEnum)newValue);
        return;
      case MultiRuleenumsPackage.MODEL__B:
        setB((MyEnum)newValue);
        return;
      case MultiRuleenumsPackage.MODEL__C:
        setC((MyEnum)newValue);
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
      case MultiRuleenumsPackage.MODEL__A:
        setA(A_EDEFAULT);
        return;
      case MultiRuleenumsPackage.MODEL__B:
        setB(B_EDEFAULT);
        return;
      case MultiRuleenumsPackage.MODEL__C:
        setC(C_EDEFAULT);
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
      case MultiRuleenumsPackage.MODEL__A:
        return a != A_EDEFAULT;
      case MultiRuleenumsPackage.MODEL__B:
        return b != B_EDEFAULT;
      case MultiRuleenumsPackage.MODEL__C:
        return c != C_EDEFAULT;
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
    result.append(" (a: ");
    result.append(a);
    result.append(", b: ");
    result.append(b);
    result.append(", c: ");
    result.append(c);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
