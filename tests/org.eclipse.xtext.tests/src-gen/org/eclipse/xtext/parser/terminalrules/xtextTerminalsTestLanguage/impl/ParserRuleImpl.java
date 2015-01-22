/**
 */
package org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.AbstractRule;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.ParserRule;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.XtextTerminalsTestLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parser Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.impl.ParserRuleImpl#isDefinesHiddenTokens <em>Defines Hidden Tokens</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.impl.ParserRuleImpl#getHiddenTokens <em>Hidden Tokens</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParserRuleImpl extends AbstractRuleImpl implements ParserRule
{
  /**
   * The default value of the '{@link #isDefinesHiddenTokens() <em>Defines Hidden Tokens</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDefinesHiddenTokens()
   * @generated
   * @ordered
   */
  protected static final boolean DEFINES_HIDDEN_TOKENS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDefinesHiddenTokens() <em>Defines Hidden Tokens</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDefinesHiddenTokens()
   * @generated
   * @ordered
   */
  protected boolean definesHiddenTokens = DEFINES_HIDDEN_TOKENS_EDEFAULT;

  /**
   * The cached value of the '{@link #getHiddenTokens() <em>Hidden Tokens</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHiddenTokens()
   * @generated
   * @ordered
   */
  protected EList<AbstractRule> hiddenTokens;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParserRuleImpl()
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
    return XtextTerminalsTestLanguagePackage.Literals.PARSER_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDefinesHiddenTokens()
  {
    return definesHiddenTokens;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefinesHiddenTokens(boolean newDefinesHiddenTokens)
  {
    boolean oldDefinesHiddenTokens = definesHiddenTokens;
    definesHiddenTokens = newDefinesHiddenTokens;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTerminalsTestLanguagePackage.PARSER_RULE__DEFINES_HIDDEN_TOKENS, oldDefinesHiddenTokens, definesHiddenTokens));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractRule> getHiddenTokens()
  {
    if (hiddenTokens == null)
    {
      hiddenTokens = new EObjectResolvingEList<AbstractRule>(AbstractRule.class, this, XtextTerminalsTestLanguagePackage.PARSER_RULE__HIDDEN_TOKENS);
    }
    return hiddenTokens;
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
      case XtextTerminalsTestLanguagePackage.PARSER_RULE__DEFINES_HIDDEN_TOKENS:
        return isDefinesHiddenTokens();
      case XtextTerminalsTestLanguagePackage.PARSER_RULE__HIDDEN_TOKENS:
        return getHiddenTokens();
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
      case XtextTerminalsTestLanguagePackage.PARSER_RULE__DEFINES_HIDDEN_TOKENS:
        setDefinesHiddenTokens((Boolean)newValue);
        return;
      case XtextTerminalsTestLanguagePackage.PARSER_RULE__HIDDEN_TOKENS:
        getHiddenTokens().clear();
        getHiddenTokens().addAll((Collection<? extends AbstractRule>)newValue);
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
      case XtextTerminalsTestLanguagePackage.PARSER_RULE__DEFINES_HIDDEN_TOKENS:
        setDefinesHiddenTokens(DEFINES_HIDDEN_TOKENS_EDEFAULT);
        return;
      case XtextTerminalsTestLanguagePackage.PARSER_RULE__HIDDEN_TOKENS:
        getHiddenTokens().clear();
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
      case XtextTerminalsTestLanguagePackage.PARSER_RULE__DEFINES_HIDDEN_TOKENS:
        return definesHiddenTokens != DEFINES_HIDDEN_TOKENS_EDEFAULT;
      case XtextTerminalsTestLanguagePackage.PARSER_RULE__HIDDEN_TOKENS:
        return hiddenTokens != null && !hiddenTokens.isEmpty();
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
    result.append(" (definesHiddenTokens: ");
    result.append(definesHiddenTokens);
    result.append(')');
    return result.toString();
  }

} //ParserRuleImpl
