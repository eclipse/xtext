/**
 */
package org.eclipse.xtext.grammarinheritance.foo.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.grammarinheritance.ametamodel.impl.ATypeImpl;

import org.eclipse.xtext.grammarinheritance.foo.FooPackage;
import org.eclipse.xtext.grammarinheritance.foo.Subrule1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subrule1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.grammarinheritance.foo.impl.Subrule1Impl#getSub1 <em>Sub1</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Subrule1Impl extends ATypeImpl implements Subrule1
{
  /**
   * The default value of the '{@link #getSub1() <em>Sub1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSub1()
   * @generated
   * @ordered
   */
  protected static final String SUB1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSub1() <em>Sub1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSub1()
   * @generated
   * @ordered
   */
  protected String sub1 = SUB1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Subrule1Impl()
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
    return FooPackage.Literals.SUBRULE1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSub1()
  {
    return sub1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSub1(String newSub1)
  {
    String oldSub1 = sub1;
    sub1 = newSub1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FooPackage.SUBRULE1__SUB1, oldSub1, sub1));
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
      case FooPackage.SUBRULE1__SUB1:
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
      case FooPackage.SUBRULE1__SUB1:
        setSub1((String)newValue);
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
      case FooPackage.SUBRULE1__SUB1:
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
      case FooPackage.SUBRULE1__SUB1:
        return SUB1_EDEFAULT == null ? sub1 != null : !SUB1_EDEFAULT.equals(sub1);
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

} //Subrule1Impl
