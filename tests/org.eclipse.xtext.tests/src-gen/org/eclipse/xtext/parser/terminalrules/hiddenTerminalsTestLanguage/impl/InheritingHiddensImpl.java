/**
 */
package org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HidingHiddens;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddens;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddensCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inheriting Hiddens</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.InheritingHiddensImpl#getCalled <em>Called</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.InheritingHiddensImpl#getHidingCalled <em>Hiding Called</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InheritingHiddensImpl extends ModelImpl implements InheritingHiddens
{
  /**
   * The cached value of the '{@link #getCalled() <em>Called</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCalled()
   * @generated
   * @ordered
   */
  protected InheritingHiddensCall called;

  /**
   * The cached value of the '{@link #getHidingCalled() <em>Hiding Called</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHidingCalled()
   * @generated
   * @ordered
   */
  protected HidingHiddens hidingCalled;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InheritingHiddensImpl()
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
    return HiddenTerminalsTestLanguagePackage.Literals.INHERITING_HIDDENS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InheritingHiddensCall getCalled()
  {
    return called;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCalled(InheritingHiddensCall newCalled, NotificationChain msgs)
  {
    InheritingHiddensCall oldCalled = called;
    called = newCalled;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__CALLED, oldCalled, newCalled);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCalled(InheritingHiddensCall newCalled)
  {
    if (newCalled != called)
    {
      NotificationChain msgs = null;
      if (called != null)
        msgs = ((InternalEObject)called).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__CALLED, null, msgs);
      if (newCalled != null)
        msgs = ((InternalEObject)newCalled).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__CALLED, null, msgs);
      msgs = basicSetCalled(newCalled, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__CALLED, newCalled, newCalled));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HidingHiddens getHidingCalled()
  {
    return hidingCalled;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetHidingCalled(HidingHiddens newHidingCalled, NotificationChain msgs)
  {
    HidingHiddens oldHidingCalled = hidingCalled;
    hidingCalled = newHidingCalled;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__HIDING_CALLED, oldHidingCalled, newHidingCalled);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHidingCalled(HidingHiddens newHidingCalled)
  {
    if (newHidingCalled != hidingCalled)
    {
      NotificationChain msgs = null;
      if (hidingCalled != null)
        msgs = ((InternalEObject)hidingCalled).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__HIDING_CALLED, null, msgs);
      if (newHidingCalled != null)
        msgs = ((InternalEObject)newHidingCalled).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__HIDING_CALLED, null, msgs);
      msgs = basicSetHidingCalled(newHidingCalled, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__HIDING_CALLED, newHidingCalled, newHidingCalled));
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
      case HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__CALLED:
        return basicSetCalled(null, msgs);
      case HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__HIDING_CALLED:
        return basicSetHidingCalled(null, msgs);
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
      case HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__CALLED:
        return getCalled();
      case HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__HIDING_CALLED:
        return getHidingCalled();
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
      case HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__CALLED:
        setCalled((InheritingHiddensCall)newValue);
        return;
      case HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__HIDING_CALLED:
        setHidingCalled((HidingHiddens)newValue);
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
      case HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__CALLED:
        setCalled((InheritingHiddensCall)null);
        return;
      case HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__HIDING_CALLED:
        setHidingCalled((HidingHiddens)null);
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
      case HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__CALLED:
        return called != null;
      case HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS__HIDING_CALLED:
        return hidingCalled != null;
    }
    return super.eIsSet(featureID);
  }

} //InheritingHiddensImpl
