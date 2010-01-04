/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.fowlerdsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.example.fowlerdsl.Event;
import org.eclipse.xtext.example.fowlerdsl.FowlerdslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.fowlerdsl.impl.EventImpl#isResetting <em>Resetting</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.fowlerdsl.impl.EventImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.fowlerdsl.impl.EventImpl#getCode <em>Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventImpl extends MinimalEObjectImpl.Container implements Event
{
  /**
   * The default value of the '{@link #isResetting() <em>Resetting</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isResetting()
   * @generated
   * @ordered
   */
  protected static final boolean RESETTING_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isResetting() <em>Resetting</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isResetting()
   * @generated
   * @ordered
   */
  protected boolean resetting = RESETTING_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getCode() <em>Code</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCode()
   * @generated
   * @ordered
   */
  protected static final String CODE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCode() <em>Code</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCode()
   * @generated
   * @ordered
   */
  protected String code = CODE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EventImpl()
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
    return FowlerdslPackage.Literals.EVENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isResetting()
  {
    return resetting;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResetting(boolean newResetting)
  {
    boolean oldResetting = resetting;
    resetting = newResetting;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FowlerdslPackage.EVENT__RESETTING, oldResetting, resetting));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FowlerdslPackage.EVENT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCode()
  {
    return code;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCode(String newCode)
  {
    String oldCode = code;
    code = newCode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FowlerdslPackage.EVENT__CODE, oldCode, code));
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
      case FowlerdslPackage.EVENT__RESETTING:
        return isResetting();
      case FowlerdslPackage.EVENT__NAME:
        return getName();
      case FowlerdslPackage.EVENT__CODE:
        return getCode();
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
      case FowlerdslPackage.EVENT__RESETTING:
        setResetting((Boolean)newValue);
        return;
      case FowlerdslPackage.EVENT__NAME:
        setName((String)newValue);
        return;
      case FowlerdslPackage.EVENT__CODE:
        setCode((String)newValue);
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
      case FowlerdslPackage.EVENT__RESETTING:
        setResetting(RESETTING_EDEFAULT);
        return;
      case FowlerdslPackage.EVENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case FowlerdslPackage.EVENT__CODE:
        setCode(CODE_EDEFAULT);
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
      case FowlerdslPackage.EVENT__RESETTING:
        return resetting != RESETTING_EDEFAULT;
      case FowlerdslPackage.EVENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case FowlerdslPackage.EVENT__CODE:
        return CODE_EDEFAULT == null ? code != null : !CODE_EDEFAULT.equals(code);
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
    result.append(" (resetting: ");
    result.append(resetting);
    result.append(", name: ");
    result.append(name);
    result.append(", code: ");
    result.append(code);
    result.append(')');
    return result.toString();
  }

} //EventImpl
