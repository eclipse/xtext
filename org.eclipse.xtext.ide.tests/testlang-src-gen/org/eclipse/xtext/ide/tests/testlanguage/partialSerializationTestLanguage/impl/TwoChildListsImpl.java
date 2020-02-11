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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryChildList;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryValue;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChildLists;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Two Child Lists</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl.TwoChildListsImpl#getDirectChildren <em>Direct Children</em>}</li>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl.TwoChildListsImpl#getChildsList <em>Childs List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TwoChildListsImpl extends ModelImpl implements TwoChildLists
{
  /**
   * The cached value of the '{@link #getDirectChildren() <em>Direct Children</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirectChildren()
   * @generated
   * @ordered
   */
  protected EList<MandatoryValue> directChildren;

  /**
   * The cached value of the '{@link #getChildsList() <em>Childs List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChildsList()
   * @generated
   * @ordered
   */
  protected MandatoryChildList childsList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TwoChildListsImpl()
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
    return PartialSerializationTestLanguagePackage.Literals.TWO_CHILD_LISTS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<MandatoryValue> getDirectChildren()
  {
    if (directChildren == null)
    {
      directChildren = new EObjectContainmentEList<MandatoryValue>(MandatoryValue.class, this, PartialSerializationTestLanguagePackage.TWO_CHILD_LISTS__DIRECT_CHILDREN);
    }
    return directChildren;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MandatoryChildList getChildsList()
  {
    return childsList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChildsList(MandatoryChildList newChildsList, NotificationChain msgs)
  {
    MandatoryChildList oldChildsList = childsList;
    childsList = newChildsList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PartialSerializationTestLanguagePackage.TWO_CHILD_LISTS__CHILDS_LIST, oldChildsList, newChildsList);
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
  public void setChildsList(MandatoryChildList newChildsList)
  {
    if (newChildsList != childsList)
    {
      NotificationChain msgs = null;
      if (childsList != null)
        msgs = ((InternalEObject)childsList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PartialSerializationTestLanguagePackage.TWO_CHILD_LISTS__CHILDS_LIST, null, msgs);
      if (newChildsList != null)
        msgs = ((InternalEObject)newChildsList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PartialSerializationTestLanguagePackage.TWO_CHILD_LISTS__CHILDS_LIST, null, msgs);
      msgs = basicSetChildsList(newChildsList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PartialSerializationTestLanguagePackage.TWO_CHILD_LISTS__CHILDS_LIST, newChildsList, newChildsList));
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
      case PartialSerializationTestLanguagePackage.TWO_CHILD_LISTS__DIRECT_CHILDREN:
        return ((InternalEList<?>)getDirectChildren()).basicRemove(otherEnd, msgs);
      case PartialSerializationTestLanguagePackage.TWO_CHILD_LISTS__CHILDS_LIST:
        return basicSetChildsList(null, msgs);
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
      case PartialSerializationTestLanguagePackage.TWO_CHILD_LISTS__DIRECT_CHILDREN:
        return getDirectChildren();
      case PartialSerializationTestLanguagePackage.TWO_CHILD_LISTS__CHILDS_LIST:
        return getChildsList();
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
      case PartialSerializationTestLanguagePackage.TWO_CHILD_LISTS__DIRECT_CHILDREN:
        getDirectChildren().clear();
        getDirectChildren().addAll((Collection<? extends MandatoryValue>)newValue);
        return;
      case PartialSerializationTestLanguagePackage.TWO_CHILD_LISTS__CHILDS_LIST:
        setChildsList((MandatoryChildList)newValue);
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
      case PartialSerializationTestLanguagePackage.TWO_CHILD_LISTS__DIRECT_CHILDREN:
        getDirectChildren().clear();
        return;
      case PartialSerializationTestLanguagePackage.TWO_CHILD_LISTS__CHILDS_LIST:
        setChildsList((MandatoryChildList)null);
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
      case PartialSerializationTestLanguagePackage.TWO_CHILD_LISTS__DIRECT_CHILDREN:
        return directChildren != null && !directChildren.isEmpty();
      case PartialSerializationTestLanguagePackage.TWO_CHILD_LISTS__CHILDS_LIST:
        return childsList != null;
    }
    return super.eIsSet(featureID);
  }

} //TwoChildListsImpl
