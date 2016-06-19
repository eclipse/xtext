/**
 */
package org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Bar;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.EObjectAtOffsetTestLanguagePackage;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.FooBar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Foo Bar</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.FooBarImpl#getBar <em>Bar</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FooBarImpl extends AbstractBarImpl implements FooBar
{
  /**
   * The cached value of the '{@link #getBar() <em>Bar</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBar()
   * @generated
   * @ordered
   */
  protected Bar bar;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FooBarImpl()
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
    return EObjectAtOffsetTestLanguagePackage.Literals.FOO_BAR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bar getBar()
  {
    return bar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBar(Bar newBar, NotificationChain msgs)
  {
    Bar oldBar = bar;
    bar = newBar;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EObjectAtOffsetTestLanguagePackage.FOO_BAR__BAR, oldBar, newBar);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBar(Bar newBar)
  {
    if (newBar != bar)
    {
      NotificationChain msgs = null;
      if (bar != null)
        msgs = ((InternalEObject)bar).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EObjectAtOffsetTestLanguagePackage.FOO_BAR__BAR, null, msgs);
      if (newBar != null)
        msgs = ((InternalEObject)newBar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EObjectAtOffsetTestLanguagePackage.FOO_BAR__BAR, null, msgs);
      msgs = basicSetBar(newBar, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EObjectAtOffsetTestLanguagePackage.FOO_BAR__BAR, newBar, newBar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case EObjectAtOffsetTestLanguagePackage.FOO_BAR__BAR:
        return basicSetBar(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case EObjectAtOffsetTestLanguagePackage.FOO_BAR__BAR:
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
      case EObjectAtOffsetTestLanguagePackage.FOO_BAR__BAR:
        setBar((Bar)newValue);
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
      case EObjectAtOffsetTestLanguagePackage.FOO_BAR__BAR:
        setBar((Bar)null);
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
      case EObjectAtOffsetTestLanguagePackage.FOO_BAR__BAR:
        return bar != null;
    }
    return super.eIsSet(featureID);
  }

} //FooBarImpl
