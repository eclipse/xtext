/**
 */
package org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HidingHiddens;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddensCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hiding Hiddens</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HidingHiddensImpl#getSpace <em>Space</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HidingHiddensImpl#getCalled <em>Called</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HidingHiddensImpl extends MinimalEObjectImpl.Container implements HidingHiddens
{
  /**
   * The default value of the '{@link #getSpace() <em>Space</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpace()
   * @generated
   * @ordered
   */
  protected static final String SPACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSpace() <em>Space</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpace()
   * @generated
   * @ordered
   */
  protected String space = SPACE_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HidingHiddensImpl()
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
    return HiddenTerminalsTestLanguagePackage.Literals.HIDING_HIDDENS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSpace()
  {
    return space;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpace(String newSpace)
  {
    String oldSpace = space;
    space = newSpace;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HiddenTerminalsTestLanguagePackage.HIDING_HIDDENS__SPACE, oldSpace, space));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HiddenTerminalsTestLanguagePackage.HIDING_HIDDENS__CALLED, oldCalled, newCalled);
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
        msgs = ((InternalEObject)called).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HiddenTerminalsTestLanguagePackage.HIDING_HIDDENS__CALLED, null, msgs);
      if (newCalled != null)
        msgs = ((InternalEObject)newCalled).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HiddenTerminalsTestLanguagePackage.HIDING_HIDDENS__CALLED, null, msgs);
      msgs = basicSetCalled(newCalled, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HiddenTerminalsTestLanguagePackage.HIDING_HIDDENS__CALLED, newCalled, newCalled));
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
      case HiddenTerminalsTestLanguagePackage.HIDING_HIDDENS__CALLED:
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
      case HiddenTerminalsTestLanguagePackage.HIDING_HIDDENS__SPACE:
        return getSpace();
      case HiddenTerminalsTestLanguagePackage.HIDING_HIDDENS__CALLED:
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
      case HiddenTerminalsTestLanguagePackage.HIDING_HIDDENS__SPACE:
        setSpace((String)newValue);
        return;
      case HiddenTerminalsTestLanguagePackage.HIDING_HIDDENS__CALLED:
        setCalled((InheritingHiddensCall)newValue);
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
      case HiddenTerminalsTestLanguagePackage.HIDING_HIDDENS__SPACE:
        setSpace(SPACE_EDEFAULT);
        return;
      case HiddenTerminalsTestLanguagePackage.HIDING_HIDDENS__CALLED:
        setCalled((InheritingHiddensCall)null);
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
      case HiddenTerminalsTestLanguagePackage.HIDING_HIDDENS__SPACE:
        return SPACE_EDEFAULT == null ? space != null : !SPACE_EDEFAULT.equals(space);
      case HiddenTerminalsTestLanguagePackage.HIDING_HIDDENS__CALLED:
        return called != null;
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
    result.append(" (space: ");
    result.append(space);
    result.append(')');
    return result.toString();
  }

} //HidingHiddensImpl
