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

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;

import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangPackage;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>My Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyClassImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyClassImpl#getImplements <em>Implements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MyClassImpl extends MyTypeImpl implements MyClass
{
  /**
   * The cached value of the '{@link #getExtends() <em>Extends</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtends()
   * @generated
   * @ordered
   */
  protected JvmParameterizedTypeReference extends_;

  /**
   * The cached value of the '{@link #getImplements() <em>Implements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImplements()
   * @generated
   * @ordered
   */
  protected EList<JvmParameterizedTypeReference> implements_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MyClassImpl()
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
    return JvmGenericTypeValidatorTestLangPackage.Literals.MY_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JvmParameterizedTypeReference getExtends()
  {
    return extends_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExtends(JvmParameterizedTypeReference newExtends, NotificationChain msgs)
  {
    JvmParameterizedTypeReference oldExtends = extends_;
    extends_ = newExtends;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JvmGenericTypeValidatorTestLangPackage.MY_CLASS__EXTENDS, oldExtends, newExtends);
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
  public void setExtends(JvmParameterizedTypeReference newExtends)
  {
    if (newExtends != extends_)
    {
      NotificationChain msgs = null;
      if (extends_ != null)
        msgs = ((InternalEObject)extends_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JvmGenericTypeValidatorTestLangPackage.MY_CLASS__EXTENDS, null, msgs);
      if (newExtends != null)
        msgs = ((InternalEObject)newExtends).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JvmGenericTypeValidatorTestLangPackage.MY_CLASS__EXTENDS, null, msgs);
      msgs = basicSetExtends(newExtends, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JvmGenericTypeValidatorTestLangPackage.MY_CLASS__EXTENDS, newExtends, newExtends));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<JvmParameterizedTypeReference> getImplements()
  {
    if (implements_ == null)
    {
      implements_ = new EObjectContainmentEList<JvmParameterizedTypeReference>(JvmParameterizedTypeReference.class, this, JvmGenericTypeValidatorTestLangPackage.MY_CLASS__IMPLEMENTS);
    }
    return implements_;
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
      case JvmGenericTypeValidatorTestLangPackage.MY_CLASS__EXTENDS:
        return basicSetExtends(null, msgs);
      case JvmGenericTypeValidatorTestLangPackage.MY_CLASS__IMPLEMENTS:
        return ((InternalEList<?>)getImplements()).basicRemove(otherEnd, msgs);
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
      case JvmGenericTypeValidatorTestLangPackage.MY_CLASS__EXTENDS:
        return getExtends();
      case JvmGenericTypeValidatorTestLangPackage.MY_CLASS__IMPLEMENTS:
        return getImplements();
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
      case JvmGenericTypeValidatorTestLangPackage.MY_CLASS__EXTENDS:
        setExtends((JvmParameterizedTypeReference)newValue);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_CLASS__IMPLEMENTS:
        getImplements().clear();
        getImplements().addAll((Collection<? extends JvmParameterizedTypeReference>)newValue);
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
      case JvmGenericTypeValidatorTestLangPackage.MY_CLASS__EXTENDS:
        setExtends((JvmParameterizedTypeReference)null);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_CLASS__IMPLEMENTS:
        getImplements().clear();
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
      case JvmGenericTypeValidatorTestLangPackage.MY_CLASS__EXTENDS:
        return extends_ != null;
      case JvmGenericTypeValidatorTestLangPackage.MY_CLASS__IMPLEMENTS:
        return implements_ != null && !implements_.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MyClassImpl
