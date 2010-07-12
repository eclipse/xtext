/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BacktrackingContentAssistTestPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralPart;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.CollectionLiteralPartImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.CollectionLiteralPartImpl#getLastExpression <em>Last Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionLiteralPartImpl extends MinimalEObjectImpl.Container implements CollectionLiteralPart
{
  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected Expression expression;

  /**
   * The cached value of the '{@link #getLastExpression() <em>Last Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLastExpression()
   * @generated
   * @ordered
   */
  protected Expression lastExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CollectionLiteralPartImpl()
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
    return BacktrackingContentAssistTestPackage.Literals.COLLECTION_LITERAL_PART;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs)
  {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(Expression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getLastExpression()
  {
    return lastExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLastExpression(Expression newLastExpression, NotificationChain msgs)
  {
    Expression oldLastExpression = lastExpression;
    lastExpression = newLastExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__LAST_EXPRESSION, oldLastExpression, newLastExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLastExpression(Expression newLastExpression)
  {
    if (newLastExpression != lastExpression)
    {
      NotificationChain msgs = null;
      if (lastExpression != null)
        msgs = ((InternalEObject)lastExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__LAST_EXPRESSION, null, msgs);
      if (newLastExpression != null)
        msgs = ((InternalEObject)newLastExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__LAST_EXPRESSION, null, msgs);
      msgs = basicSetLastExpression(newLastExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__LAST_EXPRESSION, newLastExpression, newLastExpression));
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
      case BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__EXPRESSION:
        return basicSetExpression(null, msgs);
      case BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__LAST_EXPRESSION:
        return basicSetLastExpression(null, msgs);
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
      case BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__EXPRESSION:
        return getExpression();
      case BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__LAST_EXPRESSION:
        return getLastExpression();
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
      case BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__EXPRESSION:
        setExpression((Expression)newValue);
        return;
      case BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__LAST_EXPRESSION:
        setLastExpression((Expression)newValue);
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
      case BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__EXPRESSION:
        setExpression((Expression)null);
        return;
      case BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__LAST_EXPRESSION:
        setLastExpression((Expression)null);
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
      case BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__EXPRESSION:
        return expression != null;
      case BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART__LAST_EXPRESSION:
        return lastExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //CollectionLiteralPartImpl
