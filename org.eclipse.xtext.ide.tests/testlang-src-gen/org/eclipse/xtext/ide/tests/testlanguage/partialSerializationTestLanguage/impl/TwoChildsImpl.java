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

import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryValue;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalChild;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChilds;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Two Childs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl.TwoChildsImpl#getDirectChild <em>Direct Child</em>}</li>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl.TwoChildsImpl#getOptChild <em>Opt Child</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TwoChildsImpl extends ModelImpl implements TwoChilds
{
  /**
   * The cached value of the '{@link #getDirectChild() <em>Direct Child</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirectChild()
   * @generated
   * @ordered
   */
  protected MandatoryValue directChild;

  /**
   * The cached value of the '{@link #getOptChild() <em>Opt Child</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOptChild()
   * @generated
   * @ordered
   */
  protected OptionalChild optChild;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TwoChildsImpl()
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
    return PartialSerializationTestLanguagePackage.Literals.TWO_CHILDS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MandatoryValue getDirectChild()
  {
    return directChild;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDirectChild(MandatoryValue newDirectChild, NotificationChain msgs)
  {
    MandatoryValue oldDirectChild = directChild;
    directChild = newDirectChild;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PartialSerializationTestLanguagePackage.TWO_CHILDS__DIRECT_CHILD, oldDirectChild, newDirectChild);
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
  public void setDirectChild(MandatoryValue newDirectChild)
  {
    if (newDirectChild != directChild)
    {
      NotificationChain msgs = null;
      if (directChild != null)
        msgs = ((InternalEObject)directChild).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PartialSerializationTestLanguagePackage.TWO_CHILDS__DIRECT_CHILD, null, msgs);
      if (newDirectChild != null)
        msgs = ((InternalEObject)newDirectChild).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PartialSerializationTestLanguagePackage.TWO_CHILDS__DIRECT_CHILD, null, msgs);
      msgs = basicSetDirectChild(newDirectChild, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PartialSerializationTestLanguagePackage.TWO_CHILDS__DIRECT_CHILD, newDirectChild, newDirectChild));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OptionalChild getOptChild()
  {
    return optChild;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOptChild(OptionalChild newOptChild, NotificationChain msgs)
  {
    OptionalChild oldOptChild = optChild;
    optChild = newOptChild;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PartialSerializationTestLanguagePackage.TWO_CHILDS__OPT_CHILD, oldOptChild, newOptChild);
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
  public void setOptChild(OptionalChild newOptChild)
  {
    if (newOptChild != optChild)
    {
      NotificationChain msgs = null;
      if (optChild != null)
        msgs = ((InternalEObject)optChild).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PartialSerializationTestLanguagePackage.TWO_CHILDS__OPT_CHILD, null, msgs);
      if (newOptChild != null)
        msgs = ((InternalEObject)newOptChild).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PartialSerializationTestLanguagePackage.TWO_CHILDS__OPT_CHILD, null, msgs);
      msgs = basicSetOptChild(newOptChild, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PartialSerializationTestLanguagePackage.TWO_CHILDS__OPT_CHILD, newOptChild, newOptChild));
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
      case PartialSerializationTestLanguagePackage.TWO_CHILDS__DIRECT_CHILD:
        return basicSetDirectChild(null, msgs);
      case PartialSerializationTestLanguagePackage.TWO_CHILDS__OPT_CHILD:
        return basicSetOptChild(null, msgs);
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
      case PartialSerializationTestLanguagePackage.TWO_CHILDS__DIRECT_CHILD:
        return getDirectChild();
      case PartialSerializationTestLanguagePackage.TWO_CHILDS__OPT_CHILD:
        return getOptChild();
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
      case PartialSerializationTestLanguagePackage.TWO_CHILDS__DIRECT_CHILD:
        setDirectChild((MandatoryValue)newValue);
        return;
      case PartialSerializationTestLanguagePackage.TWO_CHILDS__OPT_CHILD:
        setOptChild((OptionalChild)newValue);
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
      case PartialSerializationTestLanguagePackage.TWO_CHILDS__DIRECT_CHILD:
        setDirectChild((MandatoryValue)null);
        return;
      case PartialSerializationTestLanguagePackage.TWO_CHILDS__OPT_CHILD:
        setOptChild((OptionalChild)null);
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
      case PartialSerializationTestLanguagePackage.TWO_CHILDS__DIRECT_CHILD:
        return directChild != null;
      case PartialSerializationTestLanguagePackage.TWO_CHILDS__OPT_CHILD:
        return optChild != null;
    }
    return super.eIsSet(featureID);
  }

} //TwoChildsImpl
