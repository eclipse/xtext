/**
 */
package org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddens;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddensCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Overriding Hiddens</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.OverridingHiddensImpl#getCalled <em>Called</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OverridingHiddensImpl extends ModelImpl implements OverridingHiddens
{
  /**
   * The cached value of the '{@link #getCalled() <em>Called</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCalled()
   * @generated
   * @ordered
   */
  protected OverridingHiddensCall called;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OverridingHiddensImpl()
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
    return HiddenTerminalsTestLanguagePackage.Literals.OVERRIDING_HIDDENS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OverridingHiddensCall getCalled()
  {
    return called;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCalled(OverridingHiddensCall newCalled, NotificationChain msgs)
  {
    OverridingHiddensCall oldCalled = called;
    called = newCalled;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS__CALLED, oldCalled, newCalled);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCalled(OverridingHiddensCall newCalled)
  {
    if (newCalled != called)
    {
      NotificationChain msgs = null;
      if (called != null)
        msgs = ((InternalEObject)called).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS__CALLED, null, msgs);
      if (newCalled != null)
        msgs = ((InternalEObject)newCalled).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS__CALLED, null, msgs);
      msgs = basicSetCalled(newCalled, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS__CALLED, newCalled, newCalled));
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
      case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS__CALLED:
        return basicSetCalled(null, msgs);
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
      case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS__CALLED:
        return getCalled();
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
      case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS__CALLED:
        setCalled((OverridingHiddensCall)newValue);
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
      case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS__CALLED:
        setCalled((OverridingHiddensCall)null);
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
      case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS__CALLED:
        return called != null;
    }
    return super.eIsSet(featureID);
  }

} //OverridingHiddensImpl
