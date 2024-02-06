/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestOptional;
import org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TransientvaluestestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Optional</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TestOptionalImpl#getOpt1 <em>Opt1</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TestOptionalImpl#getOpt2 <em>Opt2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestOptionalImpl extends RootImpl implements TestOptional
{
  /**
   * The default value of the '{@link #getOpt1() <em>Opt1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpt1()
   * @generated
   * @ordered
   */
  protected static final int OPT1_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getOpt1() <em>Opt1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpt1()
   * @generated
   * @ordered
   */
  protected int opt1 = OPT1_EDEFAULT;

  /**
   * The default value of the '{@link #getOpt2() <em>Opt2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpt2()
   * @generated
   * @ordered
   */
  protected static final int OPT2_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getOpt2() <em>Opt2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpt2()
   * @generated
   * @ordered
   */
  protected int opt2 = OPT2_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TestOptionalImpl()
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
    return TransientvaluestestPackage.Literals.TEST_OPTIONAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getOpt1()
  {
    return opt1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOpt1(int newOpt1)
  {
    int oldOpt1 = opt1;
    opt1 = newOpt1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TransientvaluestestPackage.TEST_OPTIONAL__OPT1, oldOpt1, opt1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getOpt2()
  {
    return opt2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOpt2(int newOpt2)
  {
    int oldOpt2 = opt2;
    opt2 = newOpt2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TransientvaluestestPackage.TEST_OPTIONAL__OPT2, oldOpt2, opt2));
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
      case TransientvaluestestPackage.TEST_OPTIONAL__OPT1:
        return getOpt1();
      case TransientvaluestestPackage.TEST_OPTIONAL__OPT2:
        return getOpt2();
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
      case TransientvaluestestPackage.TEST_OPTIONAL__OPT1:
        setOpt1((Integer)newValue);
        return;
      case TransientvaluestestPackage.TEST_OPTIONAL__OPT2:
        setOpt2((Integer)newValue);
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
      case TransientvaluestestPackage.TEST_OPTIONAL__OPT1:
        setOpt1(OPT1_EDEFAULT);
        return;
      case TransientvaluestestPackage.TEST_OPTIONAL__OPT2:
        setOpt2(OPT2_EDEFAULT);
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
      case TransientvaluestestPackage.TEST_OPTIONAL__OPT1:
        return opt1 != OPT1_EDEFAULT;
      case TransientvaluestestPackage.TEST_OPTIONAL__OPT2:
        return opt2 != OPT2_EDEFAULT;
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
    result.append(" (opt1: ");
    result.append(opt1);
    result.append(", opt2: ");
    result.append(opt2);
    result.append(')');
    return result.toString();
  }

} //TestOptionalImpl
