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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.xbase.XExpression;

import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangPackage;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>My Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyMethodImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyMethodImpl#isPrivate <em>Private</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyMethodImpl#isSynchronized <em>Synchronized</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyMethodImpl#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyMethodImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyMethodImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyMethodImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyMethodImpl#getExceptions <em>Exceptions</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.MyMethodImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MyMethodImpl extends MyMemberImpl implements MyMethod
{
  /**
   * The default value of the '{@link #isStatic() <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStatic()
   * @generated
   * @ordered
   */
  protected static final boolean STATIC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStatic() <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStatic()
   * @generated
   * @ordered
   */
  protected boolean static_ = STATIC_EDEFAULT;

  /**
   * The default value of the '{@link #isPrivate() <em>Private</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPrivate()
   * @generated
   * @ordered
   */
  protected static final boolean PRIVATE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPrivate() <em>Private</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPrivate()
   * @generated
   * @ordered
   */
  protected boolean private_ = PRIVATE_EDEFAULT;

  /**
   * The default value of the '{@link #isSynchronized() <em>Synchronized</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSynchronized()
   * @generated
   * @ordered
   */
  protected static final boolean SYNCHRONIZED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSynchronized() <em>Synchronized</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSynchronized()
   * @generated
   * @ordered
   */
  protected boolean synchronized_ = SYNCHRONIZED_EDEFAULT;

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
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected JvmTypeReference type;

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
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<JvmFormalParameter> parameters;

  /**
   * The cached value of the '{@link #getExceptions() <em>Exceptions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExceptions()
   * @generated
   * @ordered
   */
  protected EList<JvmTypeReference> exceptions;

  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected XExpression expression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MyMethodImpl()
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
    return JvmGenericTypeValidatorTestLangPackage.Literals.MY_METHOD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isStatic()
  {
    return static_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStatic(boolean newStatic)
  {
    boolean oldStatic = static_;
    static_ = newStatic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JvmGenericTypeValidatorTestLangPackage.MY_METHOD__STATIC, oldStatic, static_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isPrivate()
  {
    return private_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPrivate(boolean newPrivate)
  {
    boolean oldPrivate = private_;
    private_ = newPrivate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JvmGenericTypeValidatorTestLangPackage.MY_METHOD__PRIVATE, oldPrivate, private_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSynchronized()
  {
    return synchronized_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSynchronized(boolean newSynchronized)
  {
    boolean oldSynchronized = synchronized_;
    synchronized_ = newSynchronized;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JvmGenericTypeValidatorTestLangPackage.MY_METHOD__SYNCHRONIZED, oldSynchronized, synchronized_));
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
      typeParameters = new EObjectContainmentEList<JvmTypeParameter>(JvmTypeParameter.class, this, JvmGenericTypeValidatorTestLangPackage.MY_METHOD__TYPE_PARAMETERS);
    }
    return typeParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JvmTypeReference getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(JvmTypeReference newType, NotificationChain msgs)
  {
    JvmTypeReference oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JvmGenericTypeValidatorTestLangPackage.MY_METHOD__TYPE, oldType, newType);
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
  public void setType(JvmTypeReference newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JvmGenericTypeValidatorTestLangPackage.MY_METHOD__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JvmGenericTypeValidatorTestLangPackage.MY_METHOD__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JvmGenericTypeValidatorTestLangPackage.MY_METHOD__TYPE, newType, newType));
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
      eNotify(new ENotificationImpl(this, Notification.SET, JvmGenericTypeValidatorTestLangPackage.MY_METHOD__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<JvmFormalParameter> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<JvmFormalParameter>(JvmFormalParameter.class, this, JvmGenericTypeValidatorTestLangPackage.MY_METHOD__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<JvmTypeReference> getExceptions()
  {
    if (exceptions == null)
    {
      exceptions = new EObjectContainmentEList<JvmTypeReference>(JvmTypeReference.class, this, JvmGenericTypeValidatorTestLangPackage.MY_METHOD__EXCEPTIONS);
    }
    return exceptions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XExpression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(XExpression newExpression, NotificationChain msgs)
  {
    XExpression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JvmGenericTypeValidatorTestLangPackage.MY_METHOD__EXPRESSION, oldExpression, newExpression);
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
  public void setExpression(XExpression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JvmGenericTypeValidatorTestLangPackage.MY_METHOD__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JvmGenericTypeValidatorTestLangPackage.MY_METHOD__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JvmGenericTypeValidatorTestLangPackage.MY_METHOD__EXPRESSION, newExpression, newExpression));
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
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__TYPE_PARAMETERS:
        return ((InternalEList<?>)getTypeParameters()).basicRemove(otherEnd, msgs);
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__TYPE:
        return basicSetType(null, msgs);
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__EXCEPTIONS:
        return ((InternalEList<?>)getExceptions()).basicRemove(otherEnd, msgs);
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__EXPRESSION:
        return basicSetExpression(null, msgs);
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
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__STATIC:
        return isStatic();
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__PRIVATE:
        return isPrivate();
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__SYNCHRONIZED:
        return isSynchronized();
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__TYPE_PARAMETERS:
        return getTypeParameters();
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__TYPE:
        return getType();
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__NAME:
        return getName();
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__PARAMETERS:
        return getParameters();
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__EXCEPTIONS:
        return getExceptions();
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__EXPRESSION:
        return getExpression();
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
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__STATIC:
        setStatic((Boolean)newValue);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__PRIVATE:
        setPrivate((Boolean)newValue);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__SYNCHRONIZED:
        setSynchronized((Boolean)newValue);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__TYPE_PARAMETERS:
        getTypeParameters().clear();
        getTypeParameters().addAll((Collection<? extends JvmTypeParameter>)newValue);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__TYPE:
        setType((JvmTypeReference)newValue);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__NAME:
        setName((String)newValue);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends JvmFormalParameter>)newValue);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__EXCEPTIONS:
        getExceptions().clear();
        getExceptions().addAll((Collection<? extends JvmTypeReference>)newValue);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__EXPRESSION:
        setExpression((XExpression)newValue);
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
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__STATIC:
        setStatic(STATIC_EDEFAULT);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__PRIVATE:
        setPrivate(PRIVATE_EDEFAULT);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__SYNCHRONIZED:
        setSynchronized(SYNCHRONIZED_EDEFAULT);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__TYPE_PARAMETERS:
        getTypeParameters().clear();
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__TYPE:
        setType((JvmTypeReference)null);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__NAME:
        setName(NAME_EDEFAULT);
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__PARAMETERS:
        getParameters().clear();
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__EXCEPTIONS:
        getExceptions().clear();
        return;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__EXPRESSION:
        setExpression((XExpression)null);
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
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__STATIC:
        return static_ != STATIC_EDEFAULT;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__PRIVATE:
        return private_ != PRIVATE_EDEFAULT;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__SYNCHRONIZED:
        return synchronized_ != SYNCHRONIZED_EDEFAULT;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__TYPE_PARAMETERS:
        return typeParameters != null && !typeParameters.isEmpty();
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__TYPE:
        return type != null;
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__EXCEPTIONS:
        return exceptions != null && !exceptions.isEmpty();
      case JvmGenericTypeValidatorTestLangPackage.MY_METHOD__EXPRESSION:
        return expression != null;
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
    result.append(" (static: ");
    result.append(static_);
    result.append(", private: ");
    result.append(private_);
    result.append(", synchronized: ");
    result.append(synchronized_);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //MyMethodImpl
