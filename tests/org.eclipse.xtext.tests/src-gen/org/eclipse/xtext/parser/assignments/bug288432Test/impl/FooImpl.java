/**
 */
package org.eclipse.xtext.parser.assignments.bug288432Test.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestPackage;
import org.eclipse.xtext.parser.assignments.bug288432Test.Foo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Foo</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.FooImpl#getFooValue <em>Foo Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FooImpl extends MinimalEObjectImpl.Container implements Foo
{
  /**
   * The default value of the '{@link #getFooValue() <em>Foo Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFooValue()
   * @generated
   * @ordered
   */
  protected static final String FOO_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFooValue() <em>Foo Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFooValue()
   * @generated
   * @ordered
   */
  protected String fooValue = FOO_VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FooImpl()
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
    return Bug288432TestPackage.Literals.FOO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFooValue()
  {
    return fooValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFooValue(String newFooValue)
  {
    String oldFooValue = fooValue;
    fooValue = newFooValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug288432TestPackage.FOO__FOO_VALUE, oldFooValue, fooValue));
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
      case Bug288432TestPackage.FOO__FOO_VALUE:
        return getFooValue();
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
      case Bug288432TestPackage.FOO__FOO_VALUE:
        setFooValue((String)newValue);
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
      case Bug288432TestPackage.FOO__FOO_VALUE:
        setFooValue(FOO_VALUE_EDEFAULT);
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
      case Bug288432TestPackage.FOO__FOO_VALUE:
        return FOO_VALUE_EDEFAULT == null ? fooValue != null : !FOO_VALUE_EDEFAULT.equals(fooValue);
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
    result.append(" (fooValue: ");
    result.append(fooValue);
    result.append(')');
    return result.toString();
  }

} //FooImpl
