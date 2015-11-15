/**
 */
package org.eclipse.xtext.xtextTest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xtextTest.AbstractRule;
import org.eclipse.xtext.xtextTest.Parameter;
import org.eclipse.xtext.xtextTest.ParserRule;
import org.eclipse.xtext.xtextTest.XtextTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parser Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.ParserRuleImpl#isFragment <em>Fragment</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.ParserRuleImpl#isWildcard <em>Wildcard</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.ParserRuleImpl#isDefinesHiddenTokens <em>Defines Hidden Tokens</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.ParserRuleImpl#getHiddenTokens <em>Hidden Tokens</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.ParserRuleImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParserRuleImpl extends AbstractRuleImpl implements ParserRule
{
  /**
   * The default value of the '{@link #isFragment() <em>Fragment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFragment()
   * @generated
   * @ordered
   */
  protected static final boolean FRAGMENT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFragment() <em>Fragment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFragment()
   * @generated
   * @ordered
   */
  protected boolean fragment = FRAGMENT_EDEFAULT;

  /**
   * The default value of the '{@link #isWildcard() <em>Wildcard</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWildcard()
   * @generated
   * @ordered
   */
  protected static final boolean WILDCARD_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isWildcard() <em>Wildcard</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWildcard()
   * @generated
   * @ordered
   */
  protected boolean wildcard = WILDCARD_EDEFAULT;

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
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<Parameter> parameters;

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
  public boolean isFragment()
  {
    return fragment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFragment(boolean newFragment)
  {
    boolean oldFragment = fragment;
    fragment = newFragment;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.PARSER_RULE__FRAGMENT, oldFragment, fragment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isWildcard()
  {
    return wildcard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWildcard(boolean newWildcard)
  {
    boolean oldWildcard = wildcard;
    wildcard = newWildcard;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.PARSER_RULE__WILDCARD, oldWildcard, wildcard));
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
  public EList<Parameter> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, XtextTestPackage.PARSER_RULE__PARAMETERS);
    }
    return parameters;
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
      case XtextTestPackage.PARSER_RULE__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
      case XtextTestPackage.PARSER_RULE__FRAGMENT:
        return isFragment();
      case XtextTestPackage.PARSER_RULE__WILDCARD:
        return isWildcard();
      case XtextTestPackage.PARSER_RULE__DEFINES_HIDDEN_TOKENS:
        return isDefinesHiddenTokens();
      case XtextTestPackage.PARSER_RULE__HIDDEN_TOKENS:
        return getHiddenTokens();
      case XtextTestPackage.PARSER_RULE__PARAMETERS:
        return getParameters();
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
      case XtextTestPackage.PARSER_RULE__FRAGMENT:
        setFragment((Boolean)newValue);
        return;
      case XtextTestPackage.PARSER_RULE__WILDCARD:
        setWildcard((Boolean)newValue);
        return;
      case XtextTestPackage.PARSER_RULE__DEFINES_HIDDEN_TOKENS:
        setDefinesHiddenTokens((Boolean)newValue);
        return;
      case XtextTestPackage.PARSER_RULE__HIDDEN_TOKENS:
        getHiddenTokens().clear();
        getHiddenTokens().addAll((Collection<? extends AbstractRule>)newValue);
        return;
      case XtextTestPackage.PARSER_RULE__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends Parameter>)newValue);
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
      case XtextTestPackage.PARSER_RULE__FRAGMENT:
        setFragment(FRAGMENT_EDEFAULT);
        return;
      case XtextTestPackage.PARSER_RULE__WILDCARD:
        setWildcard(WILDCARD_EDEFAULT);
        return;
      case XtextTestPackage.PARSER_RULE__DEFINES_HIDDEN_TOKENS:
        setDefinesHiddenTokens(DEFINES_HIDDEN_TOKENS_EDEFAULT);
        return;
      case XtextTestPackage.PARSER_RULE__HIDDEN_TOKENS:
        getHiddenTokens().clear();
        return;
      case XtextTestPackage.PARSER_RULE__PARAMETERS:
        getParameters().clear();
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
      case XtextTestPackage.PARSER_RULE__FRAGMENT:
        return fragment != FRAGMENT_EDEFAULT;
      case XtextTestPackage.PARSER_RULE__WILDCARD:
        return wildcard != WILDCARD_EDEFAULT;
      case XtextTestPackage.PARSER_RULE__DEFINES_HIDDEN_TOKENS:
        return definesHiddenTokens != DEFINES_HIDDEN_TOKENS_EDEFAULT;
      case XtextTestPackage.PARSER_RULE__HIDDEN_TOKENS:
        return hiddenTokens != null && !hiddenTokens.isEmpty();
      case XtextTestPackage.PARSER_RULE__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
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
    result.append(" (fragment: ");
    result.append(fragment);
    result.append(", wildcard: ");
    result.append(wildcard);
    result.append(", definesHiddenTokens: ");
    result.append(definesHiddenTokens);
    result.append(')');
    return result.toString();
  }

} //ParserRuleImpl
