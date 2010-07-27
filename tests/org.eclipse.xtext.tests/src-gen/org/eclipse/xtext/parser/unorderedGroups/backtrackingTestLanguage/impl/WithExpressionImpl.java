/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage;
import org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.Expression;
import org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.WithExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>With Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl.WithExpressionImpl#getReferencedAdvice <em>Referenced Advice</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl.WithExpressionImpl#getFuncExpr <em>Func Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WithExpressionImpl extends ExpressionImpl implements WithExpression
{
  /**
   * The cached value of the '{@link #getReferencedAdvice() <em>Referenced Advice</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferencedAdvice()
   * @generated
   * @ordered
   */
  protected EList<String> referencedAdvice;

  /**
   * The cached value of the '{@link #getFuncExpr() <em>Func Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFuncExpr()
   * @generated
   * @ordered
   */
  protected Expression funcExpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WithExpressionImpl()
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
    return BacktrackingTestLanguagePackage.Literals.WITH_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getReferencedAdvice()
  {
    if (referencedAdvice == null)
    {
      referencedAdvice = new EDataTypeEList<String>(String.class, this, BacktrackingTestLanguagePackage.WITH_EXPRESSION__REFERENCED_ADVICE);
    }
    return referencedAdvice;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getFuncExpr()
  {
    return funcExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFuncExpr(Expression newFuncExpr, NotificationChain msgs)
  {
    Expression oldFuncExpr = funcExpr;
    funcExpr = newFuncExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingTestLanguagePackage.WITH_EXPRESSION__FUNC_EXPR, oldFuncExpr, newFuncExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFuncExpr(Expression newFuncExpr)
  {
    if (newFuncExpr != funcExpr)
    {
      NotificationChain msgs = null;
      if (funcExpr != null)
        msgs = ((InternalEObject)funcExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingTestLanguagePackage.WITH_EXPRESSION__FUNC_EXPR, null, msgs);
      if (newFuncExpr != null)
        msgs = ((InternalEObject)newFuncExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingTestLanguagePackage.WITH_EXPRESSION__FUNC_EXPR, null, msgs);
      msgs = basicSetFuncExpr(newFuncExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingTestLanguagePackage.WITH_EXPRESSION__FUNC_EXPR, newFuncExpr, newFuncExpr));
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
      case BacktrackingTestLanguagePackage.WITH_EXPRESSION__FUNC_EXPR:
        return basicSetFuncExpr(null, msgs);
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
      case BacktrackingTestLanguagePackage.WITH_EXPRESSION__REFERENCED_ADVICE:
        return getReferencedAdvice();
      case BacktrackingTestLanguagePackage.WITH_EXPRESSION__FUNC_EXPR:
        return getFuncExpr();
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
      case BacktrackingTestLanguagePackage.WITH_EXPRESSION__REFERENCED_ADVICE:
        getReferencedAdvice().clear();
        getReferencedAdvice().addAll((Collection<? extends String>)newValue);
        return;
      case BacktrackingTestLanguagePackage.WITH_EXPRESSION__FUNC_EXPR:
        setFuncExpr((Expression)newValue);
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
      case BacktrackingTestLanguagePackage.WITH_EXPRESSION__REFERENCED_ADVICE:
        getReferencedAdvice().clear();
        return;
      case BacktrackingTestLanguagePackage.WITH_EXPRESSION__FUNC_EXPR:
        setFuncExpr((Expression)null);
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
      case BacktrackingTestLanguagePackage.WITH_EXPRESSION__REFERENCED_ADVICE:
        return referencedAdvice != null && !referencedAdvice.isEmpty();
      case BacktrackingTestLanguagePackage.WITH_EXPRESSION__FUNC_EXPR:
        return funcExpr != null;
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
    result.append(" (referencedAdvice: ");
    result.append(referencedAdvice);
    result.append(')');
    return result.toString();
  }

} //WithExpressionImpl
