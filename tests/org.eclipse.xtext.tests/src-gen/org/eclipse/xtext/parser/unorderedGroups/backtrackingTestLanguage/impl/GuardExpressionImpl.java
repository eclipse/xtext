/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage;
import org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.Expression;
import org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.GuardExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guard Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl.GuardExpressionImpl#getGuardExpr <em>Guard Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GuardExpressionImpl extends MinimalEObjectImpl.Container implements GuardExpression
{
  /**
   * The cached value of the '{@link #getGuardExpr() <em>Guard Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuardExpr()
   * @generated
   * @ordered
   */
  protected Expression guardExpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GuardExpressionImpl()
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
    return BacktrackingTestLanguagePackage.Literals.GUARD_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getGuardExpr()
  {
    return guardExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGuardExpr(Expression newGuardExpr, NotificationChain msgs)
  {
    Expression oldGuardExpr = guardExpr;
    guardExpr = newGuardExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingTestLanguagePackage.GUARD_EXPRESSION__GUARD_EXPR, oldGuardExpr, newGuardExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGuardExpr(Expression newGuardExpr)
  {
    if (newGuardExpr != guardExpr)
    {
      NotificationChain msgs = null;
      if (guardExpr != null)
        msgs = ((InternalEObject)guardExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingTestLanguagePackage.GUARD_EXPRESSION__GUARD_EXPR, null, msgs);
      if (newGuardExpr != null)
        msgs = ((InternalEObject)newGuardExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingTestLanguagePackage.GUARD_EXPRESSION__GUARD_EXPR, null, msgs);
      msgs = basicSetGuardExpr(newGuardExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingTestLanguagePackage.GUARD_EXPRESSION__GUARD_EXPR, newGuardExpr, newGuardExpr));
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
      case BacktrackingTestLanguagePackage.GUARD_EXPRESSION__GUARD_EXPR:
        return basicSetGuardExpr(null, msgs);
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
      case BacktrackingTestLanguagePackage.GUARD_EXPRESSION__GUARD_EXPR:
        return getGuardExpr();
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
      case BacktrackingTestLanguagePackage.GUARD_EXPRESSION__GUARD_EXPR:
        setGuardExpr((Expression)newValue);
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
      case BacktrackingTestLanguagePackage.GUARD_EXPRESSION__GUARD_EXPR:
        setGuardExpr((Expression)null);
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
      case BacktrackingTestLanguagePackage.GUARD_EXPRESSION__GUARD_EXPR:
        return guardExpr != null;
    }
    return super.eIsSet(featureID);
  }

} //GuardExpressionImpl
