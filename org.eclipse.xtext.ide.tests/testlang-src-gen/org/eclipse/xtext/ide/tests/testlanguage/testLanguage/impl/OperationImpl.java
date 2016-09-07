/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.testLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Operation;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.OperationCall;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Parameter;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.testLanguage.impl.OperationImpl#getParams <em>Params</em>}</li>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.testLanguage.impl.OperationImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.testLanguage.impl.OperationImpl#getOperationCall <em>Operation Call</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationImpl extends MemberImpl implements Operation
{
  /**
   * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParams()
   * @generated
   * @ordered
   */
  protected EList<Parameter> params;

  /**
   * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnType()
   * @generated
   * @ordered
   */
  protected Type returnType;

  /**
   * The cached value of the '{@link #getOperationCall() <em>Operation Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperationCall()
   * @generated
   * @ordered
   */
  protected OperationCall operationCall;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationImpl()
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
    return TestLanguagePackage.Literals.OPERATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Parameter> getParams()
  {
    if (params == null)
    {
      params = new EObjectContainmentEList<Parameter>(Parameter.class, this, TestLanguagePackage.OPERATION__PARAMS);
    }
    return params;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getReturnType()
  {
    return returnType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReturnType(Type newReturnType, NotificationChain msgs)
  {
    Type oldReturnType = returnType;
    returnType = newReturnType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestLanguagePackage.OPERATION__RETURN_TYPE, oldReturnType, newReturnType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReturnType(Type newReturnType)
  {
    if (newReturnType != returnType)
    {
      NotificationChain msgs = null;
      if (returnType != null)
        msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestLanguagePackage.OPERATION__RETURN_TYPE, null, msgs);
      if (newReturnType != null)
        msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestLanguagePackage.OPERATION__RETURN_TYPE, null, msgs);
      msgs = basicSetReturnType(newReturnType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLanguagePackage.OPERATION__RETURN_TYPE, newReturnType, newReturnType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationCall getOperationCall()
  {
    return operationCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperationCall(OperationCall newOperationCall, NotificationChain msgs)
  {
    OperationCall oldOperationCall = operationCall;
    operationCall = newOperationCall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestLanguagePackage.OPERATION__OPERATION_CALL, oldOperationCall, newOperationCall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperationCall(OperationCall newOperationCall)
  {
    if (newOperationCall != operationCall)
    {
      NotificationChain msgs = null;
      if (operationCall != null)
        msgs = ((InternalEObject)operationCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestLanguagePackage.OPERATION__OPERATION_CALL, null, msgs);
      if (newOperationCall != null)
        msgs = ((InternalEObject)newOperationCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestLanguagePackage.OPERATION__OPERATION_CALL, null, msgs);
      msgs = basicSetOperationCall(newOperationCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLanguagePackage.OPERATION__OPERATION_CALL, newOperationCall, newOperationCall));
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
      case TestLanguagePackage.OPERATION__PARAMS:
        return ((InternalEList<?>)getParams()).basicRemove(otherEnd, msgs);
      case TestLanguagePackage.OPERATION__RETURN_TYPE:
        return basicSetReturnType(null, msgs);
      case TestLanguagePackage.OPERATION__OPERATION_CALL:
        return basicSetOperationCall(null, msgs);
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
      case TestLanguagePackage.OPERATION__PARAMS:
        return getParams();
      case TestLanguagePackage.OPERATION__RETURN_TYPE:
        return getReturnType();
      case TestLanguagePackage.OPERATION__OPERATION_CALL:
        return getOperationCall();
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
      case TestLanguagePackage.OPERATION__PARAMS:
        getParams().clear();
        getParams().addAll((Collection<? extends Parameter>)newValue);
        return;
      case TestLanguagePackage.OPERATION__RETURN_TYPE:
        setReturnType((Type)newValue);
        return;
      case TestLanguagePackage.OPERATION__OPERATION_CALL:
        setOperationCall((OperationCall)newValue);
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
      case TestLanguagePackage.OPERATION__PARAMS:
        getParams().clear();
        return;
      case TestLanguagePackage.OPERATION__RETURN_TYPE:
        setReturnType((Type)null);
        return;
      case TestLanguagePackage.OPERATION__OPERATION_CALL:
        setOperationCall((OperationCall)null);
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
      case TestLanguagePackage.OPERATION__PARAMS:
        return params != null && !params.isEmpty();
      case TestLanguagePackage.OPERATION__RETURN_TYPE:
        return returnType != null;
      case TestLanguagePackage.OPERATION__OPERATION_CALL:
        return operationCall != null;
    }
    return super.eIsSet(featureID);
  }

} //OperationImpl
