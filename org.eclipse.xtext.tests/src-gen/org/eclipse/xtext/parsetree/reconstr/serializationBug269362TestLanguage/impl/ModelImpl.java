/**
 */
package org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.Model;
import org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.SerializationBug269362TestLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.impl.ModelImpl#getFoo <em>Foo</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.impl.ModelImpl#getBar <em>Bar</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The default value of the '{@link #getFoo() <em>Foo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFoo()
   * @generated
   * @ordered
   */
  protected static final String FOO_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFoo() <em>Foo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFoo()
   * @generated
   * @ordered
   */
  protected String foo = FOO_EDEFAULT;

  /**
   * The default value of the '{@link #getBar() <em>Bar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBar()
   * @generated
   * @ordered
   */
  protected static final String BAR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBar() <em>Bar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBar()
   * @generated
   * @ordered
   */
  protected String bar = BAR_EDEFAULT;

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
    return SerializationBug269362TestLanguagePackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFoo()
  {
    return foo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFoo(String newFoo)
  {
    String oldFoo = foo;
    foo = newFoo;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SerializationBug269362TestLanguagePackage.MODEL__FOO, oldFoo, foo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBar()
  {
    return bar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBar(String newBar)
  {
    String oldBar = bar;
    bar = newBar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SerializationBug269362TestLanguagePackage.MODEL__BAR, oldBar, bar));
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
      case SerializationBug269362TestLanguagePackage.MODEL__FOO:
        return getFoo();
      case SerializationBug269362TestLanguagePackage.MODEL__BAR:
        return getBar();
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
      case SerializationBug269362TestLanguagePackage.MODEL__FOO:
        setFoo((String)newValue);
        return;
      case SerializationBug269362TestLanguagePackage.MODEL__BAR:
        setBar((String)newValue);
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
      case SerializationBug269362TestLanguagePackage.MODEL__FOO:
        setFoo(FOO_EDEFAULT);
        return;
      case SerializationBug269362TestLanguagePackage.MODEL__BAR:
        setBar(BAR_EDEFAULT);
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
      case SerializationBug269362TestLanguagePackage.MODEL__FOO:
        return FOO_EDEFAULT == null ? foo != null : !FOO_EDEFAULT.equals(foo);
      case SerializationBug269362TestLanguagePackage.MODEL__BAR:
        return BAR_EDEFAULT == null ? bar != null : !BAR_EDEFAULT.equals(bar);
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
    result.append(" (foo: ");
    result.append(foo);
    result.append(", bar: ");
    result.append(bar);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
