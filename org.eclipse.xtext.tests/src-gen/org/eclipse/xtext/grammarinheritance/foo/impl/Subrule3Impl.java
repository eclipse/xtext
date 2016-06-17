/**
 */
package org.eclipse.xtext.grammarinheritance.foo.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.grammarinheritance.ametamodel.impl.ATypeImpl;

import org.eclipse.xtext.grammarinheritance.foo.FooPackage;
import org.eclipse.xtext.grammarinheritance.foo.Subrule3;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subrule3</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.grammarinheritance.foo.impl.Subrule3Impl#getSub1 <em>Sub1</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Subrule3Impl extends ATypeImpl implements Subrule3
{
  /**
   * The default value of the '{@link #getSub1() <em>Sub1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSub1()
   * @generated
   * @ordered
   */
  protected static final int SUB1_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getSub1() <em>Sub1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSub1()
   * @generated
   * @ordered
   */
  protected int sub1 = SUB1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Subrule3Impl()
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
    return FooPackage.Literals.SUBRULE3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getSub1()
  {
    return sub1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSub1(int newSub1)
  {
    int oldSub1 = sub1;
    sub1 = newSub1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FooPackage.SUBRULE3__SUB1, oldSub1, sub1));
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
      case FooPackage.SUBRULE3__SUB1:
        return getSub1();
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
      case FooPackage.SUBRULE3__SUB1:
        setSub1((Integer)newValue);
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
      case FooPackage.SUBRULE3__SUB1:
        setSub1(SUB1_EDEFAULT);
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
      case FooPackage.SUBRULE3__SUB1:
        return sub1 != SUB1_EDEFAULT;
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
    result.append(" (sub1: ");
    result.append(sub1);
    result.append(')');
    return result.toString();
  }

} //Subrule3Impl
