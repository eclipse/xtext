/**
 */
package org.eclipse.xtext.parser.terminalrules.terminalRulesTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parser.terminalrules.terminalRulesTestLanguage.Model;
import org.eclipse.xtext.parser.terminalrules.terminalRulesTestLanguage.TerminalRulesTestLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.terminalRulesTestLanguage.impl.ModelImpl#getIdValue <em>Id Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.terminalRulesTestLanguage.impl.ModelImpl#getIntValue <em>Int Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.terminalRulesTestLanguage.impl.ModelImpl#getStringValue <em>String Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.terminalRulesTestLanguage.impl.ModelImpl#getRichStringValue <em>Rich String Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.terminalRulesTestLanguage.impl.ModelImpl#getMlCommentValue <em>Ml Comment Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.terminalRulesTestLanguage.impl.ModelImpl#getSlCommentValue <em>Sl Comment Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.terminalRulesTestLanguage.impl.ModelImpl#getWsValue <em>Ws Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.terminalRulesTestLanguage.impl.ModelImpl#getAnyValue <em>Any Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The default value of the '{@link #getIdValue() <em>Id Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIdValue()
   * @generated
   * @ordered
   */
  protected static final String ID_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIdValue() <em>Id Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIdValue()
   * @generated
   * @ordered
   */
  protected String idValue = ID_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getIntValue() <em>Int Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntValue()
   * @generated
   * @ordered
   */
  protected static final String INT_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIntValue() <em>Int Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntValue()
   * @generated
   * @ordered
   */
  protected String intValue = INT_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getStringValue() <em>String Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStringValue()
   * @generated
   * @ordered
   */
  protected static final String STRING_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStringValue() <em>String Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStringValue()
   * @generated
   * @ordered
   */
  protected String stringValue = STRING_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getRichStringValue() <em>Rich String Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRichStringValue()
   * @generated
   * @ordered
   */
  protected static final String RICH_STRING_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRichStringValue() <em>Rich String Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRichStringValue()
   * @generated
   * @ordered
   */
  protected String richStringValue = RICH_STRING_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getMlCommentValue() <em>Ml Comment Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMlCommentValue()
   * @generated
   * @ordered
   */
  protected static final String ML_COMMENT_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMlCommentValue() <em>Ml Comment Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMlCommentValue()
   * @generated
   * @ordered
   */
  protected String mlCommentValue = ML_COMMENT_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getSlCommentValue() <em>Sl Comment Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSlCommentValue()
   * @generated
   * @ordered
   */
  protected static final String SL_COMMENT_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSlCommentValue() <em>Sl Comment Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSlCommentValue()
   * @generated
   * @ordered
   */
  protected String slCommentValue = SL_COMMENT_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getWsValue() <em>Ws Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWsValue()
   * @generated
   * @ordered
   */
  protected static final String WS_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getWsValue() <em>Ws Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWsValue()
   * @generated
   * @ordered
   */
  protected String wsValue = WS_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getAnyValue() <em>Any Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnyValue()
   * @generated
   * @ordered
   */
  protected static final String ANY_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAnyValue() <em>Any Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnyValue()
   * @generated
   * @ordered
   */
  protected String anyValue = ANY_VALUE_EDEFAULT;

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
    return TerminalRulesTestLanguagePackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getIdValue()
  {
    return idValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIdValue(String newIdValue)
  {
    String oldIdValue = idValue;
    idValue = newIdValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TerminalRulesTestLanguagePackage.MODEL__ID_VALUE, oldIdValue, idValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getIntValue()
  {
    return intValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIntValue(String newIntValue)
  {
    String oldIntValue = intValue;
    intValue = newIntValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TerminalRulesTestLanguagePackage.MODEL__INT_VALUE, oldIntValue, intValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStringValue()
  {
    return stringValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStringValue(String newStringValue)
  {
    String oldStringValue = stringValue;
    stringValue = newStringValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TerminalRulesTestLanguagePackage.MODEL__STRING_VALUE, oldStringValue, stringValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRichStringValue()
  {
    return richStringValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRichStringValue(String newRichStringValue)
  {
    String oldRichStringValue = richStringValue;
    richStringValue = newRichStringValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TerminalRulesTestLanguagePackage.MODEL__RICH_STRING_VALUE, oldRichStringValue, richStringValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMlCommentValue()
  {
    return mlCommentValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMlCommentValue(String newMlCommentValue)
  {
    String oldMlCommentValue = mlCommentValue;
    mlCommentValue = newMlCommentValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TerminalRulesTestLanguagePackage.MODEL__ML_COMMENT_VALUE, oldMlCommentValue, mlCommentValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSlCommentValue()
  {
    return slCommentValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSlCommentValue(String newSlCommentValue)
  {
    String oldSlCommentValue = slCommentValue;
    slCommentValue = newSlCommentValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TerminalRulesTestLanguagePackage.MODEL__SL_COMMENT_VALUE, oldSlCommentValue, slCommentValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getWsValue()
  {
    return wsValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWsValue(String newWsValue)
  {
    String oldWsValue = wsValue;
    wsValue = newWsValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TerminalRulesTestLanguagePackage.MODEL__WS_VALUE, oldWsValue, wsValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAnyValue()
  {
    return anyValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnyValue(String newAnyValue)
  {
    String oldAnyValue = anyValue;
    anyValue = newAnyValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TerminalRulesTestLanguagePackage.MODEL__ANY_VALUE, oldAnyValue, anyValue));
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
      case TerminalRulesTestLanguagePackage.MODEL__ID_VALUE:
        return getIdValue();
      case TerminalRulesTestLanguagePackage.MODEL__INT_VALUE:
        return getIntValue();
      case TerminalRulesTestLanguagePackage.MODEL__STRING_VALUE:
        return getStringValue();
      case TerminalRulesTestLanguagePackage.MODEL__RICH_STRING_VALUE:
        return getRichStringValue();
      case TerminalRulesTestLanguagePackage.MODEL__ML_COMMENT_VALUE:
        return getMlCommentValue();
      case TerminalRulesTestLanguagePackage.MODEL__SL_COMMENT_VALUE:
        return getSlCommentValue();
      case TerminalRulesTestLanguagePackage.MODEL__WS_VALUE:
        return getWsValue();
      case TerminalRulesTestLanguagePackage.MODEL__ANY_VALUE:
        return getAnyValue();
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
      case TerminalRulesTestLanguagePackage.MODEL__ID_VALUE:
        setIdValue((String)newValue);
        return;
      case TerminalRulesTestLanguagePackage.MODEL__INT_VALUE:
        setIntValue((String)newValue);
        return;
      case TerminalRulesTestLanguagePackage.MODEL__STRING_VALUE:
        setStringValue((String)newValue);
        return;
      case TerminalRulesTestLanguagePackage.MODEL__RICH_STRING_VALUE:
        setRichStringValue((String)newValue);
        return;
      case TerminalRulesTestLanguagePackage.MODEL__ML_COMMENT_VALUE:
        setMlCommentValue((String)newValue);
        return;
      case TerminalRulesTestLanguagePackage.MODEL__SL_COMMENT_VALUE:
        setSlCommentValue((String)newValue);
        return;
      case TerminalRulesTestLanguagePackage.MODEL__WS_VALUE:
        setWsValue((String)newValue);
        return;
      case TerminalRulesTestLanguagePackage.MODEL__ANY_VALUE:
        setAnyValue((String)newValue);
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
      case TerminalRulesTestLanguagePackage.MODEL__ID_VALUE:
        setIdValue(ID_VALUE_EDEFAULT);
        return;
      case TerminalRulesTestLanguagePackage.MODEL__INT_VALUE:
        setIntValue(INT_VALUE_EDEFAULT);
        return;
      case TerminalRulesTestLanguagePackage.MODEL__STRING_VALUE:
        setStringValue(STRING_VALUE_EDEFAULT);
        return;
      case TerminalRulesTestLanguagePackage.MODEL__RICH_STRING_VALUE:
        setRichStringValue(RICH_STRING_VALUE_EDEFAULT);
        return;
      case TerminalRulesTestLanguagePackage.MODEL__ML_COMMENT_VALUE:
        setMlCommentValue(ML_COMMENT_VALUE_EDEFAULT);
        return;
      case TerminalRulesTestLanguagePackage.MODEL__SL_COMMENT_VALUE:
        setSlCommentValue(SL_COMMENT_VALUE_EDEFAULT);
        return;
      case TerminalRulesTestLanguagePackage.MODEL__WS_VALUE:
        setWsValue(WS_VALUE_EDEFAULT);
        return;
      case TerminalRulesTestLanguagePackage.MODEL__ANY_VALUE:
        setAnyValue(ANY_VALUE_EDEFAULT);
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
      case TerminalRulesTestLanguagePackage.MODEL__ID_VALUE:
        return ID_VALUE_EDEFAULT == null ? idValue != null : !ID_VALUE_EDEFAULT.equals(idValue);
      case TerminalRulesTestLanguagePackage.MODEL__INT_VALUE:
        return INT_VALUE_EDEFAULT == null ? intValue != null : !INT_VALUE_EDEFAULT.equals(intValue);
      case TerminalRulesTestLanguagePackage.MODEL__STRING_VALUE:
        return STRING_VALUE_EDEFAULT == null ? stringValue != null : !STRING_VALUE_EDEFAULT.equals(stringValue);
      case TerminalRulesTestLanguagePackage.MODEL__RICH_STRING_VALUE:
        return RICH_STRING_VALUE_EDEFAULT == null ? richStringValue != null : !RICH_STRING_VALUE_EDEFAULT.equals(richStringValue);
      case TerminalRulesTestLanguagePackage.MODEL__ML_COMMENT_VALUE:
        return ML_COMMENT_VALUE_EDEFAULT == null ? mlCommentValue != null : !ML_COMMENT_VALUE_EDEFAULT.equals(mlCommentValue);
      case TerminalRulesTestLanguagePackage.MODEL__SL_COMMENT_VALUE:
        return SL_COMMENT_VALUE_EDEFAULT == null ? slCommentValue != null : !SL_COMMENT_VALUE_EDEFAULT.equals(slCommentValue);
      case TerminalRulesTestLanguagePackage.MODEL__WS_VALUE:
        return WS_VALUE_EDEFAULT == null ? wsValue != null : !WS_VALUE_EDEFAULT.equals(wsValue);
      case TerminalRulesTestLanguagePackage.MODEL__ANY_VALUE:
        return ANY_VALUE_EDEFAULT == null ? anyValue != null : !ANY_VALUE_EDEFAULT.equals(anyValue);
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
    result.append(" (idValue: ");
    result.append(idValue);
    result.append(", intValue: ");
    result.append(intValue);
    result.append(", stringValue: ");
    result.append(stringValue);
    result.append(", richStringValue: ");
    result.append(richStringValue);
    result.append(", mlCommentValue: ");
    result.append(mlCommentValue);
    result.append(", slCommentValue: ");
    result.append(slCommentValue);
    result.append(", wsValue: ");
    result.append(wsValue);
    result.append(", anyValue: ");
    result.append(anyValue);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
