/**
 * <copyright>
 * </copyright>
 *
 * $Id: ParserRuleImpl.java,v 1.5 2009/02/19 21:09:44 sefftinge Exp $
 */
package org.eclipse.xtext.xtextTest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.xtext.xtextTest.AbstractElement;
import org.eclipse.xtext.xtextTest.AbstractRule;
import org.eclipse.xtext.xtextTest.ParserRule;
import org.eclipse.xtext.xtextTest.XtextTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parser Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.ParserRuleImpl#isDefinesHiddenTokens <em>Defines Hidden Tokens</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.ParserRuleImpl#getHiddenTokens <em>Hidden Tokens</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.ParserRuleImpl#getAlternatives <em>Alternatives</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.ParserRuleImpl#isTerminal <em>Terminal</em>}</li>
 * </ul>
 * </p>
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
   * The cached value of the '{@link #getAlternatives() <em>Alternatives</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlternatives()
   * @generated
   * @ordered
   */
  protected AbstractElement alternatives;

  /**
   * The default value of the '{@link #isTerminal() <em>Terminal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTerminal()
   * @generated
   * @ordered
   */
  protected static final boolean TERMINAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isTerminal() <em>Terminal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTerminal()
   * @generated
   * @ordered
   */
  protected boolean terminal = TERMINAL_EDEFAULT;

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
    return XtextTestPackage.Literals.PARSER_RULE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.PARSER_RULE__DEFINES_HIDDEN_TOKENS, oldDefinesHiddenTokens, definesHiddenTokens));
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
      hiddenTokens = new EObjectResolvingEList<AbstractRule>(AbstractRule.class, this, XtextTestPackage.PARSER_RULE__HIDDEN_TOKENS);
    }
    return hiddenTokens;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractElement getAlternatives()
  {
    return alternatives;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAlternatives(AbstractElement newAlternatives, NotificationChain msgs)
  {
    AbstractElement oldAlternatives = alternatives;
    alternatives = newAlternatives;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextTestPackage.PARSER_RULE__ALTERNATIVES, oldAlternatives, newAlternatives);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAlternatives(AbstractElement newAlternatives)
  {
    if (newAlternatives != alternatives)
    {
      NotificationChain msgs = null;
      if (alternatives != null)
        msgs = ((InternalEObject)alternatives).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.PARSER_RULE__ALTERNATIVES, null, msgs);
      if (newAlternatives != null)
        msgs = ((InternalEObject)newAlternatives).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.PARSER_RULE__ALTERNATIVES, null, msgs);
      msgs = basicSetAlternatives(newAlternatives, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.PARSER_RULE__ALTERNATIVES, newAlternatives, newAlternatives));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isTerminal()
  {
    return terminal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTerminal(boolean newTerminal)
  {
    boolean oldTerminal = terminal;
    terminal = newTerminal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.PARSER_RULE__TERMINAL, oldTerminal, terminal));
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
      case XtextTestPackage.PARSER_RULE__ALTERNATIVES:
        return basicSetAlternatives(null, msgs);
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
      case XtextTestPackage.PARSER_RULE__DEFINES_HIDDEN_TOKENS:
        return isDefinesHiddenTokens();
      case XtextTestPackage.PARSER_RULE__HIDDEN_TOKENS:
        return getHiddenTokens();
      case XtextTestPackage.PARSER_RULE__ALTERNATIVES:
        return getAlternatives();
      case XtextTestPackage.PARSER_RULE__TERMINAL:
        return isTerminal();
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
      case XtextTestPackage.PARSER_RULE__DEFINES_HIDDEN_TOKENS:
        setDefinesHiddenTokens((Boolean)newValue);
        return;
      case XtextTestPackage.PARSER_RULE__HIDDEN_TOKENS:
        getHiddenTokens().clear();
        getHiddenTokens().addAll((Collection<? extends AbstractRule>)newValue);
        return;
      case XtextTestPackage.PARSER_RULE__ALTERNATIVES:
        setAlternatives((AbstractElement)newValue);
        return;
      case XtextTestPackage.PARSER_RULE__TERMINAL:
        setTerminal((Boolean)newValue);
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
      case XtextTestPackage.PARSER_RULE__DEFINES_HIDDEN_TOKENS:
        setDefinesHiddenTokens(DEFINES_HIDDEN_TOKENS_EDEFAULT);
        return;
      case XtextTestPackage.PARSER_RULE__HIDDEN_TOKENS:
        getHiddenTokens().clear();
        return;
      case XtextTestPackage.PARSER_RULE__ALTERNATIVES:
        setAlternatives((AbstractElement)null);
        return;
      case XtextTestPackage.PARSER_RULE__TERMINAL:
        setTerminal(TERMINAL_EDEFAULT);
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
      case XtextTestPackage.PARSER_RULE__DEFINES_HIDDEN_TOKENS:
        return definesHiddenTokens != DEFINES_HIDDEN_TOKENS_EDEFAULT;
      case XtextTestPackage.PARSER_RULE__HIDDEN_TOKENS:
        return hiddenTokens != null && !hiddenTokens.isEmpty();
      case XtextTestPackage.PARSER_RULE__ALTERNATIVES:
        return alternatives != null;
      case XtextTestPackage.PARSER_RULE__TERMINAL:
        return terminal != TERMINAL_EDEFAULT;
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
    result.append(", terminal: ");
    result.append(terminal);
    result.append(')');
    return result.toString();
  }

} //ParserRuleImpl
