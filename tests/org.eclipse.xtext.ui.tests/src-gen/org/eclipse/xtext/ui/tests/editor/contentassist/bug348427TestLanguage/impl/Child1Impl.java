/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Bug348427TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child1;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.EnumType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Child1Impl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Child1Impl#isBool <em>Bool</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Child1Impl#getEnumType <em>Enum Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Child1Impl extends MinimalEObjectImpl.Container implements Child1
{
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
   * The default value of the '{@link #isBool() <em>Bool</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBool()
   * @generated
   * @ordered
   */
  protected static final boolean BOOL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isBool() <em>Bool</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBool()
   * @generated
   * @ordered
   */
  protected boolean bool = BOOL_EDEFAULT;

  /**
   * The default value of the '{@link #getEnumType() <em>Enum Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumType()
   * @generated
   * @ordered
   */
  protected static final EnumType ENUM_TYPE_EDEFAULT = EnumType.A;

  /**
   * The cached value of the '{@link #getEnumType() <em>Enum Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumType()
   * @generated
   * @ordered
   */
  protected EnumType enumType = ENUM_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Child1Impl()
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
    return Bug348427TestLanguagePackage.Literals.CHILD1;
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
      eNotify(new ENotificationImpl(this, Notification.SET, Bug348427TestLanguagePackage.CHILD1__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isBool()
  {
    return bool;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBool(boolean newBool)
  {
    boolean oldBool = bool;
    bool = newBool;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug348427TestLanguagePackage.CHILD1__BOOL, oldBool, bool));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumType getEnumType()
  {
    return enumType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnumType(EnumType newEnumType)
  {
    EnumType oldEnumType = enumType;
    enumType = newEnumType == null ? ENUM_TYPE_EDEFAULT : newEnumType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug348427TestLanguagePackage.CHILD1__ENUM_TYPE, oldEnumType, enumType));
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
      case Bug348427TestLanguagePackage.CHILD1__NAME:
        return getName();
      case Bug348427TestLanguagePackage.CHILD1__BOOL:
        return isBool();
      case Bug348427TestLanguagePackage.CHILD1__ENUM_TYPE:
        return getEnumType();
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
      case Bug348427TestLanguagePackage.CHILD1__NAME:
        setName((String)newValue);
        return;
      case Bug348427TestLanguagePackage.CHILD1__BOOL:
        setBool((Boolean)newValue);
        return;
      case Bug348427TestLanguagePackage.CHILD1__ENUM_TYPE:
        setEnumType((EnumType)newValue);
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
      case Bug348427TestLanguagePackage.CHILD1__NAME:
        setName(NAME_EDEFAULT);
        return;
      case Bug348427TestLanguagePackage.CHILD1__BOOL:
        setBool(BOOL_EDEFAULT);
        return;
      case Bug348427TestLanguagePackage.CHILD1__ENUM_TYPE:
        setEnumType(ENUM_TYPE_EDEFAULT);
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
      case Bug348427TestLanguagePackage.CHILD1__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case Bug348427TestLanguagePackage.CHILD1__BOOL:
        return bool != BOOL_EDEFAULT;
      case Bug348427TestLanguagePackage.CHILD1__ENUM_TYPE:
        return enumType != ENUM_TYPE_EDEFAULT;
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
    result.append(" (name: ");
    result.append(name);
    result.append(", bool: ");
    result.append(bool);
    result.append(", enumType: ");
    result.append(enumType);
    result.append(')');
    return result.toString();
  }

} //Child1Impl
