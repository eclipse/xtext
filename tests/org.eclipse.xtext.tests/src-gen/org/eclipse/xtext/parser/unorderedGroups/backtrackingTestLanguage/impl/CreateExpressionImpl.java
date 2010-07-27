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

import org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage;
import org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.CreateExpression;
import org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.Expression;
import org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ParameterList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl.CreateExpressionImpl#getTypeExpr <em>Type Expr</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl.CreateExpressionImpl#getParameterList <em>Parameter List</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl.CreateExpressionImpl#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl.CreateExpressionImpl#getContextBlock <em>Context Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreateExpressionImpl extends ExpressionImpl implements CreateExpression
{
  /**
   * The default value of the '{@link #getTypeExpr() <em>Type Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeExpr()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EXPR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTypeExpr() <em>Type Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeExpr()
   * @generated
   * @ordered
   */
  protected String typeExpr = TYPE_EXPR_EDEFAULT;

  /**
   * The cached value of the '{@link #getParameterList() <em>Parameter List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterList()
   * @generated
   * @ordered
   */
  protected ParameterList parameterList;

  /**
   * The default value of the '{@link #getAlias() <em>Alias</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlias()
   * @generated
   * @ordered
   */
  protected static final String ALIAS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAlias() <em>Alias</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlias()
   * @generated
   * @ordered
   */
  protected String alias = ALIAS_EDEFAULT;

  /**
   * The cached value of the '{@link #getContextBlock() <em>Context Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContextBlock()
   * @generated
   * @ordered
   */
  protected Expression contextBlock;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CreateExpressionImpl()
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
    return BacktrackingTestLanguagePackage.Literals.CREATE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTypeExpr()
  {
    return typeExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeExpr(String newTypeExpr)
  {
    String oldTypeExpr = typeExpr;
    typeExpr = newTypeExpr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingTestLanguagePackage.CREATE_EXPRESSION__TYPE_EXPR, oldTypeExpr, typeExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterList getParameterList()
  {
    return parameterList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParameterList(ParameterList newParameterList, NotificationChain msgs)
  {
    ParameterList oldParameterList = parameterList;
    parameterList = newParameterList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingTestLanguagePackage.CREATE_EXPRESSION__PARAMETER_LIST, oldParameterList, newParameterList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParameterList(ParameterList newParameterList)
  {
    if (newParameterList != parameterList)
    {
      NotificationChain msgs = null;
      if (parameterList != null)
        msgs = ((InternalEObject)parameterList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingTestLanguagePackage.CREATE_EXPRESSION__PARAMETER_LIST, null, msgs);
      if (newParameterList != null)
        msgs = ((InternalEObject)newParameterList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingTestLanguagePackage.CREATE_EXPRESSION__PARAMETER_LIST, null, msgs);
      msgs = basicSetParameterList(newParameterList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingTestLanguagePackage.CREATE_EXPRESSION__PARAMETER_LIST, newParameterList, newParameterList));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAlias()
  {
    return alias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAlias(String newAlias)
  {
    String oldAlias = alias;
    alias = newAlias;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingTestLanguagePackage.CREATE_EXPRESSION__ALIAS, oldAlias, alias));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getContextBlock()
  {
    return contextBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContextBlock(Expression newContextBlock, NotificationChain msgs)
  {
    Expression oldContextBlock = contextBlock;
    contextBlock = newContextBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingTestLanguagePackage.CREATE_EXPRESSION__CONTEXT_BLOCK, oldContextBlock, newContextBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContextBlock(Expression newContextBlock)
  {
    if (newContextBlock != contextBlock)
    {
      NotificationChain msgs = null;
      if (contextBlock != null)
        msgs = ((InternalEObject)contextBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingTestLanguagePackage.CREATE_EXPRESSION__CONTEXT_BLOCK, null, msgs);
      if (newContextBlock != null)
        msgs = ((InternalEObject)newContextBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingTestLanguagePackage.CREATE_EXPRESSION__CONTEXT_BLOCK, null, msgs);
      msgs = basicSetContextBlock(newContextBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingTestLanguagePackage.CREATE_EXPRESSION__CONTEXT_BLOCK, newContextBlock, newContextBlock));
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
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__PARAMETER_LIST:
        return basicSetParameterList(null, msgs);
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__CONTEXT_BLOCK:
        return basicSetContextBlock(null, msgs);
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
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__TYPE_EXPR:
        return getTypeExpr();
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__PARAMETER_LIST:
        return getParameterList();
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__ALIAS:
        return getAlias();
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__CONTEXT_BLOCK:
        return getContextBlock();
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
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__TYPE_EXPR:
        setTypeExpr((String)newValue);
        return;
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__PARAMETER_LIST:
        setParameterList((ParameterList)newValue);
        return;
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__ALIAS:
        setAlias((String)newValue);
        return;
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__CONTEXT_BLOCK:
        setContextBlock((Expression)newValue);
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
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__TYPE_EXPR:
        setTypeExpr(TYPE_EXPR_EDEFAULT);
        return;
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__PARAMETER_LIST:
        setParameterList((ParameterList)null);
        return;
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__ALIAS:
        setAlias(ALIAS_EDEFAULT);
        return;
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__CONTEXT_BLOCK:
        setContextBlock((Expression)null);
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
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__TYPE_EXPR:
        return TYPE_EXPR_EDEFAULT == null ? typeExpr != null : !TYPE_EXPR_EDEFAULT.equals(typeExpr);
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__PARAMETER_LIST:
        return parameterList != null;
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__ALIAS:
        return ALIAS_EDEFAULT == null ? alias != null : !ALIAS_EDEFAULT.equals(alias);
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION__CONTEXT_BLOCK:
        return contextBlock != null;
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
    result.append(" (typeExpr: ");
    result.append(typeExpr);
    result.append(", alias: ");
    result.append(alias);
    result.append(')');
    return result.toString();
  }

} //CreateExpressionImpl
