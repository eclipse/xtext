/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.ChildList;
import org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.IndentationAwareUiTestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.OtherTreeNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Other Tree Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.impl.OtherTreeNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.impl.OtherTreeNodeImpl#getChildList <em>Child List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OtherTreeNodeImpl extends MinimalEObjectImpl.Container implements OtherTreeNode
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getChildList() <em>Child List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChildList()
   * @generated
   * @ordered
   */
  protected ChildList childList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OtherTreeNodeImpl()
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
    return IndentationAwareUiTestLanguagePackage.Literals.OTHER_TREE_NODE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IndentationAwareUiTestLanguagePackage.OTHER_TREE_NODE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ChildList getChildList()
  {
    return childList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChildList(ChildList newChildList, NotificationChain msgs)
  {
    ChildList oldChildList = childList;
    childList = newChildList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IndentationAwareUiTestLanguagePackage.OTHER_TREE_NODE__CHILD_LIST, oldChildList, newChildList);
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
  public void setChildList(ChildList newChildList)
  {
    if (newChildList != childList)
    {
      NotificationChain msgs = null;
      if (childList != null)
        msgs = ((InternalEObject)childList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IndentationAwareUiTestLanguagePackage.OTHER_TREE_NODE__CHILD_LIST, null, msgs);
      if (newChildList != null)
        msgs = ((InternalEObject)newChildList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IndentationAwareUiTestLanguagePackage.OTHER_TREE_NODE__CHILD_LIST, null, msgs);
      msgs = basicSetChildList(newChildList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IndentationAwareUiTestLanguagePackage.OTHER_TREE_NODE__CHILD_LIST, newChildList, newChildList));
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
      case IndentationAwareUiTestLanguagePackage.OTHER_TREE_NODE__CHILD_LIST:
        return basicSetChildList(null, msgs);
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
      case IndentationAwareUiTestLanguagePackage.OTHER_TREE_NODE__NAME:
        return getName();
      case IndentationAwareUiTestLanguagePackage.OTHER_TREE_NODE__CHILD_LIST:
        return getChildList();
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
      case IndentationAwareUiTestLanguagePackage.OTHER_TREE_NODE__NAME:
        setName((String)newValue);
        return;
      case IndentationAwareUiTestLanguagePackage.OTHER_TREE_NODE__CHILD_LIST:
        setChildList((ChildList)newValue);
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
      case IndentationAwareUiTestLanguagePackage.OTHER_TREE_NODE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case IndentationAwareUiTestLanguagePackage.OTHER_TREE_NODE__CHILD_LIST:
        setChildList((ChildList)null);
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
      case IndentationAwareUiTestLanguagePackage.OTHER_TREE_NODE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case IndentationAwareUiTestLanguagePackage.OTHER_TREE_NODE__CHILD_LIST:
        return childList != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //OtherTreeNodeImpl
