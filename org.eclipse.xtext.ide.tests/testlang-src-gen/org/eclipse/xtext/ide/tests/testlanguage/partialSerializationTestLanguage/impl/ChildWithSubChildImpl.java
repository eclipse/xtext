/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ChildWithSubChild;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.SubChild;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child With Sub Child</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl.ChildWithSubChildImpl#getSubChilds <em>Sub Childs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChildWithSubChildImpl extends MinimalEObjectImpl.Container implements ChildWithSubChild
{
  /**
   * The cached value of the '{@link #getSubChilds() <em>Sub Childs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubChilds()
   * @generated
   * @ordered
   */
  protected EList<SubChild> subChilds;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ChildWithSubChildImpl()
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
    return PartialSerializationTestLanguagePackage.Literals.CHILD_WITH_SUB_CHILD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<SubChild> getSubChilds()
  {
    if (subChilds == null)
    {
      subChilds = new EObjectContainmentEList<SubChild>(SubChild.class, this, PartialSerializationTestLanguagePackage.CHILD_WITH_SUB_CHILD__SUB_CHILDS);
    }
    return subChilds;
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
      case PartialSerializationTestLanguagePackage.CHILD_WITH_SUB_CHILD__SUB_CHILDS:
        return ((InternalEList<?>)getSubChilds()).basicRemove(otherEnd, msgs);
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
      case PartialSerializationTestLanguagePackage.CHILD_WITH_SUB_CHILD__SUB_CHILDS:
        return getSubChilds();
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
      case PartialSerializationTestLanguagePackage.CHILD_WITH_SUB_CHILD__SUB_CHILDS:
        getSubChilds().clear();
        getSubChilds().addAll((Collection<? extends SubChild>)newValue);
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
      case PartialSerializationTestLanguagePackage.CHILD_WITH_SUB_CHILD__SUB_CHILDS:
        getSubChilds().clear();
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
      case PartialSerializationTestLanguagePackage.CHILD_WITH_SUB_CHILD__SUB_CHILDS:
        return subChilds != null && !subChilds.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ChildWithSubChildImpl
