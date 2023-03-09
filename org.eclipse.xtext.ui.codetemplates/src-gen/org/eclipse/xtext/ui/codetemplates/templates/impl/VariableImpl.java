/**
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.codetemplates.templates.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage;
import org.eclipse.xtext.ui.codetemplates.templates.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.impl.VariableImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.impl.VariableImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.impl.VariableImpl#isExpectingParameters <em>Expecting Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.impl.VariableImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableImpl extends TemplatePartImpl implements Variable
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
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #isExpectingParameters() <em>Expecting Parameters</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExpectingParameters()
   * @generated
   * @ordered
   */
  protected static final boolean EXPECTING_PARAMETERS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isExpectingParameters() <em>Expecting Parameters</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExpectingParameters()
   * @generated
   * @ordered
   */
  protected boolean expectingParameters = EXPECTING_PARAMETERS_EDEFAULT;

  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<String> parameters;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableImpl()
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
    return TemplatesPackage.Literals.VARIABLE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.VARIABLE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(String newType)
  {
    String oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.VARIABLE__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isExpectingParameters()
  {
    return expectingParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExpectingParameters(boolean newExpectingParameters)
  {
    boolean oldExpectingParameters = expectingParameters;
    expectingParameters = newExpectingParameters;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.VARIABLE__EXPECTING_PARAMETERS, oldExpectingParameters, expectingParameters));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<String> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EDataTypeEList<String>(String.class, this, TemplatesPackage.VARIABLE__PARAMETERS);
    }
    return parameters;
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
      case TemplatesPackage.VARIABLE__NAME:
        return getName();
      case TemplatesPackage.VARIABLE__TYPE:
        return getType();
      case TemplatesPackage.VARIABLE__EXPECTING_PARAMETERS:
        return isExpectingParameters();
      case TemplatesPackage.VARIABLE__PARAMETERS:
        return getParameters();
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
      case TemplatesPackage.VARIABLE__NAME:
        setName((String)newValue);
        return;
      case TemplatesPackage.VARIABLE__TYPE:
        setType((String)newValue);
        return;
      case TemplatesPackage.VARIABLE__EXPECTING_PARAMETERS:
        setExpectingParameters((Boolean)newValue);
        return;
      case TemplatesPackage.VARIABLE__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends String>)newValue);
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
      case TemplatesPackage.VARIABLE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TemplatesPackage.VARIABLE__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case TemplatesPackage.VARIABLE__EXPECTING_PARAMETERS:
        setExpectingParameters(EXPECTING_PARAMETERS_EDEFAULT);
        return;
      case TemplatesPackage.VARIABLE__PARAMETERS:
        getParameters().clear();
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
      case TemplatesPackage.VARIABLE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TemplatesPackage.VARIABLE__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case TemplatesPackage.VARIABLE__EXPECTING_PARAMETERS:
        return expectingParameters != EXPECTING_PARAMETERS_EDEFAULT;
      case TemplatesPackage.VARIABLE__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
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
    result.append(", type: ");
    result.append(type);
    result.append(", expectingParameters: ");
    result.append(expectingParameters);
    result.append(", parameters: ");
    result.append(parameters);
    result.append(')');
    return result.toString();
  }

} //VariableImpl
