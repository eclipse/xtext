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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;

import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangPackage;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyInterface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>My Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyInterfaceImpl#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyInterfaceImpl#getExtends <em>Extends</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MyInterfaceImpl extends MyTypeImpl implements MyInterface
{
  /**
   * The cached value of the '{@link #getTypeParameters() <em>Type Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeParameters()
   * @generated
   * @ordered
   */
  protected EList<JvmTypeParameter> typeParameters;

  /**
   * The cached value of the '{@link #getExtends() <em>Extends</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtends()
   * @generated
   * @ordered
   */
  protected EList<JvmParameterizedTypeReference> extends_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MyInterfaceImpl()
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
    return JvmGenericTypeValidatorTestLangPackage.Literals.MY_INTERFACE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<JvmTypeParameter> getTypeParameters()
  {
    if (typeParameters == null)
    {
      typeParameters = new EObjectContainmentEList<JvmTypeParameter>(JvmTypeParameter.class, this, JvmGenericTypeValidatorTestLangPackage.MY_INTERFACE__TYPE_PARAMETERS);
    }
    return typeParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<JvmParameterizedTypeReference> getExtends()
  {
    if (extends_ == null)
    {
      extends_ = new EObjectContainmentEList<JvmParameterizedTypeReference>(JvmParameterizedTypeReference.class, this, JvmGenericTypeValidatorTestLangPackage.MY_INTERFACE__EXTENDS);
    }
    return extends_;
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
      case JvmGenericTypeValidatorTestLangPackage.MY_INTERFACE__TYPE_PARAMETERS:
        return ((InternalEList<?>)getTypeParameters()).basicRemove(otherEnd, msgs);
      case JvmGenericTypeValidatorTestLangPackage.MY_INTERFACE__EXTENDS:
        return ((InternalEList<?>)getExtends()).basicRemove(otherEnd, msgs);
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
      case JvmGenericTypeValidatorTestLangPackage.MY_INTERFACE__TYPE_PARAMETERS:
        return getTypeParameters();
      case JvmGenericTypeValidatorTestLangPackage.MY_INTERFACE__EXTENDS:
        return getExtends();
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
      case JvmGenericTypeValidatorTestLangPackage.MY_INTERFACE__TYPE_PARAMETERS:
        getTypeParameters().clear();
        getTypeParameters().addAll((Collection<? extends JvmTypeParameter>)newValue);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_INTERFACE__EXTENDS:
        getExtends().clear();
        getExtends().addAll((Collection<? extends JvmParameterizedTypeReference>)newValue);
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
      case JvmGenericTypeValidatorTestLangPackage.MY_INTERFACE__TYPE_PARAMETERS:
        getTypeParameters().clear();
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_INTERFACE__EXTENDS:
        getExtends().clear();
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
      case JvmGenericTypeValidatorTestLangPackage.MY_INTERFACE__TYPE_PARAMETERS:
        return typeParameters != null && !typeParameters.isEmpty();
      case JvmGenericTypeValidatorTestLangPackage.MY_INTERFACE__EXTENDS:
        return extends_ != null && !extends_.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MyInterfaceImpl
