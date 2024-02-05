/**
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.xbase.XExpression;

import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangPackage;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyConstructor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>My Constructor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyConstructorImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyConstructorImpl#getExceptions <em>Exceptions</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyConstructorImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MyConstructorImpl extends MyMemberImpl implements MyConstructor
{
  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<JvmFormalParameter> parameters;

  /**
   * The cached value of the '{@link #getExceptions() <em>Exceptions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExceptions()
   * @generated
   * @ordered
   */
  protected EList<JvmTypeReference> exceptions;

  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected XExpression expression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MyConstructorImpl()
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
    return JvmGenericTypeValidatorTestLangPackage.Literals.MY_CONSTRUCTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<JvmFormalParameter> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<JvmFormalParameter>(JvmFormalParameter.class, this, JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<JvmTypeReference> getExceptions()
  {
    if (exceptions == null)
    {
      exceptions = new EObjectContainmentEList<JvmTypeReference>(JvmTypeReference.class, this, JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__EXCEPTIONS);
    }
    return exceptions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XExpression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(XExpression newExpression, NotificationChain msgs)
  {
    XExpression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExpression(XExpression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__EXPRESSION, newExpression, newExpression));
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
      case JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
      case JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__EXCEPTIONS:
        return ((InternalEList<?>)getExceptions()).basicRemove(otherEnd, msgs);
      case JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__EXPRESSION:
        return basicSetExpression(null, msgs);
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
      case JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__PARAMETERS:
        return getParameters();
      case JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__EXCEPTIONS:
        return getExceptions();
      case JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__EXPRESSION:
        return getExpression();
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
      case JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends JvmFormalParameter>)newValue);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__EXCEPTIONS:
        getExceptions().clear();
        getExceptions().addAll((Collection<? extends JvmTypeReference>)newValue);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__EXPRESSION:
        setExpression((XExpression)newValue);
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
      case JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__PARAMETERS:
        getParameters().clear();
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__EXCEPTIONS:
        getExceptions().clear();
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__EXPRESSION:
        setExpression((XExpression)null);
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
      case JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__EXCEPTIONS:
        return exceptions != null && !exceptions.isEmpty();
      case JvmGenericTypeValidatorTestLangPackage.MY_CONSTRUCTOR__EXPRESSION:
        return expression != null;
    }
    return super.eIsSet(featureID);
  }

} //MyConstructorImpl
