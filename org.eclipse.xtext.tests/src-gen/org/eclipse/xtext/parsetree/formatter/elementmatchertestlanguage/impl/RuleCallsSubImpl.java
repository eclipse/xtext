/**
 */
package org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsAss1;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsAss2;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Calls Sub</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsSubImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsSubImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsSubImpl#getCall2 <em>Call2</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.RuleCallsSubImpl#getSub <em>Sub</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleCallsSubImpl extends RuleCallsImpl implements RuleCallsSub
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
   * The cached value of the '{@link #getCall1() <em>Call1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCall1()
   * @generated
   * @ordered
   */
  protected RuleCallsAss1 call1;

  /**
   * The cached value of the '{@link #getCall2() <em>Call2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCall2()
   * @generated
   * @ordered
   */
  protected RuleCallsAss2 call2;

  /**
   * The default value of the '{@link #getSub() <em>Sub</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSub()
   * @generated
   * @ordered
   */
  protected static final String SUB_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSub() <em>Sub</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSub()
   * @generated
   * @ordered
   */
  protected String sub = SUB_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleCallsSubImpl()
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
    return ElementmatchertestlanguagePackage.Literals.RULE_CALLS_SUB;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ElementmatchertestlanguagePackage.RULE_CALLS_SUB__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleCallsAss1 getCall1()
  {
    return call1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCall1(RuleCallsAss1 newCall1, NotificationChain msgs)
  {
    RuleCallsAss1 oldCall1 = call1;
    call1 = newCall1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL1, oldCall1, newCall1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCall1(RuleCallsAss1 newCall1)
  {
    if (newCall1 != call1)
    {
      NotificationChain msgs = null;
      if (call1 != null)
        msgs = ((InternalEObject)call1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL1, null, msgs);
      if (newCall1 != null)
        msgs = ((InternalEObject)newCall1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL1, null, msgs);
      msgs = basicSetCall1(newCall1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL1, newCall1, newCall1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleCallsAss2 getCall2()
  {
    return call2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCall2(RuleCallsAss2 newCall2, NotificationChain msgs)
  {
    RuleCallsAss2 oldCall2 = call2;
    call2 = newCall2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL2, oldCall2, newCall2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCall2(RuleCallsAss2 newCall2)
  {
    if (newCall2 != call2)
    {
      NotificationChain msgs = null;
      if (call2 != null)
        msgs = ((InternalEObject)call2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL2, null, msgs);
      if (newCall2 != null)
        msgs = ((InternalEObject)newCall2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL2, null, msgs);
      msgs = basicSetCall2(newCall2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL2, newCall2, newCall2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSub()
  {
    return sub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSub(String newSub)
  {
    String oldSub = sub;
    sub = newSub;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ElementmatchertestlanguagePackage.RULE_CALLS_SUB__SUB, oldSub, sub));
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
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL1:
        return basicSetCall1(null, msgs);
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL2:
        return basicSetCall2(null, msgs);
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
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__NAME:
        return getName();
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL1:
        return getCall1();
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL2:
        return getCall2();
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__SUB:
        return getSub();
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
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__NAME:
        setName((String)newValue);
        return;
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL1:
        setCall1((RuleCallsAss1)newValue);
        return;
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL2:
        setCall2((RuleCallsAss2)newValue);
        return;
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__SUB:
        setSub((String)newValue);
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
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL1:
        setCall1((RuleCallsAss1)null);
        return;
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL2:
        setCall2((RuleCallsAss2)null);
        return;
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__SUB:
        setSub(SUB_EDEFAULT);
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
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL1:
        return call1 != null;
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__CALL2:
        return call2 != null;
      case ElementmatchertestlanguagePackage.RULE_CALLS_SUB__SUB:
        return SUB_EDEFAULT == null ? sub != null : !SUB_EDEFAULT.equals(sub);
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
    result.append(", sub: ");
    result.append(sub);
    result.append(')');
    return result.toString();
  }

} //RuleCallsSubImpl
