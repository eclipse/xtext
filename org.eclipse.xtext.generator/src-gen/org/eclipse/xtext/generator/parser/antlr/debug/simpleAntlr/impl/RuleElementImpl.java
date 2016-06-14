/**
 */
package org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Expression;
import org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleElement;
import org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleElementImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleElementImpl#getGuarded <em>Guarded</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleElementImpl extends MinimalEObjectImpl.Container implements RuleElement
{
  /**
   * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuard()
   * @generated
   * @ordered
   */
  protected Expression guard;

  /**
   * The cached value of the '{@link #getGuarded() <em>Guarded</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuarded()
   * @generated
   * @ordered
   */
  protected RuleElement guarded;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleElementImpl()
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
    return SimpleAntlrPackage.Literals.RULE_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getGuard()
  {
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGuard(Expression newGuard, NotificationChain msgs)
  {
    Expression oldGuard = guard;
    guard = newGuard;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimpleAntlrPackage.RULE_ELEMENT__GUARD, oldGuard, newGuard);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGuard(Expression newGuard)
  {
    if (newGuard != guard)
    {
      NotificationChain msgs = null;
      if (guard != null)
        msgs = ((InternalEObject)guard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimpleAntlrPackage.RULE_ELEMENT__GUARD, null, msgs);
      if (newGuard != null)
        msgs = ((InternalEObject)newGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimpleAntlrPackage.RULE_ELEMENT__GUARD, null, msgs);
      msgs = basicSetGuard(newGuard, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimpleAntlrPackage.RULE_ELEMENT__GUARD, newGuard, newGuard));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleElement getGuarded()
  {
    return guarded;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGuarded(RuleElement newGuarded, NotificationChain msgs)
  {
    RuleElement oldGuarded = guarded;
    guarded = newGuarded;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimpleAntlrPackage.RULE_ELEMENT__GUARDED, oldGuarded, newGuarded);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGuarded(RuleElement newGuarded)
  {
    if (newGuarded != guarded)
    {
      NotificationChain msgs = null;
      if (guarded != null)
        msgs = ((InternalEObject)guarded).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimpleAntlrPackage.RULE_ELEMENT__GUARDED, null, msgs);
      if (newGuarded != null)
        msgs = ((InternalEObject)newGuarded).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimpleAntlrPackage.RULE_ELEMENT__GUARDED, null, msgs);
      msgs = basicSetGuarded(newGuarded, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimpleAntlrPackage.RULE_ELEMENT__GUARDED, newGuarded, newGuarded));
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
      case SimpleAntlrPackage.RULE_ELEMENT__GUARD:
        return basicSetGuard(null, msgs);
      case SimpleAntlrPackage.RULE_ELEMENT__GUARDED:
        return basicSetGuarded(null, msgs);
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
      case SimpleAntlrPackage.RULE_ELEMENT__GUARD:
        return getGuard();
      case SimpleAntlrPackage.RULE_ELEMENT__GUARDED:
        return getGuarded();
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
      case SimpleAntlrPackage.RULE_ELEMENT__GUARD:
        setGuard((Expression)newValue);
        return;
      case SimpleAntlrPackage.RULE_ELEMENT__GUARDED:
        setGuarded((RuleElement)newValue);
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
      case SimpleAntlrPackage.RULE_ELEMENT__GUARD:
        setGuard((Expression)null);
        return;
      case SimpleAntlrPackage.RULE_ELEMENT__GUARDED:
        setGuarded((RuleElement)null);
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
      case SimpleAntlrPackage.RULE_ELEMENT__GUARD:
        return guard != null;
      case SimpleAntlrPackage.RULE_ELEMENT__GUARDED:
        return guarded != null;
    }
    return super.eIsSet(featureID);
  }

} //RuleElementImpl
