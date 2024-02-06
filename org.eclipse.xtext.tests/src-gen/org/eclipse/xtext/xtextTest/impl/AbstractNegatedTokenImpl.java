/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtextTest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xtextTest.AbstractElement;
import org.eclipse.xtext.xtextTest.AbstractNegatedToken;
import org.eclipse.xtext.xtextTest.XtextTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Negated Token</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.AbstractNegatedTokenImpl#getTerminal <em>Terminal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractNegatedTokenImpl extends AbstractElementImpl implements AbstractNegatedToken
{
  /**
   * The cached value of the '{@link #getTerminal() <em>Terminal</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTerminal()
   * @generated
   * @ordered
   */
  protected AbstractElement terminal;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractNegatedTokenImpl()
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
    return XtextTestPackage.Literals.ABSTRACT_NEGATED_TOKEN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AbstractElement getTerminal()
  {
    return terminal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTerminal(AbstractElement newTerminal, NotificationChain msgs)
  {
    AbstractElement oldTerminal = terminal;
    terminal = newTerminal;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextTestPackage.ABSTRACT_NEGATED_TOKEN__TERMINAL, oldTerminal, newTerminal);
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
  public void setTerminal(AbstractElement newTerminal)
  {
    if (newTerminal != terminal)
    {
      NotificationChain msgs = null;
      if (terminal != null)
        msgs = ((InternalEObject)terminal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.ABSTRACT_NEGATED_TOKEN__TERMINAL, null, msgs);
      if (newTerminal != null)
        msgs = ((InternalEObject)newTerminal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.ABSTRACT_NEGATED_TOKEN__TERMINAL, null, msgs);
      msgs = basicSetTerminal(newTerminal, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.ABSTRACT_NEGATED_TOKEN__TERMINAL, newTerminal, newTerminal));
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
      case XtextTestPackage.ABSTRACT_NEGATED_TOKEN__TERMINAL:
        return basicSetTerminal(null, msgs);
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
      case XtextTestPackage.ABSTRACT_NEGATED_TOKEN__TERMINAL:
        return getTerminal();
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
      case XtextTestPackage.ABSTRACT_NEGATED_TOKEN__TERMINAL:
        setTerminal((AbstractElement)newValue);
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
      case XtextTestPackage.ABSTRACT_NEGATED_TOKEN__TERMINAL:
        setTerminal((AbstractElement)null);
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
      case XtextTestPackage.ABSTRACT_NEGATED_TOKEN__TERMINAL:
        return terminal != null;
    }
    return super.eIsSet(featureID);
  }

} //AbstractNegatedTokenImpl
