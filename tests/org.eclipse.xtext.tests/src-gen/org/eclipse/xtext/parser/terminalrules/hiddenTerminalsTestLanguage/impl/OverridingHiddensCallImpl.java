/**
 */
package org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddensCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Overriding Hiddens Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.OverridingHiddensCallImpl#getSpaces <em>Spaces</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.OverridingHiddensCallImpl#isValid <em>Valid</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OverridingHiddensCallImpl extends MinimalEObjectImpl.Container implements OverridingHiddensCall
{
  /**
   * The cached value of the '{@link #getSpaces() <em>Spaces</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpaces()
   * @generated
   * @ordered
   */
  protected EList<String> spaces;

  /**
   * The default value of the '{@link #isValid() <em>Valid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isValid()
   * @generated
   * @ordered
   */
  protected static final boolean VALID_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isValid() <em>Valid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isValid()
   * @generated
   * @ordered
   */
  protected boolean valid = VALID_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OverridingHiddensCallImpl()
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
    return HiddenTerminalsTestLanguagePackage.Literals.OVERRIDING_HIDDENS_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getSpaces()
  {
    if (spaces == null)
    {
      spaces = new EDataTypeEList<String>(String.class, this, HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS_CALL__SPACES);
    }
    return spaces;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isValid()
  {
    return valid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValid(boolean newValid)
  {
    boolean oldValid = valid;
    valid = newValid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS_CALL__VALID, oldValid, valid));
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
      case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS_CALL__SPACES:
        return getSpaces();
      case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS_CALL__VALID:
        return isValid();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS_CALL__SPACES:
        getSpaces().clear();
        getSpaces().addAll((Collection<? extends String>)newValue);
        return;
      case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS_CALL__VALID:
        setValid((Boolean)newValue);
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
      case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS_CALL__SPACES:
        getSpaces().clear();
        return;
      case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS_CALL__VALID:
        setValid(VALID_EDEFAULT);
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
      case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS_CALL__SPACES:
        return spaces != null && !spaces.isEmpty();
      case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS_CALL__VALID:
        return valid != VALID_EDEFAULT;
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
    result.append(" (spaces: ");
    result.append(spaces);
    result.append(", valid: ");
    result.append(valid);
    result.append(')');
    return result.toString();
  }

} //OverridingHiddensCallImpl
