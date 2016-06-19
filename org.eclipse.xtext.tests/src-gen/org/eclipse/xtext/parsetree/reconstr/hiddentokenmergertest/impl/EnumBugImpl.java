/**
 */
package org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBug;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBugEnum;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Bug</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.EnumBugImpl#getReturn <em>Return</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.EnumBugImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumBugImpl extends ModelImpl implements EnumBug
{
  /**
   * The default value of the '{@link #getReturn() <em>Return</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturn()
   * @generated
   * @ordered
   */
  protected static final EnumBugEnum RETURN_EDEFAULT = EnumBugEnum.ARRAY;

  /**
   * The cached value of the '{@link #getReturn() <em>Return</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturn()
   * @generated
   * @ordered
   */
  protected EnumBugEnum return_ = RETURN_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumBugImpl()
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
    return HiddentokenmergertestPackage.Literals.ENUM_BUG;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumBugEnum getReturn()
  {
    return return_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReturn(EnumBugEnum newReturn)
  {
    EnumBugEnum oldReturn = return_;
    return_ = newReturn == null ? RETURN_EDEFAULT : newReturn;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HiddentokenmergertestPackage.ENUM_BUG__RETURN, oldReturn, return_));
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
      eNotify(new ENotificationImpl(this, Notification.SET, HiddentokenmergertestPackage.ENUM_BUG__NAME, oldName, name));
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
      case HiddentokenmergertestPackage.ENUM_BUG__RETURN:
        return getReturn();
      case HiddentokenmergertestPackage.ENUM_BUG__NAME:
        return getName();
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
      case HiddentokenmergertestPackage.ENUM_BUG__RETURN:
        setReturn((EnumBugEnum)newValue);
        return;
      case HiddentokenmergertestPackage.ENUM_BUG__NAME:
        setName((String)newValue);
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
      case HiddentokenmergertestPackage.ENUM_BUG__RETURN:
        setReturn(RETURN_EDEFAULT);
        return;
      case HiddentokenmergertestPackage.ENUM_BUG__NAME:
        setName(NAME_EDEFAULT);
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
      case HiddentokenmergertestPackage.ENUM_BUG__RETURN:
        return return_ != RETURN_EDEFAULT;
      case HiddentokenmergertestPackage.ENUM_BUG__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
    result.append(" (return: ");
    result.append(return_);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //EnumBugImpl
