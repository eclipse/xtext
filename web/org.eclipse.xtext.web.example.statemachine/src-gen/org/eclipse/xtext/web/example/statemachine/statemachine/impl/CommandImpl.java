/**
 */
package org.eclipse.xtext.web.example.statemachine.statemachine.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.web.example.statemachine.statemachine.Command;
import org.eclipse.xtext.web.example.statemachine.statemachine.Signal;
import org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.CommandImpl#getSignal <em>Signal</em>}</li>
 *   <li>{@link org.eclipse.xtext.web.example.statemachine.statemachine.impl.CommandImpl#isNewState <em>New State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CommandImpl extends MinimalEObjectImpl.Container implements Command
{
  /**
   * The cached value of the '{@link #getSignal() <em>Signal</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSignal()
   * @generated
   * @ordered
   */
  protected Signal signal;

  /**
   * The default value of the '{@link #isNewState() <em>New State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNewState()
   * @generated
   * @ordered
   */
  protected static final boolean NEW_STATE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNewState() <em>New State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNewState()
   * @generated
   * @ordered
   */
  protected boolean newState = NEW_STATE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CommandImpl()
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
    return StatemachinePackage.Literals.COMMAND;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Signal getSignal()
  {
    if (signal != null && signal.eIsProxy())
    {
      InternalEObject oldSignal = (InternalEObject)signal;
      signal = (Signal)eResolveProxy(oldSignal);
      if (signal != oldSignal)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, StatemachinePackage.COMMAND__SIGNAL, oldSignal, signal));
      }
    }
    return signal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Signal basicGetSignal()
  {
    return signal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSignal(Signal newSignal)
  {
    Signal oldSignal = signal;
    signal = newSignal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StatemachinePackage.COMMAND__SIGNAL, oldSignal, signal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isNewState()
  {
    return newState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNewState(boolean newNewState)
  {
    boolean oldNewState = newState;
    newState = newNewState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StatemachinePackage.COMMAND__NEW_STATE, oldNewState, newState));
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
      case StatemachinePackage.COMMAND__SIGNAL:
        if (resolve) return getSignal();
        return basicGetSignal();
      case StatemachinePackage.COMMAND__NEW_STATE:
        return isNewState();
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
      case StatemachinePackage.COMMAND__SIGNAL:
        setSignal((Signal)newValue);
        return;
      case StatemachinePackage.COMMAND__NEW_STATE:
        setNewState((Boolean)newValue);
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
      case StatemachinePackage.COMMAND__SIGNAL:
        setSignal((Signal)null);
        return;
      case StatemachinePackage.COMMAND__NEW_STATE:
        setNewState(NEW_STATE_EDEFAULT);
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
      case StatemachinePackage.COMMAND__SIGNAL:
        return signal != null;
      case StatemachinePackage.COMMAND__NEW_STATE:
        return newState != NEW_STATE_EDEFAULT;
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
    result.append(" (newState: ");
    result.append(newState);
    result.append(')');
    return result.toString();
  }

} //CommandImpl
