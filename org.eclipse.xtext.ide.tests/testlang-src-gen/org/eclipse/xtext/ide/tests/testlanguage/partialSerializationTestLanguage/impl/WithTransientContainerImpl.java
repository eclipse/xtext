/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.WithTransientContainer;

import org.eclipse.xtext.ide.tests.testlanguage.withtransient.WithTransient;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>With Transient Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl.WithTransientContainerImpl#getChild <em>Child</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WithTransientContainerImpl extends ModelImpl implements WithTransientContainer
{
  /**
   * The cached value of the '{@link #getChild() <em>Child</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChild()
   * @generated
   * @ordered
   */
  protected WithTransient child;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WithTransientContainerImpl()
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
    return PartialSerializationTestLanguagePackage.Literals.WITH_TRANSIENT_CONTAINER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WithTransient getChild()
  {
    return child;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChild(WithTransient newChild, NotificationChain msgs)
  {
    WithTransient oldChild = child;
    child = newChild;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PartialSerializationTestLanguagePackage.WITH_TRANSIENT_CONTAINER__CHILD, oldChild, newChild);
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
  public void setChild(WithTransient newChild)
  {
    if (newChild != child)
    {
      NotificationChain msgs = null;
      if (child != null)
        msgs = ((InternalEObject)child).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PartialSerializationTestLanguagePackage.WITH_TRANSIENT_CONTAINER__CHILD, null, msgs);
      if (newChild != null)
        msgs = ((InternalEObject)newChild).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PartialSerializationTestLanguagePackage.WITH_TRANSIENT_CONTAINER__CHILD, null, msgs);
      msgs = basicSetChild(newChild, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PartialSerializationTestLanguagePackage.WITH_TRANSIENT_CONTAINER__CHILD, newChild, newChild));
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
      case PartialSerializationTestLanguagePackage.WITH_TRANSIENT_CONTAINER__CHILD:
        return basicSetChild(null, msgs);
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
      case PartialSerializationTestLanguagePackage.WITH_TRANSIENT_CONTAINER__CHILD:
        return getChild();
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
      case PartialSerializationTestLanguagePackage.WITH_TRANSIENT_CONTAINER__CHILD:
        setChild((WithTransient)newValue);
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
      case PartialSerializationTestLanguagePackage.WITH_TRANSIENT_CONTAINER__CHILD:
        setChild((WithTransient)null);
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
      case PartialSerializationTestLanguagePackage.WITH_TRANSIENT_CONTAINER__CHILD:
        return child != null;
    }
    return super.eIsSet(featureID);
  }

} //WithTransientContainerImpl
