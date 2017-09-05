/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryValue;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalChildList;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Optional Child List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl.OptionalChildListImpl#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OptionalChildListImpl extends ModelImpl implements OptionalChildList
{
  /**
   * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChildren()
   * @generated
   * @ordered
   */
  protected EList<MandatoryValue> children;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OptionalChildListImpl()
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
    return PartialSerializationTestLanguagePackage.Literals.OPTIONAL_CHILD_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MandatoryValue> getChildren()
  {
    if (children == null)
    {
      children = new EObjectContainmentEList<MandatoryValue>(MandatoryValue.class, this, PartialSerializationTestLanguagePackage.OPTIONAL_CHILD_LIST__CHILDREN);
    }
    return children;
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
      case PartialSerializationTestLanguagePackage.OPTIONAL_CHILD_LIST__CHILDREN:
        return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
      case PartialSerializationTestLanguagePackage.OPTIONAL_CHILD_LIST__CHILDREN:
        return getChildren();
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
      case PartialSerializationTestLanguagePackage.OPTIONAL_CHILD_LIST__CHILDREN:
        getChildren().clear();
        getChildren().addAll((Collection<? extends MandatoryValue>)newValue);
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
      case PartialSerializationTestLanguagePackage.OPTIONAL_CHILD_LIST__CHILDREN:
        getChildren().clear();
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
      case PartialSerializationTestLanguagePackage.OPTIONAL_CHILD_LIST__CHILDREN:
        return children != null && !children.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //OptionalChildListImpl
